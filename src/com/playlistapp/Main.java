package com.playlistapp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	
	private static ArrayList<Album> albums= new ArrayList<>();

	public static void main(String[] args) {
		
		Album album = new Album("Album1", "abc");
		
		album.addSong("Dreamers", 4.15);
		album.addSong("Waving flag", 3.45);
		album.addSong("Waka waka", 3.30);
		album.addSong("We are One", 4.05);
		albums.add(album);
		
		album = new Album("Album2", "def");
		album.addSong("Time of our lives", 2.0);
		album.addSong("Cheap Thrills", 4.22);
		album.addSong("This ones for you", 3.55);
		album.addSong("Magic in the air", 4.39);
		albums.add(album);
		
		LinkedList<Song> PlayList1 = new LinkedList<>();
		
		albums.get(0).addToPlayList("Dreamers", PlayList1);
		albums.get(0).addToPlayList("Waving flag", PlayList1);
		albums.get(1).addToPlayList("Cheap Thrills", PlayList1);
		albums.get(1).addToPlayList("Magic in the air", PlayList1);
		
		play(PlayList1);			
	}
	
	private static void play(LinkedList<Song> PlayList) {
		
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listIterator = PlayList.listIterator();
		
		if(PlayList.size() == 0) {
			System.out.println("This playlist have no songs");
		}else {
			System.out.println("Now playong "+listIterator.next().toString());
			printMenu();
		}
		
		while(!quit) {
			int action = sc.nextInt();
			sc.nextLine();
			
			switch(action) {
			
			   case 0:
				   System.out.println("Playlist completed");
				   quit = true;
				   break;
				   
			   case 1:
				   if(!forward) {
					   if(listIterator.hasNext()) {
						   listIterator.hasNext();					   
				   }
				   forward = true;
			    }
			
			     if(listIterator.hasNext()) {
			    	 System.out.println("Now playing "+ listIterator.next().toString());
			     }else {
			    	 System.out.println("No song available, reached end of the list");
			    	 forward = false;
			     }
			     break;
			     
			   case 2:
				   if(forward) {
					   if(listIterator.hasPrevious()) {
						  listIterator.previous();
					   }
					   forward = false;
				   }
				   if(listIterator.hasPrevious()) {
					   System.out.println("Now playing " + listIterator.previous().toString());
				   }else {
					   System.out.println("we are in the first song");
					   forward = false;
				   }
				   break;
				   
			   case 3:
				   if(forward) {
					   if(listIterator.hasPrevious()) {
						   System.out.println("Now playing "+ listIterator.previous().toString());
						   forward = true;
					   }else {
						   System.out.println("We are at the start of the list");
					   }
				   }
				   else {
					   if(listIterator.hasNext()) {
						   System.out.println("Now playing " + listIterator.next().toString());
						   forward = true;
					   }else {
						   System.out.println("We have reached to the end of the list");
					   }
				   }
				   break;
				   
			   case 4:
				   printList(PlayList);
				   break;
				   
			   case 5:
				   printMenu();
				   break;
				   
			   case 6:
				   if(PlayList.size() > 0) {
					   listIterator.remove();
					   if(listIterator.hasNext()) {
						   System.out.println("Now playing " + listIterator.next().toString());
					   }
					   else {
						   if(listIterator.hasPrevious()) 
							   System.out.println("Now playing " + listIterator.previous().toString());   
					   }
				   }
			 }
		 }
	}
	
	private static void printMenu() {
		System.out.println("Available options\n press");
		System.out.println("0 - to Quit\n" + 
		                   "1 - to Play next song\n"+
				           "2 - to Play previous song\n"+
		                   "3 - to Replay the current song\n"+
				           "4 - to List of all songs\n"+
		                   "5 - to Print all avaliable options\n"+
				           "6 - to Delete current song");
	}
	
	private static void printList(LinkedList<Song> PlayList) {
		Iterator<Song> iterator = PlayList.iterator();
		System.out.println("**********************************");
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());	
		}
		System.out.println("***********************************");		
	}
}
