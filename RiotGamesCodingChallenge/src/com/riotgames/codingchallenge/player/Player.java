package com.riotgames.codingchallenge.player;

import java.util.HashSet;
import java.util.Observable;

import com.riotgames.codingchallenge.achievement.Achievement;
import com.riotgames.codingchallenge.statistics.HistoricalStatistics;
import com.riotgames.codingchallenge.statistics.Statistics;

/**
 * The Class Player. A player holds their historical and current game
 * statistics, as well as a set of all of their earned achievements. The
 * Statistics are set with getters and setters, so in a large scale
 * implementation data could easily be retrieved from a separate data source.
 */
public class Player extends Observable
{

   /** The username. */
   private final String         username;

   /** The stats. */
   private Statistics           stats;

   /** The historical stats. */
   private HistoricalStatistics historicalStats;

   /**
    * This Set with the names of all earned achievements would be retrieved from
    * a database to have achievements carry over between games.
    */
   private HashSet<Achievement> achievements;

   /**
    * Instantiates a new player.
    * 
    * @param username
    *           the username of the player
    */
   public Player(String username)
   {
      this.username = username;
      this.stats = new Statistics();
      this.historicalStats = new HistoricalStatistics();
      this.achievements = new HashSet<Achievement>();
      // This is where data could be retrieved from a database
   }

   /**
    * Prints the achievements using toString.
    */
   public void printAchievements()
   {
      for (Achievement data : achievements)
      {
         System.out.println("Player " + username
               + " has earned the achievement " + data.toString() + "!");
      }
   }

   /**
    * Check all achievements. If an achievement is earned it is added to the
    * achievements set.
    */
   public void checkAchievements()
   {
      for (Achievement achievement : Achievement.values())
      {
         if (!(achievements.contains(achievement)))
         {
            // Player doesn't already have achievement, check if they do now
            if (achievement.isEarned(this))
            {
               // Player earned a new achievement!
               achievements.add(achievement);
            }
         }
      }
      notifyObservers();
   }

   /**
    * Gets the historical stats.
    * 
    * @return the historicalStats
    */
   public HistoricalStatistics getHistoricalStats()
   {
      return historicalStats;
   }

   /**
    * Sets the historical stats.
    * 
    * @param historicalStats
    *           the historicalStats to set
    */
   public void setHistoricalStats(HistoricalStatistics historicalStats)
   {
      this.historicalStats = historicalStats;
   }

   /**
    * Gets the stats.
    * 
    * @return the stats
    */
   public Statistics getStats()
   {
      return stats;
   }

   /**
    * Sets the stats.
    * 
    * @param stats
    *           the stats to set
    */
   public void setStats(Statistics stats)
   {
      this.stats = stats;
   }

   /**
    * Gets the username.
    * 
    * @return the username
    */
   public String getUsername()
   {
      return username;
   }

   /**
    * Gets the achievements.
    * 
    * @return the achievements
    */
   public HashSet<Achievement> getAchievements()
   {
      return achievements;
   }
}
