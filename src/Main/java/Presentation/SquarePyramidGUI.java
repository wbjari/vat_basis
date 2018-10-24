package Presentation;

import Domain.Shape;
import Domain.SquarePyramid;

import javax.swing.*;
import java.awt.*;

public class SquarePyramidGUI extends ShapeGUI {

	private JLabel heightLabel;
	private JLabel lengthLabel;
	private JTextField lengthField;
	private JTextField heightField;

	/**
	 * Displaylayout for SquarePyramid use GridBagConstraints for textfield and buttons.
	 * @param shape
	 * @param overviewGUI
	 */

	public SquarePyramidGUI(SquarePyramid shape, OverviewGUI overviewGUI) {
		super(shape, overviewGUI);

		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.gridx = 0; // Determine starting point x-axis
		gbc.gridy = 0; // Determine starting point y.axis

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
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.insets = new Insets(0, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.gridx = 0; // Determine starting point x-axis
		gbc.gridy = 1; // Determine starting point y.axis

		heightLabel = new JLabel("Height");

		add(heightLabel, gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 10, 10, 10);
		gbc.weightx = 1;
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
		cancelButton = new JButton(("Cancel"));
		cancelButton.addActionListener(buttonHandler);
		add(cancelButton, gbc);

		gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.insets = new Insets(0, 10, 10, 10);
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		okButton = new JButton("Save ");
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
			((SquarePyramid) this.shape).setLength(Double.parseDouble(lengthField.getText().replace(',', '.')));

			if (((SquarePyramid) this.shape).getLength() == 0.0) {
				lengthLabel.setForeground(Color.RED);
				return null;
			}
		} catch (NumberFormatException exception) {
			lengthLabel.setForeground(Color.RED);
			return null;
		}
		try {
			((SquarePyramid) this.shape).setHeight(Double.parseDouble(heightField.getText().replace(',', '.')));

			if (((SquarePyramid) this.shape).getHeight() == 0.0) {
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