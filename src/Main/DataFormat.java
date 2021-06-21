package Main;

/**
 * DataFormat is used for converting data into json objects for storage.
 * One DataFormat object houses 1 months worth of info for a given user.
 */
public class DataFormat {
  String user;
  int week_days;
  Double attended;
  Double worked;
  Double invoiced;
  Double uninvoiced;
  Double idle_prod;
  Double idle_unprod;
  Double count;
  Double taken;
  Double sold;
  Double wip_open;
  Double wip_close;

  DataFormat(String user, int week_days, Double attended, Double worked, Double invoiced,
          Double uninvoiced, Double idle_prod, Double idle_unprod,
          Double count, Double taken, Double sold, Double wip_open,
             Double wip_close){
    this.user = user;
    this.week_days = week_days;
    this.attended = attended;
    this.worked = worked;
    this.invoiced = invoiced;
    this.uninvoiced = uninvoiced;
    this.idle_prod = idle_prod;
    this.idle_unprod = idle_unprod;
    this.count = count;
    this.taken = taken;
    this.sold = sold;
    this.wip_open = wip_open;
    this.wip_close = wip_close;
  }

  //Used in cloning DataFormats and avoiding altering existing data
  DataFormat(DataFormat other){
    this.user = other.user;
    this.week_days = other.week_days;
    this.attended = other.attended;
    this.worked = other.worked;
    this.invoiced = other.invoiced;
    this.uninvoiced = other.uninvoiced;
    this.idle_prod = other.idle_prod;
    this.idle_unprod = other.idle_unprod;
    this.count = other.count;
    this.taken = other.taken;
    this.sold = other.sold;
    this.wip_open = other.wip_open;
    this.wip_close = other.wip_close;
  }

  //Getters
  public String getUser() {
    return user;
  }

  public int getWeek_days() {
    return week_days;
  }


  /**
   * Add all data from another DataFormat object
   * into this one.
   */
  public void addWeekValues(DataFormat other){
    week_days += other.week_days;
    attended += other.attended;
    worked += other.worked;
    invoiced += other.invoiced;
    uninvoiced += other.uninvoiced;
    idle_prod += other.idle_prod;
    idle_unprod += other.idle_unprod;
    count += other.count;
    taken += other.taken;
    sold += other.sold;
    wip_open += other.wip_open;
    wip_close += other.wip_close;
  }

  /**
   * Finds the daily average for each piece of data
   */
  public void averageByDays(){
    week_days /= week_days;
    attended /= week_days;
    worked /= week_days;
    invoiced /= week_days;
    uninvoiced /= week_days;
    idle_prod /= week_days;
    idle_unprod /= week_days;
    count /= week_days;
    taken /= week_days;
    sold /= week_days;
    wip_open /= week_days;
    wip_close /= week_days;
  }
}
