package Main;

import java.util.HashMap;

/**
 * Users "Car technicians" in the dealership,
 * Stores all their overall stats.
 */
public class User {
  public HashMap<Integer, HashMap<String, DataFormat[]>> yearStats;
  public HashMap<String, DataFormat> monthAverages;
  public DataFormat yearAverage;

  public String name;

  User(String name){
    this.name = name;
    yearStats = new HashMap<>();
    monthAverages = new HashMap<>();
  }

  /**
   * Adds an entry or updates a previous entry.
   *
   * @param year of entry
   * @param month of entry
   * @param week of entry
   * @param df data entry
   */
  public void addEntry(int year, String month, int week, DataFormat df){

    //Year or Month Doesnt Exist
    if(!yearStats.containsKey(year) || !yearStats.get(year).containsKey(month)){

      //Initialize an array and fill with nulls + entry
      DataFormat[] dfList = new DataFormat[6];
      for(int i=0; i<6; i++){ dfList[i] = null; }
      dfList[week] = df;

      //Create and add to hashmaps
      HashMap<String, DataFormat[]> monthStats = new HashMap<>();
      monthStats.put(month, dfList);
      yearStats.put(year, monthStats);

    //Edit an existing entry or week doesnt exist
    }else{
      yearStats.get(year).get(month)[week] = df;
    }
  }

  /**
   * Get a list of values for the provided month.
   *
   * @param year of entry
   * @param month of entry
   * @return a list of weekly values
   */
  public DataFormat[] getMonthValues(int year, int month){
    return yearStats.get(year).get(month);
  }

  /**
   * Tallies weekly data and creates monthly averages
   * to be fetched from the global variable.
   */
  public void setMonthlyAverages(){
    monthAverages.clear();

    for(int year : yearStats.keySet()) {
      for(String month : yearStats.get(year).keySet()) {
          //todo add all static variables and work out % at the end.
      }
    }
  }

  //Yearly average -> April to March so in july means april-july as year average
}