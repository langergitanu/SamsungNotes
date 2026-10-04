package androidx.compose.p109ui.graphics;

import androidx.annotation.RestrictTo;
import androidx.collection.AbstractC0622a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0086\u0002J\u0013\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0015\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0016\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, m13886d2 = {"Landroidx/compose/ui/graphics/Interval;", "T", "", "start", "", "end", "data", "(FFLjava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getEnd", "()F", "getStart", "contains", "", "value", "equals", "other", "hashCode", "", "overlaps", "toString", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class Interval<T> {

    @Nullable
    private final T data;
    private final float end;
    private final float start;

    public Interval(float f, float f4, @Nullable T t) {
        this.start = f;
        this.end = f4;
        this.data = t;
    }

    public final boolean contains(float value) {
        return value <= this.end && this.start <= value;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && getClass() == other.getClass()) {
            Interval interval = (Interval) other;
            return this.start == interval.start && this.end == interval.end && Intrinsics.areEqual(this.data, interval.data);
        }
        return false;
    }

    @Nullable
    public final T getData() {
        return this.data;
    }

    public final float getEnd() {
        return this.end;
    }

    public final float getStart() {
        return this.start;
    }

    public int hashCode() {
        int iM1156b = AbstractC0622a.m1156b(this.end, Float.hashCode(this.start) * 31, 31);
        T t = this.data;
        return iM1156b + (t != null ? t.hashCode() : 0);
    }

    public final boolean overlaps(@NotNull Interval<T> other) {
        return this.start <= other.end && this.end >= other.start;
    }

    @NotNull
    public String toString() {
        return "Interval(start=" + this.start + ", end=" + this.end + ", data=" + this.data + PropertyUtils.MAPPED_DELIM2;
    }

    public final boolean overlaps(float start, float end) {
        return this.start <= end && this.end >= start;
    }

    public /* synthetic */ Interval(float f, float f4, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f4, (i & 4) != 0 ? null : obj);
    }
}
