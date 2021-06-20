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
   * Hashmap values: <Year, <Month, <Week, Values>>>
   *
   * @return
   */
  public static HashMap<Integer, HashMap<String, HashMap<Integer, DataFormat[]>>>
  loadData(int start_year, int end_year){

    return null;
  }

  public static void loadYear(int year){

  }

  /**
   * Saves each year's data by calling saveYear and saving them individually.
   *
   * @param start_year
   * @param end_year
   * @param data
   */
  public static void saveData(int start_year, int end_year,
                              HashMap<Integer, HashMap<String, HashMap<Integer, DataFormat[]>>> data){
    for(int year=start_year; year<end_year; year++){
      saveYear(year, data.get(year));
    }

  }

  /**
   * Writes this current years data into a file
   *
   * @param year
   * @param data
   */
  public static void saveYear(int year, HashMap<String, HashMap<Integer, DataFormat[]>> data){
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("data/"+year+".json"));
      writer.write(gson.toJson(data));
      writer.close();
    } catch(Exception e){ System.out.println("Error saving "+year+"'s data file:"+e); }
  }
}

