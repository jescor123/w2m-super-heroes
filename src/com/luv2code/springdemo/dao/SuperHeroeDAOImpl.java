package com.luv2code.springdemo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.luv2code.springdemo.entity.SuperHeroe;

@Repository
public class SuperHeroeDAOImpl implements SuperHeroeDAO {

	
	@Autowired
	private SessionFactory sessionFactory;	

	@Override
	public List<SuperHeroe> getAllSuperHeroes() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		String queryString = "from SuperHeroe";
		Query<SuperHeroe> theQuery = 
				currentSession.createQuery(queryString, SuperHeroe.class);		
		List<SuperHeroe> superHeroes = theQuery.getResultList();
		return superHeroes;
		
	}

	@Override
	public List<SuperHeroe> getSuperHeroesByName(String search) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		String queryString = "from SuperHeroe where lower(name) like :theSearch order by name desc";
		Query<SuperHeroe> theQuery = 
				currentSession.createQuery(queryString, SuperHeroe.class);
		theQuery.setParameter("theSearch", "%" + search.toLowerCase() + "%");
		List<SuperHeroe> employees = theQuery.getResultList();
		return employees;
		
	}

	@Override
	public void updateSuperHeroe(SuperHeroe superHeroe) {
		
		Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(superHeroe);
		
	}

	@Override
	public void deleteSuperHeroe(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createQuery("delete from SuperHeroe where id=:superHeroeId");
		theQuery.setParameter("superHeroeId", id);
		theQuery.executeUpdate();
		
	}

	@Override
	public SuperHeroe getSuperHeroeById(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		SuperHeroe s = currentSession.get(SuperHeroe.class, id);
		return s;
		
	}

	
}
