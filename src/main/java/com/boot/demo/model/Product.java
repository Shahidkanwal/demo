package com.boot.demo.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	@NotBlank
	private String itemName;
	private String itemSize;
	private String color;
	private String description;
	private String materialType;
	private boolean active;
	private boolean specialItem;
	private String multiSelect;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date scheduleDate;
	@DateTimeFormat(pattern = "HH:mm")
	private Date scheduleTime;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemSize() {
		return itemSize;
	}
	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMaterialType() {
		return materialType;
	}
	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isSpecialItem() {
		return specialItem;
	}
	public void setSpecialItem(boolean specialItem) {
		this.specialItem = specialItem;
	}
	public String getMultiSelect() {
		return multiSelect;
	}
	public void setMultiSelect(String multiSelect) {
		this.multiSelect = multiSelect;
	}
	public Date getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public Date getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(Date scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	@Override
	public String toString() {
		return "Product [Id=" + Id + ", itemName=" + itemName + ", itemSize=" + itemSize + ", color=" + color
				+ ", description=" + description + ", materialType=" + materialType + ", active=" + active
				+ ", specialItem=" + specialItem + ", multiSelect=" + multiSelect + ", scheduleDate=" + scheduleDate
				+ ", scheduleTime=" + scheduleTime + "]";
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, @NotBlank String itemName, String itemSize, String color, String description,
			String materialType, boolean active, boolean specialItem, String multiSelect, Date scheduleDate,
			Date scheduleTime) {
		super();
		Id = id;
		this.itemName = itemName;
		this.itemSize = itemSize;
		this.color = color;
		this.description = description;
		this.materialType = materialType;
		this.active = active;
		this.specialItem = specialItem;
		this.multiSelect = multiSelect;
		this.scheduleDate = scheduleDate;
		this.scheduleTime = scheduleTime;
	}


}
