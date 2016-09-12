package winder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import winder.service.ProjectService;
import winder.service.TeamService;
import winder.service.TodoListService;
import winder.service.TodoService;

@Controller
public class TodoController {
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private TeamService teamService;
	@Autowired
	private TodoListService todolistService;
	
	//메뉴 프로젝트 선택
	@RequestMapping(value="todo")
	public String todo(Model model, HttpSession session, HttpServletRequest request){
		String id=(String)session.getAttribute("id");
		model.addAttribute("teammenu", teamService.selectTeamList(id));
		model.addAttribute("projectmenu", projectService.selectProjectMenu(id));
		model.addAttribute("todo", todolistService.selectTodoList(Integer.parseInt(request.getParameter("pno"))));
		return "project/progress";
	}

}
