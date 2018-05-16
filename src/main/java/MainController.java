import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainController {
    ArrayList<Image> list = new ArrayList<Image>();
   //Image[] list = new Image[4];

    private ImageView image_cat = new ImageView("cat.png");
    private ImageView image_dog = new ImageView("dog.png");
    private ImageButton CatDog = new ImageButton(image_cat);
    private Circle c = new Circle(50, Color.valueOf("red"));

    @FXML
    private GridPane Grid = new GridPane();

   public MainController() {
       initialize();
       //fill();
    }

    public void initialize(){
        list.add(0, new Image("cat.png"));
        list.add(1, new Image("dog.png"));
        list.add(2, new Image("frog.png"));
        list.add(3, new Image("fish.png"));

        fill();
    }

    private void fill(){
       Random r = new Random();
        Image img;
       for(int i = 0; i <6; i++) {
           for (int j = 0; j < 5; j++) {
               int n = r.nextInt(4);
               img = list.get(n);
               ImageView imv = new ImageView(img);
               ImageButton imb = new ImageButton(imv);
               Grid.add(imb, i, j);
           }
       }
    }
}
