package garden_planner.gui;
import garden_planner.model.GardenBed;
import garden_planner.model.GardenPlanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class GuiMain extends Application {
    private GardenPlanner planner = new GardenPlanner();
    private int scale = 100;
    private javafx.scene.shape.Circle cir;
    private javafx.scene.shape.Circle selectedRect_cir;
    private javafx.scene.shape.Rectangle rect;
    private javafx.scene.shape.Rectangle selectedRect;
    private TextField widthField;
    private BorderPane root;

    public GuiMain() {
        planner.createBasicDesign();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Parent root = FXMLLoader.load(getClass().getResource("garden_gui.fxml"));
        Pane pane = new Pane();
        root = new BorderPane();
        root.setCenter(pane);
//        pane = (Pane) root.getCenter();
        pane.setStyle("-fx-background-color: #007700;");


//        pane.setOnMouseReleased(ev -> {
//            updateGUI();
//        });


        widthField = new TextField("???");
        double width = planner.getBeds().get(0).getWidth();
        String str = Double.toString(width);
        widthField.setText(str);
        pane.getChildren().add(widthField);

        widthField.setOnAction(ev -> {
            rect.setWidth(Double.parseDouble(widthField.getText()));
        });

        primaryStage.setTitle("Garden Planner");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
        updateGUI();
    }

    public void updateGUI() {
        Pane pane = (Pane) root.getCenter();
        pane.getChildren().clear();
        for (GardenBed r : planner.getBeds()) {
            System.out.println("bed=" + r);
            if (r instanceof garden_planner.model.Circle) {
                cir = new javafx.scene.shape.Circle();
                cir.setRadius(50.0f);
                cir.setCenterX(200.0f);
                cir.setCenterY(250.0f);
                rect.setOnMouseDragged(ev -> {
                cir.setCenterX(ev.getX());
                cir.setCenterY(ev.getY());
                r.setLeft(ev.getX() / scale);
                r.setTop(ev.getY() / scale);


            });
                pane.getChildren().add(cir);
            }
            /**
             * Solution to show all Garden Beds
             */
            if (r instanceof garden_planner.model.Rectangle) {
                rect = new Rectangle();
                rect.setHeight(r.getHeight() * scale);
                rect.setWidth(r.getWidth() * scale);
                rect.setX(r.getLeft() * scale);
                rect.setY(r.getTop() * scale);
                rect.setOnMouseDragged(ev -> {
                    rect.setX(ev.getX());
                    rect.setY(ev.getY());
                    r.setLeft(ev.getX() / scale);
                    r.setTop(ev.getY() / scale);


                });
                pane.getChildren().add(rect);
            }
        }

}


    public static void main(String[] args) {
        launch(args);
    }
}

