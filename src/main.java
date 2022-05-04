import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class main {
	private static ArrayList<Album> albums = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Artist a1 = new Artist("System of Down");
		Artist a2 = new Artist("AC/DC");
		Artist a3 = new Artist("Postmalone", 26, "M");

		Album album1 = new Album("Toxicity", a1, new Song("Aerials", 6.13), new Song("Chop Suey", 3.3),
				new Song("Toxicity", 3.39));

		Album album2 = new Album("Back in Black", a2, new Song("Back in Black", 4.15),
				new Song("You Shook Me All Night Long", 3.3), new Song("Hells Bells", 5.1));

		Album album3 = new Album("Hollywood's Bleeding", a3, new Song("Saint-Tropez", 2.3), new Song("Circles", 3.34),
				new Song("Sunflower", 2.38));

		albums.add(album1);
		albums.add(album2);
		albums.add(album3);

		LinkedList<Song> playlist1 = new LinkedList<>();
		albums.get(0).addSongToPlaylist("Aerials", playlist1);
		albums.get(1).addSongToPlaylist("Back in Black", playlist1);
		albums.get(1).addSongToPlaylist("You Shook Me All Night Long", playlist1);
		albums.get(2).addSongToPlaylist("Saint-Tropez", playlist1);
		albums.get(2).addSongToPlaylist("Circles", playlist1);
		albums.get(2).addSongToPlaylist("Sunflower", playlist1);

		System.out.println(playlist1.toString());

		play(playlist1);
	}

	public static void play(List<Song> playlist) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listIterator = playlist.listIterator();
		if (playlist.size() == 0) {
			System.out.println("This playlist has no sound.");
		} else {
			System.out.println("Now playing " + listIterator.next().toString());
			mainMenu();
		}

		while (!quit) {
			int action = sc.nextInt();
			switch (action) {
			case 0:
				System.out.println("Bye bye...");
				quit = true;
				break;
			case 1:
				if (!forward) {
					if (listIterator.hasNext()) {
						listIterator.next();
					}
					forward = true;
				}
				if (listIterator.hasNext()) {
					System.out.println("Now playing " + listIterator.next().toString());
				} else {
					System.out.println("No song available");
					forward = false;
				}
				break;
			case 2:
				if (forward) {
					if (listIterator.hasPrevious()) {
						listIterator.previous();
					}
					forward = false;
				}

				if (listIterator.hasPrevious()) {
					System.out.println("Now playing " + listIterator.previous().toString());

				} else {
					System.out.println("First song");
					forward = false;
				}
				break;
			case 3:
				if (forward) {
					if (listIterator.hasPrevious()) {
						System.out.println("Now playing " + listIterator.previous().toString());
						forward = false;

					} else {
						System.out.println("Start of the list");
					}
				} else {
					if (listIterator.hasNext()) {
						System.out.println("Now playing " + listIterator.previous().toString());
						forward = true;
					} else {
						System.out.println("End of the list");
					}
				}
				break;
			case 4:
				printPlaylist(playlist);
				break;
			case 5:
				mainMenu();
				break;
			case 6:
				if(playlist.size()>0) {
					listIterator.remove();
					if(listIterator.hasNext()) {
						System.out.println("Now playing "+listIterator.next().toString());
					}else {
						if(listIterator.hasPrevious()) {
							System.out.println("Now playing "+listIterator.next().toString());
						}
					}
				}
			}
		}
	}

	private static void mainMenu() {
		System.out.println("Available options\n press");
		System.out.println("" + "0 - to quit\n" + "1 - to play next song\n" + "2 - to play previous song\n"
				+ "3 - to replay the current song\n" + "4 - to print all playlist songs\n"
				+"5 - to repeat the main menu"
				+ "6 - to delete current options\n");
	}

	public static void printPlaylist(List<Song> playlist) {
		Iterator<Song> iteratorSong = playlist.iterator();
		System.out.println("-------------------");
		while (iteratorSong.hasNext()) {
			System.out.println(iteratorSong.next());
		}
		System.out.println("-------------------");
	}
}
