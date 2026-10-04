package com.samsung.android.app.notes.sync.importing.core.types;

import android.content.Context;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.importing.core.tasks.MigrationImportBaseTask;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.SDocResolverContractImpl;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p042J1.AbstractC0147e;
import p042J1.AbstractC0155m;
import p042J1.C0148f;
import p086V.C0322h;
import p093X.C0338f;
import p234q1.C14433b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SSSDocSync extends MigrationImportBaseTask {
    private static final String TAG = "SS$SSSDocSync";

    public SSSDocSync(Context context, ImportBaseTask.Listener listener, int i, boolean z) {
        super(context, listener, DocTypeConstants.SS_SDOC, i, z);
    }

    private void clearTempFiles() {
        Debugger.m8607d(TAG, "clearTempFiles.");
        String str = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        String strM351d = C0148f.m351d();
        String strM387b = AbstractC0155m.m387b(C0148f.m351d(), "SmartSwitchRestoreDB");
        File file = new File(C0148f.f430u);
        try {
            FileUtils.deleteFile(new File(strM387b));
        } catch (IOException e) {
            AbstractC0000a.m20q(e, new StringBuilder("Failed to deleteFile Databases_Restore_PATH path "), TAG);
        }
        try {
            FileUtils.deleteFile(new File(strM351d));
        } catch (IOException e2) {
            AbstractC0000a.m20q(e2, new StringBuilder("Failed to deleteFile SDocBnR_PATH path "), TAG);
        }
        if (file.exists()) {
            try {
                FileUtils.deleteFile(file);
            } catch (IOException e3) {
                AbstractC0000a.m20q(e3, new StringBuilder("clearTempFiles"), TAG);
            }
        }
        unsetRunningFlag();
        AbstractC0147e.f419a.m366g();
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0409, code lost:
    
        r0 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0411, code lost:
    
        if (r0.hasNext() == false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0413, code lost:
    
        ((java.util.ArrayList) p042J1.AbstractC0144b.f399a.f254b).remove((java.lang.Integer[]) r0.next());
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0423, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x02d8, code lost:
    
        r0 = r3.size();
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x02dd, code lost:
    
        if (r14 >= r0) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x02e3, code lost:
    
        if (isCancelled() != false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x02e5, code lost:
    
        r4 = (com.samsung.android.app.notes.sync.items.ImportItem) r3.get(r14);
        r6.recoverySDoc(p086V.C0322h.m670a().f815a.getAppContext(), r4.getServerKey(), r4.getServerTimeStamp(), 0);
        sendProgressEntireRestore(((r14 * 9) / r0) + 91);
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x030c, code lost:
    
        r0 = (java.util.ArrayList) p042J1.AbstractC0144b.f399a.f254b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0312, code lost:
    
        if (r0 == null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0318, code lost:
    
        if (r0.isEmpty() != false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x031a, code lost:
    
        com.samsung.android.support.senl.p148nt.base.common.log.Debugger.m8607d(com.samsung.android.app.notes.sync.importing.core.types.SSSDocSync.TAG, "importItems WidgetList.size > 0");
        r3 = new java.util.ArrayList();
        r0 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x032c, code lost:
    
        if (r0.hasNext() == false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x032e, code lost:
    
        r4 = (java.lang.Integer[]) r0.next();
        r5 = p042J1.AbstractC0144b.f399a;
        r6 = r4[0].intValue();
        r5.getClass();
        r20 = p020E.C0073a.m196n(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0345, code lost:
    
        if (r20 == null) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0347, code lost:
    
        com.samsung.android.support.senl.p148nt.base.common.log.Debugger.m8607d(com.samsung.android.app.notes.sync.importing.core.types.SSSDocSync.TAG, "sendPickWidgetBroadcast");
        r5 = p020E.C0073a.m198p(r4[0].intValue(), com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY);
        r6 = p020E.C0073a.m198p(r4[0].intValue(), com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR);
        r7 = p020E.C0073a.m198p(r4[0].intValue(), com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0382, code lost:
    
        if (p020E.C0073a.m198p(r4[0].intValue(), com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant.KEY_WIDGET_MATCH_SETTING) != 1) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0384, code lost:
    
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0386, code lost:
    
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0388, code lost:
    
        r8 = p020E.C0073a.m198p(r4[0].intValue(), com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x03a2, code lost:
    
        if (p020E.C0073a.m198p(r4[0].intValue(), com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF) == 0) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x03a4, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x03a6, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x03a8, code lost:
    
        r10 = androidx.collection.AbstractC0622a.m1173s(r5, r6, "transparency : ", " , backgroundColor : ", " , darkMode : ");
        r10.append(r7);
        r10.append(" , matchSetting : ");
        r10.append(r14);
        r10.append(" , backgroundShape : ");
        r10.append(r8);
        r10.append(" , backgroundOnOff : ");
        r10.append(r9);
        com.samsung.android.support.senl.p148nt.base.common.log.Debugger.m8607d(com.samsung.android.app.notes.sync.importing.core.types.SSSDocSync.TAG, r10.toString());
        com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler.getWidgetAccessContract().sendPickWidgetBroadcast(r28.mContext, r20, r4[1].intValue(), r5, r6, r7, r14, r8, r9);
        r3.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x03f9, code lost:
    
        com.samsung.android.support.senl.p148nt.base.common.log.Debugger.m8607d(com.samsung.android.app.notes.sync.importing.core.types.SSSDocSync.TAG, "uuid == null");
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0407, code lost:
    
        if (r3.isEmpty() != false) goto L129;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02bf  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void importItems() throws Throwable {
        String strM387b;
        FileInputStream fileInputStream;
        Debugger.m8607d(TAG, "importItems.");
        sendProgressEntireRestore(44);
        ArrayList arrayList = new ArrayList();
        String noteFilePath = WDocUtils.getNoteFilePath(C0322h.m670a().f815a.getAppContext(), false);
        SDocResolverContractImpl sDocResolverContractImpl = C0322h.m670a().f831q;
        if (this.mSuccessfulList == null) {
            this.mSuccessfulList = new ArrayList();
        }
        int size = this.mImportList.size();
        int i = 0;
        while (true) {
            if (i >= size || isCancelled()) {
                break;
            }
            StringBuilder sb = new StringBuilder("Import : ");
            int i2 = i + 1;
            sb.append(i2);
            sb.append(" / ");
            sb.append(size);
            Debugger.m8607d(TAG, sb.toString());
            if (!AbstractC0155m.m401p()) {
                Debugger.m8609e(TAG, "Not enough free space");
                break;
            }
            ImportItem importItem = this.mImportList.get(i);
            ImportBaseTask.Listener listener = this.mListener;
            if (listener != null) {
                DocTypeConstants docTypeConstants = DocTypeConstants.SS_SDOC;
                listener.onDownloaded(docTypeConstants, importItem, this.mSuccessfulList.size());
                this.mListener.onItemImportFinished(docTypeConstants, i2, this.mSuccessfulList.size(), size);
            }
            String serverKey = importItem.getServerKey();
            String categoryUUID = importItem.getCategoryUUID();
            if (!"1".equals(categoryUUID) && !"2".equals(categoryUUID)) {
                String strM387b2 = AbstractC0155m.m387b(noteFilePath, Constants.SMART_SWITCH_RESTORE_DIR_NAME);
                Debugger.m8607d("SyncUtils", "getNewCategoryUUIDInfo. old one : " + categoryUUID);
                if (C0322h.m670a().f815a.getAppContext().getFilesDir().getParentFile() == null) {
                    categoryUUID = null;
                    if (categoryUUID == null) {
                        categoryUUID = "1";
                    }
                } else {
                    try {
                        fileInputStream = new FileInputStream(AbstractC0155m.m387b(strM387b2, categoryUUID) + ".category");
                    } catch (IOException e) {
                        Debugger.m8607d("SyncUtils", "IOException - " + e.getMessage());
                    }
                    try {
                        try {
                            JSONObject jSONObjectM394i = AbstractC0155m.m394i(fileInputStream);
                            JSONArray jSONArray = jSONObjectM394i != null ? jSONObjectM394i.getJSONArray("file_info") : null;
                            JSONObject jSONObject = jSONArray != null ? jSONArray.getJSONObject(0) : null;
                            categoryUUID = jSONObject != null ? jSONObject.getString("uuid") : null;
                            fileInputStream.close();
                        } catch (Throwable th) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        Debugger.m8607d("SyncUtils", "Failed to Migration.getNewCategoryUUIDInfo() - " + e.getMessage());
                        fileInputStream.close();
                        categoryUUID = null;
                    } catch (JSONException e3) {
                        e = e3;
                        Debugger.m8607d("SyncUtils", "Failed to Migration.getNewCategoryUUIDInfo() - " + e.getMessage());
                        fileInputStream.close();
                        categoryUUID = null;
                    }
                    if (categoryUUID == null) {
                    }
                }
            }
            if (importItem.getChangeUUIDFlag()) {
                strM387b = AbstractC0155m.m387b(noteFilePath, System.currentTimeMillis() + ".sdoc");
            } else {
                strM387b = AbstractC0155m.m387b(noteFilePath, importItem.getTitle());
            }
            if (importItem.getNeedToCopySDocFlag()) {
                try {
                    FileUtils.copyFile(new File(AbstractC0155m.m387b(importItem.getLocalFullPath(), importItem.getTitle())), new File(strM387b));
                    if (!new File(AbstractC0155m.m387b(importItem.getLocalFullPath(), importItem.getTitle())).delete()) {
                        Debugger.m8609e(TAG, "delete fail");
                    }
                    Debugger.m8607d(TAG, "importItems saveMemo: " + importItem.getSaveNew() + " , LockState : " + importItem.getLockState());
                    C14433b c14433b = new C14433b(5);
                    ((C0338f) c14433b.f10228b).f856a.setFilePath(strM387b);
                    ((C0338f) c14433b.f10228b).f856a.setUuid(serverKey);
                    ((C0338f) c14433b.f10228b).f857b = importItem.getSaveNew();
                    ((C0338f) c14433b.f10228b).f856a.setIsDeleted(sDocResolverContractImpl.getSdocContractNo());
                    ((C0338f) c14433b.f10228b).f856a.setIsFavorite(importItem.getFavorite() ? 1 : 0);
                    ((C0338f) c14433b.f10228b).f856a.setIsLock(importItem.getLockState());
                    ((C0338f) c14433b.f10228b).f856a.setCategoryUuid(categoryUUID);
                    ((C0338f) c14433b.f10228b).f856a.setCategoryServerTimeStamp(Long.valueOf(importItem.getCategoryServerTimeStamp()));
                    c14433b.m15042t(importItem.getServerTimeStamp());
                    ((C0338f) c14433b.f10228b).f856a.setUpdateStrokeSearchData(false);
                    ((C0338f) c14433b.f10228b).f856a.setLastModifiedAt(importItem.getSaveTime());
                    ((C0338f) c14433b.f10228b).f856a.setCreatedAt(importItem.getCreatedTime());
                    ((C0338f) c14433b.f10228b).f856a.setImported(true);
                    Debugger.m8607d(TAG, "SaveNoteResolverProxyContract try to save " + strM387b);
                    C0322h.m670a().f832r.saveDoc(C0322h.m670a().f815a.getAppContext(), c14433b.m15035i());
                    Debugger.m8607d(TAG, "SaveNoteResolverProxyContract saves complete");
                    if (importItem.getSaveRecovery()) {
                        arrayList.add(importItem);
                    }
                    Debugger.m8607d(TAG, "Send Progress Restore");
                    sendProgressEntireRestore(((i * 39) / size) + 51);
                    this.mSuccessfulList.add(importItem);
                } catch (IOException e5) {
                    AbstractC0000a.m20q(e5, new StringBuilder("copy fail "), TAG);
                }
            } else {
                Debugger.m8607d(TAG, "importItems saveMemo: " + importItem.getSaveNew() + " , LockState : " + importItem.getLockState());
                C14433b c14433b2 = new C14433b(5);
                ((C0338f) c14433b2.f10228b).f856a.setFilePath(strM387b);
                ((C0338f) c14433b2.f10228b).f856a.setUuid(serverKey);
                ((C0338f) c14433b2.f10228b).f857b = importItem.getSaveNew();
                ((C0338f) c14433b2.f10228b).f856a.setIsDeleted(sDocResolverContractImpl.getSdocContractNo());
                ((C0338f) c14433b2.f10228b).f856a.setIsFavorite(importItem.getFavorite() ? 1 : 0);
                ((C0338f) c14433b2.f10228b).f856a.setIsLock(importItem.getLockState());
                ((C0338f) c14433b2.f10228b).f856a.setCategoryUuid(categoryUUID);
                ((C0338f) c14433b2.f10228b).f856a.setCategoryServerTimeStamp(Long.valueOf(importItem.getCategoryServerTimeStamp()));
                c14433b2.m15042t(importItem.getServerTimeStamp());
                ((C0338f) c14433b2.f10228b).f856a.setUpdateStrokeSearchData(false);
                ((C0338f) c14433b2.f10228b).f856a.setLastModifiedAt(importItem.getSaveTime());
                ((C0338f) c14433b2.f10228b).f856a.setCreatedAt(importItem.getCreatedTime());
                ((C0338f) c14433b2.f10228b).f856a.setImported(true);
                Debugger.m8607d(TAG, "SaveNoteResolverProxyContract try to save " + strM387b);
                C0322h.m670a().f832r.saveDoc(C0322h.m670a().f815a.getAppContext(), c14433b2.m15035i());
                Debugger.m8607d(TAG, "SaveNoteResolverProxyContract saves complete");
                if (importItem.getSaveRecovery()) {
                }
                Debugger.m8607d(TAG, "Send Progress Restore");
                sendProgressEntireRestore(((i * 39) / size) + 51);
                this.mSuccessfulList.add(importItem);
            }
            i = i2;
        }
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public void getImportItems() {
        if (this.mListener != null) {
            int size = this.mImportList.size();
            int i = 0;
            while (i < size) {
                ImportItem importItem = this.mImportList.get(i);
                i++;
                this.mListener.onUpdated(DocTypeConstants.SS_SDOC, i, size, importItem);
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.MigrationImportBaseTask
    public void setRunningFlag() {
        String str = C0148f.f420k;
        AbstractC0147e.f419a.f434d = true;
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public void startImport() throws Throwable {
        importItems();
        clearTempFiles();
        sendProgressEntireRestore(100);
        sendResponseEntireRestore(0, 0);
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public int syncProgress() {
        return 0;
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.MigrationImportBaseTask
    public void unsetRunningFlag() {
        String str = C0148f.f420k;
        AbstractC0147e.f419a.f434d = false;
    }

    public SSSDocSync(Context context, ImportBaseTask.Listener listener, int i, List<ImportItem> list, boolean z) {
        super(context, listener, DocTypeConstants.SS_SDOC, i, z);
        this.mImportList = list;
    }
}
