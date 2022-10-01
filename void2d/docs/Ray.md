# Starting.
## Let's start!
I think you already know how to create window, or draw figure.

## Warning: Shadows in BETA!

### First step: Import *void2d.Ray*.
```java
import void2d.Window;
import void2d.Ray; // <- Importing.

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, true);

        window.showWindow();
    }
}
```

### Second step: Initialize ray and cast it.

```java
import void2d.Window;

import void2d.Ray;

import javax.swing.JComponent; // <- Need!

public class Main {
    public static void main(String[] args) {
        // Must support drawings.
        Window window = new Window("Window Title.", 500, 500, false, true);

        // Initializing new ray and setting up ray properties.
        Ray ray = new Ray(
            new int[] {25, 25}, // Ray position.
            new int[] {15, 15}, // Ray size.
            80 // Ray speed.
        );

        // Register new object that can collide with ray.
        ray.registerCollidableGameObject(object1);
        
        // Cast ray.
        ray.cast(
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

## Ray methods and fields.
### Fields.
```java
public int[] rayPos;
public int[] raySize;
public int raySpeed;
public boolean rayCasting = false;
public ArrayList<JComponent> regCollidableGameObjects = new ArrayList<>();
public final int MAX_RAY_POS_X = 0x10b8;
```

### Methods.
```java
public void registerCollidableGameObject(JComponent gameObject)
public void cast(BiConsumer<JComponent, int[]> onRayHit, boolean reverseCast, JComponent[] destroyOn)
public int[] getRayPosition()
public int[] getRaySize()
public int getRaySpeed()
public ArrayList<JComponent> getRegisteredCollidableGameObjects()
public boolean isRayCasting()
```

- registerCollidableGameObject(JComponent): Register new game object that can collide with ray.
- cast(BiConsumer<JComponent, int[]>, boolean, JComponent[]): Cast ray.
- getRayPosition(): Get ray position.
- getRaySize(): Get ray size.
- getRaySpeed(): Get ray speed.
- getRegisteredCollidableGameObjects(): Get all game objects that can collide with ray.
- isRayCasting(): Is ray right now casting.

#### Message.
You completed this chapter, now you can go to "VisualizedRay.md".
<br>Good luck!
