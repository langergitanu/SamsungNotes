package com.samsung.android.support.senl.p148nt.app.main.oldnotes.view;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.view.FolderPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task.DataTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import com.samsung.android.support.senl.p148nt.app.main.oldnotes.presenter.OldCategoryPresenter;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 52\u00020\u00012\u00020\u0002:\u000245B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\fJ\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0002J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0006H\u0002J\b\u0010!\u001a\u00020\u0012H\u0002J\b\u0010\"\u001a\u00020\u0012H\u0002J\b\u0010#\u001a\u00020\u0012H\u0002J\b\u0010$\u001a\u00020\u0012H\u0002J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0010H\u0002J\u0010\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020)H\u0016J\b\u0010,\u001a\u00020\u0012H\u0016J\u0010\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u0012H\u0016J\u0012\u00101\u001a\u00020\u00122\b\u00102\u001a\u0004\u0018\u000103H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/oldnotes/view/OldCategoryFragment;", "Lcom/samsung/android/support/senl/nt/app/main/common/view/AbsFragment;", "Lcom/samsung/android/support/senl/nt/app/main/oldnotes/presenter/OldCategoryPresenter$Contract;", "<init>", "()V", "mNoNotes", "Landroid/view/View;", "mRecyclerView", "Lcom/samsung/android/support/senl/nt/app/main/common/view/FolderPenRecyclerView;", "mPresenter", "Lcom/samsung/android/support/senl/nt/app/main/oldnotes/presenter/OldCategoryPresenter;", "mContract", "Lcom/samsung/android/support/senl/nt/app/main/oldnotes/view/OldCategoryFragment$Contract;", "mCheckConvertedNoteTask", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/task/DataTask;", "mIsConvertSuggestionInflated", "", "setContract", "", "contract", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initToolbar", "initBackgroundResources", "rootView", "updateButtonMargin", "initRecyclerView", "initNoNote", "initCheckConvertedNotesLayout", "inflateCheckConvertedNotesView", "isVisible", "onDataChanged", "count", "", "onNotifyBtnClicked", "type", "onResume", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroyView", "onItemSelected", "categoryUuid", "", "Contract", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class OldCategoryFragment extends AbsFragment implements OldCategoryPresenter.Contract {

    @NotNull
    public static final String TAG = "OldCategoryFragment";

    @Nullable
    private DataTask mCheckConvertedNoteTask;

    @Nullable
    private Contract mContract;
    private boolean mIsConvertSuggestionInflated;

    @Nullable
    private View mNoNotes;

    @NotNull
    private final OldCategoryPresenter mPresenter = new OldCategoryPresenter(this);

    @Nullable
    private FolderPenRecyclerView mRecyclerView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/oldnotes/view/OldCategoryFragment$Contract;", "", "onCategorySelected", "", "categoryUuid", "", "startConvertAllNotes", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void onCategorySelected(@Nullable String categoryUuid);

        void startConvertAllNotes();
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.oldnotes.view.OldCategoryFragment$inflateCheckConvertedNotesView$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.main.oldnotes.view.OldCategoryFragment$inflateCheckConvertedNotesView$1", m14021f = "OldCategoryFragment.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C87001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isVisible;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C87001(boolean z, Continuation<? super C87001> continuation) {
            super(2, continuation);
            this.$isVisible = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OldCategoryFragment.this.new C87001(this.$isVisible, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            OldCategoryFragment.this.mPresenter.updateNotifyVisibility(this.$isVisible);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C87001) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.oldnotes.view.OldCategoryFragment$initCheckConvertedNotesLayout$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.main.oldnotes.view.OldCategoryFragment$initCheckConvertedNotesLayout$1", m14021f = "OldCategoryFragment.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C87011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C87011(Continuation<? super C87011> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OldCategoryFragment.this.new C87011(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            OldCategoryFragment oldCategoryFragment = OldCategoryFragment.this;
            oldCategoryFragment.inflateCheckConvertedNotesView(oldCategoryFragment.mPresenter.isOldConvertedDataExist() && !OldCategoryFragment.this.mIsConvertSuggestionInflated);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C87011) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void inflateCheckConvertedNotesView(boolean isVisible) {
        MainLogger.m7258i(TAG, "inflate check_converted_notes_layout");
        this.mIsConvertSuggestionInflated = isVisible;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C87001(isVisible, null), 3, null);
    }

    private final void initBackgroundResources(View rootView) {
        if (DeviceInfo.isVSTModel()) {
            Context context = getContext();
            Intrinsics.checkNotNull(context);
            rootView.setBackgroundColor(ContextCompat.getColor(context, C8003R.color.noteslist_fragment_bg_color_for_vst));
        }
    }

    private final void initCheckConvertedNotesLayout() {
        if (CommonUtil.isNotAvailableActivity(getActivity())) {
            return;
        }
        this.mIsConvertSuggestionInflated = false;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C87011(null), 3, null);
    }

    private final void initNoNote() {
        View view = getView();
        this.mNoNotes = view != null ? view.findViewById(C8003R.id.no_note) : null;
    }

    private final void initRecyclerView() {
        View view = getView();
        FolderPenRecyclerView folderPenRecyclerView = view != null ? (FolderPenRecyclerView) view.findViewById(C8003R.id.old_note_list) : null;
        this.mRecyclerView = folderPenRecyclerView;
        if (folderPenRecyclerView != null) {
            folderPenRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()), 33);
            this.mPresenter.init(folderPenRecyclerView);
            folderPenRecyclerView.seslSetFadingEdgeEnabled(true);
        }
    }

    private final void initToolbar() {
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) activity.findViewById(C8003R.id.collapsing_toolbar);
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setTitle(getString(C8003R.string.upgradable_notes));
            collapsingToolbarLayout.seslSetSubtitle((CharSequence) null);
        }
        FragmentActivity activity2 = getActivity();
        Intrinsics.checkNotNull(activity2);
        ((Toolbar) activity2.findViewById(C8003R.id.toolbar)).setTitle(C8003R.string.upgradable_notes);
    }

    private final void updateButtonMargin() {
        View view = getView();
        if (view != null) {
            view.post(new RunnableC8669a(this, 3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateButtonMargin$lambda$0(OldCategoryFragment oldCategoryFragment) {
        if (oldCategoryFragment.getView() == null) {
            return;
        }
        OldCategoryPresenter oldCategoryPresenter = oldCategoryFragment.mPresenter;
        Intrinsics.checkNotNull(oldCategoryFragment.getView());
        oldCategoryPresenter.updateNotifyBtnMargin((int) (r2.getMeasuredWidth() * 0.1f));
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        updateButtonMargin();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        MainLogger.m7254d(TAG, "onCreateView# ");
        return inflater.inflate(C8003R.layout.old_category_list_fragment, container, false);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.oldnotes.presenter.OldCategoryPresenter.Contract
    public void onDataChanged(int count) {
        View view = this.mNoNotes;
        if (view != null) {
            view.setVisibility(count > 0 ? 8 : 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        DataTask dataTask = this.mCheckConvertedNoteTask;
        if (dataTask != null) {
            dataTask.cancel();
        }
        this.mIsConvertSuggestionInflated = false;
        this.mPresenter.release();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.oldnotes.presenter.OldCategoryPresenter.Contract
    public void onItemSelected(@Nullable String categoryUuid) {
        Contract contract = this.mContract;
        if (contract != null) {
            contract.onCategorySelected(categoryUuid);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.oldnotes.presenter.OldCategoryPresenter.Contract
    public void onNotifyBtnClicked(int type) {
        if (type == 1) {
            MainLogger.m7258i(TAG, "start convert all notes");
            CommonSamsungAnalytics.INSTANCE.insertLog(NotesSAConstants.SCREEN_OLD_CATEGORY, NotesSAConstants.EVENT_OLDNOTES_CONVERTED_NOTES_BUTTON);
            Contract contract = this.mContract;
            if (contract != null) {
                contract.startConvertAllNotes();
                return;
            }
            return;
        }
        if (type != 2) {
            return;
        }
        Contract contract2 = this.mContract;
        if (contract2 != null) {
            contract2.onCategorySelected("old_converted_notes");
        } else {
            MainLogger.m7258i(TAG, "initCheckConvertedNotesLayout(): mContract is null");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        CommonSamsungAnalytics.INSTANCE.insertLog(NotesSAConstants.SCREEN_OLD_CATEGORY);
        updateButtonMargin();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initToolbar();
        initBackgroundResources(view);
        initRecyclerView();
        initNoNote();
        initCheckConvertedNotesLayout();
    }

    public final void setContract(@Nullable Contract contract) {
        this.mContract = contract;
    }
}
