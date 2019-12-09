package br.com.drborsato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author: Daniel Borsato Date: 12/9/19
 */
public class QuintoAndar {
	// you can also use imports, for example:
	// import java.util.*;

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");

	class Solution {
		public int solution(int[] A) {
	        //check corner cases
			if (A == null || A.length == 0) {
				return 0;
			}
			if (A.length == 1) {
				return 1;
			}
			
			int totalCastles = 1;
			int actualHeigth = A[0];
			boolean isDownhill = true;
			int i = 1;
			//find if position 0 is valley or hill
			for (i = 1; i < A.length; i++) {
			    if (A[i] <  actualHeigth) {
	        		isDownhill = true;
			        break;
			    }
			    if (A[i] >  actualHeigth) {
			       isDownhill = false;
			        break;
			    }
			}
			
			
	        for (i++; i < A.length; i++) {
	        	if (isValleyOrHill(actualHeigth, A[i], isDownhill)) {
	        		totalCastles++;
	        	}
	        	if (A[i] > A[i-1]) {
	        		isDownhill = false;
	        	}
	        	if (A[i] < A[i-1]) {
	        		isDownhill = true;
	        	}
	        	actualHeigth = A[i];
	        }
	        
	        if(A[A.length-1] != A[A.length-2]) {
	            totalCastles++;
	        }
	        
			return totalCastles;
	    }
		
		private boolean isValleyOrHill(int actualHeigth, int i, boolean isDownhill) {
			return isValley(actualHeigth, i, isDownhill) || isHill(actualHeigth, i, isDownhill);
			
		}
		
		public boolean isValley(int previous, int actual, boolean isDownhill) {
			return (actual > previous) && isDownhill;
		}
		
		public boolean isHill(int previous, int actual, boolean isDownhill) {
			return (actual < previous) && !isDownhill;
		}
	}

	// you can also use imports, for example:
	// import java.util.*;

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");

	class Solution {
		public int solution(int N, String S) {
	        if (N == 0) {
	        	return 0;
	        }
			if (S == null || S.isEmpty()) {
	        	return N*3;
	        }
			
			boolean[][] seats = new boolean[N][10];
			int numberOfFamilies = 0;
			String[] reserveds = S.split(" ");
			
			//construct map of seats
			for (String reservedSeat : reserveds) {
			    Integer column = columnToInT(S.charAt(S.length()-1));
				Integer row = Integer.parseInt(reservedSeat.replaceAll("[\\D]", ""));
				if (row > N || row < 1 || column == -1) {
				    System.out.println("Bad entry. row: " + row + "; column: " + column);
					return -1;
				}
				seats[row-1][column] = true;
			}
			
			//checkAvailability
			for (int i = 0; i < N; i++) {
				//three first seats
				if (!seats[i][0] && !seats[i][1] && !seats[i][2]) {
					numberOfFamilies++;
				}
				
				//middle
				if (!seats[i][4] && !seats[i][5]) {
					if (!seats[i][3]) {
						numberOfFamilies++;
					} else if (!seats[i][6]) {
						numberOfFamilies++;
					}
					
				}
				
				//three last seats
				if (!seats[i][7] && !seats[i][8] && !seats[i][9]) {
					numberOfFamilies++;
				}
			}
			
			return numberOfFamilies;
	    }

		private int columnToInT(char c) {
			if (c == 'A') {
				return 0;
			}
			if (c == 'B') {
				return 1;
			}
			if (c == 'C') {
				return 2;
			}
			if (c == 'D') {
				return 3;
			}
			if (c == 'E') {
				return 4;
			}
			if (c == 'F') {
				return 5;
			}
			if (c == 'G') {
				return 6;
			}
			if (c == 'H') {
				return 7;
			}
			if (c == 'J') {
				return 8;
			}
			if (c == 'K') {
				return 9;
			}
			System.out.println("Bad char: " + c);
			return -1;
		}
	}
	// you can also use imports, for example:
	// import java.util.*;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.HashSet;
	import java.util.List;
	import java.util.Set;

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");

	class Solution {
	    public int solution(int[] A) {
	    	//construct rack
	    	Set<Integer> rackAvoidingDuplicates = new HashSet<>();
	    	for (int i = 0; i < A.length; i++) {
	    		rackAvoidingDuplicates.add(A[i]);
	    	}
	    	List<Integer> rack = new ArrayList<>(rackAvoidingDuplicates);
	    	Collections.sort(rack);
	    	
	    	//find best position
	    	int maximumDistance = 0;
	    	for (int i = 0; i < rack.size() - 1; i++) {
	    		int distance = (rack.get(i+1) - rack.get(i)) / 2;
	    		if (distance > maximumDistance) {
	    			maximumDistance = distance;
	    		}
	    	}
	    	
	        return maximumDistance;
	    }
	}

    
}
