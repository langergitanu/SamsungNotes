package com.samsung.android.support.senl.addons.base.viewmodel;

import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0005H&¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/viewmodel/IUndoRedoViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel;", "onUndoClicked", "", "onUndoLongClicked", "", "onRedoClicked", "onRedoLongClicked", "getUndoSelected", "getUndoEnabled", "getRedoSelected", "getRedoEnabled", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IUndoRedoViewModel extends IBaseViewModel {
    boolean getRedoEnabled();

    boolean getRedoSelected();

    boolean getUndoEnabled();

    boolean getUndoSelected();

    void onRedoClicked();

    boolean onRedoLongClicked();

    void onUndoClicked();

    boolean onUndoLongClicked();
}
