// Ray.java - Part of Void2D.

package void2d;

import void2d.enginePhysics.ObjectPhysics;

import javax.swing.JComponent;

import java.awt.Rectangle;

import java.util.ArrayList;

import java.util.function.BiConsumer;

/**
 * <h1>Class for working with rays.</h1>
 * Ray-casting, etc. All here.
 */
public class Ray {
    protected UpdateLoop castedRayLifeTime;

    /**
     * Ray position.
     */
    public int[] rayPos;

    /**
     * Ray size.
     */
    public int[] raySize;

    /**
     * Ray speed.
     */
    public int raySpeed;

    /**
     * Is currently ray casting?
     */
    public boolean rayCasting = false;

    /**
     * Registered game objects that can collide with ray.
     */
    public ArrayList<JComponent> regCollidableGameObjects = new ArrayList<>();

    /**
     * Maximal ray position by X.
     */
    public final int MAX_RAY_POS_X = 0x10b8;

    /**
     * Initialize new ray.
     *
     * @param _rayPos Ray position.
     * @param _raySize Ray size.
     * @param _raySpeed Ray speed.
     */
    public Ray(int[] _rayPos, int[] _raySize, int _raySpeed) {
        rayPos = _rayPos;
        raySize = _raySize;
        raySpeed = _raySpeed;
    }

    /**
     * Register new game objects which can collide with ray.
     *
     * @param gameObject Game object.
     */
    public void registerCollidableGameObject(JComponent gameObject) {
        regCollidableGameObjects.add(gameObject);
    }

    /**
     * Cast ray.
     *
     * @param onRayHit On ray hit handler.
     * @param reverseCast Cast ray in reverse. (From left to right).
     * @param destroyOn Destroy ray on hit with this object.
     */
    public void cast(BiConsumer<JComponent, int[]> onRayHit, boolean reverseCast, JComponent[] destroyOn) {
        ArrayList<JComponent> passedGameObjects = new ArrayList<>();

        rayCasting = true;

        castedRayLifeTime = new UpdateLoop(
            () -> {
                Rectangle rayCollision = new Rectangle(rayPos[0], rayPos[1], raySize[0], raySize[1]);

                if(reverseCast) {
                    rayPos[0] -= (int) (ObjectPhysics.UPDATE * raySpeed);
                } else {
                    rayPos[0] += (int) (ObjectPhysics.UPDATE * raySpeed);
                }

                if(reverseCast) {
                    if(rayPos[0] <= -MAX_RAY_POS_X) {
                        rayCasting = false;

                        castedRayLifeTime.stopLoop();
                    }
                } else {
                    if(rayPos[0] >= MAX_RAY_POS_X) {
                        rayCasting = false;

                        castedRayLifeTime.stopLoop();
                    }
                }

                for(JComponent destroyOnObject : destroyOn) {
                    Rectangle destroyOnObjectCollision = new Rectangle(destroyOnObject.getX(), destroyOnObject.getY(), destroyOnObject.getWidth(), destroyOnObject.getHeight());

                    if(rayCollision.intersects(destroyOnObjectCollision)) {
                        if(!(passedGameObjects.contains(destroyOnObject))) {
                            onRayHit.accept(destroyOnObject, rayPos);

                            passedGameObjects.add(destroyOnObject);

                            rayCasting = false;

                            castedRayLifeTime.stopLoop();
                        }

                    }
                }

                for(JComponent collidableGameObject : regCollidableGameObjects) {
                    Rectangle gameObjectCollision = new Rectangle(collidableGameObject.getX(), collidableGameObject.getY(), collidableGameObject.getWidth(), collidableGameObject.getHeight());

                    if(rayCollision.intersects(gameObjectCollision)) {
                        if(!(passedGameObjects.contains(collidableGameObject))) {
                            onRayHit.accept(collidableGameObject, rayPos);

                            passedGameObjects.add(collidableGameObject);
                        }
                    }
                }
            },

            ObjectPhysics.DEFAULT_PHYSICS_UPDATE_DELAY,
            true
        );
    }

    /**
     * Get ray position.
     */
    public int[] getRayPosition() {
        return rayPos;
    }

    /**
     * Get ray size.
     */
    public int[] getRaySize() {
        return raySize;
    }

    /**
     * Get ray speed.
     */
    public int getRaySpeed() {
        return raySpeed;
    }

    /**
     * Get registered game objects that can collide with ray.
     */
    public ArrayList<JComponent> getRegisteredCollidableGameObjects() {
        return regCollidableGameObjects;
    }

    /**
     * Get is currently ray casting.
     */
    public boolean isRayCasting() {
        return rayCasting;
    }
}
