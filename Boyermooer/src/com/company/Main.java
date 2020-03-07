package com.company;

/*
 * To change this license header, choose License Heacolders in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
public class Main {

    public static int comp=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("______________________________________________________________________");
        System.out.println("Please enter the String");
        System.out.print("-> ");
        String str = sc.nextLine();
        System.out.println("______________________________________________________________________");
        System.out.println("Please enter the pattern you want to find in the string");
        System.out.print("-> ");
        String pattern = sc.nextLine();
        int[] Shiftval = new int[pattern.length()];
        char[] patt = pattern.toCharArray();
        char[] str1 = str.toCharArray();
        int ui = 0;
        for(int i =0;i<pattern.length();i++){
            Shiftval[i]=pattern.length()-i-1;

            if(Shiftval[i]==0){
                Shiftval[i]=pattern.length();
            }

        }
        for(int i = 0 ;i<pattern.length();i++){
            char pivot = patt[i];

            for(int k = i+1;k<pattern.length();k++){
                if(pivot==patt[k]){
                    Shiftval[i]=999;

                }
            }


        }
        System.out.println("______________________________________________________________________");
        System.out.println("Shift Table for the pattern : " +pattern);
        System.out.println("______________________________________________________________________");
        for(int l = 0;l<pattern.length();l++){
            if(Shiftval[l]==999){
                System.out.println("|" + patt[l] + "   ->   "  +Shiftval[l] + "    |");
            }else
                System.out.println("|" + patt[l] + "   ->   "  +Shiftval[l] + "      |");
        }

        System.out.println("______________________________________________________________________");


        int i=pattern.length()-1,j=pattern.length()-1,count=0,k=pattern.length()-1,zx=i ;
        ArrayList<Integer> al=new ArrayList<Integer>();
        while(i<str.length())
        {
                if(i==zx) {
                    System.out.println(str);

                    for (int x = 0; x < i - pattern.length() + 1; x++) {
                        System.out.print(" ");
                    }
                    for (int x = i - pattern.length() + 1; x <= i; x++) {
                        System.out.print("|");
                    }
                    System.out.println(" ");

                    for (int x = 0; x < i - pattern.length() + 1; x++) {
                        System.out.print(" ");
                    }

                    System.out.print(pattern);

                    System.out.println(" ");
                }
            if(str.charAt(i)==pattern.charAt(j))
            {
                comp++;
                if(j==0)
                {
                    count++;
                    j=pattern.length()-1;
                    k=k+pattern.length();
                    al.add(i+1);
                    i=k;
                    zx=i;

                }
                else
                {
                    i--;
                    j--;
                }

            }
            else
            {
                comp++;
                int l,temp=0;
                for(l=pattern.length()-1;l>=0;l--)
                {

                    if(pattern.charAt(l)==str.charAt(i))
                    {
                        temp=1;
                        break;
                    }
                }
                if(temp==1)
                {
                    k=k+Shiftval[l];
                    i=k;
                    zx=i;
                    j=pattern.length()-1;
                }
                else
                {
                    k=k+pattern.length();
                    i=k;
                    zx=i;
                    j=pattern.length()-1;
                }
            }


        }
        if(al.size()==0)
        {
            System.out.println("Pattern not found!!!!!");


        }
        else {
            System.out.println("Pattern is found at location: ");


            System.out.print(al);
            System.out.println(" ");

            int u = 0;
        }

        System.out.println("Total num of times pattern occuring in the string is :  "+count);

        System.out.println("______________________________________________________________________");
        System.out.println("Total no. of comparison: "+comp);

    }

}