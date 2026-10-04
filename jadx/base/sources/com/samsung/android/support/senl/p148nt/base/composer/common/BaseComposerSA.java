package com.samsung.android.support.senl.p148nt.base.composer.common;

import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/common/BaseComposerSA;", "", "<init>", "()V", "insertLog", "", "screenID", "", "event", NetworkConfig.CLIENTS_FEEDBACK_DETAIL, "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BaseComposerSA {

    @NotNull
    public static final BaseComposerSA INSTANCE = new BaseComposerSA();

    private BaseComposerSA() {
    }

    @JvmStatic
    public static final void insertLog(@Nullable String screenID, @NotNull String event, @Nullable String detail) {
        Intrinsics.checkNotNullParameter(event, "event");
        NotesSamsungAnalytics.INSTANCE.insertLog(screenID, event, detail);
    }
}
