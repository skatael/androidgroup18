package com.arkanoid;

public class BlockLayout {
//	
//	klasse som brukes til å sette opp blockene for en gitt level
//	1 = crushable
//	2 = uncrushable
//	0 = line break for blockene
	public static String MakeBlocks(int level) {
		
		if(level == 1){
			return "1,1,1,1,0,1,1,1,1";
		}
		else if(level == 2){
			return "1,1,1,1,0,2,1,1,2";
		}
		
		return null;
	}
}
