package androidx.compose.p109ui.semantics;

import androidx.compose.p109ui.ExperimentalComposeUiApi;
import androidx.compose.runtime.AbstractC1974b;
import kotlin.Metadata;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\"5\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018G@GX\u0087\u008e\u0002¢\u0006\u0018\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b*\u0004\b\u0006\u0010\u0007¨\u0006\f"}, m13886d2 = {"<set-?>", "", "testTagsAsResourceId", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "getTestTagsAsResourceId$annotations", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "getTestTagsAsResourceId$delegate", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/Object;", "getTestTagsAsResourceId", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", "setTestTagsAsResourceId", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Z)V", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SemanticsProperties_androidKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {AbstractC1974b.m1328u(SemanticsProperties_androidKt.class, "testTagsAsResourceId", "getTestTagsAsResourceId(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)};

    static {
        SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId();
    }

    @ExperimentalComposeUiApi
    public static final boolean getTestTagsAsResourceId(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId().getValue(semanticsPropertyReceiver, $$delegatedProperties[0]).booleanValue();
    }

    @ExperimentalComposeUiApi
    public static final void setTestTagsAsResourceId(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z) {
        SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId().setValue(semanticsPropertyReceiver, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getTestTagsAsResourceId$annotations(SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }
}
