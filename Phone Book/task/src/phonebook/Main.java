package phonebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.HashMap;

public class Main {

    Integer[] fromNumArray;
    String[] fromNameArray;
    public Main(){


    }
    /*public int compareStrings(String word1, String word2){

        for(int i = 0; i < Math.min(word1.length(),word2.length()); i++){
            if((int)word1.charAt(i) != (int)word2.charAt(i)){ // compare unicode values
               return  (int)word1.charAt(i) - (int)word2.charAt(i);
            }
            if(word1.length() != word2.length()){ // smaller wor is occurs at the beginning od the larger word
                return word1.length() - word2.length();
            }else {
                return 0;
            }

        }
        return ;
    }*/
    public void bubbleSort(Integer[] numbers, String[] names, long startTime){
        String tempName;
        int tempNumber;
        long bubbleEnd ;
        long bubbleTime;
        long[] timePassedBubble ;
        for(int i = 0; i < names.length -1; i++){
            for(int j = 0; j < names.length -1; j++){
                if(names[i].compareTo(names[j])>0) {
                    tempName = names[i];
                    names[i] = names[j];
                    names[j] = tempName;

                    tempNumber = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tempNumber;

                }
            }
            bubbleEnd = System.currentTimeMillis();
            bubbleTime = bubbleEnd - startTime;
            timePassedBubble = time(bubbleTime);
            if(timePassedBubble[0] >= 10){
                break;
            }
        }
        this.fromNumArray = numbers;
        this.fromNameArray = names;

    }
    public void start(){
        long start = System.currentTimeMillis();
        System.out.println("Start searching (linear search)...");

        File fromSmall = new File("C:\\Users\\ME\\Desktop\\Java Reading Files\\directory.txt");
        int fromNum ;
        String fromName ;
        int countFrom = 0;
        ArrayList<String> fromThis = new ArrayList<>();
        ArrayList<Integer> fromThisNum = new ArrayList<>();
        ArrayList<String> searchFor = new ArrayList<>();
        HashMap<String, Integer> hashMapFrom = new HashMap<>();

        File findSmall = new File("C:\\Users\\ME\\Desktop\\Java Reading Files//find.txt");
        String findName ;
        int countFound = 0;
        int searchAmount = 0;
        long hashStartCreate;
        long hashEndCreate;
        try(Scanner scFind = new Scanner(findSmall) ){
            try(Scanner scFrom = new Scanner (fromSmall)) {
                 while (scFrom.hasNext()) {

                        fromNum = Integer.parseInt(scFrom.next());
                        fromName = scFrom.nextLine().trim();
                        fromThis.add(fromName);
                        fromThisNum.add(fromNum);
                        countFrom++;
                 }
                 Integer[] fromNumArray = new Integer[fromThisNum.size()];
                 fromNumArray = fromThisNum.toArray(fromNumArray);
                 String[] fromNameArray = new String[fromThis.size()];
                 fromNameArray = fromThis.toArray(fromNameArray);

                int aaa = 0;
                hashStartCreate = System.currentTimeMillis();
                while( aaa < fromNameArray.length && aaa < fromNumArray.length){
                    hashMapFrom.put(fromNameArray[aaa], fromNumArray[aaa]);
                       aaa++;
                }
                hashEndCreate = System.currentTimeMillis();

                String[] QuickfromNameArray = new String[fromThis.size()];
                QuickfromNameArray = fromThis.toArray(QuickfromNameArray);

                while (scFind.hasNext()) {
                    findName = scFind.nextLine().trim();
                    searchFor.add(findName);
                    for(String ele: fromThis){
                        if (ele.contains(findName)){
                            countFound++;
                            break;
                        }
                    }
                    searchAmount++;
                }
                long end = System.currentTimeMillis();
                long timeElapsed = end - start;
                long[] timePassedL = time(timeElapsed);
                printTimeStamps(countFound,searchAmount,timePassedL[0], timePassedL[1],timePassedL[2], 0,0,0, -1, -1,-1, "linear");

                System.out.println("Start searching (bubble sort + jump search)...");
                long bubbleStart = System.currentTimeMillis();
                bubbleSort(fromNumArray,fromNameArray, bubbleStart);
                long bubbleEnd = System.currentTimeMillis();
                long bubbleTime = bubbleEnd - bubbleStart;
                long[] timePassedBubble = time(bubbleTime);
                int jumpcount = 0;
                int f =0;

                int found = 0;
                if(timePassedBubble[0]>=10){
                    start = System.currentTimeMillis();
                    for(String find: searchFor) {
                        for (String compareto : fromNameArray) {
                            if (find.equals(compareto)){
                                found++;
                            }
                        }
                    }
                    end = System.currentTimeMillis();
                    timeElapsed = end - start;
                    long[] timePassedLinear = time(timeElapsed);
                    printTimeStamps(found,searchAmount,0,0,0,timePassedBubble[0], timePassedBubble[1],timePassedBubble[2], timePassedLinear[0],timePassedLinear[1],timePassedLinear[2], "bubblejump");
                    System.out.println();
                }
                else{
                    start = System.currentTimeMillis();
                    for(String find: searchFor) {
                        if(jumpSearchForward(fromNameArray, find)){
                            jumpcount++;
                            continue;
                        }else {
//                            System.out.println(find);
//                            f++;
                        }
                    }
//                    System.out.println("Jump Search found: "+jumpcount);
//                    System.out.println(f);
                    end = System.currentTimeMillis();
                    timeElapsed = end - start;
                    long[] timePassedLinear = time(timeElapsed);
                    printTimeStamps(jumpcount,searchAmount,0,0,0,timePassedBubble[0], timePassedBubble[1],timePassedBubble[2], timePassedLinear[0],timePassedLinear[01],timePassedLinear[02],"linear" );
                    System.out.println();
                }
                System.out.println("Start searching (quick sort + binary search)...");
                long quickStart = System.currentTimeMillis();
                quickSort(QuickfromNameArray, 0, QuickfromNameArray.length -1 );
                long quickEnd = System.currentTimeMillis();
                long quickTime = quickEnd - quickStart;
                long[] timePassedQuick = time(quickTime);
//                printArrayString(QuickfromNameArray, QuickfromNameArray.length -1);
                long binaryStart = System.currentTimeMillis();
                int binaryFound = 0;
                for(String find: searchFor) {
                    if (binarySearch(QuickfromNameArray, find) > 0){
                        binaryFound++;
                    }
                }
                long binaryEnd = System.currentTimeMillis();
                long binaryTime = binaryEnd - binaryStart;
                long[] timePassedBinary = time(binaryTime);
                printTimeStamps(binaryFound,searchAmount,0,0,0,timePassedQuick[0], timePassedQuick[1],timePassedQuick[2], timePassedBinary[0],timePassedBinary[1],timePassedBinary[2], "quickbinary" );
                System.out.println();
                System.out.println("Start searching (hash table)...");
                long hashCreateTime = hashEndCreate - hashStartCreate;
                long[] timePassedHashCreate = time(hashCreateTime);

                long hashStartSearch = System.currentTimeMillis();
                int hashFound = 0;
                for(String find: searchFor) {
                    if (hashMapFrom.containsKey(find)){
                        hashFound++;
                    }
                }
                long hashEndSearch = System.currentTimeMillis();
                long hashSearchTime = hashEndSearch - hashStartSearch;
                long[] timePassedhashSearchTime = time(hashSearchTime);
                printTimeStamps(hashFound,searchAmount,0,0,0,timePassedHashCreate[0], timePassedHashCreate[1],timePassedHashCreate[2], timePassedhashSearchTime[0],timePassedhashSearchTime[1],timePassedhashSearchTime[2], "hash" );

            }catch(FileNotFoundException | InputMismatchException e){
                System.out.println("NoSuchFileException"+ e.getMessage());
            }
        }catch(FileNotFoundException e) {
            System.out.println("NoSuchFileException" + e.getMessage());
        }
    }

