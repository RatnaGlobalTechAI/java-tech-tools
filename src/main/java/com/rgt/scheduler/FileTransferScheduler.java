package com.rgt.scheduler;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.rgt.service.FileTransferService;

@Component
@EnableScheduling
public class FileTransferScheduler {
	
	private static Logger logger = LoggerFactory.getLogger(FileTransferScheduler.class);
	
	 @Autowired
	    private FileTransferService fileTransferService;

	    //@Scheduled(cron = "0 0/1 * * * ?")
	    @Scheduled(cron = "${cron.job.filetransfer}")
	    public void transferFilesScheduled() {
	        String sourceDirectory = "C:\\Sandesh\\Testing\\source";
	        String targetDirectory = "C:\\Sandesh\\Testing\\target";

	        try {
	            fileTransferService.transferFiles(sourceDirectory, targetDirectory);
	            
	            logger.info("File transfer completed successfully.");
	            
	            
	        } catch (IOException e) {
	            logger.error("File transfer failed: " + e.getMessage());
	        }
	    }

}
