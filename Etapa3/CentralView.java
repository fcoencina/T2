import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/*
* Clase de la vista de la central
*/
public class CentralView extends VBox {
    private Central cenModel;
    private final Label display;
    private Button aBtn, pBtn, dBtn;
    public CentralView (Central central) {
        super(20);
        display = new Label("Disarmed");
        display.setStyle("-fx-border-color: black; -fx-background-color: white");
        display.setMinWidth(200);
        display.setAlignment(Pos.CENTER);
        //setCenter(display);
        Font controlFont = new Font("Arial", 24);
        display.setFont(controlFont);
        aBtn = new Button("A");
        pBtn = new Button("P");
        dBtn = new Button("D");
        aBtn.setFont(controlFont);
        pBtn.setFont(controlFont);
        dBtn.setFont(controlFont);
        HBox hBox = new HBox();
        hBox.getChildren().addAll(aBtn,pBtn,dBtn);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(15);
        getChildren().addAll(display,hBox);
    }
    /*
    * Función para agregar un mensaje a la pantalla
    * @param msg Es el mensaje a agregar
    */
    public void setDisplay (String msg) {
        display.setText(msg);
    }
    /*
    * Función para el modelo a la central
    * @param model es le modelo de la central
    */
    public void setCentralModel(Central model){
        cenModel = model;
        //pBtn.setOnAction(event -> cenModel.armPerimeter());
        aBtn.setOnAction(event -> cenModel.armAll());
        dBtn.setOnAction(event -> cenModel.disarm());
    }
}
