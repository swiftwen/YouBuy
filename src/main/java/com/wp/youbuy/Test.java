package com.wp.youbuy;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.internal.sign.SignUtils;
import com.taobao.api.internal.util.TaobaoUtils;
import com.taobao.api.request.TbkItemRecommendGetRequest;
import com.taobao.api.response.TbkItemRecommendGetResponse;


public class Test {

	public static void main(String[] args)throws Exception {
		String url = "http://gw.api.taobao.com/router/rest?v=2.0&sign_method=md5&format=json&timestamp=2016-01-01 12:00:00";
		
		String appkey = "27711478";
		String secret = "fbf211cd7042770a79e9e8ac096f7694";
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		TbkItemRecommendGetRequest req = new TbkItemRecommendGetRequest();
		req.setNumIid(11223344L);
		req.setFields("product_id,name,pic_url");
		TbkItemRecommendGetResponse resp = client.execute(req);
		String sign = TaobaoUtils.signTopRequest(req.getTextParams(), "", secret, "md5");
		url = url + "&sign="+sign;
		client.execute(req);
		System.out.println(resp.getBody());
	}
}
