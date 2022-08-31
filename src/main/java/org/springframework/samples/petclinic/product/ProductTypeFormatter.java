package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{
	
	private final ProductService ser;
	
	@Autowired
	public ProductTypeFormatter(ProductService ser) {
		this.ser = ser;
	}

    @Override
    public String print(ProductType object, Locale locale) {
        return object.getName();
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
    	ProductType pt =  ser.getProductType(text);
    	if(pt == null) {
    		throw new ParseException(text, 0);
    	}
    	else {
            return pt;

    	}
    }
    
}
