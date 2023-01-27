package tcp;

import java.net.*;
import java.io.*;
public class tcpServer {
public static void main(String[] args)
{
try
{
ServerSocket se = new ServerSocket(9999);
System.out.println("Server waiting");
Socket server = se.accept();
BufferedReader k = new BufferedReader (new InputStreamReader(server.getInputStream()));
String filename = k.readLine();
FileReader f = new FileReader(filename);
BufferedReader ff = new BufferedReader(f);
DataOutputStream sendToClient = new DataOutputStream(server.getOutputStream());
String string;
while((string = ff.readLine())!=null)
sendToClient.writeBytes(string+"\n");
}
catch(Exception ex) {}
}
}
