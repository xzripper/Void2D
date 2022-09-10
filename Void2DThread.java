// Void2DThread.java - Part of Void2D.

package void2d;

/**
 * <h1>Easy thread creation.</h1>
 * Add blocking function to thread, for making this function non-blocking.<br>
 * Also possible to pause execution with this class.
 */
public class Void2DThread {
    protected Thread thread;

    /**
     * Initialize new thread.
     *
     * @param function Target.
     */
    public Void2DThread(Runnable function) {
        thread = new Thread(function);
    }

    /**
     * Run thread.
     */
    public void run() {
        thread.start();
    }

    /**
     * Stop thread.
     */
    public void stop() {
        if(thread.isAlive()) {
            thread.interrupt();
        }
    }
}
