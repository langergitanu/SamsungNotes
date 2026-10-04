package com.samsung.android.sdk.pen.recoguifeature.math;

import com.samsung.android.sdk.pen.document.SpenObjectMath;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u001a\u001a\u00020\u000b2\u001e\u0010\u001b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001cj\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u0001`\u001eH\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathManagerNoOP;", "Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenIMathManager;", "<init>", "()V", "modelPath", "", "getModelPath", "()Ljava/lang/String;", "fontPath", "getFontPath", "setHwrMathListener", "", "l", "Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenHwrMathListener;", "setMathHelperListener", "Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathHelperListener;", "setMathPlotListener", "Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathPlotListener;", "setHwrMathEnabled", "", "enabled", "setAnswerColor", "color", "", "setLocale", "locale", "releaseMathObjectList", "objectMathList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectMath;", "Lkotlin/collections/ArrayList;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenMathManagerNoOP implements SpenIMathManager {

    @Nullable
    private final String fontPath;

    @Nullable
    private final String modelPath;

    @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager
    @Nullable
    public String getFontPath() {
        return this.fontPath;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager
    @Nullable
    public String getModelPath() {
        return this.modelPath;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager
    public void releaseMathObjectList(@Nullable ArrayList<SpenObjectMath> objectMathList) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager
    public void setAnswerColor(int color) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager
    public boolean setHwrMathEnabled(boolean enabled) {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager
    public void setHwrMathListener(@Nullable SpenHwrMathListener l) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager
    public void setLocale(@Nullable String locale) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager
    public void setMathHelperListener(@Nullable SpenMathHelperListener l) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager
    public void setMathPlotListener(@Nullable SpenMathPlotListener l) {
    }
}
