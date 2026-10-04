package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/MarkdownElementUtil;", "", "<init>", "()V", "createTextBox", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "text", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MarkdownElementUtil {

    @NotNull
    public static final MarkdownElementUtil INSTANCE = new MarkdownElementUtil();

    private MarkdownElementUtil() {
    }

    @Nullable
    public final SpenObjectTextBox createTextBox(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        SpenObjectBase spenObjectBaseConvertObject = new TextBox(text, new ArrayList(), null, null, 0, false, 60, null).convertObject();
        if (spenObjectBaseConvertObject instanceof SpenObjectTextBox) {
            return (SpenObjectTextBox) spenObjectBaseConvertObject;
        }
        return null;
    }
}
