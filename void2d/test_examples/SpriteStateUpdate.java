// Simple example, how to update sprite states.

package void2d.test_examples;

import void2d.Window;

import void2d.Sprite;

import void2d.Keyboard;

import java.awt.event.KeyEvent;

import java.util.function.Consumer;

public class SpriteStateUpdate {
    public static void main(String[] args) {
        Window window = new Window(
            null,
            1000,
            1000,
            true,
            false
        );

        Sprite mySprite = new Sprite(
            window,
            "src\\void2d\\test_examples\\res\\player.png",
            new int[] {50, 50},
            null
        );

        mySprite.setSpriteSizeByImageSize();
        mySprite.addSprite();

        mySprite.appendSpriteState("playerSkinDefault", "src\\void2d\\test_examples\\res\\player.png");
        mySprite.appendSpriteState("playerSkinElf", "src\\void2d\\test_examples\\res\\player2.png");

        Keyboard skinChangingKeyboardHandler = new Keyboard(
            new Consumer[] {
                null,

                key -> {
                    if(key.equals(KeyEvent.VK_RIGHT)) {
                        mySprite.nextSpriteState();
                    } else if(key.equals(KeyEvent.VK_LEFT)) {
                        mySprite.previousSpriteState();
                    }
                },

                null
            }
        );

        skinChangingKeyboardHandler.addKeyboardHandler(window);

        window.showWindow();
    }
}
