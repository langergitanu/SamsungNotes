package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.state;

import android.os.Bundle;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.ChangeTemplateConstants;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ViewStateData {
    private float mDefaultPageRatio;
    private boolean mHasPDFPage;
    private boolean mHasPDFPageNext;
    private boolean mIsNoteLandscape;
    private boolean mIsSingleMode;
    private boolean mIsTwoPage;
    private int mNextPageHeight;
    private int mNextPageWidth;
    private int mPageHeight;
    private int mPageIndex;
    private int mPageTemplateCaller;
    private int mPageWidth;

    public float getDefaultPageRatio() {
        return this.mDefaultPageRatio;
    }

    public boolean getHasPDFPage() {
        return this.mHasPDFPage;
    }

    public boolean getHasPDFPageNext() {
        return this.mHasPDFPageNext;
    }

    public boolean getIsSingleMode() {
        return this.mIsSingleMode;
    }

    public boolean getIsTwoPage() {
        return this.mIsTwoPage;
    }

    public int getNextPageHeight() {
        return this.mNextPageHeight;
    }

    public float getNextPageRatio() {
        return DocumentPageRatio.getPageRatio(this.mNextPageWidth, this.mNextPageHeight, this.mDefaultPageRatio);
    }

    public int getNextPageRatioHeight() {
        return (int) (getNextPageRatio() * this.mNextPageWidth);
    }

    public int getNextPageWidth() {
        return this.mNextPageWidth;
    }

    public int getPageHeight() {
        return this.mPageHeight;
    }

    public int getPageIndex() {
        return this.mPageIndex;
    }

    public float getPageRatio() {
        return DocumentPageRatio.getPageRatio(this.mPageWidth, this.mPageHeight, this.mDefaultPageRatio);
    }

    public int getPageRatioHeight() {
        return (int) (getPageRatio() * this.mPageWidth);
    }

    public int getPageWidth() {
        return this.mPageWidth;
    }

    public void initialize(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.mIsSingleMode = bundle.getBoolean(ChangeTemplateConstants.ARG_TEMPLATE_SINGLE_MODE, false);
        this.mHasPDFPage = bundle.getBoolean(ChangeTemplateConstants.ARG_TEMPLATE_HAS_PDF_PAGE, false);
        this.mIsTwoPage = bundle.getBoolean(ChangeTemplateConstants.ARG_TEMPLATE_IS_TWO_PAGE, false);
        this.mHasPDFPageNext = bundle.getBoolean(ChangeTemplateConstants.ARG_TEMPLATE_HAS_PDF_PAGE_NEXT, false);
        this.mPageIndex = bundle.getInt(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_INDEX, -1);
        this.mPageWidth = bundle.getInt(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_WIDTH, 0);
        this.mPageHeight = bundle.getInt(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_HEIGHT, 0);
        this.mNextPageWidth = bundle.getInt(ChangeTemplateConstants.ARG_TEMPLATE_NEXT_PAGE_WIDTH, 0);
        this.mNextPageHeight = bundle.getInt(ChangeTemplateConstants.ARG_TEMPLATE_NEXT_PAGE_HEIGHT, 0);
        this.mDefaultPageRatio = bundle.getFloat(ChangeTemplateConstants.ARG_TEMPLATE_NOTE_PAGE_RATIO, DocumentPageRatio.PageRatioType.A4_PORTRAIT.getPageRatio());
        this.mPageTemplateCaller = bundle.getInt(ChangeTemplateConstants.ARG_PAGE_TEMPLATE_CALLER, 1);
    }

    public boolean isNoteLandscape() {
        return this.mIsNoteLandscape;
    }

    public boolean isNoteStyleMode() {
        return this.mPageTemplateCaller == 3;
    }

    public boolean isPickerMode() {
        return this.mPageTemplateCaller == 2;
    }

    public void setDefaultPageRatio(float f) {
        this.mDefaultPageRatio = f;
    }
}
