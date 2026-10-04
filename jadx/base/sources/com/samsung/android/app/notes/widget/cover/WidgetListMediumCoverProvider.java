package com.samsung.android.app.notes.widget.cover;

import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.WidgetListProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/cover/WidgetListMediumCoverProvider;", "Lcom/samsung/android/app/notes/widget/WidgetListProvider;", "<init>", "()V", "providerName", "", "getProviderName", "()Ljava/lang/String;", "setProviderName", "(Ljava/lang/String;)V", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetListMediumCoverProvider extends WidgetListProvider {

    @NotNull
    public static final String TAG = "WidgetListMediumCoverProvider";

    @NotNull
    private String providerName = TAG;
    public static final int $stable = 8;

    @Override // com.samsung.android.app.notes.widget.WidgetListProvider
    @NotNull
    public String getProviderName() {
        return this.providerName;
    }

    public void setProviderName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.providerName = str;
    }
}
