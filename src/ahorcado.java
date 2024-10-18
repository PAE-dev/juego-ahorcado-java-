import java.util.Scanner;

public class ahorcado {
    public static void main(String[] args) throws Exception {
        
        //clase scanner
       Scanner scanner = new Scanner(System.in); 

       //variables
        String palabraSecreta = "payasita";
        int intentosMax= 5;
        int intentos = 0;
        boolean palabraAdivinada= false;

        //arreglo:
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        //bucle de guiones
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
            System.out.print(letrasAdivinadas[i]);
        }

        //bucle para adivinar palabra y solicitar
        while(!palabraAdivinada && intentos<intentosMax){

            System.out.println("palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras) ");
            System.out.println("introduce una letra, por favor");
            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraCorrecta= false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                //estructura control condicional
                if(palabraSecreta.charAt(i) == letra){
                    letrasAdivinadas[i]= letra;
                    letraCorrecta=true;
                }
            }

            if(!letraCorrecta){
                intentos++;
                System.out.println("INCORRECTO, te quedan " + (intentosMax - intentos) + "intentos." );
            }

            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("FELICIDADES, has adivinado la palabra secreta: " + palabraSecreta);                
            }
        }

        if (!palabraAdivinada) {
            System.out.println("que pena te has quedado sin intentos! GAME OVER. ");
        }

        scanner.close();
    }
}
