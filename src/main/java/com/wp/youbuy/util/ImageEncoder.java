package com.wp.youbuy.util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Component;

/**
 * 
 * @author swiftwen
 * @date 2019年1月22日 下午7:22:50
 */
@Component
public class ImageEncoder {

	private  String Base64Encode(String imageFileUrl) {

		InputStream in = null;
		byte[] data = null;
		try {
			in = new FileInputStream(imageFileUrl);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			System.out.println("batch generate contract,get image error" + e);
			return "";
		}
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		return encoder.encode(data);
	}

	/**
	 * 通过图片的url获取图片的base64字符串
	 * 
	 * @param imgUrl
	 *            图片url
	 * @return 返回图片base64的字符串
	 */
	public  String image2Base64(String imgUrl) {

		URL url = null;

		InputStream is = null;

		ByteArrayOutputStream outStream = null;

		HttpURLConnection httpUrl = null;

		try {

			url = new URL(imgUrl);

			httpUrl = (HttpURLConnection) url.openConnection();

			httpUrl.connect();

			httpUrl.getInputStream();

			is = httpUrl.getInputStream();

			outStream = new ByteArrayOutputStream();

			// 创建一个Buffer字符串

			byte[] buffer = new byte[1024];

			// 每次读取的字符串长度，如果为-1，代表全部读取完毕

			int len = 0;

			// 使用一个输入流从buffer里把数据读取出来

			while ((len = is.read(buffer)) != -1) {

				// 用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度

				outStream.write(buffer, 0, len);

			}

			// 对字节数组Base64编码

			sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
			return encoder.encode(outStream.toByteArray());

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (is != null)
			{
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outStream != null)
			{
				try {
					outStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			if (httpUrl != null)
			{
				httpUrl.disconnect();
			}
		}

		return imgUrl;

	}

	public static void main(String[] args) {
		String url = "http://mmbiz.qpic.cn/mmbiz_jpg/NEfOUO2fibNsus8bh4lib38MIwmUQl8qTeCt9zz5onHq7YvPgbPfG3uPKX5icfvYXwrVbzR0H9XW2TxtZBRu8chZg/0";

		System.out.println(new ImageEncoder().image2Base64(url));
	}
}
