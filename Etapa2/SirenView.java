import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class SirenView extends Polygon {
    private final Timeline timeline;
    public SirenView() {
        getPoints().addAll(0d,30d,
                0d,50d,
                40d, 80d,
                40d, 0d);
        setFill(Color.WHITE);
        setStroke(Color.RED);
        KeyFrame frame = new KeyFrame(Duration.millis(1000), new KeyValue(fillProperty(), Color.RED));
        timeline = new Timeline(frame);
        timeline.setCycleCount(Animation.INDEFINITE);
    }
    public void startBlinking(){
        timeline.play();
    }
    public void stopBlinking() {
        timeline.stop();
    }
}
