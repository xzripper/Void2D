# Starting.
## Let's start!
I think you already created your project and window!

## SafeSave.
### First step: Import *void2d.SafeSave*.
```java
import void2d.Window;
import void2d.SafeSave; // <- Importing.

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, false);

        window.showWindow();
    }
}
```

### Second step: Initialize new safe save.
```java
import void2d.Window;
import void2d.SafeSave;

import java.io.IOException; // <- Need!

import java.util.HashMap; // <- Need!

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Window window = new Window("Window Title.", 500, 500, false, false);

        // New hashmap with data.
        HashMap<String, Object> dataToSave = new HashMap<>();

        // Add data.
        dataToSave.put("x", 5);
        dataToSave.put("y", 5);

        // Initialize save.
        SafeSave newSave = new SafeSave(dataToSave, "save.dat");

        // Load save.
        HashMap<String, Object> saveOutput = SafeSave.loadData("save.dat");

        // If failed to load save (save not found).
        if(SafeSave.failedToLoad(saveOutput)) {
            System.out.println("Save don't found. Saving...");

            newSave.saveData();
        // Save found.
        } else {
            System.out.println("Save found!");

            System.out.printf("X, Y: %d, %d%n", saveOutput.get("x"), saveOutput.get("y"));
        }

        window.showWindow();
    }
}
```

- First Argument: Data to save.
- Second Argument: Save to.

Done!

Now you learned SAFE saves!

## SafeSave methods and fields.
### Fields.
```java
public HashMap<String, Object> dataToSave;
public String saveFile;
```

### Methods.
```java
public void saveData() throws IOException
public static HashMap<String, Object> loadData(String saveFile) throws IOException, ClassNotFoundException
public static boolean failedToLoad(HashMap<String, Object> out)
public void updateDataToSave(HashMap<String, Object> newDataToSave)
public void updateSaveFile(String newSaveFile)
```

- saveData(): Save data to save.
- loadData(String): Load data from save file.
- failedToLoad(HashMap<String, Object>): Is save failed to load.
- updateDataToSave(HashMap<String, Object>): Update data to save.
- updateSaveFile(String): Update save file.


B.T.W, Why safe?: It's safe because it's uses not just text, it uses Serializable text.
<br>With this system, nobody can't change values in save file. It's possible to change values only from code.

## SafeConfig.
### First step: Import *void2d.SafeConfig*.
```java
import void2d.Window;
import void2d.SafeConfig; // <- Importing.

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Window Title.", 500, 500, false, false);

        window.showWindow();
    }
}
```

### Second step: Initialize new safe config.
```java
import void2d.Window;
import void2d.SafeConfig;

import java.io.IOException; // <- Need!

import java.util.HashMap; // <- Need!

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Window window = new Window("Window Title.", 500, 500, false, false);

        // New hashmap with data.
        HashMap<String, Object> dataToSave = new HashMap<>();

        // Add data.
        dataToSave.put("x", 5);
        dataToSave.put("y", 5);

        // Initialize save.
        SafeConfig newCfg = new SafeConfig(dataToSave, "cfg.cfg");

        // Load save.
        HashMap<String, Object> cfgOutput = SafeConfig.loadConfig("cfg.cfg");

        // If failed to load save (save not found).
        if(SafeConfig.failedToLoad(cfgOutput)) {
            System.out.println("Config don't found. Saving...");

            newCfg.saveConfig();
        // Save found.
        } else {
            System.out.println("Save found!");

            System.out.printf("X, Y: %d, %d%n", cfgOutput.get("x"), cfgOutput.get("y"));
        }

        window.showWindow();
    }
}
```

- First Argument: Data to save.
- Second Argument: Save to.

Done!

Now you learned SAFE configs!

B.T.W, Why safe?: It's safe because it's uses not just text, it uses Serializable text.
<br>With this system, nobody can't change values in save file. It's possible to change values only from code.

There is no too much of difference between SafeSave and SaveConfig.<br>
SafeConfig created only for better readability.<br>

#### Message.
You completed this chapter, now you can go to "Ray.md".
<br>Good luck!
