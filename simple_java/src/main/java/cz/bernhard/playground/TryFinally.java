package cz.bernhard.playground;


public class TryFinally {

    public static void main(String[] args) {

        System.out.println(returnBoolean());

    }

    private static boolean returnBoolean() {

        // yep try/finally is valid java construction
        try {
            return true; // is returned true...
        }
        finally {
            return false;  // ... or false ?  <----- THE B IS CORRECT THIS METHOD RETURNS FALSE
        }
    }

}
