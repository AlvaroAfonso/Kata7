package kata7.control;

import kata7.model.Block;

/**
 *
 * @author alvaroafonsolopez
 */
public class LeftCommand implements Command {
    private final Block block;

    public LeftCommand(Block block) {
        this.block = block;
    }
    
    @Override
    public void execute() {
        block.left();
    }
    
}
