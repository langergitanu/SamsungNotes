package com.samsung.android.support.senl.addons.base.model.event;

import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/event/ITouchEvent;", "", "getView", "Landroid/view/View;", TextConst.METHOD_GET_EVENT, "Landroid/view/MotionEvent;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ITouchEvent {
    @Nullable
    MotionEvent getEvent();

    @Nullable
    View getView();
}
