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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @CrossOrigin(origins = "https://tekatekisulit.github.io:443")
    @GetMapping(path="/view")
    public @ResponseBody Iterable<Quiz> getAllQuestion() {
        // This returns a JSON or XML with the users
	return qr.findAll();
    }
    
    @RequestMapping(value="/add", method = RequestMethod.POST)
     @ResponseStatus(HttpStatus.CREATED)
     public void insertNewQuestion(@RequestBody Quiz q){
         qr.save(q);
     }
     
     @RequestMapping(value="/question/{id}", method = RequestMethod.PUT)
     @ResponseStatus(HttpStatus.OK)
     public void updateQuestion(@PathVariable("id") Integer id, @RequestBody Quiz q){
         q.setId(id);
         qr.save(q);
     }
     
     @RequestMapping(value="/question/{id}", method = RequestMethod.DELETE)
     @ResponseStatus(HttpStatus.OK)
     public void hapusUser(@PathVariable("id") Long id){
         qr.deleteById(id);
     }
    
}
