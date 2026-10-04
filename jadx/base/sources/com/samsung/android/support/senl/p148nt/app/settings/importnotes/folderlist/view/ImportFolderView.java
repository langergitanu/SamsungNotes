package com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.ViewOnFocusChangeListenerC4697c;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.PenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.widget.IFolderPathLayoutListener;
import com.samsung.android.support.senl.p148nt.app.main.common.view.ActionMenuController;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.view.ImportView;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.view.ImportViewContract;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.adapter.ImportFolderAdapter;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.adapter.ImportFolderAdapterContract;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.adapter.holder.ImportFolderHolder;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.model.ImportFolderInfo;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenter;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.view.dialog.ImportFolderDialog;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.view.dialog.ImportFolderDialogContract;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.OnPenMultiSelectionListener;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 _2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001_B+\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001c\u001a\u00020\u0017J\u0006\u0010\u001d\u001a\u00020\u0017J\b\u0010\u001e\u001a\u00020\u0017H\u0016J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010\u0019J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0017H\u0016J\b\u0010,\u001a\u00020\u0017H\u0016J\b\u0010-\u001a\u00020\u0017H\u0016J\b\u0010.\u001a\u00020\u0017H\u0002J\b\u0010/\u001a\u00020\u0017H\u0002J\u0018\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020&H\u0002J\u0010\u00103\u001a\u00020\u00172\u0006\u00102\u001a\u00020&H\u0016J\b\u00108\u001a\u00020\u0017H\u0016J\u0010\u00109\u001a\u00020\u00172\u0006\u0010:\u001a\u00020\bH\u0016J\u0012\u0010;\u001a\u00020\u00172\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010<\u001a\u00020\u0017H\u0016J\b\u0010=\u001a\u00020\u0017H\u0016J\u0012\u0010>\u001a\u00020\u00172\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010?\u001a\u00020\u0017H\u0016J\b\u0010@\u001a\u00020\u0017H\u0016J\u0010\u0010A\u001a\u00020\u00172\u0006\u00101\u001a\u00020!H\u0016J\b\u0010B\u001a\u00020&H\u0016J\b\u0010C\u001a\u00020\u0017H\u0016J\u001c\u0010D\u001a\u00020\u00172\b\u0010E\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010F\u001a\u00020\u0017H\u0016J\b\u0010G\u001a\u00020\u0017H\u0016J\b\u0010H\u001a\u00020\u0017H\u0002J\u0010\u0010I\u001a\u00020&2\b\u0010J\u001a\u0004\u0018\u00010KJ\b\u0010L\u001a\u00020\u0017H\u0002J\u0006\u0010M\u001a\u00020\u0017J \u0010N\u001a\u00020&2\u0006\u0010O\u001a\u00020!2\u0006\u0010P\u001a\u00020!2\b\u0010Q\u001a\u0004\u0018\u00010*J\b\u0010R\u001a\u00020\u0017H\u0016J\u0010\u0010S\u001a\u00020\u00172\u0006\u0010:\u001a\u00020\bH\u0016J\u001a\u0010W\u001a\u00020\b2\b\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010Z\u001a\u00020!H\u0016J \u0010[\u001a\u00020\b2\u0006\u0010X\u001a\u00020Y2\u0006\u0010\\\u001a\u00020Y2\u0006\u0010Z\u001a\u00020!H\u0016J\u0012\u0010]\u001a\u0004\u0018\u00010^2\u0006\u00101\u001a\u00020!H\u0016R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010'R\u0016\u00104\u001a\u0004\u0018\u0001058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u0010T\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bU\u0010V¨\u0006`"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/view/ImportFolderView;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/view/ImportView;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/view/dialog/ImportFolderDialogContract;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/adapter/ImportFolderAdapterContract;", "importType", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "googleAccountName", "", "importViewContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/view/ImportViewContract;", "importFolderViewContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/view/ImportFolderViewContract;", "<init>", "(Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;Ljava/lang/String;Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/view/ImportViewContract;Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/view/ImportFolderViewContract;)V", "mPresenter", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenter;", "mDialog", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/view/dialog/ImportFolderDialog;", "mAdapter", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/adapter/ImportFolderAdapter;", "mImportFolderViewContract", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "onViewStateRestored", "onResume", "onDestroy", "initLayout", "initFolderPathLayout", "getRecyclerViewTopPadding", "", "onRestoreInstanceState", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "isFragmentResumed", "", "()Z", "backToNoteList", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "updateSelectedItemCount", "updateFolderLayout", "updateLayout", "updateNoNoteView", "updateSelectAllLayout", "setCheckItem", "position", "checked", "setAllItemChecked", "childFragmentManager", "Landroidx/fragment/app/FragmentManager;", "getChildFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "activityFinish", "updateValidateFolderPath", "folderName", "startGoogleDriveActivity", "startMyfilesPickerActivity", "startSNBAKPickerActivity", "startRequestAuthorizationActivity", "startContentLoadingDialog", "notifyDataSetChanged", "notifyItemChanged", "isRootFolder", "setValidateFolderPath", "showFileDownloadingDialog", "appName", "dismissFileDownloadingDialog", "showErrorDialog", "updateFolderNameContainer", "prepareOptionsMenu", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "updateMenu", "onActionDoneOptionsItemSelected", "onActivityResult", "requestCode", "resultCode", "data", "onItemChecked", "onFolderClicked", "itemCount", "getItemCount", "()I", "getContainerContentDescription", "name", "", "itemType", "getItemContainerContentDescription", "time", "getImportFolderInfo", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/model/ImportFolderInfo;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImportFolderView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImportFolderView.kt\ncom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/view/ImportFolderView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,404:1\n1#2:405\n*E\n"})
public final class ImportFolderView extends ImportView implements ImportFolderPresenterContract, ImportFolderDialogContract, ImportFolderAdapterContract {

