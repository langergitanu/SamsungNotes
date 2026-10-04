package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper;

import android.content.ContentResolver;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.synchronization.managers.C6899b;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMap;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ViewParams;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import p026F1.C0098b;
import p026F1.C0099c;
import p030G1.InterfaceC0107a;
import p042J1.C0145c;
import p044K.C0158a;
import p207n1.C13540g;
import p207n1.C13541h;
import p244u1.C14477a;
import p249v1.C14499b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005*\u0002\r\u0010\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u000bJ\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010 \u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/helper/SwipeRefreshHelper;", "", "viewParams", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/params/ViewParams;", "documentMap", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/model/DocumentMap;", "contract", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/helper/SwipeRefreshHelper$Contract;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/params/ViewParams;Lcom/samsung/android/support/senl/nt/app/main/noteslist/model/DocumentMap;Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/helper/SwipeRefreshHelper$Contract;)V", "isFailTipCardAvailable", "", "uiSyncProgressListener", "com/samsung/android/support/senl/nt/app/main/noteslist/presenter/helper/SwipeRefreshHelper$uiSyncProgressListener$1", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/helper/SwipeRefreshHelper$uiSyncProgressListener$1;", "networkCallback", "com/samsung/android/support/senl/nt/app/main/noteslist/presenter/helper/SwipeRefreshHelper$networkCallback$1", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/helper/SwipeRefreshHelper$networkCallback$1;", "registerNetworkCallback", "", "unregisterNetworkCallback", "getConnectivityManager", "Landroid/net/ConnectivityManager;", "requestSyncBySelectMode", "startSwipeRefresh", "syncProgressId", "", "endSwipeRefresh", "putSyncProgressInfo", "syncNoteCount", "", "removeSyncProgressInfo", "releaseSwipeRefresh", "Contract", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SwipeRefreshHelper {
    private static final long SYNC_PROGRESS_DURATION = 5000;
    private static final int SYNC_PROGRESS_FAIL_COUNT = -1;

    @NotNull
    private static final String TAG = "SwipeRefreshHelper";

    @NotNull
    private final Contract contract;

    @NotNull
    private final DocumentMap documentMap;
    private boolean isFailTipCardAvailable;

    @NotNull
    private final SwipeRefreshHelper$networkCallback$1 networkCallback;

    @NotNull
    private final SwipeRefreshHelper$uiSyncProgressListener$1 uiSyncProgressListener;

    @NotNull
    private final ViewParams viewParams;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/helper/SwipeRefreshHelper$Contract;", "", "addSyncProgressFailTipCard", "", "tipCard", "", "removeSyncProgressFailTipCard", "updateSyncProgress", NotesConstants.KEY_CALLER, "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void addSyncProgressFailTipCard(int tipCard);

        void removeSyncProgressFailTipCard(int tipCard);

        void updateSyncProgress(@NotNull String caller);
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.SwipeRefreshHelper$endSwipeRefresh$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.SwipeRefreshHelper$endSwipeRefresh$1", m14021f = "SwipeRefreshHelper.kt", m14022i = {}, m14023l = {159}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C84931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $syncProgressId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C84931(long j, Continuation<? super C84931> continuation) {
            super(2, continuation);
            this.$syncProgressId = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SwipeRefreshHelper.this.new C84931(this.$syncProgressId, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(5000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            SwipeRefreshHelper.this.removeSyncProgressInfo(this.$syncProgressId);
            SwipeRefreshHelper.this.contract.updateSyncProgress("SwipeRefreshHelper# swipe end");
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C84931) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.SwipeRefreshHelper$startSwipeRefresh$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.SwipeRefreshHelper$startSwipeRefresh$1", m14021f = "SwipeRefreshHelper.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C84941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $syncProgressId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C84941(long j, Continuation<? super C84941> continuation) {
            super(2, continuation);
            this.$syncProgressId = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SwipeRefreshHelper.this.new C84941(this.$syncProgressId, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            SwipeRefreshHelper.this.viewParams.getNotesView().stopSwipeRefreshLayout();
            SwipeRefreshHelper.this.contract.updateSyncProgress("SwipeRefreshHelper# swipe start");
            SwipeRefreshHelper.this.endSwipeRefresh(this.$syncProgressId);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C84941) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.SwipeRefreshHelper$uiSyncProgressListener$1] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.SwipeRefreshHelper$networkCallback$1] */
    public SwipeRefreshHelper(@NotNull ViewParams viewParams, @NotNull DocumentMap documentMap, @NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(viewParams, "viewParams");
        Intrinsics.checkNotNullParameter(documentMap, "documentMap");
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.viewParams = viewParams;
        this.documentMap = documentMap;
        this.contract = contract;
        this.isFailTipCardAvailable = true;
        this.uiSyncProgressListener = new InterfaceC0107a() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.SwipeRefreshHelper$uiSyncProgressListener$1
            @Override // p030G1.InterfaceC0107a
            public void onEnded(int errorCode) {
                AbstractC8014b.m7201c(errorCode, "UiSyncProgressListener# onEnded# errorCode : ", "SwipeRefreshHelper");
                if (errorCode == 101) {
                    this.this$0.putSyncProgressInfo(-21L, -1);
                }
                this.this$0.viewParams.getNotesView().stopSwipeRefreshLayout();
            }

            @Override // p030G1.InterfaceC0107a
            public void onProgress(C0098b syncProgressInfo) {
                Intrinsics.checkNotNullParameter(syncProgressInfo, "syncProgressInfo");
                syncProgressInfo.getClass();
                int i = syncProgressInfo.f321a;
                AbstractC8014b.m7201c(i, "UiSyncProgressListener# onProgress# noteCount : ", "SwipeRefreshHelper");
                if (i <= 0) {
                    this.this$0.viewParams.getNotesView().stopSwipeRefreshLayout();
                } else {
                    this.this$0.putSyncProgressInfo(-20L, i);
                }
            }

            @Override // p030G1.InterfaceC0107a
            public void onStarted() {
                MainLogger.m7258i("SwipeRefreshHelper", "UiSyncProgressListener# onStarted");
            }
        };
        this.networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.SwipeRefreshHelper$networkCallback$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                Intrinsics.checkNotNullParameter(network, "network");
                super.onAvailable(network);
                MainLogger.m7254d("SwipeRefreshHelper", "onAvailable#");
                this.this$0.contract.removeSyncProgressFailTipCard(35);
                this.this$0.unregisterNetworkCallback();
                this.this$0.isFailTipCardAvailable = true;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void endSwipeRefresh(long syncProgressId) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C84931(syncProgressId, null), 3, null);
    }

    private final ConnectivityManager getConnectivityManager() {
        Object systemService = this.viewParams.getContext().getApplicationContext().getSystemService("connectivity");
        if (systemService instanceof ConnectivityManager) {
            return (ConnectivityManager) systemService;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void putSyncProgressInfo(long syncProgressId, int syncNoteCount) {
        this.documentMap.putSyncProgressInfoMap(syncProgressId);
        this.documentMap.setSyncProgressInfoCount(syncProgressId, syncNoteCount);
        this.documentMap.putHolderInfoMap(10, true);
        this.documentMap.sortTopHolderDisplayList(10);
        startSwipeRefresh(syncProgressId);
    }

    private final void registerNetworkCallback() {
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addTransportType(1).addTransportType(0).addCapability(12).build();
        ConnectivityManager connectivityManager = getConnectivityManager();
        if (connectivityManager == null) {
            MainLogger.m7255e(TAG, "registerNetworkCallback# ConnectivityManager is null");
            return;
        }
        try {
            connectivityManager.registerNetworkCallback(networkRequestBuild, this.networkCallback);
        } catch (Exception e) {
            AbstractC6670b.m4738C("registerNetworkCallback# Failed to register: ", e.getMessage(), TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeSyncProgressInfo(long syncProgressId) {
        this.documentMap.removeSyncProgressInfoMap(syncProgressId);
        this.documentMap.removeHolderInfoMap(10);
        this.documentMap.sortTopHolderDisplayList(10);
        C14477a c14477aM15065b = C14477a.m15065b();
        SwipeRefreshHelper$uiSyncProgressListener$1 swipeRefreshHelper$uiSyncProgressListener$1 = this.uiSyncProgressListener;
        c14477aM15065b.f10283a.getClass();
        ArrayList arrayList = C14499b.f10312f;
        synchronized (arrayList) {
            arrayList.remove(swipeRefreshHelper$uiSyncProgressListener$1);
            Debugger.m8607d("SyncLogic", "Removed Ui Sync progress listener - size : " + arrayList.size());
        }
    }

    private final void startSwipeRefresh(long syncProgressId) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C84941(syncProgressId, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unregisterNetworkCallback() {
        ConnectivityManager connectivityManager = getConnectivityManager();
        if (connectivityManager == null) {
            MainLogger.m7255e(TAG, "unregisterNetworkCallback# ConnectivityManager is null");
            return;
        }
        try {
            connectivityManager.unregisterNetworkCallback(this.networkCallback);
        } catch (Exception e) {
            AbstractC6670b.m4738C("unregisterNetworkCallback# Failed to unregister: ", e.getMessage(), TAG);
        }
    }

    public final void releaseSwipeRefresh() {
        MainLogger.m7254d(TAG, "releaseSwipeRefresh#");
        this.documentMap.clearSyncProgressInfoMap();
        this.documentMap.removeHolderInfoMap(10);
        this.documentMap.sortTopHolderDisplayList(10);
        C14477a c14477aM15065b = C14477a.m15065b();
        SwipeRefreshHelper$uiSyncProgressListener$1 swipeRefreshHelper$uiSyncProgressListener$1 = this.uiSyncProgressListener;
        c14477aM15065b.f10283a.getClass();
        ArrayList arrayList = C14499b.f10312f;
        synchronized (arrayList) {
            arrayList.remove(swipeRefreshHelper$uiSyncProgressListener$1);
            Debugger.m8607d("SyncLogic", "Removed Ui Sync progress listener - size : " + arrayList.size());
        }
    }

    public final boolean requestSyncBySelectMode() {
        CommonSamsungAnalytics.INSTANCE.insertLog("101", NotesSAConstants.EVENT_NOTESLIST_SWIPE_TO_SYNC_NOW);
        if (this.documentMap.hasHolderInfo(10)) {
            MainLogger.m7254d(TAG, "requestSyncBySelectMode# sync progress bar visible");
            return false;
        }
        if (!ContentResolver.getMasterSyncAutomatically()) {
            MainLogger.m7254d(TAG, "requestSyncBySelectMode# master sync disabled");
            this.contract.addSyncProgressFailTipCard(34);
            return false;
        }
        if (!C0158a.m407a().m417k()) {
            MainLogger.m7254d(TAG, "requestSyncBySelectMode# settings sync with samsung account is off");
            this.contract.addSyncProgressFailTipCard(37);
            return false;
        }
        if (C0145c.m299G(this.viewParams.getContext()) && !C0145c.m298F(this.viewParams.getContext())) {
            AbstractC8014b.m7210l("requestSyncBySelectMode# wifi only and not connected# isFailTipCardAvailable : ", TAG, this.isFailTipCardAvailable);
            if (this.isFailTipCardAvailable) {
                this.contract.addSyncProgressFailTipCard(35);
                registerNetworkCallback();
                this.isFailTipCardAvailable = false;
                return false;
            }
        } else {
            if (!C0145c.m334s(this.viewParams.getContext())) {
                MainLogger.m7254d(TAG, "requestSyncBySelectMode# data network not available");
                putSyncProgressInfo(-21L, -1);
                return true;
            }
            if (!C0158a.m407a().m417k()) {
                MainLogger.m7254d(TAG, "requestSyncBySelectMode# settings sync with samsung account is off");
                this.viewParams.getNotesView().stopSwipeRefreshLayout();
                return false;
            }
            C14477a.m15065b().f10283a.getClass();
            if (C14499b.m15085e() && ((C13540g) C13541h.m14287e().f9588a).m14285a()) {
                MainLogger.m7254d(TAG, "requestSyncBySelectMode# request sync");
                C14477a c14477aM15065b = C14477a.m15065b();
                SwipeRefreshHelper$uiSyncProgressListener$1 swipeRefreshHelper$uiSyncProgressListener$1 = this.uiSyncProgressListener;
                c14477aM15065b.f10283a.getClass();
                ArrayList arrayList = C14499b.f10312f;
                synchronized (arrayList) {
                    try {
                        Iterator it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                ArrayList arrayList2 = C14499b.f10312f;
                                arrayList2.add(swipeRefreshHelper$uiSyncProgressListener$1);
                                Debugger.m8607d("SyncLogic", "Added Ui Sync progress listener - size : " + arrayList2.size());
                                break;
                            }
                            if (((InterfaceC0107a) it.next()).equals(swipeRefreshHelper$uiSyncProgressListener$1)) {
                            }
                        }
                    } finally {
                    }
                }
                C14477a c14477aM15065b2 = C14477a.m15065b();
                c14477aM15065b2.getClass();
                Debugger.m8615i("SyncManager", "requestSyncBySwiping()");
                C0099c c0099c = new C0099c(8384);
                C6899b.m5109a().f4467a = true;
                c14477aM15065b2.f10283a.m5100j(c0099c);
                return true;
            }
        }
        return false;
    }
}
