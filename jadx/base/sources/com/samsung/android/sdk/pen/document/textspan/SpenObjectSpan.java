package com.samsung.android.sdk.pen.document.textspan;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\t\b\u0010¢\u0006\u0004\b\u0002\u0010\u0003B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0002\u0010\nJ\u001b\u0010\u0018\u001a\u00020\u00192\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0086\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0007R\"\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0010\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0014¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/textspan/SpenObjectSpan;", "", "<init>", "()V", "objectSpan", "(Lcom/samsung/android/sdk/pen/document/textspan/SpenObjectSpan;)V", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "textIndex", "", "(Lcom/samsung/android/sdk/pen/document/SpenObjectBase;I)V", "value", "obj", "getObj", "()Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "getTextIndex", "()I", "layoutOption", "getLayoutOption", "setLayoutOption", "(I)V", "layoutConstraint", "getLayoutConstraint", "setLayoutConstraint", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "", "getObject", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenObjectSpan {
    public static final int LAYOUT_CONSTRAINT_NORMAL = 0;
    public static final int LAYOUT_CONSTRAINT_OVER_PAGES = 2;
    public static final int LAYOUT_CONSTRAINT_OVER_PAGES_OVERLAP_PADDING = 1;
    public static final int LAYOUT_OPTION_BLOCK = 0;
    public static final int LAYOUT_OPTION_BLOCK_WITH_MARGIN_MEDIUM = 3;
    public static final int LAYOUT_OPTION_BLOCK_WITH_MARGIN_SMALL = 2;
    public static final int LAYOUT_OPTION_INLINE = 1;
    private int layoutConstraint;
    private int layoutOption;

    @Nullable
    private SpenObjectBase obj;
    private int textIndex;

    public SpenObjectSpan() {
    }

    public final int getLayoutConstraint() {
        return this.layoutConstraint;
    }

    public final int getLayoutOption() {
        return this.layoutOption;
    }

    @Nullable
    public final SpenObjectBase getObj() {
        return this.obj;
    }

    @Deprecated(message = "Please use [obj] instead.")
    @NotNull
    public final SpenObjectBase getObject() {
        SpenObjectBase spenObjectBase = this.obj;
        Intrinsics.checkNotNull(spenObjectBase);
        return spenObjectBase;
    }

    public final int getTextIndex() {
        return this.textIndex;
    }

    public final void set(@Nullable SpenObjectBase objectBase, int textIndex) {
        this.obj = objectBase;
        this.textIndex = textIndex;
    }

    public final void setLayoutConstraint(int i) {
        this.layoutConstraint = i;
    }

    public final void setLayoutOption(int i) {
        this.layoutOption = i;
    }

    public SpenObjectSpan(@Nullable SpenObjectSpan spenObjectSpan) {
        Intrinsics.checkNotNull(spenObjectSpan);
        set(spenObjectSpan.obj, spenObjectSpan.textIndex);
    }

    public SpenObjectSpan(@Nullable SpenObjectBase spenObjectBase, int i) {
        set(spenObjectBase, i);
    }
}
