# Creating figures!
## Let's start!
I think you already created your project and window!

### First step: Import *void2d.Figures*.
```java
import void2d.Window;
import void2d.Figures; // <- Importing.

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, false);

        window.showWindow();
    }
}
```

### Second step: Initialize figures factory.
```java
import void2d.Window;
import void2d.Figures; // <- Importing.

public class Main {
    public static void main(String[] args) {
        /*
            Look at last argument, it's true.
            It means that window supports drawings.
            That's important if you want draw figures.
         */
        Window window = new Window("Window Title.", 500, 500, false, true);

        Figures figuresFactory = new Figures(window); // <- Initializing.

        window.showWindow();
    }
}
```

- First Argument: Window.

Done!

Now you can draw any figure!

## Figures methods and fields.
### Fields.
```java
* NO PUBLIC FIELDS *
```

### Methods.
```java
public void square(int[] XY, int[] size, Color color)
public void circle(int[] XY, int[] size, Color color)
public void triangle(int[] size, Color color)
```

- square(int[], int[], Color): Draw a square.
- circle(int[], int[], Color): Draw a circle.
- triangle(int[], Color): Draw a triangle. Note: Drawing triangles is complicated so use it carefully.

#### Message.
You completed this chapter, now you can go to "Colors.md".
<br>Good luck!
