
/*
* Copyright 2017 Meorient, Inc. All rights reserved.
*/

package com.demo.test.beans;


import com.demo.test.R;
import com.demo.test.util.MyApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description of ExhibitionDto
 *
 * @author charles.chen
 * @version $Id: ExhibitionDto.java 1985 2017-02-25 10:03:08Z charles.chen $
 * @created on 2017年2月22日
 */
public class ExhibitionDto extends BaseDto {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 国旗
     */
    private String countryImageUrl;

    /**
     * 访客人数
     */
    private long buyerOnline;

    /**
     * 供应商发布产品个数
     */
    private long exhibitsOnline;

    /**
     * 报名参加展会的采购商
     */
    private long appliedOnSite;

    /**
     * 供应商个数
     */
    private long exhibitorsCount;

    /**
     * 展品个数
     */
    private long exhibitsOnSite;

    private String id;

    private String name;

    private String year;

    private String inshowStartDate = "";

    private String inshowEndDate = "";

    private Date digitStartDate;

    private Date digitEndDate;

    private Date internationalStartDate;

    private Date internationalEndDate;

    private String countryId;

    private String countryName;

    private String cityId;

    private String areaId;

    private String period;

    private String organizer;

    private String area;

    private String language;

    private Integer exibitors;

    private Integer buyers;

    private String pavilion;

    private String location = "";

    private String industries;

    private String briefInfo = "";

    private String exhibitionImgId;

    private String boothImgIds;

    /**
     * 展会状态 state ，0：未发布 1：未开始 2：展前 3：展中 4 ：展后 5：结束
     */
    private Short state;

    private Short digitState;

    private Short internationalState;

    private boolean checked;

    private boolean joined;
    /**
     * 默认第一张展会图
     */
    private String exhibitionImgUrl;

    /**
     * 所有展会图
     */
    private List<String> exhibitionImgUrls = new ArrayList<>();

    /**
     * 展位图
     */
    private String boothImgUrl;

    /**
     * 多张展位图
     */
    private List<String> boothImgUrls = new ArrayList<>();


    public long getBuyerOnline() {
        return buyerOnline;
    }

    public void setBuyerOnline(long buyerOnline) {
        this.buyerOnline = buyerOnline;
    }

    public long getExhibitsOnline() {
        return exhibitsOnline;
    }

    public void setExhibitsOnline(long exhibitsOnline) {
        this.exhibitsOnline = exhibitsOnline;
    }

    public long getAppliedOnSite() {
        return appliedOnSite;
    }

    public void setAppliedOnSite(long appliedOnSite) {
        this.appliedOnSite = appliedOnSite;
    }

    public long getExhibitorsCount() {
        return exhibitorsCount;
    }

    public void setExhibitorsCount(long exhibitorsCount) {
        this.exhibitorsCount = exhibitorsCount;
    }

    public long getExhibitsOnSite() {
        return exhibitsOnSite;
    }

    public void setExhibitsOnSite(long exhibitsOnSite) {
        this.exhibitsOnSite = exhibitsOnSite;
    }

    public List<String> getBoothImgUrls() {
        return boothImgUrls;
    }

    public void setBoothImgUrls(List<String> boothImgUrls) {
        this.boothImgUrls = boothImgUrls;
    }

    public String getCountryImageUrl() {
        return countryImageUrl;
    }

    public void setCountryImageUrl(String countryImageUrl) {
        this.countryImageUrl = countryImageUrl;
    }

    public String getExhibitionImgUrl() {
        return exhibitionImgUrl;
    }

