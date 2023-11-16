package com.rgt.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgt.entity.FileTransferEntity;
import com.rgt.repository.FileTransferRepository;
import com.rgt.utils.Constant;

@Service
public class FileTransferService {
	
	private static Logger logger = LoggerFactory.getLogger(FileTransferService.class);
	
	@Autowired
	private FileTransferRepository fileTransferRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	public void transferFiles(String sourceDirectory, String targetDirectory) throws IOException {
		File sourceDir = new File(sourceDirectory);
		File targetDir = new File(targetDirectory);
	
		try {
			if (!sourceDir.exists() || !targetDir.isDirectory()) {
				throw new IllegalArgumentException("Source directory does not exist or is not a directory");
			}
			if (!targetDir.exists() || !targetDir.isDirectory()) {
				throw new IllegalArgumentException("Target directory does not exist or is not a directory");
			}

			for (File file : sourceDir.listFiles()) {
				Path sourcePath = file.toPath();
				Path targetPath = new File(targetDir, file.getName()).toPath();
				Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
				
				FileTransferEntity fileTransferEntity = new FileTransferEntity();
				fileTransferEntity.setFileName(file.getName());
				fileTransferEntity.setSourceDir(sourceDirectory);
				fileTransferEntity.setTargetDir(targetDirectory);
				fileTransferEntity.setStatus(Constant.SUCCESS);
				fileTransferEntity.setCreatedOn(new Date());
				fileTransferEntity.setId(sequenceGeneratorService.generateSequence(FileTransferEntity.SEQUENCE_NAME));
				
				fileTransferRepository.save(fileTransferEntity);
				
				Files.delete(sourcePath);
			}
		}catch(Exception e) {
			logger.error("File transfer error - "+e.getMessage());
		}
			
		
		

	}

}
