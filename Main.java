import java.io.*;
class Main{
    static int[] lego = {1,2,3,4,6,8,10,12,16};
    public static void main(String[] Args) throws IOException {
        System.out.println(calc(6));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String[] aux = br.readLine().split(" ");
        //int x = Integer.parseInt(aux[0]);
        //int y = Integer.parseInt(aux[1]);
        //String[][] board = new String[x][y];
        //String line;
        //for(int i=0;i<x;++i){
        //    line=br.readLine();
        //    for(int j=0;j<y;++j){
        //        System.out.print(line.charAt(j));
        //        board[i][j]=Character.toString(line.charAt(j));
        //    }
        //    System.out.println();
        //}
        //System.out.println(x+" "+y);
        //for(int i = 0; i < x; ++i){
        //    for(int j = 0;j < 0; j++){
        //        System.out.print(board[i][j]+"-");
//
        //    }
        //    System.out.println();
        //}


        
        
    }
    public static long calc(int size){
        long[] nComb = new long[size+1];
        nComb[0]=1;
        for(int i = 1; i<=size;++i){
            for(int j=0;j<lego.length;++j){
                //if(lego[j]==i){
                //    ++nComb[i];
                //}
                if(lego[j]<=i){
                    nComb[i]+=nComb[i-lego[j]];
                }
            }
        }
        return nComb[size];
    }

    
}
