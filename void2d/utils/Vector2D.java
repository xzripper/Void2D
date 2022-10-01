// Vector2D.java - Part of Void2D.

package void2d.utils;

/**
 * 2D Vector Util.
 */
public class Vector2D {
    /**
     * Vector X.
     */
    public int x;

    /**
     * Vector Y.
     */
    public int y;

    /**
     * Initialize new 2D Vector.
     *
     * @param _x X.
     * @param _y Y.
     */
    public Vector2D(int _x, int _y) {
        x = _x;
        y = _y;
    }

    /**
     * Convert vector to array.
     */
    public int[] asArray() {
        return new int[] {x, y};
    }
}
