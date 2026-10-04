package com.samsung.android.support.senl.addons.base.view.common;

import android.view.View;
import com.samsung.android.support.senl.addons.base.viewmodel.ILifeCycleObserver;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/view/common/IBindHelper;", "", "getRoot", "Landroid/view/View;", "getLifeCycleObserver", "Lcom/samsung/android/support/senl/addons/base/viewmodel/ILifeCycleObserver;", "unBind", "", "close", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IBindHelper {
    void close();

    @Nullable
    ILifeCycleObserver getLifeCycleObserver();

    @Nullable
    View getRoot();

    void unBind();
}
