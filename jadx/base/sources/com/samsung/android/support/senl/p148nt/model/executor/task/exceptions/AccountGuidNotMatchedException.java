package com.samsung.android.support.senl.p148nt.model.executor.task.exceptions;

import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class AccountGuidNotMatchedException extends Exception {
    public AccountGuidNotMatchedException(String str, String str2) {
        super(DataLogger.getEncode(str) + " is not matched with " + DataLogger.getEncode(str2));
    }
}
