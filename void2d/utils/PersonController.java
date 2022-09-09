package void2d.utils;

import void2d.Window;

import void2d.Sprite;

import void2d.Keyboard;

import void2d.enginePhysics.ObjectPhysics;

import java.awt.event.KeyEvent;

import java.util.function.Consumer;

/**
 * Person Controller Util (2D).
 */
public class PersonController {
    /**
     * Default controller speed.
     */
    public final int PERSON_CONTROLLER_SPEED_DEFAULT = 45;

    /**
     * Does person controller activated?
     */
    public boolean activated = false;

    /**
     * Person controller speed.
     */
    public int speed = PERSON_CONTROLLER_SPEED_DEFAULT;

    /**
     * Initialize person controller.
     *
     * @param window Window.
     * @param object Object to control.
     * @param _activated Person controller activated?
     */
    public PersonController(Window window, Sprite object, boolean _activated) {
        setActivated(_activated);

        Keyboard controllerEventHandler = new Keyboard(
            new Consumer[] {
                null,

                key -> {
                    if(activated) {
                        if(key.equals(KeyEvent.VK_D) || key.equals(KeyEvent.VK_RIGHT)) {
                            object.sprite.setLocation(
                                (int) (object.sprite.getX() + (speed * ObjectPhysics.UPDATE)),
                                object.sprite.getY()
                            );
                        } else if(key.equals(KeyEvent.VK_A) || key.equals(KeyEvent.VK_LEFT)) {
                            object.sprite.setLocation(
                                (int) (object.sprite.getX() - (speed * ObjectPhysics.UPDATE)),
                                object.sprite.getY()
                            );
                        }
                    }
                },

                null
            }
        );

        controllerEventHandler.addKeyboardHandler(window);
    }

    /**
     * Set person controller activated.
     *
     * @param _activated Activated?
     */
    public void setActivated(boolean _activated) {
        activated = _activated;
    }

    /**
     * Set person controller speed.
     *
     * @param _speed New speed.
     */
    public void setSpeed(int _speed) {
        speed = _speed;
    }
}
