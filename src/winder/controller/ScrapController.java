package winder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScrapController {
	
	@RequestMapping(value="/scrap")
	public String scrap(){
		return "scrap";
	}
}
