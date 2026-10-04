package com.samsung.android.support.senl.p148nt.app.settings.external;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/external/GlobalSetting;", "", "<init>", "()V", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class GlobalSetting {

    @NotNull
    private static final String ACTION_SEC_APPLICATION_SETTING = "com.sec.android.intent.action.SEC_APPLICATION_SETTINGS";

    @NotNull
    private static final String CATEGORY_SEC_APPLICATION_SETTING = "com.sec.android.intent.category.SEC_APPLICATION_SETTINGS";

    @NotNull
    private static final String CLASS_NAME_AI_DRAWING_SKETCH_BOOK_SETTING = "com.samsung.android.app.sketchbook.settings.AiDrawingSettingsActivity";

    @NotNull
    private static final String CLASS_NAME_AI_DRAWING_SMART_CAPTURE_SETTING = "com.samsung.android.aidrawing.settings.AiDrawingSettingsActivity";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String GLOBAL_CONTINUITY_SETTING = "continuity_setting";

    @NotNull
    private static final String MULTI_DEVICES_ACTION = "com.samsung.android.intent.action.MULTI_DEVICES";

    @NotNull
    private static final String TAG = "GlobalSetting";

    @NotNull
    private static final String USEFUL_FEATURE_MAIN_SETTINGS_ACTION = "com.samsung.settings.USEFUL_FEATURE_MAIN_SETTINGS";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u000b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/external/GlobalSetting$Companion;", "", "<init>", "()V", "launchContinuitySetting", "", "fragmentWeakReference", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/Fragment;", "requestCode", "", "launchAiDrawingSetting", SearchConstants.TargetContents.TAG, "", "USEFUL_FEATURE_MAIN_SETTINGS_ACTION", "MULTI_DEVICES_ACTION", "GLOBAL_CONTINUITY_SETTING", "ACTION_SEC_APPLICATION_SETTING", "CATEGORY_SEC_APPLICATION_SETTING", "CLASS_NAME_AI_DRAWING_SMART_CAPTURE_SETTING", "CLASS_NAME_AI_DRAWING_SKETCH_BOOK_SETTING", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void launchAiDrawingSetting(@NotNull WeakReference<Fragment> fragmentWeakReference) {
            String str;
            String str2;
            Intrinsics.checkNotNullParameter(fragmentWeakReference, "fragmentWeakReference");
            Fragment fragment = fragmentWeakReference.get();
            if (fragment == null) {
                MainLogger.m7259w(GlobalSetting.TAG, "launchAiDrawingSetting, fragment is null");
                fragmentWeakReference.clear();
                return;
            }
            Context context = fragment.getContext();
            if (context == null) {
                MainLogger.m7259w(GlobalSetting.TAG, "launchAiDrawingSetting, context is null");
                fragmentWeakReference.clear();
                return;
            }
            if (Features.isDrawingSupportSketchBookInstalled()) {
                str = Features.PACKAGE_NAME_SKETCH_BOOK;
                str2 = GlobalSetting.CLASS_NAME_AI_DRAWING_SKETCH_BOOK_SETTING;
            } else if (!Features.isDrawingSupportSmartCaptureInstalled()) {
                MainLogger.m7259w(GlobalSetting.TAG, "launchAiDrawingSetting, supported app is not installed");
                fragmentWeakReference.clear();
                return;
            } else {
                str = Features.PACKAGE_NAME_SMART_CAPTURE;
                str2 = GlobalSetting.CLASS_NAME_AI_DRAWING_SMART_CAPTURE_SETTING;
            }
            Intent intent = new Intent(GlobalSetting.ACTION_SEC_APPLICATION_SETTING);
            intent.addCategory(GlobalSetting.CATEGORY_SEC_APPLICATION_SETTING);
            intent.setClassName(str, str2);
            context.startActivity(intent);
            fragmentWeakReference.clear();
        }

        public final void launchContinuitySetting(@NotNull WeakReference<Fragment> fragmentWeakReference, int requestCode) {
            Intrinsics.checkNotNullParameter(fragmentWeakReference, "fragmentWeakReference");
            Fragment fragment = fragmentWeakReference.get();
            if (fragment == null) {
                MainLogger.m7259w(GlobalSetting.TAG, "launchContinuitySetting, fragment is null");
                fragmentWeakReference.clear();
                return;
            }
            Context context = fragment.getContext();
            if (context == null) {
                MainLogger.m7259w(GlobalSetting.TAG, "launchContinuitySetting, context is null");
                fragmentWeakReference.clear();
                return;
            }
            Intent intent = new Intent();
            if (DeviceInfo.getSemPlatformVersionInt(0) < 140000) {
                intent.setAction(GlobalSetting.USEFUL_FEATURE_MAIN_SETTINGS_ACTION);
            } else {
                intent.setAction(GlobalSetting.MULTI_DEVICES_ACTION);
            }
            Bundle bundle = new Bundle();
            bundle.putString(SettingsConstants.EXTRA_FRAGMENT_ARG_KEY, GlobalSetting.GLOBAL_CONTINUITY_SETTING);
            intent.putExtra(SettingsConstants.EXTRA_SHOW_FRAGMENT_ARG, bundle);
            if (intent.resolveActivity(context.getPackageManager()) == null) {
                MainLogger.m7259w(GlobalSetting.TAG, "launchContinuitySetting, intent do not have component");
                fragmentWeakReference.clear();
            } else {
                fragment.startActivityForResult(intent, requestCode);
                fragmentWeakReference.clear();
            }
        }

        private Companion() {
        }
    }
}
