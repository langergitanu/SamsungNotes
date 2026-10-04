package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectPainting;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface IObjectInserter {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IOptions {
    }

    boolean insertBodyText(SpenObjectShape spenObjectShape, SpenWPage spenWPage, float f, boolean z);

    SpenWPage insertObject(SpenWPage spenWPage, SpenObjectBase spenObjectBase, PointF pointF, @Nullable IOptions iOptions, boolean z);

    void insertObject(ArrayList<SpenObjectBase> arrayList, int i);

    void insertObjectKeepPage(SpenWPage spenWPage, SpenObjectBase spenObjectBase, PointF pointF, boolean z);

    void insertPainting(SpenObjectPainting spenObjectPainting, int i);

    void insertVoice(SpenObjectVoice spenObjectVoice, int i);

    boolean isObjectSpan();

    void setHwMode(boolean z);
}
