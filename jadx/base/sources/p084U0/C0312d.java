package p084U0;

import android.content.Context;
import android.util.Pair;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.access.sync.importer.data.ImportDocument;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentExtensionUtils;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.DataRepositoryScheduler;
import com.samsung.android.support.senl.p148nt.model.importer.common.Constants;
import com.samsung.android.support.senl.p148nt.model.importer.task.ImportDocInfo;
import com.samsung.android.support.senl.p148nt.model.importer.task.ImportSdocTask;
import com.samsung.android.support.senl.p148nt.model.importer.task.ImportSdocXTask;
import com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask;
import com.samsung.android.support.senl.p148nt.model.importer.task.param.ImportSdocParam;
import com.samsung.android.support.senl.p148nt.model.importer.task.param.ImportSdocXParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import p001A.AbstractC0000a;
import p020E.C0073a;
import p042J1.AbstractC0144b;
import p042J1.AbstractC0147e;
import p042J1.C0148f;
import p079T.AbstractC0299q;
import p087V0.CallableC0325c;

/* JADX INFO: renamed from: U0.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0312d implements InterfaceC0313e {

    /* JADX INFO: renamed from: p */
    public static final String f795p = "SS$".concat("ImportDocumentManager");

    /* JADX INFO: renamed from: a */
    public final Context f796a;

    /* JADX INFO: renamed from: b */
    public final ArrayList f797b;

    /* JADX INFO: renamed from: c */
    public final ArrayList f798c;

    /* JADX INFO: renamed from: d */
    public final AtomicInteger f799d;

    /* JADX INFO: renamed from: e */
    public final AtomicInteger f800e;

    /* JADX INFO: renamed from: f */
    public final AtomicInteger f801f;

    /* JADX INFO: renamed from: g */
    public final AtomicInteger f802g;

    /* JADX INFO: renamed from: h */
    public final ConcurrentHashMap f803h;

    /* JADX INFO: renamed from: i */
    public ExecutorService f804i;

    /* JADX INFO: renamed from: j */
    public CallableC0325c f805j;

    /* JADX INFO: renamed from: k */
    public boolean f806k;

    /* JADX INFO: renamed from: l */
    public boolean f807l;

    /* JADX INFO: renamed from: m */
    public InterfaceC0313e f808m;

    /* JADX INFO: renamed from: n */
    public final String f809n;

    /* JADX INFO: renamed from: o */
    public final C0310b f810o;

    public C0312d(Context context, List list, String str) {
        ArrayList arrayList = new ArrayList();
        this.f797b = arrayList;
        this.f798c = new ArrayList();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.f799d = atomicInteger;
        this.f800e = new AtomicInteger(0);
        this.f801f = new AtomicInteger(0);
        this.f802g = new AtomicInteger(0);
        this.f803h = new ConcurrentHashMap();
        this.f810o = new C0310b(this);
        this.f796a = context.getApplicationContext();
        this.f809n = str;
        if (list == null || list.isEmpty()) {
            return;
        }
        arrayList.addAll(list);
        atomicInteger.set(list.size());
        SpenSdkInitializer.initialize(context);
        AbstractC0299q.m643n(f795p, "ImportDocumentManager, mTotalTaskCount : " + atomicInteger.get());
    }

    /* JADX INFO: renamed from: a */
    public static void m662a(C0312d c0312d, String str, String str2, String str3, int i, ImportItem importItem, boolean z, String str4, boolean z2) {
        ImportTask importSdocXTask;
        String extension = DocumentExtensionUtils.getExtension(str2);
        Context context = c0312d.f796a;
        String str5 = c0312d.f809n;
        ImportDocInfo importDocInfo = null;
        if (".sdoc".equals(extension)) {
            importSdocXTask = new ImportSdocTask(new ImportSdocParam().setContext(context).setUuid(str).setUuidPair(importItem != null ? importItem.getUuidPair() : null).setExternalPath(str2).setFolderUuid(str3).setCaller(str5));
        } else {
            importSdocXTask = new ImportSdocXTask(new ImportSdocXParam().setContext(context).setUuid(str).setUuidPair(importItem != null ? importItem.getUuidPair() : null).setExternalPath(str2).setFolderUuid(str3).setCaller(str5).setIsCoEditNote(z2).setClearCanvasCache(Constants.CALLER_DUPLICATE_NOTE.equals(str5)).setSkipEmptyNote(c0312d.f807l), i, str4);
        }
        ImportTask imported = importSdocXTask.setDeleteExternalFile(z).setImported(c0312d.f806k);
        if (importItem != null) {
            importDocInfo = new ImportDocInfo();
            importDocInfo.setChangeUuidFlag(importItem.getChangeUUIDFlag());
            importDocInfo.setSaveNew(importItem.getSaveNew());
            importDocInfo.setTitle(importItem.getTitle());
            importDocInfo.setSaveRecovery(importItem.getSaveRecovery());
            importDocInfo.setServerKey(importItem.getServerKey());
            importDocInfo.setFavorite(importItem.getFavorite());
            importDocInfo.setCategoryUuid(importItem.getCategoryUUID());
            importDocInfo.setCategoryServerTimeStamp(importItem.getCategoryServerTimeStamp());
            importDocInfo.setServerTimeStamp(importItem.getServerTimeStamp());
            importDocInfo.setLockState(importItem.getLockState());
            importDocInfo.setOwnerId(importItem.getOwnerId());
            importDocInfo.setRestorePath(importItem.getRestorePath());
            importDocInfo.setDeleteType(importItem.getDeleteType());
            importDocInfo.setCreatedTime(importItem.getCreatedTime());
            importDocInfo.setSaveTime(importItem.getSaveTime());
            importDocInfo.setMsSyncAccountId(importItem.getMsSyncAccountId());
            importDocInfo.setMsSyncDocumentid(importItem.getMsSyncDocumentid());
            importDocInfo.setMsLastSyncTime(importItem.getMsLastSyncTime());
            importDocInfo.setRecycleBinTimeMoved(importItem.getRecycleBinTimeMoved());
            importDocInfo.setMathMode(importItem.getMathMode());
            importDocInfo.setNeedCopyToExternal(importItem.getNeedCopyToExternal());
        }
        imported.setDocumentInfo(importDocInfo);
        DataRepositoryScheduler.callable(importSdocXTask.setImportTaskListener(c0312d)).executeOn(c0312d.m665d()).observe(new C6903f(c0312d, 8, str, str2)).execute();
    }

    /* JADX INFO: renamed from: b */
    public final void m663b(int i, int i2) throws Throwable {
        int i4 = i + i2;
        AtomicInteger atomicInteger = this.f799d;
        if (i4 >= atomicInteger.get()) {
            onFinish(atomicInteger.get(), this.f802g.get(), this.f803h, this.f801f.get());
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m664c(boolean z) {
        if (this.f797b.isEmpty() && this.f798c.isEmpty()) {
            String str = C0148f.f420k;
            C0148f c0148f = AbstractC0147e.f419a;
            C0148f.m358n(0, 0, c0148f.f431a, c0148f.f432b);
        } else {
            if (this.f805j == null) {
                this.f805j = new CallableC0325c();
            }
            DataRepositoryScheduler.callable(this.f805j).executeOn(m665d()).observe(new C0309a(this, z)).execute();
        }
    }

    /* JADX INFO: renamed from: d */
    public final ExecutorService m665d() {
        if (this.f804i == null) {
            this.f804i = Executors.newFixedThreadPool(2, new SenlThreadFactory("data_import_"));
        }
        return this.f804i;
    }

    /* JADX INFO: renamed from: e */
    public final void m666e(String str, String str2, int i, String str3) {
        InterfaceC0313e interfaceC0313e = this.f808m;
        if (interfaceC0313e != null) {
            interfaceC0313e.onFail(str, str2, i, str3);
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m667f(int i, int i2, Map map, int i4) {
        InterfaceC0313e interfaceC0313e = this.f808m;
        if (interfaceC0313e != null) {
            interfaceC0313e.onFinish(i, i2, map, i4);
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m668g(int i, int i2) {
        InterfaceC0313e interfaceC0313e = this.f808m;
        if (interfaceC0313e != null) {
            interfaceC0313e.onProgress(i, i2);
        }
    }

    /* JADX INFO: renamed from: h */
    public final List m669h() {
        ExecutorService executorService = this.f804i;
        if (executorService == null || executorService.isShutdown() || this.f804i.isTerminated()) {
            return null;
        }
        List<Runnable> listShutdownNow = this.f804i.shutdownNow();
        StringBuilder sb = new StringBuilder("terminate, remains count : ");
        sb.append(listShutdownNow == null ? 0 : listShutdownNow.size());
        AbstractC0299q.m643n(f795p, sb.toString());
        this.f804i = null;
        return listShutdownNow;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
    public final void onFail(String str, String str2, int i, String str3) {
        int i2 = this.f800e.get();
        int i4 = this.f801f.get();
        int iIncrementAndGet = this.f802g.incrementAndGet();
        this.f803h.put(str, Integer.valueOf(i));
        StringBuilder sbM1629s = AbstractC2322a.m1629s("onFail, errorCode : ", i, ", message : ", str3, ", mTotalTaskCount : ");
        sbM1629s.append(this.f799d.get());
        sbM1629s.append(", progressCount : ");
        sbM1629s.append(i2);
        sbM1629s.append(", endCount : ");
        sbM1629s.append(i4);
        sbM1629s.append(", errorCount : ");
        sbM1629s.append(iIncrementAndGet);
        AbstractC0299q.m643n(f795p, sbM1629s.toString());
        m666e(str, str2, i, str3);
        m663b(i4, iIncrementAndGet);
    }

    @Override // p084U0.InterfaceC0313e
    public final void onFinish(int i, int i2, Map map, int i4) throws Throwable {
        Iterator it;
        String str = "onFinish, mTotalTaskCount : " + this.f799d.get() + ", mProgressTaskCount : " + this.f800e.get() + ", successCount : " + i4 + ", errorCount : " + i2;
        String str2 = f795p;
        AbstractC0299q.m643n(str2, str);
        ArrayList arrayList = (ArrayList) AbstractC0144b.f399a.f254b;
        if (arrayList == null || arrayList.isEmpty()) {
            AbstractC0299q.m643n(str2, "importWidget. Empty WidgetList.");
        } else {
            AbstractC0299q.m643n(str2, "importWidget. WidgetList.size " + arrayList.size());
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Integer[] numArr = (Integer[]) it2.next();
                C0073a c0073a = AbstractC0144b.f399a;
                int iIntValue = numArr[0].intValue();
                c0073a.getClass();
                String strM196n = C0073a.m196n(iIntValue);
                if (strM196n != null) {
                    AbstractC0299q.m643n(str2, "sendPickWidgetBroadcast");
                    int iM198p = C0073a.m198p(numArr[0].intValue(), BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY);
                    int iM198p2 = C0073a.m198p(numArr[0].intValue(), BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR);
                    int iM198p3 = C0073a.m198p(numArr[0].intValue(), BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE);
                    boolean z = C0073a.m198p(numArr[0].intValue(), BaseWidgetConstant.KEY_WIDGET_MATCH_SETTING) == 1;
                    int iM198p4 = C0073a.m198p(numArr[0].intValue(), BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE);
                    boolean z2 = C0073a.m198p(numArr[0].intValue(), BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF) != 0;
                    it = it2;
                    StringBuilder sbM1173s = AbstractC0622a.m1173s(iM198p, iM198p2, "transparency : ", " , backgroundColor : ", " , darkMode : ");
                    sbM1173s.append(iM198p3);
                    sbM1173s.append(" , matchSetting : ");
                    sbM1173s.append(z);
                    sbM1173s.append(" , backgroundShape : ");
                    sbM1173s.append(iM198p4);
                    sbM1173s.append(" , backgroundOnOff : ");
                    sbM1173s.append(z2);
                    AbstractC0299q.m643n(str2, sbM1173s.toString());
                    if (this.f796a != null && WidgetAccessHandler.getWidgetAccessContract() != null) {
                        WidgetAccessHandler.getWidgetAccessContract().sendPickWidgetBroadcast(this.f796a, strM196n, numArr[1].intValue(), iM198p, iM198p2, iM198p3, z, iM198p4, z2);
                    }
                    arrayList2.add(numArr);
                } else {
                    it = it2;
                    AbstractC0299q.m643n(str2, "uuid == null");
                }
                it2 = it;
            }
            if (!arrayList2.isEmpty()) {
                Iterator it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    ((ArrayList) AbstractC0144b.f399a.f254b).remove((Integer[]) it3.next());
                }
            }
        }
        m667f(i, i2, map, i4);
        m669h();
    }

    @Override // p084U0.InterfaceC0313e
    public final void onProgress(int i, int i2) {
        int i4 = this.f800e.get();
        int i5 = this.f801f.get();
        int i6 = this.f802g.get();
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "onProgress, progress : ", ", total : ", ", mTotalTaskCount : ");
        sbM1173s.append(this.f799d.get());
        sbM1173s.append(", progressCount : ");
        sbM1173s.append(i4);
        sbM1173s.append(", endCount : ");
        sbM1173s.append(i5);
        sbM1173s.append(", errorCount : ");
        sbM1173s.append(i6);
        AbstractC0299q.m643n(f795p, sbM1173s.toString());
        m668g(i, i2);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
    public final void onStart(String str, String str2) {
        StringBuilder sbM15l = AbstractC0000a.m15l("onStart, uuid : ", str, ", mTotalTaskCount : ");
        AtomicInteger atomicInteger = this.f799d;
        sbM15l.append(atomicInteger.get());
        sbM15l.append(", mProgressTaskCount : ");
        AtomicInteger atomicInteger2 = this.f800e;
        sbM15l.append(atomicInteger2.get());
        sbM15l.append(", mSuccessTaskCount : ");
        sbM15l.append(this.f801f.get());
        AbstractC0299q.m643n(f795p, sbM15l.toString());
        InterfaceC0313e interfaceC0313e = this.f808m;
        if (interfaceC0313e != null) {
            interfaceC0313e.onStart(str, str2);
        }
        onProgress(atomicInteger2.incrementAndGet(), atomicInteger.get());
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
    public final void onSuccess(String str, String str2, String str3, Pair pair) throws Throwable {
        int i = this.f800e.get();
        int iIncrementAndGet = this.f801f.incrementAndGet();
        int i2 = this.f802g.get();
        String str4 = f795p;
        StringBuilder sbM15l = AbstractC0000a.m15l("onSuccess, destUuid : ", str2, ", mTotalTaskCount : ");
        sbM15l.append(this.f799d.get());
        sbM15l.append(", progressCount : ");
        sbM15l.append(i);
        sbM15l.append(", endCount : ");
        sbM15l.append(iIncrementAndGet);
        sbM15l.append(", errorCount : ");
        sbM15l.append(i2);
        AbstractC0299q.m643n(str4, sbM15l.toString());
        synchronized (this.f797b) {
            try {
                Iterator it = this.f797b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ImportDocument importDocument = (ImportDocument) it.next();
                    if (importDocument != null && str.equals(importDocument.getPath())) {
                        AbstractC0299q.m603M(f795p, "removeDocument, srcPath: " + Logger.getEncode(str));
                        this.f797b.remove(importDocument);
                    }
                }
            } finally {
            }
        }
        InterfaceC0313e interfaceC0313e = this.f808m;
        if (interfaceC0313e != null) {
            interfaceC0313e.onSuccess(str, str2, str3, pair);
        }
        m663b(iIncrementAndGet, i2);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
    public final void onUnsupportedVersionError(String str, String str2) {
        StringBuilder sbM15l = AbstractC0000a.m15l("onUnsupportedVersionError, uuid : ", str, ", path : ");
        sbM15l.append(Logger.getEncode(str2));
        AbstractC0299q.m643n(f795p, sbM15l.toString());
        InterfaceC0313e interfaceC0313e = this.f808m;
        if (interfaceC0313e != null) {
            interfaceC0313e.onUnsupportedVersionError(str, str2);
        }
    }
}
