import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.*;
import java.util.Arrays;

public class apiwiwi {



    public static void main(String [] args) throws IOException {
        //https://api.themoviedb.org/3/movie/550?api_key=f3d7678cf05f1b8ce1d237f960b98786
        //https://api.themoviedb.org/3/search/movie?api_key=f3d7678cf05f1b8ce1d237f960b98786&query=the+avengers
        URL url = new URL("https://api.themoviedb.org/3/search/movie?api_key=f3d7678cf05f1b8ce1d237f960b98786&query=alice");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));

        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            //System.out.println(Arrays.toString(output.split("},\\{")));
            String [] tab = (output.split("},\\{"));
            for(int i = 0 ; i < tab.length ; i++){
                System.out.println(tab[i]);
            }
            /*
            for(int i = 0 ; i < output.length();i++){
                if(output.charAt(i)==','){
                    System.out.println();
                }
                else {
                    System.out.print(output.charAt(i));
                }
            }*/
        }
    }
}
