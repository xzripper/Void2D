// ParentObject.java - Part of Void2D.

package void2d.utils;

import javax.swing.JComponent;

import java.util.ArrayList;

/**
 * Create parent objects with child util.
 */
public class ParentObject {
    private JComponent parentObject;

    private final ArrayList<JComponent> children = new ArrayList<>();

    /**
     * Initialize parent objects.
     *
     * @param _parentObject Parent object.
     */
    public ParentObject(JComponent _parentObject) {
        parentObject = _parentObject;
    }

    /**
     * Append child to parent.
     *
     * @param _child Child object.
     */
    public void addChild(JComponent _child) {
        children.add(_child);
    }

    /**
     * Register parent move for children.
     *
     * @param movePowerX Move power by X.
     * @param movePowerY Move power by Y.
     */
    public void registerParentMove(int movePowerX, int movePowerY) {
        for(JComponent child : children) {
            child.setLocation(
                child.getX() + movePowerX,
                child.getY() + movePowerY
            );
        }
    }
}
