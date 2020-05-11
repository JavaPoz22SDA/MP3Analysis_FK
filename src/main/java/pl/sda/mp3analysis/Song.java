package pl.sda.mp3analysis;

public class Song {
    private String artist;
    private String year;
    private String album;
    private String title;
    private String size;

    public Song(String artist, String year, String album, String title, String size) {
        this.artist = artist;
        this.year = year;
        this.album = album;
        this.title = title;
        this.size = size;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
