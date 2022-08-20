// Collision.java - Part of Void2D.

package void2d;

import javax.swing.JComponent;

import java.awt.Rectangle;

/**
 * <h1>Add collision to game object.</h1>
 * Adding collision to object is created for checking,
 * for example is game object intersects with another game object.
 */
public class Collision {
    protected JComponent gameObject;

    /**
     * Add collision to game object.
     * Collision bounds will be game object size.
     *
     * @param _gameObject Add collision to this object.
     */
    public Collision(JComponent _gameObject) {
        gameObject = _gameObject;
    }

    /**
     * Check, is game object intersects with second game object.<br>
     * Second game object doesn't need to have collisions.<br>
     * But it's anyway built-in. (If it's sprite).
     *
     * @param _secGameObject Second game object to check, is intersects with game object.
     */
    public boolean intersects(JComponent _secGameObject) {
        Rectangle gameObjectRect = new Rectangle(gameObject.getX(), gameObject.getY(), gameObject.getWidth(), gameObject.getHeight());
        Rectangle secGameObjectRect = new Rectangle(_secGameObject.getX(), _secGameObject.getY(), _secGameObject.getWidth(), _secGameObject.getHeight());

        return gameObjectRect.intersects(secGameObjectRect);

    }


    /**
     * Check, is game object intersects with game objects from array.<br>
     * Game objects doesn't need to have collisions.<br>
     * But it's anyway built-in. (If it's sprite).
     *
     * @param gameObjects Array with game objects to check, is intersects with game object.
     */
    public boolean intersectsFromArray(JComponent[] gameObjects) {
        for(JComponent _gameObject : gameObjects) {
            if(intersects(_gameObject)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Get game objects collision bounds.<br>
     * By default, it's size of game object.
     */
    public int[] getGameObjectCollisionBounds() {
        return new int[] {gameObject.getX(), gameObject.getY(), gameObject.getWidth(), gameObject.getHeight()};
    }

    /**
     * Get collision bounds of another game object.<br>
     * By default, it's size of game object.
     *
     * @param _gameObject Another game object to get collision bounds.
     */
    public static int[] getGameObjectCollisionBounds(JComponent _gameObject) {
        return new int[] {_gameObject.getX(), _gameObject.getY(), _gameObject.getWidth(), _gameObject.getHeight()};
    }
}
