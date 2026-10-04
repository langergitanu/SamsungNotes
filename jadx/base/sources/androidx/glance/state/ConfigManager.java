package androidx.glance.state;

import android.content.Context;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ2\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\f0\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJV\u0010\r\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\f0\u00072\u0006\u0010\b\u001a\u00020\t2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fH¦@¢\u0006\u0002\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, m13886d2 = {"Landroidx/glance/state/ConfigManager;", "", "deleteStore", "", "context", "Landroid/content/Context;", "definition", "Landroidx/glance/state/GlanceStateDefinition;", "fileKey", "", "(Landroid/content/Context;Landroidx/glance/state/GlanceStateDefinition;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getValue", "T", "updateValue", "updateBlock", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Landroid/content/Context;Landroidx/glance/state/GlanceStateDefinition;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface ConfigManager {
    @Nullable
    Object deleteStore(@NotNull Context context, @NotNull GlanceStateDefinition<?> glanceStateDefinition, @NotNull String str, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    <T> Object getValue(@NotNull Context context, @NotNull GlanceStateDefinition<T> glanceStateDefinition, @NotNull String str, @NotNull Continuation<? super T> continuation);

    @Nullable
    <T> Object updateValue(@NotNull Context context, @NotNull GlanceStateDefinition<T> glanceStateDefinition, @NotNull String str, @NotNull Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation);
}
