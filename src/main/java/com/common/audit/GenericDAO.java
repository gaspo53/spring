/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: grajoy
 * Date:  Mar 26, 2013 - 11:15:13 AM
 */
package com.common.audit;

/**

 * @author grajoy - Flux IT

 **/
import java.io.Serializable;

public interface GenericDAO<T, ID extends Serializable> {

 /** Persist the newInstance object into database */
 ID create(T newInstance);


 /** Save changes made to a persistent object. */
 void update(T transientObject);

 /** Remove an object from persistent storage in the database */
 void delete(T persistentObject);
}
