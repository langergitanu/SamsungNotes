package com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor;

import android.content.Context;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectPainting;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.document.SpenObjectWeb;
import com.samsung.android.sdk.pen.engine.SpenCapturePage;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\b\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\rH\u0007J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\b\u0010\u001a\u001a\u00020\u001bH\u0007¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/constructor/SpenObjectConstructor;", "", "<init>", "()V", "makeSpenCapturePage", "Lcom/samsung/android/sdk/pen/engine/SpenCapturePage;", "context", "Landroid/content/Context;", "makeObjectPainting", "Lcom/samsung/android/sdk/pen/document/SpenObjectPainting;", "makeObjectImage", "Lcom/samsung/android/sdk/pen/document/SpenObjectImage;", "makeObjectTextBox", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "content", "", "makeObjectVoice", "Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "makeVoiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "makeObjectWeb", "Lcom/samsung/android/sdk/pen/document/SpenObjectWeb;", "makeObjectShape", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "type", "", "makeObjectStroke", "Lcom/samsung/android/sdk/pen/document/SpenObjectStroke;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenObjectConstructor {

    @NotNull
    public static final SpenObjectConstructor INSTANCE = new SpenObjectConstructor();

    private SpenObjectConstructor() {
    }

    @JvmStatic
    @NotNull
    public static final SpenObjectImage makeObjectImage() {
        return new SpenObjectImage();
    }

    @JvmStatic
    @NotNull
    public static final SpenObjectPainting makeObjectPainting() {
        return new SpenObjectPainting();
    }

    @JvmStatic
    @NotNull
    public static final SpenObjectShape makeObjectShape() {
        return new SpenObjectShape();
    }

    @JvmStatic
    @NotNull
    public static final SpenObjectStroke makeObjectStroke() {
        return new SpenObjectStroke();
    }

    @JvmStatic
    @NotNull
    public static final SpenObjectTextBox makeObjectTextBox() {
        return new SpenObjectTextBox();
    }

    @JvmStatic
    @NotNull
    public static final SpenObjectVoice makeObjectVoice() {
        return new SpenObjectVoice();
    }

    @JvmStatic
    @NotNull
    public static final SpenObjectWeb makeObjectWeb() {
        return new SpenObjectWeb();
    }

    @JvmStatic
    @NotNull
    public static final SpenCapturePage makeSpenCapturePage(@Nullable Context context) {
        return new SpenCapturePage(context);
    }

    @JvmStatic
    @NotNull
    public static final SpenVoiceData makeVoiceData() {
        return new SpenVoiceData();
    }

    @JvmStatic
    @NotNull
    public static final SpenObjectShape makeObjectShape(int type) {
        return new SpenObjectShape(type);
    }

    @JvmStatic
    @NotNull
    public static final SpenObjectTextBox makeObjectTextBox(@Nullable String content) {
        return new SpenObjectTextBox(content);
    }
}
