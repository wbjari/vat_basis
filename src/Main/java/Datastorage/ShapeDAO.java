package Datastorage;

import Domain.Shape;

import java.util.ArrayList;


public interface ShapeDAO {
    void save(ArrayList<Shape> shapes);

    ArrayList<Shape> load();
}