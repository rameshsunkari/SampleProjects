package com.thinkadv.springmvc.pivotol.model;

import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="token")
public class UserToken {
private String guid;
@Id
private int id;
public String getGuid() {
	return guid;
}
public void setGuid(String guid) {
	this.guid = guid;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}


}
