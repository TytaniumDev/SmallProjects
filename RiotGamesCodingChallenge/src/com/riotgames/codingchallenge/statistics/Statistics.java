package com.riotgames.codingchallenge.statistics;

import java.util.EnumMap;

/**
 * The Class Statistics.
 * This holds all of the player's data for the current game statistics.
 */
public class Statistics
{
   
   /** The stats map. */
   private EnumMap<StatisticType, Integer> statsMap;

   /**
    * Instantiates a new statistics.
    */
   public Statistics()
   {
      statsMap = new EnumMap<StatisticType, Integer>(StatisticType.class);
   }

   /**
    * Sets the statistic.
    *
    * @param type the type
    * @param value the value
    */
   public void setStatistic(StatisticType type, int value)
   {
      statsMap.put(type, value);
   }

   /**
    * Gets the statistic.
    *
    * @param type the type
    * @return the statistic
    */
   public int getStatistic(StatisticType type)
   {
      if (statsMap.containsKey(type))
      {
         return statsMap.get(type);
      }
      else
      {
         // Key not found in the map, something wasn't set

         // For now, just print out to the error stream. In a full
         // implementation, this would throw a custom error.
         System.err
               .println("Error: Statistic not found. Make sure it is set correctly");
         return -1;
      }
   }
}
