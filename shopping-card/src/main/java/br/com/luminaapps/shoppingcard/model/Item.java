package br.com.luminaapps.shoppingcard.model;

import org.springframework.data.redis.core.RedisHash;

import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash("item")
@Data
@NoArgsConstructor
public class Item {
	private Long productId;
	private Double amount;
	

}
