
public class Main {
    public static void main(String[] args) {
        substract(10, 15, new CalculListener() {

            @Override
            public void onPositiveResult() {
                System.out.println("C'est bien !");
            }

            @Override
            public void onNegativeResult() {
                System.out.println("C'est pas bien !");
            }
            
        });
    }

    private static void substract(int a, int b, CalculListener listener) {

        int result = a - b;
        System.out.println("Le résultat de cette soustraction est : " + result);

        if(result > 0) {
            System.out.println("Le résultat est positif");
            listener.onPositiveResult();
        } else {
            System.out.println("Le résultat est négatif");
            listener.onNegativeResult();
        }
    }
}
