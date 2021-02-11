package kata7.control;

import kata7.model.Block;

/**
 *
 * @author alvaroafonsolopez
 */
public class DownCommand implements Command{
    

    private final Block block;

    public DownCommand(Block block) {
        this.block = block;
    }
    
    @Override
    public void execute() {
        block.down();
    }
    
}