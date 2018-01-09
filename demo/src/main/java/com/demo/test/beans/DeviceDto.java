package com.demo.test.beans;

import com.demo.test.utildata.ApplicationData;

import java.io.Serializable;

/**
 * Description of DeviceDto
 *
 * @author max.sun
 * @version $Id: DeviceDto.java 1347 2017-02-10 01:27:02Z max.sun $
 * @created on 2017年2月3日
 */
public class DeviceDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 系统类型 Android、IOS、WP
     */
//	@ApiModelProperty(value = "设备操作系统", required = true, example = "Android")
    private String sysType = "Android";

    /**
     * 系统版本号
     */
//	@ApiModelProperty(value = "设备操作系统版本", required = true, example"6.0")
    private String sysVersion = ApplicationData.sysVersion;

    /**
     * 移动设备ID
     */
//	@ApiModelProperty(value = "设备ID", required = true, example = "1349873D434")
    private String deviceId = ApplicationData.deviceId;

    /**
     * 移动设备型号
     */
//	@ApiModelProperty(value = "设备型号", example = "I9500")
    private String deviceModel = ApplicationData.deviceModel;

    /**
     * 移动设备厂商
     */
//	@ApiModelProperty(value = "设备厂商", example = "Samsung")
    private String deviceMake = ApplicationData.deviceMake;

    public String getSysType() {
        return sysType;
    }

    public void setSysType(String sysType) {
        this.sysType = sysType;
    }

    public String getSysVersion() {
        return sysVersion;
    }

    public void setSysVersion(String sysVersion) {
        this.sysVersion = sysVersion;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceMake() {
        return deviceMake;
    }

    public void setDeviceMake(String deviceMake) {
        this.deviceMake = deviceMake;
    }

    @Override
    public String toString() {
        return "DeviceDto{" +
                "sysType='" + sysType + '\'' +
                ", sysVersion='" + sysVersion + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceModel='" + deviceModel + '\'' +
                ", deviceMake='" + deviceMake + '\'' +
                '}';
    }
}
