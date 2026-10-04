package com.samsung.android.app.sdk.deepsky.donation;

import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.Gson;
import com.samsung.android.app.sdk.deepsky.common.AccessControl;
import com.samsung.android.app.sdk.deepsky.common.ContentProviderCaller;
import com.samsung.android.app.sdk.deepsky.donation.schema.DonationContract;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p014C3.RunnableC0054a;
import p066P2.RunnableC0201c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/donation/DonationImpl;", "Lcom/samsung/android/app/sdk/deepsky/donation/Donation;", "Lcom/samsung/android/app/sdk/deepsky/common/AccessControl;", "contentServiceCaller", "Lcom/samsung/android/app/sdk/deepsky/common/ContentProviderCaller;", "(Lcom/samsung/android/app/sdk/deepsky/common/ContentProviderCaller;)V", SearchConstants.TargetContents.TAG, "", "mExecutorService", "Ljava/util/concurrent/ExecutorService;", "checkIfAccessAllowed", "", "donate", "", "actionDonation", "Lcom/samsung/android/app/sdk/deepsky/donation/ActionDonation;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/app/sdk/deepsky/donation/DonationListener;", "donateForResult", "", "getDonatedActionStatus", "(Lcom/samsung/android/app/sdk/deepsky/donation/ActionDonation;)Ljava/lang/Boolean;", "removeDonatedData", "paramName", "paramValue", "sendDonatedActionInfo", "Landroid/os/Bundle;", "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class DonationImpl implements Donation, AccessControl {

    @NotNull
    private static final String KEY_DONATION_JSON = "key_donation_json";

    @NotNull
    private final String TAG;

    @NotNull
    private final ContentProviderCaller contentServiceCaller;

    @NotNull
    private final ExecutorService mExecutorService;

    public DonationImpl(@NotNull ContentProviderCaller contentServiceCaller) {
        Intrinsics.checkNotNullParameter(contentServiceCaller, "contentServiceCaller");
        this.contentServiceCaller = contentServiceCaller;
        this.TAG = "DonationImpl";
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor()");
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void donate$lambda$0(DonationImpl this$0, ActionDonation actionDonation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionDonation, "$actionDonation");
        this$0.sendDonatedActionInfo(actionDonation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void donate$lambda$1(DonationImpl this$0, ActionDonation actionDonation, DonationListener listener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionDonation, "$actionDonation");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        if (Intrinsics.areEqual(this$0.getDonatedActionStatus(actionDonation), Boolean.TRUE)) {
            listener.onSuccess();
        } else {
            listener.onFailure(2);
        }
    }

    private final Boolean getDonatedActionStatus(ActionDonation actionDonation) {
        Bundle bundleSendDonatedActionInfo = sendDonatedActionInfo(actionDonation);
        if (bundleSendDonatedActionInfo != null) {
            return Boolean.valueOf(bundleSendDonatedActionInfo.getBoolean(DonationContract.DONATION_RESULT_KEY, false));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeDonatedData$lambda$3(DonationImpl this$0, String paramName, String paramValue) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(paramName, "$paramName");
        Intrinsics.checkNotNullParameter(paramValue, "$paramValue");
        Bundle bundle = new Bundle();
        bundle.putString(DonationContract.KEY_PARAM_NAME_REMOVE, paramName);
        bundle.putString(DonationContract.KEY_PARAM_VALUE_REMOVE, new Gson().toJson(paramValue));
        ContentProviderCaller contentProviderCaller = this$0.contentServiceCaller;
        Uri content_uri = DonationContract.INSTANCE.getCONTENT_URI();
        Intrinsics.checkNotNullExpressionValue(content_uri, "DonationContract.CONTENT_URI");
        contentProviderCaller.sendCommand(content_uri, DonationContract.REMOVE_DONATED_DATA, bundle);
    }

    private final Bundle sendDonatedActionInfo(ActionDonation actionDonation) {
        String json = new Gson().toJson(actionDonation);
        ContentProviderCaller contentProviderCaller = this.contentServiceCaller;
        Uri content_uri = DonationContract.INSTANCE.getCONTENT_URI();
        Intrinsics.checkNotNullExpressionValue(content_uri, "DonationContract.CONTENT_URI");
        Bundle bundle = new Bundle();
        bundle.putString(KEY_DONATION_JSON, json);
        Unit unit = Unit.INSTANCE;
        return contentProviderCaller.sendCommand(content_uri, DonationContract.DONATION_METHOD_CALL, bundle);
    }

    @Override // com.samsung.android.app.sdk.deepsky.common.AccessControl
    public boolean checkIfAccessAllowed() {
        return true;
    }

    @Override // com.samsung.android.app.sdk.deepsky.donation.Donation
    public void donate(@NotNull ActionDonation actionDonation) {
        Intrinsics.checkNotNullParameter(actionDonation, "actionDonation");
        this.mExecutorService.execute(new RunnableC0054a(this, actionDonation, 6));
    }

    @Override // com.samsung.android.app.sdk.deepsky.donation.Donation
    public int donateForResult(@NotNull ActionDonation actionDonation) {
        Intrinsics.checkNotNullParameter(actionDonation, "actionDonation");
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            return Intrinsics.areEqual(getDonatedActionStatus(actionDonation), Boolean.TRUE) ? 0 : 2;
        }
        Log.e(this.TAG, "This method cannot be called in main thread");
        return 1;
    }

    @Override // com.samsung.android.app.sdk.deepsky.donation.Donation
    public void removeDonatedData(@NotNull String paramName, @NotNull String paramValue) {
        Intrinsics.checkNotNullParameter(paramName, "paramName");
        Intrinsics.checkNotNullParameter(paramValue, "paramValue");
        Log.i(this.TAG, "removeDonatedData inside");
        if (paramName.length() == 0 || paramValue.length() == 0) {
            return;
        }
        this.mExecutorService.execute(new RunnableC0201c(this, 4, paramName, paramValue));
    }

    @Override // com.samsung.android.app.sdk.deepsky.donation.Donation
    public void donate(@NotNull ActionDonation actionDonation, @NotNull DonationListener listener) {
        Intrinsics.checkNotNullParameter(actionDonation, "actionDonation");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mExecutorService.execute(new RunnableC0201c(this, 5, actionDonation, listener));
    }
}
