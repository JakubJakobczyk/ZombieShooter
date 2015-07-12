package basic;

import main.Game;

class Update implements Runnable {
    private final int FPS = 60;
    private long targetTime = 1000 / FPS;
    private Game g;

    Update(Game g) {
        this.g = g;

    }

    public void run() {
        long start, elapsed, wait;
        while (Base.isGameRunning) {
            start = System.nanoTime();

            g.update();

            elapsed = System.nanoTime() - start;
            wait = targetTime - elapsed / 1000000;
            if (wait < 0) {
                System.err.println("Problem with timing at: " + System.nanoTime());
                wait = 0;
            }


            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
