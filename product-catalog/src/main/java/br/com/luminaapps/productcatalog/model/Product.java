package br.com.luminaapps.productcatalog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

@Data
@Document(indexName = "product")
public class Product {
	@Id
	private Long id;
	@Field(type = FieldType.Text)
	private String name;
	@Field(type = FieldType.Double)
	private Double amount;
	
	public Product() {
		
	}

}
