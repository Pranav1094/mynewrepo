package guru.springframework.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import guru.springframework.domain.Product;
import guru.springframework.repositories.ProductRepository;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product save(Product p) {
		Product shirt = new Product();
		shirt.setDescription(p.getDescription());
		shirt.setPrice(p.getPrice());
		shirt.setImageUrl(p.getImageUrl());
		shirt.setProductId(p.getProductId());
		productRepository.save(shirt);
		return shirt;
	}

	public Product get(int id) {
		return productRepository.findOne(id);
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false, rollbackFor=Exception.class)
	public void update(Product p) throws Exception {
		productRepository.save(p);
		Product p1 = new Product();
		p1.setDescription(p.getDescription());
		p1.setImageUrl(p.getImageUrl());
		p1.setPrice(new BigDecimal("123"));
		productRepository.save(p1);
		throw new Exception();
	}

}
