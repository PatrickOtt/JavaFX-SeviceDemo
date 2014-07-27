package de.professional_webworkx.javafxdemoapp;

import de.professional_webworkx.javafxdemoapp.domain.Person;
import de.professional_webworkx.javafxdemoapp.services.JVMDataService;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainApp extends Application {

    JVMDataService service = new JVMDataService();

    @Override
    public void start(Stage stage) throws Exception {

        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 1280, 768);

        HBox hBox = new HBox();
        final TilePane tilePane = new TilePane(Orientation.VERTICAL, 25, 20);
        tilePane.setPrefRows(15);
        ScrollPane scrollPane = new ScrollPane(tilePane);
        scrollPane.setPrefViewportWidth(1100);
        scrollPane.setPrefViewportHeight(650);
        final VBox vBox = new VBox(scrollPane);
        
        service.setDelay(Duration.seconds(3));
                // time between every Period / Run
                service.setPeriod(Duration.seconds(3));
                service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {

                    @Override
                    public void handle(WorkerStateEvent t) {
                        List<Person> persons = (List<Person>) t.getSource().getValue();
                        for (Person person : persons) {
                            tilePane.getChildren().add(new Text(person.getFirstName() + " " + person.getLastNameProperty().get() + ", " + person.geteMailProperty().get()));
                        }
                    }
                });
                service.start();
        
        Button getNewList = new Button("Add new TilePane");
        getNewList.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                
                // If you want to clear the Content of the current TilePane - uncomment the
                // following two lines..
                // ObservableList<Node> children = tilePane.getChildren();
                // children.clear();

                if (service == null) {
                    service = new JVMDataService();
                }
                // delay before running the first time
                service.setDelay(Duration.seconds(3));
                // time between every Period / Run
                service.setPeriod(Duration.seconds(3));
                service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {

                    @Override
                    public void handle(WorkerStateEvent t) {
                        List<Person> persons = (List<Person>) t.getSource().getValue();
                        for (Person person : persons) {
                            tilePane.getChildren().add(new Text(person.getFirstName() + " " + person.getLastNameProperty().get() + ", " + person.geteMailProperty().get()));
                        }
                    }
                });
                service.start();
            }
        });

        //hBox.getChildren().add(getNewList);
        hBox.getChildren().add(vBox);

        root.getChildren().add(hBox);
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
