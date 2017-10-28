package guru.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guru.springframework.domain.Product;
import guru.springframework.service.ProductService;

@Controller
public class IndexController {
	
	@Autowired
    ProductService productService;
    
    @RequestMapping(value="/", method=RequestMethod.POST, consumes="application/json", produces="application/json")
    public Product save(@RequestBody Product product){
    	return productService.save(product);
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET, consumes="application/json", produces="application/json")
    Product get(@PathVariable("id") int id){
    	return productService.get(id);
    }
    
    
    @RequestMapping(value="/update", method=RequestMethod.POST, consumes="application/json", produces="application/json")
    public void update(@RequestBody Product product){
    	 try {
			productService.update(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
