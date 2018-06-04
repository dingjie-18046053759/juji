package com.fmcq.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 范伟禄
 * @createtime 2015年3月11日下午2:25:26
 * @category 条件查询工具
 */
public class QueryUtil {
	private List<QueryCond> list=new ArrayList<QueryCond>();
	private String order="";
	
	/**
	 * 默认排序为 id desc
	 */
	public QueryUtil(){
		this("id desc");
	}
	
	public QueryUtil(String order){
		this.order=order;
	}
	
	/**
	 * 获取HQL条件字符串，包含where, 不包括order by 
	 * @return
	 */
	public String getHQL(){
		StringBuilder sb=new StringBuilder();
		int i=0;
		for(QueryCond cond :list){
			String str="";
			if(i>0){
				sb.append(cond.getAndOr());
			}
			
			if(cond.getType().equals("moreor")){
				String[] fiilds=cond.getField().split(",");
				sb.append("(");
				for(int k=0;k<fiilds.length;k++){
					if(k>0){
						sb.append(" or ");
					}

					str=String.format("%s %s ('%%%s%%')", fiilds[k],"like",cond.getValue());
					sb.append(str);
				}

				sb.append(")");
			}
			else{
				if(cond.getType().equals("like")){
					str=String.format("%s %s ('%%%s%%')", cond.getField(),cond.getType(),cond.getValue());
				}else if(cond.getType().equals("in")){
					str=String.format("%s %s ('%s')", cond.getField(),cond.getType(),cond.getValue());
				}else if(cond.getType().equals("between")){
					str=String.format("%s %s %s and %s", cond.getField(),cond.getType(),cond.getMinVal(),cond.getMaxVal());
				}else{
					str=String.format("%s %s '%s'", cond.getField(),cond.getType(),cond.getValue());
				}
				sb.append(str);
			}
			i++;
		}
		if(sb.length()>0){
			sb.insert(0, " where ");
		}
		return sb.toString();
	}
	
	/**
	 * 获取排序
	 * @return
	 */
	public String getOrder(){
		if(order!=null&&"".equals(order)==false){
			return " order by "+order;
		}
		return "";
	}
	
	/**
	 * 创建相等的条件
	 * @param field 字段名
	 * @param value 值
	 * @return
	 */
	public void equal(String andOr,String field,Object value){
		if(value!=null&&"".equals(value)==false){
			list.add(new QueryCond(andOr, field, value, "="));
		}		 
	}
	/**
	 * 创建不相等的条件
	 * @param field 字段名
	 * @param value 值
	 * @return
	 */
	public void notEqual(String andOr, String field,Object value){
		if(value!=null&&"".equals(value)==false){
			list.add(new QueryCond(andOr, field, value, "<>"));
		}
	}
	/**
	 * 创建模糊相等的条件
	 * @param field 字段名
	 * @param value 值
	 * @return
	 */
	public void like(String andOr, String field,Object value){
		if(value!=null){
			list.add(new QueryCond(andOr, field, value, "like"));
		}
	}
	/**
	 * 创建大于的条件
	 * @param field 字段名
	 * @param value 值
	 * @return
	 */
	public void createrThan(String andOr, String field,Object value){
		if(value!=null&&"".equals(value)==false){
			list.add(new QueryCond(andOr, field, value, ">"));
		}
	}
	/**
	 * 创建小于的条件
	 * @param field 字段名
	 * @param value 值
	 * @return
	 */
	public void lessThan(String andOr, String field,Object value){
		if(value!=null&&"".equals(value)==false){
			list.add(new QueryCond(andOr, field, value, "<"));
		}
	}
	/**
	 * 创建大或等于的条件
	 * @param field 字段名
	 * @param value 值
	 * @return
	 */
	public void createrOrEqual(String andOr, String field,Object value){
		if(value!=null&&"".equals(value)==false){
			list.add(new QueryCond(andOr, field, value, ">="));
		}
	}
	/**
	 * 创建小或等于的条件
	 * @param field 字段名
	 * @param value 值
	 * @return
	 */
	public void lessOrEqual(String andOr, String field,Object value){
		if(value!=null&&"".equals(value)==false){
			list.add(new QueryCond(andOr, field, value, "<="));
		}
	}
	/**
	 * 创建in的条件
	 * @param field 字段名
	 * @param value 值
	 * @return
	 */
	public void in(String andOr, String field,Object value){
		if(value!=null&&"".equals(value)==false){
			list.add(new QueryCond(andOr, field, value, "in"));
		}
	}
	/**
	 * 创建between条件，局限数字和日期类型
	 * @param andOr and或or, 不能带空格
	 * @param field 字段名
	 * @param minVal 最小值
	 * @param maxVal 最大值
	 * @return
	 */
	public void between(String andOr, String field,String minVal,String maxVal){
		if(minVal!=null&&maxVal!=null&&"".equals(minVal)==false&&"".equals(maxVal)==false){
			list.add(new QueryCond(andOr, field, "between", minVal,maxVal));
		}
	}
	
