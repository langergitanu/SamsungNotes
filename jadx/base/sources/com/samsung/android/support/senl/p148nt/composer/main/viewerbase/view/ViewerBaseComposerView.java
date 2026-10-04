package com.samsung.android.support.senl.p148nt.composer.main.viewerbase.view;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.ComposerView;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ViewerBaseComposerView extends ComposerView {
    public ViewerBaseComposerView(Activity activity, @NonNull Config config) {
        super(activity, config);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.ComposerView, com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void init(SpenWNote spenWNote) {
        super.init(spenWNote);
        setModeOfSpenComposerView(false, 4);
    }
}
