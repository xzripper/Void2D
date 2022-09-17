# Starting.
## Let's start!
I think you already know how to create window, or draw figure.

## Warning: Shadows in BETA!

### First step: Import *void2d.Shadows*.
```java
import void2d.Window;
import void2d.Shadows; // <- Importing.

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, true);

        window.showWindow();
    }
}
```

### Second step: Add shadows.
```java
import void2d.Window;

import void2d.Figures; // <- Add shadows to figures for example.

import void2d.Colors;

import void2d.Shadows;

import void2d.EngineFigures; // <- All possible engine figures.

public class Main {
    public static void main(String[] args) {
        // Must support drawings.
        Window window = new Window("Window Title.", 500, 500, false, true);

        // Square properties.
        int[] squareProperties = {50, 50, 100, 100};

        // Initialize shadows.
        Shadows squareShadows = new Shadows(
            new int[][] {
                {
                    squareProperties[0],
                    squareProperties[1]
                },

                {
                    squareProperties[2],
                    squareProperties[3]
                }
            },

            window
        );

        // Add shadows.
        squareShadows.addShadows(
            null,

            Shadows.APPLY_DEFAULT_INT,

            new int[] {
                Shadows.APPLY_DEFAULT_INT,
                Shadows.APPLY_DEFAULT_INT
            },

            EngineFigures.SQUARE
        );

        // Initialize figures factory.
        Figures figuresFactory = new Figures(window);

        // Draw square.
        figuresFactory.square(
            new int[] {
                squareProperties[0],
                squareProperties[1]
            },

            new int[] {
                squareProperties[2],
                squareProperties[3]
            },

            Colors.colorRed
        );

        window.showWindow();
    }
}
```

Result must be similar to that.

<img src="docs-media\ShadowsExample.png">

## Shadows methods and fields.
### Fields.
```java
public final static int DEFAULT_SHADOW_X_MULTIPLIER = 50;
public final static int DEFAULT_SHADOW_Y_MULTIPLIER = 40;
public final static int DEFAULT_SHADOW_ALPHA = 120;
public final static Color DEFAULT_SHADOW_COLOR = Colors.colorBlack;
public final static int APPLY_DEFAULT_INT = -1;
```

### Methods.
```java
public void addShadows(Color color, int alpha, int[] _XY, EngineFigures figure)
```

- addShadows(Color, int, int[], EngineFigures): Add shadows.

#### Message.
You completed this chapter, now you can go to "Sprite.md".
<br>Good luck!
