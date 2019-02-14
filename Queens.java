/*
* Name: Sidharth Naik
* ID: 1647945
* Class: 12B/M
* Date: February 5,2018
* Description: This is the code that contains all the methods for the Queens problem.
* File Name: Queens.java
* Instructions: After compiling by using the make command in the command line
* type: Queens [-v] number in the command line to run the code
*/

public class Queens {
    static void placeQueen(int[][] B, int i, int j){
        i +=1;
        j +=1;

        B[i][0] = j;

        B[i][j] = 1;

        if( i == B[0].length-1){
            B[i][j] =1;
        }
        else if(j == 1){
            for(int k = i+1, l = j+1; k < B.length; k++, l++){
                B[k][j] -= 1;
                B[k][l] -= 1;
            }
        }
        else if(j == B[0].length-1){
            for(int k = i+1, l = j-1; k < B.length; k++, l--){
                B[k][j] -= 1;
                B[k][l] -= 1;
            }
        }
        else{
            for(int l = j + 1, k = i+1; l < B.length && k < B.length; l++, k++){
                B[k][l] -= 1;
            }
            for(int l = j-1, k = i+1; l > 0 && k < B.length; l--, k++){
                B[k][l] -= 1;
            }
            for(int k = i+1; k < B.length; k++){
                B[k][j] -= 1;
            }
        }
    }

    static void removeQueen(int[][] B, int i, int j){
        i +=1;
        j +=1;

        B[i][0] = 0;

        B[i][j] = 0;

        if( i == B[0].length-1){
            B[i][j] = 0;
        }
        else if(j == 1){
            for(int k = i+1, l = j+1; k < B.length; k++, l++){
                B[k][j] += 1;
                B[k][l] += 1;
            }
        }
        else if(j == B[0].length-1){
            for(int k = i+1, l = j-1; k < B.length; k++, l--){
                B[k][j] += 1;
                B[k][l] += 1;
            }
        }
        else{
            for(int l = j + 1, k = i+1; l < B.length && k < B.length; l++, k++){
                B[k][l] += 1;
            }
            for(int l = j-1, k = i+1; l > 0 && k < B.length; l--, k++){
                B[k][l] += 1;
            }
            for(int k = i+1; k < B.length; k++){
                B[k][j] += 1;
            }
        }

    }

    static void printBoard(int[][] B){
        System.out.print("(");

        for(int i = 1; i < B.length; i++){
            if(i == B.length -1){
                System.out.print(B[i][0] + ")");
            }
            else {
                System.out.print(B[i][0] + ", ");
            }
        }
    }

    static int findSolutions(int[][] B, int i, String mode){
        int n = 0;
        if(i >=  B.length-1){
            if(mode.equals("-v")){
                printBoard(B);
                System.out.println();
            }
                return 1;
        }
        else{
            for(int j = 0 ; j < B[i].length-1; j++){
                if(B[i+1][j+1] == 0){
                    placeQueen(B,i,j);
                    n += findSolutions(B,i+1,mode);
                    removeQueen(B,i,j);
                }
            }
        }
        return n;
    }

    static boolean isInt(String uString){
      try{
        Integer.parseInt(uString);
        return true;
      } catch(NumberFormatException ex){
        return false;
      }
    }

    public static void main(String[] args){

      if(args.length < 1){
        System.out.println("Usage: Queens [-v] number");
        System.out.println("Option: -v  verbose output, print all solutions");
        System.exit(1);
      }
      if(!(args[0].equals("-v")) && !(isInt(args[0]))) {
        System.out.println("Usage: Queens [-v] number");
        System.out.println("Option: -v  verbose output, print all solutions");
        System.exit(1);
      } else if(args.length > 1 && !(isInt(args[1]))) {
        System.out.println("Usage: Queens [-v] number");
        System.out.println("Option: -v  verbose output, print all solutions");
        System.exit(1);
      } else if(args[0].equals("-v") && args.length < 2){
        System.out.println("Usage: Queens [-v] number");
        System.out.println("Option: -v  verbose output, print all solutions");
        System.exit(1);
      }

      if(args[0].equals("-v")){
        int n = Integer.parseInt(args[1]);
        int[][] B = new int[n+1][n+1];
        System.out.println(args[1] + "-Queens has " + findSolutions(B,0,"-v") + " solutions");
      }
      else{
        int n = Integer.parseInt(args[0]);
        int[][] B = new int[n+1][n+1];
        System.out.println(args[0] + "-Queens has " + findSolutions(B,0," ") + " solutions");
      }
  }
}
