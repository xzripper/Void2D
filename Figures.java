// Figures.java - Part of Void2D.

package void2d;

import java.awt.Color;

/**
 * <h1>Class for figures drawing.</h1>
 * Draw figures on the window easy!
 *
 * @apiNote <i>supportsDrawing</i> in the window setup must be <i>true</i>.
 */
public class Figures {
    protected Window window;

    /**
     * Initialize game figures factory.
     */
    public Figures(Window _window) {
        window = _window;
    }

    private void appendFigureToDraw(Figure figure) {
        window._appendFiguresToDraw(figure);
    }

    /**
     * Draw a square.
     *
     * @param XY Square X and Y (position).
     * @param size Square size.
     * @param color Square color.
     */
    public void square(int[] XY, int[] size, Color color) {
        appendFigureToDraw(new Figure(EngineFigures.SQUARE, color, XY[0], XY[1], size[0], size[1]));
    }

    /**
     * Draw a circle.
     *
     * @param XY Circle X and Y (position).
     * @param size Circle size.
     * @param color Circle color.
    */
    public void circle(int[] XY, int[] size, Color color) {
        appendFigureToDraw(new Figure(EngineFigures.CIRCLE, color, XY[0], XY[1], size[0], size[1]));
    }

    /**
     * Draw a triangle.<br>
     * Drawing a triangle is a bit complicated, so use this carefully.<br>
     *
     * Hint: To draw smooth triangle set width equals to height.<br>
     *
     * @param size Triangle size.
     * @param color Triangle color.
     */
    public void triangle(int[] size, Color color) {
        appendFigureToDraw(new Figure(EngineFigures.TRIANGLE, color, -1, -1, size[0], size[1]));
    }
}
