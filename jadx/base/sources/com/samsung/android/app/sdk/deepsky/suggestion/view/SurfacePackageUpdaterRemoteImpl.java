package com.samsung.android.app.sdk.deepsky.suggestion.view;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.view.SurfaceControlViewHost;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionData;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionItem;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.view.SuggestionViewContracts;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.view.SuggestionViewRequest;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.view.SuggestionViewResponse;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.view.SuggestionViewSpec;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.view.SurfaceViewInfo;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 C2\u00020\u0001:\u0002BCB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u00105\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002JN\u00106\u001a\u00020\u000f2\u0006\u00102\u001a\u0002032<\u00107\u001a8\u0012\u0004\u0012\u00020-\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u000f0,H\u0016J\u0010\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020\u0005H\u0016J\u0010\u0010:\u001a\u00020\u000f2\u0006\u00102\u001a\u000203H\u0016J\u0010\u0010;\u001a\u00020\u000f2\u0006\u00102\u001a\u000203H\u0016J+\u0010<\u001a\u00020\u000f2!\u00107\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u000f0\u0015H\u0002JB\u0010=\u001a\u00020\u000f28\u00107\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bH\u0016J-\u0010>\u001a\u00020\u000f2#\u00107\u001a\u001f\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015H\u0016J\u0018\u0010?\u001a\u00020\u000f2\u000e\u00107\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0019H\u0016JB\u0010@\u001a\u00020\u000f28\u00107\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bH\u0016J-\u0010A\u001a\u00020\u000f2#\u00107\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015H\u0016R@\u0010\u0007\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010!\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010%\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010'\u001a#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u000f0\u00150(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000RF\u0010+\u001a:\u0012\u0004\u0012\u00020-\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u000f\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SurfacePackageUpdaterRemoteImpl;", "Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SurfacePackageUpdater;", "context", "Landroid/content/Context;", "viewConfig", "Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionViewConfig;", "(Landroid/content/Context;Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionViewConfig;)V", "clickedConsumer", "Lkotlin/Function2;", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionData;", "Lkotlin/ParameterName;", "name", "data", "", "viewId", "", "clientMessenger", "Landroid/os/Messenger;", "connection", "Landroid/content/ServiceConnection;", "disconnectedConsumer", "Lkotlin/Function1;", "", "cause", "dismissedConsumer", "Lkotlin/Function0;", "excludedIdList", "", "includedIdList", "isBound", "", "item", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionItem;", "layoutChangedConsumer", "width", "height", "maxSuggestionCount", "motionEventConsumer", "actionId", "requestQueue", "Ljava/util/concurrent/ArrayBlockingQueue;", "server", "serverMessenger", "surfacePackageConsumer", "Lkotlin/Function3;", "Landroid/view/SurfaceControlViewHost$SurfacePackage;", "viewSpec", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SuggestionViewSpec;", "createRequest", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SuggestionViewRequest;", "info", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SurfaceViewInfo;", "doBindService", "doUnbindService", "getSurfacePackage", "consumer", "isAlreadyConnected", ExternalDataConstants.EmbeddingConfig.KEY, "onSurfacePackageReleased", "relayout", "requestToServer", "setOnClickListener", "setOnDisconnectedListener", "setOnDismissedListener", "setOnLayoutChangedListener", "setOnMotionEventListener", "ClientIncomingHandler", "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSurfacePackageUpdaterRemoteImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SurfacePackageUpdaterRemoteImpl.kt\ncom/samsung/android/app/sdk/deepsky/suggestion/view/SurfacePackageUpdaterRemoteImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,293:1\n1#2:294\n*E\n"})
public final class SurfacePackageUpdaterRemoteImpl implements SurfacePackageUpdater {

    @NotNull
    private static final String SERVICE_NAME = "com.samsung.android.app.deepsky.service.suggestion.view.SuggestionViewService";

    @NotNull
    private static final String SERVICE_PKG = "com.samsung.android.smartsuggestions";

    @NotNull
    private static final String TAG = "SSS:SurfacePackageUpdaterRemoteImpl";

    @Nullable
    private Function2<? super SuggestionData, ? super Integer, Unit> clickedConsumer;

    @NotNull
    private final Messenger clientMessenger;

