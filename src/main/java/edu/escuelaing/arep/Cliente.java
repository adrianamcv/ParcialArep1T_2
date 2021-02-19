package edu.escuelaing.arep;
import spark.Request;
import spark.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Cliente {

    public static String resultados(Request req, Response res){
        String num = req.queryParams("valor");
        String operacion = req.queryParams("operacion");
        String rst;

        if (num == null)
            return "No se puede realizar la operación";
        else {
            rst = getCalculadora("https://calculadora-parte1.herokuapp.com/cal?valor="+num+"&operacion="+operacion);
        }
        return rst;
    }
     private static String getCalculadora(String uc){
         StringBuffer rst = new StringBuffer();
         try{
             URL url = new URL(uc);
             HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
             conexion.setRequestMethod("GET");

             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
             String line = bufferedReader.readLine();
             while ((line != null)){
                 rst.append(line);
                 line = bufferedReader.readLine();
             }
             bufferedReader.close();
             return String.valueOf(rst);

         } catch (MalformedURLException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
         return String.valueOf(rst);

     }
}
