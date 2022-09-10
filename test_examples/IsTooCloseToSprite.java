// Simple example, how to implement "is sprite close to another sprite".

package void2d.test_examples;

import void2d.Window;
import void2d.Sprite;
import void2d.Keyboard;
import void2d.Distances;

import java.awt.event.KeyEvent;
import java.util.function.Consumer;

public class IsTooCloseToSprite {
    public static void main(String[] args) {
        Window gameWindow = new Window(null, 1000, 800, false, false);

        Sprite sprite = new Sprite(gameWindow, "src\\void2d\\test_examples\\res\\sprite.png", new int[] {0, 0}, null);
        sprite.setSpriteSizeByImageSize();
        sprite.addSprite();

        Sprite _sprite = new Sprite(gameWindow, "src\\void2d\\test_examples\\res\\sprite.png", new int[] {500, 0}, null);
        _sprite.setSpriteSizeByImageSize();
        _sprite.addSprite();

        final int speed = 10;

        gameWindow.updateWindowUpdateLoopListener(() -> {
            if(Distances.getXDistanceBetweenGameObjects(sprite.sprite, _sprite.sprite) <= Distances.tooClose) {
                System.out.println("Hey, you too close to me!");
            }
        });

        gameWindow.startWindowUpdateLoop();

        Keyboard keysHandler = new Keyboard(
            new Consumer[] {
                null,
                (key) -> {
                    if(!(sprite.isDestroyed())) {
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
                        }
                    }
                },
                null
            }
        );

        keysHandler.addKeyboardHandler(gameWindow);

        gameWindow.showWindow();
    }
}
