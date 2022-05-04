package br.com.luminaapps.productcatalog.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.luminaapps.productcatalog.model.Product;
import br.com.luminaapps.productcatalog.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	private final ProductRepository productRepository;
	
	public ProductController(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}
	
	
	@PostMapping
	public ResponseEntity<Product> create(@RequestBody Product product) {
		Product result = productRepository.save(product);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Iterable<Product>> findAll() {
		return ResponseEntity.ok(productRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Optional<Product > product = productRepository.findById(id);
		if(product.isPresent())
			return ResponseEntity.ok(product.get());
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		productRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/all")
	public ResponseEntity<?> deleteAll() {
		productRepository.deleteAll();
		return ResponseEntity.ok().build();
	}
	
	
}
