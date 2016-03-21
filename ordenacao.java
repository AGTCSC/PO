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

public void quickSort(int ini, int fim)
{			
	int i = ini;
	int j = fim;	
	int aux=0;

	while(i < j)
	{		
		while(i < j && vet[i] < vet[j])	i++;
		aux = vet[i];
		vet[i] = vet[j];
		vet[j] = aux;		
		while(i < j && vet[j] > vet[i])	j--;		
			
		aux = vet[i];
		vet[i] = vet[j];
		vet[j] = aux;		
	}
	if( (i-1) - ini > 1)
		quickSort((ini, i-1);
	if( fim - (j+1) > 1)
		quickSort(j+1, fim);
}
//////////////////////////////////////////////////////////////////////////
public void particao(int  [] vet1, int[] vet2)
{
	int meio = tl << 1;
		for(int i=0; i<tl; i++)
		{
			vet1[i] = vet[i];
			vet2[i+meio] = vet[meio+1];
		}
}
public void fusao(int[] vet1, int[] vet2, int seq)
{
	int k = 0, i=0, j=0, t_seq = seq; 
	while(k < tl)
	{	
		while(i<seq || j<seq)
		{
			if(vet1[i] < vet2[j])
				vet[k++] = vet1[i++];
			else
				vet[k++] = vet2[j++];

		}
		while(i < seq)
			vet[k++] = vet1[i++];
		while(j < seq)
			vet[k++] = vet2[j++];
		seq = seq + t_seq;
	}
}
public void margeSort()
{
	int seq = 0;
	int meio = tl << 1;
	int vet1[meio];
	int vet2[meio];
	
	while(seq < tl)
	{
		particao(vet1, vet2);
		fusao(vet1, vet2, seq);
		seq *= 2;
	}
}
//////////////////////////////////////////////////////
