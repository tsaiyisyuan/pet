package com.tw.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tw.dao.PetDao;
import com.tw.vo.PetBean;

@Controller
public class HelloController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PetDao petDao;
	private PetBean petBean;

	@RequestMapping("/")
	public String petProduct() throws Exception {
		return "PetProductsList"; // !!請自行修正：剛才建立的HTML檔案名稱
	}

	@RequestMapping("/PetProductsAll")
	public String petProductsAll(Model model) throws Exception {
		// PetDao petDao = new PetDao();
		petDao.createConn();
		// logger.info("conn done");
		List<PetBean> pbs = petDao.queryAll();
		// logger.info(pbs.toString());
		model.addAttribute("pbs", pbs); //
		petDao.closeConn();
		return "PetProductsAll"; // !!請自行修正：剛才建立的HTML檔案名稱
	}

	@RequestMapping("/PetProductsQuery")
	public String PetProductsQuery() throws Exception {
		return "PetProductsQuery"; // !!請自行修正：剛才建立的HTML檔案名稱
	}

	@RequestMapping("/PetProductsQueryId")
	public String PetProductQueryId(HttpServletRequest request, Model model) throws Exception {

		petDao.createConn();
		String productId = request.getParameter("productId");
		petBean.setProductId(Integer.parseInt(productId));
		petDao.queryDBId(petBean);
		petDao.closeConn();
		return "PetProductsQueryId"; // !!請自行修正：剛才建立的HTML檔案名稱
	}

	@RequestMapping("/test")
	public String index() {
		return "hello spring boot!";
	}

}
