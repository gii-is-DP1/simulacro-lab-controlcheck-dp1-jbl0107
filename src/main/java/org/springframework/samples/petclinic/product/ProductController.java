package org.springframework.samples.petclinic.product;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
	
	private ProductService ser;
	
	@Autowired
	public ProductController(ProductService ser) {
		this.ser = ser;
	}
	
	@GetMapping(value = "/product/create")
	public String initCreationForm(ModelMap model) {
		Product product = new Product();
		model.put("product", product);
		List<ProductType> pt = this.ser.findAllProductTypes();
		model.put("productTypes", pt);
		return "products/createOrUpdateProductForm";
	}

	@PostMapping(value = "/product/create")
	public String processCreationForm(@Valid Product product, BindingResult result, ModelMap model) {		
		String v = "products/createOrUpdateProductForm";
		if (result.hasErrors()) {
			model.put("product", product);
			List<ProductType> pt = this.ser.findAllProductTypes();
			model.put("productTypes", pt);
			return v;
		}
		else {
            this.ser.save(product);
    		List<ProductType> pt = this.ser.findAllProductTypes();
    		model.put("productTypes", pt); 
            return "welcome";
		}
	}
    
}
