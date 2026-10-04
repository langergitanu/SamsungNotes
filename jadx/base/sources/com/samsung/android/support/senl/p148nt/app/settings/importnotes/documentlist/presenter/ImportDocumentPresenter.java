package com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.widget.ListView;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.controllers.C6756e;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.importing.core.types.BasicImportHelperAdapter;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.ImportPresenterContract;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportHandler;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportRequestListener;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.adapter.ImportCategorySpinnerAdapter;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.adapter.ImportDocumentAdapterContract;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.adapter.ImportDocumentRecyclerViewAdapter;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.adapter.holder.ImportDocumentRecyclerViewHolder;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.model.ImportDocumentModel;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.ImportDocumentPresenterContract;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.ImportDocumentResultContract;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentMode;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentModeContract;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportMemoLocalMode;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportMemoSCloudMode;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportScrapbookMode;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p042J1.C0145c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 p2\u00020\u0001:\u0001pB/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0010J\r\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0010J\r\u0010\u0014\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0010J\r\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0010J\u001f\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010#\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u000e¢\u0006\u0004\b%\u0010\u0010J)\u0010)\u001a\u00020\u00182\u001a\u0010(\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010&j\n\u0012\u0004\u0012\u00020!\u0018\u0001`'¢\u0006\u0004\b)\u0010*J\u0015\u0010,\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020!¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010+\u001a\u00020!¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020!¢\u0006\u0004\b1\u00102J\u0019\u00105\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u000103H\u0016¢\u0006\u0004\b5\u00106J\u0019\u00107\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020\u000e¢\u0006\u0004\b9\u0010\u0010J\u000f\u0010:\u001a\u00020\u000eH\u0016¢\u0006\u0004\b:\u0010\u0010J\r\u0010;\u001a\u00020\u0018¢\u0006\u0004\b;\u0010<J\u001f\u0010?\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010>\u001a\u00020=H\u0002¢\u0006\u0004\b?\u0010@R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010AR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010BR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010CR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010DR\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010I\u001a\u0004\u0018\u00010H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010O\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\"\u0010Q\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bQ\u0010<\"\u0004\bS\u0010\u001eR\u0018\u0010U\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u00102R\u0011\u0010Z\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\bY\u00102R\u0013\u0010]\u001a\u0004\u0018\u00010\u001f8F¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0011\u0010_\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b^\u00102R\u0011\u0010a\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b`\u00102R\u0011\u0010c\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\bb\u00102R\u0013\u0010e\u001a\u0004\u0018\u00010\u001f8F¢\u0006\u0006\u001a\u0004\bd\u0010\\R\u0013\u0010g\u001a\u0004\u0018\u00010\u001f8F¢\u0006\u0006\u001a\u0004\bf\u0010\\R\u0013\u0010i\u001a\u0004\u0018\u00010\u001f8F¢\u0006\u0006\u001a\u0004\bh\u0010\\R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\bj\u0010kR$\u0010o\u001a\u0012\u0012\u0004\u0012\u00020l0&j\b\u0012\u0004\u0012\u00020l`'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bm\u0010n¨\u0006q"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentPresenter;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentResultContract$IPresenter;", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "importType", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentPresenterContract$IView;", "mView", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentPresenterContract$IListPopupWindow;", "mSpinnerPopupMenu", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentPresenterContract$IDialog;", "mDialog", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/ImportPresenterContract$IRecyclerView;", "mRecyclerView", "<init>", "(Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentPresenterContract$IView;Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentPresenterContract$IListPopupWindow;Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentPresenterContract$IDialog;Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/ImportPresenterContract$IRecyclerView;)V", "", "onCreate", "()V", "initDialog", "onDestroy", "startImport", "initRecyclerView", "initializeSpinnerAdapter", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/adapter/holder/ImportDocumentRecyclerViewHolder;", "holder", "", Bixby2Constants.BIXBY_PARAM_CHECK, "setCheckItem", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/adapter/holder/ImportDocumentRecyclerViewHolder;Z)V", "checked", "setAllItemChecked", "(Z)V", "", "category", "", "type", "setSelectedCategory", "(Ljava/lang/String;I)V", "notifyDataSetChanged", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "selectedItemPosition", "toggleRecyclerViewSelectState", "(Ljava/util/ArrayList;)Z", "position", "getCategorySpinnerTitle", "(I)Ljava/lang/String;", "", "getCategorySpinnerItem", "(I)Ljava/lang/Object;", "measureCategorySpinnerContentWidth", "()I", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/model/ImportDocumentModel;", "item", "addRecyclerViewItem", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/model/ImportDocumentModel;)V", "addCategorySpinnerItem", "(Ljava/lang/String;)V", "registerImportListRequest", "unregisterImportListRequest", "hasSpinnerLayout", "()Z", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/mode/ImportDocumentModeContract$IPresenter;", "presenter", "initMode", "(Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/mode/ImportDocumentModeContract$IPresenter;)V", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentPresenterContract$IView;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentPresenterContract$IListPopupWindow;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentPresenterContract$IDialog;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/ImportPresenterContract$IRecyclerView;", "Lcom/samsung/android/app/notes/sync/importing/core/tasks/ImportBaseTask$Listener;", "mImportDocumentListener", "Lcom/samsung/android/app/notes/sync/importing/core/tasks/ImportBaseTask$Listener;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/adapter/ImportDocumentRecyclerViewAdapter;", "mAdapter", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/adapter/ImportDocumentRecyclerViewAdapter;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/adapter/ImportCategorySpinnerAdapter;", "mCategorySpinnerAdapter", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/adapter/ImportCategorySpinnerAdapter;", "Lcom/samsung/android/app/notes/sync/importing/controllers/e;", "mImportListRequest", "Lcom/samsung/android/app/notes/sync/importing/controllers/e;", "isCancelDownloadingEnded", "Z", "setCancelDownloadingEnded", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/mode/ImportDocumentMode;", "mMode", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/mode/ImportDocumentMode;", "getItemCount", "itemCount", "getCheckedItemCount", "checkedItemCount", "getSelectedCategory", "()Ljava/lang/String;", "selectedCategory", "getSelectedCategoryType", "selectedCategoryType", "getCategorySpinnerCount", "categorySpinnerCount", "getDefaultCategoryText", "defaultCategoryText", "getAppName", "appName", "getDefaultActionBarTitle", "defaultActionBarTitle", "getNoNoteBodyText", "noNoteBodyText", "getImportType", "()Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "Lcom/samsung/android/app/notes/sync/items/ImportItem;", "getRecyclerViewCheckedItems", "()Ljava/util/ArrayList;", "recyclerViewCheckedItems", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImportDocumentPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImportDocumentPresenter.kt\ncom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentPresenter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,349:1\n1#2:350\n*E\n"})
public final class ImportDocumentPresenter implements ImportDocumentResultContract.IPresenter {
    private static final int DELAY_IMPORT_LIST_REQUEST = 500;

