package com.example.demo.Controllers;


import com.example.demo.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.UUID;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeRepo employeeRepo;
    public EmployeeController() {
    }
    @RequestMapping("/Employees")
    public ModelAndView doHome(){
        ModelAndView mv = new ModelAndView("Employees");
        mv.addObject("EmployeeList", employeeRepo.findAll());
        return mv;
    }
    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam(value = "EmployeeName") String EmployeeName,@RequestParam(value = "cuid", required = false) Integer cuid,@RequestParam("id") String id){
        ModelAndView mvsave=new ModelAndView("redirect:/Employees");
        Employee EmployeeToSave;
        if(!id.isEmpty())
        {
            Optional<Employee> users = employeeRepo.findById(id);
            EmployeeToSave = users.get();
            EmployeeToSave.setEmployeeNum(cuid);
        }
        else {
            EmployeeToSave = new Employee();
            EmployeeToSave.setEmployeeID(UUID.randomUUID().toString());
        }
        EmployeeToSave.setEmployeeName(EmployeeName);

        employeeRepo.save(EmployeeToSave);
        mvsave.addObject("EmployeetList",employeeRepo.findAll());
        return mvsave;
    }

    @RequestMapping(value = "/editEmployees/{EmployeeID}",method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable(value = "EmployeeID") String id){
        ModelAndView mv= new ModelAndView("editEmployees");
        Optional<Employee> person= employeeRepo.findById(id);
        Employee custedit= person.get();
        mv.addObject("selectedItem",custedit);
        return mv;
    }
    @RequestMapping(value = "/deleteEmployee/{EmployeeID}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("EmployeeID") String id){
        ModelAndView mv= new ModelAndView("redirect:/Employees");
        employeeRepo.deleteById(id);
        return mv;
    }
}