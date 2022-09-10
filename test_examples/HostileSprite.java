// Simple example, how to implement hostile sprites and at all sprites.

package void2d.test_examples;

import void2d.Window;
import void2d.Sprite;
import void2d.Keyboard;
import void2d.UpdateLoop;

import java.util.function.Consumer;

import java.awt.event.KeyEvent;

public class HostileSprite {
    public static void main(String[] args) {
        Window gameWindow = new Window(null, 1000, 1000, false, false);

        Sprite player = new Sprite(gameWindow, "src\\void2d\\test_examples\\res\\sprite.png", new int[] {0, 0}, null);
        player.setSpriteSizeByImageSize();
        player.addSprite();

        Sprite hostile_sprite = new Sprite(gameWindow, "src\\void2d\\test_examples\\res\\sprite.png", new int[] {gameWindow.getWindowSize()[0] / 2, 0}, null);
        hostile_sprite.setSpriteSizeByImageSize();
        hostile_sprite.addSprite();

        UpdateLoop collisionCheckLoop = new UpdateLoop(
            () -> {
                if(!(player.isDestroyed())) {
                    if(player.spriteCollision.intersects(hostile_sprite.sprite)) {
                        System.out.println("Seems hostile sprite killed you!");

                        player.destroy();
                    }
                }
            },

            0,
            true
        );

        final int speed = 5;

        Keyboard keysHandler = new Keyboard(
            new Consumer[] {
                null,
                (key) -> {
                    if(!(player.isDestroyed())) {
                        if(key.equals(KeyEvent.VK_RIGHT)) {
                            player.updateSpritePosition(
                                player.getSpritePosition()[0] + speed,
                                player.getSpritePosition()[1]
                            );
                        } else if(key.equals(KeyEvent.VK_LEFT)) {
                            player.updateSpritePosition(
                                player.getSpritePosition()[0] - speed,
                                player.getSpritePosition()[1]
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
