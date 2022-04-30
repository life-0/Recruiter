package com.life.bo;

import com.life.POJO.user.JobHuntingInfo;
import com.life.POJO.user.ResumeDelivery;
import com.life.POJO.user.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *@Author: life-0
 *@ClassName: ResumeDeliveryBO
 *@Date: 2022/4/30 16:19
 *TODO @Description:    求职者信息,用户信息,用户求职信息

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDeliveryBO {
    private ResumeDelivery resumeDelivery;
    private UserInfo userInfo;
    private JobHuntingInfo jobHuntingInfo;
}
