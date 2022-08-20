# Starting.
## Let's start!
I think you already created your project and window!

### First step: Import *void2d.Void2DThread*.
```java
import void2d.Window;
import void2d.Void2DThread; // <- Importing.

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, false);

        window.showWindow();
    }
}
```

### Second step: Initialize new thread.
```java
import void2d.Window;
import void2d.Void2DThread;

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, false);

        // Create new thread.
        Void2DThread myThread = new Void2DThread(
            () -> {
                System.out.println("Hello from the thread!");
            }
        );

        // Run thread.
        myThread.run();

        window.showWindow();
    }
}
```

- First Argument: Target.

Done!

Now you learned threads!

## Void2DThread methods and fields.
### Fields.
```java
* NO PUBLIC FIELDS *
```

### Methods.
```java
public void run()
public void stop()
```

- run(): Run thread.
- stop(): Stop thread.

#### Message.
You completed this chapter, now you can go to "UpdateLoop.md".
<br>Good luck!
