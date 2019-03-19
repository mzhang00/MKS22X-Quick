import java.util.Arrays;

public class Quick{

  private static int median(int[] ary, int a, int b, int c){
    if (ary[a] <= ary[b] && ary[a] >= ary[c]){
      return a;
    }
    if (ary[a] >= ary[b] && ary[a] <= ary[c]){
      return a;
    }
    if (ary[b] >= ary[c] && ary[b] <= ary[a]){
      return b;
    }
    if (ary[b] <= ary[c] && ary[b] >= ary[a]){
      return b;
    }
    return c;
  }

  private static int[] partitionDutch(int[] data, int start, int end){
    int[] returnary = new int[2];
    int lt = 0;
    int gt = end;

    if (start == end){
      returnary[0] = start;
      returnary[1] = start;
      return returnary;
    }

    int pivot = median(data, start, end, ((end - start) / 2) + start);
    int oldpivot = start;

    int temp = data[start];
    data[start] = data[pivot];
    data[pivot] = temp;

    start++;
    lt = start;

    while (start < gt){
      if (data[start] == data[oldpivot]){
        temp = data[start];
        data[start] = data[lt];
        data[lt] = temp;
        start++;
      }else{
        if (data[start] > data[oldpivot]){
          temp = data[start];
          data[start] = data[gt];
          data[gt] = temp;
          gt--;
        }else{
          if (data[start] < data[oldpivot]){
            temp = data[start];
            data[start] = data[lt];
            data[lt] = temp;
            lt++;
            start++;
          }
        }
      }
    }

    if (data[oldpivot] <= data[start]){
      temp = data[lt - 1];
      data[lt - 1] = data[oldpivot];
      data[oldpivot] = temp;
      lt--;
    }else{
      temp = data[start];
      data[start] = data[oldpivot];
      data[oldpivot] = temp;
    }

    returnary[0] = lt;
    returnary[1] = gt;
    
    return returnary;
  }

  private static int partition(int[] data, int start, int end){
    if (start == end){
      return start;
    }

    int pivot = median(data, start, end, ((end - start) / 2) + start);
    int oldpivot = start;
    int temp = data[start];

    data[start] = data[pivot];
    data[pivot] = temp;
    start++;

    while (start < end){
      if (data[start] == data[oldpivot]){
        if (Math.random() < 0.5){
          temp = data[start];
          data[start] = data[end];
          data[end] = temp;
          end--;
        }
      }
      if (data[start] > data[oldpivot]){
        temp = data[start];
        data[start] = data[end];
        data[end] = temp;
        end--;
      }else{
        start++;
      }
    }

    if (data[oldpivot] < data[start]){
      start--;
    }

    temp = data[start];
    data[start] = data[oldpivot];
    data[oldpivot] = temp;

    return start;
  }

  public static int quickselect(int[] data, int k){
    //return quickselectH(data, k, 0, data.length - 1);
    return quickselectD(data, k, 0, data.length - 1);
  }

  private static int quickselectH(int[] data, int k, int start, int end){
    int finalpivot = partition(data, start, end);
    if (finalpivot == k){
      return data[k];
    }
    if (finalpivot != k){
      if (finalpivot > k){
        end = finalpivot - 1;
      }
      if (finalpivot < k){
        start = finalpivot + 1;
      }
    }
    return quickselectH(data, k, start, end);
  }

  private static int quickselectD(int[] data, int k, int start, int end){
    int finalpivotary[] = partitionDutch(data, start, end);
    boolean kinrange = finalpivotary[0] < k && k < finalpivotary[1];
    if (kinrange){
      return data[k];
    }
    if (!kinrange){
      if (finalpivotary[0] > k){
        end = finalpivotary[0];
      }
      if (finalpivotary[1] < k){
        start = finalpivotary[1];
      }
    }
    return quickselectD(data, k, start, end);
  }

  public static void quicksort(int[] data){
    //quicksortH(data, 0, data.length - 1, 0, data.length - 1);
    quicksortD(data, 0, data.length - 1, 0, data.length - 1);
  }

  private static void quicksortH(int[] data, int start, int end, int newstart, int newend){
    if (start >= end){
      return;
    }
    if (start >= 0 && end <= data.length - 1){
      int pivot = partition(data, start, end);
      quicksortH(data, newstart, pivot - 1, start, pivot - 1);
      quicksortH(data, pivot + 1, newend, pivot + 1, end);
    }
  }

  private static void quicksortD(int[] data, int start, int end, int newstart, int newend){
    if (start >= end){
      return;
    }
    if (start >= 0 && end <= data.length - 1){
      int pivot[] = partitionDutch(data, start, end);
      quicksortD(data, newstart, pivot[0], start, pivot[0]);
      quicksortD(data, pivot[1], newend, pivot[1], end);
    }
  }

// public static void main(String[] args){

    //test arrays below

    //int[]ary = { 2, 10, 15, 23, 0,  5,1,3,4,6,7,8,11,12,19,44,56,99,98,987,912,100,77,76,65,69,654,68,765,123,125,236,999,998,997,991,1111,11112,111122,1112,1113,1111111,1231231,145672,908,7857,7800};
    //int[] ary = { 2, 10, 15, 23, 0,  5, 6 , 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0};
    //int[] ary = {0,1, 2, 40, 5, 10 , 20, 9, 1, 1, 1, 1};
    //int[] ary = {0,1, 2, 50, 5, 10 , 20, 9};

    //partition testing is below

    //int[] test = {17, 61, 67, 47, 93, 12, 20, 4, 44, 68};
    //int[] test = {17, 17, 17, 47, 93, 12, 20, 4, 44, 17};
  /*  
    for (int i : test){
      System.out.print ("" + i + " ");
    }
    System.out.println();
    System.out.println("------------------------------");
    System.out.println(partition(test, 2, 9));
    System.out.println("------------------------------");
    for (int i : test){
      System.out.print ("" + i + " ");
    }
    System.out.println();
  */

    //dutch partition testing is below

    //int[] test = {17, 17, 17, 47, 93, 12, 20, 4, 44, 17};
  /*    
    int[] test = {5,9,5,1,4,3,5,7,2,5};
    for (int i : test){
      System.out.print ("" + i + " ");
    }
    System.out.println();
    System.out.println("------------------------------");
    int[] newary = partitionDutch(test, 2, 9);
    System.out.println("------------------------------");
    for (int i : test){
      System.out.print ("" + i + " ");
    }
    System.out.println();
    System.out.println("------------------------------");
    for (int i : newary){
      System.out.print ("" + i + " ");
    }
    System.out.println();
  */

    //quicksort testing is below

  /*
    quicksort(ary);
    for (int i : ary){
      System.out.print ("" + i + " ");
    }
    System.out.println();
  */

    //quickselect testing is below

  /*
    int[] newary = partitionDutch(ary, 0, ary.length - 1);
    System.out.println("------------------------------");
    for (int i : ary){
      System.out.print ("" + i + " ");
    }
    System.out.println();
    System.out.println("------------------------------");
    for (int i : newary){
      System.out.print ("" + i + " ");
    }
    System.out.println();
    System.out.println("------------------------------");
    for (int i = 0; i < ary.length; i++){
      System.out.println(quickselect( ary , i ));
    }
  */

//  }

  public static void main(String[]args){
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Quick.quicksort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }
}
