// PhysicsBasedPersonController.java - Part of Void2D.

package void2d.utils;

import void2d.Window;

import void2d.Sprite;

import void2d.enginePhysics.ObjectPhysics;

/**
 * Physics based person controller util. (2D).
 */
public class PhysicsBasedPersonController {
    /**
     * Default controller speed.
     */
    public static final int PERSON_CONTROLLER_SPEED_DEFAULT = PersonController.PERSON_CONTROLLER_SPEED_DEFAULT;

    /**
     * Default controller mass.
     */
    public static final int PERSON_CONTROLLER_MASS_DEFAULT = (int) Math.sqrt(PERSON_CONTROLLER_SPEED_DEFAULT);

    /**
     * Default controller frozen property.
     */
    public static final boolean PERSON_CONTROLLER_FROZEN_DEFAULT = false;

    /**
     * Default controller bouncy property.
     */
    public static final boolean PERSON_CONTROLLER_BOUNCY_DEFAULT = false;

    /**
     * Controller speed.
     */
    public int speed = PERSON_CONTROLLER_SPEED_DEFAULT;

    /**
     * Controller mass.
     */
    public int mass = PERSON_CONTROLLER_MASS_DEFAULT;

    /**
     * Is controller frozen.
     */
    public boolean frozen = PERSON_CONTROLLER_FROZEN_DEFAULT;

    /**
     * Is controller bouncy.
     */
    public boolean bouncy = PERSON_CONTROLLER_BOUNCY_DEFAULT;

    /**
     * Is controller activated.
     */
    public boolean activated = false;

    /**
     * Initialize controller.
     *
     * @param window Window.
     * @param object Object to control.
     * @param ground Game ground.
     * @param _activated Activated?
     */
    public PhysicsBasedPersonController(Window window, Sprite object, Sprite ground, boolean _activated) {
        setActive(_activated);

        PersonController personController = new PersonController(window, object, _activated);

        personController.setSpeed(speed);

        ObjectPhysics objectPhysics = new ObjectPhysics(object.sprite, ground.sprite);

        objectPhysics.setObjectMass(mass);
        objectPhysics.setFrozen(frozen);
        objectPhysics.setBouncy(bouncy);

        if(_activated) {
            objectPhysics.runHandlers(
                null,
                null
            );
        }
    }

    /**
     * Set person controller activated.
     *
     * @param _activated Activated?
     */
    public void setActive(boolean _activated) {
        activated = _activated;
    }

    /**
     * Set person controller speed.
     *
     * @param _speed Speed.
     */
    public void setSpeed(int _speed) {
        speed = _speed;
    }

    /**
     * Set person controller mass.
     *
     * @param _mass Mass.
     */
    public void setMass(int _mass) {
        mass = _mass;
    }

    /**
     * Set person controller frozen.
     *
     * @param _frozen Frozen?
     */
    public void setFrozen(boolean _frozen) {
        frozen = _frozen;
    }

    /**
     * Set person controller bouncy property.
     *
     * @param _bouncy Bouncy?
     */
    public void setBouncy(boolean _bouncy) {
        bouncy = _bouncy;
    }
}
