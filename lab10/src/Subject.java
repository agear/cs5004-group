/** //TODO
 * Subject: This is the object that contains the data of interest to other objects.
 */
public interface Subject {

  /**
   * This method is called in order to add an observer to be notified of changes
   * by this subject object.
   */
  void register(Observer registree);

//TODO Necessary?
  /**
   * Removes an observer from the observer list so they don't get notified about
   * changes/milestones to this grade record anymore.
   * @param deregistree the object that will be removed from observer list
   */
  void remove(Observer deregistree);

  //TODO
  /**
   * Sends an update to all observers when something happens (e.g., a course is added
   * to the grade record).
   */
  void notifyObservers();
}