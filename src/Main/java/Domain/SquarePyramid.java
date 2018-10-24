package Domain;

public class SquarePyramid extends Shape{
	private double length;
	private double height;

	/**
	 * Constructor use the parameters from the shape SquarePyramid.
	 * @param length
	 * @param height
	 */
	public SquarePyramid(double length, double height) {
		this.length = length;
		this.height = height;
	}

	/**
	 * Method getLength
	 * @return
	 */
	public double getLength() {
		return this.length;
	}

	/**
	 * Method setLength
	 * @param length
	 */
	public void setLength(double length) {
		this.length = length;
	}

	/**
	 * Method getHeight
	 * @return
	 */
	public double getHeight() {
		return this.height;
	}

	/**
	 * Method setHeight
	 * @param height
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * Method toString to return String.format for calculateVolume.
	 * @return
	 */
	public String toString() {
		return this.getType() + " " + this.getLength() + " " + this.getHeight() + " (" + String.format("%.2f", this.calculateVolume()) + ")";
	}

	/**
	 * Method calculateVolume
	 * @return
	 */
	@Override
	public double calculateVolume() {
		// TODO - implement SquarePyramid.calculateVolume
		return Math.pow(this.length, 2) * this.height / 3;
		//throw new UnsupportedOperationException();
	}



}