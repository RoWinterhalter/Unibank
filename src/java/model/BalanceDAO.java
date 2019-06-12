package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class BalanceDAO {
    
    URL url;
    public boolean update(String login, String valor){
        
        try {
            //Definindo a URL de atualizacao de saldo que conectaremos.
            url = new URL("http://mancunian-topside.000webhostapp.com/update_balance.php");
            //Inserindo os parametros que iremos atualizar pelo webservice
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("login", login);
            params.put("saldo", valor);
            //Montando a requisicao post.
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0) {
                    postData.append('&');
                }
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");
            //Conectando na URL para enviar o post.
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
            //Lendo a resposta do webservice
            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            
            for (int c; (c = in.read()) >= 0;) {
                sb.append((char) c);
            }
            String response = sb.toString();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
