package model;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDAO {    
    public User loginUser(String login) throws MalformedURLException{
        //Declaracao da model e resposta do webservice.
        StringBuilder resposta = new StringBuilder();
        User user = null;
        
        try {
            //Instanciando um objecto URL que utilizaremos para conectar no webservice.
            URL url;
            url = new URL("http://mancunian-topside.000webhostapp.com/all_info.php?login="+login);
            //Fazendo a conexao GET para buscar o login.
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("charset", "UTF-8");
            conn.setConnectTimeout(10000);
            conn.connect();
            //Lendo a resposta do webservice
            Scanner scanner = new Scanner(url.openStream());
            
            while (scanner.hasNext()) {
                resposta.append(scanner.nextLine());
            }
            //Utilizando a biblioteca Gson para parsear de JSON para nossa model.
            //Obs: caso esteja vermelho a linha abaixo significa que no seu netbeans nao foi importado
            //a biblioteca do GSON. Porem os JARs estão na raiz do projeto, por favor, crie a biblioteca
            //Gson importando os jars novamente, pois o netbeans perde essa configuração.
            user = new Gson().fromJson(resposta.toString(), User.class);
            //Retornando o usuario pego em JSON para a controller.
            return user;
        } catch (ProtocolException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
