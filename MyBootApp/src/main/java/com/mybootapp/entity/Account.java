package com.mybootapp.entity;

import java.sql.Timestamp;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.Version;

/**
 * アカウント
 */
@Entity(listener = AccountListener.class)
@Table(name = "account")
public class Account {

    /** */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Integer userId;

    /** */
    @Column(name = "email")
    String email;

    /** */
    @Column(name = "company_id")
    Integer companyId;

    /** */
    @Column(name = "emp_code")
    String empCode;

    /** */
    @Column(name = "password")
    String password;

    /** */
    @Column(name = "lastname")
    String lastname;

    /** */
    @Column(name = "firstname")
    String firstname;

    /** */
    @Column(name = "lastname_kana")
    String lastnameKana;

    /** */
    @Column(name = "firstname_kana")
    String firstnameKana;

    /** */
    @Column(name = "role_id")
    String roleId;

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
     * Returns the userId.
     * 
     * @return the userId
     */
    public Integer getUserId() {
        return userId;
    }

    /** 
     * Sets the userId.
     * 
     * @param userId the userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /** 
     * Returns the email.
     * 
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /** 
     * Sets the email.
     * 
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

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
     * Returns the empCode.
     * 
     * @return the empCode
     */
    public String getEmpCode() {
        return empCode;
    }

    /** 
     * Sets the empCode.
     * 
     * @param empCode the empCode
     */
    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    /** 
     * Returns the password.
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /** 
     * Sets the password.
     * 
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /** 
     * Returns the lastname.
     * 
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /** 
     * Sets the lastname.
     * 
     * @param lastname the lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /** 
     * Returns the firstname.
     * 
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /** 
     * Sets the firstname.
     * 
     * @param firstname the firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /** 
     * Returns the lastnameKana.
     * 
     * @return the lastnameKana
     */
    public String getLastnameKana() {
        return lastnameKana;
    }

    /** 
     * Sets the lastnameKana.
     * 
     * @param lastnameKana the lastnameKana
     */
    public void setLastnameKana(String lastnameKana) {
        this.lastnameKana = lastnameKana;
    }

    /** 
     * Returns the firstnameKana.
     * 
     * @return the firstnameKana
     */
    public String getFirstnameKana() {
        return firstnameKana;
    }

    /** 
     * Sets the firstnameKana.
     * 
     * @param firstnameKana the firstnameKana
     */
    public void setFirstnameKana(String firstnameKana) {
        this.firstnameKana = firstnameKana;
    }

    /** 
     * Returns the roleId.
     * 
     * @return the roleId
     */
    public String getRoleId() {
        return roleId;
    }

    /** 
     * Sets the roleId.
     * 
     * @param roleId the roleId
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
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