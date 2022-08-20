// Distances.java - Part of Void2D.

package void2d;

import javax.swing.JComponent;

/**
 * <h1>Class for simple working with distances.</h1>
 * Tools for work with distances.
 *
 * @apiNote Formula:<br>
 *             "<code>(((_compareWith.getX() - _gameObject.getX()) - (_compareWith.getWidth() - _gameObject.getWidth())) - _gameObject.getWidth())<br><br>
 *             (((_compareWith.getY() - _gameObject.getY()) - (_compareWith.getHeight() - _gameObject.getHeight())) - _gameObject.getHeight())</code>".
 */
public class Distances {
    /**
     * Prepared value.<br>
     * Use this if you need get, is game object too close to another game object. (<= | >=).
     * <pre>
     * {@code
     * if(Distances.getXDistanceBetweenGameObjects(x, y) <= Distances.tooClose) {
     *     System.out.println("Too close to me!"); // In this case to Y.
     * }
     * </pre>
     *
     */
    public final static int tooClose = 50;

    /**
     * Get distance between game objects.
     *
     * @param _gameObject Game object.
     * @param _compareWith Compare with.
     */
    public static int[] getDistanceBetweenGameObjects(JComponent _gameObject, JComponent _compareWith) {
        int[] distance = {
            (((_compareWith.getX() - _gameObject.getX()) - (_compareWith.getWidth() - _gameObject.getWidth())) - _gameObject.getWidth()),
            (((_compareWith.getY() - _gameObject.getY()) - (_compareWith.getHeight() - _gameObject.getHeight())) - _gameObject.getHeight())
        };

        return distance;
    }

    /**
     * Get distance between game objects but only in X.
     *
     * @param _gameObject Game object.
     * @param _compareWith Compare with.
     */
    public static int getXDistanceBetweenGameObjects(JComponent _gameObject, JComponent _compareWith) {
        return getDistanceBetweenGameObjects(_gameObject, _compareWith)[0];
    }

    /**
     * Get distance between game objects but only in Y.
     *
     * @param _gameObject Game object.
     * @param _compareWith Compare with.
     */
    public static int getYDistanceBetweenGameObjects(JComponent _gameObject, JComponent _compareWith) {
        return getDistanceBetweenGameObjects(_gameObject, _compareWith)[1];
    }

    /**
     * Get distance between game objects from array.
     *
     * @param _gameObject Game object.
     * @param _compareWithArray Compare with array.
     */
    public static int[][] getDistanceBetweenGameObjectsFromArray(JComponent _gameObject, JComponent[] _compareWithArray) {
        int[][] distances = new int[_compareWithArray.length][2];

        for(int index = 0; index < _compareWithArray.length; index++) {
            distances[index] = getDistanceBetweenGameObjects(_gameObject, _compareWithArray[index]);
        }

        return distances;
    }
}
