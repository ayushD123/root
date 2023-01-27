package tcp;

import java.net.*;
import java.io.*;
public class tcpClient {
public static void main(String[] args)
{
try
{
	Socket client = new Socket("", 9999); //any 4 digit no as port
	BufferedReader k = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter file location:");
	String filename = k.readLine();
	DataOutputStream sendToServer = new DataOutputStream(client.getOutputStream());
	sendToServer.writeBytes(filename+"\n");
	BufferedReader i = new BufferedReader(new InputStreamReader(client.getInputStream()));
	String string ;
	while((string=i.readLine())!=null)
	System.out.println(string);
}
	catch(Exception ex) {}
	}
}
