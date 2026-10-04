package com.samsung.android.support.senl.p145cm.base.common.util;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\nH\u0007¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/DetourUtils;", "", "<init>", "()V", "equalFloatValues", "", "v1", "", AuthenticationConstants.Broker.BROKER_PROTOCOL_VERSION, "equalDoubleValues", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DetourUtils {

    @NotNull
    public static final DetourUtils INSTANCE = new DetourUtils();

    private DetourUtils() {
    }

    @JvmStatic
    public static final boolean equalDoubleValues(double v12, double v22) {
        return Math.abs(v12 - v22) < 1.0E-7d;
    }

    @JvmStatic
    public static final boolean equalFloatValues(float v12, float v22) {
        return Math.abs((double) (v12 - v22)) < 1.0000000116860974E-7d;
    }
}
