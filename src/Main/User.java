package Main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Users "Car technicians" in the dealership,
 * Stores all their overall stats.
 */
public class User {
  public HashMap<Integer, HashMap<Integer, HashMap<Integer, Double[]>>> yearStats;
  public ArrayList<Double[]> monthAverages;
  public boolean monthProxyCheck;
  public String name;

  User(String name){
    this.name = name;
    yearStats = new HashMap<>();
    monthAverages = new ArrayList<>();
    monthProxyCheck = false;
  }

  /**
   * Adds an entry or updates a previous entry.
   *
   * @param year of entry
   * @param month of entry
   * @param week of entry
   * @param values of data
   */
  public void addEntry(int year, int month, int week, Double[] values){
    monthProxyCheck = false;

    //Year or Month Doesnt Exist
    if(!yearStats.containsKey(year) || !yearStats.get(year).containsKey(month)){
      //Initialize new HashMaps
      HashMap<Integer, HashMap<Integer, Double[]>> monthStats = new HashMap<>();
      HashMap<Integer, Double[]> weekStats = new HashMap<>();

      //Create Entries
      weekStats.put(week, values);
      monthStats.put(month, weekStats);
      yearStats.put(year, monthStats);

    //Edit an existing entry or week doesnt exist
    }else{
      yearStats.get(year).get(month).put(week, values);
    }
  }

  /**
   * Get a list of values for the provided month.
   *
   * @param year of entry
   * @param month of entry
   * @return a list of weekly values
   */
  public ArrayList<Double[]> getMonthValues(int year, int month){
    ArrayList<Double[]> monthValues = new ArrayList<>();

    for(int week : yearStats.get(year).get(month).keySet()){
      monthValues.set(week-1, yearStats.get(year).get(month).get(week));
    }
    return monthValues;
  }

  /**
   * Gets a list of averaged monthly values
   *
   * @param year
   * @return
   */
  public ArrayList<Double[]> getYearValues(int year){
    if(!monthProxyCheck){
      monthProxyCheck = true;
      setMonthlyAverages();
    }
    return monthAverages;
  }

  /**
   * Tallies weekly data and creates monthly averages
   * to be fetched from the global variable.
   */
  public void setMonthlyAverages(){
    monthAverages.clear();

    for(int month : yearStats.keySet()) {
      for (int week : yearStats.get(month).keySet()) {
          //todo add all static variables and work out % at the end.
      }
    }
  }
}