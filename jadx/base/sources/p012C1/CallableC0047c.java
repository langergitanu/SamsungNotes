package p012C1;

import android.content.Context;
import androidx.work.impl.Processor;
import com.airbnb.lottie.LottieCompositionFactory;
import com.samsung.android.app.notes.sync.p135db.C6735d;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.p135db.C6748q;
import com.samsung.android.sdk.scs.p142ai.text.category.DocumentCategoryClassifier;
import com.samsung.android.sdk.scs.p142ai.text.entity.BasicEntityExtractor;
import com.samsung.android.sdk.scs.p142ai.text.phrase.KeyPhraseExtractor;
import com.samsung.android.sdk.scs.p142ai.text.reminder.ReminderEntityExtractor;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.CoeditHelper;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncCategoryTreeInfo;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import p001A.AbstractC0000a;
import p007B0.C0021d;
import p007B0.C0027j;
import p022E1.C0077c;
import p026F1.C0097a;
import p206n0.C13533a;
import p255x1.C14512a;

/* JADX INFO: renamed from: C1.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class CallableC0047c implements Callable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f193a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f194b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f195c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f196d;

    public /* synthetic */ CallableC0047c(Object obj, int i, Object obj2, Object obj3) {
        this.f193a = i;
        this.f194b = obj;
        this.f195c = obj2;
        this.f196d = obj3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f193a) {
            case 0:
                C0049e c0049e = (C0049e) this.f194b;
                C6742k c6742k = (C6742k) this.f195c;
                C0097a c0097a = (C0097a) this.f196d;
                C0077c c0077c = c0049e.f205a;
                new C13533a(c0077c.f262e);
                try {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = ((C0021d) c6742k.f4111c).f114c.iterator();
                    while (it.hasNext()) {
                        arrayList.add(C6735d.m4826b((NotesCategoryTreeEntity) it.next()));
                    }
                    arrayList.addAll(((C0021d) c6742k.f4111c).f115d);
                    long j = ((C0021d) c6742k.f4111c).f113b;
                    int size = arrayList.size();
                    if (size <= 0) {
                        Debugger.m8615i("SyncFolder", "[EDP] upSyncEncryptedServerFolderItems() : None");
                        return null;
                    }
                    Debugger.m8615i("SyncFolder", "[EDP] upSyncEncryptedServerFolderItems() : " + size);
                    C0027j c0027j = new C0027j();
                    c0027j.f144b = CoverStickerConstants.Category.NONE.NAME;
                    c0027j.f145c = arrayList;
                    c0027j.f146d = c0077c;
                    c0027j.f143a = j;
                    new C14512a(c0077c.f265h, c0077c.f262e, c0097a, c0027j).m15112c();
                    return null;
                } catch (Exception e) {
                    AbstractC0000a.m22s("[EDP] upSyncEncryptedServerFolderItems() : ", e, "SyncFolder");
                    return null;
                }
            case 1:
                C0052h c0052h = (C0052h) this.f194b;
                C6748q c6748q = (C6748q) this.f195c;
                String str = (String) this.f196d;
                C0077c c0077c2 = c0052h.f216a;
                NotesDocumentEntity notesDocumentEntity = c6748q.f4128a;
                boolean z = false;
                if ((notesDocumentEntity != null ? notesDocumentEntity.getCategoryIsDirty() : 0) == 1) {
                    Debugger.m8615i("SyncNote", "isFolderInfoOfNoteUploaded() : No note node " + str);
                } else {
                    SyncCategoryTreeInfo syncCategoryTreeInfoM14279a = null;
                    String categoryUuid = notesDocumentEntity != null ? notesDocumentEntity.getCategoryUuid() : null;
                    PredefinedCategory predefinedCategory = PredefinedCategory.UNCATEGORIZED;
                    if (predefinedCategory.getUuid().equals(categoryUuid) || PredefinedCategory.OLD_NOTES.getUuid().equals(categoryUuid) || PredefinedCategory.RECYCLE_BIN.getUuid().equals(categoryUuid)) {
                        z = true;
                    } else {
                        C13533a c13533a = new C13533a(c0077c2.f262e);
                        if ((categoryUuid == null || (syncCategoryTreeInfoM14279a = c13533a.m14279a(categoryUuid)) == null) ? false : true) {
                            if (syncCategoryTreeInfoM14279a == null || !categoryUuid.equals(syncCategoryTreeInfoM14279a.getUUID())) {
                                syncCategoryTreeInfoM14279a = c13533a.m14279a(categoryUuid);
                            }
                            if ((syncCategoryTreeInfoM14279a != null ? syncCategoryTreeInfoM14279a.getIsDirty() : 0) == 1) {
                                Debugger.m8615i("SyncNote", "isFolderInfoOfNoteUploaded() : No parent node " + categoryUuid + " of " + str);
                            }
                        } else if (c0077c2.f269l.get(categoryUuid) == null && c6748q.m4878f() == 0) {
                            Debugger.m8609e("SyncNote", "isFolderInfoOfNoteUploaded() : No parent " + categoryUuid + " of " + str);
                            c0077c2.f266i.f4133a.updateCategory(str, predefinedCategory.getUuid());
                        }
                        z = true;
                    }
                }
                if (z) {
                    return Boolean.TRUE;
                }
                Debugger.m8615i("SyncNote", "upSyncLocalNote() : " + str + " is not uploaded due to no folder info!");
                c0077c2.f271n = true;
                return Boolean.FALSE;
            case 2:
                return ((Processor) this.f194b).lambda$startWork$0((ArrayList) this.f195c, (String) this.f196d);
            case 3:
                return LottieCompositionFactory.fromInputStreamSync((Context) this.f194b, (InputStream) this.f195c, (String) this.f196d);
            case 4:
                return ((DocumentCategoryClassifier) this.f194b).lambda$classifySynchronously$2((String) this.f195c, (DocumentCategoryClassifier.ClassifyOptions) this.f196d);
            case 5:
                return ((DocumentCategoryClassifier) this.f194b).lambda$getCategoryInfo$1((DocumentCategoryClassifier.RequestType) this.f195c, (String) this.f196d);
            case 6:
                return ((KeyPhraseExtractor) this.f194b).lambda$isSupported$0((KeyPhraseExtractor.RequestType) this.f195c, (String) this.f196d);
            case 7:
                return ((ReminderEntityExtractor) this.f194b).lambda$requestExtract$1((String) this.f195c, (String) this.f196d);
            case 8:
                return CoeditHelper.lambda$requestImport$0((List) this.f194b, (Context) this.f195c, (String) this.f196d);
            default:
                return ((BasicEntityExtractor) this.f194b).lambda$isSupported$0((String) this.f195c, (String) this.f196d);
        }
    }
}
