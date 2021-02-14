package penguine.game.model;

import java.util.Observable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import penguine.game.base.Drawable;
import penguine.game.base.Measurable;
import penguine.game.base.Movable;
import penguine.game.base.Upgradeable;

/**
 *
 * @author Uellington Conceição
 */
public abstract class Entity extends Observable implements Drawable, Measurable, Movable, Upgradeable {

    protected Point2D origin;
    protected double x, y, width, height;

    public Entity(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.origin = new Point2D(x, y);
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public void move(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public abstract void update();

    @Override
    public final void render(GraphicsContext graphic) {
        graphic.save();
        this.renderHook(graphic);
        graphic.restore();
    }

    protected abstract void renderHook(GraphicsContext graphic);

    @Override
    public String toString() {
        return "entity: {point" + this.origin + "}";
    }
}
