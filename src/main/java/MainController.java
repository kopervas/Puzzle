import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainController {
    ArrayList<Image> list = new ArrayList<Image>();
    //Тимчасовий масив для кнопок, обраних користувачем під час гри
    ArrayList<ImageView> temp = new ArrayList<>();
    int score = 0;
    int counter = 0;
    //Масив кнопок, призначений для перезавантаження елементів Grid
    ImageButton[][] matrix = new ImageButton[5][6];
    //Тимчасова змінна для поміщення останньої обраної кнопки
    ImageButton buffer = new ImageButton();

    @FXML
    private Label scores;

    @FXML
    private Label silver_scores;

    @FXML
    private Label gold_scores;

    @FXML
    private Button Test;

    @FXML
    private GridPane Grid = new GridPane();

    public MainController() {
        try {
            initialize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    /**
     * Метод ініціалізації, в якому додається обробник події Mouse.EVENT_CLICKED
     *
     * @throws Throwable
     */
    public void initialize() throws Throwable {
        list.add(0, new Image("cat.png"));
        list.add(1, new Image("dog.png"));
        list.add(2, new Image("frog.png"));
        list.add(3, new Image("fish.png"));

        fill();

        Grid.addEventFilter(Event.ANY, new EventHandler<Event>() {

            @Override
            public void handle(Event event) {

                if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
                    try {
                          onPlay(event);

                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            }
        });
    }

    /**
     * Метод, який заповнює GridPane об'єктами типу ImageButton.
     * Image для ImageButton обираються рандомно зі списку з чотирьох зображень -
     * "cat.png", "dog.png", "frog.png" та "fish.png"
     *
     * @throws Throwable
     */
    private void fill() throws Throwable {
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
                matrix[j][i] = imb;
            }
        }
    }

    /**
     * Метод, який перевіряє, чи відповідає обрана комірка умові
     * Використовує чотири інші методи
     *
     * @param imv
     * @return
     */
    private boolean Perevirka(ImageView imv) {
        //if(buffer == null || ((buffer.getIcon() == imv) && ((buffer.getRowIndex() == ((ImageButton)imv.getParent()).getRowIndex()) || ((buffer.getColIndex() == ((ImageButton)imv.getParent()).getColIndex())))){
        if ((CheckSize(imv) == true) || (CheckImage(imv) && (CheckRowIndex(imv) || CheckColIndex(imv)))) {
            imv.blendModeProperty().setValue(BlendMode.OVERLAY);
            return true;
        }
        return false;
    }

    private boolean CheckSize(ImageView imv) {
        if (temp.size() == 0) {
            return true;
        }
        return false;
    }

    private boolean CheckImage(ImageView imv) {
        if (temp.size() > 0 && (temp.get(0).getImage() == imv.getImage())) {
            System.out.println("Check Image!");
            return true;
        }
        return false;
    }

    private boolean CheckRowIndex(ImageView imv) {
        if (((ImageButton) temp.get(0).getParent()).getRowIndex() == ((ImageButton) imv.getParent()).getRowIndex()) {
            System.out.println("Check Row Index!");
            return true;
        }
        return false;
    }

    private boolean CheckColIndex(ImageView imv) {
        if (((ImageButton) temp.get(0).getParent()).getColIndex() == ((ImageButton) imv.getParent()).getColIndex()) {
            System.out.println("Check Col Index!");
            return true;
        }
        return false;
    }

    /**
     * В цьому методі ми отримуємо подію, аналізуємо, який об'єкт виділено, і, якщо
     * це зображення потрібного виду, метод повертає true та збільшує лічильник @counter
     * Якщо зображення не співпадає з обраним за першим кліком, повертаємо false
     *
     * @param event
     * @throws Throwable
     */
    private boolean onPlay(Event event) throws Throwable {
        boolean b = false;
        Object node = event.getTarget();

        if (node instanceof ImageView) {
            if (Perevirka((ImageView) node) == true) {//temp.size() >= 0 || ((((ImageView) node).getParent())  == (((temp.get(0))).getParent())) && ((((ImageButton)(((ImageView) node).getParent())).getRowIndex() == ((ImageButton)((temp.get(0))).getParent()).getRowIndex()) && (((ImageButton)((((ImageView) node).getParent()))).getColIndex() == ((ImageButton)((temp.get(0))).getParent()).getColIndex())) ) {
                //((ImageView) node).getParent().blendModeProperty().setValue(BlendMode.OVERLAY);
                temp.add((ImageView) node);                                                                //В цьому рядку вся проблема! - 21.05.18
                counter++;
                return true;
            } else {
                System.out.println("False! " + temp.size());
                MoveArray();
                return false;
            }

            //if (temp.size() > 0 && temp.size() < 4)
               // scores.setText(String.valueOf(score += 10));
            //else if (temp.size() > 3 && temp.size() < 6)
               // silver_scores.setText(String.valueOf(score += 20));
        }
            return false;
        }

    /**
     *  Метод, який перезавантажує елементи на Grid з врахуванням вибраних гравцем кнопок
     */
    private void MoveArray() {
            for(int i = 0; i < 6; i++){
                for(int j = 0; j < 5; j++){
                    if((matrix[j][i].blendModeProperty().getValue() == BlendMode.OVERLAY) && j == 0)
                        matrix[j][i] = new ImageButton(new ImageView("white.png"));
                    else if(matrix[j][i].blendModeProperty().getValue() == BlendMode.OVERLAY){
                        for(int k = j; k > 0; k--) {
                            matrix[k][i] = matrix[k-1][i];
                            }
                        matrix[0][i] = new ImageButton(new ImageView("white.png"));
                    }
                }
        }

        Grid.getChildren().clear();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                    Grid.add(matrix[j][i], i, j);
                }
            }
    }

    @FXML
    private void toArray() {
        int c = 1;
        Object[] temp = new Object[31];
        temp = Grid.getChildren().toArray();
        //System.out.println(Grid.getChildren().get(1));
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[j][i] = (ImageButton) temp[c];
                System.out.println(matrix[j][i].getRowIndex() + "  " + matrix[j][i].getColIndex());
                c++;
            }
        }
        MoveArray();
    }
}

