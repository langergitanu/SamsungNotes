package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.dialog.AiPersonalDataRestrictedDialog;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTools;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTextFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.p153ai.drawing.AiDrawingState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AiDrawingDeleteConfirmDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.ClipboardUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiActionStatus;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.AiDrawingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.presenter.data.AiDrawingDataController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.ResultOperation;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.model.assist.lvm.ImageMaker;
import com.samsung.android.support.senl.p148nt.model.assist.lvm.Operator;
import com.samsung.android.support.senl.p148nt.model.assist.lvm.Sketch2ImageMaker;
import com.samsung.android.support.senl.p148nt.model.assist.lvm.Text2ImageMaker;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.ImageUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CreateImage implements AiMenuContract.IAiAction {
    private static final String KEY_IS_GENERATE_ONE_MORE_CALLBACK_USED = "KEY_IS_GENERATE_ONE_MORE_CALLBACK_USED";
    private static final String TAG = Logger.createTag("CreateImage", AiConstants.PREFIX_TAG);
    private final ComposerViewPresenter mComposerViewPresenter;
    private Contract mContract;
    private final AiDrawingDataController mDataController;
    private int mFocusedOutputIndex = 0;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private ImageMaker mImageMaker;
    private boolean mIsGenerateOneMoreCallbackUsed;
    private String mLastRequestedImageStyle;
    private Listener mListener;
    private SrcContentInfo mSrcContentInfo;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void addResult(String str);

        void overwriteResult(String str);

        void releaseCreateImage(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ImageMakerCallback implements Operator.Callback {
        public ImageMakerCallback() {
        }

        public void handleSuccessResult(@NonNull List<Bitmap> list) {
            for (int i = 0; i < list.size(); i++) {
                Bitmap bitmap = list.get(i);
                if (bitmap == null) {
                    Logger.m10999d(CreateImage.TAG, "generate#onSuccess, bitmap is null, index : " + i + ", skip saving file.");
                    return;
                }
                String str = CreateImage.this.mSrcContentInfo.getOutputFilePaths().get(i);
                ImageUtil.saveBitmapToFileCache(bitmap, str, Bitmap.CompressFormat.JPEG, 100, 0, true);
                String str2 = CreateImage.TAG;
                StringBuilder sbM778t = AbstractC0541b.m778t(i, "generate#onSuccess, index: ", ", bitmap width : ");
                sbM778t.append(bitmap.getWidth());
                sbM778t.append(", height : ");
                sbM778t.append(bitmap.getHeight());
                sbM778t.append(", fileSize: ");
                sbM778t.append(FileUtils.getFileSize(str));
                Logger.m10999d(str2, sbM778t.toString());
            }
            CreateImage.this.handleResult(list, true, "onSuccess");
        }

        @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSImageResultListener.Callback
        public boolean onFailed(@NonNull Bundle bundle) {
            return false;
        }

        @Override // com.samsung.android.support.senl.nt.model.assist.lvm.Operator.Callback
        public void onRetry(Runnable runnable) {
            AiCommonUtil.executeRetryAction(runnable);
        }

        @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSImageResultListener.Callback
        public void onSuccess(@NonNull List<Bitmap> list, boolean z) {
            if (AiDrawingState.FINISHED.equals(CreateImage.this.mComposerViewPresenter.getComposerModel().getAiDrawingState())) {
                return;
            }
            int size = list.size();
            if (size == 0) {
                Logger.m11000e(CreateImage.TAG, "generate#onSuccess bitmap is empty");
            } else {
                handleSuccessResult(list);
                AbstractC0000a.m3D(size, "generate#onSuccess, bitmap list size : ", CreateImage.TAG);
            }
        }

        @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSImageResultListener.Callback
        public boolean onFailed(@NonNull String str) {
            int lastGeneratedOutputFilesCount = CreateImage.this.getLastGeneratedOutputFilesCount();
            Logger.m11000e(CreateImage.TAG, "generate#onFailed, message: " + str + ", lastGeneratedOutputFilesCountIndex: " + lastGeneratedOutputFilesCount);
            if ("RESTRICTED_USER_ERROR".equals(str)) {
                CreateImage.this.handleError(str);
                return true;
            }
            if (lastGeneratedOutputFilesCount <= 0) {
                CreateImage.this.handleError(str);
                return true;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < lastGeneratedOutputFilesCount; i++) {
                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(CreateImage.this.mSrcContentInfo.getOutputFilePaths().get(i));
                if (bitmapDecodeFile != null) {
                    arrayList.add(bitmapDecodeFile);
                }
            }
            CreateImage.this.handleResult(arrayList, false, "onFailed, use cached output");
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ImageMakerOneMoreCallback extends ImageMakerCallback {
        public ImageMakerOneMoreCallback() {
            super();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.CreateImage.ImageMakerCallback
        public void handleSuccessResult(@NonNull List<Bitmap> list) {
            Bitmap bitmap = list.get(0);
            if (bitmap == null) {
                Logger.m10999d(CreateImage.TAG, "generate#onSuccess, bitmap is null, skip saving file.");
                return;
            }
            int size = CreateImage.this.mSrcContentInfo.getOutputFilePaths().size() - 1;
            String str = CreateImage.this.mSrcContentInfo.getOutputFilePaths().get(size);
            ImageUtil.saveBitmapToFileCache(bitmap, str, Bitmap.CompressFormat.PNG, 100, 0, true);
            String str2 = CreateImage.TAG;
            StringBuilder sbM778t = AbstractC0541b.m778t(size, "generate#onSuccess, index: ", ", bitmap width : ");
            sbM778t.append(bitmap.getWidth());
            sbM778t.append(", height : ");
            sbM778t.append(bitmap.getHeight());
            sbM778t.append(", fileSize: ");
            sbM778t.append(FileUtils.getFileSize(str));
            Logger.m10999d(str2, sbM778t.toString());
            CreateImage.this.handleOneMoreResult(list, true, "onSuccess");
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.CreateImage.ImageMakerCallback, com.samsung.android.support.senl.nt.base.common.ai.scs.SCSImageResultListener.Callback
        public boolean onFailed(@NonNull String str) {
            String str2 = CreateImage.TAG;
            StringBuilder sbM15l = AbstractC0000a.m15l("generate#onFailed, message: ", str, ", Count: ");
            sbM15l.append(CreateImage.this.mSrcContentInfo.getOutputFilePaths().size());
            Logger.m11000e(str2, sbM15l.toString());
            CreateImage.this.mDataController.removeLastFilePath();
            CreateImage.this.handleError(str);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Listener extends AiMenuContract.ResultListener {
        void onStart();

        void requestRelease(String str);
    }

    public CreateImage(AiDrawingDataController aiDrawingDataController, ComposerViewPresenter composerViewPresenter) {
        this.mDataController = aiDrawingDataController;
        this.mComposerViewPresenter = composerViewPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$initImageMaker$0() {
        return this.mComposerViewPresenter.getDoc().getWidth();
    }

    private void restoreExecute() {
        execute(this.mIsGenerateOneMoreCallbackUsed);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void addTo(ResultOperation.AddTo addTo) {
        if (this.mFocusedOutputIndex <= 0) {
            return;
        }
        ComposerSA.insertLog(ComposerSAConstants.SCREEN_AI_DRAWING_POPUP_RESULT, ComposerSAConstants.EVENT_AI_DRAWING_RESULT_ADD_TO_NOTE);
        this.mContract.addResult(getCurrentOutputFilePath());
        Listener listener = this.mListener;
        if (listener != null) {
            listener.requestRelease("addTo " + hashCode());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public boolean canDoAction() {
        if (this.mFocusedOutputIndex <= 0) {
            return false;
        }
        return FileUtils.exists(getCurrentOutputFilePath());
    }

    public void cancel(String str) {
        AbstractC8014b.m7196B("cancel# ", str, TAG);
        ImageMaker imageMaker = this.mImageMaker;
        if (imageMaker != null) {
            imageMaker.cancel();
            this.mImageMaker.release();
            this.mImageMaker = null;
        }
        Contract contract = this.mContract;
        if (contract != null) {
            contract.releaseCreateImage(str + "/cancel");
            this.mContract = null;
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void clear() {
        Logger.m10999d(TAG, "clear " + hashCode());
        cancel("clear " + hashCode());
        setResultListener(null);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void copy() {
        if (this.mFocusedOutputIndex <= 0) {
            return;
        }
        ComposerSA.insertLog(ComposerSAConstants.SCREEN_AI_DRAWING_POPUP_RESULT, ComposerSAConstants.EVENT_AI_DRAWING_RESULT_COPY);
        ClipboardUtil.copyImageToClipboard(getCurrentOutputImage(), true);
    }

    public void execute() {
        Logger.m10999d(TAG, "execute# ");
        String generateStyle = this.mSrcContentInfo.getGenerateStyle();
        if (!generateStyle.equals(getLastRequestedImageStyle())) {
            Iterator<String> it = this.mSrcContentInfo.getOutputFilePaths().iterator();
            while (it.hasNext()) {
                FileUtils.deleteFile(it.next());
            }
        }
        setLastRequestedImageStyle(generateStyle);
        execute(false);
    }

    public void generateOneMore() {
        String str = TAG;
        Logger.m10999d(str, "generateOneMore# ");
        if (this.mSrcContentInfo.getOutputFilePaths().size() >= 10) {
            Logger.m11004w(str, "generateOneMore# over 10");
            if (!SharedPreferencesCompat.getInstance("Composer").getBoolean(SharedPreferencesConstants.AI_DRAWING_DELETE_CONFIRM_DIALOG_OFF, false)) {
                ListenerImplContract.IDialogPresenter dialogPresenterManager = this.mComposerViewPresenter.getDialogPresenterManager();
                if (dialogPresenterManager instanceof DialogPresenterManager) {
                    Logger.m10999d(str, "generateOneMore# show delete confirm dialog");
                    ((DialogPresenterManager) dialogPresenterManager).showAiDrawingDeleteConfirmDialog(new AiDrawingDeleteConfirmDialogPresenter.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.CreateImage.1
                        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.AiDrawingDeleteConfirmDialogPresenter.Contract
                        public void delete() {
                            Logger.m10999d(CreateImage.TAG, "delete old");
                            CreateImage.this.mDataController.removeOldFile();
                            CreateImage.this.generateOneMore();
                        }
                    });
                    return;
                }
                return;
            }
            this.mDataController.removeOldFile();
        }
        this.mDataController.addOutputFilePath();
        this.mIsGenerateOneMoreCallbackUsed = true;
        execute(true);
    }

    public AiDrawingState getAiDrawingState() {
        return this.mComposerViewPresenter.getComposerModel().getAiDrawingState();
    }

    public String getCurrentOutputFilePath() {
        return this.mSrcContentInfo.getOutputFilePaths().get(getImageIndex(this.mFocusedOutputIndex));
    }

    public Bitmap getCurrentOutputImage() {
        return BitmapFactory.decodeFile(getCurrentOutputFilePath());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public String getDetailSAAiType() {
        return "f";
    }

    public String getErrorMessage(String str) {
        if ("RESTRICTED_USER_ERROR".equals(str)) {
            return this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_personal_data_restriced_title);
        }
        if ("NETWORK_ERROR".equals(str) || !AiActionStatus.isNetworkAvailable()) {
            return this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_drawing_no_network_connection_error);
        }
        if ("TIMEOUT_ERROR".equals(str) || "INTERNAL_SERVER_ERROR".equals(str) || "REMOTE_SERVER_ERROR".equals(str) || "SERVER_ERROR".equals(str) || "SERVER_QUOTA_ERROR".equals(str) || "CLIENT_ERROR".equals(str)) {
            return this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_drawing_could_not_complete_try_again_later);
        }
        if ("SAFE_FILTER_ERROR".equals(str) || "MISSING_MANDATORY_FIELD".equals(str) || "INPUT_DATA_ERROR".equals(str)) {
            return this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_drawing_can_not_generate_with_this_content);
        }
        if ("AUTH_ERROR".equals(str) || "AUTH_SA_ERROR".equals(str) || "UNEXPECTED_ERROR".equals(str) || SCSTools.getAppInfoErrMsg().equals(str)) {
            return this.mComposerViewPresenter.getActivity().getString(C9086R.string.base_something_wrong_try_again);
        }
        Logger.m11004w(TAG, "getErrorMessage, unknown error, " + str);
        return this.mComposerViewPresenter.getActivity().getString(C9086R.string.base_something_wrong_try_again);
    }

    public int getFocusedOutputIndex() {
        return this.mFocusedOutputIndex;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public int getImageIndex(int i) {
        return this.mSrcContentInfo.getOutputFilePaths().size() - i;
    }

    public int getLastGeneratedOutputFilesCount() {
        int generatingImageCount = AiDrawingUtil.getGeneratingImageCount();
        int i = 0;
        for (int i2 = 0; i2 < generatingImageCount; i2++) {
            if (FileUtils.isFileExists(this.mSrcContentInfo.getOutputFilePaths().get(i2))) {
                i++;
            }
        }
        return i;
    }

    public String getLastRequestedImageStyle() {
        return this.mLastRequestedImageStyle;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public SpenObjectTextBox getResultToCopy() {
        return ObjectTextFactory.getNewSpenObjectTextBox();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public SrcContentInfo getSrcContentInfo() {
        return this.mSrcContentInfo;
    }

    public int getValidOutputCount() {
        Iterator<String> it = this.mSrcContentInfo.getOutputFilePaths().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (FileUtils.exists(it.next())) {
                i++;
            }
        }
        return i;
    }

    public void handleError(String str) {
        if ("RESTRICTED_USER_ERROR".equals(str)) {
            AiPersonalDataRestrictedDialog.INSTANCE.show(this.mComposerViewPresenter.getActivity(), null);
        }
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onFailed(str);
        }
    }

    public void handleOneMoreResult(List<Bitmap> list, boolean z, String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder("handleOneMoreResult, bitmap list size : ");
        sb.append(list.size());
        sb.append(", isSuccess: ");
        sb.append(z);
        sb.append(", msg: ");
        AbstractC8014b.m7213o(sb, str, str2);
        this.mComposerViewPresenter.getComposerModel().setAiDrawingState(AiDrawingState.FINISHED);
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onNextCompleted(true);
        }
    }

    public void handleResult(List<Bitmap> list, boolean z, String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder("handleResult, bitmap list size : ");
        sb.append(list.size());
        sb.append(", isSuccess: ");
        sb.append(z);
        sb.append(", msg: ");
        AbstractC8014b.m7213o(sb, str, str2);
        this.mComposerViewPresenter.getComposerModel().setAiDrawingState(AiDrawingState.FINISHED);
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onCompleted(true);
        }
    }

    public void initImageMaker() {
        initImageMaker(false);
    }

    public boolean isFinishedState() {
        return AiDrawingState.FINISHED.equals(getAiDrawingState());
    }

    public boolean isRunningState() {
        return AiDrawingState.RUNNING.equals(getAiDrawingState());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putBoolean(KEY_IS_GENERATE_ONE_MORE_CALLBACK_USED, this.mIsGenerateOneMoreCallbackUsed);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void overwrite() {
        if (this.mFocusedOutputIndex <= 0 || this.mSrcContentInfo.getSrcType() != 3) {
            return;
        }
        ComposerSA.insertLog(ComposerSAConstants.SCREEN_AI_DRAWING_POPUP_RESULT, ComposerSAConstants.EVENT_AI_DRAWING_RESULT_REPLACE);
        this.mContract.overwriteResult(getCurrentOutputFilePath());
        Listener listener = this.mListener;
        if (listener != null) {
            listener.requestRelease("overwrite " + hashCode());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void restoreState(Bundle bundle, SrcContentInfo srcContentInfo) {
        this.mSrcContentInfo = srcContentInfo;
        if (isFinishedState()) {
            return;
        }
        this.mIsGenerateOneMoreCallbackUsed = bundle.getBoolean(KEY_IS_GENERATE_ONE_MORE_CALLBACK_USED, false);
        restoreExecute();
    }

    public void setContract(Contract contract) {
        Logger.m10999d(TAG, "setContract: " + hashCode());
        this.mContract = contract;
    }

    public void setFocusedOutputIndex(int i) {
        this.mFocusedOutputIndex = i;
    }

    public void setLastRequestedImageStyle(String str) {
        this.mLastRequestedImageStyle = str;
    }

    public void setResultListener(Listener listener) {
        Logger.m10999d(TAG, "setResultListener: " + hashCode());
        this.mListener = listener;
    }

    public void setSrcContentInfo(SrcContentInfo srcContentInfo) {
        this.mSrcContentInfo = srcContentInfo;
    }

    private void initImageMaker(boolean z) {
        if (this.mSrcContentInfo.getSrcType() == 3) {
            this.mImageMaker = new Sketch2ImageMaker(this.mComposerViewPresenter.getActivity(), this.mSrcContentInfo.getInputFilePath());
        } else {
            this.mImageMaker = new Text2ImageMaker(this.mComposerViewPresenter.getActivity());
        }
        this.mImageMaker.setContract(new C9465j(this, 2));
        this.mImageMaker.registerCallback(z ? new ImageMakerOneMoreCallback() : new ImageMakerCallback());
        this.mImageMaker.requestPreProcess();
    }

    private void execute(boolean z) {
        AbstractC8014b.m7220v("execute# withGenerateOneMoreCallback: ", TAG, z);
        ImageMaker imageMaker = this.mImageMaker;
        if (imageMaker == null) {
            initImageMaker(z);
        } else if (this.mIsGenerateOneMoreCallbackUsed) {
            if (z) {
                imageMaker.registerCallback(new ImageMakerOneMoreCallback());
            } else {
                imageMaker.registerCallback(new ImageMakerCallback());
                this.mIsGenerateOneMoreCallbackUsed = false;
            }
        }
        this.mComposerViewPresenter.getComposerModel().setAiDrawingState(AiDrawingState.RUNNING);
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onStart();
        }
        this.mImageMaker.setImageStyle(this.mLastRequestedImageStyle);
        this.mImageMaker.setScribbleWeightValue(AiActionStatus.getDrawingAssistScribbleWeight());
        this.mImageMaker.execute();
    }
}
