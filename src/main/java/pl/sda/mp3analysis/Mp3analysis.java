package pl.sda.mp3analysis;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Mp3analysis {

    public List<Song> getListSongs(String file) throws IOException, InvalidDataException, UnsupportedTagException {
        Path path = Paths.get(file);
        List<Song> listSongs = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path, "*.mp3")) {
            for (Path entry: stream) {
                Mp3File mp3file = new Mp3File(entry);
                if(mp3file.hasId3v1Tag()){
                    ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                    Song song = new Song(id3v1Tag.getArtist(),id3v1Tag.getYear(),id3v1Tag.getAlbum(),id3v1Tag.getTitle(),String.format("%.2f", (entry.toFile().length() / 1048576d)));
                    listSongs.add(song);
                }
            }
        }
        return listSongs;
    }

    public void saveDes(List<Song> songList, String file) throws IOException {
        Path path = Paths.get(file);
        File file1 = new File(path.toString() + "\\description.txt");

        FileWriter writer = new FileWriter(file1);
        for (Song x : songList) {
            writer.write(x.getArtist());
            writer.write(x.getYear());
            writer.write(x.getAlbum());
            writer.write(x.getTitle());
            writer.write(x.getSize());
        }
        writer.close();
    }
}
