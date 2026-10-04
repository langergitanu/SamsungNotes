package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.support.senl.p148nt.base.composer.share.ShareCallbackReceiver;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTextFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.span.BodyTextFontSize;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.ResultOperation;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerSpenWNoteUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt.ISTTWindow;
import com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertController;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class STTTabletLayoutAction implements AiMenuContract.IAiAction {
    private static final String TAG = Logger.createTag("STTTabletLayoutAction", AiConstants.PREFIX_TAG);
    private ComposerViewPresenter mComposerViewPresenter;
    private ISTTWindow.IAIContract mIAiSTTContract;
    private STTTranslation mSTTTranslation;
    private SrcContentInfo mSrcContentInfo;
    private String mLastErrorMessage = null;
    private boolean mIsShowingContextMenu = false;
    private boolean mIsShowingVoiceListPopup = false;

    private String getAllSTTText() {
        STTPresenter sTTPresenter;
        ISTTWindow.IAIContract iAIContract = this.mIAiSTTContract;
        if (iAIContract == null || (sTTPresenter = iAIContract.getSTTPresenter()) == null) {
            return null;
        }
        if (sTTPresenter.isSelectionMode()) {
            Logger.m10999d(TAG, "getAllSTTText from selection mode");
            return getSelectedText();
        }
        if (this.mSTTTranslation.isTranslateMode()) {
            Logger.m10999d(TAG, "getAllSTTText from normal & translate mode");
            return this.mSTTTranslation.getCurrentVoiceItemText();
        }
        Logger.m10999d(TAG, "getAllSTTText from normal mode");
        return sTTPresenter.getCurrentVoiceItemText();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void addTo(ResultOperation.AddTo addTo) {
        ResultOperation resultOperation = new ResultOperation();
        String allSTTText = getAllSTTText();
        if (TextUtils.isEmpty(allSTTText)) {
            return;
        }
        SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
        newSpenObjectTextBox.setText(allSTTText);
        AiViewUtils.applySmartAlignment(newSpenObjectTextBox, allSTTText);
        ComposerSpenWNoteUtils.removeFontSizeSpan(newSpenObjectTextBox);
        int value = new BodyTextFontSize(this.mComposerViewPresenter.getTextManager().getFontSizeDelta()).getValue();
        if (ResultOperation.AddTo.EndOfNote == addTo) {
            this.mSrcContentInfo.setConvertibleColor(true);
            ComposerSpenWNoteUtils.changeFontSizeSpan(newSpenObjectTextBox, ComposerSpenWNoteUtils.getLastCursorFontSize(this.mComposerViewPresenter.getDoc().getBodyText(), value));
            if (this.mComposerViewPresenter.getComposerModel().isSingleMode()) {
                resultOperation.insertToBottom(this.mComposerViewPresenter, this.mSrcContentInfo, newSpenObjectTextBox);
                return;
            } else {
                resultOperation.insertNewPageEndOfNote(this.mComposerViewPresenter, this.mSrcContentInfo, newSpenObjectTextBox);
                return;
            }
        }
        if (ResultOperation.AddTo.NewPageBefore == addTo) {
            this.mSrcContentInfo.setConvertibleColor(true);
            ComposerSpenWNoteUtils.changeFontSizeSpan(newSpenObjectTextBox, ComposerSpenWNoteUtils.getCursorFontSize(this.mComposerViewPresenter.getTextManager().getSpenNoteTextManager(), this.mSrcContentInfo.mSrcPageIndex, this.mComposerViewPresenter.getDoc().getBodyText(), value));
            resultOperation.insertInNewPageFront(this.mComposerViewPresenter, this.mSrcContentInfo, newSpenObjectTextBox);
        } else if (ResultOperation.AddTo.NewNote == addTo) {
            resultOperation.addToNewNote(this.mComposerViewPresenter, newSpenObjectTextBox);
            ToastHandler.show(this.mComposerViewPresenter.getActivity(), C9086R.string.add_to_new_note_toast, 0);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public boolean canDoAction() {
        return !TextUtils.isEmpty(this.mIAiSTTContract.getSTTCurrentVoiceItemText());
    }

    public void cancel() {
    }

    public void clear() {
        cancel();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void copy() {
        new ResultOperation().copy(this.mComposerViewPresenter, getResultToCopy());
    }

    public void copySelectedTextData() {
        Logger.m10999d(TAG, "copySelectedTextData#");
        String selectedText = getSelectedText();
        SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
        newSpenObjectTextBox.setText(selectedText == null ? "" : selectedText);
        AiViewUtils.applySmartAlignment(newSpenObjectTextBox, selectedText);
        new ResultOperation().copy(this.mComposerViewPresenter, newSpenObjectTextBox);
    }

    public void deleteSelectedTextData() {
        Logger.m10999d(TAG, "deleteSelectedTextData#");
        this.mIAiSTTContract.getSTTPresenter().deleteSelectedTextData();
    }

    public int getConvertingPercent() {
        return FastConvertController.getInstance().getConvertingPercent(this.mIAiSTTContract.getCurrentConvertSession());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public String getDetailSAAiType() {
        return "c";
    }

    public ISTTWindow.IAIContract getIAiSTTContract() {
        return this.mIAiSTTContract;
    }

    public String getLastErrorMessage() {
        return this.mLastErrorMessage;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public SpenObjectTextBox getResultToCopy() {
        String allSTTText = getAllSTTText();
        SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
        newSpenObjectTextBox.setText(allSTTText == null ? "" : allSTTText);
        AiViewUtils.applySmartAlignment(newSpenObjectTextBox, allSTTText);
        return newSpenObjectTextBox;
    }

    public STTTranslation getSTTTranslation() {
        return this.mSTTTranslation;
    }

    public String getSelectedText() {
        STTPresenter sTTPresenter;
        ISTTWindow.IAIContract iAIContract = this.mIAiSTTContract;
        if (iAIContract == null || this.mSTTTranslation == null || (sTTPresenter = iAIContract.getSTTPresenter()) == null) {
            return null;
        }
        return this.mSTTTranslation.isTranslateMode() ? this.mSTTTranslation.getCurrentVoiceItemSelectedText() : sTTPresenter.getCurrentVoiceItemSelectedText();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public SrcContentInfo getSrcContentInfo() {
        return this.mSrcContentInfo;
    }

    public void init(SrcContentInfo srcContentInfo, ComposerViewPresenter composerViewPresenter, ISTTWindow.IAIContract iAIContract) {
        this.mIAiSTTContract = iAIContract;
        this.mSrcContentInfo = srcContentInfo;
        this.mComposerViewPresenter = composerViewPresenter;
        this.mSTTTranslation = new STTTranslation(composerViewPresenter, iAIContract);
    }

    public boolean isShowingContextMenu() {
        return this.mIsShowingContextMenu;
    }

    public boolean isShowingVoiceListPopup() {
        return this.mIsShowingVoiceListPopup;
    }

    public boolean isWorking() {
        return FastConvertController.getInstance().isConverting(this.mIAiSTTContract.getCurrentConvertSession());
    }

    public void onReleaseSection() {
        this.mIAiSTTContract.onReleaseSection();
        this.mComposerViewPresenter.getSoftInputManager().blockToShow(false, "STTTabletLayoutAction#onReleaseSection");
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Logger.m10999d(TAG, "onSaveInstanceState#");
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void overwrite() {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void restoreState(Bundle bundle, SrcContentInfo srcContentInfo) {
        Logger.m10999d(TAG, "restoreState#");
    }

    public void setShowingContextMenu(boolean z) {
        this.mIsShowingContextMenu = z;
    }

    public void setShowingVoiceListPopup(boolean z) {
        this.mIsShowingVoiceListPopup = z;
    }

    public void shareSelectedTextData() {
        String selectedText = getSelectedText();
        if (TextUtils.isEmpty(selectedText)) {
            Logger.m11000e(TAG, "shareSelectedTextData# fail : empty text");
            return;
        }
        Logger.m10999d(TAG, "shareSelectedTextData #" + this.mSTTTranslation.isTranslateMode() + " " + selectedText.length());
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", selectedText);
        try {
            Activity activity = this.mComposerViewPresenter.getActivity();
            Intent intent2 = new Intent(activity, (Class<?>) ShareCallbackReceiver.class);
            intent2.setAction(ShareCallbackReceiver.ACTION_SHARE_CALLBACK);
            activity.startActivity(Intent.createChooser(intent, activity.getString(C9086R.string.action_share), (Build.VERSION.SDK_INT >= 31 ? PendingIntent.getBroadcast(activity, 0, intent2, 33554432) : PendingIntent.getBroadcast(activity, 0, intent2, 134217728)).getIntentSender()));
        } catch (ActivityNotFoundException e) {
            Logger.m11001e(TAG, "activity not found!", e);
        }
    }
}
