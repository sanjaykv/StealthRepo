package com.stylincity.login.dao;

import com.stylincity.common.dao.BaseDao;
import com.stylincity.login.bean.UserAccount;

public interface UserAccountDao extends BaseDao<UserAccount>{
	
	void insert(UserAccount userAccount);
	
	void update(UserAccount userAccount);
	
	UserAccount get(String email);
	
	UserAccount get(String email, String password);
}
