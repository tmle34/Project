package com.example.demo.Controllers;

import com.example.demo.Model.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Optional;
import java.util.UUID;

@Controller
public class CustomerController {
    @Autowired
    CustomerRepo customerRepo;
    public CustomerController() {
    }
    @RequestMapping("/Customer")
    public ModelAndView doHome(){
        ModelAndView mv = new ModelAndView("Customer");
        mv.addObject("customerList", customerRepo.findAll());
        return mv;
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam(value = "CustomerName") String CustomerName,@RequestParam(value = "cuid", required = false) Integer cuid,@RequestParam("id") String id){
        ModelAndView mvsave=new ModelAndView("redirect:/Customer");
        Customer customerToSave;
        if(id.isEmpty()){
            id = "";
        }
        if(!id.isEmpty())
        {
            Optional<Customer> users = customerRepo.findById(id);
            customerToSave = users.get();
            customerToSave.setCustomerNum(cuid);
        }
        else {
            customerToSave = new Customer();
            customerToSave.setCustomerID(UUID.randomUUID().toString());
        }
        customerToSave.setCustomerName(CustomerName);
        customerRepo.save(customerToSave);
        mvsave.addObject("customertList",customerRepo.findAll());
        return mvsave;
    }

    @RequestMapping(value = "/editCustomer/{CustomerID}",method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable(value = "CustomerID") String id){
        ModelAndView mv= new ModelAndView("editCustomer");
        Optional<Customer> person= customerRepo.findById(id);
        Customer custedit= person.get();
        mv.addObject("selectedItem",custedit);
        return mv;
    }
    @RequestMapping(value = "/delete/{CustomerID}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("CustomerID") String id){
        ModelAndView mv= new ModelAndView("redirect:/Customer");
        customerRepo.deleteById(id);
        return mv;
    }
}