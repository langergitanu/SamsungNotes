package androidx.compose.runtime;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.exifinterface.media.ExifInterface;
import com.samsung.scsp.common.Header;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0000\u001a\u0010\u0010<\u001a\u00020=2\u0006\u0010:\u001a\u00020;H\u0000\u001a(\u0010>\u001a\u0004\u0018\u00010\u00042\b\u0010?\u001a\u0004\u0018\u00010\u00042\b\u0010@\u001a\u0004\u0018\u00010\u00042\b\u0010A\u001a\u0004\u0018\u00010\u0004H\u0002\u001a\b\u0010B\u001a\u00020/H\u0007\u001a1\u0010C\u001a\u000e\u0012\u0004\u0012\u0002HE\u0012\u0004\u0012\u0002HF0D\"\u0004\b\u0000\u0010E\"\b\b\u0001\u0010F*\u00020\u00042\u0006\u0010G\u001a\u00020\nH\u0002¢\u0006\u0002\u0010H\u001a\u0010\u0010I\u001a\u0002092\u0006\u0010?\u001a\u00020/H\u0000\u001a*\u0010I\u001a\u0002092\u0006\u0010?\u001a\u00020/2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020;0KH\u0080\b\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a\u0018\u0010L\u001a\u0002092\u0006\u0010M\u001a\u00020N2\u0006\u0010L\u001a\u00020;H\u0007\u001a\u0010\u0010O\u001a\u0002092\u0006\u0010M\u001a\u00020NH\u0007\u001a \u0010P\u001a\u0002092\u0006\u0010M\u001a\u00020N2\u0006\u0010Q\u001a\u00020\n2\u0006\u0010L\u001a\u00020;H\u0007\u001a\b\u0010R\u001a\u000209H\u0007\u001a(\u0010S\u001a\u0002092\u0006\u0010Q\u001a\u00020\n2\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\u0006\u0010V\u001a\u00020;H\u0007\u001a\u0018\u0010S\u001a\u0002092\u0006\u0010Q\u001a\u00020\n2\u0006\u0010V\u001a\u00020;H\u0007\u001a\f\u0010W\u001a\u00020/*\u00020\nH\u0002\u001a\f\u0010X\u001a\u00020\n*\u00020/H\u0002\u001a3\u0010Y\u001a\u0002HZ\"\u0004\b\u0000\u0010Z*\u00020N2\u0006\u0010[\u001a\u00020/2\u0011\u0010\\\u001a\r\u0012\u0004\u0012\u0002HZ0K¢\u0006\u0002\b]H\u0087\b¢\u0006\u0002\u0010^\u001a\u001c\u0010_\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040`*\u00020a2\u0006\u0010b\u001a\u00020cH\u0002\u001a\u0014\u0010d\u001a\u000209*\u0002022\u0006\u0010e\u001a\u00020fH\u0000\u001a\u001c\u0010g\u001a\u00020\n*\u0002002\u0006\u0010h\u001a\u00020\n2\u0006\u0010i\u001a\u00020\nH\u0002\u001a(\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00020k*\b\u0012\u0004\u0012\u00020\u00020k2\u0006\u0010l\u001a\u00020\n2\u0006\u0010m\u001a\u00020\nH\u0002\u001a\u001a\u0010n\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00020k2\u0006\u0010o\u001a\u00020\nH\u0002\u001a\u001a\u0010p\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00020k2\u0006\u0010o\u001a\u00020\nH\u0002\u001a$\u0010q\u001a\u0004\u0018\u00010\u0002*\b\u0012\u0004\u0012\u00020\u00020k2\u0006\u0010l\u001a\u00020\n2\u0006\u0010m\u001a\u00020\nH\u0002\u001a,\u0010r\u001a\u000209*\b\u0012\u0004\u0012\u00020\u00020k2\u0006\u0010o\u001a\u00020\n2\u0006\u0010s\u001a\u00020t2\b\u0010u\u001a\u0004\u0018\u00010\u0004H\u0002\u001a$\u0010v\u001a\u00020\n*\u0002002\u0006\u0010w\u001a\u00020\n2\u0006\u0010x\u001a\u00020\n2\u0006\u0010y\u001a\u00020\nH\u0002\u001a\u0014\u0010z\u001a\u000209*\u0002022\u0006\u0010e\u001a\u00020fH\u0000\u001a&\u0010{\u001a\u000209*\u0002022\u0006\u0010|\u001a\u00020\n2\u0006\u0010h\u001a\u00020\n2\b\u0010}\u001a\u0004\u0018\u00010\u0004H\u0002\u001a\u001c\u0010~\u001a\u0004\u0018\u00010\u0002*\b\u0012\u0004\u0012\u00020\u00020k2\u0006\u0010o\u001a\u00020\nH\u0002\u001a\"\u0010\u007f\u001a\u000209*\b\u0012\u0004\u0012\u00020\u00020k2\u0006\u0010l\u001a\u00020\n2\u0006\u0010m\u001a\u00020\nH\u0002\u001a<\u0010\u0080\u0001\u001a\u000209\"\u0005\b\u0000\u0010\u0081\u0001*\u0002022\b\u0010b\u001a\u0004\u0018\u00010c2\u001b\u0010\u0082\u0001\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0005\u0012\u0003H\u0081\u00010\u0083\u0001H\u0080\b\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0016\u0010\t\u001a\u00020\n8\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0006\"\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0006\"\u000e\u0010\u000f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u001c\u0010\u0011\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\b\"\u0016\u0010\u0014\u001a\u00020\n8\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0006\"\u000e\u0010\u0016\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u001c\u0010\u0017\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\b\"\u0016\u0010\u001a\u001a\u00020\n8\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0006\"\u001c\u0010\u001c\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001e\u0010\b\"\u0016\u0010\u001f\u001a\u00020\n8\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u0006\"\u001c\u0010!\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0006\u001a\u0004\b#\u0010\b\"\u0016\u0010$\u001a\u00020\n8\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b%\u0010\u0006\"\u001c\u0010&\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0006\u001a\u0004\b(\u0010\b\"\u0016\u0010)\u001a\u00020\n8\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b*\u0010\u0006\"\u0016\u0010+\u001a\u00020\n8\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b,\u0010\u0006\"\u000e\u0010-\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010.\u001a\u00020/*\u0002008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b.\u00101\"\u0018\u0010.\u001a\u00020/*\u0002028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b.\u00103\"\u0018\u00104\u001a\u00020\u0004*\u0002058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00107¨\u0006\u0084\u0001"}, m13886d2 = {"InvalidationLocationAscending", "Ljava/util/Comparator;", "Landroidx/compose/runtime/Invalidation;", "compositionLocalMap", "", "getCompositionLocalMap$annotations", "()V", "getCompositionLocalMap", "()Ljava/lang/Object;", "compositionLocalMapKey", "", "getCompositionLocalMapKey$annotations", "compositionTracer", "Landroidx/compose/runtime/CompositionTracer;", "getCompositionTracer$annotations", "defaultsKey", "invalidGroupLocation", "invocation", "getInvocation$annotations", "getInvocation", "invocationKey", "getInvocationKey$annotations", "nodeKey", "provider", "getProvider$annotations", "getProvider", "providerKey", "getProviderKey$annotations", "providerMaps", "getProviderMaps$annotations", "getProviderMaps", "providerMapsKey", "getProviderMapsKey$annotations", "providerValues", "getProviderValues$annotations", "getProviderValues", "providerValuesKey", "getProviderValuesKey$annotations", "reference", "getReference$annotations", "getReference", "referenceKey", "getReferenceKey$annotations", "reuseKey", "getReuseKey$annotations", "rootKey", "isAfterFirstChild", "", "Landroidx/compose/runtime/SlotReader;", "(Landroidx/compose/runtime/SlotReader;)Z", "Landroidx/compose/runtime/SlotWriter;", "(Landroidx/compose/runtime/SlotWriter;)Z", "joinedKey", "Landroidx/compose/runtime/KeyInfo;", "getJoinedKey", "(Landroidx/compose/runtime/KeyInfo;)Ljava/lang/Object;", "composeImmediateRuntimeError", "", "message", "", "composeRuntimeError", "", "getKey", "value", "left", "right", "isTraceInProgress", "multiMap", "Landroidx/compose/runtime/MutableScatterMultiMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "initialCapacity", "(I)Landroidx/collection/MutableScatterMap;", "runtimeCheck", "lazyMessage", "Lkotlin/Function0;", "sourceInformation", "composer", "Landroidx/compose/runtime/Composer;", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "key", "traceEventEnd", "traceEventStart", "dirty1", "dirty2", "info", "asBool", "asInt", "cache", "T", "invalid", "block", "Landroidx/compose/runtime/DisallowComposableCalls;", "(Landroidx/compose/runtime/Composer;ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "collectNodesFrom", "", "Landroidx/compose/runtime/SlotTable;", "anchor", "Landroidx/compose/runtime/Anchor;", "deactivateCurrentGroup", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "distanceFrom", "index", "root", "filterToRange", "", "start", "end", "findInsertLocation", Header.LOCATION, "findLocation", "firstInRange", "insertIfMissing", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "instance", "nearestCommonRootOf", "a", "b", "common", "removeCurrentGroup", "removeData", "group", "data", "removeLocation", "removeRange", "withAfterAnchorInfo", "R", "cb", "Lkotlin/Function2;", "runtime_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nComposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 SlotTable.kt\nandroidx/compose/runtime/SlotWriter\n+ 4 SlotTable.kt\nandroidx/compose/runtime/SlotTable\n*L\n1#1,4584:1\n4186#1,8:4593\n4186#1,8:4608\n4553#1,7:4617\n4553#1,7:4632\n1#2:4585\n2300#3,7:4586\n2308#3:4601\n2290#3,6:4602\n2297#3:4616\n159#4,8:4624\n*S KotlinDebug\n*F\n+ 1 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n4168#1:4593,8\n4223#1:4608,8\n4243#1:4617,7\n4561#1:4632,7\n4159#1:4586,7\n4159#1:4601\n4214#1:4602,6\n4214#1:4616\n4406#1:4624,8\n*E\n"})
public final class ComposerKt {
    public static final int compositionLocalMapKey = 202;