    private int binarySearch(String[] arrayFrom, String searchValue) {
        int left = 0;
        int right = arrayFrom.length;
        int middle ;
        while(left <= right){
            middle = (left + right) / 2;
            if(arrayFrom[middle].equals(searchValue)){
                return middle;
            }else if(arrayFrom[middle].compareTo(searchValue) > 0 ){
                right = middle -1;
            }else {
                left = middle +1;
            }
        }
        return -1;
    }

    /*public int jumpSearchForward(int[] arrayFrom, int searchValue){
        int step =(int) Math.floor(Math.sqrt(arrayFrom.length));
        int curIndex = 0;
        int index = 0;

        while (curIndex <= arrayFrom.length -1) {
            if(arrayFrom[curIndex] == searchValue) {
                return curIndex;

            }else if(arrayFrom[curIndex] > searchValue) {
                index = curIndex - 1;

                while(index > curIndex - step && index >= 1) {
                    if(arrayFrom[index] == searchValue) {
                        return index;
                    }
                    index -= 1;
                }
                return -1;
            }
            curIndex += step;
        }
        index = arrayFrom.length -1;

        while(index > curIndex - step) {
            if(arrayFrom[index] == searchValue) {
                return index;
            }
            index -= 1;
        }
        return -1;
    }
    public int jumpSearchBackward(int[] arrayFrom, int searchValue){
        int step =(int) Math.floor(Math.sqrt(arrayFrom.length));
        int curIndex = arrayFrom.length -1;
        int index = arrayFrom.length -1;

        while (curIndex >= 0 ) {
            if(arrayFrom[curIndex] == searchValue) {
                return curIndex;

            }else if(arrayFrom[curIndex] < searchValue) {
                index = curIndex - 1;

                while(index < curIndex + step && index >= 0) {
                    if(arrayFrom[index] == searchValue) {
                        return index;
                    }
                    index -= 1;
                }
                return -1;
            }
            curIndex -= step;
        }
        index = arrayFrom.length -1;

        while(index < curIndex + step) {
            if(arrayFrom[index] == searchValue) {
                return index;
            }
            index -= 1;
        }
        return -1;
    }
*/
    public boolean jumpSearchForward(String[] arrayFrom, String searchFind){
        int step =(int) Math.floor(Math.sqrt(arrayFrom.length));
        int curIndex = 0;
        int index = 0;

        while (curIndex <= arrayFrom.length -1) {
            if(arrayFrom[curIndex].contains(searchFind)) {
//                return curIndex;
                return true;
            }else if( arrayFrom[curIndex].compareTo(searchFind) <= 0) {
                index = curIndex - 1;

                while(index > curIndex - step && index >= 1) {
                    if(arrayFrom[index].contains(searchFind)) {
//                        return index;
                        return  true;
                    }
                    index -= 1;
                }
//                return -1;
                return false;
            }
            curIndex += step;
        }
        index = arrayFrom.length -1;

        while(index > curIndex - step) {
            if(arrayFrom[index].contains(searchFind)) {
//                return index;
                return true;
            }
            index -= 1;
        }
//        return -1;
        return false;
    }
    public int jumpSearchBackward(int[] arrayFrom, int searchValue){
        int step =(int) Math.floor(Math.sqrt(arrayFrom.length));
        int curIndex = arrayFrom.length -1;
        int index = arrayFrom.length -1;

        while (curIndex >= 0 ) {
            if(arrayFrom[curIndex] == searchValue) {
                return curIndex;

            }else if(arrayFrom[curIndex] < searchValue) {
                index = curIndex - 1;

                while(index < curIndex + step && index >= 0) {
                    if(arrayFrom[index] == searchValue) {
                        return index;
                    }
                    index -= 1;
                }
                return -1;
            }
            curIndex -= step;
        }
        index = arrayFrom.length -1;

        while(index < curIndex + step) {
            if(arrayFrom[index] == searchValue) {
                return index;
            }
            index -= 1;
        }
        return -1;
    }
    public long[] time(long timeElapsed){

        long[] timeMSM = new long[3];
        long mils = timeElapsed % 1000;
        timeMSM[2] = mils;
        long min = timeElapsed/60000;
        timeMSM[0] = min;
        long seconds = timeElapsed/1000 > 60 ? (timeElapsed/1000)%60: timeElapsed/1000 ;
        timeMSM[1] = seconds;

        return timeMSM;
    }

