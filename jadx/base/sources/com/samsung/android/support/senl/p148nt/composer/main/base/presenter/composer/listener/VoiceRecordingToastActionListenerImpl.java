package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import com.samsung.android.sdk.pen.engine.SpenToastActionListener;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/VoiceRecordingToastActionListenerImpl;", "Lcom/samsung/android/sdk/pen/engine/SpenToastActionListener;", "<init>", "()V", Constants.IntentExtraValue.SHOW, "", "charSequence", "", XmlErrorCodes.DURATION, "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceRecordingToastActionListenerImpl extends SpenToastActionListener {
    @Override // com.samsung.android.sdk.pen.engine.SpenToastActionListener
    public void show(@Nullable CharSequence charSequence, int duration) {
        if (charSequence == null) {
            Logger.m11000e("VoiceRecordingToastActionListenerImpl", "show# charSequence is null");
        } else {
            ToastHandler.showDefaultLayout(BaseUtils.getApplicationContext(), charSequence.toString(), duration);
        }
    }
}
