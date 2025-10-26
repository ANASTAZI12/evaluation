package org.example.service;

import org.example.dao.IDao;
import org.example.classes.LigneCommandeProduit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class LigneCommandeService implements IDao<LigneCommandeProduit> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public boolean create(LigneCommandeProduit ligneCommande) {
        Session session = sessionFactory.getCurrentSession();
        session.save(ligneCommande);
        return true;
    }

    @Override
    @Transactional
    public boolean delete(LigneCommandeProduit ligneCommande) {
        sessionFactory.getCurrentSession().delete(ligneCommande);
        return true;
    }

    @Override
    @Transactional
    public boolean update(LigneCommandeProduit ligneCommande) {
        sessionFactory.getCurrentSession().update(ligneCommande);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public LigneCommandeProduit findById(int id) {
        return sessionFactory.getCurrentSession().get(LigneCommandeProduit.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LigneCommandeProduit> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from LigneCommandeProduit", LigneCommandeProduit.class)
                .list();
    }
}
