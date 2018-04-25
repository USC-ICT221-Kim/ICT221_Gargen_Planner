package garden_planner.gui;
import garden_planner.model.Circle;
import garden_planner.model.GardenBed;
import garden_planner.model.GardenPlanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//import javax.swing.plaf.synth.ImagePainter;


public class GuiMain extends Application {
    private GardenPlanner planner = new GardenPlanner();
    private int scale = 100;
    private Circle cir;
    private javafx.scene.shape.Rectangle rect;
    private javafx.scene.shape.Rectangle selectedRect;
    private TextField widthField;
    private BorderPane root;

    public  GuiMain() {
        planner.createBasicDesign();
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        // Parent root = FXMLLoader.load(getClass().getResource("garden_gui.fxml"));
        Pane pane = new Pane();
//        pane = (Pane) root.getCenter();
        pane.setStyle("-fx-background-color: #007700;");


            pane.setOnMouseReleased(ev -> {
                for (GardenBed r : planner.getBeds()) {

                    rect.setX(r.getLeft() * scale);
                    rect.setY(r.getTop() * scale);
                    rect.setX(ev.getX() / scale);
                    rect.setY(ev.getY() / scale);

                    selectedRect = rect;
                    System.out.println("Message" + selectedRect);
                }
            });

        for (GardenBed r : planner.getBeds()) {
            cir = new Circle();
            cir.setRadius(r.getHeight()* scale);
            cir.setHeight(r.getHeight() * scale);
            cir.setWidth(r.getWidth() * scale);




        }
    /**
     * Solution to show all Garden Beds
     */
        for (GardenBed r : planner.getBeds()) {
            rect = new Rectangle();
            rect.setHeight(r.getHeight() * scale);
            rect.setWidth(r.getWidth() * scale);
            rect.setX(r.getLeft() * scale);
            rect.setY(r.getTop() * scale);
            rect.setOnMouseDragged(ev -> {
                rect.setX(ev.getX() );
                rect.setY(ev.getY() );


            });
            pane.getChildren().add(rect);
        }
        widthField  = new TextField("???");
        double width = planner.getBeds().get(0).getWidth();
        String str = Double.toString(width);
        widthField.setText(str);
        pane.getChildren().add(widthField);

        widthField.setOnAction(ev -> { rect.setWidth(Double.parseDouble(widthField.getText()));} );

        primaryStage.setTitle("Garden Planner");
        primaryStage.setScene(new Scene(pane, 800, 600));
        primaryStage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }
}

