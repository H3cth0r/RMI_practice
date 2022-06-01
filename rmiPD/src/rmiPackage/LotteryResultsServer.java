package rmiPackage;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class LotteryResultsServer
{
    public static void main(String[] args)
    {
        try
        {
            LocateRegistry.createRegistry(1099);
            String name = "rmi://localhost:1099/LotteryResultsInterface";
            try
            {
                LotteryResults lotteryResultsInterface = new LotteryResults(1099);
                Naming.rebind(name, lotteryResultsInterface);
                Integer num = lotteryResultsInterface.get_number(0);
                String prize = lotteryResultsInterface.get_prize(0);

                Integer numeros[] = {111, 111, 111, 111, 111};
                String premios[] = {"none", "none", "none", "none", "none"};

                while(true) {
                    for(int i = 0; i < 5; i++) {
                        Integer new_num = lotteryResultsInterface.get_number(i);
                        String new_price = lotteryResultsInterface.get_prize(i);
                        System.out.print("");
                        if (!numeros[i].equals(new_num)) {
                            System.out.println("changed number index " + i +" : " + new_num);
                            numeros[i] = new_num;
                        }
                        if (!premios[i].equals(new_price)) {
                            System.out.println("changed price index" + i + " : " + new_price);
                            premios[i] = new_price;
                        }
                    }
                }
            } catch (RemoteException | MalformedURLException e)
            {
                System.err.println("ComputeEngine exception: " +  e.getMessage());
                e.printStackTrace();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
