package test.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fmcq.util.datautil.DateUtil;
import com.fmcq.util.datautil.StringUtil;

public class HttpRequest {
	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("Content-Type", "text/html; charset=UTF-8");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.write(param);
			// flush输出流的缓冲
			out.flush();
			conn.connect();// 连接
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		//使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	public static String post(String htmlurl, String params, String charset) throws Exception {
		URL url = new URL(htmlurl);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		http.setRequestMethod("POST");
		http.setConnectTimeout(3000);
		http.setInstanceFollowRedirects(true);
		http.setRequestProperty("Content-Type", "text/html; charset=UTF-8");
		http.setDefaultUseCaches(false);
		//打算使用 URL 连接进行输出
		http.setDoOutput(true);
		//		OutputStreamWriter outr = new OutputStreamWriter(http.getOutputStream());
		//		outr.write(params.toString().toCharArray(), 0, params.toString().length());
		//		outr.flush();
		//		outr.close();
		PrintWriter out = new PrintWriter(http.getOutputStream());
		out.write(params);// 传入参数
		out.close();
		http.connect();// 连接
		InputStream in = http.getInputStream();// 返回流
		StringBuffer sb = new StringBuffer();
		byte[] inBuf = new byte[4096];
		int len = inBuf.length;
		int ret = 0;
		while ((ret = in.read(inBuf, 0, len)) > 0) {
			String rs = new String(new String(inBuf, 0, ret, charset).getBytes());
			sb.append(rs);
		}
		in.close();
		return sb.toString();
	}

	public static void main(String[] args) throws InterruptedException {
		//发送 GET 请求
		//		String s = HttpRequest.sendGet("http://127.0.0.1:8080/ycode/mgr/interface/list.do", "{\"Req\":{\"Service\":{\"RuleId\":\"B5629530-9B69-4668-A02B-9B0B1B256994\",\"StartDay\":\"7\",\"StartTime\":\"07:00\",\"EndDay\":\"0\",\"EndTime\":\"11:00\",\"DrawPoint\":\"门诊\",\"AmtakeNum\":\"07:00\",\"PmtakeNum\":\"20:00\",\"BreachDay\":\"2\",\"BreachTimes\":\"3\",\"State\":1},\"TransactionCode\":2003}}");
		//		System.out.println(s);

		//Post Request
		for (int i = 0; i < 1; i++) {
			Thread.sleep(10);
			try {
				//客户端请求报文
				String requestParameter = "{\"head\": {\"Channel\": \"Web\",\"Action\": \"CWA001\"},"
						+ "\"body\": {\"Phone\": \"13905920113\",\"FlowNum\": \"50\",\"EffType\": \"1\","
						+ "\"DealID\": \"3831001001\",\"CallbackURL\": \"http://127.0.0.1:8080/ycode/flow/interface/test.do\"}}";
				//			"{\"Req\":{\"Service\":{\"RuleId\":\"B5629530-9B69-4668-A02B-9B0B1B256994\",\"StartDay\":\"7\",\"StartTime\":\"07:00\",\"EndDay\":\"0\",\"EndTime\":\"11:00\",\"DrawPoint\":\"门诊\",\"AmtakeNum\":\"07:00\",\"PmtakeNum\":\"20:00\",\"BreachDay\":\"2\",\"BreachTimes\":\"3\",\"State\":1},\"TransactionCode\":2003}}","utf-8");
				//测试数据加密  "3831001001"
				//			String date = DateUtil.dateToStr(new Date());
				
				System.err.println(requestParameter);
				//报文数据在指定模型下加密 防止传送过程中泄漏
				requestParameter = StringUtil.encodeASE(requestParameter, "1234567899876543");
				//http://127.0.0.1:8080/tdfz2/flow/interface/robot.do这个为模块请求地址，当然有做鉴权和权限控制
				String s = HttpRequest.post("http://127.0.0.1:8080/tdfz2/flow/interface/robot.do", requestParameter, "utf-8");
				//将返回的数据交给flex端
				System.out.println("请求返回：" + s);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		//发送 POST 请求
		//				String sr = HttpRequest.sendPost("http://127.0.0.1:8080/ycode/mgr/interface/list.do", "");
		//				System.out.println(sr);

	}
}