public class Primes 
{
	public static boolean isPrime(int n){
		for (int j = 2; j<i; j++){	
			if(i%j == 0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		for(int i=1;i<100;i++){
			if (isPrime(i)){
				System.out.print(" "+i);
			}
		}
	}
	
}	
	