    public void setExhibitionImgUrl(String exhibitionImgUrl) {
        this.exhibitionImgUrl = exhibitionImgUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getInshowStartDate() {
        return inshowStartDate;
    }

    public void setInshowStartDate(String inshowStartDate) {
        this.inshowStartDate = inshowStartDate;
    }

    public String getInshowEndDate() {
        return inshowEndDate;
    }

    public void setInshowEndDate(String inshowEndDate) {
        this.inshowEndDate = inshowEndDate;
    }

    public Date getDigitStartDate() {
        return digitStartDate;
    }

    public void setDigitStartDate(Date digitStartDate) {
        this.digitStartDate = digitStartDate;
    }

    public Date getDigitEndDate() {
        return digitEndDate;
    }

    public void setDigitEndDate(Date digitEndDate) {
        this.digitEndDate = digitEndDate;
    }

    public Date getInternationalStartDate() {
        return internationalStartDate;
    }

    public void setInternationalStartDate(Date internationalStartDate) {
        this.internationalStartDate = internationalStartDate;
    }

    public Date getInternationalEndDate() {
        return internationalEndDate;
    }

    public void setInternationalEndDate(Date internationalEndDate) {
        this.internationalEndDate = internationalEndDate;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getExibitors() {
        return exibitors;
    }

    public void setExibitors(Integer exibitors) {
        this.exibitors = exibitors;
    }

    public Integer getBuyers() {
        return buyers;
    }

    public void setBuyers(Integer buyers) {
        this.buyers = buyers;
    }

    public String getPavilion() {
        return pavilion;
    }

    public void setPavilion(String pavilion) {
        this.pavilion = pavilion;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIndustries() {
        return industries;
    }

    public void setIndustries(String industries) {
        this.industries = industries;
    }

    public String getBriefInfo() {
        return briefInfo;
    }

    public void setBriefInfo(String briefInfo) {
        this.briefInfo = briefInfo;
    }

    public String getExhibitionImgId() {
        return exhibitionImgId;
    }

    public void setExhibitionImgId(String exhibitionImgId) {
        this.exhibitionImgId = exhibitionImgId;
    }

    public String getBoothImgIds() {
        return boothImgIds;
    }

    public void setBoothImgIds(String boothImgIds) {
        this.boothImgIds = boothImgIds;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public Short getDigitState() {
        return digitState;
    }

    public void setDigitState(Short digitState) {
        this.digitState = digitState;
    }

    public Short getInternationalState() {
        return internationalState;
    }

    public void setInternationalState(Short internationalState) {
        this.internationalState = internationalState;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public List<String> getExhibitionImgUrls() {
        return exhibitionImgUrls;
    }

    public void setExhibitionImgUrls(List<String> exhibitionImgUrls) {
        this.exhibitionImgUrls = exhibitionImgUrls;
    }

    public String getBoothImgUrl() {
        return boothImgUrl;
    }

    public void setBoothImgUrl(String boothImgUrl) {
        this.boothImgUrl = boothImgUrl;
    }

    public boolean isJoined() {
        return joined;
    }

    public void setJoined(boolean joined) {
        this.joined = joined;
    }

    @Override
    public String toString() {
        return  "countryImageUrl:'" + countryImageUrl + '\'' + "\n" +
                "buyerOnline:" + buyerOnline + "\n" +
                "exhibitsOnline:" + exhibitsOnline + "\n" +
                "appliedOnSite:" + appliedOnSite + "\n" +
                "exhibitorsCount:" + exhibitorsCount + "\n" +
                "exhibitsOnSite:" + exhibitsOnSite + "\n" +
                "id:'" + id + '\'' + "\n" +
                "name:'" + name + '\'' + "\n" +
                "year:'" + year + '\'' + "\n" +
                "inshowStartDate:'" + inshowStartDate + '\'' + "\n" +
                "inshowEndDate:'" + inshowEndDate + '\'' + "\n" +
                "digitStartDate:" + digitStartDate + "\n" +
                "digitEndDate:" + digitEndDate + "\n" +
                "internationalStartDate:" + internationalStartDate + "\n" +
                "internationalEndDate:" + internationalEndDate + "\n" +
                "countryId:'" + countryId + '\'' + "\n" +
                "countryName:'" + countryName + '\'' + "\n" +
                "cityId:'" + cityId + '\'' + "\n" +
                "areaId:'" + areaId + '\'' + "\n" +
                "period:'" + period + '\'' + "\n" +
                "organizer:'" + organizer + '\'' + "\n" +
                "area:'" + area + '\'' + "\n" +
                "language:'" + language + '\'' + "\n" +
                "exibitors:" + exibitors + "\n" +
                "buyers:" + buyers + "\n" +
                "pavilion:'" + pavilion + '\'' + "\n" +
                "location:'" + location + '\'' + "\n" +
                "industries:'" + industries + '\'' + "\n" +
                "exhibitionImgId:'" + exhibitionImgId + '\'' + "\n" +
                "boothImgIds:'" + boothImgIds + '\'' + "\n" +
                "state:" + state + "\n" +
                "digitState:" + digitState +
                "internationalState:" + internationalState + "\n" +
                "checked:" + checked + "\n" +
                "joined:" + joined + "\n" +
                "exhibitionImgUrl:'" + exhibitionImgUrl + '\'' + "\n" +
                "exhibitionImgUrls:" + exhibitionImgUrls + "\n" +
                "boothImgUrl:'" + boothImgUrl + '\'' + "\n" +
                "boothImgUrls:" + boothImgUrls;
    }
}
