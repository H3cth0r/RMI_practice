package rmiPackage;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class LotteryResultsClient
{
    public static void main(String args[])
    {
        try
        {
            String name = "rmi://localhost:1099/LotteryResultsInterface";
            LotteryResultsInterface lotteryResults = (LotteryResultsInterface) Naming.lookup(name);

            String prices[] = {"TV Color", "Ordenador", "Viaje", "Home Cinema", "Juego de Toallas"};
            Integer numbers[] = {1000, 2300, 321, 847, 626};



            for(int i = 0; i < 5; i++)
            {
                TimeUnit.SECONDS.sleep(2);
                lotteryResults.set_number(i, numbers[i]);
                lotteryResults.set_prize(i, prices[i]);
                System.out.println("Index 0 winner: " + lotteryResults.get_number(i));
                System.out.println("Index 0 prize: " + lotteryResults.get_prize(i));
            }

        }
        catch (NotBoundException | MalformedURLException | RemoteException | InterruptedException e)
        {
            System.out.println("Lottery Results exception " + e);
            e.printStackTrace();
        }
    }
}
