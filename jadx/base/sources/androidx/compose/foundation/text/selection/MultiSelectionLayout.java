package androidx.compose.foundation.text.selection;

import androidx.collection.AbstractC0622a;
import androidx.collection.LongIntMap;
import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0+2\u0006\u0010,\u001a\u00020\rH\u0016J\u001c\u0010-\u001a\u00020.2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020.00H\u0016J\u0010\u00101\u001a\u00020\b2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u0000H\u0002J\u0012\u00106\u001a\u00020\u000b2\b\u00105\u001a\u0004\u0018\u00010\u0001H\u0016J\u0018\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\u000bH\u0002J\u0018\u0010:\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u0010;\u001a\u00020\u000bH\u0002J\b\u0010<\u001a\u00020=H\u0016J2\u0010>\u001a\u00020.*\b\u0012\u0004\u0012\u00020\r0?2\u0006\u0010,\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\bH\u0002R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\t\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0015R\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0019R\u0014\u0010'\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0015R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019¨\u0006C"}, m13886d2 = {"Landroidx/compose/foundation/text/selection/MultiSelectionLayout;", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "selectableIdToInfoListIndex", "Landroidx/collection/LongIntMap;", "infoList", "", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "startSlot", "", "endSlot", "isStartHandle", "", "previousSelection", "Landroidx/compose/foundation/text/selection/Selection;", "(Landroidx/collection/LongIntMap;Ljava/util/List;IIZLandroidx/compose/foundation/text/selection/Selection;)V", "crossStatus", "Landroidx/compose/foundation/text/selection/CrossStatus;", "getCrossStatus", "()Landroidx/compose/foundation/text/selection/CrossStatus;", "currentInfo", "getCurrentInfo", "()Landroidx/compose/foundation/text/selection/SelectableInfo;", "endInfo", "getEndInfo", "getEndSlot", "()I", "firstInfo", "getFirstInfo", "getInfoList", "()Ljava/util/List;", "()Z", "lastInfo", "getLastInfo", "getPreviousSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "getSelectableIdToInfoListIndex", "()Landroidx/collection/LongIntMap;", "size", "getSize", "startInfo", "getStartInfo", "getStartSlot", "createSubSelections", "Landroidx/collection/LongObjectMap;", "selection", "forEachMiddleInfo", "", "block", "Lkotlin/Function1;", "getInfoListIndexBySelectableId", "id", "", "shouldAnyInfoRecomputeSelection", "other", "shouldRecomputeSelection", "slotToIndex", "slot", "isMinimumSlot", "startOrEndSlotToIndex", "isStartSlot", "toString", "", "createAndPutSubSelection", "Landroidx/collection/MutableLongObjectMap;", "info", "minOffset", "maxOffset", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSelectionLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectionLayout.kt\nandroidx/compose/foundation/text/selection/MultiSelectionLayout\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,733:1\n1#2:734\n69#3,6:735\n*S KotlinDebug\n*F\n+ 1 SelectionLayout.kt\nandroidx/compose/foundation/text/selection/MultiSelectionLayout\n*L\n270#1:735,6\n*E\n"})
final class MultiSelectionLayout implements SelectionLayout {
    private final int endSlot;

    @NotNull
    private final List<SelectableInfo> infoList;
    private final boolean isStartHandle;

    @Nullable
    private final Selection previousSelection;

