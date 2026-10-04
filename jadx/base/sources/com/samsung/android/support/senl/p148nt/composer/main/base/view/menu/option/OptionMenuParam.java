package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option;

import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.IMenuInflater;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuParam {
    private Integer mChildResId;
    private IMenuInflater mMenuInflater;
    private Object mTarget;

    public OptionMenuParam(Object obj) {
        this.mTarget = obj;
    }

    public Integer getChildResId() {
        return this.mChildResId;
    }

    @Nullable
    public IMenuInflater getMenuInflater() {
        return this.mMenuInflater;
    }

    public Object getTarget() {
        return this.mTarget;
    }

    public OptionMenuParam setChildResId(int i) {
        this.mChildResId = Integer.valueOf(i);
        return this;
    }

    public void setMenuInflater(IMenuInflater iMenuInflater) {
        this.mMenuInflater = iMenuInflater;
    }

    public OptionMenuParam(Object obj, int i) {
        this.mTarget = obj;
        this.mChildResId = Integer.valueOf(i);
    }
}
