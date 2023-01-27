package com.jbground.source.database.model.base;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

public abstract class PartitionedEntity extends Entity{
	
	protected int partitionId;
	
	protected Date time = new Date(System.currentTimeMillis());
	
	public PartitionedEntity() {
		this.id = UUID.randomUUID().toString();		
	}
	
	/**
	 * @hibernate.property 
	 */
	public int getPartitionId() {
		return partitionId;
	}

	public void setPartitionId(int partitionId) {
		this.partitionId = partitionId;
	}
	
	/**
	 * @hibernate.property
	 */
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	//////////////////////////////////////////////////////////////
	//

	public int createPartitionIdByMonth() {		
		Calendar calendar = new GregorianCalendar();
		return (calendar.get(Calendar.MONTH) + 1);
	}
	
	public int createPartitionIdByDate() {		
		Calendar calendar = new GregorianCalendar();
		return (calendar.get(Calendar.DATE));
	}

}