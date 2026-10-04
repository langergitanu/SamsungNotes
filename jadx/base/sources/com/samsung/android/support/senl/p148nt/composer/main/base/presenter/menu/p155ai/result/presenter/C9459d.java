package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import androidx.core.util.Consumer;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.SummaryOptionDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.LanguageIdentifier;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormat;
import java.util.Locale;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C9459d implements LanguageIdentifier.AsyncCallback, SummaryOptionDialogPresenter.Contract {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6873a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6874b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f6875c;

    public /* synthetic */ C9459d(Object obj, Object obj2, int i) {
        this.f6873a = i;
        this.f6874b = obj;
        this.f6875c = obj2;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.LanguageIdentifier.AsyncCallback
    public void onCompleted(Locale locale) {
        ((AutoFormat.MeetingFormat) this.f6874b).lambda$identifyLanguage$0((Consumer) this.f6875c, locale);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.SummaryOptionDialogPresenter.Contract
    public void setOption(int i) {
        switch (this.f6873a) {
            case 1:
                ((STTSummarization) this.f6874b).lambda$showSTTSummaryOptionDialog$0((Runnable) this.f6875c, i);
                break;
            default:
                ((Summarization) this.f6874b).lambda$showOptionDialog$0((Runnable) this.f6875c, i);
                break;
        }
    }
}
