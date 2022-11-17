package com.xworkz.jpa_jewellery.service;

import java.util.List;
import java.util.Optional;

import com.xworkz.jpa_jewellery.entity.JewelleryEntity;
import com.xworkz.jpa_jewellery.enums.JewelleryType;
import com.xworkz.jpa_jewellery.repository.JewelleryRepository;
import com.xworkz.jpa_jewellery.repository.JewelleryRepositoryImpl;

public class JewelleryServicesImpl implements JewelleryServices {
	private JewelleryRepository repo=new JewelleryRepositoryImpl();
	@Override
	public boolean validateAndSave(JewelleryEntity entity) {
		int id = entity.getId();
		JewelleryType type = entity.getType();
		int goldPrice = entity.getGoldPrice();
		int gstPrice = entity.getGstPrice();
		int gram = entity.getGram();
		int makingCharge = entity.getMakingCharge();
		int wastageCharge = entity.getWastageCharge();
		boolean copper = entity.isCopper();
		String shopName = entity.getShopName();
		
		//if(id>0) {
			//System.out.println("id is valid");
			if(type!=null) {
				System.out.println("jewlry type is valid");
				if(goldPrice>0 && goldPrice<6000) {
					System.out.println("gold price is valid");
					if(gstPrice>0 && gstPrice<18) {
						System.out.println("gst is valid");
						if(gram>0 && gram<1000) {
							System.out.println("garm is valid");
							if(makingCharge>0 && makingCharge<1000) {
								System.out.println("making charge is valid");
								if(wastageCharge>0 && wastageCharge<1000) {
									System.out.println("wastage cahrge is more");
									if(copper) {
										System.out.println("copper is valid");
										if(shopName!=null) {
											System.out.println("shop name is valid");
											
		this.repo.save(entity);								
										}else {
											System.out.println("shop name is not valid");
										}
									}else {
										System.out.println("coper is not valid");
									}
								}else {
									System.out.println("wastage charge is not valid");
								}
							}else {
								System.out.println("makinga charge is noat valid");
							}
						}else {
							System.out.println("gram is not valid");
						}
					}else {
						System.out.println("gst is not valid");
					}
				}else {
					System.out.println("gold price is not valid");
				}
			}else {
				System.out.println(" jewellery type is not valid");
			}
	//}//else {
//			System.out.println("id is not valid");
//		}
//		
		
		return false;
	}
	@Override
	public boolean validateAndSave(List<JewelleryEntity> entities) {

		for (JewelleryEntity jewelleryEntity : entities) {
			int goldPrice = jewelleryEntity.getGoldPrice();
			String shopName = jewelleryEntity.getShopName();
			if(goldPrice>0 && goldPrice<6000) {
				System.out.println("gold price is valid");
				if(shopName!=null) {
					System.out.println(" shop name is valid");
					
				}else {
					System.out.println("shop name is not valid");
				}
		}else {
			System.out.println("gold price not valid");
		}
			
		
	}
		repo.save(entities);
		return false;
}
	@Override
	public Optional<JewelleryEntity> findByShopNameAndId(int id, String shopName) {

		
		return repo.findByShopNameAndId(id, shopName);
	}
	@Override
	public Optional<String> findShopNameById(int id) {
		// TODO Auto-generated method stub
		return repo.findShopNameById(id);
	}
	@Override
	public Optional<Integer> findMakingChargesByShopName(String shopName) {
		// TODO Auto-generated method stub
		return 	repo.findMakingChargesByShopName(shopName);

	}
	@Override
	public Optional<Object[]> findWashtageChargeAndMakingChargeByShopName(String shopName) {
		// TODO Auto-generated method stub
		return repo.findWashtageChargeAndMakingChargeByShopName(shopName);
	}
	@Override
	public Optional<Long> findTotalPriceByGramAndShopName(int gram, String shopName) {
		// TODO Auto-generated method stub
		
		return repo.findTotalPriceByGramAndShopName(gram, shopName);
	}
}
