import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

public class controller {

    private ImageView image = new ImageView("cat.png");
    private Circle c = new Circle(50);
    @FXML
    private GridPane grid;

    /**
     *  Не можу додати на GridPane нічого :( Пробував додавати різні елементи, видає помилку.
     *  Може, все ж створювати GridPane динамічно? Або використати інший елемент, напр., Pane?
     */
   public controller() {

       ImageButton CatDog = new ImageButton();
        grid.add(c, 0, 0);
    }
}
