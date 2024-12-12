package champollion;

public class Intervention
{
    private String date;
    private int duree;
    private boolean annulee;
    private int heureDebut;
    private UE ue;
    private TypeIntervention typeIntervention;

    public Intervention(String date, int duree, boolean annulee, int heureDebut, UE ue, TypeIntervention typeIntervention)
    {
        this.date = date;
        this.duree = duree;
        this.annulee = annulee;
        this.heureDebut = heureDebut;
        this.ue = ue;
        this.typeIntervention = typeIntervention;
    }

    public UE getUE()
    {
        return this.ue;
    }

    public TypeIntervention getTypeIntervention()
    {
        return this.typeIntervention;
    }

    public int getDuree()
    {
        return this.duree;
    }
}
