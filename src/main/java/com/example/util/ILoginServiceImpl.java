package com.example.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("ls")

public class ILoginServiceImpl implements ILoginService {

	@Autowired
	ILoginDao ld;

	@Override
	public String validateCredintials(Object obj) {
		return ld.validateCredintials(obj);
	}

}
