package com.riotgames.codingchallenge.statistics;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HistoricalStatisticsTest
{
   HistoricalStatistics test;

   @Before
   public void setUp()
   {
      test = new HistoricalStatistics();
   }

   @Test
   public void testGettersAndSetters()
   {
      test.setHistoricalStatistic(HistoricalStatisticType.TOTAL_WINS, 10);
      assertTrue(test.getHistoricalStatistic(HistoricalStatisticType.TOTAL_WINS) == 10);
   }
}
