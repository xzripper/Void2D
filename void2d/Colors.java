// Colors.java - Part of Void2D.

package void2d;

import java.awt.Color;

/**
 * <h1>Class for working with <span style="color: red">R</span><span style="color: green">G</span><span style="color: blue">B</span> colors.</h1>
 */
public class Colors {
    /**
     * <span style="color: white">White</span> color.
     */
    public final static Color colorWhite = Color.WHITE;

    /**
     * <span style="color: black">Black</span> color.
     */
    public final static Color colorBlack = Color.BLACK;

    /**
     * <span style="color: gray">Gray</span> color.
     */
    public final static Color colorGray = Color.GRAY;

    /**
     * <span style="color: #A9A9A9">Dark gray</span> color.
     */
    public final static Color colorDarkGray = Color.DARK_GRAY;

    /**
     * <span style="color: #D3D3D3">Light gray</span> color.
     */
    public final static Color colorLightGray = Color.LIGHT_GRAY;

    /**
     * <span style="color: red">Red</span> color.
     */
    public final static Color colorRed = Color.RED;

    /**
     * <span style="color: green">Green</span> color.
     */
    public final static Color colorGreen = Color.GREEN;

    /**
     * <span style="color: blue">Blue</span> color.
     */
    public final static Color colorBlue = Color.BLUE;

    /**
     * <span style="color: #00FFFF">Cyan</span> color.
     */
    public final static Color colorCyan = Color.CYAN;

    /**
     * <span style="color: yellow">Yellow</span> color.
     */
    public final static Color colorYellow = Color.YELLOW;

    /**
     * <span style="color: #FFC0CB">Pink</span> color.
     */
    public final static Color colorPink = Color.PINK;

    /**
     * <span style="color: orange">Orange</span> color.
     */
    public final static Color colorOrange = Color.ORANGE;

    /**
     * Create new <span style="color: red">R</span><span style="color: green">G</span><span style="color: blue">B</span> color,
     * that was not created by default in the class.
     *
     * @param r Red.
     * @param g Green.
     * @param b Blue.
     * @param a Alpha.
     */
    public static Color newColor(int r, int g, int b, int a) {
        return new Color(r, g, b, a);
    }
}
