package androidx.glance.oneui.template.preview;

import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.oneui.template.preview.PreviewStateKt", m14021f = "PreviewState.kt", m14022i = {0, 0, 0, 0}, m14023l = {95}, m14024m = "updateAppWidgetPreviewStateInternal-rh_Hmrg", m14025n = {"context", "definition", "updateState", LangPackConfigConstants.LANGUAGE_CODE_IT}, m14026s = {"L$0", "L$1", "L$2", "L$3"})
public final class PreviewStateKt$updateAppWidgetPreviewStateInternal$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    public PreviewStateKt$updateAppWidgetPreviewStateInternal$1(Continuation<? super PreviewStateKt$updateAppWidgetPreviewStateInternal$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return PreviewStateKt.m21933updateAppWidgetPreviewStateInternalrh_Hmrg(null, null, null, 0, null, this);
    }
}
