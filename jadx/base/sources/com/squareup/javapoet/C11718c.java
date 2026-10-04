package com.squareup.javapoet;

import com.squareup.javapoet.CodeBlock;
import java.util.function.BinaryOperator;

/* JADX INFO: renamed from: com.squareup.javapoet.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11718c implements BinaryOperator {
    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return ((CodeBlock.CodeBlockJoiner) obj).merge((CodeBlock.CodeBlockJoiner) obj2);
    }
}
