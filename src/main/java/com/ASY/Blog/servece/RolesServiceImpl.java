package com.ASY.Blog.servece;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ASY.Blog.dao.RolesRepository;
import com.ASY.Blog.entity.Roles;

@Service
public class RolesServiceImpl implements RolesService {

	@Autowired
	private RolesRepository authoritiesRepository;
	
	@Override
	public List<Roles> findAll() {
		return authoritiesRepository.findAll();
	}

	@Override
	public Roles findById(int theId) {
		Optional<Roles> result = authoritiesRepository.findById(theId);
		
		Roles tempAuthority = null;
		
		if(result.isPresent()) {
			tempAuthority = result.get();
		}
		else {
			// we didn't find the Authority
			throw new RuntimeException("did not find Authority id : " + theId);
		}
		
		return tempAuthority;
	}

	@Override
	public void save(Roles theAuthority) {
		
		authoritiesRepository.save(theAuthority);
	}

	@Override
	public void deleteById(int theId) {
		
		authoritiesRepository.deleteById(theId);
	}

	@Override
	public Roles findByauthority(String authority) {
		
		return authoritiesRepository.findByauthority(authority);
	}

}
