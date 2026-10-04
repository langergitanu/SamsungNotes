package com.samsung.android.support.senl.p148nt.app.addons;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.p135db.AbstractC6736e;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AddonsConstants;
import com.samsung.android.support.senl.p148nt.app.addons.AddonsCopyController;
import com.samsung.android.support.senl.p148nt.app.addons.AddonsStubManager;
import com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.TipCardUtil;
import com.samsung.android.support.senl.p148nt.app.converter.ConverterDialogManager;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.framework.provider.ShareFileProvider;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.utils.NotesDocumentFileUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.converter.ConvertTaskManager;
import com.samsung.android.support.senl.p148nt.model.converter.task.ConvertTaskFactory;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.ConvertInfo;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCacheUtils;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 ?2\u00020\u0001:\u0002>?B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\b\b\u0001\u0010\u001d\u001a\u00020\u001eJ\"\u0010\"\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0001\u0010\u001d\u001a\u00020\u001eH\u0002J.\u0010#\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\b\b\u0001\u0010\u001d\u001a\u00020\u001eH\u0002J,\u0010$\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\b\b\u0001\u0010\u001d\u001a\u00020\u001eH\u0002J \u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010)J\b\u0010*\u001a\u00020\u0018H\u0002J$\u0010+\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010-\u001a\u00020 H\u0002J\u0014\u0010.\u001a\u00060/R\u00020\u00002\u0006\u0010-\u001a\u00020 H\u0002J\u0006\u00101\u001a\u00020\u0018J\u000e\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u0011J\u0010\u00104\u001a\u00020\u00182\b\u00105\u001a\u0004\u0018\u00010\u0011J\u0010\u00106\u001a\u00020\u00182\b\u00103\u001a\u0004\u0018\u00010\u0011J\u0010\u00107\u001a\u00020\u00182\b\u00105\u001a\u0004\u0018\u00010\u0011J\b\u0010:\u001a\u00020\u0018H\u0002J\u0006\u0010<\u001a\u00020 J\u0006\u0010=\u001a\u00020\u0018R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010!R\u0011\u00100\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b0\u0010!R\u0014\u00108\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u0010!R\u0014\u00109\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010!R\u0014\u0010;\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010!¨\u0006@"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/addons/AddonsHandler;", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroidx/appcompat/app/AppCompatActivity;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/app/addons/IAddonsListener;", "<init>", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/samsung/android/support/senl/nt/app/addons/IAddonsListener;)V", "mAppContext", "Landroid/content/Context;", "mActivity", "mListener", "mProgressController", "Lcom/samsung/android/support/senl/nt/app/addons/AddonsProgressController;", "mCopyController", "Lcom/samsung/android/support/senl/nt/app/addons/AddonsCopyController;", "mBundle", "Landroid/os/Bundle;", "mConverterDialogManager", "Lcom/samsung/android/support/senl/nt/app/converter/ConverterDialogManager;", "mStubManager", "Lcom/samsung/android/support/senl/cm/base/framework/support/ObjectBuilder;", "Lcom/samsung/android/support/senl/nt/app/addons/stub/IStubManager;", "startAddonComposer", "", "uuid", "", "filePath", "highLightText", "mode", "", "isAddonsAvailable", "", "()Z", "unlockOrConvert", "connectToAddons", "saveDataToBundle", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "notifyTaskCanceled", MarkdownConverter.PREFIX_NAME, "sdocUuid", "openOldComposer", "createConvertCallback", "Lcom/samsung/android/support/senl/nt/app/addons/AddonsHandler$ConvertCallback;", "isProgressDialogShowing", "onDestroy", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onRestoreInstanceState", "savedInstanceState", "onViewChangeSaveInstanceState", "onViewChangeRestoreInstanceState", "isSupportedAddonsUpdate", "isNeedSamsungNotesUpdate", "showSamsungNotesUpdateDialog", "isAddonExist", "onBackPressed", "onResume", "ConvertCallback", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AddonsHandler {

    @NotNull
    private static final String TAG = "AddonsHandler";

    @Nullable
    private AppCompatActivity mActivity;

    @NotNull
    private final Context mAppContext;

    @Nullable
    private Bundle mBundle;

    @Nullable
    private ConverterDialogManager mConverterDialogManager;

    @NotNull
    private final AddonsCopyController mCopyController;

    @Nullable
    private IAddonsListener mListener;

    @NotNull
    private final AddonsProgressController mProgressController;

    @NotNull
    private final ObjectBuilder<IStubManager> mStubManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\u0006\u0010\u0016\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/addons/AddonsHandler$ConvertCallback;", "Lcom/samsung/android/support/senl/nt/model/converter/task/ConvertTaskFactory$IConvertTaskFactoryCallback;", "mOpenOldComposer", "", "dialogManager", "Lcom/samsung/android/support/senl/nt/app/converter/ConverterDialogManager;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/addons/AddonsHandler;ZLcom/samsung/android/support/senl/nt/app/converter/ConverterDialogManager;)V", "mDialogManager", "mIsCancelled", "onPreFailed", "", "msg", "Lcom/samsung/android/support/senl/nt/model/converter/task/ConvertTaskFactory$IConvertTaskFactoryCallback$ErrorMsg;", "onCreated", "onSuccess", "info", "Lcom/samsung/android/support/senl/nt/model/converter/task/common/IConvertInfo;", "result", "Lcom/samsung/android/support/senl/nt/model/converter/task/common/IConvertResult;", "onFailed", "onFinish", "onCancel", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class ConvertCallback implements ConvertTaskFactory.IConvertTaskFactoryCallback {

        @Nullable
        private ConverterDialogManager mDialogManager;
        private boolean mIsCancelled;
        private final boolean mOpenOldComposer;
        final /* synthetic */ AddonsHandler this$0;

        public ConvertCallback(AddonsHandler addonsHandler, @NotNull boolean z, ConverterDialogManager dialogManager) {
            Intrinsics.checkNotNullParameter(dialogManager, "dialogManager");
            this.this$0 = addonsHandler;
            this.mOpenOldComposer = z;
            this.mDialogManager = dialogManager;
            if (dialogManager != null) {
                dialogManager.setListener(new ConverterDialogManager.IDialogListener() { // from class: com.samsung.android.support.senl.nt.app.addons.AddonsHandler.ConvertCallback.1
                    @Override // com.samsung.android.support.senl.nt.app.converter.ConverterDialogManager.IDialogListener
                    public void onCancel() {
                        ConvertCallback.this.onCancel();
                    }

                    @Override // com.samsung.android.support.senl.nt.app.converter.ConverterDialogManager.IDialogListener
                    public void requestConvert(String filePath, String password) {
                        Intrinsics.checkNotNullParameter(filePath, "filePath");
                        Intrinsics.checkNotNullParameter(password, "password");
                    }
                });
            }
            this.mIsCancelled = false;
        }

        private final void onFinish() {
            ConvertTaskManager.disconnect();
            ConverterDialogManager converterDialogManager = this.mDialogManager;
            if (converterDialogManager != null) {
                Intrinsics.checkNotNull(converterDialogManager);
                converterDialogManager.setListener(null);
                this.mDialogManager = null;
            }
            this.this$0.saveDataToBundle("", "", "", 1);
        }

        public final void onCancel() {
            MainLogger.m7259w(AddonsHandler.TAG, "ConvertCallback, onCancel");
            this.mIsCancelled = true;
        }

        @Override // com.samsung.android.support.senl.nt.model.converter.task.ConvertTaskFactory.IConvertTaskFactoryCallback
        public void onCreated() {
            ConverterDialogManager converterDialogManager = this.mDialogManager;
            if (converterDialogManager != null) {
                converterDialogManager.showConvertProgressDialog();
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.model.converter.task.IConvertTaskCallback
        public void onFailed(@NotNull IConvertInfo info, @NotNull IConvertResult result) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(result, "result");
            MainLogger.m7254d(AddonsHandler.TAG, "ConvertCallback, onFailed");
            ConverterDialogManager converterDialogManager = this.mDialogManager;
            if (converterDialogManager != null) {
                converterDialogManager.dismiss();
            }
            onFinish();
            this.this$0.notifyTaskCanceled();
        }

        @Override // com.samsung.android.support.senl.nt.model.converter.task.ConvertTaskFactory.IConvertTaskFactoryCallback
        public void onPreFailed(@NotNull ConvertTaskFactory.IConvertTaskFactoryCallback.ErrorMsg msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            MainLogger.m7255e(AddonsHandler.TAG, "ConvertCallback, onPreFailed: " + msg.getStatus());
            onFinish();
        }

        @Override // com.samsung.android.support.senl.p148nt.model.converter.task.IConvertTaskCallback
        public void onSuccess(@NotNull IConvertInfo info, @NotNull IConvertResult result) {
            IAddonsListener iAddonsListener;
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(result, "result");
            AbstractC8014b.m7210l("ConvertCallback, onSuccess, isCancelled: ", AddonsHandler.TAG, this.mIsCancelled);
            ConverterDialogManager converterDialogManager = this.mDialogManager;
            if (converterDialogManager != null) {
                converterDialogManager.dismiss();
            }
            if (this.this$0.mListener != null && !result.hasMultipleUuids()) {
                if (this.mIsCancelled) {
                    this.this$0.notifyTaskCanceled();
                } else {
                    String uuid = result.getUuid();
                    List<String> pathList = result.getPathList();
                    List<String> list = pathList;
                    if (list != null && !list.isEmpty() && (iAddonsListener = this.this$0.mListener) != null) {
                        iAddonsListener.onRequestOpenNote(this.mOpenOldComposer, info.getUuid(), uuid, pathList.get(0));
                    }
                }
            }
            onFinish();
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.addons.AddonsHandler$connectToAddons$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, m13886d2 = {"com/samsung/android/support/senl/nt/app/addons/AddonsHandler$connectToAddons$1", "Lcom/samsung/android/support/senl/nt/app/addons/AddonsCopyController$IAddonsCaller;", "onAddonsCalled", "", "srcFile", "Ljava/io/File;", "dstFile", "onFailed", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class C80111 implements AddonsCopyController.IAddonsCaller {
        final /* synthetic */ String $highLightText;
        final /* synthetic */ int $mode;
        final /* synthetic */ String $uuid;

        public C80111(String str, int i, String str2) {
            this.$uuid = str;
            this.$mode = i;
            this.$highLightText = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onAddonsCalled$lambda$0(AddonsHandler addonsHandler) {
            ToastHandler.show(addonsHandler.mAppContext, C8003R.string.open_fail_error_message_in_upsm, 1);
        }

        @Override // com.samsung.android.support.senl.nt.app.addons.AddonsCopyController.IAddonsCaller
        public void onAddonsCalled(File srcFile, File dstFile) {
            Intrinsics.checkNotNullParameter(srcFile, "srcFile");
            Intrinsics.checkNotNullParameter(dstFile, "dstFile");
            if (!AddonsSdocHelper.unlockSdoc(AddonsHandler.this.mAppContext, dstFile.getPath())) {
                MainLogger.m7258i(AddonsHandler.TAG, "onAddonsCalled, fail to unlock");
                AddonsHandler.this.notifyTaskCanceled();
                return;
            }
            try {
                NotesDocumentEntity notesDocumentEntity = NotesDataRepositoryFactory.newInstance(AddonsHandler.this.mAppContext).createDocumentDataRepository().get(this.$uuid);
                Intrinsics.checkNotNull(notesDocumentEntity);
                Intent intentBuild = new AddonsComposerBuilder(notesDocumentEntity, this.$mode).setData(FileProvider.getUriForFile(AddonsHandler.this.mAppContext, ShareFileProvider.INSTANCE.getAUTHORITY(), dstFile)).setUuid(this.$uuid).setPaths(srcFile.getAbsolutePath(), dstFile.getAbsolutePath()).setHighLightText(this.$highLightText).setHashTagData(AbstractC6736e.m4831a(this.$uuid)).setConvertingEnabled(true).setLockInfo(LockUtils.isLockedSdocType(notesDocumentEntity.getIsLock())).setCategoryInfo(FolderManager.getInstance().getCategoryEntity(notesDocumentEntity.getCategoryUuid())).build();
                if (intentBuild != null) {
                    NotesDataRepositoryFactory.newInstance(AddonsHandler.this.mAppContext).createDocumentDataRepository().setOpenedTime(this.$uuid);
                    AppCompatActivity appCompatActivity = AddonsHandler.this.mActivity;
                    if (appCompatActivity != null) {
                        appCompatActivity.startActivityForResult(intentBuild, 101);
                    }
                }
            } catch (ActivityNotFoundException e) {
                AbstractC6670b.m4738C("onAddonsCalled, ActivityNotFoundException occurs : ", e.getMessage(), AddonsHandler.TAG);
                if (SettingsCompat.INSTANCE.getInstance().isUPSM(AddonsHandler.this.mAppContext)) {
                    new Handler(Looper.getMainLooper()).post(new RunnableC7599e(AddonsHandler.this, 12));
                }
            } catch (Exception e2) {
                AbstractC6670b.m4738C("onAddonsCalled, exception occurs : ", e2.getMessage(), AddonsHandler.TAG);
            }
        }

        @Override // com.samsung.android.support.senl.nt.app.addons.AddonsCopyController.IAddonsCaller
        public void onFailed() {
            AddonsHandler.this.notifyTaskCanceled();
        }
    }

    public AddonsHandler(@NotNull final AppCompatActivity activity, @NotNull final IAddonsListener listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Context applicationContext = activity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.mAppContext = applicationContext;
        this.mBundle = new Bundle();
        this.mActivity = activity;
        this.mListener = listener;
        AddonsProgressController addonsProgressController = new AddonsProgressController(activity);
        this.mProgressController = addonsProgressController;
        this.mCopyController = new AddonsCopyController(applicationContext, addonsProgressController);
        ObjectBuilder<IStubManager> objectBuilder = new ObjectBuilder<IStubManager>() { // from class: com.samsung.android.support.senl.nt.app.addons.AddonsHandler.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
            public IStubManager build() {
                if (SystemPropertiesCompat.INSTANCE.getInstance().isNationalDisasterNet()) {
                    return new NationalDisasterNetStubManager(activity);
                }
                AppCompatActivity appCompatActivity = activity;
                final AddonsHandler addonsHandler = this;
                final IAddonsListener iAddonsListener = listener;
                return new AddonsStubManager(appCompatActivity, new AddonsStubManager.IStubPresenter() { // from class: com.samsung.android.support.senl.nt.app.addons.AddonsHandler$1$build$1
                    private final void openNote() {
                        Bundle bundle = addonsHandler.mBundle;
                        Intrinsics.checkNotNull(bundle);
                        String string = bundle.getString(AddonsConstants.ADDONS_DOCUMENT_UUID, "");
                        Bundle bundle2 = addonsHandler.mBundle;
                        Intrinsics.checkNotNull(bundle2);
                        String string2 = bundle2.getString(AddonsConstants.ADDONS_DOCUMENT_PATH, "");
                        Bundle bundle3 = addonsHandler.mBundle;
                        Intrinsics.checkNotNull(bundle3);
                        String string3 = bundle3.getString("highlighttext", "");
                        Bundle bundle4 = addonsHandler.mBundle;
                        Intrinsics.checkNotNull(bundle4);
                        int i = bundle4.getInt(AddonsConstants.ADDONS_KEY_START_MODE, 1);
                        AddonsHandler addonsHandler2 = addonsHandler;
                        Intrinsics.checkNotNull(string);
                        Intrinsics.checkNotNull(string2);
                        addonsHandler2.startAddonComposer(string, string2, string3, i);
                    }

                    @Override // com.samsung.android.support.senl.nt.app.addons.AddonsStubManager.IStubPresenter
                    public void convertNote() {
                        if (addonsHandler.mBundle == null) {
                            return;
                        }
                        if (AddonsSdocHelper.isLockedDocument(addonsHandler.mAppContext, addonsHandler.mBundle)) {
                            AddonsSdocHelper.requestUnlock(addonsHandler.mBundle, 1, iAddonsListener.getLockHelper());
                            return;
                        }
                        Bundle bundle = addonsHandler.mBundle;
                        Intrinsics.checkNotNull(bundle);
                        String string = bundle.getString(AddonsConstants.ADDONS_DOCUMENT_UUID, "");
                        Bundle bundle2 = addonsHandler.mBundle;
                        Intrinsics.checkNotNull(bundle2);
                        addonsHandler.convert(string, bundle2.getString(AddonsConstants.ADDONS_DOCUMENT_PATH, ""), false);
                    }

                    @Override // com.samsung.android.support.senl.nt.app.addons.AddonsStubManager.IStubPresenter
                    public void onStubUpdateTaskFinished(boolean needOpenSelectedNote) {
                        if (needOpenSelectedNote) {
                            openNote();
                            return;
                        }
                        IAddonsListener iAddonsListener2 = addonsHandler.mListener;
                        if (iAddonsListener2 != null) {
                            iAddonsListener2.onStubUpdateTaskFinished();
                        }
                    }
                });
            }
        };
        this.mStubManager = objectBuilder;
        IStubManager objectBuilder2 = objectBuilder.getInstance();
        if (objectBuilder2 != null) {
            objectBuilder2.onRestoreDialogListener();
        }
    }

    private final void connectToAddons(String uuid, String filePath, String highLightText, @AddonsConstants.StartMode int mode) {
        this.mCopyController.copySdocToExternalDir(uuid, filePath, new C80111(uuid, mode, highLightText));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void convert(String sdocUuid, String filePath, boolean openOldComposer) {
        String strCreateSavedPathWithDir;
        MainLogger.m7254d(TAG, "convert, sdocUuid : " + sdocUuid + ", openOldComposer: " + openOldComposer);
        if (openOldComposer) {
            String convertedCacheFolderPath = DocumentCacheUtils.getConvertedCacheFolderPath(this.mActivity);
            Intrinsics.checkNotNullExpressionValue(convertedCacheFolderPath, "getConvertedCacheFolderPath(...)");
            if (convertedCacheFolderPath.length() == 0) {
                MainLogger.m7255e(TAG, "convert, failed to make temp dir");
                return;
            }
            strCreateSavedPathWithDir = NotesDocumentFileUtils.createSavedPathWithDir(this.mActivity, convertedCacheFolderPath, ".sdocx");
        } else {
            TipCardUtil.countUpConvertTryCount(MarkdownConverter.PREFIX_NAME);
            strCreateSavedPathWithDir = "";
        }
        ConvertTaskManager.connect(this.mAppContext);
        ConvertTaskManager.getInstance().put(ConvertTaskFactory.createTaskWithValidCheck(this.mAppContext, new ConvertInfo(filePath, hashCode()).setUuid(sdocUuid).setIsImported(false).setDstPath(strCreateSavedPathWithDir), null, createConvertCallback(openOldComposer)));
    }

    private final ConvertCallback createConvertCallback(boolean openOldComposer) {
        if (this.mConverterDialogManager == null) {
            this.mConverterDialogManager = new ConverterDialogManager(this.mActivity, hashCode());
        }
        ConverterDialogManager converterDialogManager = this.mConverterDialogManager;
        Intrinsics.checkNotNull(converterDialogManager);
        return new ConvertCallback(this, openOldComposer, converterDialogManager);
    }

    private final boolean isAddonExist() {
        IStubManager objectBuilder = this.mStubManager.getInstance();
        if (objectBuilder != null) {
            return objectBuilder.isAddonExist();
        }
        return false;
    }

    private final boolean isAddonsAvailable() {
        return isAddonExist() && isSupportedAddonsUpdate();
    }

    private final boolean isNeedSamsungNotesUpdate() {
        IStubManager objectBuilder = this.mStubManager.getInstance();
        if (objectBuilder != null) {
            return objectBuilder.isNeedSamsungNotesUpdate();
        }
        return false;
    }

    private final boolean isSupportedAddonsUpdate() {
        IStubManager objectBuilder = this.mStubManager.getInstance();
        if (objectBuilder != null) {
            return objectBuilder.isSupportedAddonsUpdate();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyTaskCanceled() {
        IAddonsListener iAddonsListener = this.mListener;
        if (iAddonsListener != null) {
            iAddonsListener.onTaskCanceled();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveDataToBundle(String uuid, String filePath, String highLightText, @AddonsConstants.StartMode int mode) {
        Bundle bundle = this.mBundle;
        if (bundle != null) {
            bundle.putString(AddonsConstants.ADDONS_DOCUMENT_UUID, uuid);
            bundle.putString(AddonsConstants.ADDONS_DOCUMENT_PATH, filePath);
            bundle.putString("highlighttext", highLightText);
            bundle.putInt(AddonsConstants.ADDONS_KEY_START_MODE, mode);
        }
    }

    private final void showSamsungNotesUpdateDialog() {
        IStubManager objectBuilder = this.mStubManager.getInstance();
        if (objectBuilder != null) {
            objectBuilder.showSamsungNotesUpdateDialog();
        }
    }

    private final void unlockOrConvert(String uuid, String filePath, @AddonsConstants.StartMode int mode) {
        if (!AddonsSdocHelper.isLockedDocument(this.mAppContext, this.mBundle)) {
            convert(uuid, filePath, mode == 4);
            return;
        }
        Bundle bundle = this.mBundle;
        IAddonsListener iAddonsListener = this.mListener;
        AddonsSdocHelper.requestUnlock(bundle, 2, iAddonsListener != null ? iAddonsListener.getLockHelper() : null);
    }

    public final boolean isProgressDialogShowing() {
        ConverterDialogManager converterDialogManager = this.mConverterDialogManager;
        if (converterDialogManager != null) {
            return converterDialogManager.isProgressDialogShowing();
        }
        return false;
    }

    public final boolean onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        MainLogger.m7254d(TAG, "onActivityResult# requestCode : " + requestCode + ", data : " + (data == null ? "null" : "exist"));
        IStubManager objectBuilder = this.mStubManager.getInstance();
        if (objectBuilder != null) {
            objectBuilder.onActivityResult(requestCode, resultCode, data);
        }
        if (requestCode == 101 && data != null && data.getData() != null) {
            String stringExtra = data.getStringExtra(AddonsConstants.ADDONS_DOCUMENT_UUID);
            String stringExtra2 = data.getStringExtra(AddonsConstants.ADDONS_DOCUMENT_PATH);
            String stringExtra3 = data.getStringExtra(AddonsConstants.ADDONS_COPIED_DOCUMENT_PATH);
            if (resultCode == -1 && data.getIntExtra(AddonsConstants.ADDONS_RESULT_ACTION, 1) == 1) {
                convert(stringExtra, stringExtra2, false);
                z = true;
            }
            this.mCopyController.deleteFile(stringExtra3);
            if (!z) {
                notifyTaskCanceled();
            }
            return true;
        }
        if (requestCode != 901) {
            return false;
        }
        if (resultCode != -1 || data == null) {
            notifyTaskCanceled();
        } else {
            String stringExtra4 = data.getStringExtra("sdoc_uuid");
            String stringExtra5 = data.getStringExtra("doc_path");
            if (stringExtra4 == null || stringExtra4.length() == 0 || stringExtra5 == null || stringExtra5.length() == 0) {
                MainLogger.m7259w(TAG, "invalid data, uuid/path : " + stringExtra4 + " / " + MainLogger.getEncode(stringExtra5));
                notifyTaskCanceled();
            } else if (data.getIntExtra(AddonsConstants.ADDONS_RESULT_ACTION, 1) == 1) {
                convert(stringExtra4, stringExtra5, false);
            } else {
                String stringExtra6 = data.getStringExtra("highlighttext");
                int intExtra = data.getIntExtra(AddonsConstants.ADDONS_KEY_START_MODE, 1);
                if (isAddonsAvailable()) {
                    connectToAddons(stringExtra4, stringExtra5, stringExtra6, intExtra);
                } else {
                    convert(stringExtra4, stringExtra5, intExtra == 4);
                }
            }
        }
        return true;
    }

    public final boolean onBackPressed() {
        return this.mCopyController.onBackPressed();
    }

    public final void onDestroy() {
        IStubManager objectBuilder;
        this.mCopyController.onDestroy();
        this.mProgressController.onDestroy();
        this.mListener = null;
        this.mActivity = null;
        this.mConverterDialogManager = null;
        if (!this.mStubManager.isValid() || (objectBuilder = this.mStubManager.getInstance()) == null) {
            return;
        }
        objectBuilder.release();
    }

    public final void onRestoreInstanceState(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.mBundle = savedInstanceState.getBundle(AddonsConstants.ADDONS_KEY_DATA_BUNDLE);
        }
    }

    public final void onResume() {
        Bundle bundle = this.mBundle;
        String string = bundle != null ? bundle.getString(AddonsConstants.ADDONS_DOCUMENT_UUID) : null;
        Bundle bundle2 = this.mBundle;
        Integer numValueOf = bundle2 != null ? Integer.valueOf(bundle2.getInt(AddonsConstants.ADDONS_KEY_START_MODE, 1)) : null;
        if (string == null || string.length() == 0 || this.mConverterDialogManager != null) {
            return;
        }
        AbstractC0000a.m25v("onResume, uuid: ", string, TAG);
        ConvertCallback convertCallbackCreateConvertCallback = createConvertCallback(numValueOf != null && numValueOf.intValue() == 4);
        if (ConvertTaskManager.getInstance().changeTaskCallback(string, convertCallbackCreateConvertCallback)) {
            convertCallbackCreateConvertCallback.onCreated();
        }
    }

    public final void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putBundle(AddonsConstants.ADDONS_KEY_DATA_BUNDLE, this.mBundle);
    }

    public final void onViewChangeRestoreInstanceState(@Nullable Bundle savedInstanceState) {
        IStubManager objectBuilder = this.mStubManager.getInstance();
        if (objectBuilder != null) {
            objectBuilder.onViewChangeRestoreInstanceState(savedInstanceState);
        }
    }

    public final void onViewChangeSaveInstanceState(@Nullable Bundle outState) {
        IStubManager objectBuilder = this.mStubManager.getInstance();
        if (objectBuilder != null) {
            objectBuilder.onViewChangeSaveInstanceState(outState);
        }
    }

    public final void startAddonComposer(@NotNull String uuid, @NotNull String filePath, @Nullable String highLightText, @AddonsConstants.StartMode int mode) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        MainLogger.m7254d(TAG, "startAddonComposer, forceConvert : " + mode);
        if (this.mActivity == null) {
            MainLogger.m7254d(TAG, "startAddonComposer, mActivity is already destroyed");
            return;
        }
        saveDataToBundle(uuid, filePath, highLightText, mode);
        if (DeviceInfo.isVSTModel()) {
            unlockOrConvert(uuid, filePath, mode);
            return;
        }
        if (!isAddonsAvailable()) {
            unlockOrConvert(uuid, filePath, mode);
            return;
        }
        if (isNeedSamsungNotesUpdate()) {
            showSamsungNotesUpdateDialog();
        } else {
            if (!AddonsSdocHelper.isLockedDocument(this.mAppContext, this.mBundle)) {
                connectToAddons(uuid, filePath, highLightText, mode);
                return;
            }
            Bundle bundle = this.mBundle;
            IAddonsListener iAddonsListener = this.mListener;
            AddonsSdocHelper.requestUnlock(bundle, 2, iAddonsListener != null ? iAddonsListener.getLockHelper() : null);
        }
    }
}
