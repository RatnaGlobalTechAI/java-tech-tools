package com.rgt.jobs;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.rgt.entity.RegisterUserEntity;
import com.rgt.repository.RegisterUserRepository;
import com.rgt.service.MailService;
import com.rgt.utils.CommonUtility;



@Configuration
@EnableScheduling
@EnableAutoConfiguration
public class EmailSchedulerJob {

	private static Logger logger = LogManager.getLogger(EmailSchedulerJob.class);

	@Value("${is.enable.email}")
	private String isEmailEnable;

	@Autowired
	private RegisterUserRepository registerUserRepository;

	@Autowired
	private MailService mailService;

	@Scheduled(cron = "${daily.cron.job.emailSend}")
	//@Scheduled(fixedDelay = 1000)
	public void emailSendJob() {

		try {

			if ("true".equalsIgnoreCase(isEmailEnable.trim())) {

				String[] dateArray = CommonUtility.getTodayDate().split("-");
				String day = dateArray[0];
				Integer dayInt = Integer.parseInt(day);
				String month = dateArray[1];
				Integer monthInt = Integer.parseInt(month);
				String year = dateArray[2];
				Integer yearInt = Integer.parseInt(year);
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.HOUR_OF_DAY, 0);
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);
				cal.set(Calendar.MILLISECOND, 0);
				cal.set(yearInt, monthInt - 1, dayInt, 0, 0, 0);

				Date startDate = cal.getTime();
				cal.set(yearInt, monthInt - 1, dayInt, 23, 59, 59);
				Date endDate = cal.getTime();

				boolean sendInEmail = true;
				List<RegisterUserEntity> registerUserEntityList = registerUserRepository.updatedOnTodaysUsers(startDate,
						endDate);

				if(!registerUserEntityList.isEmpty() && registerUserEntityList.size() !=0) {
					for (RegisterUserEntity registerUserEntity : registerUserEntityList) {

						if (registerUserEntity.getEmailId() != null) {
							StringBuilder htmldata = new StringBuilder();

							if (sendInEmail) {
								htmldata.append(
										"Hi " + registerUserEntity.getUsername() + ", your data updated successfully.");

								boolean resposneStatus = mailService.sendMail(htmldata.toString(),
										registerUserEntity.getEmailId()); // ? "Email Sent Successfully." : "Email
								if (resposneStatus) {

									logger.info("Email Send Successfully");
									
									mailService.emailNotificationStatusSavedToDB("SUCESS" ,registerUserEntity.getEmailId(),htmldata.toString() , new Date() , registerUserEntity.getUsername() );


								} else {
									logger.info("Email delivery failed");
								}

							} else {
								htmldata.toString();
							}
						}

					}
				} else {
					logger.info("Data not found");
				}

			} else {
				logger.error("send email status is false");
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

	}

}
