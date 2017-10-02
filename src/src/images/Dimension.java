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

    /**
     * Returns true if this Dimension collides with another
     */
    public boolean collidesWith(Dimension other) {
        return getEastCollision(this, other) &&
                getWestCollision(this, other) &&
                getSouthCollision(this, other) &&
                getNorthCollision(this, other);
    }

    private boolean getEastCollision(Dimension dimensionOfFirst, Dimension dimensionOfSecond) {
        return dimensionOfFirst.getPosition().getX() + dimensionOfFirst.getWidth()
                >= dimensionOfSecond.getPosition().getX();
    }

    private boolean getWestCollision(Dimension dimensionOfFirst, Dimension dimensionOfSecond) {
        return dimensionOfFirst.getPosition().getX()
                <= dimensionOfSecond.getPosition().getX() + dimensionOfSecond.getWidth();
    }

    private boolean getSouthCollision(Dimension dimensionOfFirst, Dimension dimensionOfSecond) {
        return dimensionOfFirst.getPosition().getY() + dimensionOfFirst.getHeight()
                >= dimensionOfSecond.getPosition().getY();
    }

    private boolean getNorthCollision(Dimension dimensionOfFirst, Dimension dimensionOfSecond) {
        return dimensionOfFirst.getPosition().getY()
                <= dimensionOfSecond.getPosition().getY() + dimensionOfSecond.getHeight();
    }

    /**
     * Implement Cloneable
     */
    public Dimension clone() {
        return new Dimension(position.clone(), width, height);
    }

    /**
     * Setter for the position
     */
    public void setPosition(Position newPosition) {
        position = newPosition;
    }

    // Getters
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
