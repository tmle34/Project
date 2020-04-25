package com.example.demo.Controllers;


import com.example.demo.Model.Products;
import com.example.demo.Model.ProductsRepo;
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
public class ProductController {
    @Autowired
    ProductsRepo productsRepo;
    public ProductController() {
    }
    @RequestMapping("/Products")
    public ModelAndView doHome(){
        ModelAndView mv = new ModelAndView("Products");
        mv.addObject("ProductsList", productsRepo.findAll());
        return mv;
    }
    @RequestMapping(value = "/saveProducts", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam(value = "ProductsName") String ProductsName,@RequestParam(value = "cuid", required = false) Integer cuid,@RequestParam("id") String id,@RequestParam("price") double Price){
        ModelAndView mvsave=new ModelAndView("redirect:/Products");
        Products ProductsToSave;
        if(!id.isEmpty())
        {
            Optional<Products> users = productsRepo.findById(id);
            ProductsToSave = users.get();
            ProductsToSave.setProductSKU(cuid);
        }
        else {
            ProductsToSave = new Products();
            ProductsToSave.setProductID(UUID.randomUUID().toString());
        }
        ProductsToSave.setProductName(ProductsName);
        ProductsToSave.setProductPrice(Price);
        productsRepo.save(ProductsToSave);
        mvsave.addObject("ProductsList",productsRepo.findAll());
        return mvsave;
    }

    @RequestMapping(value = "/editProducts/{ProductID}",method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable(value = "ProductID") String id){
        ModelAndView mv= new ModelAndView("editProducts");
        Optional<Products> person= productsRepo.findById(id);
        Products custedit= person.get();
        mv.addObject("selectedItem",custedit);
        return mv;
    }
    @RequestMapping(value = "/deleteProducts/{ProductID}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("ProductID") String id){
        ModelAndView mv= new ModelAndView("redirect:/Products");
        productsRepo.deleteById(id);
        return mv;
    }
}