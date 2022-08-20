// Prop.java - Part of Void2D.

package void2d;

import javax.swing.JComponent;

/**
 * <h1>Prop template.</h1>
 * Create props and update their physics properties.
 */
public class Prop {
    /**
     * Game object.
     */
    public final JComponent gameObject;

    /**
     * Prop mass.
     */
    public int propMass = 0;

    /**
     * Is prop frozen.
     */
    public boolean propFrozen = false;

    /**
     * Initialize new prop.
     *
     * @param _gameObject Game object.
     */
    public Prop(JComponent _gameObject) {
        gameObject = _gameObject;
    }

    /**
     * Update prop mass.
     *
     * @param newPropMass New prop mass.
     */
    public void setPropMass(int newPropMass) {
        propMass = newPropMass;
    }

    /**
     * Set prop frozen.
     *
     * @param isFrozen Is frozen?
     */
    public void setPropFrozen(boolean isFrozen) {
        propFrozen = isFrozen;
    }
}
