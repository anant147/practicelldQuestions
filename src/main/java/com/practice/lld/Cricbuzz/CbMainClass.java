package com.practice.lld.Cricbuzz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CbMainClass {
	
	public static void main(String[] args) {
		
		int mid = 1;
		// make players
		List<Player> team1Players = getPlayerOfTeam1(); 
		
		List<Player> team2Players = getPlayerOfTeam2(); 
		
		// make match players
		List<MatchPlayer> team1MatchPlayers = getMatchPlayers(mid, team1Players);
		
		List<MatchPlayer> team2MatchPlayers = getMatchPlayers(mid, team2Players);

		// make two team from players
//		Team(int tid, String tname, List<MatchPlayer> playingElevens, int maxOver, int totalOver)
		Team team1 = new Team(1, "team1", team1MatchPlayers, 1, 4);
		Team team2 = new Team(2, "team2", team2MatchPlayers, 1, 4);
		
		// make match
//		Match(int mid, Team teamA, Team teamB, String date, String venue, int totalOver, int maxOverByBowler)
		Match match = new Match(1, team1, team2, "16-07-2024", "Noida", 1, 1);
		
		// start match
		match.playGame();
		
	}
	
	private static List<MatchPlayer> getMatchPlayers(int mid, List<Player> teamPlayers) {
		List<MatchPlayer> mps = new ArrayList<>();
		
		for (Player player : teamPlayers) {
			int mpid = mid*10+player.pid;
			mps.add( new MatchPlayer(mpid, mid, player));
		}
		return mps;
	}

	public static List<Player> getPlayerOfTeam1(){
		List<Player> teamPlayers = new ArrayList<>();
		
		teamPlayers.add( new Player(11, "t1-player11", Arrays.asList(PlayerType.BATSMAN, PlayerType.CAPTAIN)) );
		teamPlayers.add( new Player(12, "t1-player12", Arrays.asList(PlayerType.BATSMAN, PlayerType.WICKET_KEEPER)) );
		teamPlayers.add( new Player(13, "t1-player13", Arrays.asList(PlayerType.BATSMAN )));
		teamPlayers.add( new Player(14, "t1-player14", Arrays.asList(PlayerType.BATSMAN )));
		teamPlayers.add( new Player(15, "t1-player15", Arrays.asList(PlayerType.BATSMAN )));
		teamPlayers.add( new Player(16, "t1-player16", Arrays.asList(PlayerType.ALL_ROUNDER )));
		teamPlayers.add( new Player(17, "t1-player17", Arrays.asList(PlayerType.BOWLER )));
		teamPlayers.add( new Player(18, "t1-player18", Arrays.asList(PlayerType.BOWLER )));
		teamPlayers.add( new Player(19, "t1-player19", Arrays.asList(PlayerType.BOWLER )));
		teamPlayers.add( new Player(20, "t1-player20", Arrays.asList(PlayerType.BOWLER )));
		teamPlayers.add( new Player(21, "t1-player21", Arrays.asList(PlayerType.BOWLER )));
		
		return teamPlayers;
	}
	
	public static List<Player> getPlayerOfTeam2(){
		List<Player> teamPlayers = new ArrayList<>();
		
		teamPlayers.add( new Player(31, "t2-player31", Arrays.asList(PlayerType.BATSMAN, PlayerType.CAPTAIN)) );
		teamPlayers.add( new Player(32, "t2-player32", Arrays.asList(PlayerType.BATSMAN, PlayerType.WICKET_KEEPER)) );
		teamPlayers.add( new Player(33, "t2-player33", Arrays.asList(PlayerType.BATSMAN )));
		teamPlayers.add( new Player(34, "t2-player34", Arrays.asList(PlayerType.BATSMAN )));
		teamPlayers.add( new Player(35, "t2-player35", Arrays.asList(PlayerType.BATSMAN )));
		teamPlayers.add( new Player(36, "t2-player36", Arrays.asList(PlayerType.ALL_ROUNDER )));
		teamPlayers.add( new Player(37, "t2-player37", Arrays.asList(PlayerType.BOWLER )));
		teamPlayers.add( new Player(38, "t2-player38", Arrays.asList(PlayerType.BOWLER )));
		teamPlayers.add( new Player(39, "t2-player39", Arrays.asList(PlayerType.BOWLER )));
		teamPlayers.add( new Player(40, "t2-player40", Arrays.asList(PlayerType.BOWLER )));
		teamPlayers.add( new Player(41, "t2-player41", Arrays.asList(PlayerType.BOWLER )));
		
		return teamPlayers;
	}
}
