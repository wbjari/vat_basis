package Domain;

public class Sphere extends Shape {
	private double radius;

	/**
	 * Constructor use the parameters from the shape Sphere.
	 * @param radius
	 */
	public Sphere(double radius) {
		this.radius = radius;
	}

	/**
	 * Method getRadius
	 * @return
	 */
	public double getRadius() {
		return this.radius;
	}

	/**
	 * Method setRadius
	 * @param radius
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/**
	 * Method toString to return String.format for calculateVolume.
	 * @return
	 */
	public String toString() {
		return this.getType() + " " + this.getRadius() + " (" + String.format("%.2f", this.calculateVolume()) + ")";
	}

	/**
	 * Method calculateVolume
	 * @return
	 */
	@Override
	public double calculateVolume() {
		// TODO - implement Sphere.calculateVolume
		return (4.0 / 3.0) * Math.PI * Math.pow(this.radius, 3);
	}
}

