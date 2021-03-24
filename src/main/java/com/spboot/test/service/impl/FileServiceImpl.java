package com.spboot.test.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spboot.test.entity.FileInfo;
import com.spboot.test.repository.FileRepository;
import com.spboot.test.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileServiceImpl implements FileService {

	private final String ROOT = "C:\\study\\workspace11\\spboot\\src\\main\\webapp\\resources\\";
	
	@Autowired
	private FileRepository fileRepo;
	
	@Override
	public FileInfo saveFileInfo(FileInfo fi) {
		MultipartFile mf = fi.getFiiFile();
		log.info("fileName => {}", mf.getOriginalFilename());
		int idx = mf.getOriginalFilename().lastIndexOf(".");
		String extName = mf.getOriginalFilename().substring(idx);
		String filePath = System.nanoTime() + extName;
		log.info("filePath => {}", filePath);
		fi.setFiiFileName(mf.getOriginalFilename());
		fi.setFiiFilePath(filePath);
		File file = new File(ROOT + filePath);
		try {
			mf.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileRepo.save(fi);
	}

	@Override
	public List<FileInfo> getFileInfos(FileInfo fileInfo) {
		if(fileInfo.getFiiTitle() != null) {
			return fileRepo.findAllByFiiTitleOrderByFiiNumAsc(fileInfo.getFiiTitle());
		}
		if(fileInfo.getFiiContent() != null) {
			return fileRepo.findAllByFiiContentLikeOrderByFiiNumAsc("%" + fileInfo.getFiiContent() + "%");
		}
		List<FileInfo> fileInfoList = fileRepo.findAllByOrderByFiiNumDesc();
		return fileInfoList;
	}

	@Override
	public FileInfo getFileInfo(Long fiiNum) {
		FileInfo fileInfo = fileRepo.getOne(fiiNum);
		log.info("fileInfo =>{}", fileInfo);
		return fileInfo;
	}

	@Override
	public int updateFileInfo(FileInfo fi) {
		FileInfo fileInfo = fileRepo.getOne(fi.getFiiNum());
		if(fileInfo.getFiiNum() == fi.getFiiNum()) {
			fileRepo.flush();
		}
		return 1;
	}

	@Override
	public int deleteFileInfo(FileInfo fi) {
		fileRepo.delete(fi);
		return 1;
	}

}
