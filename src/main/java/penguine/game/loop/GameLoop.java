package penguine.game.loop;

import penguine.game.model.Game;

/**
 *
 * @author Uellington Conceição
 * @version 0.1
 */
public class GameLoop implements Runnable {

    private final double FPS;
    private final double INTERVAL;
    private boolean isRunning;

    private Thread thread;
    private Game game;

    public GameLoop(Game game) {
        this(game, 60);
    }

    public GameLoop(Game game, double fps) {
        this.game = game;
        this.FPS = (fps <= 0) ? 1 : (fps > 120) ? 120 : fps;
        this.INTERVAL = 1000000000 / FPS;
        this.isRunning = false;
        this.game = game;
    }

    public synchronized void start() {
        if (this.thread == null) {
            this.isRunning = true;
            this.thread = new Thread(this);
            this.thread.setName(this.game.getName().toUpperCase() + "/LOOP");
            this.thread.setDaemon(true);
            this.thread.start();
        }
    }

    public synchronized void stop() {
        this.isRunning = false;
    }

    @Override
    public void run() {
        double delta = 0;
        long lastTime = System.nanoTime();

        long now;

        while (isRunning) {
            now = System.nanoTime();
            delta += (now - lastTime) / INTERVAL;
            lastTime = now;
            if (delta >= 1) {
                this.game.clear();
                this.game.update();
                delta--;
            }
        }
    }

}