    @Nullable
    private static CompositionTracer compositionTracer = null;
    private static final int defaultsKey = -127;
    private static final int invalidGroupLocation = -2;
    public static final int invocationKey = 200;
    private static final int nodeKey = 125;
    public static final int providerKey = 201;
    public static final int providerMapsKey = 204;
    public static final int providerValuesKey = 203;
    public static final int referenceKey = 206;
    public static final int reuseKey = 207;
    private static final int rootKey = 100;

    @NotNull
    private static final Object invocation = new OpaqueKey("provider");

    @NotNull
    private static final Object provider = new OpaqueKey("provider");

    @NotNull
    private static final Object compositionLocalMap = new OpaqueKey("compositionLocalMap");

    @NotNull
    private static final Object providerValues = new OpaqueKey("providerValues");

    @NotNull
    private static final Object providerMaps = new OpaqueKey("providers");

    @NotNull
    private static final Object reference = new OpaqueKey("reference");

    @NotNull
    private static final Comparator<Invalidation> InvalidationLocationAscending = new C1973a();

    /* JADX INFO: Access modifiers changed from: private */
    public static final int InvalidationLocationAscending$lambda$15(Invalidation invalidation, Invalidation invalidation2) {
        return Intrinsics.compare(invalidation.getLocation(), invalidation2.getLocation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean asBool(int i) {
        return i != 0;
    }

    @ComposeCompilerApi
    public static final <T> T cache(@NotNull Composer composer, boolean z, @NotNull Function0<? extends T> function0) {
        T t = (T) composer.rememberedValue();
        if (!z && t != Composer.INSTANCE.getEmpty()) {
            return t;
        }
        T tInvoke = function0.invoke();
        composer.updateRememberedValue(tInvoke);
        return tInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Object> collectNodesFrom(SlotTable slotTable, Anchor anchor) {
        ArrayList arrayList = new ArrayList();
        SlotReader slotReaderOpenReader = slotTable.openReader();
        try {
            collectNodesFrom$lambda$10$collectFromGroup(slotReaderOpenReader, arrayList, slotTable.anchorIndex(anchor));
            Unit unit = Unit.INSTANCE;
            return arrayList;
        } finally {
            slotReaderOpenReader.close();
        }
    }

    private static final void collectNodesFrom$lambda$10$collectFromGroup(SlotReader slotReader, List<Object> list, int i) {
        if (slotReader.isNode(i)) {
            list.add(slotReader.node(i));
            return;
        }
        int iGroupSize = i + 1;
        int iGroupSize2 = slotReader.groupSize(i) + i;
        while (iGroupSize < iGroupSize2) {
            collectNodesFrom$lambda$10$collectFromGroup(slotReader, list, iGroupSize);
            iGroupSize += slotReader.groupSize(iGroupSize);
        }
    }

    public static final void composeImmediateRuntimeError(@NotNull String str) {
        throw new ComposeRuntimeError(AbstractC0541b.m773o("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (", str, "). Please report to Google or use https://goo.gle/compose-feedback"));
    }

    @NotNull
    public static final Void composeRuntimeError(@NotNull String str) {
        throw new ComposeRuntimeError(AbstractC0541b.m773o("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (", str, "). Please report to Google or use https://goo.gle/compose-feedback"));
    }

    public static final void deactivateCurrentGroup(@NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
        int iAnchorIndex;
        int slotsSize;
        int currentGroup = slotWriter.getCurrentGroup();
        int currentGroupEnd = slotWriter.getCurrentGroupEnd();
        while (currentGroup < currentGroupEnd) {
            Object objNode = slotWriter.node(currentGroup);
            if (objNode instanceof ComposeNodeLifecycleCallback) {
                rememberManager.deactivating((ComposeNodeLifecycleCallback) objNode, slotWriter.getSlotsSize() - slotWriter.slotsStartIndex$runtime_release(currentGroup), -1, -1);
            }
            int iSlotIndex = slotWriter.slotIndex(slotWriter.groups, slotWriter.groupIndexToAddress(currentGroup));
            int i = currentGroup + 1;
            int iDataIndex = slotWriter.dataIndex(slotWriter.groups, slotWriter.groupIndexToAddress(i));
            for (int i2 = iSlotIndex; i2 < iDataIndex; i2++) {
                int i4 = i2 - iSlotIndex;
                Object obj = slotWriter.slots[slotWriter.dataIndexToDataAddress(i2)];
                if (obj instanceof RememberObserverHolder) {
                    RememberObserverHolder rememberObserverHolder = (RememberObserverHolder) obj;
                    RememberObserver wrapped = rememberObserverHolder.getWrapped();
                    if (!(wrapped instanceof ReusableRememberObserver)) {
                        removeData(slotWriter, currentGroup, i4, obj);
                        int slotsSize2 = slotWriter.getSlotsSize() - i4;
                        Anchor after = rememberObserverHolder.getAfter();
                        if (after == null || !after.getValid()) {
                            iAnchorIndex = -1;
                            slotsSize = -1;
                        } else {
                            iAnchorIndex = slotWriter.anchorIndex(after);
                            slotsSize = slotWriter.getSlotsSize() - slotWriter.slotsEndAllIndex$runtime_release(iAnchorIndex);
                        }
                        rememberManager.forgetting(wrapped, slotsSize2, iAnchorIndex, slotsSize);
                    }
                } else if (obj instanceof RecomposeScopeImpl) {
                    removeData(slotWriter, currentGroup, i4, obj);
                    ((RecomposeScopeImpl) obj).release();
                }
            }
            currentGroup = i;
        }
    }

    private static final int distanceFrom(SlotReader slotReader, int i, int i2) {
        int i4 = 0;
        while (i > 0 && i != i2) {
            i = slotReader.parent(i);
            i4++;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Invalidation> filterToRange(List<Invalidation> list, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        for (int iFindInsertLocation = findInsertLocation(list, i); iFindInsertLocation < list.size(); iFindInsertLocation++) {
            Invalidation invalidation = list.get(iFindInsertLocation);
            if (invalidation.getLocation() >= i2) {
                break;
            }
            arrayList.add(invalidation);
        }
        return arrayList;
    }

    private static final int findInsertLocation(List<Invalidation> list, int i) {
        int iFindLocation = findLocation(list, i);
        return iFindLocation < 0 ? -(iFindLocation + 1) : iFindLocation;
    }

    private static final int findLocation(List<Invalidation> list, int i) {
        int size = list.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i4 = (i2 + size) >>> 1;
            int iCompare = Intrinsics.compare(list.get(i4).getLocation(), i);
            if (iCompare < 0) {
                i2 = i4 + 1;
            } else {
                if (iCompare <= 0) {
                    return i4;
                }
                size = i4 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Invalidation firstInRange(List<Invalidation> list, int i, int i2) {
        int iFindInsertLocation = findInsertLocation(list, i);
        if (iFindInsertLocation >= list.size()) {
            return null;
        }
        Invalidation invalidation = list.get(iFindInsertLocation);
        if (invalidation.getLocation() < i2) {
            return invalidation;
        }
        return null;
    }

    @NotNull
    public static final Object getCompositionLocalMap() {
        return compositionLocalMap;
    }

    @NotNull
    public static final Object getInvocation() {
        return invocation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getJoinedKey(KeyInfo keyInfo) {
        return keyInfo.getObjectKey() != null ? new JoinedKey(Integer.valueOf(keyInfo.getKey()), keyInfo.getObjectKey()) : Integer.valueOf(keyInfo.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getKey(Object obj, Object obj2, Object obj3) {
        JoinedKey joinedKey = obj instanceof JoinedKey ? (JoinedKey) obj : null;
        if (joinedKey == null) {
            return null;
        }
        if (Intrinsics.areEqual(joinedKey.getLeft(), obj2) && Intrinsics.areEqual(joinedKey.getRight(), obj3)) {
            return obj;
        }
        Object key = getKey(joinedKey.getLeft(), obj2, obj3);
        return key == null ? getKey(joinedKey.getRight(), obj2, obj3) : key;
    }

    @NotNull
    public static final Object getProvider() {
        return provider;
    }

    @NotNull
    public static final Object getProviderMaps() {
        return providerMaps;
    }

    @NotNull
    public static final Object getProviderValues() {
        return providerValues;
    }

    @NotNull
    public static final Object getReference() {
        return reference;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void insertIfMissing(List<Invalidation> list, int i, RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        int iFindLocation = findLocation(list, i);
        if (iFindLocation < 0) {
            int i2 = -(iFindLocation + 1);
            if (!(obj instanceof DerivedState)) {
                obj = null;
            }
            list.add(i2, new Invalidation(recomposeScopeImpl, i, obj));
            return;
        }
        Invalidation invalidation = list.get(iFindLocation);
        if (!(obj instanceof DerivedState)) {
            invalidation.setInstances(null);
            return;
        }
        Object instances = invalidation.getInstances();
        if (instances == null) {
            invalidation.setInstances(obj);
        } else if (instances instanceof MutableScatterSet) {
            ((MutableScatterSet) instances).add(obj);
        } else {
            invalidation.setInstances(ScatterSetKt.mutableScatterSetOf(instances, obj));
        }
    }

    public static final boolean isAfterFirstChild(@NotNull SlotWriter slotWriter) {
        return slotWriter.getCurrentGroup() > slotWriter.getParent() + 1;
    }

    @ComposeCompilerApi
    public static final boolean isTraceInProgress() {
        CompositionTracer compositionTracer2 = compositionTracer;
        return compositionTracer2 != null && compositionTracer2.isTraceInProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <K, V> MutableScatterMap<K, Object> multiMap(int i) {
        return MutableScatterMultiMap.m17999constructorimpl(new MutableScatterMap(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int nearestCommonRootOf(SlotReader slotReader, int i, int i2, int i4) {
        if (i != i2) {
            if (i == i4 || i2 == i4) {
                return i4;
            }
            if (slotReader.parent(i) == i2) {
                return i2;
            }
            if (slotReader.parent(i2) != i) {
                if (slotReader.parent(i) == slotReader.parent(i2)) {
                    return slotReader.parent(i);
                }
                int iDistanceFrom = distanceFrom(slotReader, i, i4);
                int iDistanceFrom2 = distanceFrom(slotReader, i2, i4);
                int i5 = iDistanceFrom - iDistanceFrom2;
                for (int i6 = 0; i6 < i5; i6++) {
                    i = slotReader.parent(i);
                }
                int i7 = iDistanceFrom2 - iDistanceFrom;
                for (int i8 = 0; i8 < i7; i8++) {
                    i2 = slotReader.parent(i2);
                }
                while (i != i2) {
                    i = slotReader.parent(i);
                    i2 = slotReader.parent(i2);
                }
                return i;
            }
        }
        return i;
    }

    public static final void removeCurrentGroup(@NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
        int slotsSize;
        int iDataIndex = slotWriter.dataIndex(slotWriter.groups, slotWriter.groupIndexToAddress(slotWriter.groupSize(slotWriter.getCurrentGroup()) + slotWriter.getCurrentGroup()));
        for (int iDataIndex2 = slotWriter.dataIndex(slotWriter.groups, slotWriter.groupIndexToAddress(slotWriter.getCurrentGroup())); iDataIndex2 < iDataIndex; iDataIndex2++) {
            Object obj = slotWriter.slots[slotWriter.dataIndexToDataAddress(iDataIndex2)];
            int iAnchorIndex = -1;
            if (obj instanceof ComposeNodeLifecycleCallback) {
                rememberManager.releasing((ComposeNodeLifecycleCallback) obj, slotWriter.getSlotsSize() - iDataIndex2, -1, -1);
            }
            if (obj instanceof RememberObserverHolder) {
                int slotsSize2 = slotWriter.getSlotsSize() - iDataIndex2;
                RememberObserverHolder rememberObserverHolder = (RememberObserverHolder) obj;
                Anchor after = rememberObserverHolder.getAfter();
                if (after == null || !after.getValid()) {
                    slotsSize = -1;
                } else {
                    iAnchorIndex = slotWriter.anchorIndex(after);
                    slotsSize = slotWriter.getSlotsSize() - slotWriter.slotsEndAllIndex$runtime_release(iAnchorIndex);
                }
                rememberManager.forgetting(rememberObserverHolder.getWrapped(), slotsSize2, iAnchorIndex, slotsSize);
            }
            if (obj instanceof RecomposeScopeImpl) {
                ((RecomposeScopeImpl) obj).release();
            }
        }
        slotWriter.removeGroup();
    }

    private static final void removeData(SlotWriter slotWriter, int i, int i2, Object obj) {
        if (obj == slotWriter.set(i, i2, Composer.INSTANCE.getEmpty())) {
            return;
        }
        composeImmediateRuntimeError("Slot table is out of sync");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Invalidation removeLocation(List<Invalidation> list, int i) {
        int iFindLocation = findLocation(list, i);
        if (iFindLocation >= 0) {
            return list.remove(iFindLocation);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeRange(List<Invalidation> list, int i, int i2) {
        int iFindInsertLocation = findInsertLocation(list, i);
        while (iFindInsertLocation < list.size() && list.get(iFindInsertLocation).getLocation() < i2) {
            list.remove(iFindInsertLocation);
        }
    }

    public static final void runtimeCheck(boolean z, @NotNull Function0<String> function0) {
        if (z) {
            return;
        }
        composeImmediateRuntimeError(function0.invoke());
    }

    @ComposeCompilerApi
    public static final void sourceInformation(@NotNull Composer composer, @NotNull String str) {
        composer.sourceInformation(str);
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerEnd(@NotNull Composer composer) {
        composer.sourceInformationMarkerEnd();
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerStart(@NotNull Composer composer, int i, @NotNull String str) {
        composer.sourceInformationMarkerStart(i, str);
    }

    @ComposeCompilerApi
    public static final void traceEventEnd() {
        CompositionTracer compositionTracer2 = compositionTracer;
        if (compositionTracer2 != null) {
            compositionTracer2.traceEventEnd();
        }
    }

    public static final <R> void withAfterAnchorInfo(@NotNull SlotWriter slotWriter, @Nullable Anchor anchor, @NotNull Function2<? super Integer, ? super Integer, ? extends R> function2) {
        int iAnchorIndex;
        int slotsSize;
        if (anchor == null || !anchor.getValid()) {
            iAnchorIndex = -1;
            slotsSize = -1;
        } else {
            iAnchorIndex = slotWriter.anchorIndex(anchor);
            slotsSize = slotWriter.getSlotsSize() - slotWriter.slotsEndAllIndex$runtime_release(iAnchorIndex);
        }
        function2.invoke(Integer.valueOf(iAnchorIndex), Integer.valueOf(slotsSize));
    }

    public static final boolean isAfterFirstChild(@NotNull SlotReader slotReader) {
        return slotReader.getCurrentGroup() > slotReader.getParent() + 1;
    }

    public static final void runtimeCheck(boolean z) {
        if (z) {
            return;
        }
        composeImmediateRuntimeError("Check failed");
    }

    @ComposeCompilerApi
    public static final void traceEventStart(int i, int i2, int i4, @NotNull String str) {
        CompositionTracer compositionTracer2 = compositionTracer;
        if (compositionTracer2 != null) {
            compositionTracer2.traceEventStart(i, i2, i4, str);
        }
    }

    @PublishedApi
    public static /* synthetic */ void getCompositionLocalMap$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getCompositionLocalMapKey$annotations() {
    }

    private static /* synthetic */ void getCompositionTracer$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getInvocation$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getInvocationKey$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getProvider$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getProviderKey$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getProviderMaps$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getProviderMapsKey$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getProviderValues$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getProviderValuesKey$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getReference$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getReferenceKey$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getReuseKey$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int asInt(boolean z) {
        return z ? 1 : 0;
    }
}
