package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        //Hibernate Configuration
        Configuration cfg = new Configuration()
                .configure("D:\\java\\Plan\\src\\sample\\hibernate.cfg.xml");
        try (SessionFactory sf = cfg.buildSessionFactory()) {
        } catch(HibernateException exception){
            System.out.println("Problem creating session factory");
            exception.printStackTrace();
        }

//        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
//        primaryStage.setTitle("АРМ завуча школи");
//        primaryStage.setMinHeight(600);
//        primaryStage.setMinWidth(800);
//        primaryStage.setScene(new Scene(root, 800, 600));
//        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
