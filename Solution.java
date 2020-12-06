package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        FileInputStream inStream = null;
        InputStreamReader inputSrteam = null;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  // считываю имя файла
            String nameFile = reader.readLine();
            reader.close();
            // (ниже) считываю данные из файла, по кодировке UTF-8 - чтобы руские буквы читались нормально
            BufferedReader readerFile = new BufferedReader(new InputStreamReader(new FileInputStream(nameFile), "UTF-8"));

            ArrayList<Integer> chisla = new ArrayList<>();
            String line;
            while ((line = readerFile.readLine()) != null) {
                int number = Integer.parseInt(line);
                if (number % 2 ==0)  // если число четное оно записывается в ArrayList
                    chisla.add(number);
            }
            readerFile.close();

            Collections.sort(chisla);  // метод для сортировки ArrayList

            for (int out : chisla) {
                System.out.println(out);
            }

        } catch (IOException e) {
            e.printStackTrace();
            // это вместо проброски Exception, можно в начале в строке public static void main написать throws Exception
        }


    }
}
