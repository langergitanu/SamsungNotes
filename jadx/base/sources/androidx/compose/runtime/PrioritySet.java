package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0007R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Landroidx/compose/runtime/PrioritySet;", "", XmlErrorCodes.LIST, "", "", "(Ljava/util/List;)V", "add", "", "value", "isEmpty", "", "isNotEmpty", "peek", "takeMax", "validateHeap", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSlotTable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlotTable.kt\nandroidx/compose/runtime/PrioritySet\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 Preconditions.kt\nandroidx/compose/runtime/PreconditionsKt\n*L\n1#1,4179:1\n4553#2,7:4180\n61#3,7:4187\n61#3,7:4194\n*S KotlinDebug\n*F\n+ 1 SlotTable.kt\nandroidx/compose/runtime/PrioritySet\n*L\n4120#1:4180,7\n4168#1:4187,7\n4169#1:4194,7\n*E\n"})
public final class PrioritySet {
    public static final int $stable = 8;

    @NotNull
    private final List<Integer> list;

    /* JADX WARN: Multi-variable type inference failed */
    public PrioritySet() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final void add(int value) {
        if (this.list.isEmpty() || !(this.list.get(0).intValue() == value || ((Number) AbstractC0000a.m10g(this.list, 1)).intValue() == value)) {
            int size = this.list.size();
            this.list.add(Integer.valueOf(value));
            while (size > 0) {
                int i = ((size + 1) >>> 1) - 1;
                int iIntValue = this.list.get(i).intValue();
                if (value <= iIntValue) {
                    break;
                }
                this.list.set(size, Integer.valueOf(iIntValue));
                size = i;
            }
            this.list.set(size, Integer.valueOf(value));
        }
    }

    public final boolean isEmpty() {
        return this.list.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !this.list.isEmpty();
    }

    public final int peek() {
        return ((Number) CollectionsKt.first((List) this.list)).intValue();
    }

    public final int takeMax() {
        int iIntValue;
        if (!(this.list.size() > 0)) {
            ComposerKt.composeImmediateRuntimeError("Set is empty");
        }
        int iIntValue2 = this.list.get(0).intValue();
        while (!this.list.isEmpty() && this.list.get(0).intValue() == iIntValue2) {
            List<Integer> list = this.list;
            list.set(0, (Integer) CollectionsKt.last((List) list));
            List<Integer> list2 = this.list;
            list2.remove(list2.size() - 1);
            int size = this.list.size();
            int size2 = this.list.size() >>> 1;
            int i = 0;
            while (i < size2) {
                int iIntValue3 = this.list.get(i).intValue();
                int i2 = (i + 1) * 2;
                int i4 = i2 - 1;
                int iIntValue4 = this.list.get(i4).intValue();
                if (i2 >= size || (iIntValue = this.list.get(i2).intValue()) <= iIntValue4) {
                    if (iIntValue4 > iIntValue3) {
                        this.list.set(i, Integer.valueOf(iIntValue4));
                        this.list.set(i4, Integer.valueOf(iIntValue3));
                        i = i4;
                    }
                } else if (iIntValue > iIntValue3) {
                    this.list.set(i, Integer.valueOf(iIntValue));
                    this.list.set(i2, Integer.valueOf(iIntValue3));
                    i = i2;
                }
            }
        }
        return iIntValue2;
    }

    public final void validateHeap() {
        int size = this.list.size();
        int i = size / 2;
        int i2 = 0;
        while (i2 < i) {
            int i4 = i2 + 1;
            int i5 = i4 * 2;
            boolean z = true;
            if (!(this.list.get(i2).intValue() >= this.list.get(i5 + (-1)).intValue())) {
                PreconditionsKt.throwIllegalStateException("Check failed.");
            }
            if (i5 < size && this.list.get(i2).intValue() < this.list.get(i5).intValue()) {
                z = false;
            }
            if (!z) {
                PreconditionsKt.throwIllegalStateException("Check failed.");
            }
            i2 = i4;
        }
    }

    public PrioritySet(@NotNull List<Integer> list) {
        this.list = list;
    }

    public /* synthetic */ PrioritySet(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }
}
