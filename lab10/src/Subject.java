/**
 * TODO javadoc
 */
public interface Subject {

  /**
   * TODO javadoc
   */
  void register(Observer registree);


  /**
   * TODO probably not strictly necessary for this assignment. TODO javadoc
   */
  void remove(Observer registree);

  /**
   * TODO javadoc
   */
  void notifyObservers();
}