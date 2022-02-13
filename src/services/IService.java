/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;

/**
 *
 * @author boukr
 * @param <T>
 */
public interface IService <T>{
    public void create(T t);
    public void delete(T t);
    public void update(T t);
    public List<T> read();
    
    
    
    
}
