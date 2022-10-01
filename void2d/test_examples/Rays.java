// Simple example, how to use rays.

package void2d.test_examples;

import void2d.Window;

import void2d.Sprite;

import void2d.Ray;

import javax.swing.JComponent;

public class Rays {
    public static void main(String[] args) {
        Window window = new Window(
            null,
            1000,
            500,
            true,
            false
        );

        Sprite sprite = new Sprite(
            window,
            "src\\void2d\\test_examples\\res\\player.png",
            new int[] {0, 0},
            null
        );

        sprite.setSpriteSizeByImageSize();
        sprite.addSprite();

        Sprite ball = new Sprite(
            window,
            "src\\void2d\\test_examples\\res\\redball.png",
            new int[] {800, 0},
            null
        );

        ball.setSpriteSizeByImageSize();
        ball.addSprite();

        ball.sprite.setName("Second ball!");

        Sprite ball2 = new Sprite(
            window,
            "src\\void2d\\test_examples\\res\\redball.png",
            new int[] {400, 0},
            null
        );

        ball2.setSpriteSizeByImageSize();
        ball2.addSprite();

        ball2.sprite.setName("First ball!");

        Ray myBullet = new Ray(new int[] {0, 0}, new int[] {10, 1}, 500);

        myBullet.registerCollidableGameObject(ball.sprite);
        myBullet.registerCollidableGameObject(ball2.sprite);

        myBullet.cast(
            (gameObject, rayPos) -> {
                System.out.println(String.format("Ray hit the game object with name (%s) at position (%d, %d).", gameObject.getName(), rayPos[0], rayPos[1]));
            },

            false,
            new JComponent[] {ball.sprite}
        );

        window.showWindow();
    }
}
