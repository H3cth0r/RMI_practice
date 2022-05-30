# Simple RMI project
This is a simple RMI application, where there is a Server and a Client. The Client will
make some changes to the classes attributes, by accessing by some of the classes Methods.
Both the server and the client are able to make the same process. In this case, the problem is about some price, where the  client will set the winner numbers and the 
prices for each number; the client will set this valis and the server will present the
recived data from the client.

## Compiling
For compiling this project, we have installed the Java 17 SDK, so I recomment using this verssion. For compiling, you must get to the rmiPackage directory and then type the following:

```
javac *.java
```

A bunch of java classes will be created.

## Running
For running the project, you must must go back one directory before the rmiPackage. Then
you'll be able to run each class. First of all, you must firstly run the Server, so,  you
must type the following:
```
java rmiPackage.LotteryResultsServer
```

Then you must run the Client, by typing the following:

```
java rmiPackage.LotteryResultsClient
```

Then the program should work as follows:
