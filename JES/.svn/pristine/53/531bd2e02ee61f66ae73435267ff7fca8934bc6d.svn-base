package com.fmcq.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="control")
public class Control implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String controllermodel;
	private String cmdlist;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="controllermodel")
	public String getControllermodel() {
		return controllermodel;
	}

	public void setControllermodel(String controllermodel) {
		this.controllermodel = controllermodel;
	}

	@Column(name="cmdlist")
	public String getCmdlist() {
		return cmdlist;
	}

	public void setCmdlist(String cmdlist) {
		this.cmdlist = cmdlist;
	}
}
