import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PIR_DetectorView extends Rectangle {
    public PIR_DetectorView(Double x, Double y, int direction_angle){
        this.setX(x);
        this.setY(y);
        this.setRotate(direction_angle);
        this.setWidth(30);
        this.setHeight(15);
        this.setFill(Color.GREEN);
        this.setStrokeWidth(5);
        this.setStroke(Color.DARKGREEN);
    }
}
