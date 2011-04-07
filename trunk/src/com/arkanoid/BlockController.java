package com.arkanoid;

import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;

public class BlockController {
	
	private Arkanoid ark;
	//Block Textures
    private Texture blTexture;
    private TextureRegion mBlockTextureRegion;
    
    //
    private final Block[] blocks;
	
	public BlockController(Arkanoid ark){
		this.ark = ark;
		blTexture = new Texture(128, 32, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        mBlockTextureRegion = TextureRegionFactory.createFromAsset(this.blTexture, ark, "gfx/block.png", 0, 0);
        ark.getEngine().getTextureManager().loadTexture(this.blTexture);
        removeBlock();
        
        
        blocks = makeBlocks(); 
  
		
	}
	
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

	public Block[] getBlocks(){
		return blocks;
	}
	

}
