package androidx.credentials.playservices;

import android.content.Context;
import android.os.CancellationSignal;
import androidx.credentials.CredentialManagerCallback;
import com.google.android.gms.tasks.OnFailureListener;
import com.samsung.android.app.notes.sync.network.InterfaceC6846k;
import com.samsung.android.app.notes.sync.p135db.C6741j;
import com.samsung.android.sdk.mobileservice.social.group.GroupApi;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupInvitationResult;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.result.SpaceResult;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.coedit.caller.handler.InternalImportHandler;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTUpdateDataTask;
import com.vladsch.flexmark.util.format.MarkdownTable;
import com.vladsch.flexmark.util.format.TableCellOffsetInfo;
import com.vladsch.flexmark.util.format.TableRow;
import com.vladsch.flexmark.util.format.TableRowManipulator;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.function.BiFunction;
import kotlin.jvm.internal.Ref;
import p001A.AbstractC0000a;
import p002A0.C0002b;
import p002A0.C0009i;
import p002A0.C0011k;
import p003A1.C0012a;
import p086V.C0322h;
import p261z1.C14520a;
import p261z1.C14523d;

/* JADX INFO: renamed from: androidx.credentials.playservices.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C2517b implements OnFailureListener, GroupApi.GroupResultCallback, ShareApi.SpaceResultCallback, STTUpdateDataTask.Callback, TableRowManipulator, InterfaceC6846k {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1385a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1386b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f1387c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f1388d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f1389e;

    public /* synthetic */ C2517b(int i, Object obj, Object obj2, Object obj3, Object obj4) {
        this.f1385a = i;
        this.f1386b = obj;
        this.f1387c = obj2;
        this.f1388d = obj3;
        this.f1389e = obj4;
    }

    @Override // com.samsung.android.app.notes.sync.network.InterfaceC6846k
    /* JADX INFO: renamed from: a */
    public void mo264a(int i) {
        switch (this.f1385a) {
            case 5:
                C14520a c14520a = (C14520a) this.f1386b;
                String str = (String) this.f1387c;
                C0002b c0002b = (C0002b) this.f1388d;
                String str2 = (String) this.f1389e;
                AbstractC0000a.m17n(i, "onResponse - uploadFile = ", "SyncOldNote$SyncCategory");
                if (i == 0) {
                    synchronized (C0322h.m670a().f829o.synchronizeCategory()) {
                        try {
                            if (C0322h.m670a().f829o.getCategoryServerTimestamp(c14520a.f10356e.f262e, str) <= c0002b.f12f) {
                                C0322h.m670a().f829o.setCategoryDirty(c14520a.f10356e.f262e, str, C0322h.m670a().f831q.getSdocContractNo());
                            }
                        } finally {
                        }
                        break;
                    }
                    C0012a c0012a = c14520a.f10356e;
                    if (!c0012a.f79t) {
                        c0012a.f79t = true;
                    }
                }
                File file = new File(str2);
                if (!file.exists() || file.delete()) {
                    return;
                }
                Debugger.m8609e("SyncOldNote$SyncCategory", "Failed to delete json!");
                return;
            case 6:
                C14523d c14523d = (C14523d) this.f1386b;
                C6741j c6741j = (C6741j) this.f1387c;
                C0009i c0009i = (C0009i) this.f1388d;
                String str3 = (String) this.f1389e;
                C0012a c0012a2 = c14523d.f10378e;
                AbstractC0000a.m17n(i, "onResponse - uploadFile = ", "SyncOldNote$SyncSDoc");
                if (i == 0) {
                    NotesDocumentEntity notesDocumentEntity = c6741j.f4107a.f4128a;
                    if ((notesDocumentEntity != null ? notesDocumentEntity.getServerTimestamp().longValue() : 0L) <= c0009i.f40c) {
                        C0322h.m670a().f831q.setNoteDirty(c0012a2.f262e, str3, C0322h.m670a().f831q.getSdocContractNo());
                    }
                    if (c0012a2.f79t) {
                        return;
                    }
                    c0012a2.f79t = true;
                    return;
                }
                return;
            default:
                C14520a c14520a2 = (C14520a) this.f1386b;
                String str4 = (String) this.f1387c;
                C0011k c0011k = (C0011k) this.f1388d;
                String str5 = (String) this.f1389e;
                AbstractC0000a.m17n(i, "onResponse - uploadFile = ", "SyncOldNote$SyncTag");
                if (i == 0) {
                    synchronized (C0322h.m670a().f830p.synchronizeTag()) {
                        try {
                            if (C0322h.m670a().f830p.getTagServerTimestamp(str4) <= c0011k.f64e) {
                                C0322h.m670a().f830p.setTagDirty(str4, C0322h.m670a().f831q.getSdocContractNo());
                            }
                        } finally {
                        }
                        break;
                    }
                    C0012a c0012a3 = c14520a2.f10356e;
                    if (!c0012a3.f79t) {
                        c0012a3.f79t = true;
                    }
                }
                File file2 = new File(str5);
                if (!file2.exists() || file2.delete()) {
                    return;
                }
                Debugger.m8609e("SyncOldNote$SyncTag", "Failed to delete json!");
                return;
        }
    }

    @Override // com.vladsch.flexmark.util.format.TableRowManipulator
    public int apply(TableRow tableRow, int i, ArrayList arrayList, int i2) {
        return TableCellOffsetInfo.lambda$getStopOffset$0((MarkdownTable) this.f1386b, (Map) this.f1387c, (Integer[]) this.f1388d, (BiFunction) this.f1389e, tableRow, i, arrayList, i2);
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        CredentialProviderPlayServicesImpl.onClearCredential$lambda$2((CredentialProviderPlayServicesImpl) this.f1386b, (CancellationSignal) this.f1387c, (Executor) this.f1388d, (CredentialManagerCallback) this.f1389e, exc);
    }

    @Override // com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask.Callback
    public void onFinished(boolean z) {
        STTPresenter.saveRealtimeData$lambda$54((SpenVoiceData) this.f1386b, (STTPresenter) this.f1387c, (Ref.IntRef) this.f1388d, (Ref.ObjectRef) this.f1389e, z);
    }

    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.SpaceResultCallback
    public void onResult(SpaceResult spaceResult) {
        ((InternalImportHandler) this.f1386b).lambda$createSharedNotebooksForRestore$1((String) this.f1387c, (Context) this.f1388d, (String) this.f1389e, spaceResult);
    }

    @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupResultCallback
    public void onResult(Object obj) {
        ((InternalImportHandler) this.f1386b).lambda$restoreNoteToCoedit$0((Context) this.f1387c, (NotesDocumentEntity) this.f1388d, (String) this.f1389e, (GroupInvitationResult) obj);
    }
}
