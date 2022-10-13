package cinema.dao;

import cinema.exception.DataProcessingException;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class AbstractDao<T> {
    public static final Logger LOGGER = LogManager.getLogger(AbstractDao.class);
    protected final SessionFactory factory;
    private final Class<T> clazz;

    public AbstractDao(SessionFactory factory, Class<T> clazz) {
        this.factory = factory;
        this.clazz = clazz;
    }

    public T add(T t) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
            LOGGER.info(" {} was added to DB", t);
            return t;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.error(" {} wasn't inserted to DB", t);
            throw new DataProcessingException("Can't insert "
                    + clazz.getSimpleName() + " " + t, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Optional<T> get(Long id) {
        try (Session session = factory.openSession()) {
            return Optional.ofNullable(session.get(clazz, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get "
                    + clazz.getSimpleName() + ", id: " + id, e);
        }
    }

    public List<T> getAll() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from " + clazz.getSimpleName(), clazz).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all "
                    + clazz.getSimpleName() + "s from db", e);
        }
    }

    public T update(T t) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.update(t);
            LOGGER.info(" {} was updated in DB", t);
            return t;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.error(" {} wasn't updated in the DB", clazz.getSimpleName());
            throw new DataProcessingException("Can't update "
                    + clazz.getSimpleName() + " " + t, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Long id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            T movieSession = session.get(clazz, id);
            session.delete(movieSession);
            transaction.commit();
            LOGGER.info(" {} was deleted from DB by id: {} ", clazz.getSimpleName(), id);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.error(" {} wasn't deleted from DB by id: {} ", clazz.getSimpleName(), id);
            throw new DataProcessingException("Can't delete "
                    + clazz.getSimpleName() + " with id: " + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
