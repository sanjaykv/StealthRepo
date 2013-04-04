package com.stylincity.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stylincity.login.bean.UserAccount;
import com.stylincity.login.bean.enums.UserAccountStatus;
import com.stylincity.login.dao.UserAccountDao;

@Service
public class LoginService {
	
	@Autowired private UserAccountDao userAccountDao;
	
	public String login(UserAccount userAccount) {
		String email = userAccount.getEmail();
		String password = userAccount.getPassword();
		
		UserAccountStatus loginStatus = null;
		
		UserAccount userAccountInDb = userAccountDao.get(email);
		
		// User Record does not exist. Insert it.
		if(userAccountInDb == null) {
			userAccountDao.insert(userAccount);
			loginStatus = UserAccountStatus.NEW_USER_CREATED;
		}
		else {
			// Email and password matched. Login successful
			if(password.equals(userAccountInDb.getPassword())){
				loginStatus = UserAccountStatus.LOGIN_SUCCESS;
			}
			// Email matched. Password didn't match. Login unsuccessful.
			else{
				loginStatus = UserAccountStatus.INVALID_LOGIN;
			}
		}
		return loginStatus.toString();
	}
}
