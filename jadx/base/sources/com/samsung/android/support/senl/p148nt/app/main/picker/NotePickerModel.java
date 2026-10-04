package com.samsung.android.support.senl.p148nt.app.main.picker;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.drawer.model.DrawerModel;
import com.samsung.android.support.senl.p148nt.base.common.access.sync.importer.data.ImportDocument;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.startmanager.ModelStartManager;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import p084U0.AbstractC0311c;
import p084U0.C0312d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotePickerModel {
    private static final String SDOC_MIME_TYPE = "sdoc";
    private static final String TAG = "NotePickerModel";
    private final Map<String, NotesFolder> mFolderDataMap = DataManager.getInstance().getFolderDataMap();

    public boolean hasOnlySDocShare(Context context, Intent intent) throws Throwable {
        ArrayList parcelableArrayListExtra;
        String type = intent.getType();
        if (type != null && !TextUtils.isEmpty(type)) {
            if (type.startsWith(Constants.MIME_SDOC)) {
                return true;
            }
            if (type.startsWith(Constants.MIME_APPLICATION_START)) {
                if (!"android.intent.action.SEND".equals(intent.getAction())) {
                    if (!"android.intent.action.SEND_MULTIPLE".equals(intent.getAction()) || (parcelableArrayListExtra = intent.getParcelableArrayListExtra("android.intent.extra.STREAM")) == null) {
                        return false;
                    }
                    Iterator it = parcelableArrayListExtra.iterator();
                    while (it.hasNext()) {
                        String pathFromUri = UriFileUtils.getPathFromUri(context, (Uri) it.next());
                        if (!pathFromUri.endsWith(".sdoc") && !pathFromUri.endsWith(".sdocx")) {
                            return false;
                        }
                    }
                    return true;
                }
                Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
                if (uri != null && uri.getLastPathSegment() != null) {
                    return uri.getLastPathSegment().contains("sdoc");
                }
            }
        }
        return false;
    }

    public void importSdocHandler(Context context, Intent intent) throws Throwable {
        ClipData clipData;
        int itemCount;
        if (intent == null || intent.getClipData() == null) {
            return;
        }
        if (ModelStartManager.INSTANCE.isBlocked()) {
            MainLogger.m7258i(TAG, "importSdocHandler, import is blocked");
            return;
        }
        String action = intent.getAction();
        MainLogger.m7258i(TAG, "importSdocHandler# action : " + action);
        ArrayList arrayList = new ArrayList();
        if ("android.intent.action.SEND".equals(action)) {
            arrayList.add((Uri) intent.getParcelableExtra("android.intent.extra.STREAM"));
        } else if (!"android.intent.action.SEND_MULTIPLE".equals(action)) {
            return;
        } else {
            arrayList = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
        }
        if (arrayList == null || (clipData = intent.getClipData()) == null || (itemCount = clipData.getItemCount()) <= 1) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < itemCount; i++) {
            Uri uri = clipData.getItemAt(i).getUri();
            String pathFromUri = UriFileUtils.getPathFromUri(context, uri);
            if (pathFromUri.endsWith(".sdoc") || pathFromUri.endsWith(".sdocx")) {
                arrayList2.add(new ImportDocument(pathFromUri, null));
                arrayList.remove(uri);
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        TaskState.INSTANCE.getInstance().setIsRunning("IMPORT_BY_NOTEPICKER", true);
        C0312d c0312d = new C0312d(context, arrayList2, TAG);
        c0312d.f806k = true;
        c0312d.f808m = new AbstractC0311c() { // from class: com.samsung.android.support.senl.nt.app.main.picker.NotePickerModel.1
            @Override // p084U0.InterfaceC0313e
            public void onFinish(int i2, int i4, @NonNull Map<String, Integer> map, int i5) {
                TaskState.INSTANCE.getInstance().setIsRunning("IMPORT_BY_NOTEPICKER", false);
            }
        };
        c0312d.m664c(false);
    }

    public void updateDrawerData(DocumentCategoryTree documentCategoryTree) {
        MainLogger.m7258i(TAG, "updateDrawerData# size " + documentCategoryTree.getFolderCount());
        if (this.mFolderDataMap == null) {
            return;
        }
        Map<String, NotesFolder> folderMap = documentCategoryTree.getFolderMap();
        for (DrawerModel.FilterType filterType : DrawerModel.FilterType.values()) {
            NotesFolder notesFolder = this.mFolderDataMap.get(filterType.getUuid());
            if (notesFolder != null) {
                folderMap.put(filterType.getUuid(), notesFolder);
            }
        }
        for (NotesFolder notesFolder2 : folderMap.values()) {
            NotesFolder notesFolder3 = this.mFolderDataMap.get(notesFolder2.getUuid());
            if (notesFolder3 != null && notesFolder3.getViewType() <= 3) {
                notesFolder2.setExpanded(notesFolder3.isExpanded());
                notesFolder2.setViewType(notesFolder3.getViewType());
                notesFolder2.setId(notesFolder3.getId());
            }
        }
        this.mFolderDataMap.clear();
        this.mFolderDataMap.putAll(DataManager.getInstance().drawerOrdering(folderMap));
    }
}