    @NotNull
    private static final String TAG = "ST$ImportFolderView";

    @NotNull
    private final ImportFolderAdapter mAdapter;

    @NotNull
    private ImportFolderDialog mDialog;

    @NotNull
    private final ImportFolderViewContract mImportFolderViewContract;

    @NotNull
    private final ImportFolderPresenter mPresenter;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.view.ImportFolderView$notifyDataSetChanged$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.view.ImportFolderView$notifyDataSetChanged$1", m14021f = "ImportFolderView.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C88131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C88131(Continuation<? super C88131> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ImportFolderView.this.new C88131(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ImportFolderView.this.mAdapter.notifyDataSetChanged();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C88131) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.view.ImportFolderView$notifyItemChanged$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.view.ImportFolderView$notifyItemChanged$1", m14021f = "ImportFolderView.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C88141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $position;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88141(int i, Continuation<? super C88141> continuation) {
            super(2, continuation);
            this.$position = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ImportFolderView.this.new C88141(this.$position, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ImportFolderView.this.mAdapter.notifyItemChanged(this.$position);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C88141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.view.ImportFolderView$updateFolderLayout$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.view.ImportFolderView$updateFolderLayout$1", m14021f = "ImportFolderView.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C88151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C88151(Continuation<? super C88151> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ImportFolderView.this.new C88151(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ImportFolderView.this.updateFolderNameContainer();
            ImportFolderView.this.setAllItemChecked(false);
            ImportFolderView importFolderView = ImportFolderView.this;
            importFolderView.setFastScrollerEnabled(importFolderView.mPresenter.getItemCount());
            PenRecyclerView penRecyclerView = ((ImportView) ImportFolderView.this).mRecyclerView;
            if (penRecyclerView != null) {
                penRecyclerView.scrollToPosition(0);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C88151) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.view.ImportFolderView$updateFolderNameContainer$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.view.ImportFolderView$updateFolderNameContainer$1", m14021f = "ImportFolderView.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    @SourceDebugExtension({"SMAP\nImportFolderView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImportFolderView.kt\ncom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/view/ImportFolderView$updateFolderNameContainer$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,404:1\n739#2,9:405\n37#3:414\n36#3,3:415\n*S KotlinDebug\n*F\n+ 1 ImportFolderView.kt\ncom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/view/ImportFolderView$updateFolderNameContainer$1\n*L\n349#1:405,9\n349#1:414\n349#1:415,3\n*E\n"})
    public static final class C88161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C88161(Continuation<? super C88161> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ImportFolderView.this.new C88161(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List listEmptyList;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String currentFolder = ImportFolderView.this.mPresenter.getCurrentFolder();
            if (TextUtils.isEmpty(currentFolder)) {
                ActionMenuController mActionMenuController = ImportFolderView.this.getMActionMenuController();
                if (mActionMenuController != null) {
                    mActionMenuController.updateFolderPathLayoutVisibility(8);
                }
                return Unit.INSTANCE;
            }
            ActionMenuController mActionMenuController2 = ImportFolderView.this.getMActionMenuController();
            if (mActionMenuController2 != null) {
                mActionMenuController2.updateFolderPathLayoutVisibility(0);
            }
            Intrinsics.checkNotNull(currentFolder);
            List<String> listSplit = new Regex("/").split(currentFolder, 0);
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
            ActionMenuController mActionMenuController3 = ImportFolderView.this.getMActionMenuController();
            if (mActionMenuController3 != null) {
                mActionMenuController3.updateCurrentFolderPath(strArr);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C88161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.view.ImportFolderView$updateLayout$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.view.ImportFolderView$updateLayout$1", m14021f = "ImportFolderView.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C88171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C88171(Continuation<? super C88171> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ImportFolderView.this.new C88171(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ImportFolderView.this.updateMenu();
            ImportFolderView.this.updateNoNoteView();
            ImportFolderView.this.updateSelectAllLayout();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C88171) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImportFolderView(@Nullable DocTypeConstants docTypeConstants, @Nullable String str, @NotNull ImportViewContract importViewContract, @NotNull ImportFolderViewContract importFolderViewContract) {
        super(importViewContract);
        Intrinsics.checkNotNullParameter(importViewContract, "importViewContract");
        Intrinsics.checkNotNullParameter(importFolderViewContract, "importFolderViewContract");
        Intrinsics.checkNotNull(docTypeConstants);
        ImportFolderPresenter importFolderPresenter = new ImportFolderPresenter(docTypeConstants, str, this);
        this.mPresenter = importFolderPresenter;
        this.mDialog = new ImportFolderDialog(importFolderPresenter, this);
        this.mAdapter = new ImportFolderAdapter(this);
        this.mImportFolderViewContract = importFolderViewContract;
    }

    private final void initFolderPathLayout() throws Exception {
        Activity activity = getActivity();
        View viewFindViewById = activity != null ? activity.findViewById(C8003R.id.multi_floating_bar_item_container) : null;
        if (viewFindViewById != null) {
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            layoutParams.width = -1;
            viewFindViewById.setLayoutParams(layoutParams);
        }
        ActionMenuController mActionMenuController = getMActionMenuController();
        if (mActionMenuController != null) {
            mActionMenuController.initFolderPathLayoutForImportList(new IFolderPathLayoutListener() { // from class: com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.view.ImportFolderView.initFolderPathLayout.2
                @Override // com.samsung.android.support.senl.p148nt.app.common.widget.IFolderPathLayoutListener
                public String getFolderUuid() {
                    return ImportFolderView.this.mPresenter.getCurrentFolder();
                }

                @Override // com.samsung.android.support.senl.p148nt.app.common.widget.IFolderPathLayoutListener
                public void onFolderLayoutSelected(String folderUuid) {
                    Intrinsics.checkNotNullParameter(folderUuid, "folderUuid");
                    MainLogger.m7254d(ImportFolderView.TAG, "onFolderLayoutSelected: " + folderUuid);
                    ImportFolderView.this.mPresenter.setCurrentFolder(folderUuid);
                    ImportFolderView.this.updateFolderLayout();
                    ImportFolderView.this.invalidateOptionsMenu();
                    CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_IMPORT_SNOTE_PICKER, SettingsSAConstants.EVENT_IMPORT_SNOTE_PICKER_FOLDER_MOVE);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLayout$lambda$0(ImportFolderView importFolderView, View view, boolean z) {
        if (z) {
            PenRecyclerView penRecyclerView = importFolderView.mRecyclerView;
            View childAt = penRecyclerView != null ? penRecyclerView.getChildAt(0) : null;
            if (childAt != null) {
                childAt.requestFocus();
            }
        }
    }

    private final void onRestoreInstanceState(Bundle savedInstanceState) {
        this.mPresenter.onRestoreInstanceState(savedInstanceState);
        this.mDialog.onRestoreDialogState(savedInstanceState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCheckItem(int position, boolean checked) {
        this.mPresenter.setItemChecked(position, checked);
        updateSelectedItemCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFolderNameContainer() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C88161(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateMenu() {
        invalidateOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateNoNoteView() {
        boolean z = this.mPresenter.isLocalNotePickerNeeds() && !this.mPresenter.hasItem();
        TextView textView = this.mNoNote;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
        TextView textView2 = this.mNoNote;
        if (textView2 != null) {
            CharSequence text = null;
            if (z && textView2 != null) {
                text = textView2.getText();
            }
            textView2.announceForAccessibility(text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelectAllLayout() {
        if (!this.mPresenter.isLocalNotePickerNeeds() || this.mPresenter.getItemCount() == 0) {
            finishActionMode();
        } else {
            startActionMode();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract, com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.view.dialog.ImportFolderDialogContract
    public void activityFinish() {
        Activity activity;
        if (CommonUtil.isNotAvailableActivity(getActivity()) || (activity = getActivity()) == null) {
            return;
        }
        activity.finish();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract
    public void backToNoteList(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        NotesUtils.INSTANCE.backToNoteList(new WeakReference<>(getActivity()), intent);
        activityFinish();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract
    public void dismissFileDownloadingDialog() {
        this.mDialog.dismissFileDownloadingDialog();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.view.dialog.ImportFolderDialogContract
    @Nullable
    public FragmentManager getChildFragmentManager() {
        return this.mImportFolderViewContract.getChildFragmentManager();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.adapter.ImportFolderAdapterContract
    @NotNull
    public String getContainerContentDescription(@Nullable CharSequence name, int itemType) {
        return this.mPresenter.getContainerContentDescription(name, itemType);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.adapter.ImportFolderAdapterContract
    @Nullable
    public ImportFolderInfo getImportFolderInfo(int position) {
        return this.mPresenter.getImportFolderInfo(position);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.adapter.ImportFolderAdapterContract
    @NotNull
    public String getItemContainerContentDescription(@NotNull CharSequence name, @NotNull CharSequence time, int itemType) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(time, "time");
        return this.mPresenter.getItemContainerContentDescription(name, time, itemType);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.adapter.ImportFolderAdapterContract
    public int getItemCount() {
        return this.mPresenter.getItemCount();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.view.ImportView
    public int getRecyclerViewTopPadding() {
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        return activity.getResources().getDimensionPixelSize(C8003R.dimen.folderpath_layout_height_for_notesview_padding);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.view.ImportView
    public void initLayout() {
        PenRecyclerView penRecyclerView;
        super.initLayout();
        TextView textView = this.mNoNote;
        if (textView != null) {
            textView.setText(this.mPresenter.getNoNoteText());
        }
        PenRecyclerView penRecyclerView2 = this.mRecyclerView;
        if (penRecyclerView2 != null) {
            penRecyclerView2.setAdapter(this.mAdapter);
        }
        PenRecyclerView penRecyclerView3 = this.mRecyclerView;
        if (penRecyclerView3 != null) {
            penRecyclerView3.setOnPenMultiSelectionListener(new OnPenMultiSelectionListener() { // from class: com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.view.ImportFolderView.initLayout.1
                @Override // com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.OnPenMultiSelectionListener
                public void onSelectedItemPosition(ArrayList<Integer> selectedItemPosition, int recyclerViewWidth, int penDragLeft, int penDragRight) {
                    Intrinsics.checkNotNullParameter(selectedItemPosition, "selectedItemPosition");
                    ImportFolderView.this.mPresenter.toggleSelectedState(selectedItemPosition);
                    ImportFolderView.this.updateSelectedItemCount();
                }
            });
        }
        PenRecyclerView penRecyclerView4 = this.mRecyclerView;
        if (penRecyclerView4 != null) {
            penRecyclerView4.seslSetLongPressMultiSelectionListener(new RecyclerView.SeslLongPressMultiSelectionListener() { // from class: com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.view.ImportFolderView.initLayout.2
                private final ArrayList<Integer> selectedItemPositionList = new ArrayList<>();

                public final ArrayList<Integer> getSelectedItemPositionList() {
                    return this.selectedItemPositionList;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
                public void onItemSelected(RecyclerView recyclerView, View view, int position, long l) {
                    boolean z;
                    Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                    Intrinsics.checkNotNullParameter(view, "view");
                    PenRecyclerView penRecyclerView5 = ((ImportView) ImportFolderView.this).mRecyclerView;
                    RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = penRecyclerView5 != null ? penRecyclerView5.findViewHolderForAdapterPosition(position) : null;
                    if (viewHolderFindViewHolderForAdapterPosition == null) {
                        MainLogger.m7258i(ImportFolderView.TAG, "holder is null!!");
                        return;
                    }
                    if (this.selectedItemPositionList.contains(Integer.valueOf(position))) {
                        this.selectedItemPositionList.remove(Integer.valueOf(position));
                        z = false;
                    } else {
                        this.selectedItemPositionList.add(Integer.valueOf(position));
                        z = true;
                    }
                    CheckBox checkBox = ((ImportFolderHolder) viewHolderFindViewHolderForAdapterPosition).mCheckBox;
                    Intrinsics.checkNotNull(checkBox);
                    checkBox.setChecked(z);
                    ImportFolderView.this.setCheckItem(position, z);
                }

                @Override // androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
                public void onLongPressMultiSelectionEnded(int i, int i12) {
                    this.selectedItemPositionList.clear();
                }

                @Override // androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
                public void onLongPressMultiSelectionStarted(int i, int i12) {
                    this.selectedItemPositionList.clear();
                }
            });
        }
        InputMethodCompat companion = InputMethodCompat.INSTANCE.getInstance();
        PenRecyclerView penRecyclerView5 = this.mRecyclerView;
        if (companion.isKeyboardConnected(penRecyclerView5 != null ? penRecyclerView5.getContext() : null) && (penRecyclerView = this.mRecyclerView) != null) {
            penRecyclerView.requestFocus();
        }
        PenRecyclerView penRecyclerView6 = this.mRecyclerView;
        if (penRecyclerView6 != null) {
            penRecyclerView6.setOnFocusChangeListener(new ViewOnFocusChangeListenerC4697c(this, 4));
        }
        PenRecyclerView penRecyclerView7 = this.mRecyclerView;
        if (penRecyclerView7 != null) {
            penRecyclerView7.seslSetGoToTopEnabled(true);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract
    public boolean isFragmentResumed() {
        return this.mImportFolderViewContract.isResumed();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract
    public boolean isRootFolder() {
        return this.mPresenter.isRootFolder();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract
    public void notifyDataSetChanged() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C88131(null), 3, null);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract
    public void notifyItemChanged(int position) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C88141(position, null), 3, null);
    }

    public final void onActionDoneOptionsItemSelected() {
        this.mPresenter.onActionDone();
    }

    public final boolean onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        return this.mPresenter.onActivityResult(requestCode, resultCode, data);
    }

    public final void onCreate(@Nullable Bundle savedInstanceState) {
        this.mPresenter.onCreate();
        if (savedInstanceState != null) {
            onRestoreInstanceState(savedInstanceState);
        } else {
            startContentLoadingDialog();
        }
    }

    public final void onDestroy() {
        this.mPresenter.onDestroy();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.adapter.ImportFolderAdapterContract
    public void onFolderClicked(@NotNull String folderName) {
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        this.mPresenter.onFolderClicked(folderName);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.adapter.ImportFolderAdapterContract
    public void onItemChecked() {
        this.mPresenter.onItemChecked();
    }

    public final void onResume() {
        this.mPresenter.onResume();
    }

    public final void onSaveInstanceState(@Nullable Bundle outState) {
        if (outState != null) {
            this.mPresenter.onSaveInstanceState(outState);
            this.mDialog.onSaveInstanceState(outState);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.view.ImportView
    public void onViewCreated() throws Exception {
        MainLogger.m7254d(TAG, "onViewCreated# ");
        initLayout();
        initializeToolbar(this.mPresenter.getDefaultActionBarTitle());
        initFolderPathLayout();
        updateFolderNameContainer();
        updateLayout();
        updateSelectedItemCount();
        super.onViewCreated();
    }

    public final void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        MainLogger.m7254d(TAG, "onViewStateRestored# ");
        if (savedInstanceState != null) {
            onRestoreInstanceState(savedInstanceState);
        }
    }

    public final boolean prepareOptionsMenu(@Nullable Menu menu) {
        prepareOptionsMenu(menu, this.mPresenter.getCheckedItemCount(), this.mPresenter.isLocalNotePickerNeeds() && this.mPresenter.hasItem());
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.view.ImportView
    public void setAllItemChecked(boolean checked) {
        super.setAllItemChecked(checked);
        this.mPresenter.setAllItemChecked(checked);
        updateSelectedItemCount();
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_IMPORT_SNOTE_PICKER, SettingsSAConstants.EVENT_IMPORT_SNOTE_PICKER_SELECT_ALL, checked ? "1" : "0");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract
    public void setValidateFolderPath() {
        this.mPresenter.setValidateFolderPath();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract
    public void showErrorDialog() {
        ImportFolderDialog importFolderDialog = this.mDialog;
        PenRecyclerView penRecyclerView = this.mRecyclerView;
        importFolderDialog.showErrorDialog(penRecyclerView != null ? penRecyclerView.getContext() : null);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract
    public void showFileDownloadingDialog(@Nullable String appName, @Nullable DocTypeConstants importType) {
        if (importType != null) {
            this.mDialog.showFileDownloadingDialog(appName, importType);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract
    public void startContentLoadingDialog() {
        MainLogger.m7254d(TAG, "startContentLoadingDialog");
        if (!this.mPresenter.isLocalNotePickerNeeds()) {
            MainLogger.m7258i(TAG, "startContentLoadingDialog# isLocalNotePickerNeeds: false");
        } else {
            if (this.mDialog.isFileDownloadInProgress()) {
                MainLogger.m7258i(TAG, "startContentLoadingDialog#  Loading inProgress");
                return;
            }
            this.mPresenter.initPresenter();
            notifyDataSetChanged();
            showFileDownloadingDialog(this.mPresenter.getAppName(), this.mPresenter.getImportType());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract
    public void startGoogleDriveActivity(@Nullable Intent intent) {
        this.mImportFolderViewContract.startGoogleDriveActivity(intent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract
    public void startMyfilesPickerActivity() {
        this.mImportFolderViewContract.startMyfilesPickerActivity();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract
    public void startRequestAuthorizationActivity(@Nullable Intent intent) {
        this.mImportFolderViewContract.startRequestAuthorizationActivity(intent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract
    public void startSNBAKPickerActivity() {
        this.mImportFolderViewContract.startSNBAKPickerActivity();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract
    public void updateFolderLayout() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C88151(null), 3, null);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract, com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.view.dialog.ImportFolderDialogContract
    public void updateLayout() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C88171(null), 3, null);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract
    public void updateSelectedItemCount() {
        updateSelectedItemCount(this.mPresenter.getItemCount(), this.mPresenter.getCheckedItemCount());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract
    public void updateValidateFolderPath(@NotNull String folderName) {
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        this.mPresenter.updateValidateFolderPath(folderName);
    }
}
