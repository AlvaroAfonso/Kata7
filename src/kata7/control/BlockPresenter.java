package kata7.control;

import kata7.model.Block;
import kata7.view.BlockDisplay;
import kata7.view.BlockDisplay.Moved;

/**
 *
 * @author alvaroafonsolopez
 */
public class BlockPresenter implements Block.Observer {
    private Block block;
    private BlockDisplay bDisplay;
    public static final int SIZE =100;


    public BlockPresenter(Block block, BlockDisplay bDisplay) {
        this.block = block;
        this.bDisplay = bDisplay;
        bDisplay.on(new Moved() {
            @Override
            public void to(int x, int y) {
                block.moveTo(x / 100 + 1, Block.MAX - y / 100);
            }
        });
        block.register(this);
        refresh();
    }

    private void refresh() {
        bDisplay.paintBlock((block.x()-1)*SIZE, (Block.MAX - block.y())*SIZE);
    }

    @Override
    public void changed() {
        refresh();
    }
    
    
}
