package com.samsung.android.support.senl.p148nt.composer.main.compare.logic;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.page.ConflictPage;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\b&\u0018\u00002\u00020\u0001:\u0003\u0017\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\t¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict;", "", "<init>", "()V", "type", "", "getType", "()I", "setType", "(I)V", "id", "getId", "setId", "isActiveLocal", "", "()Z", "setActiveLocal", "(Z)V", "isActiveSync", "setActiveSync", "indexOfListConflict", "getIndexOfListConflict", "setIndexOfListConflict", "BodyTextConflict", "SPenObjectConflict", "WPageConflict", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class InformationConflict {
    private int id;
    private int type;
    private boolean isActiveLocal = true;
    private boolean isActiveSync = true;
    private int indexOfListConflict = -1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001a¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict$BodyTextConflict;", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict;", "<init>", "()V", "startIndexLocal", "", "getStartIndexLocal", "()I", "setStartIndexLocal", "(I)V", "endIndexLocal", "getEndIndexLocal", "setEndIndexLocal", "startIndexSync", "getStartIndexSync", "setStartIndexSync", "endIndexSync", "getEndIndexSync", "setEndIndexSync", "startMerge", "getStartMerge", "setStartMerge", "isSPenObject", "", "()Z", "setSPenObject", "(Z)V", "isParagraph", "setParagraph", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class BodyTextConflict extends InformationConflict {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private int endIndexLocal;
        private int endIndexSync;
        private boolean isParagraph;
        private boolean isSPenObject;
        private int startIndexLocal;
        private int startIndexSync;
        private int startMerge;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict$BodyTextConflict$Companion;", "", "<init>", "()V", "createConflictInfo", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict$BodyTextConflict;", "type", "", "startIndexLocal", "endIndexLocal", "startIndexSync", "endIndexSync", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final BodyTextConflict createConflictInfo(int type, int startIndexLocal, int endIndexLocal, int startIndexSync, int endIndexSync) {
                BodyTextConflict bodyTextConflict = new BodyTextConflict(null);
                bodyTextConflict.setType(type);
                bodyTextConflict.setStartIndexLocal(startIndexLocal);
                bodyTextConflict.setEndIndexLocal(endIndexLocal);
                bodyTextConflict.setStartIndexSync(startIndexSync);
                bodyTextConflict.setEndIndexSync(endIndexSync);
                return bodyTextConflict;
            }

            private Companion() {
            }
        }

        public /* synthetic */ BodyTextConflict(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getEndIndexLocal() {
            return this.endIndexLocal;
        }

        public final int getEndIndexSync() {
            return this.endIndexSync;
        }

        public final int getStartIndexLocal() {
            return this.startIndexLocal;
        }

        public final int getStartIndexSync() {
            return this.startIndexSync;
        }

        public final int getStartMerge() {
            return this.startMerge;
        }

        /* JADX INFO: renamed from: isParagraph, reason: from getter */
        public final boolean getIsParagraph() {
            return this.isParagraph;
        }

        /* JADX INFO: renamed from: isSPenObject, reason: from getter */
        public final boolean getIsSPenObject() {
            return this.isSPenObject;
        }

        public final void setEndIndexLocal(int i) {
            this.endIndexLocal = i;
        }

        public final void setEndIndexSync(int i) {
            this.endIndexSync = i;
        }

        public final void setParagraph(boolean z) {
            this.isParagraph = z;
        }

        public final void setSPenObject(boolean z) {
            this.isSPenObject = z;
        }

        public final void setStartIndexLocal(int i) {
            this.startIndexLocal = i;
        }

        public final void setStartIndexSync(int i) {
            this.startIndexSync = i;
        }

        public final void setStartMerge(int i) {
            this.startMerge = i;
        }

        private BodyTextConflict() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR*\u0010 \u001a\u0012\u0012\u0004\u0012\u00020!0\u0005j\b\u0012\u0004\u0012\u00020!`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR*\u0010$\u001a\u0012\u0012\u0004\u0012\u00020!0\u0005j\b\u0012\u0004\u0012\u00020!`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000b¨\u0006("}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict$SPenObjectConflict;", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict;", "<init>", "()V", "indexLocals", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getIndexLocals", "()Ljava/util/ArrayList;", "setIndexLocals", "(Ljava/util/ArrayList;)V", "indexSyncs", "getIndexSyncs", "setIndexSyncs", "indexPage", "getIndexPage", "()I", "setIndexPage", "(I)V", "conflictPage", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/page/ConflictPage;", "getConflictPage", "()Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/page/ConflictPage;", "setConflictPage", "(Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/page/ConflictPage;)V", "pageMerge", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "getPageMerge", "()Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "setPageMerge", "(Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;)V", "objectLocals", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "getObjectLocals", "setObjectLocals", "objectSyncs", "getObjectSyncs", "setObjectSyncs", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class SPenObjectConflict extends InformationConflict {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @Nullable
        private ConflictPage conflictPage;

        @NotNull
        private ArrayList<Integer> indexLocals;
        private int indexPage;

        @NotNull
        private ArrayList<Integer> indexSyncs;

        @NotNull
        private ArrayList<SpenObjectBase> objectLocals;

        @NotNull
        private ArrayList<SpenObjectBase> objectSyncs;

        @Nullable
        private SpenWPage pageMerge;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict$SPenObjectConflict$Companion;", "", "<init>", "()V", "createConflictInfo", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict$SPenObjectConflict;", "type", "", "indexLocal", "indexSync", "conflictPage", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/page/ConflictPage;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final SPenObjectConflict createConflictInfo(int type, int indexLocal, int indexSync, @Nullable ConflictPage conflictPage) {
                SPenObjectConflict sPenObjectConflict = new SPenObjectConflict(null);
                sPenObjectConflict.setType(type);
                if (indexLocal != -1) {
                    sPenObjectConflict.getIndexLocals().add(Integer.valueOf(indexLocal));
                }
                if (indexSync != -1) {
                    sPenObjectConflict.getIndexSyncs().add(Integer.valueOf(indexSync));
                }
                sPenObjectConflict.setConflictPage(conflictPage);
                return sPenObjectConflict;
            }

            private Companion() {
            }
        }

        public /* synthetic */ SPenObjectConflict(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final ConflictPage getConflictPage() {
            return this.conflictPage;
        }

        @NotNull
        public final ArrayList<Integer> getIndexLocals() {
            return this.indexLocals;
        }

        public final int getIndexPage() {
            return this.indexPage;
        }

        @NotNull
        public final ArrayList<Integer> getIndexSyncs() {
            return this.indexSyncs;
        }

        @NotNull
        public final ArrayList<SpenObjectBase> getObjectLocals() {
            return this.objectLocals;
        }

        @NotNull
        public final ArrayList<SpenObjectBase> getObjectSyncs() {
            return this.objectSyncs;
        }

        @Nullable
        public final SpenWPage getPageMerge() {
            return this.pageMerge;
        }

        public final void setConflictPage(@Nullable ConflictPage conflictPage) {
            this.conflictPage = conflictPage;
        }

        public final void setIndexLocals(@NotNull ArrayList<Integer> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.indexLocals = arrayList;
        }

        public final void setIndexPage(int i) {
            this.indexPage = i;
        }

        public final void setIndexSyncs(@NotNull ArrayList<Integer> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.indexSyncs = arrayList;
        }

        public final void setObjectLocals(@NotNull ArrayList<SpenObjectBase> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.objectLocals = arrayList;
        }

        public final void setObjectSyncs(@NotNull ArrayList<SpenObjectBase> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.objectSyncs = arrayList;
        }

        public final void setPageMerge(@Nullable SpenWPage spenWPage) {
            this.pageMerge = spenWPage;
        }

        private SPenObjectConflict() {
            this.indexLocals = new ArrayList<>();
            this.indexSyncs = new ArrayList<>();
            this.indexPage = -1;
            this.objectLocals = new ArrayList<>();
            this.objectSyncs = new ArrayList<>();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict$WPageConflict;", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict;", "<init>", "()V", "indexMerge", "", "getIndexMerge", "()I", "setIndexMerge", "(I)V", "conflictPage", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/page/ConflictPage;", "getConflictPage", "()Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/page/ConflictPage;", "setConflictPage", "(Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/page/ConflictPage;)V", "pageLocal", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "getPageLocal", "()Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "setPageLocal", "(Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;)V", "pageSync", "getPageSync", "setPageSync", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class WPageConflict extends InformationConflict {

        @Nullable
        private ConflictPage conflictPage;
        private int indexMerge;

        @Nullable
        private SpenWPage pageLocal;

        @Nullable
        private SpenWPage pageSync;

        @Nullable
        public final ConflictPage getConflictPage() {
            return this.conflictPage;
        }

        public final int getIndexMerge() {
            return this.indexMerge;
        }

        @Nullable
        public final SpenWPage getPageLocal() {
            return this.pageLocal;
        }

        @Nullable
        public final SpenWPage getPageSync() {
            return this.pageSync;
        }

        public final void setConflictPage(@Nullable ConflictPage conflictPage) {
            this.conflictPage = conflictPage;
        }

        public final void setIndexMerge(int i) {
            this.indexMerge = i;
        }

        public final void setPageLocal(@Nullable SpenWPage spenWPage) {
            this.pageLocal = spenWPage;
        }

        public final void setPageSync(@Nullable SpenWPage spenWPage) {
            this.pageSync = spenWPage;
        }
    }

    public final int getId() {
        return this.id;
    }

    public final int getIndexOfListConflict() {
        return this.indexOfListConflict;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: isActiveLocal, reason: from getter */
    public final boolean getIsActiveLocal() {
        return this.isActiveLocal;
    }

    /* JADX INFO: renamed from: isActiveSync, reason: from getter */
    public final boolean getIsActiveSync() {
        return this.isActiveSync;
    }

    public final void setActiveLocal(boolean z) {
        this.isActiveLocal = z;
    }

    public final void setActiveSync(boolean z) {
        this.isActiveSync = z;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setIndexOfListConflict(int i) {
        this.indexOfListConflict = i;
    }

    public final void setType(int i) {
        this.type = i;
    }
}
