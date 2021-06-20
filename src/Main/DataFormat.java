package Main;

/**
 * DataFormat is used for converting data into json objects for storage.
 * One DataFormat object houses 1 months worth of info for a given user.
 */
public class DataFormat {
  String user;
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

  DataFormat(String user, Double attended, Double worked, Double invoiced,
          Double uninvoiced, Double idle_prod, Double idle_unprod,
          Double count, Double taken, Double sold, Double wip_open,
             Double wip_close){
    this.user = user;
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
}
