package cn.zjy.demo.controller.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ZJY
 * @ClassName: BaseController
 * @Description: BaseController
 * @date 2018/11/15 15:56
 */
public class BaseController {

	@Autowired
	protected HttpServletRequest request;

	protected ThreadLocal<String> token = new ThreadLocal<>();

	/**
	 * 会在进入其他方法之前调用这个init方法
	 */
	@ModelAttribute
	public void init() {
		token.set(request.getHeader("token"));
	}
}
