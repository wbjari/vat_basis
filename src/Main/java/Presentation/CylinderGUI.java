package Presentation;

import Domain.Cylinder;
import Domain.Shape;
import javax.swing.*;
import java.awt.*;

public class CylinderGUI extends ShapeGUI {

	private JLabel radiusLabel;
	private JTextField radiusField;
	private JLabel heightLabel;
	private JTextField heightField;

	/**
	 * Displaylayout for Cylinder use GridBagConstraints for textfield and buttons.
	 * @param shape
	 * @param overviewGUI
	 */

	public CylinderGUI(Cylinder shape, OverviewGUI overviewGUI) {
		super(shape, overviewGUI);

		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.gridx = 0; //bepaal startplaats x-as
		gbc.gridy = 0; //bepaal startplaats y-as

		radiusLabel = new JLabel("Radius");
		add(radiusLabel, gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 2;
		radiusField = new JTextField();
		radiusField.setText(String.format("%.2f", shape.getRadius()));
		add(radiusField, gbc);

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
	 * Try and Catch with NumberFormatException to choose another value then 0.0 error message foreground color RED.
	 * @return
	 */
	@Override
	public Shape toShape() {

		try {
			((Cylinder) this.shape).setRadius(Double.parseDouble(radiusField.getText().replace(',', '.')));


			if (((Cylinder) this.shape).getRadius() == 0.0) {
				radiusLabel.setForeground(Color.RED);
				return null;
			}

		} catch (NumberFormatException exeption) {
			radiusLabel.setForeground(Color.RED);
			return null;
		}

		try {
			((Cylinder) this.shape).setHeight(Double.parseDouble(heightField.getText().replace(',', '.')));

			if (((Cylinder) this.shape).getHeight() == 0.0) {
				heightLabel.setForeground(Color.RED);
				return null;
			}
		} catch (NumberFormatException exeption) {
			heightLabel.setForeground(Color.RED);
			return null;
		}
		return this.shape;
	}
}