package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiBixbyParam;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContentSwitcher {
    private boolean mCanSwitchContents;
    private final ComposerViewPresenter mComposerViewPresenter;
    private final Contract mContract;
    private int mLastSourceType = -1;
    private int mStartPageIndex;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        AiBixbyParam getAiBixbyParam();

        boolean hasBodyText(int i);

        boolean hasLineRectList();
    }

    public ContentSwitcher(ComposerViewPresenter composerViewPresenter, Contract contract) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mContract = contract;
    }

    private boolean isAutoFormat(AiBixbyParam aiBixbyParam) {
        if (aiBixbyParam == null || aiBixbyParam.getResultAction() != 5) {
            return false;
        }
        return aiBixbyParam.getAction() == 3 || aiBixbyParam.getAction() == 4;
    }

    private boolean isInvalid(List<Integer> list) {
        return list != null && list.size() <= 1;
    }

    private boolean isSpellingCorrection(AiBixbyParam aiBixbyParam) {
        return aiBixbyParam != null && aiBixbyParam.getResultAction() == 5 && aiBixbyParam.getAction() == 5;
    }

    public int getCurrentSelectedType() {
        if (this.mComposerViewPresenter.getPdfManager().hasSelectedText()) {
            return 0;
        }
        if (this.mComposerViewPresenter.getObjectManager().isSelectedBodyText() && this.mComposerViewPresenter.getTextManager().isSelected()) {
            return 1;
        }
        return (this.mComposerViewPresenter.getComposerModel().getComposerSpenDocModel().hasStrokeInSelected() || this.mContract.hasLineRectList() || !this.mComposerViewPresenter.getComposerModel().getComposerState().isTranslated()) ? 2 : 0;
    }

    public int getLastSourceType() {
        return this.mLastSourceType;
    }

    @NonNull
    public List<Integer> getListNextSwitchContent() {
        if (!isCanSwitchContents()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList<Integer> listNextSwitchContent = getListNextSwitchContent(this.mStartPageIndex, this.mContract.getAiBixbyParam());
        if (!isInvalid(listNextSwitchContent)) {
            return listNextSwitchContent;
        }
        setCanSwitchContents(false);
        return Collections.EMPTY_LIST;
    }

    public int getStartPageIndex() {
        return this.mStartPageIndex;
    }

    public String getStringCurrentSelectedType() {
        if (!isCanSwitchContents()) {
            return null;
        }
        if (isInvalid(getListNextSwitchContent(this.mStartPageIndex, this.mContract.getAiBixbyParam()))) {
            setCanSwitchContents(false);
            return null;
        }
        int currentSelectedType = getCurrentSelectedType();
        if (this.mLastSourceType != currentSelectedType) {
            this.mLastSourceType = currentSelectedType;
        }
        if (currentSelectedType == 0) {
            return this.mComposerViewPresenter.getActivity().getResources().getString(C9086R.string.composer_add_pdf);
        }
        if (currentSelectedType == 1) {
            return this.mComposerViewPresenter.getActivity().getResources().getString(C9086R.string.hw_toolbar_convert_body_text);
        }
        if (currentSelectedType == 2) {
            return this.mComposerViewPresenter.getActivity().getResources().getString(C9086R.string.composer_handwriting);
        }
        return null;
    }

    public boolean hasHandWriting(int i) {
        return hasHandWriting(i, true);
    }

    public boolean hasPdfText(int i) {
        return this.mComposerViewPresenter.getComposerModel().getComposerSpenDocModel().hasPdf(i) && this.mComposerViewPresenter.getPdfManager().getPageTextLength(i) > 0;
    }

    public boolean isCanSwitchContents() {
        return this.mCanSwitchContents;
    }

    public boolean isRecognitionSupported() {
        if (this.mComposerViewPresenter.getComposerModel().isPDFReader()) {
            return false;
        }
        return RecognitionUtil.isSupported(this.mComposerViewPresenter.getActivity());
    }

    public void setCanSwitchContents(boolean z) {
        this.mCanSwitchContents = z;
    }

    public void setDisableSwitchContentButton() {
        setCanSwitchContents(false);
    }

    public void setEnableSwitchContentButton() {
        setCanSwitchContents((this.mComposerViewPresenter.getComposerModel().isPDFReader() || this.mComposerViewPresenter.getComposerModel().isSingleMode() || this.mComposerViewPresenter.getComposerModel().getComposerSpenDocModel().hasStrokeInSelected()) ? false : true);
    }

    public void setLastSourceType(int i) {
        this.mLastSourceType = i;
    }

    public void setStartPageIndex(int i) {
        this.mStartPageIndex = i;
    }

    public boolean hasHandWriting(int i, boolean z) {
        RectF contentRectInView;
        if (!z || isRecognitionSupported()) {
            return !((!this.mComposerViewPresenter.getComposerModel().isSingleMode() || (contentRectInView = this.mComposerViewPresenter.getObjectManager().getNoteZoomScroller().getContentRectInView()) == null) ? this.mComposerViewPresenter.getDoc().getPage(i).getObjectList(1).isEmpty() : this.mComposerViewPresenter.getDoc().getPage(0).findObjectInRect(1, contentRectInView, true).isEmpty());
        }
        return false;
    }

    @NonNull
    private ArrayList<Integer> getListNextSwitchContent(int i, AiBixbyParam aiBixbyParam) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        boolean zIsSpellingCorrection = isSpellingCorrection(aiBixbyParam);
        boolean zIsAutoFormat = isAutoFormat(aiBixbyParam);
        if (!zIsSpellingCorrection && !zIsAutoFormat && hasPdfText(i)) {
            arrayList.add(0);
        }
        Contract contract = this.mContract;
        if (contract != null && contract.hasBodyText(i)) {
            arrayList.add(1);
        }
        if (!zIsSpellingCorrection && hasHandWriting(i)) {
            arrayList.add(2);
        }
        return arrayList;
    }
}
