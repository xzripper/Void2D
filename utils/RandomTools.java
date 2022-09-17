// RandomTools.java - Part of Void2D.

package void2d.utils;

import java.util.Random;

/**
 * RandomTools tools util.
 */
public class RandomTools {
    private static final Random randomTool = new Random();

    /**
     * Generate random integer.<br>
     * Generates from (0 to MAX_INT).
     */
    public static int randomInt() {
        return randomTool.nextInt(0, Integer.MAX_VALUE);
    }

    /**
     * Generate random integer.<br>
     * Generates from (min to MAX_INT).
     *
     * @param min Minimal value.
     */
    public static int randomInt(int min) {
        return randomTool.nextInt(min, Integer.MAX_VALUE);
    }

    /**
     * Generates random integer.<br>
     * Generates from (min to max + 1).
     *
     * @param min Minimal value.
     * @param max Maximal value.
     */
    public static int randomInt(int min, int max) {
        return randomTool.nextInt(min, max + 1);
    }

    /**
     * Generate random float.<br>
     * Generates from (0 to MAX_FLOAT).
     */
    public static float randomFloat() {
        return randomTool.nextFloat(0, Float.MAX_VALUE);
    }

    /**
     * Generate random float.<br>
     * Generates from (min to MAX_FLOAT).
     *
     * @param min Minimal value.
     */
    public static float randomFloat(float min) {
        return randomTool.nextFloat(min, Float.MAX_VALUE);
    }

    /**
     * Generate random float.<br>
     * Generates from (min to max + 1).
     *
     * @param min Minimal value.
     * @param max Maximal value.
     */
    public static float randomFloat(float min, float max) {
        return randomTool.nextFloat(min, max + 1);
    }

    /**
     * Generate random bool.
     * Generates (true or false).
     */
    public static boolean randomBool() {
        return new boolean[] {true, false} [randomInt(0, 1)];
    }

    /**
     * Choose random element from array.<br>
     * Return's random element from array.
     *
     * @param array Array.
     */
    public static <ArrayElementsType> ArrayElementsType randomElement(ArrayElementsType[] array) {
        return array[randomInt(0, array.length)];
    }
}
