package com.epam.training.student_oleksandra_kyrylchuk.model;

import java.util.Objects;

public class ComputeEngine {
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
    public ComputeEngine(int numberOfInstances, String operationSystemSoftware,
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

    @Override
    public String toString() {
        return "ComputeEngine{" +
                "numberOfInstances=" + numberOfInstances +
                ", operationSystemSoftware='" + operationSystemSoftware + '\'' +
                ", provisioningModel='" + provisioningModel + '\'' +
                ", machineFamily='" + machineFamily + '\'' +
                ", series='" + series + '\'' +
                ", machineType='" + machineType + '\'' +
                ", addGPUs=" + addGPUs +
                ", GPUType='" + GPUType + '\'' +
                ", numberOfGPUs=" + numberOfGPUs +
                ", localSSD='" + localSSD + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                ", cost='" + cost + '\'' +
                ", machineTypeSetUp='" + machineTypeSetUp + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputeEngine that = (ComputeEngine) o;
        return numberOfInstances == that.numberOfInstances && addGPUs == that.addGPUs && numberOfGPUs == that.numberOfGPUs && Objects.equals(operationSystemSoftware, that.operationSystemSoftware) && Objects.equals(provisioningModel, that.provisioningModel) && Objects.equals(machineFamily, that.machineFamily) && Objects.equals(series, that.series) && Objects.equals(machineType, that.machineType) && Objects.equals(GPUType, that.GPUType) && Objects.equals(localSSD, that.localSSD) && Objects.equals(datacenterLocation, that.datacenterLocation) && Objects.equals(committedUsage, that.committedUsage) && Objects.equals(cost, that.cost) && Objects.equals(machineTypeSetUp, that.machineTypeSetUp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, operationSystemSoftware, provisioningModel, machineFamily, series, machineType, addGPUs, GPUType, numberOfGPUs, localSSD, datacenterLocation, committedUsage, cost, machineTypeSetUp);
    }
}
