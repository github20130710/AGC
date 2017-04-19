package cn.sw.entity;

import org.springframework.stereotype.Component;

/**
 * Created by sophia.wang on 17/4/17.
 */
@Component("host")
public class HostEntity extends BaseEntity{

    private String status;
    private String hypervisorType;
    private String clusterUuid;
    private String zoneUuid;
    private String username;
    private String managementIp;
    private String description;
    private Integer sshPort;
    private Integer totalCpuCapacity;
    private Integer totalMemoryCapacity;
    private Integer availableCpuCapacity;
    private Integer availableMemoryCapacity;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAvailableMemoryCapacity() {
        return availableMemoryCapacity;
    }

    public void setAvailableMemoryCapacity(Integer availableMemoryCapacity) {
        this.availableMemoryCapacity = availableMemoryCapacity;
    }

    public String getHypervisorType() {
        return hypervisorType;
    }

    public void setHypervisorType(String hypervisorType) {
        this.hypervisorType = hypervisorType;
    }

    public String getClusterUuid() {
        return clusterUuid;
    }

    public void setClusterUuid(String clusterUuid) {
        this.clusterUuid = clusterUuid;
    }

    public String getZoneUuid() {
        return zoneUuid;
    }

    public void setZoneUuid(String zoneUuid) {
        this.zoneUuid = zoneUuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getManagementIp() {
        return managementIp;
    }

    public void setManagementIp(String managementIp) {
        this.managementIp = managementIp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSshPort() {
        return sshPort;
    }

    public void setSshPort(Integer sshPort) {
        this.sshPort = sshPort;
    }

    public Integer getTotalCpuCapacity() {
        return totalCpuCapacity;
    }

    public void setTotalCpuCapacity(Integer totalCpuCapacity) {
        this.totalCpuCapacity = totalCpuCapacity;
    }

    public Integer getTotalMemoryCapacity() {
        return totalMemoryCapacity;
    }

    public void setTotalMemoryCapacity(Integer totalMemoryCapacity) {
        this.totalMemoryCapacity = totalMemoryCapacity;
    }

    public Integer getAvailableCpuCapacity() {
        return availableCpuCapacity;
    }

    public void setAvailableCpuCapacity(Integer availableCpuCapacity) {
        this.availableCpuCapacity = availableCpuCapacity;
    }
}
