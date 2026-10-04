package com.samsung.android.app.sdk.deepsky.textextraction.translate.engine;

import com.sun.imageio.plugins.jpeg.JPEG;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.VexImageTranslationEngine", m14021f = "VexImageTranslationEngine.kt", m14022i = {}, m14023l = {JPEG.COM}, m14024m = "translateImage-BWLJW6A", m14025n = {}, m14026s = {})
public final class VexImageTranslationEngine$translateImage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VexImageTranslationEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VexImageTranslationEngine$translateImage$1(VexImageTranslationEngine vexImageTranslationEngine, Continuation<? super VexImageTranslationEngine$translateImage$1> continuation) {
        super(continuation);
        this.this$0 = vexImageTranslationEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM22151translateImageBWLJW6A = this.this$0.m22151translateImageBWLJW6A(null, null, null, this);
        return objM22151translateImageBWLJW6A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM22151translateImageBWLJW6A : Result.m22214boximpl(objM22151translateImageBWLJW6A);
    }
}
