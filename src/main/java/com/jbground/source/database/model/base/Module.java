/*
 * Created on 2005. 5. 13.
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jbground.source.database.model.base;


public abstract class Module extends Entity{

	public final static String STATE_INSERVICE = "INSERVICE";    
    public final static String STATE_OUTOFSERVICE = "OUTOFSERVICE";
    public final static String STATE_PREVENTIVEMAINTENANCE = "PM";
    public final static String STATE_UNLOADONLY = "UNLOADONLY";
    
    public final static String PROCESSINGSTATE_IDLE = "IDLE";
    public final static String PROCESSINGSTATE_PROCESSING = "PROCESSING";
    public final static String PROCESSINGSTATE_DOWN = "DOWN";
    
    //AGV
    public final static String PROCESSINGSTATE_RUN = "RUN";
    public final static String PROCESSINGSTATE_CHARGE = "CHARGE";
	
	////////////////////////////////////////////////////////////
	//    
    public final static String ACCEPTABLECARRIERTYPE_TFT = "TFT";
    public final static String ACCEPTABLECARRIERTYPE_CF = "CF";
    public final static String ACCEPTABLECARRIERTYPE_CELL = "CELL";
    public final static String ACCEPTABLECARRIERTYPE_MODULE = "MODULE";
    
    public final static String ACCEPTABLECARRIERTYPE_TFT_CF = "TFT-CF";
    public final static String ACCEPTABLECARRIERTYPE_TFT_CELL = "TFT-CELL";
    public final static String ACCEPTABLECARRIERTYPE_TFT_MODULE = "TFT-MODULE";    
    
    public final static String ACCEPTABLECARRIERTYPE_CF_CELL = "CF-CELL";
    public final static String ACCEPTABLECARRIERTYPE_CF_MODULE = "CF-MODULE";    
    
    public final static String ACCEPTABLECARRIERTYPE_CELL_MODULE = "CELL-MODULE";    
    
    public final static String ACCEPTABLECARRIERTYPE_TFT_CF_CELL = "TFT-CF-CELL";
    public final static String ACCEPTABLECARRIERTYPE_TFT_CF_MODULE = "TFT-CF-MODULE";
    
    public final static String ACCEPTABLECARRIERTYPE_CF_CELL_MODULE = "CF-CELL-MODULE";
    
    public final static String ACCEPTABLECARRIERTYPE_ALL = "ALL";
    
    
    
//    public static final String STATE_NORMAL = "NORMAL";


//	public static final String STATUS_EMPTY = "EMPTY";
//	public static final String STATUS_FULL = "FULL";
//    public static final String STATUS_IDLE = "IDLE";


//	public static final String TYPE_SHELF = "SHELF";
//	public static final String TYPE_PORT = "PORT";
//
//
//	public static final String TYPE_BUFFER = "BUFFER";
//	public static final String TYPE_CRANE = "CRANE";
//	public static final String TYPE_VEHICLE = "VEHICLE";
//	public static final String TYPE_COMPONENT = "COMPONENT";


	/**
	 * module�� type�� �ǹ�. Stocker�̸� STK, AGV�̸� AGV...
	 */
	protected String type = "";
	
	
	/** 
	 * sub type���� �ٸ� �ǹ̸� ������ �ȴ�.
	 */
	protected String state= STATE_INSERVICE;
	
	protected String processingState = PROCESSINGSTATE_PROCESSING;
	
	protected String acceptableCarrierType = ACCEPTABLECARRIERTYPE_ALL;
	
	protected String acceptableSubstrate = FALSE;
	
//	/** 
//	 * sub type���� �ٸ� �ǹ̸� ������ �ȴ�.
//	 */
//	protected String status="";
	
	/////////////////////////////////////////////////////////////////////////////////////
	//
	
	/**
	 * @hibernate.property
	 *  length="20"
	 */
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	} 
	
	/**
	 * @hibernate.property
	 *  length="20"
	 */
	public String getProcessingState() {
		return processingState;
	}
	public void setProcessingState(String processingState) {
		this.processingState = processingState;
	}
//	/**
//	 * @hibernate.property
//	 */
//	public String getStatus() {
//		if(status == null)
//			return "";
//		else
//			return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
	
	/**
	 * @hibernate.property
	 */
	public String getAcceptableCarrierType() {
		return acceptableCarrierType;
	}
	public void setAcceptableCarrierType(String acceptableCarrierType) {
		this.acceptableCarrierType = acceptableCarrierType;
	}
	
	/**
     * @hibernate.property
	 *  length="2"
     */
	public String getAcceptableSubstrate() {
		return acceptableSubstrate;
	}
	public void setAcceptableSubstrate(String acceptableSubstrate) {
		this.acceptableSubstrate = acceptableSubstrate;
	}
	
	/**
	 * @hibernate.property
	 *  length="20"
	 */
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
