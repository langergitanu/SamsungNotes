package com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.model.ImportFolderInfo;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\r\n\u0002\b\r\u0018\u0000 \u0080\u00012\u00020\u0001:\u0002\u0080\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u0019\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0017J\u0006\u0010\u001b\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001eJ\u0006\u0010$\u001a\u00020\u0017J\u0006\u0010)\u001a\u00020\"J\u0018\u0010+\u001a\u00020&2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002J\u0016\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020\"J\u000e\u00100\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020&J\u000e\u00101\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\"J \u00102\u001a\u00020\u00172\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010/\u001a\u00020\"H\u0002J\u0014\u00103\u001a\u00020\u00172\f\u00104\u001a\b\u0012\u0004\u0012\u00020&0\u000eJ,\u00105\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u001c\u00106\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0018\u000107H\u0002J.\u00108\u001a\u00020\u00172\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020&0\u000e2\b\b\u0002\u0010;\u001a\u00020&H\u0002J\u0006\u0010<\u001a\u00020\u0017J\u0006\u0010=\u001a\u00020\u0017J\u000e\u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u0005J\u000e\u0010@\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u0005J\u0006\u0010A\u001a\u00020\u0017J\u0006\u0010B\u001a\u00020\u0017J\u0006\u0010C\u001a\u00020\u0017J\u0006\u0010I\u001a\u00020\u0017J \u0010J\u001a\u00020\"2\u0006\u0010K\u001a\u00020&2\u0006\u0010L\u001a\u00020&2\b\u0010M\u001a\u0004\u0018\u00010NJ\b\u0010O\u001a\u0004\u0018\u00010\u0005J\u0010\u0010P\u001a\u00020\u00172\b\u0010Q\u001a\u0004\u0018\u00010\u0005J\u0010\u0010W\u001a\u00020\u00172\b\u0010X\u001a\u0004\u0018\u00010\u0005J\u0018\u0010]\u001a\u00020\u00172\u0006\u0010^\u001a\u00020\u00052\u0006\u0010_\u001a\u00020\u0005H\u0002J\u0018\u0010`\u001a\u00020\u00172\u0006\u0010^\u001a\u00020\u00052\u0006\u0010a\u001a\u00020\u000fH\u0002J\u001e\u0010b\u001a\u00020\"2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010?\u001a\u00020\u0005H\u0002J\u001e\u0010d\u001a\u00020&2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010?\u001a\u00020\u0005H\u0002J\u001e\u0010e\u001a\u00020&2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010f\u001a\u00020\u000fH\u0002J\u0016\u0010l\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010_\u001a\u00020\u000fH\u0002J6\u0010o\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u001c\u0010p\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0018\u00010\r2\b\u0010q\u001a\u0004\u0018\u00010\u0005H\u0002J\"\u0010r\u001a\u00020\u00052\b\u0010s\u001a\u0004\u0018\u00010t2\b\u0010u\u001a\u0004\u0018\u00010t2\u0006\u0010v\u001a\u00020&J\u0018\u0010w\u001a\u00020\u00052\b\u0010s\u001a\u0004\u0018\u00010t2\u0006\u0010v\u001a\u00020&J\u0010\u0010x\u001a\u00020\u00172\u0006\u0010a\u001a\u00020\u000fH\u0016J\u001c\u0010y\u001a\u0004\u0018\u00010\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010z\u001a\u00020&H\u0016J\u0006\u0010{\u001a\u00020\u0017J\u0006\u0010|\u001a\u00020\u0017J\u0006\u0010}\u001a\u00020\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b!\u0010#R\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0011\u0010*\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b+\u0010(R(\u0010D\u001a\u0004\u0018\u00010\u00052\b\u0010D\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR(\u0010R\u001a\u0004\u0018\u00010\u00052\b\u0010R\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bS\u0010F\"\u0004\bT\u0010HR\u0013\u0010U\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\bV\u0010FR(\u0010Y\u001a\u0004\u0018\u00010\u00052\b\u0010Y\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bZ\u0010F\"\u0004\b[\u0010HR\u0011\u0010\\\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b\\\u0010#R\u001a\u0010g\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bh\u0010iR\u001a\u0010j\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bk\u0010iR\u001a\u0010m\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bn\u0010iR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b~\u0010\u007f¨\u0006\u0081\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenter;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode$Contract;", "importType", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "googleAccountName", "", "mContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;", "<init>", "(Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;Ljava/lang/String;Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;)V", "mMode", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode;", "mFileMap", "", "", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/model/ImportFolderInfo;", "mFolderMap", "mRootFolderName", "mNoNoteText", "mAppName", "mActionBarTitle", "mCurrentFolder", "setImportFolderMode", "", "mode", "onCreate", "onResume", "onDestroy", "onRestoreInstanceState", "savedInstanceState", "Landroid/os/Bundle;", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "isRootFolder", "", "()Z", "moveToUpperFolder", "itemCount", "", "getItemCount", "()I", "hasItem", "checkedItemCount", "getCheckedItemCount", "importFolderInfos", "setItemChecked", "position", "checked", "getImportFolderInfo", "setAllItemChecked", "setItemsChecked", "toggleSelectedState", "selectedItemPositionList", "getImportFolderInfos", "importFolderMap", "", "toggleItemSelectedState", "items", "selectedItemPositions", TypedValues.Cycle.S_WAVE_OFFSET, "onItemChecked", "onItemLongPressed", "onFolderClicked", "folderName", "updateValidateFolderPath", "initPresenter", "initFileMap", "initFolderMap", "currentFolder", "getCurrentFolder", "()Ljava/lang/String;", "setCurrentFolder", "(Ljava/lang/String;)V", "onActionDone", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "getRootFolder", "setRootFolder", "rootFolderName", "noNoteText", "getNoNoteText", "setNoNoteText", "defaultActionBarTitle", "getDefaultActionBarTitle", "setActionBarTitle", "actionBarTitle", "appName", "getAppName", "setAppName", "isLocalNotePickerNeeds", "addFolderToSpecificFolderPath", "targetFolder", "folder", "addFileToSpecificFolderPath", "fileData", "hasFolderInFolderList", "folderInfos", "getPositionFolderToBeAddedFromFolderList", "getPositionFileToBeAddedFromFolderList", "file", "checkedImportFolderInfos", "getCheckedImportFolderInfos", "()Ljava/util/List;", "checkedFolder", "getCheckedFolder", "getAllFilesFromFolder", "checkedFile", "getCheckedFile", "getFolderListFromFolderInfos", "folderInfoMap", "folderPath", "getItemContainerContentDescription", "name", "", "time", "itemType", "getContainerContentDescription", "addFileData", "getBaseDisplayDirectory", "storageType", "unregisterImportListRequest", "removeSelectedItem", "setValidateFolderPath", "getImportType", "()Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImportFolderPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImportFolderPresenter.kt\ncom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,512:1\n739#2,9:513\n739#2,9:526\n37#3:522\n36#3,3:523\n37#3:535\n36#3,3:536\n*S KotlinDebug\n*F\n+ 1 ImportFolderPresenter.kt\ncom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenter\n*L\n66#1:513,9\n457#1:526,9\n67#1:522\n67#1:523,3\n458#1:535\n458#1:536,3\n*E\n"})
public final class ImportFolderPresenter implements ImportFolderMode.Contract {

