package br.com.luminaapps.productcatalog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.luminaapps.productcatalog.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}
