// Sprite.java - Part of Void2D.

package void2d;

import void2d.utils.javaUtils.Dictionary;

import java.io.File;

import javax.swing.JLabel;

import javax.swing.ImageIcon;

import java.awt.Image;

/**
 * <h1>Class for loading sprites into the game!</h1>
 * Interaction with sprites!
 */
public class Sprite {
    protected Window window;

    protected String spritePath;

    /**
     * Empty sprite constant.
     */
    public static final String EMPTY = "empty";

    /**
     * Missing sprite texture.
     */
    public final String MISSING_SPRITE_TEXTURE = EnginePartPathManager.accessEnginePartWithAbsolutePath("media\\MissingSprite.png");

    /**
     * Is sprite destroyed.
     */
    public boolean destroyed = false;

    /**
     * The sprite object.
     */
    public JLabel sprite;

    /**
     * The sprite object collision.
     */
    public Collision spriteCollision;

    /**
     * All possible sprite states.
     */
    public Dictionary spriteStates = new Dictionary();

    /**
     * Current sprite state.
     */
    public String spriteState = "default";

    /**
     * Current sprite state position.
     */
    public int spriteStatePosition = 0;

    /**
     * Sprite name. (Optional).
     */
    public String spriteName;

    /**
     * Sprite position.
     */
    public int[] position;

    /**
     * Sprite size.
     */
    public int[] size;

    /**
     * Initialize new sprite.
     *
     * @param _window Window where will be placed a sprite.
     * @param _spritePath Sprite path.
     * @param _position Sprite position.
     * @param _size Sprite size.
     */
    public Sprite(Window _window, String _spritePath, int[] _position, int[] _size) {
        window = _window;
        spritePath = _spritePath;

        position = _position;
        size = _size;

        if(spritePath.equals(EMPTY)) {
            int[] spriteSize = (_size == null) ? new int[] {0, 0} : _size;

            sprite = new JLabel(new ImageIcon(EMPTY));
            sprite.setBounds(position[0], position[1], spriteSize[0], spriteSize[1]);

            spriteCollision = new Collision(sprite);

            return;
        }

        int[] spriteSize = (_size == null) ? new int[] {0, 0} : _size;

        sprite = new JLabel(new ImageIcon(new File(spritePath).exists() ? spritePath : MISSING_SPRITE_TEXTURE));
        sprite.setBounds(position[0], position[1], spriteSize[0], spriteSize[1]);

        spriteCollision = new Collision(sprite);
    }

    /**
     * Load sprite into the window.
     */
    public void addSprite() {
        window._getContentPane().add(sprite);
    }

    /**
     * Destroy a sprite.
     */
    public void destroy() {
        window._getContentPane().remove(sprite);

        window.refresh();

        destroyed = true;

        spriteCollision = null;
    }

    /**
     * Get is sprite destroyed.
     */
    public boolean isDestroyed() {
        return destroyed;
    }

    /**
     * Update sprite name.
     *
     * @param newSpriteName New sprite name.
     */
    public void updateSpriteName(String newSpriteName) {
        spriteName = newSpriteName;
    }

    /**
     * Get sprite name.
     */
    public String getSpriteName() {
        return spriteName;
    }

    /**
     * Get sprite path.
    */
    public String getSpritePath() {
        return spritePath;
    }

    /**
     * Append new possible state to sprite states.
     *
     * @param stateName State name.
     * @param statePath State path.
     */
    public void appendSpriteState(String stateName, String statePath) {
        spriteStates.add(stateName, statePath);
    }

    /**
     * Update sprite state.
     *
     * @param stateName State name.
     */
    public void updateSpriteState(String stateName) {
        if(!spriteStates.containsKey(stateName)) {
            throw new IllegalStateException("Invalid sprite state.");
        }

        ImageIcon newSprite = new ImageIcon(String.valueOf(spriteStates.get(stateName)));

        newSprite.getImage().flush();

        sprite.setIcon(newSprite);

        spriteState = stateName;
    }

    /**
     * Update sprite state to next.
     */
    public void nextSpriteState() {
        if(spriteStatePosition >= spriteStates.getKeys().length - 1) {
            return;
        }

        spriteStatePosition++;

        String nextSpriteState = String.valueOf(spriteStates.getKeys()[spriteStatePosition]);

        updateSpriteState(nextSpriteState);
    }

    /**
     * Update sprite state to previous.
     */
    public void previousSpriteState() {
        if(spriteStatePosition <= 0) {
            return;
        }

        spriteStatePosition--;

        String previousSpriteState = String.valueOf(spriteStates.getKeys()[spriteStatePosition]);

        updateSpriteState(previousSpriteState);
    }

    /**
     * Get original image (sprite) size.
     */
    public int[] getImageSize() {
        int[] size = {
            sprite.getIcon().getIconWidth(),
            sprite.getIcon().getIconHeight()
        };

        return size;
    }

    /**
     * Get sprite properties (position and size).
     */
    public int[][] getSpriteProperties() {
        return new int[][] {position, size};
    }

    /**
     * Get current sprite position.
     */
    public int[] getSpritePosition() {
        return getSpriteProperties()[0];
    }

    /**
     * Get current sprite size.
     */
    public int[] getSpriteSize() {
        return getSpriteProperties()[1];
    }

    /**
     * Update sprite position.
     *
     * @param x New sprite X.
     * @param y New sprite Y.
     */
    public void updateSpritePosition(int x, int y) {
        position = new int[] {x, y};

        sprite.setLocation(x, y);
    }

    /**
     * Update sprite size.
     *
     * @param width New sprite width.
     * @param height New sprite height.
     */
    public void updateSpriteSize(int width, int height) {
        size = new int[] {width, height};

        sprite.setSize(width, height);
    }

    /**
     * Update original image size.
     *
     * @param newWidth New width.
     * @param newHeight New height.
     * @param smooth Use smooth scaling?
     */
    public void updateOriginalImageSize(int newWidth, int newHeight, boolean smooth) {
        size = new int[] {newWidth, newHeight};

        sprite.setSize(newWidth, newHeight);

        Image updatedSprite = new ImageIcon(spritePath).getImage().getScaledInstance(newWidth, newHeight, smooth ? Image.SCALE_SMOOTH : Image.SCALE_FAST);

        updatedSprite.flush();

        sprite.setIcon(new ImageIcon(updatedSprite));
    }

    /**
     * Set sprite size by it original image size.<br><br>
     *
     * <h2>Example:</h2>
     *     <b><i>
     *         sprite.png - 800x800.<br>
     * <pre>
     * {@code
     * // Load new sprite.
     * // Take a look at "null" instead of sprite size.
     * Sprite mySprite = new Sprite(myWindow, "sprites\\sprite.png", new int[] {0, 0}, null)
     *
     * // Update sprite size by image size.
     * // By the way, if we don't call this method after settings sprite size to null, we couldn't run the game, because of error.
     * // Now sprite size is 800x800, not null like was.
     * mySprite.setSpriteSizeByImageSize();
     * }
     * </pre>
     *     <i>NOTE</i>: If you wanna use this method, you must be sure that sprite doesn't have transparent borders around the myself.<br>
     *     That's not only not recommended, it's can create some sprite collision problems.
     *     </i></b>
     */
    public void setSpriteSizeByImageSize() {
        int[] imageSize = getImageSize();

        int imageWidth = imageSize[0];
        int imageHeight = imageSize[1];

        size = new int[] {imageWidth, imageHeight};

        updateSpriteSize(imageWidth, imageHeight);
    }
}
