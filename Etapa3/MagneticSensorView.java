import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
 /**
    * clase de la vista del sensor magnético
    */
public class MagneticSensorView extends Group {
    private final Rectangle switchView;
    private final Rectangle magnetView;
     /**
    * constructor del sensor magnético
    */
    public MagneticSensorView () {
        switchView = new Rectangle(6,6);
        setCloseView();
        magnetView = new Rectangle(6,6);
        magnetView.setFill(Color.BLACK);
        getChildren().addAll(magnetView,switchView);
    }
     /**
    * Función colocar la vista del sensor en modo cerrado 
    */
    public void setCloseView(){
        //...
    }
    /**
    * Función colocar la vista del sensor en modo abierto 
    */
    public void setOpenView(){
        //...
    }
    public Rectangle getSwitchView(){
        return switchView;
    }
    public Rectangle getMagnetView(){
        return magnetView;
    }
}
