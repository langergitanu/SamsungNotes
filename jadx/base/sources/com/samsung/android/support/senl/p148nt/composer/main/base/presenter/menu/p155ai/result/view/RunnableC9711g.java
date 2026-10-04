package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewSTT;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewSummarization;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AutoFormatResultView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AutoFormatStreamingResultView;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9711g implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6947a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6948b;

    public /* synthetic */ RunnableC9711g(Object obj, int i) {
        this.f6947a = i;
        this.f6948b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6947a) {
            case 0:
                AiMenuResultView.C958017.lambda$updateResultState$0((AutoFormatResultView) this.f6948b);
                break;
            case 1:
                ((AiMenuResultView.C958017) this.f6948b).lambda$updateResultState$1();
                break;
            case 2:
                ((AiMenuResultViewSTT.C96199) this.f6948b).lambda$onReceive$0();
                break;
            case 3:
                ((AiMenuResultViewSummarization.C96541) this.f6948b).lambda$onBeforeTextChangedByKeyBoard$0();
                break;
            case 4:
                ((AiMenuResultViewSummarization.C96574) this.f6948b).lambda$onObjectChanged$0();
                break;
            case 5:
                ((AutoFormatResultView.C96651) this.f6948b).lambda$onObjectChanged$0();
                break;
            case 6:
                ((AutoFormatResultView.C96662) this.f6948b).lambda$onBeforeTextChangedByKeyBoard$0();
                break;
            case 7:
                ((AutoFormatStreamingResultView.C96681) this.f6948b).lambda$onBeforeTextChangedByKeyBoard$0();
                break;
            case 8:
                ((AutoFormatStreamingResultView.C96692) this.f6948b).lambda$onObjectChanged$0();
                break;
            case 9:
                ((LottieAnimationView) this.f6948b).playAnimation();
                break;
            case 10:
                ((AiMenuResultViewSTTSummarization) this.f6948b).updateTranslateMode();
                break;
            case 11:
                ((AiMenuResultViewSummarization) this.f6948b).lambda$showSettingDialog$4();
                break;
            case 12:
                ((AiMenuResultViewTranslation) this.f6948b).lambda$onLanguageDownload$5();
                break;
            case 13:
                ((TextView) this.f6948b).requestLayout();
                break;
            default:
                ((CreateImageResultViewManager) this.f6948b).lambda$onCompleted$2();
                break;
        }
    }
}
