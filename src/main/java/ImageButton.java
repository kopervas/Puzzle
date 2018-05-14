import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ImageButton extends Parent {

    // The image is being loaded in the background
    //  Image image = new Image(url, backgroundLoading);

    private static final Image NORMAL_IMAGE = new Image("cat.png", true);
    private static final Image PRESSED_IMAGE = new Image("frog.png", true);

    private final ImageView iv;

    public ImageButton() {
        this.iv = new ImageView(NORMAL_IMAGE);
        this.getChildren().add(this.iv);

        this.iv.setOnMousePressed(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent evt) {
                iv.setImage(PRESSED_IMAGE);
            }

        });

        // TODO other event handlers like mouse up

    }

}