import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MainController {

    private ImageView image = new ImageView("cat.png");
    //private ImageButton CatDog = new ImageButton();
    private Circle c = new Circle(50, Color.valueOf("red"));
    Image imgDog = new Image("dog.png");
    @FXML
    private GridPane Grid;

    @FXML
    private ImageView imgOne;

    @FXML
    private Button btnOne;

   public MainController() {
       //super();
       initialize();
    }

    public void initialize(){
        ImageButton CatDog = new ImageButton();
        imgOne.setImage(imgDog);
        Grid.setConstraints(CatDog, 1,0);
        Grid.setConstraints(imgOne, 1, 1 );
    }
}
