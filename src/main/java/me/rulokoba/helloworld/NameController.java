package me.rulokoba.helloworld;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

	private final NameService nameService;

	public NameController(NameService nameService) {
		this.nameService = nameService;
	}
	
	@GetMapping(value = "/names", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<NameEntity> getAll() {
		List<NameEntity> result = nameService.findAll();
		return result;
	}
	
	@PostMapping(value = "/names", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public NameEntity add(@RequestBody NameEntity name) {
		NameEntity result = nameService.save(name);
		return result;
	}
	
	
}
