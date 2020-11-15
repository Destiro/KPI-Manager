package GUI;

import java.awt.*;

import javax.swing.*;

public class DashboardPanel extends JPanel {
  private ApplicationView gui;
  public DashboardPanel(Dimension size, ApplicationView gui){
    //JPanel setup
    this.setBounds(1280/6, 0, size.width, size.height);
    this.setBackground(Color.YELLOW);
    this.setLayout(new BorderLayout());

    //Variables set
    this.gui = gui;
    setupDashboard();
  }

  public void setupDashboard(){
    //Creating Label
    JLabel userSelected = new JLabel(gui.getUser());
    userSelected.setFont(userSelected.getFont().deriveFont(24.0f));
    userSelected.setHorizontalAlignment(JLabel.LEFT);
    userSelected.setVerticalAlignment(JLabel.TOP);
    this.add(userSelected);

  }
}
