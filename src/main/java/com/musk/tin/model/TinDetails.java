package com.musk.tin.model;

/**W
 * This class is hold tin details
 * Created by dhiren on 17/11/16.
 * @author dhiren
 * @since 17/11/2016
 */
public class TinDetails {

    private String tin;

    private String cstNumber;

    private  String dealerName;

    private String dealerAddress;

    private String stateName;

    private String panNumber;

    private String dateOfRegistration;

    private String status;

    private String validAsOn;

    public TinDetails(String tin, String cstNumber, String dealerName, String dealerAddress, String stateName, String panNumber, String dateOfRegistration, String status, String validAsOn) {
        this.tin = tin;
        this.cstNumber = cstNumber;
        this.dealerName = dealerName;
        this.dealerAddress = dealerAddress;
        this.stateName = stateName;
        this.panNumber = panNumber;
        this.dateOfRegistration = dateOfRegistration;
        this.status = status;
        this.validAsOn = validAsOn;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getCstNumber() {
        return cstNumber;
    }

    public void setCstNumber(String cstNumber) {
        this.cstNumber = cstNumber;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getDealerAddress() {
        return dealerAddress;
    }

    public void setDealerAddress(String dealerAddress) {
        this.dealerAddress = dealerAddress;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValidAsOn() {
        return validAsOn;
    }

    public void setValidAsOn(String validAsOn) {
        this.validAsOn = validAsOn;
    }
}
