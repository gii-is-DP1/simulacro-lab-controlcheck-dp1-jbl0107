package org.springframework.samples.petclinic.product;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter
@Setter

public class Product extends BaseEntity{
	
	@NotNull
	@Size(min=5, max=30)
    String name;
	
	@NotNull
	@Min(0)
    double price;
	
	@ManyToOne
	@JoinColumn(name="product_type_id")
    ProductType productType;
}
