package GUI;

import java.awt.*;

import javax.swing.*;

public class DashboardPanel extends JPanel {
  private ApplicationView gui;
  private GridBagConstraints constraints = new GridBagConstraints();
  public DashboardPanel(Dimension size, ApplicationView gui){
    //JPanel setup
    this.setBounds(1280/6, 0, size.width, size.height);
    System.out.println(size.width);
    System.out.println(size.height);
    this.setBackground(Color.YELLOW);
    this.setLayout(new GridBagLayout());

    //Grid Constraints setup
    constraints.insets = new Insets(5, 5, 5, 5);
    constraints.anchor = GridBagConstraints.FIRST_LINE_START;
    constraints.weightx = 1;
    constraints.weighty = 1;
    //constraints.gridheight = 5;
    constraints.gridwidth = 2;
    //constraints.fill = GridBagConstraints.HORIZONTAL;

    //Variables set
    this.gui = gui;
    setupDashboard();
  }

  public void setupDashboard(){
    //Creating Label
    JLabel userSelected = new JLabel("  "+gui.getUser());
    userSelected.setFont(userSelected.getFont().deriveFont(24.0f));
    userSelected.setHorizontalAlignment(JLabel.LEFT);
    userSelected.setVerticalAlignment(JLabel.TOP);

    //Creating Constraints and adding element
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.gridx = 0;
    constraints.gridy = 0;
    this.add(userSelected, constraints);

    //Creating User Selection
    //todo create user selection
    //User user = ...

    //Creating meters
    Dimension meterSize = new Dimension(250, 200);
    setupMeter(0, 1, meterSize, "Productivity", 0.0, 0.0);
    setupMeter(1, 1, meterSize, "Efficiency", 0.0, 0.0);
    setupMeter(2, 1, meterSize, "Performance", 0.0, 0.0);
    setupMeter(3, 1, meterSize, "Days Left", 0.0, 0.0);

    //Creating bar graphs
    Dimension barGraphSize = new Dimension(500, 200);
    setupBarGraph(0, 2, barGraphSize, "Sold / Taken", 0.0, 0.0);
    setupBarGraph(2, 2, barGraphSize, "Worked / Attended", 0.0, 0.0);

    //Creating line graph
    Dimension lineGraphSize = new Dimension(1000, 200);
    setupLineGraph(0, 3, lineGraphSize, "Sold / Taken", 0.0, 0.0);

  }

  /**
   * Sets up a box for displaying a meter,
   *
   *
   * @param x
   * @param y
   * @param size
   * @param name
   * @param current
   * @param max
   */
  public void setupMeter(int x, int y, Dimension size, String name, Double current, Double max){
    //Setup panel
    JPanel meter = new JPanel();
    meter.setPreferredSize(size);
    meter.setBackground(Color.RED);
    meter.setVisible(true);

    //Setup Graph
    JLabel meterName = new JLabel(name);
    meterName.setFont(meterName.getFont().deriveFont(18.0f));
    meter.add(meterName);
    //todo create graph

    //Constraints and adding element
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.gridx = x;
    constraints.gridy = y;
    constraints.gridwidth = 1;
    constraints.gridheight = 1;
    this.add(meter, constraints);
  }

  public void setupBarGraph(int x, int y, Dimension size, String name, Double current, Double max){
    //Setup panel
    JPanel barGraph = new JPanel();
    barGraph.setPreferredSize(size);
    barGraph.setBackground(Color.BLUE);
    barGraph.setVisible(true);

    //Setup Graph
    JLabel meterName = new JLabel(name);
    meterName.setFont(meterName.getFont().deriveFont(18.0f));
    barGraph.add(meterName);
    //todo create graph

    //Constraints and adding element
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.gridx = x;
    constraints.gridy = y;
    constraints.gridwidth = 2;
    constraints.gridheight = 1;
    this.add(barGraph, constraints);
  }

  public void setupLineGraph(int x, int y, Dimension size, String name, Double current, Double max){
    //Setup panel
    JPanel lineGraph = new JPanel();
    lineGraph.setPreferredSize(size);
    lineGraph.setBackground(Color.GREEN);
    lineGraph.setVisible(true);

    //Setup Graph
    JLabel meterName = new JLabel(name);
    meterName.setFont(meterName.getFont().deriveFont(18.0f));
    lineGraph.add(meterName);
    //todo create graph

    //Constraints and adding element
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.gridx = x;
    constraints.gridy = y;
    constraints.gridwidth = 4;
    constraints.gridheight = 1;
    this.add(lineGraph, constraints);
  }
}
