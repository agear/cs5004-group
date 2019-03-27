/**
 * The observer design pattern creates a notification scheme between objects that
 * contain data, and other objects that may be interested in monitoring that data
 * and act accordingly. Observers do not have to continuously poll the object they
 * are monitoring to see if they have changed: they simply wait to be notified
 * when the change occurs.
 */
public interface Observer {

  /**
   * Update the observer object with only the relevant information that the observer
   * will need in order to correctly report status.
   */
  void update();


  /** Whatever the thing is that the observer is observing has a return value of
   * true or false -- this returns that value.
   * @return If the thing being observed is true or not.
   */
  boolean getStatus();

}