package cn.zjy.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class Task {

    private Integer id;

    private String patientId;

    private String studyIuid;

    private String accessionNo;

    private String patientName;

    private String patientSex;

    private Date studyDatetime;

    private String studyDesc;

    private String modality;

    private String bodyPart;

    private Date patientBirthdate;

    private String source;

    private Integer taskStatus;

    private Integer taskLevel;

    private Integer aiTag;

    private String fromOrgNo;

    private String toOrgNo;

    private Integer reportDoctorId;

    private Integer reviewDoctorId;

    private String abandonReason;

    private Date abandonTime;

    private Integer rejectTag;

    private Date rejectDate;

    private Integer operateId;

    private Date allotTime;

    private Date finishTime;

    private Date createTime;

    private Date updateTime;
}
