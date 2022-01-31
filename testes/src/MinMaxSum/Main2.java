package MinMaxSum;

public class Main2 {

    public static void MinMaxSum(int arr[]) {

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int j = 0; j < arr.length; j++) {

            int soma = 0;

            for (int i = 0; i < arr.length; i++) {

                if (i != j)
                soma += arr[i];

            }

            if (soma > max)
                max = soma;

            if (soma < min)
                min = soma;

        }

        System.out.println(min + " " + max);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};

        MinMaxSum(arr);
    }


}
