package androidx.glance.text;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\f"}, m13886d2 = {"Landroidx/glance/text/TextCategory;", "", "minSize", "", "maxSize", "(FF)V", "getMaxSize", "()F", "getMinSize", "toString", "", "Companion", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class TextCategory {
    public static final int $stable = 0;
    private final float maxSize;
    private final float minSize;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final TextCategory Display = new TextCategory(1.0f, 44.0f);

    @NotNull
    private static final TextCategory Title = new TextCategory(1.0f, 20.0f);

    @NotNull
    private static final TextCategory Body = new TextCategory(1.0f, 16.0f);

    @NotNull
    private static final TextCategory Description = new TextCategory(1.0f, 24.0f);

    @NotNull
    private static final TextCategory Label = new TextCategory(1.0f, 14.0f);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0006R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006R\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, m13886d2 = {"Landroidx/glance/text/TextCategory$Companion;", "", "()V", "Body", "Landroidx/glance/text/TextCategory;", "getBody", "()Landroidx/glance/text/TextCategory;", "Description", "getDescription$annotations", "getDescription", "Display", "getDisplay", "Label", "getLabel", "Title", DynamicActionBarProvider.METHOD_GET_DATA, "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TextCategory getBody() {
            return TextCategory.Body;
        }

        @NotNull
        public final TextCategory getDescription() {
            return TextCategory.Description;
        }

        @NotNull
        public final TextCategory getDisplay() {
            return TextCategory.Display;
        }

        @NotNull
        public final TextCategory getLabel() {
            return TextCategory.Label;
        }

        @NotNull
        public final TextCategory getTitle() {
            return TextCategory.Title;
        }

        private Companion() {
        }

        @Deprecated(message = "Description text is deprecated since OneUI8.5")
        public static /* synthetic */ void getDescription$annotations() {
        }
    }

    private TextCategory(float f, float f4) {
        this.minSize = f;
        this.maxSize = f4;
    }

    public final float getMaxSize() {
        return this.maxSize;
    }

    public final float getMinSize() {
        return this.minSize;
    }

    @NotNull
    public String toString() {
        return AbstractC0541b.m770l("TextCategory(", this.minSize, SQLKeyword.COMMA, this.maxSize, ")");
    }
}
