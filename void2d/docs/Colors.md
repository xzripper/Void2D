# Starting.
## Let's start!
I think you already know how to create window, or draw figure.

### First step: Import *void2d.Colors* (Example).
```java
import void2d.Window;
import void2d.Figures;
import void2d.Colors; // <- Importing.

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, true);

        Figures figuresFactory = new Figures(window); // <- Initializing.

        // Draw for example, red circle.
        figuresFactory.circle(
            new int[] {100, 100},
            new int[] {50, 50},

            Colors.colorRed // <- Using.
        );

        window.showWindow();
    }
}
```

Result must be that.

<img src="docs-media\RedCircle.png">

## Colors methods and fields.
### Fields.
```java
public static final Color colorWhite = Color.WHITE;
public static final Color colorBlack = Color.BLACK;
public static final Color colorGray = Color.GRAY;
public static final Color colorDarkGray = Color.DARK_GRAY;
public static final Color colorLightGray = Color.LIGHT_GRAY;
public static final Color colorRed = Color.RED;
public static final Color colorGreen = Color.GREEN;
public static final Color colorBlue = Color.BLUE;
public static final Color colorCyan = Color.CYAN;
public static final Color colorYellow = Color.YELLOW;
public static final Color colorPink = Color.PINK;
public static final Color colorOrange = Color.ORANGE;
```

- colorWhite: White color.
- colorBlack: Black color.
- colorGray: Gray color.
- colorDarkGray: Dark Gray color.
- colorLightGray: Light Gray color.
- colorRed: Red color.
- colorGreen: Green color.
- colorBlue: Blue color.
- colorCyan: Cyan color.
- colorYellow: Yellow color.
- colorPink: Pink color.
- colorOrange: Orange color.

### Methods.
```java
public static Color newColor(int r, int g, int b, int a)
```

- newColor(int, int, int, int): Generate new color in RGBA (Red, Green, Blue, Alpha).

#### Message.
You completed this chapter, now you can go to "Shadows.md".
<br>Good luck!
