package com.samsung.android.support.senl.p148nt.app.main.tablet.presenter;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.IdRes;
import com.samsung.android.support.senl.p148nt.app.C8003R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TabletTipCardAnimatorHelper {
    private TipCardInfo mMessageTipCardInfo;
    private final PresenterContract mPresenterContract;
    private TipCardInfo mTitleTipCardInfo;
    private View mTipcardTextContainer = null;
    private boolean mIsDrawerOpened = false;
    private int mTipCardHeight = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PresenterContract {
        <T extends View> T findViewById(@IdRes int i);

        int getSlideWidth();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TipCardInfo {
        int lineCount = 0;
        int lineHeight = 0;
        int lineGap = 0;
        TextView textView = null;

        public void clear() {
            this.lineCount = 0;
            this.lineHeight = 0;
            this.lineGap = 0;
            this.textView = null;
        }
    }

    public TabletTipCardAnimatorHelper(PresenterContract presenterContract) {
        this.mTitleTipCardInfo = null;
        this.mMessageTipCardInfo = null;
        this.mPresenterContract = presenterContract;
        this.mTitleTipCardInfo = new TipCardInfo();
        this.mMessageTipCardInfo = new TipCardInfo();
    }

    private void setTipCardInfo(TextView textView, int i, TipCardInfo tipCardInfo) {
        if (textView == null) {
            return;
        }
        tipCardInfo.textView = textView;
        int lineCount = textView.getLineCount();
        if (lineCount <= 0) {
            return;
        }
        int lineSpacingExtra = (int) (i - (textView.getLineSpacingExtra() * 2.0f));
        textView.measure(0, 0);
        float lineWidth = textView.getLayout().getLineWidth(0);
        float f = lineSpacingExtra;
        int i2 = (int) ((lineWidth / f) + (lineWidth % f > 0.0f ? 1 : 0));
        Rect rect = new Rect();
        textView.getLineBounds(0, rect);
        if (this.mIsDrawerOpened) {
            tipCardInfo.lineCount = i2;
            tipCardInfo.lineGap = (lineCount - i2) * rect.height();
            tipCardInfo.lineHeight = rect.height() * i2;
        } else {
            tipCardInfo.lineCount = i2;
            tipCardInfo.lineGap = (i2 - lineCount) * rect.height();
            tipCardInfo.lineHeight = rect.height() * lineCount;
        }
    }

    public void setIsDrawerOpened(boolean z) {
        this.mIsDrawerOpened = z;
    }

    public void touchDown() {
        View viewFindViewById = this.mPresenterContract.findViewById(C8003R.id.tipcard_layout);
        if (viewFindViewById == null) {
            return;
        }
        View viewFindViewById2 = viewFindViewById.findViewById(C8003R.id.tipcard_text_container);
        this.mTipcardTextContainer = viewFindViewById2;
        if (viewFindViewById2 == null) {
            return;
        }
        int slideWidth = (this.mPresenterContract.getSlideWidth() * (this.mIsDrawerOpened ? 1 : -1)) + viewFindViewById2.getMeasuredWidth();
        this.mTitleTipCardInfo.clear();
        this.mMessageTipCardInfo.clear();
        setTipCardInfo((TextView) this.mTipcardTextContainer.findViewById(C8003R.id.tipcard_title), slideWidth, this.mTitleTipCardInfo);
        setTipCardInfo((TextView) this.mTipcardTextContainer.findViewById(C8003R.id.tipcard_message), slideWidth, this.mMessageTipCardInfo);
        this.mTipcardTextContainer.getLayoutParams().height = -2;
        this.mTipcardTextContainer.requestLayout();
        this.mTipcardTextContainer.measure(0, 0);
        this.mTipCardHeight = this.mTipcardTextContainer.getMeasuredHeight();
    }

    public void updateTipcardLayout(float f) {
        if (this.mTipcardTextContainer == null || this.mTipCardHeight == 0) {
            return;
        }
        if (f > 0.95f || f < 0.05f) {
            TextView textView = this.mTitleTipCardInfo.textView;
            if (textView != null) {
                textView.setMaxLines(2);
            }
            TextView textView2 = this.mMessageTipCardInfo.textView;
            if (textView2 != null) {
                textView2.setMaxLines(10);
            }
        } else {
            TipCardInfo tipCardInfo = this.mTitleTipCardInfo;
            TextView textView3 = tipCardInfo.textView;
            if (textView3 != null && tipCardInfo.lineCount > 0) {
                int maxLines = textView3.getMaxLines();
                TipCardInfo tipCardInfo2 = this.mTitleTipCardInfo;
                int i = tipCardInfo2.lineCount;
                if (maxLines != i) {
                    tipCardInfo2.textView.setMaxLines(i);
                }
            }
            TipCardInfo tipCardInfo3 = this.mMessageTipCardInfo;
            TextView textView4 = tipCardInfo3.textView;
            if (textView4 != null && tipCardInfo3.lineCount > 0) {
                int maxLines2 = textView4.getMaxLines();
                TipCardInfo tipCardInfo4 = this.mMessageTipCardInfo;
                int i2 = tipCardInfo4.lineCount;
                if (maxLines2 != i2) {
                    tipCardInfo4.textView.setMaxLines(i2);
                }
            }
        }
        ViewGroup.LayoutParams layoutParams = this.mTipcardTextContainer.getLayoutParams();
        int i4 = this.mTipCardHeight;
        TipCardInfo tipCardInfo5 = this.mTitleTipCardInfo;
        float f4 = (tipCardInfo5.lineGap * f) + i4 + tipCardInfo5.lineHeight;
        TipCardInfo tipCardInfo6 = this.mMessageTipCardInfo;
        layoutParams.height = (int) ((tipCardInfo6.lineGap * f) + f4 + tipCardInfo6.lineHeight);
        this.mTipcardTextContainer.requestLayout();
    }
}
