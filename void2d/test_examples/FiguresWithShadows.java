// Simple example, how to add shadows to figures.

package void2d.test_examples;

import void2d.Window;
import void2d.Figures;
import void2d.Colors;
import void2d.Shadows;
import void2d.EngineFigures;

public class FiguresWithShadows {
    public static void main(String[] args) {
        Window gameWindow = new Window(null, 1000, 800, false, true);

        Figures figuresFactory = new Figures(gameWindow);

        Shadows squareShadows = new Shadows(new int[][] {{40, 50}, {80, 80}}, gameWindow);
        squareShadows.addShadows(null, Shadows.APPLY_DEFAULT_INT, new int[] {Shadows.APPLY_DEFAULT_INT, Shadows.APPLY_DEFAULT_INT}, EngineFigures.SQUARE);

        figuresFactory.square(
            new int[] {50, 50},
            new int[] {100, 100},

            Colors.colorRed
        );

        Shadows circleShadows = new Shadows(new int[][] {{220, 40}, {190, 190}}, gameWindow);
        circleShadows.addShadows(null, -1, new int[] {-1, -1}, EngineFigures.CIRCLE);

        figuresFactory.circle(
            new int[] {200, 50},
            new int[] {100, 100},

            Colors.colorGreen
        );

        gameWindow.showWindow();
    }
}
