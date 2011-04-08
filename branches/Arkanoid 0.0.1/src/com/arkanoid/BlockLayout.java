package com.arkanoid;

public class BlockLayout {
//	
//	klasse som brukes til å sette opp blockene for en gitt level
//	1 = crushable
//	2 = uncrushable
//	0 = line break for blockene
	private static int[] blocks;
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
