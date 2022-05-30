package rmiPackage;

import java.rmi.*;
public interface LotteryResultsInterface extends Remote {
    public void set_number(Integer index, Integer val) throws RemoteException;
    public void set_prize(Integer index, String val) throws RemoteException;
    public Integer get_number(Integer index) throws RemoteException;
    public String get_prize(Integer index) throws RemoteException;
}
