package kms.dat.zego.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="game")
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String desc;
	
	@Column(name="link_image",length = 300)
	private String linkImage;
	
	@Column(name="link_appstore",length=300)
	private String linkApp;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getLinkImage() {
		return linkImage;
	}
	public void setLinkImage(String linkImage) {
		this.linkImage = linkImage;
	}
	public String getLinkApp() {
		return linkApp;
	}
	public void setLinkApp(String linkApp) {
		this.linkApp = linkApp;
	}
	public String getLinkCH() {
		return linkCH;
	}
	public void setLinkCH(String linkCH) {
		this.linkCH = linkCH;
	}
	@Column(name="link_ch")
	private String linkCH;
	
}
