public class Metedo2 {
    public static void main(String[] args) {
        String dada = "[{\"duracion\":[3,28],\"featuring\":[{\"id\": 1, \"nombre\": \"Taylor Swift\"}, {\"id\": 1, \"nombre\": \"Otro artista\"}],\"nombre\":\"Im That Girl\",\"reproducciones\":86746546},{\"duracion\":[3,30],\"featuring\":null,\"nombre\":\"Cozy\",\"reproducciones\":869213754}]";
        String[]sentecias={"[^\\-dA-Za-z-#-,-/-:0123456789]","duracion:","reproducciones:","nombre:","featuring:","id:"};
        dada= dada.replaceAll(" ", "#"); 
        for (int index = 0; index < sentecias.length; index++) {
            dada= dada.replaceAll(sentecias[index], ""); 
        }
        dada= dada.replaceAll("#", " "); 
        System.out.println(dada);
    }
}
