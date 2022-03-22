import java.io.*;
class Main{
    static int[] bricks = {1,2,3,4,6,8,10,12,16};
    public static void main(String[] Args) throws IOException {
        /*----------------------------------------------------*/ 
        /*               Leitura dos Dados                    */ 
        /*----------------------------------------------------*/ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] aux = br.readLine().split(" ");
        int x = Integer.parseInt(aux[0]);   //linhas
        int y = Integer.parseInt(aux[1]);   //colunas
        
        
        char[][] board = new char[x][y];    //mosaico
        String line;                        //auxia a ler o mosaico
        for(int i=0;i<x;++i){               //le o mosaico
            line=br.readLine();
            for(int j=0;j<y;++j){
                board[i][j]=line.charAt(j);
            }
        }
        /*----------------------------------------------------*/ 
        /*               Analise dos Dados                    */ 
        /*----------------------------------------------------*/

        long result=1;      
        char currentColor;
        int sequenceSize=1;
        char atPos;
        for(int i=0;i<x;++i){       
            atPos=board[i][0];
            currentColor=atPos;
            if(atPos!='.'){         // caso a primeira posição da linha não seja 1 ponto
                sequenceSize=1;
            }
            for(int j=1;j<y;++j){
                atPos=board[i][j];
                if(atPos=='.'){     //se for um ponto
                    if(currentColor!=atPos){  // e se vier depois de uma sequencia
                        result*=possibleCombinations(sequenceSize);
                        sequenceSize=0;
                    }
                }
                else if(j==y-1){        // caso estejamos a analisar a ultima posição da linha
                    if(atPos==currentColor){    //caso a ultima posição pertença á sequencia
                        result*=possibleCombinations(++sequenceSize);
                        sequenceSize=1;
                    }
                    else{       
                        result*=possibleCombinations(sequenceSize);
                        sequenceSize=1;
                    }
                }
                else{   
                    if(atPos==currentColor){    // caso a cor em questão pertença á sequencia
                        ++sequenceSize;
                        
                    }
                    else{               
                        result*=possibleCombinations(sequenceSize);
                        currentColor=atPos;
                        sequenceSize=1;
                    }
                }
                

                
            }
            
        }
        System.out.println(result);


        
        
    }

    public static long possibleCombinations(int sequenceSize){
        long[] numOfCombinations = new long[sequenceSize+1];
        numOfCombinations[0]=1;         // Caso base
        for(int i = 1; i<=sequenceSize;++i){        
            for(int j=0;j<bricks.length;++j){       // analisar para cada peça
                if(bricks[j]<=i){               // verfica se podemos usar a peça e soma ao resultado
                    numOfCombinations[i]+=numOfCombinations[i-bricks[j]];  
                }
            }
        }
        return numOfCombinations[sequenceSize];
    }

    
}