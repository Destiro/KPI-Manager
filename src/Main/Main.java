package Main;

import java.util.HashMap;

import GUI.ApplicationView;

public class Main {
  private ApplicationView view;
  private HashMap<Integer, HashMap<String, HashMap<Integer, DataFormat[]>>> data = new HashMap();

  public static void main(String[] args){
    /*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
    System.out.println(dateFormat.format(new Date()));
    data = Main.FileManager.loadYear("assets/"+dateFormat.format(new Date())+".txt");*/

    //Mock data
    DataFormat df1 = new DataFormat("Joe Smith",1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0);
    DataFormat df2 = new DataFormat("Michael Jackson",2.0,2.0,2.0,2.0,2.0,2.0,2.0,2.0,2.0,2.0,2.0);
    DataFormat df3 = new DataFormat("Joe Smith",3.0,3.0,3.0,3.0,3.0,3.0,3.0,3.0,3.0,3.0,3.0);
    DataFormat df4 = new DataFormat("Michael Jackson",4.0,4.0,4.0,4.0,4.0,4.0,4.0,4.0,4.0,4.0,4.0);

    HashMap<Integer, DataFormat[]> week = new HashMap<>();
    HashMap<Integer, DataFormat[]> week2 = new HashMap<>();
    week.put(1, new DataFormat[]{df1,df2});
    week.put(2, new DataFormat[]{df3,df4});
    week2.put(2, new DataFormat[]{df1,df2});
    week2.put(1, new DataFormat[]{df3,df4});

    HashMap<String, HashMap<Integer, DataFormat[]>> month = new HashMap<>();

    month.put("January", week);
    month.put("February", week2);

    FileManager.saveYear(2019, month);


    Main instance = new Main();
    instance.setup();
  }

  private void setup(){
    view = new ApplicationView();
  }
}
