package com.company;

public class z1 {


        public static void main(String[] args) {
            String s="AabbBaaaa";
            char buf; //Переменная, хранящая текущий символ
            StringBuffer sb = new StringBuffer(); // Объект, в который сохраняем элементы для вывода
            int counter=0; //счетчик повторяющийся элементов
/*
Далее реализован цикл в котором производится посимвольная считка элементов, сравнение текущего элемента с последующим и запись данных в результирующий объект.
*/
            for (int i=0;i<s.length();i++){
                counter++;
                buf = s.charAt(i); //считывание символа
                if (s.regionMatches(i, s, i+1, 1)==false){
                    if(counter==1)sb.append(buf);
                    else {
                        sb.append(counter)
                                .append(buf);
                    }
                    counter=0;
                }
            }
            System.out.println(sb); // вывод результата в консоль
        }
}


