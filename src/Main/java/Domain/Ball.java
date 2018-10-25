package Domain;

public class Ball extends Shape {

    private double diameter;

    /**
     * Constructor use the parameters from the shape RectangularPrism.
     * @param diameter
     */
    public Ball(double diameter) {
        this.diameter = diameter;
    }

    /**
     * Method getDiameter
     * @return
     */
    public double getDiameter() {
        return diameter;
    }

    /**
     * Method setDiameter
     * @param diameter
     */
    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    /**
     * Method toString to return String.format for calculateVolume.
     * @return
     */
    public String toString(){
        return this.getType() + " " + this.diameter + " (" + String.format("%.2f", this.calculateVolume()) + ")";
    }

    /**
     * Method calculateVolume
     * @return
     */
    @Override
    public double calculateVolume() {

        return (1/6) * Math.PI * Math.pow(this.diameter, 3);
    }
}
