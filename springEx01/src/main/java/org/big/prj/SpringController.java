package org.big.prj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SpringController {

	@RequestMapping("/home")
	public String home() {
		return "index.html";
	}
	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		String data = "@ResponseBody 어노테이션을 통해 반환";
		
		return data;
	}
	
	@RestController
	public class SampleRestController {
		@RequestMapping(value="/sampleValue", method=RequestMethod.GET)
		public String getSampleValue() {
			String sampleValue = "@RestController + @ResponseBody 이며, view 변환에 json 데이터 변환시 사용";
			
			return sampleValue;
			
		}
	}
}
