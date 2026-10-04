package com.microsoft.identity.common.java.controllers;

import java.util.Calendar;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CommandResultCacheItem {
    private static final int VALIDITY_DURATION = 30;
    private Date mExpiresOn = getExpiresOn();
    private CommandResult mValue;

    public CommandResultCacheItem(CommandResult commandResult) {
        this.mValue = commandResult;
    }

    private Date getExpiresOn() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(13, 30);
        return calendar.getTime();
    }

    public CommandResult getValue() {
        return this.mValue;
    }

    public boolean isExpired() {
        return Calendar.getInstance().getTime().after(this.mExpiresOn);
    }
}
