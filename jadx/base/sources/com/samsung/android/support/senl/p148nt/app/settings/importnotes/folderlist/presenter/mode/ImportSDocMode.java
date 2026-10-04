package com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode;

import android.content.Intent;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.core.os.EnvironmentCompat;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.importer.ImportProcessor;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.common.utils.ImportFolderUtils;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.model.ImportFolderInfo;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode;
import com.samsung.android.support.senl.p148nt.base.common.access.sync.importer.data.ImportDocument;
import com.samsung.android.support.senl.p148nt.base.common.startmanager.ModelStartManager;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0001#B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0016J\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00152\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u0006\u0010\u001a\u001a\u00020\u0013J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\u001c\u0010\u001d\u001a\u00020\u00132\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020 \u0018\u00010\u001fJ\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0002R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportSDocMode;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode;", "presenterContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;", "modeContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode$Contract;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode$Contract;)V", "mThread", "Ljava/lang/Thread;", "appNameRes", "", "getAppNameRes", "()I", "importType", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "getImportType", "()Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "startImport", "", "importFolderInfos", "", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/model/ImportFolderInfo;", "getImportDocuments", "Lcom/samsung/android/support/senl/nt/base/common/access/sync/importer/data/ImportDocument;", "requestImportList", "requestImportListRunner", "unregisterImportListRequest", "setValidateFolderPath", "onUpdated", "fileInfo", "Lkotlin/Pair;", "", "getContainerName", "folderPath", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImportSDocMode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImportSDocMode.kt\ncom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportSDocMode\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,155:1\n739#2,9:156\n37#3:165\n36#3,3:166\n*S KotlinDebug\n*F\n+ 1 ImportSDocMode.kt\ncom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportSDocMode\n*L\n126#1:156,9\n127#1:165\n127#1:166,3\n*E\n"})
public final class ImportSDocMode extends ImportFolderMode {

    @NotNull
    private static final String TAG = "ImportSDocMode";

    @JvmField
    @Nullable
    public Thread mThread;

    public ImportSDocMode(@Nullable ImportFolderPresenterContract importFolderPresenterContract, @Nullable ImportFolderMode.Contract contract) {
        super(importFolderPresenterContract, contract);
    }

    private final String getContainerName(String folderPath) {
        List listEmptyList;
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        Regex regex = new Regex(separator);
        List<String> listSplit = regex.split(folderPath, 0);
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
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        StringBuilder sb = new StringBuilder();
        int length = strArr.length;
        StringBuilder sb2 = sb;
        boolean z = false;
        for (int i = 0; i < length; i++) {
            sb2.append(strArr[i]);
            if (i < strArr.length - 1) {
                sb2.append(File.separator);
            }
            if (z) {
                break;
            }
            if (!Intrinsics.areEqual("unknown", EnvironmentCompat.getStorageState(new File(sb2.toString())))) {
                sb2 = new StringBuilder();
                z = true;
            }
        }
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public int getAppNameRes() {
        return CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.notes_jp : C8003R.string.notes;
    }

    @NotNull
    public final List<ImportDocument> getImportDocuments(@NotNull List<ImportFolderInfo> importFolderInfos) {
        Intrinsics.checkNotNullParameter(importFolderInfos, "importFolderInfos");
        ArrayList arrayList = new ArrayList();
        for (ImportFolderInfo importFolderInfo : importFolderInfos) {
            File file = new File(AbstractC0541b.m757C(importFolderInfo.getFolderPath(), File.separator, importFolderInfo.getName()));
            if (file.exists()) {
                arrayList.add(new ImportDocument(file.getAbsolutePath(), ""));
            }
        }
        return arrayList;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    @NotNull
    public DocTypeConstants getImportType() {
        return DocTypeConstants.SDOC;
    }

    public final void onUpdated(@Nullable Pair<Integer, String> fileInfo) {
        if (fileInfo == null) {
            return;
        }
        int iIntValue = fileInfo.getFirst().intValue();
        String second = fileInfo.getSecond();
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        int iM14131E = StringsKt.m14131E(separator, 0, 6, second) + 1;
        String strSubstring = second.substring(0, iM14131E);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        if (FileUtils.INSTANCE.isAndroidDir(strSubstring)) {
            return;
        }
        String strSubstring2 = second.substring(iM14131E);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        ImportFolderMode.Contract contract = this.mModeContract;
        String strM756B = AbstractC0541b.m756B(contract != null ? contract.getBaseDisplayDirectory(DocTypeConstants.SDOC, iIntValue) : null, getContainerName(strSubstring));
        ImportFolderMode.Contract contract2 = this.mModeContract;
        if (contract2 != null) {
            contract2.addFileData(new ImportFolderInfo(2, strM756B, strSubstring, strSubstring2, new File(AbstractC0541b.m757C(strSubstring, separator, strSubstring2)).lastModified()));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public void requestImportList() {
        Thread threadNewThread = new SenlThreadFactory(TAG).newThread(new RunnableC8669a(this, 13));
        this.mThread = threadNewThread;
        if (threadNewThread != null) {
            threadNewThread.start();
        }
    }

    public final void requestImportListRunner() {
        List<Pair<Integer, String>> fileListHasSpecificExtension = ImportFolderUtils.getFileListHasSpecificExtension(".sdoc", ".sdocx");
        int size = fileListHasSpecificExtension.size();
        for (int i = 0; i < size && !Thread.interrupted(); i++) {
            onUpdated(fileListHasSpecificExtension.get(i));
        }
        ImportFolderPresenterContract importFolderPresenterContract = this.mPresenterContract;
        if (importFolderPresenterContract != null) {
            importFolderPresenterContract.updateFolderLayout();
        }
        ImportFolderPresenterContract importFolderPresenterContract2 = this.mPresenterContract;
        if (importFolderPresenterContract2 != null) {
            importFolderPresenterContract2.updateLayout();
        }
        ImportFolderPresenterContract importFolderPresenterContract3 = this.mPresenterContract;
        if (importFolderPresenterContract3 != null) {
            importFolderPresenterContract3.dismissFileDownloadingDialog();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public void setValidateFolderPath() {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public void startImport(@Nullable List<ImportFolderInfo> importFolderInfos) {
        Intent intent = new Intent();
        if (ModelStartManager.INSTANCE.isBlocked()) {
            MainLogger.m7258i(TAG, "startImport, Import is blocked");
        } else if (importFolderInfos != null) {
            List<ImportDocument> importDocuments = getImportDocuments(importFolderInfos);
            ImportProcessor.initialize(importDocuments);
            if (!importDocuments.isEmpty()) {
                intent.setAction(NotesConstants.ACTION_IMPORT_SAMSUNG_NOTES);
            }
        }
        ImportFolderPresenterContract importFolderPresenterContract = this.mPresenterContract;
        if (importFolderPresenterContract != null) {
            importFolderPresenterContract.backToNoteList(intent);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public void unregisterImportListRequest() {
        Thread thread = this.mThread;
        if (thread != null) {
            Intrinsics.checkNotNull(thread);
            boolean z = !thread.isInterrupted();
            Thread thread2 = this.mThread;
            Intrinsics.checkNotNull(thread2);
            if (z && thread2.isAlive()) {
                Thread thread3 = this.mThread;
                Intrinsics.checkNotNull(thread3);
                thread3.interrupt();
                this.mThread = null;
            }
        }
    }
}
