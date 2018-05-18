import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainController {
    ArrayList<Image> list = new ArrayList<Image>();
    int score = 0;

    private ImageView image_cat = new ImageView("cat.png");
    private ImageView image_dog = new ImageView("dog.png");
    private ImageButton CatDog = new ImageButton(image_cat);
    private Circle c = new Circle(50, Color.valueOf("red"));

    @FXML
    private Label scores;

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

        Grid.addEventFilter(Event.ANY, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                //System.out.println(event.getEventType().getClass().toString());
                if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
                    onPlay(event);
                    /*Object node = event.getTarget();
                        if( node instanceof ImageButton) {
                               System.out.println("Node: " + node + " at " + String.valueOf(((ImageButton) node).getRowIndex()) + "/" + String.valueOf(((ImageButton) node).getColIndex()));
                                scores.setText(String.valueOf(score += 10));*/
                            }
                        }
                });
            //});

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
               imb.setRowIndex(i);
               imb.setColIndex(j);
               Grid.add(imb, i, j);
           }
       }
    }

    private void onPlay(Event event) {
        ArrayList<ImageButton> temp = new ArrayList<ImageButton>();
        boolean b = false;

        Object node = event.getTarget();
        if (node instanceof ImageButton) {
            //System.out.println("Node: " + node + " at " + String.valueOf(((ImageButton) node).getRowIndex()) + "/" + String.valueOf(((ImageButton) node).getColIndex()));
            if(temp.size() == 0)
                temp.add((ImageButton)node);
            else if(((ImageButton) node).getIndex() == temp.get(0).getIndex())
                temp.add((ImageButton)node);

            scores.setText(String.valueOf(score += 10));
        }
    }
}
