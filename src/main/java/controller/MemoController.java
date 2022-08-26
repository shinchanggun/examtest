package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.PhonebookServiceInter;
import vo.PhonebookVO;

@Controller
public class MemoController {

	@Autowired
	PhonebookServiceInter service;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("list",service.getList());
		mv.setViewName("list");
		return mv;
	}
	
	@RequestMapping("/find")
	public ModelAndView list(String search) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("list",service.find(search));
		mv.setViewName("list");
		return mv;
	}
	
	@RequestMapping("/insertProc")
	public String insertProc(PhonebookVO pb) {
		System.out.println(pb.toString());
		int result=service.insert(pb);		
		return "index";
	}
	
	@RequestMapping("/insert")
	public ModelAndView insert(PhonebookVO pb) {
		ModelAndView mv=new ModelAndView();
		int result=service.insert(pb);		
		mv.addObject("list",service.getList());
		mv.setViewName("list");
		return mv;
	}
	
	@RequestMapping("/findOne")
	public ModelAndView findOne(int idx) {
		System.out.println(idx);
		System.out.println(service.findOne(idx).toString());
		ModelAndView mv=new ModelAndView();
		mv.addObject("phonebook",service.findOne(idx));
		mv.setViewName("findOne");
		return mv;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(PhonebookVO pb) {
		ModelAndView mv=new ModelAndView();
		int result=service.update(pb);	
		mv.addObject("list",service.getList());
		mv.setViewName("list");
		return mv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(int idx) {
		ModelAndView mv=new ModelAndView();
		int result=service.delete(idx);
		mv.addObject("list",service.getList());
		mv.setViewName("list");
		return mv;
	}
	
	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	
	@PostMapping("/home")
	public String home(@RequestBody PhonebookVO pb) {
		System.out.println(pb.toString());
		return "form";
	}
}
