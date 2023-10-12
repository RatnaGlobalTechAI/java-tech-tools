package com.rgt.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rgt.entity.EmailNotificationReportEntity;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseObject {

    boolean status = true;
    Object response;

    List<EmailNotificationReportEntity> reportEntityList;
    String errorMessage;
    String successMessage;
    private String info;
    private String errorType;


    public ResponseObject() {

    }

    public ResponseObject(boolean status, Object response, String errorMessage, String successMessage, String info,
                          String errorType) {
        this.status = status;
        this.response = response;
        this.errorMessage = errorMessage;
        this.successMessage = successMessage;
        this.info = info;
        this.errorType = errorType;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public List<EmailNotificationReportEntity> getReportEntityList() {
        return reportEntityList;
    }

    public void setReportEntityList(List<EmailNotificationReportEntity> reportEntityList) {
        this.reportEntityList = reportEntityList;
    }

    @Override
    public String toString() {
        return "ResponseObject{" +
                "status=" + status +
                ", response=" + response +
                ", reportEntityList=" + reportEntityList +
                ", errorMessage='" + errorMessage + '\'' +
                ", successMessage='" + successMessage + '\'' +
                ", info='" + info + '\'' +
                ", errorType='" + errorType + '\'' +
                '}';
    }
}
