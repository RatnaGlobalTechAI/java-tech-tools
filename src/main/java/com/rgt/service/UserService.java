package com.rgt.service;

import com.rgt.request.UserRequest;
import com.rgt.response.ResponseObject;

public interface UserService {

	ResponseObject createAccount(UserRequest userRequest);

	ResponseObject updateUser(String emailId , UserRequest userRequest);

}
