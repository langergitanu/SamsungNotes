package com.squareup.javapoet;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.CodeBlock;
import java.lang.reflect.Method;
import java.util.function.Function;

/* JADX INFO: renamed from: com.squareup.javapoet.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11719d implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8265a;

    public /* synthetic */ C11719d(int i) {
        this.f8265a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f8265a) {
            case 0:
                return ((CodeBlock.CodeBlockJoiner) obj).join();
            case 1:
                return ((Method) obj).getName();
            default:
                return AnnotationSpec.Builder.lambda$addMember$0((String) obj);
        }
    }
}
