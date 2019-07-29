package com.wp.youbuy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wp.youbuy.common.resp.BaseResponse;
import com.wp.youbuy.service.AlimamaService;
import com.wp.youbuy.util.ResponseUtil;

import io.swagger.annotations.ApiOperation;
/**
 * 淘宝客联盟
 * @author swiftwen
 * @date 2019年7月29日 上午9:50:33
 */
@RestController
@RequestMapping(value = "/alimama")
public class AlimamaController extends BaseController {

	private static final Logger log= LoggerFactory.getLogger(AlimamaController.class);

	@Autowired
	private AlimamaService alimamaService;
	
	@ApiOperation(value = "test" ,  notes="test")
	@PostMapping(value = "/test")
	public BaseResponse<Boolean> test(HttpServletRequest request, HttpServletResponse response) {
		log.debug("test .....");
		return ResponseUtil.buildResp(true);
	}
}
