package com.sharathit.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sharathit.binding.CitizenApp;
import com.sharathit.entity.CitizenAppEntity;
import com.sharathit.repo.CitizenAppRepository;

@Service
public class ArServiceImpl implements ArService {

	@Autowired
	private CitizenAppRepository repo;

	@Override
	public Integer createApplication(CitizenApp app) {

		System.out.println("ssn is " + app.getSSN());
		String endPointUrl = "https://ssa-web-api.herokuapp.com/ssn/{ssn}";
		RestTemplate rt = new RestTemplate();
 		ResponseEntity<String> respEntity = rt.getForEntity(endPointUrl, String.class, app.getSSN());
	//	ResponseEntity<String> respEntity = rt.getForEntity(endPointUrl, String.class, 608080L);

		String stateNAME = respEntity.getBody();

		if ("New Jersey".equals(stateNAME)) {

			CitizenAppEntity entity = new CitizenAppEntity();

			BeanUtils.copyProperties(app, entity);

			CitizenAppEntity save = repo.save(entity);

			return save.getAppId();

		}

		return 0;

	}
}
