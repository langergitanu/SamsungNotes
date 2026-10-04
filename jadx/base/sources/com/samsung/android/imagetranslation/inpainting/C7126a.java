package com.samsung.android.imagetranslation.inpainting;

import android.graphics.Bitmap;
import com.vladsch.flexmark.ast.util.AttributeProvidingHandler;
import com.vladsch.flexmark.html.renderer.AttributablePart;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.html.MutableAttributeImpl;
import com.vladsch.flexmark.util.html.MutableAttributes;
import com.vladsch.flexmark.util.visitor.AstAction;
import com.vladsch.flexmark.util.visitor.AstActionHandler;
import io.opentelemetry.context.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import org.apache.commons.lang3.concurrent.BackgroundInitializer;
import org.apache.commons.lang3.concurrent.MultiBackgroundInitializer;

/* JADX INFO: renamed from: com.samsung.android.imagetranslation.inpainting.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7126a implements BiConsumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4782a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f4783b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f4784c;

    public /* synthetic */ C7126a(Object obj, Object obj2, int i) {
        this.f4782a = i;
        this.f4783b = obj;
        this.f4784c = obj2;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f4782a) {
            case 0:
                ((InpainterHelper) this.f4783b).lambda$getInpaintedFrame$0((InpainterParam) this.f4784c, (Bitmap) obj, (Throwable) obj2);
                break;
            case 1:
                AttributeProvidingHandler.AttributeProvidingVisitor attributeProvidingVisitor = (AttributeProvidingHandler.AttributeProvidingVisitor) obj2;
                attributeProvidingVisitor.setAttributes((Node) obj, (AttributablePart) this.f4783b, (MutableAttributes) this.f4784c);
                break;
            case 2:
                ((MutableAttributeImpl) this.f4783b).lambda$setValue$0((Map) this.f4784c, (String) obj, (String) obj2);
                break;
            case 3:
                MutableAttributeImpl.lambda$removeValue$1((Map) this.f4783b, (boolean[]) this.f4784c, (String) obj, (String) obj2);
                break;
            case 4:
                ((Context) this.f4783b).lambda$wrapConsumer$7((BiConsumer) this.f4784c, obj, obj2);
                break;
            case 5:
                MultiBackgroundInitializer.lambda$initialize$1((HashMap) this.f4783b, (HashMap) this.f4784c, (String) obj, (BackgroundInitializer) obj2);
                break;
            default:
                AstActionHandler.lambda$processNodeOnly$0((Object[]) this.f4783b, (BiFunction) this.f4784c, obj, (AstAction) obj2);
                break;
        }
    }
}
