package com.yinzhi.eduplat.constant;
/**
 * 平台上下文常量定义类
 * 
 * @author 黄清泉
 * @date 2013-3-20
 */
public interface EduplatContextConstant {

	// 控制器处理结果
	public final static String EDUPLAT_ACTION_SUCCESS = "success";
	public final static String EDUPLAT_ACTION_ERROR = "error";
	
	// 平台相关路径
	public final static String EDUPLAT_COURSE_PPT = "eduplat.course.ppt";
	public final static String EDUPLAT_RESOURCE = "eduplat.resource";
	public final static String EDUPLAT_RESOURCE_BOOKS = "eduplat.resource.books";
	public final static String EDUPLAT_RESOURCE_COURSES = "eduplat.resource.courses";
	public final static String EDUPLAT_RESOURCE_TEMPLATES_PPT = "eduplat.resource.templates.ppt";
	
	public final static String EDUPLAT_PPT_XMLFILE = "ppt-new.xml";
	
	// 文件后缀
	public final static String PPT_FILE_EXT = ".ppt";
	public final static String ASM_FILE_EXT = ".html";
	
	// 班级状态
	public final static int COR_STATUS_0 = 0;//未关联图书
	public final static int COR_STATUS_1 = 1;//已关联图书，未发布
	public final static int COR_STATUS_2 = 2;//已发布
	public final static int COR_STATUS_3 = 3;//已删除
	
	// 课件状态
	public final static int PPT_STATUS_0 = 0;//未制作，不可上传
	public final static int PPT_STATUS_1 = 1;//已制作，未发布，可上传
	public final static int PPT_STATUS_2 = 2;//已发布
	public final static int PPT_STATUS_3 = 3;//已删除
	
	// 作业状态
	public final static int ASM_STATUS_0 = 0;//未发布
	public final static int ASM_STATUS_1 = 1;//已发布
	public final static int ASM_STATUS_2 = 2;//已删除
	
	// 学生作业状态
	public final static int MSS_STATUS_0 = 0;//未出卷
	public final static int MSS_STATUS_1 = 1;//已出卷，未答题
	public final static int MSS_STATUS_2 = 2;//已答题
	
	// 题型
	public final static int QUS_TYPE_SIZE = 8;//题型数目
	public final static int QUS_TYPE_0 = 0;//单选题
	public final static int QUS_TYPE_1 = 1;//多选题
	public final static int QUS_TYPE_2 = 2;//填空题
	public final static int QUS_TYPE_3 = 3;//简答题
	public final static int QUS_TYPE_4 = 4;//辨析题
	public final static int QUS_TYPE_5 = 5;//计算题
	public final static int QUS_TYPE_6 = 6;//图表题
	public final static int QUS_TYPE_7 = 7;//分录题
	
	// 出题方式
	public final static int QUS_KIND_0 = 0;//随机
	public final static int QUS_KIND_1 = 1;//按模板
	public final static int QUS_KIND_2 = 2;//按业务点
	
	// 书评状态
	public final static int CMT_STATUS_0 = 0;//未审核
	public final static int CMT_STATUS_1 = 1;//已审核
	public final static int CMT_STATUS_2 = 2;//已删除
	
	// 笔记状态
	public final static int NTE_STATUS_0 = 0;//未审核
	public final static int NTE_STATUS_1 = 1;//已审核
	public final static int NTE_STATUS_2 = 2;//已删除
	
	// 回应状态
	public final static int REP_STATUS_0 = 0;//未审核
	public final static int REP_STATUS_1 = 1;//已审核
	public final static int REP_STATUS_2 = 2;//已删除
}
