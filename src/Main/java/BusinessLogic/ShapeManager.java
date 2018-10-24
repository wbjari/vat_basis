package BusinessLogic;

import Datastorage.DatabaseDAO;
import Datastorage.FileShapeDAO;
import Datastorage.ShapeDAO;
import Domain.Shape;

import java.io.File;
import java.util.ArrayList;

public class ShapeManager {
    private ArrayList<String> shapeTypes;
    private ArrayList<Shape> shapes;
    private ShapeDAO shapeDao;

    /**
     * Constructor for shapes make a new ArrayList<Shape>
     */
    public ShapeManager() {
        this.shapes = new ArrayList<Shape>();
    }

    /**
     * Method Save to shapeDao.
     */
    public void save() {
        this.shapeDao = new DatabaseDAO();
        this.shapeDao.save(this.shapes);
    }

    /**
     * Method Load from shapeDao.
     */
    public void load() {
        this.shapeDao = new DatabaseDAO();
        this.shapes = this.shapeDao.load();
    }

    /**
     * Method for delete shapes.
     * @param shape
     */
    public void delete(Shape shape) {
        this.shapes.remove(shape);

    }

    /**
     * Method to add Shapes.
     * @param shape
     */
    public void add(Shape shape) {
        this.shapes.add(shape);

       }

    /**
     *Method to exportShapes in FileShapeDao and Save the shapes.
     */
    public void exportShapes(File file) {
        this.shapeDao = new FileShapeDAO(file);
        this.shapeDao.save(this.shapes);
    }

    /**
     * Method to importShapes in FileShapeDao and Save the shapes.
     */
    public void importShapes(File file) {
        this.shapeDao = new FileShapeDAO(file);
        this.shapes = this.shapeDao.load();
    }

    //shapes.data

    /**
     * Method calculate TotalVolume from all the shapes.
     * @return
     */
    public double calculateTotalVolume() {
        double totalVolume = 0.0;
        for (Shape shape : this.shapes) {
            totalVolume += shape.calculateVolume();
        }
        return totalVolume;
    }

    /**
     *
     * @return
     */
    public ArrayList<Shape> getShapes() {
        return this.shapes;
    }


}

