import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Random;

public class MainController {
    ArrayList<Image> list = new ArrayList<Image>();
    ArrayList<ImageView> temp = new ArrayList<>();
    int score = 0;
    int counter = 0;

    private ImageView image_cat = new ImageView("cat.png");
    private ImageView image_dog = new ImageView("dog.png");
    private ImageButton CatDog = new ImageButton(image_cat);
    private Circle c = new Circle(50, Color.valueOf("red"));

    @FXML
    private Label scores;

    @FXML
    private GridPane Grid = new GridPane();

   public MainController() {
       try {
           initialize();
       } catch (Throwable throwable) {
           throwable.printStackTrace();
       }
       //fill();
    }

    /**
     * Метод ініціалізації, в якому додається обробник події Mouse.EVENT_CLICKED
     * @throws Throwable
     */
    public void initialize() throws Throwable{
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
                    try {
                        onPlay(event);
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                    /*Object node = event.getTarget();
                        if( node instanceof ImageButton) {
                               System.out.println("Node: " + node + " at " + String.valueOf(((ImageButton) node).getRowIndex()) + "/" + String.valueOf(((ImageButton) node).getColIndex()));
                                scores.setText(String.valueOf(score += 10));*/
                            }
                        }
                });
    }

    private void fill() throws Throwable{
       Random r = new Random();
        Image img;
            for (int i = 0; i < 6; i++) {
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

    /**
     *  В цьому методі ми отримуємо подію, аналізуємо, який об'єкт виділено, і, якщо
     *  це зображення потрібного виду, метод повертає true та збільшує лічильник @counter
     *  Якщо зображення не співпадає з обраним за першим кліком, повертаємо false
     * @param event
     * @throws Throwable
     */
    private boolean onPlay(Event event) throws Throwable {
        boolean b = false;
        Object node = event.getTarget();

        //System.out.println(event.toString());
        if (node instanceof ImageView) {
            if ( temp.size() >= 0 && (((ImageButton)(((ImageView) node).getParent())).getIndex()  == ((ImageButton)((temp.get(0))).getParent()).getIndex()) && (((ImageButton)(((ImageView) node).getParent())).getRowIndex() == ((ImageButton)((temp.get(0))).getParent()).getRowIndex()) && (((ImageButton)((((ImageView) node).getParent()))).getColIndex() == ((ImageButton)((temp.get(0))).getParent()).getColIndex()) ) {
                temp.add((ImageView) event.getTarget());                                                                //В цьому рядку вся проблема! - 21.05.18
                counter++;
            }
            else
            {
                System.out.println("False! " + temp.size());
                return false;
            }

            scores.setText(String.valueOf(score += 10));
            System.out.println("RowIndex ? " + ((ImageButton)(((ImageView) node).getParent())).getRowIndex());
            System.out.println("ColIndex ? " + ((ImageButton)(((ImageView) node).getParent())).getColIndex());
            System.out.println(temp.size() + "  " + counter);
            System.out.println(event.getSource());
        }
        return true;
    }
}
