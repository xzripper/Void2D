# Starting.
## Let's start!
I think you already created your project and window!

### First step: Import *void2d.Collision*.
```java
import void2d.Window;
import void2d.Collision; // <- Importing.

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, false);

        window.showWindow();
    }
}
```

### Second step: Using collision.
If you want to add collision to object, not sprite.
Use this method.

```java
import void2d.Window;
import void2d.Collision;

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, false);

        Collision objectCollision = new Collision(); // <- Insert there your object.

        window.showWindow();
    }
}
```

If you want to add collision to sprite.
Use this method.

```java
import void2d.Window;

import void2d.Sprite;

import void2d.Collision;

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, false);

        Sprite mySprite = new Sprite(
            window,

            "path\\to\\sprite.png",

            new int[] {0, 0},

            null
        );

        mySprite.setSpriteSizeByImageSize();
        mySprite.addSprite();

        Collision spriteCollision = mySprite.spriteCollision;

        window.showWindow();
    }
}

```

Done!

Now you can add sprites to your window!

## Sprite methods and fields.
### Fields.
```java
* NO PUBLIC FIELDS *
```

### Methods.
```java
public boolean intersects(JComponent _secGameObject)
public boolean intersectsFromArray(JComponent[] gameObjects)
public int[] getGameObjectCollisionBounds()
public static int[] getGameObjectCollisionBounds(JComponent _gameObject)
```

- intersects(JComponent): Is game object intersects another object.
- intersectsFromArray(JComponent[]): Is game object intersects another objects from array.
- getGameObjectCollisionBounds(): Get game object collision bounds.
- getGameObjectCollisionBounds(JComponent): Get game object collision bounds using static method. 

#### Message.
You completed this chapter, now you can go to "Keyboard.md".
<br>Good luck!
