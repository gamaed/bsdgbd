public class MainV2 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {-7, 8, 9}
        };

        System.out.println("Сума всіх елементів: " + sumArray(arr));
        findMaxElement(arr);
        sumRows(arr);
        sumDiagonals(arr);
        findRowWithMaxSum(arr);
        findNegativeElements(arr);
        findColumnWithMaxSum(arr);
        replaceZeros(arr);
        findColumnAverages(arr);
    }

    public static int sumArray(int[][] arr) {
        int sum = 0;
        for (int[] row : arr) {
            for (int num : row) {
                sum += num;
            }
        }
        return sum;
    }
    public static void findMaxElement(int[][] arr) {
        int max = arr[0][0];
        int rowIndex = 0, colIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    rowIndex = i;
                    colIndex = j;
                }
            }
        }
        System.out.println("Максимальний елемент: " + max + " на позиції (" + rowIndex + ", " + colIndex + ")");
    }
    public static void sumRows(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
            System.out.println("Сума рядка " + i + ": " + sum);
        }
    }
    public static void sumDiagonals(int[][] arr) {
        int mainDiagonalSum = 0;
        int secondaryDiagonalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            mainDiagonalSum += arr[i][i];
            secondaryDiagonalSum += arr[i][arr.length - 1 - i];
        }
        System.out.println("Сума головної діагоналі: " + mainDiagonalSum);
        System.out.println("Сума побічної діагоналі: " + secondaryDiagonalSum);

        if (mainDiagonalSum > secondaryDiagonalSum) {
            System.out.println("Головна діагональ має більшу суму.");
        } else if (secondaryDiagonalSum > mainDiagonalSum) {
            System.out.println("Побічна діагональ має більшу суму.");
        } else {
            System.out.println("Суми діагоналей однакові.");
        }
    }
    public static void findRowWithMaxSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;
        int maxRowIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxRowIndex = i;
            }
        }
        System.out.println("Рядок з найбільшою сумою елементів: " + maxRowIndex);
    }
    public static void findNegativeElements(int[][] arr) {
        int count = 0;
        for (int[] row : arr) {
            for (int num : row) {
                if (num < 0) {
                    count++;
                }
            }
        }
        System.out.println("Кількість від'ємних елементів: " + count);
    }
    public static void findColumnWithMaxSum(int[][] arr) {
        int columns = arr[0].length;
        int maxSum = Integer.MIN_VALUE;
        int maxColIndex = -1;
        for (int j = 0; j < columns; j++) {
            int sum = 0;
            for (int[] row : arr) {
                sum += row[j];
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxColIndex = j;
            }
        }
        System.out.println("Стовпчик з найбільшою сумою: " + maxColIndex);
    }
    public static void replaceZeros(int[][] arr) {
        int sum = 0;
        int count = 0;
        for (int[] row : arr) {
            for (int num : row) {
                if (num != 0) {
                    sum += num;
                    count++;
                }
            }
        }
        if (count == 0) return;
        int average = sum / count;

        System.out.println("\nМасив після заміни нулів:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = average;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void findColumnAverages(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        System.out.println("\nСереднє арифметичне для кожного стовпця:");
        for (int j = 0; j < cols; j++) {
            int sum = 0;
            for (int i = 0; i < rows; i++) {
                sum += arr[i][j];
            }
            double average = (double) sum / rows;
            System.out.println("Стовпець " + j + ": " + average);
        }
    }
}
