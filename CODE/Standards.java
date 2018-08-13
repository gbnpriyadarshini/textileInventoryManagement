import java.awt.*;
import javax.swing.*;

class Standards extends JPanel
{
	Standards()
	{
		designLayout();
		setVisible(true);
	}

	public void designLayout()
	{
		JPanel DisplayPanel;

		DisplayPanel = new JPanel();
		DisplayPanel.setLayout(new GridLayout(10,10));

		DisplayPanel.add(new JLabel("Raw fiber is considered in terms of kilograms(kgs). "));
		DisplayPanel.add(new JLabel("Chemicals and dye is considered in terms of liters(l). "));
		DisplayPanel.add(new JLabel("Cloth produced is considered in terms of bundles"));
		DisplayPanel.add(new JLabel("1 bundle of cloth = 10 meters"));
		DisplayPanel.add(new JLabel("RawMaterial Types - raw fiber , chemichals , dye."));
		DisplayPanel.add(new JLabel("Categories in raw fiber - cotton , silk , wool."));
		DisplayPanel.add(new JLabel("Categories in chemicals - preprocessing chemichal , dying chemichal , finishing chemical."));
		DisplayPanel.add(new JLabel("To produce one bundle of Cotton cloth it takes 40kgs of raw cotton, 5l of preprocessing chemical, 1l of dying chemichal, 3l of finishing chemichal and 1l of dye. "));
		DisplayPanel.add(new JLabel("To produce one bundle of Silk cloth it takes 15kgs of raw silk, 2l of preprocessing chemichal, 3l of dying chemical, 4l of finishing chemical and 2l of dye. "));
		DisplayPanel.add(new JLabel("To produce one bundle of Wool clothit takes 20kgs of raw wool, 3l of preprocessing chemical, 1.5l of dying chemical, 1l of finishing chemical and 3l og dye. "));

		add(DisplayPanel);
	}
}