package com.samsung.scsp.common;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Invoker {
    String appId;
    String appVersion;
    String reason;
    String sdkName;
    String sdkVersion;

    public Invoker(String str, String str2, String str3) {
        this.appId = str;
        this.appVersion = str2;
        this.reason = str3;
    }

    public void set(String str, String str2) {
        this.sdkName = str;
        this.sdkVersion = str2;
    }

    @NonNull
    public String toString() {
        return this.appId + '/' + this.appVersion + SQLKeyword.DELIMITER + this.sdkName + '/' + this.sdkVersion + SQLKeyword.DELIMITER + this.reason;
    }
}
