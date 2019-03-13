public class Quick{

  private static int median(int a, int b, int c){
    int max = a;
    int min = a;
    if (b < min){
      min = b;
    }
    if (c < min){
      min = c;
    }
    if (b > max){
      max = b;
    }
    if (c > max){
      max = c;
    }
    return a + b + c - max - min;
  }

  public static int partition(int[] data, int start, int end){
    //System.out.println("" + median(3,1,1123));
    //System.out.println("---------------------");


    int first = data[start];
    int last = data[end];
    int middle = data[((end - start) / 2) + start];
    int mediann = median(first, last, middle);

    //int pivot;

    /*
    if (mediann == middle){
      pivot = (end - start) / 2;
    }else{
      if (mediann == first){
        pivot = start;
      }else{
        pivot = end;
      }
    }
    System.out.println("" + pivot);
    */

    int pivot = (int)(Math.random() * ((end - start) + 1)) + start;
    //int pivot = 1;

    int temp = data[start];
    data[start] = data[pivot];
    data[pivot] = temp;
    start++;

    while (start < end){
      if (data[start] > data[0]){
        temp = data[start];
        data[start] = data[end];
        data[end] = temp;
        end--;
      }else{
        start++;
      }
      //for (int i : data){
      //  System.out.print ("" + i + " ");
      //}
      //System.out.println();
      //System.out.println();
    }

    if (data[0] < data[start]){
      start--;
    }

    temp = data[start];
    data[start] = data[0];
    data[0] = temp;

    return start;
  }

  public static int quickselect(int[] data, int k){
    //int finalpivot = partition(data, 0, data.length - 1);
    if (partition(data, 0, data.length - 1) == k){
      return data[k];
    }
    return quickselect(data, k);
    //return quickselectH(data, k, 0, data.length - 1);
  }

  private static int quickselectH(int[] data, int k, int start, int end){
    int finalpivot = partition(data, start, end);
    if (finalpivot == k){
      return data[k];
    }
    if (finalpivot > k){
      return quickselectH(data, k, finalpivot, data.length - 1);
    }
    return quickselectH(data, k, 0, finalpivot);
  }

  public static void main(String[] args){
    //int[] test =  {0, 1, 2, 3, 4, 5, 6, 7, 8,9};


    //partition testing is below
    /*

    int[] test = {17, 61, 67, 47, 93, 12, 20, 4, 44, 68};
    for (int i : test){
      System.out.print ("" + i + " ");
    }
    System.out.println();
    System.out.println("------------------------------");
    System.out.println(partition(test, 0, 9));
    System.out.println("------------------------------");
    for (int i : test){
      System.out.print ("" + i + " ");
    }
    System.out.println();

    */

    //for (int i : test){
    //  System.out.print ("" + i + " ");
    //}
    //int[]ary = { 2, 10, 15, 23, 0,  5,1,3,4,6,7,8,11,12,19,44,56,99,98,987,912,100,77,76,65,69,654,68,765,123,125,236,999,998,997,991,1111,11112,111122,1112,1113,1111111,1231231,145672,908,7857,7800};  //sorted :  {0,2,5,10,15,23}


    //@TODO: QUICKSELECT STILL DOESN'T WORK IF THERE ARE A LOT OF DUPLICATES

    int[]ary = { 2, 10, 15, 23, 0,  5, 6 };//, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0};
    for (int i = 0; i < ary.length; i++){
      System.out.println(quickselect( ary , i ));
    }
    //System.out.println(quickselect( ary , 0 )); //would return 0
    //System.out.println(quickselect( ary , 1 ));  //would return 2
    //System.out.println(quickselect( ary , 2 ));  //would return 5
    //System.out.println(quickselect( ary , 3 ));  //would return 10
    //System.out.println(quickselect( ary , 4 ));  //would return 15
    //System.out.println(quickselect( ary , 5 ));  //would return 23
  }
}
