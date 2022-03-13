import java.io.*;
class Main{
    static int[] legoSize = {1,2,3,4,6,8,10,12,16};
    public static void main(String[] Args) throws IOException {
        //System.out.println(calc(6));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] aux = br.readLine().split(" ");
        int x = Integer.parseInt(aux[0]);
        int y = Integer.parseInt(aux[1]);
        
        
        char[][] board = new char[x][y];
        String line;
        
        for(int i=0;i<x;++i){
            line=br.readLine();
            for(int j=0;j<y;++j){
                board[i][j]=line.charAt(j);
            }
        }

        long result=1;
        char currentColor;
        int numberSequense=1;
        char charAtPos;
        for(int i=0;i<x;++i){
            charAtPos=board[i][0];
            currentColor=charAtPos;
            if(charAtPos!='.'){
                numberSequense=1;
            }
            for(int j=1;j<y;++j){
                charAtPos=board[i][j];
                if(charAtPos=='.'){
                    if(currentColor!=charAtPos){
                        result*=calc(numberSequense);
                        numberSequense=0;
                    }
                }
                else if(j==y-1){
                    if(charAtPos==currentColor){
                        result*=calc(++numberSequense);
                        numberSequense=1;
                    }
                }
                else{
                    if(charAtPos==currentColor){
                        ++numberSequense;
                        
                    }
                    else{
                        result*=calc(numberSequense);
                        currentColor=charAtPos;
                        numberSequense=1;
                    }
                }
                

                
            }
            
        }
        System.out.println(result);


        
        
    }
    public static long calc(int size){
        long[] numberCombinations = new long[size+1];
        numberCombinations[0]=1;
        for(int i = 1; i<=size;++i){
            for(int j=0;j<legoSize.length;++j){
                if(legoSize[j]<=i){
                    numberCombinations[i]+=numberCombinations[i-legoSize[j]];
                }
            }
        }
        return numberCombinations[size];
    }

    
}
