// Simple example, how to use bodies!

package void2d.test_examples;

import void2d.Window;

import void2d.Colors;

import void2d.Sprite;

import void2d.ObjectPhysics;

import void2d.Body;

import void2d.Prop;

public class Bodies {
    public static void main(String[] args) {
        Window gameWindow = new Window(
            "Physic bodies showcase! (Physics Version: %f)".formatted(ObjectPhysics.PHYSICS_VERSION),
            884,
            800,
            true,
            false
        );

        gameWindow.setWindowBackground(new int[] {
            Colors.colorLightGray.getRed(),
            Colors.colorLightGray.getGreen(),
            Colors.colorLightGray.getBlue(),

            Colors.colorLightGray.getAlpha()
        });

        Sprite groundObject = new Sprite(
            gameWindow,
            "src\\void2d\\test_examples\\res\\blackground.png",
            new int[] {0, 625},
            null
        );

        groundObject.setSpriteSizeByImageSize();
        groundObject.addSprite();

        Sprite boxObject = new Sprite(
            gameWindow,
            "src\\void2d\\test_examples\\res\\box.png",
            new int[] {25, 5},
            null
        );

        boxObject.setSpriteSizeByImageSize();
        boxObject.addSprite();

        ObjectPhysics boxPhysics = new ObjectPhysics(
            boxObject.sprite,
            groundObject.sprite
        );

        boxPhysics.setBody(Body.SQUARE_BODY);

        boxPhysics.setObjectMass(150);

        boxPhysics.runHandlers(
            gameWindow,
            null,
            null
        );

        Sprite ballObject = new Sprite(
            gameWindow,
            "src\\void2d\\test_examples\\res\\redball.png",
            new int[] {500, 5},
            null
        );

        ballObject.setSpriteSizeByImageSize();
        ballObject.addSprite();

        ObjectPhysics ballPhysics = new ObjectPhysics(
            ballObject.sprite,
            groundObject.sprite
        );

        ballPhysics.setBody(Body.CIRCLE_BODY);

        ballPhysics.setObjectMass(250);

        ballPhysics.setBouncy(true);

        ballPhysics.addProp(new Prop(boxObject.sprite));

        ballPhysics.runHandlers(
            gameWindow,
            null,
            null
        );

        gameWindow.showWindow();
    }
}
