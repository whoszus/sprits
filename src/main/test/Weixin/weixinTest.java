package Weixin;

import cc.top.model.TestModel.entity.User;
import com.google.gson.Gson;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Zus on 3/29/16.
 */
public class weixinTest {
    @Test
    public void testgetReader() throws Exception {
        String url = "http://localhost:8080/user/getUser?id=1";
        String json = getReader(url);
        System.out.println(json);
        Gson gson = new Gson();
        User user  = gson.fromJson(json,User.class);
        System.out.println(user.getPassword());


    }


    private static String getReader(String strurl){
        String str = null;
        try {
            URL url = new URL(strurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "text/xml;charset=utf-8");
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            String judgement = "";
            str = "";
            while((judgement=br.readLine())!=null){
                str += judgement;
            }
        } catch (Exception e) {
        }
        return str;
    }
}
