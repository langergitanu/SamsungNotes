package androidx.glance.oneui.template.preview;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, m13886d2 = {"<anonymous>", "Landroidx/datastore/preferences/core/Preferences;", LangPackConfigConstants.LANGUAGE_CODE_IT}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.oneui.template.preview.PreviewStateKt$updateAppWidgetPreviewState$2", m14021f = "PreviewState.kt", m14022i = {}, m14023l = {81}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
@SourceDebugExtension({"SMAP\nPreviewState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreviewState.kt\nandroidx/glance/oneui/template/preview/PreviewStateKt$updateAppWidgetPreviewState$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,217:1\n1#2:218\n*E\n"})
public final class PreviewStateKt$updateAppWidgetPreviewState$2 extends SuspendLambda implements Function2<Preferences, Continuation<? super Preferences>, Object> {
    final /* synthetic */ Function2<MutablePreferences, Continuation<? super Unit>, Object> $updateState;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PreviewStateKt$updateAppWidgetPreviewState$2(Function2<? super MutablePreferences, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super PreviewStateKt$updateAppWidgetPreviewState$2> continuation) {
        super(2, continuation);
        this.$updateState = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PreviewStateKt$updateAppWidgetPreviewState$2 previewStateKt$updateAppWidgetPreviewState$2 = new PreviewStateKt$updateAppWidgetPreviewState$2(this.$updateState, continuation);
        previewStateKt$updateAppWidgetPreviewState$2.L$0 = obj;
        return previewStateKt$updateAppWidgetPreviewState$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull Preferences preferences, @Nullable Continuation<? super Preferences> continuation) {
        return ((PreviewStateKt$updateAppWidgetPreviewState$2) create(preferences, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
            ResultKt.throwOnFailure(obj);
            return mutablePreferences;
        }
        ResultKt.throwOnFailure(obj);
        MutablePreferences mutablePreferences2 = ((Preferences) this.L$0).toMutablePreferences();
        Function2<MutablePreferences, Continuation<? super Unit>, Object> function2 = this.$updateState;
        this.L$0 = mutablePreferences2;
        this.label = 1;
        return function2.invoke(mutablePreferences2, this) == coroutine_suspended ? coroutine_suspended : mutablePreferences2;
    }
}
