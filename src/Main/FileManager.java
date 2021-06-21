package Main;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
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
  public SettingsFormat loadSettings(){
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
  public void saveSettings(SettingsFormat sf){
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
  public HashMap<Integer, HashMap<String, HashMap<Integer, DataFormat[]>>>
  loadData(int start_year, int end_year){
    HashMap<Integer, HashMap<String, HashMap<Integer, DataFormat[]>>> allYearStats = new HashMap<>();
    for(int year=start_year; year<end_year; year++){
      allYearStats.put(year, loadYear(year));
    }

    return allYearStats;
  }

  /**
   * Reads this current years file and converts that to a JSON object
   *
   * @param year specifies file ("year.json")
   * @return
   */
  public HashMap<String, HashMap<Integer, DataFormat[]>> loadYear(int year){
    HashMap<String, HashMap<Integer, DataFormat[]>> yearData = new HashMap<>();
    try{
      //Convert file to Hashmap using type token
      Type type = new TypeToken<HashMap<String, HashMap<Integer, DataFormat[]>>>(){}.getType();
      JsonReader reader = new JsonReader(new FileReader("data/"+year+".json"));
      yearData = gson.fromJson(reader, type);

    } catch(Exception e){ System.out.println("Error loading year: "+e); }
    return yearData;
  }

  /**
   * Saves each year's data by calling saveYear and saving them individually.
   *
   * @param start_year
   * @param end_year
   * @param data
   */
  public void saveData(int start_year, int end_year,
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
  public void saveYear(int year, HashMap<String, HashMap<Integer, DataFormat[]>> data){
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("data/"+year+".json"));
      writer.write(gson.toJson(data));
      writer.close();
    } catch(Exception e){ System.out.println("Error saving "+year+"'s data file:"+e); }
  }
}

