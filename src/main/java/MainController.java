import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MainController {

    private ImageView image_cat = new ImageView("cat.png");
    private ImageView image_dog = new ImageView("dog.png");
    private ImageButton CatDog = new ImageButton();
    private Circle c = new Circle(50, Color.valueOf("red"));

    @FXML
    private GridPane Grid = new GridPane();

   public MainController() {
       initialize();
    }

    public void initialize(){

        Grid.add(CatDog, 0,0);

    }
}
