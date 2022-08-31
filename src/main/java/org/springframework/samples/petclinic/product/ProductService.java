package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	private ProductRepository repo;
	
	@Autowired
	public ProductService(ProductRepository repo) {
		this.repo=repo;
	}
	
	
    public List<Product> getAllProducts(){
        return (List<Product>) repo.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return repo.findByPriceLessThan(price);
    }

    public ProductType getProductType(String typeName) {
        return repo.findByName2(typeName);
    }
    
    public List<ProductType> findAllProductTypes(){
    	return repo.findAllProductTypes();
    }

    public Product save(Product p){
        return null;       
    }

    
}
