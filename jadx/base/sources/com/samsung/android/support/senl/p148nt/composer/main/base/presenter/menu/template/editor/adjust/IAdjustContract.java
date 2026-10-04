package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.adjust;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface IAdjustContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IView {
        Drawable getDrawable();

        void postOnAnimation(Runnable runnable);

        void release();

        void setImageBitmap(Bitmap bitmap);

        void setImageMatrix(Matrix matrix);

        void setOpacity(int i);
    }
}
