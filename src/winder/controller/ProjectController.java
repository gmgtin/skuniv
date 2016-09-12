package winder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import winder.service.ProjectService;
import winder.service.TeamService;
import winder.vo.ProjectVO;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private TeamService teamService;
	
	//프로젝트 생성 form
	@RequestMapping(value="projectform")
	public String projectForm(Model model, HttpSession session){
		String id=(String)session.getAttribute("id");
		model.addAttribute("teammenu", teamService.selectTeamList(id));
		model.addAttribute("projectmenu", projectService.selectProjectMenu(id));
		return "project/projectCreate";
	}
	
	//프로젝트 생성
	@RequestMapping(value="projectcreate")
	public String project(ProjectVO vo, HttpSession session){
		try {
			int count=projectService.insertProject(vo);
			if(count==1){
				return "redirect:/index";
			}else{
				return "redirect:/index";
			}
		} catch (Exception e) {
			return "redirect:/index";
		}
	}
}
