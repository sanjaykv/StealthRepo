package com.stylincity.login.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stylincity.common.dao.impl.BaseDaoImpl;
import com.stylincity.login.bean.UserAccount;
import com.stylincity.login.dao.UserAccountDao;

@Repository("userAccountDao")
public class UserAccountDaoImpl extends BaseDaoImpl<UserAccount> implements UserAccountDao {

	@PersistenceContext(unitName = "STYLEDS")
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Transactional
	@Override
	public void insert(UserAccount userAccount) {
		save(userAccount);
	}

	@Override
	public void update(UserAccount userAccount) {
		
	}

	@Override
	public UserAccount get(String email) {
		Query query = getEntityManager().createQuery("from UserAccount where email=:email");
		query.setParameter("email", email);
		UserAccount userAccount = (UserAccount)query.getSingleResult();
		return userAccount;
	}
	
	@Override
	public UserAccount get(String email, String password) {
		Query query = getEntityManager().createQuery("from UserAccount where email=:email and password=:password");
		query.setParameter("email", email);
		query.setParameter("password", password);
		UserAccount userAccount = (UserAccount)query.getSingleResult();
		return userAccount;
	}

}
