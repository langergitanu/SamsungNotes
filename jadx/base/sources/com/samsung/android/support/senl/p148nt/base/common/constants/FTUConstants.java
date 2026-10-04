package com.samsung.android.support.senl.p148nt.base.common.constants;

import android.content.SharedPreferences;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001.B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tH\u0007J\b\u0010\u0019\u001a\u00020\u0017H\u0007J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\tH\u0002J\b\u0010\u001d\u001a\u00020\u0017H\u0007J\b\u0010 \u001a\u00020\u0017H\u0007J\b\u0010#\u001a\u00020\u0017H\u0007J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0014H\u0007J\b\u0010&\u001a\u00020\u0017H\u0007J\b\u0010'\u001a\u00020\u0017H\u0007J\u0010\u0010*\u001a\u00020\u00172\b\u0010+\u001a\u0004\u0018\u00010,J\u0010\u0010-\u001a\u00020\u00172\b\u0010+\u001a\u0004\u0018\u00010,R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001a\u0010\u001cR\u001a\u0010\u001e\u001a\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b\u001e\u0010\u001cR\u001a\u0010!\u001a\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b!\u0010\u001cR\u001a\u0010(\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0003\u001a\u0004\b(\u0010\u000b¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/constants/FTUConstants;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "PREF_FTU", "KEY_LAST_USED_COMPOSER_FTU_VERSION", "TARGET_COMPOSER_FTU_VERSION", "", "getTARGET_COMPOSER_FTU_VERSION", "()I", "setTARGET_COMPOSER_FTU_VERSION", "(I)V", "TARGET_COMPOSER_FTU_VERSION_FOR_AI", "KEY_LAST_USED_CO_EDIT_FTU_VERSION", "KEY_FIRST_TIME_TO_COEDIT_JOIN", "EXTRA_TRY_CO_EDIT", "KEY_SIGN_IN_FTU", "mIsOpenedCoeditByNotification", "", "KEY_IN_APP_COLLABORATION_FTU_NEED", "initComposerFTUTargetVersion", "", "targetComposerFtuVersion", "setComposerFTUUsed", "isComposerFTUNeeds", "isComposerFTUNeeds$annotations", "()Z", "setInAppFTUUsed", "isInAppFTUNeeds", "isInAppFTUNeeds$annotations", "setCoeditFTUUsed", "isCoeditFTUNeeds", "isCoeditFTUNeeds$annotations", "setCoeditOpenedByNotification", "isFirstTimeToCoeditJoin", "isNeedToClearValue", "setSignInFTUNeedToShow", "setSignInFTUUsed", "isSignInFTUNeeds", "isSignInFTUNeeds$annotations", "registerFTUNeedStateChangeListener", "changeListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "unregisterFTUNeedStateChangeListener", "SignIn", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FTUConstants {

    @NotNull
    public static final String EXTRA_TRY_CO_EDIT = "extra_try_co_edit";

    @NotNull
    public static final String KEY_FIRST_TIME_TO_COEDIT_JOIN = "first_time_to_coedit_join";

    @NotNull
    private static final String KEY_IN_APP_COLLABORATION_FTU_NEED = "is_in_app_collaboration_need";

    @NotNull
    public static final String KEY_LAST_USED_COMPOSER_FTU_VERSION = "key_last_used_ftu_version";

    @NotNull
    public static final String KEY_LAST_USED_CO_EDIT_FTU_VERSION = "key_last_used_co_edit_ftu_version";

    @NotNull
    public static final String KEY_SIGN_IN_FTU = "sign_in_ftu";

    @NotNull
    public static final String PREF_FTU = "FTU_Preference";

    @NotNull
    private static final String TAG = "FTUConstants";
    public static final int TARGET_COMPOSER_FTU_VERSION_FOR_AI = 3;
    private static boolean mIsOpenedCoeditByNotification;

    @NotNull
    public static final FTUConstants INSTANCE = new FTUConstants();
    private static int TARGET_COMPOSER_FTU_VERSION = 1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/constants/FTUConstants$SignIn;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface SignIn {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int VALUE_NEED_TO_SHOW = 0;
        public static final int VALUE_NOT_CHECKED = -1;
        public static final int VALUE_USED = 1;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/constants/FTUConstants$SignIn$Companion;", "", "<init>", "()V", "VALUE_NOT_CHECKED", "", "VALUE_NEED_TO_SHOW", "VALUE_USED", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int VALUE_NEED_TO_SHOW = 0;
            public static final int VALUE_NOT_CHECKED = -1;
            public static final int VALUE_USED = 1;

            private Companion() {
            }
        }
    }

    private FTUConstants() {
    }

    @JvmStatic
    public static final void initComposerFTUTargetVersion(int targetComposerFtuVersion) {
        AbstractC4539a.m3212v(targetComposerFtuVersion, "initComposerFTUTargetVersion# targetComposerFtuVersion: ", TAG);
        TARGET_COMPOSER_FTU_VERSION = targetComposerFtuVersion;
    }

    public static final boolean isCoeditFTUNeeds() {
        if (mIsOpenedCoeditByNotification) {
            Logger.m8702i(TAG, "isCoeditFTUNeeds# false. IsOpenedCoeditByNotification");
            return false;
        }
        boolean z = SharedPreferencesCompat.INSTANCE.getInstance(PREF_FTU).getBoolean(KEY_LAST_USED_CO_EDIT_FTU_VERSION, true);
        Logger.m8702i(TAG, "isCoeditFTUNeeds# isCoeditFTUNeeds: " + z);
        return z;
    }

    @JvmStatic
    public static /* synthetic */ void isCoeditFTUNeeds$annotations() {
    }

    public static final boolean isComposerFTUNeeds() {
        return INSTANCE.isComposerFTUNeeds(TARGET_COMPOSER_FTU_VERSION);
    }

    @JvmStatic
    public static /* synthetic */ void isComposerFTUNeeds$annotations() {
    }

    @JvmStatic
    public static final boolean isFirstTimeToCoeditJoin(boolean isNeedToClearValue) {
        SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
        boolean z = companion.getInstance(PREF_FTU).getBoolean(KEY_FIRST_TIME_TO_COEDIT_JOIN, true);
        if (isNeedToClearValue && z) {
            Logger.m8702i(TAG, "isFirstTimeToCoeditJoin#");
            companion.getInstance(PREF_FTU).putBoolean(KEY_FIRST_TIME_TO_COEDIT_JOIN, false);
        }
        return z;
    }

    public static final boolean isInAppFTUNeeds() {
        boolean z = SharedPreferencesCompat.INSTANCE.getInstance().getBoolean(KEY_IN_APP_COLLABORATION_FTU_NEED, true);
        Logger.m8702i(TAG, "isInAppFTUNeeds# isInAppFTUNeeds: " + z);
        return z;
    }

    @JvmStatic
    public static /* synthetic */ void isInAppFTUNeeds$annotations() {
    }

    public static final int isSignInFTUNeeds() {
        if (DeviceUtils.isShopDemoDevice(BaseUtils.getApplicationContext())) {
            return 1;
        }
        SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
        int i = companion.getInstance(Constants.APP_LAUNCH_PREFERENCE).getInt(KEY_SIGN_IN_FTU, -1);
        if (i == -1) {
            int i2 = companion.getInstance(Constants.APP_LAUNCH_PREFERENCE).getInt("app_version", -1) == -1 ? 0 : 1;
            companion.getInstance(Constants.APP_LAUNCH_PREFERENCE).putInt(KEY_SIGN_IN_FTU, i2);
            i = i2;
        }
        AbstractC4539a.m3212v(i, "isSignInFTUNeeds# isSignInFTUNeeds: ", TAG);
        return i;
    }

    @JvmStatic
    public static /* synthetic */ void isSignInFTUNeeds$annotations() {
    }

    @JvmStatic
    public static final void setCoeditFTUUsed() {
        Logger.m8702i(TAG, "setCoeditFTUUsed# ");
        SharedPreferencesCompat.INSTANCE.getInstance(PREF_FTU).putBoolean(KEY_LAST_USED_CO_EDIT_FTU_VERSION, false);
    }

    @JvmStatic
    public static final void setCoeditOpenedByNotification() {
        Logger.m8702i(TAG, "setCoeditOpenedByNotification#");
        mIsOpenedCoeditByNotification = true;
    }

    @JvmStatic
    public static final void setComposerFTUUsed() {
        SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
        Logger.m8702i(TAG, "setComposerFTUUsed# lastUsedVersion: " + companion.getInstance(PREF_FTU).getInt(KEY_LAST_USED_COMPOSER_FTU_VERSION, 0) + " to " + TARGET_COMPOSER_FTU_VERSION);
        companion.getInstance(PREF_FTU).putInt(KEY_LAST_USED_COMPOSER_FTU_VERSION, TARGET_COMPOSER_FTU_VERSION);
    }

    @JvmStatic
    public static final void setInAppFTUUsed() {
        Logger.m8702i(TAG, "setInAppFTUUsed# ");
        SharedPreferencesCompat.INSTANCE.getInstance().putBoolean(KEY_IN_APP_COLLABORATION_FTU_NEED, false);
    }

    @JvmStatic
    public static final void setSignInFTUNeedToShow() {
        Logger.m8702i(TAG, "setSignInFTUNeedToShow#");
        SharedPreferencesCompat.INSTANCE.getInstance(Constants.APP_LAUNCH_PREFERENCE).putInt(KEY_SIGN_IN_FTU, 0);
    }

    @JvmStatic
    public static final void setSignInFTUUsed() {
        Logger.m8702i(TAG, "setSignInFTUUsed#");
        SharedPreferencesCompat.INSTANCE.getInstance(Constants.APP_LAUNCH_PREFERENCE).putInt(KEY_SIGN_IN_FTU, 1);
    }

    public final int getTARGET_COMPOSER_FTU_VERSION() {
        return TARGET_COMPOSER_FTU_VERSION;
    }

    public final void registerFTUNeedStateChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener changeListener) {
        SharedPreferencesCompat.INSTANCE.getInstance(PREF_FTU).registerOnSharedPreferenceChangeListener(changeListener);
    }

    public final void setTARGET_COMPOSER_FTU_VERSION(int i) {
        TARGET_COMPOSER_FTU_VERSION = i;
    }

    public final void unregisterFTUNeedStateChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener changeListener) {
        SharedPreferencesCompat.INSTANCE.getInstance(PREF_FTU).unregisterOnSharedPreferenceChangeListener(changeListener);
    }

    private final boolean isComposerFTUNeeds(int targetComposerFtuVersion) {
        int i = SharedPreferencesCompat.INSTANCE.getInstance(PREF_FTU).getInt(KEY_LAST_USED_COMPOSER_FTU_VERSION, 0);
        Logger.m8702i(TAG, "isComposerFTUNeeds# lastUsedVersion: " + i + ", target version " + targetComposerFtuVersion);
        return i < targetComposerFtuVersion;
    }
}
