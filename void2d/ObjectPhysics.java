// ObjectPhysics.java - Part of Void2D.

package void2d;

import javax.swing.JComponent;

import java.util.ArrayList;

import java.util.function.Consumer;

/**
 * <h1>Class for handling simple physics of game objects.</h1>
 * Physics handler for game object.
 */
public class ObjectPhysics {
    protected JComponent gameObject;

    protected JComponent groundObject = null;

    protected UpdateLoop handlingLoop = null;

    protected boolean rebounding = false;

    protected boolean rolled = false;

    /**
     * Physics version.
     */
    public static final float PHYSICS_VERSION = 1.f;

    /**
     * Object body.
     */
    public Body objectBody = Body.SQUARE_BODY;

    /**
     * Is handlers are running.
     */
    public boolean handlersRunning = false;

    /**
     * Game props.
     */
    public ArrayList<Prop> gameProps = new ArrayList<>();

    /**
     * Object mass.
     */
    public int gameObjectMass = 0;

    /**
     * Is object frozen.
     */
    public boolean frozen = false;

    /**
     * Is object bouncy.
     */
    public boolean bouncy = false;

    /**
     * Physics update loop delay.
     */
    public final static int DEFAULT_PHYSICS_UPDATE_DELAY = 25;

    /**
     * Falling speed.
     */
    public final static int DEFAULT_FALLING_SPEED = 50;

    /**
     * Default rebound power.
     */
    public final static int DEFAULT_REBOUND_POWER = 80;

    /**
     * Default minimal roll power.
     */
    public final static int DEFAULT_MIN_ROLL_POWER = -15;

    /**
     * Default maximal roll power.
     */
    public final static int DEFAULT_MAX_ROLL_POWER = Math.abs(DEFAULT_MIN_ROLL_POWER);

    /**
     * Default props mass.
     */
    public final static int DEFAULT_PROP_MASS = 100;

    /**
     * Update value.
     */
    public final static float UPDATE = 0.1f;

    /**
     * Initialize physics.
     *
     * @param _gameObject Add physics to that object.
     */
    public ObjectPhysics(JComponent _gameObject) {
        gameObject = _gameObject;
    }

    /**
     * Initialize physics but specify ground object.
     *
     * @param _gameObject Add physics to that object.
     * @param _groundObject Ground object.
     */
    public ObjectPhysics(JComponent _gameObject, JComponent _groundObject) {
        gameObject = _gameObject;

        groundObject = _groundObject;
    }

    /**
     * Set object body.
     *
     * @param body Object body.
     */
    public void setBody(Body body) {
        objectBody = body;
    }

    /**
     * Get object body.
     */
    public Body getBody() {
        return objectBody;
    }

    /**
     * Set game object mass.
     *
     * @param newMass New mass.
     */
    public void setObjectMass(int newMass) {
        gameObjectMass = newMass;
    }

    /**
     * Get game object mass.
     */
    public int getObjectMass() {
        return gameObjectMass;
    }

    /**
     * Freeze game object.
     *
     * @param _frozen Is frozen?
     */
    public void setFrozen(boolean _frozen) {
        frozen = _frozen;
    }

    /**
     * Get is game object frozen.
     */
    public boolean isFrozen() {
        return frozen;
    }

    /**
     * Set object bouncy.
     *
     * @param _bouncy Is bouncy?
     */
    public void setBouncy(boolean _bouncy) {
        bouncy = _bouncy;
    }

    /**
     * Get is object bouncy.
     */
    public boolean isBouncy() {
        return bouncy;
    }

    /**
     * Get is game object in air.
     *
     * @throws NullPointerException This exception will be thrown if ground is not specified.
     */
    public boolean inAir() {
        if(groundObject == null) {
            throw new NullPointerException("Ground is not specified.");
        }

        Collision gameObjectCollision = new Collision(gameObject);

        return (!(gameObjectCollision.intersects(groundObject)));
    }

    /**
     * Get is game object not in air.
     *
     * @throws NullPointerException This exception will be thrown if ground is not specified.
     */
    public boolean notInAir() {
        return !inAir();
    }

