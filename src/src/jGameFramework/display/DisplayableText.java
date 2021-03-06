package jGameFramework.display;

import jGameFramework.physicalObjects.PhysicalObject;
import jGameFramework.physicalObjects.Position;

import java.awt.*;

/**
 * A text is a String which can be show on the frame
 *
 * @author Jérémie Beaudoin-Dion
 */
public class DisplayableText extends Displayable {

	public enum Alignment {
		left, center, right
	}
	
	private String message;
	private Font font;
	private Paint paint;
	private Alignment alignment;

	/**
	 * Displayable text for specific position
	 */
	public DisplayableText(Position position, DisplayableDepth depth, String message, Font font, Paint paint,
                           Alignment alignment){
		super(position, new Position(font.getSize()/2 * message.length(), font.getSize()), depth);
		this.message = message;
		this.font = font;
		this.paint = paint;
		this.alignment = alignment;
	}

    /**
     * Displayable text from base object
     */
    public DisplayableText(PhysicalObject baseObject, Position cameraPosition, String message, Font font, Paint paint,
                           Alignment alignment){
        super(baseObject.getPositionAccordingToCamera(cameraPosition),
                new Position(font.getSize()/2 * message.length(), font.getSize()),
                baseObject.getDepth());
        this.message = message;
        this.font = font;
        this.paint = paint;
		this.alignment = alignment;
    }

	public String getMessage() {
		return message;
	}

	public Font getFont() {
		return font;
	}
	
	public Paint getPaint() {
		return paint;
	}

	public Alignment getAlignment() {
    	return alignment;
	}

}

