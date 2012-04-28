package com.riotgames.codingchallenge.statistics;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StatisticsTest
{
   Statistics test;

   @Before
   public void setUp()
   {
      test = new Statistics();
   }

   @Test
   public void testGettersAndSetters()
   {
      test.setStatistic(StatisticType.ASSISTS, 10);
      assertTrue(test.getStatistic(StatisticType.ASSISTS) == 10);
   }
}
