package com.life.dto;

import com.life.POJO.user.FirmInfo;
import com.life.POJO.user.JobHuntingInfo;
import com.life.POJO.user.JobList;
import com.life.POJO.user.ResumeDelivery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *@Author: life-0
 *@ClassName: ResumeDliveryFirmInfoBO
 *@Date: 2022/5/3 20:26
 *TODO @Description:
            返回公司名字,福利信息,职位信息,用户投递结果信息,简历
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDeliveryFirmInfoDTO {
    private JobList jobList;
    private String FirmName;
    private String FirmWelfare;
    private Integer ResumeDeliveryResult;
    private Boolean ResumeDeliveryIsOnlineResume;
}
