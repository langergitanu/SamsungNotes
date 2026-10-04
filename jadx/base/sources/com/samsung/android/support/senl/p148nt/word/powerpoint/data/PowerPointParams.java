package com.samsung.android.support.senl.p148nt.word.powerpoint.data;

import com.samsung.android.support.senl.p148nt.word.data.OfficeParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0014¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0014¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/powerpoint/data/PowerPointParams;", "Lcom/samsung/android/support/senl/nt/word/data/OfficeParams;", "<init>", "()V", "getSizesRecognize", "", "", "()[Ljava/lang/Integer;", "getFontSize", "", "fontSize", "getTextRecognizeDefaultFontSize", "Companion", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PowerPointParams extends OfficeParams {
    public static final double FONT_SIZE_DEFAULT = 50.0d;
    public static final int TEXT_RECOGNIZE_DEFAULT_FONT_SIZE = 30;

    public PowerPointParams() {
        this.width = 1870;
        this.height = 1323;
        this.marginLeft = 0;
        this.marginRight = 0;
        this.marginTop = 0;
        this.marginBottom = 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.word.data.OfficeParams
    public double getFontSize(int fontSize) {
        return (int) (((double) (fontSize - getFontSizeDelta())) * 2.2d);
    }

    @Override // com.samsung.android.support.senl.p148nt.word.data.OfficeParams
    @NotNull
    public Integer[] getSizesRecognize() {
        return new Integer[]{60, 57, 54, 51, 47, 44, 41, 38, 35};
    }

    @Override // com.samsung.android.support.senl.p148nt.word.data.OfficeParams
    public int getTextRecognizeDefaultFontSize() {
        return 30;
    }
}
