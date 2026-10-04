package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@DoNotMock("Use ImmutableClassToInstanceMap or MutableClassToInstanceMap")
@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface ClassToInstanceMap<B> extends Map<Class<? extends B>, B> {
    @CheckForNull
    <T extends B> T getInstance(Class<T> cls);

    @CanIgnoreReturnValue
    @CheckForNull
    <T extends B> T putInstance(Class<T> cls, @ParametricNullness T t);
}
