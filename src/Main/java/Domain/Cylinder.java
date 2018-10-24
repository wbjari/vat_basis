package Domain;

public class Cylinder extends Shape {


	private double radius;
	private double height;

	/**
	 * Constructor use the parameters from the shape Cylinder.
	 * @param radius
	 * @param height
	 */
	public Cylinder(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}

	/**
	 * Method getRadius
	 * @return
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * Method getHeight
	 * @return
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Method setRadius
	 * @param radius
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/**
	 * Method setHeight
	 * @param height
	 */
	public void setHeight(double height){
		this.height = height;
	}

	/**
	 * Method toString to return String.format for calculateVolume.
	 * @return
	 */
	public String toString() {
		return this.getType() + " " + this.getRadius() + " " + this.getHeight() + " (" + String.format("%.2f", this.calculateVolume()) + ")";
	}

	/**
	 * Method calculateVolume
	 * @return
	 */
	@Override
	public double calculateVolume() {
		// TODO - implement Cylinder.calculateVolume
		return Math.PI * Math.pow(this.radius, 2) * this.height;
	}
}