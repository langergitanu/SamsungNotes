package com.samsung.android.support.senl.p148nt.composer.main.compare.logic.page;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.RectF;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.ConflictLocation;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.InformationConflict;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.page.object.ComparePDFData;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p005A3.C0016a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 <2\u00020\u0001:\u0002;<B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\nJ\u0006\u0010\"\u001a\u00020\u0003J\u0006\u0010#\u001a\u00020\u0003J\u0006\u0010$\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0013J\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00170&J\u0006\u0010'\u001a\u00020\u0013J\u0006\u0010(\u001a\u00020 J\b\u0010)\u001a\u00020 H\u0002J\b\u0010*\u001a\u00020 H\u0002J\b\u0010+\u001a\u00020 H\u0002J4\u0010,\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000100H\u0002J.\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u001a03j\b\u0012\u0004\u0012\u00020\u001a`42\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u00106\u001a\u00020\u001aH\u0002J\u0010\u00107\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0016\u00108\u001a\u0002002\u0006\u00109\u001a\u0002002\u0006\u0010:\u001a\u000200R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/page/ConflictPage;", "", "type", "", "pageIndexLocal", "pageIndexSyncDown", "pageSyncDown", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "pageLocal", WiggleAnimationConfig.KEY_SCALE, "", "<init>", "(IIILcom/samsung/android/sdk/pen/worddoc/SpenWPage;Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;F)V", "mType", "mPageIndexLocal", "mPageIndexSyncDown", "mPageSyncDown", "mPageLocal", "isConflictBackground", "", "isConflictObject", "mListLocations", "", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/ConflictLocation;", "mStrokeFormatting", "Ljava/util/TreeSet;", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/page/ConflictPage$RectContainer;", "mStrokeLocalDelete", "mStrokeSyncAdd", "mScale", "mOffSetSync", "setOffSetY", "", "mOffSetY", "getType", "getPageIndexLocal", "getPageIndexSyncDown", "getListLocations", "", "isConflict", "checkConflictPage", "checkConflictBackground", "checkPdfData", "checkConflictObject", "addStrokeConflict", "indexLocal", "indexSync", "rectLocal", "Landroid/graphics/RectF;", "rectSync", "intersect", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "stroke", "updateConflictStroke", "unionRect", "rect1", "rect2", "RectContainer", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nConflictPage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConflictPage.kt\ncom/samsung/android/support/senl/nt/composer/main/compare/logic/page/ConflictPage\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,339:1\n1#2:340\n*E\n"})
public final class ConflictPage {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean ENABLE_UNION_RECT_FOR_STROKE = true;

    @NotNull
    private static final String TAG = "ConflictPage";
    private boolean isConflictBackground;
    private boolean isConflictObject;

    @Nullable
    private List<ConflictLocation> mListLocations;
    private float mOffSetSync;
    private int mPageIndexLocal;
    private int mPageIndexSyncDown;

    @Nullable
    private SpenWPage mPageLocal;

    @Nullable
    private SpenWPage mPageSyncDown;
    private float mScale;

    @Nullable
    private TreeSet<RectContainer> mStrokeFormatting;

    @Nullable
    private TreeSet<RectContainer> mStrokeLocalDelete;

