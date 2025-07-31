package wipro;

public class Wipro_36 {

    static class Tank {
        private boolean isFilled;
        private boolean isReleased;

        public Tank() {
            isFilled = false;
            isReleased = false;
            System.out.println("Tank created.");
        }

        public void fill() {
            isFilled = true;
            System.out.println("Tank filled.");
        }

        public void empty() {
            if (isFilled) {
                isFilled = false;
                System.out.println("Tank emptied.");
            } else {
                System.out.println("Tank is already empty.");
            }
        }

        public void releaseTank() {
            if (!isReleased) {
                isReleased = true;
                System.out.println("Tank resources released.");
            }
        }

        @Override
        protected void finalize() throws Throwable {
            try {
                if (!isReleased) {
                    System.out.println("Error: Tank not released before garbage collection!");
                } else {
                    System.out.println("Tank cleaned up properly.");
                }
            } finally {
                super.finalize();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Scenario 1: Proper cleanup ===");
        Tank t1 = new Tank();
        t1.fill();
        t1.empty();
        t1.releaseTank();
        t1 = null;

        System.out.println("\n=== Scenario 2: Forgetting cleanup ===");
        Tank t2 = new Tank();
        t2.fill();
        t2.empty();
        // Forgot to call t2.releaseTank()
        t2 = null;

        // Request JVM to run GC
        System.gc();

        // Pause to allow finalize() to run
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
/*=== Scenario 1: Proper cleanup ===
Tank created.
Tank filled.
Tank emptied.
Tank resources released.

=== Scenario 2: Forgetting cleanup ===
Tank created.
Tank filled.
Tank emptied.
Error: Tank not released before garbage collection!
Tank cleaned up properly.
*/