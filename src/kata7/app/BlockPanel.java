package kata7.app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import kata7.view.BlockDisplay;

/**
 *
 * @author alvaroafonsolopez
 */
class BlockPanel extends JPanel implements BlockDisplay{
    
    private int x;
    private int y;
    private final int max;
    private final int size;
    private final MouseHandler mouseHandler;
    private Moved moved;
    
    public BlockPanel(int max, int size){
        this.max = max;
        this.size = size;
        this.mouseHandler = new MouseHandler();
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
    }
    
    @Override
    public void paint(Graphics g){
        
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        
        int m=max*size;
        
        for (int i = 0; i <= max; i++) {
            int d= i*100;
            g.drawLine(0, d, m, d);
            g.drawLine(d, 0, d,m);
        }
        
        g.setColor(Color.RED);
        g.fillRect(x,y,size,size);
    }

    @Override
    public void paintBlock(int x, int y) {
        this.x = x;
        this.y = y;
        repaint();
    }

    @Override
    public void on(Moved moved) {
        this.moved = moved;
    }

    private class MouseHandler implements MouseListener, MouseMotionListener{

        private boolean pressed;

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if(e.getX() < x || e.getX() > x + size) return;
            if(e.getY() < y || e.getY() > y + size) return;
            pressed = true;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            pressed = false;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            moved.to(e.getX(),e.getY());
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            
        }
        
    }
    
}
