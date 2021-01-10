package com.spring.admin.goods.controller;

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

import com.spring.admin.goods.service.AdminGoodsService;
import com.spring.admin.goods.vo.AdminGoodsVO;
import com.spring.admin.login.service.AdminLoginService;
import com.spring.common.file.UploadFileUtils;


@Controller
@RequestMapping("admin")
public class AdminGoodsController {
	@Autowired AdminGoodsService adminGoodsService;
	@Autowired AdminLoginService adminService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	//상품 등록 페이지
	@RequestMapping("goodsRegister.do")
	public String goodsRegister() {
		return "admin/goodsRegister";
	}
	
	//상품 등록
	@RequestMapping(value ="/goodsRegister.do",method=RequestMethod.POST)
	public String goodsRegister(AdminGoodsVO adminGoodsVO,MultipartFile file) throws Exception{
//		 String imgUploadPath = uploadPath + File.separator + "imgUpload";  // 이미지를 업로드할 폴더를 설정 = /uploadPath/imgUpload
		 String imgUploadPath = File.separator + "home" +File.separator +"ec2-user" + File.separator + "imgUpload";  // 이미지를 업로드할 폴더를 설정 = /uploadPath/imgUpload
		 String ymdPath = UploadFileUtils.calcPath(imgUploadPath);  // 위의 폴더를 기준으로 연월일 폴더를 생성
		 String fileName = null;  // 기본 경로와 별개로 작성되는 경로 + 파일이름
		   
		 if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		  // 파일 인풋박스에 첨부된 파일이 없다면(=첨부된 파일이 이름이 없다면)
		  
		  fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);

		  // goodsImage1에 원본 파일 경로 + 파일명 저장
		  adminGoodsVO.setGoodsImage1(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		  // goodsThumbImage에 썸네일 파일 경로 + 썸네일 파일명 저장
		  adminGoodsVO.setGoodsThumbImage(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		  
		 } else {  // 첨부된 파일이 없으면
		  fileName = File.separator + "images" + File.separator + "none.png";
		  // 미리 준비된 none.png파일을 대신 출력함
		  
		  adminGoodsVO.setGoodsImage1(fileName);
		  adminGoodsVO.setGoodsThumbImage(fileName);
		 }
		
		adminGoodsService.goodsRegister(adminGoodsVO);
		return "redirect:/admin/index.do";
	}
	
	//상품 목록
	@RequestMapping("goodsList.do")
	public String goodsList(Model model){
		List<AdminGoodsVO> list = adminGoodsService.goodsList();
		model.addAttribute("list",list);
		return "admin/goodsList";
	}

	//상품 조회
	@RequestMapping("goodsView.do")
	public String goodsView(@RequestParam("n") int goodsNum, Model model) {
		AdminGoodsVO adminGoodsVO = adminGoodsService.goodsView(goodsNum);
		model.addAttribute("goods",adminGoodsVO);
		return "admin/goodsView";
	}
	
	//상품 수정 페이지
	@RequestMapping(value="/goodsModify.do", method = RequestMethod.GET)
	public String goodsModify(@RequestParam("n") int goodsNum, Model model) {
		AdminGoodsVO adminGoodsVO = adminGoodsService.goodsView(goodsNum);
		model.addAttribute("goods",adminGoodsVO);
		return "admin/goodsModify";
	}
	
	//상품 수정
	@RequestMapping(value = "/postgoodsModify.do", method = RequestMethod.POST)
	public String postGoodsModify1(AdminGoodsVO adminGoodsVO,MultipartFile file,HttpServletRequest req) throws IOException, Exception {
		// 새로운 파일이 등록되었는지 확인
		 if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		  // 기존 파일을 삭제
		  new File(uploadPath + req.getParameter("goodsImage1")).delete();
		  new File(uploadPath + req.getParameter("goodsThumbImage")).delete();
		  
		  // 새로 첨부한 파일을 등록
		  String imgUploadPath = uploadPath + File.separator + "imgUpload";
		  String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		  String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		  
		  adminGoodsVO.setGoodsImage1(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		  adminGoodsVO.setGoodsThumbImage(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		  
		 } else {  // 새로운 파일이 등록되지 않았다면
		  // 기존 이미지를 그대로 사용
			 adminGoodsVO.setGoodsImage1(req.getParameter("goodsImage1"));
			 adminGoodsVO.setGoodsThumbImage(req.getParameter("goodsThumbImage"));
		 }
		adminGoodsService.goodsModify(adminGoodsVO);
		return "redirect:/admin/goodsList.do";
	}
	
	//상품 삭제
	@RequestMapping(value = "/goodsDelete.do", method = RequestMethod.POST)
	public String goodsDelte(@RequestParam("n") int goodsNum) throws IOException {
		adminGoodsService.goodsDelete(goodsNum);
		return "redirect:/admin/goodsList.do";
		
	}

	// ck 에디터에서 파일 업로드
	@RequestMapping(value = "/ckUpload.do", method = RequestMethod.POST)
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

	
	

}	
