package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor;

import android.graphics.Bitmap;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.TEAdjustModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.image.TEImageModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.Observable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TemplateEditorModel extends Observable {
    private static final String TAG = CTLogger.createTag("TemplateEditorModel");
    private TEAdjustModel mAdjustModel;
    private TEImageModel mImageModel;

    public TemplateEditorModel(Bitmap bitmap, String str, int i, int i2, String str2) {
        this.mImageModel = new TEImageModel(bitmap, str, i, i2, str2);
        this.mAdjustModel = new TEAdjustModel(this.mImageModel);
    }

    public void close() {
        Logger.m11003i(TAG, "close");
        this.mAdjustModel.close();
        this.mAdjustModel = null;
        this.mImageModel.close();
        this.mImageModel = null;
    }

    public TEAdjustModel getAdjustModel() {
        return this.mAdjustModel;
    }

    public TEImageModel getImageModel() {
        return this.mImageModel;
    }
}
