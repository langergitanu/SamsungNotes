package com.samsung.android.support.senl.p148nt.composer.main.simple.presenter.listener;

import com.samsung.android.sdk.composer.SpenComposer;
import com.samsung.android.sdk.composer.listener.SpenComposerListenerManager;
import com.samsung.android.support.senl.p148nt.composer.main.simple.presenter.listener.ISimpleListenerContract;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000f\u001a\u00020\u0010R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/simple/presenter/listener/SimpleComposerListenerManager;", "", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/simple/presenter/listener/ISimpleListenerContract$IPresenter;", "view", "Lcom/samsung/android/sdk/composer/SpenComposer;", "tag", "", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/simple/presenter/listener/ISimpleListenerContract$IPresenter;Lcom/samsung/android/sdk/composer/SpenComposer;Ljava/lang/String;)V", "mPresenter", "mPageActionListener", "Lcom/samsung/android/support/senl/nt/composer/main/simple/presenter/listener/SimpleComposerPageActionListenerImpl;", "mView", "mTag", "init", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SimpleComposerListenerManager {

    @Nullable
    private SimpleComposerPageActionListenerImpl mPageActionListener;

    @Nullable
    private ISimpleListenerContract.IPresenter mPresenter;

    @Nullable
    private String mTag;

    @Nullable
    private SpenComposer mView;

    public SimpleComposerListenerManager(@Nullable ISimpleListenerContract.IPresenter iPresenter, @Nullable SpenComposer spenComposer, @Nullable String str) {
        this.mPresenter = iPresenter;
        this.mView = spenComposer;
        this.mTag = str;
    }

    public final void init() {
        SpenComposerListenerManager listenerManager;
        ISimpleListenerContract.IPresenter iPresenter = this.mPresenter;
        SpenComposer spenComposer = this.mView;
        this.mPageActionListener = new SimpleComposerPageActionListenerImpl(iPresenter, spenComposer != null ? spenComposer.getNotePageLayouter() : null, this.mTag);
        SpenComposer spenComposer2 = this.mView;
        if (spenComposer2 == null || (listenerManager = spenComposer2.getListenerManager()) == null) {
            return;
        }
        listenerManager.setPageActionListener(this.mPageActionListener);
    }
}
