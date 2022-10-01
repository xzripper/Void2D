// UpdateLoop.java - Part of Void2D.

package void2d;

import javax.swing.Timer;

/**
 * <h1>Class for creating own update loop that can be applied to the window.</h1>
 * Something similar on a Timer.
 */
public class UpdateLoop {
    protected Timer updateLoop;

    /**
     * Update loop delay.
     */
    public int updateLoopDelay;

    /**
     * Initialize new update loop.
     *
     * @param toExecute Function to execute.
     * @param _updateLoopDelay Update loop delay.
     * @param autoRun Run loop when it will be created.
     */
    public UpdateLoop(Runnable toExecute, int _updateLoopDelay, boolean autoRun) {
        updateLoopDelay = _updateLoopDelay;

        updateLoop = new Timer(
            _updateLoopDelay,

            (event) -> {
                toExecute.run();
            }
        );

        if(autoRun) {
            runLoop();
        }
    }

    /**
     * Update loop delay.
     *
     * @param newUpdateLoopDelay New delay.
     */
    public void updateLoopDelay(int newUpdateLoopDelay) {
        updateLoopDelay = newUpdateLoopDelay;

        updateLoop.setDelay(newUpdateLoopDelay);
    }

    /**
     * Run update loop.
     */
    public void runLoop() {
        updateLoop.start();
    }

    /**
     * Stop update loop.
     */
    public void stopLoop() {
        updateLoop.stop();
    }
}
