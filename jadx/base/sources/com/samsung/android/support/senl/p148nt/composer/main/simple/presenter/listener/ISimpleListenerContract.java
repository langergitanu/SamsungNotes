package com.samsung.android.support.senl.p148nt.composer.main.simple.presenter.listener;

import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/simple/presenter/listener/ISimpleListenerContract;", "", "IPresenter", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ISimpleListenerContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/simple/presenter/listener/ISimpleListenerContract$IPresenter;", "", "doc", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "getDoc", "()Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IPresenter {
        @Nullable
        SpenWNote getDoc();
    }
}
