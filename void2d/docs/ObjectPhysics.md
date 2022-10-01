# Starting.
## Let's start!
I think you already created your project and window!

## What is that?
ObjectPhysics - Built-in engine physics that provides simple gravity system, prop physics (like rigid body), and more.

### First step: Import *void2d.enginePhysics.ObjectPhysics*.

```java
import void2d.Window;

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, false);

        window.showWindow();
    }
}
```

### Second step: Attach (initialize) physics to object (sprite in our case).

```java
import void2d.Window;

import void2d.Sprite;

import void2d.enginePhysics.ObjectPhysics;

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, false);

        // Init & setup sprite.
        Sprite spriteObject = new Sprite(
            window,

            "path\\to\\sprite.png",

            new int[]{0, 0},

            null
        );

        spriteObject.setSpriteSizeByImageSize();
        spriteObject.addSprite();

        // Initialize physics.
        ObjectPhysics spritePhysics = new ObjectPhysics(spriteObject.sprite);

        // Setup physics settings.
        spritePhysics.setObjectMass(100);

        // Run physics loop.
        spritePhysics.runHandlers(
            window,

            null,
            null
        );

        window.showWindow();
    }
}
```

And if you run it, you can see your sprite fall!<br>
To make sprite land-able, specify ground in physics constructor.

## ObjectPhysics methods and fields.
### Fields.
```java
public static final float PHYSICS_VERSION = 1.3f;
public Body objectBody = Body.SQUARE_BODY;
public boolean handlersRunning = false;
public ArrayList<Prop> gameProps = new ArrayList<>();
public int gameObjectMass = 0;
public boolean frozen = false;
public boolean bouncy = false;
public int force = 0;
public final static int DEFAULT_PHYSICS_UPDATE_DELAY = 25;
public final static int DEFAULT_FALLING_SPEED = 50;
public final static int DEFAULT_REBOUND_POWER = 80;
public final static int DEFAULT_MIN_ROLL_POWER = -15;
public final static int DEFAULT_MAX_ROLL_POWER = Math.abs(DEFAULT_MIN_ROLL_POWER);
public final static int DEFAULT_PROP_MASS = 100;
public final static float UPDATE = 0.1f;
```

### Methods.
```java
public void setBody(Body body)
public Body getBody()
public void setObjectMass(int newMass)
public int getObjectMass()
public void setFrozen(boolean _frozen)
public boolean isFrozen()
public void setBouncy(boolean _bouncy)
public boolean isBouncy()
public int getForce()
public boolean inAir()
public boolean notInAir()
public boolean abutsGameObject(JComponent _gameObject)
public boolean abutsGameObjectFromBack(JComponent _gameObject)
public boolean intersectsAnyProp()
public void addProp(Prop newProp)
public void removeProp(int propIndex)
public void handleGravity(Window window)
public void handleProps(Consumer<ScreenSides> onEnter, Runnable onExit)
public void runHandlers(Window window, Consumer<ScreenSides> onPropEnter, Runnable onPropExit)
public void stopHandlers()
public boolean isHandlersRunning()
```

- setBody(Body): Update object body.
- getBody(): Get object body.
- setObjectMass(int): Set object mass.
- getObjectMass(): Get object mass.
- setFrozen(boolean): Set object static (frozen).
- isFrozen(): Is object static (frozen).
- setBouncy(boolean): Set object bouncy.
- isBouncy(): Get is object bouncy.
- getForce(): Get object force.
- inAir(): Is object in air.
- notInAir(): Is object not in air.
- abutsGameObject(JComponent): Is game object abuts another game object.
- abutsGameObjectFromBack(JComponent): Is game object abuts another game object from back.
- intersectsAnyProp(): Is game object intersects any prop.
- addProp(Prop): Register new prop in game props.
- removeProp(int): Remove prop from game props.
- handleGravity(Window): Handle gravity. To run in loop use ```runHandlers```.
- handleProps(Consumer<ScreenSides<ScreenSides>>, Runnable onExit): Handle props. To run in loop use ``runHandlers``.
- stopHandlers(): Stop all physics handlers.
- isHandlersRunning(): Is physics handlers running?

#### Message.
You reached last documentation chapter!
<br>Good luck writing code!
