package void2d.test_examples;

import void2d.Window;

import void2d.Sprite;

import void2d.VisualizedRay;

import javax.swing.JComponent;

public class VisualizedRays {
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

        Sprite bulletSprite = new Sprite(window, "src\\void2d\\test_examples\\res\\box.png", new int[] {25, 15}, new int[] {25, 15});
        bulletSprite.addSprite();

        VisualizedRay myBullet = new VisualizedRay(
            bulletSprite,
            new int[] {0, 15},
            new int[] {25, 15},
            70);

        myBullet.registerCollidableGameObject(ball.sprite);
        myBullet.registerCollidableGameObject(ball2.sprite);

        myBullet.castVisualized(
            (gameObject, rayPos) -> {
                System.out.println(String.format("Ray hit the game object with name (%s) at position (%d, %d). ", gameObject.getName(), rayPos[0], rayPos[1]));
            },

            true,
            new JComponent[] {ball.sprite}
        );

        window.showWindow();
    }
}
