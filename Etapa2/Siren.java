import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

import java.io.File;
import java.net.URL;

public class Siren {
    private SirenView view;
    private MediaPlayer mediaPlayer;
    public Siren (String mediaURL){
        Media media = new Media(mediaURL);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        view = new SirenView();
    }
    public void play(){
        mediaPlayer.play();
        view.startBlinking();
    }
    public void stop(){
        mediaPlayer.pause();
        view.stopBlinking();
    }
    public Polygon getView() {
        return view;
    }
}
