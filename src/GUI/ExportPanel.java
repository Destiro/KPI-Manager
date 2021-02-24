package GUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ExportPanel extends JPanel {
  private ApplicationView gui;
  private Dimension size;
  private GridBagConstraints constraints;

  public ExportPanel(Dimension size, ApplicationView gui){
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

    //Create Panel content
    setupExport();
  }

  public void setupExport(){
    //Creating Label
    JLabel title = new JLabel("Export Report Printout");
    title.setFont(title.getFont().deriveFont(24.0f));
    constraints.gridx = 0;
    constraints.gridy = 0;
    add(title, constraints);

    //Create inner JPanel
    JPanel innerPanel = new JPanel();
    innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.PAGE_AXIS));
    innerPanel.setBorder(new EmptyBorder(20,15,100, 15));
    innerPanel.setBounds(size.width/4, size.height/6, size.width/2, size.height/3);
    innerPanel.setBackground(Color.RED);

    //Creating User Dropdown
    String users[] = {"Branch", "Joe", "Bill", "Jessica"};
    JComboBox userSelect = new JComboBox(users);
    userSelect.setPreferredSize(new Dimension(size.width/4, size.height/16));
    userSelect.setPrototypeDisplayValue("Select User");
    innerPanel.add(userSelect);
    innerPanel.add(Box.createRigidArea(new Dimension(0, 20))); //Padding

    //Creating Timeframe Dropdown
    String month[] = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
    JComboBox timeFrame = new JComboBox(month);
    timeFrame.setPreferredSize(new Dimension(size.width/4, size.height/16));
    timeFrame.setPrototypeDisplayValue("Select Month");
    innerPanel.add(timeFrame);
    innerPanel.add(Box.createRigidArea(new Dimension(0, 80))); //Padding

    //Creating export button
    JButton exportButton = new JButton("Export");
    exportButton.setPreferredSize(new Dimension(size.width/4, size.height/16));
    innerPanel.add(exportButton);

    constraints.gridwidth = 1;
    constraints.gridheight = 1;
    constraints.gridx = 1;
    constraints.gridy = 1;
    constraints.anchor = GridBagConstraints.CENTER;
    constraints.fill = GridBagConstraints.NONE;
    add(innerPanel, constraints);
  }
}
