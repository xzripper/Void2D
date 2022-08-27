// Window.java - Part of Void2D.

package void2d;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.ImageIcon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Container;

import java.awt.event.KeyListener;

/**
 * <h1>Class for window creation.</h1>
 * Main class that allows you build a game. How's it without a window?
 */
public class Window {
    protected JFrame _window;

    protected Timer _windowUpdateLoop = new Timer(0, null);

    protected ArrayList<Figure> _figuresToDraw = new ArrayList<>();

    protected boolean needRepaint = false;

    protected UpdateLoop repaintLoop;

    /**
     * Default window update loop delay.
     */
    public final int WINDOW_UPDATE_LOOP_DELAY = _windowUpdateLoop.getDelay();

    /**
     * Default window X position.<br>
     * At start (you can change it later using <code>Window.updateWindowPosition</code>), window X position will be this.
     */
    public final int DEFAULT_WINDOW_X_POSITION = 50;

    /**
     * Default window Y position.<br>
     * At start (you can change it later using <code>Window.updateWindowPosition</code>), window Y position will be this.
     */
    public final int DEFAULT_WINDOW_Y_POSITION = 50;

    /**
     * Is window visible?
     */
    public boolean windowVisible = false;

    /**
     * Initialize new window.<br>
     * If windowTitle is null, title will be automatically set to "{OS} {Architecture}".
     *
     * @param windowTitle Window title.
     * @param width Window width.
     * @param height Window height.
     * @param resizable Is window can be resized.
     * @param supportsDrawings Is window supports drawing. If this is <i>false</i>, then it means that you can't use Figures.java (draw figures on the window).
     */
    public Window(String windowTitle, int width, int height, boolean resizable, boolean supportsDrawings) {
        windowTitle = (windowTitle == null) ? _getOSAndArchitecture() : windowTitle;

        if(supportsDrawings) {
            _window = new JFrame(windowTitle) {
                @Override
                public void paint(Graphics graphics) {
                    _windowPaint(graphics);
                }
            };
        } else {
            _window = new JFrame(windowTitle);
        }

        _window.setLayout(null);

        _window.setBounds(DEFAULT_WINDOW_X_POSITION, DEFAULT_WINDOW_Y_POSITION, width, height);

        _window.setIconImage(new ImageIcon(EnginePartPathManager.accessEnginePartWithAbsolutePath("media\\DefaultWindowIcon.png")).getImage());

        _window.setResizable(resizable);

        _window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        _getContentPane().setBackground(Colors.colorBlack);
    }

    protected void _windowPaint(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;

        for(Figure figure : _figuresToDraw) {
            if(figure.figure == EngineFigures.SQUARE) {
                graphics2D.setColor(figure.color);

                graphics2D.fillRect(figure.x, figure.y, figure.width, figure.height);
            } else if(figure.figure == EngineFigures.CIRCLE) {
                graphics2D.setColor(figure.color);

                graphics2D.fillOval(figure.x, figure.y, figure.width, figure.height);
            } else if(figure.figure == EngineFigures.TRIANGLE) {
                graphics2D.setColor(figure.color);

                // A bit complicated.
                graphics2D.fillPolygon(
                    new int[] {
                        figure.width * 2,
                        figure.width * 3,
                        figure.width * 4
                    },

                    new int[] {
                        figure.height * 3,
                        figure.height / 3,
                        figure.height * 3
                    },

                    3
                );
            }
        }
    }

    /**
     * Do repaint while painting.
     * <p>
     * If needRepaint is true, then figures will be automatically updated (figures will be dynamically in a nutshell).
     */
    public void doRepaintDuringPaint(boolean _needRepaint) {
        needRepaint = _needRepaint;

        if(needRepaint) {
            repaintLoop = new UpdateLoop(
                _window::repaint,

                WINDOW_UPDATE_LOOP_DELAY,
                true
            );
        }
    }

    /**
     * Show a window.
     *
     * @apiNote This method doesn't run a window, it's only showing it.
     *          Window automatically runs myself after its creation.
     */
    public void showWindow() {
        windowVisible = true;

        _window.setVisible(true);
    }

