package util;

public class Util {

    public boolean validateCpf(String cpf) {
        // Delcaracao das variaveis.
        int s1 = 0;
        int s2 = 0;
        int num = 0;
        int resto = 0;
        int j = 0;
        int k = 0;

        // Validando o cpf digitado esta dentro dos requisitos basicos.
        cpf = cpf.replace(".", "");
        String regex = "[^0-9]+";
        cpf = cpf.replaceAll(regex, "");
        if (cpf.equals("00000000000")
                || cpf.equals("11111111111")
                || cpf.equals("22222222222") || cpf.equals("33333333333")
                || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777")
                || cpf.equals("88888888888") || cpf.equals("99999999999")
                || (cpf.length() != 11)) {
            return false;
        } else {
            // Validando o cpf.
            // Primeiro digito.
            int multiplicar = 10;
            for (int i = 0; i < 9; i++) {
                num = (int) (cpf.charAt(i) - 48); // converte string para numero
                s1 += num * multiplicar; // Aqui é feito o a b c .d e f . g h i
                multiplicar--; // x10 x9 x8 x7 x6 x5 x4 x3 x2
            }
            resto = s1 % 11;
            if (resto == 0 || resto == 1) {
                j = 0;
            } else if (resto == 2 || resto == 3 || resto == 4 || resto == 5
                    || resto == 6 || resto == 7 || resto == 8 || resto == 9
                    || resto == 10) {
                j = 11 - resto;
            }
            // Segundo digito
            multiplicar = 11;
            for (int i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - 48); // converte string para numero
                s2 += num * multiplicar; // Aqui é feito o a b c .d e f . g h i j

                multiplicar--; // x11 x10 x9 x8 x7 x6 x5 x4 x3 x2
            }
            resto = s2 % 11;
            if (resto == 0 || resto == 1) {
                k = 0;
            } else if (resto == 2 || resto == 3 || resto == 4 || resto == 5
                    || resto == 6 || resto == 7 || resto == 8 || resto == 9
                    || resto == 10) {
                k = 11 - resto;
            }
            if (j == (int) (cpf.charAt(9) - 48) && (k == (int) (cpf.charAt(10) - 48))) {
                return true;
            } else {
                return false;
            }
        }
    }
}
