package FifthSem;
import java.util.*;
import java.math.*;
import java.security.*;
import java.io.*;

public class RSAnew {
	static BigInteger p,q,n,phi,e,d;
	static int bitLength=1024;
	static Random secureRandom;
	
//	public RSAnew() {
//		
//		
//	}
	
	static String byteToString(byte[] msg) {
		String temp="";
		for(byte b:msg) {
			temp+=Byte.toString(b);
		}
		return temp;
	}
	static byte[] encrypt(byte[] msg) {
		return (new BigInteger(msg)).modPow(e, n).toByteArray();
	}
	static byte[] decrypt(byte[] msg) {
		return (new BigInteger(msg)).modPow(d, n).toByteArray();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
		 secureRandom = new Random();
		 p = BigInteger.probablePrime(bitLength, secureRandom);
		 q = BigInteger.probablePrime(bitLength, secureRandom);
		 n = p.multiply(q);
		 phi =
		p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		 e = BigInteger.probablePrime(bitLength / 2, secureRandom);
		 while (e.gcd(phi).compareTo(BigInteger.ONE) != 0
		&&e.compareTo(phi) < 0) {
		 e = e.add(BigInteger.ONE);
		 }
		 d = e.modInverse(phi);
		 Scanner sc=new Scanner(System.in);
		String msg;
		System.out.println("Enter Msg");
		msg=sc.nextLine();
		System.out.println("String in bytes " + byteToString(msg.getBytes()));
		byte[] encryptmsg=encrypt(msg.getBytes());
		byte[] dercypt=decrypt(encryptmsg);
		System.out.println("decrypted bytes "+byteToString(dercypt));
		System.out.println("decrypted string "+new String(dercypt));
	}

}
