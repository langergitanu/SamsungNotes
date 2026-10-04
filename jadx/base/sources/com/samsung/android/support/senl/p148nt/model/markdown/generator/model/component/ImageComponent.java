package com.samsung.android.support.senl.p148nt.model.markdown.generator.model.component;

import androidx.appcompat.widget.AbstractC0541b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/markdown/generator/model/component/ImageComponent;", "Lcom/samsung/android/support/senl/nt/model/markdown/generator/model/component/MarkdownComponent;", "content", "", "<init>", "(Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "render", "Companion", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImageComponent extends MarkdownComponent {

    @NotNull
    public static final String TAG = "![ ]";

    @NotNull
    private final String content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageComponent(@NotNull String content) {
        super(content);
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.markdown.generator.model.component.MarkdownComponent
    @NotNull
    public String getContent() {
        return this.content;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.markdown.generator.model.component.MarkdownComponent
    @NotNull
    public String render() {
        return AbstractC0541b.m773o("![ ](", getContent(), ")");
    }
}
