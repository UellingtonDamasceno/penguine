package penguine.game.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
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

    protected final double WIDHT;
    protected final double HEIGHT;

    protected final double X;
    protected final double Y;

    protected GraphicsContext graphic;
    private Paint defaultColor;

    public Game(String name, double width, double height) {
        this(name, width, height, Color.BLACK);
    }

    public Game(String name, double width, double height, Paint color) {
        this(name, 0, 0, width, height, color);
    }

    public Game(String name, double x, double y, double widht, double height, Paint color) {
        this.name = name;
        this.X = x;
        this.Y = y;
        this.WIDHT = widht;
        this.HEIGHT = height;
        this.defaultColor = color;
        this.canvas = new Canvas(WIDHT, HEIGHT);
        this.graphic = this.canvas.getGraphicsContext2D();
    }

    public final String getName() {
        return this.name;
    }

    public Canvas getCanvas() {
        return this.canvas;
    }

    @Override
    public double getWidth() {
        return this.WIDHT;
    }

    @Override
    public double getHeight() {
        return this.HEIGHT;
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
    public abstract void update();

    @Override
    public final void clear() {
        this.graphic.setFill(defaultColor);
        this.graphic.fillRect(X, Y, WIDHT, HEIGHT);
    }

}
