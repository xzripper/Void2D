// ScreenSides.java - Part of Void2D.

package void2d;

/**
 * <h1>Screen sides enumerator.</h1>
 * Screen sides enumerator.
 */
public enum ScreenSides {
    /**
     * Right side.
     */
    RIGHT,

    /**
     * Left side.
     */
    LEFT;

    /**
     * Get is side equals right.
     * @param side Side.
     */
    public static boolean IS_RIGHT(ScreenSides side) {
        return side == RIGHT;
    }

    /**
     * Get is side equals left.
     * @param side Side.
     */
    public static boolean IS_LEFT(ScreenSides side) {
        return side == LEFT;
    }
}
