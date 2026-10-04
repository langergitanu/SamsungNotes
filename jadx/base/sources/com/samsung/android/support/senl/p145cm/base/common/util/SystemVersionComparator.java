package com.samsung.android.support.senl.p145cm.base.common.util;

import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/SystemVersionComparator;", "", "<init>", "()V", "isHigherThan", "", "versionCode", "", "isEqualOrHigherThan", "isLessThan", "isEqualOrLessThan", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SystemVersionComparator {

    @NotNull
    public static final SystemVersionComparator INSTANCE = new SystemVersionComparator();

    private SystemVersionComparator() {
    }

    @JvmStatic
    public static final boolean isLessThan(int versionCode) {
        return Build.VERSION.SDK_INT < versionCode;
    }

    public final boolean isEqualOrHigherThan(int versionCode) {
        return Build.VERSION.SDK_INT >= versionCode;
    }

    public final boolean isEqualOrLessThan(int versionCode) {
        return Build.VERSION.SDK_INT <= versionCode;
    }

    public final boolean isHigherThan(int versionCode) {
        return Build.VERSION.SDK_INT > versionCode;
    }
}
