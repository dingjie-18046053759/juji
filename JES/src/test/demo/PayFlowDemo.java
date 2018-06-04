package test.demo;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.cmcc.api.fj.payflow.bean.BatchLLTFMemberAddition;
import com.cmcc.api.fj.payflow.bean.BatchLLTFMemberOrder;
import com.cmcc.api.fj.payflow.bean.BatchResult;
import com.cmcc.api.fj.payflow.bean.LLTFMemberAddition;
import com.cmcc.api.fj.payflow.bean.LLTFMemberAdditionResult;
import com.cmcc.api.fj.payflow.bean.LLTFMemberInfo;
import com.cmcc.api.fj.payflow.bean.LLTFMemberOrder;
import com.cmcc.api.fj.payflow.bean.LLTFMemberOrderResult;
import com.cmcc.api.fj.payflow.bean.QueryBatchDetails;
import com.cmcc.api.fj.payflow.bean.QueryBatchDetailsResult;
import com.cmcc.api.fj.payflow.bean.QueryMemberLLTF;
import com.cmcc.api.fj.payflow.bean.QueryMemberLLTFResult;
import com.cmcc.api.fj.payflow.bean.ResultInfo;
import com.cmcc.api.fj.payflow.bean.TS_OPRECORD;
import com.cmcc.api.fj.payflow.bean.resPageInfo.PageInfo;
import com.cmcc.api.fj.payflow.service.PayFlowService;
import com.cmcc.api.fj.payflow.util.NoneType;

public class PayFlowDemo {
	private PayFlowService flow;

	public PayFlowDemo() {
		//				//应用id 该参数是开发者在开放平台创建应用的时候，由开放平台分配给开发者
		//				String appId = "159102000000000800";
		//				//应用密钥 该参数是开发者在开放平台创建应用的时候，由开放平台分配给开发者
		//				String appKey = "CDD71F432B569E63FC9A2C0CC573C1FD";
		//				//鉴权初始化URL
		//				String URL = "http://218.207.182.105:8075";
		//				flow = new PayFlowService(appId, appKey, URL);

		//应用id 该参数是开发者在开放平台创建应用的时候，由开放平台分配给开发者
		String appId = "159102000000000800";
		//应用密钥 该参数是开发者在开放平台创建应用的时候，由开放平台分配给开发者
		String appKey = "CDD71F432B569E63FC9A2C0CC573C1FD";
		//鉴权初始化URL
		String URL = "http://218.207.182.105:8070";
		flow = new PayFlowService(appId, appKey, URL);
	}

	public static void main(String[] args) {
		new PayFlowDemo().orderMemberProductDemo();
	}

