package champollion;

import java.util.ArrayList;

/**
 * Un enseignant est caractérisé par les informations suivantes : son nom, son adresse email, et son service prévu,
 * et son emploi du temps.
 */
public class Enseignant extends Personne {

    private ServicePrevu servicePrevu;
    private ArrayList<Intervention> listeInterventions;

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML

    public Enseignant(String nom, String email)
    {
        super(nom, email);

        this.servicePrevu = new ServicePrevu();
        this.listeInterventions = new ArrayList<Intervention>();
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        // TODO: Implémenter cette méthode
        // throw new UnsupportedOperationException("Pas encore implémenté");

        double nbTotalHeuresCM = this.servicePrevu.getVolumeCM() * 1.5;
        double nbTotalHeuresTD = this.servicePrevu.getVolumeTD();
        double nbTotalHeuresTP = this.servicePrevu.getVolumeTP() * 0.75;

        double result = nbTotalHeuresCM + nbTotalHeuresTD + nbTotalHeuresTP;
        return (int) Math.round(result);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        // TODO: Implémenter cette méthode
        // throw new UnsupportedOperationException("Pas encore implémenté");
        double nbTotalHeuresCM = this.servicePrevu.getUE(ue).getHeuresCM() * 1.5;
        double nbTotalHeuresTD = this.servicePrevu.getUE(ue).getHeuresTD();
        double nbTotalHeuresTP = this.servicePrevu.getUE(ue).getHeuresTP() * 0.75;

        double result = nbTotalHeuresCM + nbTotalHeuresTD + nbTotalHeuresTP;
        return (int) Math.round(result);
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magistral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        // TODO: Implémenter cette méthode
        // throw new UnsupportedOperationException("Pas encore implémenté");
        UE previousUE = this.servicePrevu.getUE(ue);
        if(previousUE != null)
        {
            previousUE.addHeuresCM(volumeCM);
            previousUE.addHeuresTD(volumeTD);
            previousUE.addHeuresTP(volumeTP);

            this.servicePrevu.addHeuresTD(volumeTD);
        }
        else
        {
            ue.setHeuresCM(volumeCM);
            ue.setHeuresTD(volumeTD);
            ue.setHeuresTP(volumeTP);

            this.servicePrevu.addUE(ue);
            this.servicePrevu.addHeuresTD(volumeTD);
        }
    }

    public void addIntervention(Intervention intervention) throws IllegalStateException
    {
        if(intervention.getTypeIntervention().equals(TypeIntervention.TD))
        {
            UE ue = intervention.getUE();
            int heuresTDUEPrevues = ue.getHeuresTD();
            int heuresTDUEPlanifiees = heuresTDUEPrevues + intervention.getDuree();

            int heuresPlanifieesPourUE = ue.getDuree() + intervention.getDuree();
            int heuresPrevuesPourUE = this.heuresPrevuesPourUE(ue);

            int heuresServicePlanifie = this.servicePrevu.getDuree() + intervention.getDuree();
            int heuresServicePrevu = this.servicePrevu.getDuree();

            System.out.println("Heures TD UE planifiées : " + heuresTDUEPlanifiees);
            System.out.println("Heures TD UE prévues : " + heuresTDUEPrevues);

            // Si le volume d'heures de TD planifiées pour l'UE est supérieur à la durée potentielle totale de l'UE en TD
            if(heuresTDUEPlanifiees > heuresTDUEPrevues || heuresPlanifieesPourUE > heuresPrevuesPourUE || heuresServicePlanifie > heuresServicePrevu)
            {
                throw new IllegalStateException();
            }
        }

        this.listeInterventions.add(intervention);
    }
}
