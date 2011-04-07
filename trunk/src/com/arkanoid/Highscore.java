package com.arkanoid;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author Thomas Marstrander
 *
 * Handles saving new highscores and retrieving current highscores from memory.
 */
public class Highscore {
	private SharedPreferences preferences;
    private String names[];
    private long score[];

    /**
     * @param context current context
     * Retrieves current highscores from memory, and saves them to two arrays.
     */
    public Highscore(Context context)
    {
            preferences = context.getSharedPreferences("Highscore", 0);
            names = new String[10];
            score = new long[10];

            for (int x=0; x<10; x++)
            {
                    names[x] = preferences.getString("name"+x, "-");
                    score[x] = preferences.getLong("score"+x, 0);
            }

    }

    /**
     * @param x 
     * @return name of the x-th position in the Highscore-List
     */
    public String getName(int x)
    {
    	return names[x];
    }

    /**
     * @param x
     * @return get the score of the x-th position in the Highscore-List
     */
    public long getScore(int x)
    {
            return score[x];
    }

    /**
     * @param score
     * @return check if the score is in the Highscore-List
     */
    public boolean inHighscore(long score)
    {
            int position;
            for (position=0; position<10&&this.score[position]>score; position++);
            if (position==10) return false;
            
            return true;
    }

    /**
     * @param name
     * @param score
     * @return add the score with the name to the Highscore-List
     */
    public boolean addScore(String name, long score)
    {
            int position;
            for (position=0; position<10&&this.score[position]>score; position++);
            if (position==10) return false;

            for (int x=9; x>position; x--)
            {
                    names[x]=names[x-1];
                    this.score[x]=this.score[x-1];
            }

            this.names[position] = new String(name);
            this.score[position] = score;

            SharedPreferences.Editor editor = preferences.edit();
            for (int x=0; x<10; x++)
            {
                    editor.putString("name"+x, this.names[x]);
                    editor.putLong("score"+x, this.score[x]);
            }
            editor.commit();
            return true;

    }

}
