package com.samsung.android.sdk.pen.setting.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sesl.visualeffect.utils.DeviceSettingsUtil;
import com.samsung.android.spen.libwrapper.ViewWrapper;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.spen.libwrapper.utils.PlatformUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.regex.PatternSyntaxException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilAccessibility;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "setAccessibilityNodeInfoToButton", "", "target", "Landroid/view/View;", "description", "requestAccessibilityFocus", "view", "isVoiceAssistantEnabled", "", "context", "Landroid/content/Context;", "isOldVoiceAssistantEnabled", "isTalkBackUsed", "()Z", "mIsCheckedRemoveAnimation", "mRemoveAnimationValue", "", "isRemoveAnimationsEnabled", "isHighContrast", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSettingUtilAccessibility {

    @NotNull
    public static final SpenSettingUtilAccessibility INSTANCE = new SpenSettingUtilAccessibility();

    @NotNull
    private static final String TAG = "SpenSettingUtilAccessibility";
    private static boolean mIsCheckedRemoveAnimation;
    private static int mRemoveAnimationValue;

    private SpenSettingUtilAccessibility() {
    }

    @JvmStatic
    public static final boolean isHighContrast(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Settings.Secure.getInt(context.getContentResolver(), "high_text_contrast_enabled", 0) == 1;
    }

    @SuppressLint({"LongLogTag"})
    private final boolean isOldVoiceAssistantEnabled(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
        if (string != null) {
            try {
                if (new Regex("(?i).*com.samsung.android.app.talkback.TalkBackService.*").matches(string) || new Regex("(?i).*com.samsung.android.marvin.talkback.TalkBackService.*").matches(string)) {
                    return true;
                }
                return new Regex("(?i).*com.google.android.marvin.talkback.TalkBackService.*").matches(string);
            } catch (PatternSyntaxException e) {
                Log.e(TAG, "isTalkBackEnabled() error: " + e);
            }
        }
        return false;
    }

    @JvmStatic
    @SuppressLint({"LongLogTag"})
    public static final boolean isRemoveAnimationsEnabled(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4765z(new Object[]{Boolean.valueOf(mIsCheckedRemoveAnimation), Integer.valueOf(mRemoveAnimationValue)}, 2, "isRemoveAnimationsEnabled() mIsCheckedRemoveAnimation=%s, RemoveAnimationValue=%d", "format(format, *args)", TAG);
        if (mIsCheckedRemoveAnimation && mRemoveAnimationValue == -1) {
            return false;
        }
        mIsCheckedRemoveAnimation = true;
        int i = Settings.Global.getInt(context.getContentResolver(), DeviceSettingsUtil.REDUCE_ANIMATION, -1);
        mRemoveAnimationValue = i;
        return i == 1;
    }

    private final boolean isTalkBackUsed() {
        return PlatformUtils.isSemDevice() && Build.VERSION.SDK_INT >= 30;
    }

    @JvmStatic
    public static final boolean isVoiceAssistantEnabled(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SpenSettingUtilAccessibility spenSettingUtilAccessibility = INSTANCE;
        if (!spenSettingUtilAccessibility.isTalkBackUsed()) {
            return spenSettingUtilAccessibility.isOldVoiceAssistantEnabled(context);
        }
        try {
            Object systemService = context.getSystemService("accessibility");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
            AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
            Object objInvoke = accessibilityManager.getClass().getMethod("semIsScreenReaderEnabled", null).invoke(accessibilityManager, null);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) objInvoke).booleanValue();
        } catch (Exception unused) {
            return INSTANCE.isOldVoiceAssistantEnabled(context);
        }
    }

    @JvmStatic
    public static final void requestAccessibilityFocus(@Nullable View view) {
        if (view != null) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            if (isVoiceAssistantEnabled(context)) {
                try {
                    ViewWrapper.create(view.getContext(), view).requestAccessibilityFocus();
                } catch (PlatformException unused) {
                    view.sendAccessibilityEvent(8);
                }
            }
        }
    }

    @JvmStatic
    public static final void setAccessibilityNodeInfoToButton(@Nullable View target, @Nullable String description) {
        if (target == null) {
            return;
        }
        target.setContentDescription(description);
        target.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAccessibility.setAccessibilityNodeInfoToButton.1
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                info.setClassName("android.widget.Button");
            }
        });
    }
}
