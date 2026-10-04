package com.squareup.javapoet;

import java.util.function.Consumer;

/* JADX INFO: renamed from: com.squareup.javapoet.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11722g implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8270a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CodeWriter f8271b;

    public /* synthetic */ C11722g(CodeWriter codeWriter, int i) {
        this.f8270a = i;
        this.f8271b = codeWriter;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f8270a) {
            case 0:
                this.f8271b.lambda$popTypeVariables$1((TypeVariableName) obj);
                break;
            default:
                this.f8271b.lambda$emitTypeVariables$0((TypeVariableName) obj);
                break;
        }
    }
}
