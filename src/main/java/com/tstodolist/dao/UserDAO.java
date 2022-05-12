package com.tstodolist.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.tstodolist.hibernate.HibernateUtil;
import com.tstodolist.model.LoginVO;
import com.tstodolist.model.ToDo;



@Repository
public class UserDAO{
		    
	    public int registerUser(LoginVO lLoginVO)
	    {
	    	System.out.println("Inside registerUser method of UserDAO");
	    	LoginVO newUser = lLoginVO;
	    	newUser.setCreatedOn(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
	        Transaction transaction = null;
	        try {
	        	Session session = HibernateUtil.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            
	            if(!checkUserNameExists(lLoginVO))
	            {
	            // save the user objects
	            session.save(newUser);
	            transaction.commit();
	            return 0;
	            }
	            
	           	// commit transaction
	           
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	       
	    	return 1;
	    }
	    
	    public boolean checkUserNameExists(LoginVO lLoginVO)
	    {
	    	 System.out.println("Inside checkUserNameExists method of UserDAO");
	    	 try{ 
					
					Session session = HibernateUtil.getSessionFactory().openSession() ;
					

		            // get an student object
		            String hql = " FROM LoginVO l WHERE l.userid = :userId";
		            
		            Query query = session.createQuery(hql);
		            query.setParameter("userId", lLoginVO.getUserid());
		            List<LoginVO> results = query.getResultList();

		            if (results != null && !results.isEmpty())
		            	
		            	{
		            		System.out.println("User Exists.!");
		            		return true;
		            	}
		            // commit transaction
		          
		        } catch (Exception e) {
		        	 e.printStackTrace();
		            }
				return false;
	    	
	    }
	    
	    @SuppressWarnings({ "unlikely-arg-type", "deprecation" })
		public int validateUser(LoginVO lLoginVO) {
	    	 
	    	 System.out.println("Inside validateUser method of UserDAO");
	        try{ 
				
				Session session = HibernateUtil.getSessionFactory().openSession() ;
				

	            // get an student object
	            String hql = " FROM LoginVO l WHERE l.userid = :userId";
	            
	            Query query = session.createQuery(hql);
	            query.setParameter("userId", lLoginVO.getUserid());
	            List<LoginVO> results = query.getResultList();

	            if (results != null && !results.isEmpty()) {
	            	System.out.println(results.get(0).getPassword());
	            	System.out.println(lLoginVO.getPassword());
	            	String actual= results.get(0).getPassword();
	            	String entered = lLoginVO.getPassword();
	            	if(actual.equals(entered))
	            	{
	            		System.out.println("Validated");
	            		return 0;
	            	}
	            	
	               
	            }
	            // commit transaction
	          
	        } catch (Exception e) {
	        	 e.printStackTrace();
	            }
			return 1;
	           
	        
			
	    }

		public int getUser() {
			// TODO Auto-generated method stub
			 System.out.println("Inside getUser method of UserDAO");
			try{ 
				
				Session session = HibernateUtil.getSessionFactory().openSession() ;
	            List < LoginVO > students = session.createQuery("from LoginVO", LoginVO.class).list();
	            students.forEach(s-> System.out.println(s.getPassword()));
	        } catch (Exception e) {
	        	 e.printStackTrace();
	            }
	           
	        
			return 0;
		}
		
		public int addToDo(ToDo lToDo)
	    {
			System.out.println("Inside addToDo method of UserDAO");
			ToDo newtodo = lToDo;
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			lToDo.setToDoModifedDate(timestamp);
			lToDo.setToDoCreatedDate(timestamp);
	        Transaction transaction = null;
	        List<ToDo> todolist= new ArrayList<ToDo>(); 
	        try {
	        	Session session = HibernateUtil.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student objects
	            session.save(newtodo);
	            
	           	// commit transaction
	            transaction.commit();
	            
	         //   todolist = getToDoAfterUpdation(lToDo);
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	                return 1;
	            }
	            e.printStackTrace();
	        }
	       
	    	return 0;
	    }
		
		public List<ToDo> getToDo(LoginVO lLoginVO) {
			
			System.out.println("Inside getToDo method of UserDAO");
			// TODO Auto-generated method stub
			 List < ToDo > todo = null;
			 Query query = null;
			try{ 
				
				    Session session = HibernateUtil.getSessionFactory().openSession() ;
				    String hql = " FROM ToDo td WHERE td.id = :userId";
		            
				    query = session.createQuery(hql);
		            query.setParameter("userId", lLoginVO.getUserid());
		            todo = query.getResultList();
	          
	        } catch (Exception e) {
	        	 e.printStackTrace();
	            }
	           
	        
			return todo;
		}
		
          public List<ToDo> getToDoAfterUpdation(ToDo lToDo) {
			
			System.out.println("Inside getToDoAfterUpdation method of UserDAO");
			// TODO Auto-generated method stub
			 List < ToDo > todo = null;
			 Query query = null;
			try{ 
				
				 	Session session = HibernateUtil.getSessionFactory().openSession() ;
				    String hql = " FROM ToDo td WHERE td.id = :userId";
		            
				    query = session.createQuery(hql);
		            query.setParameter("userId", lToDo.getId());
		            todo = query.getResultList();
	        } catch (Exception e) {
	        	 e.printStackTrace();
	            }
	           
	        
			return todo;
		}
		
       public List<ToDo> getToDoByType(ToDo lToDo) {
			
			System.out.println("Inside getToDoByType method of UserDAO");
			// TODO Auto-generated method stub
			 List < ToDo > todo = null;
			try{ 
				
				Session session = HibernateUtil.getSessionFactory().openSession() ;
				Query query = null;
				 if (!lToDo.getToDoType().equals( "All"))
				 {
				    String hql = " FROM ToDo td WHERE td.id = :userId and td.toDoType = :toDoType";
		            
				    query = session.createQuery(hql);
		            query.setParameter("userId", lToDo.getId());
		           
		            query.setParameter("toDoType", lToDo.getToDoType());
		            
				 }
				 else
					 
				 {
					 	String hql = " FROM ToDo td WHERE td.id = :userId ";
			            
					 	query = session.createQuery(hql);
			            query.setParameter("userId", lToDo.getId());
			           
				 }
				 
		            todo = query.getResultList();
	           
	        } catch (Exception e) {
	        	 e.printStackTrace();
	            }
	           
	        
			return todo;
		}

		public int doneToDo(ToDo lToDoVO) {
			// TODO Auto-generated method stub
			
			System.out.println("Inside doneToDo method of UserDAO");
			int result = 0;
			 List < ToDo > todolist = null;
			 Transaction transaction = null;
				try{ 
				int toDoId= lToDoVO.getTodoid();
				Session session = HibernateUtil.getSessionFactory().openSession() ;
				 transaction = session.beginTransaction();
	            String query = "update ToDo td set td.toDoStatus='Done' where td.todoid=:todoId";
	            Query query1 = session.createQuery(query);
	            query1.setParameter("todoId", toDoId);
	            result = query1.executeUpdate();
	           // todo.forEach(s-> System.out.println(s.getId()));
	            transaction.commit();
	           
	        } catch (Exception e) {
	        	 if (transaction != null) {
		                transaction.rollback();
		            }
		            e.printStackTrace();
		            return 1;
	            }
	           
			return 0;
		}
		
		public int updateToDo(ToDo lToDoVO) {
			// TODO Auto-generated method stub
			
			System.out.println("Inside updateToDo method of UserDAO");
			int result = 0;
			 Transaction transaction = null;
				try{ 
				int toDoId= lToDoVO.getTodoid();
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				lToDoVO.setToDoModifedDate(timestamp);
				Session session = HibernateUtil.getSessionFactory().openSession() ;
				 transaction = session.beginTransaction();
	            String query = "update ToDo td set td.toDodesc=:tododesc,td.toDoOn=:toDoOn,td.toDoModifedDate=:toDoModifedDate where td.todoid=:todoId";
	            Query query1 = session.createQuery(query);
	            query1.setParameter("todoId", toDoId);
	            query1.setParameter("toDoOn", lToDoVO.getToDoOn());
	            query1.setParameter("toDoModifedDate", lToDoVO.getToDoModifedDate());
	            query1.setParameter("tododesc", lToDoVO.getToDodesc());
	            result = query1.executeUpdate();
	           // todo.forEach(s-> System.out.println(s.getId()));
	            transaction.commit();
	        } catch (Exception e) {
	        	 if (transaction != null) {
		                transaction.rollback();
		            }
		            e.printStackTrace();
	            }
	           
			return result;
		}
		
		public int deleteToDo(ToDo lToDoVO) {
			// TODO Auto-generated method stub
			
			System.out.println("Inside deleteToDo method of UserDAO");
			int result = 0;
			 Transaction transaction = null;
				try{ 
				int toDoId= lToDoVO.getTodoid();
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				lToDoVO.setToDoModifedDate(timestamp);
				Session session = HibernateUtil.getSessionFactory().openSession() ;
				 transaction = session.beginTransaction();
	            String query = "delete from ToDo td where td.todoid=:todoId";
	            Query query1 = session.createQuery(query);
	            query1.setParameter("todoId", toDoId);
	            
	            result = query1.executeUpdate();
	            transaction.commit();
	        } 
				catch (Exception e) {
	        	 if (transaction != null) {
		                transaction.rollback();
		            }
		            e.printStackTrace();
	            }
	           
			return result;
		}

		public int getUserId(LoginVO lLoginVO) {
			// TODO Auto-generated method stub
			 System.out.println("Inside checkUserNameExists method of UserDAO");
			 int id = 0;
	    	 try{ 
					
					Session session = HibernateUtil.getSessionFactory().openSession() ;
					

		            // get an student object
		            String hql = "select id FROM LoginVO l WHERE l.userid = :userId";
		            
		            Query query = session.createQuery(hql);
		            query.setParameter("userId", lLoginVO.getUserid());
		            id =(int) query.getResultList().get(0);

		           
		            // commit transaction
		          
		        } catch (Exception e) {
		        	 e.printStackTrace();
		            }
				return id;
			
		}
		
	}

