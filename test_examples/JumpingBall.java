// Simple example, how to make jumping ball!

package void2d.test_examples;

import void2d.Window;

import void2d.Colors;

import void2d.Sprite;

import void2d.enginePhysics.ObjectPhysics;

public class JumpingBall {
    public static void main(String[] args) {
        Window gameWindow = new Window(
            "Jumping Ball!",
            884,
            800,
            false,
            false
        );

        gameWindow.setWindowBackground(new int[] {
            Colors.colorCyan.getRed(),
            Colors.colorCyan.getGreen(),
            Colors.colorCyan.getBlue(),

            Colors.colorCyan.getAlpha()
        });

        Sprite groundObject = new Sprite(
            gameWindow,
            "src\\void2d\\test_examples\\res\\ground.png",
            new int[] {0, 595},
            null
        );

        groundObject.setSpriteSizeByImageSize();
        groundObject.addSprite();

        Sprite ballObject = new Sprite(
            gameWindow,
            "src\\void2d\\test_examples\\res\\redball.png",
            new int[] {350, 5},
            null
        );

        ballObject.setSpriteSizeByImageSize();
        ballObject.addSprite();

        int ballMass = 120;

        ObjectPhysics ballPhysics = new ObjectPhysics(
            ballObject.sprite,
            groundObject.sprite
        );

        ballPhysics.setObjectMass(ballMass);
        ballPhysics.setBouncy(true);

        ballPhysics.runHandlers(
            null,
            null
        );

        gameWindow.showWindow();
    }
}
