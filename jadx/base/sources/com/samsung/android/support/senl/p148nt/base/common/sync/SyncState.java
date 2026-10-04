package com.samsung.android.support.senl.p148nt.base.common.sync;

import android.content.Context;
import android.content.SharedPreferences;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0019\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0007J\u0018\u0010\"\u001a\u00020#2\u0006\u0010 \u001a\u00020!2\u0006\u0010$\u001a\u00020\u0013H\u0007J\b\u0010%\u001a\u00020#H\u0007J\u0010\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020\u0013H\u0007J\u001a\u00105\u001a\u00020#2\b\u00106\u001a\u0004\u0018\u00010\u00052\u0006\u00107\u001a\u00020\u0011H\u0007J\u0012\u00108\u001a\u00020\u00112\b\u00106\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u00109\u001a\u00020#2\b\u00106\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010:\u001a\u00020#2\b\u00106\u001a\u0004\u0018\u00010\u00052\u0006\u00107\u001a\u00020\u0011H\u0007J\u0012\u0010;\u001a\u00020\u00112\b\u00106\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010<\u001a\u00020#2\b\u00106\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010=\u001a\u00020#H\u0007J\b\u0010>\u001a\u00020#H\u0007J\b\u0010?\u001a\u00020\u0013H\u0007J\u0010\u0010@\u001a\u00020#2\u0006\u0010?\u001a\u00020\u0013H\u0007J\b\u0010A\u001a\u00020#H\u0007J\b\u0010B\u001a\u00020\u0013H\u0007J\b\u0010C\u001a\u00020#H\u0007J\b\u0010D\u001a\u00020\u0013H\u0007J\b\u0010E\u001a\u00020#H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0012\u0010\u0015\"\u0004\b\u0016\u0010\u0017R&\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00138\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u001b\u0010\u0015R&\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00138\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0003\u001a\u0004\b\u001e\u0010\u0015R\u001a\u0010&\u001a\u00020\u00118FX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010\u0003\u001a\u0004\b(\u0010)R\u001a\u0010,\u001a\u00020-8FX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0003\u001a\u0004\b/\u00100R*\u00102\u001a\u00020\u00132\u0006\u00101\u001a\u00020\u00138F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b3\u0010\u0003\u001a\u0004\b2\u0010\u0015\"\u0004\b4\u0010\u0017¨\u0006F"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/SyncState;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "SYNC_PREFERENCE_SYNC_STATE_NAME", "SYNC_PREFERENCE_APP_UPDATE_NEEDED_KEY", "SYNC_PREFERENCE_APP_UPDATE_CHECK_PERIOD", "SYNC_PREFERENCE_APP_UPDATE_STORE_CONNECTED", "SYNC_PREFERENCE_CLEAR_INVALID_COEDIT_NOTES", "SYNC_PREFERENCE_EDP_MODE", "SYNC_PREFERENCE_HIGH_FORMAT_VER_TEST", "SYNC_PREFERENCE_CMS_TEST", "SYNC_CONTROL_SDOC_DONT_SYNC_NAME", "SYNC_CONTROL_SDOCX_DONT_SYNC_NAME", "UPDATE_CHECK_PERIOD_WEEK", "", "isWiFiNetworkFailed", "", "isWiFiNetworkFailed$annotations", "()Z", "setWiFiNetworkFailed", "(Z)V", "value", "edpUiTest1State", "getEdpUiTest1State$annotations", "getEdpUiTest1State", "edpUiTest2State", "getEdpUiTest2State$annotations", "getEdpUiTest2State", SyncState.SYNC_PREFERENCE_APP_UPDATE_NEEDED_KEY, "context", "Landroid/content/Context;", "setAppUpdateNeeded", "", "isNeeded", "setAppUpdateCheckPeriod", "appUpdateCheckPeriod", "getAppUpdateCheckPeriod$annotations", "getAppUpdateCheckPeriod", "()J", "setStoreConnected", "connected", "storeConnected", "", "getStoreConnected$annotations", "getStoreConnected", "()I", "enable", SyncState.SYNC_PREFERENCE_CLEAR_INVALID_COEDIT_NOTES, "isClearInvalidCoEditNotes$annotations", "setClearInvalidCoEditNotes", "addDontSyncOldNote", "docUuid", "serverTimestamp", "getDontSyncOldNote", "removeDontSyncOldNote", "addDontSyncNewNote", "getDontSyncNewNote", "removeDontSyncNewNote", "toggleEdpUiTest1State", "toggleEdpUiTest2State", SyncState.SYNC_PREFERENCE_EDP_MODE, "setEdpMode", "toggleEdpMode", SyncState.SYNC_PREFERENCE_HIGH_FORMAT_VER_TEST, "toggleHighFormatVerTest", SyncState.SYNC_PREFERENCE_CMS_TEST, "toggleCmsTest", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SyncState {

    @NotNull
    public static final SyncState INSTANCE = new SyncState();

    @NotNull
    private static final String SYNC_CONTROL_SDOCX_DONT_SYNC_NAME = "SyncControlSDocxDontSync";

    @NotNull
    private static final String SYNC_CONTROL_SDOC_DONT_SYNC_NAME = "SyncControlSDocDontSync";

    @NotNull
    private static final String SYNC_PREFERENCE_APP_UPDATE_CHECK_PERIOD = "isAppUpdateCheckPeriod";

    @NotNull
    private static final String SYNC_PREFERENCE_APP_UPDATE_NEEDED_KEY = "isAppUpdateNeeded";

    @NotNull
    private static final String SYNC_PREFERENCE_APP_UPDATE_STORE_CONNECTED = "isAppUpdateStoreConnected";

    @NotNull
    private static final String SYNC_PREFERENCE_CLEAR_INVALID_COEDIT_NOTES = "isClearInvalidCoEditNotes";

    @NotNull
    private static final String SYNC_PREFERENCE_CMS_TEST = "isCmsTest";

    @NotNull
    private static final String SYNC_PREFERENCE_EDP_MODE = "isEdpMode";

    @NotNull
    private static final String SYNC_PREFERENCE_HIGH_FORMAT_VER_TEST = "isHighFormatVerTest";

    @NotNull
    private static final String SYNC_PREFERENCE_SYNC_STATE_NAME = "syncState";

    @NotNull
    private static final String TAG = "SyncState";
    private static final long UPDATE_CHECK_PERIOD_WEEK = 604800000;
    private static boolean edpUiTest1State;
    private static boolean edpUiTest2State;
    private static boolean isWiFiNetworkFailed;

    private SyncState() {
    }

    @JvmStatic
    public static final void addDontSyncNewNote(@Nullable String docUuid, long serverTimestamp) {
        SharedPreferencesCompat.INSTANCE.getInstance(SYNC_CONTROL_SDOCX_DONT_SYNC_NAME).putLong(docUuid, serverTimestamp);
    }

    @JvmStatic
    public static final void addDontSyncOldNote(@Nullable String docUuid, long serverTimestamp) {
        SharedPreferencesCompat.INSTANCE.getInstance(SYNC_CONTROL_SDOC_DONT_SYNC_NAME).putLong(docUuid, serverTimestamp);
    }

    public static final long getAppUpdateCheckPeriod() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getLong(SYNC_PREFERENCE_APP_UPDATE_CHECK_PERIOD, 0L);
    }

    @JvmStatic
    public static /* synthetic */ void getAppUpdateCheckPeriod$annotations() {
    }

    @JvmStatic
    public static final long getDontSyncNewNote(@Nullable String docUuid) {
        return SharedPreferencesCompat.INSTANCE.getInstance(SYNC_CONTROL_SDOCX_DONT_SYNC_NAME).getLong(docUuid, 0L);
    }

    @JvmStatic
    public static final long getDontSyncOldNote(@Nullable String docUuid) {
        return SharedPreferencesCompat.INSTANCE.getInstance(SYNC_CONTROL_SDOC_DONT_SYNC_NAME).getLong(docUuid, 0L);
    }

    public static final boolean getEdpUiTest1State() {
        return edpUiTest1State;
    }

    @JvmStatic
    public static /* synthetic */ void getEdpUiTest1State$annotations() {
    }

    public static final boolean getEdpUiTest2State() {
        return edpUiTest2State;
    }

    @JvmStatic
    public static /* synthetic */ void getEdpUiTest2State$annotations() {
    }

    public static final int getStoreConnected() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getInt(SYNC_PREFERENCE_APP_UPDATE_STORE_CONNECTED, 0);
    }

    @JvmStatic
    public static /* synthetic */ void getStoreConnected$annotations() {
    }

    @JvmStatic
    public static final boolean isAppUpdateNeeded(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getSharedPreferences("syncState", 0).getBoolean(SYNC_PREFERENCE_APP_UPDATE_NEEDED_KEY, false);
    }

    public static final boolean isClearInvalidCoEditNotes() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SYNC_PREFERENCE_CLEAR_INVALID_COEDIT_NOTES, false);
    }

    @JvmStatic
    public static /* synthetic */ void isClearInvalidCoEditNotes$annotations() {
    }

    @JvmStatic
    public static final boolean isCmsTest() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SYNC_PREFERENCE_CMS_TEST, false);
    }

    @JvmStatic
    public static final boolean isEdpMode() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SYNC_PREFERENCE_EDP_MODE, false);
    }

    @JvmStatic
    public static final boolean isHighFormatVerTest() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SYNC_PREFERENCE_HIGH_FORMAT_VER_TEST, false);
    }

    public static final boolean isWiFiNetworkFailed() {
        return isWiFiNetworkFailed;
    }

    @JvmStatic
    public static /* synthetic */ void isWiFiNetworkFailed$annotations() {
    }

    @JvmStatic
    public static final void removeDontSyncNewNote(@Nullable String docUuid) {
        SharedPreferencesCompat.INSTANCE.getInstance(SYNC_CONTROL_SDOCX_DONT_SYNC_NAME).remove(docUuid);
    }

    @JvmStatic
    public static final void removeDontSyncOldNote(@Nullable String docUuid) {
        SharedPreferencesCompat.INSTANCE.getInstance(SYNC_CONTROL_SDOC_DONT_SYNC_NAME).remove(docUuid);
    }

    @JvmStatic
    public static final void setAppUpdateCheckPeriod() {
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putLong(SYNC_PREFERENCE_APP_UPDATE_CHECK_PERIOD, System.currentTimeMillis() + 604800000);
    }

    @JvmStatic
    public static final void setAppUpdateNeeded(@NotNull Context context, boolean isNeeded) {
        Intrinsics.checkNotNullParameter(context, "context");
        Debugger.INSTANCE.m8626f(TAG, "setAppUpdateNeeded() : isNeeded = " + isNeeded + ", callee: " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("syncState", 0).edit();
        editorEdit.putBoolean(SYNC_PREFERENCE_APP_UPDATE_NEEDED_KEY, isNeeded);
        editorEdit.apply();
    }

    public static final void setClearInvalidCoEditNotes(boolean z) {
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putBoolean(SYNC_PREFERENCE_CLEAR_INVALID_COEDIT_NOTES, z);
    }

    @JvmStatic
    public static final void setEdpMode(boolean isEdpMode) {
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putBoolean(SYNC_PREFERENCE_EDP_MODE, isEdpMode);
    }

    @JvmStatic
    public static final void setStoreConnected(boolean connected) {
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putInt(SYNC_PREFERENCE_APP_UPDATE_STORE_CONNECTED, connected ? 1 : 0);
    }

    public static final void setWiFiNetworkFailed(boolean z) {
        isWiFiNetworkFailed = z;
    }

    @JvmStatic
    public static final void toggleCmsTest() {
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putBoolean(SYNC_PREFERENCE_CMS_TEST, !isCmsTest());
    }

    @JvmStatic
    public static final void toggleEdpMode() {
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putBoolean(SYNC_PREFERENCE_EDP_MODE, !isEdpMode());
    }

    @JvmStatic
    public static final void toggleEdpUiTest1State() {
        edpUiTest1State = !edpUiTest1State;
    }

    @JvmStatic
    public static final void toggleEdpUiTest2State() {
        edpUiTest2State = !edpUiTest2State;
    }

    @JvmStatic
    public static final void toggleHighFormatVerTest() {
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putBoolean(SYNC_PREFERENCE_HIGH_FORMAT_VER_TEST, !isHighFormatVerTest());
    }
}
