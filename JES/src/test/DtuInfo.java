package test;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DtuInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dtu_info", catalog = "jes")
public class DtuInfo implements java.io.Serializable {

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
	private Timestamp updateTime;
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
	private Timestamp createTime_1;
	private Integer sessionId_1;
	private Timestamp updateTime_1;

	// Constructors

	/** default constructor */
	public DtuInfo() {
	}

	/** minimal constructor */
	public DtuInfo(Integer alarm, Integer cell, Integer lac, Integer mnc,
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
	public DtuInfo(Integer alarm, Integer cell, Timestamp createTime,
			Integer lac, Integer mnc, Integer prealarm, Integer sessionId,
			String sim, String sn, Timestamp updateTime, Integer ablv,
			Integer aclv, Integer apc, Integer av, Float batbol, Integer bclv,
			Integer bpc, Integer bv, Integer cpc, Integer ctrdiginput,
			Integer ctroutput, Integer cv, Integer eablv, Integer eaclv,
			Integer eapv, Integer ebclv, Integer ebpv, Integer ecpv, Float ef,
			Float gpf, String led, Float op, Float pgf, Integer rs,
			Integer totalap, Integer totalip, Integer totaltime, Float wt,
			String lat, String lon, Timestamp createTime_1,
			Integer sessionId_1, Timestamp updateTime_1) {
		this.alarm = alarm;
		this.cell = cell;
		this.createTime = createTime;
		this.lac = lac;
		this.mnc = mnc;
		this.prealarm = prealarm;
		this.sessionId = sessionId;
		this.sim = sim;
		this.sn = sn;
		this.updateTime = updateTime;
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
		this.createTime_1 = createTime_1;
		this.sessionId_1 = sessionId_1;
		this.updateTime_1 = updateTime_1;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "alarm", nullable = false)
	public Integer getAlarm() {
		return this.alarm;
	}

	public void setAlarm(Integer alarm) {
		this.alarm = alarm;
	}

	@Column(name = "cell", nullable = false)
	public Integer getCell() {
		return this.cell;
	}

	public void setCell(Integer cell) {
		this.cell = cell;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "lac", nullable = false)
	public Integer getLac() {
		return this.lac;
	}

	public void setLac(Integer lac) {
		this.lac = lac;
	}

	@Column(name = "mnc", nullable = false)
	public Integer getMnc() {
		return this.mnc;
	}

	public void setMnc(Integer mnc) {
		this.mnc = mnc;
	}

	@Column(name = "prealarm", nullable = false)
	public Integer getPrealarm() {
		return this.prealarm;
	}

	public void setPrealarm(Integer prealarm) {
		this.prealarm = prealarm;
	}

	@Column(name = "session_id", nullable = false)
	public Integer getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}

