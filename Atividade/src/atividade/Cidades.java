package atividade; 
import java.util.Scanner;
public class Cidades {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int casos,i=1,aux;
		final int maximo=100;
		String []cidades= new String[maximo];
		String []regioes=new String[maximo];
		int []populacoes=new int[maximo];
		do{
			System.out.print("Quantas cidades ser�o analisadas: ");
			casos=leInteiro(entrada,"a quantidade de casos");
			entrada.nextLine();
			if(casos>maximo){
				System.out.printf("A quantidade de casos n�o pode ser superior a %d\n",maximo);
				System.out.println("Tente novamente.");
			}
		}while(casos>maximo);
		aux=casos;
		while(aux>0){
			System.out.printf("Digite o nome da cidade %d: ",i);
			cidades[i-1]=leString(entrada,"cidade");
			System.out.printf("Digite o nome da regi�o da cidade %d: ",i);
			regioes[i-1]=leString(entrada,"regi�o");
			System.out.printf("Digite o tamanho da popula��o da cidade %d: ",i);
			populacoes[i-1]=leInteiro(entrada,"o tamanho da popula��o");
			entrada.nextLine();
			aux--;
			i++;
		}
		if(casos==0){
			System.out.println("Nenhuma cidade foi cadastrada!");
			
		}
		else{
			menu(cidades,regioes,populacoes,casos,entrada);
		}
		

	}
	public static String leString(Scanner entrada,String aux){
		String retorno;
		while(!entrada.hasNextLine()){
			System.out.printf("Voc� deve digitar o nome de uma %s!\n",aux);
			System.out.println("Tente novamente.");
			return leString(entrada,aux);
		}
		retorno=entrada.nextLine();
		return retorno;
	}
	public static int leInteiro(Scanner entrada,String aux){
		int retorno;
		while(!entrada.hasNextInt()){
			System.out.printf("Voc� deve digitar %s!\n",aux);
			System.out.println("Tente novamente.");
			entrada.nextLine();
			return leInteiro(entrada,aux);
		}
		retorno=entrada.nextInt();
		return retorno;
	}
	public static void op1(String[]cidades,String[]regioes,int[] populacoes,int qtde){
		for(int i=0;i<qtde;i++){
			System.out.printf("\nInforma��es sobre a cidade %d:\n",i+1);
			System.out.printf("Nome: %s\n",cidades[i]);
			System.out.printf("Regi�o: %s\n", regioes[i]);
			System.out.printf("Popula��o: %d\n",populacoes[i] );
		}
	}
	public static void op2(String[]cidades,int[] populacoes,int qtde){
		int maior=-1,pos=0;
		for(int i=0;i<qtde;i++){
			if(populacoes[i]>maior){
				maior=populacoes[i];
				pos=i;
			}
		}
		System.out.printf("\nA cidade de maior popula��o �: %s\n",cidades[pos]);
		System.out.printf("Ela possui %d habitantes.\n", maior);
	}
	public static void op3(String[] cidades,String[] regioes,int[] populacoes,int qtde){
		System.out.println("\nCidades que possuem mais de 50 mil habitantes: ");
		boolean check=true;
		for(int i=0;i<qtde;i++){
			if(populacoes[i]>50000){
				System.out.printf("A cidade %s est� na regi�o %s e possui %d habitantes\n", cidades[i],regioes[i],populacoes[i]);
				check=false;
			}
		}
		if(check){
			System.out.println("N�o h� cidades com mais de 50 mil habitantes!");
			return;
		}
	}
	public static void menu(String[] cidades,String[] regioes,int[] populacoes,int qtde,Scanner entrada ){
		int op;
		do{
			System.out.println("1-Imprimir informa��es sobre todas as cidades.");
			System.out.println("2-Imprimir a cidade de maior popula��o.");
			System.out.println("3-Imprimir informa��es sobre todas as cidades com popula��o acima de 50 mil habitantes.");
			System.out.print("\nDigite o c�digo da op��o desejada: ");
			do{
				op=leInteiro(entrada,"um c�digo v�lido");
				entrada.nextLine();
				if(op>3||op<1){
					System.out.println("Voc� deve digitar um c�digo v�lido!");
					System.out.println("Tente novamente.");
				}
			}while(op>3||op<1);
			if(op==1){
				op1(cidades,regioes,populacoes,qtde);
			}
			else if(op==2){
				op2(cidades,populacoes,qtde);
			}
			else{
				op3(cidades,regioes,populacoes,qtde);
			}
			System.out.print("\nDigite o 1 caso deseje selecionar uma nova op��o: ");
			op=leInteiro(entrada,"um inteiro");
		}while(op==1);
	}
}
