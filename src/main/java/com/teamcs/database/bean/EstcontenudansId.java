package com.teamcs.database.bean;
// Generated 8 juin 2015 21:32:57 by Hibernate Tools 4.3.1



/**
 * EstcontenudansId generated by hbm2java
 */
public class EstcontenudansId  implements java.io.Serializable {

    private int idCaisse;
    private int idContenu;

    public EstcontenudansId() {
    }

    public EstcontenudansId(int idCaisse, int idContenu) {
       this.idCaisse = idCaisse;
       this.idContenu = idContenu;
    }
   
    public int getIdCaisse() {
        return this.idCaisse;
    }
    
    public void setIdCaisse(int idCaisse) {
        this.idCaisse = idCaisse;
    }
    public int getIdContenu() {
        return this.idContenu;
    }
    
    public void setIdContenu(int idContenu) {
        this.idContenu = idContenu;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof EstcontenudansId) ) return false;
		 EstcontenudansId castOther = ( EstcontenudansId ) other; 
         
		 return (this.getIdCaisse()==castOther.getIdCaisse())
 && (this.getIdContenu()==castOther.getIdContenu());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdCaisse();
         result = 37 * result + this.getIdContenu();
         return result;
   }   
}

