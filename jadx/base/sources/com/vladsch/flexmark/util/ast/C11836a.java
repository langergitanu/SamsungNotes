package com.vladsch.flexmark.util.ast;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanBuilder;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.Function;
import org.apache.commons.collections4.map.PredicatedMap;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableBiConsumer;
import org.apache.commons.lang3.stream.LangCollectors;

/* JADX INFO: renamed from: com.vladsch.flexmark.util.ast.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11836a implements BiConsumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8360a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8361b;

    public /* synthetic */ C11836a(Object obj, int i) {
        this.f8360a = i;
        this.f8361b = obj;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f8360a) {
            case 0:
                ((NodeVisitor) this.f8361b).visit((Node) obj, (Visitor) obj2);
                break;
            case 1:
                ((Span) this.f8361b).lambda$setAllAttributes$0((AttributeKey) obj, obj2);
                break;
            case 2:
                ((SpanBuilder) this.f8361b).lambda$setAllAttributes$0((AttributeKey) obj, obj2);
                break;
            case 3:
                ((PredicatedMap) this.f8361b).validate(obj, obj2);
                break;
            case 4:
                Functions.accept((Functions.FailableBiConsumer) this.f8361b, obj, obj2);
                break;
            case 5:
                Failable.accept((FailableBiConsumer) this.f8361b, obj, obj2);
                break;
            default:
                LangCollectors.lambda$joining$1((Function) this.f8361b, (StringJoiner) obj, obj2);
                break;
        }
    }
}
