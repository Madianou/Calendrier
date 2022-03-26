package modele;
import java.util.Calendar;

public class DateCalendrier extends Date
        implements Comparable <Date>, ConstantesCalendrier{
    private int chJourSemaine;

    public DateCalendrier(){
    Calendar today = Calendar.getInstance();
    chAnnee = today.get(Calendar.YEAR);
    chMois = today.get(Calendar.MONTH)+1;
    chJour = today.get(Calendar.DAY_OF_MONTH);
    chJourSemaine = today.get(Calendar.DAY_OF_WEEK);
    if (chJourSemaine == 1) 
        chJourSemaine = 7;
    else chJourSemaine -= 1;
    }

    public DateCalendrier(int parJour, int parMois, int parAnnee){
        super(parJour,parMois,parAnnee); // appel du super constructeur

        Calendar cal = Calendar.getInstance();
        cal.set(chAnnee,chMois-1,chJour);
        chJourSemaine = cal.get(Calendar.DAY_OF_WEEK);
        if (chJourSemaine == 1) 
            chJourSemaine = 7;
        else chJourSemaine -= 1;
    }

    public DateCalendrier(Date parDate){
        Calendar cal = Calendar.getInstance();
        cal.set(parDate.chAnnee,parDate.chMois-1,parDate.chJour);
        chJourSemaine = cal.get(Calendar.DAY_OF_WEEK);
        if (chJourSemaine == 1) 
            chJourSemaine = 7;
        else chJourSemaine -= 1;
    }

    public int getJourSemaine(){
        return chJourSemaine;
    }

    public int getJour(){ return chJour; }

    public int getMois(){ return chMois;}

    public Integer getNumeroSemaine(Date parDate){
        Calendar cal = Calendar.getInstance();
        cal.set(chAnnee,chMois-1,chJour);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }


    public DateCalendrier dateDuLendemain(){
        Date nvDate = new Date(chJour,chMois,chAnnee);
        nvDate = nvDate.dateDuLendemain();
        return new DateCalendrier(nvDate.chJour,nvDate.chMois,nvDate.chAnnee);
    }

    public DateCalendrier dateDeLaVeille(){
        Date nvDate = new Date(chJour,chMois,chAnnee);
        nvDate = nvDate.dateDeLaVeille();
        return new DateCalendrier(nvDate.chJour,nvDate.chMois,nvDate.chAnnee);

    }

    public String toString(){
        return JOURS_SEMAINE[chJourSemaine-1] + " " + chJour + " " + MOIS[chMois-1] + " " + chAnnee ;
    }

    public static String toStringTab(DateCalendrier [] parTab){
        String chaine = new String();
        chaine += "-------------------------------"+"\n";
        for (int i = 0 ; i < parTab.length ; i++){
            if (parTab[i]==null) break;
            int num = i + 1;
            chaine += num + " " + parTab[i].toString() + "\n" + "-------------------------------"+"\n";
        }
        return chaine;
    }
}