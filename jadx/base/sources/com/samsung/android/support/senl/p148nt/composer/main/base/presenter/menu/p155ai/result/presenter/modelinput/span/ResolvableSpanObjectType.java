package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.span;

import androidx.glance.AbstractC2821a;
import com.google.firebase.messaging.Constants;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/span/ResolvableSpanObjectType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "TABLE", "OTHER", Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_REPLACE, "", "obj", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class ResolvableSpanObjectType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ResolvableSpanObjectType[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final int type;
    public static final ResolvableSpanObjectType TABLE = new ResolvableSpanObjectType("TABLE", 0) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.modelinput.span.ResolvableSpanObjectType.TABLE
        {
            int i = 22;
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.span.ResolvableSpanObjectType
        @NotNull
        public String replace(@NotNull SpenObjectBase obj) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            return ResolvableSpanObjectType.INSTANCE.convertTableToString((SpenObjectTable) obj);
        }
    };
    public static final ResolvableSpanObjectType OTHER = new ResolvableSpanObjectType("OTHER", 1) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.modelinput.span.ResolvableSpanObjectType.OTHER
        {
            int i = -1;
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.span.ResolvableSpanObjectType
        @NotNull
        public String replace(@NotNull SpenObjectBase obj) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            return "";
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/span/ResolvableSpanObjectType$Companion;", "", "<init>", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/span/ResolvableSpanObjectType;", "type", "", "convertTableToString", "", "table", "Lcom/samsung/android/sdk/pen/document/SpenObjectTable;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nResolvableSpanObjectType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResolvableSpanObjectType.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/span/ResolvableSpanObjectType$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,50:1\n1#2:51\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String convertTableToString(SpenObjectTable table) {
            int i;
            StringBuilder sb = new StringBuilder("\n");
            if (table.getRowsCount() > 0) {
                int columnsCount = table.getColumnsCount();
                int iM2213d = 0;
                while (iM2213d < columnsCount) {
                    sb.append("|");
                    String text = table.getContentObject(0, iM2213d).getText();
                    if (text == null) {
                        text = " ";
                    }
                    iM2213d = AbstractC2821a.m2213d(sb, iM2213d, 1, text, " ");
                }
                sb.append("|\n");
                int columnsCount2 = table.getColumnsCount();
                for (int i2 = 0; i2 < columnsCount2; i2++) {
                    sb.append("|---");
                }
                sb.append("|\n");
                i = 1;
            } else {
                i = 0;
            }
            int rowsCount = table.getRowsCount();
            while (i < rowsCount) {
                int columnsCount3 = table.getColumnsCount();
                int iM2213d2 = 0;
                while (iM2213d2 < columnsCount3) {
                    sb.append("|");
                    String text2 = table.getContentObject(i, iM2213d2).getText();
                    if (text2 == null) {
                        text2 = " ";
                    }
                    iM2213d2 = AbstractC2821a.m2213d(sb, iM2213d2, 1, text2, " ");
                }
                sb.append("|\n");
                i++;
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        @NotNull
        public final ResolvableSpanObjectType from(int type) {
            ResolvableSpanObjectType next;
            Iterator<ResolvableSpanObjectType> it = ResolvableSpanObjectType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.getType() == type) {
                    break;
                }
            }
            ResolvableSpanObjectType resolvableSpanObjectType = next;
            return resolvableSpanObjectType == null ? ResolvableSpanObjectType.OTHER : resolvableSpanObjectType;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ ResolvableSpanObjectType[] $values() {
        return new ResolvableSpanObjectType[]{TABLE, OTHER};
    }

    static {
        ResolvableSpanObjectType[] resolvableSpanObjectTypeArr$values = $values();
        $VALUES = resolvableSpanObjectTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(resolvableSpanObjectTypeArr$values);
        INSTANCE = new Companion(null);
    }

    public /* synthetic */ ResolvableSpanObjectType(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2);
    }

    @NotNull
    public static EnumEntries<ResolvableSpanObjectType> getEntries() {
        return $ENTRIES;
    }

    public static ResolvableSpanObjectType valueOf(String str) {
        return (ResolvableSpanObjectType) Enum.valueOf(ResolvableSpanObjectType.class, str);
    }

    public static ResolvableSpanObjectType[] values() {
        return (ResolvableSpanObjectType[]) $VALUES.clone();
    }

    public final int getType() {
        return this.type;
    }

    @NotNull
    public abstract String replace(@NotNull SpenObjectBase obj);

    private ResolvableSpanObjectType(String str, int i, int i2) {
        this.type = i2;
    }
}
