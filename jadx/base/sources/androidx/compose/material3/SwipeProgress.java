package androidx.compose.material3;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.Immutable;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@ExperimentalMaterial3Api
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000b¨\u0006\u0015"}, m13886d2 = {"Landroidx/compose/material3/SwipeProgress;", "T", "", Constants.MessagePayloadKeys.FROM, "to", "fraction", "", "(Ljava/lang/Object;Ljava/lang/Object;F)V", "getFraction", "()F", "getFrom", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTo", "equals", "", "other", "hashCode", "", "toString", "", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SwipeProgress<T> {
    private final float fraction;
    private final T from;
    private final T to;

    public SwipeProgress(T t, T t2, float f) {
        this.from = t;
        this.to = t2;
        this.fraction = f;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SwipeProgress)) {
            return false;
        }
        SwipeProgress swipeProgress = (SwipeProgress) other;
        return Intrinsics.areEqual(this.from, swipeProgress.from) && Intrinsics.areEqual(this.to, swipeProgress.to) && this.fraction == swipeProgress.fraction;
    }

    public final float getFraction() {
        return this.fraction;
    }

    public final T getFrom() {
        return this.from;
    }

    public final T getTo() {
        return this.to;
    }

    public int hashCode() {
        T t = this.from;
        int iHashCode = (t != null ? t.hashCode() : 0) * 31;
        T t2 = this.to;
        return Float.hashCode(this.fraction) + ((iHashCode + (t2 != null ? t2.hashCode() : 0)) * 31);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("SwipeProgress(from=");
        sb.append(this.from);
        sb.append(", to=");
        sb.append(this.to);
        sb.append(", fraction=");
        return AbstractC0622a.m1171q(sb, this.fraction, PropertyUtils.MAPPED_DELIM2);
    }
}
