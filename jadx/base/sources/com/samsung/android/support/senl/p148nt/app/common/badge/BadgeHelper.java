package com.samsung.android.support.senl.p148nt.app.common.badge;

import android.content.SharedPreferences;
import android.content.res.Resources;
import androidx.glance.AbstractC2821a;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.badge.BadgeHelper;
import com.samsung.android.support.senl.p148nt.app.common.data.RepositoryManager;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.GcsConstants;
import com.samsung.android.support.senl.p148nt.app.settings.common.utils.SettingsMenuUtils;
import com.samsung.android.support.senl.p148nt.app.updater.UpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001-B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\b\u0010\u0010\u001a\u00020\fH\u0007J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u0014\u001a\u00020\u0013H\u0007J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u0016\u001a\u00020\u0013H\u0007J\u0012\u0010\u0017\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u0012\u0010\u0018\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\b\u0010\u0019\u001a\u00020\fH\u0007J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u001b\u001a\u00020\u0013H\u0007J\u0012\u0010\u001c\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u0012\u0010\u001d\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J2\u0010\u001e\u001a\u00020\f2\u0016\u0010\u001f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010!0 2\u0006\u0010\"\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u0010$\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010!0 H\u0002J\u001a\u0010%\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010&\u001a\u00020\u0013H\u0007J\u0012\u0010'\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u0012\u0010(\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u0012\u0010)\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010*\u001a\u00020\u0013H\u0007J\b\u0010+\u001a\u00020,H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/common/badge/BadgeHelper;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mGcsDrawerBadgeListenerModel", "Lcom/samsung/android/support/senl/nt/app/common/badge/BadgeHelper$BadgeListenerModel;", "mCoeditListenerModel", "mSOMListenerModel", "mSettingListenerModel", "registerGCSDrawerBadgeChangeListener", "", "changeListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "unregisterGCSDrawerBadgeChangeListener", "updateGcsUnReadCount", "setGcsHasDrawerBadge", "hasBadge", "", "hasGcsDrawerBadge", "setGcsHasMoreBadge", "hasGcsMoreBadge", "registerCoeditBadgeChangeListener", "unregisterCoeditBadgeChangeListener", "updateCoeditUnReadCount", "setCoeditHasBadge", "hasCoeditBadge", "registerSOMBadgeChangeListener", "unregisterSOMBadgeChangeListener", "updateSOMRecognizedTimes", "recognizeModifiedTimes", "", "", "isSOMRecognizedCardCollapsed", NotesConstants.KEY_CALLER, "getLastSOMRecognizeModifiedTimes", "setSOMFolderHasNewBadge", "hasSOMFolderNewBadge", "registerSettingBadgeChangeListener", "unregisterSettingBadgeChangeListener", "getDrawerButtonContentDescription", "hasDrawerIconNewBadge", "getNumOfSettingsNewBadgeReason", "", "BadgeListenerModel", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BadgeHelper {

    @NotNull
    private static final String TAG = "BadgeHelper";

    @NotNull
    public static final BadgeHelper INSTANCE = new BadgeHelper();

    @NotNull
    private static final BadgeListenerModel mGcsDrawerBadgeListenerModel = new BadgeListenerModel(GcsConstants.GCS_PREFS_NAME, GcsConstants.KEY_GCS_HAS_DRAWER_BADGE);

    @NotNull
    private static final BadgeListenerModel mCoeditListenerModel = new BadgeListenerModel(GcsConstants.COEDIT_PREFS_NAME, GcsConstants.KEY_COEIDT_HAS_BADGE);

    @NotNull
    private static final BadgeListenerModel mSOMListenerModel = new BadgeListenerModel(FolderConstants.PREF_FOLDER_INFO, FolderConstants.KEY_SOM_FOLDER_HAS_BADGE);

    @NotNull
    private static final BadgeListenerModel mSettingListenerModel = new BadgeListenerModel("Settings", SettingsConstants.HAS_NEW_VERSION_BADGE);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/common/badge/BadgeHelper$BadgeListenerModel;", "", "prefName", "", "targetKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "mutex", "registeredChangeListeners", "", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "internalChangeListener", "registerListener", "", "changeListener", "unregisterListener", "setHasBadge", "hasBadge", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class BadgeListenerModel {

        @Nullable
        private SharedPreferences.OnSharedPreferenceChangeListener internalChangeListener;

        @NotNull
        private Object mutex;

        @NotNull
        private final String prefName;

        @Nullable
        private Set<SharedPreferences.OnSharedPreferenceChangeListener> registeredChangeListeners;

        @NotNull
        private final String targetKey;

        public BadgeListenerModel(@NotNull String prefName, @NotNull String targetKey) {
            Intrinsics.checkNotNullParameter(prefName, "prefName");
            Intrinsics.checkNotNullParameter(targetKey, "targetKey");
            this.prefName = prefName;
            this.targetKey = targetKey;
            this.mutex = new Object();
        }

        public final boolean hasBadge() {
            return SharedPreferencesCompat.INSTANCE.getInstance(this.prefName).getBoolean(this.targetKey, false);
        }

        public final void registerListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener changeListener) {
            synchronized (this.mutex) {
                try {
                    if (this.registeredChangeListeners == null) {
                        this.registeredChangeListeners = new HashSet();
                    }
                    Set<SharedPreferences.OnSharedPreferenceChangeListener> set = this.registeredChangeListeners;
                    Intrinsics.checkNotNull(set);
                    Intrinsics.checkNotNull(changeListener);
                    set.add(changeListener);
                    if (this.internalChangeListener != null) {
                        return;
                    }
                    this.internalChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.samsung.android.support.senl.nt.app.common.badge.BadgeHelper$BadgeListenerModel$registerListener$1$1
                        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                            if (Intrinsics.areEqual(this.this$0.targetKey, key)) {
                                Object obj = this.this$0.mutex;
                                BadgeHelper.BadgeListenerModel badgeListenerModel = this.this$0;
                                synchronized (obj) {
                                    try {
                                        if (badgeListenerModel.registeredChangeListeners == null) {
                                            return;
                                        }
                                        Iterator it = badgeListenerModel.registeredChangeListeners.iterator();
                                        while (it.hasNext()) {
                                            ((SharedPreferences.OnSharedPreferenceChangeListener) it.next()).onSharedPreferenceChanged(sharedPreferences, key);
                                        }
                                        Unit unit = Unit.INSTANCE;
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            }
                        }
                    };
                    SharedPreferencesCompat.INSTANCE.getInstance(this.prefName).registerOnSharedPreferenceChangeListener(this.internalChangeListener);
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void setHasBadge(boolean hasBadge) {
            SharedPreferencesCompat.INSTANCE.getInstance(this.prefName).putBoolean(this.targetKey, hasBadge);
        }

        public final void unregisterListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener changeListener) {
            synchronized (this.mutex) {
                try {
                    Set<SharedPreferences.OnSharedPreferenceChangeListener> set = this.registeredChangeListeners;
                    if (set == null) {
                        return;
                    }
                    Intrinsics.checkNotNull(set);
                    Intrinsics.checkNotNull(changeListener);
                    set.remove(changeListener);
                    Set<SharedPreferences.OnSharedPreferenceChangeListener> set2 = this.registeredChangeListeners;
                    Intrinsics.checkNotNull(set2);
                    if (set2.isEmpty() && this.internalChangeListener != null) {
                        SharedPreferencesCompat.INSTANCE.getInstance(GcsConstants.GCS_PREFS_NAME).unregisterOnSharedPreferenceChangeListener(this.internalChangeListener);
                        this.internalChangeListener = null;
                    }
                    Set<SharedPreferences.OnSharedPreferenceChangeListener> set3 = this.registeredChangeListeners;
                    Intrinsics.checkNotNull(set3);
                    if (set3.isEmpty()) {
                        this.registeredChangeListeners = null;
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private BadgeHelper() {
    }

    @JvmStatic
    @Nullable
    public static final String getDrawerButtonContentDescription(boolean hasBadge) {
        Resources resources = BaseUtils.getContext().getResources();
        String string = resources.getString(C8003R.string.drawer_description);
        return hasBadge ? AbstractC2821a.m2221l(string, resources.getString(C8003R.string.string_comma), " ", resources.getString(C8003R.string.drawer_new_item_added_description)) : string;
    }

    private final Map<String, Long> getLastSOMRecognizeModifiedTimes() {
        Map<String, Long> map = (Map) new Gson().fromJson(SharedPreferencesCompat.INSTANCE.getInstance(FolderConstants.PREF_FOLDER_INFO).getString(FolderConstants.KEY_SOM_RECOGNIZE_MODIFIED_TIME, ""), new TypeToken<Map<String, Long>>() { // from class: com.samsung.android.support.senl.nt.app.common.badge.BadgeHelper$getLastSOMRecognizeModifiedTimes$map$1
        }.getType());
        return map == null ? new HashMap() : map;
    }

    @JvmStatic
    public static final int getNumOfSettingsNewBadgeReason() {
        boolean zHasBadge = UpdateManager.getInstance().hasBadge();
        AbstractC8014b.m7210l("getNumOfSettingsNewBadgeReason# updateBadge: ", TAG, zHasBadge);
        return zHasBadge ? 1 : 0;
    }

    @JvmStatic
    public static final boolean hasCoeditBadge() {
        if (SettingsMenuUtils.INSTANCE.isSharedNotesSyncSupported(BaseUtils.getContext())) {
            return mCoeditListenerModel.hasBadge();
        }
        return false;
    }

    @JvmStatic
    public static final boolean hasDrawerIconNewBadge() {
        int numOfSettingsNewBadgeReason = getNumOfSettingsNewBadgeReason();
        boolean zHasGcsDrawerBadge = hasGcsDrawerBadge();
        boolean zHasCoeditBadge = hasCoeditBadge();
        boolean zHasSOMFolderNewBadge = hasSOMFolderNewBadge();
        StringBuilder sbM2226q = AbstractC2821a.m2226q("checkDrawerIconNewBadge# numOfSettingsNewBadgeReason: ", numOfSettingsNewBadgeReason, ", mdeNewBadge : ", zHasGcsDrawerBadge, ", coeditNewBadge : ");
        sbM2226q.append(zHasCoeditBadge);
        sbM2226q.append(", somFolderNewBadge : ");
        sbM2226q.append(zHasSOMFolderNewBadge);
        MainLogger.m7254d(TAG, sbM2226q.toString());
        return numOfSettingsNewBadgeReason > 0 || zHasGcsDrawerBadge || zHasCoeditBadge || zHasSOMFolderNewBadge;
    }

    @JvmStatic
    public static final boolean hasGcsDrawerBadge() {
        if (NotesUtils.isMDEFeatureEnabled()) {
            return mGcsDrawerBadgeListenerModel.hasBadge();
        }
        return false;
    }

    @JvmStatic
    public static final boolean hasGcsMoreBadge() {
        if (NotesUtils.isMDEFeatureEnabled()) {
            return SharedPreferencesCompat.INSTANCE.getInstance(GcsConstants.GCS_PREFS_NAME).getBoolean(GcsConstants.KEY_GCS_HAS_MORE_BADGE, false);
        }
        return false;
    }

    @JvmStatic
    public static final boolean hasSOMFolderNewBadge() {
        if (FeatureUtils.isSOMFeatureSupported()) {
            return mSOMListenerModel.hasBadge();
        }
        return false;
    }

    @JvmStatic
    public static final void registerCoeditBadgeChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener changeListener) {
        if (SettingsMenuUtils.INSTANCE.isSharedNotesSyncSupported(BaseUtils.getContext())) {
            mCoeditListenerModel.registerListener(changeListener);
        }
    }

    @JvmStatic
    public static final void registerGCSDrawerBadgeChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener changeListener) {
        if (NotesUtils.isMDEFeatureEnabled()) {
            mGcsDrawerBadgeListenerModel.registerListener(changeListener);
        }
    }

    @JvmStatic
    public static final void registerSOMBadgeChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener changeListener) {
        if (FeatureUtils.isSOMFeatureSupported()) {
            mSOMListenerModel.registerListener(changeListener);
        }
    }

    @JvmStatic
    public static final void registerSettingBadgeChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener changeListener) {
        mSettingListenerModel.registerListener(changeListener);
    }

    @JvmStatic
    public static final void setCoeditHasBadge(boolean hasBadge) {
        if (SettingsMenuUtils.INSTANCE.isSharedNotesSyncSupported(BaseUtils.getContext())) {
            mCoeditListenerModel.setHasBadge(hasBadge);
        }
    }

    @JvmStatic
    public static final void setGcsHasDrawerBadge(boolean hasBadge) {
        if (NotesUtils.isMDEFeatureEnabled()) {
            AbstractC8014b.m7210l("setGcsHasDrawerBadge# hasBadge: ", TAG, hasBadge);
            mGcsDrawerBadgeListenerModel.setHasBadge(hasBadge);
        }
    }

    @JvmStatic
    public static final void setGcsHasMoreBadge(boolean hasBadge) {
        if (NotesUtils.isMDEFeatureEnabled()) {
            AbstractC8014b.m7210l("setGcsHasMoreBadge# hasBadge: ", TAG, hasBadge);
            SharedPreferencesCompat.INSTANCE.getInstance(GcsConstants.GCS_PREFS_NAME).putBoolean(GcsConstants.KEY_GCS_HAS_MORE_BADGE, hasBadge);
        }
    }

    @JvmStatic
    public static final void setSOMFolderHasNewBadge(boolean hasBadge, @Nullable String caller) {
        if (FeatureUtils.isSOMFeatureSupported()) {
            MainLogger.m7254d(TAG, "setSOMFolderHasNewBadge, caller: " + caller + ", hasBadge: " + hasBadge);
            mSOMListenerModel.setHasBadge(hasBadge);
        }
    }

    @JvmStatic
    public static final void unregisterCoeditBadgeChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener changeListener) {
        if (SettingsMenuUtils.INSTANCE.isSharedNotesSyncSupported(BaseUtils.getContext())) {
            mCoeditListenerModel.unregisterListener(changeListener);
        }
    }

    @JvmStatic
    public static final void unregisterGCSDrawerBadgeChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener changeListener) {
        if (NotesUtils.isMDEFeatureEnabled()) {
            mGcsDrawerBadgeListenerModel.unregisterListener(changeListener);
        }
    }

    @JvmStatic
    public static final void unregisterSOMBadgeChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener changeListener) {
        if (FeatureUtils.isSOMFeatureSupported()) {
            mSOMListenerModel.unregisterListener(changeListener);
        }
    }

    @JvmStatic
    public static final void unregisterSettingBadgeChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener changeListener) {
        mSettingListenerModel.unregisterListener(changeListener);
    }

    @JvmStatic
    public static final void updateCoeditUnReadCount() {
        if (SettingsMenuUtils.INSTANCE.isSharedNotesSyncSupported(BaseUtils.getContext())) {
            int unreadCoeditNoteCount = RepositoryManager.INSTANCE.getInstance().getSyncNoteDataRepository().getUnreadCoeditNoteCount();
            SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
            int i = companion.getInstance(GcsConstants.COEDIT_PREFS_NAME).getInt(GcsConstants.KEY_COEDIT_UNREAD_COUNT, 0);
            if (unreadCoeditNoteCount == 0) {
                setCoeditHasBadge(false);
            } else if (unreadCoeditNoteCount > i) {
                setCoeditHasBadge(true);
            }
            companion.getInstance(GcsConstants.COEDIT_PREFS_NAME).putInt(GcsConstants.KEY_COEDIT_UNREAD_COUNT, unreadCoeditNoteCount);
        }
    }

    @JvmStatic
    public static final void updateGcsUnReadCount() {
        if (NotesUtils.isMDEFeatureEnabled()) {
            int unreadMdeNoteCount = RepositoryManager.INSTANCE.getInstance().getSyncNoteDataRepository().getUnreadMdeNoteCount();
            SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
            int i = companion.getInstance(GcsConstants.GCS_PREFS_NAME).getInt(GcsConstants.KEY_GCS_UNREAD_COUNT, 0);
            if (unreadMdeNoteCount == 0) {
                setGcsHasDrawerBadge(false);
                setGcsHasMoreBadge(false);
            } else if (unreadMdeNoteCount > i) {
                setGcsHasDrawerBadge(true);
                setGcsHasMoreBadge(true);
            }
            companion.getInstance(GcsConstants.GCS_PREFS_NAME).putInt(GcsConstants.KEY_GCS_UNREAD_COUNT, unreadMdeNoteCount);
        }
    }

    @JvmStatic
    public static final void updateSOMRecognizedTimes(@NotNull Map<String, Long> recognizeModifiedTimes, boolean isSOMRecognizedCardCollapsed, @Nullable String caller) {
        Intrinsics.checkNotNullParameter(recognizeModifiedTimes, "recognizeModifiedTimes");
        if (FeatureUtils.isSOMFeatureSupported()) {
            if (isSOMRecognizedCardCollapsed) {
                Map<String, Long> lastSOMRecognizeModifiedTimes = INSTANCE.getLastSOMRecognizeModifiedTimes();
                for (Map.Entry<String, Long> entry : recognizeModifiedTimes.entrySet()) {
                    Long l = lastSOMRecognizeModifiedTimes.get(entry.getKey());
                    if (l == null || !Intrinsics.areEqual(l, recognizeModifiedTimes.get(entry.getKey()))) {
                        setSOMFolderHasNewBadge(true, "updateSOMRecognizedTimes, caller: " + caller);
                        break;
                    }
                }
            }
            SharedPreferencesCompat.INSTANCE.getInstance(FolderConstants.PREF_FOLDER_INFO).putString(FolderConstants.KEY_SOM_RECOGNIZE_MODIFIED_TIME, new Gson().toJson(recognizeModifiedTimes));
        }
    }
}
