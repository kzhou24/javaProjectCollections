package Music;

import java.util.ArrayList;
import java.util.List;

public class Album {
    String name;
    String artist;
    List<Song>songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public Song findSong(String title){

        for(Song song: songs){

            if(song.getTitle().equals(title)){

                return song;
            }

        }

            return null;

    }

    public boolean addSong(String name , double duration){

        if(findSong(name)!=null){
            System.out.println(" Duplicated song contained ");
            return false;
        }
        Song song = new Song(name,duration);
        this.songs.add(song);
        return true;
    }

    public boolean addToPlayList(String title, List<Song>playList){

        if(findSong(title)==null){
            System.out.println(" The song does not exist");
            return false;
        }

        playList.add(findSong(title));

        return true;
    }

    public boolean addToPlayList(int track,List<Song>list){

        int index = track-1;

        if(index>=0&&index<this.songs.size()){

            list.add(this.songs.get(index));

            return true;

        }

        System.out.println(" Invalid track number");

        return false;
    }


}
