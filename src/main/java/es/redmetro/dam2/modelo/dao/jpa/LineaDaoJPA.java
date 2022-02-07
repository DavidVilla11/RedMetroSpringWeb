package es.redmetro.dam2.modelo.dao.jpa;

import java.util.Base64;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;

import es.redmetro.dam2.modelo.dao.IBaseGeneralDao;
import es.redmetro.dam2.modelo.dao.ILineaDao;
import es.redmetro.dam2.modelo.excepciones.RedMetroException;
import es.redmetro.dam2.modelo.utilidades.GestorEntityManagerJPA;
import es.redmetro.dam2.modelo.vo.Linea;

public class LineaDaoJPA implements ILineaDao {

	private EntityManager entityManager;
	
	
	public void crear(Linea entidad) throws RedMetroException {
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

	
	public void borrar(Linea entidad) throws RedMetroException {
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

	
	public void actualizar(Linea entidad) throws RedMetroException {
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

	
	public Linea getEntirdadPorID(int idEntidad) throws RedMetroException {
		Linea linea = null;
		try {
			entityManager=GestorEntityManagerJPA.getEntityManager();
			
			linea = entityManager.find(Linea.class, idEntidad);
			
		}catch (NoResultException e) {
			linea = null;
		}catch(PersistenceException e){
			throw new RedMetroException(RedMetroException.ERROR_CONSULTA, e);
		}finally {
			if (entityManager!=null)
        		entityManager.close();
		}
		
		return linea;
	}

	
	public List<Linea> getListaEntidades() throws RedMetroException {
		List<Linea> linea = null;
		try {
			entityManager=GestorEntityManagerJPA.getEntityManager();
			
			String sentenciaJPQL="SELECT linea FROM Linea linea";
			
			TypedQuery<Linea> query =entityManager.createQuery(sentenciaJPQL, Linea.class);
			
			linea = query.getResultList();
			

			
		}catch (NoResultException e) {
			linea = null;
		}catch(HibernateException e){
			throw new RedMetroException(RedMetroException.ERROR_CONSULTA, e);
		}finally {
        	if (entityManager!=null)
        		entityManager.close();
		}
		
		return linea;
	}

}
