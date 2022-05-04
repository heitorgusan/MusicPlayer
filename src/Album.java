import java.util.ArrayList;
import java.util.Arrays;

public class Album {
	private String name;
	private Artist artist;
	private ArrayList<Song>songs;
	
	public Album(String name, Artist artist, Song ...songs) {
		super();
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Song>(Arrays.asList(songs));
	}
	
	public Album() {
		this.songs = new ArrayList<Song>();
	}
	
	public boolean addSong(String name, double duration) {
		if(this.findSong(name) == null) {
			this.songs.add(new Song(name,duration));
			System.out.println(name + " added to the album!!!");
			return true;
		}else {
			System.out.println(name+" Song already exist in the list");
			return false;
		}
	}
	public Song findSong(String name){
		for(Song checkedSong: this.songs) {
			if(checkedSong.getName().equals(name))return checkedSong;
		}
		return null;
	}
	
	public boolean addSongToPlaylist(int trackNumberSong , ArrayList<Song>Playlist) {
		int index = trackNumberSong -1;
		if(index > 0 && trackNumberSong <=  this.songs.size()-1) {
			Playlist.add(this.songs.get(trackNumberSong));
			return true;
		}else {
			System.out.println("This album doesn't have a song with this tracknumber"+ trackNumberSong);
			return false;
		}
	}
	
	public boolean addSongToPlaylist(String nameSong, ArrayList<Song>Playlist) {
		Song song = this.findSong(nameSong);
		if(song!=null) {
			Playlist.add(song);
			System.out.println("Song added to your playlist");
			return true;
		}else {
			System.out.println("Song doesn't found in this album");
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public ArrayList<Song> getSongs() {
		return songs;
	}

	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Album [name=" + name + ", artist=" + artist + ", songs=" + songs + "]";
	}
	
	
}