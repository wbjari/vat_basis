package Presentation;

import Domain.Shape;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this is abstract class from the classes ConeGUI, CylinderGUI, RectangularPrismGUI, SphereGUI, SquarePyramidGUI
 */
public abstract class ShapeGUI extends JPanel{
	protected Shape shape;
	protected JButton okButton;
	protected JButton cancelButton;
	private OverviewGUI overviewGUI;

	public ShapeGUI(Shape shape, OverviewGUI overviewGUI) {
		this.shape = shape;
		this.overviewGUI = overviewGUI;
	}

	/**
	 * This void to close does not close the whole application but only the Panel SwingUtilities.getWindowAncestor(this).dispose();
	 * This void will add the shape from the overviewGUI and close the panel.
	 */
	public void close() {
		SwingUtilities.getWindowAncestor(this).dispose();
	}

	abstract public Shape toShape();

	public class ShapeButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == okButton) {
				Shape shape = toShape();
				if (shape != null) {
					if (e.getActionCommand().equals("add")) {
						overviewGUI.getShapeManager().add(shape);
					}
					overviewGUI.refreshShapeList();
					close();
				}
			} else if (e.getSource() == cancelButton) {
				close();
			}
		}
	}
}