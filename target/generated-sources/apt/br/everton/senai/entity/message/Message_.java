package br.everton.senai.entity.message;

import br.everton.senai.entity.login.SystemUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Message.class)
public abstract class Message_ {

	public static volatile SingularAttribute<Message, Date> createdAt;
	public static volatile SingularAttribute<Message, SystemUser> systemUser;
	public static volatile SingularAttribute<Message, Long> id;
	public static volatile SingularAttribute<Message, String> message;

}

