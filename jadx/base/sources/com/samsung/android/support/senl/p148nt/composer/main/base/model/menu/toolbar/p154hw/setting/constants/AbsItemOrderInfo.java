package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsItemOrderInfo {
    private final int mResourceId;
    private int mViewId;

    public AbsItemOrderInfo(@NonNull int i) {
        this.mResourceId = i;
    }

    public int getViewId() {
        return this.mViewId;
    }

    public View inflateView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(this.mResourceId, (ViewGroup) null);
        this.mViewId = viewInflate.getId();
        return viewInflate;
    }

    public void setHorizontal(View view, boolean z) {
    }
}
