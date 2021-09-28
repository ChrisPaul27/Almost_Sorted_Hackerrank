package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input21.txt"));
        int n = Integer.parseInt(in.nextLine());
        List <Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(in.next()));
        }
        almostSorted(arr);
    }

    public static void almostSorted(List<Integer> arr) {
        if (isSorted(arr)) {
            System.out.println("yes");
        } else {
            int i, swap1 = -1, swap2 = -1;
            for (i = 0; i < arr.size() - 1; i++) {
                if (arr.get(i) > arr.get(i+1)) {
                    if (swap1 == -1) {
                        swap1 = i;
                    } else {
                        swap2 = i + 1;
                    }
                }
            }

            if (swap2 == -1) {
                swap2 = swap1 + 1;
            }

            swap(arr, swap1, swap2);

            if (isSorted(arr)) {
                System.out.println("yes\nswap "+ (swap1 + 1) + " "+(swap2 + 1));
                return;
            }

            swap(arr, swap2, swap1);
            Collections.reverse(arr.subList(swap1, swap2+1));
            if (isSorted(arr)) {
                System.out.println("yes\nreverse "+ (swap1 + 1) + " "+(swap2 + 1));
                return;
            }
        }
        System.out.println("no");
    }


    public static boolean isSorted(List <Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i-1) > arr.get(i)) {
                return false;
            }
        }
        return true;
    }


    public static void swap(List<Integer> arr, int swap1, int swap2) {
        int tmp = arr.get(swap1);
        arr.set(swap1, arr.get(swap2));
        arr.set(swap2, tmp);
    }
}
