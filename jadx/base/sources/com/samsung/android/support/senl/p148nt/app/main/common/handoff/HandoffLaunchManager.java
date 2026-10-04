package com.samsung.android.support.senl.p148nt.app.main.common.handoff;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.ActivityLifecycleTracker;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManager;
import com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener;
import com.samsung.android.support.senl.p148nt.base.common.access.lock.LockAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.HandoffUtils;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.model.MainHandoffData;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.handoff.CoHandOffUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.handoff.CoHandoffConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.SyncWaitingProgressDialog;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import p054M1.DialogInterfaceOnClickListenerC0174a;
import p070Q1.RunnableC0218a;
import p192j1.C12936a;
import p207n1.C13541h;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 C2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002BCB+\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\u0016\u0010\u0018\u001a\u00020\u00162\u000e\u0010\u0019\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012J\u0016\u0010\u001a\u001a\u00020\u00162\u000e\u0010\u001b\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012J\u0016\u0010\u001c\u001a\u00020\u00162\u000e\u0010\u001d\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012J\u0010\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\rJ\u0010\u0010 \u001a\u00020!2\b\u0010\u001f\u001a\u0004\u0018\u00010\rJ\b\u0010\"\u001a\u00020\u0016H\u0002J\u001c\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u0018\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\rH\u0002J\u0018\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020$H\u0002J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010-\u001a\u00020$H\u0002J\u0010\u0010/\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\rH\u0002J \u00100\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\r2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020&H\u0002J\u0010\u00104\u001a\u0004\u0018\u00010\u00022\u0006\u00103\u001a\u00020&J\u0012\u00105\u001a\u00020\u00162\b\u00106\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u00107\u001a\u00020\u0016J\b\u00108\u001a\u00020\u0016H\u0002J\"\u00109\u001a\u00020\u00162\b\u0010:\u001a\u0004\u0018\u00010&2\u0010\b\u0002\u0010;\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012J \u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>2\b\u0010@\u001a\u0004\u0018\u00010$J\u000e\u0010A\u001a\u00020\u00162\u0006\u0010=\u001a\u00020>R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\f\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/handoff/HandoffLaunchManager;", "Landroidx/lifecycle/Observer;", "Lcom/samsung/android/support/senl/nt/data/database/core/document/data/MainListDocumentData;", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroidx/appcompat/app/AppCompatActivity;", "handleActionWithBaseActivityFinish", "", "contract", "Lcom/samsung/android/support/senl/nt/app/main/common/handoff/HandoffLaunchManager$Contract;", "<init>", "(Ljava/lang/ref/WeakReference;ZLcom/samsung/android/support/senl/nt/app/main/common/handoff/HandoffLaunchManager$Contract;)V", "newNoteMetaData", "Lorg/json/JSONObject;", "getNewNoteMetaData", "()Lorg/json/JSONObject;", "mTimerStartAction", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "mTimerFailAction", "mTimerEndAction", "createTimer", "", "cancelTimer", "setTimerStartAction", "timerStartAction", "setTimerFailAction", "timerFailAction", "setTimerEndAction", "timerEndAction", "handleMain", "metaData", "handleComposer", "Lcom/samsung/android/support/senl/nt/app/main/common/handoff/HandoffLaunchManager$Companion$COMPOSER_METADATA_HANDLE_RESULT;", "closeAllActivityInThisTask", "createMainIntent", "Landroid/content/Intent;", "activityType", "", "mainHandoffData", "Lcom/samsung/android/support/senl/nt/base/common/mcf/handoff/model/MainHandoffData;", "createComposerIntent", "entry", "setMdeInfo", "entity", MarketingConstants.LINK_TYPE_INTENT, "createLockManager", "isNotAvailableToSync", "waitSyncNewNote", "docRepository", "Lcom/samsung/android/support/senl/nt/data/repository/document/MainListDocumentDataRepository;", "uuid", "getDocumentData", "onChanged", "value", "hideSyncDialog", "releaseNewNoteObserver", "handleHandoffData", HandoffConstant.KEY_HANDOFF_DATA, "endAction", "onActivityResult", "requestCode", "", "resultCode", "data", "onRequestPermissionsResult", "Contract", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nHandoffLaunchManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HandoffLaunchManager.kt\ncom/samsung/android/support/senl/nt/app/main/common/handoff/HandoffLaunchManager\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,600:1\n37#2:601\n36#2,3:602\n*S KotlinDebug\n*F\n+ 1 HandoffLaunchManager.kt\ncom/samsung/android/support/senl/nt/app/main/common/handoff/HandoffLaunchManager\n*L\n164#1:601\n164#1:602,3\n*E\n"})
public final class HandoffLaunchManager implements Observer<MainListDocumentData> {
    public static final int SYNC_PERMISSION_REQUEST_CODE = 9999;

