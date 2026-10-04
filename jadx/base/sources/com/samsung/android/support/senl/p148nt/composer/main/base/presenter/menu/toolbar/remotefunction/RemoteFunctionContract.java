package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RemoteFunctionContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface InnerContract extends PresenterContract {
        void onInvalidVersion();

        void onValidVersion();

        void sendMessage(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PresenterContract {
        void disableAIAssist();

        void disableDynamicWeightAndFixedOpacityFeature();

        @RemoteConstant.RemoteSenderType
        int getRemoteType();

        boolean isAIAssistDisabled();

        boolean isDynamicWeightAndFixedOpacityFeatureDisabled();

        boolean isRemotedFunctionCall();

        void remoteFunctionCall(String str, String str2, Object... objArr);

        void remoteFunctionSync(String str, String str2, Object... objArr);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TargetClassContract {
        void init();
    }
}