    @NotNull
    private final LongIntMap selectableIdToInfoListIndex;
    private final int startSlot;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CrossStatus.values().length];
            try {
                iArr[CrossStatus.COLLAPSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CrossStatus.NOT_CROSSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CrossStatus.CROSSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MultiSelectionLayout(@NotNull LongIntMap longIntMap, @NotNull List<SelectableInfo> list, int i, int i2, boolean z, @Nullable Selection selection) {
        this.selectableIdToInfoListIndex = longIntMap;
        this.infoList = list;
        this.startSlot = i;
        this.endSlot = i2;
        this.isStartHandle = z;
        this.previousSelection = selection;
        if (list.size() > 1) {
            return;
        }
        throw new IllegalStateException(("MultiSelectionLayout requires an infoList size greater than 1, was " + list.size() + '.').toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createAndPutSubSelection(MutableLongObjectMap<Selection> mutableLongObjectMap, Selection selection, SelectableInfo selectableInfo, int i, int i2) {
        Selection selectionMakeSingleLayoutSelection = selection.getHandlesCrossed() ? selectableInfo.makeSingleLayoutSelection(i2, i) : selectableInfo.makeSingleLayoutSelection(i, i2);
        if (i <= i2) {
            mutableLongObjectMap.put(selectableInfo.getSelectableId(), selectionMakeSingleLayoutSelection);
        } else {
            throw new IllegalStateException(("minOffset should be less than or equal to maxOffset: " + selectionMakeSingleLayoutSelection).toString());
        }
    }

    private final int getInfoListIndexBySelectableId(long id) {
        try {
            return this.selectableIdToInfoListIndex.get(id);
        } catch (NoSuchElementException e) {
            throw new IllegalStateException(AbstractC0622a.m1169o("Invalid selectableId: ", id), e);
        }
    }

    private final boolean shouldAnyInfoRecomputeSelection(MultiSelectionLayout other) {
        if (getSize() != other.getSize()) {
            return true;
        }
        int size = this.infoList.size();
        for (int i = 0; i < size; i++) {
            if (this.infoList.get(i).shouldRecomputeSelection(other.infoList.get(i))) {
                return true;
            }
        }
        return false;
    }

    private final int slotToIndex(int slot, boolean isMinimumSlot) {
        return (slot - (!isMinimumSlot ? 1 : 0)) / 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int startOrEndSlotToIndex(int slot, boolean isStartSlot) {
        int i = WhenMappings.$EnumSwitchMapping$0[getCrossStatus().ordinal()];
        if (i == 1) {
            isStartSlot = true;
        } else if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            if (isStartSlot) {
                isStartSlot = false;
            }
        }
        return slotToIndex(slot, isStartSlot);
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    @NotNull
    public LongObjectMap<Selection> createSubSelections(@NotNull final Selection selection) {
        if (selection.getStart().getSelectableId() != selection.getEnd().getSelectableId()) {
            final MutableLongObjectMap<Selection> mutableLongObjectMapMutableLongObjectMapOf = LongObjectMapKt.mutableLongObjectMapOf();
            createAndPutSubSelection(mutableLongObjectMapMutableLongObjectMapOf, selection, getFirstInfo(), (selection.getHandlesCrossed() ? selection.getEnd() : selection.getStart()).getOffset(), getFirstInfo().getTextLength());
            forEachMiddleInfo(new Function1<SelectableInfo, Unit>() { // from class: androidx.compose.foundation.text.selection.MultiSelectionLayout$createSubSelections$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SelectableInfo selectableInfo) {
                    invoke2(selectableInfo);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull SelectableInfo selectableInfo) {
                    this.this$0.createAndPutSubSelection(mutableLongObjectMapMutableLongObjectMapOf, selection, selectableInfo, 0, selectableInfo.getTextLength());
                }
            });
            createAndPutSubSelection(mutableLongObjectMapMutableLongObjectMapOf, selection, getLastInfo(), 0, (selection.getHandlesCrossed() ? selection.getStart() : selection.getEnd()).getOffset());
            return mutableLongObjectMapMutableLongObjectMapOf;
        }
        if ((selection.getHandlesCrossed() && selection.getStart().getOffset() >= selection.getEnd().getOffset()) || (!selection.getHandlesCrossed() && selection.getStart().getOffset() <= selection.getEnd().getOffset())) {
            return LongObjectMapKt.longObjectMapOf(selection.getStart().getSelectableId(), selection);
        }
        throw new IllegalStateException(("unexpectedly miss-crossed selection: " + selection).toString());
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public void forEachMiddleInfo(@NotNull Function1<? super SelectableInfo, Unit> block) {
        int infoListIndexBySelectableId = getInfoListIndexBySelectableId(getFirstInfo().getSelectableId());
        int infoListIndexBySelectableId2 = getInfoListIndexBySelectableId(getLastInfo().getSelectableId());
        int i = infoListIndexBySelectableId + 1;
        if (i >= infoListIndexBySelectableId2) {
            return;
        }
        while (i < infoListIndexBySelectableId2) {
            block.invoke(this.infoList.get(i));
            i++;
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    @NotNull
    public CrossStatus getCrossStatus() {
        return getStartSlot() < getEndSlot() ? CrossStatus.NOT_CROSSED : getStartSlot() > getEndSlot() ? CrossStatus.CROSSED : this.infoList.get(getStartSlot() / 2).getRawCrossStatus();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    @NotNull
    /* JADX INFO: renamed from: getCurrentInfo */
    public SelectableInfo getInfo() {
        return getIsStartHandle() ? getStartInfo() : getEndInfo();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    @NotNull
    public SelectableInfo getEndInfo() {
        return this.infoList.get(startOrEndSlotToIndex(getEndSlot(), false));
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int getEndSlot() {
        return this.endSlot;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    @NotNull
    public SelectableInfo getFirstInfo() {
        return getCrossStatus() == CrossStatus.CROSSED ? getEndInfo() : getStartInfo();
    }

    @NotNull
    public final List<SelectableInfo> getInfoList() {
        return this.infoList;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    @NotNull
    public SelectableInfo getLastInfo() {
        return getCrossStatus() == CrossStatus.CROSSED ? getStartInfo() : getEndInfo();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    @Nullable
    public Selection getPreviousSelection() {
        return this.previousSelection;
    }

    @NotNull
    public final LongIntMap getSelectableIdToInfoListIndex() {
        return this.selectableIdToInfoListIndex;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int getSize() {
        return this.infoList.size();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    @NotNull
    public SelectableInfo getStartInfo() {
        return this.infoList.get(startOrEndSlotToIndex(getStartSlot(), true));
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int getStartSlot() {
        return this.startSlot;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    /* JADX INFO: renamed from: isStartHandle, reason: from getter */
    public boolean getIsStartHandle() {
        return this.isStartHandle;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public boolean shouldRecomputeSelection(@Nullable SelectionLayout other) {
        if (getPreviousSelection() == null || other == null || !(other instanceof MultiSelectionLayout)) {
            return true;
        }
        MultiSelectionLayout multiSelectionLayout = (MultiSelectionLayout) other;
        return (getIsStartHandle() == multiSelectionLayout.getIsStartHandle() && getStartSlot() == multiSelectionLayout.getStartSlot() && getEndSlot() == multiSelectionLayout.getEndSlot() && !shouldAnyInfoRecomputeSelection(multiSelectionLayout)) ? false : true;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("MultiSelectionLayout(isStartHandle=");
        sb.append(getIsStartHandle());
        sb.append(", startPosition=");
        boolean z = true;
        float f = 2;
        sb.append((getStartSlot() + 1) / f);
        sb.append(", endPosition=");
        sb.append((getEndSlot() + 1) / f);
        sb.append(", crossed=");
        sb.append(getCrossStatus());
        sb.append(", infos=");
        StringBuilder sb2 = new StringBuilder("[\n\t");
        List<SelectableInfo> list = this.infoList;
        int size = list.size();
        int i = 0;
        while (i < size) {
            SelectableInfo selectableInfo = list.get(i);
            if (z) {
                z = false;
            } else {
                sb2.append(",\n\t");
            }
            StringBuilder sb3 = new StringBuilder();
            i++;
            sb3.append(i);
            sb3.append(" -> ");
            sb3.append(selectableInfo);
            sb2.append(sb3.toString());
        }
        sb2.append("\n]");
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        sb.append(string);
        sb.append(PropertyUtils.MAPPED_DELIM2);
        return sb.toString();
    }
}
