# Starting.
## Let's start!
I think you already know how to create window, or draw figure.

## Warning: Shadows in BETA!

### First step: Import *void2d.VisualizedRay*.
```java
import void2d.Window;
import void2d.VisualizedRay; // <- Importing.

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, true);

        window.showWindow();
    }
}
```

### Second step: Initialize visualized ray and cast it.

```java
import void2d.Window;

import void2d.VisualizedRay;

import void2d.Sprite; // <- Need!

import javax.swing.JComponent; // <- Need!

public class Main {
    public static void main(String[] args) {
        // Must support drawings.
        Window window = new Window("Window Title.", 500, 500, false, true);

        // Visualized ray sprite.
        Sprite raySprite = new Sprite(
            window,
            "path\\to\\sprite.png",
            new int[] {25, 25},
            new int[] {25, 25}
        );

        // Add sprite.
        raySprite.addSprite();

        // Initializing new visualized ray and setting up ray properties.
        VisualizedRay ray = new VisualizedRay(
            raySprite, // Ray sprite.
            new int[] {raySprite.getSpritePosition()[0], raySprite.getSpritePosition()[1]}, // Ray position.
            new int[] {raySprite.getSpriteSize()[0], raySprite.getSpriteSize()[1]}, // Ray size.
            80 // Ray speed.
        );

        // Register new object that can collide with ray.
        ray.registerCollidableGameObject(object1);
        
        // Cast visualized ray.
        ray.castVisualized(
            (gameObject, rayPosition) -> {
                System.out.println("Got hit with game object.");
            }, // On hit handler.

            false, // Reverse cast? If true, ray must cast back, else forward.

            new JComponent[] {
                object2,
                object3
            } // Destroy ray when ray hit something from this array.
        );

        window.showWindow();
    }
}
```

## VisualizedRay methods and fields.
### Fields.
```java
public int[] rayPos;
public int[] raySize;
public int raySpeed;
public Sprite raySprite;
public boolean rayCasting = false;
public ArrayList<JComponent> regCollidableGameObjects = new ArrayList<>();
public final int MAX_RAY_POS_X = 0x10b8;
```

### Methods.
```java
public void registerCollidableGameObject(JComponent gameObject)
public void cast(BiConsumer<JComponent, int[]> onRayHit, boolean reverseCast, JComponent[] destroyOn)
public void castVisualized(BiConsumer<JComponent, int[]>, boolean, JComponent[])
public int[] getRayPosition()
public int[] getRaySize()
public int getRaySpeed()
public Sprite getRaySprite()
public ArrayList<JComponent> getRegisteredCollidableGameObjects()
public boolean isRayCasting()
```

- registerCollidableGameObject(JComponent): Register new game object that can collide with ray.
- cast(BiConsumer<JComponent, int[]>, boolean, JComponent[]): Cast ray.
- castVisualized(BiConsumer<JComponent, int[]>, boolean, JComponent[]): Cast visualized ray.
- getRayPosition(): Get ray position.
- getRaySize(): Get ray size.
- getRaySpeed(): Get ray speed.
- getRaySprite(): Get ray sprite.
- getRegisteredCollidableGameObjects(): Get all game objects that can collide with ray.
- isRayCasting(): Is ray right now casting.

#### Message.
You completed this chapter, now you can go to "ObjectPhysics.md".
<br>Good luck!
