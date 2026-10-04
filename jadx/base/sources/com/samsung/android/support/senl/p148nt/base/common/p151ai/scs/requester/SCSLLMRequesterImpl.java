package com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import androidx.core.app.NotificationCompat;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.language.Result;
import com.samsung.android.sdk.scs.p142ai.language.Summarizer;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.AiServicesManager;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSExecutor;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTextResultListener;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTools;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.VirtualScsAiServiceConstants;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSServiceRequester;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p070Q1.RunnableC0218a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0016\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\tJ\u001c\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0016J6\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0018\u0010\u0015\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000fH\u0002J>\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010$\u001a\u0004\u0018\u00010\u000f2\u0018\u0010\u0015\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u0016H\u0002J\u0014\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010'\u001a\u00020\u000bH\u0002J\u0012\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010*\u001a\u00020+2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0002J,\u0010,\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020+H\u0016J\u001c\u00100\u001a\u0004\u0018\u00010\u000f2\b\u0010-\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u00101\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u00010\u000fJ\u000e\u00102\u001a\u00020+2\u0006\u00103\u001a\u00020\u000fJ\b\u00104\u001a\u00020\u000bH\u0016J\u000e\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020\u000fJ\u0010\u00107\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u00069"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/SCSLLMRequesterImpl;", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/ILLMRequester;", "<init>", "()V", "mVirtualScsServiceConnection", "Landroid/content/ServiceConnection;", "mRetryCount", "", "mCallback", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSTextResultListener$Callback;", "setCallback", "", Profile.PhoneNumberData.TYPE_CALLBACK, "getLimitedStringSize", "input", "", "type", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/SCSRequesterType;", "requestText", TextConst.KEY_PARAM_REQUEST_TYPE, "content", "options", "", "", "createTextResultListener", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSTextResultListener;", "latch", "Ljava/util/concurrent/CountDownLatch;", "timeOut", "getTimeOut", "()I", "onFailed", NetworkConfig.ACK_ERROR_MSG, "requestToService", "Lcom/samsung/android/sdk/scs/base/tasks/Task;", "Lcom/samsung/android/sdk/scs/ai/language/Result;", "requestStr", "createServiceRequester", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/SCSServiceRequester;", "makeAppInfoError", "getVirtualSCSRequestTypeId", "requesterType", "isVirtualSCSEnabled", "", "saveToCache", "key", "result", "isCompleted", "loadFromCache", "deleteCache", "couldRetry", NotificationCompat.CATEGORY_ERROR, "close", "couldTokenRetry", "message", "release", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSCSLLMRequesterImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SCSLLMRequesterImpl.kt\ncom/samsung/android/support/senl/nt/base/common/ai/scs/requester/SCSLLMRequesterImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,266:1\n1#2:267\n29#3:268\n*S KotlinDebug\n*F\n+ 1 SCSLLMRequesterImpl.kt\ncom/samsung/android/support/senl/nt/base/common/ai/scs/requester/SCSLLMRequesterImpl\n*L\n123#1:268\n*E\n"})
public class SCSLLMRequesterImpl implements ILLMRequester {

    @NotNull
    private static final String KEY_SUMMARY_APP_NAME = "app_name";

    @NotNull
    private static final String KEY_SUMMARY_LINES = "count_of_summary_lines";

    @NotNull
    private static final String KEY_SUMMARY_TYPE = "document_type";
    private static final int MAX_REQUEST_STRING_LEN_EN = 10000;
    private static final int MAX_REQUEST_STRING_LEN_EN_MIN = 2000;

    @NotNull
    private static final String SUMMARY_APP_NAME_VOICE_RECORDER = "voice_recorder";

    @NotNull
    private static final String TAG = "Ai$LLM$SCSLLMRequesterImpl";
    private static final boolean sIsCachingEnabled = true;

    @Nullable
    private SCSTextResultListener.Callback mCallback;
    private int mRetryCount;

