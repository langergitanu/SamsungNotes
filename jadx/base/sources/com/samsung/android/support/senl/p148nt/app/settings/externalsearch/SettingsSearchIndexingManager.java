package com.samsung.android.support.senl.p148nt.app.settings.externalsearch;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.common.util.SpenUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.common.utils.SettingsMenuUtils;
import com.samsung.android.support.senl.p148nt.app.settings.externalsearch.SettingsSearchIndexingManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0007J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0007J\b\u0010\u0011\u001a\u00020\u000eH\u0007J\u0016\u0010\u0015\u001a\u00020\u000e2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0017J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/externalsearch/SettingsSearchIndexingManager;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "LAST_NON_INDEXABLE_KEYS", "mMutex", "mSPenSettingStateChangeListener", "", "Lcom/samsung/android/support/senl/nt/app/settings/externalsearch/SettingsSearchIndexingManager$SPenSettingStateChangeListener;", "mSPenSettingContentObserver", "Landroid/database/ContentObserver;", "registerSPenSettingStateChangeListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "unregisterSPenSettingStateChangeListener", "requestIndexing", "isIndexingRequired", "", "()Z", "saveLastNonIndexableKeys", "nonIndexableKeys", "", "isNonIndexableKey", "key", "SPenSettingStateChangeListener", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsSearchIndexingManager {

    @NotNull
    private static final String LAST_NON_INDEXABLE_KEYS = "key_last_non_indexable_keys";

    @NotNull
    private static final String TAG = "SettingsSearchIndexingManager";

    @Nullable
    private static ContentObserver mSPenSettingContentObserver;

    @Nullable
    private static Set<SPenSettingStateChangeListener> mSPenSettingStateChangeListener;

    @NotNull
    public static final SettingsSearchIndexingManager INSTANCE = new SettingsSearchIndexingManager();

    @NotNull
    private static final Object mMutex = new Object();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/externalsearch/SettingsSearchIndexingManager$SPenSettingStateChangeListener;", "", "onChanged", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface SPenSettingStateChangeListener {
        void onChanged();
    }

    private SettingsSearchIndexingManager() {
    }

    private final boolean isIndexingRequired() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (!SettingsMenuUtils.isScreenOffMemoStyleSupported(applicationContext)) {
            Intrinsics.checkNotNull(applicationContext);
            if (!SettingsMenuUtils.isConvertYourNoteVisible(applicationContext)) {
                return false;
            }
        }
        boolean zIsScreenOffMemoStyleVisible = SettingsMenuUtils.isScreenOffMemoStyleVisible();
        SettingsSearchIndexingManager settingsSearchIndexingManager = INSTANCE;
        boolean zIsNonIndexableKey = settingsSearchIndexingManager.isNonIndexableKey(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE);
        Intrinsics.checkNotNull(applicationContext);
        boolean zIsConvertYourNoteVisible = SettingsMenuUtils.isConvertYourNoteVisible(applicationContext);
        boolean zIsNonIndexableKey2 = settingsSearchIndexingManager.isNonIndexableKey(SettingsConstants.SETTINGS_CONVERT_YOUR_NOTES);
        StringBuilder sbM2230u = AbstractC2821a.m2230u("isIndexingRequired, isScreenOffMemoStyleVisible: ", ", isScreenOffMemoStyleNonIndexable: ", ", isConvertYourNoteVisible: ", zIsScreenOffMemoStyleVisible, zIsNonIndexableKey);
        sbM2230u.append(zIsConvertYourNoteVisible);
        sbM2230u.append(", isConvertYourNoteNonIndexable: ");
        sbM2230u.append(zIsNonIndexableKey2);
        MainLogger.m7254d(TAG, sbM2230u.toString());
        return zIsScreenOffMemoStyleVisible == zIsNonIndexableKey || zIsConvertYourNoteVisible == zIsNonIndexableKey2;
    }

    private final boolean isNonIndexableKey(String key) {
        Set<String> stringSet = SharedPreferencesCompat.INSTANCE.getInstance("Settings").getStringSet(LAST_NON_INDEXABLE_KEYS, new HashSet());
        if (stringSet == null) {
            return false;
        }
        if (stringSet.isEmpty()) {
            return true;
        }
        return stringSet.contains(key);
    }

    @JvmStatic
    public static final void registerSPenSettingStateChangeListener(@Nullable SPenSettingStateChangeListener listener) {
        ContentResolver contentResolver;
        ContentResolver contentResolver2;
        if (listener == null || !SettingsMenuUtils.isScreenOffMemoStyleSupported(BaseUtils.getApplicationContext())) {
            return;
        }
        synchronized (mMutex) {
            try {
                if (mSPenSettingStateChangeListener == null) {
                    mSPenSettingStateChangeListener = new HashSet();
                }
                Set<SPenSettingStateChangeListener> set = mSPenSettingStateChangeListener;
                if (set != null) {
                    set.add(listener);
                }
                if (mSPenSettingContentObserver == null) {
                    if (Looper.myLooper() == null) {
                        Looper.prepare();
                    }
                    final Handler handler = new Handler();
                    mSPenSettingContentObserver = new ContentObserver(handler) { // from class: com.samsung.android.support.senl.nt.app.settings.externalsearch.SettingsSearchIndexingManager$registerSPenSettingStateChangeListener$1$1
                        @Override // android.database.ContentObserver
                        public void onChange(boolean selfChange, Uri uri) {
                            if (uri == null) {
                                return;
                            }
                            if (Intrinsics.areEqual(Settings.System.getUriFor(SpenUtils.SETTINGS_SPEN_ACTIVATED).toString(), uri.toString()) || Intrinsics.areEqual(Settings.System.getUriFor("pen_usage_detected").toString(), uri.toString())) {
                                MainLogger.m7254d("SettingsSearchIndexingManager", "onChanged, " + SettingsMenuUtils.isScreenOffMemoStyleVisible() + SQLKeyword.COMMA + MainLogger.getEncode(uri.toString()));
                                synchronized (SettingsSearchIndexingManager.mMutex) {
                                    try {
                                        Set set2 = SettingsSearchIndexingManager.mSPenSettingStateChangeListener;
                                        if (set2 != null) {
                                            Iterator it = set2.iterator();
                                            while (it.hasNext()) {
                                                ((SettingsSearchIndexingManager.SPenSettingStateChangeListener) it.next()).onChanged();
                                            }
                                            Unit unit = Unit.INSTANCE;
                                        }
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            }
                        }
                    };
                }
                ContentObserver contentObserver = mSPenSettingContentObserver;
                if (contentObserver != null) {
                    Context applicationContext = BaseUtils.getApplicationContext();
                    if (applicationContext != null && (contentResolver2 = applicationContext.getContentResolver()) != null) {
                        contentResolver2.registerContentObserver(Settings.System.getUriFor(SpenUtils.SETTINGS_SPEN_ACTIVATED), false, contentObserver);
                    }
                    Context applicationContext2 = BaseUtils.getApplicationContext();
                    if (applicationContext2 != null && (contentResolver = applicationContext2.getContentResolver()) != null) {
                        contentResolver.registerContentObserver(Settings.System.getUriFor("pen_usage_detected"), false, contentObserver);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmStatic
    public static final void requestIndexing() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            MainLogger.m7255e(TAG, "requestIndexing, ignore, context is null");
            return;
        }
        if (!INSTANCE.isIndexingRequired()) {
            MainLogger.m7259w(TAG, "requestIndexing, ignore, indexing is not required");
            return;
        }
        MainLogger.m7254d(TAG, "requestIndexing,");
        try {
            Uri uri = Uri.parse("content://com.samsung.android.settings.intelligence.search.provider.SettingSearchProvider");
            Bundle bundle = new Bundle();
            bundle.putString("indexingType", "nonIndexableKeys");
            bundle.putString("authority", "com.samsung.android.app.notes.SettingsSearchProvider");
            applicationContext.getContentResolver().call(uri, "requestIndexing", (String) null, bundle);
        } catch (SQLiteException e) {
            AbstractC6670b.m4738C("requestIndexing, Exception: ", e.getMessage(), TAG);
        } catch (IllegalArgumentException e2) {
            AbstractC6670b.m4738C("requestIndexing, Exception: ", e2.getMessage(), TAG);
        } catch (SecurityException e3) {
            AbstractC6670b.m4738C("requestIndexing, Exception: ", e3.getMessage(), TAG);
        }
    }

    @JvmStatic
    public static final void unregisterSPenSettingStateChangeListener(@Nullable SPenSettingStateChangeListener listener) {
        Context applicationContext;
        ContentResolver contentResolver;
        if (listener == null || !SettingsMenuUtils.isScreenOffMemoStyleSupported(BaseUtils.getApplicationContext())) {
            return;
        }
        synchronized (mMutex) {
            try {
                Set<SPenSettingStateChangeListener> set = mSPenSettingStateChangeListener;
                if (set == null) {
                    return;
                }
                Intrinsics.checkNotNull(set);
                set.remove(listener);
                Set<SPenSettingStateChangeListener> set2 = mSPenSettingStateChangeListener;
                Intrinsics.checkNotNull(set2);
                if (set2.isEmpty()) {
                    ContentObserver contentObserver = mSPenSettingContentObserver;
                    if (contentObserver != null && (applicationContext = BaseUtils.getApplicationContext()) != null && (contentResolver = applicationContext.getContentResolver()) != null) {
                        contentResolver.unregisterContentObserver(contentObserver);
                    }
                    mSPenSettingContentObserver = null;
                    mSPenSettingStateChangeListener = null;
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void saveLastNonIndexableKeys(@Nullable Set<String> nonIndexableKeys) {
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putStringSet(LAST_NON_INDEXABLE_KEYS, nonIndexableKeys);
    }
}
