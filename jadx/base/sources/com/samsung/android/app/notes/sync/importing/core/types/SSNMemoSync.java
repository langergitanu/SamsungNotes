package com.samsung.android.app.notes.sync.importing.core.types;

import android.content.Context;
import androidx.collection.AbstractC0622a;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.importing.core.tasks.MigrationImportBaseTask;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p020E.C0073a;
import p042J1.AbstractC0144b;
import p042J1.AbstractC0147e;
import p042J1.AbstractC0155m;
import p042J1.C0148f;
import p086V.C0322h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SSNMemoSync extends MigrationImportBaseTask {
    private static final String NMEMO_ATTACHED_FOLDER = "SDocData/NMEMO/app_attach";
    private static final String NMEMO_DB_NAME = "memo.db";
    private static final String TAG = "SS$SSNMemoSync";
    private boolean mNeedToClear;

    public SSNMemoSync(Context context, ImportBaseTask.Listener listener, int i, boolean z) {
        super(context, listener, DocTypeConstants.SS_NMEMO, i, z);
        this.mNeedToClear = true;
    }

    private void clearTempFiles() {
        Debugger.m8607d(TAG, "clearTempFiles.");
        if (!this.mNeedToClear) {
            Debugger.m8607d(TAG, "Skip delete files.");
            return;
        }
        String str = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        String strM349b = C0148f.m349b();
        String strM387b = AbstractC0155m.m387b(C0148f.m352e(), "NMEMO");
        File file = new File(AbstractC0155m.m387b(strM349b, NMEMO_DB_NAME));
        File file2 = new File(strM387b);
        if (file.exists() && !file.delete()) {
            Debugger.m8609e(TAG, "Failed to delete outMemoDBFile");
        }
        if (file2.exists()) {
            try {
                FileUtils.deleteFile(file2);
            } catch (IOException e) {
                AbstractC0000a.m20q(e, new StringBuilder("clearTempFiles IOException occurred 1."), TAG);
            }
        }
        unsetRunningFlag();
        AbstractC0147e.f419a.m366g();
    }

    private void importItems() throws Throwable {
        Debugger.m8607d(TAG, "Start importItems.");
        sendProgressEntireRestore(91);
        Object objCreateNMemoConverter = C0322h.m670a().f823i.createNMemoConverter(NMEMO_DB_NAME, NMEMO_ATTACHED_FOLDER);
        List listNMemoGetMemoMetaData = C0322h.m670a().f823i.NMemoGetMemoMetaData(objCreateNMemoConverter);
        ArrayList<String[]> arrayList = new ArrayList();
        int size = this.mImportList.size();
        int i = 0;
        while (true) {
            if (i >= size || isCancelled()) {
                break;
            }
            if (!AbstractC0155m.m401p()) {
                Debugger.m8609e(TAG, "Not enough free space");
                break;
            }
            ImportItem importItem = this.mImportList.get(i);
            try {
                ImportBaseTask.Listener listener = this.mListener;
                if (listener != null) {
                    listener.onDownloaded(DocTypeConstants.SS_NMEMO, importItem, 1);
                }
                Debugger.m8615i(TAG, "Start converting");
                String strNMemoCoreConvertToSDoc = C0322h.m670a().f823i.NMemoCoreConvertToSDoc(objCreateNMemoConverter, true, importItem.getServerKey(), C0322h.m670a().f823i.getNMemoValueConvertModeNormal());
                if (strNMemoCoreConvertToSDoc != null) {
                    arrayList.add(new String[]{importItem.getServerKey(), strNMemoCoreConvertToSDoc});
                } else if (!arrayList.isEmpty()) {
                    for (String[] strArr : arrayList) {
                        if (importItem.getServerKey().equals(strArr[0])) {
                            strNMemoCoreConvertToSDoc = strArr[1];
                        }
                    }
                }
                importItem.setRestoredUUID(strNMemoCoreConvertToSDoc);
                if (this.mFromSmartSwitch) {
                    Debugger.m8615i(TAG, "uuid : " + strNMemoCoreConvertToSDoc + ", widgetId : " + importItem.getWidgetID());
                    makeWidgetInfo(importItem.getWidgetID(), strNMemoCoreConvertToSDoc);
                }
                Debugger.m8615i(TAG, "Succeed to convert");
                this.mSuccessfulList.add(importItem);
                ImportBaseTask.Listener listener2 = this.mListener;
                if (listener2 != null) {
                    listener2.onItemImportFinished(DocTypeConstants.SS_NMEMO, i + 1, this.mSuccessfulList.size(), size);
                }
            } catch (Exception e) {
                AbstractC0000a.m21r(e, new StringBuilder("Exception importItems : "), TAG);
            }
            i++;
        }
        if (this.mFromSmartSwitch) {
            if (listNMemoGetMemoMetaData != null && size != listNMemoGetMemoMetaData.size()) {
                Debugger.m8607d(TAG, "Import widget files only. Do not clear restore data.");
                this.mNeedToClear = false;
            }
            restoreNMemoWidget();
        }
        Debugger.m8607d(TAG, "End importItems.");
    }

    private void loadImportItems() {
        Debugger.m8607d(TAG, "loadImportItems.");
        Object objCreateNMemoConverter = C0322h.m670a().f823i.createNMemoConverter(NMEMO_DB_NAME, NMEMO_ATTACHED_FOLDER);
        if (this.mImportList == null) {
            this.mImportList = new ArrayList();
        } else {
            Debugger.m8607d(TAG, "Original size : " + this.mImportList.size());
        }
        List<MemoMetaDataItem> listNMemoGetMemoMetaData = C0322h.m670a().f823i.NMemoGetMemoMetaData(objCreateNMemoConverter);
        if (listNMemoGetMemoMetaData != null) {
            for (MemoMetaDataItem memoMetaDataItem : listNMemoGetMemoMetaData) {
                ImportItem importItem = new ImportItem();
                importItem.setTitle(memoMetaDataItem.getTitle());
                importItem.setDownloadCompleted(true);
                importItem.setExtraObject(memoMetaDataItem);
                this.mImportList.add(importItem);
            }
        }
        Debugger.m8607d(TAG, "loadImportItems. result size : " + this.mImportList.size());
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0113 A[Catch: all -> 0x008d, Exception -> 0x0090, RuntimeException -> 0x0093, TRY_LEAVE, TryCatch #9 {all -> 0x008d, blocks: (B:8:0x0038, B:11:0x0073, B:13:0x0079, B:20:0x0096, B:22:0x009c, B:53:0x0149, B:60:0x016a, B:61:0x0184, B:31:0x00c2, B:33:0x00f4, B:35:0x00fa, B:36:0x010d, B:38:0x0113), top: B:72:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0169 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x015e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0187 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void makeWidgetInfo(int i, String str) throws Throwable {
        StringBuilder sb;
        IOException e;
        File file;
        String strM387b = AbstractC0155m.m387b(WDocUtils.getNoteFilePath(C0322h.m670a().f815a.getAppContext()), "SSWL");
        File file2 = new File(strM387b);
        if (!file2.exists() && !file2.mkdirs()) {
            Debugger.m8607d(TAG, "Failed to mkdirs widgetIdFolder path.");
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("uuid", str);
                jSONArray.put(jSONObject2);
                jSONObject.put("file_info", jSONArray);
                File file3 = new File(AbstractC0155m.m387b(strM387b, str) + ".widget");
                if (file3.exists() && !file3.delete()) {
                    Debugger.m8609e(TAG, "Failed to delete file. " + file3.getName());
                }
                if (file3.createNewFile()) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                    try {
                        fileOutputStream2.write(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                        fileOutputStream = fileOutputStream2;
                        JSONObject jSONObject3 = new JSONObject();
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(jSONObject2);
                        jSONObject3.put("file_info", jSONArray2);
                        file = new File(AbstractC0155m.m387b(strM387b, Integer.toString(i)) + ".widget");
                        if (file.exists() && !file.delete()) {
                            Debugger.m8609e(TAG, "Failed to delete file. " + file.getName());
                        }
                        if (file.createNewFile()) {
                            FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                            try {
                                fileOutputStream3.write(jSONObject3.toString().getBytes(StandardCharsets.UTF_8));
                                fileOutputStream3.flush();
                                fileOutputStream3.close();
                                fileOutputStream = fileOutputStream3;
                            } catch (RuntimeException e2) {
                                e = e2;
                                Debugger.m8609e(TAG, "unrecoverable exception occurred " + e.toString() + e.getMessage());
                                throw e;
                            } catch (Exception e3) {
                                fileOutputStream = fileOutputStream3;
                                e = e3;
                                Debugger.m8609e(TAG, "Failed to backup NMemo widget info. " + e.getMessage());
                                if (fileOutputStream != null) {
                                }
                            } catch (Throwable th) {
                                fileOutputStream = fileOutputStream3;
                                th = th;
                                if (fileOutputStream != null) {
                                }
                                throw th;
                            }
                        }
                        if (fileOutputStream != null) {
                            return;
                        }
                        try {
                            fileOutputStream.close();
                            return;
                        } catch (IOException e5) {
                            e = e5;
                            sb = new StringBuilder("IOException occured while closing stream. ");
                        }
                    } catch (RuntimeException e6) {
                        e = e6;
                        Debugger.m8609e(TAG, "unrecoverable exception occurred " + e.toString() + e.getMessage());
                        throw e;
                    } catch (Exception e7) {
                        e = e7;
                        fileOutputStream = fileOutputStream2;
                        Debugger.m8609e(TAG, "Failed to backup NMemo widget info. " + e.getMessage());
                        if (fileOutputStream != null) {
                            return;
                        }
                        try {
                            fileOutputStream.close();
                            return;
                        } catch (IOException e8) {
                            e = e8;
                            sb = new StringBuilder("IOException occured while closing stream. ");
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e9) {
                                AbstractC0000a.m20q(e9, new StringBuilder("IOException occured while closing stream. "), TAG);
                            }
                        }
                        throw th;
                    }
                } else {
                    JSONObject jSONObject32 = new JSONObject();
                    JSONArray jSONArray22 = new JSONArray();
                    jSONArray22.put(jSONObject2);
                    jSONObject32.put("file_info", jSONArray22);
                    file = new File(AbstractC0155m.m387b(strM387b, Integer.toString(i)) + ".widget");
                    if (file.exists()) {
                        Debugger.m8609e(TAG, "Failed to delete file. " + file.getName());
                    }
                    if (file.createNewFile()) {
                    }
                    if (fileOutputStream != null) {
                    }
                }
                AbstractC0000a.m20q(e, sb, TAG);
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (RuntimeException e10) {
            e = e10;
        } catch (Exception e11) {
            e = e11;
        }
    }

    private void restoreNMemoWidget() throws Throwable {
        ArrayList<Integer[]> arrayList = (ArrayList) AbstractC0144b.f399a.f254b;
        if (arrayList == null || arrayList.isEmpty()) {
            Debugger.m8607d(TAG, "restoreNMemoWidget. Nothing to restore.");
            return;
        }
        Debugger.m8607d(TAG, "restoreNMemoWidget.");
        ArrayList arrayList2 = new ArrayList();
        for (Integer[] numArr : arrayList) {
            C0073a c0073a = AbstractC0144b.f399a;
            int iIntValue = numArr[0].intValue();
            c0073a.getClass();
            String strM196n = C0073a.m196n(iIntValue);
            if (strM196n != null) {
                Debugger.m8607d(TAG, "sendPickWidgetBroadcast");
                int iM198p = C0073a.m198p(numArr[0].intValue(), BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY);
                int iM198p2 = C0073a.m198p(numArr[0].intValue(), BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR);
                int iM198p3 = C0073a.m198p(numArr[0].intValue(), BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE);
                boolean z = C0073a.m198p(numArr[0].intValue(), BaseWidgetConstant.KEY_WIDGET_MATCH_SETTING) == 1;
                int iM198p4 = C0073a.m198p(numArr[0].intValue(), BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE);
                boolean z2 = C0073a.m198p(numArr[0].intValue(), BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF) != 0;
                StringBuilder sbM1173s = AbstractC0622a.m1173s(iM198p, iM198p2, "transparency : ", " , backgroundColor : ", " , darkMode : ");
                sbM1173s.append(iM198p3);
                sbM1173s.append(" , matchSetting : ");
                sbM1173s.append(z);
                sbM1173s.append(" , backgroundShape : ");
                sbM1173s.append(iM198p4);
                sbM1173s.append(" , backgroundOnOff : ");
                sbM1173s.append(z2);
                Debugger.m8607d(TAG, sbM1173s.toString());
                WidgetAccessHandler.getWidgetAccessContract().sendPickWidgetBroadcast(this.mContext, strM196n, numArr[1].intValue(), iM198p, iM198p2, iM198p3, z, iM198p4, z2);
                arrayList2.add(numArr);
            } else {
                Debugger.m8607d(TAG, "uuid == null");
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((ArrayList) AbstractC0144b.f399a.f254b).remove((Integer[]) it.next());
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
                this.mListener.onUpdated(DocTypeConstants.SS_NMEMO, i, size, importItem);
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.MigrationImportBaseTask
    public void setRunningFlag() {
        String str = C0148f.f420k;
        AbstractC0147e.f419a.f435e = true;
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public void startImport() throws Throwable {
        importItems();
        clearTempFiles();
        sendResponseEntireRestore(0, 0);
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public int syncProgress() {
        return 0;
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.MigrationImportBaseTask
    public void unsetRunningFlag() {
        String str = C0148f.f420k;
        AbstractC0147e.f419a.f435e = false;
    }

    public SSNMemoSync(Context context, ImportBaseTask.Listener listener, int i, List<ImportItem> list, boolean z) {
        super(context, listener, DocTypeConstants.SS_NMEMO, i, z);
        this.mNeedToClear = true;
        if (list == null) {
            loadImportItems();
        } else {
            this.mImportList = list;
        }
    }
}