    @NotNull
    public static final String KEY_CURRENT_FOLDER = "key_current_folder";

    @NotNull
    private static final String TAG = "ImportFolderPresenter";

    @Nullable
    private String mActionBarTitle;

    @Nullable
    private String mAppName;

    @NotNull
    private final ImportFolderPresenterContract mContract;

    @Nullable
    private String mCurrentFolder;

    @Nullable
    private Map<String, List<ImportFolderInfo>> mFileMap;

    @Nullable
    private Map<String, List<ImportFolderInfo>> mFolderMap;

    @Nullable
    private ImportFolderMode mMode;

    @Nullable
    private String mNoNoteText;

    @Nullable
    private String mRootFolderName;

    public ImportFolderPresenter(@NotNull DocTypeConstants importType, @Nullable String str, @NotNull ImportFolderPresenterContract mContract) {
        Intrinsics.checkNotNullParameter(importType, "importType");
        Intrinsics.checkNotNullParameter(mContract, "mContract");
        this.mContract = mContract;
        setImportFolderMode(ImportFolderMode.INSTANCE.create(importType, str, mContract, this));
    }

    private final void addFileToSpecificFolderPath(String targetFolder, ImportFolderInfo fileData) {
        List<ImportFolderInfo> folderListFromFolderInfos = getFolderListFromFolderInfos(this.mFileMap, targetFolder);
        Intrinsics.checkNotNull(folderListFromFolderInfos, "null cannot be cast to non-null type java.util.ArrayList<com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.model.ImportFolderInfo>");
        ArrayList arrayList = (ArrayList) folderListFromFolderInfos;
        arrayList.add(getPositionFileToBeAddedFromFolderList(arrayList, fileData), fileData);
    }

