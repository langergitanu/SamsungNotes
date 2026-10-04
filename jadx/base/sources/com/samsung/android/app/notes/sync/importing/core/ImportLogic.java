package com.samsung.android.app.notes.sync.importing.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.util.SparseBooleanArray;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.importing.core.types.AbstractImportType;
import com.samsung.android.app.notes.sync.importing.services.C6777a;
import com.samsung.android.app.notes.sync.importing.services.ImportService;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCardListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;
import p038I1.C0136l;
import p038I1.C0137m;
import p042J1.AbstractC0155m;
import p042J1.C0145c;
import p086V.C0322h;
import p207n1.C13540g;
import p207n1.C13541h;
import p238s0.C14462a;
import p254x0.InterfaceC14511a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ImportLogic {
    public static final int DELAYED_IMPORT_MESSAGE = 500;
    private static final int MESSAGE_IMPORT_NOW = 102;
    private static final String TAG = "ImportLogic";
    public static final boolean mEnableTipCard = true;
    public static int mStartServiceCount;
    public static long mStartTime;
    private ImportHandler mImportHandler;
    private ImportHandler.SelfBindContract mSelfBind;
    private ImportBaseTask.Listener mImportListener = new ImportBaseTask.Listener() { // from class: com.samsung.android.app.notes.sync.importing.core.ImportLogic.1
        @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
        public void onDownloaded(DocTypeConstants docTypeConstants, ImportItem importItem, int i) {
            synchronized (this) {
                int successfulListSize = ImportLogic.this.mImportHelperRegistry.getSuccessfulListSize() + 1;
                synchronized (ImportLogic.this.mImportCount) {
                    try {
                        Debugger.m8607d(ImportLogic.TAG, "TipCard onUpdate(IMPORT)");
                        C0136l c0136l = (C0136l) C0137m.m279c(1, ImportLogic.this.mImportTipCardController.f391a);
                        if (c0136l != null) {
                            c0136l.setProgressInfo(ImportLogic.this.mImportCount.mTotal, ImportLogic.this.mImportCount.mDownloaded + successfulListSize, 0);
                            c0136l.setState(i);
                            ImportLogic.this.mImportTipCardController.getClass();
                            for (TipCardListener tipCardListener : C0137m.f389c) {
                                Debugger.m8607d("TipCardManager", "TipCard onUpdate()");
                                tipCardListener.onUpdate(c0136l);
                            }
                            StringBuilder sb = new StringBuilder("Import ");
                            sb.append(Integer.toString(ImportLogic.this.mImportCount.mDownloaded + successfulListSize));
                            sb.append(" / ");
                            sb.append(Integer.toString(ImportLogic.this.mImportCount.mTotal));
                            sb.append(" : ");
                            sb.append(i == 3 ? " Downloading..." : " Converting...");
                            Debugger.m8607d(ImportLogic.TAG, sb.toString());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
        public void onGetListEnded(DocTypeConstants docTypeConstants) {
            Debugger.m8607d(ImportLogic.TAG, "mImportListener : onGetListEnded()");
            ImportLogic.this.onEnded(docTypeConstants, 2);
        }

        @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
        public void onImportEnded(DocTypeConstants docTypeConstants) {
            Debugger.m8607d(ImportLogic.TAG, "mImportListener : onImportEnded() without item");
            ImportLogic.this.onEnded(docTypeConstants, 3);
        }

        @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
        public void onImportError(DocTypeConstants docTypeConstants, int i, String str, Exception exc) {
            Debugger.m8607d(ImportLogic.TAG, "mImportListener : onError()");
            ImportLogic.this.onFailed(docTypeConstants, i, str);
            if (docTypeConstants == DocTypeConstants.SNOTE_GOOGLEDRIVE && i == 901) {
                synchronized (ImportLogic.this.mImportListeners) {
                    try {
                        if (!ImportLogic.this.mImportListeners.isEmpty()) {
                            Iterator it = ImportLogic.this.mImportListeners.iterator();
                            while (it.hasNext()) {
                                C6777a c6777a = (C6777a) ((InterfaceC14511a) it.next());
                                c6777a.getClass();
                                Debugger.m8607d("ImportService", "mImportListener - onFailed");
                                c6777a.f4163a.stopSelf();
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
        public void onImportStart(DocTypeConstants docTypeConstants) {
        }

        @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
        public void onItemImportFinished(DocTypeConstants docTypeConstants, int i, int i2, int i4) {
        }

        @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
        public void onUpdated(DocTypeConstants docTypeConstants, int i, int i2, ImportItem importItem) {
            Debugger.m8607d(ImportLogic.TAG, "mImportListener : onUpdated()");
            synchronized (ImportLogic.this.mImportListeners) {
                try {
                    C0136l c0136l = (C0136l) C0137m.m279c(1, ImportLogic.this.mImportTipCardController.f391a);
                    if (c0136l != null) {
                        c0136l.setProgressInfo(i2, i, 0);
                    }
                    if (!ImportLogic.this.mImportListeners.isEmpty()) {
                        Iterator it = ImportLogic.this.mImportListeners.iterator();
                        while (it.hasNext()) {
                            ((InterfaceC14511a) it.next()).getClass();
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("onUpdated - ");
                    sb.append(docTypeConstants);
                    sb.append(Integer.toString(i));
                    sb.append("/");
                    sb.append(Integer.toString(i2));
                    sb.append(" ");
                    sb.append(importItem != null ? importItem.getLocalFullPath() : "");
                    Debugger.m8616s(ImportLogic.TAG, sb.toString());
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
        public void onImportEnded(DocTypeConstants docTypeConstants, List<ImportItem> list) {
            Debugger.m8607d(ImportLogic.TAG, "mImportListener : onImportEnded()");
            synchronized (ImportLogic.this.mImportCount) {
                ImportLogic.this.mImportCount.mDownloaded += list.size();
            }
            ImportLogic.this.onEnded(docTypeConstants, 3);
        }
    };
    private HelperRegistry mImportHelperRegistry = new HelperRegistry();
    private ArrayList<InterfaceC14511a> mImportListeners = new ArrayList<>();
    private boolean mImporting = false;
    private ArrayList<ImportData> mImportDataList = new ArrayList<>();
    private final ImportCount mImportCount = new ImportCount();
    private C0137m mImportTipCardController = C0137m.m280d();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ImportCount {
        int mTotal = 0;
        int mDownloaded = 0;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ImportHandler {
        private Handler mHandler;
        private final SelfBindContract mSelfBind;
        private SparseBooleanArray mMessageQueue = new SparseBooleanArray();
        private ServiceConnection mConnection = new ServiceConnection() { // from class: com.samsung.android.app.notes.sync.importing.core.ImportLogic.ImportHandler.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Debugger.m8607d(ImportLogic.TAG, "SelfBind connected");
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Debugger.m8607d(ImportLogic.TAG, "SelfBind disconnected");
            }
        };
        private Context mAppContext = C0322h.m670a().f815a.getAppContext();

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class InternalHandler extends Handler {
            private WeakReference<ImportLogic> mImportLogic;
            private WeakReference<ImportHandler> mParentHandler;

            public InternalHandler(ImportLogic importLogic, ImportHandler importHandler) {
                this.mImportLogic = new WeakReference<>(importLogic);
                this.mParentHandler = new WeakReference<>(importHandler);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ImportLogic importLogic = this.mImportLogic.get();
                final int i = message.what;
                postDelayed(new Runnable() { // from class: com.samsung.android.app.notes.sync.importing.core.ImportLogic.ImportHandler.InternalHandler.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ImportHandler importHandler = (ImportHandler) InternalHandler.this.mParentHandler.get();
                        if (importHandler != null) {
                            importHandler.selfUnbind(i);
                        }
                    }
                }, 500L);
                if (importLogic != null) {
                    importLogic.handleImportMessage(message);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public interface SelfBindContract {
            void selfBind(ServiceConnection serviceConnection);
        }

        public ImportHandler(ImportLogic importLogic, SelfBindContract selfBindContract) {
            this.mSelfBind = selfBindContract;
            this.mHandler = new InternalHandler(importLogic, this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeMessages(int i) {
            if (this.mMessageQueue.get(i)) {
                selfUnbind(i);
                this.mMessageQueue.delete(i);
                this.mHandler.removeMessages(i);
            }
        }

        private synchronized void selfBind(int i) {
            try {
                if (this.mMessageQueue.size() == 0) {
                    Debugger.m8615i(ImportLogic.TAG, "selfBind() call bindService()");
                    SelfBindContract selfBindContract = this.mSelfBind;
                    if (selfBindContract != null) {
                        selfBindContract.selfBind(this.mConnection);
                    }
                }
                this.mMessageQueue.put(i, true);
                Debugger.m8607d(ImportLogic.TAG, "selfBind() count:" + this.mMessageQueue.size() + " what:" + i);
            } catch (Throwable th) {
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void selfUnbind(int i) {
            this.mMessageQueue.delete(i);
            if (this.mMessageQueue.size() == 0) {
                try {
                    Debugger.m8615i(ImportLogic.TAG, "selfUnbind() call unbindService()");
                    this.mAppContext.unbindService(this.mConnection);
                } catch (IllegalArgumentException e) {
                    Debugger.m8610e(ImportLogic.TAG, "selfUnbind() unbindService", e);
                }
                Debugger.m8607d(ImportLogic.TAG, "selfUnbind() count:" + this.mMessageQueue.size() + " what:" + i);
            } else {
                Debugger.m8607d(ImportLogic.TAG, "selfUnbind() count:" + this.mMessageQueue.size() + " what:" + i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendEmptyMessage(int i) {
            this.mHandler.sendEmptyMessage(i);
            selfBind(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendEmptyMessageDelayed(int i, long j) {
            this.mHandler.sendEmptyMessageDelayed(i, j);
            selfBind(i);
        }
    }

    private void addImportData(ImportHelper importHelper, List<ImportItem> list) {
        Debugger.m8615i(TAG, "addImportData()");
        synchronized (this.mImportDataList) {
            this.mImportDataList.add(new ImportData(importHelper, list));
        }
        if (C0137m.m279c(1, this.mImportTipCardController.f391a) != null) {
            requestImportNow();
            return;
        }
        ImportHandler importHandler = this.mImportHandler;
        if (importHandler == null) {
            Debugger.m8615i(TAG, "call addImportData() mImportHandler is null");
        } else {
            importHandler.removeMessages(102);
            this.mImportHandler.sendEmptyMessageDelayed(102, 500L);
        }
    }

    private static void addStartServiceCount() {
        mStartServiceCount++;
    }

    private synchronized boolean checkAllImportTaskStoped() {
        Debugger.m8607d(TAG, "checkAllTaskStoped()");
        return this.mImportHelperRegistry.isAllHelperStopped();
    }

    private void checkAllImportingEnded() {
        checkAllImportingEnded(false);
    }

    private void checkNeedToImport() {
        Debugger.m8607d(TAG, "checkNeedToImport()");
        if (isImportingPaused() > 0 && C0145c.m336u(getApplicationContext()) && !C0145c.m296D(getApplicationContext())) {
            C0322h.m670a().f822h.show(getApplicationContext(), 3);
        }
        if (isImporting()) {
            return;
        }
        if (C0145c.m298F(getApplicationContext()) || C0145c.m296D(getApplicationContext())) {
            reTryImporting();
        }
    }

    private Context getApplicationContext() {
        return C0322h.m670a().f815a.getAppContext();
    }

    private static int getStartServiceCount() {
        return mStartServiceCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleImportMessage(Message message) {
        if (message.what != 102) {
            return;
        }
        startImport();
    }

    private void initImportHelper(Context context) {
        ImportHelperManager.getInstance().initImportHelper(context, this.mImportHelperRegistry);
        this.mImportHelperRegistry.setSyncListener(this.mImportListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEnded(DocTypeConstants docTypeConstants, int i) {
        checkAllImportingEnded();
        Debugger.m8607d(TAG, "onEnded - " + docTypeConstants + Long.toString(System.currentTimeMillis() - mStartTime) + "ms");
        if (i == 2) {
            synchronized (this.mImportListeners) {
                try {
                    Iterator<InterfaceC14511a> it = this.mImportListeners.iterator();
                    while (it.hasNext()) {
                        C6777a c6777a = (C6777a) it.next();
                        c6777a.getClass();
                        Debugger.m8607d("ImportService", "mImportListener - onEnded");
                        c6777a.f4163a.stopSelf();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFailed(DocTypeConstants docTypeConstants, int i, String str) {
        C14462a c14462a;
        C14462a c14462a2;
        Debugger.m8609e(TAG, "onFailed[" + docTypeConstants + "] errorCode(" + i + "), " + Long.toString(System.currentTimeMillis() - mStartTime) + "ms " + str);
        synchronized (this.mImportListeners) {
            try {
                Iterator<InterfaceC14511a> it = this.mImportListeners.iterator();
                while (it.hasNext()) {
                    C6777a c6777a = (C6777a) it.next();
                    c6777a.getClass();
                    Debugger.m8607d("ImportService", "mImportListener - onFailed");
                    c6777a.f4163a.stopSelf();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        checkAllImportingEnded();
        if (docTypeConstants != DocTypeConstants.SDOCX) {
            this.mImporting = false;
        }
        if (i == 101) {
            c14462a = new C14462a(1);
            c14462a.f10250c = docTypeConstants;
        } else if (i == 104) {
            c14462a = new C14462a(0);
            c14462a.f10250c = docTypeConstants;
        } else {
            if (i != 106 && i != 108 && i != 201) {
                Debugger.m8609e("SyncErrorManager", "No matched import error : " + i);
                c14462a2 = null;
                if (c14462a2 == null) {
                    c14462a2.mo4791d();
                    return;
                }
                return;
            }
            c14462a = new C14462a(2);
            c14462a.f10250c = docTypeConstants;
        }
        c14462a2 = c14462a;
        if (c14462a2 == null) {
        }
    }

    private void onPreStartedImporting(int i, boolean z) {
        Debugger.m8607d(TAG, "onPreStartedImporting()");
        this.mImporting = true;
        synchronized (this.mImportCount) {
            try {
                C0136l c0136l = (C0136l) C0137m.m279c(1, this.mImportTipCardController.f391a);
                if (c0136l == null) {
                    C0136l c0136l2 = new C0136l();
                    c0136l2.setProgressInfo(i, 0, 0);
                    ImportCount importCount = this.mImportCount;
                    importCount.mTotal = i;
                    importCount.mDownloaded = 0;
                    Debugger.m8607d(TAG, "# Importing Tipcard created. # - " + Integer.toString(this.mImportCount.mTotal) + "/" + Integer.toString(i));
                    if (this.mImportTipCardController.m288i(c0136l2)) {
                        Debugger.m8607d(TAG, "# Importing Tipcard created. # - " + Integer.toString(this.mImportCount.mDownloaded) + "/" + Integer.toString(i));
                    }
                } else {
                    Debugger.m8607d(TAG, "# Importing Tipcard update. 1 # - " + Integer.toString(this.mImportCount.mTotal) + "/" + Integer.toString(i));
                    if (!z) {
                        Debugger.m8607d(TAG, "# Importing Tipcard update. 2 # - " + Integer.toString(this.mImportCount.mTotal) + "/" + Integer.toString(i));
                        ImportCount importCount2 = this.mImportCount;
                        importCount2.mTotal = importCount2.mTotal + i;
                    }
                    Debugger.m8607d(TAG, "# Importing Tipcard update. 3 # - " + Integer.toString(this.mImportCount.mTotal) + "/" + Integer.toString(i));
                    c0136l.setTotal(this.mImportCount.mTotal);
                    this.mImportTipCardController.getClass();
                    for (TipCardListener tipCardListener : C0137m.f389c) {
                        Debugger.m8607d("TipCardManager", "TipCard onUpdate()");
                        tipCardListener.onUpdate(c0136l);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void onStartedImporting() {
        Debugger.m8607d(TAG, "onStartedImporting()");
        C0322h.m670a().f818d.cancelAllImportNotification();
        removeTipcardsBeforeImporting();
    }

    private void removeTipcardsBeforeImporting() {
        C0137m c0137m = this.mImportTipCardController;
        Debugger.m8607d("TipCardManager", "clearImportTipCardList() : " + c0137m.f391a.size());
        ArrayList arrayList = new ArrayList();
        synchronized (c0137m.f391a) {
            try {
                for (TipCard tipCard : c0137m.f391a) {
                    if (tipCard.getType() == 4 || tipCard.getType() == 2) {
                        ArrayList<TipCardListener> arrayList2 = C0137m.f389c;
                        synchronized (arrayList2) {
                            try {
                                for (TipCardListener tipCardListener : arrayList2) {
                                    Debugger.m8607d("TipCardManager", "Remove Tipcard for Listener : " + C0137m.m282j(tipCard.getType()));
                                    tipCardListener.onEnd(tipCard);
                                }
                            } finally {
                            }
                        }
                        arrayList.add(tipCard);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c0137m.m286g(((TipCard) it.next()).getType());
        }
    }

    private void requestDownloadLists(AbsImportHelper absImportHelper, List<ImportItem> list, boolean z) {
        mStartTime = System.currentTimeMillis();
        if (z && !C0145c.m334s(getApplicationContext())) {
            onFailed(absImportHelper.getTaskType(), 101, "Network is unable.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(absImportHelper.getTaskType());
        sb.append("start to download : ");
        sb.append(Integer.toString(list == null ? 0 : list.size()));
        Debugger.m8607d(TAG, sb.toString());
        if (list == null || list.isEmpty()) {
            Debugger.m8607d(TAG, "requestDownloadLists onImportEnded()");
            onEnded(absImportHelper.getTaskType(), 3);
        } else {
            onPreStartedImporting(list.size(), false);
            onStartedImporting();
            absImportHelper.requestDownloadLists(ImportHelperManager.getInstance().getImportExecutor(), list, false);
        }
    }

    private void requestImportNow() {
        ImportHandler importHandler = this.mImportHandler;
        if (importHandler != null) {
            importHandler.removeMessages(102);
            this.mImportHandler.sendEmptyMessage(102);
        } else {
            Debugger.m8615i(TAG, "call requestImportNow() mImportHandler is null");
        }
        Debugger.m8615i(TAG, "call requestImportNow()");
    }

    private void startImport() {
        Debugger.m8607d(TAG, "start import - " + Integer.toString(this.mImportDataList.size()));
        synchronized (this.mImportDataList) {
            try {
                for (ImportData importData : this.mImportDataList) {
                    ImportHelper importHelper = importData.helper;
                    DocTypeConstants docTypeConstants = importHelper.mType;
                    requestDownloadLists(importHelper, importData.downloadList, docTypeConstants == DocTypeConstants.MEMO_SCLOUD || docTypeConstants == DocTypeConstants.SNOTE_SCLOUD || docTypeConstants == DocTypeConstants.SNOTE_GOOGLEDRIVE || docTypeConstants == DocTypeConstants.SCRAPBOOK_SCLOUD);
                }
                this.mImportDataList.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addImportListener(InterfaceC14511a interfaceC14511a) {
        synchronized (this.mImportListeners) {
            try {
                Iterator<InterfaceC14511a> it = this.mImportListeners.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(interfaceC14511a)) {
                        return;
                    }
                }
                this.mImportListeners.add(interfaceC14511a);
                Debugger.m8607d(TAG, "Added sync listener - size : " + this.mImportListeners.size());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void initImportLogic() {
        Debugger.m8615i(TAG, "onCreate() : v." + AbstractC0155m.m399n(getApplicationContext()));
        addStartServiceCount();
        Debugger.m8607d(TAG, "mStartServiceCount = " + getStartServiceCount());
        Context appContext = C0322h.m670a().f815a.getAppContext();
        this.mImportHandler = new ImportHandler(this, this.mSelfBind);
        initImportHelper(appContext);
        this.mImporting = false;
        C0145c.m301I(appContext);
        Debugger.m8607d(TAG, "onCreate() finishes");
    }

    public boolean isImporting() {
        Debugger.m8615i(TAG, "isImporting : " + this.mImporting);
        return this.mImporting;
    }

    public int isImportingPaused() {
        Debugger.m8615i(TAG, "isImportingPaused()");
        if (((C13540g) C13541h.m14287e().f9588a).m14285a()) {
            return this.mImportHelperRegistry.getDownloadListSize();
        }
        Debugger.m8615i(TAG, "isImportingPaused() : not loginned!");
        return 0;
    }

    public void onNetworkConnected(boolean z, boolean z2) {
        Debugger.m8615i(TAG, "Network : onNetworkConnected() : " + z);
        if (!z) {
            NetworkStatusManager.setNetworkConnected(false);
            return;
        }
        Context applicationContext = getApplicationContext();
        if (z == NetworkStatusManager.isNetworkConnected() && z2 == NetworkStatusManager.isWiFiConnected()) {
            Debugger.m8615i(TAG, "onNetworkConnected() : not changed!");
            return;
        }
        NetworkStatusManager.setNetworkConnected(z);
        NetworkStatusManager.setWiFiConnected(z2);
        if (z2) {
            C0322h.m670a().f815a.reConnectedToWAN(applicationContext);
        } else {
            C0322h.m670a().f815a.reConnectedToMobile(applicationContext);
        }
        try {
            checkNeedToImport();
        } catch (Exception e) {
            Debugger.m8609e(TAG, e.toString());
        }
    }

    public void onNetworkConnectionFailedDialogFinish(int i, int i2) {
        boolean z = true;
        if (i != 0 && i != 1) {
            if (i == 3 || i == 2) {
                C0145c.m313U(getApplicationContext(), Boolean.TRUE);
            } else {
                z = false;
            }
        }
        AbstractC4539a.m3215y("Network is re-enabled isReEnabled:", TAG, z);
        if (z) {
            if (i2 == 3 || i2 == 2) {
                reTryImporting();
            }
        }
    }

    public void reTryImporting() {
        int localDownloadListSize;
        Debugger.m8615i(TAG, "reTryImporting()");
        if (((C13540g) C13541h.m14287e().f9588a).m14285a()) {
            Debugger.m8615i(TAG, "reTryImporting() : loginned!");
            localDownloadListSize = this.mImportHelperRegistry.getDownloadListSize();
        } else {
            Debugger.m8615i(TAG, "reTryImporting() : not loginned!");
            localDownloadListSize = this.mImportHelperRegistry.getLocalDownloadListSize();
        }
        AbstractC0000a.m0A(localDownloadListSize, "reTryImporting() : size = ", TAG);
        if (localDownloadListSize <= 0) {
            removeTipcardsBeforeImporting();
            return;
        }
        onPreStartedImporting(localDownloadListSize, true);
        onStartedImporting();
        this.mImportHelperRegistry.requestRetry(ImportHelperManager.getInstance().getImportExecutor());
    }

    public void removeImportListener(InterfaceC14511a interfaceC14511a) {
        synchronized (this.mImportListeners) {
            this.mImportListeners.remove(interfaceC14511a);
            Debugger.m8607d(TAG, "Removed sync listener - size : " + this.mImportListeners.size());
        }
    }

    public void setSelfBind(ImportHandler.SelfBindContract selfBindContract) {
        this.mSelfBind = selfBindContract;
    }

    public void startImportByType(AbstractImportType abstractImportType) {
        if (this.mImportHelperRegistry.getImportHelperByClass(abstractImportType.getClass()) != null) {
            ImportHelper importHelperByType = this.mImportHelperRegistry.getImportHelperByType(abstractImportType);
            this.mImportHelperRegistry.getImportHelperByClass(abstractImportType.getClass()).configureImportHelper(abstractImportType);
            addImportData(importHelperByType, abstractImportType.getImportItems());
        }
    }

    public void stopImportInternal() {
        Debugger.m8615i(TAG, "stop import internal");
        Debugger.m8615i(TAG, Log.getStackTraceString(new Exception()));
        this.mImportHelperRegistry.stop();
    }

    private void checkAllImportingEnded(boolean z) {
        boolean zCheckAllImportTaskStoped = checkAllImportTaskStoped();
        Debugger.m8607d(TAG, "checkAllImportingEnded() : mImporting = " + this.mImporting + " ignoreCheckImporting : " + z);
        if ((this.mImporting || z) && zCheckAllImportTaskStoped) {
            C0136l c0136l = new C0136l();
            this.mImportTipCardController.getClass();
            for (TipCardListener tipCardListener : C0137m.f389c) {
                Debugger.m8607d("TipCardManager", "TipCard onEnd(IMPORT)");
                tipCardListener.onEnd(c0136l);
            }
            this.mImportTipCardController.m286g(c0136l.getType());
            int i = 0;
            this.mImporting = false;
            C0145c.m313U(getApplicationContext(), Boolean.FALSE);
            synchronized (this.mImportListeners) {
                try {
                    ArrayList arrayList = this.mImportTipCardController.f391a;
                    int size = arrayList.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                        if (1 == ((TipCard) arrayList.get(i)).getType()) {
                            arrayList.remove(i);
                            break;
                        }
                        i++;
                    }
                    Iterator<InterfaceC14511a> it = this.mImportListeners.iterator();
                    while (it.hasNext()) {
                        C6777a c6777a = (C6777a) it.next();
                        c6777a.getClass();
                        Debugger.m8607d("ImportService", "mImportListener - onDownloadFinished");
                        ImportService importService = c6777a.f4163a;
                        importService.unbind();
                        importService.stopSelf();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
