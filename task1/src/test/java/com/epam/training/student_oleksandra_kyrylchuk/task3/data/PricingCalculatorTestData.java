package com.epam.training.student_oleksandra_kyrylchuk.task3.data;

public class PricingCalculatorTestData {
    private int numberOfInstances;
    private String operationSystemSoftware;
    private String provisioningModel;
    private String machineFamily;
    private String series;
    private String machineType;
    private boolean addGPUs;
    private String GPUType;
    private int numberOfGPUs;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;
    private String cost;
    private String machineTypeSetUp;
    public PricingCalculatorTestData(int numberOfInstances, String operationSystemSoftware,
                                     String provisioningModel, String machineFamily, String series,
                                     String machineType, boolean addGPUs, String GPUType, int numberOfGPUs,
                                     String localSSD, String datacenterLocation, String committedUsage, String cost, String machineTypeSetUp){
        this.numberOfInstances = numberOfInstances;
        this.operationSystemSoftware = operationSystemSoftware;
        this.provisioningModel = provisioningModel;
        this.machineFamily = machineFamily;
        this.series = series;
        this.machineType = machineType;
        this.addGPUs = addGPUs;
        this.GPUType = GPUType;
        this.numberOfGPUs = numberOfGPUs;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
        this.cost = cost;
        this.machineTypeSetUp = machineTypeSetUp;
    }

    public int getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(int numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperationSystemSoftware() {
        return operationSystemSoftware;
    }

    public void setOperationSystemSoftware(String operationSystemSoftware) {
        this.operationSystemSoftware = operationSystemSoftware;
    }

    public String getProvisioningModel() {
        return provisioningModel;
    }

    public void setProvisioningModel(String provisioningModel) {
        this.provisioningModel = provisioningModel;
    }

    public String getMachineFamily() {
        return machineFamily;
    }

    public void setMachineFamily(String machineFamily) {
        this.machineFamily = machineFamily;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public boolean isAddGPUs() {
        return addGPUs;
    }

    public void setAddGPUs(boolean addGPUs) {
        this.addGPUs = addGPUs;
    }

    public String getGPUType() {
        return GPUType;
    }

    public void setGPUType(String GPUType) {
        this.GPUType = GPUType;
    }

    public int getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(int numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMachineTypeSetUp() {
        return machineTypeSetUp;
    }

    public void setMachineTypeSetUp(String machineTypeSetUp) {
        this.machineTypeSetUp = machineTypeSetUp;
    }

}