    public void printTimeStamps(int countFound, int searchAmount,long min, long sec, long  milli, long sortMin,long sortSec,long sortMilli, long searchMin,long searchSec,long searchMilli, String forHash){

        long totalMin = min + sortMin + searchMin;
        long totalSec = sec + sortSec + searchSec;
        long totalMilli = milli + sortMilli + searchMilli;
        if(searchMilli == -1){
            totalMin = min + sortMin ;
            totalSec = sec + sortSec ;
            totalMilli = milli + sortMilli;
        }

        System.out.printf("Found %d / %d entries. ", countFound, searchAmount);
        System.out.printf("Time taken: %d min. %d sec. %d ms.%n",totalMin ,totalSec, totalMilli);

        if(sortMin >= 10) {
            System.out.printf("Sorting time: %d min. %d sec. %d ms.- STOPPED, moved to linear search\n",sortMin ,sortSec, sortMilli);
            System.out.printf("Searching time: %d min. %d sec. %d ms.", searchMin, searchSec, searchMilli);
        }else if(sortMin < 10 && (searchMilli > -1 || searchMin > -1 || searchSec > -1) ) {
            if(forHash != "hash") {
                System.out.printf("Sorting time: %d min. %d sec. %d ms.\n", sortMin, sortSec, sortMilli);
            }else{
                System.out.printf("Creating time: %d min. %d sec. %d ms.\n", sortMin, sortSec, sortMilli);
            }
            System.out.printf("Searching time: %d min. %d sec. %d ms.", searchMin, searchSec, searchMilli);
        }
        System.out.println();
    }
    //--------------------Quick Sort------------------------
    // Java implementation of QuickSort
        // A utility function to swap two elements
        public void swap(String[] arr, int i, int j)
        {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        /* This function takes last element as pivot, places
        the pivot element at its correct position in sorted
        array, and places all smaller (smaller than pivot)
        to left of pivot and all greater elements to right
        of pivot */
        public int partition(String[] arr, int low, int high) {
            // pivot
            String pivot = arr[high];

            // Index of smaller element and
            // indicates the right position
            // of pivot found so far
            int i = (low - 1);

            for(int j = low; j <= high - 1; j++) {
                // If current element is smaller
                // than the pivot
                if (arr[j].compareTo(pivot) < 0 ) {
                    // Increment index of
                    // smaller element
                    i++;
                    swap(arr, i, j);
                }
            }
            swap(arr, i + 1, high);
            return (i + 1);
        }

        /* The main function that implements QuickSort
                arr[] --> Array to be sorted,
                low --> Starting index,
                high --> Ending index
        */
        public void quickSort(String[] arr, int low, int high) {
            if (low < high) {
                // pi is partitioning index, arr[p]
                // is now at right place
                int pi = partition(arr, low, high);

                // Separately sort elements before
                // partition and after partition
                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            }
        }
    public void printArrayString(String[] arr, int size){
        for(int i = 0; i < size; i++)
            System.out.println(arr[i] + " ");

    }

        // Function to print an array
        /* public void printArray(int[] arr, int size)
        {
            for(int i = 0; i < size; i++)
                System.out.print(arr[i] + " ");

            System.out.println();
        }
*/
    //--------------------Quick Sort End---------------------
    public static void main(String[] args){
        Main main = new Main();
        main.start();
    }
}