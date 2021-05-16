package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        Scene scene = new Scene(root, 412, 870);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

                System.out.println(keyEvent.getCode());
                switch (keyEvent.getCode()) {
                    case A:
                        controller.ac();
                        break;
                    case C:
                        controller.ce();
                        break;
                    case ENTER:
                        controller.equal();
                        break;
                    case DIGIT0, NUMPAD0:
                        controller.addZero();
                        break;
                    case DIGIT1, NUMPAD1:
                        controller.addOne();
                        break;
                    case DIGIT2, NUMPAD2:
                        controller.addTwo();
                        break;
                    case DIGIT3, NUMPAD3:
                        controller.addThree();
                        break;
                    case DIGIT4, NUMPAD4:
                        controller.addFour();
                        break;
                    case DIGIT5, NUMPAD5:
                        controller.addFive();
                        break;
                    case DIGIT6, NUMPAD6:
                        controller.addSix();
                        break;
                    case DIGIT7, NUMPAD7:
                        controller.addSeven();
                        break;

                    case DIGIT8:
                        if (keyEvent.isShiftDown()) {
                            controller.addTimes();
                        } else {
                            controller.addEight();
                        }
                        break;

                    case NUMPAD8:
                        controller.addEight();
                        break;
                    case DIGIT9, NUMPAD9:
                        controller.addNine();
                        break;
                    case BACK_SPACE:
                        controller.bs();
                        break;
                    case SLASH:
                        controller.addDivide();
                        break;
                    case EQUALS:
                        if (keyEvent.isShiftDown()) {
                            controller.addPlus();
                        }
                        break;
                    case MINUS:
                        controller.addMinus();
                        break;
                    case PERIOD:
                        controller.addDot();
                        break;
                    default:
                        break;
                }
            }
        });

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
