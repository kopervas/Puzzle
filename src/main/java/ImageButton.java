import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ImageButton extends Parent{

    // The image is being loaded in the background
    //  Image image = new Image(url, backgroundLoading);

    private static final Image CAT = new Image("cat.png", true);
    private static final Image DOG = new Image("dog.png", true);
    private static final Image FROG = new Image("frog.png", true);
    private static final Image FISH = new Image("fish.png", true);

    private int ROW_INDEX;
    private int COL_INDEX;
    private int index;

    private ImageView iv = new ImageView(new Image("white.png", true));

    public void setIcon(ImageView i){
        this.getChildren().add(i);
    }

    public ImageView getIcon() {return (ImageView) this.getChildren();}

    public ImageButton(){}

    public ImageButton(ImageView i) {
        super();
        Image img = i.getImage();
        if(img == CAT)
            index = 1;
        else if(img == DOG)
            index = 2;
        else if(img == FROG)
            index = 3;
        else if(img == FISH)
            index = 4;

        this.getChildren().add(i);

        this.setOnMousePressed(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent evt) {
                try {
                    bingo();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                //getIcon(iv);
            }

        });
        // TODO other event handlers like mouse up
    }

    public void setRowIndex(int i){
        ROW_INDEX = i;
    }

    public void setColIndex(int i){
        COL_INDEX = i;
    }

    public int getRowIndex(){
        return ROW_INDEX;
    }

    public int getColIndex(){
        return COL_INDEX;
    }

    public int getIndex() {
        return index;
    }

    public void bingo() throws Throwable{
        this.blendModeProperty().setValue(BlendMode.OVERLAY);
    }

}