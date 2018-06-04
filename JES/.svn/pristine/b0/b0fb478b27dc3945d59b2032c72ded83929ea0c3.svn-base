package com.fmcq.util.constant;

/**
 * 
 * @author daiys
 * @date 2015-1-4
 */
public interface RetCode {

	String getMessage();

	Integer getCode();

	/**
	 * 调用接口返回代码定义 定义范围： -14001 开始
	 * 
	 * @author daiys
	 * @date 2015-1-4
	 */
	enum Common implements RetCode {

		/**
		 * 业务逻辑公共返回 Code 所有定义为 10000
		 */
		RET_10000(10000, "成功"),

		/**
		 * -20000 参数错误
		 */
		ERROR_PARAM(-20000, "参数错误"),

		/**
		 * "获取当前操作时间异常。"
		 */
		GetDate(-14001, "获取当前操作时间异常。"),
		/**
		 * "初始化配置文件出错."
		 */
		Init(-14002, "初始化配置文件出错."),
		/**
		 * 解析日期类型数据出错"
		 */
		ParseDate(-14004, "解析日期类型出现异常"),
		/**
		 * 调用医院端接口异常返回
		 */
		CallHosClientError(-14005, "调用医院端接口异常返回"),
		/**
		 * 调用Hop接口网关异常
		 */
		CallHOPClientError(-14006, "服务端接口异常"),
		/**
		 * -14007 数据库脚本执行查询异常
		 */
		EXECSqlError(-14007, "数据库脚本执行查询异常"),
		/**
		 * -14008请求的参数为空
		 */
		NULLERROR(-14008, "请求的参数为空"),
		/**
		 * -63001 XML解析异常
		 */
		ERROR_XMLERROR(-63001, "XML解析异常"),
		/**
		 * -14011健康卡号不存在
		 */
		ERROR_HEALTHNONOTEXIST(-14011, "健康卡号不存在"),
		/**
		 * -63001 XML解析异常
		 */
		ERROR_INIT_SYSCONFIG(-14009, "初始化系统配置信息异常。"),
		/**
		 * -63001 XML解析异常
		 */
		SysCfgNot(-14010, "系统解析模块参数未配置。"), ;
		/** 代码 */
		private Integer code;
		/** 消息 */
		private String message;

		@Override
		public String getMessage() {
			return message;
		}

		Common(Integer code, String message) {
			this.code = code;
			this.message = message;
		}

		@Override
		public Integer getCode() {
			return code;
		}
	}

	/**
	 * 基础信息错误
	 * 
	 * @author Administrator
	 * 
	 */
	enum Basic implements RetCode {
		/**
		 * 数据库操作异常
		 */
		ERROR_EXECUTESQL(-100001, "数据库操作异常"),
		/**
		 * 日期格式化异常
		 */
		ERROR_DATEFORMAT(-100002, "日期格式化异常"),
		/**
		 * json操作异常
		 */
		ERROR_JSONOPERTOR(-100003, "json操作异常"),
		/**
		 * 获取数据库连接异常
		 */
		ERROR_GETDBCONNECT(-100004, "获取数据库连接异常"),
		/**
		 * 数据不存在
		 */
		ERROR_CANNOTEXIST(-100005, "数据不存在"),
		/**
		 * 数据已存在
		 */
		ERROR_DATAEXIST(-100006, "数据已存在"),
		/**
		 * 交易代码不正确
		 */
		ERROR_TRANSACTIONCODE(-100006, "交易代码不匹配"),
		/**
		 * 用户名输入有误或不存在
		 */
		ERROR_USERNAME(-100007, "用户名输入有误或不存在"),
		/**
		 * 登陆失败：密码输入有误
		 */
		ERROR_LOGIN(-100008, " 登陆失败：密码输入有误"),
		/**
		 * 推送消息异常
		 */
		ERROR_SENDMSG(-100009, " 登陆失败：密码输入有推送消息异常"),
		/**
		 * 验证码输入有误
		 */
		ERROR_CHECKPORVINGCODE(-100010, "验证码输入有误"),
		/**
		 * 验证码已失效
		 */
		ERROR_PORVINGCODEFAILURE(-100011, "验证码已失效"),
		/**
		 * 本地身份验证异常
		 */
		ERROR_CHECKIDCARDNO(-100012, "本地身份验证异常"),
		/**
		 * 字符编码异常
		 */
		ERROR_ENCODE(-100013, "字符编码异常"),
		/**
		 * 通过身份证获取出生日期异常
		 */
		ERROR_GETBIRTHDAYBYIDCARDNO(-100014, "通过身份证获取出生日期异常"),
		/**
		 * 成员信息有误
		 */
		ERROR_MEMBERINFO(-100015, "成员信息有误"),
		/**
		 * 该账号已被其他用户绑定
		 */
		ERROR_binding(-100016, "该账号已被其他用户绑定"),
		/**
		 * 旧密码输入有误
		 */
		ERROR_OLDPASSWORD(-100017, "旧密码输入有误"), ;
		/** 代码 */
		private Integer code;
		/** 消息 */
		private String message;

		@Override
		public String getMessage() {
			return message;
		}

		Basic(Integer code, String message) {
			this.code = code;
			this.message = message;
		}

		@Override
		public Integer getCode() {
			return code;
		}
	}

}
