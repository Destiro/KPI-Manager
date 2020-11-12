package Main;

import java.util.HashMap;

import GUI.ApplicationView;

public class Main {
  private ApplicationView view;

  public static void main(String[] args){
    /*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
    System.out.println(dateFormat.format(new Date()));
    Main.FileManager.loadYear("assets/"+dateFormat.format(new Date())+".txt");*/

    Main instance = new Main();
    instance.setup();
  }

  private void setup(){
    view = new ApplicationView();
  }
}