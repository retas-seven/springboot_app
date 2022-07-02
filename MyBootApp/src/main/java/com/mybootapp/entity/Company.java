package com.mybootapp.entity;

import java.sql.Timestamp;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.Version;

/**
 * 会社
 */
@Entity(listener = CompanyListener.class)
@Table(name = "company")
public class Company {

    /** */
    @Id
    @Column(name = "company_id")
    Integer companyId;

    /** */
    @Column(name = "company_name")
    String companyName;

    /** */
    @Column(name = "regist_date")
    Timestamp registDate;

    /** */
    @Column(name = "regist_user_id")
    Integer registUserId;

    /** */
    @Column(name = "update_date")
    Timestamp updateDate;

    /** */
    @Column(name = "update_user_id")
    Integer updateUserId;

    /** */
    @Version
    @Column(name = "version")
    Integer version;

    /** 
     * Returns the companyId.
     * 
     * @return the companyId
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /** 
     * Sets the companyId.
     * 
     * @param companyId the companyId
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /** 
     * Returns the companyName.
     * 
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /** 
     * Sets the companyName.
     * 
     * @param companyName the companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /** 
     * Returns the registDate.
     * 
     * @return the registDate
     */
    public Timestamp getRegistDate() {
        return registDate;
    }

    /** 
     * Sets the registDate.
     * 
     * @param registDate the registDate
     */
    public void setRegistDate(Timestamp registDate) {
        this.registDate = registDate;
    }

    /** 
     * Returns the registUserId.
     * 
     * @return the registUserId
     */
    public Integer getRegistUserId() {
        return registUserId;
    }

    /** 
     * Sets the registUserId.
     * 
     * @param registUserId the registUserId
     */
    public void setRegistUserId(Integer registUserId) {
        this.registUserId = registUserId;
    }

    /** 
     * Returns the updateDate.
     * 
     * @return the updateDate
     */
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    /** 
     * Sets the updateDate.
     * 
     * @param updateDate the updateDate
     */
    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    /** 
     * Returns the updateUserId.
     * 
     * @return the updateUserId
     */
    public Integer getUpdateUserId() {
        return updateUserId;
    }

    /** 
     * Sets the updateUserId.
     * 
     * @param updateUserId the updateUserId
     */
    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    /** 
     * Returns the version.
     * 
     * @return the version
     */
    public Integer getVersion() {
        return version;
    }

    /** 
     * Sets the version.
     * 
     * @param version the version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}