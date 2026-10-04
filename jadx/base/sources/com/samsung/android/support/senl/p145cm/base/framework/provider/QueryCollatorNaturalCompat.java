package com.samsung.android.support.senl.p145cm.base.framework.provider;

import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/provider/QueryCollatorNaturalCompat;", "", "<init>", "()V", "sqlCollatorString", "", "getSqlCollatorString", "()Ljava/lang/String;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class QueryCollatorNaturalCompat {
    @NotNull
    public final String getSqlCollatorString() {
        return DeviceInfo.getSemPlatformVersionInt(0) >= 95000 ? "UNICODE_NATURAL" : "LOCALIZED";
    }
}
