package com.arkanoid;

import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
/**
 * 
 * @author Anders Dahl, Kenneth J Wannebo
 *
 */
public class BlockController {
	/**
	 * The Arkanoid object
	 */
	private Arkanoid ark;
	/**
	 * Block texture
	 */
    private Texture blTexture;
    /**
     * TextureRegion for the block
     */
    private TextureRegion mBlockTextureRegion;
    /**
     * Array of blocks
     */
    private final Block[] blocks;
    
	/**
	 * Constructor for the Block controller
	 * Takes the Arkanoid object as parameter, initialises the block texture and creates the block-sprites.
	 * @param ark
	 */
	public BlockController(Arkanoid ark){
		this.ark = ark;
		blTexture = new Texture(128, 32, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        mBlockTextureRegion = TextureRegionFactory.createFromAsset(this.blTexture, ark, "gfx/block.png", 0, 0);
        ark.getEngine().getTextureManager().loadTexture(this.blTexture);
        
        
        blocks = makeBlocks(); 
  
		
	}
	/**
	 * Method that makes an array of Block objects from the BlockLayout class.
	 * @return Block[]
	 */
	private Block[] makeBlocks(){
		
		
		int level = 2;
        int[] blockArray = BlockLayout.MakeBlocks(level);
        int j = 0;
        
        Block[] blocks = new Block[6];
        
        int xPos =40, yPos = 50;

        for(int i = 0;i < blockArray.length; i++){
        	if(blockArray[i] == 1){
        		blocks[j] = new Block(xPos, yPos, this.mBlockTextureRegion, ark);
        		xPos+=128;
        		j++;
        	}else if(blockArray[i] == 2){
        		blocks[j] = new Block(xPos, yPos, this.mBlockTextureRegion, ark);
        		xPos+=128;
        		j++;
        	}else if(blockArray[i] == 0){
        		yPos+=32;
        		xPos = 40;
        	}
        }
		
		
		return blocks;
	}
	/**
	 * Method that creates a thread that checks if any of the blocks have been marked for removal,
	 * and then removes them from from the scene object in Arkanoid .
	 */
	public void removeBlock(){

		ark.runOnUpdateThread(new Runnable() {
            @Override
            public void run() {
                    /* Now it is save to remove the entity! */
            	for (int i = 0; i < blocks.length; i++) {
					if(blocks[i].getDestroy()){
						ark.getEngine().getScene().getLastChild().detachChild(blocks[i]);
					}
				}
            	
            	
            	
        			
        			
        	}
            
		});
		
	}
	/**
	 * Method that returns the Block array
	 * @return Block[]
	 */
	public Block[] getBlocks(){
		return blocks;
	}
	

}
