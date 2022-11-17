package com.xworkz.jpa_jewellery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.xworkz.jpa_jewellery.entity.JewelleryEntity;
import com.xworkz.jpa_jewellery.enums.JewelleryType;
import com.xworkz.jpa_jewellery.service.JewelleryServices;
import com.xworkz.jpa_jewellery.service.JewelleryServicesImpl;

public class JewelleryRunner {

	public static void main(String[] args) {
		JewelleryEntity entity = new JewelleryEntity(JewelleryType.CARATA, 300, 3, 100, 80, 500, true, "SLV");
		JewelleryEntity entity1 = new JewelleryEntity(JewelleryType.CARATA, 200, 5, 10, 180, 600, true, "SBI");
		JewelleryEntity entity2 = new JewelleryEntity(JewelleryType.CARATA, 150, 3, 500, 280, 900, true, "BTM");

		JewelleryServices services = new JewelleryServicesImpl();

		// services.validateAndSave(entity);
		List<JewelleryEntity> entities = new ArrayList<JewelleryEntity>();
		entities.add(entity1);
		entities.add(entity2);
		services.validateAndSave(entities);

		Optional<JewelleryEntity> findByShopNameAndId = services.findByShopNameAndId(1, "SLV");
		if (findByShopNameAndId.isPresent()) {
			JewelleryEntity jewelleryEntity = findByShopNameAndId.get();
			System.out.println(jewelleryEntity);

		}
		System.out.println("=============================================");
		Optional<String> findShopNameById = services.findShopNameById(2);
		if (findShopNameById.isPresent()) {
			String string = findShopNameById.get();
			System.out.println(string);
		}
		System.out.println("=========================================");
		Optional<Integer> findMakingChargesByShopName = services.findMakingChargesByShopName("SBI");
		if (findMakingChargesByShopName.isPresent()) {
			Integer integer = findMakingChargesByShopName.get();
			System.out.println(integer);
		}
		System.out.println("====================================");
		Optional<Object[]> findWashtageChargeAndMakingChargeByShopName = services
				.findWashtageChargeAndMakingChargeByShopName("SLV");
		if (findWashtageChargeAndMakingChargeByShopName.isPresent()) {
			Object[] integer = findWashtageChargeAndMakingChargeByShopName.get();
			System.out.println("-------------------------------");

			for (Object object : integer) {
				System.out.println(object);
			}
			System.out.println("-------------------------------");
		}
		System.out.println("==================================");
		Optional<Long> findTotalPriceByGramAndShopName = services.findTotalPriceByGramAndShopName(10, "SBI");
		if (findTotalPriceByGramAndShopName.isPresent()) {
			Long integer = findTotalPriceByGramAndShopName.get();
			//System.out.println("killer");
			System.out.println(integer);
			//System.out.println("done");
		}

	}

}
