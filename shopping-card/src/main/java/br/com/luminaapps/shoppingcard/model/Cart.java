package br.com.luminaapps.shoppingcard.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@RedisHash("cart")
public class Cart {
	@Id
	private Long id;
	private List<Item> items;

	public Cart(Long id) {
		this.id = id;
	}

	public List<Item> getItems() {
		if (items == null)
			return new ArrayList<>();
		return items;
	}

	public void addItem(Item item) {
		if (this.items == null)
			this.items = new ArrayList<Item>();

		this.items.add(item);
	}

}
