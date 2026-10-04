package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.DecoratorLayout;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageMoveButton {
    private static final boolean FLAG_DISABLED = true;
    private static final String TAG = Logger.createTag("PageMoveButton");
    private ComposerViewState mComposerViewState;
    private Contract mContract;
    private DecoratorLayout mDecoratorLayout;
    private View mNextPageBtn;
    private View mPrevPageBtn;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void goToPage(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNextButtonVisibility() {
        return (this.mComposerViewState.getLastPageCount() + (-2)) - (this.mComposerViewState.isTwoPageView() ? 1 : 0) > this.mComposerViewState.getLastPageIndex() ? 0 : 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPrevButtonVisibility() {
        return this.mComposerViewState.getLastPageIndex() != 0 ? 0 : 4;
    }

    private void initOnMousePointerListener() {
        this.mDecoratorLayout.setOnMousePointerListener(new DecoratorLayout.OnMousePointerListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.PageMoveButton.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.DecoratorLayout.OnMousePointerListener
            public void onMousePointer(MotionEvent motionEvent) {
                int x = (int) motionEvent.getX();
                int y2 = (int) motionEvent.getY();
                PageMoveButton pageMoveButton = PageMoveButton.this;
                pageMoveButton.updateVisibleState(pageMoveButton.mNextPageBtn, x, y2, true);
                PageMoveButton pageMoveButton2 = PageMoveButton.this;
                pageMoveButton2.updateVisibleState(pageMoveButton2.mPrevPageBtn, x, y2, false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVisibleState(View view, int i, int i2, boolean z) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        if (!rect.contains(i, i2)) {
            view.setVisibility(4);
        } else {
            if (view.getVisibility() == 0) {
                return;
            }
            if (z) {
                view.setVisibility(getNextButtonVisibility());
            } else {
                view.setVisibility(getPrevButtonVisibility());
            }
        }
    }

    public void init(ViewGroup viewGroup, ComposerViewState composerViewState, Contract contract) {
        this.mContract = contract;
        this.mComposerViewState = composerViewState;
        DecoratorLayout decoratorLayout = (DecoratorLayout) viewGroup.findViewById(C9086R.id.comp_view_decor_layout);
        this.mDecoratorLayout = decoratorLayout;
        this.mNextPageBtn = decoratorLayout.findViewById(C9086R.id.move_next_page_btn);
        this.mPrevPageBtn = this.mDecoratorLayout.findViewById(C9086R.id.move_previous_page_btn);
        this.mNextPageBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.PageMoveButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.m10999d(PageMoveButton.TAG, "nextPageBtn#onClick#");
                PageMoveButton.this.mContract.goToPage(PageMoveButton.this.mComposerViewState.getLastPageIndex() + (PageMoveButton.this.mComposerViewState.isTwoPageView() ? 2 : 1));
                view.setVisibility(PageMoveButton.this.getNextButtonVisibility());
            }
        });
        this.mPrevPageBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.PageMoveButton.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.m10999d(PageMoveButton.TAG, "prevPageBtn#onClick#");
                PageMoveButton.this.mContract.goToPage(PageMoveButton.this.mComposerViewState.getLastPageIndex() - 1);
                view.setVisibility(PageMoveButton.this.getPrevButtonVisibility());
            }
        });
    }

    public void setEnabled(boolean z) {
    }
}