    @NotNull
    private final ServiceConnection connection;

    @NotNull
    private final Context context;

    @Nullable
    private Function1<? super String, Unit> disconnectedConsumer;

    @Nullable
    private Function0<Unit> dismissedConsumer;

    @NotNull
    private final List<Integer> excludedIdList;

    @NotNull
    private final List<Integer> includedIdList;
    private boolean isBound;

    @NotNull
    private final SuggestionItem item;

    @Nullable
    private Function2<? super Integer, ? super Integer, Unit> layoutChangedConsumer;
    private final int maxSuggestionCount;

    @Nullable
    private Function1<? super Integer, Unit> motionEventConsumer;

    @NotNull
    private final ArrayBlockingQueue<Function1<Messenger, Unit>> requestQueue;

    @Nullable
    private Messenger serverMessenger;

    @Nullable
    private Function3<? super SurfaceControlViewHost.SurfacePackage, ? super Integer, ? super Integer, Unit> surfacePackageConsumer;

    @NotNull
    private final SuggestionViewConfig viewConfig;

    @NotNull
    private final SuggestionViewSpec viewSpec;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0004H\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SurfacePackageUpdaterRemoteImpl$ClientIncomingHandler;", "Landroid/os/Handler;", "consumer", "Lkotlin/Function1;", "Landroid/os/Message;", "", "(Lkotlin/jvm/functions/Function1;)V", "handleMessage", "msg", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSurfacePackageUpdaterRemoteImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SurfacePackageUpdaterRemoteImpl.kt\ncom/samsung/android/app/sdk/deepsky/suggestion/view/SurfacePackageUpdaterRemoteImpl$ClientIncomingHandler\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,293:1\n1#2:294\n*E\n"})
    public static final class ClientIncomingHandler extends Handler {

        @NotNull
        private final Function1<Message, Unit> consumer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ClientIncomingHandler(@NotNull Function1<? super Message, Unit> consumer) {
            super(Looper.getMainLooper());
            Intrinsics.checkNotNullParameter(consumer, "consumer");
            this.consumer = consumer;
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            Object obj = msg.obj;
            this.consumer.invoke(msg);
        }
    }

    public SurfacePackageUpdaterRemoteImpl(@NotNull Context context, @NotNull SuggestionViewConfig viewConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewConfig, "viewConfig");
        this.context = context;
        this.viewConfig = viewConfig;
        this.item = viewConfig.getItem();
        this.viewSpec = viewConfig.getViewSpec();
        this.maxSuggestionCount = viewConfig.getMaxSuggestionCount();
        this.includedIdList = viewConfig.getIncludedDataId();
        this.excludedIdList = viewConfig.getExcludedDataId();
        this.requestQueue = new ArrayBlockingQueue<>(5);
        this.clientMessenger = new Messenger(new ClientIncomingHandler(new Function1<Message, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdaterRemoteImpl$clientMessenger$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Message message) {
                invoke2(message);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Message msg) {
                Object objM22215constructorimpl;
                SurfaceControlViewHost.SurfacePackage surfacePackage;
                Object objM22215constructorimpl2;
                Integer viewId;
                Object next;
                Function2 function2;
                Object objM22215constructorimpl3;
                Integer width;
                Object objM22215constructorimpl4;
                Integer actionId;
                Intrinsics.checkNotNullParameter(msg, "msg");
                Log.d("SSS:SurfacePackageUpdaterRemoteImpl", "received from service, " + msg);
                int i = msg.what;
                Unit unit = null;
                if (i == 11) {
                    SuggestionViewResponse responseFromMsg = SuggestionViewContracts.INSTANCE.getResponseFromMsg(msg);
                    if (responseFromMsg != null) {
                        SurfacePackageUpdaterRemoteImpl surfacePackageUpdaterRemoteImpl = this.this$0;
                        if (!responseFromMsg.isValid()) {
                            Log.e("SSS:SurfacePackageUpdaterRemoteImpl", "error message: " + responseFromMsg.getErrorMessage());
                            surfacePackageUpdaterRemoteImpl.doUnbindService(surfacePackageUpdaterRemoteImpl.context);
                            Function1 function1 = surfacePackageUpdaterRemoteImpl.disconnectedConsumer;
                            if (function1 != null) {
                                function1.invoke(String.valueOf(responseFromMsg.getErrorMessage()));
                                return;
                            }
                            return;
                        }
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            surfacePackage = responseFromMsg.getSurfacePackage();
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
                        }
                        if (surfacePackage == null) {
                            throw new IllegalStateException("surfacePackage is null");
                        }
                        Integer width2 = responseFromMsg.getWidth();
                        if (width2 == null) {
                            throw new IllegalStateException("width is null");
                        }
                        int iIntValue = width2.intValue();
                        Integer height = responseFromMsg.getHeight();
                        if (height == null) {
                            throw new IllegalStateException("height is null");
                        }
                        int iIntValue2 = height.intValue();
                        Function3 function3 = surfacePackageUpdaterRemoteImpl.surfacePackageConsumer;
                        if (function3 != null) {
                            function3.invoke(surfacePackage, Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2));
                            unit = Unit.INSTANCE;
                        }
                        objM22215constructorimpl = Result.m22215constructorimpl(unit);
                        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
                        if (thM22218exceptionOrNullimpl != null) {
                            Log.e("SSS:SurfacePackageUpdaterRemoteImpl", "update surface package: ", thM22218exceptionOrNullimpl);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i == 20) {
                    SuggestionViewResponse responseFromMsg2 = SuggestionViewContracts.INSTANCE.getResponseFromMsg(msg);
                    if (responseFromMsg2 != null) {
                        AbstractC2322a.m1636z("error, message: ", responseFromMsg2.getErrorMessage(), "SSS:SurfacePackageUpdaterRemoteImpl");
                        return;
                    }
                    return;
                }
                switch (i) {
                    case 14:
                        SurfacePackageUpdaterRemoteImpl surfacePackageUpdaterRemoteImpl2 = this.this$0;
                        surfacePackageUpdaterRemoteImpl2.doUnbindService(surfacePackageUpdaterRemoteImpl2.context);
                        Function1 function12 = this.this$0.disconnectedConsumer;
                        if (function12 != null) {
                            function12.invoke("expired");
                            return;
                        }
                        return;
                    case 15:
                        SuggestionViewResponse responseFromMsg3 = SuggestionViewContracts.INSTANCE.getResponseFromMsg(msg);
                        if (responseFromMsg3 != null) {
                            SurfacePackageUpdaterRemoteImpl surfacePackageUpdaterRemoteImpl3 = this.this$0;
                            try {
                                Result.Companion companion3 = Result.INSTANCE;
                                viewId = responseFromMsg3.getViewId();
                            } catch (Throwable th2) {
                                Result.Companion companion4 = Result.INSTANCE;
                                objM22215constructorimpl2 = Result.m22215constructorimpl(ResultKt.createFailure(th2));
                            }
                            if (viewId == null) {
                                throw new IllegalStateException("Required value was null.");
                            }
                            int iIntValue3 = viewId.intValue();
                            String dataId = responseFromMsg3.getDataId();
                            if (dataId == null) {
                                throw new IllegalStateException("Required value was null.");
                            }
                            String actionUrl = responseFromMsg3.getActionUrl();
                            Iterator<T> it = surfacePackageUpdaterRemoteImpl3.item.getItems().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    next = it.next();
                                    if (Intrinsics.areEqual(((SuggestionData) next).getId(), dataId)) {
                                    }
                                } else {
                                    next = null;
                                }
                            }
                            SuggestionData suggestionData = (SuggestionData) next;
                            if (suggestionData != null && (function2 = surfacePackageUpdaterRemoteImpl3.clickedConsumer) != null) {
                                function2.invoke(SuggestionData.copy$default(suggestionData, null, null, null, null, null, null, null, actionUrl, 0L, 383, null), Integer.valueOf(iIntValue3));
                                unit = Unit.INSTANCE;
                            }
                            objM22215constructorimpl2 = Result.m22215constructorimpl(unit);
                            Throwable thM22218exceptionOrNullimpl2 = Result.m22218exceptionOrNullimpl(objM22215constructorimpl2);
                            if (thM22218exceptionOrNullimpl2 != null) {
                                Log.e("SSS:SurfacePackageUpdaterRemoteImpl", "clicked", thM22218exceptionOrNullimpl2);
                                return;
                            }
                            return;
                        }
                        return;
                    case 16:
                        SuggestionViewResponse responseFromMsg4 = SuggestionViewContracts.INSTANCE.getResponseFromMsg(msg);
                        if (responseFromMsg4 != null) {
                            SurfacePackageUpdaterRemoteImpl surfacePackageUpdaterRemoteImpl4 = this.this$0;
                            try {
                                Result.Companion companion5 = Result.INSTANCE;
                                width = responseFromMsg4.getWidth();
                            } catch (Throwable th3) {
                                Result.Companion companion6 = Result.INSTANCE;
                                objM22215constructorimpl3 = Result.m22215constructorimpl(ResultKt.createFailure(th3));
                            }
                            if (width == null) {
                                throw new IllegalStateException("width is null");
                            }
                            int iIntValue4 = width.intValue();
                            Integer height2 = responseFromMsg4.getHeight();
                            if (height2 == null) {
                                throw new IllegalStateException("height is null");
                            }
                            int iIntValue5 = height2.intValue();
                            Function2 function22 = surfacePackageUpdaterRemoteImpl4.layoutChangedConsumer;
                            if (function22 != null) {
                                function22.invoke(Integer.valueOf(iIntValue4), Integer.valueOf(iIntValue5));
                                unit = Unit.INSTANCE;
                            }
                            objM22215constructorimpl3 = Result.m22215constructorimpl(unit);
                            Throwable thM22218exceptionOrNullimpl3 = Result.m22218exceptionOrNullimpl(objM22215constructorimpl3);
                            if (thM22218exceptionOrNullimpl3 != null) {
                                Log.e("SSS:SurfacePackageUpdaterRemoteImpl", "layout changed: ", thM22218exceptionOrNullimpl3);
                                return;
                            }
                            return;
                        }
                        return;
                    case 17:
                        SurfacePackageUpdaterRemoteImpl surfacePackageUpdaterRemoteImpl5 = this.this$0;
                        surfacePackageUpdaterRemoteImpl5.doUnbindService(surfacePackageUpdaterRemoteImpl5.context);
                        Function0 function0 = this.this$0.dismissedConsumer;
                        if (function0 != null) {
                            function0.invoke();
                            return;
                        }
                        return;
                    case 18:
                        SuggestionViewResponse responseFromMsg5 = SuggestionViewContracts.INSTANCE.getResponseFromMsg(msg);
                        if (responseFromMsg5 != null) {
                            SurfacePackageUpdaterRemoteImpl surfacePackageUpdaterRemoteImpl6 = this.this$0;
                            try {
                                Result.Companion companion7 = Result.INSTANCE;
                                actionId = responseFromMsg5.getActionId();
                            } catch (Throwable th4) {
                                Result.Companion companion8 = Result.INSTANCE;
                                objM22215constructorimpl4 = Result.m22215constructorimpl(ResultKt.createFailure(th4));
                            }
                            if (actionId == null) {
                                throw new IllegalStateException("Required value was null.");
                            }
                            int iIntValue6 = actionId.intValue();
                            Function1 function13 = surfacePackageUpdaterRemoteImpl6.motionEventConsumer;
                            if (function13 != null) {
                                function13.invoke(Integer.valueOf(iIntValue6));
                                unit = Unit.INSTANCE;
                            }
                            objM22215constructorimpl4 = Result.m22215constructorimpl(unit);
                            Throwable thM22218exceptionOrNullimpl4 = Result.m22218exceptionOrNullimpl(objM22215constructorimpl4);
                            if (thM22218exceptionOrNullimpl4 != null) {
                                Log.e("SSS:SurfacePackageUpdaterRemoteImpl", "motionEvent", thM22218exceptionOrNullimpl4);
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }));
        this.connection = new ServiceConnection() { // from class: com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdaterRemoteImpl$connection$1
            private final void executePendingRequest(Messenger server) {
                AbstractC0541b.m755A(this.this$0.requestQueue.size(), "executePendingRequest, size: ", "SSS:SurfacePackageUpdaterRemoteImpl");
                while (!this.this$0.requestQueue.isEmpty()) {
                    Function1 function1 = (Function1) this.this$0.requestQueue.poll();
                    if (function1 != null) {
                        function1.invoke(server);
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(@Nullable ComponentName name, @Nullable IBinder service) {
                Log.d("SSS:SurfacePackageUpdaterRemoteImpl", "onServiceConnected");
                this.this$0.serverMessenger = new Messenger(service);
                Messenger messenger = this.this$0.serverMessenger;
                if (messenger != null) {
                    executePendingRequest(messenger);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(@Nullable ComponentName name) {
                Log.i("SSS:SurfacePackageUpdaterRemoteImpl", "onServiceDisconnected");
                this.this$0.serverMessenger = null;
                this.this$0.requestQueue.clear();
                Function1 function1 = this.this$0.disconnectedConsumer;
                if (function1 != null) {
                    function1.invoke("onServiceDisconnected");
                }
                SurfacePackageUpdaterRemoteImpl surfacePackageUpdaterRemoteImpl = this.this$0;
                surfacePackageUpdaterRemoteImpl.doUnbindService(surfacePackageUpdaterRemoteImpl.context);
            }
        };
    }

    private final SuggestionViewRequest createRequest(SurfaceViewInfo info) {
        String surfaceHash = info.getSurfaceHash();
        String id = this.item.getId();
        SuggestionViewSpec suggestionViewSpec = this.viewSpec;
        int i = this.maxSuggestionCount;
        return new SuggestionViewRequest(0, surfaceHash, id, info, suggestionViewSpec, Integer.valueOf(i), null, this.includedIdList, this.excludedIdList, 65, null);
    }

    private final void doBindService(Context context) {
        AbstractC6670b.m4759t("doBindService, isBound: ", TAG, this.isBound);
        if (this.isBound) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(SERVICE_PKG, SERVICE_NAME));
        context.bindService(intent, this.connection, 1);
        this.isBound = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doUnbindService(Context context) {
        Object objM22215constructorimpl;
        AbstractC6670b.m4759t("doUnbindService, isBound: ", TAG, this.isBound);
        if (this.isBound) {
            try {
                Result.Companion companion = Result.INSTANCE;
                context.unbindService(this.connection);
                objM22215constructorimpl = Result.m22215constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
            if (thM22218exceptionOrNullimpl != null) {
                Log.e(TAG, "doUnbindService", thM22218exceptionOrNullimpl);
            }
            this.isBound = false;
        }
    }

    private final void requestToServer(Function1<? super Messenger, Unit> consumer) {
        Messenger messenger = this.serverMessenger;
        if (messenger != null) {
            consumer.invoke(messenger);
        } else {
            this.requestQueue.offer(consumer);
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdater
    public void getSurfacePackage(@NotNull SurfaceViewInfo info, @NotNull final Function3<? super SurfaceControlViewHost.SurfacePackage, ? super Integer, ? super Integer, Unit> consumer) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Log.d(TAG, "getSurfacePackage, info: " + info);
        if (!this.item.getValid()) {
            throw new IllegalStateException("getSurfacePackage, item is not valid");
        }
        doBindService(this.context);
        final SuggestionViewRequest suggestionViewRequestCreateRequest = createRequest(info);
        requestToServer(new Function1<Messenger, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdaterRemoteImpl.getSurfacePackage.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Messenger messenger) {
                invoke2(messenger);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Messenger server) {
                Object objM22215constructorimpl;
                Intrinsics.checkNotNullParameter(server, "server");
                SurfacePackageUpdaterRemoteImpl surfacePackageUpdaterRemoteImpl = SurfacePackageUpdaterRemoteImpl.this;
                Function3<SurfaceControlViewHost.SurfacePackage, Integer, Integer, Unit> function3 = consumer;
                SuggestionViewRequest suggestionViewRequest = suggestionViewRequestCreateRequest;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    surfacePackageUpdaterRemoteImpl.surfacePackageConsumer = function3;
                    Message messageCreateMessage = SuggestionViewContracts.INSTANCE.createMessage(10, suggestionViewRequest);
                    messageCreateMessage.replyTo = surfacePackageUpdaterRemoteImpl.clientMessenger;
                    server.send(messageCreateMessage);
                    objM22215constructorimpl = Result.m22215constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
                }
                SurfacePackageUpdaterRemoteImpl surfacePackageUpdaterRemoteImpl2 = SurfacePackageUpdaterRemoteImpl.this;
                Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
                if (thM22218exceptionOrNullimpl != null) {
                    if (thM22218exceptionOrNullimpl instanceof RemoteException) {
                        Log.e(SurfacePackageUpdaterRemoteImpl.TAG, "getSurfacePackage, RemoteException");
                    }
                    surfacePackageUpdaterRemoteImpl2.surfacePackageConsumer = null;
                }
            }
        });
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdater
    public boolean isAlreadyConnected(@NotNull SuggestionViewConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return Intrinsics.areEqual(this.viewConfig, config);
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdater
    public void onSurfacePackageReleased(@NotNull SurfaceViewInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        Log.d(TAG, "onSurfacePackageReleased, info: " + info);
        final SuggestionViewRequest suggestionViewRequestCreateRequest = createRequest(info);
        requestToServer(new Function1<Messenger, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdaterRemoteImpl.onSurfacePackageReleased.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Messenger messenger) {
                invoke2(messenger);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Messenger server) {
                Object objM22215constructorimpl;
                Intrinsics.checkNotNullParameter(server, "server");
                SurfacePackageUpdaterRemoteImpl surfacePackageUpdaterRemoteImpl = SurfacePackageUpdaterRemoteImpl.this;
                SuggestionViewRequest suggestionViewRequest = suggestionViewRequestCreateRequest;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Message messageCreateMessage = SuggestionViewContracts.INSTANCE.createMessage(13, suggestionViewRequest);
                    messageCreateMessage.replyTo = surfacePackageUpdaterRemoteImpl.clientMessenger;
                    server.send(messageCreateMessage);
                    surfacePackageUpdaterRemoteImpl.doUnbindService(surfacePackageUpdaterRemoteImpl.context);
                    objM22215constructorimpl = Result.m22215constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
                if (thM22218exceptionOrNullimpl == null || !(thM22218exceptionOrNullimpl instanceof RemoteException)) {
                    return;
                }
                Log.e(SurfacePackageUpdaterRemoteImpl.TAG, "onSurfacePackageReleased, RemoteException");
            }
        });
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdater
    public void relayout(@NotNull SurfaceViewInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        Log.d(TAG, "relayout, info: " + info);
        final SuggestionViewRequest suggestionViewRequestCreateRequest = createRequest(info);
        requestToServer(new Function1<Messenger, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdaterRemoteImpl.relayout.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Messenger messenger) {
                invoke2(messenger);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Messenger server) {
                Object objM22215constructorimpl;
                Intrinsics.checkNotNullParameter(server, "server");
                SurfacePackageUpdaterRemoteImpl surfacePackageUpdaterRemoteImpl = SurfacePackageUpdaterRemoteImpl.this;
                SuggestionViewRequest suggestionViewRequest = suggestionViewRequestCreateRequest;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Message messageCreateMessage = SuggestionViewContracts.INSTANCE.createMessage(12, suggestionViewRequest);
                    messageCreateMessage.replyTo = surfacePackageUpdaterRemoteImpl.clientMessenger;
                    server.send(messageCreateMessage);
                    objM22215constructorimpl = Result.m22215constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
                if (thM22218exceptionOrNullimpl == null || !(thM22218exceptionOrNullimpl instanceof RemoteException)) {
                    return;
                }
                Log.e(SurfacePackageUpdaterRemoteImpl.TAG, "relayout, RemoteException");
            }
        });
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdater
    public void setOnClickListener(@Nullable Function2<? super SuggestionData, ? super Integer, Unit> consumer) {
        this.clickedConsumer = consumer;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdater
    public void setOnDisconnectedListener(@Nullable Function1<? super String, Unit> consumer) {
        this.disconnectedConsumer = consumer;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdater
    public void setOnDismissedListener(@Nullable Function0<Unit> consumer) {
        this.dismissedConsumer = consumer;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdater
    public void setOnLayoutChangedListener(@Nullable Function2<? super Integer, ? super Integer, Unit> consumer) {
        this.layoutChangedConsumer = consumer;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdater
    public void setOnMotionEventListener(@Nullable Function1<? super Integer, Unit> consumer) {
        this.motionEventConsumer = consumer;
    }
}
