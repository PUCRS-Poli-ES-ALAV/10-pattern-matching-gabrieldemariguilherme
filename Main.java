public class Main {

    public static void main(String[] args) {
        contador = new Contador();
        KMP_String_Matching kmp = new KMP_String_Matching(contador);

        contador.reset();
        System.out.println(ocorrenciaString("adadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaabacate", "aca"));
        contador.print("algoritmo search sem Hash");
        contador.reset();
        System.out.println(search("aca", "adadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaabacate" ));
        contador.print("algoritmo search com Hash");
        contador.reset();
        kmp.KMPSearch("aca", "adadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaabacate");
        contador.print("kmpSearch");
        contador.reset();
        System.out.println(ocorrenciaString("adadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaabacate", "aca"));
        contador.print("algoritmo search sem Hash");
        contador.reset();
        System.out.println(search("aca", "adadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaabacate" ));
        contador.print("algoritmo search com Hash");
        kmp.KMPSearch("aca", "adadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaadadadaddadadadadadadadadaabacate");
        contador.print("kmpSearch");
        contador.reset();
    }

    private static Contador contador;
    

    private static int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        long patHash = hash(pat, M);
     
        for (int i = 0; i <= N - M; i++) {
           long txtHash = hash(txt.substring(i, i+M), M);
           if (patHash == txtHash)
            {
                contador.add();
                return i; // ocorrência? colisão?
            }
        }
        return N; // nenhuma ocorrência
     }

     private static long hash(String s, int M) {
        long h = 0;
        for (int j = 0; j < M; j++){
            contador.add();
            h = (h * 26 + s.charAt(j)) % 2147483647;
        }
        return h;
     }


    public static int ocorrenciaString(String s1, String s2) {
        int ocorrencia = 0;
        for(int i =0; i < s1.length(); i++){
            contador.add(); 
            if(s1.charAt(i) == s2.charAt(0)) {
                ocorrencia = i;
                for(int j = 1; j < s2.length(); j++) {
                    contador.add();
                    if(s1.charAt(i+j) != s2.charAt(j)) {
                        break;
                    }
                    if(j == s2.length()-1) {
                        return ocorrencia;
                    }
                }
            }
        }
        return 0;
    }
}