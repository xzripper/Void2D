// Figure.java - Part of Void2D.

package void2d;

import java.awt.Color;

/**
 * <h1>Figure template.</h1>
 * Figures.java generates Figure template and adds it to drawing queue.<br>
 * Later Window.java takes figure templates from queue and draws figure from this template.<br>
 *
 * @see Figures
 * @see Window
 */
public class Figure {
    /**
     * Figure to draw.
     */
    public EngineFigures figure;

    /**
     * Figure color.
     */
    public Color color;

    /**
     * Figure property.
     */
    int x, y, width, height;

    /**
     * Create figure template.
     *
     * @param engineFigure Figure to draw.
     * @param figureColor Figure color.
     * @param figureX Figure X position.
     * @param figureY Figure Y position.
     * @param figureWidth Figure width.
     * @param figureHeight Figure height.
     */
    public Figure(EngineFigures engineFigure, Color figureColor, int figureX, int figureY, int figureWidth, int figureHeight) {
        figure = engineFigure;

        color = figureColor;

        x = figureX;
        y = figureY;

        width = figureWidth;
        height = figureHeight;
    }
}
