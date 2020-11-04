package GUI;

import java.awt.*;

import javax.swing.*;

/**
 * JPanel on the left side of the GUI,
 * to display buttons to change to different pages.
 */
public class SidePanel extends JPanel {
  public ApplicationView gui;
  public enum buttons{
    DASHBOARD, EXPORT, INPUT, SETTINGS, HELP, QUIT
  }
  public SidePanel(Dimension size, ApplicationView gui){
    this.gui = gui;

    this.setSize(size);
    //this.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
    this.setLayout(new GridLayout(0,1));
    this.setVisible(true);
    this.setBackground(Color.LIGHT_GRAY);

    addButtons();
    this.updateUI();
  }

  public void addButtons(){
    for(buttons b : buttons.values()){
      this.add(new JButton(b.toString()));
    }
  }
}
