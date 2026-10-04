package com.samsung.android.support.senl.p148nt.model.markdown.generator.processing;

import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverData;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.model.markdown.generator.model.MarkdownDocument;
import com.samsung.android.support.senl.p148nt.model.markdown.generator.model.component.MarkdownComponent;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p100Y3.C0348a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/markdown/generator/processing/MarkdownGenerator;", "", "<init>", "()V", "Companion", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MarkdownGenerator {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/markdown/generator/processing/MarkdownGenerator$Companion;", "", "<init>", "()V", CoverData.KEY_GENERATE_COVER, "", ExternalDataConstants.DOCUMENT_TABLE_NAME, "Lcom/samsung/android/support/senl/nt/model/markdown/generator/model/MarkdownDocument;", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence generate$lambda$0(MarkdownComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            return component.render();
        }

        @NotNull
        public final String generate(@NotNull MarkdownDocument document) {
            Intrinsics.checkNotNullParameter(document, "document");
            return CollectionsKt.m13955n(document.getComponents(), MarkdownDocument.NEW_LINE, null, null, new C0348a(14), 30);
        }

        private Companion() {
        }
    }
}
