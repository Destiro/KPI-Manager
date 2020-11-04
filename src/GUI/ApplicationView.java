package GUI;

import java.awt.*;

import javax.swing.*;

public class ApplicationView {
  private JFrame window;
  private JPanel sidePanel;
  private JPanel mainPanel;
  private String user = "Branch";

  public ApplicationView(){
    //General Frame Construction
    window = new JFrame("KPI Manager");
    window.setMinimumSize(new Dimension(1280, 720));
    window.setResizable(false);
    window.setVisible(true);

    //Create First Page
    makeDashboard();
  }

  public void changePage(int newPage){
    if(newPage == 0){
      makeDashboard();
    }else if(newPage == 1){
      makeExport();
    }else if(newPage == 2){
      makeInput();
    }else if(newPage == 3){
      makeSettings();
    }else if(newPage == 4){
      makeHelp();
    }else{
      window.dispose();
    }
  }

  private void makeHelp() {
  }

  private void makeSettings() {
  }

  private void makeInput() {
  }

  private void makeExport() {
  }

  public void makeDashboard(){
    JLabel userSelected = new JLabel(user);
    //window.add(userSelected);

    //Getting Panels
    sidePanel = new SidePanel(new Dimension(1280/6, 720), this);
    mainPanel = new DashboardPanel(new Dimension((1280*5)/6, 720), this);
    window.add(sidePanel);
    window.add(mainPanel);

    //Application 
    
    //User interaction
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    window.pack();
  }
}
