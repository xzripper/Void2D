// Simple example, how to write the simplest runner.

package void2d.test_examples;

import void2d.Window;
import void2d.Sprite;
import void2d.Colors;
import void2d.Keyboard;
import void2d.ObjectPhysics;
import void2d.Prop;
import void2d.ScreenSides;

import java.awt.event.KeyEvent;

import java.util.function.Consumer;

public class SimplestRunner {
    public static int playerMass = 100;

    public static int forwardSpeed = 10;
    public static int backSpeed = 10;

    public static int jumpPower = 200;
    public static int jumpSpeed = 5;

    public static void main(String[] args) {
        Window gameWindow = new Window(null, 884, 800, false, false);

        gameWindow.setWindowBackground(
            new int[] {
                Colors.colorCyan.getRed(),
                Colors.colorCyan.getGreen(),
                Colors.colorCyan.getBlue(),

                255
            }
        );

        Sprite player = new Sprite(gameWindow, "src\\void2d\\test_examples\\res\\player.png", new int[] {0, 0}, null);
        player.setSpriteSizeByImageSize();
        player.addSprite();

        Sprite anotherPlayer = new Sprite(gameWindow, "src\\void2d\\test_examples\\res\\player2.png", new int[] {400, 335}, null);
        anotherPlayer.setSpriteSizeByImageSize();
        anotherPlayer.addSprite();

        Sprite ground = new Sprite(gameWindow, "src\\void2d\\test_examples\\res\\ground.png", new int[] {0, 595}, null);
        ground.setSpriteSizeByImageSize();
        ground.addSprite();

        ObjectPhysics playerPhysics = new ObjectPhysics(player.sprite, ground.sprite);

        playerPhysics.setObjectMass(playerMass);

        Prop anotherPlayerProp = new Prop(anotherPlayer.sprite);

        anotherPlayerProp.setPropMass(100);
        anotherPlayerProp.setPropFrozen(false);

        playerPhysics.addProp(anotherPlayerProp);

        playerPhysics.runHandlers(gameWindow, SimplestRunner::onEnter, SimplestRunner::onExit);

        Keyboard keysHandler = new Keyboard(
            new Consumer[] {
                null,

                (key) -> {
                    if(!(player.isDestroyed())) {
                        if(key.equals(KeyEvent.VK_RIGHT)) {
                            player.updateSpritePosition(
                                player.sprite.getX() + forwardSpeed,
                                player.sprite.getY()
                            );

                        } else if(key.equals(KeyEvent.VK_LEFT)) {
                            player.updateSpritePosition(
                                player.sprite.getX() - backSpeed,
                                player.sprite.getY()
                            );

                        } else if(key.equals(KeyEvent.VK_SPACE)) {
                            if(playerPhysics.notInAir() || playerPhysics.intersectsAnyProp()) {
                                for(int i=1; i < jumpPower; i++) {
                                    player.updateSpritePosition(
                                        player.sprite.getX(),
                                        (int) (player.sprite.getY() - (ObjectPhysics.UPDATE * jumpSpeed))
                                    );
                                }
                            }
                        }
                    }
                },

                null
            }
        );

        keysHandler.addKeyboardHandler(gameWindow);

        gameWindow.showWindow();
    }

    public static void onEnter(ScreenSides side) {
        if(side == ScreenSides.LEFT) {
            forwardSpeed = 0;

        } else if(side == ScreenSides.RIGHT) {
            backSpeed = 0;
        }
    }

    public static void onExit() {
        forwardSpeed = 10;
    }
}
