package com.epam.training.student_oleksandra_kyrylchuk.service;

import com.epam.training.student_oleksandra_kyrylchuk.model.ComputeEngine;

public class ComputeEngineCreator {
    public static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.computeengine.numberofinstances";
    public static final String TESTDATA_OPERATING_SYSTEM = "testdata.computeengine.operatingsystem";
    public static final String TESTDATA_MACHINE_CLASS = "testdata.computeengine.machinefamily";
    public static final String TESTDATA_SERIES = "testdata.computeengine.series";
    public static final String TESTDATA_MACHINE_TYPE = "testdata.computeengine.machinetype";
    public static final String TESTDATA_TYPE_OF_GPUS = "testdata.computeengine.gputype";
    public static final String TESTDATA_NUMBER_OF_GPUS = "testdata.computeengine.numberofgpus";
    public static final String TESTDATA_LOCAL_SSD = "testdata.computeengine.localssd";
    public static final String TESTDATA_DATACENTER_LOCATION = "testdata.computeengine.datacenterlocation";
    public static final String TESTDATA_COMMITTED_USAGE = "testdata.computeengine.committedusage";
    public static final String TESTDATA_ADD_GPUS = "testdata.computeengine.addgpus";
    public static final String TESTDATA_FINAL_COST = "testdata.computeengine.finalcost";
    public static final String TESTDATA_MACHINE_TYPE_SETUP = "testdata.computeengine.machinetypesetup";
    public static final String TESTDATA_PROVISIONING_MODEL = "testdata.computeengine.provisioningmodel";

    public static ComputeEngine withDataFromProperty() {
        return new ComputeEngine(
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES)),
                TestDataReader.getTestData(TESTDATA_OPERATING_SYSTEM),
                TestDataReader.getTestData(TESTDATA_PROVISIONING_MODEL),
                TestDataReader.getTestData(TESTDATA_MACHINE_CLASS),
                TestDataReader.getTestData(TESTDATA_SERIES),
                TestDataReader.getTestData(TESTDATA_MACHINE_TYPE),
                Boolean.parseBoolean(TestDataReader.getTestData(TESTDATA_ADD_GPUS)),
                TestDataReader.getTestData(TESTDATA_TYPE_OF_GPUS),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_NUMBER_OF_GPUS)),
                TestDataReader.getTestData(TESTDATA_LOCAL_SSD),
                TestDataReader.getTestData(TESTDATA_DATACENTER_LOCATION),
                TestDataReader.getTestData(TESTDATA_COMMITTED_USAGE),
                TestDataReader.getTestData(TESTDATA_FINAL_COST),
                TestDataReader.getTestData(TESTDATA_MACHINE_TYPE_SETUP));
    }
}
