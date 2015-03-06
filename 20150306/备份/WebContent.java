package webContent;

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
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WebContent {
	public static void main(String[] args)
	{
		try
		{
			String urlName;
			if(args.length>0) urlName = args[0];
//			else urlName = "http://baidu.com";
//			else urlName = "http://www.tuicool.com/assets/application-e24a1938a0be681881c7f219301f0961.css";
//			else urlName = "http://www.tuicool.com/assets/application-750e7e45d44953caf9148dbf5ba0b752.js";
//			else urlName = "https://django-chinese-docs.readthedocs.org/en/latest/intro/tutorial01.html";
//			else urlName = "http://www.jb51.net/article/57203.htm";
//			else urlName = "http://tomfish88.iteye.com/";
//			else urlName = "http://www.baidu.com/s?wd=java���汣��html&pn=0&oq=java���汣��html&ie=utf-8&rsv_pq=dc9bccde00000aef&rsv_t=9ede1Xt3efpyk8XPporisaNFhr6f4M8JJRZPVUCRLen1vmvUFDVhdyBBKGk&f=8&rsv_bp=1&tn=baidu";
			else urlName = "http://outofmemory.cn/code-snippet/2332/java-usage-BufferedInputStream-duqu-wenbenwenjian";
			//����һ��url����
			URL url = new URL(urlName);
			//��������tcp����
			HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
			//��������
			//�޸�ͷ������ͷ����Ϣ��αװ�������
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			
			//��ʼ��������
			InputStream is = null;
			//������������Ϊ��ȡ��ҳ�õ�����Ϣ��
			is = connection.getInputStream();
			//bis�ǻ�����������Ϊconnection.getInputStream()�ṩ���幦�ܣ�����������뻺�����С�
			BufferedInputStream bis = new BufferedInputStream(is);
			
			//ֱ�ӽ���ҳ�����ֽ����ķ�ʽ���浽�ļ���
			//������Ϊ�ֽ������ַ���֮���ת�������µ���������
			//�ο�������ҳ��http://www.iteye.com/topic/1106176
			//�½�һ���ֽ�����
			byte bytes[] = new byte[1024 * 1000];
			int index = 0;
			
			//inputStream.read(b,off,len)
			//b    - �������ݵĻ�����
			//off  - ���䴦д�����ݵ�����b�ĳ�ʼƫ����
			//len  - Ҫ��ȡ������ֽ���             
			int count = bis.read(bytes, index, 1024 * 100);
			//����ﵽ��ĩβ�����������ݣ�����-1.�����������count�Ƕ��뻺������������
			while (count != -1) {
			index += count;
			count = bis.read(bytes, index, 1);
			}
			//����Ҫд����ļ�·��
			String filePath = "D:/web1.htm";
			//����һ���ַ����͵Ĵ�ӡ�����
			PrintWriter pw  =null;
			//����һ���ļ������
			FileOutputStream fos = new FileOutputStream(filePath);
			//������һ����FileOutputStreamת�����ֽ���
			//OutputStreamWriter����Writer�����࣬��������ַ�����Ϊ�ֽ���������һ���ַ�������������Ϊ�ֽ����������
			//InputStreamReader����Reader�����࣬��������ֽ�����Ϊ�ַ���������һ���ֽ�������������Ϊ�ַ������������
			//������ļ�����Ϊ��
			//���ڴ��е��ַ�������Ҫͨ��OutputStreamWriter��Ϊ�ֽ������ܱ������ļ���
			//��ȡʱ��Ҫ��������ֽ���ͨ��InputStreamReader��Ϊ�ַ���
			OutputStreamWriter writer = new OutputStreamWriter(fos);
			//
			pw = new PrintWriter(writer);
			System.out.println(index);
			fos.write(bytes, 0, index);
			is.close();
			bis.close();
			fos.close();
//			����ķ����Ǳ����HTML��ҳ��������룬������ҳ��http://tomfish88.iteye.com/
//			BufferedReader bReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//			   StringBuffer sb = new StringBuffer();
//			   String rLine = null;
//			   String tmp_rLine = null;
//			   while ( (rLine = bReader.readLine()) != null)
//			   {
//			    tmp_rLine = rLine;
//			    int str_len = tmp_rLine.length();
//			    if (str_len > 0)
//			    {
//			     sb.append("\n" + tmp_rLine);
//			     pw.println(tmp_rLine);
//			     pw.flush();
//			    
//			    }
//			    tmp_rLine = null;
//			   }
//			  pw.close();
			
			//�õ�ͷ����Ϣ
			Map<String , List<String>> headers = connection.getHeaderFields();
			//���ռ�ֵ�Եķ�ʽ���ͷ����Ϣ
			for(Map.Entry<String,List<String>> entry:headers.entrySet())
			{
				String key = entry.getKey();
				for(String value:entry.getValue())
					System.out.println(key + ": "+value);
			}
			//���contenttype
			System.out.println("getContentType: " + connection.getContentType());

		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}	

	}

//if(args.length>2)
//{
//	String username = args[1];
//	String password = args[2];
//}


