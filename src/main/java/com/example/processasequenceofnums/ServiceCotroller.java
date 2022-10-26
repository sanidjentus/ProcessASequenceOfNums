package com.example.processasequenceofnums;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

@RestController
public class ServiceCotroller {
    //ммаксвимальное число
    @RequestMapping("/max_value")
    public int maxValue(){
        try (FileInputStream fin = new FileInputStream("C:/test_data/10mm.txt")) {
            int i = -1;
            int max = Integer.MAX_VALUE;
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer, 0, buffer.length);
            while ((i = fin.read()) != -1) {
                if (fin.read() < max) {
                    max = fin.read();
                }
            }
            return max;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }

    //минимальное число
    @RequestMapping("/min_value")
    public int minValue(){
        try (FileInputStream fin = new FileInputStream("C:/test_data/10mm.txt")) {
            int i = -1;
            int min = Integer.MIN_VALUE;
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer, 0, buffer.length);
            while ((i = fin.read()) != -1) {
                if (fin.read() > min) {
                    min = fin.read();
                }
            }
            return min;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }

    //медиана
    @RequestMapping("/median")
    public double median() {
        try (FileInputStream fin = new FileInputStream("C:/test_data/10mm.txt")) {
            int i = -1;
            double median = 0;
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer, 0, buffer.length);
            while ((i = fin.read()) != -1) {
                if (buffer.length % 2 == 0)
                    median = ((double) buffer[buffer.length / 2] + (double) buffer[buffer.length / 2 - 1]) / 2;
                else
                    median = (double) buffer[buffer.length / 2];
            }
            return median;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return -1.0;
    }

    //среднее арифметическое
    @RequestMapping("/average")
    public double average(){
        try (FileInputStream fin = new FileInputStream("C:/test_data/10mm.txt")) {
            int i = -1;
            double average = 0;
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer, 0, buffer.length);
            while ((i = fin.read()) != -1) {
                if (buffer.length > 0)
                {
                    double sum = 0;
                    for (int j = 0; j < buffer.length; j++) {
                        sum += buffer[j];
                    }
                    average = sum / buffer.length;
                }
            }
            return average;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return -1.0;
    }

    //самая длинная уыеличивающаяся последовательность
    @RequestMapping("/increasing_sequence")
    public byte increasingSequence(){
        try (FileInputStream fin = new FileInputStream("C:/test_data/10mm.txt")) {
            int j = -1;
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer, 0, buffer.length);
            while ((j = fin.read()) != -1) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                ArrayList<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(reader.readLine()));
                byte inARow = 1;
                byte saveResult = 1;
                for (int i = 1; i < 10; i++) {
                    list.add(Integer.parseInt(reader.readLine()));
                    if (list.get(i).equals(list.get(i - 1)))
                        inARow++;
                    else {
                        if (inARow >= saveResult) {
                            saveResult = inARow;
                            inARow = 1;
                        }
                    }
                }
                if (saveResult > inARow)
                    return saveResult;
                else
                    return inARow;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }


    //самая длинная уменьшающаяся последовательность
    @RequestMapping("/decreasing_sequence")
    public byte decreasingSequence(){
        try (FileInputStream fin = new FileInputStream("C:/test_data/10mm.txt")) {
            int j = -1;
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer, 0, buffer.length);
            while ((j = fin.read()) != -1) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                ArrayList<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(reader.readLine()));
                byte inARow = 1;
                byte saveResult = 1;
                for (int i = 1; i < 10; i++) {
                    list.add(Integer.parseInt(reader.readLine()));
                    if (list.get(i).equals(list.get(i + 1)))
                        inARow++;
                    else {
                        if (inARow >= saveResult) {
                            saveResult = inARow;
                            inARow = 1;
                        }
                    }
                }
                if (saveResult > inARow)
                    return saveResult;
                else
                    return inARow;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }
}


