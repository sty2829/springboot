package com.spboot.test.service;

import java.util.List;

import com.spboot.test.entity.FileInfo;

public interface FileService {

	FileInfo saveFileInfo(FileInfo fi);
	
	List<FileInfo> getFileInfos();
	
	FileInfo getFileInfo(Long fiiNum);
	
}
