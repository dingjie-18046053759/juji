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
@Table(name="users")
public class Users implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;	//编号
    private String account; //登录账号
    private String pass;	//密码
    private String name;	//昵称
    private String truename;	//真是姓名
    private String sex;	//性别
    private Integer age;	//年龄
    private String phone;	//电话
    private Integer state;	//状态 0-正常
    private Date ctime;	//创建时间
    private String clients;	//管理设备ID串
    private Integer role;	//权限
    private String headportrait;	//头像
    
    private String cardtype;	//证件类型
    private String cardnumber;	//证件号码
    private String email;	//邮箱
    private String country;	//国家
    private String city;	//城市
    private String remark;	//备注
    private String skilltype;	//技能类型
    private String begoodatmodel;	//擅长类型
    private String begoodatbrand;	//擅长品牌
    private String begoodatbreed;	//擅长控制器
    private String begoodatcontroller;	//擅长控制器型号
    
    private String userlevel;	//级别
    private String usernumber;	//编号

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="account")
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name="pass")
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="sex")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name="age")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name="phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name="state")
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="ctime")
	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	@Column(name="clients")
	public String getClients() {
		return clients;
	}

	public void setClients(String clients) {
		this.clients = clients;
	}

	@Column(name="role")
	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	@Column(name="headportrait")
	public String getHeadportrait() {
		return headportrait;
	}

	public void setHeadportrait(String headportrait) {
		this.headportrait = headportrait;
	}

	@Column(name="cardtype")
	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	@Column(name="cardnumber")
	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name="city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name="remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name="skilltype")
	public String getSkilltype() {
		return skilltype;
	}

	public void setSkilltype(String skilltype) {
		this.skilltype = skilltype;
	}

	@Column(name="begoodatmodel")
	public String getBegoodatmodel() {
		return begoodatmodel;
	}

	public void setBegoodatmodel(String begoodatmodel) {
		this.begoodatmodel = begoodatmodel;
	}

	@Column(name="begoodatbrand")
	public String getBegoodatbrand() {
		return begoodatbrand;
	}

	public void setBegoodatbrand(String begoodatbrand) {
		this.begoodatbrand = begoodatbrand;
	}

	@Column(name="begoodatbreed")
	public String getBegoodatbreed() {
		return begoodatbreed;
	}

	public void setBegoodatbreed(String begoodatbreed) {
		this.begoodatbreed = begoodatbreed;
	}

	@Column(name="begoodatcontroller")
	public String getBegoodatcontroller() {
		return begoodatcontroller;
	}

	public void setBegoodatcontroller(String begoodatcontroller) {
		this.begoodatcontroller = begoodatcontroller;
	}

	@Column(name="userlevel")
	public String getUserlevel() {
		return userlevel;
	}

	public void setUserlevel(String userlevel) {
		this.userlevel = userlevel;
	}

	@Column(name="usernumber")
	public String getUsernumber() {
		return usernumber;
	}

	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}

	@Column(name="truename")
	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}
}
