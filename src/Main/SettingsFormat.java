package Main;

/**
 * Creates format for the settings file
 * Storing first year to be loaded from file and targets to reach.
 */
public class SettingsFormat {
  Integer start_year;
  Double efficiency_target;
  Double productivity_target;
  Double recovery_target;

  SettingsFormat(Integer start_year, Double efficiency_target,
                 Double productivity_target, Double recovery_target){
    this.start_year = start_year;
    this.efficiency_target = efficiency_target;
    this.productivity_target = productivity_target;
    this.recovery_target = recovery_target;
  }

  //Getters
  public Integer getStart_year() {
    return start_year;
  }

  public Double getEfficiency_target() {
    return efficiency_target;
  }

  public Double getProductivity_target() {
    return productivity_target;
  }

  public Double getRecovery_target() {
    return recovery_target;
  }
}
