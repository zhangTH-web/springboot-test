package com.xino.dao.mybatis.bean;

import java.util.Date;

public class TVisitorRegisterInfo {
    private Integer id;

    private String visitorName;

    private String phone;

    private String identityNumber;

    private String visitorComp;

    private String visitorPosition;

    private String headImgUrl;

    private Integer followerAmount;

    private String visitorGoal;

    private Date visitingTime;

    private Date visitingEndTime;

    private String deviceId;

    private String intervieweeName;

    private String intervieweeDept;

    private String intervieweePosition;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private Integer schoolId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName == null ? null : visitorName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber == null ? null : identityNumber.trim();
    }

    public String getVisitorComp() {
        return visitorComp;
    }

    public void setVisitorComp(String visitorComp) {
        this.visitorComp = visitorComp == null ? null : visitorComp.trim();
    }

    public String getVisitorPosition() {
        return visitorPosition;
    }

    public void setVisitorPosition(String visitorPosition) {
        this.visitorPosition = visitorPosition == null ? null : visitorPosition.trim();
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl == null ? null : headImgUrl.trim();
    }

    public Integer getFollowerAmount() {
        return followerAmount;
    }

    public void setFollowerAmount(Integer followerAmount) {
        this.followerAmount = followerAmount;
    }

    public String getVisitorGoal() {
        return visitorGoal;
    }

    public void setVisitorGoal(String visitorGoal) {
        this.visitorGoal = visitorGoal == null ? null : visitorGoal.trim();
    }

    public Date getVisitingTime() {
        return visitingTime;
    }

    public void setVisitingTime(Date visitingTime) {
        this.visitingTime = visitingTime;
    }

    public Date getVisitingEndTime() {
        return visitingEndTime;
    }

    public void setVisitingEndTime(Date visitingEndTime) {
        this.visitingEndTime = visitingEndTime;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getIntervieweeName() {
        return intervieweeName;
    }

    public void setIntervieweeName(String intervieweeName) {
        this.intervieweeName = intervieweeName == null ? null : intervieweeName.trim();
    }

    public String getIntervieweeDept() {
        return intervieweeDept;
    }

    public void setIntervieweeDept(String intervieweeDept) {
        this.intervieweeDept = intervieweeDept == null ? null : intervieweeDept.trim();
    }

    public String getIntervieweePosition() {
        return intervieweePosition;
    }

    public void setIntervieweePosition(String intervieweePosition) {
        this.intervieweePosition = intervieweePosition == null ? null : intervieweePosition.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }
}