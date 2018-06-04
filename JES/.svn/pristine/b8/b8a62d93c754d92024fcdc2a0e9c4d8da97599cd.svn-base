package com.fmcq.util.constant;

public interface Combo {

	String getCode();

	int getPrice();

	int getFlow();

	/**
	 * 移动套餐
	 * 
	 * @author xb
	 * @date 2016-2-1 上午11:58:22
	 */
	//	 套餐编号		套餐名称					套餐月费（元/月）	套餐包含国内流量（MB）	套餐内单价（元/MB）
	//	3831001001	个人流量包- 省内通用流量套餐一档	3			10				0.3
	//	3831001002	个人流量包- 省内通用流量套餐二档	5			30				0.167
	//	3831001003	个人流量包- 省内通用流量套餐三档	10			70				0.143
	//	3831001004	个人流量包- 省内通用流量套餐四档	20			150				0.133
	//	3831001005	个人流量包- 省内通用流量套餐五档	30			500				0.06
	//	3831001006	个人流量包- 省内通用流量套餐六档	50			1024			0.049
	//	3831001007	个人流量包- 省内通用流量套餐七档	70			2048			0.034
	//	3831001008	个人流量包- 省内通用流量套餐八档	100			3072			0.033
	//	3831010241	个人流量包- 省内通用流量套餐九档	130			4096			0.032
	//	3831010240	个人流量包- 省内通用流量套餐十档	180			6144			0.029
	//	3831010239	个人流量包- 省内通用流量套餐十一档	280			1264			0.025
	/**
	 * @author xb
	 * 
	 */
	enum MoveCombo implements Combo {
		/**
		 * 个人流量包- 省内通用流量套餐一档
		 */
		COMBO_1("3831001001", 3, 10),
		/**
		 * 个人流量包- 省内通用流量套餐二档
		 */
		COMBO_2("3831001002", 5, 30),
		/**
		 * 个人流量包- 省内通用流量套餐三档
		 */
		COMBO_3("3831001003", 10, 70),
		/**
		 * 个人流量包- 省内通用流量套餐4档
		 */
		COMBO_4("3831001004", 20, 150),
		/**
		 * 个人流量包- 省内通用流量套餐5档
		 */
		COMBO_5("3831001005", 30, 500),
		/**
		 * 个人流量包- 省内通用流量套餐6档
		 */
		COMBO_6("3831001006", 50, 1024),
		/**
		 * 个人流量包- 省内通用流量套餐7档
		 */
		COMBO_7("3831001007", 70, 2048),
		/**
		 * 个人流量包- 省内通用流量套餐8档
		 */
		COMBO_8("3831001008", 100, 3072),
		/**
		 * 个人流量包- 省内通用流量套餐9档
		 */
		COMBO_9("3831010241", 130, 4096),
		/**
		 * 个人流量包- 省内通用流量套餐10档
		 */
		COMBO_10("3831010240", 180, 6144),
		/**
		 * 个人流量包- 省内通用流量套餐11档
		 */
		COMBO_11("3831010239", 280, 11264), ;

		private String code;
		private int price;
		private int flow;

		MoveCombo(String code, int price, int flow) {
			this.code = code;
			this.price = price;
			this.flow = flow;
		}

		@Override
		public String getCode() {
			// TODO Auto-generated method stub
			return code;
		}

		@Override
		public int getPrice() {
			// TODO Auto-generated method stub
			return price;
		}

		@Override
		public int getFlow() {
			// TODO Auto-generated method stub
			return flow;
		}

		// 校验;
		public static MoveCombo getName(String code) {
			for (MoveCombo value : MoveCombo.values()) {
				if (value.getCode().equals(code)) {
					return value;
				}
			}
			return null;
		}
	}

}
