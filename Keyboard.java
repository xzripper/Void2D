// Keyboard.java - Part of Void2D.

package void2d;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.function.Consumer;

class _EngineKeyListener implements KeyListener {
    protected Consumer<Integer> onKeyTyped;
    protected Consumer<Integer> onKeyPressed;
    protected Consumer<Integer> onKeyReleased;

    public _EngineKeyListener(Consumer<Integer>[] handlers) {
        onKeyTyped = handlers[0];
        onKeyPressed = handlers[1];
        onKeyReleased = handlers[2];
    }

    @Override
    public void keyTyped(KeyEvent key) {
        if(!(onKeyTyped == null)) {
            onKeyTyped.accept(key.getKeyCode());
        }
    }

    @Override
    public void keyPressed(KeyEvent key) {
        if(!(onKeyPressed == null)) {
            onKeyPressed.accept(key.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent key) {
        if(!(onKeyReleased == null)) {
            onKeyReleased.accept(key.getKeyCode());
        }
    }
}

/**
 * <h1>Class for working with a keyboard.</h1>
 * Class intercepts some keyboard events (like <i>KeyReleased</i>) and executes user function.
 */
public class Keyboard {
    protected _EngineKeyListener keyListener;

    /**
     * Initialize keyboard class.<br><br>
     *
     * <h2>Handlers tip.</h2>
     * <b><i>
     *     handlers[0] - On key typed.<br>
     *     handlers[1] - On key pressed.<br>
     *     handlers[2] - On key released.<br>
     * </i></b>
     *
     * @param handlers All events handlers.
     */
    public Keyboard(Consumer<Integer>[] handlers) {
        keyListener = new _EngineKeyListener(handlers);
    }

    /**
     * Add keyboard events handler to the window.<br>
     * Without this all events will not be intercepted.
     *
     * @param window Window to add keyboard events handler.
     */
    public void addKeyboardHandler(Window window) {
        window._addKeyboardHandler(keyListener);
    }
}
