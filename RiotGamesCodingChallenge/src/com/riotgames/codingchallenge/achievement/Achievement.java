package com.riotgames.codingchallenge.achievement;

import com.riotgames.codingchallenge.player.Player;
import com.riotgames.codingchallenge.statistics.HistoricalStatisticType;
import com.riotgames.codingchallenge.statistics.Statistics;
import com.riotgames.codingchallenge.statistics.StatisticType;

/**
 * The Achievement Enum.
 * 
 * This enum holds all of the possible achievements for the game.
 * 
 * To add a new achievement, simply create a new type in the enum. The name of
 * the achievement is the first value in the constructor, and all achievements
 * need to implement the isEarned method to determine if the player has earned
 * the achievement or not. This makes it extremely easy to add new achievements.
 * All other classes interact with Achievement as a whole so it is possible to
 * add an unlimited number of achievements by only changing this class.
 * 
 * @author Tyler Holland
 */
public enum Achievement
{
   /**
    * The "Sharpshooter" Award: 
    * A user receives this for landing 75% of their
    * attacks, assuming they have at least attacked once.
    */
   SHARPSHOOTER("Sharpshooter")
   {
      public boolean isEarned(Player player)
      {
         Statistics stats = player.getStats();
         int attempts = stats.getStatistic(StatisticType.ATTEMPTED_ATTACKS);
         int hits = stats.getStatistic(StatisticType.HITS);

         // Check to see if they have attacked at least once
         if (attempts > 0)
         {
            // If at least 75% hits, achievement earned
            // Using ints and not getting floats involved
            if (((hits * 100) / attempts) >= 75)
            {
               return true;
            }
         }
         return false;
      }
   },

   /**
    * The “Bruiser” Award: 
    * A user receives this for doing more than 500 points
    * of damage in one game
    */
   BRUISER("Bruiser")
   {
      public boolean isEarned(Player player)
      {
         return player.getStats().getStatistic(StatisticType.TOTAL_DAMAGE_DONE) > 500;
      }
   },

   /**
    * The "Veteran” Award: 
    * A user receives this for playing more than 1000 games
    * in their lifetime.
    */
   VETERAN("Veteran")
   {
      public boolean isEarned(Player player)
      {
         return player.getHistoricalStats().getHistoricalStatistic(
               HistoricalStatisticType.TOTAL_GAMES_PLAYED) > 1000;
      }
   },

   /** The “Big Winner” Award: 
    * A user receives this for having 200 wins. */
   BIG_WINNER("Big Winner")
   {
      public boolean isEarned(Player player)
      {
         return player.getHistoricalStats().getHistoricalStatistic(
               HistoricalStatisticType.TOTAL_WINS) >= 200;
      }
   },
   /**
    * The"Snowballer" Award: 
    * A user receives this for having at least 10 kills
    * in a game without dying.
    */
   SNOWBALLER("Snowballer")
   {
      public boolean isEarned(Player player)
      {
         Statistics stats = player.getStats();
         int deaths = stats.getStatistic(StatisticType.DEATHS);
         int kills = stats.getStatistic(StatisticType.KILLS);
         // Check to see if they died
         if (deaths == 0)
         {
            // Check kills
            if (kills >= 10)
            {
               return true;
            }
         }
         return false;
      }
   };

   /** The name. */
   private final String name; // Achievement name

   /**
    * Instantiates a new achievement.
    * 
    * @param name
    *           The name of the achievement
    */
   Achievement(String name)
   {
      this.name = name;
   }

   /**
    * Gets the name.
    * 
    * @return the name
    */
   public String getName()
   {
      return name;
   }

   /**
    * Override the toString so that if extra text needs to be added 
    * to the display of an achievement without changing the name, 
    * it can be added here.
    */
   @Override
   public String toString()
   {
      return name;
   }

   /**
    * Checks if the achievement is earned.
    * 
    * @param player
    *           the player
    * @return true, if the player has earned the achievement.
    */
   public abstract boolean isEarned(Player player);
}
