package androidx.transition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import androidx.core.os.CancellationSignal;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.samsung.android.app.notes.sync.network.InterfaceC6846k;
import com.samsung.android.sdk.scs.base.tasks.OnCompleteListener;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.translation.LlmTranslationRequest;
import com.samsung.android.sdk.scs.p142ai.translation.NeuralTranslationRequest;
import com.samsung.android.sdk.scs.p142ai.translation.NeuralTranslator;
import com.samsung.android.support.senl.p148nt.app.lock.strategy.VerifyStrategy;
import com.samsung.android.support.senl.p148nt.app.lock.view.convert.VerifyConvertPasswordDialog;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NumberedBadgeShadowBuilder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.DragAndDropHelper;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.SDocCategoryResolverContractImpl;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.STTPresenterImpl;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.DocSyncEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncInfoEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTUpdateDataTask;
import com.samsung.scsp.common.PushConsumerManager;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.decorator.AbstractDecorator;
import com.yubico.yubikit.android.transport.nfc.NfcConfiguration;
import com.yubico.yubikit.android.transport.nfc.NfcDispatcher;
import com.yubico.yubikit.android.transport.nfc.NfcYubiKeyManager;
import com.yubico.yubikit.core.util.Callback;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.function.FailableBiPredicate;
import org.apache.commons.lang3.function.FailableBooleanSupplier;
import p001A.AbstractC0000a;
import p003A1.C0012a;
import p086V.C0322h;
import p261z1.C14521b;
import p261z1.C14522c;

