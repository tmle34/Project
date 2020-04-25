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
public class TransactionsController {
    @Autowired
    TransactionsRepo transactionsRepo;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    ProductsRepo productsRepo;


    public TransactionsController() {
    }
    @RequestMapping("/Transactions")
    public ModelAndView doHome(){
        ModelAndView mv = new ModelAndView("Transactions");
        mv.addObject("CustomerList", customerRepo.findAll());
        mv.addObject("EmployeeList", employeeRepo.findAll());
        mv.addObject("ProductsList", productsRepo.findAll());
        mv.addObject("TransactionsList", transactionsRepo.findAll());
        return mv;
    }

    @RequestMapping(value = "/saveTransactions", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam(value = "EmployeeID") String EmployeeName,@RequestParam(value = "ProductID") String ProductName,@RequestParam(value = "CustomerID") String CustomerName, @RequestParam("ReceiptNum")int Num){
        ModelAndView mvsave=new ModelAndView("redirect:/Transactions");
        Transactions TransactionsToSave;
        TransactionsToSave = new Transactions();
        TransactionsToSave.setTransactionID(UUID.randomUUID().toString());
        TransactionsToSave.setEmployeeID(EmployeeName);
        TransactionsToSave.setProductID(ProductName);
        TransactionsToSave.setCustomerID(CustomerName);
        TransactionsToSave.setReceipt(Num);
        transactionsRepo.save(TransactionsToSave);
        mvsave.addObject("TransactionsList",transactionsRepo.findAll());
        return mvsave;
    }
    @RequestMapping(value = "/saveTransactions2", method = RequestMethod.POST)
    public ModelAndView save2(@RequestParam(value = "EmployeeID") String EmployeeName,@RequestParam(value = "cuid", required = false) Integer cuid,@RequestParam("id") Integer id,@RequestParam(value = "ProoductID") String ProductName,@RequestParam(value = "CustomerID") String CustomerName) {
        ModelAndView mvsave = new ModelAndView("redirect:/Transactions");
        Transactions TransactionsToSave;
        Optional<Transactions> users = transactionsRepo.findById(id);
        TransactionsToSave = users.get();
        TransactionsToSave.setReceipt(cuid);
        TransactionsToSave.setEmployeeID(EmployeeName);
        TransactionsToSave.setProductID(ProductName);
        TransactionsToSave.setCustomerID(CustomerName);
        transactionsRepo.save(TransactionsToSave);
        mvsave.addObject("TransactionsList", transactionsRepo.findAll());
        return mvsave;
    }
    @RequestMapping(value = "/editTransaction/{Receipt}",method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("Receipt") Integer id){
        ModelAndView mv= new ModelAndView("editTransactions");
        Optional<Transactions> person= transactionsRepo.findById(id);
        Transactions custedit= person.get();
        mv.addObject("selectedItem",custedit);
        return mv;
    }
    @RequestMapping(value = "/deleteTransaction/{TransactionID}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("TransactionID") int id){
        ModelAndView mv= new ModelAndView("redirect:/Transactions");
        transactionsRepo.deleteById(id);
        return mv;
    }
}