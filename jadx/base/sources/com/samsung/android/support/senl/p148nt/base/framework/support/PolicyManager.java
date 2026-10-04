package com.samsung.android.support.senl.p148nt.base.framework.support;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import com.samsung.android.support.senl.p145cm.base.framework.app.PolicyManagerCompat;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\u0006\u0010\tR\u001a\u0010\n\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\n\u0010\tR\u001a\u0010\f\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\f\u0010\tR\u001a\u0010\u000e\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u000e\u0010\t¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/framework/support/PolicyManager;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "isEdmPolicyAiEnabled", "", "isEdmPolicyAiEnabled$annotations", "()Z", "isEdmPolicyAiGrayout", "isEdmPolicyAiGrayout$annotations", "isEdmPolicyAiDrawingEnabled", "isEdmPolicyAiDrawingEnabled$annotations", "isEdmPolicyAiDrawingGrayout", "isEdmPolicyAiDrawingGrayout$annotations", "updateKnoxRestrictions", "", "getCameraDisabled", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PolicyManager {

    @NotNull
    public static final PolicyManager INSTANCE = new PolicyManager();

    @NotNull
    private static final String TAG = "PolicyManager";

    private PolicyManager() {
    }

    @JvmStatic
    public static final boolean getCameraDisabled(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Object systemService = activity.getSystemService("device_policy");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.admin.DevicePolicyManager");
        if (!((DevicePolicyManager) systemService).getCameraDisabled(null)) {
            return false;
        }
        Logger.m8702i(TAG, "camera security policy restricted");
        String string = activity.getResources().getString(C8875R.string.camera_security_policy_restriction);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ToastHandler.show(activity, string, 0);
        return true;
    }

    public static final boolean isEdmPolicyAiDrawingEnabled() {
        return PolicyManagerCompat.INSTANCE.getInstance().isEdmPolicyAiDrawingEnabled(ApplicationManager.INSTANCE.getInstance().getAppContext());
    }

    @JvmStatic
    public static /* synthetic */ void isEdmPolicyAiDrawingEnabled$annotations() {
    }

    public static final boolean isEdmPolicyAiDrawingGrayout() {
        return PolicyManagerCompat.INSTANCE.getInstance().isEdmPolicyAiDrawingGrayout(ApplicationManager.INSTANCE.getInstance().getAppContext());
    }

    @JvmStatic
    public static /* synthetic */ void isEdmPolicyAiDrawingGrayout$annotations() {
    }

    public static final boolean isEdmPolicyAiEnabled() {
        return PolicyManagerCompat.INSTANCE.getInstance().isEdmPolicyAiEnabled(ApplicationManager.INSTANCE.getInstance().getAppContext());
    }

    @JvmStatic
    public static /* synthetic */ void isEdmPolicyAiEnabled$annotations() {
    }

    public static final boolean isEdmPolicyAiGrayout() {
        return PolicyManagerCompat.INSTANCE.getInstance().isEdmPolicyAiGrayout(ApplicationManager.INSTANCE.getInstance().getAppContext());
    }

    @JvmStatic
    public static /* synthetic */ void isEdmPolicyAiGrayout$annotations() {
    }

    @JvmStatic
    public static final void updateKnoxRestrictions() {
        PolicyManagerCompat.INSTANCE.getInstance().updateKnoxRestrictions(ApplicationManager.INSTANCE.getInstance().getAppContext());
    }
}
