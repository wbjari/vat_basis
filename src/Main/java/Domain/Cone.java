package Domain;

public class Cone extends Shape {
    private double radius;
    private double height;

    /**
     * Constructor use the parameters from the shape Cone.
     * @param radius
     * @param height
     */
    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    /**
     * Method getHeight
     *
     * @return
     */

    public double getHeight() {
        return height;
    }

    /**
     * Method getRadius
     *
     * @return
     */

    public double getRadius() {
        return radius;
    }

    /**
     * Method setHeight
     *
     * @param height
     */

    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Method set Radius
     *
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
        return this.getType() + " " + this.getRadius() + " " + this.getHeight() + " (" + String.format("%.2f", this.calculateVolume()) + ")";
    }

    /**
     * Method CalculateVolume
     *
     * @return
     */
    @Override
    public double calculateVolume() {
        return Math.PI * Math.pow(this.radius, 2) * (this.height/ 3.0);
    }
}