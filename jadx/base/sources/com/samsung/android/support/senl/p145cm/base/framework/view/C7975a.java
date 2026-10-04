package com.samsung.android.support.senl.p145cm.base.framework.view;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordSimpleMenu;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting.AbsStartingAnimation;

/* JADX INFO: renamed from: com.samsung.android.support.senl.cm.base.framework.view.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class C7975a implements OnApplyWindowInsetsListener, SimpleLottieValueCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5800a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f5801b;

    public /* synthetic */ C7975a(int i, int i2) {
        this.f5800a = i2;
        this.f5801b = i;
    }

    @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
    public Object getValue(LottieFrameInfo lottieFrameInfo) {
        switch (this.f5800a) {
            case 1:
                return VoiceRecordSimpleMenu.updateButtonColor$lambda$13(this.f5801b, lottieFrameInfo);
            default:
                return AbsStartingAnimation.initAnimation$lambda$1(this.f5801b, lottieFrameInfo);
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return WindowManagerCompat.updateSystemBarInsets$lambda$0(this.f5801b, view, windowInsetsCompat);
    }
}
