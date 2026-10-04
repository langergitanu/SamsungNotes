package com.google.android.appfunctions.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.p108os.OutcomeReceiver;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.appfunctions.AppFunctionContext;
import com.google.android.appfunctions.AppFunctionDocument;
import com.google.android.appfunctions.AppFunctionException;
import com.google.android.appfunctions.AppFunctionMetadata;
import com.google.android.appfunctions.AppFunctionParameterMetadata;
import com.google.android.appfunctions.ExecuteAppFunctionRequest;
import com.google.android.appfunctions.ExecuteAppFunctionResponse;
import com.google.android.appfunctions.internal.AppFunctionContextImpl;
import com.google.android.appfunctions.internal.AppFunctionInventory;
import com.google.android.appfunctions.internal.AppFunctionInvoker;
import com.google.android.appfunctions.internal.utils.AppFunctionDocumentUtils;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 >2\u00020\u0001:\u0001>B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ*\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00162\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"J<\u0010%\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u00172\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015H\u0082@¢\u0006\u0002\u0010(J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0016H\u0002J\u001a\u0010,\u001a\u00020-2\u0006\u0010&\u001a\u00020\u00172\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0002J\u001a\u0010/\u001a\u0002002\u0006\u0010&\u001a\u00020\u00172\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0002J\u001a\u00101\u001a\u0002002\u0006\u0010&\u001a\u00020\u00172\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0002J&\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0017H\u0002J\u001a\u00103\u001a\u0004\u0018\u00010\u00012\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020-H\u0002J\u001a\u00107\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u0001082\u0006\u00104\u001a\u000205H\u0002J\u001a\u00109\u001a\u0002002\u0006\u0010:\u001a\u0002052\b\u0010;\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010<\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0006\u0010=\u001a\u000200R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\n \u0012*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R'\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u0006?"}, m13886d2 = {"Lcom/google/android/appfunctions/service/AppFunctionServiceDelegate;", "", "context", "Landroid/content/Context;", "workerCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "mainCoroutineContext", "appFunctionInvoker", "Lcom/google/android/appfunctions/internal/AppFunctionInvoker;", "appFunctionInventory", "Lcom/google/android/appfunctions/internal/AppFunctionInventory;", "<init>", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lcom/google/android/appfunctions/internal/AppFunctionInvoker;Lcom/google/android/appfunctions/internal/AppFunctionInventory;)V", "job", "Lkotlinx/coroutines/CompletableJob;", "workerCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", StateHandler.KEY_APP_STATE, "kotlin.jvm.PlatformType", "Landroid/content/Context;", "metadataCacheMap", "", "", "Lcom/google/android/appfunctions/AppFunctionMetadata;", "getMetadataCacheMap", "()Ljava/util/Map;", "metadataCacheMap$delegate", "Lkotlin/Lazy;", "onExecuteFunction", "Lkotlinx/coroutines/Job;", "executeAppFunctionRequest", "Lcom/google/android/appfunctions/ExecuteAppFunctionRequest;", "callingPackageName", Profile.PhoneNumberData.TYPE_CALLBACK, "Landroid/os/OutcomeReceiver;", "Lcom/google/android/appfunctions/ExecuteAppFunctionResponse;", "Lcom/google/android/appfunctions/AppFunctionException;", "invokeFunctionInternal", "appFunctionMetadata", "paramList", "(Lcom/google/android/appfunctions/ExecuteAppFunctionRequest;Ljava/lang/String;Lcom/google/android/appfunctions/AppFunctionMetadata;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareAppFunctionContext", "Lcom/google/android/appfunctions/AppFunctionContext;", "applicationContext", "prepareFunctionResult", "Lcom/google/android/appfunctions/AppFunctionDocument;", "result", "validateListTypeFunctionResult", "", "validateFunctionResult", "extractParameters", "extractParameter", GroupContract.Group.META_DATA, "Lcom/google/android/appfunctions/AppFunctionParameterMetadata;", "parameters", "getParameterEntityClass", "Ljava/lang/Class;", "validateParameter", "parameterMetadata", "parameter", "extractAppFunctionMetadata", "onDestroy", "Companion", "java.com.google.android.libraries.llm.appfunctions.appfunctions_appfunctions"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({WarningType.NewApi})
@SourceDebugExtension({"SMAP\nAppFunctionServiceDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppFunctionServiceDelegate.kt\ncom/google/android/appfunctions/service/AppFunctionServiceDelegate\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,240:1\n1#2:241\n*E\n"})
public final class AppFunctionServiceDelegate {

    @NotNull
    private static final String TAG = "AppFunction";
    private final Context appContext;

    @NotNull
    private final AppFunctionInventory appFunctionInventory;

    @NotNull
    private final AppFunctionInvoker appFunctionInvoker;

    @NotNull
    private final CompletableJob job;

    @NotNull
    private final CoroutineContext mainCoroutineContext;

    /* JADX INFO: renamed from: metadataCacheMap$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy metadataCacheMap;

    @NotNull
    private final CoroutineScope workerCoroutineScope;

    /* JADX INFO: renamed from: com.google.android.appfunctions.service.AppFunctionServiceDelegate$invokeFunctionInternal$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.google.android.appfunctions.service.AppFunctionServiceDelegate", m14021f = "AppFunctionServiceDelegate.kt", m14022i = {0, 0}, m14023l = {113}, m14024m = "invokeFunctionInternal", m14025n = {"this", "appFunctionMetadata"}, m14026s = {"L$0", "L$1"})
    public static final class C44901 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C44901(Continuation<? super C44901> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppFunctionServiceDelegate.this.invokeFunctionInternal(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.google.android.appfunctions.service.AppFunctionServiceDelegate$onExecuteFunction$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.google.android.appfunctions.service.AppFunctionServiceDelegate$onExecuteFunction$1", m14021f = "AppFunctionServiceDelegate.kt", m14022i = {}, m14023l = {79}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C44911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ OutcomeReceiver $callback;
        final /* synthetic */ String $callingPackageName;
        final /* synthetic */ ExecuteAppFunctionRequest $executeAppFunctionRequest;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C44911(ExecuteAppFunctionRequest executeAppFunctionRequest, OutcomeReceiver outcomeReceiver, String str, Continuation<? super C44911> continuation) {
            super(2, continuation);
            this.$executeAppFunctionRequest = executeAppFunctionRequest;
            this.$callback = outcomeReceiver;
            this.$callingPackageName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AppFunctionServiceDelegate.this.new C44911(this.$executeAppFunctionRequest, this.$callback, this.$callingPackageName, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Throwable th;
            C44911 c44911;
            CancellationException cancellationException;
            IllegalArgumentException illegalArgumentException;
            AppFunctionException appFunctionException;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (AppFunctionException e) {
                appFunctionException = e;
                c44911 = this;
            } catch (IllegalArgumentException e2) {
                illegalArgumentException = e2;
                c44911 = this;
            } catch (CancellationException e3) {
                cancellationException = e3;
                c44911 = this;
            } catch (Throwable th2) {
                th = th2;
                c44911 = this;
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    AppFunctionMetadata appFunctionMetadataExtractAppFunctionMetadata = AppFunctionServiceDelegate.this.extractAppFunctionMetadata(this.$executeAppFunctionRequest);
                    if (appFunctionMetadataExtractAppFunctionMetadata == null) {
                        Log.w(AppFunctionServiceDelegate.TAG, this.$executeAppFunctionRequest.getFunctionIdentifier() + " is not available.");
                        this.$callback.onError(new AppFunctionException(1001, this.$executeAppFunctionRequest.getFunctionIdentifier() + " is not available", null, 4, null));
                        return Unit.INSTANCE;
                    }
                    Map mapExtractParameters = AppFunctionServiceDelegate.this.extractParameters(this.$executeAppFunctionRequest, appFunctionMetadataExtractAppFunctionMetadata);
                    AppFunctionServiceDelegate appFunctionServiceDelegate = AppFunctionServiceDelegate.this;
                    ExecuteAppFunctionRequest executeAppFunctionRequest = this.$executeAppFunctionRequest;
                    String str = this.$callingPackageName;
                    this.label = 1;
                    c44911 = this;
                    try {
                        obj = appFunctionServiceDelegate.invokeFunctionInternal(executeAppFunctionRequest, str, appFunctionMetadataExtractAppFunctionMetadata, mapExtractParameters, c44911);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (AppFunctionException e5) {
                        e = e5;
                        appFunctionException = e;
                        Log.w(AppFunctionServiceDelegate.TAG, "AppFunction invocation exception: " + c44911.$executeAppFunctionRequest, appFunctionException);
                        c44911.$callback.onError(new AppFunctionException(appFunctionException.getErrorCode(), appFunctionException.getErrorMessage(), null, 4, null));
                    } catch (IllegalArgumentException e6) {
                        e = e6;
                        illegalArgumentException = e;
                        Log.w(AppFunctionServiceDelegate.TAG, "Invalid request: " + c44911.$executeAppFunctionRequest, illegalArgumentException);
                        c44911.$callback.onError(new AppFunctionException(1001, illegalArgumentException.getMessage(), null, 4, null));
                    } catch (CancellationException e7) {
                        e = e7;
                        cancellationException = e;
                        c44911.$callback.onError(new AppFunctionException(2001, cancellationException.getMessage(), null, 4, null));
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        Log.w(AppFunctionServiceDelegate.TAG, "Something went wrong when processing request " + c44911.$executeAppFunctionRequest, th);
                        c44911.$callback.onError(new AppFunctionException(3000, th.getMessage(), null, 4, null));
                    }
                } catch (AppFunctionException e8) {
                    e = e8;
                    c44911 = this;
                    appFunctionException = e;
                    Log.w(AppFunctionServiceDelegate.TAG, "AppFunction invocation exception: " + c44911.$executeAppFunctionRequest, appFunctionException);
                    c44911.$callback.onError(new AppFunctionException(appFunctionException.getErrorCode(), appFunctionException.getErrorMessage(), null, 4, null));
                } catch (IllegalArgumentException e9) {
                    e = e9;
                    c44911 = this;
                    illegalArgumentException = e;
                    Log.w(AppFunctionServiceDelegate.TAG, "Invalid request: " + c44911.$executeAppFunctionRequest, illegalArgumentException);
                    c44911.$callback.onError(new AppFunctionException(1001, illegalArgumentException.getMessage(), null, 4, null));
                } catch (CancellationException e10) {
                    e = e10;
                    c44911 = this;
                    cancellationException = e;
                    c44911.$callback.onError(new AppFunctionException(2001, cancellationException.getMessage(), null, 4, null));
                } catch (Throwable th4) {
                    th = th4;
                    c44911 = this;
                    th = th;
                    Log.w(AppFunctionServiceDelegate.TAG, "Something went wrong when processing request " + c44911.$executeAppFunctionRequest, th);
                    c44911.$callback.onError(new AppFunctionException(3000, th.getMessage(), null, 4, null));
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            c44911 = this;
            c44911.$callback.onResult((ExecuteAppFunctionResponse) obj);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C44911) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public AppFunctionServiceDelegate(@NotNull Context context, @NotNull CoroutineContext workerCoroutineContext, @NotNull CoroutineContext mainCoroutineContext, @NotNull AppFunctionInvoker appFunctionInvoker, @NotNull AppFunctionInventory appFunctionInventory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerCoroutineContext, "workerCoroutineContext");
        Intrinsics.checkNotNullParameter(mainCoroutineContext, "mainCoroutineContext");
        Intrinsics.checkNotNullParameter(appFunctionInvoker, "appFunctionInvoker");
        Intrinsics.checkNotNullParameter(appFunctionInventory, "appFunctionInventory");
        this.mainCoroutineContext = mainCoroutineContext;
        this.appFunctionInvoker = appFunctionInvoker;
        this.appFunctionInventory = appFunctionInventory;
        CompletableJob completableJobJob$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.job = completableJobJob$default;
        this.workerCoroutineScope = CoroutineScopeKt.CoroutineScope(workerCoroutineContext.plus(completableJobJob$default));
        this.appContext = context.getApplicationContext();
        this.metadataCacheMap = LazyKt.lazy(new Function0<Map<String, ? extends AppFunctionMetadata>>() { // from class: com.google.android.appfunctions.service.AppFunctionServiceDelegate$metadataCacheMap$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<String, ? extends AppFunctionMetadata> invoke() {
                AppFunctionServiceDelegate appFunctionServiceDelegate = this.this$0;
                Map mapCreateMapBuilder = MapsKt.createMapBuilder();
                for (AppFunctionMetadata appFunctionMetadata : appFunctionServiceDelegate.appFunctionInventory.getFunctionToMetadataMap().values()) {
                    mapCreateMapBuilder.put(appFunctionMetadata.getId(), appFunctionMetadata);
                }
                return MapsKt.build(mapCreateMapBuilder);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppFunctionMetadata extractAppFunctionMetadata(ExecuteAppFunctionRequest executeAppFunctionRequest) {
        return getMetadataCacheMap().get(executeAppFunctionRequest.getFunctionIdentifier());
    }

    private final Object extractParameter(AppFunctionParameterMetadata metadata, AppFunctionDocument parameters) {
        Object objUnsafeGetPropertyList = metadata.getParameterType().getIsList() ? AppFunctionDocumentUtils.unsafeGetPropertyList(parameters, metadata.getId(), metadata.getParameterType().getDataType(), getParameterEntityClass(metadata)) : AppFunctionDocumentUtils.unsafeGetProperty(parameters, metadata.getId(), metadata.getParameterType().getDataType(), getParameterEntityClass(metadata));
        validateParameter(metadata, objUnsafeGetPropertyList);
        return objUnsafeGetPropertyList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> extractParameters(ExecuteAppFunctionRequest executeAppFunctionRequest, AppFunctionMetadata appFunctionMetadata) {
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        for (AppFunctionParameterMetadata appFunctionParameterMetadata : appFunctionMetadata.getParameters()) {
            mapCreateMapBuilder.put(appFunctionParameterMetadata.getName(), extractParameter(appFunctionParameterMetadata, executeAppFunctionRequest.getFunctionParameters()));
        }
        return MapsKt.build(mapCreateMapBuilder);
    }

    private final Map<String, AppFunctionMetadata> getMetadataCacheMap() {
        return (Map) this.metadataCacheMap.getValue();
    }

    private final Class<? extends Object> getParameterEntityClass(AppFunctionParameterMetadata metadata) {
        if (metadata.getParameterType().getDataType() != 3) {
            return null;
        }
        if (metadata.getParameterType().getDocumentType() == null) {
            throw new IllegalStateException("Document parameter must have document type");
        }
        try {
            return Class.forName(metadata.getParameterType().getDocumentType());
        } catch (ClassNotFoundException e) {
            Log.w(TAG, "Unable to resolve java class for [" + metadata.getParameterType().getDocumentType() + "]", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeFunctionInternal(ExecuteAppFunctionRequest executeAppFunctionRequest, String str, AppFunctionMetadata appFunctionMetadata, Map<String, ? extends Object> map, Continuation<? super ExecuteAppFunctionResponse> continuation) {
        C44901 c44901;
        AppFunctionServiceDelegate appFunctionServiceDelegate;
        if (continuation instanceof C44901) {
            c44901 = (C44901) continuation;
            int i = c44901.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c44901.label = i - Integer.MIN_VALUE;
            } else {
                c44901 = new C44901(continuation);
            }
        }
        Object objWithContext = c44901.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c44901.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            CoroutineContext coroutineContext = this.mainCoroutineContext;
            AppFunctionServiceDelegate$invokeFunctionInternal$result$1 appFunctionServiceDelegate$invokeFunctionInternal$result$1 = new AppFunctionServiceDelegate$invokeFunctionInternal$result$1(this, str, executeAppFunctionRequest, map, null);
            c44901.L$0 = this;
            c44901.L$1 = appFunctionMetadata;
            c44901.label = 1;
            objWithContext = BuildersKt.withContext(coroutineContext, appFunctionServiceDelegate$invokeFunctionInternal$result$1, c44901);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            appFunctionServiceDelegate = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            appFunctionMetadata = (AppFunctionMetadata) c44901.L$1;
            appFunctionServiceDelegate = (AppFunctionServiceDelegate) c44901.L$0;
            ResultKt.throwOnFailure(objWithContext);
        }
        return new ExecuteAppFunctionResponse(appFunctionServiceDelegate.prepareFunctionResult(appFunctionMetadata, objWithContext));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppFunctionContext prepareAppFunctionContext(Context applicationContext, String callingPackageName) {
        return new AppFunctionContextImpl(applicationContext, callingPackageName);
    }

    private final AppFunctionDocument prepareFunctionResult(AppFunctionMetadata appFunctionMetadata, Object result) {
        if (appFunctionMetadata.getReturnType().getIsList()) {
            validateListTypeFunctionResult(appFunctionMetadata, result);
            return AppFunctionDocumentUtils.unsafeBuildListResultDocumentByType(appFunctionMetadata.getReturnType().getDataType(), (List) result);
        }
        validateFunctionResult(appFunctionMetadata, result);
        return AppFunctionDocumentUtils.unsafeBuildResultDocumentByType(appFunctionMetadata.getReturnType().getDataType(), result);
    }

    private final void validateFunctionResult(AppFunctionMetadata appFunctionMetadata, Object result) {
        if (!appFunctionMetadata.getReturnType().getIsNullable() && result == null) {
            throw new IllegalArgumentException(AbstractC0541b.m773o("[", appFunctionMetadata.getId(), "] is specified to return non-null. But null is returned").toString());
        }
    }

    private final void validateListTypeFunctionResult(AppFunctionMetadata appFunctionMetadata, Object result) {
        if (result == null) {
            if (!appFunctionMetadata.getReturnType().getIsNullable()) {
                throw new IllegalArgumentException(AbstractC0541b.m756B(appFunctionMetadata.getId(), "] is specified to return non-null List. But result is null").toString());
            }
        } else {
            if (result instanceof List) {
                return;
            }
            throw new IllegalArgumentException(("[" + appFunctionMetadata.getId() + "] is specified to return a List. But [" + result.getClass() + "] is returned").toString());
        }
    }

    private final void validateParameter(AppFunctionParameterMetadata parameterMetadata, Object parameter) {
        if (!parameterMetadata.getParameterType().getIsNullable() && parameter == null) {
            throw new IllegalArgumentException(AbstractC0541b.m773o("Parameter [", parameterMetadata.getName(), "] cannot be null").toString());
        }
    }

    public final void onDestroy() {
        Job.DefaultImpls.cancel$default((Job) this.job, (CancellationException) null, 1, (Object) null);
    }

    @NotNull
    public final Job onExecuteFunction(@NotNull ExecuteAppFunctionRequest executeAppFunctionRequest, @NotNull String callingPackageName, @NotNull OutcomeReceiver callback) {
        Intrinsics.checkNotNullParameter(executeAppFunctionRequest, "executeAppFunctionRequest");
        Intrinsics.checkNotNullParameter(callingPackageName, "callingPackageName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return BuildersKt__Builders_commonKt.launch$default(this.workerCoroutineScope, null, null, new C44911(executeAppFunctionRequest, callback, callingPackageName, null), 3, null);
    }
}
