import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Tile extends ImageView {
    private static final Image NORMAL_IMAGE = new Image("cat.png", true);
    private static final Image PRESSED_IMAGE = new Image("frog.png", true);

    //private final ImageView iv;

    public Tile() {
        super();
        ImageView iv = new ImageView(NORMAL_IMAGE);
        this.setClip(iv);

        iv.setOnMousePressed(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent evt) {
                iv.setImage(PRESSED_IMAGE);
            }

        });

        // TODO other event handlers like mouse up

    }
}