/* JADX INFO: renamed from: androidx.transition.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C3970a implements CancellationSignal.OnCancelListener, OnCompleteListener, VerifyConvertPasswordDialog.ResultListener, NumberedBadgeShadowBuilder.ShadowBuilderContract, STTUpdateDataTask.Callback, FaultBarrier.ThrowableRunnable, FaultBarrier.ThrowableSupplier, NfcDispatcher.OnTagHandler, Functions.FailableRunnable, Functions.FailableSupplier, FailableBooleanSupplier, SynchronizationGuard.CriticalSection, InterfaceC6846k {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1703a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1704b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f1705c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f1706d;

    public /* synthetic */ C3970a(Object obj, int i, Object obj2, Object obj3) {
        this.f1703a = i;
        this.f1704b = obj;
        this.f1705c = obj2;
        this.f1706d = obj3;
    }

    @Override // com.samsung.android.app.notes.sync.network.InterfaceC6846k
    /* JADX INFO: renamed from: a */
    public void mo264a(int i) {
        switch (this.f1703a) {
            case 13:
                C14521b c14521b = (C14521b) this.f1704b;
                HashMap map = (HashMap) this.f1705c;
                String str = (String) this.f1706d;
                C0012a c0012a = c14521b.f10361a;
                AbstractC0000a.m17n(i, "[UEL] onResponse - SYNC_CATEGORY_FILENAME = ", "SyncOldNote$SyncExtraList");
                if (i == 0) {
                    for (Map.Entry entry : map.entrySet()) {
                        String str2 = (String) entry.getKey();
                        long jLongValue = ((Long) entry.getValue()).longValue();
                        SDocCategoryResolverContractImpl sDocCategoryResolverContractImpl = C0322h.m670a().f829o;
                        Context context = c0012a.f262e;
                        if (sDocCategoryResolverContractImpl.getNoteCategoryServerTimestamp(context, str2) <= jLongValue && C0322h.m670a().f829o.getNoteCategoryDirty(context, str2) == C0322h.m670a().f831q.getSdocContractYes()) {
                            C0322h.m670a().f829o.setNoteCategoryDirty(context, str2, C0322h.m670a().f831q.getSdocContractNo());
                        }
                    }
                    Debugger.m8607d("SyncOldNote$SyncExtraList", "[UEL] finish to check DB!");
                    File file = new File(str);
                    if (file.exists() && !file.delete()) {
                        Debugger.m8609e("SyncOldNote$SyncExtraList", "[UEL] failed to delete zipfile");
                    }
                    if (!c0012a.f79t) {
                        c0012a.f79t = true;
                    }
                }
                Debugger.m8607d("SyncOldNote$SyncExtraList", "[UEL] onResponse finish");
                break;
            case 14:
                C14522c c14522c = (C14522c) this.f1704b;
                HashMap map2 = (HashMap) this.f1705c;
                String str3 = (String) this.f1706d;
                C0012a c0012a2 = c14522c.f10368b;
                AbstractC0000a.m17n(i, "[UEIL] onResponse - SYNC_CATEGORY_FILENAME = ", "SyncOldNote$SyncExtraListInfo");
                if (i == 0) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = map2.entrySet().iterator();
                    while (it.hasNext()) {
                        arrayList.add((String) ((Map.Entry) it.next()).getKey());
                    }
                    Context context2 = c0012a2.f262e;
                    new HashMap();
                    HashMap map3 = new HashMap();
                    List<DocSyncEntry> cacheSyncDocInfoList = NotesDataRepositoryFactory.newInstance(context2).createSyncNoteDataRepository().getCacheSyncDocInfoList(arrayList);
                    if (cacheSyncDocInfoList != null) {
                        for (DocSyncEntry docSyncEntry : cacheSyncDocInfoList) {
                            map3.put(docSyncEntry.getUuid(), docSyncEntry);
                        }
                    }
                    ArrayList<String> arrayList2 = new ArrayList();
                    NotesDataRepositoryFactory.newInstance(c0012a2.f262e).createSyncNoteDataRepository();
                    SyncInfoDao syncInfoDao = NotesDatabaseManager.getInstance().getSyncInfoDao();
                    for (Map.Entry entry2 : map2.entrySet()) {
                        String str4 = (String) entry2.getKey();
                        long jLongValue2 = ((Long) entry2.getValue()).longValue();
                        DocSyncEntry docSyncEntry2 = (DocSyncEntry) map3.get(str4);
                        if ((docSyncEntry2 != null ? docSyncEntry2.getServerTimestamp().longValue() : 0L) <= jLongValue2) {
                            arrayList2.add(str4);
                        }
                    }
                    for (String str5 : arrayList2) {
                        if (syncInfoDao.isExistByClientId(str5)) {
                            syncInfoDao.setExtraInfoDirty(str5, 0);
                        } else {
                            SyncInfoEntity syncInfoEntity = new SyncInfoEntity();
                            syncInfoEntity.setNoteClientId(str5);
                            syncInfoEntity.setIsExtraInfoDirty(0);
                            syncInfoDao.upsert(syncInfoEntity);
                        }
                    }
                    Debugger.m8607d("SyncOldNote$SyncExtraListInfo", "[UEIL] finish to check DB!");
                    File file2 = new File(str3);
                    if (file2.exists() && !file2.delete()) {
                        Debugger.m8609e("SyncOldNote$SyncExtraListInfo", "[UEIL] failed to delete zipfile");
                    }
                    if (!c0012a2.f79t) {
                        c0012a2.f79t = true;
                    }
                }
                Debugger.m8607d("SyncOldNote$SyncExtraListInfo", "[UEIL] onResponse finish");
                break;
            default:
                C14522c c14522c2 = (C14522c) this.f1704b;
                HashMap map4 = (HashMap) this.f1705c;
                String str6 = (String) this.f1706d;
                AbstractC0000a.m17n(i, "[UELT] onResponse - SYNC_TAG_FILENAME = ", "SyncOldNote$SyncExtraListTag");
                if (i == 0) {
                    for (Map.Entry entry3 : map4.entrySet()) {
                        String str7 = (String) entry3.getKey();
                        if (C0322h.m670a().f830p.getNoteTagServerTimestamp(str7) <= ((Long) entry3.getValue()).longValue()) {
                            C0322h.m670a().f830p.setNoteTagDirty(str7, C0322h.m670a().f831q.getSdocContractNo());
                        }
                    }
                    Debugger.m8607d("SyncOldNote$SyncExtraListTag", "[UELT] finish to check DB!");
                    File file3 = new File(str6);
                    if (file3.exists() && !file3.delete()) {
                        Debugger.m8609e("SyncOldNote$SyncExtraListTag", "[UELT] failed to delete zipfile");
                    }
                    C0012a c0012a3 = c14522c2.f10368b;
                    if (!c0012a3.f79t) {
                        c0012a3.f79t = true;
                    }
                }
                Debugger.m8607d("SyncOldNote$SyncExtraListTag", "[UELT] onResponse finish");
                break;
        }
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        return ((DefaultScheduler) this.f1704b).lambda$schedule$0((TransportContext) this.f1705c, (EventInternal) this.f1706d);
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
    public Object get() {
        switch (this.f1703a) {
            case 6:
                return ((AbstractDecorator) this.f1704b).lambda$getFeature$3((String) this.f1705c, this.f1706d);
            default:
                return ((Functions.FailableBiFunction) this.f1704b).apply(this.f1705c, this.f1706d);
        }
    }

    @Override // org.apache.commons.lang3.function.FailableBooleanSupplier
    public boolean getAsBoolean() {
        switch (this.f1703a) {
            case 10:
                return ((Functions.FailableBiPredicate) this.f1704b).test(this.f1705c, this.f1706d);
            default:
                return ((FailableBiPredicate) this.f1704b).test(this.f1705c, this.f1706d);
        }
    }

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        FragmentTransitionSupport.lambda$setListenerForTransitionEnd$0((Runnable) this.f1704b, (Transition) this.f1706d, (Runnable) this.f1705c);
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.OnCompleteListener
    public void onComplete(Task task) {
        NeuralTranslator.lambda$translate$2((Handler) this.f1704b, (LlmTranslationRequest) this.f1705c, (NeuralTranslationRequest) this.f1706d, task);
    }

    @Override // com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask.Callback
    public void onFinished(boolean z) {
        STTPresenterImpl.updateSTTData$lambda$0((ArrayList) this.f1704b, (Activity) this.f1705c, (STTPresenterImpl) this.f1706d, z);
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.view.convert.VerifyConvertPasswordDialog.ResultListener
    public void onResult(String str, String str2) {
        VerifyStrategy.showLegacyVerifyDialog$lambda$3((VerifyStrategy) this.f1704b, (Intent) this.f1705c, (Activity) this.f1706d, str, str2);
    }

    @Override // com.yubico.yubikit.android.transport.nfc.NfcDispatcher.OnTagHandler
    public void onTag(Tag tag) {
        NfcYubiKeyManager.lambda$enable$0((Callback) this.f1704b, (NfcConfiguration) this.f1705c, (ExecutorService) this.f1706d, tag);
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
    public void run() {
        switch (this.f1703a) {
            case 5:
                PushConsumerManager.lambda$add$0((Supplier) this.f1704b, (String[]) this.f1705c, (Bundle) this.f1706d);
                break;
            default:
                ((Functions.FailableBiConsumer) this.f1704b).accept(this.f1705c, this.f1706d);
                break;
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.common.view.NumberedBadgeShadowBuilder.ShadowBuilderContract
    public void setImageView(ImageView imageView) {
        ((DragAndDropHelper) this.f1704b).lambda$getNumberedBadgeShadowBuilder$2((String) this.f1705c, (CommonHolder) this.f1706d, imageView);
    }

    public /* synthetic */ C3970a(Runnable runnable, Transition transition, Runnable runnable2) {
        this.f1703a = 0;
        this.f1704b = runnable;
        this.f1706d = transition;
        this.f1705c = runnable2;
    }
}
