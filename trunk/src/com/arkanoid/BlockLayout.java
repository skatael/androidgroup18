package com.arkanoid;
/**
 * class used to setup the blocks for a given level
 * @author dahl
 *
 */
public class BlockLayout {
	/**
	 * array of blocks
	 */
	private static int[] blocks;
	/**
	 * constructs the blockarray based on which level the game is on
	 * @param level which level is currently being played
	 * @return the array of blocks
	 */
	public static int[] MakeBlocks(int level) {
		
		
		if(level == 1){
			int[] blocks = {1,1,1,0,1,1,1};
			return blocks;
		}
		else if(level == 2){
			int[] blocks = {1,1,1,0,1,2,1};
			return blocks;
		}
		
		return null;
	}
}
