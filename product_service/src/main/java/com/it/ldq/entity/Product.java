package com.it.ldq.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 商品实体类
 */
@Data
@Entity
@Table(name = "product")
public class Product {
	@Id
	private Long id;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_dsc")
	private String productDsc;
	@Column(name = "product_status")
	private Integer status;
	@Column(name = "product_price")
	private BigDecimal productPrice;
}
