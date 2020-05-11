package pl.sda.mp3analysis;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.IOException;


public class Main {
        public static void main(String[] args) throws InvalidDataException, UnsupportedTagException {
            Mp3analysis mp3Analysis = new Mp3analysis();
            try {
                mp3Analysis.saveDes(mp3Analysis.getListSongs("C:\\Users\\uer\\Desktop\\mp3"), "C:\\Users\\uer\\Desktop");
                System.out.println("Informacje o utworach zapisano w pliku description.txt");
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Nie podałeś ścieżki do pliku!");
            } catch (IOException ex) {
                System.out.println("Problem z odczytem lub zapisem!");
            }
        }
}
