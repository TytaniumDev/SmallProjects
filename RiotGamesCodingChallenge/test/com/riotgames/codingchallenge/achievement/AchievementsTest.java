package com.riotgames.codingchallenge.achievement;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.riotgames.codingchallenge.achievement.Achievement;
import com.riotgames.codingchallenge.player.Player;
import com.riotgames.codingchallenge.statistics.HistoricalStatisticType;
import com.riotgames.codingchallenge.statistics.HistoricalStatistics;
import com.riotgames.codingchallenge.statistics.Statistics;
import com.riotgames.codingchallenge.statistics.StatisticType;

public class AchievementsTest
{
   private Player               test;
   private Statistics           stats;
   private HistoricalStatistics historicalStats;

   @Before
   public void setUp()
   {
      test = new Player("test");
      stats = new Statistics();
      historicalStats = new HistoricalStatistics();
   }

   @Test
   public void testSharpshooterisEarned()
   {
      stats.setStatistic(StatisticType.ATTEMPTED_ATTACKS, 10);
      // Hit 0 of 10 hits, not 75%
      stats.setStatistic(StatisticType.HITS, 0);
      test.setStats(stats);
      assertFalse(Achievement.SHARPSHOOTER.isEarned(test));
      // Hit 7 of 10 hits, not 75%
      stats.setStatistic(StatisticType.HITS, 7);
      test.setStats(stats);
      assertFalse(Achievement.SHARPSHOOTER.isEarned(test));
      // Hit 8 of 10 hits, over 75&
      stats.setStatistic(StatisticType.HITS, 8);
      test.setStats(stats);
      assertTrue(Achievement.SHARPSHOOTER.isEarned(test));
      // Hit 10 of 10 hits, over 75&
      stats.setStatistic(StatisticType.HITS, 10);
      test.setStats(stats);
      assertTrue(Achievement.SHARPSHOOTER.isEarned(test));
   }

   @Test
   public void testBruiserisEarned()
   {
      // 0 damage does not earn achievement
      stats.setStatistic(StatisticType.TOTAL_DAMAGE_DONE, 0);
      test.setStats(stats);
      assertFalse(Achievement.BRUISER.isEarned(test));
      // 500 damage does not earn achievement
      stats.setStatistic(StatisticType.TOTAL_DAMAGE_DONE, 500);
      test.setStats(stats);
      assertFalse(Achievement.BRUISER.isEarned(test));
      // 501 damage does earn achievement
      stats.setStatistic(StatisticType.TOTAL_DAMAGE_DONE, 501);
      test.setStats(stats);
      assertTrue(Achievement.BRUISER.isEarned(test));
      // 900 damage does earn achievement
      stats.setStatistic(StatisticType.TOTAL_DAMAGE_DONE, 900);
      test.setStats(stats);
      assertTrue(Achievement.BRUISER.isEarned(test));
   }
   
   @Test
   public void testVeteranisEarned()
   {
      // 0 wins does not earn achievement
      historicalStats.setHistoricalStatistic(HistoricalStatisticType.TOTAL_GAMES_PLAYED, 0);
      test.setHistoricalStats(historicalStats);
      assertFalse(Achievement.VETERAN.isEarned(test));
      // 1000 wins does not earn achievement
      historicalStats.setHistoricalStatistic(HistoricalStatisticType.TOTAL_GAMES_PLAYED, 1000);
      test.setHistoricalStats(historicalStats);
      assertFalse(Achievement.VETERAN.isEarned(test));
      // 1001 wins does earn achievement
      historicalStats.setHistoricalStatistic(HistoricalStatisticType.TOTAL_GAMES_PLAYED, 1001);
      test.setHistoricalStats(historicalStats);
      assertTrue(Achievement.VETERAN.isEarned(test));
      // 10000 wins does earn achievement
      historicalStats.setHistoricalStatistic(HistoricalStatisticType.TOTAL_GAMES_PLAYED, 10000);
      test.setHistoricalStats(historicalStats);
      assertTrue(Achievement.VETERAN.isEarned(test));
   }
   
   @Test
   public void testBigWinnerisEarned()
   {
      // 0 wins does not earn achievement
      historicalStats.setHistoricalStatistic(HistoricalStatisticType.TOTAL_WINS, 0);
      test.setHistoricalStats(historicalStats);
      assertFalse(Achievement.BIG_WINNER.isEarned(test));
      // 199 wins does not earn achievement
      historicalStats.setHistoricalStatistic(HistoricalStatisticType.TOTAL_WINS, 199);
      test.setHistoricalStats(historicalStats);
      assertFalse(Achievement.BIG_WINNER.isEarned(test));
      // 200 wins does earn achievement
      historicalStats.setHistoricalStatistic(HistoricalStatisticType.TOTAL_WINS, 200);
      test.setHistoricalStats(historicalStats);
      assertTrue(Achievement.BIG_WINNER.isEarned(test));
      // 500 wins does earn achievement
      historicalStats.setHistoricalStatistic(HistoricalStatisticType.TOTAL_WINS, 500);
      test.setHistoricalStats(historicalStats);
      assertTrue(Achievement.BIG_WINNER.isEarned(test));
   }
   
   @Test
   public void testSnowballerisEarned()
   {
      // 1 death, 5 kills does not earn achievement
      stats.setStatistic(StatisticType.DEATHS, 1);
      stats.setStatistic(StatisticType.KILLS, 5);
      test.setStats(stats);
      assertFalse(Achievement.SNOWBALLER.isEarned(test));
      // 1 death, 10 kills does not earn achievement
      stats.setStatistic(StatisticType.DEATHS, 1);
      stats.setStatistic(StatisticType.KILLS, 10);
      test.setStats(stats);
      assertFalse(Achievement.SNOWBALLER.isEarned(test));
      // 0 death, 5 kills does not earn achievement
      stats.setStatistic(StatisticType.DEATHS, 0);
      stats.setStatistic(StatisticType.KILLS, 5);
      test.setStats(stats);
      assertFalse(Achievement.SNOWBALLER.isEarned(test));
      // 0 death, 10 kills does earn achievement
      stats.setStatistic(StatisticType.DEATHS, 0);
      stats.setStatistic(StatisticType.KILLS, 10);
      test.setStats(stats);
      assertTrue(Achievement.SNOWBALLER.isEarned(test));
      // 0 death, 100 kills does earn achievement
      stats.setStatistic(StatisticType.DEATHS, 0);
      stats.setStatistic(StatisticType.KILLS, 100);
      test.setStats(stats);
      assertTrue(Achievement.SNOWBALLER.isEarned(test));
   }
   
   @Test
   public void testGetNames()
   {
      assertTrue(Achievement.SHARPSHOOTER.getName().equals("Sharpshooter"));
      assertTrue(Achievement.BRUISER.getName().equals("Bruiser"));
      assertTrue(Achievement.VETERAN.getName().equals("Veteran"));
      assertTrue(Achievement.BIG_WINNER.getName().equals("Big Winner"));
      assertTrue(Achievement.SNOWBALLER.getName().equals("Snowballer"));
   }
   
   @Test
   public void testToStrings()
   {
      assertTrue(Achievement.SHARPSHOOTER.toString().equals("Sharpshooter"));
      assertTrue(Achievement.BRUISER.toString().equals("Bruiser"));
      assertTrue(Achievement.VETERAN.toString().equals("Veteran"));
      assertTrue(Achievement.BIG_WINNER.toString().equals("Big Winner"));
      assertTrue(Achievement.SNOWBALLER.toString().equals("Snowballer"));
   }
}