    /**
     * Get is game object abuts another game object.
     *
     * @param _gameObject Game object to check abuts with.
     */
    public boolean abutsGameObject(JComponent _gameObject) {
        Collision gameObjectCollision = new Collision(gameObject);

        return (Distances.getXDistanceBetweenGameObjects(gameObject, _gameObject) <= 0 && gameObjectCollision.intersects(_gameObject));
    }

    /**
     * Get is game object abuts another game object from the back.
     *
     * @param _gameObject Game object to check abuts with.
     */
    public boolean abutsGameObjectFromBack(JComponent _gameObject) {
        Collision gameObjectCollision = new Collision(gameObject);

        return (((Distances.getXDistanceBetweenGameObjects(gameObject, _gameObject) + _gameObject.getWidth()) < 0) && gameObjectCollision.intersects(_gameObject));
    }

    /**
     * Get is game object intersects any prop from props array.
     */
    public boolean intersectsAnyProp() {
        JComponent[] propsArray = new JComponent[gameProps.size()];

        for(int index=0; index < gameProps.size(); index++) {
            propsArray[index] = gameProps.get(index).gameObject;
        }

        Collision gameObjectCollision = new Collision(gameObject);

        return gameObjectCollision.intersectsFromArray(propsArray);
    }

    /**
     * Add new prop to game props.
     *
     * @param newProp New prop.
     */
    public void addProp(Prop newProp) {
        gameProps.add(newProp);
    }

    /**
     * Remove prop from game props.
     *
     * @param propIndex Prop index that be removed.
     */
    public void removeProp(int propIndex) {
        gameProps.remove(propIndex);
    }

    /**
     * Handle gravity.<br>
     * Game object will fall until he touches the ground or prop.<br>
     * Ground must be specified for that.
     */
    public void handleGravity(Window window) {
        if(groundObject == null) {
            throw new NullPointerException("Ground is not specified.");
        }

        Collision gameObjectCollision = new Collision(gameObject);

        JComponent[] propsArray = new JComponent[gameProps.size()];

        for(int index=0; index < gameProps.size(); index++) {
            propsArray[index] = gameProps.get(index).gameObject;
        }

        if(!isFrozen()) {
            if(!(gameObjectCollision.intersects(groundObject)) && !(gameObjectCollision.intersectsFromArray(propsArray))) {
                if(!rebounding) {
                    gameObject.setLocation(gameObject.getX(), (int) (gameObject.getY() + (UPDATE * (DEFAULT_FALLING_SPEED + gameObjectMass))));

                    rolled = false;
                }
            } else {
                if(Body.IS_CIRCLE(objectBody)) {
                    if(!rolled) {
                        int rollPower = (int) Math.round((DEFAULT_MIN_ROLL_POWER + (Math.random() * (DEFAULT_MAX_ROLL_POWER - DEFAULT_MIN_ROLL_POWER))));

                        int rollSpeed = (gameObjectMass / 3) / 2;

                        Void2DThread objectRollThread = new Void2DThread(
                            () -> {
                                for(int power=1; power < Math.abs(rollPower); power++) {
                                    if(rollPower <= 0) {
                                        gameObject.setLocation((int) (gameObject.getX() - (UPDATE * ((rollPower / (power)) + gameObjectMass))), gameObject.getY());
                                    } else {
                                        gameObject.setLocation((int) (gameObject.getX() + (UPDATE * ((rollPower / (power)) + gameObjectMass))), gameObject.getY());
                                    }

                                    try {
                                        Thread.sleep((rollSpeed + (power * 2)) / 3);
                                    } catch(InterruptedException _interrupted_exc) {
                                        System.out.println(_interrupted_exc.getMessage());
                                    }
                                }
                            }
                        );

                        objectRollThread.run();

                        rolled = true;
                    }
                }

                if(isBouncy()) {
                    int oldY = gameObject.getY();

                    Void2DThread objectUpLiftThread = new Void2DThread(
                        () -> {
                            rebounding = true;

                            // int fallingSpeed = (DEFAULT_REBOUND_POWER - ((gameObjectMass <= DEFAULT_REBOUND_POWER) ? gameObjectMass : (DEFAULT_REBOUND_POWER / 2)));

                            while(rebounding) {
                                if(gameObject.getY() >= (oldY - (DEFAULT_REBOUND_POWER + gameObjectMass))) {
                                    gameObject.setLocation(gameObject.getX(), (int) (gameObject.getY() - (UPDATE * (DEFAULT_FALLING_SPEED + gameObjectMass))));

                                    try {
                                        Thread.sleep((gameObjectMass / 3) / 2);
                                    } catch(InterruptedException _interrupted_exc) {
                                        System.out.println(_interrupted_exc.getMessage());
                                    }
                                } else {
                                    rebounding = false;
                                }
                            }
                        }
                    );

                    objectUpLiftThread.run();
                }
            }
        }

        for(Prop gameProp : gameProps) {
            if(!gameProp.propFrozen) {
                Collision gamePropCollision = new Collision(gameProp.gameObject);

                if(!(gamePropCollision.intersects(groundObject))) {
                    gameProp.gameObject.setLocation(gameProp.gameObject.getX(), (int) (gameProp.gameObject.getY() + (UPDATE * (DEFAULT_FALLING_SPEED + ((gameProp.propMass == 0) ? DEFAULT_PROP_MASS : gameProp.propMass)))));
                }
            }
        }
    }

