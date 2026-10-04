package com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.feature;

import android.os.Build;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/feature/SkipPreInitializeFeature;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", SkipPreInitializeFeature.STATE_CREATED, SkipPreInitializeFeature.STATE_DESTROYED, "needToSkipPreInitialize", "", "state", "screenOffActivityState", "getScreenOffActivityState", "()Ljava/lang/String;", "setScreenOffActivityState", "(Ljava/lang/String;)V", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SkipPreInitializeFeature {

    @NotNull
    public static final String STATE_CREATED = "STATE_CREATED";

    @NotNull
    public static final String STATE_DESTROYED = "STATE_DESTROYED";

    @NotNull
    public static final SkipPreInitializeFeature INSTANCE = new SkipPreInitializeFeature();

    @NotNull
    private static final String TAG = SOLogger.createTag("SkipPreInitializeFeature");

    private SkipPreInitializeFeature() {
    }

    @Nullable
    public final String getScreenOffActivityState() {
        return SharedPreferencesCompat.INSTANCE.getInstance(Constants.Preference.SCREEN_OFF_COMMON_PREF).getString(Constants.Preference.PREF_KEY_ACTIVITY_STATE, "");
    }

    public final boolean needToSkipPreInitialize() {
        boolean z = Build.VERSION.SDK_INT == 26 && !ServiceManager.INSTANCE.getInstance().canWorkOnBackground();
        AbstractC8014b.m7211m("needToSkipPreInitialize# ", z, SOLogger.INSTANCE, TAG);
        return z;
    }

    public final void setScreenOffActivityState(@Nullable String str) {
        SharedPreferencesCompat.INSTANCE.getInstance(Constants.Preference.SCREEN_OFF_COMMON_PREF).putString(Constants.Preference.PREF_KEY_ACTIVITY_STATE, str);
    }
}
