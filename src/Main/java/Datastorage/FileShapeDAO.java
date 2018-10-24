package Datastorage;

import Domain.*;

import java.io.*;
import java.util.ArrayList;


public class FileShapeDAO implements ShapeDAO {
    private String fileType;
    private File file;
    private String CSVDelimiter = ";";
    private ArrayList<Shape> shapes;

    /**
     * @param fileName
     */
    public FileShapeDAO(File fileName) {


        this.file = fileName;
        this.fileType = FileShapeDAO.getFileExtension(this.file);

    }

    /**
     * @param file
     * @return
     */
    public static String getFileExtension(File file) {
        String extension = "";
        String s = file.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            extension = s.substring(i + 1).toLowerCase();
        }
        return extension;
    }

    /**
     * Switch between save to CSV or save to data  and other type get Default Message.
     * @param shapes
     */
    @Override
    public void save(ArrayList<Shape> shapes) {
        switch (this.fileType) {
            case "csv":
                this.saveToCSV(shapes);
                break;
            case "data":
                this.saveToData(shapes);
                break;
            default:
                System.out.println("File type " + this.fileType + " not supported by file data access object");
        }

    }

    /**
     * Switch between load to CSV or load to data  and other type get Default Message.
     * @return
     */
    public ArrayList<Shape> load() {
        this.shapes = new ArrayList<Shape>();
        switch (fileType) {
            case "csv":
                this.loadFromCSV();
                break;
            case "data":
                this.loadFromData();
                break;
            default:
                System.out.println("File type " + fileType + " not supported by file data access object");
        }
        return this.shapes;
    }

    /**
     * saves to CSV
     *
     * @param shapes
     * @return
     */
    public boolean saveToCSV(ArrayList<Shape> shapes) {
        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(this.file)));

            String line = "";
            for (Shape shape : shapes) {
                if (shape == null) ;
                double length = 0.0;
                double width = 0.0;
                double height = 0.0;
                double radius = 0.0;


                if (shape instanceof Cone) {
                    Cone cone = (Cone) shape;
                    line = shape.getId() + this.CSVDelimiter +
                            shape.getType() + this.CSVDelimiter +
                            length + this.CSVDelimiter +
                            cone.getHeight() + this.CSVDelimiter +
                            width + this.CSVDelimiter +
                            cone.getRadius() + this.CSVDelimiter;
                } else if (shape instanceof Cylinder) {
                    Cylinder cylinder = (Cylinder) shape;
                    line = shape.getId() + this.CSVDelimiter +
                            shape.getType() + this.CSVDelimiter +
                            length + this.CSVDelimiter +
                            cylinder.getHeight() + this.CSVDelimiter +
                            width + this.CSVDelimiter +
                            cylinder.getRadius() + this.CSVDelimiter;
                } else if (shape instanceof RectangularPrism) {
                    RectangularPrism rectangularprism = (RectangularPrism) shape;
                    line = shape.getId() + this.CSVDelimiter +
                            shape.getType() + this.CSVDelimiter +
                            rectangularprism.getLength() + this.CSVDelimiter +
                            rectangularprism.getHeight() + this.CSVDelimiter +
                            rectangularprism.getWidth() + this.CSVDelimiter +
                            radius + this.CSVDelimiter;
                } else if (shape instanceof Sphere) {
                    Sphere sphere = (Sphere) shape;
                    line = shape.getId() + this.CSVDelimiter +
                            shape.getType() + this.CSVDelimiter +
                            length + this.CSVDelimiter +
                            height + this.CSVDelimiter +
                            width + this.CSVDelimiter +
                            sphere.getRadius() + this.CSVDelimiter;
                } else if (shape instanceof SquarePyramid) {
                    SquarePyramid squarePyramid = (SquarePyramid) shape;
                    line = shape.getId() + this.CSVDelimiter +
                            shape.getType() + this.CSVDelimiter +
                            squarePyramid.getLength() + this.CSVDelimiter +
                            squarePyramid.getHeight() + this.CSVDelimiter +
                            width + this.CSVDelimiter +
                            radius + this.CSVDelimiter;
                }
                printWriter.println(line);

            }

            printWriter.close();
        } catch (FileNotFoundException exception) {
            System.out.println("File " + this.file + " not found.");
        } catch (IOException exception) {
            System.out.println("Unable to save CSV file.");
        }

        return true;
    }

    /**
     * @return
     */
    private boolean loadFromCSV() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.file));

            String line;

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(this.CSVDelimiter);

                if (columns.length != 6) {
                    System.out.println("Invalid data detected in given CSV file.");
                }

                Shape shape;

                switch (columns[1]) {
                    case "Sphere":
                        shape = new Sphere(Double.parseDouble(columns[5]));
                        shape.setId(Integer.parseInt(columns[0]));
                        this.shapes.add(shape);
                        break;
                    case "Cylinder":
                        shape = new Cylinder(Double.parseDouble(columns[5]), Double.parseDouble(columns[3]));
                        shape.setId(Integer.parseInt(columns[0]));
                        this.shapes.add(shape);
                        break;
                    case "Cone":
                        shape = new Cone(Double.parseDouble(columns[5]), Double.parseDouble(columns[3]));
                        shape.setId(Integer.parseInt(columns[0]));
                        this.shapes.add(shape);
                        break;
                    case "RectangularPrism":
                        shape = new RectangularPrism(
                                Double.parseDouble(columns[2]),
                                Double.parseDouble(columns[4]),
                                Double.parseDouble(columns[3])
                        );
                        shape.setId(Integer.parseInt(columns[0]));
                        this.shapes.add(shape);
                        break;
                    case "SquarePyramid":
                        shape = new SquarePyramid(Double.parseDouble(columns[3]), Double.parseDouble(columns[4]));
                        shape.setId(Integer.parseInt(columns[0]));
                        this.shapes.add(shape);
                        break;
                    default:
                        System.out.println("Invalid shape data in CSV file.");
                }
            }

            reader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("File " + this.file + " not found.");
        } catch (IOException exception) {
            System.out.println("Unable to load from data file.");
        }
        return true;
    }

    /**
     * @param shapes
     * @return
     */
    private boolean saveToData(ArrayList<Shape> shapes) {
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(this.file));

            for (Shape shape : shapes) {
                stream.writeObject(shape);
            }

            stream.close();
        } catch (FileNotFoundException exception) {
            System.out.println("File " + this.file + " not found.");
        } catch (IOException exception) {
            System.out.println("Unable to save data file.");
        }
        return true;
    }

    /**
     * Load shapes from a binary object stream file and put them into a list.
     *
     * @return boolean
     */
    private boolean loadFromData() {
        ObjectInputStream stream;
        try {
            stream = new ObjectInputStream(new FileInputStream(this.file));

            Shape shape;

            try {
                while ((shape = (Shape) stream.readObject()) != null) {
                    this.shapes.add(shape);
                }
            } catch (EOFException exception) {
                stream.close();
            }
        } catch (FileNotFoundException exception) {
            System.out.println("File " + this.file + " not found.");
        } catch (IOException exception) {
            System.out.println("Unable to load from data file.");
        } catch (ClassNotFoundException exception) {
            System.out.println("Invalid data found in given file.");
        }
        return true;
    }

    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

}