    /**
     * Hide a window.<br>
     *
     * @apiNote This method doesn't close a window, it's only hiding it.
     */
    public void hideWindow() {
        windowVisible = false;

        _window.setVisible(false);
    }

    /**
     * Get is window visible right now.
     */
    public boolean windowVisible() {
        return windowVisible;
    }

    /**
     * Update window size to its new size.
     *
     * @param newWidth New window width.
     * @param newHeight New window height.
     */
    public void updateWindowSize(int newWidth, int newHeight) {
        _window.setSize(newWidth, newHeight);
    }

    /**
     * Update window position to its new position.
     *
     * @param newX New window X.
     * @param newY New window Y.
     */
    public void updateWindowPosition(int newX, int newY) {
        _window.setLocation(newX, newY);
    }

    /**
     * Set window resizable. (<i>true | false</i>).
     *
     * @param resizable Window resizable?
     */
    public void setWindowResizable(boolean resizable) {
        _window.setResizable(resizable);
    }

    /**
     * Update window background color (in RGBA (A = Alpha)).
     *
     * @param rgba New RGBA background.
     */
    public void setWindowBackground(int[] rgba) {
        _getContentPane().setBackground(Colors.newColor(rgba[0], rgba[1], rgba[2], rgba[3]));
    }

    /**
     * Get window current size.
     */
    public int[] getWindowSize() {
        Dimension windowSize = _window.getSize();

        int[] windowSizeArray = {windowSize.width, windowSize.height};

        return windowSizeArray;
    }

    /**
     * Get is window minimized right now.
     */
    public boolean isMinimized() {
        return _window.getState() == JFrame.ICONIFIED;
    }

    /**
     * Get is window maximized right now.
     */
    public boolean isMaximized() {
        return _window.getExtendedState() == JFrame.MAXIMIZED_BOTH;
    }

    /**
     * Call function if window minimized.
     *
     * @apiNote Call this method in window update loop (update window loop handler: <code>Window.updateWindowUpdateLoopListener</code>),
     * for infinity check.
     */
    public void onMinimizing(Runnable handler) {
        if(isMinimized()) {
            handler.run();
        }
    }

    /**
     * Call function if window maximized.
     *
     * @apiNote Call this method in window update loop (update window loop handler: <code>Window.updateWindowUpdateLoopListener</code>),
     * for infinity check.
     */
    public void onMaximizing(Runnable handler) {
        if(isMaximized()) {
            handler.run();
        }
    }

    /**
     * Update window update loop handler.<br>
     * <code>listener</code> will be called in window update loop.
     */
    public void updateWindowUpdateLoopListener(Runnable listener) {
        _windowUpdateLoop.addActionListener(
            (event) -> {
                listener.run();
            }
        );
    }

    /**
     * Start window update loop.
     *
     * @apiNote Window update loop will be called only if you added handler(s) to update loop.
     */
    public void startWindowUpdateLoop() {
        if(_windowUpdateLoop.getActionListeners().length >= 1) {
            _windowUpdateLoop.start();
        }
    }

    /**
     * Stop window update loop.
     *
     */
    public void stopWindowUpdateLoop() {
        if(_windowUpdateLoop.isRunning()) {
            _windowUpdateLoop.stop();
        }
    }

    /**
     * Get window content pane.
     *
     * @apiNote This method created only for engine parts, so its better don't use in game developing.
     */
    public Container _getContentPane() {
        return _window.getContentPane();
    }

    /**
     * Add key listener to the window.
     *
     * @param keyListener A key listener.
     *
     * @apiNote This method created only for engine parts, so its better don't use in game developing.
     */
    public void _addKeyboardHandler(KeyListener keyListener) {
        _window.addKeyListener(keyListener);
    }

    /**
     * Append figures to draw.
     *
     * @param figure Figure to add.
     *
     * @apiNote This method created only for engine parts, so its better don't use in game developing.
     */
    public void _appendFiguresToDraw(Figure figure) {
        _figuresToDraw.add(figure);
    }

    /**
     * Get OS and architecture.
     *
     * @apiNote Linux and Mac is not supported!
     */
    public String _getOSAndArchitecture() {
        return (String.format("%s %s", System.getProperty("os.name"), ((System.getenv("ProgramFiles(x86)") == null) ? "x32" : "x64")));
    }
}
