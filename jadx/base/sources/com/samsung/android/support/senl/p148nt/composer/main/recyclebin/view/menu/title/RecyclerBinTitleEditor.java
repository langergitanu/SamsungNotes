package com.samsung.android.support.senl.p148nt.composer.main.recyclebin.view.menu.title;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title.TitleEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.TitleEditor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RecyclerBinTitleEditor extends TitleEditor {
    public RecyclerBinTitleEditor(Activity activity, Fragment fragment, TitleEditorPresenter titleEditorPresenter) {
        super(activity, fragment, titleEditorPresenter);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.TitleEditor
    public void init(Context context) {
        super.init(context);
        this.mViewSet.getTitleView().updateEditableState(false);
        this.mViewSet.getFavorite().setEnable(false);
        this.mViewSet.getCoeditAddMember().setEnable(false);
    }
}
