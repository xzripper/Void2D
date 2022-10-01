// PathArray.java - Part of Void2D.

package void2d.utils;

import void2d.UpdateLoop;

import void2d.enginePhysics.ObjectPhysics;

import javax.swing.JComponent;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Path array, allows you to create path's (as coordinates), and later move by them.
 */
public class PathArray {
    protected UpdateLoop smoothPathFinderCleaner;

    /**
     * Path array.
     */
    public int[][] pathArray;

    /**
     * Current path position.
     */
    public int pathPosition = 0;

    /**
     * Use pathfinder?
     */
    public boolean usePf = false;

    /**
     * Initialize path array.
     *
     * @param _pathArray Path array.
     */
    public PathArray(int[][] _pathArray) {
        pathArray = _pathArray;
    }

    /**
     * Move object by next path.
     *
     * @param object Object.
     */
    public void applyNextPath(JComponent object) {
        if(pathPosition >= pathArray.length - 1) {
            return;
        }

        if(usePf) {
            smoothPathFinder(
                new int[] {
                    pathArray[pathPosition][0],
                    pathArray[pathPosition][1]
                },

                object
            );

            return;
        }

        object.setLocation(
            pathArray[pathPosition][0],
            pathArray[pathPosition][1]
        );

        pathPosition++;
    }

    /**
     * Move object by previous path.
     *
     * @param object Object.
     */
    public void applyPreviousPath(JComponent object) {
        if(pathPosition <= 0) {
            return;
        }

        if(usePf) {
            smoothPathFinder(
                new int[] {
                    pathArray[pathPosition][0],
                    pathArray[pathPosition][1]
                },

                object
            );

            return;
        }

        object.setLocation(
            pathArray[pathPosition][0],
            pathArray[pathPosition][1]
        );

        pathPosition--;
    }

    /**
     * Move object by path index.
     *
     * @param object Object.
     * @param pathIndex Path index.
     */
    public void applyPath(JComponent object, int pathIndex) {
        if(pathIndex - 1 > pathArray.length - 1 || pathIndex < 0) {
            return;
        }

        pathPosition = pathIndex - 1;

        if(usePf) {
            smoothPathFinder(
                new int[] {
                    pathArray[pathPosition][0],
                    pathArray[pathPosition][1]
                },

                object
            );

            return;
        }

        object.setLocation(
            pathArray[pathPosition][0],
            pathArray[pathPosition][1]
        );
    }

    /**
     * Get path array.
     */
    public int[][] getPathArray() {
        return pathArray;
    }

    /**
     * Get current path position (index).
     */
    public int getPathPosition() {
        return pathPosition;
    }

    /**
     * Use pathfinder when moving via path's.
     *
     * @param _useP_F Use pathfinder?
     */
    public void setPathFinderUsing(boolean _useP_F) {
        usePf = _useP_F;
    }

    /**
     * Using pathfinder?
     */
    public boolean usingPathFinder() {
        return usePf;
    }

    // Void2D Smooth Path Finder.
    protected void smoothPathFinder(int[] target, JComponent object) {
        int objectX = object.getX();
        int objectY = object.getY();

        int targetX = target[0];
        int targetY = target[1];

        int objTargDistX = objectX - targetX;
        int objTargDistY = objectY - targetY;

        Runnable finderX;
        Runnable finderY;

        AtomicBoolean foundX = new AtomicBoolean(false);
        AtomicBoolean foundY = new AtomicBoolean(false);

        if(objTargDistX <= 0) {
            finderX = () -> {
                if(object.getX() <= targetX) {
                    object.setLocation(
                        object.getX() + (int) (ObjectPhysics.UPDATE * ObjectPhysics.DEFAULT_PHYSICS_UPDATE_DELAY),
                        object.getY()
                    );
                } else {
                    foundX.set(true);
                }
            };
        } else {
            finderX = () -> {
                if(object.getX() >= targetX) {
                    object.setLocation(
                        object.getX() - (int) (ObjectPhysics.UPDATE * ObjectPhysics.DEFAULT_PHYSICS_UPDATE_DELAY),
                        object.getY()
                    );
                } else {
                    foundX.set(true);
                }
            };
        }

        if(objTargDistY >= 0) {
            finderY = () -> {
                if(object.getY() >= targetY) {
                    object.setLocation(
                        object.getX(),
                        object.getY() - (int) (ObjectPhysics.UPDATE * ObjectPhysics.DEFAULT_PHYSICS_UPDATE_DELAY)
                    );
                } else {
                    foundY.set(true);
                }
            };
        } else {
            finderY = () -> {
                if(object.getY() <= targetY) {
                    object.setLocation(
                        object.getX(),
                        object.getY() + (int) (ObjectPhysics.UPDATE * ObjectPhysics.DEFAULT_PHYSICS_UPDATE_DELAY)
                    );
                } else {
                    foundY.set(true);
                }
            };
        }

        UpdateLoop smoothFinderXLoop = new UpdateLoop(finderX, ObjectPhysics.DEFAULT_PHYSICS_UPDATE_DELAY, true);
        UpdateLoop smoothFinderYLoop = new UpdateLoop(finderY, ObjectPhysics.DEFAULT_PHYSICS_UPDATE_DELAY, true);

        smoothPathFinderCleaner = new UpdateLoop(
            () -> {
                if(foundX.get()) { smoothFinderXLoop.stopLoop(); }
                if(foundY.get()) { smoothFinderYLoop.stopLoop(); }

                if(foundX.get() && foundY.get()) {
                    smoothPathFinderCleaner.stopLoop();
                }
            },

            ObjectPhysics.DEFAULT_PHYSICS_UPDATE_DELAY,
            true
        );
    }
}
