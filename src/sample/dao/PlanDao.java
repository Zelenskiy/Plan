package sample.dao;


import sample.utils.HibernateSessionFactoryUtilBase;
import sample.models.PlanEntity;

public class PlanDao {


	public PlanEntity findById(int id) {
        return (PlanEntity) HibernateSessionFactoryUtilBase
                .getSessionFactory()
                .openSession()
                .get(PlanEntity.class, id);
    }

//    public void save(PlanEntity plans) {
//        Session session = HibernateSessionFactoryUtilBase.getSessionFactory().openSession();
//        Transaction tx1 = session.beginTransaction();
//        session.save(plans);
//        tx1.commit();
//        session.close();
//    }
//
//    public void update(Plan_ plans) {
//        Session session = HibernateSessionFactoryUtilBase.getSessionFactory().openSession();
//        Transaction tx1 = session.beginTransaction();
//        session.update(plans);
//        tx1.commit();
//        session.close();
//    }
//
//    public void delete(Plan_ plans) {
//        Session session = HibernateSessionFactoryUtilBase.getSessionFactory().openSession();
//        Transaction tx1 = session.beginTransaction();
//        session.delete(plans);
//        tx1.commit();
//        session.close();
//    }
//
//
//
//    public List<Plan_> findAll() {
//        @SuppressWarnings("unchecked")
//		List<Plan_> plans = (List<Plan_>)  HibernateSessionFactoryUtilBase.getSessionFactory().openSession().createQuery("From Plan_").list();
//        return plans;
//    }
//
//    public List<Plan_> find(String query) {
//        @SuppressWarnings("unchecked")
//		List<Plan_> plans = (List<Plan_>)  HibernateSessionFactoryUtilBase.getSessionFactory().openSession().createQuery(query).list();
//        return plans;
//    }

}
