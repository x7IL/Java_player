import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.*;

public class apiwiwi {
    public static void main(String [] args) throws IOException {
        String recherche = "qu'est-ce qu'on".replace(" ","+");
        //https://www.themoviedb.org/search?language=fr&query=harry
        URL url = new URL("https://api.themoviedb.org/3/search/movie?api_key=f3d7678cf05f1b8ce1d237f960b98786&language=fr&query=avengers");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));

        //https://api.themoviedb.org/3/movie/551?api_key=f3d7678cf05f1b8ce1d237f960b98786
        //https://api.themoviedb.org/3/search/movie?api_key=f3d7678cf05f1b8ce1d237f960b98786&query=the+avengers
        //https://api.themoviedb.org/3/search/movie?api_key=f3d7678cf05f1b8ce1d237f960b98786&language=pt-FR&query=the+avengers

        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            //System.out.println(output);
            for(int i = 0 ; i < output.length();i++){
                if(output.charAt(i)=='{'){
                    System.out.println();
                }
                else {
                    System.out.print(output.charAt(i));
                }
            }
        }
    }
}
