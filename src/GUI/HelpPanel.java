package GUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class HelpPanel extends JPanel {
  private ApplicationView gui;
  private Dimension size;
  private GridBagConstraints constraints;

  public HelpPanel(Dimension size, ApplicationView gui){
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
    setupHelp();
  }

  private void setupHelp(){
    //Creating Label
    JLabel title = new JLabel("Help Menu");
    title.setFont(title.getFont().deriveFont(24.0f));
    constraints.gridx = 0;
    constraints.gridy = 0;
    add(title, constraints);

    //Create inner JPanel
    JPanel innerPanel = new JPanel();
    innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.PAGE_AXIS));
    innerPanel.setBorder(new EmptyBorder(20,15,100, 15));
    innerPanel.setBounds(size.width/4, size.height/6, size.width/2, size.height/3);
    innerPanel.setMinimumSize(new Dimension(size.width/2, size.height/2));
    innerPanel.setBackground(Color.RED);

    //About
    JLabel about = new JLabel("About");
    about.setFont(about.getFont().deriveFont(22.0f));
    innerPanel.add(about);
    JTextArea text = new JTextArea("Lorem Ipsum is simply dummy text of the printing and typesetting \n" +
            "industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown \n" +
            "printer took a galley of type and scrambled it to make a type specimen book. It has survived not\n" +
            " only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.\n" +
            " It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages,\n" +
            " and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem \n" +
            "Ipsum.");
    text.setBackground(Color.RED); //todo change this later
    text.setFont(text.getFont().deriveFont(18.0f));
    innerPanel.add(text);

    //Create space
    innerPanel.add(Box.createRigidArea(new Dimension(0, 80))); //Padding

    //Contact
    JLabel contact = new JLabel("Contact");
    contact.setFont(contact.getFont().deriveFont(22.0f));
    innerPanel.add(contact);
    JTextArea text2 = new JTextArea("Im contact: Lorem Ipsum is simply dummy text of the printing and typesetting \n" +
            "industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown \n" +
            "printer took a galley of type and scrambled it to make a type specimen book. It has survived not\n" +
            " only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.\n" +
            " It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages,\n" +
            " and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem \n" +
            "Ipsum.");
    text2.setBackground(Color.RED); //todo change this later
    text2.setFont(text.getFont().deriveFont(18.0f));
    innerPanel.add(text2);

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
