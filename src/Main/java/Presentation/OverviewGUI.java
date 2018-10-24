package Presentation;


import BusinessLogic.ShapeManager;
import Domain.*;
import Domain.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


public class OverviewGUI extends JPanel {


    private JLabel shapeLabel;
    private JComboBox<String> shapeSelectorField;
    private JLabel totalVolumeLabel;
    private JTextField totalVolumeField;
    private JScrollPane shapeListField;
    private JList<Shape> shapeList;
    private JButton totalVolumeButton;
    private JButton addButton;
    private JButton deleteButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton editButton;
    private JButton importButton;
    private JButton exportButton;
    private ShapeManager shapeManager;


    GridBagConstraints gbc = new GridBagConstraints();

    /**
     * The overviewGUI communicate with the shapeManager.
     *
     * @param shapeManager
     */
    public OverviewGUI(ShapeManager shapeManager) {
        this.shapeManager = shapeManager;
        setLayout(new GridBagLayout());


        GridBagConstraints gbc = new GridBagConstraints();
        //align uiteinden

        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1;
        gbc.gridx = 0; //bepaal startplaats x-as
        gbc.gridy = 0; //bepaal startplaats y-as
        shapeLabel = new JLabel("Shape");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(shapeLabel, gbc);

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        shapeSelectorField = new JComboBox<String>();

        this.shapeSelectorField.addItem("Sphere");
        this.shapeSelectorField.addItem("Cylinder");
        this.shapeSelectorField.addItem("Cone");
        this.shapeSelectorField.addItem("RectangularPrism");
        this.shapeSelectorField.addItem("SquarePyramid");
        add(shapeSelectorField, gbc);

        gbc.weightx = 1;
        gbc.insets = new Insets(10, 10, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        totalVolumeLabel = new JLabel("Total Volume");
        add(totalVolumeLabel, gbc);


        gbc.weightx = 1;
        gbc.insets = new Insets(20, 10, 10, 0);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        totalVolumeField = new JTextField();
        totalVolumeField.setEditable(false);
        add(totalVolumeField, gbc);


        gbc.weightx = 1;
        gbc.insets = new Insets(20, 10, 0, 10);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        shapeList = new JList(this.shapeManager.getShapes().toArray());
        shapeListField = new JScrollPane(shapeList);
        add(shapeListField, gbc);


        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.insets = new Insets(0, 10, 0, 0);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        totalVolumeButton = new JButton("Calculate Total Volume");
        totalVolumeButton.addActionListener(new OverviewButtonHandler(this));
        add(totalVolumeButton, gbc);


        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(10, 10, 0, 0);
        gbc.gridx = 1;
        gbc.gridy = 4;
        deleteButton = new JButton("Delete Shape");
        deleteButton.addActionListener(new OverviewButtonHandler(this));
        add(deleteButton, gbc);


        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(10, 10, 10, 0);
        gbc.gridx = 2;
        gbc.gridy = 5;
        saveButton = new JButton("Save Shape");
        saveButton.addActionListener(new OverviewButtonHandler(this));
        add(saveButton, gbc);


        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(10, 10, 0, 0);
        gbc.gridx = 2;
        gbc.gridy = 4;
        loadButton = new JButton("Load Shapes");
        loadButton.addActionListener(new OverviewButtonHandler(this));
        add(loadButton, gbc);


        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(-30, 10, 0, 0);
        gbc.gridx = 1;
        gbc.gridy = 3;
        addButton = new JButton("Add Shape");
        addButton.addActionListener(new OverviewButtonHandler(this));
        add(addButton, gbc);


        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(45, 10, 0, 0);
        gbc.gridx = 1;
        gbc.gridy = 3;
        editButton = new JButton("Edit Shape");
        editButton.addActionListener(new OverviewButtonHandler(this));
        add(editButton, gbc);


        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(10, 10, 0, 10);
        gbc.gridx = 3;
        gbc.gridy = 4;
        importButton = new JButton("Import Shapes");
        importButton.addActionListener(new OverviewButtonHandler(this));
        add(importButton, gbc);


        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 3;
        gbc.gridy = 5;
        exportButton = new JButton("Export shapes");
        exportButton.addActionListener(new OverviewButtonHandler(this));
        add(exportButton, gbc);


    }

    /**
     *
     * @return
     */
    public ShapeManager getShapeManager() {
        return shapeManager;
    }

    /**
     *
     */
    public void refreshShapeList() {
        this.shapeList.setListData(new Vector<>(this.shapeManager.getShapes()));
    }

    public class OverviewButtonHandler implements ActionListener {
        private OverviewGUI overviewGUI;

        /**
         * List from the buttons in the overviewGUI
         * @param overviewGUI
         */
        public OverviewButtonHandler(OverviewGUI overviewGUI) {
            this.overviewGUI = overviewGUI;
        }

        /**
         * Get the selected list frome the shapes and give the buttons action to the ShapeManager
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == deleteButton) {
                shapeManager.delete(shapeList.getSelectedValue());
                refreshShapeList();
            }
            if (e.getSource() == saveButton) {
                shapeManager.save();
            }
            if (e.getSource() == loadButton) {
                shapeManager.load();
                refreshShapeList();
            }
            if (e.getSource() == totalVolumeButton) {
                totalVolumeField.setText(String.format("%.2f", shapeManager.calculateTotalVolume()));
            }
            if (e.getSource() == addButton) {
                String shapeType = shapeSelectorField.getSelectedItem().toString();
                Frame frame = new Frame(shapeType);

                System.out.println(shapeType);
                switch (shapeType) {
                    case "Sphere":
                        frame.addPanel(new SphereGui(new Sphere(0.0), this.overviewGUI));
                        break;
                    case "Cone":
                        frame.addPanel(new ConeGUI(new Cone(0.0, 0.0), this.overviewGUI));
                        break;
                    case "RectangularPrism":
                        frame.addPanel(new RectangularPrismGUI(new RectangularPrism(0.0, 0.0, 0.0), this.overviewGUI));
                        break;
                    case "Cylinder":
                        frame.addPanel(new CylinderGUI(new Cylinder(0.0, 0.0), this.overviewGUI));
                        break;
                    case "SquarePyramid":
                        frame.addPanel(new SquarePyramidGUI(new SquarePyramid(0.0, 0.0), this.overviewGUI));
                        break;
                }

                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }

            if (e.getSource() == editButton) {

                /**
                 * Get selected value and open the panels from subclassesGUI.
                 */

                Shape shape = shapeList.getSelectedValue();
                if (shape != null) {
                    Frame frame = new Frame(shape.getType());


                    switch (shape.getType()) {
                        case "Sphere":
                            frame.addPanel(new SphereGui((Sphere) shape, this.overviewGUI));
                            break;
                        case "Cone":
                            frame.addPanel(new ConeGUI((Cone) shape, this.overviewGUI));
                            break;
                        case "RectangularPrism":
                            frame.addPanel(new RectangularPrismGUI((RectangularPrism) shape, this.overviewGUI));
                            break;
                        case "Cylinder":
                            frame.addPanel(new CylinderGUI((Cylinder) shape, this.overviewGUI));
                            break;
                        case "SquarePyramidGUI":
                            frame.addPanel(new SquarePyramidGUI((SquarePyramid) shape, this.overviewGUI));
                            break;

                    }

                }

            }

            if (e.getSource() == exportButton || e.getSource() == importButton) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                int returnValue = fileChooser.showOpenDialog(this.overviewGUI);

                if (returnValue != JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(null,"No file selected");
                    return;
                }

                if (e.getSource() == exportButton) {
                    shapeManager.exportShapes(fileChooser.getSelectedFile());
                }

                if (e.getSource() == importButton) {
                    shapeManager.importShapes(fileChooser.getSelectedFile());
                    refreshShapeList();
                }
            }
        }
    }
}


