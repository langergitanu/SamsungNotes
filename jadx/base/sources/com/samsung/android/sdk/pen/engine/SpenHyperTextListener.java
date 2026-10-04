package com.samsung.android.sdk.pen.engine;

import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenHyperTextListener;", "", "onSelected", "", "hyperText", "", "type", "", "objectTextBox", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenHyperTextListener {
    void onSelected(@Nullable String hyperText, int type, @Nullable SpenObjectTextBox objectTextBox);
}
