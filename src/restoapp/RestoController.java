package restoapp;

import java.sql.*;
import java.util.ArrayList;


public class RestoController  {
	
	
	  
	
	
 public ArrayList<Resto> getParNom(String nomResto){
	ArrayList<Resto> ListResto = new ArrayList<Resto>();
	try{
	
	//connection to the database in order to getParNom selon nomResto
	  Connection con=connexionJM.dBconnector();
	String sql="select * from Restaurant where nameR= "+"'"+nomResto+"'";
	//envoi d'une requette g�n�rique 
	 Statement smt = con.createStatement();
	 ResultSet rs = smt.executeQuery(sql) ;
	 int i=0;  
	 
	 while (rs.next()) {
		 Resto e=new Resto(rs.getInt("idR"),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(6),rs.getString(5));
	     ListResto.add(i, e);
	    i++;
         }
	   
	}catch(SQLException e1){
		e1.getMessage();System.out.println("Sql errrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrorrrrrrrrrrrrrrrrrrrrrrrrrr");
	}
	catch(Exception e2){
		e2.getMessage();System.out.println("gen errrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrorrrrrrrrrrrrrrrrrrrrrrrrrr");
		
	}		     
	return ListResto; 
  }

public ArrayList<Resto> getParSpecialite(String specialite){
	  ArrayList<Resto> ListResto=new ArrayList<Resto>();
	try{
		
		//connection to the database in order to getParNom selon nomResto
		  Connection con=connexionJM.dBconnector();
		String sql="select * from Restaurant where specialiteR= "+"'"+specialite+"'";
		//envoi d'une requette g�n�rique 
		 Statement smt = con.createStatement();
		 ResultSet rs = smt.executeQuery(sql) ;
		 int i=0;    
		 while (rs.next()) {
		       //System.out.println(rs.getString(2)+','+rs.getString(1)+",nbre de fourchette="+rs.getString(3)+','+rs.getString(5)) ;
		       Resto e=new Resto(rs.getInt("idR"),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(6),rs.getString(5));
		       ListResto.add(i,e);
		       i++;
	         }
		  
	}catch(SQLException e){
		e.getMessage();System.out.println("Sql errrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrorrrrrrrrrrrrrrrrrrrrrrrrrr");
	 
   }
	return ListResto;
 }
public ArrayList<Resto> getParFourchette(int nbre_fourchette){
	
	ArrayList<Resto> ListResto=new ArrayList<Resto>();
	try{
		//connection to the database in order to getParNom selon nomResto
		  Connection con=connexionJM.dBconnector();
		String sql="select * from Restaurant where nbre_fourchetteR= "+nbre_fourchette;
		//envoi d'une requette g�n�rique 
		 Statement smt = con.createStatement();
		 ResultSet rs = smt.executeQuery(sql) ;
		 int i=0;    
		 while (rs.next()) {
		       Resto e=new Resto(rs.getInt("idR"),rs.getString("nameR"),rs.getInt(3),rs.getString(4),rs.getString(6),rs.getString(5)) ;
		       ListResto.add(i,e);
		       i++;
	         }
		  
	}catch(SQLException e){
		e.getMessage();System.out.println("Sql errrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrorrrrrrrrrrrrrrrrrrrrrrrrrr");
	 
   }
	return ListResto;
 }
public ArrayList<Resto> getParCoordonnes(double X, double Y){
	ArrayList<Resto> ListResto=new ArrayList<Resto>();
    try { 
    	//connection to the database in order to getParNom selon nomResto
		  Connection con=connexionJM.dBconnector();
		  Statement smt = con.createStatement();
      double rayonCel=10;
      double distance=0;         
      ResultSet rs1 = smt.executeQuery("select * from Restaurant " ) ;
      
      int i=0;
       while (rs1.next()) {
     	  double xx=rs1.getDouble("X_latt");
     	  double yy=rs1.getDouble("Y_long");
     	  distance=Math.sqrt(((xx-X)*(xx-X)+(yy-Y)*(yy-Y)));
     	  if (distance< rayonCel){
     		 
     	     Resto e=new Resto(rs1.getInt("idR"),rs1.getString("nameR"),rs1.getInt(3),rs1.getString(4),rs1.getString(6),rs1.getString(5)) ;
		     ListResto.add(i,e);
		     i++;
     	  }
         
      }
      
            
   }  catch (SQLException e) {
       // gestion des exceptions
   }
    
  return ListResto;  
}
   
//mis a jour le nombre de like pour un restaurant particulier
	
	public void nvLike(String nomRes)
	{
		Statement smt;
		
		    try {
		    Connection con=connexionJM.dBconnector();
			smt = con.createStatement();
		
		String query1="Select like From restaurant where nameR='"+nomRes+"'";
		ResultSet rs = smt.executeQuery(query1);
		int lk =(rs.getInt("like"));
		int id=rs.getInt(1);
		lk++;
		String query2="Update mydb.restaurant Set dislike="+lk+" and Where nameR="+nomRes+" and idR="+id;
		smt.executeUpdate(query2);
		
		
	      } catch (SQLException e) {
		
		e.printStackTrace();

		}
		
	}
 

}
