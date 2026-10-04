package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.directwrite;

import android.graphics.Rect;
import android.os.Bundle;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface DwToolbarContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IView {
        Rect getVisibleRect();

        boolean isDirectWriteRecognizing();

        void onSaveInstanceState(@NonNull Bundle bundle);

        void onSpenToTextResultInserted();

        void restore(Bundle bundle);

        void setKeyboardFunctionKeyEnable(boolean z);
    }
}
