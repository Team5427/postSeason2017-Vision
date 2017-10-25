package com.Team5427.VisionProcessing;

import java.util.Scanner;

public class PackingClass {
	
	//Bellow is a list of which bytes mean what in the double word
	//First Byte:: OnTarget
	//SecondByte:: isRobotLeftOfTarget
	//ThirdByte:: isRobotRightOfTarget
	//
	
	public static void main(String[]args)
	{
		//Code to test bytesToDouble(b)
//		Scanner kb= new Scanner(System.in);
//		int x = 0;
//		byte[] b = new byte[10];
//		do
//		{
//		System.out.print("Enter the byte index: "+x);
//		b[x]=kb.nextByte();
//		x++;
//		}
//		while(x<10);
//		System.out.print("The double is:" + bytesToDouble(b));
		
		//Code to test doubleToBytes(d)
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the double you wish to convert: ");
		double d = kb.nextDouble();
		System.out.print("\n");
		byte[] b = doubleToBytes(d);
		System.out.print("The value in binary is ");
		for(int x = b.length-1; x>=0;x--)
		{
			System.out.print(b[x]);
		}
	}
	
	/**
	 * Method to convert a byte array of ones and zeros to a double
	 * @param buff, a byte array in binary backwards
	 * @return a double that the number stands for
	 */
	public static  double bytesToDouble(byte [] buff){
		Double d = new Double(0);
		for(int x=0; x<buff.length;x++)
		{
			d += buff[x]*Math.pow(2, x);
		}
		return d;
	}
	
	/**
	 * Method to convert double to a byte array of ones and zeros
	 * @param d, the double to convert
	 * @return a byte array of the binary value that the double represents, written in binary backwards
	 */
	public static byte[] doubleToBytes(double d)
	{
		int curExponent, maxExponent = 0;
		double temp=d;
		while(Math.pow(2,maxExponent)<=d)
		{
			maxExponent++;
		}
		if(Math.pow(2, maxExponent)!=d)
			maxExponent--;
		curExponent=maxExponent;
		byte[]b=new byte[curExponent+1];
		for(int x=b.length-1;x>=0;x--){
			if((temp-Math.pow(2,curExponent))>=0)
			{
				temp-=Math.pow(2,curExponent);
				b[x]=1;
				
			}
			else
				b[x]=0;
			curExponent--;
		}
		return b;
	}
}
