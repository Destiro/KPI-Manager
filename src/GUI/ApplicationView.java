package GUI;

import Main.User;

import java.awt.*;
import java.util.HashMap;

import javax.swing.*;

public class ApplicationView {
  private JFrame window;
  private JPanel sidePanel;
  private JPanel mainPanel;
  private String user = "Branch";
  public HashMap<String, User> users;
  private String page = "DASHBOARD";

  public ApplicationView(){
    //General Frame Construction
    window = new JFrame("KPI Manager");
    window.setSize(1280, 720);
    window.setResizable(false);
    window.setVisible(true);
    window.setLayout(null);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Create First Page
    sidePanel = new SidePanel(new Dimension(1280/6, 720), this);
    window.add(sidePanel);
    makeDashboard();

    //Draw Panel
    window.revalidate();
    window.repaint();
  }

  public void changePage(String newPage){
    //If Page selected is already chosen
    if(page.equals(newPage)){
      return;
    }

    //New page selected, Recreate GUI
    page = newPage;
    window.remove(mainPanel);
    if(newPage.equals("DASHBOARD")){
      makeDashboard();
    }else if(newPage.equals("EXPORT")){
      makeExport();
    }else if(newPage.equals("INPUT")){
      makeInput();
    }else if(newPage.equals("SETTINGS")){
      makeSettings();
    }else if(newPage.equals("HELP")){
      makeHelp();
    }else{
      window.dispose();
    }

    //Draw Panel
    window.revalidate();
    window.repaint();
  }

  private void makeHelp() {
    mainPanel = new HelpPanel(new Dimension((1280*5)/6, 720), this);
    window.add(mainPanel);
  }

  private void makeSettings() {
    mainPanel = new SettingsPanel(new Dimension((1280*5)/6, 720), this);
    window.add(mainPanel);
  }

  private void makeInput() {
    mainPanel = new InputPanel(new Dimension((1280*5)/6, 720), this);
    window.add(mainPanel);
  }

  private void makeExport() {
    mainPanel = new ExportPanel(new Dimension((1280*5)/6, 720), this);
    window.add(mainPanel);
  }

  public void makeDashboard(){
    mainPanel = new DashboardPanel(new Dimension((1280*5)/6, 720), this);
    window.add(mainPanel);
  }

  public String getUser(){
    return user;
  }
}
