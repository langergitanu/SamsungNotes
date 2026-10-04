package com.samsung.android.app.sdk.deepsky.common;

import android.app.appsearch.AppSearchSchema;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;

/* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.common.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract /* synthetic */ class AbstractC7018e {
    /* JADX INFO: renamed from: A */
    public static /* synthetic */ AppSearchSchema.StringPropertyConfig.Builder m5317A() {
        return new AppSearchSchema.StringPropertyConfig.Builder("categories");
    }

    /* JADX INFO: renamed from: C */
    public static /* synthetic */ AppSearchSchema.StringPropertyConfig.Builder m5319C() {
        return new AppSearchSchema.StringPropertyConfig.Builder("intents");
    }

    /* JADX INFO: renamed from: D */
    public static /* synthetic */ AppSearchSchema.StringPropertyConfig.Builder m5320D() {
        return new AppSearchSchema.StringPropertyConfig.Builder("locusId");
    }

    /* JADX INFO: renamed from: b */
    public static /* synthetic */ AppSearchSchema.BytesPropertyConfig.Builder m5322b() {
        return new AppSearchSchema.BytesPropertyConfig.Builder("intentPersistableExtras");
    }

    /* JADX INFO: renamed from: d */
    public static /* synthetic */ AppSearchSchema.StringPropertyConfig.Builder m5324d() {
        return new AppSearchSchema.StringPropertyConfig.Builder("capability");
    }

    /* JADX INFO: renamed from: i */
    public static /* synthetic */ AppSearchSchema.BytesPropertyConfig.Builder m5329i() {
        return new AppSearchSchema.BytesPropertyConfig.Builder("extras");
    }

    /* JADX INFO: renamed from: k */
    public static /* synthetic */ AppSearchSchema.StringPropertyConfig.Builder m5331k() {
        return new AppSearchSchema.StringPropertyConfig.Builder("capabilityBindings");
    }

    /* JADX INFO: renamed from: o */
    public static /* synthetic */ AppSearchSchema.StringPropertyConfig.Builder m5335o() {
        return new AppSearchSchema.StringPropertyConfig.Builder(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
    }

    /* JADX INFO: renamed from: r */
    public static /* synthetic */ AppSearchSchema.StringPropertyConfig.Builder m5338r() {
        return new AppSearchSchema.StringPropertyConfig.Builder("shortLabel");
    }

    /* JADX INFO: renamed from: u */
    public static /* synthetic */ AppSearchSchema.StringPropertyConfig.Builder m5341u() {
        return new AppSearchSchema.StringPropertyConfig.Builder("longLabel");
    }

    /* JADX INFO: renamed from: x */
    public static /* synthetic */ AppSearchSchema.StringPropertyConfig.Builder m5344x() {
        return new AppSearchSchema.StringPropertyConfig.Builder("disabledMessage");
    }
}
