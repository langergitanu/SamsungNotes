package com.google.common.collect;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import com.google.errorprone.annotations.DoNotMock;
import com.samsung.android.sdk.smp.common.constants.FeedbackDetailConstants;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@GwtCompatible
@DoNotMock("Use ImmutableTable, HashBasedTable, or another implementation")
@ElementTypesAreNonnullByDefault
public interface Table<R, C, V> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Cell<R, C, V> {
        boolean equals(@CheckForNull Object obj);

        @ParametricNullness
        C getColumnKey();

        @ParametricNullness
        R getRowKey();

        @ParametricNullness
        V getValue();

        int hashCode();
    }

    Set<Cell<R, C, V>> cellSet();

    void clear();

    Map<R, V> column(@ParametricNullness C c);

    Set<C> columnKeySet();

    Map<C, Map<R, V>> columnMap();

    boolean contains(@CheckForNull @CompatibleWith("R") Object obj, @CheckForNull @CompatibleWith(FeedbackDetailConstants.PREFIX_CLIENT_ERROR) Object obj2);

    boolean containsColumn(@CheckForNull @CompatibleWith(FeedbackDetailConstants.PREFIX_CLIENT_ERROR) Object obj);

    boolean containsRow(@CheckForNull @CompatibleWith("R") Object obj);

    boolean containsValue(@CheckForNull @CompatibleWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED) Object obj);

    boolean equals(@CheckForNull Object obj);

    @CheckForNull
    V get(@CheckForNull @CompatibleWith("R") Object obj, @CheckForNull @CompatibleWith(FeedbackDetailConstants.PREFIX_CLIENT_ERROR) Object obj2);

    int hashCode();

    boolean isEmpty();

    @CanIgnoreReturnValue
    @CheckForNull
    V put(@ParametricNullness R r, @ParametricNullness C c, @ParametricNullness V v);

    void putAll(Table<? extends R, ? extends C, ? extends V> table);

    @CanIgnoreReturnValue
    @CheckForNull
    V remove(@CheckForNull @CompatibleWith("R") Object obj, @CheckForNull @CompatibleWith(FeedbackDetailConstants.PREFIX_CLIENT_ERROR) Object obj2);

    Map<C, V> row(@ParametricNullness R r);

    Set<R> rowKeySet();

    Map<R, Map<C, V>> rowMap();

    int size();

    Collection<V> values();
}
