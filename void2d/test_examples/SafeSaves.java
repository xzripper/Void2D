// Simple example, how to implement SAFE saves to your game.

package void2d.test_examples;

import void2d.Window;
import void2d.Sprite;
import void2d.Keyboard;
import void2d.SafeSave;

import java.util.function.Consumer;

import java.awt.event.KeyEvent;

import java.util.HashMap;

import java.io.IOException;

public class SafeSaves {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Window gameWindow = new Window(null, 1000, 1000, false, false);

        Sprite sprite = new Sprite(gameWindow, "src\\void2d\\test_examples\\res\\sprite.png", new int[] {0, 0}, null);
        sprite.setSpriteSizeByImageSize();
        sprite.addSprite();

        HashMap<String, Object> oldSpritePositionsSave = SafeSave.loadData("src\\void2d\\save.dat");

        if(!(SafeSave.failedToLoad(oldSpritePositionsSave))) {
            int[] oldSpritePositions = new int[] {
                    (int) oldSpritePositionsSave.get("spriteX"),
                    (int) oldSpritePositionsSave.get("spriteY")
            };

            sprite.updateSpritePosition(oldSpritePositions[0], oldSpritePositions[1]);

            System.out.println("Found save, loading...");
        } else {
            System.out.println("Unable to load save, possible it's was deleted or not created.");
        }

        final int speed = 5;

        Keyboard keysHandler = new Keyboard(
                new Consumer[] {
                        null,
                        (key) -> {
                            if(key.equals(KeyEvent.VK_RIGHT)) {
                                sprite.updateSpritePosition(
                                    sprite.getSpritePosition()[0] + speed,
                                    sprite.getSpritePosition()[1]
                                );
                            } else if(key.equals(KeyEvent.VK_LEFT)) {
                                sprite.updateSpritePosition(
                                    sprite.getSpritePosition()[0] - speed,
                                    sprite.getSpritePosition()[1]
                                );
                            } else if(key.equals(KeyEvent.VK_F)) {
                                HashMap<String, Object> dataToSave = new HashMap<>();

                                dataToSave.put("spriteX", sprite.getSpritePosition()[0]);
                                dataToSave.put("spriteY", sprite.getSpritePosition()[1]);

                                SafeSave newSave = new SafeSave(dataToSave, "src\\void2d\\save.dat");

                                try {
                                    newSave.saveData();
                                } catch(IOException error) {
                                    System.out.println("Unable to save data.");
                                }

                                System.out.println("Data saved.");
                            }
                        },
                        null
                }
        );

        keysHandler.addKeyboardHandler(gameWindow);

        gameWindow.showWindow();
    }
}
