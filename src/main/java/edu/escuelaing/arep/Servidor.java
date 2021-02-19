package edu.escuelaing.arep;

import static spark.Spark.get;
import static spark.Spark.port;

import spark.Request;
import spark.Response;

import com.google.gson.Gson;

public class Servidor {


    public static void main( String[] args )  {
        port(getPort());
        Gson gson = new Gson();
        get("/facadetrig",(req,res) -> {
            String val = req.queryParams("valor");
            String opera = req.queryParams("operacion");
            //llamadoApp
            Cliente cliente = null;
            return gson.toJson(cliente.resultados(req,res));
        });
    }


    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
