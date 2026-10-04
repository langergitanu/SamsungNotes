package com.samsung.android.support.senl.p148nt.base.common.access.sync;

import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00078F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R6\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00078F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R6\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00078F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R6\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00078F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/access/sync/ReceiverAccessHandler;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "MDE_PUSH_RECEIVER_CLASS", "Ljava/lang/Class;", "COEDIT_PUSH_RECEIVER_CLASS", "EDP_PUSH_RECEIVER_CLASS", "KNOX_RESTRICTIONS_RECEIVER_CLASS", "executor", "mdePushReceiverClass", "getMdePushReceiverClass$annotations", "getMdePushReceiverClass", "()Ljava/lang/Class;", "setMdePushReceiverClass", "(Ljava/lang/Class;)V", "coeditPushReceiverClass", "getCoeditPushReceiverClass$annotations", "getCoeditPushReceiverClass", "setCoeditPushReceiverClass", "edpPushReceiverClass", "getEdpPushReceiverClass$annotations", "getEdpPushReceiverClass", "setEdpPushReceiverClass", "knoxRestrictionsReceiverClass", "getKnoxRestrictionsReceiverClass$annotations", "getKnoxRestrictionsReceiverClass", "setKnoxRestrictionsReceiverClass", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ReceiverAccessHandler {

    @Nullable
    private static Class<?> COEDIT_PUSH_RECEIVER_CLASS = null;

    @Nullable
    private static Class<?> EDP_PUSH_RECEIVER_CLASS = null;

    @NotNull
    public static final ReceiverAccessHandler INSTANCE = new ReceiverAccessHandler();

    @Nullable
    private static Class<?> KNOX_RESTRICTIONS_RECEIVER_CLASS = null;

    @Nullable
    private static Class<?> MDE_PUSH_RECEIVER_CLASS = null;

    @NotNull
    private static final String TAG = "ReceiverAccessHandler";

    private ReceiverAccessHandler() {
    }

    @Nullable
    public static final Class<?> getCoeditPushReceiverClass() {
        return COEDIT_PUSH_RECEIVER_CLASS;
    }

    @JvmStatic
    public static /* synthetic */ void getCoeditPushReceiverClass$annotations() {
    }

    @Nullable
    public static final Class<?> getEdpPushReceiverClass() {
        return EDP_PUSH_RECEIVER_CLASS;
    }

    @JvmStatic
    public static /* synthetic */ void getEdpPushReceiverClass$annotations() {
    }

    @Nullable
    public static final Class<?> getKnoxRestrictionsReceiverClass() {
        return KNOX_RESTRICTIONS_RECEIVER_CLASS;
    }

    @JvmStatic
    public static /* synthetic */ void getKnoxRestrictionsReceiverClass$annotations() {
    }

    @Nullable
    public static final Class<?> getMdePushReceiverClass() {
        return MDE_PUSH_RECEIVER_CLASS;
    }

    @JvmStatic
    public static /* synthetic */ void getMdePushReceiverClass$annotations() {
    }

    public static final void setCoeditPushReceiverClass(@Nullable Class<?> cls) {
        if (COEDIT_PUSH_RECEIVER_CLASS == null) {
            COEDIT_PUSH_RECEIVER_CLASS = cls;
        } else {
            Logger.m8698e(TAG, "setCoeditPushReceiverClass, twice access! only first trial is accepted");
        }
    }

    public static final void setEdpPushReceiverClass(@Nullable Class<?> cls) {
        if (EDP_PUSH_RECEIVER_CLASS == null) {
            EDP_PUSH_RECEIVER_CLASS = cls;
        } else {
            Logger.m8698e(TAG, "setEdpPushReceiverClass, twice access! only first trial is accepted");
        }
    }

    public static final void setKnoxRestrictionsReceiverClass(@Nullable Class<?> cls) {
        if (KNOX_RESTRICTIONS_RECEIVER_CLASS == null) {
            KNOX_RESTRICTIONS_RECEIVER_CLASS = cls;
        } else {
            Logger.m8698e(TAG, "setKnoxRestrictionsReceiverClass, twice access! only first trial is accepted");
        }
    }

    public static final void setMdePushReceiverClass(@Nullable Class<?> cls) {
        if (MDE_PUSH_RECEIVER_CLASS == null) {
            MDE_PUSH_RECEIVER_CLASS = cls;
        } else {
            Logger.m8698e(TAG, "setMdePushReceiverClass, twice access! only first trial is accepted");
        }
    }
}
