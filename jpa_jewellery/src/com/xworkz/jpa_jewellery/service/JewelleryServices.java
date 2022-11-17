package com.xworkz.jpa_jewellery.service;

import java.util.List;
import java.util.Optional;

import com.xworkz.jpa_jewellery.entity.JewelleryEntity;

public interface JewelleryServices {
	boolean validateAndSave(JewelleryEntity entity);
	boolean validateAndSave(List<JewelleryEntity> entities);
	Optional<JewelleryEntity>findByShopNameAndId(int id,String shopName);
	Optional<String>findShopNameById(int id);
	Optional<Integer>findMakingChargesByShopName(String shopName);
	Optional<Object[]>findWashtageChargeAndMakingChargeByShopName(String shopName);
	Optional<Long>findTotalPriceByGramAndShopName(int gram,String shopName);

}
