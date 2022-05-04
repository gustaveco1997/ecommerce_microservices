package br.com.luminaapps.shoppingcard.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.luminaapps.shoppingcard.model.Cart;
import br.com.luminaapps.shoppingcard.model.Item;
import br.com.luminaapps.shoppingcard.repository.CartRepository;

@RestController
@RequestMapping("/cart")
public class CartController {

	private final CartRepository cartRepository;

	public CartController(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	@PostMapping("/item/{cartId}")
	public ResponseEntity<Cart> addItem(@PathVariable("cartId") Long cartId, @RequestBody Item item) {
		Optional<Cart> cartDB = cartRepository.findById(cartId);
		Cart cart;
		if (cartDB.isPresent())
			cart = cartDB.get();
		else
			cart = new Cart(cartId);

		cart.addItem(item);

		return ResponseEntity.ok(cartRepository.save(cart));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cart> findById(@PathVariable("id") Long id) {
		Optional<Cart> cart = cartRepository.findById(id);
		if (cart.isPresent())
			return ResponseEntity.ok(cart.get());
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/all")
	public ResponseEntity<Iterable<Cart>> findAll() {
		return ResponseEntity.ok(cartRepository.findAll());
	}

	@PostMapping
	public ResponseEntity<Cart> cadastrar(@RequestBody Cart cart) {
		Cart cartDB = cartRepository.save(cart);
		return ResponseEntity.ok(cartDB);
	}

	@DeleteMapping("/all")
	public ResponseEntity<?> deleteAll() {
		cartRepository.deleteAll();
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		cartRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
