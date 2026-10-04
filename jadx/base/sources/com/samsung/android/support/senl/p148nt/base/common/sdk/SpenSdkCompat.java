package com.samsung.android.support.senl.p148nt.base.common.sdk;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.SpenSdkClassFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sdk/SpenSdkCompat;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "with", "LSpenSdkClassFactory;", "context", "Landroid/content/Context;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenSdkCompat {

    @NotNull
    public static final SpenSdkCompat INSTANCE = new SpenSdkCompat();

    @NotNull
    private static final String TAG = "SpenSdkCompat";

    private SpenSdkCompat() {
    }

    @JvmStatic
    @NotNull
    public static final SpenSdkClassFactory with(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new SpenSdkClassFactory(context);
    }
}
