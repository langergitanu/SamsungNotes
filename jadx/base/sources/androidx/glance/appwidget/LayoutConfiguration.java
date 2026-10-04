package androidx.glance.appwidget;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.datastore.DataStoreFile;
import androidx.datastore.core.CorruptionException;
import androidx.glance.Emittable;
import androidx.glance.GlanceId;
import androidx.glance.appwidget.proto.LayoutProto;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.state.GlanceState;
import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aBS\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\u0010\rJ\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u0019R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u00020\u000f8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Landroidx/glance/appwidget/LayoutConfiguration;", "", "context", "Landroid/content/Context;", "layoutConfig", "", "Landroidx/glance/appwidget/proto/LayoutProto$LayoutNode;", "", "nextIndex", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "usedLayoutIds", "", "existingLayoutIds", "(Landroid/content/Context;Ljava/util/Map;IILjava/util/Set;Ljava/util/Set;)V", "dataStoreFile", "Ljava/io/File;", "getDataStoreFile$glance_appwidget_release$annotations", "()V", "getDataStoreFile$glance_appwidget_release", "()Ljava/io/File;", "addLayout", "layoutRoot", "Landroidx/glance/Emittable;", "save", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class LayoutConfiguration {
    private final int appWidgetId;

    @NotNull
    private final Context context;

    @NotNull
    private final File dataStoreFile;

    @NotNull
    private final Set<Integer> existingLayoutIds;

    @NotNull
    private final Map<LayoutProto.LayoutNode, Integer> layoutConfig;
    private int nextIndex;

    @NotNull
    private final Set<Integer> usedLayoutIds;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tJ5\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0001¢\u0006\u0002\b\tJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0080@¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m13886d2 = {"Landroidx/glance/appwidget/LayoutConfiguration$Companion;", "", "()V", "create", "Landroidx/glance/appwidget/LayoutConfiguration;", "context", "Landroid/content/Context;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "create$glance_appwidget_release", "nextIndex", "existingLayoutIds", "", OpenSessionApi.ITEM_LIMIT_DELETE, "", "id", "Landroidx/glance/GlanceId;", "load", "load$glance_appwidget_release", "(Landroid/content/Context;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nWidgetLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetLayout.kt\nandroidx/glance/appwidget/LayoutConfiguration$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,435:1\n1179#2,2:436\n1253#2,4:438\n*S KotlinDebug\n*F\n+ 1 WidgetLayout.kt\nandroidx/glance/appwidget/LayoutConfiguration$Companion\n*L\n122#1:436,2\n122#1:438,4\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LayoutConfiguration create$glance_appwidget_release$default(Companion companion, Context context, int i, int i2, Collection collection, int i4, Object obj) {
            if ((i4 & 8) != 0) {
                collection = CollectionsKt.emptyList();
            }
            return companion.create$glance_appwidget_release(context, i, i2, collection);
        }

        @NotNull
        public final LayoutConfiguration create$glance_appwidget_release(@NotNull Context context, int appWidgetId) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new LayoutConfiguration(context, new LinkedHashMap(), 0, appWidgetId, null, null, 48, null);
        }

        public final boolean delete(@NotNull Context context, @NotNull GlanceId id) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(id, "id");
            if (!(id instanceof AppWidgetId)) {
                return false;
            }
            AppWidgetId appWidgetId = (AppWidgetId) id;
            if (!AppWidgetUtilsKt.isRealId(appWidgetId)) {
                return false;
            }
            try {
                return DataStoreFile.dataStoreFile(context, WidgetLayoutKt.layoutDatastoreKey(appWidgetId.getAppWidgetId())).delete();
            } catch (Exception e) {
                GlanceLog.INSTANCE.m2298d("GWT:WidgetLayout", "Could not delete LayoutConfiguration dataStoreFile when cleaning upold appwidget id " + id, e);
                return false;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object load$glance_appwidget_release(@NotNull Context context, int i, @NotNull Continuation<? super LayoutConfiguration> continuation) {
            LayoutConfiguration$Companion$load$1 layoutConfiguration$Companion$load$1;
            LayoutProto.LayoutConfig defaultInstance;
            if (continuation instanceof LayoutConfiguration$Companion$load$1) {
                layoutConfiguration$Companion$load$1 = (LayoutConfiguration$Companion$load$1) continuation;
                int i2 = layoutConfiguration$Companion$load$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    layoutConfiguration$Companion$load$1.label = i2 - Integer.MIN_VALUE;
                } else {
                    layoutConfiguration$Companion$load$1 = new LayoutConfiguration$Companion$load$1(this, continuation);
                }
            }
            Object value = layoutConfiguration$Companion$load$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = layoutConfiguration$Companion$load$1.label;
            try {
                if (i4 == 0) {
                    ResultKt.throwOnFailure(value);
                    GlanceState glanceState = GlanceState.INSTANCE;
                    LayoutStateDefinition layoutStateDefinition = LayoutStateDefinition.INSTANCE;
                    String strLayoutDatastoreKey = WidgetLayoutKt.layoutDatastoreKey(i);
                    layoutConfiguration$Companion$load$1.L$0 = context;
                    layoutConfiguration$Companion$load$1.I$0 = i;
                    layoutConfiguration$Companion$load$1.label = 1;
                    value = glanceState.getValue(context, layoutStateDefinition, strLayoutDatastoreKey, layoutConfiguration$Companion$load$1);
                    if (value == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = layoutConfiguration$Companion$load$1.I$0;
                    context = (Context) layoutConfiguration$Companion$load$1.L$0;
                    ResultKt.throwOnFailure(value);
                }
                defaultInstance = (LayoutProto.LayoutConfig) value;
            } catch (CorruptionException e) {
                GlanceLog.INSTANCE.m2300e("GWT:WidgetLayout", AbstractC0541b.m767i(i, "Set of layout structures for App Widget id ", " is corrupted"), e);
                defaultInstance = LayoutProto.LayoutConfig.getDefaultInstance();
            } catch (IOException e2) {
                GlanceLog.INSTANCE.m2300e("GWT:WidgetLayout", "I/O error reading set of layout structures for App Widget id " + i, e2);
                defaultInstance = LayoutProto.LayoutConfig.getDefaultInstance();
            }
            Context context2 = context;
            int i5 = i;
            List<LayoutProto.LayoutDefinition> layoutList = defaultInstance.getLayoutList();
            Intrinsics.checkNotNullExpressionValue(layoutList, "getLayoutList(...)");
            List<LayoutProto.LayoutDefinition> list = layoutList;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.m13952k(list)), 16));
            for (LayoutProto.LayoutDefinition layoutDefinition : list) {
                Pair pairM13893to = TuplesKt.m13893to(layoutDefinition.getLayout(), Boxing.boxInt(layoutDefinition.getLayoutIndex()));
                linkedHashMap.put(pairM13893to.getFirst(), pairM13893to.getSecond());
            }
            Map mutableMap = MapsKt.toMutableMap(linkedHashMap);
            return new LayoutConfiguration(context2, mutableMap, defaultInstance.getNextIndex(), i5, null, CollectionsKt.toMutableSet(mutableMap.values()), 16, null);
        }

        private Companion() {
        }

        @VisibleForTesting
        @NotNull
        public final LayoutConfiguration create$glance_appwidget_release(@NotNull Context context, int appWidgetId, int nextIndex, @NotNull Collection<Integer> existingLayoutIds) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(existingLayoutIds, "existingLayoutIds");
            return new LayoutConfiguration(context, new LinkedHashMap(), nextIndex, appWidgetId, null, CollectionsKt.toMutableSet(existingLayoutIds), 16, null);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.LayoutConfiguration$save$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.LayoutConfiguration", m14021f = "WidgetLayout.kt", m14022i = {}, m14023l = {JPEG.APP10}, m14024m = "save", m14025n = {}, m14026s = {})
    public static final class C28701 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C28701(Continuation<? super C28701> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LayoutConfiguration.this.save(this);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.LayoutConfiguration$save$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, m13886d2 = {"<anonymous>", "Landroidx/glance/appwidget/proto/LayoutProto$LayoutConfig;", ExternalDataConstants.EmbeddingConfig.KEY}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.LayoutConfiguration$save$2", m14021f = "WidgetLayout.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    @SourceDebugExtension({"SMAP\nWidgetLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetLayout.kt\nandroidx/glance/appwidget/LayoutConfiguration$save$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,435:1\n1855#2,2:436\n*S KotlinDebug\n*F\n+ 1 WidgetLayout.kt\nandroidx/glance/appwidget/LayoutConfiguration$save$2\n*L\n242#1:436,2\n*E\n"})
    public static final class C28712 extends SuspendLambda implements Function2<LayoutProto.LayoutConfig, Continuation<? super LayoutProto.LayoutConfig>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public C28712(Continuation<? super C28712> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C28712 c28712 = LayoutConfiguration.this.new C28712(continuation);
            c28712.L$0 = obj;
            return c28712;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull LayoutProto.LayoutConfig layoutConfig, @Nullable Continuation<? super LayoutProto.LayoutConfig> continuation) {
            return ((C28712) create(layoutConfig, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            LayoutProto.LayoutConfig.Builder builder = ((LayoutProto.LayoutConfig) this.L$0).toBuilder();
            LayoutConfiguration layoutConfiguration = LayoutConfiguration.this;
            LayoutProto.LayoutConfig.Builder builder2 = builder;
            builder2.setNextIndex(builder2.getNextIndex());
            builder2.clearLayout();
            for (Map.Entry entry : layoutConfiguration.layoutConfig.entrySet()) {
                LayoutProto.LayoutNode layoutNode = (LayoutProto.LayoutNode) entry.getKey();
                int iIntValue = ((Number) entry.getValue()).intValue();
                if (layoutConfiguration.usedLayoutIds.contains(Boxing.boxInt(iIntValue))) {
                    LayoutProto.LayoutDefinition.Builder builderNewBuilder = LayoutProto.LayoutDefinition.newBuilder();
                    builderNewBuilder.setLayout(layoutNode);
                    builderNewBuilder.setLayoutIndex(iIntValue);
                    builder2.addLayout(builderNewBuilder);
                }
            }
            LayoutProto.LayoutConfig layoutConfigBuild = builder2.build();
            Intrinsics.checkNotNullExpressionValue(layoutConfigBuild, "build(...)");
            return layoutConfigBuild;
        }
    }

    private LayoutConfiguration(Context context, Map<LayoutProto.LayoutNode, Integer> map, int i, int i2, Set<Integer> set, Set<Integer> set2) {
        this.context = context;
        this.layoutConfig = map;
        this.nextIndex = i;
        this.appWidgetId = i2;
        this.usedLayoutIds = set;
        this.existingLayoutIds = set2;
        this.dataStoreFile = DataStoreFile.dataStoreFile(context, WidgetLayoutKt.layoutDatastoreKey(i2));
    }

    public final int addLayout(@NotNull Emittable layoutRoot) {
        Intrinsics.checkNotNullParameter(layoutRoot, "layoutRoot");
        LayoutProto.LayoutNode layoutNodeCreateNode = WidgetLayoutKt.createNode(this.context, layoutRoot);
        synchronized (this) {
            Integer num = this.layoutConfig.get(layoutNodeCreateNode);
            if (num != null) {
                int iIntValue = num.intValue();
                this.usedLayoutIds.add(Integer.valueOf(iIntValue));
                return iIntValue;
            }
            int topLevelLayoutsCount = this.nextIndex;
            while (this.existingLayoutIds.contains(Integer.valueOf(topLevelLayoutsCount))) {
                topLevelLayoutsCount = (topLevelLayoutsCount + 1) % LayoutSelectionKt.getTopLevelLayoutsCount();
                if (topLevelLayoutsCount == this.nextIndex) {
                    throw new IllegalArgumentException("Cannot assign a valid layout index to the new layout: no free index left.");
                }
            }
            this.nextIndex = (topLevelLayoutsCount + 1) % LayoutSelectionKt.getTopLevelLayoutsCount();
            this.usedLayoutIds.add(Integer.valueOf(topLevelLayoutsCount));
            this.existingLayoutIds.add(Integer.valueOf(topLevelLayoutsCount));
            this.layoutConfig.put(layoutNodeCreateNode, Integer.valueOf(topLevelLayoutsCount));
            return topLevelLayoutsCount;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: getDataStoreFile$glance_appwidget_release, reason: from getter */
    public final File getDataStoreFile() {
        return this.dataStoreFile;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object save(@NotNull Continuation<? super Unit> continuation) {
        C28701 c28701;
        if (continuation instanceof C28701) {
            c28701 = (C28701) continuation;
            int i = c28701.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c28701.label = i - Integer.MIN_VALUE;
            } else {
                c28701 = new C28701(continuation);
            }
        }
        C28701 c287012 = c28701;
        Object obj = c287012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c287012.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                GlanceState glanceState = GlanceState.INSTANCE;
                Context context = this.context;
                LayoutStateDefinition layoutStateDefinition = LayoutStateDefinition.INSTANCE;
                String strLayoutDatastoreKey = WidgetLayoutKt.layoutDatastoreKey(this.appWidgetId);
                C28712 c28712 = new C28712(null);
                c287012.label = 1;
                if (glanceState.updateValue(context, layoutStateDefinition, strLayoutDatastoreKey, c28712, c287012) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception e) {
            GlanceLog.INSTANCE.m2297d("GWT:WidgetLayout", "LayoutConfiguration exception : " + e);
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ LayoutConfiguration(Context context, Map map, int i, int i2, Set set, Set set2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, map, i, i2, (i4 & 16) != 0 ? new LinkedHashSet() : set, (i4 & 32) != 0 ? new LinkedHashSet() : set2);
    }

    @VisibleForTesting
    public static /* synthetic */ void getDataStoreFile$glance_appwidget_release$annotations() {
    }
}