	@Column(name = "sim")
	public String getSim() {
		return this.sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	@Column(name = "sn")
	public String getSn() {
		return this.sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	@Column(name = "update_time", length = 19)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "ablv", nullable = false)
	public Integer getAblv() {
		return this.ablv;
	}

	public void setAblv(Integer ablv) {
		this.ablv = ablv;
	}

	@Column(name = "aclv", nullable = false)
	public Integer getAclv() {
		return this.aclv;
	}

	public void setAclv(Integer aclv) {
		this.aclv = aclv;
	}

	@Column(name = "apc", nullable = false)
	public Integer getApc() {
		return this.apc;
	}

	public void setApc(Integer apc) {
		this.apc = apc;
	}

	@Column(name = "av", nullable = false)
	public Integer getAv() {
		return this.av;
	}

	public void setAv(Integer av) {
		this.av = av;
	}

	@Column(name = "batbol", nullable = false, precision = 12, scale = 0)
	public Float getBatbol() {
		return this.batbol;
	}

	public void setBatbol(Float batbol) {
		this.batbol = batbol;
	}

	@Column(name = "bclv", nullable = false)
	public Integer getBclv() {
		return this.bclv;
	}

	public void setBclv(Integer bclv) {
		this.bclv = bclv;
	}

	@Column(name = "bpc", nullable = false)
	public Integer getBpc() {
		return this.bpc;
	}

	public void setBpc(Integer bpc) {
		this.bpc = bpc;
	}

	@Column(name = "bv", nullable = false)
	public Integer getBv() {
		return this.bv;
	}

	public void setBv(Integer bv) {
		this.bv = bv;
	}

	@Column(name = "cpc", nullable = false)
	public Integer getCpc() {
		return this.cpc;
	}

	public void setCpc(Integer cpc) {
		this.cpc = cpc;
	}

	@Column(name = "ctrdiginput", nullable = false)
	public Integer getCtrdiginput() {
		return this.ctrdiginput;
	}

	public void setCtrdiginput(Integer ctrdiginput) {
		this.ctrdiginput = ctrdiginput;
	}

	@Column(name = "ctroutput", nullable = false)
	public Integer getCtroutput() {
		return this.ctroutput;
	}

	public void setCtroutput(Integer ctroutput) {
		this.ctroutput = ctroutput;
	}

	@Column(name = "cv", nullable = false)
	public Integer getCv() {
		return this.cv;
	}

	public void setCv(Integer cv) {
		this.cv = cv;
	}

	@Column(name = "eablv", nullable = false)
	public Integer getEablv() {
		return this.eablv;
	}

	public void setEablv(Integer eablv) {
		this.eablv = eablv;
	}

	@Column(name = "eaclv", nullable = false)
	public Integer getEaclv() {
		return this.eaclv;
	}

	public void setEaclv(Integer eaclv) {
		this.eaclv = eaclv;
	}

	@Column(name = "eapv", nullable = false)
	public Integer getEapv() {
		return this.eapv;
	}

	public void setEapv(Integer eapv) {
		this.eapv = eapv;
	}

	@Column(name = "ebclv", nullable = false)
	public Integer getEbclv() {
		return this.ebclv;
	}

	public void setEbclv(Integer ebclv) {
		this.ebclv = ebclv;
	}

	@Column(name = "ebpv", nullable = false)
	public Integer getEbpv() {
		return this.ebpv;
	}

	public void setEbpv(Integer ebpv) {
		this.ebpv = ebpv;
	}

	@Column(name = "ecpv", nullable = false)
	public Integer getEcpv() {
		return this.ecpv;
	}

	public void setEcpv(Integer ecpv) {
		this.ecpv = ecpv;
	}

	@Column(name = "ef", nullable = false, precision = 12, scale = 0)
	public Float getEf() {
		return this.ef;
	}

	public void setEf(Float ef) {
		this.ef = ef;
	}

	@Column(name = "gpf", nullable = false, precision = 12, scale = 0)
	public Float getGpf() {
		return this.gpf;
	}

	public void setGpf(Float gpf) {
		this.gpf = gpf;
	}

	@Column(name = "led")
	public String getLed() {
		return this.led;
	}

	public void setLed(String led) {
		this.led = led;
	}

	@Column(name = "op", nullable = false, precision = 12, scale = 0)
	public Float getOp() {
		return this.op;
	}

	public void setOp(Float op) {
		this.op = op;
	}

	@Column(name = "pgf", nullable = false, precision = 12, scale = 0)
	public Float getPgf() {
		return this.pgf;
	}

	public void setPgf(Float pgf) {
		this.pgf = pgf;
	}

	@Column(name = "rs", nullable = false)
	public Integer getRs() {
		return this.rs;
	}

	public void setRs(Integer rs) {
		this.rs = rs;
	}

	@Column(name = "totalap", nullable = false)
	public Integer getTotalap() {
		return this.totalap;
	}

	public void setTotalap(Integer totalap) {
		this.totalap = totalap;
	}

	@Column(name = "totalip", nullable = false)
	public Integer getTotalip() {
		return this.totalip;
	}

	public void setTotalip(Integer totalip) {
		this.totalip = totalip;
	}

	@Column(name = "totaltime", nullable = false)
	public Integer getTotaltime() {
		return this.totaltime;
	}

	public void setTotaltime(Integer totaltime) {
		this.totaltime = totaltime;
	}

	@Column(name = "wt", nullable = false, precision = 12, scale = 0)
	public Float getWt() {
		return this.wt;
	}

	public void setWt(Float wt) {
		this.wt = wt;
	}

	@Column(name = "lat")
	public String getLat() {
		return this.lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	@Column(name = "lon")
	public String getLon() {
		return this.lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	@Column(name = "createTime", length = 19)
	public Timestamp getCreateTime_1() {
		return this.createTime_1;
	}

	public void setCreateTime_1(Timestamp createTime_1) {
		this.createTime_1 = createTime_1;
	}

	@Column(name = "sessionId")
	public Integer getSessionId_1() {
		return this.sessionId_1;
	}

	public void setSessionId_1(Integer sessionId_1) {
		this.sessionId_1 = sessionId_1;
	}

	@Column(name = "updateTime", length = 19)
	public Timestamp getUpdateTime_1() {
		return this.updateTime_1;
	}

	public void setUpdateTime_1(Timestamp updateTime_1) {
		this.updateTime_1 = updateTime_1;
	}

}