	/**
	 * or带括弧格式
	 * @param field
	 * @param value
	 */
	public void moreOr(String field, Object value){
		if(value!=null&&"".equals(value)==false){
			list.add(new QueryCond("and", field, value, "moreor"));
		}
	}
	
	/**
	 * 创建相等的条件
	 * @param field 字段名
	 * @param value 值
	 * @return
	 */
	public void equal(String field,Object value){
		equal("and",field,value);		 
	}
	/**
	 * 创建不相等的条件
	 * @param field 字段名
	 * @param value 值
	 * @return
	 */
	public void notEqual(String field,Object value){
		notEqual("and",field,value);
	}
	/**
	 * 创建模糊相等的条件
	 * @param field 字段名
	 * @param value 值
	 * @return
	 */
	public void like(String field,Object value){
		like("and",field,value);
	}
	/**
	 * 创建大于的条件
	 * @param field 字段名
	 * @param value 值
	 * @return
	 */
	public void createrThan(String field,Object value){
		createrThan("and",field,value);
	}
	/**
	 * 创建小于的条件
	 * @param field 字段名
	 * @param value 值
	 * @return
	 */
	public void lessThan(String field,Object value){
		lessThan("and",field,value);
	}
	/**
	 * 创建大或等于的条件
	 * @param field 字段名
	 * @param value 值
	 * @return
	 */
	public void createrOrEqual(String field,Object value){
		createrOrEqual("and",field,value);
	}
	/**
	 * 创建小或等于的条件
	 * @param field 字段名
	 * @param value 值
	 * @return
	 */
	public void lessOrEqual(String field,Object value){
		lessOrEqual("and",field,value);
	}
	/**
	 * 创建in的条件
	 * @param field 字段名
	 * @param value 值
	 * @return
	 */
	public void in(String field,Object value){
		in("and",field,value);
	}
	/**
	 * 创建between条件，局限数字和日期类型
	 * @param field 字段名
	 * @param minVal 最小值
	 * @param maxVal 最大值
	 * @return
	 */
	public void between(String field,String minVal,String maxVal){
		between("and",field,minVal,maxVal);
	}
}

class QueryCond {
	private String field;
	private Object value;
	private String type;
	private String maxVal;
	private String minVal;
	private String andOr;
	public QueryCond(String andOr, String field, String type, String minVal, String maxVal) {
		super();
		this.field = field;
		this.type = type;
		this.minVal = minVal;
		this.maxVal = maxVal;
		
		if(andOr==null||"or".equals(andOr.toLowerCase().trim())==false){
			this.andOr=" and ";
		}
		else {
			this.andOr=" or ";
		}
	}		
	
	public QueryCond(String andOr, String field, Object value, String type) {
		super();
		this.field = field;
		this.value = value;
		this.type = type;
		
		if(andOr==null||"or".equals(andOr.toLowerCase().trim())==false){
			this.andOr=" and ";
		}
		else {
			this.andOr=" or ";
		}
	}

	public String getAndOr() {
		return andOr;
	}

	public void setAndOr(String andOr) {
		this.andOr = andOr;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getMaxVal() {
		return maxVal;
	}
	public void setMaxVal(String maxVal) {
		this.maxVal = maxVal;
	}
	public String getMinVal() {
		return minVal;
	}
	public void setMinVal(String minVal) {
		this.minVal = minVal;
	}
}
