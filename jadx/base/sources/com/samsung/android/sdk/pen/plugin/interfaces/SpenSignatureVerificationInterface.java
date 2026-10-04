package com.samsung.android.sdk.pen.plugin.interfaces;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0014J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0016\u0010\u000f\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0011H&¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenSignatureVerificationInterface;", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenPluginInterface;", "register", "", "stroke", "", "Lcom/samsung/android/sdk/pen/document/SpenObjectStroke;", "unregisterAll", "getRegisteredCount", "", "getMinimumRequiredCount", "request", "setResultListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenSignatureVerificationInterface$ResultListener;", "prepareRegistration", "isRegistrationPrepared", "", "completeRegistration", "isRegistrationCompleted", "ResultListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenSignatureVerificationInterface extends SpenPluginInterface {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenSignatureVerificationInterface$ResultListener;", "", "onResult", "", "input", "", "Lcom/samsung/android/sdk/pen/document/SpenObjectStroke;", "result", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ResultListener {
        void onResult(@NotNull List<SpenObjectStroke> input, boolean result);
    }

    void completeRegistration();

    int getMinimumRequiredCount();

    int getRegisteredCount();

    boolean isRegistrationCompleted();

    boolean isRegistrationPrepared();

    void prepareRegistration(@NotNull List<SpenObjectStroke> stroke);

    void register(@NotNull List<SpenObjectStroke> stroke);

    void request(@NotNull List<SpenObjectStroke> stroke);

    void setResultListener(@Nullable ResultListener listener);

    void unregisterAll();
}
