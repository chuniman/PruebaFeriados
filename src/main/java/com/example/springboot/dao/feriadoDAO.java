/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springboot.dao;

import com.example.springboot.model.feriadosModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Chuni
 */
@Repository
public interface feriadoDAO extends CrudRepository<feriadosModel, Integer>{
    
}
