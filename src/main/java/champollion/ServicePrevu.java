package champollion;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ServicePrevu
{
	// TODO : implémenter cette classe
    private ArrayList<UE> listUE;
    private int volumeCM;
    private int volumeTD;
    private int volumeTP;

    public ServicePrevu()
    {
        this.volumeCM = 0;
        this.volumeTD = 0;
        this.volumeTP = 0;
        this.listUE = new ArrayList<>();
    }

    public ServicePrevu(int volumeCM, int volumeTD, int volumeTP)
    {
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;
    }

    public int getVolumeCM()
    {
        return volumeCM;
    }

    public int getVolumeTD()
    {
        return volumeTD;
    }

    public int getVolumeTP()
    {
        return volumeTP;
    }

    public void addUE(UE ue)
    {
        this.listUE.add(ue);
    }

    public void addHeuresTD(int heuresTD)
    {
        this.volumeTD += heuresTD;
    }

    public UE getUE(UE theUE)
    {
        for(UE ue: this.listUE)
        {
            if(ue.getIntitule().equals(theUE.getIntitule()))
            {
                return ue;
            }
        }

        return null;
    }

    public int getDuree()
    {
        int duree = 0;

        for(UE ue: this.listUE)
        {
            duree += ue.getDuree();
        }

        return duree;
    }
}
