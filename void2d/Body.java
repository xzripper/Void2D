// Body.java - Part of Void2D.

package void2d;

/**
 * <h1>Bodies enumerator.</h1>
 * Bodies enumerator.<br>
 * Applicable to ObjectPhysics.
 *
 * @see ObjectPhysics
 */
public enum Body {
    /**
     * Square body.
     */
    SQUARE_BODY,

    /**
     * Circle body.
     */
    CIRCLE_BODY;

    /**
     * Is body a square.
     *
     * @param body Body.
     */
    public static boolean IS_SQUARE(Body body) {
        return body == SQUARE_BODY;
    }

    /**
     * Is body a circle.
     *
     * @param body Body.
     */
    public static boolean IS_CIRCLE(Body body) {
        return body == CIRCLE_BODY;
    }
}
