package kata7.app;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import kata7.control.BlockPresenter;
import kata7.control.Command;
import kata7.control.DownCommand;
import kata7.control.LeftCommand;
import kata7.control.RightCommand;
import kata7.control.UpCommand;
import kata7.model.Block;
import kata7.view.BlockDisplay;

/**
 *
 * @author alvaroafonsolopez
 */
public class Main extends JFrame{

    private Block block;
    private BlockDisplay blockDisplay;
    private Map<String,Command> commands;
    private BlockPresenter blockPresenter;

    public static void main(String[] args) {
        new Main().execute();
    }
    
    public Main(){
        this.setTitle("Block shifter");
        this.setSize(700,720);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(blockPanel());
        this.add(toolbar(),BorderLayout.SOUTH);        
    }

    private void execute() {
        this.block=new Block();
        this.commands=createCommands();
        this.blockPresenter = new BlockPresenter(block,blockDisplay);
        this.setVisible(true);
    
    }

    private BlockPanel blockPanel() {
        BlockDisplay blockPanel=new BlockPanel(Block.MAX, BlockPresenter.SIZE);
        this.blockDisplay=blockPanel;
        return (BlockPanel) blockPanel;
    }

    private Component toolbar() {
        JMenuBar toolbar = new JMenuBar();
        toolbar.setLayout(new FlowLayout(FlowLayout.CENTER));
        toolbar.add(button("L"));
        toolbar.add(button("R"));
        toolbar.add(button("U"));
        toolbar.add(button("D"));
        return toolbar;
    }

    private HashMap<String, Command> createCommands() {
        HashMap<String,Command> comms = new HashMap<String,Command>();
        comms.put("U", new UpCommand(this.block));
        comms.put("D", new DownCommand(this.block));
        comms.put("L", new LeftCommand(this.block));
        comms.put("R", new RightCommand(this.block));
        return comms;
    }

    private JButton button(String l) {
        JButton boton=new JButton(l);
        boton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get(l).execute();
            }
        
        });
        return boton;
                
    }
    
}