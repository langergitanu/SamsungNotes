package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectCodeBlock;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.composer.html.common.HtmlConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/CodeBlockObject;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/DocumentElement;", "title", "", "code", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", DynamicActionBarProvider.METHOD_GET_DATA, "()Ljava/lang/String;", "getCode", "convertObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class CodeBlockObject extends DocumentElement {

    @NotNull
    private final String code;

    @NotNull
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeBlockObject(@NotNull String title, @NotNull String code) {
        super(null);
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(code, "code");
        this.title = title;
        this.code = code;
    }

    public static /* synthetic */ CodeBlockObject copy$default(CodeBlockObject codeBlockObject, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = codeBlockObject.title;
        }
        if ((i & 2) != 0) {
            str2 = codeBlockObject.code;
        }
        return codeBlockObject.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.html.logic.DocumentElement
    @NotNull
    public SpenObjectBase convertObject() {
        SpenObjectCodeBlock spenObjectCodeBlock = new SpenObjectCodeBlock();
        SpenObjectTextBox title = spenObjectCodeBlock.getTitle();
        if (title != null) {
            title.setFontSize(15.0f);
            title.setTextColor(BaseUtils.getContext().getColor(C8875R.color.html_code_block_title_color));
            title.setText(this.title);
        }
        SpenObjectTextBox body = spenObjectCodeBlock.getBody();
        if (body != null) {
            body.setFontSize(15.0f);
            body.setTextColor(HtmlConstants.INSTANCE.getDEF_FONT_COLOR());
            body.setText(this.code);
        }
        spenObjectCodeBlock.setSelectable(false);
        return spenObjectCodeBlock;
    }

    @NotNull
    public final CodeBlockObject copy(@NotNull String title, @NotNull String code) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(code, "code");
        return new CodeBlockObject(title, code);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CodeBlockObject)) {
            return false;
        }
        CodeBlockObject codeBlockObject = (CodeBlockObject) other;
        return Intrinsics.areEqual(this.title, codeBlockObject.title) && Intrinsics.areEqual(this.code, codeBlockObject.code);
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return this.code.hashCode() + (this.title.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return AbstractC0541b.m775q("CodeBlockObject(title=", this.title, ", code=", this.code, ")");
    }
}
