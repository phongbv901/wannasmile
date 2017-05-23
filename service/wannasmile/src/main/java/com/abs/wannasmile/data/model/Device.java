package com.abs.wannasmile.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

/**
 * Created by phongbv on 5/22/17.
 */
@Document(collection = "Device")
public class Device {

    @Id
    private String deviceId;

    private String accountUid;

    private String esn;

    private String osType;

    private String osBuild;

    private Integer updateStatus;

    private Date lastChecked;

    private String refBuild;

    public boolean isOutofDate(String version){
        if(version != null && !version.isEmpty()){
            String[] newBuid = version.split("\\.");
            if(newBuid.length == 2){
                String[] oldBuild = osBuild.split("\\.");
                Integer oldNum1 = Integer.parseInt(oldBuild[0]);
                Integer oldNum2 = Integer.parseInt(oldBuild[1]);
                //
                Integer newNum1 = Integer.parseInt(newBuid[0]);
                Integer newNum2 = Integer.parseInt(newBuid[1]);
                if(oldNum1 < newNum1 || (oldNum1 == newNum1 && oldNum2 < newNum2)){
                    return true;
                }
            }
        }
        return false;
    }

    public Device() {
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getAccountUid() {
        return accountUid;
    }

    public void setAccountUid(String accountUid) {
        this.accountUid = accountUid;
    }

    public String getEsn() {
        return esn;
    }

    public void setEsn(String esn) {
        this.esn = esn;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getOsBuild() {
        return osBuild;
    }

    public void setOsBuild(String osBuild) {
        this.osBuild = osBuild;
    }

    public Integer getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(Integer updateStatus) {
        this.updateStatus = updateStatus;
    }

    public Date getLastChecked() {
        return lastChecked;
    }

    public void setLastChecked(Date lastChecked) {
        this.lastChecked = lastChecked;
    }

    public String getRefBuild() {
        return refBuild;
    }

    public void setRefBuild(String refBuild) {
        this.refBuild = refBuild;
    }
}
