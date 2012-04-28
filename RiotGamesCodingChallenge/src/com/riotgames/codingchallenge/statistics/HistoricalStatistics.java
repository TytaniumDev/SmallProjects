package com.riotgames.codingchallenge.statistics;

import java.util.EnumMap;

/**
 * The Class HistoricalStatistics.
 */
public class HistoricalStatistics
{
   
   /** The stats map. */
   private EnumMap<HistoricalStatisticType, Integer> statsMap;

   /**
    * Instantiates a new historical statistics.
    */
   public HistoricalStatistics()
   {
      statsMap = new EnumMap<HistoricalStatisticType, Integer>(
            HistoricalStatisticType.class);
   }

   /**
    * Sets the historical statistic.
    *
    * @param type the type
    * @param value the value
    */
   public void setHistoricalStatistic(HistoricalStatisticType type, int value)
   {
      statsMap.put(type, value);
   }

   /**
    * This method could be changed to grab data from an existing database with
    * historical statistics upon integration with the rest of the game.
    * 
    * @param type
    *           The historical statistic type wanted
    * @return The value of the historical statistic requested.
    */
   public int getHistoricalStatistic(HistoricalStatisticType type)
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
               .println("Error: Historical Statistic not found. Make sure it is set correctly");
         return -1;
      }
   }
}
