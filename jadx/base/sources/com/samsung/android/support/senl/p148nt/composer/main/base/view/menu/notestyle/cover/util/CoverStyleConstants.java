package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.util;

import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/util/CoverStyleConstants;", "", "<init>", "()V", "CoverType", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CoverStyleConstants {

    @NotNull
    public static final CoverStyleConstants INSTANCE = new CoverStyleConstants();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/util/CoverStyleConstants$CoverType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", CoverConstants.TemplateType.PATTERN.UUID, CoverConstants.TemplateType.ILLUST.UUID, "TEXT", "toString", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class CoverType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CoverType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        @NotNull
        private final String value;
        public static final CoverType PATTERN = new CoverType(CoverConstants.TemplateType.PATTERN.UUID, 0, CoverConstants.TemplateType.PATTERN.UUID);
        public static final CoverType ILLUST = new CoverType(CoverConstants.TemplateType.ILLUST.UUID, 1, CoverConstants.TemplateType.ILLUST.UUID);
        public static final CoverType TEXT = new CoverType("TEXT", 2, CoverConstants.TemplateType.TEXT.UUID);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/util/CoverStyleConstants$CoverType$Companion;", "", "<init>", "()V", "fromString", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/util/CoverStyleConstants$CoverType;", "text", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        @SourceDebugExtension({"SMAP\nCoverStyleConstants.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoverStyleConstants.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/util/CoverStyleConstants$CoverType$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,17:1\n1#2:18\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Nullable
            public final CoverType fromString(@NotNull String text) {
                CoverType next;
                Intrinsics.checkNotNullParameter(text, "text");
                Iterator<CoverType> it = CoverType.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(next.toString(), text)) {
                        break;
                    }
                }
                return next;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ CoverType[] $values() {
            return new CoverType[]{PATTERN, ILLUST, TEXT};
        }

        static {
            CoverType[] coverTypeArr$values = $values();
            $VALUES = coverTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(coverTypeArr$values);
            INSTANCE = new Companion(null);
        }

        private CoverType(String str, int i, String str2) {
            this.value = str2;
        }

        @NotNull
        public static EnumEntries<CoverType> getEntries() {
            return $ENTRIES;
        }

        public static CoverType valueOf(String str) {
            return (CoverType) Enum.valueOf(CoverType.class, str);
        }

        public static CoverType[] values() {
            return (CoverType[]) $VALUES.clone();
        }

        @Override // java.lang.Enum
        @NotNull
        public String toString() {
            return this.value;
        }
    }

    private CoverStyleConstants() {
    }
}
