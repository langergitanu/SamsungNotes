package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@DoNotMock("Use Iterators.peekingIterator")
@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface PeekingIterator<E> extends Iterator<E> {
    @Override // java.util.Iterator
    @ParametricNullness
    @CanIgnoreReturnValue
    E next();

    @ParametricNullness
    E peek();

    @Override // java.util.Iterator
    void remove();
}
