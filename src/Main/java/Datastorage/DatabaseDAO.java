package Datastorage;

import Domain.*;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseDAO implements ShapeDAO {

    /**
     * //constructor Databaseconnection
     */
    public DatabaseDAO() {

    }

    /**
     * This is to open de Databaseconnection
     *
     * @return connection
     * catch means that if the connection failed the system
     */
    public Connection openConnection() {
        try {
            //Try to create a connection with the library database
            // localhost, root, password empty
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/vat", "root", "");


            return connection;
        } catch (SQLException event) {
            System.out.println(event);
            return null;
        }
    }

    /**
     * Check if an object is an instance of a specific class.
     * Get the objects and put them in to an ArrayList.
     * @param shapes
     */
    @Override
    public void save(ArrayList<Shape> shapes) {
        if (shapes.size() > 0) {
            this.truncate();
        }
        for (Shape shape : shapes) {
            if (shape == null) return;
            String name = shape.getType();
            int id = shape.getId();
            double length = 0.0;
            double width = 0.0;
            double height = 0.0;
            double radius = 0.0;
            if (shape instanceof Cone) {
                Cone cone = (Cone) shape;
                height = cone.getHeight();
                radius = cone.getRadius();
            } else if (shape instanceof Cylinder) {
                Cylinder cylinder = (Cylinder) shape;
                height = cylinder.getHeight();
                radius = cylinder.getRadius();
            } else if (shape instanceof RectangularPrism) {
                RectangularPrism rectangularprism = (RectangularPrism) shape;
                length = rectangularprism.getLength();
                width = rectangularprism.getWidth();
                height = rectangularprism.getHeight();
            } else if (shape instanceof Sphere) {
                Sphere sphere = (Sphere) shape;
                radius = sphere.getRadius();
            } else if (shape instanceof SquarePyramid) {
                SquarePyramid squarePyramid = (SquarePyramid) shape;
                length = squarePyramid.getLength();
                height = squarePyramid.getHeight();
            }
            /**
             * PrepareStatement for data injection.
             */
            String query = "INSERT INTO `shape`(`id`,`name`,`length`, `width`,`height`, `radius`) VALUES(?,?,?,?,?,?)";
            try {
                Connection conn = this.openConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, id);
                pstmt.setString(2, name);
                pstmt.setDouble(3, length);
                pstmt.setDouble(4, width);
                pstmt.setDouble(5, height);
                pstmt.setDouble(6, radius);

                pstmt.execute();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());

            }
        }
    }

    /**
     * Load list from the database in to an ArrayList.
     * @return
     */
    public ArrayList<Shape> load() {

        ArrayList<Shape> shapes = new ArrayList<Shape>();
        String query = "SELECT * from `shape`";
        try (Connection conn = this.openConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                switch (rs.getString("name")) {
                    case "Cone":
                        Cone cone = new Cone(rs.getDouble("radius"), rs.getDouble("height"));
                        cone.setId(rs.getInt("id"));
                        shapes.add(cone);
                        break;
                    case "Cylinder":
                        Cylinder cylinder = new Cylinder(rs.getDouble("radius"), rs.getDouble("height"));
                        cylinder.setId(rs.getInt("id"));
                        shapes.add(cylinder);
                        break;
                    case "RectangularPrism":
                        RectangularPrism rectangularPrism = new RectangularPrism(rs.getDouble("length"), rs.getDouble("width"), rs.getDouble("height"));
                        rectangularPrism.setId(rs.getInt("id"));
                        shapes.add(rectangularPrism);
                        break;
                    case "Sphere":
                        Sphere sphere = new Sphere(rs.getDouble("radius"));
                        sphere.setId(rs.getInt("id"));
                        shapes.add(sphere);
                        break;
                    case "SquarePyramid":
                        SquarePyramid squarePyramid = new SquarePyramid(rs.getDouble("length"), rs.getDouble("height"));
                        squarePyramid.setId(rs.getInt("id"));
                        shapes.add(squarePyramid);
                        break;

                }

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return shapes;

    }

    /**
     * If the program is closed, close the connection from the mysql database.
     */
    public void truncate() {
        String query = "DELETE FROM shape";
        try {
            Connection conn = this.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException ex) {

        }
    }

}
