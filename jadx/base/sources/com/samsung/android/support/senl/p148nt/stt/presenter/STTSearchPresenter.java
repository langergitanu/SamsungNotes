package com.samsung.android.support.senl.p148nt.stt.presenter;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.stt.base.model.AiTextData;
import com.samsung.android.support.senl.p148nt.stt.base.model.mode.STTMode;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.common.util.search.SearchFoundItem;
import com.samsung.android.support.senl.p148nt.stt.controller.STTFloatingController;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListViewAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0007\u0018\u0000 <2\u00020\u0001:\u0002<=B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fJ\u001e\u0010 \u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007J\u000e\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0011J\u0006\u0010'\u001a\u00020\u0019J\u0006\u0010(\u001a\u00020\u0019J\u0006\u0010)\u001a\u00020\u0019J\u001a\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020.H\u0002J\u000e\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u001cJ\u0006\u00101\u001a\u00020\u001cJ\u0006\u00102\u001a\u00020\u001cJ\u0006\u00103\u001a\u00020\u0019J\u0006\u00104\u001a\u00020\u0019J\u0012\u00105\u001a\u00020\u001c2\b\u00106\u001a\u0004\u0018\u000107H\u0002J\u0006\u00108\u001a\u00020\u0019J\u0006\u00109\u001a\u00020\u0019J\u000e\u0010:\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u001cR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/presenter/STTSearchPresenter;", "", "sttPresenter", "Lcom/samsung/android/support/senl/nt/stt/presenter/STTPresenter;", "<init>", "(Lcom/samsung/android/support/senl/nt/stt/presenter/STTPresenter;)V", "mAiMenuSTTSearchListener", "Lcom/samsung/android/support/senl/nt/stt/presenter/AiMenuSTTSearchListener;", "mSTTFloatingController", "Lcom/samsung/android/support/senl/nt/stt/controller/STTFloatingController;", "mSTTPresenter", "mAiSTTListViewAdapter", "Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListViewAdapter;", "mAiTextDataItems", "", "Lcom/samsung/android/support/senl/nt/stt/base/model/AiTextData;", "mLastSearchPosition", "", "mPresenterScope", "Lkotlinx/coroutines/CoroutineScope;", "getMPresenterScope", "()Lkotlinx/coroutines/CoroutineScope;", "mSearchJob", "Lkotlinx/coroutines/Job;", "setAiMenuSTTSearchListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getDataFromAdapter", "", "setMode", "mode", "Lcom/samsung/android/support/senl/nt/stt/base/model/mode/STTMode;", "search", Bixby2Constants.BIXBY_PARAM_KEYWORD, "", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/support/senl/nt/stt/presenter/STTSearchPresenter$Callback;", "searchPosition", "index", "searchForward", "searchLatest", "searchBackward", "scrollToFoundItem", "searchFoundItem", "Lcom/samsung/android/support/senl/nt/stt/common/util/search/SearchFoundItem;", "scrollDirection", "Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListView$ScrollItemDirection;", "getCurrentSearchSTTIndex", "isFromBackward", "canForward", "canBackward", "clearSearchFocus", "clearSearchInfo", "isEmptyOrBlank", "str", "", "onBackPressed", "onDestroy", "onMinimize", "isMinimized", "Companion", "Callback", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class STTSearchPresenter {

    @NotNull
    private static final String TAG = "STTSearchPresenter";

    @Nullable
    private AiMenuSTTSearchListener mAiMenuSTTSearchListener;
    private AiSTTListViewAdapter mAiSTTListViewAdapter;

    @Nullable
    private List<AiTextData> mAiTextDataItems;
    private int mLastSearchPosition;

    @NotNull
    private final CoroutineScope mPresenterScope;

    @NotNull
    private STTFloatingController mSTTFloatingController;

    @NotNull
    private STTPresenter mSTTPresenter;

    @Nullable
    private Job mSearchJob;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/presenter/STTSearchPresenter$Callback;", "", "onSearchDone", "", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Callback {
        void onSearchDone();
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.presenter.STTSearchPresenter$search$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.stt.presenter.STTSearchPresenter$search$1", m14021f = "STTSearchPresenter.kt", m14022i = {}, m14023l = {82}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C115161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Callback $callback;
        final /* synthetic */ List<AiTextData> $dataItems;
        final /* synthetic */ String $keyword;
        final /* synthetic */ boolean $showSpeakerLabel;
        final /* synthetic */ long $startTime;
        final /* synthetic */ boolean $translateMode;
        int label;
        final /* synthetic */ STTSearchPresenter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C115161(String str, STTSearchPresenter sTTSearchPresenter, long j, Callback callback, List<AiTextData> list, boolean z, boolean z2, Continuation<? super C115161> continuation) {
            super(2, continuation);
            this.$keyword = str;
            this.this$0 = sTTSearchPresenter;
            this.$startTime = j;
            this.$callback = callback;
            this.$dataItems = list;
            this.$showSpeakerLabel = z;
            this.$translateMode = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C115161(this.$keyword, this.this$0, this.$startTime, this.$callback, this.$dataItems, this.$showSpeakerLabel, this.$translateMode, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Logger.m12710d(STTSearchPresenter.TAG, "search# starting background STT seach for: " + this.$keyword);
                CoroutineDispatcher coroutineDispatcher = Dispatchers.getDefault();
                STTSearchPresenter$search$1$searchResults$1 sTTSearchPresenter$search$1$searchResults$1 = new STTSearchPresenter$search$1$searchResults$1(this.$keyword, this.$dataItems, this.this$0, this.$showSpeakerLabel, this.$translateMode, null);
                this.label = 1;
                obj = BuildersKt.withContext(coroutineDispatcher, sTTSearchPresenter$search$1$searchResults$1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            List list = (List) obj;
            Logger.m12710d(STTSearchPresenter.TAG, "search# background search completed");
            AiSTTListViewAdapter aiSTTListViewAdapter = this.this$0.mAiSTTListViewAdapter;
            AiSTTListViewAdapter aiSTTListViewAdapter2 = null;
            if (aiSTTListViewAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                aiSTTListViewAdapter = null;
            }
            aiSTTListViewAdapter.getFoundItemList().addAll(list);
            AiSTTListViewAdapter aiSTTListViewAdapter3 = this.this$0.mAiSTTListViewAdapter;
            if (aiSTTListViewAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                aiSTTListViewAdapter3 = null;
            }
            aiSTTListViewAdapter3.notifyDataSetChanged();
            AiSTTListViewAdapter aiSTTListViewAdapter4 = this.this$0.mAiSTTListViewAdapter;
            if (aiSTTListViewAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
            } else {
                aiSTTListViewAdapter2 = aiSTTListViewAdapter4;
            }
            boolean isTranslateMode = aiSTTListViewAdapter2.getIsTranslateMode();
            String str = this.$keyword;
            if (str == null) {
                str = "null";
            }
            Logger.m12710d(STTSearchPresenter.TAG, "search# done hasTranslatedData =" + isTranslateMode + " / word= " + str + " / numOfFounds=" + list.size() + " / time=" + (System.currentTimeMillis() - this.$startTime) + "ms");
            AiMenuSTTSearchListener aiMenuSTTSearchListener = this.this$0.mAiMenuSTTSearchListener;
            if (aiMenuSTTSearchListener != null) {
                aiMenuSTTSearchListener.onSearchDone();
            }
            Callback callback = this.$callback;
            if (callback != null) {
                callback.onSearchDone();
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C115161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public STTSearchPresenter(@NotNull STTPresenter sttPresenter) {
        Intrinsics.checkNotNullParameter(sttPresenter, "sttPresenter");
        this.mSTTFloatingController = sttPresenter.getFloatingController();
        this.mSTTPresenter = sttPresenter;
        this.mLastSearchPosition = -1;
        this.mPresenterScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        if (getDataFromAdapter()) {
            return;
        }
        Logger.m12710d(TAG, "init# false to getDataFromAdapter");
    }

    private final boolean getDataFromAdapter() {
        if (this.mSTTFloatingController.getSttListView() != null) {
            AiSTTListView sttListView = this.mSTTFloatingController.getSttListView();
            AiSTTListViewAdapter aiSTTListViewAdapter = null;
            if ((sttListView != null ? sttListView.getMAiSTTListViewAdapter() : null) != null) {
                AiSTTListView sttListView2 = this.mSTTFloatingController.getSttListView();
                AiSTTListViewAdapter mAiSTTListViewAdapter = sttListView2 != null ? sttListView2.getMAiSTTListViewAdapter() : null;
                Intrinsics.checkNotNull(mAiSTTListViewAdapter);
                this.mAiSTTListViewAdapter = mAiSTTListViewAdapter;
                if (mAiSTTListViewAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                } else {
                    aiSTTListViewAdapter = mAiSTTListViewAdapter;
                }
                List<AiTextData> aiTextDataItems = aiSTTListViewAdapter.getAiTextDataItems();
                this.mAiTextDataItems = aiTextDataItems;
                List<AiTextData> list = aiTextDataItems;
                return !(list == null || list.isEmpty());
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isEmptyOrBlank(CharSequence str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        Integer numValueOf = str != null ? Integer.valueOf(str.length()) : null;
        Intrinsics.checkNotNull(numValueOf);
        int iIntValue = numValueOf.intValue();
        for (int i = 0; i < iIntValue; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private final void scrollToFoundItem(SearchFoundItem searchFoundItem, AiSTTListView.ScrollItemDirection scrollDirection) {
        AiSTTListView.ScrollItemType scrollItemType = searchFoundItem.getDeltaPosition() == 0 ? AiSTTListView.ScrollItemType.SPEAKER_NAME : searchFoundItem.getIsTranslatedItem() ? AiSTTListView.ScrollItemType.TRANSLATE_TEXT : AiSTTListView.ScrollItemType.STT_CONTENT;
        int i = searchFoundItem.position;
        int i2 = this.mLastSearchPosition;
        AiSTTListViewAdapter aiSTTListViewAdapter = null;
        if (i != i2) {
            if (i2 != -1) {
                AiSTTListViewAdapter aiSTTListViewAdapter2 = this.mAiSTTListViewAdapter;
                if (aiSTTListViewAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                    aiSTTListViewAdapter2 = null;
                }
                aiSTTListViewAdapter2.notifyItemChanged(this.mLastSearchPosition);
            }
            this.mLastSearchPosition = searchFoundItem.position;
        }
        AiSTTListView sttListView = this.mSTTFloatingController.getSttListView();
        if (sttListView != null) {
            sttListView.scrollToItem(searchFoundItem.position, searchFoundItem.getKeywordStart(), true, scrollItemType, scrollDirection);
        }
        AiSTTListView sttListView2 = this.mSTTFloatingController.getSttListView();
        if (sttListView2 != null) {
            sttListView2.setMUserScrollTime(System.currentTimeMillis());
        }
        AiSTTListViewAdapter aiSTTListViewAdapter3 = this.mAiSTTListViewAdapter;
        if (aiSTTListViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
        } else {
            aiSTTListViewAdapter = aiSTTListViewAdapter3;
        }
        aiSTTListViewAdapter.notifyItemChanged(searchFoundItem.position);
    }

    public static /* synthetic */ void scrollToFoundItem$default(STTSearchPresenter sTTSearchPresenter, SearchFoundItem searchFoundItem, AiSTTListView.ScrollItemDirection scrollItemDirection, int i, Object obj) {
        if ((i & 2) != 0) {
            scrollItemDirection = AiSTTListView.ScrollItemDirection.DOWN;
        }
        sTTSearchPresenter.scrollToFoundItem(searchFoundItem, scrollItemDirection);
    }

    public static /* synthetic */ void search$default(STTSearchPresenter sTTSearchPresenter, String str, Callback callback, int i, Object obj) {
        if ((i & 2) != 0) {
            callback = null;
        }
        sTTSearchPresenter.search(str, callback);
    }

    public final boolean canBackward() {
        if ((this.mSTTPresenter.getCurrentMode() != STTMode.SEARCH && this.mSTTPresenter.getCurrentMode() != STTMode.SEARCH_COMPOSER) || !getDataFromAdapter()) {
            return false;
        }
        AiSTTListViewAdapter aiSTTListViewAdapter = this.mAiSTTListViewAdapter;
        AiSTTListViewAdapter aiSTTListViewAdapter2 = null;
        if (aiSTTListViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
            aiSTTListViewAdapter = null;
        }
        ArrayList<SearchFoundItem> foundItemList = aiSTTListViewAdapter.getFoundItemList();
        AiSTTListViewAdapter aiSTTListViewAdapter3 = this.mAiSTTListViewAdapter;
        if (aiSTTListViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
        } else {
            aiSTTListViewAdapter2 = aiSTTListViewAdapter3;
        }
        int currentSearchPosition = aiSTTListViewAdapter2.getCurrentSearchPosition();
        return foundItemList.size() > 0 && currentSearchPosition > 0 && currentSearchPosition < foundItemList.size();
    }

    public final boolean canForward() {
        if ((this.mSTTPresenter.getCurrentMode() != STTMode.SEARCH && this.mSTTPresenter.getCurrentMode() != STTMode.SEARCH_COMPOSER) || !getDataFromAdapter()) {
            return false;
        }
        AiSTTListViewAdapter aiSTTListViewAdapter = this.mAiSTTListViewAdapter;
        AiSTTListViewAdapter aiSTTListViewAdapter2 = null;
        if (aiSTTListViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
            aiSTTListViewAdapter = null;
        }
        ArrayList<SearchFoundItem> foundItemList = aiSTTListViewAdapter.getFoundItemList();
        AiSTTListViewAdapter aiSTTListViewAdapter3 = this.mAiSTTListViewAdapter;
        if (aiSTTListViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
        } else {
            aiSTTListViewAdapter2 = aiSTTListViewAdapter3;
        }
        int currentSearchPosition = aiSTTListViewAdapter2.getCurrentSearchPosition();
        return foundItemList.size() > 0 && currentSearchPosition >= -1 && currentSearchPosition < foundItemList.size() - 1;
    }

    public final void clearSearchFocus() {
        Job job = this.mSearchJob;
        AiSTTListViewAdapter aiSTTListViewAdapter = null;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        AiSTTListViewAdapter aiSTTListViewAdapter2 = this.mAiSTTListViewAdapter;
        if (aiSTTListViewAdapter2 != null) {
            if (aiSTTListViewAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                aiSTTListViewAdapter2 = null;
            }
            AiSTTListViewAdapter aiSTTListViewAdapter3 = this.mAiSTTListViewAdapter;
            if (aiSTTListViewAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                aiSTTListViewAdapter3 = null;
            }
            aiSTTListViewAdapter2.setCurrentSearchPosition(aiSTTListViewAdapter3.getFoundItemList().size());
            AiSTTListViewAdapter aiSTTListViewAdapter4 = this.mAiSTTListViewAdapter;
            if (aiSTTListViewAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
            } else {
                aiSTTListViewAdapter = aiSTTListViewAdapter4;
            }
            aiSTTListViewAdapter.notifyDataSetChanged();
        }
    }

    public final void clearSearchInfo() {
        AiSTTListViewAdapter aiSTTListViewAdapter;
        Job job = this.mSearchJob;
        AiSTTListViewAdapter aiSTTListViewAdapter2 = null;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if ((this.mSTTPresenter.getCurrentMode() == STTMode.SEARCH || this.mSTTPresenter.getCurrentMode() == STTMode.SEARCH_COMPOSER) && getDataFromAdapter() && (aiSTTListViewAdapter = this.mAiSTTListViewAdapter) != null) {
            if (aiSTTListViewAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                aiSTTListViewAdapter = null;
            }
            aiSTTListViewAdapter.getFoundItemList().clear();
            AiSTTListViewAdapter aiSTTListViewAdapter3 = this.mAiSTTListViewAdapter;
            if (aiSTTListViewAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                aiSTTListViewAdapter3 = null;
            }
            aiSTTListViewAdapter3.setCurrentSearchPosition(-1);
            AiSTTListViewAdapter aiSTTListViewAdapter4 = this.mAiSTTListViewAdapter;
            if (aiSTTListViewAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
            } else {
                aiSTTListViewAdapter2 = aiSTTListViewAdapter4;
            }
            aiSTTListViewAdapter2.notifyDataSetChanged();
        }
    }

    public final int getCurrentSearchSTTIndex(boolean isFromBackward) {
        int i;
        if ((this.mSTTPresenter.getCurrentMode() != STTMode.SEARCH && this.mSTTPresenter.getCurrentMode() != STTMode.SEARCH_COMPOSER) || !getDataFromAdapter()) {
            return -1;
        }
        AiSTTListViewAdapter aiSTTListViewAdapter = this.mAiSTTListViewAdapter;
        AiSTTListViewAdapter aiSTTListViewAdapter2 = null;
        if (aiSTTListViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
            aiSTTListViewAdapter = null;
        }
        ArrayList<SearchFoundItem> foundItemList = aiSTTListViewAdapter.getFoundItemList();
        AiSTTListViewAdapter aiSTTListViewAdapter3 = this.mAiSTTListViewAdapter;
        if (aiSTTListViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
        } else {
            aiSTTListViewAdapter2 = aiSTTListViewAdapter3;
        }
        int currentSearchPosition = aiSTTListViewAdapter2.getCurrentSearchPosition();
        if (foundItemList.size() > 0 && currentSearchPosition >= 0 && currentSearchPosition < foundItemList.size()) {
            if (isFromBackward && currentSearchPosition - 1 >= 0) {
                return currentSearchPosition - 1;
            }
            if (!isFromBackward && (i = currentSearchPosition + 1) < foundItemList.size()) {
                return i;
            }
        }
        return -1;
    }

    @NotNull
    public final CoroutineScope getMPresenterScope() {
        return this.mPresenterScope;
    }

    public final void onBackPressed() {
        if (this.mSTTPresenter.getCurrentMode() == STTMode.SEARCH) {
            this.mSTTPresenter.toggleSTTSearchMode();
        }
    }

    public final void onDestroy() {
        CoroutineScopeKt.cancel$default(this.mPresenterScope, null, 1, null);
    }

    public final void onMinimize(boolean isMinimized) {
        AiMenuSTTSearchListener aiMenuSTTSearchListener = this.mAiMenuSTTSearchListener;
        if (aiMenuSTTSearchListener != null) {
            aiMenuSTTSearchListener.onResultViewMinimize(isMinimized);
        }
    }

    @JvmOverloads
    public final void search(@Nullable String str) {
        search$default(this, str, null, 2, null);
    }

    public final void searchBackward() {
        int i;
        if ((this.mSTTPresenter.getCurrentMode() == STTMode.SEARCH || this.mSTTPresenter.getCurrentMode() == STTMode.SEARCH_COMPOSER) && getDataFromAdapter()) {
            AiSTTListViewAdapter aiSTTListViewAdapter = this.mAiSTTListViewAdapter;
            AiSTTListViewAdapter aiSTTListViewAdapter2 = null;
            if (aiSTTListViewAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                aiSTTListViewAdapter = null;
            }
            ArrayList<SearchFoundItem> foundItemList = aiSTTListViewAdapter.getFoundItemList();
            AiSTTListViewAdapter aiSTTListViewAdapter3 = this.mAiSTTListViewAdapter;
            if (aiSTTListViewAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                aiSTTListViewAdapter3 = null;
            }
            int currentSearchPosition = aiSTTListViewAdapter3.getCurrentSearchPosition();
            if (foundItemList.isEmpty() || currentSearchPosition <= 0 || currentSearchPosition - 1 >= foundItemList.size()) {
                return;
            }
            AiSTTListViewAdapter aiSTTListViewAdapter4 = this.mAiSTTListViewAdapter;
            if (aiSTTListViewAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
            } else {
                aiSTTListViewAdapter2 = aiSTTListViewAdapter4;
            }
            aiSTTListViewAdapter2.setCurrentSearchPosition(i);
            SearchFoundItem searchFoundItem = foundItemList.get(i);
            Intrinsics.checkNotNullExpressionValue(searchFoundItem, "get(...)");
            scrollToFoundItem(searchFoundItem, AiSTTListView.ScrollItemDirection.f7921UP);
        }
    }

    public final void searchForward() {
        if ((this.mSTTPresenter.getCurrentMode() == STTMode.SEARCH || this.mSTTPresenter.getCurrentMode() == STTMode.SEARCH_COMPOSER) && getDataFromAdapter()) {
            AiSTTListViewAdapter aiSTTListViewAdapter = this.mAiSTTListViewAdapter;
            AiSTTListViewAdapter aiSTTListViewAdapter2 = null;
            if (aiSTTListViewAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                aiSTTListViewAdapter = null;
            }
            ArrayList<SearchFoundItem> foundItemList = aiSTTListViewAdapter.getFoundItemList();
            if (foundItemList.isEmpty()) {
                return;
            }
            AiSTTListViewAdapter aiSTTListViewAdapter3 = this.mAiSTTListViewAdapter;
            if (aiSTTListViewAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                aiSTTListViewAdapter3 = null;
            }
            if (aiSTTListViewAdapter3.getCurrentSearchPosition() + 1 >= foundItemList.size()) {
                return;
            }
            AiSTTListViewAdapter aiSTTListViewAdapter4 = this.mAiSTTListViewAdapter;
            if (aiSTTListViewAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                aiSTTListViewAdapter4 = null;
            }
            int currentSearchPosition = aiSTTListViewAdapter4.getCurrentSearchPosition() + 1;
            if (currentSearchPosition < 0 || currentSearchPosition >= foundItemList.size()) {
                return;
            }
            AiSTTListViewAdapter aiSTTListViewAdapter5 = this.mAiSTTListViewAdapter;
            if (aiSTTListViewAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
            } else {
                aiSTTListViewAdapter2 = aiSTTListViewAdapter5;
            }
            aiSTTListViewAdapter2.setCurrentSearchPosition(currentSearchPosition);
            SearchFoundItem searchFoundItem = foundItemList.get(currentSearchPosition);
            Intrinsics.checkNotNullExpressionValue(searchFoundItem, "get(...)");
            scrollToFoundItem(searchFoundItem, AiSTTListView.ScrollItemDirection.DOWN);
        }
    }

    public final void searchLatest() {
        int size;
        if ((this.mSTTPresenter.getCurrentMode() == STTMode.SEARCH || this.mSTTPresenter.getCurrentMode() == STTMode.SEARCH_COMPOSER) && getDataFromAdapter()) {
            AiSTTListViewAdapter aiSTTListViewAdapter = this.mAiSTTListViewAdapter;
            if (aiSTTListViewAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                aiSTTListViewAdapter = null;
            }
            ArrayList<SearchFoundItem> foundItemList = aiSTTListViewAdapter.getFoundItemList();
            if (foundItemList.isEmpty()) {
                return;
            }
            AiSTTListViewAdapter aiSTTListViewAdapter2 = this.mAiSTTListViewAdapter;
            if (aiSTTListViewAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                aiSTTListViewAdapter2 = null;
            }
            if (aiSTTListViewAdapter2.getCurrentSearchPosition() + 1 < foundItemList.size() && foundItemList.size() - 1 >= 0 && size < foundItemList.size()) {
                AiSTTListViewAdapter aiSTTListViewAdapter3 = this.mAiSTTListViewAdapter;
                if (aiSTTListViewAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                    aiSTTListViewAdapter3 = null;
                }
                aiSTTListViewAdapter3.setCurrentSearchPosition(size);
                SearchFoundItem searchFoundItem = foundItemList.get(size);
                Intrinsics.checkNotNullExpressionValue(searchFoundItem, "get(...)");
                scrollToFoundItem$default(this, searchFoundItem, null, 2, null);
            }
        }
    }

    public final void searchPosition(int index) {
        if ((this.mSTTPresenter.getCurrentMode() == STTMode.SEARCH || this.mSTTPresenter.getCurrentMode() == STTMode.SEARCH_COMPOSER) && getDataFromAdapter()) {
            AiSTTListViewAdapter aiSTTListViewAdapter = this.mAiSTTListViewAdapter;
            if (aiSTTListViewAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                aiSTTListViewAdapter = null;
            }
            ArrayList<SearchFoundItem> foundItemList = aiSTTListViewAdapter.getFoundItemList();
            if (foundItemList.isEmpty()) {
                return;
            }
            AiSTTListViewAdapter aiSTTListViewAdapter2 = this.mAiSTTListViewAdapter;
            if (aiSTTListViewAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                aiSTTListViewAdapter2 = null;
            }
            if (aiSTTListViewAdapter2.getCurrentSearchPosition() + 1 < foundItemList.size() && index >= 0 && index < foundItemList.size()) {
                AiSTTListViewAdapter aiSTTListViewAdapter3 = this.mAiSTTListViewAdapter;
                if (aiSTTListViewAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                    aiSTTListViewAdapter3 = null;
                }
                aiSTTListViewAdapter3.setCurrentSearchPosition(index);
                AiSTTListViewAdapter aiSTTListViewAdapter4 = this.mAiSTTListViewAdapter;
                if (aiSTTListViewAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                    aiSTTListViewAdapter4 = null;
                }
                SearchFoundItem searchFoundItem = foundItemList.get(aiSTTListViewAdapter4.getCurrentSearchPosition());
                Intrinsics.checkNotNullExpressionValue(searchFoundItem, "get(...)");
                scrollToFoundItem$default(this, searchFoundItem, null, 2, null);
            }
        }
    }

    public final void setAiMenuSTTSearchListener(@NotNull AiMenuSTTSearchListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mAiMenuSTTSearchListener = listener;
    }

    public final void setMode(@NotNull STTMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.mSTTPresenter.setMode(mode);
    }

    @JvmOverloads
    public final void search(@Nullable String keyword, @Nullable Callback callback) {
        Job job = this.mSearchJob;
        AiSTTListViewAdapter aiSTTListViewAdapter = null;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if ((this.mSTTPresenter.getCurrentMode() == STTMode.SEARCH || this.mSTTPresenter.getCurrentMode() == STTMode.SEARCH_COMPOSER) && getDataFromAdapter()) {
            AiSTTListViewAdapter aiSTTListViewAdapter2 = this.mAiSTTListViewAdapter;
            if (aiSTTListViewAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                aiSTTListViewAdapter2 = null;
            }
            aiSTTListViewAdapter2.getFoundItemList().clear();
            AiSTTListViewAdapter aiSTTListViewAdapter3 = this.mAiSTTListViewAdapter;
            if (aiSTTListViewAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                aiSTTListViewAdapter3 = null;
            }
            aiSTTListViewAdapter3.setCurrentSearchPosition(-1);
            if (isEmptyOrBlank(keyword)) {
                AiSTTListViewAdapter aiSTTListViewAdapter4 = this.mAiSTTListViewAdapter;
                if (aiSTTListViewAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                } else {
                    aiSTTListViewAdapter = aiSTTListViewAdapter4;
                }
                aiSTTListViewAdapter.notifyDataSetChanged();
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            AiSTTListViewAdapter aiSTTListViewAdapter5 = this.mAiSTTListViewAdapter;
            if (aiSTTListViewAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
                aiSTTListViewAdapter5 = null;
            }
            boolean isShowSpeakerLabel = aiSTTListViewAdapter5.getIsShowSpeakerLabel();
            AiSTTListViewAdapter aiSTTListViewAdapter6 = this.mAiSTTListViewAdapter;
            if (aiSTTListViewAdapter6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiSTTListViewAdapter");
            } else {
                aiSTTListViewAdapter = aiSTTListViewAdapter6;
            }
            this.mSearchJob = BuildersKt__Builders_commonKt.launch$default(this.mPresenterScope, null, null, new C115161(keyword, this, jCurrentTimeMillis, callback, this.mAiTextDataItems, isShowSpeakerLabel, aiSTTListViewAdapter.getIsTranslateMode(), null), 3, null);
        }
    }
}
