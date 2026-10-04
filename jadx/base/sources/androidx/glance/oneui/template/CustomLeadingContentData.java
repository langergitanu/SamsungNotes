package androidx.glance.oneui.template;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H'¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"Landroidx/glance/oneui/template/CustomLeadingContentData;", "Landroidx/glance/oneui/template/LeadingContentData;", "()V", "LeadingContent", "", "(Landroidx/compose/runtime/Composer;I)V", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public abstract class CustomLeadingContentData extends LeadingContentData {
    public static final int $stable = 0;

    public CustomLeadingContentData() {
        super(null);
    }

    @Composable
    public abstract void LeadingContent(@Nullable Composer composer, int i);
}
