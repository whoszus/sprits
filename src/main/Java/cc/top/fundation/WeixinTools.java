package cc.top.fundation;

import cc.top.model.webchat.entity.WebchatClient;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeixinTools {
	
	public static WebchatClient  getUserInformationFromWeixin(HttpServletRequest request, HttpServletResponse response,
													   String appid, String secret) throws ServletException, IOException {

		WebchatClient webchatClient = new WebchatClient();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String strurl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+secret+"&code="+request.getParameter("code")+"&grant_type=authorization_code";
		String str = getReader(strurl);
		System.out.println("str============"+str);
		
		
		System.out.println("str1:"+str);
		
		/**
		 * {
		 *	   "access_token":"ACCESS_TOKEN",
		 *	   "expires_in":7200,
		 *	   "refresh_token":"REFRESH_TOKEN",
		 *	   "openid":"OPENID",
		 *	   "scope":"SCOPE"
		 *	}
		 *返回的json 解析出 access_token 和 openid
		 */
		String accessToken = "";
		String openid = "";
		Pattern p = Pattern.compile("\"access_token\":\"(.*)\",\"expires_in\":");  
		Matcher m = p.matcher(str);
		if(m.find()){  
			accessToken = m.group(1);
		}
		Pattern p2 = Pattern.compile("\"openid\":\"(.*)\",\"scope\":");  
		Matcher m2 = p2.matcher(str);
		if(m2.find()){  
			openid = m2.group(1);
		}
		String strurl2 = "https://api.weixin.qq.com/sns/userinfo?access_token="+accessToken+"&openid="+openid+"&lang=zh_CN";
		/**
		 * 用户信息
		 * {
		 *	   "openid":" OPENID",
		 *	   "nickname": NICKNAME,
		 *	   "sex":"1",
		 *	   "province":"PROVINCE"
		 *	   "city":"CITY",
		 *	   "country":"COUNTRY",
		 *	    "headimgurl":    "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/46", 
		 *		"privilege":[
		 *		"PRIVILEGE1"
		 *		"PRIVILEGE2"
		 *	    ]
		 *	    "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
		 *	}
		 */
		String str2 = getReader(strurl2);
		
		Pattern errP = Pattern.compile("\"errcode\":(.*),");  
		Matcher errM = p.matcher(str2);
		//判断 是否错误
		if(errM.find()){
			accessToken = m.group(1);
		}else{
			String nickname = null;
			String sex = null;
			String province = null;
			String city = null;
			String country = null;
			String headimgurl = null;
			Pattern nicknamep = Pattern.compile("\"nickname\":\"(.*)\",\"sex\"");  
			Matcher nicknamem = nicknamep.matcher(str2);
			if(nicknamem.find()){  
				nickname = nicknamem.group(1);
			}
			Pattern headimgurlp = Pattern.compile("\"headimgurl\":\"(.*)\",");  
			Matcher headimgurlm = headimgurlp.matcher(str2);
			if(headimgurlm.find()){  
				headimgurl = headimgurlm.group(1);
			}
			
			//测试代码
			if(headimgurl!=null&&!headimgurl.trim().equalsIgnoreCase("")){
			    headimgurl = headimgurl.replaceAll("\\\\","");
			}
			
			if(nickname!=null){
				nickname = nickname.trim();
			}

			webchatClient.setOpenid(openid);
			webchatClient.setNickname(nickname);
			webchatClient.setHeadimgurl(headimgurl);

		}
		return webchatClient;
	}
	
	//获取微信公众号access_token值
	public static String  getAccessToken(HttpServletRequest request, HttpServletResponse response,
										 String appid, String secret) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String strurl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret;
		String str = getReader(strurl);
		/**
		 * {
		 *	   "access_token":"ACCESS_TOKEN",
		 *	   "expires_in":7200,
		 *	   "refresh_token":"REFRESH_TOKEN",
		 *	   "openid":"OPENID",
		 *	   "scope":"SCOPE"
		 *	}
		 *返回的json 解析出 access_token 和 openid
		 */
		String accessToken = "";
		Pattern p = Pattern.compile("\"access_token\":\"(.*)\",\"expires_in\":");  
		Matcher m = p.matcher(str);
		if(m.find()){  
			accessToken = m.group(1);
		}
		return accessToken;
	}
	
	 /**
	   * 获取媒体文件
	   * @param accessToken 接口访问凭证
	   * @param mediaId 媒体文件id
	   * @param path 文件在服务器上的存储路径
	   * */
	  public static String downloadMedia(String accessToken, String mediaId, String path) {
	    File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		if (!dir.canWrite()) {
			dir.setWritable(true);
		}
	    String filePath = null;
	    String fileName = null;
	    // 拼接请求地址
	    String requestUrl = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token="+accessToken+"&media_id="+mediaId;

	     /* HTTP/1.1 200 OK
	     * Connection: close
	     * Content-Type: image/jpeg 
	     * Content-disposition: attachment; filename="MEDIA_ID.jpg"
	     * Cache-Control: no-cache, must-revalidate
	     *  Content-Length: 339721
	     * curl -G "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID"
	     */
	    System.out.println("requestUrl==="+requestUrl);
	    try {
	      URL url = new URL(requestUrl);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setDoInput(true);
	      conn.setRequestMethod("GET");
	      // 根据内容类型获取扩展名
	      fileName = getFileEndWitsh(conn.getHeaderField("Content-Type"));
	      // 将mediaId作为文件名
	      filePath = path + mediaId + fileName;

	      BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
	      FileOutputStream fos = new FileOutputStream(new File(filePath));
	      byte[] buf = new byte[8096];
	      int size = 0;
	      while ((size = bis.read(buf)) != -1)
	        fos.write(buf, 0, size);
	      fos.close();
	      bis.close();

	      conn.disconnect();
	      String info = String.format("下载媒体文件成功，filePath=" + filePath);
	      System.out.println(info);
	    } catch (Exception e) {
	      filePath = null;
	      String error = String.format("下载媒体文件失败：%s", e);
	      System.out.println(error);
	    }
	    //返回文件名  eg:ymcEgKgnWK4l-mFaaT_ssk5UaqtMvo4Jv9u8Jd-YTfkxeRdxea3629AE9jj6O4JC.jpg
	    return mediaId+fileName;
	  }
	  
	/**
	 * 通过连接获取返回流放入String中
	 * @param strurl 
	 * @return
	 */
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
	
	/**
	 * 根据内容类型判断文件扩展名
	 * 
	 * @param contentType 内容类型
	 * @return
	 */
	public static String getFileEndWitsh(String contentType) {
		String fileEndWitsh = "";
		if ("image/jpeg".equals(contentType))
			fileEndWitsh = ".jpg";
		else if ("audio/mpeg".equals(contentType))
			fileEndWitsh = ".mp3";
		else if ("audio/amr".equals(contentType))
			fileEndWitsh = ".amr";
		else if ("video/mp4".equals(contentType))
			fileEndWitsh = ".mp4";
		else if ("video/mpeg4".equals(contentType))
			fileEndWitsh = ".mp4";
		return fileEndWitsh;
	}
}
