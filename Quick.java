public class Quick{
  public static int partition(int[] data, int start, int end){
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
    return 1;
  }

  public static void main(String[] args){
    //int[] test =  {0, 1, 2, 3, 4, 5, 6, 7, 8,9};
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
    //for (int i : test){
    //  System.out.print ("" + i + " ");
    //}
  }
}
