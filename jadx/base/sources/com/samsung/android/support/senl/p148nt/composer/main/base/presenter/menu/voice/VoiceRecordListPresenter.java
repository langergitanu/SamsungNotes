package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.samsung.android.sdk.composer.voice.AudioFocus;
import com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.senl.p145cm.base.framework.media.AudioManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.RunnableC8928b;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.controller.ViewState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.voice.VoiceMenuItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceViewState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.VoiceDataDeleteConfirmDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.VoiceDataRenameDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.VoiceUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.StorageChecker;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.stt.base.model.SpenVoiceTextDataReader;
import com.samsung.android.support.senl.p148nt.stt.base.model.SpenVoiceTextDataReaderCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 j2\u00020\u0001:\u0001jB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0018J\u0006\u0010%\u001a\u00020\u001eJ\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(J\u001a\u0010)\u001a\u00020\u001e2\b\u0010*\u001a\u0004\u0018\u00010\u001a2\b\u0010+\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010,\u001a\u00020\u001eJ\u000e\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u000202J\u0010\u00103\u001a\u00020/2\u0006\u00101\u001a\u000202H\u0002J\u000e\u00104\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/J\u000e\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u00020/J\b\u00109\u001a\u000207H\u0002J\u0006\u0010:\u001a\u00020\u001eJ\u0006\u0010;\u001a\u00020\u001eJ\u000e\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020(J\u000e\u0010>\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020(J\u0016\u0010?\u001a\u00020\u001e2\u0006\u00101\u001a\u0002022\u0006\u0010@\u001a\u000207J\u0018\u0010A\u001a\u00020/2\u0006\u00101\u001a\u0002022\u0006\u0010B\u001a\u000207H\u0002J\u0018\u0010C\u001a\u0002072\u0006\u00101\u001a\u0002022\u0006\u0010B\u001a\u000207H\u0002J\u000e\u0010D\u001a\u00020\u001e2\u0006\u0010@\u001a\u000207J\u0006\u0010E\u001a\u00020\u001eJ\u0006\u0010F\u001a\u00020(J\b\u0010G\u001a\u00020(H\u0002J\u0010\u0010H\u001a\u00020\u001e2\b\u0010I\u001a\u0004\u0018\u00010\u0013J\u0006\u0010J\u001a\u00020\u001eJ\b\u0010K\u001a\u00020(H\u0002J\u0006\u0010L\u001a\u00020\u001eJ\u000e\u0010M\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020(J\u0006\u0010O\u001a\u00020\u001eJ\u0006\u0010P\u001a\u00020(J\u0006\u0010Q\u001a\u00020\u001eJ\u0006\u0010R\u001a\u00020(J\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00160TJ\u0006\u0010U\u001a\u00020\u001eJ\u0006\u0010V\u001a\u00020/J \u0010W\u001a\u00020\u001e2\b\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010Z\u001a\u0002072\u0006\u0010=\u001a\u00020(J\u0006\u0010[\u001a\u00020\u001eJ\u0006\u0010\\\u001a\u00020\u001eJ\u0010\u0010]\u001a\u00020\u001e2\b\u0010^\u001a\u0004\u0018\u00010_J\u000e\u0010`\u001a\u00020\u001e2\u0006\u0010a\u001a\u000207J\u000e\u0010b\u001a\u00020\u001e2\u0006\u0010c\u001a\u00020/J\u000e\u0010d\u001a\u00020\u001e2\u0006\u0010@\u001a\u000207J\u0006\u0010e\u001a\u00020\u001eJ\u000e\u0010f\u001a\u00020\u001e2\u0006\u0010@\u001a\u000207J\u0006\u0010g\u001a\u00020\u001eJ\u0010\u0010h\u001a\u00020\u001e2\b\u0010i\u001a\u0004\u0018\u00010_R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006k"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordListPresenter;", "", "<init>", "()V", "mComposerModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "mVoiceModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceModel;", "mComposerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "mDialogPresenterManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/DialogPresenterManager;", "mObjectManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/ObjectManager;", "mStorageChecker", "Lcom/samsung/android/support/senl/nt/composer/main/base/util/StorageChecker;", "mViewState", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/controller/ViewState;", "mView", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuContract$IView;", "mItemList", "", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/menu/voice/VoiceMenuItem;", "mParent", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuContract$IParent;", "mActivity", "Landroid/app/Activity;", "mFragment", "Landroidx/fragment/app/Fragment;", "init", "", "composerModel", "composerViewPresenter", "controllerManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;", "dialogPresenterManager", "parent", "clearVoiceDataList", "setDeleteVisible", "visible", "", "onAttachView", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "fragment", "onDetachView", "updatePlayingItemByName", "name", "", "add", "voiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "getSummarizeText", "removeOnlyItem", "remove", "index", "", "getTotalRecordTimeString", "getTotalRecordTime", "hideAudioPlayView", "recordPlayStop", "setPlayPauseViewVoiceObject", "isPlay", "setPlayPauseView", "setUpdateRecordPlayTime", "position", "getCurrentTime", "sec", "getCurrentPosition", "setUpdatePlayTime", "setRecordingTime", "startNewRecordingByMediaEvent", "isEditMode", "setView", "view", "startNewRecording", "checkVoiceState", "recordStop", "saveCache", "immediately", "clearSelectionObject", "isAutoScrollEnableMode", "updateVoiceSyncPlayOption", "initRecordingList", "getVoiceMenuList", "", "updateVoiceMenu", "getPlaySPDVoiceTag", "showAudioPlayView", "objectVoice", "Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "time", "showRecordingView", "showInitView", "onRenameClick", "anchorView", "Landroid/view/View;", "updatePlayingItemByIndex", "nextIndex", "updateLastItemPlayTime", DBSchema.DocumentThumbnail.PLAY_TIME, "updateItemByIndex", "hideAllView", "updateSTTShowItem", "hideDialog", "updateDialogFragment", "parentView", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceRecordListPresenter {

    @NotNull
    private static final String TAG;

    @Nullable
    private Activity mActivity;
    private ComposerModel mComposerModel;
    private ComposerViewPresenter mComposerViewPresenter;
    private DialogPresenterManager mDialogPresenterManager;

    @Nullable
    private Fragment mFragment;

    @NotNull
    private final List<VoiceMenuItem> mItemList = new ArrayList();
    private ObjectManager mObjectManager;
    private VoiceRecordMenuContract.IParent mParent;
    private StorageChecker mStorageChecker;

    @Nullable
    private VoiceRecordMenuContract.IView mView;
    private ViewState mViewState;
    private VoiceModel mVoiceModel;

    static {
        String strCreateTag = Logger.createTag("VoiceRecordListPresenter");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    private final boolean checkVoiceState() {
        if (!VoiceUtil.isAllowAudioRecord(this.mActivity)) {
            return false;
        }
        if (VoiceManager.isRecorderWorking() || AudioManagerCompat.INSTANCE.getInstance().isRecordActive(this.mActivity)) {
            VoiceManager.toastVoiceMessage(SpenVoiceListenerManager.ERROR_ALREADY_RECORDER_WORKING);
            return false;
        }
        if (!AudioFocus.isCalling()) {
            return true;
        }
        VoiceManager.toastVoiceMessage(SpenVoiceListenerManager.ERROR_IS_CALLING_RECORD);
        return false;
    }

    private final int getCurrentPosition(SpenVoiceData voiceData, int sec) {
        VoiceModel voiceModel = this.mVoiceModel;
        VoiceModel voiceModel2 = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        int voiceDataIndex = voiceModel.getVoiceDataIndex(voiceData);
        VoiceModel voiceModel3 = this.mVoiceModel;
        if (voiceModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
        } else {
            voiceModel2 = voiceModel3;
        }
        return voiceModel2.getVoiceDataTimeByIndex(voiceDataIndex) + sec;
    }

    private final String getCurrentTime(SpenVoiceData voiceData, int sec) {
        return VoiceUtil.createTimeString$default(VoiceUtil.INSTANCE, getCurrentPosition(voiceData, sec) / 1000, false, 2, null);
    }

    private final String getSummarizeText(SpenVoiceData voiceData) {
        SpenVoiceTextDataReader spenVoiceTextDataReader = SpenVoiceTextDataReaderCache.INSTANCE.getInstance().get(voiceData);
        String[] summaryTitle = spenVoiceTextDataReader.getSummaryTitle();
        if (summaryTitle != null && summaryTitle.length != 0) {
            return summaryTitle[0];
        }
        String[] voiceTexts = spenVoiceTextDataReader.getVoiceTexts();
        StringBuilder sb = new StringBuilder();
        if (voiceTexts != null && voiceTexts.length != 0) {
            Iterator it = ArrayIteratorKt.iterator(voiceTexts);
            while (it.hasNext()) {
                sb.append((String) it.next());
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final int getTotalRecordTime() {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        int i = 0;
        for (SpenVoiceData spenVoiceData : voiceModel.getVoiceDataList()) {
            int recordingTime = (int) spenVoiceData.getRecordingTime();
            if (recordingTime <= 0) {
                recordingTime = VoiceUtil.INSTANCE.changeTimeType(spenVoiceData.getPlayTime()) * 1000;
            }
            i += recordingTime;
        }
        return i;
    }

    private final boolean isEditMode() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        return composerModel.getModeManager().isEditModeWithReadOnly();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startNewRecording$lambda$0(Fragment fragment, String[] strArr) {
        Logger.m11004w(TAG, "to get RECORD_AUDIO permission");
        PermissionHelper.requestPermissions(fragment, 113, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateDialogFragment$lambda$1(View view, VoiceRecordListPresenter voiceRecordListPresenter, VoiceDataRenameDialogPresenter voiceDataRenameDialogPresenter) {
        if (view.getX() <= 0.0f) {
            return;
        }
        voiceRecordListPresenter.onRenameClick(view);
        voiceDataRenameDialogPresenter.setDefaultName(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateDialogFragment$lambda$2(View view, VoiceRecordListPresenter voiceRecordListPresenter) {
        if (view.getX() <= 0.0f) {
            return;
        }
        VoiceRecordMenuContract.IParent iParent = voiceRecordListPresenter.mParent;
        if (iParent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParent");
            iParent = null;
        }
        iParent.showDeleteConfirmDialog(view);
    }

    public final void add(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        this.mItemList.add(new VoiceMenuItem(voiceData.getName(), voiceData.getPlayTime(), voiceData.getCreationTime(), getSummarizeText(voiceData)));
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.notifyItemInserted(this.mItemList.size() - 1);
        }
    }

    public final void clearSelectionObject() {
        ComposerModel composerModel = this.mComposerModel;
        ObjectManager objectManager = null;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        if (composerModel.getModeManager().isMode(Mode.Text)) {
            ObjectManager objectManager2 = this.mObjectManager;
            if (objectManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mObjectManager");
                objectManager2 = null;
            }
            if (objectManager2.isFocusedTextBox()) {
                return;
            }
        }
        ObjectManager objectManager3 = this.mObjectManager;
        if (objectManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mObjectManager");
        } else {
            objectManager = objectManager3;
        }
        objectManager.clearSelectObject();
    }

    public final void clearVoiceDataList() {
        setDeleteVisible(false);
    }

    @NotNull
    public final String getPlaySPDVoiceTag() {
        VoiceRecordMenuContract.IParent iParent = this.mParent;
        if (iParent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParent");
            iParent = null;
        }
        return iParent.getMSPDVoiceTagPath();
    }

    @NotNull
    public final String getTotalRecordTimeString() {
        return VoiceUtil.createTimeString$default(VoiceUtil.INSTANCE, getTotalRecordTime() / 1000, false, 2, null);
    }

    @NotNull
    public final List<VoiceMenuItem> getVoiceMenuList() {
        return this.mItemList;
    }

    public final void hideAllView() {
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.hideAllView();
        }
    }

    public final void hideAudioPlayView() {
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.hideAudioPlayView();
        }
    }

    public final void hideDialog() {
        DialogPresenterManager dialogPresenterManager = this.mDialogPresenterManager;
        if (dialogPresenterManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogPresenterManager");
            dialogPresenterManager = null;
        }
        dialogPresenterManager.hideVoiceDialog();
    }

    public final void init(@NotNull ComposerModel composerModel, @NotNull ComposerViewPresenter composerViewPresenter, @NotNull ControllerManager controllerManager, @NotNull DialogPresenterManager dialogPresenterManager, @NotNull VoiceRecordMenuContract.IParent parent) {
        Intrinsics.checkNotNullParameter(composerModel, "composerModel");
        Intrinsics.checkNotNullParameter(composerViewPresenter, "composerViewPresenter");
        Intrinsics.checkNotNullParameter(controllerManager, "controllerManager");
        Intrinsics.checkNotNullParameter(dialogPresenterManager, "dialogPresenterManager");
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.mComposerModel = composerModel;
        this.mVoiceModel = composerModel.getVoiceModel();
        this.mComposerViewPresenter = composerViewPresenter;
        this.mDialogPresenterManager = dialogPresenterManager;
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mStorageChecker = controllerManager.getStorageChecker();
        this.mViewState = controllerManager.getViewState();
        this.mParent = parent;
    }

    public final boolean initRecordingList() {
        this.mItemList.clear();
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        for (SpenVoiceData spenVoiceData : voiceModel.getVoiceDataList()) {
            String name = spenVoiceData.getName();
            String playTime = spenVoiceData.getPlayTime();
            long creationTime = spenVoiceData.getCreationTime();
            String str = TAG;
            StringBuilder sbM16m = AbstractC0000a.m16m("voice item=", name, "/", playTime, "/");
            sbM16m.append(creationTime);
            Logger.m10999d(str, sbM16m.toString());
            this.mItemList.add(new VoiceMenuItem(name, playTime, creationTime, getSummarizeText(spenVoiceData)));
        }
        AbstractC8014b.m7217s(this.mItemList.size(), "initRecordingList. ", TAG);
        boolean zIsEmpty = this.mItemList.isEmpty();
        boolean z = !zIsEmpty;
        if (!zIsEmpty) {
            this.mItemList.get(0).setPlayingVisible(true);
        }
        return z;
    }

    public final boolean isAutoScrollEnableMode() {
        ComposerModel composerModel = this.mComposerModel;
        ComposerModel composerModel2 = null;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        if (composerModel.getModeManager().isMode(Mode.ReadOnly)) {
            return true;
        }
        ComposerModel composerModel3 = this.mComposerModel;
        if (composerModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
        } else {
            composerModel2 = composerModel3;
        }
        return composerModel2.getModeManager().isMode(Mode.View);
    }

    public final void onAttachView(@Nullable Activity activity, @Nullable Fragment fragment) {
        this.mActivity = activity;
        this.mFragment = fragment;
        VoiceModel voiceModel = this.mVoiceModel;
        ComposerViewPresenter composerViewPresenter = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        if (voiceModel.isPlayingVoiceDataState() && isAutoScrollEnableMode()) {
            ComposerViewPresenter composerViewPresenter2 = this.mComposerViewPresenter;
            if (composerViewPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            } else {
                composerViewPresenter = composerViewPresenter2;
            }
            composerViewPresenter.getVoiceController().setVoiceSyncPlayAutoScroll(true);
        }
    }

    public final void onDetachView() {
        this.mActivity = null;
        this.mFragment = null;
        this.mView = null;
    }

    public final void onRenameClick(@Nullable View anchorView) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (UserInputSkipper.isValidEvent(tag)) {
            Logger.m11003i(TAG, "onRenameClick");
            UserInputSkipper.setHoldingEventTime(1000L, tag);
            DialogPresenterManager dialogPresenterManager = this.mDialogPresenterManager;
            if (dialogPresenterManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogPresenterManager");
                dialogPresenterManager = null;
            }
            dialogPresenterManager.showVoiceDataRenameDialog(new VoiceDataRenameDialogPresenter.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordListPresenter.onRenameClick.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.VoiceDataRenameDialogPresenter.OnClickListener
                public void dismiss(View view) {
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.VoiceDataRenameDialogPresenter.OnClickListener
                public void onClick(String newName) {
                    VoiceModel voiceModel = VoiceRecordListPresenter.this.mVoiceModel;
                    VoiceModel voiceModel2 = null;
                    if (voiceModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                        voiceModel = null;
                    }
                    if (voiceModel.getSelectedVoiceList().isEmpty()) {
                        Logger.m11004w(VoiceRecordListPresenter.TAG, "selected list error");
                        return;
                    }
                    VoiceModel voiceModel3 = VoiceRecordListPresenter.this.mVoiceModel;
                    if (voiceModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                        voiceModel3 = null;
                    }
                    String str = voiceModel3.getSelectedVoiceList().get(0);
                    if (TextUtils.isEmpty(str)) {
                        Logger.m11004w(VoiceRecordListPresenter.TAG, "selected rename item is error");
                        return;
                    }
                    Logger.addFileLog(VoiceRecordListPresenter.TAG, "VoiceRename", 0);
                    if (newName != null) {
                        VoiceModel voiceModel4 = VoiceRecordListPresenter.this.mVoiceModel;
                        if (voiceModel4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                            voiceModel4 = null;
                        }
                        voiceModel4.setNewName(newName);
                    }
                    int size = VoiceRecordListPresenter.this.mItemList.size();
                    for (int i = 0; i < size; i++) {
                        if (Intrinsics.areEqual(str, ((VoiceMenuItem) VoiceRecordListPresenter.this.mItemList.get(i)).getName())) {
                            ((VoiceMenuItem) VoiceRecordListPresenter.this.mItemList.get(i)).setName(newName);
                            VoiceRecordMenuContract.IView iView = VoiceRecordListPresenter.this.mView;
                            if (iView != null) {
                                iView.notifyItemChanged(i);
                            }
                            VoiceRecordMenuContract.IView iView2 = VoiceRecordListPresenter.this.mView;
                            if (iView2 != null) {
                                VoiceModel voiceModel5 = VoiceRecordListPresenter.this.mVoiceModel;
                                if (voiceModel5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                                } else {
                                    voiceModel2 = voiceModel5;
                                }
                                iView2.updateSelectedItemMenu(voiceModel2.getSelectedVoiceListSize());
                                return;
                            }
                            return;
                        }
                    }
                }
            }, anchorView);
        }
    }

    public final void recordPlayStop() {
        VoiceRecordMenuContract.IView iView;
        VoiceRecordMenuContract.IView iView2 = this.mView;
        if (iView2 != null) {
            iView2.setProgress(0);
        }
        VoiceRecordMenuContract.IView iView3 = this.mView;
        if (iView3 != null) {
            iView3.setRecordTime(getTotalRecordTimeString(), VoiceViewState.Type.VOICEINIT);
        }
        String totalRecordTimeString = getTotalRecordTimeString();
        if (!TextUtils.isEmpty(totalRecordTimeString) && (iView = this.mView) != null) {
            iView.setTotalRecordTime(totalRecordTimeString);
        }
        setPlayPauseView(false);
    }

    public final void recordStop() {
        ObjectManager objectManager = this.mObjectManager;
        if (objectManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mObjectManager");
            objectManager = null;
        }
        objectManager.commitHistory();
        saveCache(true);
    }

    public final void remove(int index) {
        this.mItemList.remove(index);
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.notifyItemRemoved(index);
        }
    }

    public final void removeOnlyItem(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        int size = this.mItemList.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(name, this.mItemList.get(i).getName())) {
                this.mItemList.remove(i);
                return;
            }
        }
    }

    public final void saveCache(boolean immediately) {
        ViewState viewState = this.mViewState;
        ComposerModel composerModel = null;
        if (viewState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewState");
            viewState = null;
        }
        if (viewState.isResumed()) {
            return;
        }
        ComposerModel composerModel2 = this.mComposerModel;
        if (composerModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
        } else {
            composerModel = composerModel2;
        }
        composerModel.saveCache(immediately);
    }

    public final void setDeleteVisible(boolean visible) {
        Iterator<VoiceMenuItem> it = this.mItemList.iterator();
        while (it.hasNext()) {
            it.next().setDeleteVisible(visible);
        }
    }

    public final void setPlayPauseView(boolean isPlay) {
        VoiceRecordMenuContract.IView iView;
        VoiceRecordMenuContract.IView iView2 = this.mView;
        if (iView2 != null) {
            iView2.setPlayPauseIcon(isPlay);
        }
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        if (voiceModel.compareViewState(VoiceViewState.Type.NORMAL_PLAY) || (iView = this.mView) == null) {
            return;
        }
        iView.showRecordSimpleMenu(isPlay);
    }

    public final void setPlayPauseViewVoiceObject(boolean isPlay) {
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.setPlayPauseIcon(isPlay);
        }
    }

    public final void setRecordingTime() {
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            VoiceUtil voiceUtil = VoiceUtil.INSTANCE;
            VoiceModel voiceModel = this.mVoiceModel;
            if (voiceModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel = null;
            }
            iView.setRecordingTime(VoiceUtil.createTimeString$default(voiceUtil, voiceModel.getRecordingTime(), false, 2, null));
        }
    }

    public final void setUpdatePlayTime(int position) {
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.setProgress(position);
        }
        VoiceRecordMenuContract.IView iView2 = this.mView;
        if (iView2 != null) {
            iView2.setPlayTime(VoiceUtil.createTimeString$default(VoiceUtil.INSTANCE, position / 1000, false, 2, null));
        }
    }

    public final void setUpdateRecordPlayTime(@NotNull SpenVoiceData voiceData, int position) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        int currentPosition = getCurrentPosition(voiceData, position);
        String currentTime = getCurrentTime(voiceData, position);
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.setProgress(currentPosition);
        }
        VoiceRecordMenuContract.IView iView2 = this.mView;
        if (iView2 != null) {
            VoiceModel voiceModel = this.mVoiceModel;
            if (voiceModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel = null;
            }
            iView2.setRecordTime(currentTime, voiceModel.getViewStateType());
        }
    }

    public final void setView(@Nullable VoiceRecordMenuContract.IView view) {
        this.mView = view;
    }

    public final void showAudioPlayView(@Nullable SpenObjectVoice objectVoice, int time, boolean isPlay) {
        VoiceRecordMenuContract.IParent iParent = this.mParent;
        if (iParent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParent");
            iParent = null;
        }
        iParent.showAudioPlayView(objectVoice, time, isPlay, true);
    }

    public final void showInitView() {
        VoiceRecordMenuContract.IParent iParent = this.mParent;
        if (iParent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParent");
            iParent = null;
        }
        VoiceRecordMenuContract.IParent.DefaultImpls.showInitView$default(iParent, false, 1, null);
    }

    public final void showRecordingView() {
        VoiceRecordMenuContract.IParent iParent = this.mParent;
        if (iParent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParent");
            iParent = null;
        }
        iParent.showRecordingView();
    }

    public final void startNewRecording() {
        VoiceModel voiceModel = this.mVoiceModel;
        ObjectManager objectManager = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        voiceModel.stopPlaying();
        clearSelectionObject();
        if (VoiceManager.isRecordingActivated()) {
            VoiceManager.stopRecording();
        }
        String[] permissionsForRecordAudio = PermissionHelper.getPermissionsForRecordAudio();
        Fragment fragment = this.mFragment;
        if (fragment != null && PermissionHelper.isPermissionGranted(this.mActivity, new RunnableC9844c(fragment, permissionsForRecordAudio, 5), (String[]) Arrays.copyOf(permissionsForRecordAudio, permissionsForRecordAudio.length))) {
            if (!checkVoiceState()) {
                Logger.m10999d(TAG, "insert voice# voice state is not available");
                return;
            }
            StorageChecker storageChecker = this.mStorageChecker;
            if (storageChecker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStorageChecker");
                storageChecker = null;
            }
            if (storageChecker.checkAvailableStateToEdit(true, true, true) != 0) {
                return;
            }
            VoiceModel voiceModel2 = this.mVoiceModel;
            if (voiceModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel2 = null;
            }
            VoiceState voiceState = voiceModel2.getVoiceState();
            String str = TAG;
            VoiceModel voiceModel3 = this.mVoiceModel;
            if (voiceModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel3 = null;
            }
            Logger.m11003i(str, "startNewRecording. " + voiceState + SQLKeyword.COMMA + voiceModel3.getViewStateType());
            VoiceState voiceState2 = VoiceState.RECORD_INIT;
            if (voiceState != voiceState2) {
                VoiceModel voiceModel4 = this.mVoiceModel;
                if (voiceModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                    voiceModel4 = null;
                }
                voiceModel4.setVoiceState(voiceState2);
                ObjectManager objectManager2 = this.mObjectManager;
                if (objectManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mObjectManager");
                } else {
                    objectManager = objectManager2;
                }
                objectManager.insertVoiceData();
            }
        }
    }

    public final boolean startNewRecordingByMediaEvent() {
        if (!isEditMode()) {
            return false;
        }
        VoiceModel voiceModel = this.mVoiceModel;
        VoiceModel voiceModel2 = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        if (voiceModel.getVoiceDataListSize() == 0) {
            return false;
        }
        ViewState viewState = this.mViewState;
        if (viewState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewState");
            viewState = null;
        }
        if (!viewState.isResumed()) {
            return false;
        }
        VoiceModel voiceModel3 = this.mVoiceModel;
        if (voiceModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel3 = null;
        }
        if (!voiceModel3.compareViewState(VoiceViewState.Type.VOICEINIT)) {
            return false;
        }
        VoiceModel voiceModel4 = this.mVoiceModel;
        if (voiceModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel4 = null;
        }
        if (voiceModel4.isRecordingVoiceState()) {
            return false;
        }
        VoiceModel voiceModel5 = this.mVoiceModel;
        if (voiceModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
        } else {
            voiceModel2 = voiceModel5;
        }
        if (voiceModel2.isPlayingVoiceState()) {
            return false;
        }
        startNewRecording();
        return true;
    }

    public final void updateDialogFragment(@Nullable View parentView) {
        DialogPresenterManager dialogPresenterManager = this.mDialogPresenterManager;
        if (dialogPresenterManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogPresenterManager");
            dialogPresenterManager = null;
        }
        DialogContract.IFragmentPresenter dialogFragmentPresenter = dialogPresenterManager.getDialogFragmentPresenter(9);
        VoiceDataRenameDialogPresenter voiceDataRenameDialogPresenter = dialogFragmentPresenter instanceof VoiceDataRenameDialogPresenter ? (VoiceDataRenameDialogPresenter) dialogFragmentPresenter : null;
        Boolean boolValueOf = voiceDataRenameDialogPresenter != null ? Boolean.valueOf(voiceDataRenameDialogPresenter.isShowing()) : null;
        String oldName = voiceDataRenameDialogPresenter != null ? voiceDataRenameDialogPresenter.getOldName() : null;
        DialogPresenterManager dialogPresenterManager2 = this.mDialogPresenterManager;
        if (dialogPresenterManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogPresenterManager");
            dialogPresenterManager2 = null;
        }
        DialogContract.IFragmentPresenter dialogFragmentPresenter2 = dialogPresenterManager2.getDialogFragmentPresenter(13);
        VoiceDataDeleteConfirmDialogPresenter voiceDataDeleteConfirmDialogPresenter = dialogFragmentPresenter2 instanceof VoiceDataDeleteConfirmDialogPresenter ? (VoiceDataDeleteConfirmDialogPresenter) dialogFragmentPresenter2 : null;
        Boolean boolValueOf2 = voiceDataDeleteConfirmDialogPresenter != null ? Boolean.valueOf(voiceDataDeleteConfirmDialogPresenter.isShowing()) : null;
        hideDialog();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(boolValueOf, bool)) {
            voiceDataRenameDialogPresenter.setDefaultName(oldName);
            View viewFindViewById = parentView != null ? parentView.findViewById(C9086R.id.voice_record_rename) : null;
            if (viewFindViewById != null) {
                viewFindViewById.post(new RunnableC8928b(viewFindViewById, 11, this, voiceDataRenameDialogPresenter));
            }
        }
        if (Intrinsics.areEqual(boolValueOf2, bool)) {
            View viewFindViewById2 = parentView != null ? parentView.findViewById(C9086R.id.voice_record_trash) : null;
            if (viewFindViewById2 != null) {
                viewFindViewById2.post(new RunnableC9844c(viewFindViewById2, this, 4));
            }
        }
    }

    public final void updateItemByIndex(int position) {
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.notifyItemChanged(position);
        }
    }

    public final void updateLastItemPlayTime(@NotNull String playTime) {
        Intrinsics.checkNotNullParameter(playTime, "playTime");
        if (this.mItemList.isEmpty()) {
            return;
        }
        int size = this.mItemList.size() - 1;
        this.mItemList.get(size).setPlayTime(playTime);
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.notifyItemChanged(size);
        }
        updatePlayingItemByIndex(0);
    }

    public final void updatePlayingItemByIndex(int nextIndex) {
        if (this.mItemList.isEmpty() || nextIndex < 0 || nextIndex >= this.mItemList.size()) {
            return;
        }
        int size = this.mItemList.size();
        int i = 0;
        while (i < size) {
            VoiceMenuItem voiceMenuItem = this.mItemList.get(i);
            boolean playingVisible = voiceMenuItem.getPlayingVisible();
            boolean z = nextIndex == i;
            if (this.mView != null && playingVisible != z) {
                voiceMenuItem.setPlayingVisible(z);
                VoiceRecordMenuContract.IView iView = this.mView;
                Intrinsics.checkNotNull(iView);
                iView.notifyItemChanged(i);
            }
            i++;
        }
    }

    public final void updatePlayingItemByName(@NotNull String name) {
        VoiceRecordMenuContract.IView iView;
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.mItemList.isEmpty() || TextUtils.isEmpty(name)) {
            return;
        }
        int size = this.mItemList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            VoiceMenuItem voiceMenuItem = this.mItemList.get(i2);
            boolean playingVisible = voiceMenuItem.getPlayingVisible();
            boolean zAreEqual = Intrinsics.areEqual(voiceMenuItem.getName(), name);
            if (zAreEqual) {
                i = i2;
            }
            if (playingVisible != zAreEqual) {
                voiceMenuItem.setPlayingVisible(zAreEqual);
                VoiceRecordMenuContract.IView iView2 = this.mView;
                if (iView2 != null) {
                    iView2.notifyItemChanged(i2);
                }
            }
        }
        if (!FeatureInfo.isSupportSTTFunction() || (iView = this.mView) == null) {
            return;
        }
        iView.updateSTTShowItem(i);
    }

    public final void updateSTTShowItem(int position) {
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.updateSTTShowItem(position);
        }
    }

    public final void updateVoiceMenu() {
        VoiceRecordMenuContract.IParent iParent = this.mParent;
        if (iParent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParent");
            iParent = null;
        }
        iParent.updateVoiceMenu();
    }

    public final void updateVoiceSyncPlayOption() {
        VoiceModel voiceModel = this.mVoiceModel;
        ComposerViewPresenter composerViewPresenter = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        boolean mSyncEnabled = voiceModel.getMSyncEnabled();
        if (isAutoScrollEnableMode()) {
            ComposerViewPresenter composerViewPresenter2 = this.mComposerViewPresenter;
            if (composerViewPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
                composerViewPresenter2 = null;
            }
            composerViewPresenter2.getVoiceController().setVoiceSyncPlayAutoScroll(true);
        }
        ComposerViewPresenter composerViewPresenter3 = this.mComposerViewPresenter;
        if (composerViewPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            composerViewPresenter3 = null;
        }
        composerViewPresenter3.getVoiceController().setVoiceSyncPlayEnabled(mSyncEnabled);
        ComposerViewPresenter composerViewPresenter4 = this.mComposerViewPresenter;
        if (composerViewPresenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
        } else {
            composerViewPresenter = composerViewPresenter4;
        }
        composerViewPresenter.getWritingToolManager().cancel();
    }
}
