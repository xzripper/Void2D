# Starting.
## Let's start!
I think you already created your project and window!

### First step: Import *void2d.Keyboard*.
```java
import void2d.Window;
import void2d.Keyboard; // <- Importing.

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, false);

        window.showWindow();
    }
}
```

### Second step: Initialize keyboard and bind functions to events.
```java
import void2d.Window;
import void2d.Keyboard;

import java.util.function.Consumer; // <- Need!

import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, false);

        Keyboard keyboardHandler = new Keyboard(
            new Consumer[] {
                null, // <- Evaluate this function on key typed. (Can be null).
                Main::onKeyPressed, // <- Evaluate this function on key pressed. (Can be null).
                null // <- Evaluate this function on key released. (Can be null).
            }
        );

        // Register keyboard handler.
        keyboardHandler.addKeyboardHandler(window);

        window.showWindow();
    }

    public static void onKeyPressed(KeyEvent key) {
        // Close app on "escape" key.
        if(key.equals(KeyEvent.VK_ESCAPE)) {
            System.exit(0);
        }
    }
}
```

- First Argument: Events handlers.

Done!

Now you can interact with keyboard!

## Keyboard methods and fields.
### Fields.
```java
* NO PUBLIC FIELDS *
```

### Methods.
```java
public void addKeyboardHandler(Window window)
```

- addKeyboardHandler(Window): Add keyboard handler to the window. Important to call!

#### Message.
You completed this chapter, now you can go to "Void2DThread.md".
<br>Good luck!