    @Nullable
    private TreeSet<RectContainer> mStrokeSyncAdd;
    private int mType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/page/ConflictPage$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "ENABLE_UNION_RECT_FOR_STROKE", "", "scalePoint", "Landroid/graphics/Point;", "point", WiggleAnimationConfig.KEY_SCALE, "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Point scalePoint(@NotNull Point point, float scale) {
            Intrinsics.checkNotNullParameter(point, "point");
            return new Point((int) (point.x / scale), (int) (point.y / scale));
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/page/ConflictPage$RectContainer;", "", "<init>", "()V", "rectF", "Landroid/graphics/RectF;", "getRectF", "()Landroid/graphics/RectF;", "setRectF", "(Landroid/graphics/RectF;)V", "rectFSync", "getRectFSync", "setRectFSync", "informationConflict", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict$SPenObjectConflict;", "getInformationConflict", "()Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict$SPenObjectConflict;", "setInformationConflict", "(Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict$SPenObjectConflict;)V", "intersect", "", "other", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class RectContainer {

        @Nullable
        private InformationConflict.SPenObjectConflict informationConflict;

        @Nullable
        private RectF rectF;

        @Nullable
        private RectF rectFSync;

        @Nullable
        public final InformationConflict.SPenObjectConflict getInformationConflict() {
            return this.informationConflict;
        }

        @Nullable
        public final RectF getRectF() {
            return this.rectF;
        }

        @Nullable
        public final RectF getRectFSync() {
            return this.rectFSync;
        }

        public final boolean intersect(@NotNull RectContainer other) {
            Intrinsics.checkNotNullParameter(other, "other");
            RectF rectF = this.rectF;
            if (rectF != null && other.rectF != null) {
                Intrinsics.checkNotNull(rectF);
                float f = rectF.bottom;
                RectF rectF2 = other.rectF;
                Intrinsics.checkNotNull(rectF2);
                if (f >= rectF2.top) {
                    RectF rectF3 = this.rectF;
                    Intrinsics.checkNotNull(rectF3);
                    float f4 = rectF3.top;
                    RectF rectF4 = other.rectF;
                    Intrinsics.checkNotNull(rectF4);
                    if (f4 <= rectF4.bottom) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final void setInformationConflict(@Nullable InformationConflict.SPenObjectConflict sPenObjectConflict) {
            this.informationConflict = sPenObjectConflict;
        }

        public final void setRectF(@Nullable RectF rectF) {
            this.rectF = rectF;
        }

        public final void setRectFSync(@Nullable RectF rectF) {
            this.rectFSync = rectF;
        }
    }

    public ConflictPage(int i, int i2, int i4, @Nullable SpenWPage spenWPage, @Nullable SpenWPage spenWPage2, float f) {
        this.mType = i;
        this.mPageIndexLocal = i2;
        this.mPageIndexSyncDown = i4;
        this.mPageSyncDown = spenWPage;
        this.mPageLocal = spenWPage2;
        this.mScale = f;
        C0016a c0016a = new C0016a(22);
        this.mStrokeFormatting = new TreeSet<>(c0016a);
        this.mStrokeLocalDelete = new TreeSet<>(c0016a);
        this.mStrokeSyncAdd = new TreeSet<>(c0016a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _init_$lambda$0(RectContainer rectContainer, RectContainer rectContainer2) {
        RectF rectF = rectContainer.getRectF();
        Intrinsics.checkNotNull(rectF);
        float f = rectF.top;
        RectF rectF2 = rectContainer2.getRectF();
        Intrinsics.checkNotNull(rectF2);
        return Float.compare(f, rectF2.top);
    }

    private final void addStrokeConflict(int type, int indexLocal, int indexSync, RectF rectLocal, RectF rectSync) {
        TreeSet<RectContainer> treeSet;
        ArrayList<Integer> indexSyncs;
        ArrayList<Integer> indexLocals;
        ArrayList<Integer> indexSyncs2;
        if (type == 0) {
            treeSet = this.mStrokeSyncAdd;
            Intrinsics.checkNotNull(treeSet);
        } else if (type != 2) {
            treeSet = this.mStrokeLocalDelete;
            Intrinsics.checkNotNull(treeSet);
        } else {
            treeSet = this.mStrokeFormatting;
            Intrinsics.checkNotNull(treeSet);
        }
        if (type != 1 && type != 2) {
            RectContainer rectContainer = new RectContainer();
            rectContainer.setRectF(new RectF(rectSync));
            rectContainer.setInformationConflict(InformationConflict.SPenObjectConflict.INSTANCE.createConflictInfo(type, indexLocal, indexSync, this));
            ArrayList<RectContainer> arrayListIntersect = intersect(treeSet, rectContainer);
            if (!arrayListIntersect.isEmpty()) {
                for (RectContainer rectContainer2 : arrayListIntersect) {
                    RectF rectF = rectContainer.getRectF();
                    Intrinsics.checkNotNull(rectF);
                    RectF rectF2 = rectContainer2.getRectF();
                    Intrinsics.checkNotNull(rectF2);
                    rectContainer.setRectF(unionRect(rectF, rectF2));
                    InformationConflict.SPenObjectConflict informationConflict = rectContainer.getInformationConflict();
                    if (informationConflict != null && (indexSyncs2 = informationConflict.getIndexSyncs()) != null) {
                        InformationConflict.SPenObjectConflict informationConflict2 = rectContainer2.getInformationConflict();
                        Intrinsics.checkNotNull(informationConflict2);
                        indexSyncs2.addAll(informationConflict2.getIndexSyncs());
                    }
                }
            }
            treeSet.add(rectContainer);
            return;
        }
        RectContainer rectContainer3 = new RectContainer();
        rectContainer3.setRectF(new RectF(rectLocal));
        rectContainer3.setRectFSync(rectSync != null ? new RectF(rectSync) : null);
        rectContainer3.setInformationConflict(InformationConflict.SPenObjectConflict.INSTANCE.createConflictInfo(type, indexLocal, indexSync, this));
        ArrayList<RectContainer> arrayListIntersect2 = intersect(treeSet, rectContainer3);
        if (!arrayListIntersect2.isEmpty()) {
            for (RectContainer rectContainer4 : arrayListIntersect2) {
                RectF rectF3 = rectContainer3.getRectF();
                Intrinsics.checkNotNull(rectF3);
                RectF rectF4 = rectContainer4.getRectF();
                Intrinsics.checkNotNull(rectF4);
                rectContainer3.setRectF(unionRect(rectF3, rectF4));
                InformationConflict.SPenObjectConflict informationConflict3 = rectContainer3.getInformationConflict();
                if (informationConflict3 != null && (indexLocals = informationConflict3.getIndexLocals()) != null) {
                    InformationConflict.SPenObjectConflict informationConflict4 = rectContainer4.getInformationConflict();
                    Intrinsics.checkNotNull(informationConflict4);
                    indexLocals.addAll(informationConflict4.getIndexLocals());
                }
                if (type == 2) {
                    RectF rectFSync = rectContainer3.getRectFSync();
                    Intrinsics.checkNotNull(rectFSync);
                    RectF rectFSync2 = rectContainer4.getRectFSync();
                    Intrinsics.checkNotNull(rectFSync2);
                    rectContainer3.setRectFSync(unionRect(rectFSync, rectFSync2));
                    InformationConflict.SPenObjectConflict informationConflict5 = rectContainer3.getInformationConflict();
                    if (informationConflict5 != null && (indexSyncs = informationConflict5.getIndexSyncs()) != null) {
                        InformationConflict.SPenObjectConflict informationConflict6 = rectContainer4.getInformationConflict();
                        Intrinsics.checkNotNull(informationConflict6);
                        indexSyncs.addAll(informationConflict6.getIndexSyncs());
                    }
                }
            }
        }
        treeSet.add(rectContainer3);
    }

    private final void checkConflictBackground() {
        SpenWPage spenWPage = this.mPageSyncDown;
        Intrinsics.checkNotNull(spenWPage);
        int backgroundColor = spenWPage.getBackgroundColor();
        SpenWPage spenWPage2 = this.mPageLocal;
        Intrinsics.checkNotNull(spenWPage2);
        if (backgroundColor != spenWPage2.getBackgroundColor()) {
            this.isConflictBackground = true;
        }
        SpenWPage spenWPage3 = this.mPageSyncDown;
        Intrinsics.checkNotNull(spenWPage3);
        Bitmap backgroundImage = spenWPage3.getBackgroundImage();
        SpenWPage spenWPage4 = this.mPageLocal;
        Intrinsics.checkNotNull(spenWPage4);
        Bitmap backgroundImage2 = spenWPage4.getBackgroundImage();
        if ((backgroundImage == null && backgroundImage2 != null) || (backgroundImage != null && backgroundImage2 == null)) {
            this.isConflictBackground = true;
        } else if (backgroundImage != null && !backgroundImage.sameAs(backgroundImage2)) {
            this.isConflictBackground = true;
        }
        SpenWPage spenWPage5 = this.mPageLocal;
        Intrinsics.checkNotNull(spenWPage5);
        int templateType = spenWPage5.getTemplateType();
        SpenWPage spenWPage6 = this.mPageSyncDown;
        Intrinsics.checkNotNull(spenWPage6);
        if (templateType != spenWPage6.getTemplateType()) {
            this.isConflictBackground = true;
        }
        Logger.m11003i(TAG, AbstractC0622a.m1164j(this.mPageIndexLocal, this.mPageIndexSyncDown, "checkConflictBackground", " ", " is done"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void checkConflictObject() {
        String str;
        int i;
        ?? r6;
        ConflictPage conflictPage;
        int i2;
        int i4;
        int i5;
        int i6;
        int i7;
        ConflictPage conflictPage2;
        ConflictPage conflictPage3 = this;
        SpenWPage spenWPage = conflictPage3.mPageSyncDown;
        ArrayList<SpenObjectBase> objectList = spenWPage != null ? spenWPage.getObjectList() : null;
        SpenWPage spenWPage2 = conflictPage3.mPageLocal;
        ArrayList<SpenObjectBase> objectList2 = spenWPage2 != null ? spenWPage2.getObjectList() : null;
        SpenWPage spenWPage3 = conflictPage3.mPageLocal;
        Point offset = spenWPage3 != null ? spenWPage3.getOffset() : null;
        SpenWPage spenWPage4 = conflictPage3.mPageSyncDown;
        Point offset2 = spenWPage4 != null ? spenWPage4.getOffset() : null;
        conflictPage3.mListLocations = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        Intrinsics.checkNotNull(objectList);
        int size = objectList.size();
        int i8 = 0;
        while (true) {
            str = "get(...)";
            if (i8 >= size) {
                break;
            }
            SpenObjectBase spenObjectBase = objectList.get(i8);
            Intrinsics.checkNotNullExpressionValue(spenObjectBase, "get(...)");
            SpenObjectBase spenObjectBase2 = spenObjectBase;
            String id = spenObjectBase2.getId();
            map.put(id + " " + spenObjectBase2.getAppendTime() + " " + spenObjectBase2.getType(), spenObjectBase2);
            map2.put(id, Integer.valueOf(i8));
            i8++;
        }
        int i9 = 1;
        if (objectList2 == null || offset == null || offset2 == null) {
            i = 2;
            r6 = 1;
            conflictPage = conflictPage3;
        } else {
            int size2 = objectList2.size();
            int i10 = 2;
            int i11 = 0;
            ConflictPage conflictPage4 = conflictPage3;
            while (i11 < size2) {
                SpenObjectBase spenObjectBase3 = objectList2.get(i11);
                Intrinsics.checkNotNullExpressionValue(spenObjectBase3, str);
                SpenObjectBase spenObjectBase4 = spenObjectBase3;
                String id2 = spenObjectBase4.getId();
                String str2 = str;
                long appendTime = spenObjectBase4.getAppendTime();
                int type = spenObjectBase4.getType();
                String str3 = id2 + " " + appendTime + " " + type;
                int i12 = (type == i9 || type == 100 || type == 7 || type == 18) ? i9 : 0;
                RectF drawnRect = spenObjectBase4.getDrawnRect();
                if (drawnRect == null) {
                    drawnRect = new RectF();
                }
                int i13 = i11;
                Point point = new Point(offset.x + ((int) drawnRect.left), offset.y + ((int) drawnRect.top));
                int i14 = size2;
                float f = drawnRect.left;
                int i15 = offset.x;
                float f4 = drawnRect.top;
                int i16 = offset.y;
                ArrayList<SpenObjectBase> arrayList = objectList2;
                int i17 = i12;
                RectF rectF = new RectF(f + i15, f4 + i16, drawnRect.right + i15, drawnRect.bottom + i16);
                if (map.containsKey(str3)) {
                    SpenObjectBase spenObjectBase5 = (SpenObjectBase) map.get(str3);
                    if (spenObjectBase5 == null || spenObjectBase4.getModifiedTime() == spenObjectBase5.getModifiedTime()) {
                        i4 = i13;
                        i7 = 1;
                        i6 = 2;
                        conflictPage4 = conflictPage4;
                    } else {
                        conflictPage4.isConflictObject = true;
                        RectF drawnRect2 = spenObjectBase5.getDrawnRect();
                        if (drawnRect2 == null) {
                            drawnRect2 = new RectF();
                        }
                        float f5 = drawnRect2.left;
                        int i18 = offset2.x;
                        float f6 = conflictPage4.mScale;
                        float f7 = drawnRect2.top / f6;
                        float f8 = conflictPage4.mOffSetSync;
                        RectF rectF2 = new RectF((f5 + i18) / f6, f7 + f8, (drawnRect2.right + i18) / f6, (drawnRect2.bottom / f6) + f8);
                        if (i17 != 0) {
                            Object obj = map2.get(id2);
                            Intrinsics.checkNotNull(obj);
                            int iIntValue = ((Number) obj).intValue();
                            i4 = i13;
                            i7 = 1;
                            i6 = 2;
                            ConflictPage conflictPage5 = this;
                            conflictPage5.addStrokeConflict(2, i4, iIntValue, rectF, rectF2);
                            conflictPage2 = conflictPage5;
                        } else {
                            i4 = i13;
                            i6 = 2;
                            ConflictPage conflictPage6 = this;
                            i7 = 1;
                            ConflictLocation conflictLocation = new ConflictLocation(2, true, new Point((int) rectF2.left, (int) rectF2.top), point);
                            InformationConflict.SPenObjectConflict.Companion companion = InformationConflict.SPenObjectConflict.INSTANCE;
                            Object obj2 = map2.get(id2);
                            Intrinsics.checkNotNull(obj2);
                            conflictLocation.setMInformationConflict(companion.createConflictInfo(2, i4, ((Number) obj2).intValue(), conflictPage6));
                            conflictLocation.setObjectRectF(rectF, rectF2);
                            List<ConflictLocation> list = conflictPage6.mListLocations;
                            conflictPage2 = conflictPage6;
                            if (list != null) {
                                list.add(conflictLocation);
                                conflictPage2 = conflictPage6;
                            }
                        }
                        map2.remove(id2);
                        conflictPage4 = conflictPage2;
                    }
                    map.remove(str3);
                    i5 = i7;
                } else {
                    i4 = i13;
                    i5 = 1;
                    i6 = 2;
                    conflictPage4.isConflictObject = true;
                    if (i17 != 0) {
                        conflictPage4.addStrokeConflict(1, i4, -1, rectF, null);
                    } else {
                        Point pointScalePoint = INSTANCE.scalePoint(offset2, conflictPage4.mScale);
                        ConflictLocation conflictLocation2 = new ConflictLocation(1, true, new Point(pointScalePoint.x + ((int) drawnRect.left), pointScalePoint.y + ((int) drawnRect.top)), point);
                        conflictLocation2.setMInformationConflict(InformationConflict.SPenObjectConflict.INSTANCE.createConflictInfo(1, i4, -1, conflictPage4));
                        conflictLocation2.setObjectRectF(rectF, null);
                        List<ConflictLocation> list2 = conflictPage4.mListLocations;
                        if (list2 != null) {
                            list2.add(conflictLocation2);
                        }
                    }
                }
                i11 = i4 + 1;
                i9 = i5;
                i10 = i6;
                str = str2;
                size2 = i14;
                objectList2 = arrayList;
                conflictPage4 = conflictPage4;
            }
            r6 = i9;
            i = i10;
            conflictPage = conflictPage4;
        }
        if (!map.isEmpty() && offset2 != null && offset != null) {
            for (Object obj3 : map.values()) {
                Intrinsics.checkNotNullExpressionValue(obj3, "next(...)");
                SpenObjectBase spenObjectBase6 = (SpenObjectBase) obj3;
                conflictPage.isConflictObject = r6;
                RectF drawnRect3 = spenObjectBase6.getDrawnRect();
                if (drawnRect3 == null) {
                    drawnRect3 = new RectF();
                }
                float f9 = drawnRect3.left;
                int i19 = offset2.x;
                float f10 = conflictPage.mScale;
                float f11 = drawnRect3.top / f10;
                float f12 = conflictPage.mOffSetSync;
                RectF rectF3 = new RectF((f9 + i19) / f10, f11 + f12, (drawnRect3.right + i19) / f10, (drawnRect3.bottom / f10) + f12);
                if (spenObjectBase6.getType() == r6 || spenObjectBase6.getType() == 100 || spenObjectBase6.getType() == 7 || spenObjectBase6.getType() == 18) {
                    i2 = 2;
                    Object obj4 = map2.get(spenObjectBase6.getId());
                    Intrinsics.checkNotNull(obj4);
                    conflictPage.addStrokeConflict(0, -1, ((Number) obj4).intValue(), null, rectF3);
                    i = i2;
                } else {
                    Point point2 = new Point(offset2.x + ((int) drawnRect3.left), offset2.y + ((int) drawnRect3.top));
                    Companion companion2 = INSTANCE;
                    Point pointScalePoint2 = companion2.scalePoint(new Point((int) drawnRect3.left, (int) drawnRect3.top), conflictPage.mScale);
                    ConflictLocation conflictLocation3 = new ConflictLocation(0, r6, companion2.scalePoint(point2, conflictPage.mScale), new Point(offset.x + pointScalePoint2.x, offset.y + pointScalePoint2.y));
                    InformationConflict.SPenObjectConflict.Companion companion3 = InformationConflict.SPenObjectConflict.INSTANCE;
                    Object obj5 = map2.get(spenObjectBase6.getId());
                    Intrinsics.checkNotNull(obj5);
                    i2 = 2;
                    conflictLocation3.setMInformationConflict(companion3.createConflictInfo(0, -1, ((Number) obj5).intValue(), conflictPage));
                    conflictLocation3.setObjectRectF(null, rectF3);
                    List<ConflictLocation> list3 = conflictPage.mListLocations;
                    if (list3 != null) {
                        list3.add(conflictLocation3);
                    }
                    i = i2;
                }
            }
        }
        int i20 = i;
        TreeSet<RectContainer> treeSet = conflictPage.mStrokeFormatting;
        if (treeSet != null && !treeSet.isEmpty()) {
            conflictPage.updateConflictStroke(i20);
        }
        TreeSet<RectContainer> treeSet2 = conflictPage.mStrokeLocalDelete;
        if (treeSet2 != null && !treeSet2.isEmpty()) {
            conflictPage.updateConflictStroke(r6);
        }
        TreeSet<RectContainer> treeSet3 = conflictPage.mStrokeSyncAdd;
        if (treeSet3 != null && !treeSet3.isEmpty()) {
            conflictPage.updateConflictStroke(0);
        }
        Logger.m11003i(TAG, AbstractC0622a.m1164j(conflictPage.mPageIndexLocal, conflictPage.mPageIndexSyncDown, "checkConflictObject", " ", " is done"));
    }

    private final void checkPdfData() {
        SpenWPage spenWPage = this.mPageLocal;
        ArrayList<SpenWPage.PDFData> pdfData = spenWPage != null ? spenWPage.getPdfData() : null;
        SpenWPage spenWPage2 = this.mPageSyncDown;
        ArrayList<SpenWPage.PDFData> pdfData2 = spenWPage2 != null ? spenWPage2.getPdfData() : null;
        if (!Intrinsics.areEqual(pdfData != null ? Integer.valueOf(pdfData.size()) : null, pdfData2 != null ? Integer.valueOf(pdfData2.size()) : null)) {
            this.isConflictBackground = true;
            Logger.m11003i(TAG, AbstractC0622a.m1164j(this.mPageIndexLocal, this.mPageIndexSyncDown, "checkPdfData", " ", " is PDF data size conflict"));
            return;
        }
        if (pdfData != null) {
            int size = pdfData.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                SpenWPage.PDFData pDFData = pdfData.get(i);
                Intrinsics.checkNotNullExpressionValue(pDFData, "get(...)");
                SpenWPage.PDFData pDFData2 = pDFData;
                SpenWPage.PDFData pDFData3 = pdfData2 != null ? pdfData2.get(i) : null;
                if (pDFData3 != null && ComparePDFData.INSTANCE.isNotSameData(pDFData2, pDFData3)) {
                    this.isConflictBackground = true;
                    Logger.m11000e(TAG, AbstractC0622a.m1164j(this.mPageIndexLocal, this.mPageIndexSyncDown, "checkPdfData", " ", " is PDF data conflict"));
                    break;
                }
                i++;
            }
        }
        Logger.m11003i(TAG, AbstractC0622a.m1164j(this.mPageIndexLocal, this.mPageIndexSyncDown, "checkPdfData", " ", " is done"));
    }

    private final ArrayList<RectContainer> intersect(TreeSet<RectContainer> set, RectContainer stroke) {
        ArrayList<RectContainer> arrayList = new ArrayList<>();
        RectContainer rectContainer = new RectContainer();
        RectF rectF = stroke.getRectF();
        Float fValueOf = rectF != null ? Float.valueOf(rectF.bottom) : null;
        Intrinsics.checkNotNull(fValueOf);
        float fFloatValue = fValueOf.floatValue();
        RectF rectF2 = stroke.getRectF();
        Float fValueOf2 = rectF2 != null ? Float.valueOf(rectF2.bottom) : null;
        Intrinsics.checkNotNull(fValueOf2);
        rectContainer.setRectF(new RectF(0.0f, fFloatValue, 10000.0f, fValueOf2.floatValue() + 1));
        RectContainer rectContainerFloor = set.floor(rectContainer);
        while (rectContainerFloor != null && rectContainerFloor.intersect(stroke)) {
            arrayList.add(rectContainerFloor);
            set.remove(rectContainerFloor);
            rectContainerFloor = set.lower(rectContainerFloor);
        }
        return arrayList;
    }

    private final void updateConflictStroke(int type) {
        if (type == 1) {
            SpenWPage spenWPage = this.mPageLocal;
            Point offset = spenWPage != null ? spenWPage.getOffset() : null;
            Companion companion = INSTANCE;
            SpenWPage spenWPage2 = this.mPageSyncDown;
            Point offset2 = spenWPage2 != null ? spenWPage2.getOffset() : null;
            Intrinsics.checkNotNull(offset2);
            Point pointScalePoint = companion.scalePoint(offset2, this.mScale);
            TreeSet<RectContainer> treeSet = this.mStrokeLocalDelete;
            if (treeSet != null) {
                Intrinsics.checkNotNull(treeSet);
                Iterator<RectContainer> it = treeSet.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    RectContainer next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    RectContainer rectContainer = next;
                    RectF rectF = rectContainer.getRectF();
                    Float fValueOf = rectF != null ? Float.valueOf(rectF.left) : null;
                    Intrinsics.checkNotNull(fValueOf);
                    int iFloatValue = (int) fValueOf.floatValue();
                    RectF rectF2 = rectContainer.getRectF();
                    Float fValueOf2 = rectF2 != null ? Float.valueOf(rectF2.top) : null;
                    Intrinsics.checkNotNull(fValueOf2);
                    Point point = new Point(iFloatValue, (int) fValueOf2.floatValue());
                    RectF rectF3 = rectContainer.getRectF();
                    Float fValueOf3 = rectF3 != null ? Float.valueOf(rectF3.left) : null;
                    Intrinsics.checkNotNull(fValueOf3);
                    int iFloatValue2 = (int) fValueOf3.floatValue();
                    int i = pointScalePoint.y;
                    RectF rectF4 = rectContainer.getRectF();
                    Float fValueOf4 = rectF4 != null ? Float.valueOf(rectF4.top) : null;
                    Intrinsics.checkNotNull(fValueOf4);
                    ConflictLocation conflictLocation = new ConflictLocation(type, true, new Point(iFloatValue2, (i + ((int) fValueOf4.floatValue())) - (offset != null ? offset.y : 0)), point);
                    conflictLocation.setMInformationConflict(rectContainer.getInformationConflict());
                    conflictLocation.setObjectRectF(rectContainer.getRectF(), null);
                    List<ConflictLocation> list = this.mListLocations;
                    if (list != null) {
                        list.add(conflictLocation);
                    }
                }
                return;
            }
            return;
        }
        if (type == 2) {
            TreeSet<RectContainer> treeSet2 = this.mStrokeFormatting;
            if (treeSet2 != null) {
                Intrinsics.checkNotNull(treeSet2);
                Iterator<RectContainer> it2 = treeSet2.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    RectContainer next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    RectContainer rectContainer2 = next2;
                    RectF rectF5 = rectContainer2.getRectF();
                    Float fValueOf5 = rectF5 != null ? Float.valueOf(rectF5.left) : null;
                    Intrinsics.checkNotNull(fValueOf5);
                    int iFloatValue3 = (int) fValueOf5.floatValue();
                    RectF rectF6 = rectContainer2.getRectF();
                    Float fValueOf6 = rectF6 != null ? Float.valueOf(rectF6.top) : null;
                    Intrinsics.checkNotNull(fValueOf6);
                    Point point2 = new Point(iFloatValue3, (int) fValueOf6.floatValue());
                    RectF rectFSync = rectContainer2.getRectFSync();
                    Float fValueOf7 = rectFSync != null ? Float.valueOf(rectFSync.left) : null;
                    Intrinsics.checkNotNull(fValueOf7);
                    int iFloatValue4 = (int) fValueOf7.floatValue();
                    RectF rectFSync2 = rectContainer2.getRectFSync();
                    Float fValueOf8 = rectFSync2 != null ? Float.valueOf(rectFSync2.top) : null;
                    Intrinsics.checkNotNull(fValueOf8);
                    ConflictLocation conflictLocation2 = new ConflictLocation(type, true, new Point(iFloatValue4, (int) fValueOf8.floatValue()), point2);
                    conflictLocation2.setMInformationConflict(rectContainer2.getInformationConflict());
                    conflictLocation2.setObjectRectF(rectContainer2.getRectF(), rectContainer2.getRectFSync());
                    List<ConflictLocation> list2 = this.mListLocations;
                    if (list2 != null) {
                        list2.add(conflictLocation2);
                    }
                }
                return;
            }
            return;
        }
        SpenWPage spenWPage3 = this.mPageLocal;
        Point offset3 = spenWPage3 != null ? spenWPage3.getOffset() : null;
        Companion companion2 = INSTANCE;
        SpenWPage spenWPage4 = this.mPageSyncDown;
        Point offset4 = spenWPage4 != null ? spenWPage4.getOffset() : null;
        Intrinsics.checkNotNull(offset4);
        Point pointScalePoint2 = companion2.scalePoint(offset4, this.mScale);
        TreeSet<RectContainer> treeSet3 = this.mStrokeSyncAdd;
        if (treeSet3 != null) {
            Intrinsics.checkNotNull(treeSet3);
            Iterator<RectContainer> it3 = treeSet3.iterator();
            Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
            while (it3.hasNext()) {
                RectContainer next3 = it3.next();
                Intrinsics.checkNotNullExpressionValue(next3, "next(...)");
                RectContainer rectContainer3 = next3;
                RectF rectF7 = rectContainer3.getRectF();
                Float fValueOf9 = rectF7 != null ? Float.valueOf(rectF7.left) : null;
                Intrinsics.checkNotNull(fValueOf9);
                int iFloatValue5 = (int) fValueOf9.floatValue();
                RectF rectF8 = rectContainer3.getRectF();
                Float fValueOf10 = rectF8 != null ? Float.valueOf(rectF8.top) : null;
                Intrinsics.checkNotNull(fValueOf10);
                Point point3 = new Point(iFloatValue5, (int) fValueOf10.floatValue());
                RectF rectF9 = rectContainer3.getRectF();
                Intrinsics.checkNotNull(rectF9);
                int i2 = (int) rectF9.left;
                RectF rectF10 = rectContainer3.getRectF();
                Intrinsics.checkNotNull(rectF10);
                ConflictLocation conflictLocation3 = new ConflictLocation(type, true, point3, new Point(i2, (((int) rectF10.top) - pointScalePoint2.y) + (offset3 != null ? offset3.y : 0)));
                conflictLocation3.setMInformationConflict(rectContainer3.getInformationConflict());
                conflictLocation3.setObjectRectF(null, rectContainer3.getRectF());
                List<ConflictLocation> list3 = this.mListLocations;
                if (list3 != null) {
                    list3.add(conflictLocation3);
                }
            }
        }
    }

    public final void checkConflictPage() {
        SpenWPage spenWPage;
        if (this.mPageSyncDown != null && (spenWPage = this.mPageLocal) != null) {
            Long lValueOf = spenWPage != null ? Long.valueOf(spenWPage.getModifiedTime()) : null;
            SpenWPage spenWPage2 = this.mPageSyncDown;
            if (Intrinsics.areEqual(lValueOf, spenWPage2 != null ? Long.valueOf(spenWPage2.getModifiedTime()) : null)) {
                return;
            }
            checkConflictBackground();
            checkPdfData();
            checkConflictObject();
        }
        Logger.m11003i(TAG, AbstractC0622a.m1164j(this.mPageIndexLocal, this.mPageIndexSyncDown, "checkConflictPage", " ", " is done"));
    }

    @NotNull
    public final List<ConflictLocation> getListLocations() {
        List<ConflictLocation> list = this.mListLocations;
        Intrinsics.checkNotNull(list);
        return list;
    }

    /* JADX INFO: renamed from: getPageIndexLocal, reason: from getter */
    public final int getMPageIndexLocal() {
        return this.mPageIndexLocal;
    }

    /* JADX INFO: renamed from: getPageIndexSyncDown, reason: from getter */
    public final int getMPageIndexSyncDown() {
        return this.mPageIndexSyncDown;
    }

    /* JADX INFO: renamed from: getType, reason: from getter */
    public final int getMType() {
        return this.mType;
    }

    public final boolean isConflict() {
        return this.isConflictBackground || this.isConflictObject;
    }

    /* JADX INFO: renamed from: isConflictBackground, reason: from getter */
    public final boolean getIsConflictBackground() {
        return this.isConflictBackground;
    }

    public final void setOffSetY(float mOffSetY) {
        this.mOffSetSync = mOffSetY;
    }

    @NotNull
    public final RectF unionRect(@NotNull RectF rect1, @NotNull RectF rect2) {
        Intrinsics.checkNotNullParameter(rect1, "rect1");
        Intrinsics.checkNotNullParameter(rect2, "rect2");
        return new RectF((float) Math.min(rect1.left, rect2.left), (float) Math.min(rect1.top, rect2.top), (float) Math.max(rect1.right, rect2.right), (float) Math.max(rect1.bottom, rect2.bottom));
    }
}
