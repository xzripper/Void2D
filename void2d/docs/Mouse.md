# Starting.
## Let's start!
I think you already created your project and window!

### First step: Import *void2d.Mouse*.
```java
import void2d.Window;
import void2d.Mouse; // <- Importing.

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, false);

        window.showWindow();
    }
}
```

### Second step: Initialize mouse and bind functions to events.
```java
import void2d.Window;
import void2d.Keyboard;

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, false);

        Mouse mouseHandler = new Mouse(
            new Runnable[] { // On mouse clicked.
                () -> { // On left mouse clicked.
                    System.out.println("Do you clicked left mouse?");
                },

                null // On right mouse clicked.
            },

            new Runnable[] { // On mouse released.
                () -> { // On left mouse released.
                    System.out.println("Do you released left mouse?");
                },

                null // On right mouse released.
            },

            new Runnable[] { // On mouse pressed.
                () -> { // On left mouse pressed.
                    System.out.println("Do you pressed left mouse?");
                },

                null // On right mouse pressed.
            }
        );

        // Bind mouse handler to object.
        // AnyObject - sprite for example.
        mouseHandler.addMouseHandlerToObject(AnyObject);

        // You can also bind handler to window.
        mouseHandler.addMouseHandlerToWindow(window);

        window.showWindow();
    }
}
```

- First Argument: On mouse clicked handler.
- Second Argument: On mouse released handler.
- Third Argument: On mouse pressed handler.

Done!

Now you can interact with mouse!

## Mouse methods and fields.
### Fields.
```java
* NO PUBLIC FIELDS *
```

### Methods.
```java
public void addMouseHandlerToWindow(Window window)
public void addMouseHandlerToObject(JComponent object)
public static int[] getMousePosition()
public static int[] getMousePositionInWindow(Window window)
```

- addMouseHandlerToWindow(Window): Add mouse handler to window.
- addMouseHandlerToObject(JComponent): Add mouse handler to object.
- getMousePosition(): Get mouse position.
- getMousePositionInWindow(Window): Get mouse position inside the window.

#### Message.
You completed this chapter, now you can go to "Sound.md".
<br>Good luck!
