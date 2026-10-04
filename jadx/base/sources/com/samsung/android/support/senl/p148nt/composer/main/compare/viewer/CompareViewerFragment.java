package com.samsung.android.support.senl.p148nt.composer.main.compare.viewer;

import android.graphics.Point;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.composer.text.ISpenNoteTextManager;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.compare.presenter.CompareViewerContract;
import com.samsung.android.support.senl.p148nt.composer.main.simple.presenter.SimpleComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.simple.view.SimpleComposerFragment;
import com.samsung.android.support.senl.p148nt.composer.main.simple.view.SimpleComposerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CompareViewerFragment extends SimpleComposerFragment implements CompareViewerContract.IViewerFragment {
    private static final String TAG = "CompareViewerFragment";
    private boolean isMergeDone = false;
    private ImageButton mCompareEditMergeBtn;
    private CompareViewerContract.IPresenter mCompareMainPresenter;
    private ArrayList<RectF> mCurrentRectFHighlight;
    private HighLightView mHighLightView;

    private void initKeepButton() {
        this.mFragmentView.findViewById(C9086R.id.comp_compare).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.compare.viewer.CompareViewerFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CompareViewerFragment.this.mCompareMainPresenter.showDialog(CompareViewerFragment.this.getChildFragmentManager(), CompareViewerFragment.this.getTag());
            }
        });
    }

    private void updateEditMergeButton(RectF rectF, int i) {
        if (this.mCompareEditMergeBtn != null) {
            int height = (int) (rectF.top - r0.getHeight());
            int iM1155a = (int) AbstractC0622a.m1155a(rectF.width(), this.mCompareEditMergeBtn.getWidth(), 2.0f, rectF.left);
            int i2 = (int) rectF.bottom;
            if (iM1155a < 0 || ((height < 0 && i2 < 0) || !this.isMergeDone)) {
                this.mCompareEditMergeBtn.setVisibility(4);
                return;
            }
            String tag = getTag();
            if (tag == null || ((i == 1 && tag.equals("first")) || (i == 0 && tag.equals("second")))) {
                this.mCompareEditMergeBtn.setVisibility(4);
                return;
            }
            this.mCompareEditMergeBtn.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            if (height >= 0) {
                i2 = height;
            }
            layoutParams.setMargins(iM1155a, i2, 0, 0);
            this.mCompareEditMergeBtn.setLayoutParams(layoutParams);
            this.mCompareEditMergeBtn.setRotation(height >= 0 ? 0.0f : 180.0f);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.simple.view.SimpleComposerFragment, com.samsung.android.support.senl.nt.composer.main.simple.presenter.SimpleComposerFragmentContract.IView
    public void attachComposerView(SimpleComposerViewPresenter simpleComposerViewPresenter) {
        super.attachComposerView(simpleComposerViewPresenter);
        String tag = getTag();
        if (tag != null) {
            Logger.m10999d(TAG, "attachComposerView# ".concat(tag));
            this.mSimpleComposerView.setCompareMainPresenter(this.mCompareMainPresenter, tag);
            if (tag.equals("merge")) {
                this.mCompareMainPresenter.setMergeNoteToShow(this.mPresenter.getNote());
            } else {
                this.mCompareMainPresenter.setAutoScroll();
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewerFragment
    public void drawHighlight(@NonNull ArrayList<RectF> arrayList, int i) {
        this.mCurrentRectFHighlight = arrayList;
        ArrayList<RectF> arrayList2 = new ArrayList<>();
        for (RectF rectF : this.mCurrentRectFHighlight) {
            if (rectF != null) {
                arrayList2.add(this.mSimpleComposerView.convertViewRectIntoContentRect(rectF));
            }
        }
        if (!arrayList2.isEmpty()) {
            this.mHighLightView.setRectF(arrayList2, i, getTag().equals("merge"));
            this.mHighLightView.invalidate();
            updateEditMergeButton(arrayList2.get(0), i);
        } else {
            this.mHighLightView.clear();
            ImageButton imageButton = this.mCompareEditMergeBtn;
            if (imageButton != null) {
                imageButton.setVisibility(4);
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewerFragment
    public int getBottomContainerHeight() {
        return this.mFragmentView.findViewById(C9086R.id.simple_comp_bottom_container).getHeight();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewerFragment
    @Nullable
    public View getComposerViewContainer() {
        return this.mFragmentView.findViewById(C9086R.id.simple_comp_container);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewerFragment
    @Nullable
    public Integer getEditBtnHeight() {
        return Integer.valueOf(this.mCompareEditMergeBtn.getHeight());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewerFragment
    @Nullable
    public Integer getHeightBottomContainer() {
        return Integer.valueOf(this.mFragmentView.findViewById(C9086R.id.simple_comp_container).getHeight());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.simple.view.SimpleComposerFragment
    @LayoutRes
    public int getLayoutResource() {
        return C9086R.layout.compare_comp_viewer_fragment;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewerFragment
    @Nullable
    public SpenWNote getNote() {
        return this.mPresenter.getNote();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewerFragment
    public float getPanY() {
        SimpleComposerView simpleComposerView = this.mSimpleComposerView;
        if (simpleComposerView != null) {
            return simpleComposerView.getScrollY();
        }
        return -1.0f;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewerFragment
    @NonNull
    public ArrayList<RectF> getRectObjectSpan(int i) {
        ArrayList<RectF> arrayList = new ArrayList<>();
        SpenWNote note = this.mPresenter.getNote();
        SpenObjectSpan objectSpanAtTextIndex = note.getBodyText().getObjectSpanAtTextIndex(i);
        if (objectSpanAtTextIndex != null) {
            Point offset = note.getPage(this.mCompareMainPresenter.getIndexPageOfObject(note, i)).getOffset();
            RectF drawnRect = objectSpanAtTextIndex.getObject().getDrawnRect();
            float f = drawnRect.left;
            float f4 = drawnRect.top;
            int i2 = offset.y;
            RectF rectF = new RectF(f, f4 + i2, drawnRect.right, drawnRect.bottom + i2);
            arrayList.add(rectF);
            arrayList.add(rectF);
        }
        return arrayList;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewerFragment
    @NonNull
    public ArrayList<RectF> getTextRectFromIndex(int i, int i2) {
        SpenWNote note = this.mPresenter.getNote();
        ArrayList<RectF> arrayList = new ArrayList<>();
        SimpleComposerView simpleComposerView = this.mSimpleComposerView;
        ISpenNoteTextManager textManager = simpleComposerView != null ? simpleComposerView.getTextManager() : null;
        if (textManager != null) {
            List<RectF> textContentRectsByCursorRangeInBodytext = textManager.getTextContentRectsByCursorRangeInBodytext(i, i2);
            if (textContentRectsByCursorRangeInBodytext == null) {
                RectF cursorRect = textManager.getCursorRect(note.getBodyText(), i);
                RectF cursorRect2 = textManager.getCursorRect(note.getBodyText(), i2);
                arrayList.add(new RectF(cursorRect.left, cursorRect.top, cursorRect2.right, cursorRect2.bottom));
                arrayList.add(cursorRect);
                arrayList.add(cursorRect2);
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    arrayList.add(textManager.getCursorRect(note.getBodyText(), i));
                }
            } else {
                RectF rectF = new RectF(textContentRectsByCursorRangeInBodytext.get(0));
                arrayList.add(rectF);
                for (RectF rectF2 : textContentRectsByCursorRangeInBodytext) {
                    rectF.left = Math.min(rectF.left, rectF2.left);
                    rectF.right = Math.max(rectF.right, rectF2.right);
                    rectF.top = Math.min(rectF.top, rectF2.top);
                    rectF.bottom = Math.max(rectF.bottom, rectF2.bottom);
                    arrayList.add(rectF2);
                }
            }
        }
        return arrayList;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewerFragment
    public int getTopContainerHeight() {
        return this.mFragmentView.findViewById(C9086R.id.simple_comp_top_container).getHeight();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewerFragment
    public void hideProgress() {
        this.mProgressController.setProgressVisibility(false);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewerFragment
    public void mergeDone() {
        this.isMergeDone = true;
        redraw();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.simple.view.SimpleComposerFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        updateTitle();
        initKeepButton();
        final String tag = getTag();
        this.mHighLightView = (HighLightView) this.mFragmentView.findViewById(C9086R.id.compare_highlight_view);
        if (tag != null && !tag.equals("merge")) {
            ImageButton imageButton = (ImageButton) this.mFragmentView.findViewById(C9086R.id.add_or_delete_merge_button);
            this.mCompareEditMergeBtn = imageButton;
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.compare.viewer.CompareViewerFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Boolean boolOnClickEditMerge = CompareViewerFragment.this.mCompareMainPresenter.onClickEditMerge(tag);
                    if (boolOnClickEditMerge != null) {
                        CompareViewerFragment.this.setViewEditMergeButton(boolOnClickEditMerge.booleanValue());
                    }
                }
            });
        }
        this.mCompareMainPresenter.setViewerFragment(this, getTag());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewerFragment
    public void redraw() {
        if (this.mCurrentRectFHighlight == null) {
            ImageButton imageButton = this.mCompareEditMergeBtn;
            if (imageButton != null) {
                imageButton.setVisibility(4);
                return;
            }
            return;
        }
        ArrayList<RectF> arrayList = new ArrayList<>();
        for (RectF rectF : this.mCurrentRectFHighlight) {
            if (rectF != null) {
                arrayList.add(this.mSimpleComposerView.convertViewRectIntoContentRect(rectF));
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        HighLightView highLightView = this.mHighLightView;
        highLightView.setRectF(arrayList, highLightView.getMType(), getTag().equals("merge"));
        this.mHighLightView.invalidate();
        updateEditMergeButton(arrayList.get(0), this.mHighLightView.getMType());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewerFragment
    public void requestFitToScreenPreview() {
        SimpleComposerView simpleComposerView = this.mSimpleComposerView;
        if (simpleComposerView != null) {
            simpleComposerView.requestFitToScreenPreview();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewerFragment
    public void requestPageLayout() {
        SimpleComposerView simpleComposerView = this.mSimpleComposerView;
        if (simpleComposerView != null) {
            simpleComposerView.requestPageLayout();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewerFragment
    public void setAutoScroll(boolean z) {
        SimpleComposerView simpleComposerView = this.mSimpleComposerView;
        if (simpleComposerView != null) {
            simpleComposerView.setAutoScroll(z);
        }
    }

    public void setCompareMainPresenter(CompareViewerContract.IPresenter iPresenter) {
        this.mCompareMainPresenter = iPresenter;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewerFragment
    public void setScrollView(float f) {
        SimpleComposerView simpleComposerView = this.mSimpleComposerView;
        if (simpleComposerView != null) {
            simpleComposerView.setScrollForModeCompare(f);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewerFragment
    public void setViewEditMergeButton(boolean z) {
        this.mCompareEditMergeBtn.setImageDrawable(getResources().getDrawable(z ? C9086R.drawable.compare_comment_delete : C9086R.drawable.compare_comment_add, null));
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewerFragment
    public void setZoomScale(float f) {
        SimpleComposerView simpleComposerView = this.mSimpleComposerView;
        if (simpleComposerView != null) {
            simpleComposerView.setZoomScale(f);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.simple.view.SimpleComposerFragment, com.samsung.android.support.senl.nt.composer.main.simple.presenter.SimpleComposerFragmentContract.IView
    public void updateTitle(String str) {
    }

    private void updateTitle() {
        String tag = getTag();
        TextView textView = (TextView) this.mFragmentView.findViewById(C9086R.id.title_text);
        if (tag != null) {
            this.mCompareMainPresenter.setTitle(tag, textView);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewerFragment
    public void setScrollView(float f, float f4) {
        SimpleComposerView simpleComposerView = this.mSimpleComposerView;
        if (simpleComposerView != null) {
            simpleComposerView.setScrollForModeCompare(f, f4);
        }
    }
}
