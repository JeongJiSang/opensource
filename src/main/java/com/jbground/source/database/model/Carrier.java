package com.jbground.source.database.model;

import com.toy.uiserver.database.model.base.Entity;

import java.util.Date;


public class Carrier {


	protected String machineName	= "";

	protected String unitName		= "";

	protected String carrierName	= "";
	protected String type			= "ALL";
	protected String kind			= "";
	protected String state			= Entity.NA;
	protected String reserved		= Entity.FALSE;
	protected String holded			= Entity.FALSE;
	protected Date installTime		= new Date();
	protected Date storedTime		= new Date();
	protected Date idReadTime		= new Date();
	protected Date lastCleanTime 	= new Date();
	protected String lotId			= "";
	protected String batchId		= "";
	protected String stepId			= "";
	protected String processId		= "";
	protected int usedCount			= -1;
	protected String productEmpty 	= Entity.NA;
	protected int productQuantity	= -1;
	protected int maxCapa			= -1;
	protected String additionalInfo = "";
	protected String batchType		= "";
	protected String oldCarrierName	= "";
	protected String cleanState		= "";
	protected String maskType		= "";
	protected String carrierKind    = "";
	protected String slotNumber		= "";
	protected String carrierType    = "";
	protected String materialName     = "";
	protected String materialQuantity = "";
	protected String pollutionRate	  ="";


	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

	public String getHolded() {
		return holded;
	}

	public void setHolded(String holded) {
		this.holded = holded;
	}

	public Date getInstallTime() {
		return installTime;
	}

	public void setInstallTime(Date installTime) {
		this.installTime = installTime;
	}

	public Date getStoredTime() {
		return storedTime;
	}

	public void setStoredTime(Date storedTime) {
		this.storedTime = storedTime;
	}

	public Date getIdReadTime() {
		return idReadTime;
	}

	public void setIdReadTime(Date idReadTime) {
		this.idReadTime = idReadTime;
	}

	public Date getLastCleanTime() {
		return lastCleanTime;
	}

	public void setLastCleanTime(Date lastCleanTime) {
		this.lastCleanTime = lastCleanTime;
	}

	public String getLotId() {
		return lotId;
	}

	public void setLotId(String lotId) {
		this.lotId = lotId;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getStepId() {
		return stepId;
	}

	public void setStepId(String stepId) {
		this.stepId = stepId;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public int getUsedCount() {
		return usedCount;
	}

	public void setUsedCount(int usedCount) {
		this.usedCount = usedCount;
	}

	public String getProductEmpty() {
		return productEmpty;
	}

	public void setProductEmpty(String productEmpty) {
		this.productEmpty = productEmpty;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getMaxCapa() {
		return maxCapa;
	}

	public void setMaxCapa(int maxCapa) {
		this.maxCapa = maxCapa;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getBatchType() {
		return batchType;
	}

	public void setBatchType(String batchType) {
		this.batchType = batchType;
	}

	public String getOldCarrierName() {
		return oldCarrierName;
	}

	public void setOldCarrierName(String oldCarrierName) {
		this.oldCarrierName = oldCarrierName;
	}

	public String getCleanState() {
		return cleanState;
	}

	public void setCleanState(String cleanState) {
		this.cleanState = cleanState;
	}

	public String getMaskType() {
		return maskType;
	}

	public void setMaskType(String maskType) {
		this.maskType = maskType;
	}

	public String getCarrierKind() {
		return carrierKind;
	}

	public void setCarrierKind(String carrierKind) {
		this.carrierKind = carrierKind;
	}

	public String getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(String slotNumber) {
		this.slotNumber = slotNumber;
	}

	public String getCarrierType() {
		return carrierType;
	}

	public void setCarrierType(String carrierType) {
		this.carrierType = carrierType;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getMaterialQuantity() {
		return materialQuantity;
	}

	public void setMaterialQuantity(String materialQuantity) {
		this.materialQuantity = materialQuantity;
	}

	public String getPollutionRate() {
		return pollutionRate;
	}

	public void setPollutionRate(String pollutionRate) {
		this.pollutionRate = pollutionRate;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Carrier{");
		sb.append("machineName='").append(machineName).append('\'');
		sb.append(", unitName='").append(unitName).append('\'');
		sb.append(", carrierName='").append(carrierName).append('\'');
		sb.append(", type='").append(type).append('\'');
		sb.append(", kind='").append(kind).append('\'');
		sb.append(", state='").append(state).append('\'');
		sb.append(", reserved='").append(reserved).append('\'');
		sb.append(", holded='").append(holded).append('\'');
		sb.append(", installTime=").append(installTime);
		sb.append(", storedTime=").append(storedTime);
		sb.append(", idReadTime=").append(idReadTime);
		sb.append(", lastCleanTime=").append(lastCleanTime);
		sb.append(", lotId='").append(lotId).append('\'');
		sb.append(", batchId='").append(batchId).append('\'');
		sb.append(", stepId='").append(stepId).append('\'');
		sb.append(", processId='").append(processId).append('\'');
		sb.append(", usedCount=").append(usedCount);
		sb.append(", productEmpty='").append(productEmpty).append('\'');
		sb.append(", productQuantity=").append(productQuantity);
		sb.append(", maxCapa=").append(maxCapa);
		sb.append(", additionalInfo='").append(additionalInfo).append('\'');
		sb.append(", batchType='").append(batchType).append('\'');
		sb.append(", oldCarrierName='").append(oldCarrierName).append('\'');
		sb.append(", cleanState='").append(cleanState).append('\'');
		sb.append(", maskType='").append(maskType).append('\'');
		sb.append(", carrierKind='").append(carrierKind).append('\'');
		sb.append(", slotNumber='").append(slotNumber).append('\'');
		sb.append(", carrierType='").append(carrierType).append('\'');
		sb.append(", materialName='").append(materialName).append('\'');
		sb.append(", materialQuantity='").append(materialQuantity).append('\'');
		sb.append(", pollutionRate='").append(pollutionRate).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
