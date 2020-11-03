package GUI;

import java.awt.*;

import javax.swing.*;

public class ApplicationView {
  private JFrame window;
  private String user = "Branch";

  public ApplicationView(){
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
    //General Frame Construction
    window = new JFrame("KPI Manager");
    window.setSize(1280, 720);
    window.setResizable(false);
    window.setVisible(true);
    JLabel userSelected = new JLabel(user);
    window.add(userSelected);

    //Getting Panels

    //Application 
    
    //User interaction
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
