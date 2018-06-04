package com.fmcq.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="client")
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;	//ID
	private String name;	//名称
	private String number;	//编号
	private String type;	//类型
	private String controllermodel;	//控制器型号
	private String area;	//所属区域
	private String sn;	//序列号
	private String sim;	//终端内嵌的手机卡号
	private Integer state;	//设备状态 1-正常 2-超时 3-离线 4-故障 5-无效
	private String ip;	//终端的IP地址
	private Date time;	//最后连接时间
	private String alert;	//断线事件，可以回调或者邮件通知
	private String remark;	//备注
	private String data;	//设备详细信息
	private String latitude;	//纬度
	private String longitude;	//经度

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="number")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Column(name="type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name="controllermodel")
	public String getControllermodel() {
		return controllermodel;
	}

	public void setControllermodel(String controllermodel) {
		this.controllermodel = controllermodel;
	}

	@Column(name="area")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name="sn")
	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	@Column(name="sim")
	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	@Column(name="state")
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name="ip")
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="time")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name="alert")
	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	@Column(name="remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name="data")
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Column(name="latitude")
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Column(name="longitude")
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
