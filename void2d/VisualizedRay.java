// VisualizedRay.java - Part of Void2D.

package void2d;

import void2d.enginePhysics.ObjectPhysics;

import javax.swing.JComponent;

import java.util.function.BiConsumer;

/**
 * <h1>Class for working with visualized rays.</h1>
 * Same like Ray, but visualized.
 */
public class VisualizedRay extends Ray {
    protected UpdateLoop raySpriteApplierLoop;

    /**
     * Ray sprite.
     */
    public Sprite raySprite;

    /**
     * Initialize new visualized ray.
     *
     * @param _raySprite Ray sprite.
     * @param rayPos Ray position.
     * @param raySize Ray size.
     * @param raySpeed Ray speed.
     */
    public VisualizedRay(Sprite _raySprite, int[] rayPos, int[] raySize, int raySpeed) {
        super(rayPos, raySize, raySpeed);

        raySprite = _raySprite;
    }

    /**
     * Cast visualized ray.
     *
     * @param onRayHit On ray hit handler.
     * @param reverseCast Cast ray in reverse. (From left to right).
     * @param destroyOn Destroy ray on hit with this object.
     */
    public void castVisualized(BiConsumer<JComponent, int[]> onRayHit, boolean reverseCast, JComponent[] destroyOn) {
        cast(onRayHit, reverseCast, destroyOn);

        raySpriteApplierLoop = new UpdateLoop(
            () -> {
                if(!isRayCasting()) {
                    raySprite.destroy();

                    raySpriteApplierLoop.stopLoop();
                }

                raySprite.updateSpritePosition(
                    rayPos[0],
                    rayPos[1]
                );
            },

            ObjectPhysics.DEFAULT_PHYSICS_UPDATE_DELAY,
            true
        );
    }

    /**
     * Get ray sprite.
     */
    public Sprite getRaySprite() {
        return raySprite;
    }
}
