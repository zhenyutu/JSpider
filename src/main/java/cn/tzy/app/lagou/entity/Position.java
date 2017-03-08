package cn.tzy.app.lagou.entity;

import lombok.Getter;

/**
 * Created by tuzhenyu on 17-3-5.
 * @author tuzhenyu
 */
@Getter
public class Position {

    /** 职位id */
    private int positionId;

    /** 职位名称 */
    private String positionName;

    /** 招聘时间 */
    private String createTime;

    /** 城市 */
    private String city;

    /** 行政区 */
    private String district;

    /** 进一步抓取内容：工作地址 */
    private String positionAddress;

    /** 公司简称 */
    private String companyShortName;

    /** 公司全名 */
    private String companyFullName;

    /** 学历要求 */
    private String education;

    /** 工资范围 */
    private String salary;

    /** 工资范围解析后得到最低工资 */
    private int salaryMin;

    /** 工资范围解析后得到最高工资 */
    private int salaryMax;

    /** 工作经验 */
    private String workYear;

    /** 工作经验 */
    private String industryField;

    /** 职位类型 */
    private String positionType;

    @Override
    public String toString(){
        return "CompanyName:"+companyShortName+",positionName:" + positionName+ ",city:" + city+"\n";
    }

}
