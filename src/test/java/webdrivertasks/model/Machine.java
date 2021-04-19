package webdrivertasks.model;

import java.util.Objects;

public class Machine {
    private String numberOfInstances;
    private String operationSystem;
    private String machineClass;
    private String machineType;
    private String dataCenterLocation;
    private String commitedUsage;
    private String numberOfNodes;
    private String numberOfGPU;
    private String localSSD;

    public String getLocalSSD() {
        return localSSD;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getDataCenterLocation() {
        return dataCenterLocation;
    }

    public String getCommitedUsage() {
        return commitedUsage;
    }

    public String getNumberOfNodes() {
        return numberOfNodes;
    }

    public String getNumberOfGPU() {
        return numberOfGPU;
    }
    public static class MachineBuilder{

        private Machine newMachine = new Machine();

        public MachineBuilder withNumberOfInstances(String numberOfInstances){
            newMachine.numberOfInstances = numberOfInstances;
            return this;
        }

        public MachineBuilder withOperationSystem (String operationSystem){
            newMachine.operationSystem = operationSystem;
            return this;
        }

        public MachineBuilder withClass(String machineClass){
            newMachine.machineClass = machineClass;
            return this;
        }

        public MachineBuilder withType(String machineType){
            newMachine.machineType = machineType;
            return this;
        }

        public MachineBuilder withDataCenterLocation (String dataCenterLocation){
            newMachine.dataCenterLocation = dataCenterLocation;
            return this;
        }

        public MachineBuilder withCommitedUsage (String commitedUsage){
            newMachine.commitedUsage = commitedUsage;
            return this;
        }

        public MachineBuilder withNumberOfNodes (String numberOfNodes){
            newMachine.numberOfNodes = numberOfNodes;
            return this;
        }

        public MachineBuilder withNumberOfGPU (String numberOfGPU){
            newMachine.numberOfGPU = numberOfGPU;
            return this;
        }

        public MachineBuilder withLocalSSD(String localSSD){
            newMachine.localSSD = localSSD;
            return this;
        }

        public Machine build(){
            return newMachine;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Machine machine = (Machine) o;
        return Objects.equals(numberOfInstances, machine.numberOfInstances) && Objects.equals(operationSystem, machine.operationSystem) && Objects.equals(machineClass, machine.machineClass) && Objects.equals(machineType, machine.machineType) && Objects.equals(dataCenterLocation, machine.dataCenterLocation) && Objects.equals(commitedUsage, machine.commitedUsage) && Objects.equals(numberOfNodes, machine.numberOfNodes) && Objects.equals(numberOfGPU, machine.numberOfGPU);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, operationSystem, machineClass, machineType, dataCenterLocation, commitedUsage, numberOfNodes, numberOfGPU);
    }
}
