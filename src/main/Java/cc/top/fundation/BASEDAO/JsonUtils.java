package cc.top.fundation.BASEDAO;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Created by Lr on 2016/4/13/013.
 */
public class JsonUtils {

    public static void writeJson(String jsonData,HttpServletRequest request,HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        String callbackFunName =request.getParameter("callback");//得到js函数名称
        try {
            response.getWriter().write(callbackFunName + "("+jsonData+")");
        } catch (IOException e) {
            System.out.println("write to client exception with " + jsonData);
        }
    }

}
