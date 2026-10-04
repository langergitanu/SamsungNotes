package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/CodeBlock;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/HtmlNode;", "code", "", "classes", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getCode", "()Ljava/lang/String;", "getClasses", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class CodeBlock extends HtmlNode {

    @NotNull
    private final List<String> classes;

    @NotNull
    private final String code;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeBlock(@NotNull String code, @NotNull List<String> classes) {
        super(null);
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(classes, "classes");
        this.code = code;
        this.classes = classes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CodeBlock copy$default(CodeBlock codeBlock, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = codeBlock.code;
        }
        if ((i & 2) != 0) {
            list = codeBlock.classes;
        }
        return codeBlock.copy(str, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final List<String> component2() {
        return this.classes;
    }

    @NotNull
    public final CodeBlock copy(@NotNull String code, @NotNull List<String> classes) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(classes, "classes");
        return new CodeBlock(code, classes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CodeBlock)) {
            return false;
        }
        CodeBlock codeBlock = (CodeBlock) other;
        return Intrinsics.areEqual(this.code, codeBlock.code) && Intrinsics.areEqual(this.classes, codeBlock.classes);
    }

    @NotNull
    public final List<String> getClasses() {
        return this.classes;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    public int hashCode() {
        return this.classes.hashCode() + (this.code.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "CodeBlock(code=" + this.code + ", classes=" + this.classes + ")";
    }

    public /* synthetic */ CodeBlock(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }
}
