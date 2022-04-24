package com.life.bo;

import com.life.POJO.user.FirmInfo;
import com.life.POJO.user.JobList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *@Author: life-0
 *@ClassName: JobListBO
 *@Date: 2022/4/24 23:14
 *TODO @Description:

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobListBO {
    private JobList jobList;
    private FirmInfo firmInfo;
}
