/**
 * TODO javadoc
 */
public interface Subject {

  /**
   * TODO javadoc
   */
  void register(Observer registree);


  /**
   * TODO javadoc
   */
  void remove(Observer registree);

  /**
   * TODO javadoc
   */
  void notifyObservers();
}