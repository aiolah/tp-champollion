package champollion;

public class UE {
    private final String myIntitule;
    private int heuresCM;
    private int heuresTD;
    private int heuresTP;

    public UE(String intitule)
    {
        myIntitule = intitule;
        this.heuresCM = 0;
        this.heuresTD = 0;
        this.heuresTP = 0;
    }

    public void setHeuresCM(int heuresCM)
    {
        this.heuresCM = heuresCM;
    }

    public void setHeuresTD(int heuresTD)
    {
        this.heuresTD = heuresTD;
    }

    public void setHeuresTP(int heuresTP)
    {
        this.heuresTP = heuresTP;
    }

    public int getHeuresCM()
    {
        return heuresCM;
    }

    public int getHeuresTD()
    {
        return heuresTD;
    }

    public int getHeuresTP()
    {
        return heuresTP;
    }

    public String getIntitule() {
        return myIntitule;
    }

    public void addHeuresCM(int newHeuresCM)
    {
        this.heuresCM += newHeuresCM;
    }

    public void addHeuresTD(int newHeuresTD)
    {
        this.heuresTD += newHeuresTD;
    }

    public void addHeuresTP(int newHeuresTP)
    {
        this.heuresTP += newHeuresTP;
    }

    public int getDuree()
    {
        return this.heuresCM + this.heuresTD + this.heuresTP;
    }
}
