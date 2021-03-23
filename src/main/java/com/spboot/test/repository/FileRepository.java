package com.spboot.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spboot.test.entity.FileInfo;

public interface FileRepository extends JpaRepository<FileInfo, Long> {

	List<FileInfo> findAllByOrderByFiiNumDesc();
}
