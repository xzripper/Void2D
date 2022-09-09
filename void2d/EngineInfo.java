// EngineInfo.java - Part of Void2D.

package void2d;

/**
 * <h1>Some info about engine.</h1>
 * Get information about engine.
 */
public class EngineInfo {
    /**
     * Engine name.
     */
    public final static String engineName = "Void2D";

    /**
     * Engine version.
     */
    public final static float engineVersion = 1.3f;

    /**
     * Is version in release.
     */
    public final static boolean engineVersionInRelease = true; // When developing new version - set to false. It fixes problems with path's.

    /**
     * Engine license.
     */
    public final static String engineLicense = "MIT License";

    /**
     * Engine author.
     */
    public final static String engineAuthor = "Ivan Perzhynsky";

    /**
     * Get all information in array.
     */
    public static Object[] getAllInfo() {
        Object[] info = {
            engineName,
            engineVersion,
            engineLicense,
            engineAuthor
        };

        return info;
    }
}
