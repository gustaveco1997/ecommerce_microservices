package br.com.luminaapps.shoppingcard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.luminaapps.shoppingcard.model.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long>{

}
