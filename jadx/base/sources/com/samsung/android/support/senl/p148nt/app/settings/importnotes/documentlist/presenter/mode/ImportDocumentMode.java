package com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.core.types.AbstractImportType;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.app.notes.sync.quota.C6871d;
import com.samsung.android.app.notes.sync.quota.InterfaceC6872e;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import com.samsung.android.support.senl.p148nt.app.settings.detail.C8790n;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentModeContract;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p042J1.C0145c;
import p248v0.C14497a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\bJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00198\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0013\u0010 \u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020!8&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#R\u0016\u0010(\u001a\u0004\u0018\u00010\u00198&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u001fR\u0016\u0010*\u001a\u0004\u0018\u00010\u00198&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u001fR\u0016\u0010.\u001a\u0004\u0018\u00010+8&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00060"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/mode/ImportDocumentMode;", "", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/mode/ImportDocumentModeContract$IPresenter;", "mPresenter", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/mode/ImportDocumentModeContract$IPresenter;)V", "", "onCreate", "()V", "onDestroy", "startImport", "", "hasSpinnerLayout", "()Z", "Ljava/util/ArrayList;", "Lcom/samsung/android/app/notes/sync/items/ImportItem;", "Lkotlin/collections/ArrayList;", "importItems", "Lcom/samsung/android/app/notes/sync/importing/core/types/AbstractImportType;", "getAbstractImportType", "(Ljava/util/ArrayList;)Lcom/samsung/android/app/notes/sync/importing/core/types/AbstractImportType;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/mode/ImportDocumentModeContract$IPresenter;", "Lcom/samsung/android/app/notes/sync/quota/e;", "mSyncQuotaListener", "Lcom/samsung/android/app/notes/sync/quota/e;", "", "mNoNoteText", "Ljava/lang/String;", "mAppName", "mDefaultActionBarTitle", "getDefaultActionBarTitle", "()Ljava/lang/String;", "defaultActionBarTitle", "", "getTaskType", "()I", "taskType", "getDefaultCategoryText", "defaultCategoryText", "getAppName", "appName", "getNoNoteBodyText", "noNoteBodyText", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "getImportType", "()Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "importType", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class ImportDocumentMode {

    @NotNull
    private static final String TAG = "ST$ImportDocumentMode";

    @JvmField
    @Nullable
    protected String mAppName;

    @JvmField
    @Nullable
    protected String mDefaultActionBarTitle;

    @JvmField
    @Nullable
    protected String mNoNoteText;

    @JvmField
    @NotNull
    protected final ImportDocumentModeContract.IPresenter mPresenter;

    @JvmField
    @NotNull
    protected final InterfaceC6872e mSyncQuotaListener;

    public ImportDocumentMode(@NotNull ImportDocumentModeContract.IPresenter mPresenter) {
        Intrinsics.checkNotNullParameter(mPresenter, "mPresenter");
        this.mPresenter = mPresenter;
        this.mSyncQuotaListener = new C8790n(this, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mSyncQuotaListener$lambda$2(final ImportDocumentMode importDocumentMode, int i, long j, long j2) {
        importDocumentMode.mPresenter.dismissProgressDialog();
        final double d = j / 1048576;
        MainLogger.m7258i(TAG, "Get MemoDataSize for Import : " + d + "MB");
        if (i == 0) {
            if (d < 100.0d || C0145c.m297E(BaseUtils.getApplicationContext())) {
                new Handler(Looper.getMainLooper()).post(new RunnableC8669a(importDocumentMode, 8));
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.mode.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImportDocumentMode.mSyncQuotaListener$lambda$2$lambda$0(this.f6325a, d);
                    }
                });
            }
            importDocumentMode.mPresenter.registerImportListRequest();
            return;
        }
        String str = "Fail to get data size for ImportMemo data from Account : " + i;
        MainLogger.m7255e(TAG, str);
        importDocumentMode.mPresenter.handleError(importDocumentMode.getImportType(), i, "", new Exception(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mSyncQuotaListener$lambda$2$lambda$0(ImportDocumentMode importDocumentMode, double d) {
        importDocumentMode.mPresenter.showMemoDataWarningDialog(importDocumentMode.getTaskType(), d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mSyncQuotaListener$lambda$2$lambda$1(ImportDocumentMode importDocumentMode) {
        importDocumentMode.mPresenter.showCancelDownloadingDialog();
    }

    @Nullable
    public abstract AbstractImportType getAbstractImportType(@Nullable ArrayList<ImportItem> importItems);

    @Nullable
    public abstract String getAppName();

    @Nullable
    public final String getDefaultActionBarTitle() {
        if (TextUtils.isEmpty(this.mDefaultActionBarTitle)) {
            Context applicationContext = BaseUtils.getApplicationContext();
            this.mDefaultActionBarTitle = applicationContext != null ? applicationContext.getString(C8003R.string.settings_import_data_title, getAppName()) : null;
        }
        return this.mDefaultActionBarTitle;
    }

    public abstract int getDefaultCategoryText();

    @Nullable
    public abstract DocTypeConstants getImportType();

    @Nullable
    public abstract String getNoNoteBodyText();

    public abstract int getTaskType();

    public final boolean hasSpinnerLayout() {
        return true;
    }

    public void onCreate() {
    }

    public final void onDestroy() {
        C6871d c6871dM5056b = C6871d.m5056b();
        InterfaceC6872e interfaceC6872e = this.mSyncQuotaListener;
        c6871dM5056b.getClass();
        synchronized (InterfaceC6872e.class) {
            ((ArrayList) c6871dM5056b.f4367b).remove(interfaceC6872e);
        }
    }

    public final void startImport() {
        C14497a.m15078a().m15081d(getAbstractImportType(this.mPresenter.getCheckedItems()));
    }
}
