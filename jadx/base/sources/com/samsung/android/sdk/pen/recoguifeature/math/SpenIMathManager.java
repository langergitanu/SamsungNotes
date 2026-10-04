package com.samsung.android.sdk.pen.recoguifeature.math;

import com.samsung.android.sdk.pen.document.SpenObjectMath;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0012\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H&J(\u0010\u0018\u001a\u00020\t2\u001e\u0010\u0019\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001aj\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u0001`\u001cH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenIMathManager;", "", "modelPath", "", "getModelPath", "()Ljava/lang/String;", "fontPath", "getFontPath", "setHwrMathListener", "", "l", "Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenHwrMathListener;", "setMathHelperListener", "Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathHelperListener;", "setMathPlotListener", "Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathPlotListener;", "setHwrMathEnabled", "", "enabled", "setAnswerColor", "color", "", "setLocale", "locale", "releaseMathObjectList", "objectMathList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectMath;", "Lkotlin/collections/ArrayList;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenIMathManager {
    @Nullable
    String getFontPath();

    @Nullable
    String getModelPath();

    void releaseMathObjectList(@Nullable ArrayList<SpenObjectMath> objectMathList);

    void setAnswerColor(int color);

    boolean setHwrMathEnabled(boolean enabled);

    void setHwrMathListener(@Nullable SpenHwrMathListener l);

    void setLocale(@Nullable String locale);

    void setMathHelperListener(@Nullable SpenMathHelperListener l);

    void setMathPlotListener(@Nullable SpenMathPlotListener l);
}
