package org.apache.commons.lang3.exception;

import android.view.View;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectBase;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.ImageUtil;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.text.TextStringBuilder;
import org.apache.commons.text.diff.CommandVisitor;
import org.apache.commons.text.diff.EditCommand;

/* JADX INFO: renamed from: org.apache.commons.lang3.exception.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13834b implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9824a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9825b;

    public /* synthetic */ C13834b(Object obj, int i) {
        this.f9824a = i;
        this.f9825b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f9824a) {
            case 0:
                ((PrintStream) this.f9825b).println((String) obj);
                break;
            case 1:
                ((PrintWriter) this.f9825b).println((String) obj);
                break;
            case 2:
                ((Function) this.f9825b).apply(obj);
                break;
            case 3:
                Failable.accept((FailableConsumer<Object, E>) this.f9825b, obj);
                break;
            case 4:
                ((List) this.f9825b).add((Method) obj);
                break;
            case 5:
                ((StrBuilder) this.f9825b).append(obj);
                break;
            case 6:
                ((org.apache.commons.text.StrBuilder) this.f9825b).append(obj);
                break;
            case 7:
                ((TextStringBuilder) this.f9825b).append(obj);
                break;
            case 8:
                ((EditCommand) obj).accept((CommandVisitor) this.f9825b);
                break;
            case 9:
                ImageUtil.addGenerativeEditExtraData((SpenObjectImage) this.f9825b);
                break;
            default:
                VibeEffectBase.destroy$lambda$15((VibeEffectBase) this.f9825b, (View) obj);
                break;
        }
    }
}
