package GUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Main.SettingsFormat;

public class SettingsPanel extends JPanel {
  private ApplicationView gui;
  private Dimension size;
  private GridBagConstraints constraints;
  private Color backgroundColor = new Color(215,215,215);

  //Text fields to fetch values when settings saved
  private JTextField effField;
  private JTextField proField;
  private JTextField perField;
  private JTextField startYearField;

  public SettingsPanel(Dimension size, ApplicationView gui){
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

    //Setup the gui
    setupSettings();
  }

  public void setupSettings(){
    //Creating Label
    JLabel title = new JLabel("  "+"Settings");
    title.setFont(title.getFont().deriveFont(24.0f));
    constraints.gridx = 0;
    constraints.gridy = 0;
    add(title, constraints);

    //Create outer JPanel
    JPanel outerPanel = new JPanel();
    outerPanel.setLayout(new BoxLayout(outerPanel, BoxLayout.PAGE_AXIS));
    outerPanel.setBorder(new EmptyBorder(20,15,100, 15));
    //outerPanel.setBounds(size.width/4, size.height/6, size.width/2, size.height/3);
    outerPanel.setPreferredSize(new Dimension(size.width-(size.width/5), size.height-(size.height/4)));
    outerPanel.setBackground(Color.WHITE);

    //Title Label
    JLabel targets = new JLabel("Targets:");
    targets.setFont(targets.getFont().deriveFont(22.0f));
    outerPanel.add(targets);

    //Create space
    outerPanel.add(Box.createRigidArea(new Dimension(0, 40))); //Padding

    //Productivity target
    JLabel productivity = new JLabel("Productivity Target");
    productivity.setFont(productivity.getFont().deriveFont(18.0f));
    outerPanel.add(productivity);

    proField = new JTextField();
    proField.setPreferredSize(new Dimension(size.width/4,size.height/20));
    proField.setColumns(10);
    proField.setText(gui.settings.getProductivity_target().toString());
    outerPanel.add(proField);

    //Create space
    outerPanel.add(Box.createRigidArea(new Dimension(0, 40))); //Padding

    //Efficiency target
    JLabel efficiency = new JLabel("Efficiency Target");
    efficiency.setFont(efficiency.getFont().deriveFont(18.0f));
    outerPanel.add(efficiency);

    effField = new JTextField();
    effField.setPreferredSize(new Dimension(size.width/4,size.height/20));
    effField.setColumns(10);
    effField.setFont(effField.getFont().deriveFont(14.0f));
    effField.setText(gui.settings.getEfficiency_target().toString());
    outerPanel.add(effField);

    //Create space
    outerPanel.add(Box.createRigidArea(new Dimension(0, 40))); //Padding

    //Performance target
    JLabel performance = new JLabel("Efficiency Target");
    performance.setFont(performance.getFont().deriveFont(18.0f));
    outerPanel.add(performance);

    perField = new JTextField();
    perField.setPreferredSize(new Dimension(size.width/4,size.height/20));
    perField.setColumns(10);
    perField.setText(gui.settings.getRecovery_target().toString());
    outerPanel.add(perField);

    //Create space
    outerPanel.add(Box.createRigidArea(new Dimension(0, 40))); //Padding

    //Start year to load from
    JLabel startYear = new JLabel("Year to Start Loading");
    startYear.setFont(startYear.getFont().deriveFont(18.0f));
    outerPanel.add(startYear);

    startYearField = new JTextField();
    startYearField.setPreferredSize(new Dimension(size.width/4,size.height/20));
    startYearField.setColumns(10);
    startYearField.setText(gui.settings.getStart_year().toString());
    outerPanel.add(startYearField);

    //Create space
    outerPanel.add(Box.createRigidArea(new Dimension(0, 40))); //Padding

    //Create a save settings button
    JButton button = new JButton("Save Settings");
    button.addActionListener(actionEvent -> saveSettings());
    outerPanel.add(button);

    //Constraints and adding panel
    constraints.gridwidth = 1;
    constraints.gridheight = 1;
    constraints.gridx = 1;
    constraints.gridy = 1;
    constraints.anchor = GridBagConstraints.CENTER;
    constraints.fill = GridBagConstraints.NONE;
    add(outerPanel, constraints);
  }

  /**
   * Creating a new settings object and saving it.
   * Replacing the global settings variable with this one.
   */
  public void saveSettings(){
    SettingsFormat sf = new SettingsFormat(Integer.parseInt(startYearField.getText()),
            Double.parseDouble(effField.getText()), Double.parseDouble(proField.getText()),
            Double.parseDouble(perField.getText()));
    gui.setSettings(sf);
    gui.main.fileManager.saveSettings(sf);
  }
}
