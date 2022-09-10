// Shadows.java - Part of Void2D.

package void2d;

import javax.swing.JComponent;

import java.awt.Color;

/**
 * <h1>Class for working easy working with shadows.</h1>
 * Apply shadows to game objects easy!
 */
public class Shadows {
    protected Window window;

    protected JComponent gameObject = null;

    protected int[][] shadowsProperties = null;

    protected Figures figuresFactory;

//    protected UpdateLoop parentFollowingLoop;

//    public boolean followsParent = false;

    /**
     * Default shadow X multiplier.
     */
    public final static int DEFAULT_SHADOW_X_MULTIPLIER = 50;

    /**
     * Default shadow Y multiplier.
     */
    public final static int DEFAULT_SHADOW_Y_MULTIPLIER = 40;

    /**
     * Default shadow alpha.
     */
    public final static int DEFAULT_SHADOW_ALPHA = 120;

    /**
     * Default shadow color.
     */
    public final static Color DEFAULT_SHADOW_COLOR = Colors.colorBlack;

    /**
     * Use this value for applying default values to parameters (INT).
     */
    public final static int APPLY_DEFAULT_INT = -1;

    /**
     * Initialize shadows.
     *
     * @param _gameObject Game object.
     * @param _window Window.
     */
    public Shadows(JComponent _gameObject, Window _window) {
        gameObject = _gameObject;

        window = _window;

        figuresFactory = new Figures(_window);
    }

    /**
     * Initialize shadows.<br>
     * Initialize shadows, but without game object.<br>
     * Use this method, if you want to create shadows without parent.<br>
     *
     * @param _shadowsProperties Shadows properties.
     * @param _window Window.
     */
    public Shadows(int[][] _shadowsProperties, Window _window) {
        shadowsProperties = _shadowsProperties;

        figuresFactory = new Figures(_window);
    }


    /**
     * <h3>Warning: This method currently not works with adding shadows when window doesn't supports drawing.</h3>
     *
     * Add shadows to game object.<br><br>
     * Or, if game object don't specified you can create shadows without parents.<br><br>
     *
     * Default shadow color: <code>DEFAULT_SHADOW_COLOR</code>. (To apply set color to null).<br>
     * Default shadow alpha: <code>DEFAULT_SHADOW_ALPHA</code>. (To apply set alpha to APPLY_DEFAULT_INT).<br>
     * Default shadow coordinates multiplier: <br><code>int[] DEFAULT_SHADOW_X_MULTIPLIER, DEFAULT_SHADOW_Y_MULTIPLIER</code> (To apply set XY to <code>int[] {APPLY_DEFAULT_INT, APPLY_DEFAULT_INT})</code> ([0] - Set X to default, [1] - Set Y to default).
     *
     * @param color Shadows color.
     * @param alpha Shadows alpha.
     * @param _XY Shadows coordinates multiplier.
     * @param figure Shadows figure.
     *
     * @throws IllegalArgumentException This exception could be thrown if shadows figure is invalid.
     *                                  Allowed only square or circle.
     *
     * @apiNote This function could have unexpected behaviour.
     *          So please, use it carefully.
     */
    public void addShadows(Color color, int alpha, int[] _XY, EngineFigures figure) {
        if(color == null) {
            color = DEFAULT_SHADOW_COLOR;
        }

        if(alpha == -1) {
            alpha = DEFAULT_SHADOW_ALPHA;
        }

        int[] gameObjectPosition = null;

        if(gameObject != null) {
            gameObjectPosition = new int[] {
                gameObject.getX(),
                gameObject.getY()
            };
        } else if(shadowsProperties != null) {
            gameObjectPosition = shadowsProperties[0];
        }

        int[] gameObjectSize = null;

        if(gameObject != null) {
            gameObjectSize = new int[] {
                gameObject.getWidth(),
                gameObject.getHeight()
            };
        } else if(shadowsProperties != null) {
            gameObjectSize = shadowsProperties[1];
        }

        int[] XY = {
            ((_XY[0] == -1) ? ((figure == EngineFigures.CIRCLE) ? 0 : DEFAULT_SHADOW_X_MULTIPLIER) : _XY[0]),
            ((_XY[1] == -1) ? DEFAULT_SHADOW_Y_MULTIPLIER : _XY[1])
        };

        int shadowX = gameObjectPosition[0] + XY[0];
        int shadowY = gameObjectPosition[1] + XY[1];

        int[] shadowXY = {
            shadowX,
            shadowY
        };

        if(figure == EngineFigures.SQUARE) {
            figuresFactory.square(
                shadowXY,
                gameObjectSize,

                Colors.newColor(
                    color.getRed(),
                    color.getGreen(),
                    color.getBlue(),

                    alpha
                )
            );
        } else if(figure == EngineFigures.CIRCLE) {
            int[] circleShadowSize = {
                gameObjectSize[0] / 2,
                gameObjectSize[1] / 2
            };

            figuresFactory.circle(
                shadowXY,
                circleShadowSize,

                Colors.newColor(
                    color.getRed(),
                    color.getGreen(),
                    color.getBlue(),

                    alpha
                )
            );
        } else {
            throw new IllegalArgumentException("Invalid shadow figure. Allowed only {SQUARE, CIRCLE}.");
        }
    }

    // Commented while developing this method.
    // While shadows have problem (shadows unsupported while window doesn't support drawing), this method will be frozen.
//    public void followParent() {
//        if(gameObject == null) {
//            throw new UnsupportedOperationException("Make shadows follow the parent only possible when parent is specified.");
//        }
//
//        if(!(window.needRepaint)) {
//            window.doRepaintDuringPaint(true);
//        }
//
//        followsParent = true;
//
//        parentFollowingLoop = new UpdateLoop(
//            () -> {
//
//            },
//
//            0,
//            true
//        );
//    }
}
