package projet15;
/****
 * 
 * @author Seif_mejri
 *
 */
public class Resto {
	
int idR;
String nameR;
String AdresseR;
int nbre_fourchetteR;
String specialiteR;
String numtelR;
double X_latt,Y_long;
int like,dislike;
String description;



 public Resto(int idR,String nameR,int nbre_fourchetteR,String specialiteR,String adresseR) {
	 this.idR=idR;
	 this.nameR=nameR;
	 this.nbre_fourchetteR=nbre_fourchetteR;
	 this.specialiteR=specialiteR;
	 this.AdresseR=adresseR;
	 
	
 }
 public Resto(int idR,String nameR,int nbre_fourchetteR,String specialiteR,String adresseR,String numtelR) {
	 this.idR=idR;
	 this.nameR=nameR;
	 this.nbre_fourchetteR=nbre_fourchetteR;
	 this.specialiteR=specialiteR;
	 this.AdresseR=adresseR;
	 this.numtelR=numtelR;
	
 }
}
