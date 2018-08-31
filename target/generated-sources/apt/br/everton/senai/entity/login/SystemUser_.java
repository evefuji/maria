package br.everton.senai.entity.login;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SystemUser.class)
public abstract class SystemUser_ {

	public static volatile SingularAttribute<SystemUser, Date> createdAt;
	public static volatile SingularAttribute<SystemUser, Long> id;
	public static volatile SingularAttribute<SystemUser, String> uuid;

}

