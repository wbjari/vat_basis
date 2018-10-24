package Presentation;

import Domain.RectangularPrism;
import Domain.Shape;

import javax.swing.*;
import java.awt.*;


public class RectangularPrismGUI extends ShapeGUI {


    private JLabel lengthLabel;
    private JTextField lengthField;
    private JLabel heightLabel;
    private JTextField heightField;
    private JLabel widthLabel;
    private JTextField widthField;

    /**
     * Displaylayout for RectangularPrism use GridBagConstraints for textfield and buttons.
     * @param shape
     * @param overviewGUI
     */
    public RectangularPrismGUI(RectangularPrism shape, OverviewGUI overviewGUI) {
        super(shape, overviewGUI);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.gridx = 0; //bepaal startplaats x-as
        gbc.gridy = 0; //bepaal startplaats y-as

        lengthLabel = new JLabel("Length");
        add(lengthLabel, gbc);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        lengthField = new JTextField();
        lengthField.setText(String.format("%.2f", shape.getLength()));
        add(lengthField, gbc);

        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.insets = new Insets(0, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        heightLabel = new JLabel("Height");
        add(heightLabel, gbc);

        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.insets = new Insets(0, 10, 10, 10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        heightField = new JTextField();
        heightField.setText(String.format("%.2f", shape.getHeight()));
        add(heightField, gbc);

        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.insets = new Insets(0, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        widthLabel = new JLabel("Width");
        add(widthLabel, gbc);

        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.insets = new Insets(0, 10, 10, 10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        widthField = new JTextField();
        widthField.setText(String.format("%.2f", shape.getWidth()));
        add(widthField, gbc);

        ShapeButtonHandler buttonHandler = new ShapeButtonHandler();

        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.insets = new Insets(0, 10, 10, 10);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(buttonHandler);
        add(cancelButton, gbc);

        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.insets = new Insets(0, 10, 10, 10);
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        okButton = new JButton("Save");
        okButton.addActionListener(buttonHandler);
        if (shape.getId() == 0) {
            okButton.setActionCommand("add");
        } else {
            okButton.setActionCommand("edit");
        }
        add(okButton, gbc);


    }

    /**
     *Try and Catch with NumberFormatException to choose another value then 0.0 error message foreground color RED.
     * @return
     */
    @Override
    public Shape toShape() {

        try {
            ((RectangularPrism) this.shape).setLength(Double.parseDouble(lengthField.getText().replace(',', '.')));
            if (((RectangularPrism) this.shape).getLength() == 0.0) {
                lengthField.setForeground(Color.RED);
                return null;
            }
        } catch (NumberFormatException exception) {
            lengthField.setForeground(Color.RED);
            return null;
        }

        try {
            ((RectangularPrism) this.shape).setWidth(Double.parseDouble(widthField.getText().replace(',', '.')));
            if (((RectangularPrism) this.shape).getWidth() == 0.0) {
                widthField.setForeground(Color.RED);
                return null;
            }
        } catch (NumberFormatException exception) {
            widthField.setForeground(Color.RED);
            return null;
        }

        try {
            ((RectangularPrism) this.shape).setHeight(Double.parseDouble(heightField.getText().replace(',', '.')));
            if (((RectangularPrism) this.shape).getHeight() == 0.0) {
                heightLabel.setForeground(Color.RED);
                return null;
            }
        } catch (NumberFormatException exception) {
            heightLabel.setForeground(Color.RED);
            return null;
        }
        return this.shape;
    }
}
