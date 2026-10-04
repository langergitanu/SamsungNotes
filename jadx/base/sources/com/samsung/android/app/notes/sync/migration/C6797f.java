package com.samsung.android.app.notes.sync.migration;

import android.content.Context;
import android.util.Pair;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.access.document.DocumentAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.data.DataUpdateManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.tuple.DocumentCoverStateTuple;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.cover.NotesDocumentCoverRepository;
import com.samsung.android.support.senl.p148nt.model.domain.cover.UpdateDocumentCoverUseCase;
import java.util.HashMap;
import java.util.Map;
import p020E.C0073a;
import p042J1.AbstractC0147e;
import p042J1.C0148f;
import p079T.AbstractC0299q;
import p084U0.AbstractC0311c;
import p086V.C0322h;
import p126c1.AbstractC4207b;
import p126c1.C4206a;
import p186h1.AbstractC12023d;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.migration.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6797f extends AbstractC0311c {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ HashMap f4217a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f4218b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C0073a f4219c;

    public C6797f(C0073a c0073a, HashMap map, int i) {
        this.f4219c = c0073a;
        this.f4217a = map;
        this.f4218b = i;
    }

    @Override // p084U0.InterfaceC0313e
    public final void onFinish(int i, int i2, Map map, int i4) {
        String str = C6798g.f4220k;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "onFinish total ", ", errorCount ", ", successCount ");
        sbM1173s.append(i4);
        AbstractC0299q.m647r(str, sbM1173s.toString());
        if (this.f4218b > 0) {
            String str2 = C0148f.f420k;
            AbstractC0147e.f419a.f434d = false;
        }
        C0073a c0073a = this.f4219c;
        C6798g c6798g = (C6798g) c0073a.f254b;
        int i5 = c6798g.f4225d + i;
        c6798g.f4225d = i5;
        int i6 = c6798g.f4224c;
        if (i5 >= i6) {
            c6798g.m4965i(i6, i6);
            C6798g c6798g2 = (C6798g) c0073a.f254b;
            c6798g2.f4225d = 0;
            c6798g2.f4224c = 0;
        } else {
            C6798g.m4958c(c6798g, i5, i6);
        }
        if (i != i4) {
            String str3 = AbstractC12023d.f8776a;
            int i7 = C0322h.m670a().f815a.getAppContext().getSharedPreferences("SAMSUNGNOTE_MIGRATION_PREFERENCES", 0).getInt("retry_count", 0);
            AbstractC0299q.m643n(str, "onFinish retryCount " + i7);
            if (i7 > 10) {
                AbstractC12023d.m13677V(0);
                C6798g.m4957b((C6798g) c0073a.f254b);
            } else {
                AbstractC12023d.m13677V(i7 + 1);
            }
        } else {
            AbstractC12023d.m13677V(0);
            C6798g.m4957b((C6798g) c0073a.f254b);
        }
        C6798g.m4962h().m4971p();
        if (DeviceInfo.isEngMode() && i2 > 0) {
            ((C6798g) c0073a.f254b).getClass();
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : map.entrySet()) {
                sb.append(System.lineSeparator());
                sb.append((String) entry.getKey());
                sb.append("/");
                sb.append(entry.getValue());
            }
            AbstractC0299q.m643n(C6798g.f4220k, "dumpErrorCodes " + sb.toString());
        }
        DataUpdateManager.getInstance().onDataUpdated(1);
        if (WidgetAccessHandler.getWidgetAccessContract() != null) {
            AbstractC0299q.m643n(C6798g.f4220k, "onRestoreFinished send update to finish widget broadcast");
            WidgetAccessHandler.getWidgetAccessContract().sendUpdateAllWidgetBroadcast(C0322h.m670a().f815a.getAppContext());
        }
        AbstractC12023d.m13676U(AbstractC12023d.m13699v() - 1);
    }

    @Override // p084U0.AbstractC0311c, p084U0.InterfaceC0313e
    public final void onProgress(int i, int i2) {
        AbstractC0299q.m643n(C6798g.f4220k, "onProgress " + i + "/" + i2);
        C6798g c6798g = (C6798g) this.f4219c.f254b;
        C6798g.m4958c(c6798g, c6798g.f4225d + i, c6798g.f4224c);
    }

    @Override // com.samsung.android.support.senl.nt.model.importer.task.ImportTask.ListerImpl, com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
    public final void onStart(String str, String str2) {
        AbstractC0299q.m643n(C6798g.f4220k, "onStart import document uuid " + str);
    }

    @Override // com.samsung.android.support.senl.nt.model.importer.task.ImportTask.ListerImpl, com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
    public final void onSuccess(String str, String str2, String str3, Pair pair) {
        if (pair == null) {
            AbstractC0299q.m646q(C6798g.f4220k, "onSuccess uuidPair is null");
            return;
        }
        Context appContext = C0322h.m670a().f815a.getAppContext();
        String str4 = (String) pair.first;
        String str5 = (String) pair.second;
        AbstractC0299q.m643n(C6798g.f4220k, "onSuccess import document originalUuid/newUuid " + str4 + "/" + str5);
        C4206a c4206a = (C4206a) this.f4217a.get(str4);
        if (c4206a != null) {
            String str6 = str4.equals(str5) ? str4 : str5;
            String str7 = AbstractC4207b.f1851a;
            AbstractC0299q.m643n(str7, "restoreCoverPreview uuid " + str6);
            try {
                DocumentAccessHandler.getContract().createCoverPreview(appContext, c4206a.f1843e, c4206a.f1845g, c4206a.f1840b, c4206a.f1846h, str6, c4206a.f1850l);
            } catch (Exception e) {
                AbstractC0299q.m646q(str7, "restoreCoverPreview() : fail to update, " + e);
            }
            NotesDataRepositoryFactory notesDataRepositoryFactoryNewInstance = NotesDataRepositoryFactory.newInstance(appContext);
            NotesDocumentCoverRepository notesDocumentCoverRepositoryCreateDocumentCoverRepository = notesDataRepositoryFactoryNewInstance.createDocumentCoverRepository();
            DocumentCoverStateTuple documentCoverStateTuple = new DocumentCoverStateTuple();
            documentCoverStateTuple.setDocUuid(c4206a.f1839a);
            documentCoverStateTuple.setTemplateUuid(c4206a.f1840b);
            documentCoverStateTuple.setTitle(c4206a.f1841c);
            documentCoverStateTuple.setTitleAlignment(c4206a.f1842d);
            documentCoverStateTuple.setSummary(c4206a.f1843e);
            documentCoverStateTuple.setSummaryAlignment(c4206a.f1844f);
            documentCoverStateTuple.setCategoryUuid(c4206a.f1845g);
            documentCoverStateTuple.setBackgroundColor(c4206a.f1846h);
            documentCoverStateTuple.setCreatedAt(c4206a.f1847i);
            documentCoverStateTuple.setLastModifiedAt(c4206a.f1848j);
            documentCoverStateTuple.setIsEnabled(c4206a.f1849k);
            documentCoverStateTuple.state = c4206a.f1850l;
            AbstractC0299q.m643n(AbstractC4207b.f1851a, "restoreCoverDB entity " + documentCoverStateTuple.getDocUuid());
            notesDataRepositoryFactoryNewInstance.createCoverStickerRepository().insertIfNotExists(documentCoverStateTuple.getCategoryUuid());
            notesDataRepositoryFactoryNewInstance.createCoverTemplateRepository().insertIfNotExists(documentCoverStateTuple.getTemplateUuid());
            new UpdateDocumentCoverUseCase(notesDocumentCoverRepositoryCreateDocumentCoverRepository).invoke(documentCoverStateTuple, documentCoverStateTuple.state, "SmartSwitch");
        }
    }
}