    @NotNull
    public static final String TAG = "HandoffLaunchManager";

    @Nullable
    private static ILockManager mLockManager;

    @Nullable
    private static JSONObject mNewNoteMetaData;
    private static boolean mSkipFlagForWiFiSyncOnlyAndNotWiFiConnected;

    @Nullable
    private static SyncWaitingProgressDialog mSyncWaitingProgressDialog;

    @Nullable
    private static Timer mTimer;

    @NotNull
    private final WeakReference<AppCompatActivity> activityRef;

    @Nullable
    private final Contract contract;
    private final boolean handleActionWithBaseActivityFinish;

    @Nullable
    private Runnable mTimerEndAction;

    @Nullable
    private Runnable mTimerFailAction;

    @Nullable
    private Runnable mTimerStartAction;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/handoff/HandoffLaunchManager$Contract;", "", "requestUnregisterHandoffObserver", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void requestUnregisterHandoffObserver();
    }

    public HandoffLaunchManager(@NotNull WeakReference<AppCompatActivity> activityRef, boolean z, @Nullable Contract contract) {
        Intrinsics.checkNotNullParameter(activityRef, "activityRef");
        this.activityRef = activityRef;
        this.handleActionWithBaseActivityFinish = z;
        this.contract = contract;
    }

    private final void closeAllActivityInThisTask() {
        if (this.activityRef.get() == null || !this.handleActionWithBaseActivityFinish) {
            return;
        }
        ActivityLifecycleTracker activityTracker = ApplicationManager.INSTANCE.getInstance().getActivityTracker();
        AppCompatActivity appCompatActivity = this.activityRef.get();
        Intrinsics.checkNotNull(appCompatActivity);
        activityTracker.closeAllInSameTask(appCompatActivity);
    }

    private final Intent createComposerIntent(MainListDocumentData entry, JSONObject metaData) {
        if (this.activityRef.get() == null) {
            return new Intent();
        }
        Intent intent = CoHandOffUtil.getIntent(this.activityRef.get(), entry.getUuid(), metaData.toString());
        Intrinsics.checkNotNull(intent);
        setMdeInfo(entry, intent);
        return intent;
    }

    private final void createLockManager(final Intent intent) {
        if (this.activityRef.get() == null) {
            return;
        }
        AppCompatActivity appCompatActivity = this.activityRef.get();
        Intrinsics.checkNotNull(appCompatActivity);
        final AppCompatActivity appCompatActivity2 = appCompatActivity;
        mLockManager = LockAccessHandler.createLockManager(new ILockManagerListener() { // from class: com.samsung.android.support.senl.nt.app.main.common.handoff.HandoffLaunchManager.createLockManager.1
            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onCreatePasswordFail(int requestCode, int failCode, Intent data) {
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onCreatePasswordSuccess(int requestCode, Intent data) {
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onLockFail(int requestCode, int failCode, String... uuidList) {
                Intrinsics.checkNotNullParameter(uuidList, "uuidList");
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onLockSuccess(int requestCode, String... uuidList) {
                Intrinsics.checkNotNullParameter(uuidList, "uuidList");
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onUnlockFail(int requestCode, int failCode, String... uuidList) {
                Intrinsics.checkNotNullParameter(uuidList, "uuidList");
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onUnlockSuccess(int requestCode, Intent data, String... uuidList) {
                Intrinsics.checkNotNullParameter(uuidList, "uuidList");
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onVerifyFail(int requestCode, int failCode, String... uuidList) {
                Intrinsics.checkNotNullParameter(uuidList, "uuidList");
                MainLogger.m7258i(HandoffLaunchManager.TAG, "onVerifyFail");
                Contract contract = HandoffLaunchManager.this.contract;
                if (contract != null) {
                    contract.requestUnregisterHandoffObserver();
                }
                if (requestCode == 109 && HandoffLaunchManager.this.handleActionWithBaseActivityFinish) {
                    appCompatActivity2.finish();
                }
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onVerifySuccess(int requestCode, Intent data, String... uuidList) {
                Intrinsics.checkNotNullParameter(uuidList, "uuidList");
                MainLogger.m7258i(HandoffLaunchManager.TAG, "onVerifySuccess");
                Contract contract = HandoffLaunchManager.this.contract;
                if (contract != null) {
                    contract.requestUnregisterHandoffObserver();
                }
                intent.putExtra(ComposerConstants.ARG_LOCK_ACCOUNT_GUID, C13541h.m14287e().m14294h());
                appCompatActivity2.startActivity(intent);
                if (HandoffLaunchManager.this.handleActionWithBaseActivityFinish) {
                    appCompatActivity2.finish();
                }
                HandoffUtils.INSTANCE.getInstance().requestSyncHandoffData();
            }
        });
    }

    private final Intent createMainIntent(String activityType, MainHandoffData mainHandoffData) {
        Intent intent = new Intent(BaseUtils.getApplicationContext(), HandoffUtils.INSTANCE.getInstance().getClassFromActivityType(activityType));
        intent.setAction(Constants.ACTION_HANDOFF);
        intent.putExtra(HandoffConstant.KEY_HANDOFF_DATA, mainHandoffData);
        intent.putExtra(HandoffConstant.KEY_HANDLE_HANDOFF_BASED_ON_CURRENT_ACTIVITY, !this.handleActionWithBaseActivityFinish);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleComposer$lambda$1(HandoffLaunchManager handoffLaunchManager, JSONObject jSONObject, DialogInterface dialogInterface, int i) {
        handoffLaunchManager.handleMain(jSONObject);
        mSkipFlagForWiFiSyncOnlyAndNotWiFiConnected = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleComposer$lambda$2(HandoffLaunchManager handoffLaunchManager, JSONObject jSONObject, DialogInterface dialogInterface) {
        Logger.m7100d(TAG, "showWiFiSyncOnlyAndNotWiFiConnected# onDismiss");
        if (mSkipFlagForWiFiSyncOnlyAndNotWiFiConnected) {
            return;
        }
        handoffLaunchManager.handleMain(jSONObject);
    }

    public static /* synthetic */ void handleHandoffData$default(HandoffLaunchManager handoffLaunchManager, String str, Runnable runnable, int i, Object obj) {
        if ((i & 2) != 0) {
            runnable = null;
        }
        handoffLaunchManager.handleHandoffData(str, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleHandoffData$lambda$12$lambda$11(String str, HandoffLaunchManager handoffLaunchManager, AppCompatActivity appCompatActivity, Runnable runnable) {
        MainLogger.m7258i(TAG, "handleHandoffDataInfo# start");
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("app_id");
            String string2 = jSONObject.getString("version");
            String string3 = jSONObject.getString(HandoffConstant.KEY_ACTIVITY_TYPE);
            MainLogger.m7258i(TAG, "handleHandoffDataInfo, appId: " + string + ", receiverHandoffVersion: 1.0.0, senderHandoffVersion: " + string2 + ", activityType: " + string3 + ", syncEnabledOnSender: " + jSONObject.getBoolean(HandoffConstant.KEY_SYNC_ENABLED));
            if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string) && Intrinsics.areEqual(string, ApplicationManager.INSTANCE.getInstance().getApplicationID())) {
                Companion.COMPOSER_METADATA_HANDLE_RESULT composer_metadata_handle_resultHandleComposer = handoffLaunchManager.handleComposer(jSONObject);
                if (composer_metadata_handle_resultHandleComposer == Companion.COMPOSER_METADATA_HANDLE_RESULT.FAILED) {
                    handoffLaunchManager.handleMain(jSONObject);
                }
                if (composer_metadata_handle_resultHandleComposer == Companion.COMPOSER_METADATA_HANDLE_RESULT.LOCK_REQUESTED || runnable == null) {
                    return;
                }
                runnable.run();
                return;
            }
            if (handoffLaunchManager.handleActionWithBaseActivityFinish) {
                appCompatActivity.finish();
            }
        } catch (JSONException e) {
            AbstractC6670b.m4738C("handleHandoffDataInfo#JSONException# ", e.getMessage(), TAG);
            if (handoffLaunchManager.handleActionWithBaseActivityFinish) {
                appCompatActivity.finish();
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    private final boolean isNotAvailableToSync(JSONObject metaData) {
        if (this.activityRef.get() == null) {
            return true;
        }
        AppCompatActivity appCompatActivity = this.activityRef.get();
        Intrinsics.checkNotNull(appCompatActivity);
        AppCompatActivity appCompatActivity2 = appCompatActivity;
        if (!ContentResolver.getMasterSyncAutomatically()) {
            Logger.m7101e(TAG, "isNotAvailableToSync# master sync is off");
            ToastHandler.show(appCompatActivity2, C8003R.string.settings_sync_accounts_summary_auto_sync_disabled, 0);
            return true;
        }
        if (!SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_SYNC_NOTES, false)) {
            return true;
        }
        if (!metaData.getBoolean(HandoffConstant.KEY_SYNC_ENABLED)) {
            HandoffUtils.INSTANCE.getInstance().showTurnOnSyncToast();
            return true;
        }
        RequestToSyncManager.Companion companion = RequestToSyncManager.INSTANCE;
        if (companion.getInstance().getRequestSyncContract() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(301);
        }
        if (companion.isDataCallNotLimitedForApp()) {
            return false;
        }
        HandoffUtils.INSTANCE.getInstance().showConnectToNetwork();
        return true;
    }

    private final void releaseNewNoteObserver() {
        String string;
        JSONObject jSONObject = mNewNoteMetaData;
        AppCompatActivity appCompatActivity = this.activityRef.get();
        if (appCompatActivity != null) {
            MainListDocumentDataRepository mainListDocumentDataRepositoryCreateMainListDocumentDataRepository = NotesDataRepositoryFactory.newInstance(appCompatActivity.getApplicationContext()).createMainListDocumentDataRepository();
            if (jSONObject != null) {
                try {
                    string = jSONObject.getString("sdoc_uuid");
                } catch (JSONException e) {
                    Logger.m7102e(TAG, "hideSyncDialog# JSON Err", e);
                    Unit unit = Unit.INSTANCE;
                    return;
                }
            } else {
                string = null;
            }
            if (string != null && !TextUtils.isEmpty(string)) {
                mainListDocumentDataRepositoryCreateMainListDocumentDataRepository.get_LiveData(string).removeObserver(this);
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    private final void setMdeInfo(MainListDocumentData entity, Intent intent) {
        if (TextUtils.isEmpty(entity.getMdeSpaceId())) {
            return;
        }
        MainLogger.m7258i(TAG, "setMdeInfo#");
        intent.putExtra(ComposerConstants.ARG_MDE_SPACE_ID, entity.getMdeSpaceId());
        intent.putExtra(ComposerConstants.ARG_MDE_GROUP_ID, entity.getMdeGroupId());
        intent.putExtra(ComposerConstants.ARG_MDE_OWNER_ID, entity.getMdeOwnerId());
        intent.putExtra(ComposerConstants.ARG_MDE_ACCOUNT_TYPE, AbstractC14517a.m15166z(BaseUtils.getApplicationContext(), entity.getUuid()) ? 1 : 2);
    }

    private final void waitSyncNewNote(JSONObject metaData, MainListDocumentDataRepository docRepository, final String uuid) {
        Logger.m7104i(TAG, "waitSyncNewNote# ");
        if (this.activityRef.get() == null) {
            return;
        }
        AppCompatActivity appCompatActivity = this.activityRef.get();
        Intrinsics.checkNotNull(appCompatActivity);
        AppCompatActivity appCompatActivity2 = appCompatActivity;
        cancelTimer();
        closeAllActivityInThisTask();
        mNewNoteMetaData = metaData;
        DialogContract.ISyncWaitingProgressDialogPresenter iSyncWaitingProgressDialogPresenter = new DialogContract.ISyncWaitingProgressDialogPresenter() { // from class: com.samsung.android.support.senl.nt.app.main.common.handoff.HandoffLaunchManager$waitSyncNewNote$presenter$1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.ISyncWaitingProgressDialogPresenter
            public boolean canStopToSendRequestSyncMsg() {
                return HandoffLaunchManager.mNewNoteMetaData == null;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.ISyncWaitingProgressDialogPresenter
            public void cancel() {
                if (HandoffLaunchManager.mNewNoteMetaData != null) {
                    this.this$0.handleMain(null);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.ISyncWaitingProgressDialogPresenter
            /* JADX INFO: renamed from: getUuid, reason: from getter */
            public String get$uuid() {
                return uuid;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.ISyncWaitingProgressDialogPresenter, com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IPresenter
            public void onDismiss() {
                HandoffLaunchManager.mNewNoteMetaData = null;
                HandoffLaunchManager.mSyncWaitingProgressDialog = null;
            }
        };
        FragmentManager supportFragmentManager = appCompatActivity2.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        if (supportFragmentManager.isDestroyed()) {
            return;
        }
        String str = SyncWaitingProgressDialog.TAG;
        Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag(str);
        if (fragmentFindFragmentByTag instanceof SyncWaitingProgressDialog) {
            SyncWaitingProgressDialog syncWaitingProgressDialog = (SyncWaitingProgressDialog) fragmentFindFragmentByTag;
            mSyncWaitingProgressDialog = syncWaitingProgressDialog;
            syncWaitingProgressDialog.setPresenter(iSyncWaitingProgressDialogPresenter);
        } else {
            SyncWaitingProgressDialog syncWaitingProgressDialog2 = new SyncWaitingProgressDialog();
            mSyncWaitingProgressDialog = syncWaitingProgressDialog2;
            syncWaitingProgressDialog2.setPresenter(iSyncWaitingProgressDialogPresenter);
            supportFragmentManager.beginTransaction().add(syncWaitingProgressDialog2, str).commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
        }
        docRepository.get_LiveData(uuid).observe(appCompatActivity2, this);
    }

    public final void cancelTimer() {
        Timer timer = mTimer;
        if (timer != null) {
            Logger.m7104i(TAG, "cancelTimer# " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
            timer.cancel();
            Runnable runnable = this.mTimerEndAction;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public final void createTimer() {
        cancelTimer();
        Timer timer = new Timer();
        mTimer = timer;
        timer.schedule(new TimerTask() { // from class: com.samsung.android.support.senl.nt.app.main.common.handoff.HandoffLaunchManager.createTimer.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Runnable runnable = HandoffLaunchManager.this.mTimerStartAction;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }, 2000L);
        Timer timer2 = mTimer;
        if (timer2 != null) {
            timer2.schedule(new TimerTask() { // from class: com.samsung.android.support.senl.nt.app.main.common.handoff.HandoffLaunchManager.createTimer.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Runnable runnable = HandoffLaunchManager.this.mTimerFailAction;
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            }, 30000L);
        }
    }

    @Nullable
    public final MainListDocumentData getDocumentData(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (this.activityRef.get() == null) {
            return null;
        }
        AppCompatActivity appCompatActivity = this.activityRef.get();
        Intrinsics.checkNotNull(appCompatActivity);
        return NotesDataRepositoryFactory.newInstance(appCompatActivity.getApplicationContext()).createMainListDocumentDataRepository().get(uuid);
    }

    @Nullable
    public final JSONObject getNewNoteMetaData() {
        return mNewNoteMetaData;
    }

    @NotNull
    public final Companion.COMPOSER_METADATA_HANDLE_RESULT handleComposer(@Nullable JSONObject metaData) throws JSONException {
        if (this.activityRef.get() == null) {
            return Companion.COMPOSER_METADATA_HANDLE_RESULT.FAILED;
        }
        AppCompatActivity appCompatActivity = this.activityRef.get();
        Intrinsics.checkNotNull(appCompatActivity);
        AppCompatActivity appCompatActivity2 = appCompatActivity;
        if (metaData != null) {
            HandoffUtils.Companion companion = HandoffUtils.INSTANCE;
            HandoffUtils companion2 = companion.getInstance();
            String string = metaData.getString(HandoffConstant.KEY_ACTIVITY_TYPE);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            if (companion2.isComposerData(string)) {
                MainLogger.m7258i(TAG, "handleComposer#");
                String string2 = metaData.getString("sdoc_uuid");
                MainListDocumentDataRepository mainListDocumentDataRepositoryCreateMainListDocumentDataRepository = NotesDataRepositoryFactory.newInstance(appCompatActivity2.getApplicationContext()).createMainListDocumentDataRepository();
                MainListDocumentData mainListDocumentData = mainListDocumentDataRepositoryCreateMainListDocumentDataRepository.get(string2);
                if (mainListDocumentData == null) {
                    if (isNotAvailableToSync(metaData)) {
                        return Companion.COMPOSER_METADATA_HANDLE_RESULT.FAILED;
                    }
                    C12936a.m13839c().getClass();
                    if (C12936a.m13842g()) {
                        if (RequestToSyncManager.INSTANCE.isWiFiSyncOnlyAndNotWiFiConnected(appCompatActivity2.getApplicationContext())) {
                            companion.getInstance().showWiFiSyncOnlyAndNotWiFiConnected(new WeakReference<>(appCompatActivity2), new DialogInterfaceOnClickListenerC0174a(this, metaData, 2), new DialogInterfaceOnDismissListenerC8211a(this, metaData, 0));
                            return Companion.COMPOSER_METADATA_HANDLE_RESULT.SUCCESS;
                        }
                        Intrinsics.checkNotNull(mainListDocumentDataRepositoryCreateMainListDocumentDataRepository);
                        Intrinsics.checkNotNull(string2);
                        waitSyncNewNote(metaData, mainListDocumentDataRepositoryCreateMainListDocumentDataRepository, string2);
                        return Companion.COMPOSER_METADATA_HANDLE_RESULT.SUCCESS;
                    }
                    Logger.m7100d(TAG, "handleComposer# no sync permission");
                    C12936a.m13839c().getClass();
                    ArrayList arrayListM13840e = C12936a.m13840e();
                    Intrinsics.checkNotNull(arrayListM13840e);
                    String[] strArr = (String[]) arrayListM13840e.toArray(new String[0]);
                    cancelTimer();
                    PermissionHelper.requestPermissions(appCompatActivity2, SYNC_PERMISSION_REQUEST_CODE, (String[]) Arrays.copyOf(strArr, strArr.length));
                    mNewNoteMetaData = metaData;
                    return Companion.COMPOSER_METADATA_HANDLE_RESULT.SUCCESS;
                }
                if (mainListDocumentData.getIsDeleted() != 0) {
                    MainLogger.m7258i(TAG, "handleComposer# entry is deleted");
                    return Companion.COMPOSER_METADATA_HANDLE_RESULT.FAILED;
                }
                Intent intentCreateComposerIntent = createComposerIntent(mainListDocumentData, metaData);
                ComposerManager.Companion companion3 = ComposerManager.INSTANCE;
                boolean zHasComposerInSameTask = companion3.getInstance().hasComposerInSameTask(appCompatActivity2, string2);
                AbstractC6670b.m4739D("handleComposer# exist: ", TAG, zHasComposerInSameTask);
                if (zHasComposerInSameTask) {
                    cancelTimer();
                    ComposerManager companion4 = companion3.getInstance();
                    Intrinsics.checkNotNull(string2);
                    Activity composerActivity = companion4.getComposerActivity(string2);
                    Intrinsics.checkNotNull(composerActivity);
                    composerActivity.getIntent().putExtra(CoHandoffConstant.ARG_HANDOFF_DATA_STRING, metaData.toString());
                    if (this.handleActionWithBaseActivityFinish) {
                        appCompatActivity2.finish();
                    }
                    companion.getInstance().requestSyncHandoffData();
                    return Companion.COMPOSER_METADATA_HANDLE_RESULT.SUCCESS;
                }
                closeAllActivityInThisTask();
                if (mainListDocumentData.getIsLock() == 5) {
                    createLockManager(intentCreateComposerIntent);
                    ILockManager iLockManager = mLockManager;
                    if (iLockManager != null) {
                        iLockManager.verify(appCompatActivity2, 109, null, string2);
                    }
                    return Companion.COMPOSER_METADATA_HANDLE_RESULT.LOCK_REQUESTED;
                }
                appCompatActivity2.startActivity(intentCreateComposerIntent);
                if (this.handleActionWithBaseActivityFinish) {
                    appCompatActivity2.finish();
                }
                companion.getInstance().requestSyncHandoffData();
                return Companion.COMPOSER_METADATA_HANDLE_RESULT.SUCCESS;
            }
        }
        return Companion.COMPOSER_METADATA_HANDLE_RESULT.FAILED;
    }

    public final void handleHandoffData(@Nullable String handoffData, @Nullable Runnable endAction) {
        if (TextUtils.isEmpty(handoffData)) {
            return;
        }
        String strValueOf = String.valueOf(handoffData);
        AppCompatActivity appCompatActivity = this.activityRef.get();
        if (appCompatActivity != null) {
            appCompatActivity.runOnUiThread(new RunnableC0218a(strValueOf, this, appCompatActivity, endAction, 8));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handleMain(@Nullable JSONObject metaData) {
        Intent intentCreateMainIntent;
        if (this.activityRef.get() == null) {
            return;
        }
        cancelTimer();
        AppCompatActivity appCompatActivity = this.activityRef.get();
        Intrinsics.checkNotNull(appCompatActivity);
        AppCompatActivity appCompatActivity2 = appCompatActivity;
        MainHandoffData handoffData = metaData == null ? null : MainHandoffManager.INSTANCE.getInstance().getHandoffData(metaData);
        closeAllActivityInThisTask();
        if (handoffData == null || !HandoffUtils.INSTANCE.getInstance().isMainData(handoffData.getMActivityType())) {
            intentCreateMainIntent = createMainIntent("Main", null);
        } else {
            MainHandoffManager companion = MainHandoffManager.INSTANCE.getInstance();
            String actionType = handoffData.getMActionType();
            Intrinsics.checkNotNull(actionType);
            if (companion.canStartMain(actionType, handoffData)) {
                intentCreateMainIntent = createMainIntent(handoffData.getMActivityType(), handoffData);
            }
        }
        appCompatActivity2.startActivity(intentCreateMainIntent);
        if (this.handleActionWithBaseActivityFinish) {
            appCompatActivity2.finish();
        }
    }

    public final void hideSyncDialog() {
        Fragment fragmentFindFragmentByTag;
        if (mSyncWaitingProgressDialog != null) {
            Logger.m7104i(TAG, "hideSyncDialog# ");
            releaseNewNoteObserver();
            AppCompatActivity appCompatActivity = this.activityRef.get();
            FragmentManager supportFragmentManager = appCompatActivity != null ? appCompatActivity.getSupportFragmentManager() : null;
            if (supportFragmentManager != null && (fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag(SyncWaitingProgressDialog.TAG)) != null) {
                supportFragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commitAllowingStateLoss();
            }
        }
        mSyncWaitingProgressDialog = null;
    }

    public final boolean onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        ILockManager iLockManager;
        return (this.activityRef.get() == null || (iLockManager = mLockManager) == null || !iLockManager.onActivityResult(this.activityRef.get(), requestCode, resultCode, data)) ? false : true;
    }

    public final void onRequestPermissionsResult(int requestCode) {
        if (requestCode == 9999) {
            try {
                handleComposer(mNewNoteMetaData);
            } catch (JSONException e) {
                Logger.m7101e(TAG, "onRequestPermissionsResult# " + e.getMessage());
            }
        }
    }

    public final void setTimerEndAction(@Nullable Runnable timerEndAction) {
        this.mTimerEndAction = timerEndAction;
    }

    public final void setTimerFailAction(@Nullable Runnable timerFailAction) {
        this.mTimerFailAction = timerFailAction;
    }

    public final void setTimerStartAction(@Nullable Runnable timerStartAction) {
        this.mTimerStartAction = timerStartAction;
    }

    @Override // androidx.lifecycle.Observer
    public void onChanged(@Nullable MainListDocumentData value) {
        if (value == null) {
            return;
        }
        JSONObject jSONObject = mNewNoteMetaData;
        if (jSONObject != null) {
            Logger.m7104i(TAG, "observer#onChanged# new");
            try {
                handleComposer(jSONObject);
            } catch (JSONException e) {
                Logger.m7102e(TAG, "JSON Err#", e);
                handleMain(null);
            }
            hideSyncDialog();
        }
        mNewNoteMetaData = null;
    }

    public /* synthetic */ HandoffLaunchManager(WeakReference weakReference, boolean z, Contract contract, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference, z, (i & 4) != 0 ? null : contract);
    }
}
