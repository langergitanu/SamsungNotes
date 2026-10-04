package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.app.Activity;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.text.SpenTextLimitListener;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class TextEventListenerImpl extends SpenTextLimitListener implements SpenWNote.TextEventListener {
    private static final String TAG = Logger.createTag("TextEventListenerImpl");
    private Activity mActivity;

    public TextEventListenerImpl(Activity activity) {
        this.mActivity = activity;
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.TextEventListener
    public void onExceedTextLimit(SpenWPage spenWPage, SpenObjectShape spenObjectShape, int i) {
        onExceedTextLimit(i);
    }

    public void release() {
        this.mActivity = null;
    }

    @Override // com.samsung.android.sdk.pen.text.SpenTextLimitListener
    public void onExceedTextLimit(final int i) {
        Logger.m11004w(TAG, "onExceedTextLimit# " + i);
        if (CommonUtils.isNotAvailableActivity(this.mActivity)) {
            return;
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.TextEventListenerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                if (CommonUtils.isNotAvailableActivity(TextEventListenerImpl.this.mActivity)) {
                    return;
                }
                ToastHandler.show(TextEventListenerImpl.this.mActivity, TextEventListenerImpl.this.mActivity.getString(C9086R.string.composer_maximum_input, Integer.valueOf(i)), 0);
            }
        });
    }
}
