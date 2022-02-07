package es.redmetro.dam2.modelo.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;

import es.redmetro.dam2.modelo.dao.IBaseGeneralDao;
import es.redmetro.dam2.modelo.dao.IColorDao;
import es.redmetro.dam2.modelo.excepciones.RedMetroException;
import es.redmetro.dam2.modelo.utilidades.GestorEntityManagerJPA;
import es.redmetro.dam2.modelo.vo.Color;

public class ColorDaoJPA implements IColorDao {

	private EntityManager entityManager;
	
	
	public void crear(Color entidad) throws RedMetroException {
		
		EntityTransaction transaccion=null;
		try {
			entityManager=GestorEntityManagerJPA.getEntityManager();
			transaccion=entityManager.getTransaction();
			transaccion.begin();
			
			entityManager.persist(entidad);
            
            transaccion.commit();
        } catch (RollbackException err) {
        }
        catch (PersistenceException e) {
            if(transaccion != null)
            	transaccion.rollback();
            throw new  RedMetroException(RedMetroException.ERROR_ALTA, e);            
        } finally {
        	if (entityManager!=null)
        		entityManager.close();
        }				
		
		
	}

	
	public void borrar(Color entidad) throws RedMetroException {
		
		EntityTransaction transaccion=null;
		try {
			entityManager=GestorEntityManagerJPA.getEntityManager();
			transaccion=entityManager.getTransaction();
			transaccion.begin();
			
			if (!entityManager.contains(entidad))
				entidad=entityManager.merge(entidad);

			entityManager.remove(entidad);
            
            transaccion.commit();
        } catch (PersistenceException e) {
            if(transaccion != null)
            	transaccion.rollback();
            throw new  RedMetroException(RedMetroException.ERROR_BORRAR, e);            
        } finally {
        	if (entityManager!=null)
        		entityManager.close();
        }	
		
	}

	
	public void actualizar(Color entidad) throws RedMetroException {
		EntityTransaction transaccion=null;
		try {
			entityManager=GestorEntityManagerJPA.getEntityManager();
			transaccion=entityManager.getTransaction();
			transaccion.begin();
			
			if (!entityManager.contains(entidad))
				entidad=entityManager.merge(entidad);
			
//			Se actualizar� cualquier cambio existente entre el objeto que est� en la base de datos y el que 
//			se maneja como entidad, siempre que est� entre el comienzo y la confirmaci�n de una transacci�n. 

            
            transaccion.commit();
        } catch (PersistenceException e) {
            if(transaccion != null)
            	transaccion.rollback();
            throw new  RedMetroException(RedMetroException.ERROR_MODIFICAR, e);            
        } finally {
        	if (entityManager!=null)
        		entityManager.close();
        }
		
	}

	
	public Color getEntirdadPorID(int idEntidad) throws RedMetroException {
		Color color = null;
		try {
			entityManager=GestorEntityManagerJPA.getEntityManager();
			
			color = entityManager.find(Color.class, idEntidad);
			
		}catch (NoResultException e) {
			color = null;
		}catch(PersistenceException e){
			throw new RedMetroException(RedMetroException.ERROR_CONSULTA, e);
		}finally {
			if (entityManager!=null)
        		entityManager.close();
		}
		
		return color;
	}

	
	public List<Color> getListaEntidades() throws RedMetroException {
		
		List<Color> color = null;
		try {
			entityManager=GestorEntityManagerJPA.getEntityManager();
			
			String sentenciaJPQL="SELECT color FROM Color color";
			
			TypedQuery<Color> query =entityManager.createQuery(sentenciaJPQL, Color.class);
			
			color = query.getResultList();
			
		}catch (NoResultException e) {
			color = null;
		}catch(HibernateException e){
			throw new RedMetroException(RedMetroException.ERROR_CONSULTA, e);
		}finally {
        	if (entityManager!=null)
        		entityManager.close();
		}
		
		return color;
	}

}
