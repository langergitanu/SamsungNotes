package com.vladsch.flexmark.util.misc;

import com.vladsch.flexmark.util.misc.Immutable;
import com.vladsch.flexmark.util.misc.Mutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface Mutable<M extends Mutable<M, I>, I extends Immutable<I, M>> {
    I toImmutable();
}
