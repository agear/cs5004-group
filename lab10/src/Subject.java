/**
 * Interface for Objects that contain data of interest to other objects.
 */
public interface Subject {

  /**
   * This method is called in order to add an observer to be notified of changes by this subject
   * object.
   */
  void register(Observer registree);

  /**
   * Removes an observer from the observer list so they don't get notified about changes/milestones
   * to this grade record anymore.
   *
   * @param deregistree the object that will be removed from observer list.
   */
  void remove(Observer deregistree);

  /**
   * Sends a notification to all observers when and object implementing this interfaces' state
   * changes.
   */
  void notifyObservers();
}