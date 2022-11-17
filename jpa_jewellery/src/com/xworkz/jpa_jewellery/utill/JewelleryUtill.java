package com.xworkz.jpa_jewellery.utill;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JewelleryUtill {
private static	EntityManagerFactory factory;
public static EntityManagerFactory getFactory() {
	return factory;
}
static {
	
	factory= Persistence.createEntityManagerFactory("forentitylinkjewellery");
}

}
