package com.xworkz.jpa_jewellery.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.xworkz.jpa_jewellery.entity.JewelleryEntity;
import com.xworkz.jpa_jewellery.utill.JewelleryUtill;

public class JewelleryRepositoryImpl implements JewelleryRepository {
	private EntityManagerFactory factory = JewelleryUtill.getFactory();

	@Override
	public boolean save(JewelleryEntity entity) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();

			manager.persist(entity);

			transaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

		return false;
	}

	@Override
	public boolean save(List<JewelleryEntity> entity) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			for (JewelleryEntity jewelleryEntity : entity) {
				manager.persist(jewelleryEntity);
			}
		

			transaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}
		return false;
	}

	@Override
	public Optional<JewelleryEntity> findByShopNameAndId(int id, String shopName) {
		EntityManager createEntityManager = factory.createEntityManager();
		Query createNamedQuery = createEntityManager.createNamedQuery("findByShopNameAndId");
		createNamedQuery.setParameter("shi", shopName);
		createNamedQuery.setParameter("dummy", id);
		Object singleResult = createNamedQuery.getSingleResult();
		if(singleResult!=null) {
		JewelleryEntity castingvariable=(JewelleryEntity)singleResult;
		
		return Optional.of(castingvariable);
		}
		
		return Optional.empty();
	}

	@Override
	public Optional<String> findShopNameById(int id) {
		// TODO Auto-generated method stub
		EntityManager createEntityManager = factory.createEntityManager();
	try {
		Query createNamedQuery = createEntityManager.createNamedQuery("findShopNameById");
	
		createNamedQuery.setParameter("iddupe", id);
		Object singleResult = createNamedQuery.getSingleResult();
		if(singleResult!=null) {
			String castingvariable=(String)singleResult;
			return Optional.of(castingvariable);
		}
	}finally {
		createEntityManager.close();
	}
		return null;
	}

	@Override
	public Optional<Integer> findMakingChargesByShopName(String shopName) {
		// TODO Auto-generated method stub
		EntityManager createEntityManager = factory.createEntityManager();
		try {
			Query createNamedQuery = createEntityManager.createNamedQuery("findMakingChargesByShopName");
		
			createNamedQuery.setParameter("take", shopName);
			Object singleResult = createNamedQuery.getSingleResult();
			if(singleResult!=null) {
				Integer castingvariable=(Integer)singleResult;
				return Optional.of(castingvariable);
			}
		}finally {
			createEntityManager.close();
		}
		return Optional.empty();
	}

	@Override
	public Optional<Object[]> findWashtageChargeAndMakingChargeByShopName(String shopName) {
		// TODO Auto-generated method stub
		EntityManager createEntityManager = factory.createEntityManager();
		try {
			Query createNamedQuery = createEntityManager.createNamedQuery("findWashtageChargeAndMakingChargeByShopName");
		
			createNamedQuery.setParameter("take", shopName);
			Object singleResult = createNamedQuery.getSingleResult();
			if(singleResult!=null) {
				Object[] castingvariable=(Object[])singleResult;
				return Optional.of(castingvariable);
			}
		}finally {
			createEntityManager.close();
		}
		return Optional.empty();
	}

	@Override
	public Optional<Long> findTotalPriceByGramAndShopName(int gram, String shopName) {
		EntityManager createEntityManager = factory.createEntityManager();
		try {
			Query createNamedQuery = createEntityManager.createNamedQuery("findTotalPriceByGramAndShopName");
		
			createNamedQuery.setParameter("take1", gram);
			createNamedQuery.setParameter("take2", shopName);
			Object singleResult = createNamedQuery.getSingleResult();
			if(singleResult!=null) {
				Long castingvariable=(Long)singleResult;
				return Optional.of(castingvariable);
			}
		}finally {
			createEntityManager.close();
		}
		return Optional.empty();
	}

}
