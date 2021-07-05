package GUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ExportPanel extends JPanel {
  private ApplicationView gui;
  private Dimension size;
  private GridBagConstraints constraints;
  private Color backgroundColor = new Color(215,215,215);

  //Get data from boxes
  public JComboBox userSelect;
  public JComboBox yearBox;
  public JComboBox monthBox;

  public ExportPanel(Dimension size, ApplicationView gui){
    //JPanel setup
    setBounds((1280/6), 0, size.width, size.height);
    setBackground(backgroundColor);
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
    JLabel title = new JLabel("  "+"Export Report Printout");
    title.setFont(title.getFont().deriveFont(24.0f));
    constraints.gridx = 0;
    constraints.gridy = 0;
    add(title, constraints);

    //Create inner JPanel
    JPanel innerPanel = new JPanel();
    innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.PAGE_AXIS));
    innerPanel.setBorder(new EmptyBorder(20,15,100, 15));
    innerPanel.setBounds(size.width/4, size.height/6, size.width/2, size.height/3);
    innerPanel.setBackground(Color.WHITE);

    //Creating User Dropdown
    userSelect = new JComboBox(gui.users.keySet().toArray());
    userSelect.setPreferredSize(new Dimension(size.width/4, size.height/16));
    userSelect.setPrototypeDisplayValue("Select User");
    innerPanel.add(userSelect);
    innerPanel.add(Box.createRigidArea(new Dimension(0, 20))); //Padding

    //Creating Year Dropdown
    yearBox = new JComboBox(gui.main.data.keySet().toArray());
    yearBox.setPreferredSize(new Dimension(size.width/4, size.height/16));
    yearBox.setPrototypeDisplayValue("Select Year");
    innerPanel.add(yearBox);
    innerPanel.add(Box.createRigidArea(new Dimension(0, 20))); //Padding

    //Creating Timeframe Dropdown
    String month[] = {"Full Business Year", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
    monthBox = new JComboBox(month);
    monthBox.setPreferredSize(new Dimension(size.width/4, size.height/16));
    monthBox.setPrototypeDisplayValue("Select Month");
    innerPanel.add(monthBox);
    innerPanel.add(Box.createRigidArea(new Dimension(0, 80))); //Padding

    //Creating export button
    JButton exportButton = new JButton("Export");
    exportButton.setPreferredSize(new Dimension(size.width/4, size.height/16));
    exportButton.addActionListener(actionEvent -> saveCSV());
    innerPanel.add(exportButton);

    constraints.gridwidth = 1;
    constraints.gridheight = 1;
    constraints.gridx = 1;
    constraints.gridy = 1;
    constraints.anchor = GridBagConstraints.CENTER;
    constraints.fill = GridBagConstraints.NONE;
    add(innerPanel, constraints);
  }

  public void saveCSV(){
    
  }
}
