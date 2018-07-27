package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sample.dao.PlanDao;
import sample.models.PlanEntity;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        //Hibernate Configuration
//        Configuration cfg = new Configuration()
//                .configure("main/resources/hibernate.cfg.xml");
//        SessionFactory sf = cfg
//                .buildSessionFactory();

        PlanDao c = new PlanDao();
        PlanEntity cc = c.findById(101);
        System.out.println("-----> "+cc.getZmist());

//        PlanEntity planEntity = session.get(PlanEntity.class,101);
//        System.out.println("------> "+planEntity.getZmist().toString());



                //session.get(PlanEntity.class, 101);

//        PlanDao planDao = new PlanDao();
//        PlanEntity planEntity = planDao.findById(101);
//        System.out.println("------> "+planEntity.getZmist().toString());


        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("АРМ завуча школи");
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(800);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
