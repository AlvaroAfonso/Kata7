package kata7.view;

/**
 *
 * @author alvaroafonsolopez
 */
public interface BlockDisplay {

    public void paintBlock(int x, int y);
    
    public void on(Moved moved);
    
    public interface Moved {
        void to(int x, int y);
    }
}
