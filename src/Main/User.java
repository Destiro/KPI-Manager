package Main;

import java.util.HashMap;

/**
 * Users "Car technicians" in the dealership,
 * Stores all their overall stats.
 */
public class User {

  //Values stored inside the files
  public enum Months {
    January, February, March, April, May, June, July, August, September, October, November, December
  }
  public enum Values {
    attended, worked, invoiced, uninvoiced, idle_prod, idle_unprod, count, taken, sold, wip_open, wip_close
  }

  //User variables
  public HashMap<Integer, HashMap<String, DataFormat[]>> yearStats;
  public String name;

  User(String name){
    this.name = name;
    yearStats = new HashMap<>();
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
  public DataFormat[] getMonthValues(int year, String month){
    if(yearStats.containsKey(year) && yearStats.get(year).containsKey(month)) {
      return yearStats.get(year).get(month);
    }
    return null;
  }

  /**
   * Tallies weekly data and creates monthly average
   * to be fetched from the global variable.
   */
  public DataFormat getMonthlyAverage(int year, String month){
    //Iterates through and sum up all data
    DataFormat result = null;
    for(DataFormat entry : getMonthValues(year, month)){
      if(result == null){
        result = new DataFormat(entry);
      }else{
        result.addWeekValues(entry);
      }
    }

    //Find average and return DataFormat object
    if(result != null){ result.averageByDays(); }
    return result;
  }

  /**
   * Get the average for the specified financial year
   * Each financial year starts from April 1st of the previous year
   * and ends in March 31st of the current year.
   * (eg 2021 = April 2020 to March 2021).
   *
   * @param year
   * @return
   */
  public DataFormat getYearlyAverage(int year){
    DataFormat result = null;
    for(Months monthEnum : Months.values()){
      //Get month
      String month = monthEnum.name();

      //Decrease year when April - Dec
      if(month.equals("April")){
        year -= 1;
      }

      //If entry exists, find average and add it on
      if(yearStats.containsKey(year) && yearStats.get(year).containsKey(month)) {
        if (result == null) {
          result = getMonthlyAverage(year, month);
        }else{
          result.addWeekValues(getMonthlyAverage(year, month));
        }
      }
    }

    //Find average and return DataFormat object
    if(result != null){ result.averageByDays(); }
    return result;
  }
}