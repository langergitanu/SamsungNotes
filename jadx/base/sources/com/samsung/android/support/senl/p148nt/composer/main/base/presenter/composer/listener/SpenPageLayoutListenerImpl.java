package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.composer.listener.SpenPageLayoutListener;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.CvPageSettingController;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SpenPageLayoutListenerImpl extends SpenPageLayoutListener {
    private static final String TAG = Logger.createTag("SpenPageLayoutListenerImpl");
    private CvPageSettingController mCvPageSettingController;

    public SpenPageLayoutListenerImpl(CvPageSettingController cvPageSettingController) {
        this.mCvPageSettingController = cvPageSettingController;
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenPageLayoutListener
    public void onChanged(int i, int i2, boolean z, boolean z2) {
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "onChanged# ", SQLKeyword.COMMA, SQLKeyword.COMMA);
        sbM1173s.append(z);
        sbM1173s.append(SQLKeyword.COMMA);
        sbM1173s.append(z2);
        Logger.m10999d(str, sbM1173s.toString());
        this.mCvPageSettingController.setPageLayout(i, i2, z2);
    }
}
