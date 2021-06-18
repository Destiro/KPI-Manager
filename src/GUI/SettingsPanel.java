package GUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SettingsPanel extends JPanel {
  private ApplicationView gui;
  private Dimension size;
  private GridBagConstraints constraints;

  public SettingsPanel(Dimension size, ApplicationView gui){
    //JPanel setup
    setBounds((1280/6), 0, size.width, size.height);
    setBackground(Color.YELLOW);
    setLayout(new GridBagLayout());

    //Gridbag Constraints
    constraints = new GridBagConstraints();
    constraints.anchor = GridBagConstraints.FIRST_LINE_START;
    constraints.weightx = 1;
    constraints.weighty = 1;
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.gridwidth = 2;
    constraints.gridheight = 2;

    //Variables set
    this.gui = gui;
    this.size = size;

    //Setup the gui
    setupSettings();
  }

  public void setupSettings(){
    //Creating Label
    JLabel title = new JLabel("Settings");
    title.setFont(title.getFont().deriveFont(24.0f));
    constraints.gridx = 0;
    constraints.gridy = 0;
    add(title, constraints);

    //Create outer JPanel
    JPanel outerPanel = new JPanel();
    outerPanel.setLayout(new BoxLayout(outerPanel, BoxLayout.PAGE_AXIS));
    outerPanel.setBorder(new EmptyBorder(20,15,100, 15));
    outerPanel.setBounds(size.width/4, size.height/6, size.width/2, size.height/3);
    outerPanel.setMinimumSize(new Dimension(size.width/2, size.height/2));
    outerPanel.setBackground(Color.RED);

    //Creating inner left JPanel

    //Creating inner right JPanel

    //Constraints and adding panel
    constraints.gridwidth = 1;
    constraints.gridheight = 1;
    constraints.gridx = 1;
    constraints.gridy = 1;
    constraints.anchor = GridBagConstraints.CENTER;
    constraints.fill = GridBagConstraints.NONE;
    add(outerPanel, constraints);
  }
}
