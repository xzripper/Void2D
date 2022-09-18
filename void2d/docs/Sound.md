# Starting.
## Let's start!
I think you already created your project and window!

### First step: Import *void2d.Sound*.
```java
import void2d.Window;
import void2d.Sound; // <- Importing.

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, false);

        window.showWindow();
    }
}
```

### Second step: Initialize new sound ( and play it maybe :) ).
```java
import void2d.Window;
import void2d.Sound;

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, false);

        Sound sfx = new Sound("mySound.wav"); // WAV - Important.

        // Play it <3
        sfx.play();

        window.showWindow();
    }
}
```

- First Argument: Sound path.

Done!

Now you can interact with sounds!

## Sound methods and fields.
### Fields.
```java
public boolean paused = false;
public boolean looped = false;
```

### Methods.
```java
public void setLooped(boolean _looped)
public boolean isLooped()
public void play()
public void stop()
public void pause()
public void resume()
public boolean isPaused()
```

- setLooped(boolean): Make sound looped.
- isLooped(): Is sound looped?
- play(): Play sound.
- stop(): Stop sound.
- pause(): Pause sound.
- resume(): Resume sound.
- isPaused(): Is sound paused?

#### Message.
You completed this chapter, now you can go to "Void2DThread.md".
<br>Good luck!
