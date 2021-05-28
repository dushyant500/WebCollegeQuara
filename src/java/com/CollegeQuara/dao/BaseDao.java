/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CollegeQuara.dao;

import java.util.List;

/**
 *
 * @author Dushyant
 */
public interface BaseDao<T>
        
{
    boolean save(T ob);
    boolean update(T ob);
    boolean delete(T ob);
    
    List<T> list();
    T get(int id);
    
}
