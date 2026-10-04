package com.samsung.android.support.senl.p148nt.stt.presenter;

import com.samsung.android.support.senl.p148nt.stt.base.model.AiTextData;
import com.samsung.android.support.senl.p148nt.stt.common.util.search.SearchFoundItem;
import com.samsung.android.support.senl.p148nt.stt.common.util.search.SearchHelper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.YieldKt;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, m13886d2 = {"<anonymous>", "", "Lcom/samsung/android/support/senl/nt/stt/common/util/search/SearchFoundItem;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.stt.presenter.STTSearchPresenter$search$1$searchResults$1", m14021f = "STTSearchPresenter.kt", m14022i = {0, 0, 0}, m14023l = {93}, m14024m = "invokeSuspend", m14025n = {"tempFoundItemList", "searchHelper", "i"}, m14026s = {"L$0", "L$2", "I$0"})
public final class STTSearchPresenter$search$1$searchResults$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<SearchFoundItem>>, Object> {
    final /* synthetic */ List<AiTextData> $dataItems;
    final /* synthetic */ String $keyword;
    final /* synthetic */ boolean $showSpeakerLabel;
    final /* synthetic */ boolean $translateMode;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ STTSearchPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public STTSearchPresenter$search$1$searchResults$1(String str, List<AiTextData> list, STTSearchPresenter sTTSearchPresenter, boolean z, boolean z2, Continuation<? super STTSearchPresenter$search$1$searchResults$1> continuation) {
        super(2, continuation);
        this.$keyword = str;
        this.$dataItems = list;
        this.this$0 = sTTSearchPresenter;
        this.$showSpeakerLabel = z;
        this.$translateMode = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int invokeSuspend$lambda$1(SearchFoundItem searchFoundItem, SearchFoundItem searchFoundItem2) {
        int i = searchFoundItem.position;
        int i2 = searchFoundItem2.position;
        if (i != i2) {
            return i - i2;
        }
        if (!searchFoundItem.getIsTranslatedItem() && searchFoundItem2.getIsTranslatedItem()) {
            return -1;
        }
        if (searchFoundItem.getIsTranslatedItem() && !searchFoundItem2.getIsTranslatedItem()) {
            return 1;
        }
        return (searchFoundItem.getKeywordStart() + searchFoundItem.getDeltaPosition()) - (searchFoundItem2.getKeywordStart() + searchFoundItem2.getDeltaPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int invokeSuspend$lambda$2(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new STTSearchPresenter$search$1$searchResults$1(this.$keyword, this.$dataItems, this.this$0, this.$showSpeakerLabel, this.$translateMode, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0132  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00a7 -> B:33:0x00aa). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        List arrayList;
        Iterator it;
        List listSplit$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            arrayList = new ArrayList();
            String str = this.$keyword;
            List listDistinct = (str == null || (listSplit$default = StringsKt__StringsKt.split$default(str, new String[]{" "}, false, 0, 6, (Object) null)) == null) ? null : CollectionsKt.distinct(listSplit$default);
            if (listDistinct != null && this.$dataItems != null) {
                it = listDistinct.iterator();
                while (it.hasNext()) {
                }
            }
            final C11530i c11530i = new C11530i();
            CollectionsKt.sortWith(arrayList, new Comparator() { // from class: com.samsung.android.support.senl.nt.stt.presenter.j
                @Override // java.util.Comparator
                public final int compare(Object obj2, Object obj3) {
                    return STTSearchPresenter$search$1$searchResults$1.invokeSuspend$lambda$2(c11530i, obj2, obj3);
                }
            });
            return arrayList;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = this.I$1;
        int i4 = this.I$0;
        SearchHelper searchHelper = (SearchHelper) this.L$2;
        Iterator it2 = (Iterator) this.L$1;
        List list = (List) this.L$0;
        ResultKt.throwOnFailure(obj);
        AiTextData aiTextData = this.$dataItems.get(i4);
        boolean z = this.$showSpeakerLabel;
        boolean z2 = this.$translateMode;
        AiTextData aiTextData2 = aiTextData;
        if (z) {
            list.addAll(searchHelper.setPosition(i4).setText(aiTextData2.getSpeakerName().toString()).setDeltaPosition(0).setTranslation(false).search());
        }
        list.addAll(searchHelper.setPosition(i4).setText(aiTextData2.getText().toString()).setDeltaPosition(aiTextData2.getSpeakerName().toString().length()).setTranslation(false).search());
        if (z2) {
            list.addAll(searchHelper.setText(String.valueOf(aiTextData2.getTranslatedText())).setDeltaPosition(aiTextData2.getText().toString().length()).setTranslation(true).search());
        }
        if (i4 != i2) {
            i4++;
            this.L$0 = list;
            this.L$1 = it2;
            this.L$2 = searchHelper;
            this.I$0 = i4;
            this.I$1 = i2;
            this.label = 1;
            if (YieldKt.yield(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            AiTextData aiTextData3 = this.$dataItems.get(i4);
            boolean z3 = this.$showSpeakerLabel;
            boolean z22 = this.$translateMode;
            AiTextData aiTextData22 = aiTextData3;
            if (z3) {
            }
            list.addAll(searchHelper.setPosition(i4).setText(aiTextData22.getText().toString()).setDeltaPosition(aiTextData22.getSpeakerName().toString().length()).setTranslation(false).search());
            if (z22) {
            }
            if (i4 != i2) {
                it = it2;
                arrayList = list;
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (!this.this$0.isEmptyOrBlank(str2)) {
                        searchHelper = new SearchHelper(StringsKt.trim((CharSequence) str2).toString());
                        List list2 = this.this$0.mAiTextDataItems;
                        IntRange indices = list2 != null ? CollectionsKt.getIndices(list2) : null;
                        Intrinsics.checkNotNull(indices);
                        int first = indices.getFirst();
                        int last = indices.getLast();
                        if (first <= last) {
                            it2 = it;
                            i2 = last;
                            i4 = first;
                            list = arrayList;
                            this.L$0 = list;
                            this.L$1 = it2;
                            this.L$2 = searchHelper;
                            this.I$0 = i4;
                            this.I$1 = i2;
                            this.label = 1;
                            if (YieldKt.yield(this) == coroutine_suspended) {
                            }
                            AiTextData aiTextData32 = this.$dataItems.get(i4);
                            boolean z32 = this.$showSpeakerLabel;
                            boolean z222 = this.$translateMode;
                            AiTextData aiTextData222 = aiTextData32;
                            if (z32) {
                            }
                            list.addAll(searchHelper.setPosition(i4).setText(aiTextData222.getText().toString()).setDeltaPosition(aiTextData222.getSpeakerName().toString().length()).setTranslation(false).search());
                            if (z222) {
                            }
                            if (i4 != i2) {
                            }
                        }
                    }
                }
                final C11530i c11530i2 = new C11530i();
                CollectionsKt.sortWith(arrayList, new Comparator() { // from class: com.samsung.android.support.senl.nt.stt.presenter.j
                    @Override // java.util.Comparator
                    public final int compare(Object obj2, Object obj3) {
                        return STTSearchPresenter$search$1$searchResults$1.invokeSuspend$lambda$2(c11530i2, obj2, obj3);
                    }
                });
                return arrayList;
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<SearchFoundItem>> continuation) {
        return ((STTSearchPresenter$search$1$searchResults$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
