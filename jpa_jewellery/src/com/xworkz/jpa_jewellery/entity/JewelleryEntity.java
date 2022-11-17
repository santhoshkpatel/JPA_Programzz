package com.xworkz.jpa_jewellery.entity;



import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.xworkz.jpa_jewellery.enums.JewelleryType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jewellery")
@Entity
@NamedQuery(name = "findByShopNameAndId",query = "select aliyasname from JewelleryEntity aliyasname where aliyasname.shopName=:shi and aliyasname.id=:dummy ")
@NamedQuery(name = "findShopNameById",query = "select aliyasname.shopName from JewelleryEntity aliyasname where aliyasname.id=:iddupe")
@NamedQuery(name = "findMakingChargesByShopName",query = "select distinct aliyasname.makingCharge from JewelleryEntity aliyasname where aliyasname.shopName=:take")
@NamedQuery(name = "findWashtageChargeAndMakingChargeByShopName",query = "select  aliyasname.wastageCharge,aliyasname.makingCharge from JewelleryEntity aliyasname where aliyasname.shopName=:take")
@NamedQuery(name = "findTotalPriceByGramAndShopName",query = "select SUM(goldPrice + gstPrice + makingCharge + wastageCharge) from JewelleryEntity aliyasname where aliyasname.gram=:take1 and aliyasname.shopName=:take2")


public class JewelleryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private JewelleryType type;
	private int goldPrice;
	private int gstPrice;
	private int gram;
	private int makingCharge;
	private int wastageCharge;
	private boolean copper;
	private String shopName;

	public JewelleryEntity(JewelleryType type, int goldPrice, int gstPrice, int gram, int makingCharge,
			int wastageCharge, boolean copper, String shopName) {
		super();
		this.type = type;
		this.goldPrice = goldPrice;
		this.gstPrice = gstPrice;
		this.gram = gram;
		this.makingCharge = makingCharge;
		this.wastageCharge = wastageCharge;
		this.copper = copper;
		this.shopName = shopName;
	}

}
