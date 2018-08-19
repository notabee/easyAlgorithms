import java.util.Scanner;

class MergeCount{
    int count = 0;
    void merge(int arr[], int l,int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;

        int leftArray[] = new int [n1];
        int rightArray[] = new int [n2];

        for(int i=0; i<n1; i++){
            leftArray[i] = arr[l+i];
        }
        for(int j=0; j<n2; j++){
            rightArray[j] = arr[m+1+j];
        }

        int i=0, j=0;

        int k = l;
        while(i<n1 && j<n2){
            if(leftArray[i] <= rightArray[j]){
                arr[k] = leftArray[i];
                i++;
            }
            else{
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while(j < n2){
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
    void sort(int arr[], int leftIndex, int rightIndex){
        if(leftIndex < rightIndex){
            int cl = 0;
            int middleIndex = (leftIndex+rightIndex)/2;
            for(int k=leftIndex; k<middleIndex;k++){
                if(arr[k]<arr[k+1]){
                    cl++;
                }
            }
            if(cl!=middleIndex){
                count++;
                sort(arr,leftIndex,middleIndex);
            }
            int cr = 0;
            for(int k=middleIndex + 1; k<rightIndex;k++){
                if(arr[k]<arr[k+1]){
                    cr++;
                }
            }
            if(cr!=(rightIndex-middleIndex)){
                count++;
                sort(arr,middleIndex + 1, rightIndex);
            }
            merge(arr, leftIndex, middleIndex, rightIndex);
        }
    }
    void displayArray(int arr[],int n){
        //to print sorted array uncomment the code below
        /*for(int i=0; i<n; i++){
          System.out.print(arr[i] + " ");
        }
        System.out.println();*/
        //to print the number of times sort function is called uncomment the code below
        /*System.out.print(count);
        System.out.println();
        count=0;*/
    }
}

class main{
    public static void main(String arg[]){


        Scanner sc = new Scanner(System.in);

        int t;
        t = sc.nextInt();
        for(;t>0;t--){
            int n;
            int v=2;
            n = sc.nextInt();
            for(;v>0;v--){
                int[] arr = new int[1000];
                int i;
                for(i=0;i<n;i++){
                    arr[i] = sc.nextInt();
                }
                MergeCount sorter = new MergeCount();
                sorter.sort(arr,0,i - 1);
                sorter.displayArray(arr,n);
            }
        }
    }
}
