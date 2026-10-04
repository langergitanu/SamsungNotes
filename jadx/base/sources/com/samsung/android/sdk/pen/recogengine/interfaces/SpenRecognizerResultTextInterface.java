package com.samsung.android.sdk.pen.recogengine.interfaces;

import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerResultInterface;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/interfaces/SpenRecognizerResultTextInterface;", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerResultInterface;", "getResultString", "", "index", "", "getResultCount", "getStrokeIndex", "", "characterIndex", "getStartStrokeIndex", "getEndStrokeIndex", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenRecognizerResultTextInterface extends SpenRecognizerResultInterface {
    int getEndStrokeIndex(int characterIndex);

    int getResultCount();

    @Nullable
    String getResultString(int index);

    int getStartStrokeIndex(int characterIndex);

    @Nullable
    List<Integer> getStrokeIndex(int characterIndex);
}
