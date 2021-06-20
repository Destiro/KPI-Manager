package Main;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

/**
 * FileManager loads and saves files.
 */
public class FileManager {
  //Values stored inside the files
  public enum Month {
    January, February, March, April, May, June, July, August, September, October, November, December
  }
  public enum Values {
    attended, worked, invoiced, uninvoiced, idle_prod, idle_unprod, count, taken, sold, wip_open, wip_close
  }

  private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

  /**
   * Loads settings from settings.json.
   * Used to find which year file to start loading from.
   *
   * @return SettingsFormat object
   */
  public static SettingsFormat loadSettings(){
    SettingsFormat sf = null;
    try {
      JsonReader reader = new JsonReader(new FileReader("settings/settings.json"));
      sf = gson.fromJson(reader, SettingsFormat.class);
    } catch(Exception e){ System.out.println("Error reading settings file:"+e); }
    return sf;
  }

  /**
   * Saves a new settings file from a SettingsFormat object.
   * This can be invoked by updating the settings from its panel in the UI.
   */
  public static void saveSettings(SettingsFormat sf){
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("settings/settings.json"));
      writer.write(gson.toJson(sf));
      writer.close();
    } catch(Exception e){ System.out.println("Error saving settings file:"+e); }
  }

  /**
   * Loads data from each year into a hashmap
   * Hashmap values: <Year, <Month, <User, Values>>>
   *
   * @return
   */
  public static HashMap<Integer, HashMap<String, HashMap<String, DataFormat>>> loadData(int start_year, int end_year){

    return null;
  }

  public static void LoadYear(int year){

  }

  public static void SaveYear(int year){

  }
}

