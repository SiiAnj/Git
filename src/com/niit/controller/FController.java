package com.niit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.niit.model.Food;
import com.niit.model.FoodType;
import com.niit.page.Page;
import com.niit.service.FService;
import com.niit.service.FTService;

@Controller
public class FController {
	
	// 注入Service层的接口
	@Autowired // byType的自动注入  
	private FService fService;
	@Autowired
	private FTService ftService;
	
	//查询
	@RequestMapping("/foodList.do")
	public String list(Map<String,Object> map,
			Page page){
		
		// 查询总的数据行数
		int totalCount = fService.getTotalCount();
		page.setTotalCount(totalCount);// 一定要设置到 page类中
		
		List<Food> list = fService.getAll(page);
		map.put("list",list);
		
		return "foodList";
	}
	
	//添加菜系1. 跳转到saveCuisine.jsp
	@RequestMapping("/toSaveFood.do")
	public String toSaveFood(Map<String,Object> map,Page page){
		
		List<FoodType> list = ftService.getAll(page);
		map.put("list", list);
		
		return"saveFood";
	}
	
	//添加菜系2.执行添加方法
	@RequestMapping("/saveFood.do")
	public String saveFood(Food food,Map<String,Object> map){
	
		fService.save(food);
		food = fService.findByName(food.getFoodName());
		
		map.put("id", food.getId());
		
		
		return"updateImg"; // redirect: 不经过视图解析器 直接跳转
	}
	
	@RequestMapping("/{id}upImg.do")
	public String upImg(@PathVariable int id,Food food,HttpServletRequest request) throws ServletException, IOException{
		
		List<FileItem> items=null;// 存放所有的数据(已经经过FileItemFactory加工之后的数据 )
		// 1 FiletItem的工厂 将 form的数据 都生产为 FileItem 每一个 FiletItem 代表form里的一个字段 包括 普通字段和文件字段 
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
			
		// 从请求中获取数据 并调用 FileItemFactory 将form中的数据 都转换成 FileItem对象
		try { items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
			
		
		String img="";
		InputStream in=null; // 文件输入流
		// 遍历所有的表单数据
		for(FileItem item : items){
			if(item.isFormField()){// 如果是 普通表单字段的话
				System.out.println("出错");
			}else{// 不是普通的表单字段 也就是上传字段
				img=item.getName();//要不要截取
				in=item.getInputStream();// 接受文件的输入流
			}
		}
			
		// 1  确定以个上传的路径    绝对路径 放在电脑里面D://photos
	       String path ="E:\\files\\";// 目标路径
	       img = path+img;// 获取上传之后的文件名全路径
	        
		// 2  写入文件到服务器上的一个路径
	    if(new File(img).exists()){// 若文件已存在
	       	new File(img).delete(); // 删除之
        }else{// 不存在就上传
        	FileOutputStream fos = new FileOutputStream(img);// 创建输出流
        	byte[] buffer = new byte[1024];
        	// 应该是一边读取 一边写入
        	int temp=0;// 一次读取的字节数
        	while((temp=in.read(buffer))!=-1){// 读取
        		fos.write(buffer, 0, temp);// 写入
        	}
        	in.close();
        	fos.close();
        	
        }
	    
	    food.setId(id);
 	    food.setImg(img);
		
		fService.upImg(food);
		
		return"redirect:/foodList.do";
	}
	
	
	//更新菜系名1.跳转updateCuisine.jsp
	@RequestMapping("/{id}/toUpdateFood.do")
	public String toUpdate (@PathVariable("id") int id,
			Map<String,Object> map,
			Page page){
		
		List<FoodType> list = ftService.getAll(page);
		map.put("list", list);
		
		Food F = fService.findById(id);
		map.put("F", F);
		
		return"updateFood";
	}
	
	//更新菜系名2.执行更新方法
	@RequestMapping("/updateFood.do")
	public String updateCuisine(Food food,Map<String,Object> map){
		
		fService.update(food);
		food = fService.findByName(food.getFoodName());
		
		map.put("id", food.getId());
		
		return"updateImg"; /*"redirect:/foodList.do";*/
	}
	
	//删除餐桌
	@RequestMapping("/{id}/deleteFood.do")
	public String deleteFood(@PathVariable("id") int id){
		fService.delete(id);
		
		return "redirect:/foodList.do";// 返回到cuisineList.do 重新查询数据
	}
}
