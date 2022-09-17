# Starting.
## Let's start!
I think you already created your project and window!

### First step: Import *void2d.UpdateLoop*.
```java
import void2d.Window;
import void2d.UpdateLoop; // <- Importing.

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, false);

        window.showWindow();
    }
}
```

### Second step: Initialize new update loop.
```java
import void2d.Window;
import void2d.UpdateLoop;

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, false);

        // Create new update loop.
        UpdateLoop myUpdLoop = new UpdateLoop(
            () -> {
                System.out.println("Update loop!");
            },

            0,

            true
        );

        window.showWindow();
    }
}
```

- First Argument: Target.
- Second Argument: Delay.
- Third Argument: Auto-run?

Done!

Now you learned threads!

## UpdateLoop methods and fields.
### Fields.
```java
public int updateLoopDelay;
```

### Methods.
```java
public void updateLoopDelay(int newUpdateLoopDelay)
public void runLoop()
public void stopLoop()
```

- updateLoopDelay(int): Update loop delay.
- runLoop(): Run loop.
- stopLoop(): Stop loop.

#### Message.
You completed this chapter, now you can go to "SafeSaveAndSafeConfig.md".
<br>Good luck!