    private final void addFolderToSpecificFolderPath(String targetFolder, String folder) {
        List<ImportFolderInfo> folderListFromFolderInfos = getFolderListFromFolderInfos(this.mFolderMap, targetFolder);
        Intrinsics.checkNotNull(folderListFromFolderInfos, "null cannot be cast to non-null type java.util.ArrayList<com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.model.ImportFolderInfo>");
        ArrayList arrayList = (ArrayList) folderListFromFolderInfos;
        if (hasFolderInFolderList(arrayList, folder)) {
            return;
        }
        arrayList.add(getPositionFolderToBeAddedFromFolderList(arrayList, folder), new ImportFolderInfo(1, null, targetFolder, folder));
    }

    private final List<ImportFolderInfo> getAllFilesFromFolder(ImportFolderInfo folder) {
        ArrayList arrayList = new ArrayList();
        String displayPath = folder.getDisplayPath();
        String str = File.separator;
        String strM757C = AbstractC0541b.m757C(displayPath, str, folder.getName());
        String strM756B = AbstractC0541b.m756B(strM757C, str);
        Map<String, List<ImportFolderInfo>> map = this.mFileMap;
        Intrinsics.checkNotNull(map);
        for (Map.Entry<String, List<ImportFolderInfo>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<ImportFolderInfo> value = entry.getValue();
            if (!TextUtils.isEmpty(key)) {
                if (!Intrinsics.areEqual(key, strM757C)) {
                    Intrinsics.checkNotNull(key);
                    if (StringsKt.m14129C(strM756B, 0, 6, key) == 0) {
                    }
                }
                arrayList.addAll(value);
            }
        }
        return arrayList;
    }

    private final List<ImportFolderInfo> getCheckedFile() {
        ArrayList arrayList = new ArrayList();
        for (ImportFolderInfo importFolderInfo : getFolderListFromFolderInfos(this.mFileMap, this.mCurrentFolder)) {
            if (importFolderInfo.getIsChecked()) {
                arrayList.add(importFolderInfo);
            }
        }
        return arrayList;
    }

    private final List<ImportFolderInfo> getCheckedFolder() {
        ArrayList arrayList = new ArrayList();
        for (ImportFolderInfo importFolderInfo : getFolderListFromFolderInfos(this.mFolderMap, this.mCurrentFolder)) {
            if (importFolderInfo.getIsChecked()) {
                arrayList.addAll(getAllFilesFromFolder(importFolderInfo));
            }
        }
        return arrayList;
    }

    private final List<ImportFolderInfo> getFolderListFromFolderInfos(Map<String, List<ImportFolderInfo>> folderInfoMap, String folderPath) {
        if (TextUtils.isEmpty(folderPath)) {
            return new ArrayList();
        }
        if (folderInfoMap != null && folderInfoMap.containsKey(folderPath)) {
            List<ImportFolderInfo> list = folderInfoMap.get(folderPath);
            Intrinsics.checkNotNull(list);
            return list;
        }
        ArrayList arrayList = new ArrayList();
        if (folderInfoMap != null) {
            folderInfoMap.put(folderPath, arrayList);
        }
        return arrayList;
    }

