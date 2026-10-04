package androidx.glance.appwidget;

import androidx.datastore.preferences.core.MutablePreferences;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", LangPackConfigConstants.LANGUAGE_CODE_IT, "Landroidx/datastore/preferences/core/MutablePreferences;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceAppWidgetManager$clearDataStore$2", m14021f = "GlanceAppWidgetManager.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class GlanceAppWidgetManager$clearDataStore$2 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public GlanceAppWidgetManager$clearDataStore$2(Continuation<? super GlanceAppWidgetManager$clearDataStore$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GlanceAppWidgetManager$clearDataStore$2 glanceAppWidgetManager$clearDataStore$2 = new GlanceAppWidgetManager$clearDataStore$2(continuation);
        glanceAppWidgetManager$clearDataStore$2.L$0 = obj;
        return glanceAppWidgetManager$clearDataStore$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull MutablePreferences mutablePreferences, @Nullable Continuation<? super Unit> continuation) {
        return ((GlanceAppWidgetManager$clearDataStore$2) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ((MutablePreferences) this.L$0).clear();
        return Unit.INSTANCE;
    }
}
