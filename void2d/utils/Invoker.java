package void2d.utils;

import void2d.Void2DThread;

/**
 * Invoker Util.
 */
public class Invoker {
    /**
     * Invoke function.
     *
     * @param function Function.
     */
    public static void invoke(Runnable function) {
        function.run();
    }

    /**
     * Invoke function with duration.
     */
    public static void invokeWithDuration(Runnable function, long duration) {
        Void2DThread invokeThread = new Void2DThread(
            () -> {
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException interrupted_exc) {
                    System.out.println(interrupted_exc.getMessage());
                }

                invoke(function);
            }
        );

        invokeThread.run();
    }
}
