package com.metin.medium.transaction.dto;

import java.math.BigDecimal;

public class TransferInformation {

    private String usernameFrom;
    private String usernameTo;
    private BigDecimal amount;

    public TransferInformation(String usernameFrom, String usernameTo, BigDecimal amount) {
        this.usernameFrom = usernameFrom;
        this.usernameTo = usernameTo;
        this.amount = amount;
    }

    public String getUsernameFrom() {
        return usernameFrom;
    }

    public void setUsernameFrom(String usernameFrom) {
        this.usernameFrom = usernameFrom;
    }

    public String getUsernameTo() {
        return usernameTo;
    }

    public void setUsernameTo(String usernameTo) {
        this.usernameTo = usernameTo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
