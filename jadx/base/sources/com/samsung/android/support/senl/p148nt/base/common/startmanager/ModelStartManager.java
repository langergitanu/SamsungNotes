package com.samsung.android.support.senl.p148nt.base.common.startmanager;

import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.access.document.DocumentAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/startmanager/ModelStartManager;", "", "<init>", "()V", "mMask", "", "mOnCloseListener", "Lcom/samsung/android/support/senl/nt/base/common/startmanager/ModelStartManager$OnCloseListener;", "initStatus", "", "type", "", ImageConst.PARAM_MODE_WALLPAPER_MASK, "updateMask", "taskMask", "isRunning", "", "()Z", "closeAll", "onCloseListener", "OnCloseListener", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ModelStartManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int MASK_CONVERT_SERVICE = 2;
    private static final int MASK_DELETE_DATA = 4;
    private static final int MASK_DOCUMENT_SERVICE = 1;
    private static final int MASK_DUPLICATE_NOTES = 512;
    private static final int MASK_IMPORT_BY_NOTEPICKER = 256;
    private static final int MASK_IMPORT_BY_SETTING = 64;
    private static final int MASK_IMPORT_CLOUD_DATA_BY_SETTING = 128;
    private static final int MASK_RESTORE_DATA = 8;
    private static final int MASK_RESTORE_TASK = 16;
    private static final int MASK_TRIGGER_ACTIVITY = 32;

    @NotNull
    private static final String TAG = "ModelStartManager";
    private static long sFinalBlockTime;

    @Nullable
    private static ModelStartManager sInstance;
    private int mMask;

    @Nullable
    private OnCloseListener mOnCloseListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001d¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/startmanager/ModelStartManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "MASK_DOCUMENT_SERVICE", "", "MASK_CONVERT_SERVICE", "MASK_DELETE_DATA", "MASK_RESTORE_DATA", "MASK_RESTORE_TASK", "MASK_TRIGGER_ACTIVITY", "MASK_IMPORT_BY_SETTING", "MASK_IMPORT_CLOUD_DATA_BY_SETTING", "MASK_IMPORT_BY_NOTEPICKER", "MASK_DUPLICATE_NOTES", "sInstance", "Lcom/samsung/android/support/senl/nt/base/common/startmanager/ModelStartManager;", "sFinalBlockTime", "", "instance", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/startmanager/ModelStartManager;", "setFinalBlockTime", "", "finalBlockTime", "isBlocked", "", "()Z", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized ModelStartManager getInstance() {
            ModelStartManager modelStartManager;
            try {
                if (ModelStartManager.sInstance == null) {
                    ModelStartManager.sInstance = new ModelStartManager(null);
                }
                modelStartManager = ModelStartManager.sInstance;
                Intrinsics.checkNotNull(modelStartManager);
            } catch (Throwable th) {
                throw th;
            }
            return modelStartManager;
        }

        public final boolean isBlocked() {
            if (System.currentTimeMillis() >= ModelStartManager.sFinalBlockTime) {
                return false;
            }
            Logger.m8703w(ModelStartManager.TAG, "isBlocked# true = blockTime = " + ModelStartManager.sFinalBlockTime);
            return true;
        }

        public final void setFinalBlockTime(long finalBlockTime) {
            ModelStartManager.sFinalBlockTime = finalBlockTime;
            Logger.m8702i(ModelStartManager.TAG, "setFinalBlockTime# blockTime = " + finalBlockTime);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/startmanager/ModelStartManager$OnCloseListener;", "", "onClosed", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnCloseListener {
        void onClosed();
    }

    public /* synthetic */ ModelStartManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void initStatus(@TaskState.Type String type, final int mask) {
        TaskState.Companion companion = TaskState.INSTANCE;
        companion.getInstance().addListener(type, new TaskState.TaskStateListener() { // from class: com.samsung.android.support.senl.nt.base.common.startmanager.ModelStartManager.initStatus.1
            @Override // com.samsung.android.support.senl.nt.base.common.task.TaskState.TaskStateListener
            public void onTaskStateChanged(String taskType, boolean isRunning) {
                ModelStartManager.this.updateMask(mask, isRunning);
            }
        });
        updateMask(mask, companion.getInstance().isRunning(type));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void updateMask(int taskMask, boolean isRunning) {
        int i;
        try {
            if (isRunning) {
                i = taskMask | this.mMask;
            } else {
                i = (~taskMask) & this.mMask;
            }
            this.mMask = i;
            Logger.m8702i(TAG, "updateMask, mask: " + i);
            if (!isRunning()) {
                OnCloseListener onCloseListener = this.mOnCloseListener;
                if (onCloseListener != null) {
                    onCloseListener.onClosed();
                }
                this.mOnCloseListener = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void closeAll(@NotNull OnCloseListener onCloseListener) {
        Intrinsics.checkNotNullParameter(onCloseListener, "onCloseListener");
        synchronized (this) {
            Logger.m8702i(TAG, "closeAll#, mask: " + this.mMask);
            Unit unit = Unit.INSTANCE;
        }
        if (!isRunning()) {
            onCloseListener.onClosed();
            return;
        }
        this.mOnCloseListener = onCloseListener;
        if (DocumentAccessHandler.getContract() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        DocumentAccessHandler.DocumentAccessContract contract = DocumentAccessHandler.getContract();
        if (contract == null) {
            return;
        }
        contract.cancelAllConvertTasks();
        contract.cancelImportBySetting();
        contract.cancelImportCloudDataBySetting();
    }

    public final synchronized boolean isRunning() {
        return this.mMask != 0;
    }

    private ModelStartManager() {
        initStatus("DOC_SERVICE", 1);
        initStatus("CONVERT", 2);
        initStatus("DELETE_DATA", 4);
        initStatus("RESTORE_DATA", 8);
        initStatus("RESTORE_TASK", 16);
        initStatus("TRIGGER", 32);
        initStatus("IMPORT_BY_SETTING", 64);
        initStatus("IMPORT_CLOUD_DATA_BY_SETTING", 128);
        initStatus("IMPORT_BY_NOTEPICKER", 256);
        initStatus("DUPLICATE_NOTES", 512);
    }
}
