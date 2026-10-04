package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class PageIndexView {
    private static final String PAGE_FORMAT = "%d/%d";
    private PositionUpdater mPositionUpdater;
    private final TextView mView;
    private AtomicInteger mPageIndex = new AtomicInteger();
    private AtomicInteger mPageCount = new AtomicInteger();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class HorizontalPositionUpdater extends PositionUpdater {
        float mAnchorHalfW;

        public HorizontalPositionUpdater() {
        }

        private float getStartDistance() {
            return this.mAnchorHalfW - (PageIndexView.this.mView.getWidth() / 2.0f);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.PageIndexView.PositionUpdater
        public float adjustBoundary(float f) {
            return Math.min(Math.max(this.mRangeStart, f), this.mRangeEnd - PageIndexView.this.mView.getWidth());
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.PageIndexView.PositionUpdater
        public void setUpdatePosition(View view, int i, int i2) {
            Resources resources = view.getResources();
            float y2 = (view.getY() - resources.getDimensionPixelOffset(C9086R.dimen.comp_fast_scroll_horizontal_gap_between_page_index)) - (PageIndexView.this.mView.getHeight() == 0 ? resources.getDimensionPixelSize(C9086R.dimen.comp_page_index_view_min_height) : PageIndexView.this.mView.getHeight());
            this.mInitialized = checkInitialized(PageIndexView.this.mView);
            PageIndexView.this.mView.setTranslationY(y2);
            this.mRangeStart = i;
            this.mRangeEnd = i2;
            this.mAnchorHalfW = view.getWidth() / 2.0f;
            if (this.mInitialized) {
                updateVariablePosition(view);
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.PageIndexView.PositionUpdater
        public void updateVariablePosition(View view) {
            if (!this.mInitialized) {
                setUpdatePosition(view, (int) this.mRangeStart, (int) this.mRangeEnd);
            }
            PageIndexView.this.mView.setTranslationX(adjustBoundary(view.getX() + getStartDistance()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class PositionUpdater {
        boolean mInitialized = false;
        float mRangeEnd;
        float mRangeStart;

        public float adjustBoundary(float f) {
            return Math.min(Math.max(this.mRangeStart, f), this.mRangeEnd);
        }

        public boolean checkInitialized(View view) {
            return (view.getHeight() == 0 || view.getWidth() == 0) ? false : true;
        }

        public abstract void setUpdatePosition(View view, int i, int i2);

        public abstract void updateVariablePosition(View view);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class VerticalPositionUpdater extends PositionUpdater {
        float mStartDistance;

        public VerticalPositionUpdater() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.PageIndexView.PositionUpdater
        public void setUpdatePosition(View view, int i, int i2) {
            int dimensionPixelOffset = view.getResources().getDimensionPixelOffset(C9086R.dimen.comp_fast_scroll_vertical_gap_between_page_index);
            float x = LocaleUtils.isRTLMode() ? view.getX() + view.getWidth() + dimensionPixelOffset : (view.getX() - dimensionPixelOffset) - PageIndexView.this.mView.getWidth();
            this.mInitialized = checkInitialized(PageIndexView.this.mView);
            PageIndexView.this.mView.setTranslationX(x);
            this.mRangeStart = i;
            this.mRangeEnd = i2 - PageIndexView.this.mView.getHeight();
            this.mStartDistance = (view.getHeight() / 2.0f) - (PageIndexView.this.mView.getHeight() / 2.0f);
            if (this.mInitialized) {
                updateVariablePosition(view);
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.PageIndexView.PositionUpdater
        public void updateVariablePosition(View view) {
            if (!this.mInitialized) {
                setUpdatePosition(view, (int) this.mRangeStart, (int) this.mRangeEnd);
            }
            PageIndexView.this.mView.setTranslationY(adjustBoundary(view.getY() + this.mStartDistance));
        }
    }

    public PageIndexView(View view) {
        this.mView = (TextView) view.findViewById(C9086R.id.comp_scroll_bar_page_index);
    }

    public PositionUpdater getPositionUpdater() {
        return this.mPositionUpdater;
    }

    public void hide() {
        this.mView.setVisibility(8);
    }

    public void invisible() {
        this.mView.setVisibility(4);
    }

    public boolean isShowing() {
        return this.mView.getVisibility() == 0;
    }

    public void setDirection(boolean z) {
        if (z) {
            this.mPositionUpdater = new VerticalPositionUpdater();
        } else {
            this.mPositionUpdater = new HorizontalPositionUpdater();
        }
    }

    public boolean setPageCount(int i) {
        int iMax = Math.max(i - 1, 0);
        if (this.mPageCount.get() == iMax) {
            return false;
        }
        this.mPageCount.set(iMax);
        return true;
    }

    public boolean setPageIndex(int i) {
        int iMin = Math.min(i + 1, this.mPageCount.get());
        if (this.mPageIndex.get() == iMin) {
            return false;
        }
        this.mPageIndex.set(iMin);
        return true;
    }

    public void show() {
        updateText();
        this.mView.setVisibility(0);
    }

    public void updateText() {
        if (LocaleUtils.isRTLMode()) {
            this.mView.setText(String.format(Locale.getDefault(), PAGE_FORMAT, Integer.valueOf(this.mPageCount.get()), Integer.valueOf(this.mPageIndex.get())));
        } else {
            this.mView.setText(String.format(Locale.getDefault(), PAGE_FORMAT, Integer.valueOf(this.mPageIndex.get()), Integer.valueOf(this.mPageCount.get())));
        }
    }
}
