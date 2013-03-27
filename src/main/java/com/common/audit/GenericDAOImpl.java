/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: grajoy
 * Date:  Mar 26, 2013 - 11:15:41 AM
 */
package com.common.audit;

/**

 * @author grajoy - Flux IT

 **/

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
@Transactional
public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private SessionFactory sessionFactory;

	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public ID create(final T newInstance) {
		ID id = null;
		final Session session = sessionFactory.openSession();
		final Transaction tx = session.beginTransaction();
		try {
			id = (ID) session.save(newInstance);
			tx.commit();
			session.close();
		} catch (final Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return id;
	}

	@Override
	public void update(final T transientObject) {
		final Session session = sessionFactory.openSession();
		final Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(transientObject);
			tx.commit();
			session.close();
		} catch (final Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void delete(final T persistentObject) {
		final Session session = sessionFactory.openSession();
		final Transaction tx = session.beginTransaction();
		try {
			session.delete(persistentObject);
			tx.commit();
			session.close();
		} catch (final Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
	}
}