	/**
	 * 流量统付集团成员产品受理
	 */
	public void orderMemberProductDemo() {
		//流量统付集团成员产品受理Bean
		LLTFMemberOrder lltfMemberOrder = new LLTFMemberOrder();
		//集团编码：必填
		lltfMemberOrder.setECCode("5911914920");// 5911914920  5911323401
		//号码：必填
		lltfMemberOrder.setNumber("13905920139");
		//操作编码：必填,01=开通、02=退订、03=调整成员套餐或流量值
		lltfMemberOrder.setOprCode("01");
		//统付模式。判断如果是流量池受理，该项可选：1、通用业务、指定用户、定量统付
		//2、通用业务、指定用户、全量统付。如果是通用包受理，该项只可填：3通用业务、指定用户、定额统付
		lltfMemberOrder.setMode("1");
		//套餐编码,统付模式=定额模式必填
		lltfMemberOrder.setDealID("3831001001");
		//成员流量：统付模式=定量模式时必填，单位MB
//		lltfMemberOrder.setMemberAmount("50");
		//生效模式：必填，默认=2，1=立即生效、2=次月生效
		lltfMemberOrder.setEffType("1");
		//失效日期：必填，通用包订购的时候时间格式为YYYYMM，流量池订购的时候时间格式为YYYYMMDD
		lltfMemberOrder.setEndTime("201603");
		//退订、 变更必填
		lltfMemberOrder.setECMemberOrderID("");
		Hashtable respHashtable = new Hashtable();
		try {
			//发送请求并接受响应内容
			respHashtable = flow.orderMemberProduct(lltfMemberOrder);
			//异常信息bean
			ResultInfo resultInfo = (ResultInfo) respHashtable.get("ResultInfo");
			//流量统付集团成员产品受理应答结果Bean
			LLTFMemberOrderResult lltfMemberOrderResult = (LLTFMemberOrderResult) respHashtable.get("LLTFMemberOrderResult");
			//输出异常编码
			System.out.println("异常编码" + resultInfo.getResultCode() + ":" + resultInfo.getResultMsg());
			//输出受理结果的错误原因
			if (!NoneType.isNull(lltfMemberOrderResult) && !NoneType.isNullOrEmpty(lltfMemberOrderResult.getResultMsg())) {
				System.out.println("开通结果" + lltfMemberOrderResult.getResultMsg());
				if (!NoneType.isNullOrEmpty(lltfMemberOrderResult.getECMemberOrderID())) {
					System.out.println("成员订购标识：" + lltfMemberOrderResult.getECMemberOrderID());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 流量统付集团成员产品订购关系查询
	 */
	public void getOrderRelationDemo() {
		//查询流量统付集团成员产品订购关系情况请求Bean
		QueryMemberLLTF queryMemberlltf = new QueryMemberLLTF();
		//集团编码:必填 
		queryMemberlltf.setECCode("5911914920");
		//号码：非必填，不填代表查询该集团下所有成员订购关系
		queryMemberlltf.setNumber("13905920139");
		//套餐编码：非必填
		//queryMemberlltf.setDealID("3730010001");
		PageInfo pageInfo = new PageInfo();
		//页数：必填默认=1，最小取1
		pageInfo.setPageNum("1");
		//每页记录数：必填默认=10，最大取100
		pageInfo.setPageSize("100");
		queryMemberlltf.setPageInfo(pageInfo);
		Hashtable respHashtable = new Hashtable();
		try {
			//发送请求并接受响应内容
			respHashtable = flow.getOrderRelation(queryMemberlltf);
			//异常信息bean
			ResultInfo resultInfo = (ResultInfo) respHashtable.get("ResultInfo");
			//响应结果集bean
			QueryMemberLLTFResult queryMemberLLTFResult = (QueryMemberLLTFResult) respHashtable.get("QueryMemberLLTFResult");
			//QueryMemberLLTFResult属性说明：
			//分页信息
			if (queryMemberLLTFResult != null) {
				com.cmcc.api.fj.payflow.bean.responPageInfo.PageInfo pageInfo1 = queryMemberLLTFResult.getPageInfo();
				//集团成员产品订购关系集合
				List<LLTFMemberInfo> lLTFMemberInfos = queryMemberLLTFResult.getLLTFMemberInfo();
				//集团成员产品订购关系bean
				if (lLTFMemberInfos != null && lLTFMemberInfos.size() > 0) {
					LLTFMemberInfo lltfMemberInfo = lLTFMemberInfos.get(0);
					System.err.println(lltfMemberInfo.getDealName());
					//输出集团成员产品订购关系条数
					System.out.println("输出集团成员产品订购关系条数:" + lLTFMemberInfos.size());
					//输出集团产品套餐编码
					System.out.println("输出集团产品套餐编码:" + lltfMemberInfo.getECDealID());
				}
			}
			//输出异常编码
			System.out.println("异常编码" + resultInfo.getResultCode() + ":" + resultInfo.getResultMsg());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 流量统付集团成员产品叠加包受理
	 */
	public void orderMemberProductAdditionDemo() {
		//流量统付集团成员叠加包受理Bean
		LLTFMemberAddition lltfMemberAddition = new LLTFMemberAddition();
		//集团编码：必填
		lltfMemberAddition.setECCode("5911323401");
		//号码：必填
		lltfMemberAddition.setNumber("13459405894");//13906911180
		//叠加包套餐编码：必填
		lltfMemberAddition.setDealID("3831010234");// 3831010233
		Hashtable respHashtable = new Hashtable();
		try {
			//发送请求并接受响应内容
			respHashtable = flow.orderMemberProductAddition(lltfMemberAddition);
			//异常信息bean
			ResultInfo resultInfo = (ResultInfo) respHashtable.get("ResultInfo");
			//流量统付集团成员产品叠加包受理结果Bean
			LLTFMemberAdditionResult lltfMemberAdditionResult = (LLTFMemberAdditionResult) respHashtable.get("LLTFMemberAdditionResult");
			//输出异常编码
			System.out.println(resultInfo.getResultCode() + ":" + resultInfo.getResultMsg());
			//输出受理结果的错误原因
			if (!NoneType.isNull(lltfMemberAdditionResult) && !NoneType.isNullOrEmpty(lltfMemberAdditionResult.getResultMsg())) {
				System.out.println(lltfMemberAdditionResult.getResultMsg());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 流量统付集团成员产品批量受理
	 */
	public void batchOrderMemberProductDemo() {
		//定义流量统付集团成员产品受理Bean集合
		List<LLTFMemberOrder> LLTFMemberOrderList = new ArrayList<LLTFMemberOrder>();
		//流量统付集团成员产品受理Bean
		LLTFMemberOrder lltfMemberOrder = new LLTFMemberOrder();
		//号码：必填
		lltfMemberOrder.setNumber("13459405894");
		//操作编码：必填,01=开通、02=退订、03=调整成员套餐或流量值
		lltfMemberOrder.setOprCode("01");
		//套餐编码,统付模式=定额模式必填
		lltfMemberOrder.setDealID("3831001001");
		//成员流量：统付模式=定量模式时必填，单位MB
		lltfMemberOrder.setMemberAmount("1");
		//生效模式：必填，默认=2，1=立即生效、2=次月生效
		lltfMemberOrder.setEffType("1");
		//失效日期：必填，通用包订购的时候时间格式为YYYYMM，流量池订购的时候时间格式为YYYYMMDD
		lltfMemberOrder.setEndTime("20141230");
		//退订、 变更必填
		lltfMemberOrder.setECMemberOrderID("");
		//把lltfMemberOrder添加到LLTFMemberOrderList
		LLTFMemberOrderList.add(lltfMemberOrder);
		//流量统付集团成员产品受理Bean
		LLTFMemberOrder lltfMemberOrder2 = new LLTFMemberOrder();
		//号码：必填
		lltfMemberOrder2.setNumber("13459405895");
		//操作编码：必填,01=开通、02=退订、03=调整成员套餐或流量值
		lltfMemberOrder2.setOprCode("01");
		//套餐编码,统付模式=定额模式必填
		lltfMemberOrder2.setDealID("3831001001");
		//成员流量：统付模式=定量模式时必填，单位MB
		lltfMemberOrder2.setMemberAmount("5");
		//生效模式：必填，默认=2，1=立即生效、2=次月生效
		lltfMemberOrder2.setEffType("1");
		//失效日期：必填，通用包订购的时候时间格式为YYYYMM，流量池订购的时候时间格式为YYYYMMDD
		lltfMemberOrder2.setEndTime("20151130");
		//退订、 变更必填
		lltfMemberOrder.setECMemberOrderID("");
		//把lltfMemberOrder添加到LLTFMemberOrderList
		LLTFMemberOrderList.add(lltfMemberOrder2);
		//把流量统付集团成员产品受理Bean集合赋值给BatchLLTFMemberOrder
		BatchLLTFMemberOrder batchLLTFMemberOrder = new BatchLLTFMemberOrder();
		//集团编码：必填
		batchLLTFMemberOrder.setECCode("5911914920");//5911323401
		//统付模式
		batchLLTFMemberOrder.setMode("3");
		batchLLTFMemberOrder.setLLTFMemberOrder(LLTFMemberOrderList);
		//设置第三方回调接口地址，流量统付平台批量处理完成后可根据该回调地址将处理结果返回给第三方
		batchLLTFMemberOrder.setCallbackUrl("http://ip:port/....");
		Hashtable respHashtable = new Hashtable();
		try {
			//发送请求并接受响应内容
			respHashtable = flow.batchOrderMemberProduct(batchLLTFMemberOrder);
			//异常信息bean
			ResultInfo resultInfo = (ResultInfo) respHashtable.get("ResultInfo");
			//批次处理结果信息
			BatchResult batchResult = (BatchResult) respHashtable.get("BatchResult");
			//输出批次号
			if (batchResult != null && !NoneType.isNullOrEmpty(batchResult.getLno())) {
				System.out.println(batchResult.getLno());
			}
			System.out.println(resultInfo.getResultCode() + ":" + resultInfo.getResultMsg());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 流量统付集团成员产品叠加包批量受理
	 */
	public void batchOrderMemberProductAdditionDemo() {
		//定义流量统付集团成员产品叠加包受理Bean集合
		List<LLTFMemberAddition> LLTFMemberAdditionList = new ArrayList<LLTFMemberAddition>();
		//流量统付集团成员叠加包受理Bean
		LLTFMemberAddition lltfMemberAddition = new LLTFMemberAddition();
		//号码：必填
		lltfMemberAddition.setNumber("13459405894");
		//叠加包套餐编码：必填
		lltfMemberAddition.setDealID("3831010233");
		LLTFMemberAdditionList.add(lltfMemberAddition);
		//流量统付集团成员叠加包受理Bean
		LLTFMemberAddition lltfMemberAddition2 = new LLTFMemberAddition();
		//号码：必填
		lltfMemberAddition2.setNumber("13459405895");
		//叠加包套餐编码：必填
		lltfMemberAddition2.setDealID("3831010233");
		LLTFMemberAdditionList.add(lltfMemberAddition2);
		//把流量统付集团成员产品受理Bean集合赋值给BatchLLTFMemberOrder
		BatchLLTFMemberAddition batchLLTFMemberAddition = new BatchLLTFMemberAddition();
		batchLLTFMemberAddition.setLLTFMemberAddition(LLTFMemberAdditionList);
		//集团编码：必填
		batchLLTFMemberAddition.setECCode("5911914920");
		//设置第三方回调接口地址，流量统付平台批量处理完成后可根据该回调地址将处理结果返回给第三方
		batchLLTFMemberAddition.setCallbackUrl("http://ip:port/....");
		Hashtable respHashtable = new Hashtable();
		try {
			//发送请求并接受响应内容
			respHashtable = flow.batchOrderMemberProductAddition(batchLLTFMemberAddition);
			//异常信息bean
			ResultInfo resultInfo = (ResultInfo) respHashtable.get("ResultInfo");
			//批次处理结果信息
			BatchResult batchResult = (BatchResult) respHashtable.get("BatchResult");
			//输出批次号
			if (batchResult != null && !NoneType.isNullOrEmpty(batchResult.getLno())) {
				System.out.println(batchResult.getLno());
			}
			System.out.println(resultInfo.getResultCode() + ":" + resultInfo.getResultMsg());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 流量统付集团成员产品批量状态查询
	 */
	public void getBatchOrderStatusDemo() {
		//流量统付集团成员产品批量状态查询请求bean
		QueryBatchDetails queryBatchDetails = new QueryBatchDetails();
		//批次号:必填
		queryBatchDetails.setLno("2d722296169746d59fbf84ac8aa54f3e");
		Hashtable respHashtable = new Hashtable();
		try {
			//发送请求并接受响应内容
			respHashtable = flow.getBatchOrderStatus(queryBatchDetails);
			//异常信息bean
			ResultInfo resultInfo = (ResultInfo) respHashtable.get("ResultInfo");
			//该批次下明细产品受理bean集合
			QueryBatchDetailsResult queryBatchDetailsResult = (QueryBatchDetailsResult) respHashtable.get("QueryBatchDetailsResult");
			if (queryBatchDetailsResult != null) {
				List<TS_OPRECORD> TS_OPRECORDS = queryBatchDetailsResult.getTS_OPRECORD();
				for (TS_OPRECORD tsOPRECORD : TS_OPRECORDS) {
					//输出成员号码和受理结果编码
					System.out.println(tsOPRECORD.getPHONE() + ":" + tsOPRECORD.getRESULTCODE());
				}
				if (TS_OPRECORDS.size() == 0) {
					System.out.println("暂无数据");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}