package com.samsung.android.support.senl.p148nt.model.markdown.generator.model;

import com.samsung.android.support.senl.p148nt.model.markdown.generator.model.component.MarkdownComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/markdown/generator/model/MarkdownDocument;", "", "<init>", "()V", "components", "", "Lcom/samsung/android/support/senl/nt/model/markdown/generator/model/component/MarkdownComponent;", "getComponents", "()Ljava/util/List;", "addComponent", "", "component", "Companion", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MarkdownDocument {

    @NotNull
    public static final String NEW_LINE = "\n\n";

    @NotNull
    private final List<MarkdownComponent> components = new ArrayList();

    public final void addComponent(@NotNull MarkdownComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.components.add(component);
    }

    @NotNull
    public final List<MarkdownComponent> getComponents() {
        return this.components;
    }
}
