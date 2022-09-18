// DraggableObject.java - Part of Void2D.

package void2d.utils;

import void2d.Window;

import void2d.Mouse;

import java.awt.event.MouseEvent;

import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

/**
 * Draggable object util.
 */
public class DraggableObject {
    protected final Window window;

    protected final JComponent gameObject;

    /**
     * Is already handling the drag.
     */
    public boolean handlingDrag = false;

    /**
     * Initialize new draggable object.
     *
     * @param _window Window.
     * @param _gameObject Game object.
     */
    public DraggableObject(Window _window, JComponent _gameObject) {
        window = _window;

        gameObject = _gameObject;
    }

    /**
     * Handle drag.
     */
    public void handleDrag() {
        if(handlingDrag) {
            return;
        }

        handlingDrag = true;

        MouseMotionListener mouseMotionHandler = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                // NullPointerException - When mouse is out of the window when dragging.
                try {
                    gameObject.setLocation(
                        Mouse.getMousePositionInWindow(window)[0] - (gameObject.getWidth() / 2) - 5,
                        Mouse.getMousePositionInWindow(window)[1] - (gameObject.getHeight() / 2) - 10
                    );
                } catch(NullPointerException null_pointer_exc) {}
            }

            // Not implemented. (Why?).

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {}
        };

        gameObject.addMouseMotionListener(mouseMotionHandler);
    }
}
