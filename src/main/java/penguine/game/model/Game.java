package penguine.game.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import penguine.game.base.Cleanable;
import penguine.game.base.Upgradeable;
import penguine.game.base.Measurable;

/**
 *
 * @author Uellington Conceição
 */
public abstract class Game implements Measurable, Upgradeable, Cleanable {

    private final String name;

    private final Canvas canvas;

    protected final double X;
    protected final double Y;

    protected final double MIN_X;
    protected final double MIN_Y;

    protected GraphicsContext graphic;

    public Game(String name) {
        this(name, 500, 500);
    }

    public Game(String name, double x, double y) {
        this(name, 0, 0, x, y);
    }

    public Game(String name, double minX, double minY, double x, double y) {
        this.name = name;
        this.MIN_X = minX;
        this.MIN_Y = minY;
        this.X = x;
        this.Y = y;
        this.canvas = new Canvas(X, Y);
        this.graphic = this.canvas.getGraphicsContext2D();
    }

    public final String getName() {
        return this.name;
    }

    public Canvas getCanvas() {
        return this.canvas;
    }

    @Override
    public double getX() {
        return this.X;
    }

    @Override
    public double getY() {
        return this.Y;
    }

    @Override
    public double getMinX() {
        return this.MIN_X;
    }

    @Override
    public double getMinY() {
        return this.MIN_Y;
    }

    @Override
    public abstract void update();

    @Override
    public final void clear() {
        this.graphic.setFill(Color.GREY);
        this.graphic.fillRect(MIN_X, MIN_Y, X, Y);
    }

}
