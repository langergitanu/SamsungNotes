package androidx.glance.appwidget;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u008a@"}, m13886d2 = {"<anonymous>", "Landroidx/datastore/preferences/core/Preferences;", "R", "Landroidx/glance/appwidget/GlanceAppWidgetReceiver;", "P", "Landroidx/glance/appwidget/GlanceAppWidget;", "pref"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceAppWidgetManager$updateReceiver$2", m14021f = "GlanceAppWidgetManager.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class GlanceAppWidgetManager$updateReceiver$2 extends SuspendLambda implements Function2<Preferences, Continuation<? super Preferences>, Object> {
    final /* synthetic */ String $providerName;
    final /* synthetic */ String $receiverName;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlanceAppWidgetManager$updateReceiver$2(String str, String str2, Continuation<? super GlanceAppWidgetManager$updateReceiver$2> continuation) {
        super(2, continuation);
        this.$receiverName = str;
        this.$providerName = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GlanceAppWidgetManager$updateReceiver$2 glanceAppWidgetManager$updateReceiver$2 = new GlanceAppWidgetManager$updateReceiver$2(this.$receiverName, this.$providerName, continuation);
        glanceAppWidgetManager$updateReceiver$2.L$0 = obj;
        return glanceAppWidgetManager$updateReceiver$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull Preferences preferences, @Nullable Continuation<? super Preferences> continuation) {
        return ((GlanceAppWidgetManager$updateReceiver$2) create(preferences, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Preferences preferences = (Preferences) this.L$0;
        MutablePreferences mutablePreferences = preferences.toMutablePreferences();
        String str = this.$receiverName;
        String str2 = this.$providerName;
        Preferences.Key key = GlanceAppWidgetManager.providersKey;
        Set setEmptySet = (Set) preferences.get(GlanceAppWidgetManager.providersKey);
        if (setEmptySet == null) {
            setEmptySet = SetsKt.emptySet();
        }
        mutablePreferences.set(key, SetsKt.plus((Set<? extends String>) setEmptySet, str));
        mutablePreferences.set(GlanceAppWidgetManager.Companion.providerKey(str), str2);
        return mutablePreferences.toPreferences();
    }
}
