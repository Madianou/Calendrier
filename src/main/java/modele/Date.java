package modele;

public class Date{
    protected int chJour;
    protected int chMois;
    protected int chAnnee;


    public Date (int parJour,int parMois,int parAnnee){
        chJour = parJour;
        chMois = parMois;
        chAnnee = parAnnee;
    }

    public Date(int parAnnee){
        chJour = 1;
        chMois = 1;
        chAnnee = parAnnee;
    }

    public Date(){

    }

    public static boolean estBissextile(int parAnnee){
        return parAnnee%400==0 || (parAnnee%4==0 && parAnnee%100!=0);
    }

    public static int dernierJourDuMois(int parMois,int parAnnee){
        switch (parMois){
            case 2: if (Date.estBissextile(parAnnee))
                        return 29;
                    return 28;
            case 4:case 6:case 9:case 11: return 30;
            default: return 31;
        }
    }

    public boolean estValide(){
        return chAnnee>1582 &&
               chMois>=1 && chMois<=12 &&
               chJour>=1 &&
               chJour<=Date.dernierJourDuMois(chMois,chAnnee);
    }
    
    public static Date lireDate(){
        System.out.println("Entrez le jour :");
        int jour = Clavier.lireInt();
        System.out.println("Entrez le mois :");
        int mois = Clavier.lireInt();
        System.out.println("Entrez l'année :");
        int annee = Clavier.lireInt();
        return new Date(jour,mois,annee);
    }

    public Date dateDuLendemain(){
        if (chJour == Date.dernierJourDuMois(chMois,chAnnee)){
            if (chMois+1 == 13) return new Date(1,1,chAnnee+1);
            return new Date(1,chMois+1,chAnnee);
        }
        return new Date(chJour+1,chMois,chAnnee);
    }

    public Date dateDeLaVeille(){
        if (chJour == 1){
            if (chMois == 1) return new Date(31,12,chAnnee-1);
            return new Date(Date.dernierJourDuMois(chMois-1,chAnnee),chMois-1,chAnnee);
        }
        return new Date(chJour-1,chMois,chAnnee);
    }

    public  int compareTo(Date parDate){
        if (chAnnee < parDate.chAnnee) return -1;
        if (chAnnee > parDate.chAnnee) return 1;
        // Si les années sont égales :
        if (chMois < parDate.chMois) return -1;
        if (chMois > parDate.chMois) return 1;
        // si les mois sont égaux:
        if (chJour < parDate.chJour) return -1;
        if (chJour > parDate.chJour) return 1;
        return 0;
        
    }

    
    public String toString(){
        return chJour+"/"+chMois+"/"+chAnnee;
    }
}