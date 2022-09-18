# Creating windows!
## Let's start!
I think you already created a project, and you have Main.java (main file can have any file).

### First step: Import *void2d.Window* (window class).
```java
import void2d.Window; // <- Importing.

// Main -> Your file name. (without .java).
public class Main {
    public static void main(String[] args) {

    }
}
```

### Second step: Initialize window.
```java
import void2d.Window; // <- Importing.

// Main -> Your file name. (without .java).
public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, false);
    }
}
```

Here, we've initializing new ```Window``` class.

- First Argument: Window Title.<br>
Note: If window title is null, title automatically will set to "{OS Name} {OS Architecture}".<br>
<br>But if you have Linux or Mac, you can have problems with it.
Look at OS support table in "Starting.md".<br><br>

- Second Argument: Window width.<br>

- Third Argument: Window height.<br>

- Fourth Argument: Is window resizable.

- Fifth Argument: Is window supports drawings. (explanation about that will be later, in "Figures.md").

### Third step: Run window.
```java
import void2d.Window; // <- Importing.

// Main -> Your file name. (without .java).
public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, false);

        window.showWindow(); // <- Running.
    }
}
```

### Done!
Now you can see this.

<img src="docs-media\Window.png">

## Window methods and fields.
### Fields.
```java
public final int WINDOW_UPDATE_LOOP_DELAY = _windowUpdateLoop.getDelay();
public final int DEFAULT_WINDOW_X_POSITION = 50;
public final int DEFAULT_WINDOW_Y_POSITION = 50;
public boolean windowVisible = false;
```

### Methods.
```java
public void doRepaintDuringPaint(boolean _needRepaint)
public void showWindow()
public void hideWindow()
public boolean windowVisible()
public void updateWindowSize(int newWidth, int newHeight)
public void updateWindowPosition(int newX, int newY)
public void setWindowResizable(boolean resizable)
public void setWindowIcon(String newIcon)
public void setWindowBackground(int[] rgba) 
public int[] getWindowSize()
public boolean isMinimized()
public boolean isMaximized()
public void onMinimizing(Runnable handler)
public void onMaximizing(Runnable handler)
public void updateWindowUpdateLoopListener(Runnable listener)
public void startWindowUpdateLoop()
public void stopWindowUpdateLoop()
public Container _getContentPane()
public void _addKeyboardHandler(KeyListener keyListener)
public void _appendFiguresToDraw(Figure figure)
public String _getOSAndArchitecture()
```

- doRepaintDuringPaint(boolean): Repaint all objects that was drawn on the screen. (look "Figures.md").
- showWindow(): Run window.
- hideWindow(): Hide window.
- windowVisible(): Get is window visible.
- updateWindowSize(int, int): Update window size.
- updateWindowPosition(int, int): Update window position.
- setWindowResizable(boolean): Set is window resizable.
- setWindowIcon(String): Set new window icon.
- setWindowBackground(int[]): Update window background. (RGBA - Red, Green, Blue, Alpha).
- getWindowSize(): Get window size.
- isMinimized(): Get is window minimized.
- isMaximized(): Get is window maximized.
- onMinimizing(Runnable): Run function on minimizing. Works infinity when in window update loop.
- onMaximizing(Runnable): Run function on maximizing. Works infinity when in window update loop.
- updateWindowUpdateLoopListener(Runnable): Execute function in window update loop. (Timer?).
- startWindowUpdateLoop(): Start window update loop.
- stopWindowUpdateLoop(): Stop window update loop.
- _getContentPane(): Get window content pane. Not prepared for using by user. This method uses another parts of engine.
- _addKeyboardHandler(KeyListener): Add keyboard handler. Not prepared for using by user. This method uses another parts of engine.
- _addMouseHandler(MouseListener): Add mouse handler. Not prepared for using by user. This method uses another parts of engine.
- _appendFiguresToDraw(Figure): Append figure to draw queue. Not prepared for using by user. This method uses another parts of engine.
- _getOSAndArchitecture(): Get OS and architecture. Not prepared for using by user. This method uses another parts of engine.

#### Message.
You completed this chapter, now you can go to "Figures.md".
<br>Good luck!
