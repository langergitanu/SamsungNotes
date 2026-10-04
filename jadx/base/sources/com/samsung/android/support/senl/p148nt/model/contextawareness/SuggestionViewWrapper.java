package com.samsung.android.support.senl.p148nt.model.contextawareness;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionData;
import com.samsung.android.app.sdk.deepsky.suggestion.view.SuggestionView;
import com.samsung.android.app.sdk.deepsky.suggestion.view.SuggestionViewConfig;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.model.common.log.CALogger;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.SuggestionInfo;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.SuggestionInfoFactory;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SuggestionViewWrapper extends FrameLayout {
    private static final String TAG = CALogger.createTag("SuggestionViewWrapper");
    private OnButtonClickListener mOnButtonClickListener;
    private OnExpiredListener mOnExpiredListener;
    private OnSwipeDismissListener mOnSwipeDismissListener;
    private SuggestionView mSuggestionView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnButtonClickListener {
        void onClick(SuggestionInfo suggestionInfo, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnExpiredListener {
        void onExpired(@NonNull String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnSwipeDismissListener {
        void onDismiss();
    }

    public SuggestionViewWrapper(@NonNull Context context) {
        super(context);
        init();
    }

    private void init() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        SuggestionView suggestionView = new SuggestionView(getContext());
        this.mSuggestionView = suggestionView;
        suggestionView.setVisibility(8);
        addView(this.mSuggestionView, layoutParams);
        this.mSuggestionView.setOnClickListener(new SuggestionView.OnSuggestionClickListener() { // from class: com.samsung.android.support.senl.nt.model.contextawareness.SuggestionViewWrapper.1
            @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SuggestionView.OnSuggestionClickListener
            public void onClick(@NonNull SuggestionData suggestionData, int i) {
                Logger.m8697d(SuggestionViewWrapper.TAG, "onClick# " + suggestionData);
                if (SuggestionViewWrapper.this.mOnButtonClickListener != null) {
                    SuggestionViewWrapper.this.mOnButtonClickListener.onClick(SuggestionInfoFactory.getInstance().makeSuggestionInfo(suggestionData), i);
                }
            }
        });
        this.mSuggestionView.setOnExpiredListener(new SuggestionView.OnExpiredListener() { // from class: com.samsung.android.support.senl.nt.model.contextawareness.SuggestionViewWrapper.2
            @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SuggestionView.OnExpiredListener
            public void onExpired(@NonNull String str) {
                AbstractC4539a.m3188B("onExpired# ", str, SuggestionViewWrapper.TAG);
                if (SuggestionViewWrapper.this.mOnExpiredListener != null) {
                    SuggestionViewWrapper.this.mOnExpiredListener.onExpired(str);
                }
            }
        });
        this.mSuggestionView.setOnDismissedListener(new SuggestionView.OnDismissedListener() { // from class: com.samsung.android.support.senl.nt.model.contextawareness.SuggestionViewWrapper.3
            @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SuggestionView.OnDismissedListener
            public void onDismissed() {
                Logger.m8697d(SuggestionViewWrapper.TAG, "onDismissed# ");
                if (SuggestionViewWrapper.this.mOnSwipeDismissListener != null) {
                    SuggestionViewWrapper.this.mOnSwipeDismissListener.onDismiss();
                }
            }
        });
    }

    public boolean isSuggestionViewVisible() {
        return this.mSuggestionView.getVisibility() == 0;
    }

    public void setGoneState() {
        this.mSuggestionView.releaseViewConfig();
        setSuggestionViewVisibility(8);
    }

    public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
        this.mOnButtonClickListener = onButtonClickListener;
    }

    public void setOnExpiredListener(OnExpiredListener onExpiredListener) {
        this.mOnExpiredListener = onExpiredListener;
    }

    public void setOnSwipeDismissListener(OnSwipeDismissListener onSwipeDismissListener) {
        this.mOnSwipeDismissListener = onSwipeDismissListener;
    }

    public void setSuggestionViewVisibility(int i) {
        this.mSuggestionView.setVisibility(i);
    }

    public void updateSuggestionView(IContextAwarenessResult iContextAwarenessResult, RemoteViews remoteViews, List<Integer> list, List<String> list2, List<String> list3, int i) {
        this.mSuggestionView.setViewConfig(new SuggestionViewConfig.Builder(iContextAwarenessResult.getSuggestionItem(), remoteViews, i).addClickableId(list).setMaxSuggestionCount(1).setMaxListItemVisibleCount(1).enableSwipeDismiss(true).setIncludedDataId(list2).setExcludedDataId(list3).build());
    }

    public SuggestionViewWrapper(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SuggestionViewWrapper(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public SuggestionViewWrapper(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }
}
