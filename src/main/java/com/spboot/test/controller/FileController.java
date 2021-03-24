package com.spboot.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spboot.test.entity.FileInfo;
import com.spboot.test.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileController {

	@Autowired
	private FileService fileService;
	
	@PostMapping("/file-info")
	public String upload(@ModelAttribute FileInfo fi) {
		fileService.saveFileInfo(fi);
		log.info("mf => {}", fi);
		log.info("@Slf4j 어노테이션이 있으면 log변수 자동으로 만들어줌");
		return "views/file-upload";
	}
	
	@GetMapping("/file-infos")
	public @ResponseBody List<FileInfo> getFileInfos(@ModelAttribute FileInfo fileInfo){
		log.info("fileInfo => {}", fileInfo);
		return fileService.getFileInfos(fileInfo);
	}
	
	@GetMapping("/file-info")
	public @ResponseBody FileInfo getFileInfo(@RequestParam Long fiiNum){
		return fileService.getFileInfo(fiiNum);
	}
	
	@PostMapping("/file-info-update")
	public String update(FileInfo fi) {
		log.info("fileInfo =>{}", fi);
		int result = fileService.updateFileInfo(fi);
		return "views/file-info-list";
	}
	
	@PostMapping("file-info-delete")
	public @ResponseBody Map<String,String> delete(@RequestBody FileInfo fi){
		log.info("fileInfo =>{}", fi);
		int result = fileService.deleteFileInfo(fi);
		Map<String,String> rMap = new HashMap<>();
		if(result == 1) {
			 rMap.put("result", result+"");
			 rMap.put("msg", "삭제 정상이요");
		}
		
		return rMap;
	}
	
}
