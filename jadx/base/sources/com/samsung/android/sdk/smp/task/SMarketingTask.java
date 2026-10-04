package com.samsung.android.sdk.smp.task;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.glance.AbstractC2821a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.database.DBHandler;
import com.samsung.android.sdk.smp.task.STask;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SMarketingTask extends STask {
    protected static final String EXTRA_MID = "EXTRA_MID";
    private final String mMid;

    public SMarketingTask(STask.MarketingAction marketingAction, Bundle bundle, String str) {
        super(marketingAction, bundle);
        this.mMid = str;
    }

    public static boolean isBasicMarketingTask(int i) {
        int i2 = i % 10000000;
        return STask.MarketingAction.BASIC.value() <= i2 && i2 < STask.MarketingAction.CLEAR.value();
    }

    public String getMid() {
        return this.mMid;
    }

    @Override // com.samsung.android.sdk.smp.task.STask
    public int getTaskId(Context context) {
        DBHandler dBHandlerOpen;
        if (getAction() == null || (dBHandlerOpen = DBHandler.open(context)) == null) {
            return 9000000;
        }
        int marketingDisplayId = dBHandlerOpen.getMarketingDisplayId(this.mMid);
        dBHandlerOpen.close();
        if (marketingDisplayId != -1) {
            return (marketingDisplayId % 1000) + STask.getJobIdSelectionValue(context) + getAction().value();
        }
        return 9000000;
    }

    @Override // com.samsung.android.sdk.smp.task.STask
    public Bundle toBundle(Context context) {
        Bundle bundle = super.toBundle(context);
        String str = this.mMid;
        if (str != null) {
            bundle.putString(EXTRA_MID, str);
        }
        return bundle;
    }

    @Override // com.samsung.android.sdk.smp.task.STask
    @NonNull
    public String toString() {
        Bundle data = getData();
        String string = data != null ? data.getString(Constants.EXTRA_KEY_MARKETING_SUB_ACTION) : null;
        if (!TextUtils.isEmpty(string)) {
            StringBuilder sb = new StringBuilder();
            AbstractC2821a.m2207B(sb, super.toString(), ":", string, CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
            sb.append(this.mMid);
            return sb.toString();
        }
        return super.toString() + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + this.mMid;
    }
}
