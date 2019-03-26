/**
 * TODO javadoc
 */
public interface Subject {

  /**
   * TODO javadoc
   * @param registree
   */
  void add(Observer registree);


  /**
   * TODO javadoc
   * @param registree
   */
  void remove(Observer registree);

  /**
   * TODO javadoc
   */
  void notifyObservers();
}