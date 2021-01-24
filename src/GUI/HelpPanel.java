package GUI;

import java.awt.*;

import javax.swing.*;

public class HelpPanel extends JPanel {
  private ApplicationView gui;

  public HelpPanel(Dimension size, ApplicationView gui){
    //JPanel setup
    this.setBounds((1280/6), 0, size.width, size.height);
    this.setBackground(Color.YELLOW);
    this.setLayout(new GridBagLayout());

    //Variables set
    this.gui = gui;
  }
}
