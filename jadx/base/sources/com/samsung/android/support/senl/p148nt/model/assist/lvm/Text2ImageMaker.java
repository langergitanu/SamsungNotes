package com.samsung.android.support.senl.p148nt.model.assist.lvm;

import android.content.Context;
import android.os.Bundle;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class Text2ImageMaker extends ImageMaker {
    private static final String TAG = "Text2ImageMaker";
    private String mTextData;

    public Text2ImageMaker(Context context) {
        super(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.lvm.Operator
    public SCSRequesterType getRequestType() {
        return SCSRequesterType.TextToImage;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.lvm.ImageMaker
    public String getTAG() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.lvm.Operator
    public void operate() {
        if (isReleased()) {
            Logger.m8697d(TAG, "operate, ignore already released: " + hashCode());
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("style", this.mImageStyle);
            bundle.putString("textInfo", this.mTextData);
            this.mImpl.requestImage(getRequestType(), null, bundle);
        }
    }

    public void setTextData(String str) {
        this.mTextData = str;
    }
}
