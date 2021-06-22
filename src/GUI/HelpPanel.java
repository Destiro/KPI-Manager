package GUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class HelpPanel extends JPanel {
  private ApplicationView gui;
  private Dimension size;
  private GridBagConstraints constraints;
  private Color backgroundColor = new Color(215,215,215);

  public HelpPanel(Dimension size, ApplicationView gui){
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
    setupHelp();
  }

  private void setupHelp(){
    //Creating Label
    JLabel title = new JLabel("  "+"Help Menu");
    title.setFont(title.getFont().deriveFont(24.0f));
    constraints.gridx = 0;
    constraints.gridy = 0;
    add(title, constraints);

    //Create inner JPanel
    JPanel innerPanel = new JPanel();
    innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.PAGE_AXIS));
    innerPanel.setBorder(new EmptyBorder(20,15,50, 15));
    innerPanel.setBounds(size.width/4, size.height/6, size.width/2, size.height/3);
    innerPanel.setMinimumSize(new Dimension(size.width/2, size.height/2));
    innerPanel.setBackground(Color.WHITE);

    //About
    JLabel about = new JLabel("About");
    about.setFont(about.getFont().deriveFont(22.0f));
    innerPanel.add(about);
    JTextArea text = new JTextArea("This is a KPI (Key performance indicator) dashboard app used for tracking " +
            "progress of a car branch's technicians.\nTracking statistics on efficiency to deliver cars, idle times " +
            "and overall performance, to provide beneficial feedback \nand improve on workflow. This is originally " +
            "a personal project to help my mum visualize performance of her staff.");
    text.setFont(text.getFont().deriveFont(18.0f));
    innerPanel.add(text);

    //Create space
    innerPanel.add(Box.createRigidArea(new Dimension(0, 60))); //Padding

    //Details
    JLabel details = new JLabel("Details");
    details.setFont(details.getFont().deriveFont(22.0f));
    innerPanel.add(details);
    JTextArea text2 = new JTextArea("The app stores a series of hashmaps filled with data, catagorised by years, " +
            "months and weeks that are assigned to users.\nWhen fetching data each user is reconstructed with their " +
            "associated DataFormat objects containing weekly statistics.\nThe interface was created using the " +
            "JSwing library and data/settings files made using the Gson (JSON) library. Compiled \nand built using " +
            "Java 11.");
    text2.setFont(text.getFont().deriveFont(18.0f));
    innerPanel.add(text2);

    //Create space
    innerPanel.add(Box.createRigidArea(new Dimension(0, 60))); //Padding

    //Contact
    JLabel contact = new JLabel("Usage");
    contact.setFont(contact.getFont().deriveFont(22.0f));
    innerPanel.add(contact);
    JTextArea text3 = new JTextArea("For usage, In each menu containing data visualization (Data, Dashboard) there " +
            "should be dropdowns in the top right.\nChanging the selected option for user and/or timeframe should " +
            "show the new info related to that query. Inputting data\ncan be done through the input menu by filling " +
            "in each form and submitting. A CSV file (spreadsheet) can be exported\nin the export menu by selecting " +
            "the user and timeframe. Settings such as the targets or start year for loading can be\nadjusted in the" +
            " settings menu (If you are experiencing lots of lag move up the start year). For more info or any\n" +
            "additional queries please email me at connordebruyn234@gmail.com.");
    text3.setFont(text.getFont().deriveFont(18.0f));
    innerPanel.add(text3);

    //Constraints and adding panel
    constraints.gridwidth = 1;
    constraints.gridheight = 1;
    constraints.gridx = 1;
    constraints.gridy = 1;
    constraints.anchor = GridBagConstraints.CENTER;
    constraints.fill = GridBagConstraints.NONE;
    add(innerPanel, constraints);
  }
}
