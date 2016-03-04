void heap()
{
    int tl2 = tl;
    int maiorF, FE, FD;                       //maior filho, filho da esquerda e direita
    int aux;
    
    while(tl2 > 1)
    {
      for(int pai = (tl2/2)-1; pai--)
      {
        FE = pai*pai+1; //FILHO DA ESQUERDA
        FD = pai*pai+2; //FILHO DA DIREITA
        maiorF = FE;

        if(FD < tl2 && vet[FD] > vet[FE])              //se o filho da esquerda existe
          maiorF = FD;                                //encontro o maior
          
        if (vet[pai] < vet[maiorF])                   //pai recebe o maior filho e vice-versa
        { 
            aux = vet[maiorF];
            vet[maiorF] = vet[pai];
            vet[pai] = aux;
        }
      }
      
      aux = vet[tl2];                           //Permutação entre o ultimo e o primeiro
      vet[tl2] = vet[0];
      vet[0] = aux;
      
      tl2--;
    }
}
