package dao;

import java.util.List;

/**
 * Interface générique pour les opérations CRUD (Create, Read, Update, Delete).
 * @param <T> Type de l'objet manipulé.
 */
public interface IDao<T> {

    boolean create(T o); 

    boolean delete(T o); 

    boolean update(T o); 

    T findById(int id); 

    List<T> findAll(); 

}