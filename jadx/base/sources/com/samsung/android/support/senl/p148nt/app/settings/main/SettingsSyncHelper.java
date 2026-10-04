package com.samsung.android.support.senl.p148nt.app.settings.main;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.glance.AbstractC2821a;
import androidx.preference.DropDownPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.preference.SeslSwitchPreferenceScreen;
import androidx.preference.SwitchPreferenceCompat;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.microsoft.graph.AbstractC6784f;
import com.samsung.android.app.notes.sync.synchronization.controllers.C6896g;
import com.samsung.android.sdk.scs.p142ai.language.C7737b;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.account.AccountHelper;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.dialog.SettingsConfirmDialogFragment;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsSwitchPreferenceScreen;
import com.samsung.android.support.senl.p148nt.app.settings.common.dialog.AllowAppPermissionDialogFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.handler.SettingsGlobalSyncStatusHandler;
import com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper;
import com.samsung.android.support.senl.p148nt.app.settings.common.listener.SyncStateListener;
import com.samsung.android.support.senl.p148nt.app.settings.common.utils.SettingsMenuUtils;
import com.samsung.android.support.senl.p148nt.app.settings.external.SCloudSetting;
import com.samsung.android.support.senl.p148nt.app.settings.microsoft.SettingsMicrosoft;
import com.samsung.android.support.senl.p148nt.app.settings.microsoft.SettingsMicrosoftLoginActivity;
import com.samsung.android.support.senl.p148nt.app.updater.UpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.NotificationUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p010C.C0042g;
import p042J1.C0145c;
import p044K.C0158a;
import p207n1.C13540g;
import p207n1.C13541h;
import p211o0.C13567a;
import p244u1.C14477a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\u0018\u0000 t2\u00020\u0001:\u0001tB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\u001e\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\b\u0010 \u001a\u00020\u0013H\u0016J\b\u0010!\u001a\u00020\u0013H\u0016J\b\u0010\"\u001a\u00020\u0013H\u0002J\b\u0010#\u001a\u00020\u0013H\u0016J\b\u0010$\u001a\u00020\u0013H\u0016J\u001a\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010*\u001a\u00020\u00072\u0006\u0010&\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010)H\u0002J\b\u0010-\u001a\u00020\u0013H\u0002J\b\u0010.\u001a\u00020\u0007H\u0002J\u0018\u0010/\u001a\u00020\u00132\u0006\u0010&\u001a\u0002002\u0006\u00101\u001a\u00020\u000fH\u0002J\u0010\u00102\u001a\u00020\u00132\u0006\u0010&\u001a\u000200H\u0002J\u0010\u00103\u001a\u00020\u00132\u0006\u0010&\u001a\u000200H\u0002J\u0010\u00104\u001a\u00020\u00132\u0006\u0010&\u001a\u000200H\u0002J\u0010\u00105\u001a\u00020\u00132\u0006\u0010&\u001a\u000200H\u0002J\u0010\u00106\u001a\u00020\u00132\u0006\u0010&\u001a\u000200H\u0002J\u0010\u00107\u001a\u00020\u00132\u0006\u0010&\u001a\u000200H\u0002J\u0010\u00108\u001a\u00020\u00132\u0006\u0010&\u001a\u000200H\u0003J\u0010\u00109\u001a\u00020\u00132\u0006\u0010&\u001a\u000200H\u0002J\u0010\u0010:\u001a\u00020\u00132\u0006\u0010&\u001a\u000200H\u0002J\u0010\u0010;\u001a\u00020\u00132\u0006\u0010&\u001a\u000200H\u0002J\u0010\u0010<\u001a\u00020\u00132\u0006\u0010&\u001a\u000200H\u0002J\b\u0010A\u001a\u00020\u0013H\u0002J\b\u0010B\u001a\u00020\u0013H\u0002J\b\u0010C\u001a\u00020\u0013H\u0002J\b\u0010D\u001a\u00020\u0013H\u0002J\b\u0010E\u001a\u00020\u0013H\u0002J\b\u0010F\u001a\u00020\u0013H\u0002J\u0018\u0010L\u001a\u00020\u00072\u0006\u0010&\u001a\u00020M2\u0006\u0010,\u001a\u00020)H\u0002J\u001c\u0010N\u001a\u00020\u00132\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010Q\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010R\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010W\u001a\u00020\u00132\u0006\u0010X\u001a\u00020\u000fH\u0002J)\u0010Y\u001a\u00020\u00132\u0006\u0010X\u001a\u00020\u000f2\u0012\u0010Z\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190>\"\u00020\u0019H\u0002¢\u0006\u0002\u0010[J\u0012\u0010\\\u001a\u00020\u00132\b\b\u0002\u0010]\u001a\u00020\u0007H\u0002J\u000e\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u0019J\b\u0010`\u001a\u00020\u0013H\u0002J\u0010\u0010b\u001a\u00020\u00132\u0006\u0010c\u001a\u00020\u0007H\u0002J\b\u0010d\u001a\u00020\u0013H\u0002J\b\u0010f\u001a\u00020\u0013H\u0002J\"\u0010g\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u000f2\u0006\u0010h\u001a\u00020\u000f2\b\u0010i\u001a\u0004\u0018\u00010jH\u0016J+\u0010k\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u000f2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00190>2\u0006\u0010l\u001a\u00020mH\u0016¢\u0006\u0002\u0010nJ\u0006\u0010o\u001a\u00020\u0013J\b\u0010p\u001a\u00020\u0013H\u0002R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\t\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\bR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00190>8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u000e\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0014\u0010U\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bV\u0010TR\u000e\u0010a\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010q\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\br\u0010s¨\u0006u"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/main/SettingsSyncHelper;", "Lcom/samsung/android/support/senl/nt/app/settings/common/helper/AbsSettingsHelper;", "fragment", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;)V", "isMsSignOutRequested", "", "()Z", "isMicrosoftSyncStartRequestedByExternalAction", "mSettingsMicrosoft", "Lcom/samsung/android/support/senl/nt/app/settings/microsoft/SettingsMicrosoft;", "mGlobalSyncStatusHandler", "Lcom/samsung/android/support/senl/nt/app/settings/common/handler/SettingsGlobalSyncStatusHandler;", "mSCloudSyncState", "", "mSyncEnableModeListener", "Lcom/samsung/android/support/senl/nt/app/settings/common/listener/SyncStateListener;", "initialize", "", "initializeGlobalSyncStatusHandler", "releaseGlobalSyncStatusHandler", "updateMicrosoftSyncSummary", "isMsAccountSignIn", "microsoftAccount", "", "initSamsungCloudSync", "initMicrosoftSync", "initSharedNotesSync", "onCreate", "onStart", "bindSyncService", "onResume", "onStop", "unBindSyncService", "release", "updatePreference", "onPreferenceChange", "preference", "Landroidx/preference/Preference;", "newValue", "", "handleSwitchPreferenceChange", "Landroidx/preference/SwitchPreferenceCompat;", "o", "updateSCloudSyncSummary", "isFeedEnable", "changeSCloudSyncSummary", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsSwitchPreferenceScreen;", "sCloudSyncState", "initializeSCloudSyncSummary", "changeSCloudSyncSummaryToRequestDownloadSCloud", "changeSCloudSyncSummaryToNotLogin", "changeSCloudSyncSummaryToFailedConsentToUseNetwork", "changeSCloudSyncSummaryToNoPersonalInfo", "changeSCloudSyncSummaryToNoPrivacyNotice", "changeSCloudSyncSummaryToNoPermission", "changeSCloudSyncSummaryToAutoSyncEnabled", "changeSCloudSyncSummaryToDigitalLegacyMode", "changeSCloudSyncSummaryToAutoSyncDisabled", "changeSCloudSyncSummaryToEDPNotice", "requiredPermissionsForSync", "", "getRequiredPermissionsForSync", "()[Ljava/lang/String;", "updateSCloudSyncVisibility", "updateMicrosoftSyncVisibility", "updateCoeditNotesSyncType", "showTurnOffSCloudSyncWithTurnOffMSSyncDialog", "showTurnOnWiFiSyncOnlyConfirmDialog", "showTurnOnSCloudSyncWithTurnOnMSSyncDialog", "mMsSyncTurnOnConfirmDialogFragmentListener", "Lcom/samsung/android/support/senl/nt/app/common/dialog/SettingsConfirmDialogFragment$DialogListener;", "mTurnOffSCloudSyncConfirmDialogFragmentListener", "mTurnOnWiFiSyncOnlyConfirmDialogFragmentListener", "Lcom/samsung/android/support/senl/nt/app/common/dialog/SettingsConfirmDialogFragment$WifiSyncOnlyDialogListener;", "handleDropDownPreferenceChange", "Landroidx/preference/DropDownPreference;", "onSharedPreferenceChanged", "sharedPreferences", "Landroid/content/SharedPreferences;", "key", "onPreferenceClick", "getSCloudSyncState", "()I", "sCloudSupportState", "getSCloudSupportState", "loginSamsungAccountByFragment", "requestCode", "requestPermissions", "permissions", "(I[Ljava/lang/String;)V", "startMicrosoftSyncSettingsActivity", "insertSALogging", "compareIntentAction", "actionConstant", "showTurnOnSCloudSyncAndLoginMSDialog", "mMsLoginConfirmDialogFragmentListener", "setEnableSamsungAccountSync", "isEnabled", "showSignInAndTurnOnSCloudSyncDialog", "mSignInAndTurnOnSyncConfirmDialogFragmentListener", "onSCloudSettingSelected", "handleActivityResults", "resultCode", "data", "Landroid/content/Intent;", "handleRequestPermissionsResult", "grantResults", "", "(I[Ljava/lang/String;[I)Z", "checkedNotificationPermissions", "updateCategoryVisibility", "tag", "getTag", "()Ljava/lang/String;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSettingsSyncHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsSyncHelper.kt\ncom/samsung/android/support/senl/nt/app/settings/main/SettingsSyncHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,1232:1\n1#2:1233\n37#3:1234\n36#3,3:1235\n*S KotlinDebug\n*F\n+ 1 SettingsSyncHelper.kt\ncom/samsung/android/support/senl/nt/app/settings/main/SettingsSyncHelper\n*L\n684#1:1234\n684#1:1235,3\n*E\n"})
public final class SettingsSyncHelper extends AbsSettingsHelper {
    private static final int REQUEST_LOGIN_MS_ACCOUNT = 1;
    private static final int REQUEST_SYNC_ACCESS_TOKEN = 103;

    @NotNull
    private static final String TAG = "SettingsSyncHelper";

    @Nullable
    private SettingsGlobalSyncStatusHandler mGlobalSyncStatusHandler;

    @NotNull
    private final SettingsConfirmDialogFragment.DialogListener mMsLoginConfirmDialogFragmentListener;

    @NotNull
    private final SettingsConfirmDialogFragment.DialogListener mMsSyncTurnOnConfirmDialogFragmentListener;
    private int mSCloudSyncState;

    @Nullable
    private SettingsMicrosoft mSettingsMicrosoft;

    @NotNull
    private final SettingsConfirmDialogFragment.DialogListener mSignInAndTurnOnSyncConfirmDialogFragmentListener;

    @Nullable
    private SyncStateListener mSyncEnableModeListener;

    @NotNull
    private final SettingsConfirmDialogFragment.DialogListener mTurnOffSCloudSyncConfirmDialogFragmentListener;

    @NotNull
    private final SettingsConfirmDialogFragment.WifiSyncOnlyDialogListener mTurnOnWiFiSyncOnlyConfirmDialogFragmentListener;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.main.SettingsSyncHelper$updateSCloudSyncSummary$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.settings.main.SettingsSyncHelper$updateSCloudSyncSummary$1", m14021f = "SettingsSyncHelper.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C88271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SettingsSwitchPreferenceScreen $preference;
        int label;

        /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.main.SettingsSyncHelper$updateSCloudSyncSummary$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.settings.main.SettingsSyncHelper$updateSCloudSyncSummary$1$1", m14021f = "SettingsSyncHelper.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SettingsSyncHelper this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SettingsSyncHelper settingsSyncHelper, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = settingsSyncHelper;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                SettingsSyncHelper.updateMicrosoftSyncSummary$default(this.this$0, false, null, 3, null);
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.main.SettingsSyncHelper$updateSCloudSyncSummary$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.settings.main.SettingsSyncHelper$updateSCloudSyncSummary$1$2", m14021f = "SettingsSyncHelper.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ SettingsSwitchPreferenceScreen $preference;
            int label;
            final /* synthetic */ SettingsSyncHelper this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(SettingsSyncHelper settingsSyncHelper, SettingsSwitchPreferenceScreen settingsSwitchPreferenceScreen, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = settingsSyncHelper;
                this.$preference = settingsSwitchPreferenceScreen;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$preference, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                SettingsSyncHelper settingsSyncHelper = this.this$0;
                settingsSyncHelper.changeSCloudSyncSummary(this.$preference, settingsSyncHelper.mSCloudSyncState);
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88271(SettingsSwitchPreferenceScreen settingsSwitchPreferenceScreen, Continuation<? super C88271> continuation) {
            super(2, continuation);
            this.$preference = settingsSwitchPreferenceScreen;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SettingsSyncHelper.this.new C88271(this.$preference, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            MainLogger.m7258i(SettingsSyncHelper.TAG, "updateSCloudSyncSummary# getSCloudSyncState, start");
            int sCloudSyncState = SettingsSyncHelper.this.getSCloudSyncState();
            MainLogger.m7258i(SettingsSyncHelper.TAG, "updateSCloudSyncSummary# getSCloudSyncState, end, sCloudSyncState: " + sCloudSyncState);
            if (C0158a.m407a().m416i()) {
                AbstractC6784f.f4180a.m4949m(SettingsSyncHelper.this.isFeedEnable());
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(SettingsSyncHelper.this, null), 3, null);
            }
            if (sCloudSyncState == SettingsSyncHelper.this.mSCloudSyncState) {
                return Unit.INSTANCE;
            }
            SettingsSyncHelper.this.mSCloudSyncState = sCloudSyncState;
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass2(SettingsSyncHelper.this, this.$preference, null), 3, null);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C88271) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsSyncHelper(@NotNull SettingsBaseFragment fragment) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.mMsSyncTurnOnConfirmDialogFragmentListener = new SettingsConfirmDialogFragment.DialogListener() { // from class: com.samsung.android.support.senl.nt.app.settings.main.SettingsSyncHelper$mMsSyncTurnOnConfirmDialogFragmentListener$1
            @Override // com.samsung.android.support.senl.nt.app.common.dialog.SettingsConfirmDialogFragment.DialogListener
            public void onCancel() {
                AbstractC6784f.f4180a.m4949m(false);
                SettingsSyncHelper.updateMicrosoftSyncSummary$default(this.this$0, false, null, 3, null);
            }

            @Override // com.samsung.android.support.senl.nt.app.common.dialog.SettingsConfirmDialogFragment.DialogListener
            public void onConfirm() {
                this.this$0.setEnableSamsungAccountSync(true);
                AbstractC6784f.f4180a.m4949m(true);
                SettingsSyncHelper.updateMicrosoftSyncSummary$default(this.this$0, false, null, 3, null);
            }
        };
        this.mTurnOffSCloudSyncConfirmDialogFragmentListener = new SettingsConfirmDialogFragment.DialogListener() { // from class: com.samsung.android.support.senl.nt.app.settings.main.SettingsSyncHelper$mTurnOffSCloudSyncConfirmDialogFragmentListener$1
            @Override // com.samsung.android.support.senl.nt.app.common.dialog.SettingsConfirmDialogFragment.DialogListener
            public void onCancel() {
                this.this$0.setEnableSamsungAccountSync(true);
            }

            @Override // com.samsung.android.support.senl.nt.app.common.dialog.SettingsConfirmDialogFragment.DialogListener
            public void onConfirm() {
                AbstractC6784f.f4180a.m4949m(false);
                SettingsSyncHelper.updateMicrosoftSyncSummary$default(this.this$0, false, null, 3, null);
                this.this$0.setEnableSamsungAccountSync(false);
            }
        };
        this.mTurnOnWiFiSyncOnlyConfirmDialogFragmentListener = new C8822xaa7b352c(fragment, this);
        this.mMsLoginConfirmDialogFragmentListener = new SettingsConfirmDialogFragment.DialogListener() { // from class: com.samsung.android.support.senl.nt.app.settings.main.SettingsSyncHelper$mMsLoginConfirmDialogFragmentListener$1
            @Override // com.samsung.android.support.senl.nt.app.common.dialog.SettingsConfirmDialogFragment.DialogListener
            public void onCancel() {
            }

            @Override // com.samsung.android.support.senl.nt.app.common.dialog.SettingsConfirmDialogFragment.DialogListener
            public void onConfirm() {
                this.this$0.setEnableSamsungAccountSync(true);
                SettingsSyncHelper.startMicrosoftSyncSettingsActivity$default(this.this$0, false, 1, null);
            }
        };
        this.mSignInAndTurnOnSyncConfirmDialogFragmentListener = new SettingsConfirmDialogFragment.DialogListener() { // from class: com.samsung.android.support.senl.nt.app.settings.main.SettingsSyncHelper$mSignInAndTurnOnSyncConfirmDialogFragmentListener$1
            @Override // com.samsung.android.support.senl.nt.app.common.dialog.SettingsConfirmDialogFragment.DialogListener
            public void onCancel() {
            }

            @Override // com.samsung.android.support.senl.nt.app.common.dialog.SettingsConfirmDialogFragment.DialogListener
            public void onConfirm() {
                this.this$0.loginSamsungAccountByFragment(10);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bindSyncService() {
        C14477a.m15065b().m15068a(this.mSyncEnableModeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeSCloudSyncSummary(SettingsSwitchPreferenceScreen preference, int sCloudSyncState) {
        if (getFragment().isDetached()) {
            MainLogger.m7255e(TAG, "updateSCloudSyncSummary, fragment is detached, sCloudSyncState: " + sCloudSyncState);
        }
        switch (sCloudSyncState) {
            case 0:
                initializeSCloudSyncSummary(preference);
                break;
            case 1:
            case 2:
            case 3:
                MainLogger.m7259w(TAG, "updateSCloudSyncSummary, unused sCloudSyncState: " + sCloudSyncState);
                break;
            case 4:
                changeSCloudSyncSummaryToFailedConsentToUseNetwork(preference);
                break;
            case 5:
                changeSCloudSyncSummaryToNoPersonalInfo(preference);
                break;
            case 6:
                changeSCloudSyncSummaryToNoPrivacyNotice(preference);
                break;
            case 7:
                changeSCloudSyncSummaryToRequestDownloadSCloud(preference);
                break;
            case 8:
                changeSCloudSyncSummaryToNotLogin(preference);
                break;
            case 9:
                changeSCloudSyncSummaryToNoPermission(preference);
                break;
            case 10:
                changeSCloudSyncSummaryToAutoSyncEnabled(preference);
                break;
            case 11:
                changeSCloudSyncSummaryToAutoSyncDisabled(preference);
                break;
            case 12:
                changeSCloudSyncSummaryToEDPNotice(preference);
                break;
            case 13:
                changeSCloudSyncSummaryToDigitalLegacyMode(preference);
                break;
            default:
                MainLogger.m7255e(TAG, "updateSCloudSyncSummary, unexpected sCloudSyncState: " + sCloudSyncState);
                break;
        }
    }

    private final void changeSCloudSyncSummaryToAutoSyncDisabled(SettingsSwitchPreferenceScreen preference) {
        MainLogger.m7258i(TAG, "changeSCloudSyncSummaryToAutoSyncDisabled# ");
        preference.setWidgetState(0);
        preference.setSummary(C8003R.string.settings_sync_accounts_summary_auto_sync_disabled);
    }

    private final void changeSCloudSyncSummaryToAutoSyncEnabled(SettingsSwitchPreferenceScreen preference) {
        MainLogger.m7258i(TAG, "changeSCloudSyncSummaryToAutoSyncEnabled# ");
        Context context = getFragment().getContext();
        if (context == null) {
            return;
        }
        preference.setWidgetState(2);
        preference.setChecked(C0158a.m407a().m417k());
        if (preference.isChecked()) {
            String str = ((C13540g) C13541h.m14287e().f9588a).f9582d;
            preference.setSummary(str + "\n" + context.getString(C0145c.m299G(context) ? C8003R.string.settings_wifi_sync_only : C8003R.string.settings_both_wifi_and_mobile));
        }
    }

    private final void changeSCloudSyncSummaryToDigitalLegacyMode(SettingsSwitchPreferenceScreen preference) {
        MainLogger.m7258i(TAG, "changeSCloudSyncSummaryToDigitalLegacyMode# ");
        preference.setWidgetState(0);
        preference.setSummary(C8003R.string.settings_sync_accounts_summary_digital_legacy);
        preference.setEnabled(false);
    }

    private final void changeSCloudSyncSummaryToEDPNotice(SettingsSwitchPreferenceScreen preference) {
        MainLogger.m7258i(TAG, "changeSCloudSyncSummaryToEDPNotice# ");
        preference.setWidgetState(0);
        if (DeviceUtils.isTabletModel()) {
            preference.setSummary(C8003R.string.settings_sync_accounts_summary_tablet_edp_notice);
        } else {
            preference.setSummary(C8003R.string.settings_sync_accounts_summary_phone_edp_notice);
        }
    }

    private final void changeSCloudSyncSummaryToFailedConsentToUseNetwork(SettingsSwitchPreferenceScreen preference) {
        MainLogger.m7258i(TAG, "changeSCloudSyncSummaryToFailedConsentToUseNetwork# ");
        preference.setWidgetState(0);
        preference.setSummary(C8003R.string.settings_sync_accounts_summary_failed_consent_to_use_network);
    }

    @SuppressLint({"StringFormatInvalid"})
    private final void changeSCloudSyncSummaryToNoPermission(SettingsSwitchPreferenceScreen preference) {
        Context context = getFragment().getContext();
        if (context == null) {
            MainLogger.m7258i(TAG, "changeSCloudSyncSummaryToNoPermission# ignore, context is null");
            return;
        }
        String[] requiredPermissionsForSync = getRequiredPermissionsForSync();
        String string = Arrays.toString(requiredPermissionsForSync);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        MainLogger.m7258i(TAG, "changeSCloudSyncSummaryToNoPermission#  + " + string);
        if (requiredPermissionsForSync.length == 0) {
            return;
        }
        String string2 = requiredPermissionsForSync.length == 1 ? context.getString(C8003R.string.settings_sync_accounts_summary_no_permission, requiredPermissionsForSync[0]) : context.getString(C8003R.string.settings_sync_accounts_summary_no_permissions, CharUtils.arrayJoin(getFragment().getString(C8003R.string.string_comma), requiredPermissionsForSync));
        Intrinsics.checkNotNull(string2);
        preference.setWidgetState(0);
        preference.setSummary(string2);
    }

    private final void changeSCloudSyncSummaryToNoPersonalInfo(SettingsSwitchPreferenceScreen preference) {
        MainLogger.m7258i(TAG, "changeSCloudSyncSummaryToNoPersonalInfo# ");
        preference.setWidgetState(0);
        preference.setSummary(C8003R.string.settings_sync_accounts_summary_no_personal_info);
    }

    private final void changeSCloudSyncSummaryToNoPrivacyNotice(SettingsSwitchPreferenceScreen preference) {
        MainLogger.m7258i(TAG, "changeSCloudSyncSummaryToNoPrivacyNotice# ");
        preference.setWidgetState(0);
        preference.setSummary(C8003R.string.settings_sync_accounts_summary_no_privacy_notice);
    }

    private final void changeSCloudSyncSummaryToNotLogin(SettingsSwitchPreferenceScreen preference) {
        MainLogger.m7258i(TAG, "changeSCloudSyncSummaryToNotLogin# ");
        preference.setWidgetState(0);
        preference.setSummary(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.settings_sync_accounts_summary_jp : C8003R.string.settings_sync_accounts_summary);
    }

    private final void changeSCloudSyncSummaryToRequestDownloadSCloud(SettingsSwitchPreferenceScreen preference) {
        preference.setWidgetState(0);
        preference.setSummary(getFragment().getString(C8003R.string.settings_sync_accounts_summary_no_scloud_package, getFragment().getString(C8003R.string.settings_samsung_cloud)));
    }

    private final String[] getRequiredPermissionsForSync() {
        String[] strArr = {"android.permission.GET_ACCOUNTS", "android.permission.READ_PHONE_STATE"};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 2; i++) {
            String str = strArr[i];
            if (!PermissionHelper.isPermissionGrantedWithoutNotice(getFragment().getActivity(), str)) {
                arrayList.add(String.valueOf(PermissionCompat.getPermissionGroupName(getFragment().getContext(), str)));
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    private final int getSCloudSupportState() {
        Context context = getFragment().getContext();
        if (context == null) {
            return 0;
        }
        Ref.IntRef intRef = new Ref.IntRef();
        try {
        } catch (InterruptedException e) {
            AbstractC6670b.m4738C("getSCloudSupportState, InterruptedException: ", e.getMessage(), TAG);
        } catch (ExecutionException e2) {
            AbstractC6670b.m4738C("getSCloudSupportState, ExecutionException: ", e2.getMessage(), TAG);
        } catch (TimeoutException e3) {
            AbstractC6670b.m4738C("getSCloudSupportState, TimeoutException: ", e3.getMessage(), TAG);
        }
        return intRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getSCloudSyncState() {
        Context context = getFragment().getContext();
        if (context == null) {
            return 0;
        }
        return SCloudSetting.INSTANCE.getSCloudSyncState(context.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleActivityResults$lambda$12(SettingsSyncHelper settingsSyncHelper) {
        if (settingsSyncHelper.isMicrosoftSyncStartRequestedByExternalAction()) {
            startMicrosoftSyncSettingsActivity$default(settingsSyncHelper, false, 1, null);
        }
    }

    private final boolean handleDropDownPreferenceChange(DropDownPreference preference, Object o) {
        if (!(o instanceof String)) {
            return false;
        }
        if (Intrinsics.areEqual(preference.getValue(), o)) {
            return true;
        }
        String value = preference.getValue();
        MainLogger.m7258i(TAG, "onPreferenceChange# key : " + value + ", state : " + o);
        if (Intrinsics.areEqual(SettingsConstants.SETTINGS_COEDIT_NOTES_SYNC_TYPE, value)) {
            C0145c.m305M(getFragment().getContext(), (String) o);
        } else {
            AbstractC8014b.m7209k("unexpected key: ", value, TAG);
        }
        return true;
    }

    private final boolean handleSwitchPreferenceChange(SwitchPreferenceCompat preference, Object o) {
        String key;
        if (o instanceof Boolean) {
            if (!Intrinsics.areEqual(Boolean.valueOf(preference.isChecked()), o) && (key = preference.getKey()) != null) {
                MainLogger.m7258i(TAG, "handleSwitchPreferenceChange# key : " + key + ", state : " + o);
                Boolean bool = (Boolean) o;
                SettingsMainSALoggingHelper.mainSettingChangedSALogging(key, bool.booleanValue());
                if (Intrinsics.areEqual(key, SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC)) {
                    if (isMsAccountSignIn() && AbstractC6784f.f4180a.f4186f && !bool.booleanValue()) {
                        showTurnOffSCloudSyncWithTurnOffMSSyncDialog();
                        return true;
                    }
                    if (!bool.booleanValue()) {
                        C14477a.m15065b().m15075k(false);
                        updateSCloudSyncSummary();
                        checkedNotificationPermissions();
                        return true;
                    }
                    if (!SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_TURN_ON_SYNC_OPTION, C0145c.m339x(getFragment().getContext()))) {
                        showTurnOnWiFiSyncOnlyConfirmDialog();
                        return true;
                    }
                    C14477a.m15065b().m15075k(true);
                    updateSCloudSyncSummary();
                    checkedNotificationPermissions();
                    return true;
                }
                if (!Intrinsics.areEqual(key, SettingsConstants.SETTINGS_MICROSOFT_SYNC)) {
                    MainLogger.m7258i(TAG, "unexpected key: ".concat(key));
                } else if (C0158a.m407a().m416i() && isMsAccountSignIn()) {
                    if (!bool.booleanValue() || PermissionHelper.isPermissionGranted(getFragment().getActivity(), new RunnableC8829b(this, 0), "android.permission.GET_ACCOUNTS", "android.permission.READ_PHONE_STATE")) {
                        if (!C0158a.m407a().m417k()) {
                            showTurnOnSCloudSyncWithTurnOnMSSyncDialog();
                            return true;
                        }
                        AbstractC6784f.f4180a.m4949m(bool.booleanValue());
                        updateMicrosoftSyncSummary$default(this, false, null, 3, null);
                        return true;
                    }
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSwitchPreferenceChange$lambda$5$lambda$4(SettingsSyncHelper settingsSyncHelper) {
        settingsSyncHelper.requestPermissions(202, "android.permission.GET_ACCOUNTS", "android.permission.READ_PHONE_STATE");
    }

    private final void initMicrosoftSync() {
        SeslSwitchPreferenceScreen seslSwitchPreferenceScreen = (SeslSwitchPreferenceScreen) getFragment().findPreference(SettingsConstants.SETTINGS_MICROSOFT_SYNC);
        if (seslSwitchPreferenceScreen == null) {
            return;
        }
        seslSwitchPreferenceScreen.setVisible(SettingsMenuUtils.isMicrosoftSyncSupported());
        seslSwitchPreferenceScreen.setChecked(AbstractC6784f.f4180a.f4186f);
        seslSwitchPreferenceScreen.setOnPreferenceClickListener(this);
        seslSwitchPreferenceScreen.setOnPreferenceChangeListener(this);
    }

    private final void initSamsungCloudSync() {
        SeslSwitchPreferenceScreen seslSwitchPreferenceScreen = (SeslSwitchPreferenceScreen) getFragment().findPreference(SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC);
        Context context = getFragment().getContext();
        if (seslSwitchPreferenceScreen == null || context == null) {
            return;
        }
        seslSwitchPreferenceScreen.setVisible(SettingsMenuUtils.isSamsungCloudSyncSupported());
        seslSwitchPreferenceScreen.setTitle(SettingsMenuUtils.getSamsungCloudSyncMenuTitleRes(context));
        seslSwitchPreferenceScreen.setChecked(C0158a.m407a().m417k());
        seslSwitchPreferenceScreen.setOnPreferenceClickListener(this);
        seslSwitchPreferenceScreen.setOnPreferenceChangeListener(this);
    }

    private final void initSharedNotesSync() {
        Context context;
        DropDownPreference dropDownPreference = (DropDownPreference) getFragment().findPreference(SettingsConstants.SETTINGS_COEDIT_NOTES_SYNC_TYPE);
        if (dropDownPreference == null || (context = getFragment().getContext()) == null) {
            return;
        }
        if (!SettingsMenuUtils.INSTANCE.isSharedNotesSyncSupported(context)) {
            removePreference(dropDownPreference);
            return;
        }
        dropDownPreference.setValue(C0145c.m324i(context));
        dropDownPreference.seslSetSummaryColor(SettingsMenuUtils.getSummaryColor(context, true));
        dropDownPreference.setOnPreferenceChangeListener(this);
    }

    private final void initializeGlobalSyncStatusHandler() {
        if (this.mGlobalSyncStatusHandler != null) {
            return;
        }
        SettingsGlobalSyncStatusHandler settingsGlobalSyncStatusHandler = new SettingsGlobalSyncStatusHandler(new C7737b(this, 25));
        this.mGlobalSyncStatusHandler = settingsGlobalSyncStatusHandler;
        settingsGlobalSyncStatusHandler.initialize();
    }

    private final void initializeSCloudSyncSummary(SettingsSwitchPreferenceScreen preference) {
        if (TextUtils.isEmpty(preference.getSummary())) {
            preference.setWidgetState(1);
            preference.setSummary("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isFeedEnable() {
        if (AbstractC6784f.f4180a.f4186f && ((C13540g) C13541h.m14287e().f9588a).m14285a() && ContentResolver.getMasterSyncAutomatically() && C0158a.m407a().m417k()) {
            return (C13567a.m14371a().m14372c() && AbstractC4539a.m3210t()) ? false : true;
        }
        return false;
    }

    private final boolean isMicrosoftSyncStartRequestedByExternalAction() {
        return getFragment().isMsSignInRequested() || isMsSignOutRequested();
    }

    private final boolean isMsAccountSignIn() {
        SettingsMicrosoft settingsMicrosoft = this.mSettingsMicrosoft;
        if (settingsMicrosoft == null) {
            return false;
        }
        Intrinsics.checkNotNull(settingsMicrosoft);
        return settingsMicrosoft.isSignIn();
    }

    private final boolean isMsSignOutRequested() {
        return compareIntentAction(Constants.ACTION_START_SIGNOUT_MS_FEED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loginSamsungAccountByFragment(int requestCode) {
        if (AccountHelper.loginSamsungAccountByFragment(getFragment(), requestCode)) {
            SettingsMainSALoggingHelper.mainSettingLoginSamsungAccount();
        }
    }

    private final void onSCloudSettingSelected() {
        MainLogger.m7258i(TAG, "onSCloudSettingSelected# ");
        if (((SettingsSwitchPreferenceScreen) getFragment().findPreference(SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC)) == null || this.mSCloudSyncState == 0) {
            MainLogger.m7258i(TAG, "onSCloudSettingSelected, ignore, menu select action is not initialized");
            return;
        }
        MainLogger.m7258i(TAG, "onSCloudSettingSelected# sCloudSupportState, start");
        int sCloudSupportState = getSCloudSupportState();
        AbstractC8014b.m7201c(sCloudSupportState, "onSCloudSettingSelected# sCloudSupportState, end, sCloudSupportState: ", TAG);
        switch (sCloudSupportState) {
            case 1:
                getFragment().startSettingsActivity(SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC);
                break;
            case 2:
                MainLogger.m7258i(TAG, "onSCloudSettingSelected# Start SCloud Sync Settings by intent");
                if (!SCloudSetting.INSTANCE.launchSCloudSyncSetting(new WeakReference<>(getFragment()))) {
                    MainLogger.m7258i(TAG, "onSCloudSettingSelected# failed to launch SCloudSyncSetting, Start NotesSyncSetting");
                    getFragment().startSettingsActivity(SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC);
                }
                break;
            case 3:
                MainLogger.m7258i(TAG, "onSCloudSettingSelected# Show SCloud Sync Settings by RPCSyncApi");
                SCloudSetting.INSTANCE.launchSCloudRPCSetting(getFragment().getActivity());
                break;
            case 4:
            case 5:
            case 6:
            case 10:
            case 11:
                MainLogger.m7259w(TAG, "onSCloudSettingSelected, unused sCloudSupportState: " + sCloudSupportState);
                break;
            case 7:
                MainLogger.m7258i(TAG, "onSCloudSettingSelected# SCloud not installed.");
                UpdateManager.getInstance().goToGalaxyAppStore("com.samsung.android.scloud");
                break;
            case 8:
                MainLogger.m7258i(TAG, "onSCloudSettingSelected# Not Login.");
                loginSamsungAccountByFragment(103);
                break;
            case 9:
                if (!PermissionHelper.isPermissionGranted(getFragment().getActivity(), new RunnableC8829b(this, 1), "android.permission.GET_ACCOUNTS", "android.permission.READ_PHONE_STATE")) {
                    MainLogger.m7258i(TAG, "onSCloudSettingSelected# no permission");
                }
                break;
            default:
                MainLogger.m7255e(TAG, "onSCloudSettingSelected, unexpected sCloudSupportState: " + sCloudSupportState);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSCloudSettingSelected$lambda$11(SettingsSyncHelper settingsSyncHelper) {
        settingsSyncHelper.requestPermissions(200, "android.permission.GET_ACCOUNTS", "android.permission.READ_PHONE_STATE");
    }

    private final void releaseGlobalSyncStatusHandler() {
        SettingsGlobalSyncStatusHandler settingsGlobalSyncStatusHandler = this.mGlobalSyncStatusHandler;
        if (settingsGlobalSyncStatusHandler == null) {
            return;
        }
        if (settingsGlobalSyncStatusHandler != null) {
            settingsGlobalSyncStatusHandler.release();
        }
        this.mGlobalSyncStatusHandler = null;
    }

    private final void requestPermissions(int requestCode, String... permissions) {
        PermissionHelper.requestPermissions(getFragment(), requestCode, (String[]) Arrays.copyOf(permissions, permissions.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setEnableSamsungAccountSync(boolean isEnabled) {
        C14477a.m15065b().m15075k(isEnabled);
        SettingsSwitchPreferenceScreen settingsSwitchPreferenceScreen = (SettingsSwitchPreferenceScreen) getFragment().findPreference(SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC);
        if (settingsSwitchPreferenceScreen == null) {
            MainLogger.m7258i(TAG, "setEnableSamsungAccountSync#. Sync Preference is Null");
            return;
        }
        settingsSwitchPreferenceScreen.setChecked(isEnabled);
        if (isEnabled) {
            settingsSwitchPreferenceScreen.setSummary(((C13540g) C13541h.m14287e().f9588a).f9582d);
        }
    }

    private final void showSignInAndTurnOnSCloudSyncDialog() {
        getFragment().showSettingsConfirmDialog(3, this.mSignInAndTurnOnSyncConfirmDialogFragmentListener);
    }

    private final void showTurnOffSCloudSyncWithTurnOffMSSyncDialog() {
        getFragment().showSettingsConfirmDialog(1, this.mTurnOffSCloudSyncConfirmDialogFragmentListener);
    }

    private final void showTurnOnSCloudSyncAndLoginMSDialog() {
        getFragment().showSettingsConfirmDialog(2, this.mMsLoginConfirmDialogFragmentListener);
    }

    private final void showTurnOnSCloudSyncWithTurnOnMSSyncDialog() {
        getFragment().showSettingsConfirmDialog(2, this.mMsSyncTurnOnConfirmDialogFragmentListener);
    }

    private final void showTurnOnWiFiSyncOnlyConfirmDialog() {
        getFragment().showSettingsConfirmDialog(5, this.mTurnOnWiFiSyncOnlyConfirmDialogFragmentListener);
    }

    private final void startMicrosoftSyncSettingsActivity(boolean insertSALogging) {
        if (PermissionHelper.isPermissionGranted(getFragment().getActivity(), new RunnableC8829b(this, 2), "android.permission.GET_ACCOUNTS", "android.permission.READ_PHONE_STATE")) {
            if (!((C13540g) C13541h.m14287e().f9588a).m14285a()) {
                showSignInAndTurnOnSCloudSyncDialog();
                return;
            }
            if (!C0158a.m407a().m417k() && !isMsSignOutRequested()) {
                showTurnOnSCloudSyncAndLoginMSDialog();
                return;
            }
            if (C0158a.m407a().m416i()) {
                SettingsMicrosoft settingsMicrosoft = this.mSettingsMicrosoft;
                if (settingsMicrosoft != null) {
                    Intrinsics.checkNotNull(settingsMicrosoft);
                    if (!settingsMicrosoft.isSignIn()) {
                        if (PermissionHelper.isPermissionGranted(getFragment().getActivity(), new RunnableC8829b(this, 3), "android.permission.GET_ACCOUNTS", "android.permission.READ_PHONE_STATE")) {
                            Intent intent = new Intent();
                            intent.setClass(getFragment().requireContext(), SettingsMicrosoftLoginActivity.class);
                            if (insertSALogging) {
                                CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_SETTINGS, SettingsSAConstants.EVENT_SETTINGS_MS_SYNC_SIGN_IN);
                            }
                            getFragment().startActivityForResult(intent, 1);
                            return;
                        }
                        return;
                    }
                }
                if (insertSALogging) {
                    CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_SETTINGS, SettingsSAConstants.EVENT_SETTINGS_MS_SYNC);
                }
                getFragment().startSettingsActivity(SettingsConstants.SETTINGS_MICROSOFT_SYNC);
            }
        }
    }

    public static /* synthetic */ void startMicrosoftSyncSettingsActivity$default(SettingsSyncHelper settingsSyncHelper, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        settingsSyncHelper.startMicrosoftSyncSettingsActivity(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startMicrosoftSyncSettingsActivity$lambda$8(SettingsSyncHelper settingsSyncHelper) {
        settingsSyncHelper.requestPermissions(201, "android.permission.GET_ACCOUNTS", "android.permission.READ_PHONE_STATE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startMicrosoftSyncSettingsActivity$lambda$9(SettingsSyncHelper settingsSyncHelper) {
        ToastHandler.show(settingsSyncHelper.getFragment().getContext(), "Permission is not granted", 0, false);
    }

    private final void unBindSyncService() {
        C14477a.m15065b().m15070e(this.mSyncEnableModeListener);
    }

    private final void updateCategoryVisibility() {
        PreferenceCategory preferenceCategory = (PreferenceCategory) getFragment().findPreference(SettingsConstants.SETTINGS_SYNC_CATEGORY);
        if (preferenceCategory == null) {
            return;
        }
        preferenceCategory.setVisible(SettingsMenuUtils.isMicrosoftSyncSupported() || SettingsMenuUtils.isSamsungCloudSyncSupported());
    }

    private final void updateCoeditNotesSyncType() {
        DropDownPreference dropDownPreference = (DropDownPreference) getFragment().findPreference(SettingsConstants.SETTINGS_COEDIT_NOTES_SYNC_TYPE);
        if (dropDownPreference == null) {
            return;
        }
        if (dropDownPreference.isVisible()) {
            dropDownPreference.setValue(C0145c.m324i(getFragment().getContext()));
        } else {
            MainLogger.m7258i(TAG, "updateCoeditNotesSyncType# preference is not visible");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateMicrosoftSyncSummary(boolean isMsAccountSignIn, String microsoftAccount) {
        if (getFragment().getContext() == null) {
            MainLogger.m7258i(TAG, "updateMicrosoftSyncSummary# Context is Null, ignore");
            return;
        }
        SettingsSwitchPreferenceScreen settingsSwitchPreferenceScreen = (SettingsSwitchPreferenceScreen) getFragment().findPreference(SettingsConstants.SETTINGS_MICROSOFT_SYNC);
        if (settingsSwitchPreferenceScreen == null) {
            MainLogger.m7258i(TAG, "updateMicrosoftSyncSummary# Sync Preference is Null");
            return;
        }
        if (settingsSwitchPreferenceScreen.isVisible()) {
            if (SettingsCompat.INSTANCE.getInstance().isUPSM(settingsSwitchPreferenceScreen.getContext())) {
                settingsSwitchPreferenceScreen.setSummary(C8003R.string.settings_upsm_sub_text_unable_to_sync);
                settingsSwitchPreferenceScreen.setSecondarySummary(null, false);
                return;
            }
            boolean z = isMsAccountSignIn && ((C13540g) C13541h.m14287e().f9588a).m14285a();
            boolean z2 = AbstractC6784f.f4180a.f4186f;
            String encode = MainLogger.getEncode(microsoftAccount);
            StringBuilder sbM2230u = AbstractC2821a.m2230u("updateMicrosoftSyncSummary# isSignIn : ", " , enabled : ", " , ", z, z2);
            sbM2230u.append(encode);
            MainLogger.m7258i(TAG, sbM2230u.toString());
            settingsSwitchPreferenceScreen.setWidgetState(z ? 2 : 0);
            settingsSwitchPreferenceScreen.setChecked(z2);
            if (!z) {
                settingsSwitchPreferenceScreen.setSummary(getFragment().getString(C8003R.string.settings_sync_to_ms_sign_out_without_account_summary));
                settingsSwitchPreferenceScreen.setSecondarySummary(null, false);
            } else if (!z2) {
                settingsSwitchPreferenceScreen.setSummary("");
                settingsSwitchPreferenceScreen.setSecondarySummary(null, false);
            } else if (microsoftAccount != null) {
                settingsSwitchPreferenceScreen.setSummary(C8003R.string.settings_sync_to_ms_sign_in_with_account_summary);
                settingsSwitchPreferenceScreen.setSecondarySummary(microsoftAccount, true);
            } else {
                settingsSwitchPreferenceScreen.setSummary("");
                settingsSwitchPreferenceScreen.setSecondarySummary(null, false);
            }
        }
    }

    public static void updateMicrosoftSyncSummary$default(SettingsSyncHelper settingsSyncHelper, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = settingsSyncHelper.isMsAccountSignIn();
        }
        if ((i & 2) != 0) {
            str = C0145c.m331p("GRAPH_PREFERENCE", "user_email", "");
        }
        settingsSyncHelper.updateMicrosoftSyncSummary(z, str);
    }

    private final void updateMicrosoftSyncVisibility() {
        SettingsSwitchPreferenceScreen settingsSwitchPreferenceScreen = (SettingsSwitchPreferenceScreen) getFragment().findPreference(SettingsConstants.SETTINGS_MICROSOFT_SYNC);
        if (settingsSwitchPreferenceScreen == null) {
            MainLogger.m7258i(TAG, "updateMicrosoftSyncVisibility# Sync Preference is Null");
        } else {
            settingsSwitchPreferenceScreen.setVisible(SettingsMenuUtils.isMicrosoftSyncSupported());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSCloudSyncSummary() {
        if (getFragment().isDetached()) {
            MainLogger.m7258i(TAG, "updateSCloudSyncSummary# fragment is detached");
            return;
        }
        if (getFragment().getContext() == null) {
            return;
        }
        SettingsSwitchPreferenceScreen settingsSwitchPreferenceScreen = (SettingsSwitchPreferenceScreen) getFragment().findPreference(SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC);
        if (settingsSwitchPreferenceScreen == null) {
            MainLogger.m7258i(TAG, "updateSCloudSyncSummary# Sync Preference is Null");
        } else if (!settingsSwitchPreferenceScreen.isVisible()) {
            MainLogger.m7258i(TAG, "updateSCloudSyncSummary# Sync Preference is not visible");
        } else {
            changeSCloudSyncSummary(settingsSwitchPreferenceScreen, this.mSCloudSyncState);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C88271(settingsSwitchPreferenceScreen, null), 3, null);
        }
    }

    private final void updateSCloudSyncVisibility() {
        if (getFragment().isDetached()) {
            MainLogger.m7258i(TAG, "updateSCloudSyncVisibility# fragment is detached");
            return;
        }
        if (getFragment().getContext() == null) {
            return;
        }
        SettingsSwitchPreferenceScreen settingsSwitchPreferenceScreen = (SettingsSwitchPreferenceScreen) getFragment().findPreference(SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC);
        if (settingsSwitchPreferenceScreen == null) {
            MainLogger.m7258i(TAG, "updateSCloudSyncVisibility# Sync Preference is Null");
        } else {
            settingsSwitchPreferenceScreen.setVisible(SettingsMenuUtils.isSamsungCloudSyncSupported());
        }
    }

    public final void checkedNotificationPermissions() {
        if (C0158a.m407a().m417k()) {
            NotificationUtils.checkedNotificationPermissions$default(getFragment(), 0, 2, null);
        }
    }

    public final boolean compareIntentAction(@NotNull String actionConstant) {
        Intent intent;
        Intrinsics.checkNotNullParameter(actionConstant, "actionConstant");
        FragmentActivity activity = getFragment().getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return false;
        }
        return Intrinsics.areEqual(actionConstant, intent.getAction());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public boolean handleActivityResults(int requestCode, int resultCode, @Nullable Intent data) {
        if (PermissionHelper.onActivityResult(requestCode, resultCode, new RunnableC8829b(this, 4))) {
            finishActivity();
            return true;
        }
        if (requestCode != 1) {
            if (requestCode != 10) {
                if (requestCode == 103) {
                    if (resultCode == -1) {
                        onSCloudSettingSelected();
                        return false;
                    }
                }
            } else if (resultCode == -1) {
                C6896g c6896g = C14477a.m15065b().f10283a;
                c6896g.m5102l(true, true, false);
                C0042g c0042gM78a = C0042g.m78a(c6896g.f4454c);
                if (c0042gM78a.m79b()) {
                    c0042gM78a.f186b.mo68e(true);
                } else {
                    Debugger.m8609e("SCRPCSettingManager", "notifyAutoSyncChanged() : fail!");
                }
                startMicrosoftSyncSettingsActivity$default(this, false, 1, null);
                return false;
            }
            return true;
        }
        if (isMicrosoftSyncStartRequestedByExternalAction()) {
            finishActivity();
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public boolean handleRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (requestCode != 10001) {
            switch (requestCode) {
                case 200:
                    if (PermissionHelper.verifyRequestResult(getFragment().getActivity(), grantResults, (String[]) Arrays.copyOf(permissions, permissions.length))) {
                        updateSCloudSyncSummary();
                        onSCloudSettingSelected();
                        return true;
                    }
                    break;
                case 201:
                    if (PermissionHelper.verifyRequestResult(getFragment().getActivity(), grantResults, (String[]) Arrays.copyOf(permissions, permissions.length))) {
                        updateMicrosoftSyncSummary$default(this, false, null, 3, null);
                        startMicrosoftSyncSettingsActivity$default(this, false, 1, null);
                        return true;
                    }
                    break;
                case 202:
                    if (C0158a.m407a().m417k()) {
                        AbstractC6784f.f4180a.m4949m(true);
                        updateMicrosoftSyncSummary$default(this, false, null, 3, null);
                        return true;
                    }
                    showTurnOnSCloudSyncWithTurnOnMSSyncDialog();
                    break;
            }
        } else if (!PermissionHelper.verifyRequestResult(getFragment().getActivity(), grantResults, (String[]) Arrays.copyOf(permissions, permissions.length))) {
            MainLogger.m7258i(TAG, "onRequestPermissionsResult# PERMISSION_REQUEST_NOTIFICATION not verified");
            return true;
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void initialize() {
        PreferenceGroup parent;
        if (UserHandleCompat.INSTANCE.getInstance().isKnoxMode() && !DeviceUtils.isSyncEnabledInDoMode(getFragment().getContext())) {
            Preference preference = (PreferenceCategory) getFragment().findPreference(SettingsConstants.SETTINGS_SYNC_CATEGORY);
            if (preference == null || (parent = preference.getParent()) == null) {
                return;
            }
            parent.removePreference(preference);
            return;
        }
        super.initialize();
        MainLogger.m7254d(TAG, "initialize");
        initSamsungCloudSync();
        initMicrosoftSync();
        initSharedNotesSync();
        initializeGlobalSyncStatusHandler();
        if (C0158a.m407a().m416i()) {
            this.mSettingsMicrosoft = new SettingsMicrosoft(new WeakReference(getFragment().getActivity()), new SettingsMicrosoft.MicrosoftCallback() { // from class: com.samsung.android.support.senl.nt.app.settings.main.SettingsSyncHelper.initialize.1
                @Override // com.samsung.android.support.senl.nt.app.settings.microsoft.SettingsMicrosoft.MicrosoftCallback
                public void onEnable(boolean enable) {
                    AbstractC6670b.m4739D("SettingsMicrosoft onEnable : ", SettingsSyncHelper.TAG, enable);
                    SettingsSwitchPreferenceScreen settingsSwitchPreferenceScreen = (SettingsSwitchPreferenceScreen) SettingsSyncHelper.this.getFragment().findPreference(SettingsConstants.SETTINGS_MICROSOFT_SYNC);
                    if (settingsSwitchPreferenceScreen == null) {
                        return;
                    }
                    settingsSwitchPreferenceScreen.setChecked(enable);
                }

                @Override // com.samsung.android.support.senl.nt.app.settings.microsoft.SettingsMicrosoft.MicrosoftCallback
                public void onUpdate(boolean isSignIn, String info) {
                    MainLogger.m7258i(SettingsSyncHelper.TAG, "SettingsMicrosoft onUpdate. signIn : " + isSignIn + ", + " + MainLogger.getEncode(info));
                    SettingsSyncHelper.this.updateMicrosoftSyncSummary(isSignIn, info);
                }
            });
        }
        if (C0158a.m407a().m416i()) {
            this.mSettingsMicrosoft = new SettingsMicrosoft(new WeakReference(getFragment().getActivity()), new SettingsMicrosoft.MicrosoftCallback() { // from class: com.samsung.android.support.senl.nt.app.settings.main.SettingsSyncHelper.initialize.2
                @Override // com.samsung.android.support.senl.nt.app.settings.microsoft.SettingsMicrosoft.MicrosoftCallback
                public void onEnable(boolean enable) {
                    AbstractC6670b.m4739D("SettingsMicrosoft onEnable : ", SettingsSyncHelper.TAG, enable);
                    SettingsSwitchPreferenceScreen settingsSwitchPreferenceScreen = (SettingsSwitchPreferenceScreen) SettingsSyncHelper.this.getFragment().findPreference(SettingsConstants.SETTINGS_MICROSOFT_SYNC);
                    if (settingsSwitchPreferenceScreen == null) {
                        return;
                    }
                    settingsSwitchPreferenceScreen.setChecked(enable);
                }

                @Override // com.samsung.android.support.senl.nt.app.settings.microsoft.SettingsMicrosoft.MicrosoftCallback
                public void onUpdate(boolean isSignIn, String info) {
                    MainLogger.m7258i(SettingsSyncHelper.TAG, "SettingsMicrosoft onUpdate. signIn : " + isSignIn + ", + " + MainLogger.getEncode(info));
                    SettingsSyncHelper.this.updateMicrosoftSyncSummary(isSignIn, info);
                }
            });
        }
        SyncStateListener syncStateListener = null;
        if (!PermissionHelper.noticeAppPermissionIfNeededs(getFragment().getActivity()) && isMicrosoftSyncStartRequestedByExternalAction()) {
            startMicrosoftSyncSettingsActivity$default(this, false, 1, null);
        }
        FragmentActivity activity = getFragment().getActivity();
        if (activity != null) {
            PreferenceScreen preferenceScreen = getFragment().getPreferenceScreen();
            Intrinsics.checkNotNullExpressionValue(preferenceScreen, "getPreferenceScreen(...)");
            syncStateListener = new SyncStateListener(activity, preferenceScreen);
        }
        this.mSyncEnableModeListener = syncStateListener;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void onCreate() {
        checkedNotificationPermissions();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper, androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(@NotNull Preference preference, @Nullable Object newValue) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.SettingsMain;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(100L, tag);
        if (preference instanceof SwitchPreferenceCompat) {
            return handleSwitchPreferenceChange((SwitchPreferenceCompat) preference, newValue);
        }
        if (!(preference instanceof DropDownPreference)) {
            return false;
        }
        SharedPreferencesCompat companion = SharedPreferencesCompat.INSTANCE.getInstance("Settings");
        Intrinsics.checkNotNull(newValue, "null cannot be cast to non-null type kotlin.String");
        companion.putString(SettingsConstants.SETTINGS_COEDIT_NOTES_SYNC_TYPE, (String) newValue);
        return handleDropDownPreferenceChange((DropDownPreference) preference, newValue);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper, androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(@NotNull Preference preference) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.SettingsMain;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(1000L, tag);
        String key = preference.getKey();
        if (key != null) {
            MainLogger.m7258i(TAG, "onPreferenceClick# key : ".concat(key));
            if (!preference.isEnabled()) {
                MainLogger.m7258i(TAG, "onPreferenceClick# preference is disabled ");
                return false;
            }
            SettingsMainSALoggingHelper.mainSettingClickedSALogging(key);
            if (Intrinsics.areEqual(key, SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC)) {
                onSCloudSettingSelected();
            } else if (Intrinsics.areEqual(key, SettingsConstants.SETTINGS_MICROSOFT_SYNC)) {
                startMicrosoftSyncSettingsActivity(true);
            } else {
                MainLogger.m7258i(TAG, "unexpected key: ".concat(key));
            }
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void onResume() {
        if (C0145c.m338w(getFragment().getContext())) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogics();
            C14477a.m15065b().m15077m(getFragment().getContext());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper, android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(@Nullable SharedPreferences sharedPreferences, @Nullable String key) {
        super.onSharedPreferenceChanged(sharedPreferences, key);
        if (Intrinsics.areEqual(SettingsConstants.SETTINGS_SYNC_ENABLE_DO_MODE, key)) {
            updateSCloudSyncVisibility();
            updateMicrosoftSyncVisibility();
        } else if (Intrinsics.areEqual(SettingsConstants.SETTINGS_SYNC_NOTES, key)) {
            updateSCloudSyncSummary();
        } else if (Intrinsics.areEqual(SettingsConstants.SETTINGS_COEDIT_NOTES_SYNC_TYPE, key)) {
            updateCoeditNotesSyncType();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void onStart() {
        if (!SystemPropertiesCompat.INSTANCE.getInstance().isChinaModel() || C0145c.m332q(getFragment().getContext())) {
            bindSyncService();
            return;
        }
        AllowAppPermissionDialogFragment allowAppPermissionDialogFragmentNewInstance = AllowAppPermissionDialogFragment.INSTANCE.newInstance();
        allowAppPermissionDialogFragmentNewInstance.setAllowAppPermissionDialogCallback(new AllowAppPermissionDialogFragment.AllowAppPermissionDialogCallback() { // from class: com.samsung.android.support.senl.nt.app.settings.main.SettingsSyncHelper.onStart.1
            @Override // com.samsung.android.support.senl.nt.app.settings.common.dialog.AllowAppPermissionDialogFragment.AllowAppPermissionDialogCallback
            public void onAppPermissionCancel() {
                MainLogger.m7258i(SettingsSyncHelper.TAG, "onAppPermissionCancel.");
                SettingsSyncHelper.this.finishActivity();
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.common.dialog.AllowAppPermissionDialogFragment.AllowAppPermissionDialogCallback
            public void onAppPermissionConfirm() {
                MainLogger.m7258i(SettingsSyncHelper.TAG, "onAppPermissionConfirm.");
                C0145c.m303K(SettingsSyncHelper.this.getFragment().getContext());
                SettingsSyncHelper.this.bindSyncService();
            }
        });
        AppCompatActivity appCompatActivity = (AppCompatActivity) getFragment().getActivity();
        if (appCompatActivity == null || !CommonUtil.isAvailableActivity(appCompatActivity)) {
            return;
        }
        allowAppPermissionDialogFragmentNewInstance.showAllowingStateLoss(appCompatActivity.getSupportFragmentManager(), AllowAppPermissionDialogFragment.TAG);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void onStop() {
        unBindSyncService();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void release() {
        super.release();
        SettingsMicrosoft settingsMicrosoft = this.mSettingsMicrosoft;
        if (settingsMicrosoft != null) {
            settingsMicrosoft.release();
        }
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putBoolean(SettingsConstants.SETTINGS_MICROSOFT_SYNC_FIRST_TIME, false);
        releaseGlobalSyncStatusHandler();
        SyncStateListener syncStateListener = this.mSyncEnableModeListener;
        if (syncStateListener != null) {
            syncStateListener.release();
        }
        this.mSyncEnableModeListener = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void updatePreference() {
        super.updatePreference();
        updateSCloudSyncVisibility();
        updateMicrosoftSyncVisibility();
        updateSCloudSyncSummary();
        updateCategoryVisibility();
    }
}
