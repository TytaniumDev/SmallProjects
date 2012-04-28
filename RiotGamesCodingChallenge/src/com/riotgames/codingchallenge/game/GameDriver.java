package com.riotgames.codingchallenge.game;

import java.util.ArrayList;

import com.riotgames.codingchallenge.player.Player;
import com.riotgames.codingchallenge.statistics.HistoricalStatisticType;
import com.riotgames.codingchallenge.statistics.HistoricalStatistics;
import com.riotgames.codingchallenge.statistics.StatisticType;
import com.riotgames.codingchallenge.statistics.Statistics;


public class GameDriver
{
   public static void main(String[] args)
   {
      ArrayList<Player> TeamA = new ArrayList<Player>();
      ArrayList<Player> TeamB = new ArrayList<Player>();
      
      //Create a 3v3
      //Team A
      Player Alistar = new Player("Alistar");
      Player Amumu = new Player("Amumu");
      Player Irelia = new Player("Irelia");
      //Team B
      Player Gangplank = new Player("Gangplank");
      Player Soraka = new Player("Soraka");
      Player Sona = new Player("Sona");
      
      //Add statistics (The game client would do this at the end of the game)
      addStats(Alistar, 0, 0, 0, 0, 5, 10, 1000, 2000, 30, 10); //No achievements
      addStats(Amumu, 0, 0, 0, 0, 10, 10, 1000, 2000, 30, 5); //No achievements
      addStats(Irelia, 100, 74, 8020, 10, 10, 0, 10, 2000, 30, 0); //Earns Bruiser for 8020 damage, and Snowballer for 10 kills 0 deaths
      
      addStats(Gangplank, 100, 90, 10000, 10, 10, 0, 0, 2000, 30, 3); //Earns Bruiser for 10000 damage, Sharpshooter for hitting 90 of 100 attacks
      addStats(Soraka, 10, 7, 20, 2, 2, 10, 1000, 2000, 30, 5);//No achievements
      addStats(Sona, 10, 8, 30, 3, 0, 10, 1000, 2000, 30, 2);//Earns Sharpshooter for hitting 8 out of 10 attacks
      
      //Add historical statistics (Would be retrieved from a database)
      addHStats(Alistar, 1, 30, 0, 0, 1);//No achievements
      addHStats(Amumu, 10, 3000, 50, 7, 3);//No achievements
      addHStats(Irelia, 1000, 30000, 9000, 200, 1);//Earns Big Winner for 200 wins
      
      addHStats(Gangplank, 2000, 999999, 300, 1950, 50);//Earns Veteran for 2000 games played, and Big Winner for winning 1950 games
      addHStats(Soraka, 1, 30, 0, 0, 1);//No achievements
      addHStats(Sona, 1, 30, 0, 0, 1);//No achievements
      
      //Add players to teams after data is entered
      TeamA.add(Alistar);
      TeamA.add(Amumu);
      TeamA.add(Irelia);
      
      TeamA.add(Gangplank);
      TeamA.add(Soraka);
      TeamA.add(Sona);
      
      //Calculate achievements for both teams
      for(Player player : TeamA)
      {
         player.checkAchievements();
      }
      for(Player player : TeamB)
      {
         player.checkAchievements();
      }
      
      //Print out all achievements
      for(Player player : TeamA)
      {
         player.printAchievements();
      }
      for(Player player : TeamB)
      {
         player.printAchievements();
      }
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
