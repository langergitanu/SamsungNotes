package com.samsung.android.support.senl.p148nt.base.composer.share;

import android.text.TextUtils;
import com.samsung.android.sdk.pen.document.SpenObjectCodeBlock;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/share/HandleCodeBlock;", "", "<init>", "()V", "handleObject", "", "content", "Lcom/samsung/android/sdk/pen/document/SpenObjectCodeBlock;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class HandleCodeBlock {
    @NotNull
    public final String handleObject(@NotNull SpenObjectCodeBlock content) {
        Intrinsics.checkNotNullParameter(content, "content");
        StringBuilder sb = new StringBuilder();
        SpenObjectTextBox title = content.getTitle();
        if (title != null && !TextUtils.isEmpty(title.getText())) {
            sb.append(title.getText());
            sb.append("\n");
        }
        SpenObjectTextBox body = content.getBody();
        if (body != null && !TextUtils.isEmpty(body.getText())) {
            sb.append(body.getText());
            sb.append("\n");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
