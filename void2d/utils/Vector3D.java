// Vector3D.java - Part of Void2D.

package void2d.utils;

/**
 * 3D Vector Util.
 */
public class Vector3D {
    /**
     * Vector X.
     */
    public int x;

    /**
     * Vector Y.
     */
    public int y;

    /**
     * Vector Z.
     */
    public int z;

    /**
     * Initialize new 3D Vector.
     *
     * @param _x X.
     * @param _y Y.
     * @param _z Z.
     */
    public Vector3D(int _x, int _y, int _z) {
        x = _x;
        y = _y;
        z = _z;
    }

    /**
     * Convert vector to array.
     */
    public int[] asArray() {
        return new int[] {x, y, z};
    }
}
