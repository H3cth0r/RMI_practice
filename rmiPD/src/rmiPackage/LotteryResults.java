package rmiPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.rmi.*;
import java.rmi.server.*;

public class LotteryResults extends UnicastRemoteObject implements rmiPackage.LotteryResultsInterface
{

    public List<Integer>   list_numbers        = new ArrayList<>(Arrays.asList(111, 111, 111, 111, 111));
    public List<String>    list_prizes         = new ArrayList<>(Arrays.asList("none", "none", "none", "none", "none"));

    public LotteryResults(List<Integer> num_val, List<String> str_val) throws RemoteException{
        list_numbers = num_val;
        list_prizes = str_val;
    }
    public LotteryResults(int port) throws RemoteException
    {
        super(port);
        System.out.println("created");
    }
    public void set_number(Integer index, Integer val) throws RemoteException{
        list_numbers.add(index, val);
    }
    public void set_prize(Integer index, String val) throws RemoteException{
        list_prizes.add(index, val);
    }
    public Integer get_number(Integer index) throws RemoteException{
        return list_numbers.get(index);
    }
    public String get_prize(Integer index) throws RemoteException{
        return list_prizes.get(index);
    }
    /*
    public static void main(String [] args) throws RemoteException {
        LotteryResults lr = new LotteryResults();
        //lr.set_number(0, 23);
        lr.set_prize(0, "lol");
        System.out.println(lr.get_prize(0));
    }
     */
}
