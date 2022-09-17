// MouseExample.java - Part of Void2D.

package void2d;

import javax.swing.JComponent;

import javax.swing.SwingUtilities;

import java.awt.event.MouseListener;

import java.awt.event.MouseEvent;

import java.awt.MouseInfo;

class _MouseListener implements MouseListener {
    protected Runnable[] onMouseClicked = new Runnable[2];
    protected Runnable[] onMouseReleased = new Runnable[2];
    protected Runnable[] onMousePressed = new Runnable[2];

    public _MouseListener(Runnable[] _onMouseClicked, Runnable[] _onMouseReleased, Runnable[] _onMousePressed) {
        onMouseClicked[0] = _onMouseClicked[0];
        onMouseClicked[1] = _onMouseClicked[1];

        onMouseReleased[0] = _onMouseReleased[0];
        onMouseReleased[1] = _onMouseReleased[1];

        onMousePressed[0] = _onMousePressed[0];
        onMousePressed[1] = _onMousePressed[1];
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if(SwingUtilities.isLeftMouseButton(mouseEvent)) {
            if(onMouseClicked[0] != null) {
                onMouseClicked[0].run();
            }
        } else if(SwingUtilities.isRightMouseButton(mouseEvent)) {
            if(onMouseClicked[1] != null) {
                onMouseClicked[1].run();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if(SwingUtilities.isLeftMouseButton(mouseEvent)) {
            if(onMouseReleased[0] != null) {
                onMouseReleased[0].run();
            }
        } else if(SwingUtilities.isRightMouseButton(mouseEvent)) {
            if(onMouseReleased[1] != null) {
                onMouseReleased[1].run();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if(SwingUtilities.isLeftMouseButton(mouseEvent)) {
            if(onMousePressed[0] != null) {
                onMousePressed[0].run();
            }
        } else if(SwingUtilities.isRightMouseButton(mouseEvent)) {
            if(onMousePressed[1] != null) {
                onMousePressed[1].run();
            }
        }
    }

    // Not implemented.
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {}

    // Not implemented.
    @Override
    public void mouseExited(MouseEvent mouseEvent) {}
}

/**
 * <h1>Class for working with mouse.</h1>
 * Class intercepts some mouse events (like <i>mouseReleased</i>) and executes user function.
 */
public class Mouse {
    private final _MouseListener mouseListener;

    /**
     * Initialize mouse class.
     *
     * <h2>Handlers tip.</h2>
     * <b>
     * onMouseClicked:<br>
     * &emsp&emsp&emsp[0] - on left mouse clicked.<br>
     * &emsp&emsp&emsp[1] - on right mouse clicked.<br>
     * <br>
     * onMouseReleased:<br>
     * &emsp&emsp&emsp[0] - on left mouse released.<br>
     * &emsp&emsp&emsp[1] - on right mouse released.<br>
     * <br>
     * onMousePressed:<br>
     * &emsp&emsp&emsp[0] - on left mouse pressed.<br>
     * &emsp&emsp&emsp[1] - on right mouse pressed.<br>
     * </b>
     */
    public Mouse(Runnable[] onMouseClicked, Runnable[] onMouseReleased, Runnable[] onMousePressed) {
        mouseListener = new _MouseListener(onMouseClicked, onMouseReleased, onMousePressed);
    }

    /**
     * Add mouse handler to window.
     *
     * @param window Window.
     */
    public void addMouseHandlerToWindow(Window window) {
        window._addMouseHandler(mouseListener);
    }

    /**
     * Add mouse handler to object.
     *
     * @param object Object.
     */
    public void addMouseHandlerToObject(JComponent object) {
        object.addMouseListener(mouseListener);
    }

    /**
     * Get mouse position on display.
     */
    public static int[] getMousePosition() {
        return new int[] {
            MouseInfo.getPointerInfo().getLocation().x,
            MouseInfo.getPointerInfo().getLocation().y
        };
    }

    /**
     * Get mouse position in the window.
     *
     * @param window Window.
     */
    public static int[] getMousePositionInWindow(Window window) {
        return new int[] {
            window._window.getMousePosition().x,
            window._window.getMousePosition().y
        };
    }
}
