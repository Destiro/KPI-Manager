package Main;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import GUI.ApplicationView;

public class Main {
  private ApplicationView view;
  private HashMap<Integer, HashMap<String, HashMap<Integer, DataFormat[]>>> data = new HashMap();
  private SettingsFormat settings;

  public static void main(String[] args){
    Main instance = new Main();
    instance.setup();
  }

  private void setup(){
    view = new ApplicationView();
    settings = FileManager.loadSettings();

    //Load data from start to current years date
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
    data = FileManager.loadData(settings.getStart_year(), Integer.parseInt(dateFormat.format(new Date())));
  }
}
