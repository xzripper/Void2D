// Simple example, how to implement mouse handler.

package void2d.test_examples;

import void2d.Window;

import void2d.Sprite;

import void2d.Mouse;

public class MouseExample {
    public static void main(String[] args) {
        Window window = new Window(
            null,
            1000,
            1000,
            true,
            false
        );

        Sprite sprite = new Sprite(
            window,
            "src\\void2d\\test_examples\\res\\redball.png",
            new int[] {50, 50},
            null
        );

        sprite.setSpriteSizeByImageSize();
        sprite.addSprite();

        Mouse mouseHandler = new Mouse(
            new Runnable[] {
                () -> {
                    System.out.println("Did you clicked mouse?");
                },

                null
            },

            new Runnable[] {
                () -> {
                    System.out.println("Did you released the mouse?");
                },

                null
            },

            new Runnable[] {
                () -> {
                    System.out.println("Did you just pressed the mouse?");
                },

                null
            }
        );

        // You can also apply to window.
        mouseHandler.addMouseHandlerToObject(sprite.sprite);

        window.showWindow();
    }
}
