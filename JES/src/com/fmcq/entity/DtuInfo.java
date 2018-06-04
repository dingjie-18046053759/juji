package com.fmcq.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * DtuInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="dtu_info")
public class DtuInfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer alarm;
	private Integer cell;
	private Date create_time;
	private Integer lac;
	private Integer mnc;
	private Integer prealarm;
	private Integer session_id;
	private String sim;
	private String sn;
	private Date update_time;
	private Integer ablv;
	private Integer aclv;
	private Integer apc;
	private Integer av;
	private Float batbol;
	private Integer bclv;
	private Integer bpc;
	private Integer bv;
	private Integer cpc;
	private Integer ctrdiginput;
	private Integer ctroutput;
	private Integer cv;
	private Integer eablv;
	private Integer eaclv;
	private Integer eapv;
	private Integer ebclv;
	private Integer ebpv;
	private Integer ecpv;
	private Float ef;
	private Float gpf;
	private String led;
	private Float op;
	private Float pgf;
	private Integer rs;
	private Integer totalap;
	private Integer totalip;
	private Integer totaltime;
	private Float wt;
	private String lat;
	private String lon;
	private int status;//状态 0 表示未上线 1表示上线
	
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="alarm")
	public Integer getAlarm() {
		return alarm;
	}
	public void setAlarm(Integer alarm) {
		this.alarm = alarm;
	}
	@Column(name="cell")
	public Integer getCell() {
		return cell;
	}
	public void setCell(Integer cell) {
		this.cell = cell;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="create_time")
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	@Column(name="lac")
	public Integer getLac() {
		return lac;
	}
	
	public void setLac(Integer lac) {
		this.lac = lac;
	}
	@Column(name="mnc")
	public Integer getMnc() {
		return mnc;
	}
	public void setMnc(Integer mnc) {
		this.mnc = mnc;
	}
	@Column(name="prealarm")
	public Integer getPrealarm() {
		return prealarm;
	}
	public void setPrealarm(Integer prealarm) {
		this.prealarm = prealarm;
	}
	@Column(name="session_id")
	public Integer getSession_id() {
		return session_id;
	}
	public void setSession_id(Integer session_id) {
		this.session_id = session_id;
	}
	
	@Column(name="sim")
	public String getSim() {
		return sim;
	}
	
	public void setSim(String sim) {
		this.sim = sim;
	}
	@Column(name="sn")
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		
		this.sn = sn;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="update_time")
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
	@Column(name="ablv")
	public Integer getAblv() {
		return ablv;
	}
	
	public void setAblv(Integer ablv) {
		this.ablv = ablv;
	}
	@Column(name="aclv")
	public Integer getAclv() {
		return aclv;
	}
	public void setAclv(Integer aclv) {
		this.aclv = aclv;
	}
	@Column(name="apc")
	public Integer getApc() {
		return apc;
	}
	public void setApc(Integer apc) {
		this.apc = apc;
	}
	@Column(name="av")
	public Integer getAv() {
		return av;
	}
	public void setAv(Integer av) {
		this.av = av;
	}
	@Column(name="batbol")
	public Float getBatbol() {
		return batbol;
	}
	public void setBatbol(Float batbol) {
		this.batbol = batbol;
	}
	@Column(name="bclv")
	public Integer getBclv() {
		return bclv;
	}
	public void setBclv(Integer bclv) {
		this.bclv = bclv;
	}
	@Column(name="bpc")
	public Integer getBpc() {
		return bpc;
	}
	public void setBpc(Integer bpc) {
		this.bpc = bpc;
	}
	@Column(name="bv")
	public Integer getBv() {
		return bv;
	}
	public void setBv(Integer bv) {
		this.bv = bv;
	}
	@Column(name="cpc")
	public Integer getCpc() {
		return cpc;
	}
	public void setCpc(Integer cpc) {
		this.cpc = cpc;
	}
	@Column(name="ctrdiginput")
	public Integer getCtrdiginput() {
		return ctrdiginput;
	}
	public void setCtrdiginput(Integer ctrdiginput) {
		this.ctrdiginput = ctrdiginput;
	}
	@Column(name="ctroutput")
	public Integer getCtroutput() {
		return ctroutput;
	}
	public void setCtroutput(Integer ctroutput) {
		this.ctroutput = ctroutput;
	}
	@Column(name="cv")
	public Integer getCv() {
		return cv;
	}
	public void setCv(Integer cv) {
		this.cv = cv;
	}
	@Column(name="eablv")
	public Integer getEablv() {
		return eablv;
	}
	public void setEablv(Integer eablv) {
		this.eablv = eablv;
	}
	@Column(name="eaclv")
	public Integer getEaclv() {
		return eaclv;
	}
	public void setEaclv(Integer eaclv) {
		this.eaclv = eaclv;
	}
	@Column(name="eapv")
	public Integer getEapv() {
		return eapv;
	}
	public void setEapv(Integer eapv) {
		this.eapv = eapv;
	}
	@Column(name="ebclv")
	public Integer getEbclv() {
		return ebclv;
	}
	public void setEbclv(Integer ebclv) {
		this.ebclv = ebclv;
	}
	@Column(name="ebpv")
	public Integer getEbpv() {
		return ebpv;
	}
	public void setEbpv(Integer ebpv) {
	
		this.ebpv = ebpv;
	}
	@Column(name="ecpv")
	public Integer getEcpv() {
		return ecpv;
	}
	public void setEcpv(Integer ecpv) {
		this.ecpv = ecpv;
	}
	@Column(name="ef")
	public Float getEf() {
		return ef;
	}
	public void setEf(Float ef) {
		this.ef = ef;
	}
	@Column(name="gpf")
	public Float getGpf() {
		return gpf;
	}
	public void setGpf(Float gpf) {
		this.gpf = gpf;
	}
	@Column(name="led")
	public String getLed() {
		return led;
	}
	public void setLed(String led) {
		this.led = led;
	}
	@Column(name="op")
	public Float getOp() {
		return op;
	}
	public void setOp(Float op) {
		this.op = op;
	}
	@Column(name="pgf")
	public Float getPgf() {
		return pgf;
	}
	public void setPgf(Float pgf) {
		this.pgf = pgf;
	}
	@Column(name="rs")
	public Integer getRs() {
		return rs;
	}
	public void setRs(Integer rs) {
		this.rs = rs;
	}
	@Column(name="totalap")
	public Integer getTotalap() {
		return totalap;
	}
	public void setTotalap(Integer totalap) {
		this.totalap = totalap;
	}
	@Column(name="totalip")
	public Integer getTotalip() {
		return totalip;
	}
	public void setTotalip(Integer totalip) {
		this.totalip = totalip;
	}
	@Column(name="totaltime")
	public Integer getTotaltime() {
		return totaltime;
	}
	public void setTotaltime(Integer totaltime) {
		this.totaltime = totaltime;
	}
	@Column(name="wt")
	public Float getWt() {
		return wt;
	}
	public void setWt(Float wt) {
		this.wt = wt;
	}
	@Column(name="lat")
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	@Column(name="lon")
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	@Column(name="status")
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	
}