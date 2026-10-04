package com.vladsch.flexmark.util.visitor;

import com.samsung.android.imagetranslation.inpainting.C7126a;
import com.vladsch.flexmark.util.visitor.AstAction;
import com.vladsch.flexmark.util.visitor.AstActionHandler;
import com.vladsch.flexmark.util.visitor.AstHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AstActionHandler<C extends AstActionHandler<C, N, A, H>, N, A extends AstAction<N>, H extends AstHandler<N, A>> {

    @NotNull
    private final AstNode<N> astAdapter;

    @NotNull
    private final Map<Class<? extends N>, H> customHandlersMap = new HashMap();

    public AstActionHandler(@NotNull AstNode<N> astNode) {
        this.astAdapter = astNode;
    }

    @Nullable
    private A getAction(@Nullable H h) {
        if (h == null) {
            return null;
        }
        return (A) h.getAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$processNodeOnly$0(Object[] objArr, BiFunction biFunction, Object obj, AstAction astAction) {
        objArr[0] = biFunction.apply(obj, astAction);
    }

    @NotNull
    public C addActionHandler(@NotNull H h) {
        this.customHandlersMap.put(h.getNodeType(), h);
        return this;
    }

    @SafeVarargs
    @NotNull
    public final C addActionHandlers(@NotNull H[]... hArr) {
        for (H[] hArr2 : hArr) {
            for (H h : hArr2) {
                this.customHandlersMap.put(h.getNodeType(), h);
            }
        }
        return this;
    }

    @Nullable
    public H getHandler(@NotNull N n) {
        return this.customHandlersMap.get(n.getClass());
    }

    @NotNull
    public Set<Class<? extends N>> getNodeClasses() {
        return this.customHandlersMap.keySet();
    }

    public final void processChildren(@NotNull N n, @NotNull BiConsumer<N, A> biConsumer) {
        N firstChild = this.astAdapter.getFirstChild(n);
        while (firstChild != null) {
            N next = this.astAdapter.getNext(firstChild);
            processNode(firstChild, true, biConsumer);
            firstChild = next;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void processNode(@NotNull N n, boolean z, @NotNull BiConsumer<N, A> biConsumer) {
        AstAction action = getAction(n);
        if (action != null) {
            biConsumer.accept(n, action);
        } else if (z) {
            processChildren(n, biConsumer);
        }
    }

    public final <R> R processNodeOnly(@NotNull N n, R r, @NotNull BiFunction<N, A, R> biFunction) {
        Object[] objArr = {r};
        processNode(n, false, new C7126a(objArr, biFunction, 6));
        return (R) objArr[0];
    }

    @Nullable
    public A getAction(@NotNull N n) {
        return (A) getAction((AstHandler) this.customHandlersMap.get(n.getClass()));
    }

    @Nullable
    public H getHandler(@NotNull Class<?> cls) {
        return this.customHandlersMap.get(cls);
    }

    @Nullable
    public A getAction(@NotNull Class<?> cls) {
        return (A) getAction((AstHandler) this.customHandlersMap.get(cls));
    }
}
