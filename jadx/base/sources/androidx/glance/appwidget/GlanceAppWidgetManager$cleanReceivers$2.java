package androidx.glance.appwidget;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, m13886d2 = {"<anonymous>", "Landroidx/datastore/preferences/core/Preferences;", "prefs"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceAppWidgetManager$cleanReceivers$2", m14021f = "GlanceAppWidgetManager.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
@SourceDebugExtension({"SMAP\nGlanceAppWidgetManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlanceAppWidgetManager.kt\nandroidx/glance/appwidget/GlanceAppWidgetManager$cleanReceivers$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,569:1\n766#2:570\n857#2,2:571\n1855#2,2:573\n*S KotlinDebug\n*F\n+ 1 GlanceAppWidgetManager.kt\nandroidx/glance/appwidget/GlanceAppWidgetManager$cleanReceivers$2\n*L\n344#1:570\n344#1:571,2\n348#1:573,2\n*E\n"})
public final class GlanceAppWidgetManager$cleanReceivers$2 extends SuspendLambda implements Function2<Preferences, Continuation<? super Preferences>, Object> {
    final /* synthetic */ Set<String> $receivers;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlanceAppWidgetManager$cleanReceivers$2(Set<String> set, Continuation<? super GlanceAppWidgetManager$cleanReceivers$2> continuation) {
        super(2, continuation);
        this.$receivers = set;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GlanceAppWidgetManager$cleanReceivers$2 glanceAppWidgetManager$cleanReceivers$2 = new GlanceAppWidgetManager$cleanReceivers$2(this.$receivers, continuation);
        glanceAppWidgetManager$cleanReceivers$2.L$0 = obj;
        return glanceAppWidgetManager$cleanReceivers$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull Preferences preferences, @Nullable Continuation<? super Preferences> continuation) {
        return ((GlanceAppWidgetManager$cleanReceivers$2) create(preferences, continuation)).invokeSuspend(Unit.INSTANCE);
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
        Set set = (Set) preferences.get(GlanceAppWidgetManager.providersKey);
        if (set != null) {
            Set<String> set2 = this.$receivers;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : set) {
                if (!set2.contains((String) obj2)) {
                    arrayList.add(obj2);
                }
            }
            if (!arrayList.isEmpty()) {
                MutablePreferences mutablePreferences = preferences.toMutablePreferences();
                mutablePreferences.set(GlanceAppWidgetManager.providersKey, SetsKt.minus(set, (Iterable) arrayList));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    mutablePreferences.remove(GlanceAppWidgetManager.Companion.providerKey((String) it.next()));
                }
                return mutablePreferences.toPreferences();
            }
        }
        return preferences;
    }
}