    @Nullable
    private ServiceConnection mVirtualScsServiceConnection;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SCSRequesterType.values().length];
            try {
                iArr[SCSRequesterType.Translation.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SCSRequesterType.StructuredAutoFormat.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SCSRequesterType.STTSummary.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getVirtualSCSRequestTypeId(SCSRequesterType requesterType) {
        if (requesterType == SCSRequesterType.TravelSchedule) {
            return 7;
        }
        if (requesterType == SCSRequesterType.TravelTip) {
            return 6;
        }
        if (requesterType == SCSRequesterType.TravelReservationInfo) {
            return 8;
        }
        return requesterType == SCSRequesterType.JournalInfo ? 9 : 5;
    }

    private final boolean isVirtualSCSEnabled(SCSRequesterType requestType) {
        if (requestType == SCSRequesterType.VirtualScsNoteDescription) {
            Logger.m8697d(TAG, "isVirtualSCSEnabled: true");
            return true;
        }
        if (Features.isVirtualScsInstalled() && (requestType == SCSRequesterType.TravelTip || requestType == SCSRequesterType.TravelSchedule || requestType == SCSRequesterType.TravelReservationInfo || requestType == SCSRequesterType.JournalInfo)) {
            Logger.m8697d(TAG, "isVirtualSCSEnabled: true");
            return true;
        }
        Logger.m8697d(TAG, "isVirtualSCSEnabled: false");
        return false;
    }

    private final void makeAppInfoError() {
        onFailed(SCSTools.getAppInfoErrMsg());
    }

    private final void onFailed(String errorMsg) {
        if (this.mCallback != null) {
            new Handler(Looper.getMainLooper()).post(new RunnableC8515c(this, errorMsg, 16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFailed$lambda$1(SCSLLMRequesterImpl sCSLLMRequesterImpl, String str) {
        SCSTextResultListener.Callback callback = sCSLLMRequesterImpl.mCallback;
        if (callback != null) {
            callback.onFailed(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestText$lambda$0(String str, SCSLLMRequesterImpl sCSLLMRequesterImpl, SCSRequesterType sCSRequesterType, Map map) {
        Logger.m8697d(TAG, "[LLM:I]requestText : " + (str != null ? Integer.valueOf(str.length()) : null));
        CountDownLatch countDownLatch = new CountDownLatch(1);
        SCSTextResultListener sCSTextResultListenerCreateTextResultListener = sCSLLMRequesterImpl.createTextResultListener(countDownLatch, sCSLLMRequesterImpl.mCallback);
        try {
            Task<Result> taskRequestToService = sCSLLMRequesterImpl.requestToService(sCSRequesterType, str, map);
            if (taskRequestToService == null) {
                return;
            }
            taskRequestToService.addOnCompleteListener(sCSTextResultListenerCreateTextResultListener);
            if (countDownLatch.await(sCSLLMRequesterImpl.getTimeOut(), TimeUnit.SECONDS)) {
                return;
            }
            Logger.m8698e(TAG, "requestText, timeout");
            sCSTextResultListenerCreateTextResultListener.release();
            sCSLLMRequesterImpl.onFailed("UNEXPECTED_ERROR");
        } catch (InterruptedException e) {
            Logger.m8698e(TAG, "requestText, e: " + e.getMessage());
            sCSTextResultListenerCreateTextResultListener.release();
            sCSLLMRequesterImpl.onFailed("UNEXPECTED_ERROR");
        }
    }

    private final Task<Result> requestToService(final SCSRequesterType requestType, final String requestStr, Map<String, ? extends Object> options) {
        Context applicationContext;
        if (requestStr != null) {
            SCSTools.INSTANCE.getExtraPrompt(requestStr);
        }
        if (!isVirtualSCSEnabled(requestType)) {
            SCSServiceRequester sCSServiceRequesterCreateServiceRequester = createServiceRequester(requestType);
            Task<Result> taskRequestToService = sCSServiceRequesterCreateServiceRequester != null ? sCSServiceRequesterCreateServiceRequester.requestToService(requestStr, options) : null;
            if (taskRequestToService == null) {
                makeAppInfoError();
                return taskRequestToService;
            }
            String tag = requestType != null ? requestType.getTAG() : null;
            Logger.m8697d(TAG, "requestToService, type: " + tag + ", req: " + SCSTools.getRequestType());
            return taskRequestToService;
        }
        Logger.m8697d(TAG, "requestToService, VirtualScsNoteDescription, requestStr: ".concat(requestStr == null ? "null" : requestStr));
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(VirtualScsAiServiceConstants.SERVICE_PACKAGE, VirtualScsAiServiceConstants.SERVICE_CLASS));
        intent.addCategory(VirtualScsAiServiceConstants.SERVICE_CATEGORY);
        intent.setAction(VirtualScsAiServiceConstants.SERVICE_ACTION);
        if (SCSRequesterType.TravelReservationInfo == requestType && requestStr != null && (applicationContext = BaseUtils.getApplicationContext()) != null) {
            applicationContext.grantUriPermission(VirtualScsAiServiceConstants.SERVICE_PACKAGE, Uri.parse(requestStr), 3);
        }
        this.mVirtualScsServiceConnection = new ServiceConnection() { // from class: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.SCSLLMRequesterImpl.requestToService.2
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                Logger.m8697d(SCSLLMRequesterImpl.TAG, "onServiceConnected");
                Message messageObtain = Message.obtain((Handler) null, SCSLLMRequesterImpl.this.getVirtualSCSRequestTypeId(requestType));
                messageObtain.getData().putString("textInfo", requestStr);
                final Looper mainLooper = Looper.getMainLooper();
                final SCSLLMRequesterImpl sCSLLMRequesterImpl = SCSLLMRequesterImpl.this;
                messageObtain.replyTo = new Messenger(new Handler(mainLooper) { // from class: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.SCSLLMRequesterImpl$requestToService$2$onServiceConnected$1
                    @Override // android.os.Handler
                    public void handleMessage(Message msg) {
                        Intrinsics.checkNotNullParameter(msg, "msg");
                        if (!msg.getData().getBoolean("result")) {
                            SCSTextResultListener.Callback callback = sCSLLMRequesterImpl.mCallback;
                            if (callback != null) {
                                callback.onFailed("VirtualScsAiService failed");
                                return;
                            }
                            return;
                        }
                        SCSTextResultListener.Callback callback2 = sCSLLMRequesterImpl.mCallback;
                        if (callback2 != null) {
                            String string = msg.getData().getString("content", "");
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            callback2.onSuccess(string, true);
                        }
                    }
                });
                try {
                    new Messenger(service).send(messageObtain);
                } catch (RemoteException unused) {
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                Logger.m8697d(SCSLLMRequesterImpl.TAG, "onServiceDisconnected");
            }
        };
        Context applicationContext2 = BaseUtils.getApplicationContext();
        if (applicationContext2 != null) {
            ServiceConnection serviceConnection = this.mVirtualScsServiceConnection;
            Intrinsics.checkNotNull(serviceConnection, "null cannot be cast to non-null type android.content.ServiceConnection");
            applicationContext2.bindService(intent, serviceConnection, 1);
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.ILLMRequester, java.lang.AutoCloseable
    public void close() {
    }

    public final boolean couldRetry(@NotNull String err) {
        Intrinsics.checkNotNullParameter(err, "err");
        if (!Intrinsics.areEqual("REMOTE_SERVER_ERROR", err) && !Intrinsics.areEqual("INTERNAL_SERVER_ERROR", err)) {
            return false;
        }
        int i = this.mRetryCount + 1;
        this.mRetryCount = i;
        return i <= 1;
    }

    public final boolean couldTokenRetry(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (Intrinsics.areEqual(SCSTools.getAppInfoErrMsg(), message)) {
            int i = this.mRetryCount + 1;
            this.mRetryCount = i;
            if (i <= 1) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public SCSServiceRequester createServiceRequester(@Nullable SCSRequesterType requestType) {
        if (requestType != null) {
            return requestType.create(false);
        }
        return null;
    }

    @NotNull
    public SCSTextResultListener createTextResultListener(@Nullable CountDownLatch latch, @Nullable SCSTextResultListener.Callback callback) {
        return new SCSTextResultListener(latch, callback);
    }

    public final void deleteCache(@Nullable String key) {
        SCSTools.INSTANCE.deleteResultCache(key);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.ILLMRequester
    public int getLimitedStringSize(@Nullable String input, @Nullable SCSRequesterType type) {
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1 || i == 2) {
            return 2000;
        }
        if (i == 3 && input != null) {
            return input.length();
        }
        return 10000;
    }

    public int getTimeOut() {
        return SCSTools.INSTANCE.getTimeOut(false);
    }

    @Nullable
    public final String loadFromCache(@Nullable String key, @Nullable String input) {
        return SCSTools.getResultFromCache(key, input);
    }

    public final void release(@Nullable SCSRequesterType requestType) {
        Summarizer summarizer;
        if ((requestType == SCSRequesterType.Summary || requestType == SCSRequesterType.STTSummary) && (summarizer = AiServicesManager.INSTANCE.getInstance().getSummarizer()) != null) {
            summarizer.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.ILLMRequester
    public void requestText(@Nullable SCSRequesterType requestType, @Nullable String content) {
        requestText(requestType, null, content);
    }

    public void saveToCache(@Nullable String key, @Nullable String input, @NotNull String result, boolean isCompleted) {
        Intrinsics.checkNotNullParameter(result, "result");
        SCSTools.addResultToCache(key, input, result);
    }

    public final void setCallback(@Nullable SCSTextResultListener.Callback callback) {
        this.mCallback = callback;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.ILLMRequester
    public void requestText(@Nullable SCSRequesterType requestType, @Nullable Map<String, ? extends Object> options, @Nullable String content) {
        SCSExecutor.INSTANCE.execute(new RunnableC0218a(content, this, requestType, options, 12));
    }
}
