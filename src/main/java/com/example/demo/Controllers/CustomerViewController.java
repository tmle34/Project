package com.example.demo.Controllers;


import com.example.demo.Model.Employee;
import com.example.demo.Model.EmployeeRepo;
import com.example.demo.Model.Transactions;
import com.example.demo.Model.TransactionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class CustomerViewController {
    @Autowired
    TransactionsRepo transactionsRepo;

    public CustomerViewController() {
    }
    @RequestMapping("/CustomerView")
    public ModelAndView doHome(){
        ModelAndView mv = new ModelAndView("CustomerView");
        mv.addObject("tt", transactionsRepo.findAll());
        return mv;
    }
    @RequestMapping(value = "/CustomerItem", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam(value = "receipt") int id){
        ModelAndView mv = new ModelAndView("CustomerItem");
        Optional<Transactions> person= transactionsRepo.findById(id);
        Transactions searchre= person.get();
        mv.addObject("searchedItem",person);
        return mv;
    }
}