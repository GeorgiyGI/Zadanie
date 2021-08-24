package com.company;

// Задание 3

import java.util.Arrays;

public class Main {
    public static int summa(int [][] array,int i,int j){ //метод подсчитывающий и возвращающий сумму в диагонали
        int sum=0;
        while (j>=0){
            try{
                sum=sum+array[i][j];
                i++;
                j--;
            }
            catch (ArrayIndexOutOfBoundsException e){
                return sum;
            }
        }
        return sum;
    }

    public static int[] posled(int [][] array, int i, int j, int []diag){ //метод считывающий и возвращающий массив эл-тов диагонали

        int a=0;
        while (j>=0){
            try{
                diag[a]=array[i][j];
                j--;
                i++;
                a++;
            }
            catch (ArrayIndexOutOfBoundsException e){
                return diag;
            }
        }
        return diag;
    }





    public static void main(String[] args) {
	    int [][]ar={
	            {20,4,5},
                {6,3,9},
                {2,0,-1},
        };

	    int num= ar.length;
        int []diag; //промежуточный массив
        diag = new int[num];
        int []diagmin; //результирующий массив
        diagmin = new int[num];
	    int sumb,sum;
        int maxd=ar.length;//текущий размер результирующей диагонали




        sum=summa(ar,0,ar.length-1);
        diagmin=posled(ar,0,ar.length-1,diagmin);

        num--;



        //поиск через элементы первой строки
	    for (int j=ar.length-2,i=0;j>0;j--,num--){
            sumb=summa(ar,i,j);
            diag = posled(ar, i, j, diag);

           if (sumb<sum){
                maxd=num;
                diagmin= Arrays.copyOf(diag,maxd-1);// копирование эелементов промежуточного массива в результирующий
                sum=sumb;
            }
           else  {
                if ((sumb==sum)&&(maxd<num)){
                    diagmin= Arrays.copyOf(diag,maxd+1);//копирование эелементов промежуточного массива в результирующий
                    maxd=num;
                }
           }

        }



        num= ar.length-1;
        //поиск через элементы последнего столбца
        for (int i=1,j=ar.length-1;i<ar.length-1;i++,num--) {
            sumb = summa(ar, i, j);
            diag = posled(ar, i, j, diag);

            if (sumb < sum) {
                maxd = num;
                diagmin = Arrays.copyOf(diag, maxd+1);// копирование эелементов промежуточного массива в результирующий
                sum = sumb;
            } else {
                if ((sumb == sum) && (maxd < num)) {
                    diagmin = Arrays.copyOf(diag, maxd+1);// копирование эелементов промежуточного массива в результирующий
                    maxd = num;
                }
            }
        }

        for (int i=0;i<maxd;i++){
            System.out.print(diagmin[i]+" ");
        }
    }
}
