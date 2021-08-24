package com.company;
import java.util.Arrays;

public class z2 {


    public static void main(String[] args) {
        int counter=0; //счетчик максимального повтора числа
        int numMod=0; //результирующая мода числового ряда
        int bufModNum; //промежуточная мода
        int counterBuff; //счетчик  повтора числа
        int ar[]={10,20,50,150,30,150,20,20,150};


        Arrays.sort(ar);// вызов встроенного метода сортировки по возрастанию

        for (int i=0;i<ar.length;i++){
            bufModNum=ar[i];
            counterBuff = 1;
            try {
                while (ar[i] == ar[i + 1]) {
                    counterBuff++;
                    i++;
                }
                if ((counterBuff >= counter) && (numMod < bufModNum)) {
                    counter = counterBuff;
                    numMod = bufModNum;
                }
           }
            catch (ArrayIndexOutOfBoundsException e){ //для случая если модой будет являться наибольшее число в ряду
                if ((counterBuff >= counter) && (numMod < bufModNum)) {
                    counter = counterBuff;
                    numMod = bufModNum;
                }
            }
        }
        System.out.println(numMod);
    }
}


