/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziaskincare.dao;

import java.util.List;

/**
 *
 * @author Ai
 */
public interface BaseDao<T> {
    public void save(T entity);
    public void update(T entity);
    public void delete(T entity);
    public T getEntityById(Long id);
    public List<T> getAllData();
    
    
    
}
