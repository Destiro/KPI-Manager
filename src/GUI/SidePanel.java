package GUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

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

    this.setBounds(0, 0, size.width, size.height);
    this.setBorder(new EmptyBorder(20,15,100, 15));
    this.setLayout(new GridLayout(6,1,0,10));
    this.setVisible(true);
    this.setBackground(Color.LIGHT_GRAY);

    addButtons();
    this.updateUI();
  }

  public void addButtons(){
    for(buttons b : buttons.values()){
      JButton newButton = new JButton(b.toString());
      newButton.addActionListener(actionEvent -> gui.changePage(b.toString()));
      this.add(newButton);
    }
  }
}
