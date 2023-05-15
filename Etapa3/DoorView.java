import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
    
/**
* Clase para la vista de la puerta
*/
public class DoorView extends Group {
    private TranslateTransition transition;
    private Door doorModel;
    private Polygon switchPillar;
    private Rectangle slidingSheet;
    public DoorView(int x, int y, int angle){
        makeDoorViewWithoutSensor();
        //setRotate(angle);  // to rotate at the geometric center.
        relocate(x,y);
        //getTransforms().add(new Rotate(angle,x,y));  // to rotate at anchor pivot (40,50)
        prepareOpen_CloseTransition();
    }
    /**
    * Función para la creación de la puerta sin sensor
    */
    private void makeDoorViewWithoutSensor(){
        Polygon origenPillar = new Polygon();
        origenPillar.getPoints().addAll(0d,0d,
                0d,20d,
                10d, 20d,
                10d, 10d,
                20d, 10d,
                20d, 0d);
        origenPillar.setFill(Color.BLUE);
        origenPillar.setStroke(Color.BLUE);
        switchPillar = new Polygon(
                160d,0d,
                160d, 10d,
                170d, 10d,
                170d, 20d,
                180d, 20d,
                180d, 0d );
        switchPillar.setFill(Color.BLUE);
        switchPillar.setStroke(Color.BLUE);
        slidingSheet = new Rectangle(10,10,160,10);
        slidingSheet.setFill(Color.BURLYWOOD);
        Rectangle border = new Rectangle(0,0 ,180, 180);
        border.setFill(Color.TRANSPARENT);
        border.setStroke(Color.GRAY);
        border.getStrokeDashArray().addAll(4d,4d );
        getChildren().addAll(border);
        getChildren().addAll(origenPillar, switchPillar,slidingSheet);
    }
    /**
    * Función para agregar modelo a la puerta
    * @param model Es el modelo de la puerta
    */
    public void setDoorModel(Door model) {
        doorModel = model;
        this.setOnMouseClicked(event -> {
            if (doorModel.getState() == State.CLOSE)
                startOpening();
            else
                startClosing();
            doorModel.changeState();
        });
    }
    /**
    * Función para agregar la vista del sensor a la puerta 
    * @param msView la vista del sensor de la puerta 
    */
    public void addMagneticSensorView(MagneticSensorView msView){
        placeMagneticSensor(msView);
        //....
        getChildren().add(msView);
    }
    /**
    * Función para agregar el lugar del sensor a la puerta 
    * @param mv Es la vista del Sensor magnético
    */
    private void placeMagneticSensor( MagneticSensorView mv){
        mv.getMagnetView().setX(slidingSheet.getX()+slidingSheet.getWidth()-mv.getMagnetView().getWidth());
        //...
        mv.getSwitchView().setY(switchPillar.getBoundsInLocal().getHeight());
    }
    /**
    * Función para la vista de cierre y de apretura de la puerta 
    */
    private void prepareOpen_CloseTransition(){
        transition = new TranslateTransition(Duration.millis(1000), slidingSheet);
        transition.setCycleCount(1);
        //transition.setOnFinished();
    }
    /**
    * Función para abrir la puerta
    */
    public void startOpening(){
        transition.stop();
        transition.setFromX(slidingSheet.getTranslateX());// in case the user decides to close before it opens.
        transition.setToX(-130);
        transition.play();
    }
    /**
    * Función para cerrar la puerta
    */
    public void startClosing(){
        transition.stop();
        transition.setFromX(slidingSheet.getTranslateX());  // in case the user decides to open before it closes.
        transition.setToX(0); // original position
        transition.play();
    }
}
