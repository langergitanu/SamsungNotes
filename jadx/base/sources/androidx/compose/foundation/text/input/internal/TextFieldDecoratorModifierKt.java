package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.content.MediaType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, m13886d2 = {"MediaTypesAll", "", "Landroidx/compose/foundation/content/MediaType;", "getMediaTypesAll$annotations", "()V", "MediaTypesText", "getMediaTypesText$annotations", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TextFieldDecoratorModifierKt {

    @NotNull
    private static final Set<MediaType> MediaTypesAll;

    @NotNull
    private static final Set<MediaType> MediaTypesText;

    static {
        MediaType.Companion companion = MediaType.INSTANCE;
        MediaTypesText = SetsKt.setOf(companion.getText());
        MediaTypesAll = SetsKt.setOf(companion.getAll());
    }

    private static /* synthetic */ void getMediaTypesAll$annotations() {
    }

    private static /* synthetic */ void getMediaTypesText$annotations() {
    }
}
