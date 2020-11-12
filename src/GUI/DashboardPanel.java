package GUI;

import java.awt.*;

import javax.swing.*;

public class DashboardPanel extends JPanel {
  public DashboardPanel(Dimension size, ApplicationView gui){
    this.setSize(size);
    this.setBackground(Color.YELLOW);

    JLabel userSelected = new JLabel(gui.getUser());
    this.add(userSelected);
  }
}
