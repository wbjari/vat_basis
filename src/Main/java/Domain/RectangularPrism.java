package Domain;

public class RectangularPrism extends Shape {

	private double length;
	private double height;
	private double width;

	/**
	 * Constructor use the parameters from the shape RectangularPrism.
	 * @param length
	 * @param width
	 * @param height
	 */
	public RectangularPrism(double length, double width, double height) {
		this.length = length;
		this.height = height;
		this.width = width;
	}

	/**
	 * Method getLength
	 * @return
	 */
	public double getLength() {
		return length;
	}

	/**
	 * Method getHeight
	 * @return
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Method getWidth
	 * @return
	 */
	public double getWidth() {
		return width;
	}


	/**
	 * Method setLength
	 * @param length
	 */
	public void setLength(double length) {
		this.length = length;
	}

	/**
	 * Method setHeight
	 * @param height
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * Method setWidth
	 * @param width
	 */
	public void setWidth(double width) {
		this.width = width;
	}


	/**
	 * Method toString to return String.format for calculateVolume.
	 * @return
	 */
	public String toString(){
		return this.getType() + " " + this.getLength() + " " + this.height + " " + this.width + " (" + String.format("%.2f", this.calculateVolume()) + ")";
	}

	/**
	 * Method calculateVolume
	 * @return
	 */
	@Override
	public double calculateVolume() {

		return length * width * height;
	}
}
