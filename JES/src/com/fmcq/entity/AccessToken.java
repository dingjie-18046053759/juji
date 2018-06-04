package com.fmcq.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
* 类名: AccessToken </br>
* 包名： com.souvc.weixin.pojo
* 描述: 微信通用接口凭证  </br>
* 开发人员：souvc </br>
* 创建时间：  2015-12-1 </br>
* 发布版本：V1.0  </br>
 */
@Entity
@Table(name="wx_token")
public class AccessToken implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
    // 获取到的凭证
    private String token;
    //有效期
    private String time;
    // 凭证有效时间，单位：秒
    private int expiresIn;
    //Openid
    private String openid;
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JoinColumn(name="token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    @JoinColumn(name="time")
    public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@JoinColumn(name="expiresIn")
    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    @JoinColumn(name="openid")
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
}