    // Learn about Rectangle.intersection;

    /**
     * Run onEnter when game object entered the prop and onExit on exit.
     *
     * @param onEnter On enter trigger.
     * @param onExit On exit trigger.
     */
    public void handleProps(Consumer<ScreenSides> onEnter, Runnable onExit) {
        for(Prop gameProp : gameProps) {
            if(abutsGameObject(gameProp.gameObject) || abutsGameObjectFromBack(gameProp.gameObject)) {
                if(!gameProp.propFrozen) {
                    if(notInAir()) {
                        if(gameObject.getX() >= gameProp.gameObject.getX()) {
                            gameProp.gameObject.setLocation((int) (gameProp.gameObject.getX() - (UPDATE * (DEFAULT_FALLING_SPEED + ((gameProp.propMass == 0) ? DEFAULT_PROP_MASS : gameProp.propMass)))), gameProp.gameObject.getY());
                        } else {
                            gameProp.gameObject.setLocation((int) (gameProp.gameObject.getX() + (UPDATE * (DEFAULT_FALLING_SPEED + ((gameProp.propMass == 0) ? DEFAULT_PROP_MASS : gameProp.propMass)))), gameProp.gameObject.getY());
                        }
                    }
                }

                if(notInAir()) {
                    if(onEnter != null) {
                        if(abutsGameObjectFromBack(gameProp.gameObject)) {
                            onEnter.accept(ScreenSides.RIGHT);
                        } else if(abutsGameObject(gameProp.gameObject)) {
                            onEnter.accept(ScreenSides.LEFT);
                        }
                    }
                }
            } else {
                if(onExit != null) {
                    onExit.run();
                }
            }
        }
    }

    /**
     * Run all possible physics handlers.
     *
     * @throws NullPointerException This exception will be thrown if ground object is not specified.
     * @throws UnsupportedOperationException This exception will be thrown if physics handlers is already running.
     */
    public void runHandlers(Window window, Consumer<ScreenSides> onPropEnter, Runnable onPropExit) {
        if(handlersRunning) {
            throw new UnsupportedOperationException("Physics handlers is already running.");
        }

        handlingLoop = new UpdateLoop(
            () -> {
                if(groundObject == null) {
                    throw new NullPointerException("Ground object is not specified.");
                }

                handleGravity(window);
                handleProps(onPropEnter, onPropExit);
            },

            DEFAULT_PHYSICS_UPDATE_DELAY,

            true
        );

        handlersRunning = true;
    }

    /**
     * Stop all possible physics handlers.
     *
     * @throws NullPointerException This exception will be thrown if handling loop is not initialized.
     */
    public void stopHandlers() {
        if(handlingLoop == null) {
            throw new NullPointerException("Handling loop is not initialized.");
        }

        handlingLoop.stopLoop();

        handlersRunning = false;
    }

    /**
     * Get is handlers running.
     */
    public boolean isHandlersRunning() {
        return handlersRunning;
    }
}
