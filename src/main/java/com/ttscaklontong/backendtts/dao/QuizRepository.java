/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttscaklontong.backendtts.dao;

import com.ttscaklontong.backendtts.entity.Quiz;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Syahrul
 */
public interface QuizRepository extends CrudRepository<Quiz, Long>{
    
}
