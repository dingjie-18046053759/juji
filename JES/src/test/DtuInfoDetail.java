package test;

import java.sql.Timestamp;

/**
 * DtuInfoDetail entity. @author MyEclipse Persistence Tools
 */

public class DtuInfoDetail implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer alarm;
	private Integer cell;
	private Timestamp createTime;
	private Integer lac;
	private Integer mnc;
	private Integer prealarm;
	private Integer sessionId;
	private String sim;
	private String sn;
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

	// Constructors

	/** default constructor */
	public DtuInfoDetail() {
	}

	/** minimal constructor */
	public DtuInfoDetail(Integer alarm, Integer cell, Integer lac, Integer mnc,
			Integer prealarm, Integer sessionId, Integer ablv, Integer aclv,
			Integer apc, Integer av, Float batbol, Integer bclv, Integer bpc,
			Integer bv, Integer cpc, Integer ctrdiginput, Integer ctroutput,
			Integer cv, Integer eablv, Integer eaclv, Integer eapv,
			Integer ebclv, Integer ebpv, Integer ecpv, Float ef, Float gpf,
			Float op, Float pgf, Integer rs, Integer totalap, Integer totalip,
			Integer totaltime, Float wt) {
		this.alarm = alarm;
		this.cell = cell;
		this.lac = lac;
		this.mnc = mnc;
		this.prealarm = prealarm;
		this.sessionId = sessionId;
		this.ablv = ablv;
		this.aclv = aclv;
		this.apc = apc;
		this.av = av;
		this.batbol = batbol;
		this.bclv = bclv;
		this.bpc = bpc;
		this.bv = bv;
		this.cpc = cpc;
		this.ctrdiginput = ctrdiginput;
		this.ctroutput = ctroutput;
		this.cv = cv;
		this.eablv = eablv;
		this.eaclv = eaclv;
		this.eapv = eapv;
		this.ebclv = ebclv;
		this.ebpv = ebpv;
		this.ecpv = ecpv;
		this.ef = ef;
		this.gpf = gpf;
		this.op = op;
		this.pgf = pgf;
		this.rs = rs;
		this.totalap = totalap;
		this.totalip = totalip;
		this.totaltime = totaltime;
		this.wt = wt;
	}

	/** full constructor */
	public DtuInfoDetail(Integer alarm, Integer cell, Timestamp createTime,
			Integer lac, Integer mnc, Integer prealarm, Integer sessionId,
			String sim, String sn, Integer ablv, Integer aclv, Integer apc,
			Integer av, Float batbol, Integer bclv, Integer bpc, Integer bv,
			Integer cpc, Integer ctrdiginput, Integer ctroutput, Integer cv,
			Integer eablv, Integer eaclv, Integer eapv, Integer ebclv,
			Integer ebpv, Integer ecpv, Float ef, Float gpf, String led,
			Float op, Float pgf, Integer rs, Integer totalap, Integer totalip,
			Integer totaltime, Float wt, String lat, String lon) {
		this.alarm = alarm;
		this.cell = cell;
		this.createTime = createTime;
		this.lac = lac;
		this.mnc = mnc;
		this.prealarm = prealarm;
		this.sessionId = sessionId;
		this.sim = sim;
		this.sn = sn;
		this.ablv = ablv;
		this.aclv = aclv;
		this.apc = apc;
		this.av = av;
		this.batbol = batbol;
		this.bclv = bclv;
		this.bpc = bpc;
		this.bv = bv;
		this.cpc = cpc;
		this.ctrdiginput = ctrdiginput;
		this.ctroutput = ctroutput;
		this.cv = cv;
		this.eablv = eablv;
		this.eaclv = eaclv;
		this.eapv = eapv;
		this.ebclv = ebclv;
		this.ebpv = ebpv;
		this.ecpv = ecpv;
		this.ef = ef;
		this.gpf = gpf;
		this.led = led;
		this.op = op;
		this.pgf = pgf;
		this.rs = rs;
		this.totalap = totalap;
		this.totalip = totalip;
		this.totaltime = totaltime;
		this.wt = wt;
		this.lat = lat;
		this.lon = lon;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAlarm() {
		return this.alarm;
	}

	public void setAlarm(Integer alarm) {
		this.alarm = alarm;
	}

	public Integer getCell() {
		return this.cell;
	}

	public void setCell(Integer cell) {
		this.cell = cell;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getLac() {
		return this.lac;
	}

	public void setLac(Integer lac) {
		this.lac = lac;
	}

	public Integer getMnc() {
		return this.mnc;
	}

	public void setMnc(Integer mnc) {
		this.mnc = mnc;
	}

	public Integer getPrealarm() {
		return this.prealarm;
	}

	public void setPrealarm(Integer prealarm) {
		this.prealarm = prealarm;
	}

	public Integer getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}

	public String getSim() {
		return this.sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public String getSn() {
		return this.sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Integer getAblv() {
		return this.ablv;
	}

	public void setAblv(Integer ablv) {
		this.ablv = ablv;
	}

	public Integer getAclv() {
		return this.aclv;
	}

	public void setAclv(Integer aclv) {
		this.aclv = aclv;
	}

	public Integer getApc() {
		return this.apc;
	}

	public void setApc(Integer apc) {
		this.apc = apc;
	}

	public Integer getAv() {
		return this.av;
	}

	public void setAv(Integer av) {
		this.av = av;
	}

	public Float getBatbol() {
		return this.batbol;
	}

	public void setBatbol(Float batbol) {
		this.batbol = batbol;
	}

	public Integer getBclv() {
		return this.bclv;
	}

	public void setBclv(Integer bclv) {
		this.bclv = bclv;
	}

	public Integer getBpc() {
		return this.bpc;
	}

	public void setBpc(Integer bpc) {
		this.bpc = bpc;
	}

	public Integer getBv() {
		return this.bv;
	}

	public void setBv(Integer bv) {
		this.bv = bv;
	}

	public Integer getCpc() {
		return this.cpc;
	}

	public void setCpc(Integer cpc) {
		this.cpc = cpc;
	}

	public Integer getCtrdiginput() {
		return this.ctrdiginput;
	}

	public void setCtrdiginput(Integer ctrdiginput) {
		this.ctrdiginput = ctrdiginput;
	}

	public Integer getCtroutput() {
		return this.ctroutput;
	}

	public void setCtroutput(Integer ctroutput) {
		this.ctroutput = ctroutput;
	}

	public Integer getCv() {
		return this.cv;
	}

	public void setCv(Integer cv) {
		this.cv = cv;
	}

	public Integer getEablv() {
		return this.eablv;
	}

	public void setEablv(Integer eablv) {
		this.eablv = eablv;
	}

	public Integer getEaclv() {
		return this.eaclv;
	}

	public void setEaclv(Integer eaclv) {
		this.eaclv = eaclv;
	}

	public Integer getEapv() {
		return this.eapv;
	}

	public void setEapv(Integer eapv) {
		this.eapv = eapv;
	}

	public Integer getEbclv() {
		return this.ebclv;
	}

	public void setEbclv(Integer ebclv) {
		this.ebclv = ebclv;
	}

	public Integer getEbpv() {
		return this.ebpv;
	}

	public void setEbpv(Integer ebpv) {
		this.ebpv = ebpv;
	}

	public Integer getEcpv() {
		return this.ecpv;
	}

	public void setEcpv(Integer ecpv) {
		this.ecpv = ecpv;
	}

	public Float getEf() {
		return this.ef;
	}

	public void setEf(Float ef) {
		this.ef = ef;
	}

	public Float getGpf() {
		return this.gpf;
	}

	public void setGpf(Float gpf) {
		this.gpf = gpf;
	}

	public String getLed() {
		return this.led;
	}

	public void setLed(String led) {
		this.led = led;
	}

	public Float getOp() {
		return this.op;
	}

	public void setOp(Float op) {
		this.op = op;
	}

	public Float getPgf() {
		return this.pgf;
	}

	public void setPgf(Float pgf) {
		this.pgf = pgf;
	}

	public Integer getRs() {
		return this.rs;
	}

	public void setRs(Integer rs) {
		this.rs = rs;
	}

	public Integer getTotalap() {
		return this.totalap;
	}

	public void setTotalap(Integer totalap) {
		this.totalap = totalap;
	}

	public Integer getTotalip() {
		return this.totalip;
	}

	public void setTotalip(Integer totalip) {
		this.totalip = totalip;
	}

	public Integer getTotaltime() {
		return this.totaltime;
	}

	public void setTotaltime(Integer totaltime) {
		this.totaltime = totaltime;
	}

	public Float getWt() {
		return this.wt;
	}

	public void setWt(Float wt) {
		this.wt = wt;
	}

	public String getLat() {
		return this.lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return this.lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

}