package com.samsung.android.sdk.pen.document;

import android.graphics.PointF;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectFactory;", "", "<init>", "()V", "createObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "type", "", "isTemplateObject", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenObjectFactory {

    @NotNull
    public static final SpenObjectFactory INSTANCE = new SpenObjectFactory();

    private SpenObjectFactory() {
    }

    @JvmStatic
    @Nullable
    public static final SpenObjectBase createObject(int type) {
        switch (type) {
            case 1:
                return new SpenObjectStroke("");
            case 2:
                return new SpenObjectTextBox("");
            case 3:
                SpenObjectImage spenObjectImage = new SpenObjectImage();
                spenObjectImage.setImage((String) null);
                return spenObjectImage;
            case 4:
                return new SpenObjectContainer((ArrayList<SpenObjectBase>) null);
            case 5:
            case 6:
            case 9:
            case 12:
            case 15:
            case 18:
            case 22:
            default:
                return null;
            case 7:
                return new SpenObjectShape();
            case 8:
                return new SpenObjectLine(0, new PointF(0.0f, 0.0f), new PointF(0.0f, 0.0f));
            case 10:
                return new SpenObjectVoice();
            case 11:
                return new SpenObjectFormula();
            case 13:
                return new SpenObjectWeb();
            case 14:
                return new SpenObjectPainting();
            case 16:
                return new SpenObjectVideo();
            case 17:
                return new SpenObjectLink();
            case 19:
                return new SpenObjectUnknown();
            case 20:
                return new SpenObjectPlot();
            case 21:
                return new SpenObjectMath();
            case 23:
                return new SpenObjectCodeBlock();
        }
    }

    @JvmStatic
    @Nullable
    public static final SpenObjectBase createObject(int type, boolean isTemplateObject) {
        switch (type) {
            case 1:
                return new SpenObjectStroke(isTemplateObject);
            case 2:
                return new SpenObjectTextBox(isTemplateObject);
            case 3:
                SpenObjectImage spenObjectImage = new SpenObjectImage(isTemplateObject);
                spenObjectImage.setImage((String) null);
                return spenObjectImage;
            case 4:
                return new SpenObjectContainer(isTemplateObject);
            case 5:
            case 6:
            case 9:
            case 12:
            case 15:
            case 18:
            default:
                return null;
            case 7:
                return new SpenObjectShape(0, isTemplateObject);
            case 8:
                return new SpenObjectLine(0, new PointF(0.0f, 0.0f), new PointF(0.0f, 0.0f));
            case 10:
                return new SpenObjectVoice(isTemplateObject);
            case 11:
                return new SpenObjectFormula(isTemplateObject);
            case 13:
                return new SpenObjectWeb(isTemplateObject);
            case 14:
                return new SpenObjectPainting(isTemplateObject);
            case 16:
                return new SpenObjectVideo(isTemplateObject);
            case 17:
                return new SpenObjectLink(isTemplateObject);
            case 19:
                return new SpenObjectUnknown(isTemplateObject);
            case 20:
                return new SpenObjectPlot(isTemplateObject);
            case 21:
                return new SpenObjectMath(isTemplateObject);
        }
    }
}
