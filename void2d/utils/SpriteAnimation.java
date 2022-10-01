// SpriteAnimation.java - Part of Void2D.

package void2d.utils;

import void2d.Sprite;

import void2d.Void2DThread;

/**
 * Sprite Animations Util.
 */
public class SpriteAnimation {
    private final Sprite sprite;

    private boolean shouldStopInfAnim = false;

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

        String[] spriteStates = (String[]) sprite.spriteStates.getKeys();

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
     * Play infinite animation.
     */
    public void playInfinite() {
        if(animRunning) {
            return;
        }

        Void2DThread infAnimThread = new Void2DThread(
            () -> {
                String[] spriteStates = (String[]) sprite.spriteStates.getKeys();

                animRunning = true;

                while(!shouldStopInfAnim) {
                    for(String spriteState : spriteStates) {
                        sprite.updateSpriteState(spriteState);

                        try {
                            Thread.sleep(animSpeed);
                        } catch(InterruptedException interrupted_exc) {
                            System.out.println(interrupted_exc.getMessage());
                        }
                    }
                }

                animRunning = false;

                shouldStopInfAnim = false;
            }
        );

        infAnimThread.run();
    }

    /**
     * Stop infinity animation.
     */
    public void stopInfiniteAnimation() {
        shouldStopInfAnim = true;
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
