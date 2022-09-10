# Starting.
## Let's start!
I think you already created your project and window!

### First step: Import *void2d.Sprite*.
```java
import void2d.Window;
import void2d.Sprite; // <- Importing.

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, false);

        window.showWindow();
    }
}
```

### Second step: Setup new sprite.
```java
import void2d.Window;
import void2d.Sprite;

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, false);

        Sprite mySprite = new Sprite(
            window,

            "path\\to\\sprite.png",

            new int[] {25, 25},

            null // Can be any size, but we will use next method to apply image size to sprite object.
        );

        mySprite.setSpriteSizeByImageSize(); // Apply object size to original image (sprite) size.
        mySprite.addSprite(); // Add sprite.

        window.showWindow();
    }
}
```

- First Argument: Window.
- Second Argument: Path to sprite.
- Third Argument: Sprite position.
- Fourth Argument: Sprite size.

Done!

Now you can add sprites to your window!

## Sprite methods and fields.
### Fields.
```java
public boolean destroyed = false;
public JLabel sprite;
public Collision spriteCollision;
public HashMap<String, String> spriteStates = new HashMap<>();
public String spriteState = "default";
public int spriteStatePosition = 0;
public String spriteName;
public int[] position;
public int[] size;
```

### Methods.
```java
public void addSprite()
public void destroy()
public boolean isDestroyed()
public void updateSpriteName(String newSpriteName)
public String getSpriteName()
public String getSpritePath()
public void appendSpriteState(String stateName, String statePath)
public void updateSpriteState(String stateName)
public void nextSpriteState()
public void previousSpriteState()
public int[] getImageSize()
public int[][] getSpriteProperties()
public int[] getSpritePosition()
public int[] getSpriteSize()
public void updateSpritePosition(int x, int y)
public void updateSpriteSize(int width, int height)
public void setSpriteSizeByImageSize()
```

- addSprite(): Add sprite to the window.
- destroy(): Destroy sprite.
- isDestroyed(): Is sprite destroyed?
- updateSpriteName(String): Update sprite name.
- getSpriteName(): Get sprite name.
- getSpritePath(): Get sprite path.
- appendSpriteState(String, String): Append new sprite state.
- updateSpriteState(String): Update current sprite state.
- nextSpriteState(): Update current sprite state to next state.
- previousSpriteState(): Update current sprite state to previous state.
- getImageSize(): Get original image size.
- getSpriteProperties(): Get sprite properties (size & position).
- getSpritePosition(): Get sprite position.
- getSpriteSize(): Get sprite size.
- updateSpritePosition(int, int): Update sprite position.
- updateSpriteSize(int, int): Update sprite size.
- setSpriteSizeByImageSize(): Set sprite size by it original image size.

#### Message.
You completed this chapter, now you can go to "Collision.md".
<br>Good luck!
