package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.collection.AbstractC0622a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfExport;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.checkdata.CheckedNoteInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task.ShareHandler;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task.ShareTask;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportHandler;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.composer.share.ShareCallbackReceiver;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareException;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.UriHelper;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.model.collector.CollectController;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectParam;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u001a\u0018\u0000 B2\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001:\u0003@ABB;\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010#\u001a\u00020$2\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010%\u001a\u00020$H\u0016J$\u0010&\u001a\u00020$2\u001a\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0016J\u0016\u0010(\u001a\u00020$2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130)H\u0002J\u0016\u0010*\u001a\u00020$2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130)H\u0002J\u0016\u0010+\u001a\u00020$2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130)H\u0002J\u0016\u0010,\u001a\u00020$2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130)H\u0002J\u0016\u0010-\u001a\u00020$2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130)H\u0002J\u0016\u0010.\u001a\u00020$2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130)H\u0002J\b\u0010/\u001a\u00020$H\u0016J\b\u00100\u001a\u00020$H\u0016J\b\u00101\u001a\u00020$H\u0002J\u001a\u00102\u001a\u00020$2\b\u00103\u001a\u0004\u0018\u00010\u00172\u0006\u00104\u001a\u00020\bH\u0002J\b\u00105\u001a\u00020$H\u0002J\b\u00106\u001a\u00020$H\u0002J\u0010\u00107\u001a\u00020$2\u0006\u00108\u001a\u00020\nH\u0002J\b\u00109\u001a\u00020\u001bH\u0002J\b\u0010:\u001a\u00020$H\u0002J\b\u0010;\u001a\u00020$H\u0002J\b\u0010<\u001a\u00020\u001bH\u0002J\b\u0010=\u001a\u00020\u001bH\u0002J\b\u0010>\u001a\u00020\bH\u0016J\b\u0010?\u001a\u00020\u0015H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/task/ShareTask;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask;", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/model/checkdata/CheckedNoteInfo;", "Lkotlin/collections/ArrayList;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "destPath", "", Bixby2Constants.BIXBY_PARAM_SHARE_TYPE, "", "saveAsExternalStorageDir", "exportPdfType", "contract", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/task/ShareTask$Contract;", "<init>", "(Landroid/app/Activity;Ljava/lang/String;ILjava/lang/String;ILcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/task/ShareTask$Contract;)V", "shareDataList", "", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/share/ShareData;", "mResult", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/task/ShareTask$Result;", "mSpenWNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "mSpenNotePdfExport", "Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfExport;", "mIsPdfManagerExecuting", "", "mDestFileName", "mFilePath", "mContract", "mShareHandler", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/task/ShareHandler;", "mShareHandlerCallback", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/task/ShareHandler$Callback;", "setContract", "", "onPreExecute", "execute", "taskParams", "docShare", "", "pdfShare", "officeShare", "imageShare", "textOnlyShare", "zipFileSave", "onPostExecute", "cancel", "cancelTask", "closeSpenWNote", "spenWNote", "filePath", "pausePdfCollector", "resumePdfCollector", "executePdfCollectorTask", "actionType", "isTaskCancelled", "showProgress", "removeProgress", "isSupportExportPdfDialog", "isSupportSaveAsProgressDialog", "getTag", "getResult", "Contract", "Result", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ShareTask extends WorkerTask<ArrayList<CheckedNoteInfo>> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int SHARE_IMAGE = 4;
    public static final int SHARE_NONE = -1;
    public static final int SHARE_OLD_NOTE = 6;
    public static final int SHARE_PDF = 1;
    public static final int SHARE_PPT = 3;
    public static final int SHARE_SDOC = 0;
    public static final int SHARE_TEXT_ONLY = 5;
    public static final int SHARE_WORD = 2;
    public static final int SHARE_ZIP_FILE = 7;

    @NotNull
    public static final String TAG = "ShareTask";

    @NotNull
    private final Activity activity;
    private final int exportPdfType;

    @Nullable
    private Contract mContract;

    @Nullable
    private String mDestFileName;

    @Nullable
    private String mFilePath;
    private boolean mIsPdfManagerExecuting;

    @NotNull
    private final Result mResult;

    @NotNull
    private final ShareHandler mShareHandler;

    @NotNull
    private final ShareHandler.Callback mShareHandlerCallback;

    @Nullable
    private SpenNotePdfExport mSpenNotePdfExport;

    @Nullable
    private SpenWNote mSpenWNote;

    @Nullable
    private final String saveAsExternalStorageDir;

    @NotNull
    private final List<ShareData> shareDataList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/task/ShareTask$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "SHARE_NONE", "", "SHARE_SDOC", "SHARE_PDF", "SHARE_WORD", "SHARE_PPT", "SHARE_IMAGE", "SHARE_TEXT_ONLY", "SHARE_OLD_NOTE", "SHARE_ZIP_FILE", "getExtension", Bixby2Constants.BIXBY_PARAM_SHARE_TYPE, "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getExtension(int shareType) {
            return shareType != 0 ? shareType != 1 ? shareType != 2 ? shareType != 3 ? shareType != 4 ? shareType != 5 ? "" : com.samsung.android.support.senl.p148nt.base.common.constants.Constants.TEXT_EXTENSION : "jpg" : com.samsung.android.support.senl.p148nt.base.common.constants.Constants.PPT_EXTENSION : com.samsung.android.support.senl.p148nt.base.common.constants.Constants.DOC_EXTENSION : com.samsung.android.support.senl.p148nt.base.common.constants.Constants.PDF_EXTENSION : "sdocx";
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/task/ShareTask$Contract;", "", "showExportPdfDialog", "", "removeExportPdfDialog", "updateExportPdfDialogNoteName", "exportingNoteName", "", "updateExportPdfDialogProgress", ImportHandler.KEY_TOTAL, "", "finished", "showSaveAsProgressDialog", "removeSaveAsProgressDialog", "showCircleProgressDialog", "removeCircleProgressDialog", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void removeCircleProgressDialog();

        void removeExportPdfDialog();

        void removeSaveAsProgressDialog();

        void showCircleProgressDialog();

        void showExportPdfDialog();

        void showSaveAsProgressDialog();

        void updateExportPdfDialogNoteName(@Nullable String exportingNoteName);

        void updateExportPdfDialogProgress(int total, int finished);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020&R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\u0005R\u001a\u0010\u0019\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\u0005R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\"\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u001e\u0010#\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001e¨\u0006("}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/task/ShareTask$Result;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Result;", "hashCode", "", "<init>", "(I)V", "getHashCode", "()I", "tag", "", "getTag", "()Ljava/lang/String;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "exportedFileName", "getExportedFileName", "setExportedFileName", "(Ljava/lang/String;)V", Bixby2Constants.BIXBY_PARAM_SHARE_TYPE, "getShareType", "setShareType", "exportedItemCount", "getExportedItemCount", "setExportedItemCount", "isShare", "", "()Z", "setShare", "(Z)V", "value", "isCancelled", "storageExceed", "getStorageExceed", "setCancelled", "", "setStorageExceed", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Result implements WorkerTask.Result {

        @Nullable
        private String exportedFileName;
        private int exportedItemCount;
        private final int hashCode;

        @Nullable
        private Intent intent;
        private boolean isCancelled;
        private boolean isShare;
        private int shareType;
        private boolean storageExceed;

        public Result(int i) {
            this.hashCode = i;
        }

        @Nullable
        public final String getExportedFileName() {
            return this.exportedFileName;
        }

        public final int getExportedItemCount() {
            return this.exportedItemCount;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
        public int getHashCode() {
            return this.hashCode;
        }

        @Nullable
        public final Intent getIntent() {
            return this.intent;
        }

        public final int getShareType() {
            return this.shareType;
        }

        public final boolean getStorageExceed() {
            return this.storageExceed;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
        @NotNull
        public String getTag() {
            return ShareTask.TAG;
        }

        /* JADX INFO: renamed from: isCancelled, reason: from getter */
        public final boolean getIsCancelled() {
            return this.isCancelled;
        }

        /* JADX INFO: renamed from: isShare, reason: from getter */
        public final boolean getIsShare() {
            return this.isShare;
        }

        public final void setCancelled() {
            this.isCancelled = true;
        }

        public final void setExportedFileName(@Nullable String str) {
            this.exportedFileName = str;
        }

        public final void setExportedItemCount(int i) {
            this.exportedItemCount = i;
        }

        public final void setIntent(@Nullable Intent intent) {
            this.intent = intent;
        }

        public final void setShare(boolean z) {
            this.isShare = z;
        }

        public final void setShareType(int i) {
            this.shareType = i;
        }

        public final void setStorageExceed() {
            this.storageExceed = true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareTask(@NotNull Activity activity, @Nullable String str, int i, @Nullable String str2, int i2, @NotNull Contract contract) {
        super(activity.hashCode(), null, 2, null);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.activity = activity;
        this.saveAsExternalStorageDir = str2;
        this.exportPdfType = i2;
        this.shareDataList = new ArrayList();
        Result result = new Result(getHashCode());
        this.mResult = result;
        ShareHandler shareHandler = new ShareHandler();
        this.mShareHandler = shareHandler;
        this.mShareHandlerCallback = new ShareHandler.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.task.ShareTask$mShareHandlerCallback$1
            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.task.ShareHandler.Callback
            public void onProgressMakePdf(int total, int finished) {
                MainLogger.m7254d(ShareTask.TAG, AbstractC0622a.m1164j(finished, total, "onProgressMakePdf, finished / total -> [", " / ", "]"));
                ShareTask.Contract contract2 = this.this$0.mContract;
                if (contract2 != null) {
                    contract2.updateExportPdfDialogProgress(total, finished);
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.task.ShareHandler.Callback
            public void onStartMakePdf(String noteFileName) {
                Intrinsics.checkNotNullParameter(noteFileName, "noteFileName");
                MainLogger.m7254d(ShareTask.TAG, "onStartMakePdf -> [" + MainLogger.getEncode(noteFileName) + "]");
                ShareTask.Contract contract2 = this.this$0.mContract;
                if (contract2 != null) {
                    contract2.updateExportPdfDialogNoteName(noteFileName);
                }
            }
        };
        shareHandler.setRenamedFilePath(str);
        result.setShareType(i);
        result.setShare(TextUtils.isEmpty(str2));
        setContract(contract);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelTask() {
        String str;
        SpenWNote spenWNote = this.mSpenWNote;
        if (spenWNote != null && (str = this.mFilePath) != null) {
            Intrinsics.checkNotNull(str);
            closeSpenWNote(spenWNote, str);
        }
        removeProgress();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void closeSpenWNote(SpenWNote spenWNote, String filePath) {
        try {
            try {
                DocumentFileManager.getInstance().close(filePath, spenWNote, true);
            } catch (IOException e) {
                MainLogger.m7256e(TAG, "closeSpenWNote : " + e.getMessage(), e);
            }
        } finally {
            this.mSpenWNote = null;
            this.mFilePath = null;
        }
    }

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
    private final void docShare(List<? extends ShareData> shareDataList) {
        try {
            String strMakeSDoc = "";
            int i = 0;
            if (this.mResult.getIsShare()) {
                Result result = this.mResult;
                result.setIntent(this.mShareHandler.shareSDoc((Context) this.activity, (List<ShareData>) shareDataList, ShareCallbackReceiver.ShareCaller.MemoList, result.getShareType() == 6));
            } else {
                for (ShareData shareData : shareDataList) {
                    if (isTaskCancelled()) {
                        break;
                    }
                    strMakeSDoc = this.mShareHandler.getMakeUriHelper().makeSDoc(this.activity, shareData, this.mShareHandler.generateNewFilePath(this.saveAsExternalStorageDir, shareData.getTitle(), shareData.getLastModifiedTime(), "sdocx"));
                    i += !TextUtils.isEmpty(strMakeSDoc) ? 1 : 0;
                }
                this.mResult.setIntent(new Intent());
                if (shareDataList.size() <= 1) {
                    Result result2 = this.mResult;
                    Intrinsics.checkNotNull(strMakeSDoc);
                    result2.setExportedFileName(FileUtils.getFileNameFromFilePath(strMakeSDoc));
                }
                this.mResult.setExportedItemCount(i);
            }
        } catch (Exception e) {
            AbstractC6670b.m4738C("SHARE_DOC : ", e.getMessage(), TAG);
        }
        AbstractC6670b.m4739D("SHARE_DOC# isShare : ", TAG, this.mResult.getIsShare());
    }

    private final void executePdfCollectorTask(int actionType) {
        CollectController.getInstance().postCollectorTask(new CollectParam.CollectParamBuilder().setPdfActionKey(TAG).setPdfActionCaller(ShareTask.class).setActionType(actionType).build());
    }

    private final void imageShare(List<? extends ShareData> shareDataList) {
        try {
            if (!this.mResult.getIsShare()) {
                int i = 0;
                for (ShareData shareData : shareDataList) {
                    boolean zIsCoeditUuid = UUIDUtils.isCoeditUuid(shareData.getUuid());
                    Activity activity = this.activity;
                    String path = shareData.getPath();
                    Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                    SpenWNote spenWNote = NotesUtils.getSpenWNote(activity, path, zIsCoeditUuid);
                    if (spenWNote != null) {
                        this.mSpenWNote = spenWNote;
                        this.mFilePath = shareData.getPath();
                        String strGenerateNewFilePath = this.mShareHandler.generateNewFilePath(this.saveAsExternalStorageDir, shareData.getTitle(), shareData.getLastModifiedTime(), "jpg");
                        if (shareDataList.size() <= 1) {
                            ArrayList<String> arrayListMakeImage = this.mShareHandler.getMakeUriHelper().makeImage(this.activity, spenWNote, strGenerateNewFilePath);
                            if (arrayListMakeImage.size() == 1) {
                                Result result = this.mResult;
                                String str = arrayListMakeImage.get(0);
                                Intrinsics.checkNotNullExpressionValue(str, "get(...)");
                                result.setExportedFileName(FileUtils.getFileNameFromFilePath(str));
                            }
                            this.mResult.setExportedItemCount(arrayListMakeImage.size());
                            String path2 = shareData.getPath();
                            Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
                            closeSpenWNote(spenWNote, path2);
                            return;
                        }
                        ArrayList<String> arrayListMakeImage2 = this.mShareHandler.getMakeUriHelper().makeImage(this.activity, spenWNote, strGenerateNewFilePath, false);
                        String strGenerateNewFilePath2 = this.mShareHandler.generateNewFilePath(this.saveAsExternalStorageDir, shareData.getTitle(), shareData.getLastModifiedTime(), "zip");
                        this.mShareHandler.zip(arrayListMakeImage2, strGenerateNewFilePath2);
                        this.mShareHandler.deleteFile(arrayListMakeImage2);
                        i += !arrayListMakeImage2.isEmpty() ? 1 : 0;
                        UriHelper.requestScanFile(this.activity, strGenerateNewFilePath2, com.samsung.android.support.senl.p148nt.base.common.constants.Constants.MIME_ZIP);
                        String path3 = shareData.getPath();
                        Intrinsics.checkNotNullExpressionValue(path3, "getPath(...)");
                        closeSpenWNote(spenWNote, path3);
                    }
                }
                this.mResult.setExportedItemCount(i);
            } else if (shareDataList.size() == 1) {
                ShareData shareData2 = shareDataList.get(0);
                boolean zIsCoeditUuid2 = UUIDUtils.isCoeditUuid(shareData2.getUuid());
                Activity activity2 = this.activity;
                String path4 = shareData2.getPath();
                Intrinsics.checkNotNullExpressionValue(path4, "getPath(...)");
                SpenWNote spenWNote2 = NotesUtils.getSpenWNote(activity2, path4, zIsCoeditUuid2);
                if (spenWNote2 == null) {
                    return;
                }
                this.mSpenWNote = spenWNote2;
                this.mFilePath = shareData2.getPath();
                this.mShareHandler.shareImage(this.activity, spenWNote2, shareData2);
                String path5 = shareData2.getPath();
                Intrinsics.checkNotNullExpressionValue(path5, "getPath(...)");
                closeSpenWNote(spenWNote2, path5);
            } else {
                this.mShareHandler.makeShareImageList(this.activity, shareDataList);
            }
        } catch (Exception e) {
            AbstractC6670b.m4738C("SHARE_IMAGE : ", e.getMessage(), TAG);
        }
        AbstractC6670b.m4739D("SHARE_IMAGE# share : ", TAG, this.mResult.getIsShare());
    }

    private final boolean isSupportExportPdfDialog() {
        return this.mResult.getShareType() == 1;
    }

    private final boolean isSupportSaveAsProgressDialog() {
        return (this.mResult.getShareType() == 1 || this.mResult.getIsShare()) ? false : true;
    }

    private final boolean isTaskCancelled() {
        return this.mResult.getIsCancelled() || isCancelled();
    }

    private final void officeShare(List<? extends ShareData> shareDataList) {
        try {
            int shareType = this.mResult.getShareType();
            if (this.mResult.getIsShare()) {
                this.mShareHandler.shareOfficeFile(this.activity, shareType, shareDataList);
            } else {
                String strMakeMsWord = "";
                int i = 0;
                for (ShareData shareData : shareDataList) {
                    SpenWNote spenWNoteForExportOffice = NotesUtils.getSpenWNoteForExportOffice(this.activity, shareData.getPath(), UUIDUtils.isCoeditUuid(shareData.getUuid()));
                    if (spenWNoteForExportOffice != null) {
                        this.mSpenWNote = spenWNoteForExportOffice;
                        this.mFilePath = shareData.getPath();
                        String strGenerateNewFilePath = this.mShareHandler.generateNewFilePath(this.saveAsExternalStorageDir, shareData.getTitle(), shareData.getLastModifiedTime(), com.samsung.android.support.senl.p148nt.base.common.constants.Constants.PPT_EXTENSION);
                        if (shareType == 2) {
                            strMakeMsWord = this.mShareHandler.getMakeUriHelper().makeMsWord(this.activity, spenWNoteForExportOffice, shareData.getPath(), strGenerateNewFilePath);
                        } else if (shareType == 3) {
                            strMakeMsWord = this.mShareHandler.getMakeUriHelper().makeMsPPT(this.activity, spenWNoteForExportOffice, shareData.getPath(), strGenerateNewFilePath);
                        }
                        i += 1 ^ (TextUtils.isEmpty(strMakeMsWord) ? 1 : 0);
                        String path = shareData.getPath();
                        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                        closeSpenWNote(spenWNoteForExportOffice, path);
                    }
                }
                if (!TextUtils.isEmpty(strMakeMsWord) && shareDataList.size() <= 1) {
                    Result result = this.mResult;
                    Intrinsics.checkNotNull(strMakeMsWord);
                    result.setExportedFileName(FileUtils.getFileNameFromFilePath(strMakeMsWord));
                }
                this.mResult.setExportedItemCount(i);
            }
        } catch (Exception e) {
            AbstractC6670b.m4738C("SHARE_OFFICE : ", e.getMessage(), TAG);
        }
        AbstractC6670b.m4739D("SHARE_OFFICE# share : ", TAG, this.mResult.getIsShare());
    }

    private final void pausePdfCollector() {
        executePdfCollectorTask(ICollectParam.ActionType.PAUSE_PDF.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void pdfShare(List<? extends ShareData> shareDataList) throws Throwable {
        List<? extends ShareData> list;
        String str;
        int size;
        StringBuilder sb;
        int size2;
        try {
            CommonUtil.initSpenSdk(this.activity);
            pausePdfCollector();
            this.mSpenNotePdfExport = new SpenNotePdfExport(this.activity, this.exportPdfType);
            this.mIsPdfManagerExecuting = true;
            if (this.mResult.getIsShare()) {
                size2 = this.mShareHandler.sharePdf(this.activity, this.mSpenNotePdfExport, shareDataList, this.mShareHandlerCallback);
                list = shareDataList;
            } else {
                list = shareDataList;
                try {
                    try {
                        ArrayList<String> arrayListMakePDFFiles = this.mShareHandler.makePDFFiles(this.activity, this.mSpenNotePdfExport, list, this.saveAsExternalStorageDir, this.mShareHandlerCallback);
                        Intrinsics.checkNotNull(arrayListMakePDFFiles);
                        if (!arrayListMakePDFFiles.isEmpty()) {
                            Result result = this.mResult;
                            String str2 = arrayListMakePDFFiles.get(0);
                            Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
                            result.setExportedFileName(FileUtils.getFileNameFromFilePath(str2));
                        }
                        size2 = arrayListMakePDFFiles.size();
                    } catch (ShareException e) {
                        e = e;
                        MainLogger.m7255e(TAG, "SHARE_PDF : " + e.getMessage());
                        this.mIsPdfManagerExecuting = false;
                        str = this.mResult.getIsShare() ? "share " : "save as ";
                        size = list.size();
                        sb = new StringBuilder("SHARE_PDF# ");
                    }
                } catch (Throwable th) {
                    th = th;
                    this.mIsPdfManagerExecuting = false;
                    str = this.mResult.getIsShare() ? "share " : "save as ";
                    MainLogger.m7258i(TAG, "SHARE_PDF# " + str + list.size());
                    throw th;
                }
            }
            this.mResult.setExportedItemCount(size2);
            resumePdfCollector();
            this.mIsPdfManagerExecuting = false;
            str = this.mResult.getIsShare() ? "share " : "save as ";
            size = list.size();
            sb = new StringBuilder("SHARE_PDF# ");
        } catch (ShareException e2) {
            e = e2;
            list = shareDataList;
        } catch (Throwable th2) {
            th = th2;
            list = shareDataList;
            this.mIsPdfManagerExecuting = false;
            if (this.mResult.getIsShare()) {
            }
            MainLogger.m7258i(TAG, "SHARE_PDF# " + str + list.size());
            throw th;
        }
        sb.append(str);
        sb.append(size);
        MainLogger.m7258i(TAG, sb.toString());
    }

    private final void removeProgress() {
        if (this.mContract == null) {
            return;
        }
        if (isSupportExportPdfDialog()) {
            Contract contract = this.mContract;
            Intrinsics.checkNotNull(contract);
            contract.removeExportPdfDialog();
        } else if (isSupportSaveAsProgressDialog()) {
            Contract contract2 = this.mContract;
            Intrinsics.checkNotNull(contract2);
            contract2.removeSaveAsProgressDialog();
        } else {
            Contract contract3 = this.mContract;
            Intrinsics.checkNotNull(contract3);
            contract3.removeCircleProgressDialog();
        }
    }

    private final void resumePdfCollector() {
        executePdfCollectorTask(ICollectParam.ActionType.RESUME_PDF.getValue());
    }

    private final void showProgress() {
        if (this.mContract == null) {
            return;
        }
        if (isSupportExportPdfDialog()) {
            Contract contract = this.mContract;
            Intrinsics.checkNotNull(contract);
            contract.showExportPdfDialog();
        } else if (isSupportSaveAsProgressDialog()) {
            Contract contract2 = this.mContract;
            Intrinsics.checkNotNull(contract2);
            contract2.showSaveAsProgressDialog();
        } else {
            Contract contract3 = this.mContract;
            Intrinsics.checkNotNull(contract3);
            contract3.showCircleProgressDialog();
        }
    }

    private final void textOnlyShare(List<? extends ShareData> shareDataList) {
        try {
            int i = 0;
            if (!this.mResult.getIsShare()) {
                this.mResult.setIntent(new Intent());
                String strMakeText = "";
                for (ShareData shareData : shareDataList) {
                    boolean zIsCoeditUuid = UUIDUtils.isCoeditUuid(shareData.getUuid());
                    Activity activity = this.activity;
                    String path = shareData.getPath();
                    Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                    SpenWNote spenWNote = NotesUtils.getSpenWNote(activity, path, zIsCoeditUuid);
                    if (spenWNote != null) {
                        this.mSpenWNote = spenWNote;
                        this.mFilePath = shareData.getPath();
                        strMakeText = this.mShareHandler.getMakeUriHelper().makeText(this.activity, spenWNote, this.mShareHandler.generateNewFilePath(this.saveAsExternalStorageDir, shareData.getTitle(), shareData.getLastModifiedTime(), com.samsung.android.support.senl.p148nt.base.common.constants.Constants.TEXT_EXTENSION));
                        i += !TextUtils.isEmpty(strMakeText) ? 1 : 0;
                        String path2 = shareData.getPath();
                        Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
                        closeSpenWNote(spenWNote, path2);
                    }
                }
                if (shareDataList.size() <= 1) {
                    Result result = this.mResult;
                    Intrinsics.checkNotNull(strMakeText);
                    result.setExportedFileName(FileUtils.getFileNameFromFilePath(strMakeText));
                }
                this.mResult.setExportedItemCount(i);
            } else if (shareDataList.size() <= 1) {
                ShareData shareData2 = shareDataList.get(0);
                boolean zIsCoeditUuid2 = UUIDUtils.isCoeditUuid(shareData2.getUuid());
                Activity activity2 = this.activity;
                String path3 = shareData2.getPath();
                Intrinsics.checkNotNullExpressionValue(path3, "getPath(...)");
                SpenWNote spenWNote2 = NotesUtils.getSpenWNote(activity2, path3, zIsCoeditUuid2);
                if (spenWNote2 == null) {
                    return;
                }
                this.mSpenWNote = spenWNote2;
                this.mFilePath = shareData2.getPath();
                this.mResult.setIntent(this.mShareHandler.createIntentToShareText(this.activity, spenWNote2, shareData2.getTitle()));
                String path4 = shareData2.getPath();
                Intrinsics.checkNotNullExpressionValue(path4, "getPath(...)");
                closeSpenWNote(spenWNote2, path4);
            } else {
                this.mShareHandler.makeShareTextList(this.activity, shareDataList);
                this.mResult.setIntent(new Intent());
            }
        } catch (Exception e) {
            AbstractC6670b.m4738C("SHARE_TEXT_ONLY : ", e.getMessage(), TAG);
        }
        AbstractC6670b.m4739D("SHARE_TEXT_ONLY# share : ", TAG, this.mResult.getIsShare());
    }

    private final void zipFileSave(List<? extends ShareData> shareDataList) {
        this.mDestFileName = null;
        if (shareDataList.size() > 1) {
            return;
        }
        MainLogger.m7258i(TAG, "zipFileSave#");
        ShareData shareData = shareDataList.get(0);
        String destPath = this.mShareHandler.getDestPath();
        Intrinsics.checkNotNull(destPath);
        String strSubstring = destPath.substring(0, destPath.length() - 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        try {
            File file = new File(shareData.getPath());
            File file2 = new File(strSubstring);
            String path = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
            String path2 = file2.getPath();
            Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
            FileUtils.zip(path, path2);
            this.mDestFileName = file2.getName() + com.samsung.android.support.senl.p148nt.base.common.constants.Constants.ZIP_EXTENSION_WITH_DOT;
        } catch (Exception e) {
            AbstractC6670b.m4738C("zipFileSave : ", e.getMessage(), TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    public void cancel() {
        super.cancel();
        this.mResult.setCancelled();
        this.mShareHandler.cancel();
        SpenNotePdfExport spenNotePdfExport = this.mSpenNotePdfExport;
        if (spenNotePdfExport == null) {
            cancelTask();
            return;
        }
        Intrinsics.checkNotNull(spenNotePdfExport);
        spenNotePdfExport.cancelExportFile();
        resumePdfCollector();
        Looper looperMyLooper = Looper.myLooper();
        Intrinsics.checkNotNull(looperMyLooper);
        final Handler handler = new Handler(looperMyLooper);
        handler.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.task.ShareTask.cancel.1
            private int count;

            public final int getCount() {
                return this.count;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i = this.count;
                this.count = i + 1;
                AbstractC8014b.m7201c(i, "onCancelled# sleep count : ", ShareTask.TAG);
                if (this.count > 50) {
                    ShareTask.this.cancelTask();
                    return;
                }
                if (ShareTask.this.mIsPdfManagerExecuting) {
                    handler.postDelayed(this, 100L);
                    return;
                }
                SpenNotePdfExport spenNotePdfExport2 = ShareTask.this.mSpenNotePdfExport;
                Intrinsics.checkNotNull(spenNotePdfExport2);
                spenNotePdfExport2.close();
                ShareTask.this.cancelTask();
            }

            public final void setCount(int i) {
                this.count = i;
            }
        }, 100L);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    public void onPostExecute() {
        super.onPostExecute();
        AbstractC8014b.m7209k("onPostExecute# tag ", this.mResult.getTag(), TAG);
        SpenNotePdfExport spenNotePdfExport = this.mSpenNotePdfExport;
        if (spenNotePdfExport != null) {
            Intrinsics.checkNotNull(spenNotePdfExport);
            spenNotePdfExport.close();
        }
        if (this.activity.isFinishing()) {
            return;
        }
        removeProgress();
        int shareType = this.mResult.getShareType();
        if (shareType != 0 && shareType != 5 && shareType != 6) {
            if (shareType != 7) {
                return;
            }
            if (TextUtils.isEmpty(this.mDestFileName)) {
                if (this.mResult.getStorageExceed()) {
                    ToastHandler.show(this.activity, C8003R.string.not_enough_space, 0);
                    return;
                }
                return;
            } else {
                Activity activity = this.activity;
                ToastHandler.showEncodingLog(activity, activity.getResources().getString(C8003R.string.save_as_file_saved, this.mDestFileName), 0);
                this.mDestFileName = null;
                return;
            }
        }
        if (this.mResult.getIntent() == null) {
            ToastHandler.show(this.activity, C8003R.string.unable_to_open_note, 0);
            return;
        }
        Intent intent = this.mResult.getIntent();
        Intrinsics.checkNotNull(intent);
        if (Intrinsics.areEqual("android.intent.action.VIEW", intent.getAction())) {
            ToastHandler.show(this.activity, C8003R.string.share_no_text, 1);
            return;
        }
        if (!this.mResult.getStorageExceed()) {
            this.mShareHandler.startChooserActivity(this.activity, this.mResult.getIntent());
            return;
        }
        if (this.saveAsExternalStorageDir == null) {
            Activity activity2 = this.activity;
            String string = activity2.getString(C8003R.string.not_enough_space_content, activity2.getString(C8003R.string.action_share));
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            DialogUtils.showNotEnoughStorageDialog(this.activity, string, null);
            return;
        }
        Activity activity3 = this.activity;
        String string2 = activity3.getString(C8003R.string.not_enough_space_content, activity3.getString(C8003R.string.composer_save_to_device));
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        DialogUtils.showNotEnoughStorageDialog(this.activity, string2, null);
        this.mShareHandler.startChooserActivity(this.activity, this.mResult.getIntent());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    public void onPreExecute() {
        super.onPreExecute();
        showProgress();
    }

    public final void setContract(@NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.mContract = contract;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    public void execute(@Nullable ArrayList<CheckedNoteInfo> taskParams) throws Throwable {
        if (taskParams == null || taskParams.isEmpty() || isTaskCancelled()) {
            return;
        }
        this.shareDataList.clear();
        ArrayList arrayList = new ArrayList();
        Iterator<CheckedNoteInfo> it = taskParams.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        int i = 0;
        while (it.hasNext()) {
            CheckedNoteInfo next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            CheckedNoteInfo checkedNoteInfo = next;
            if (TextUtils.isEmpty(checkedNoteInfo.getFilePath()) || !new File(checkedNoteInfo.getFilePath()).exists()) {
                i++;
            } else {
                String filePath = checkedNoteInfo.getFilePath();
                Intrinsics.checkNotNullExpressionValue(filePath, "getFilePath(...)");
                String uuid = checkedNoteInfo.getUuid();
                Intrinsics.checkNotNullExpressionValue(uuid, "getUuid(...)");
                String title = checkedNoteInfo.getTitle();
                Intrinsics.checkNotNullExpressionValue(title, "getTitle(...)");
                StorageUtils.GetSizeOfSDocShareTask getSizeOfSDocShareTask = new StorageUtils.GetSizeOfSDocShareTask(filePath, uuid, title, String.valueOf(checkedNoteInfo.getCreatedTime()), String.valueOf(checkedNoteInfo.getModifiedTime()));
                getSizeOfSDocShareTask.fork();
                arrayList.add(getSizeOfSDocShareTask);
            }
        }
        MainLogger.m7258i(TAG, "Empty Fail case count : " + i);
        Iterator it2 = arrayList.iterator();
        long jLongValue = 0;
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            StorageUtils.GetSizeOfSDocShareTask getSizeOfSDocShareTask2 = (StorageUtils.GetSizeOfSDocShareTask) it2.next();
            if (isTaskCancelled()) {
                MainLogger.m7258i(TAG, "Task is cancelled");
                break;
            }
            Long lJoin = getSizeOfSDocShareTask2.join();
            Intrinsics.checkNotNullExpressionValue(lJoin, "join(...)");
            jLongValue += lJoin.longValue();
            if (!StorageUtils.isAvailableMemoryForShare(((long) 4) * jLongValue)) {
                AbstractC8014b.m7209k("There is no storage to share. ", getSizeOfSDocShareTask2.filePath, TAG);
                this.mResult.setStorageExceed();
                break;
            }
            this.shareDataList.add(new ShareData(getSizeOfSDocShareTask2.filePath, getSizeOfSDocShareTask2.uuid, getSizeOfSDocShareTask2.title, Long.parseLong(getSizeOfSDocShareTask2.createdAt), Long.parseLong(getSizeOfSDocShareTask2.lastModifiedAt), ""));
        }
        if (this.shareDataList.isEmpty()) {
            return;
        }
        int shareType = this.mResult.getShareType();
        AbstractC8014b.m7200b(this.shareDataList.size(), shareType, "shareDataList size : ", ", shareType : ", TAG);
        switch (shareType) {
            case 0:
            case 6:
                docShare(this.shareDataList);
                break;
            case 1:
                pdfShare(this.shareDataList);
                break;
            case 2:
            case 3:
                officeShare(this.shareDataList);
                break;
            case 4:
                imageShare(this.shareDataList);
                break;
            case 5:
                textOnlyShare(this.shareDataList);
                break;
            case 7:
                zipFileSave(this.shareDataList);
                break;
            default:
                AbstractC8014b.m7201c(shareType, "unexpected shareType: ", TAG);
                break;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    /* JADX INFO: renamed from: getResult, reason: from getter */
    public Result getMResult() {
        return this.mResult;
    }
}