    private final List<ImportFolderInfo> getImportFolderInfos(Map<String, ? extends List<ImportFolderInfo>> importFolderMap) {
        if (importFolderMap == null || !importFolderMap.containsKey(this.mCurrentFolder)) {
            return CollectionsKt.emptyList();
        }
        List<ImportFolderInfo> list = importFolderMap.get(this.mCurrentFolder);
        return list == null ? CollectionsKt.emptyList() : list;
    }

    private final int getPositionFileToBeAddedFromFolderList(List<ImportFolderInfo> folderInfos, ImportFolderInfo file) {
        int size = folderInfos.size();
        for (int i = 0; i < size; i++) {
            if (file.getModifiedTime() > folderInfos.get(i).getModifiedTime()) {
                return i;
            }
        }
        return size;
    }

    private final int getPositionFolderToBeAddedFromFolderList(List<ImportFolderInfo> folderInfos, String folderName) {
        int size = folderInfos.size();
        for (int i = 0; i < size; i++) {
            String name = folderInfos.get(i).getName();
            Intrinsics.checkNotNull(name);
            if (folderName.compareTo(name) < 0) {
                return i;
            }
        }
        return size;
    }

    private final boolean hasFolderInFolderList(List<ImportFolderInfo> folderInfos, String folderName) {
        Iterator<ImportFolderInfo> it = folderInfos.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getName(), folderName)) {
                return true;
            }
        }
        return false;
    }

    private final void setItemsChecked(List<ImportFolderInfo> importFolderInfos, boolean checked) {
        if (importFolderInfos == null) {
            return;
        }
        for (ImportFolderInfo importFolderInfo : importFolderInfos) {
            if (importFolderInfo.getIsChecked() != checked) {
                importFolderInfo.setChecked(checked);
            }
        }
    }

    private final void toggleItemSelectedState(List<ImportFolderInfo> items, List<Integer> selectedItemPositions, int offset) {
        Iterator<Integer> it = selectedItemPositions.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (offset <= iIntValue && iIntValue < items.size() + offset) {
                items.get(iIntValue - offset).setChecked(!r1.getIsChecked());
                this.mContract.notifyItemChanged(iIntValue);
            }
        }
    }

    public static /* synthetic */ void toggleItemSelectedState$default(ImportFolderPresenter importFolderPresenter, List list, List list2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        importFolderPresenter.toggleItemSelectedState(list, list2, i);
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode.Contract
    public void addFileData(@NotNull ImportFolderInfo fileData) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(fileData, "fileData");
        MainLogger.m7258i(TAG, "addFileData# " + MainLogger.getEncode(fileData.getDisplayPath()));
        String displayPath = fileData.getDisplayPath();
        Intrinsics.checkNotNull(displayPath);
        List listM13999t = AbstractC12991c.m13999t(0, "/", displayPath);
        if (listM13999t.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        StringBuilder sb = new StringBuilder(strArr[0]);
        int length = strArr.length;
        for (int i = 1; i < length; i++) {
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            addFolderToSpecificFolderPath(string, strArr[i]);
            sb.append(File.separator);
            sb.append(strArr[i]);
        }
        String string2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        addFileToSpecificFolderPath(string2, fileData);
    }

    @Nullable
    public final String getAppName() {
        String string;
        if (TextUtils.isEmpty(this.mAppName)) {
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext != null) {
                ImportFolderMode importFolderMode = this.mMode;
                Intrinsics.checkNotNull(importFolderMode);
                string = applicationContext.getString(importFolderMode.getAppNameRes());
            } else {
                string = null;
            }
            setAppName(string);
        }
        return this.mAppName;
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode.Contract
    @Nullable
    public String getBaseDisplayDirectory(@Nullable DocTypeConstants importType, int storageType) {
        Context applicationContext = BaseUtils.getApplicationContext();
        StringBuilder sb = new StringBuilder();
        if (importType == DocTypeConstants.SNOTE_GOOGLEDRIVE) {
            sb.append(applicationContext != null ? applicationContext.getString(C8003R.string.import_rootname_google_drive) : null);
            sb.append(File.separator);
        } else if (importType == DocTypeConstants.SNOTE_SCLOUD) {
            if (applicationContext != null) {
                string = applicationContext.getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.import_rootname_samsung_account_jp : C8003R.string.import_rootname_samsung_account);
            }
            sb.append(string);
            sb.append(File.separator);
        } else {
            sb.append(applicationContext != null ? applicationContext.getString(C8003R.string.import_rootname_this_device) : null);
            String str = File.separator;
            sb.append(str);
            if (storageType == 101) {
                sb.append(applicationContext != null ? applicationContext.getString(C8003R.string.import_foldername_my_device) : null);
                sb.append(str);
            } else {
                if (storageType != 103) {
                    throw new IllegalArgumentException();
                }
                sb.append(applicationContext != null ? applicationContext.getString(C8003R.string.import_foldername_sd_card) : null);
                sb.append(str);
            }
        }
        return sb.toString();
    }

    @NotNull
    public final List<ImportFolderInfo> getCheckedImportFolderInfos() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getCheckedFolder());
        arrayList.addAll(getCheckedFile());
        return arrayList;
    }

    public final int getCheckedItemCount() {
        if (TextUtils.isEmpty(this.mCurrentFolder)) {
            return 0;
        }
        return getCheckedItemCount(getImportFolderInfos(this.mFolderMap)) + getCheckedItemCount(getImportFolderInfos(this.mFileMap));
    }

    @NotNull
    public final String getContainerContentDescription(@Nullable CharSequence name, int itemType) {
        Context applicationContext = BaseUtils.getApplicationContext();
        StringBuilder sb = new StringBuilder();
        if (itemType == 1) {
            sb.append(applicationContext != null ? applicationContext.getString(C8003R.string.import_folder) : null);
            sb.append(SQLKeyword.COMMA);
            sb.append(name);
            sb.append(SQLKeyword.COMMA);
            sb.append(applicationContext != null ? applicationContext.getString(C8003R.string.selectall_voice_ass_tick_box) : null);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Nullable
    public final String getCurrentFolder() {
        AbstractC8014b.m7209k("getCurrentFolder# mCurrentFolder ", this.mCurrentFolder, TAG);
        return this.mCurrentFolder;
    }

    @Nullable
    public final String getDefaultActionBarTitle() {
        String string;
        if (TextUtils.isEmpty(this.mActionBarTitle)) {
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext != null) {
                ImportFolderMode importFolderMode = this.mMode;
                Intrinsics.checkNotNull(importFolderMode);
                string = applicationContext.getString(importFolderMode.getActionBarTitleRes(), getAppName());
            } else {
                string = null;
            }
            setActionBarTitle(string);
        }
        return this.mActionBarTitle;
    }

    @NotNull
    public final ImportFolderInfo getImportFolderInfo(int position) {
        Map<String, List<ImportFolderInfo>> map = this.mFolderMap;
        Intrinsics.checkNotNull(map);
        int size = map.containsKey(this.mCurrentFolder) ? getImportFolderInfos(this.mFolderMap).size() : 0;
        return position < size ? getImportFolderInfos(this.mFolderMap).get(position) : getImportFolderInfos(this.mFileMap).get(position - size);
    }

    @Nullable
    public final DocTypeConstants getImportType() {
        ImportFolderMode importFolderMode = this.mMode;
        Intrinsics.checkNotNull(importFolderMode);
        return importFolderMode.getImportType();
    }

    @NotNull
    public final String getItemContainerContentDescription(@Nullable CharSequence name, @Nullable CharSequence time, int itemType) {
        Context applicationContext = BaseUtils.getApplicationContext();
        StringBuilder sb = new StringBuilder();
        if (itemType == 1) {
            sb.append(applicationContext != null ? applicationContext.getString(C8003R.string.import_folder) : null);
            sb.append(SQLKeyword.COMMA);
            sb.append(name);
        } else {
            sb.append(applicationContext != null ? applicationContext.getString(C8003R.string.import_file) : null);
            sb.append(SQLKeyword.COMMA);
            sb.append(name);
            sb.append(SQLKeyword.COMMA);
            sb.append(time);
        }
        sb.append(SQLKeyword.COMMA);
        sb.append(applicationContext != null ? applicationContext.getString(C8003R.string.selectall_voice_ass_tick_box) : null);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final int getItemCount() {
        if (TextUtils.isEmpty(this.mCurrentFolder)) {
            return 0;
        }
        return getImportFolderInfos(this.mFolderMap).size() + getImportFolderInfos(this.mFileMap).size();
    }

    @Nullable
    public final String getNoNoteText() {
        String string;
        if (TextUtils.isEmpty(this.mNoNoteText)) {
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext != null) {
                ImportFolderMode importFolderMode = this.mMode;
                Intrinsics.checkNotNull(importFolderMode);
                string = applicationContext.getString(importFolderMode.getNoNoteTextRes(), getAppName());
            } else {
                string = null;
            }
            setNoNoteText(string);
        }
        return this.mNoNoteText;
    }

    @Nullable
    public final String getRootFolder() {
        String string;
        if (TextUtils.isEmpty(this.mRootFolderName)) {
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext != null) {
                ImportFolderMode importFolderMode = this.mMode;
                Intrinsics.checkNotNull(importFolderMode);
                string = applicationContext.getString(importFolderMode.getRootFolderRes());
            } else {
                string = null;
            }
            setRootFolder(string);
        }
        AbstractC8014b.m7209k("getRootFolder: ", this.mRootFolderName, TAG);
        return this.mRootFolderName;
    }

    public final boolean hasItem() {
        Map<String, List<ImportFolderInfo>> map = this.mFileMap;
        return (map == null || map.isEmpty()) ? false : true;
    }

    public final void initFileMap() {
        Map<String, List<ImportFolderInfo>> map = this.mFileMap;
        if (map == null) {
            this.mFileMap = new HashMap();
        } else {
            Intrinsics.checkNotNull(map);
            map.clear();
        }
    }

    public final void initFolderMap() {
        Map<String, List<ImportFolderInfo>> map = this.mFolderMap;
        if (map == null) {
            this.mFolderMap = new HashMap();
        } else {
            Intrinsics.checkNotNull(map);
            map.clear();
        }
    }

    public final void initPresenter() {
        MainLogger.m7258i(TAG, "initPresenter");
        setCurrentFolder(getRootFolder());
        initFileMap();
        initFolderMap();
        ImportFolderMode importFolderMode = this.mMode;
        if (importFolderMode != null) {
            importFolderMode.requestImportList();
        }
    }

    public final boolean isLocalNotePickerNeeds() {
        ImportFolderMode importFolderMode = this.mMode;
        Intrinsics.checkNotNull(importFolderMode);
        return importFolderMode.isLocalNotePickerNeeds();
    }

    public final boolean isRootFolder() {
        List listEmptyList;
        if (TextUtils.isEmpty(this.mCurrentFolder)) {
            return true;
        }
        String str = this.mCurrentFolder;
        Intrinsics.checkNotNull(str);
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        List<String> listSplit = new Regex(separator).split(str, 0);
        if (listSplit.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listSplit);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        return listEmptyList.toArray(new String[0]).length == 1;
    }

    public final void moveToUpperFolder() {
        String str = this.mCurrentFolder;
        Intrinsics.checkNotNull(str);
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        int iM14131E = StringsKt.m14131E(separator, 0, 6, str);
        String str2 = this.mCurrentFolder;
        Intrinsics.checkNotNull(str2);
        String strSubstring = str2.substring(0, iM14131E);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        setCurrentFolder(strSubstring);
    }

    public final void onActionDone() {
        ImportFolderMode importFolderMode = this.mMode;
        if (importFolderMode != null) {
            importFolderMode.startImport(getCheckedImportFolderInfos());
        }
    }

    public final boolean onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        AbstractC8014b.m7200b(requestCode, resultCode, "onActivityResult# ", " , ", TAG);
        ImportFolderMode importFolderMode = this.mMode;
        Intrinsics.checkNotNull(importFolderMode);
        return importFolderMode.onActivityResult(requestCode, resultCode, data);
    }

    public final void onCreate() {
        ImportFolderMode importFolderMode = this.mMode;
        if (importFolderMode != null) {
            importFolderMode.onCreate();
        }
    }

    public final void onDestroy() {
        ImportFolderMode importFolderMode = this.mMode;
        if (importFolderMode != null) {
            importFolderMode.onDestroy();
        }
    }

    public final void onFolderClicked(@NotNull String folderName) {
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        setCurrentFolder(this.mCurrentFolder + File.separator + folderName);
        this.mContract.updateFolderLayout();
    }

    public final void onItemChecked() {
        this.mContract.updateSelectedItemCount();
    }

    public final void onItemLongPressed() {
        this.mContract.onItemLongPressed();
    }

    public final void onRestoreInstanceState(@NotNull Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        setCurrentFolder(savedInstanceState.getString(KEY_CURRENT_FOLDER, getRootFolder()));
    }

    public final void onResume() {
        ImportFolderMode importFolderMode = this.mMode;
        if (importFolderMode != null) {
            importFolderMode.onResume();
        }
    }

    public final void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putString(KEY_CURRENT_FOLDER, this.mCurrentFolder);
    }

    public final void removeSelectedItem() {
        ImportFolderMode importFolderMode = this.mMode;
        Intrinsics.checkNotNull(importFolderMode);
        importFolderMode.removeSelectedItem();
    }

    public final void setActionBarTitle(@Nullable String actionBarTitle) {
        this.mActionBarTitle = actionBarTitle;
    }

    public final void setAllItemChecked(boolean checked) {
        setItemsChecked(getImportFolderInfos(this.mFolderMap), checked);
        setItemsChecked(getImportFolderInfos(this.mFileMap), checked);
        this.mContract.notifyDataSetChanged();
    }

    public final void setAppName(@Nullable String str) {
        this.mAppName = str;
    }

    public final void setCurrentFolder(@Nullable String str) {
        AbstractC8014b.m7209k("setCurrentFolder# currentFolder ", str, TAG);
        this.mCurrentFolder = str;
    }

    public final void setImportFolderMode(@Nullable ImportFolderMode mode) {
        this.mMode = mode;
    }

    public final void setItemChecked(int position, boolean checked) {
        getImportFolderInfo(position).setChecked(checked);
        onItemChecked();
        this.mContract.notifyDataSetChanged();
    }

    public final void setNoNoteText(@Nullable String str) {
        this.mNoNoteText = str;
    }

    public final void setRootFolder(@Nullable String rootFolderName) {
        this.mRootFolderName = rootFolderName;
    }

    public final void setValidateFolderPath() {
        ImportFolderMode importFolderMode = this.mMode;
        Intrinsics.checkNotNull(importFolderMode);
        importFolderMode.setValidateFolderPath();
    }

    public final void toggleSelectedState(@NotNull List<Integer> selectedItemPositionList) {
        Intrinsics.checkNotNullParameter(selectedItemPositionList, "selectedItemPositionList");
        List<ImportFolderInfo> importFolderInfos = getImportFolderInfos(this.mFileMap);
        List<ImportFolderInfo> importFolderInfos2 = getImportFolderInfos(this.mFolderMap);
        int size = importFolderInfos2.size();
        toggleItemSelectedState$default(this, importFolderInfos2, selectedItemPositionList, 0, 4, null);
        toggleItemSelectedState(importFolderInfos, selectedItemPositionList, size);
    }

    public final void unregisterImportListRequest() {
        ImportFolderMode importFolderMode = this.mMode;
        Intrinsics.checkNotNull(importFolderMode);
        importFolderMode.unregisterImportListRequest();
    }

    public final void updateValidateFolderPath(@NotNull String folderName) {
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        setCurrentFolder(getBaseDisplayDirectory(DocTypeConstants.SNOTE_LOCAL, 101) + folderName);
    }

    private final int getCheckedItemCount(List<ImportFolderInfo> importFolderInfos) {
        int i = 0;
        if (importFolderInfos == null) {
            return 0;
        }
        Iterator<ImportFolderInfo> it = importFolderInfos.iterator();
        while (it.hasNext()) {
            if (it.next().getIsChecked()) {
                i++;
            }
        }
        return i;
    }
}
