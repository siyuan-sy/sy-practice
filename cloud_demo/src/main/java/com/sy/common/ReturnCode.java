package com.sy.common;

/**
 * @ClassName ReturnCode
 * @Description 异常返回状态码为四位，其中前两位代表接口编码，后两位代表错误码编号
 * @Author DINGLAN
 * @Date 2019/2/19 15:19
 **/
public abstract class ReturnCode {


    /**
     * 返回成功 无异常
     */
    public static final KeyValuePair<String, String> SUCCESS = KeyValuePair.create("0000", "操作成功");

    /**
     * 接口内部异常
     */
    public static final KeyValuePair<String, String> EXCEPTION = KeyValuePair.create("0001", "哎呀，出错鸟，接口异常，待会再来试试吧");

    public static final KeyValuePair<String, String> MYSQL_EXCEPTION = KeyValuePair.create("0002", "哎呀，数据库异常，待会再来试试吧");

    public static final KeyValuePair<String, String> SERVER_EXCEPTION = KeyValuePair.create("0003", "哎呀，服务器异常，待会再来试试吧");

    /**
     * 获取参数失败，可能类型不匹配
     */
    public static final KeyValuePair<String, String> ILLEGAL_ARGUMENTS = KeyValuePair.create("0004", "哎呀，出错鸟，获取参数失败，待会再来试试吧");

    /**
     * 没有符合条件的记录
     */
    public static final KeyValuePair<String, String> NO_MORE_RESULT = KeyValuePair.create("0005", "亲，已经没有更多记录了，待会再来看看吧");

    /**
     * 暂无记录
     */
    public static final KeyValuePair<String, String> NO_RESULT = KeyValuePair.create("0006", "暂无记录");
    /**
     * 无效请求
     */
    public static final KeyValuePair<String, String> ERROR_REQUEST = KeyValuePair.create("0007", "无效请求，请查看参数后重试");

    public static final KeyValuePair<String, String> NEW_JWT_SUCCESS= KeyValuePair.create("0008", "重新签发秘钥成功");

    public static final KeyValuePair<String, String> EXPIRED_JWT= KeyValuePair.create("0009", "秘钥已经过期，请重新登录！");

    public static final KeyValuePair<String, String> ERROR_JWT= KeyValuePair.create("0010", "无效秘钥，请重新登录！");

    /**
     * 验证码错误
     */
    public static final KeyValuePair<String, String> ERROR_CAPTCHA = KeyValuePair.create("0011", "验证码错误");
    /**
     * 登录，签发JWT成功
     */
    public static final KeyValuePair<String, String> LOGIN_SUCCESS = KeyValuePair.create("0101", "登录成功");
    public static final KeyValuePair<String, String> LONGIN_ERROR = KeyValuePair.create("0102", "用户名密码错误，请重试");
    /** 用户退出成功*/
    public static final KeyValuePair<String, String> LOGOUT_SUCCESS = KeyValuePair.create("0103", "退出成功");
    public static final KeyValuePair<String, String> LOGOUT_FAIL = KeyValuePair.create("0104", "退出失败");
    /** 用户未登录 */
    public static final KeyValuePair<String, String> USER_NOT_LOGIN = KeyValuePair.create("0105", "用户未登录");

    /** 用户不存在 */
    public static final KeyValuePair<String, String> USER_NOT_EXISTS = KeyValuePair.create("0106", "用户不存在");
    /**
     * 用户已存在
     */
    public static final KeyValuePair<String, String> USER_ALREADY_EXISTS = KeyValuePair.create("0107", "用户已存在，请更改账号");
    /**
     * 用户注册成功
     */
    public static final KeyValuePair<String, String> REGISTER_SUCCESS = KeyValuePair.create("0108", "注册成功");
    public static final KeyValuePair<String, String> REGISTER_FAIL = KeyValuePair.create("0109", "注册失败，请稍后重试！");
    /**
     * 当前用户无此接口权限
     */
    public static final KeyValuePair<String, String> NO_AUTHORITY = KeyValuePair.create("0110", "当前用户无权限");

    /**
     * 数据不存在时
     */
    public static final KeyValuePair<String, String> NOT_EXISTS = KeyValuePair.create("0111", "数据不存在，请刷新后重试");
    /**
     * 组织不可删除
     */
    public static final KeyValuePair<String, String> NO_DELETE = KeyValuePair.create("0112", "当前组织不可删除，建议先转移下属组织和党员再删除");
    /**
     * 手机号被占用
     */
    public static final KeyValuePair<String, String> PHONE_ALREADY_EXISTS = KeyValuePair.create("0108", "此手机号码已被占用，请更换");
    /**
     * 不支持的文件类型
     */
    public static final KeyValuePair<String, String> NO_SUPPORT_FILE_TYPE = KeyValuePair.create("0114", "不支持的文件类型");

    public static final KeyValuePair<String, String> NOT_MATCH_FILE_TYPE = KeyValuePair.create("0115", "文件类型和内容不匹配");

    public static final KeyValuePair<String, String> DUPLICAT_TELEPHONE_IMPORT = KeyValuePair.create("0116", "上传文件中有重复的联系电话，请修改后再次上传");

    public static final KeyValuePair<String, String> ILLEGAL_DATEFORMAT = KeyValuePair.create("0117", "上传文件中有不合法的日期格式，请检查之后再次上传！");
    /**
     * 达到最大上传文件大小
     */
    public static final KeyValuePair<String, String> MAX_UPLOAD_SIZE_EXCEEDED = KeyValuePair.create("0120", "最大支持上传5MB的文件");
    /**
     * 重复操作
     */
    public static final KeyValuePair<String, String> REPETITIVE_OPERATION = KeyValuePair.create("0121", "重复操作");

    public static final KeyValuePair<String, String> DUPLICAT_ID_MEMBER = KeyValuePair.create("0122", "系统中已存在此身份证号的党员或发展党员");

    public static final KeyValuePair<String, String> DUPLICAT_TELEPHONE = KeyValuePair.create("0123", "系统中已存在此联系电话的党员或发展党员");

    /**
     * 达到最大上传文件记录数量
     */
    public static final KeyValuePair<String, String> MAX_UPLOAD_COUNT_EXCEEDED = KeyValuePair.create("0125", "最大支持上传1000条数据");

    public static final KeyValuePair<String, String> NO_CHECK_FIELD = KeyValuePair.create("0126", "上传文件中没有表头信息");

    public static final KeyValuePair<String, String> OVERLAP_RULE = KeyValuePair.create("0200", "和已有执行中的规则生效时段重合，请终止后再次尝试");

    public static final KeyValuePair<String, String> NO_STOP_STANDARD = KeyValuePair.create("0201", "此标准没在执行中，不可终止！");

    public static final KeyValuePair<String, String> NO_DELETE_STANDARD = KeyValuePair.create("0202", "此标准不是待执行状态，不可删除！");

    public static final KeyValuePair<String, String> NO_GEATER_THEN_START = KeyValuePair.create("0203", "不能早于开始时间！");
}
