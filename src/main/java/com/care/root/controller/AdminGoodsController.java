package com.care.root.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.adminservice.AdminService;
import com.care.root.goodsservice.GoodsService;
import com.care.root.goodsvo.GoodsVO;
import com.care.root.orderListVO.OrderListVO;
import com.care.root.ordervo.OrderVO;
import com.care.root.util.UploadFileUtils;

@Controller
@RequestMapping("admin")
public class AdminGoodsController {
	@Autowired GoodsService goodsService;
	@Autowired AdminService adminService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	//상품 등록 페이지
	@RequestMapping("goodsRegister")
	public String goodsRegister() {
		return "admin/goodsRegister";
	}
	
	//상품 등록
	@RequestMapping(value ="/goodsRegister",method=RequestMethod.POST)
	public String goodsRegister(GoodsVO goodsVO,MultipartFile file) throws Exception{
		 String imgUploadPath = uploadPath + File.separator + "imgUpload";  // 이미지를 업로드할 폴더를 설정 = /uploadPath/imgUpload
		 String ymdPath = UploadFileUtils.calcPath(imgUploadPath);  // 위의 폴더를 기준으로 연월일 폴더를 생성
		 String fileName = null;  // 기본 경로와 별개로 작성되는 경로 + 파일이름
		   
		 if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		  // 파일 인풋박스에 첨부된 파일이 없다면(=첨부된 파일이 이름이 없다면)
		  
		  fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);

		  // goodsImage1에 원본 파일 경로 + 파일명 저장
		  goodsVO.setGoodsImage1(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		  // goodsThumbImage에 썸네일 파일 경로 + 썸네일 파일명 저장
		  goodsVO.setGoodsThumbImage(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		  
		 } else {  // 첨부된 파일이 없으면
		  fileName = File.separator + "images" + File.separator + "none.png";
		  // 미리 준비된 none.png파일을 대신 출력함
		  
		  goodsVO.setGoodsImage1(fileName);
		  goodsVO.setGoodsThumbImage(fileName);
		 }
		
		goodsService.goodsRegister(goodsVO);
		return "redirect:/admin/index";
	}
	
	//상품 목록
	@RequestMapping("goodsList")
	public String goodsList(Model model){
		List<GoodsVO> list = goodsService.goodsList();
		model.addAttribute("list",list);
		return "admin/goodsList";
	}

	//상품 조회
	@RequestMapping("goodsView")
	public String goodsView(@RequestParam("n") int goodsNum, Model model) {
		GoodsVO goodsVO = goodsService.goodsView(goodsNum);
		model.addAttribute("goods",goodsVO);
		return "admin/goodsView";
	}
	
	//상품 수정 페이지
	@RequestMapping(value="/goodsModify", method = RequestMethod.GET)
	public String goodsModify(@RequestParam("n") int goodsNum, Model model) {
		GoodsVO goodsVO = goodsService.goodsView(goodsNum);
		model.addAttribute("goods",goodsVO);
		return "admin/goodsModify";
	}
	
	//상품 수정
	@RequestMapping(value = "/postgoodsModify", method = RequestMethod.POST)
	public String postGoodsModify1(GoodsVO goodsVO,MultipartFile file,HttpServletRequest req) throws IOException, Exception {
		// 새로운 파일이 등록되었는지 확인
		 if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		  // 기존 파일을 삭제
		  new File(uploadPath + req.getParameter("goodsImage1")).delete();
		  new File(uploadPath + req.getParameter("goodsThumbImage")).delete();
		  
		  // 새로 첨부한 파일을 등록
		  String imgUploadPath = uploadPath + File.separator + "imgUpload";
		  String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		  String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		  
		  goodsVO.setGoodsImage1(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		  goodsVO.setGoodsThumbImage(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		  
		 } else {  // 새로운 파일이 등록되지 않았다면
		  // 기존 이미지를 그대로 사용
			 goodsVO.setGoodsImage1(req.getParameter("goodsImage1"));
			 goodsVO.setGoodsThumbImage(req.getParameter("goodsThumbImage"));
		 }
		goodsService.goodsModify(goodsVO);
		return "redirect:/admin/goodsList";
	}
	
	//상품 삭제
	@RequestMapping(value = "/goodsDelete", method = RequestMethod.POST)
	public String goodsDelte(@RequestParam("n") int goodsNum) throws IOException {
		goodsService.goodsDelete(goodsNum);
		return "redirect:/admin/goodsList";
		
	}

	// ck 에디터에서 파일 업로드
	@RequestMapping(value = "/ckUpload", method = RequestMethod.POST)
	public void postCKEditorImgUpload(HttpServletRequest req,HttpServletResponse res,
	          @RequestParam MultipartFile upload) throws Exception {
	 
	 // 랜덤 문자 생성
	 UUID uid = UUID.randomUUID();
	 
	 OutputStream out = null;
	 PrintWriter printWriter = null;
	   
	 // 인코딩
	 res.setCharacterEncoding("utf-8");
	 res.setContentType("text/html;charset=utf-8");

	 try {

		 String fileName = upload.getOriginalFilename();  // 파일 이름 가져오기
		 byte[] bytes = upload.getBytes();

		 // 업로드 경로
		 String ckUploadPath = uploadPath + File.separator + "ckUpload" + File.separator + uid + "_" + fileName;

		 out = new FileOutputStream(new File(ckUploadPath));
		 out.write(bytes);
		 out.flush();  // out에 저장된 데이터를 전송하고 초기화

		 String callback = req.getParameter("CKEditorFuncNum");
		 printWriter = res.getWriter();
		 String fileUrl = "/ckUpload/" + uid + "_" + fileName;  // 작성화면

		 // 업로드시 메시지 출력
		 printWriter.println("<script type='text/javascript'>"
				 + "window.parent.CKEDITOR.tools.callFunction("
				 + callback+",'"+ fileUrl+"','이미지를 업로드하였습니다.')"
				 +"</script>");

		 printWriter.flush();

	 } catch (IOException e) { e.printStackTrace();
	 } finally {
		 try {
			 if(out != null) { out.close(); }
			 if(printWriter != null) { printWriter.close(); }
		 } catch(IOException e) { e.printStackTrace(); }
	 }

	 return; 
	}

	// 주문 목록
	@RequestMapping("orderList")
	public void getOrderList(Model model) throws Exception {

		List<OrderVO> orderList = adminService.orderList();

		model.addAttribute("orderList", orderList);
	}

	// 주문 상세 목록
	@RequestMapping("orderView")
	public void getOrderList(@RequestParam("n") String orderId,
			OrderVO orderVO, Model model) throws Exception {

		orderVO.setOrderId(orderId);  
		List<OrderListVO> orderView = adminService.orderView(orderVO);

		model.addAttribute("orderView", orderView);
	}

	// 주문 상세 목록 - 상태 변경
	@RequestMapping(value = "/orderView", method = RequestMethod.POST)
	public String delivery(OrderVO orderVO) throws Exception {

		adminService.delivery(orderVO);
		System.out.println("주문상세목록 테스트");
		
		//상품 수량 조절
		List<OrderListVO> orderView = adminService.orderView(orderVO); 

		GoodsVO goodsVO = new GoodsVO();

		for(OrderListVO i : orderView) {
			goodsVO.setGoodsNum(i.getGoodsNum());
			goodsVO.setGoodsStock(i.getCartStock());
			adminService.changeStock(goodsVO);
		}
		
		return "redirect:/admin/orderView?n=" + orderVO.getOrderId();
	}
	
	

}	
