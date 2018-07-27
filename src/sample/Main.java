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
import sample.utils.HibernateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        //Hibernate Configuration
//        Configuration cfg = new Configuration()
//                .configure("main/resources/hibernate.cfg.xml");
//        SessionFactory sf = cfg
//                .buildSessionFactory();

//        PlanDao c = new PlanDao();
//        PlanEntity cc = c.findById(101);
//        System.out.println("-----> "+cc.getZmist());

       // Session s=HibernateUtil.openSession();

        //s.close();


//        PlanEntity planEntity = session.get(PlanEntity.class,101);
//        System.out.println("------> "+planEntity.getZmist().toString());



                //session.get(PlanEntity.class, 101);

//        PlanDao planDao = new PlanDao();
//        PlanEntity planEntity = planDao.findById(101);
//        System.out.println("------> "+planEntity.getZmist().toString());
        connect();

        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("АРМ завуча школи");
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(800);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();




    }

    public void connect(){

        Connection connection;
        try {

            String url = "jdbc:firebirdsql:localhost/3050:d:/MyDoc/projects_java/Plan1/WebContent/Base/KYRS.FDB";

            Properties p=new Properties();
            p.setProperty("user","SYSDBA");
            p.setProperty("password","masterkey");
            p.setProperty("useUnicode","true");
            p.setProperty("lc_ctype","win1251");
            p.setProperty("setChar","UNICODE_FSS");
            p.setProperty("encodind","UNICODE_FSS");
            p.setProperty("localEncoding","windows-1251");

            p.setProperty("driver", "org.firebirdsql.jdbc.FBDriver");

            String driverName = p.getProperty("driver", "org.firebirdsql.jdbc.FBDriver");
            Class.forName(driverName);

            connection = DriverManager.getConnection(url, p);
            System.out.println("is connect to DB" + connection);

            String query = "Select * FROM  BASE_COURSE";

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(query);
            String dbtime;
            while (rs.next()) {
                dbtime = rs.getString(2);
                System.out.println(dbtime);
            }

            connection.close();
        } // end try
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Could not find the database driver
        } catch (SQLException e) {
            e.printStackTrace();
            // Could not connect to the database
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
