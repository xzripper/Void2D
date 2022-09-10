// SpriteAnimation.java - Part of Void2D.

package void2d.utils;

import void2d.Sprite;

import void2d.Void2DThread;

/**
 * Sprite Animations Util.
 */
public class SpriteAnimation {
    private final Sprite sprite;

    /**
     * Default animation speed.
     */
    public final long SPRITE_ANIMATION_SPEED_DEFAULT = 1;

    /**
     * Animation speed.
     */
    public long animSpeed = SPRITE_ANIMATION_SPEED_DEFAULT;

    /**
     * Is animation running?
     */
    public boolean animRunning = false;

    /**
     * Initialize new sprite animation.
     *
     * @param _sprite Sprite.
     */
    public SpriteAnimation(Sprite _sprite) {
        sprite = _sprite;
    }

    /**
     * Play animation.
     */
    public void play() {
        if(animRunning) {
            return;
        }

        String[] spriteStates = sprite.spriteStates.keySet().toArray(new String[0]);

        Void2DThread animThread = new Void2DThread(
            () -> {
                animRunning = true;

                for(String spriteState : spriteStates) {
                    sprite.updateSpriteState(spriteState);

                    try {
                        Thread.sleep(animSpeed);
                    } catch(InterruptedException interrupted_exc) {
                        System.out.println(interrupted_exc.getMessage());
                    }
                }

                animRunning = false;
            }
        );

        animThread.run();
    }

    /**
     * Update animation speed.
     *
     * @param _animSpeed New animation speed.
     */
    public void updateAnimationSpeed(long _animSpeed) {
        animSpeed = _animSpeed;
    }
}
