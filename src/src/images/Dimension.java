package images;

/**
 * The Dimension of an image is its position, width and height
 *
 * @author Jérémie Beaudoin-Dion
 */
public class Dimension implements Cloneable {

    private Position position;
    private int width;
    private int height;

    public Dimension(Position position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public Dimension(int x, int y, int width, int height) {
        this.position = new Position(x, y);
        this.width = width;
        this.height = height;
    }

    public Dimension clone() {
        return new Dimension(position.clone(), width, height);
    }

    public void setPosition(Position newPosition) {
        position = newPosition;
    }

    public Position getPosition() {
        return position;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
