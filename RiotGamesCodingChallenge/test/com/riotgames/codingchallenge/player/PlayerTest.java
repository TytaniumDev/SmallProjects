package com.riotgames.codingchallenge.player;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.riotgames.codingchallenge.statistics.HistoricalStatisticType;
import com.riotgames.codingchallenge.statistics.HistoricalStatistics;
import com.riotgames.codingchallenge.statistics.StatisticType;
import com.riotgames.codingchallenge.statistics.Statistics;

public class PlayerTest
{
   Player test;

   @Before
   public void setUp()
   {
      test = new Player("test");
   }

   @Test
   public void testConstructor()
   {
      assertTrue(test.getUsername().equals("test"));
      assertTrue(test.getAchievements() != null);
      assertTrue(test.getHistoricalStats() != null);
      assertTrue(test.getStats() != null);
   }

   // Not testing printAchievements, as it just prints to System.out

   @Test
   public void testCheckAchievements()
   {
      // Test to make sure it adds achievements. Actual achievement
      // functionality is tested elsewhere.
      addStats(test, 100, 74, 8020, 10, 10, 0, 10, 2000, 30, 0);
      addHStats(test, 1000, 30000, 9000, 200, 1);
      test.checkAchievements();
      //Irelia earns Snowballer, Big Winner, and Bruiser
      assertTrue(test.getAchievements().size() == 3);
   }

   @Test
   public void testGettersAndSetters()
   {
      HistoricalStatistics hs = new HistoricalStatistics();
      hs.setHistoricalStatistic(HistoricalStatisticType.TOTAL_KILLS, 10);
      test.setHistoricalStats(hs);
      assertTrue(test.getHistoricalStats().equals(hs));

      Statistics s = new Statistics();
      s.setStatistic(StatisticType.ASSISTS, 10);
      test.setStats(s);
      assertTrue(test.getStats().equals(s));

      // Getter for getAchievements is tested in testCheckAchievements
   }

   private static void addStats(Player player, int attemptedAttacks, int hits,
         int totalDamage, int kills, int firstHitKills, int assists,
         int spellsCast, int spellDamageDone, int timePlayed, int deaths)
   {
      Statistics stats = new Statistics();
      stats.setStatistic(StatisticType.ATTEMPTED_ATTACKS, attemptedAttacks);
      stats.setStatistic(StatisticType.HITS, hits);
      stats.setStatistic(StatisticType.TOTAL_DAMAGE_DONE, totalDamage);
      stats.setStatistic(StatisticType.KILLS, kills);
      stats.setStatistic(StatisticType.FIRST_HIT_KILLS, firstHitKills);
      stats.setStatistic(StatisticType.ASSISTS, assists);
      stats.setStatistic(StatisticType.SPELLS_CAST, spellsCast);
      stats.setStatistic(StatisticType.SPELL_DAMAGE_DONE, spellDamageDone);
      stats.setStatistic(StatisticType.TIME_PLAYED, timePlayed);
      stats.setStatistic(StatisticType.DEATHS, deaths);
      player.setStats(stats);
   }
   
   public static void addHStats(Player player, int totalGames, int duration, int kills, int wins, int losses)
   {
      HistoricalStatistics stats = new HistoricalStatistics();
      stats.setHistoricalStatistic(HistoricalStatisticType.TOTAL_GAMES_PLAYED, totalGames);
      stats.setHistoricalStatistic(HistoricalStatisticType.TOTAL_DURATION_OF_GAMES, duration);
      stats.setHistoricalStatistic(HistoricalStatisticType.TOTAL_KILLS, kills);
      stats.setHistoricalStatistic(HistoricalStatisticType.TOTAL_WINS, wins);
      stats.setHistoricalStatistic(HistoricalStatisticType.TOTAL_LOSSES, losses);
      player.setHistoricalStats(stats);
   }
}