    @NotNull
    private static final String TAG = "ST$ImportDocumentPresenter";
    private boolean isCancelDownloadingEnded;

    @Nullable
    private final ImportDocumentRecyclerViewAdapter mAdapter;

    @Nullable
    private ImportCategorySpinnerAdapter mCategorySpinnerAdapter;

    @NotNull
    private final ImportDocumentPresenterContract.IDialog mDialog;

    @NotNull
    private final ImportBaseTask.Listener mImportDocumentListener;

    @Nullable
    private C6756e mImportListRequest;

    @Nullable
    private ImportDocumentMode mMode;

    @NotNull
    private final ImportPresenterContract.IRecyclerView mRecyclerView;

    @NotNull
    private final ImportDocumentPresenterContract.IListPopupWindow mSpinnerPopupMenu;

    @NotNull
    private final ImportDocumentPresenterContract.IView mView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DocTypeConstants.values().length];
            try {
                iArr[DocTypeConstants.MEMO_LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DocTypeConstants.MEMO_SCLOUD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DocTypeConstants.SCRAPBOOK_SCLOUD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ImportDocumentPresenter(@NotNull DocTypeConstants importType, @NotNull ImportDocumentPresenterContract.IView mView, @NotNull ImportDocumentPresenterContract.IListPopupWindow mSpinnerPopupMenu, @NotNull ImportDocumentPresenterContract.IDialog mDialog, @NotNull ImportPresenterContract.IRecyclerView mRecyclerView) {
        Intrinsics.checkNotNullParameter(importType, "importType");
        Intrinsics.checkNotNullParameter(mView, "mView");
        Intrinsics.checkNotNullParameter(mSpinnerPopupMenu, "mSpinnerPopupMenu");
        Intrinsics.checkNotNullParameter(mDialog, "mDialog");
        Intrinsics.checkNotNullParameter(mRecyclerView, "mRecyclerView");
        this.mView = mView;
        this.mSpinnerPopupMenu = mSpinnerPopupMenu;
        this.mDialog = mDialog;
        this.mRecyclerView = mRecyclerView;
        this.mImportDocumentListener = new ImportRequestListener(new ImportHandler(new ImportDocumentResult(mView, mDialog, this)));
        ImportDocumentModeContract.IPresenter iPresenter = new ImportDocumentModeContract.IPresenter() { // from class: com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.ImportDocumentPresenter$presenter$1
            @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentModeContract.IPresenter
            public void dismissProgressDialog() {
                this.this$0.mDialog.dismissProgressDialog();
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentModeContract.IPresenter
            public ArrayList<ImportItem> getCheckedItems() {
                return this.this$0.getRecyclerViewCheckedItems();
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentModeContract.IPresenter
            public void handleError(DocTypeConstants type, int errorCode, String message, Exception e) {
                this.this$0.mImportDocumentListener.onImportError(type, errorCode, message, e);
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentModeContract.IPresenter
            public boolean isCancelDownloadingEnded() {
                return this.this$0.getIsCancelDownloadingEnded();
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentModeContract.IPresenter
            public void registerImportListRequest() {
                this.this$0.registerImportListRequest();
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentModeContract.IPresenter
            public void showCancelDownloadingDialog() {
                this.this$0.mDialog.showCancelDownloadingDialog();
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentModeContract.IPresenter
            public void showMemoDataWarningDialog(int type, double size) {
                this.this$0.mDialog.showNoteDataWarningDialog(type, size);
            }
        };
        this.mAdapter = new ImportDocumentRecyclerViewAdapter(new ImportDocumentAdapterContract() { // from class: com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.ImportDocumentPresenter.1
            @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.adapter.ImportDocumentAdapterContract
            public void onItemChecked() {
                ImportDocumentPresenter.this.mView.updateSelectedItemCount();
            }

            @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.adapter.ImportDocumentAdapterContract
            public void onItemLongPressed() {
                ImportDocumentPresenter.this.mView.onItemLongPressed();
            }
        });
        initMode(importType, iPresenter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<ImportItem> getRecyclerViewCheckedItems() {
        ImportDocumentRecyclerViewAdapter importDocumentRecyclerViewAdapter = this.mAdapter;
        Intrinsics.checkNotNull(importDocumentRecyclerViewAdapter);
        return importDocumentRecyclerViewAdapter.getCheckedItems();
    }

    private final void initMode(DocTypeConstants importType, ImportDocumentModeContract.IPresenter presenter) {
        int i = WhenMappings.$EnumSwitchMapping$0[importType.ordinal()];
        if (i == 1) {
            this.mMode = new ImportMemoLocalMode(presenter);
            return;
        }
        if (i == 2) {
            this.mMode = new ImportMemoSCloudMode(presenter);
        } else {
            if (i == 3) {
                this.mMode = new ImportScrapbookMode(presenter);
                return;
            }
            MainLogger.m7255e(TAG, "unexpected importType: " + importType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerImportListRequest$lambda$4(ImportDocumentPresenter importDocumentPresenter) {
        C6756e c6756e = importDocumentPresenter.mImportListRequest;
        if (c6756e == null) {
            return;
        }
        Intrinsics.checkNotNull(c6756e);
        c6756e.m4895a(importDocumentPresenter.mView.getContext(), importDocumentPresenter.mImportDocumentListener);
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.ImportDocumentResultContract.IPresenter
    public void addCategorySpinnerItem(@Nullable String category) {
        ImportCategorySpinnerAdapter importCategorySpinnerAdapter = this.mCategorySpinnerAdapter;
        if (importCategorySpinnerAdapter != null) {
            importCategorySpinnerAdapter.add(category);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.ImportDocumentResultContract.IPresenter
    public void addRecyclerViewItem(@Nullable ImportDocumentModel item) {
        ImportDocumentRecyclerViewAdapter importDocumentRecyclerViewAdapter;
        if (item == null || (importDocumentRecyclerViewAdapter = this.mAdapter) == null) {
            return;
        }
        importDocumentRecyclerViewAdapter.add(item);
    }

    @Nullable
    public final String getAppName() {
        ImportDocumentMode importDocumentMode = this.mMode;
        Intrinsics.checkNotNull(importDocumentMode);
        return importDocumentMode.getAppName();
    }

    public final int getCategorySpinnerCount() {
        ImportCategorySpinnerAdapter importCategorySpinnerAdapter = this.mCategorySpinnerAdapter;
        Intrinsics.checkNotNull(importCategorySpinnerAdapter);
        return importCategorySpinnerAdapter.getCount();
    }

    @Nullable
    public final Object getCategorySpinnerItem(int position) {
        ImportCategorySpinnerAdapter importCategorySpinnerAdapter = this.mCategorySpinnerAdapter;
        if (importCategorySpinnerAdapter != null) {
            return importCategorySpinnerAdapter.getItem(position);
        }
        return null;
    }

    @NotNull
    public final String getCategorySpinnerTitle(int position) {
        ImportCategorySpinnerAdapter importCategorySpinnerAdapter = this.mCategorySpinnerAdapter;
        Intrinsics.checkNotNull(importCategorySpinnerAdapter);
        return importCategorySpinnerAdapter.getTitle(position);
    }

    public final int getCheckedItemCount() {
        ImportDocumentRecyclerViewAdapter importDocumentRecyclerViewAdapter = this.mAdapter;
        Intrinsics.checkNotNull(importDocumentRecyclerViewAdapter);
        return importDocumentRecyclerViewAdapter.getCheckedItemCount();
    }

    @Nullable
    public final String getDefaultActionBarTitle() {
        ImportDocumentMode importDocumentMode = this.mMode;
        Intrinsics.checkNotNull(importDocumentMode);
        return importDocumentMode.getDefaultActionBarTitle();
    }

    public final int getDefaultCategoryText() {
        ImportDocumentMode importDocumentMode = this.mMode;
        Intrinsics.checkNotNull(importDocumentMode);
        return importDocumentMode.getDefaultCategoryText();
    }

    @Nullable
    public final DocTypeConstants getImportType() {
        ImportDocumentMode importDocumentMode = this.mMode;
        Intrinsics.checkNotNull(importDocumentMode);
        return importDocumentMode.getImportType();
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.ImportDocumentResultContract.IPresenter
    public int getItemCount() {
        ImportDocumentRecyclerViewAdapter importDocumentRecyclerViewAdapter = this.mAdapter;
        if (importDocumentRecyclerViewAdapter == null) {
            return -1;
        }
        return importDocumentRecyclerViewAdapter.getItemCount();
    }

    @Nullable
    public final String getNoNoteBodyText() {
        ImportDocumentMode importDocumentMode = this.mMode;
        Intrinsics.checkNotNull(importDocumentMode);
        return importDocumentMode.getNoNoteBodyText();
    }

    @Nullable
    public final String getSelectedCategory() {
        ImportDocumentRecyclerViewAdapter importDocumentRecyclerViewAdapter = this.mAdapter;
        Intrinsics.checkNotNull(importDocumentRecyclerViewAdapter);
        return importDocumentRecyclerViewAdapter.getSelectedCategory();
    }

    public final int getSelectedCategoryType() {
        ImportDocumentRecyclerViewAdapter importDocumentRecyclerViewAdapter = this.mAdapter;
        Intrinsics.checkNotNull(importDocumentRecyclerViewAdapter);
        return importDocumentRecyclerViewAdapter.getSelectedCategoryType();
    }

    public final boolean hasSpinnerLayout() {
        ImportDocumentMode importDocumentMode = this.mMode;
        Intrinsics.checkNotNull(importDocumentMode);
        return importDocumentMode.hasSpinnerLayout();
    }

    public final void initDialog() {
        ImportDocumentMode importDocumentMode = this.mMode;
        Intrinsics.checkNotNull(importDocumentMode);
        DocTypeConstants importType = importDocumentMode.getImportType();
        if (importType == DocTypeConstants.MEMO_LOCAL) {
            this.mDialog.showCancelDownloadingDialog();
            registerImportListRequest();
            return;
        }
        if (!C0145c.m334s(this.mView.getContext())) {
            MainLogger.m7258i(TAG, "onError() Network is not Connected.");
            this.mImportDocumentListener.onImportError(DocTypeConstants.MEMO_SCLOUD, 101, "", null);
        } else if (!C0145c.m297E(this.mView.getContext())) {
            this.mDialog.showProgressDialog();
        } else if (importType == DocTypeConstants.MEMO_SCLOUD || importType == DocTypeConstants.SCRAPBOOK_SCLOUD) {
            this.mDialog.showCancelDownloadingDialog();
        }
    }

    public final void initRecyclerView() {
        this.mRecyclerView.setAdapter(this.mAdapter);
    }

    public final void initializeSpinnerAdapter() {
        if (this.mCategorySpinnerAdapter == null) {
            this.mCategorySpinnerAdapter = new ImportCategorySpinnerAdapter(new ImportCategorySpinnerAdapter.Contract() { // from class: com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.ImportDocumentPresenter.initializeSpinnerAdapter.1
                @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.adapter.ImportCategorySpinnerAdapter.Contract
                public Context getContext() {
                    return ImportDocumentPresenter.this.mView.getContext();
                }

                @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.adapter.ImportCategorySpinnerAdapter.Contract
                public String getDefaultTitle() {
                    Context context = ImportDocumentPresenter.this.mView.getContext();
                    Intrinsics.checkNotNull(context);
                    String string = context.getString(ImportDocumentPresenter.this.getDefaultCategoryText());
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    return string;
                }

                @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.adapter.ImportCategorySpinnerAdapter.Contract
                public int getSelectedCategoryPosition() {
                    return ImportDocumentPresenter.this.mSpinnerPopupMenu.getSelectedCategoryPosition();
                }

                @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.adapter.ImportCategorySpinnerAdapter.Contract
                public ListView getSpinnerListView() {
                    return ImportDocumentPresenter.this.mSpinnerPopupMenu.getSpinnerListView();
                }
            });
        }
        this.mSpinnerPopupMenu.setAdapter(this.mCategorySpinnerAdapter);
    }

    /* JADX INFO: renamed from: isCancelDownloadingEnded, reason: from getter */
    public final boolean getIsCancelDownloadingEnded() {
        return this.isCancelDownloadingEnded;
    }

    public final int measureCategorySpinnerContentWidth() {
        Context context = this.mView.getContext();
        Intrinsics.checkNotNull(context);
        int dimension = (int) context.getResources().getDimension(C8003R.dimen.note_picker_category_spinner_list_popup_width);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        ImportCategorySpinnerAdapter importCategorySpinnerAdapter = this.mCategorySpinnerAdapter;
        Intrinsics.checkNotNull(importCategorySpinnerAdapter);
        int count = importCategorySpinnerAdapter.getCount();
        TypedValue typedValue = new TypedValue();
        Context context2 = this.mView.getContext();
        Intrinsics.checkNotNull(context2);
        context2.getResources().getValue(C8003R.dimen.memo_list_category_spinner_list_popup_max_width_ratio, typedValue, true);
        int i = 0;
        int i2 = 0;
        View view = null;
        for (int i4 = 0; i4 < count; i4++) {
            ImportCategorySpinnerAdapter importCategorySpinnerAdapter2 = this.mCategorySpinnerAdapter;
            Intrinsics.checkNotNull(importCategorySpinnerAdapter2);
            int itemViewType = importCategorySpinnerAdapter2.getItemViewType(i4);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            try {
                ImportCategorySpinnerAdapter importCategorySpinnerAdapter3 = this.mCategorySpinnerAdapter;
                Intrinsics.checkNotNull(importCategorySpinnerAdapter3);
                ListView spinnerListView = this.mSpinnerPopupMenu.getSpinnerListView();
                Intrinsics.checkNotNull(spinnerListView);
                view = importCategorySpinnerAdapter3.getView(i4, view, spinnerListView);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                int measuredWidth = view.getMeasuredWidth();
                if (measuredWidth > i) {
                    i = measuredWidth;
                }
            } catch (NullPointerException unused) {
            }
            if (i > dimension) {
                return dimension;
            }
        }
        return (int) Math.max(dimension, i);
    }

    public final void notifyDataSetChanged() {
        ImportDocumentRecyclerViewAdapter importDocumentRecyclerViewAdapter = this.mAdapter;
        if (importDocumentRecyclerViewAdapter != null) {
            importDocumentRecyclerViewAdapter.notifyDataSetChanged();
        }
    }

    public final void onCreate() {
        ImportDocumentMode importDocumentMode = this.mMode;
        if (importDocumentMode != null) {
            importDocumentMode.onCreate();
        }
    }

    public final void onDestroy() {
        ImportDocumentMode importDocumentMode = this.mMode;
        if (importDocumentMode != null) {
            importDocumentMode.onDestroy();
        }
        unregisterImportListRequest();
    }

    public final void registerImportListRequest() {
        ImportDocumentMode importDocumentMode = this.mMode;
        Intrinsics.checkNotNull(importDocumentMode);
        MainLogger.m7258i(TAG, "registerImportListRequest() importType : " + importDocumentMode.getImportType());
        ImportDocumentMode importDocumentMode2 = this.mMode;
        Intrinsics.checkNotNull(importDocumentMode2);
        this.mImportListRequest = new C6756e(importDocumentMode2.getAbstractImportType(null));
        ImportDocumentMode importDocumentMode3 = this.mMode;
        Intrinsics.checkNotNull(importDocumentMode3);
        if (importDocumentMode3.getImportType() == DocTypeConstants.MEMO_LOCAL) {
            Looper looperMyLooper = Looper.myLooper();
            Intrinsics.checkNotNull(looperMyLooper);
            new Handler(looperMyLooper).postDelayed(new RunnableC8669a(this, 7), 500L);
        } else {
            C6756e c6756e = this.mImportListRequest;
            Intrinsics.checkNotNull(c6756e);
            c6756e.m4895a(this.mView.getContext(), this.mImportDocumentListener);
        }
    }

    public final void setAllItemChecked(boolean checked) {
        ImportDocumentRecyclerViewAdapter importDocumentRecyclerViewAdapter = this.mAdapter;
        if (importDocumentRecyclerViewAdapter != null) {
            importDocumentRecyclerViewAdapter.setAllItemChecked(checked);
        }
        ImportDocumentRecyclerViewAdapter importDocumentRecyclerViewAdapter2 = this.mAdapter;
        if (importDocumentRecyclerViewAdapter2 != null) {
            importDocumentRecyclerViewAdapter2.notifyDataSetChanged();
        }
    }

    public final void setCancelDownloadingEnded(boolean z) {
        this.isCancelDownloadingEnded = z;
    }

    public final void setCheckItem(@Nullable ImportDocumentRecyclerViewHolder holder, boolean check) {
        ImportDocumentRecyclerViewAdapter importDocumentRecyclerViewAdapter;
        if (holder != null && (importDocumentRecyclerViewAdapter = this.mAdapter) != null) {
            importDocumentRecyclerViewAdapter.setCheckItem(holder, Boolean.valueOf(check));
        }
        ImportDocumentRecyclerViewAdapter importDocumentRecyclerViewAdapter2 = this.mAdapter;
        if (importDocumentRecyclerViewAdapter2 != null) {
            importDocumentRecyclerViewAdapter2.notifyDataSetChanged();
        }
    }

    public final void setSelectedCategory(@Nullable String category, int type) {
        ImportDocumentRecyclerViewAdapter importDocumentRecyclerViewAdapter = this.mAdapter;
        if (importDocumentRecyclerViewAdapter != null) {
            importDocumentRecyclerViewAdapter.setCategory(category, type);
        }
        ImportDocumentRecyclerViewAdapter importDocumentRecyclerViewAdapter2 = this.mAdapter;
        if (importDocumentRecyclerViewAdapter2 != null) {
            importDocumentRecyclerViewAdapter2.notifyDataSetChanged();
        }
    }

    public final void startImport() {
        MainLogger.m7258i(TAG, "startImport()");
        ImportDocumentMode importDocumentMode = this.mMode;
        if (importDocumentMode != null) {
            importDocumentMode.startImport();
        }
    }

    public final boolean toggleRecyclerViewSelectState(@Nullable ArrayList<Integer> selectedItemPosition) {
        ImportDocumentRecyclerViewAdapter importDocumentRecyclerViewAdapter = this.mAdapter;
        if (importDocumentRecyclerViewAdapter == null) {
            return false;
        }
        importDocumentRecyclerViewAdapter.toggleSelectState(selectedItemPosition);
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.ImportDocumentResultContract.IPresenter
    public void unregisterImportListRequest() {
        if (this.mImportListRequest != null) {
            MainLogger.m7258i(TAG, "unregisterImportListRequest()");
            C6756e c6756e = this.mImportListRequest;
            Intrinsics.checkNotNull(c6756e);
            BasicImportHelperAdapter basicImportHelperAdapter = c6756e.f4152c;
            if (basicImportHelperAdapter != null) {
                basicImportHelperAdapter.getImportHelper().setImportListener(null);
                c6756e.f4152c.getImportHelper().stop();
            }
            this.mImportListRequest = null;
        }
    }
}
