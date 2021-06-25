package Main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import GUI.ApplicationView;

public class Main {
  public FileManager fileManager;
  private ApplicationView view;
  public HashMap<Integer, HashMap<String, HashMap<Integer, DataFormat[]>>> data = new HashMap();
  private SettingsFormat settings;

  public static void main(String[] args){
    Main instance = new Main();
    instance.setup(instance);
  }

  /**
   * Creates GUI and fetches data
   */
  private void setup(Main instance){
    fileManager = new FileManager();
    settings = fileManager.loadSettings();

    //Load data from start to current years date
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
    data = fileManager.loadData(settings.getStart_year(), Integer.parseInt(dateFormat.format(new Date())));

    //Create users and GUI
    HashMap<String, User> users = populateUsers();
    view = new ApplicationView(users, settings, instance);
  }

  /**
   * From fetched data, create users and populate them
   * with data that matches
   */
  private HashMap<String, User> populateUsers(){
    if(data.size() < 1){ System.out.println("No data was loaded to create users."); }

    //Loop through each year, month and week
    //Adding a new user if one doesnt exist or adding a week entry otherwise
    HashMap<String, User> users = new HashMap<>();

    for(int year : data.keySet()){ //Year
      for(String month : data.get(year).keySet()){ //Month
        for(int week : data.get(year).get(month).keySet()){ //Week
          for(DataFormat entry : data.get(year).get(month).get(week)) { //User entries for week
            String username = entry.getUser();

            //No user, make a new one
            if (!users.containsKey(username)){
              users.put(username, new User(username));
            }

            //Add an entry for that user
            users.get(username).addEntry(year,month,week,entry);
          }
        }
      }
    }

    //TODO create a branch user
    return users;
  }
}
