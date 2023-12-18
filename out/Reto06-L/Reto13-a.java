import java.util.Scanner;

class InnerApp {
    boolean isElementOf(int array[], int z){
        int i=0;
        for (int Array : array) {
            if(z==array[i]){
                return true;
             }
            i++;
         }
        return false;
    }
}
 public class App {
    public static void main(String[] args) throws Exception {
       System.out.println("Ingresa el valor de z");
        Scanner sc = new Scanner(System.in);
        int z = sc.nextInt();
            System.out.println("Ingresa el tamanio de la lista");
            int ArrayLenght = sc.nextInt();
            int[] array = new int[ArrayLenght]; 
                System.out.println("Ingresa los valores de la lista");
                    for(int j=0; j< ArrayLenght; j++){
                        array[j]= sc.nextInt();
                    }
                    InnerApp appi = new InnerApp();
                    boolean yes = appi.isElementOf(array, z);
                  /*  for(int Array : array){
                    if(array[Array] != 0){
                        System.out.println("Esta null"+ z);
                    }
                } */
                    if(yes){
                         System.out.println("Si esta "+ z);
                    } else {
                        System.out.println("No esta "+ z);
                    }
    }
}