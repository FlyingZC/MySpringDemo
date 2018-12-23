package com.zc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zc.entity.Bmi;

@Controller
public class BmiController {
	@RequestMapping("toBmi.do")
	public String toBmi(){
		return "bmi";
	}
	
	@RequestMapping("/bmi.do")
	public String bmiResult(Bmi bmi,HttpServletRequest request){
		Double weight=bmi.getWeight();
		Double height=bmi.getHeight();
		Double bmiResult=weight/height/height;
		if(bmiResult<19){
			request.setAttribute("result", "过轻");
		}else if(bmiResult<25){
			
			request.setAttribute("result", "正常");
		}else{
			request.setAttribute("result", "过重");	
		}
		return "view";
	}
}
