package webContent;
//			else urlName = "http://baidu.com";
//			else urlName = "http://www.tuicool.com/assets/application-e24a1938a0be681881c7f219301f0961.css";
//			else urlName = "http://www.tuicool.com/assets/application-750e7e45d44953caf9148dbf5ba0b752.js";
//else urlName = "http://www.jb51.net/article/57203.htm";
//else urlName = "http://tomfish88.iteye.com/";
//else urlName = "http://www.baidu.com/s?wd=java爬虫保存html&pn=0&oq=java爬虫保存html&ie=utf-8&rsv_pq=dc9bccde00000aef&rsv_t=9ede1Xt3efpyk8XPporisaNFhr6f4M8JJRZPVUCRLen1vmvUFDVhdyBBKGk&f=8&rsv_bp=1&tn=baidu";
//else urlName = "http://outofmemory.cn/code-snippet/2332/java-usage-BufferedInputStream-duqu-wenbenwenjian";
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebContent {
	public static void main(String[] args)
	{
			try
			{
				String urlName;
				if(args.length>0) urlName = args[0];
//				else urlName = "https://django-chinese-docs.readthedocs.org/en/latest/intro/tutorial01.html";	
//				else urlName = "http://www.tuicool.com/assets/application-e24a1938a0be681881c7f219301f0961.css";
//				else urlName = "http://www.tuicool.com/assets/application-750e7e45d44953caf9148dbf5ba0b752.js";
//				else urlName = "http://tomfish88.iteye.com/";
//				else urlName = "file:///D:/123.html";
				else urlName = "http://www.jb51.net/article/57203.htm";
				URL url = new URL(urlName);				
				HttpURLConnection con = (HttpURLConnection) url.openConnection(); 				
				con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");								
				InputStream is = null;			
				is = con.getInputStream();	
				
				String st = savefile(is);

				String type = con.getContentType().substring(0, 8);
				if (type.equals("text/htm") ){
					System.out.println("getContentType: " + con.getContentType());
					}
				else if (type.equals("text/htm") == false){
				System.out.println("getContentType: " + con.getContentType());
				
//				boolean zztype = parseHtmlLable(sb.toString());
				boolean zztype = parseHtmlLable(st);
					if(zztype == true){
						savefile(is);
						System.out.println("这是一个不规范的HTML网页");}
					else
						System.out.println("这才不是一个HTML网页");
				}
				else 
					System.out.println("这不是一个HTML网页");
//				
				
//				boolean type = JudgePageType(con);
//				System.out.print(type);
//				if(type == true)
//				    savefile(is);				
//				//得到头部信息
//				Map<String , List<String>> headers = connection.getHeaderFields();
//				//按照键值对的方式输出头部信息
//				for(Map.Entry<String,List<String>> entry:headers.entrySet())
//				{
//					String key = entry.getKey();
//					for(String value:entry.getValue())
//						System.out.println(key + ": "+value);
//				}
//				//输出contenttype
//				System.out.println("getContentType: " + connection.getContentType());
	
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		
	}	

		public static void JudgePageType(HttpURLConnection con , String sb) throws IOException{
				    
	
			String type = con.getContentType().substring(0, 8);
			if (type.equals("text/htm") ){
				System.out.println("getContentType: " + con.getContentType());
				}
			else if (type.equals("text/htm") == false){
			System.out.println("getContentType: " + con.getContentType());
			
//			boolean zztype = parseHtmlLable(sb.toString());
			boolean zztype = parseHtmlLable(sb);
				if(zztype == true){
					savefile(con.getInputStream());
					System.out.println("这是一个不规范的HTML网页");}
				else
					System.out.println("这才不是一个HTML网页");
			}
			else 
				System.out.println("这不是一个HTML网页");
				 
			}

//	public  static void crwal(InputStream is) throws IOException {
//		//bis是缓冲输入流，为connection.getInputStream()提供缓冲功能，将其分批填入缓冲区中。
//		
//		BufferedInputStream bis = new BufferedInputStream(is);
//		
//		//直接将网页按照字节流的方式保存到文件中
//		//避免因为字节流和字符流之间的转换而导致的乱码问题
//		//参考资料网页：http://www.iteye.com/topic/1106176
//		//新建一个字节数组
//		byte bytes[] = new byte[1024 * 1000];
//		int index = 0;
//		
//		//inputStream.read(b,off,len)
//		//b    - 读入数据的缓冲区
//		//off  - 在其处写入数据的数组b的初始偏移量
//		//len  - 要读取的最大字节数             
//		int count = bis.read(bytes, index, 1024 * 100);
//		//如果达到流末尾，不再有数据，返回-1.否则继续读。count是读入缓冲区的总字数
//		while (count != -1) {
//		index += count;
//		count = bis.read(bytes, index, 1);
//		}
//		
//		String sb = bytes.toString();
//		JudgePageType()
//		
//		String filePath = "D:/web1.htm";
//		//定义一个字符类型的打印输出流
//		PrintWriter pw  =null;
//		//定义一个文件输出流
//		FileOutputStream fos = new FileOutputStream(filePath);
//		//定义了一个将FileOutputStream转换成字节流
//		//OutputStreamWriter：是Writer的子类，将输出的字符流变为字节流，即将一个字符流的输出对象变为字节流输出对象。
//		//InputStreamReader：是Reader的子类，将输入的字节流变为字符流，即将一个字节流的输入对象变为字符流的输入对象。
//		//如果以文件操作为例
//		//则内存中的字符数据需要通过OutputStreamWriter变为字节流才能保存在文件中
//		//读取时需要将读入的字节流通过InputStreamReader变为字符流
//		OutputStreamWriter writer = new OutputStreamWriter(fos);
//		//
//		pw = new PrintWriter(writer);
//		System.out.println(index);
//		fos.write(bytes, 0, index);
//		is.close();
//		bis.close();
//		fos.close();
//		
//		
//		
//	}
	
		public static String savefile(InputStream is) throws IOException{
		
				BufferedReader bReader = new BufferedReader(new InputStreamReader(is));
				BufferedInputStream bis = new BufferedInputStream(is);
				byte bytes[] = new byte[1024 * 1000];
				int index = 0;
				int count = bis.read(bytes, index, 1024 * 100);
				while (count != -1) {
				index += count;
				count = bis.read(bytes, index, 1);
				}	
				String sb = bytes.toString();
				String filePath = "D:/web1.htm";				
				PrintWriter pw  =null;				
				FileOutputStream fos = new FileOutputStream(filePath);				
				OutputStreamWriter writer = new OutputStreamWriter(fos);				
				pw = new PrintWriter(writer);
				System.out.println(index);
				fos.write(bytes, 0, index);
				is.close();
				bis.close();
				fos.close();
				System.out.println(sb.toString());
			    return sb.toString();
			
		}
		
		public static boolean parseHtmlLable(String context) {
		    String regex = "<meta>.*?</meta>";
			Pattern pt = Pattern.compile(regex);
			boolean mt = pt.matcher(context).find();
			
			if (mt == true){
				return true;}
			else
				return false;
			
			}
}

//System.out.println("getContentType: " + con.getContentType());

//String rLine = null;
//while((rLine=bReader1.readLine())!=null){
//	sb.append(rLine);
//	sb.append("/r/n");
//}