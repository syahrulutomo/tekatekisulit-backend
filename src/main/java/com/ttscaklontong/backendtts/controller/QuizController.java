/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttscaklontong.backendtts.controller;

import com.ttscaklontong.backendtts.dao.QuizRepository;
import com.ttscaklontong.backendtts.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 *
 * @author Syahrul
 */

@Controller
@RequestMapping(path="/api")
public class QuizController {
    
    @Autowired
    private QuizRepository qr;
    
    @GetMapping(path="/view")
    public @ResponseBody Iterable<Quiz> getAllUsers() {
        // This returns a JSON or XML with the users
	return qr.findAll();
    }
    
    @RequestMapping(value="/add", method = RequestMethod.POST)
     @ResponseStatus(HttpStatus.CREATED)
     public void insertUserBaru(@RequestBody Quiz q){
         qr.save(q);
     }
    
}
