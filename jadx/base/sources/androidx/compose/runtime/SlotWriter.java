package androidx.compose.runtime;

import androidx.collection.AbstractC0622a;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.RangesKt;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\bK\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 Ë\u00012\u00020\u0001:\u0002Ë\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\rJ\u0010\u0010F\u001a\u00020\u00072\b\b\u0002\u0010G\u001a\u00020\rJ\u000e\u0010H\u001a\u00020\r2\u0006\u0010F\u001a\u00020\u0007J\u0018\u0010I\u001a\u00020D2\u0006\u0010F\u001a\u00020\u00072\b\u0010J\u001a\u0004\u0018\u00010\u0001J\u0006\u0010K\u001a\u00020DJ\u0006\u0010L\u001a\u00020DJ\u0010\u0010M\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\rH\u0002J\b\u0010O\u001a\u00020DH\u0002J\u000e\u0010P\u001a\u00020D2\u0006\u0010Q\u001a\u00020\u0011J\u0010\u0010R\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\rH\u0002J\u0010\u0010S\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\rH\u0002J \u0010T\u001a\u00020\r2\u0006\u0010F\u001a\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010V\u001a\u00020\r2\u0006\u0010G\u001a\u00020\rH\u0002J\u0010\u0010W\u001a\u00020\r2\u0006\u0010V\u001a\u00020\rH\u0002J(\u0010X\u001a\u00020\r2\u0006\u0010G\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0006\u0010Z\u001a\u00020\rJ\u0006\u0010[\u001a\u00020DJ\u000e\u0010\\\u001a\u00020D2\u0006\u0010F\u001a\u00020\u0007J\u000e\u0010\\\u001a\u00020D2\u0006\u0010G\u001a\u00020\rJ \u0010]\u001a\u00020D2\u0006\u0010.\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\r2\u0006\u0010^\u001a\u00020\rH\u0002JK\u0010_\u001a\u00020D2\u0006\u0010N\u001a\u00020\r28\u0010`\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\bb\u0012\b\bc\u0012\u0004\b\b(G\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\bb\u0012\b\bc\u0012\u0004\b\b(d\u0012\u0004\u0012\u00020D0aH\u0086\bJK\u0010e\u001a\u00020D2\u0006\u0010N\u001a\u00020\r28\u0010`\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\bb\u0012\b\bc\u0012\u0004\b\b(G\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\bb\u0012\b\bc\u0012\u0004\b\b(d\u0012\u0004\u0012\u00020D0aH\u0086\bJ5\u0010f\u001a\u00020D2\u0006\u0010g\u001a\u00020\r2\u0006\u0010h\u001a\u00020\r2\u001a\u0010`\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020D0aH\u0086\bJ\u0010\u0010i\u001a\u0004\u0018\u00010\u00012\u0006\u0010G\u001a\u00020\rJ\u0010\u0010j\u001a\u00020\r2\u0006\u0010G\u001a\u00020\rH\u0002J\u000e\u0010k\u001a\u00020\r2\u0006\u0010G\u001a\u00020\rJ\u0010\u0010l\u001a\u0004\u0018\u00010\u00012\u0006\u0010G\u001a\u00020\rJ\u000e\u0010m\u001a\u00020\r2\u0006\u0010G\u001a\u00020\rJ\u000e\u0010n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010oJ\u001c\u0010p\u001a\u0004\u0018\u00010>2\u0006\u0010.\u001a\u00020\r2\b\u0010q\u001a\u0004\u0018\u00010rH\u0002J\u000e\u0010s\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\rJ\u0016\u0010t\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\r2\u0006\u0010N\u001a\u00020\rJ\u000e\u0010u\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\rJ\u0010\u0010v\u001a\u00020D2\b\u0010J\u001a\u0004\u0018\u00010\u0001J\u0010\u0010w\u001a\u00020D2\u0006\u00102\u001a\u00020\rH\u0002J\u0018\u0010x\u001a\u00020D2\u0006\u00102\u001a\u00020\r2\u0006\u0010N\u001a\u00020\rH\u0002J\u000e\u0010+\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\rJ\u000e\u0010y\u001a\b\u0012\u0004\u0012\u00020\r0zH\u0002J\u0010\u0010{\u001a\u00020D2\b\b\u0002\u0010N\u001a\u00020\rJ \u0010|\u001a\u00020D2\u0006\u0010}\u001a\u00020\r2\u0006\u0010~\u001a\u00020\r2\u0006\u00102\u001a\u00020\rH\u0002J'\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u00070z2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010G\u001a\u00020\r2\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u0011J\u0010\u0010\u0081\u0001\u001a\u00020D2\u0007\u0010\u0082\u0001\u001a\u00020\rJ\u0011\u0010\u0083\u0001\u001a\u00020D2\u0006\u0010G\u001a\u00020\rH\u0002J&\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070z2\u0007\u0010\u0082\u0001\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010G\u001a\u00020\rJ\u0019\u0010\u0085\u0001\u001a\u00020D2\u0006\u0010G\u001a\u00020\r2\u0006\u0010N\u001a\u00020\rH\u0002J'\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070z2\u0006\u0010F\u001a\u00020\u00072\u0007\u0010\u0082\u0001\u001a\u00020\r2\u0007\u0010\u0087\u0001\u001a\u00020\u0000J\u0011\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010F\u001a\u00020\u0007J\u0011\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010G\u001a\u00020\rJ\u000e\u0010,\u001a\u00020\r2\u0006\u0010G\u001a\u00020\rJ\u000e\u0010.\u001a\u00020\r2\u0006\u0010F\u001a\u00020\u0007J\u000e\u0010.\u001a\u00020\r2\u0006\u0010G\u001a\u00020\rJ\u0011\u0010\u0089\u0001\u001a\u00020\r2\u0006\u0010G\u001a\u00020\rH\u0002J\u0019\u0010\u008a\u0001\u001a\u00020\r2\u0006\u0010G\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\rH\u0002J\u0015\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010J\u001a\u0004\u0018\u00010\u0001H\u0002J\t\u0010\u008c\u0001\u001a\u00020DH\u0002J\u000f\u0010\u008d\u0001\u001a\u00020D2\u0006\u0010q\u001a\u00020rJ\u0007\u0010\u008e\u0001\u001a\u00020DJ\u0018\u0010\u008f\u0001\u001a\u00020D2\u0007\u0010\u0090\u0001\u001a\u00020\r2\u0006\u0010J\u001a\u00020rJA\u0010\u0091\u0001\u001a\u00020\u00112\u0006\u0010Y\u001a\u00020\r2\u0006\u00102\u001a\u00020\r2&\u0010<\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020>\u0018\u00010=j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020>\u0018\u0001`?H\u0002J\u0007\u0010\u0092\u0001\u001a\u00020\u0011J\u001b\u0010\u0093\u0001\u001a\u00020\u00112\u0007\u0010\u0094\u0001\u001a\u00020\r2\u0007\u0010\u0095\u0001\u001a\u00020\rH\u0002J#\u0010\u0096\u0001\u001a\u00020D2\u0007\u0010\u0094\u0001\u001a\u00020\r2\u0007\u0010\u0095\u0001\u001a\u00020\r2\u0006\u0010N\u001a\u00020\rH\u0002J\u0007\u0010\u0097\u0001\u001a\u00020DJ\t\u0010\u0098\u0001\u001a\u00020\rH\u0002J\t\u0010\u0099\u0001\u001a\u00020DH\u0002J\u000f\u0010\u009a\u0001\u001a\u00020D2\u0006\u0010F\u001a\u00020\u0007J\u0011\u0010\u009b\u0001\u001a\u00020D2\b\u0010J\u001a\u0004\u0018\u00010\u0001J\u001b\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010G\u001a\u00020\r2\b\u0010J\u001a\u0004\u0018\u00010\u0001J#\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010N\u001a\u00020\r2\u0006\u0010G\u001a\u00020\r2\b\u0010J\u001a\u0004\u0018\u00010\u0001J\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0001J\u0007\u0010\u009d\u0001\u001a\u00020\rJ\u0007\u0010\u009e\u0001\u001a\u00020DJ\u0019\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\rJ\u0019\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010g\u001a\u00020\r2\u0006\u0010G\u001a\u00020\rJ\u0017\u0010 \u0001\u001a\u00020\r2\u0006\u0010N\u001a\u00020\r2\u0006\u0010G\u001a\u00020\rJ\u0017\u0010¡\u0001\u001a\u00020\r2\u0006\u0010g\u001a\u00020\rH\u0000¢\u0006\u0003\b¢\u0001J\u0017\u0010£\u0001\u001a\u00020\r2\u0006\u0010g\u001a\u00020\rH\u0000¢\u0006\u0003\b¤\u0001J\u0017\u0010¥\u0001\u001a\u00020\r2\u0006\u0010g\u001a\u00020\rH\u0000¢\u0006\u0003\b¦\u0001J\u0013\u0010§\u0001\u001a\u0004\u0018\u00010>2\u0006\u0010N\u001a\u00020\rH\u0002J\u001b\u0010¨\u0001\u001a\u00020D2\u0007\u0010\u0090\u0001\u001a\u00020\r2\t\u0010©\u0001\u001a\u0004\u0018\u00010\u0001J&\u0010¨\u0001\u001a\u00020D2\u0007\u0010\u0090\u0001\u001a\u00020\r2\t\u0010ª\u0001\u001a\u0004\u0018\u00010\u00012\t\u0010©\u0001\u001a\u0004\u0018\u00010\u0001J\u0007\u0010«\u0001\u001a\u00020DJ\u0010\u0010«\u0001\u001a\u00020D2\u0007\u0010\u0090\u0001\u001a\u00020\rJ\u001b\u0010«\u0001\u001a\u00020D2\u0007\u0010\u0090\u0001\u001a\u00020\r2\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u0001J0\u0010«\u0001\u001a\u00020D2\u0007\u0010\u0090\u0001\u001a\u00020\r2\t\u0010ª\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010+\u001a\u00020\u00112\t\u0010©\u0001\u001a\u0004\u0018\u00010\u0001H\u0002J\u001b\u0010\u00ad\u0001\u001a\u00020D2\u0007\u0010\u0090\u0001\u001a\u00020\r2\t\u0010ª\u0001\u001a\u0004\u0018\u00010\u0001J&\u0010\u00ad\u0001\u001a\u00020D2\u0007\u0010\u0090\u0001\u001a\u00020\r2\t\u0010ª\u0001\u001a\u0004\u0018\u00010\u00012\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0001J\u0007\u0010®\u0001\u001a\u00020rJ\t\u0010¯\u0001\u001a\u00020rH\u0016J\u000f\u0010°\u0001\u001a\u00020D2\u0006\u0010h\u001a\u00020\rJ\u0019\u0010±\u0001\u001a\u0004\u0018\u00010\u00072\u0006\u0010N\u001a\u00020\rH\u0000¢\u0006\u0003\b²\u0001J\u0013\u0010³\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010J\u001a\u0004\u0018\u00010\u0001J\u001b\u0010´\u0001\u001a\u00020D2\u0007\u0010µ\u0001\u001a\u00020\r2\u0007\u0010¶\u0001\u001a\u00020\rH\u0002J\u0011\u0010·\u0001\u001a\u00020D2\b\u0010J\u001a\u0004\u0018\u00010\u0001J\u0011\u0010¸\u0001\u001a\u00020D2\u0006\u0010N\u001a\u00020\rH\u0002J\u001a\u0010¹\u0001\u001a\u00020D2\u0006\u0010N\u001a\u00020\r2\u0007\u0010\u009b\u0001\u001a\u000201H\u0002J\u0019\u0010º\u0001\u001a\u00020D2\u0006\u0010F\u001a\u00020\u00072\b\u0010J\u001a\u0004\u0018\u00010\u0001J\u0011\u0010º\u0001\u001a\u00020D2\b\u0010J\u001a\u0004\u0018\u00010\u0001J\u001b\u0010»\u0001\u001a\u00020D2\u0006\u0010G\u001a\u00020\r2\b\u0010J\u001a\u0004\u0018\u00010\u0001H\u0002J\u0011\u0010¼\u0001\u001a\u00020D2\b\u0010J\u001a\u0004\u0018\u00010\u0001J\u0007\u0010½\u0001\u001a\u00020DJ\u000f\u0010¾\u0001\u001a\u00020DH\u0000¢\u0006\u0003\b¿\u0001J\u000f\u0010À\u0001\u001a\u00020DH\u0000¢\u0006\u0003\bÁ\u0001J\u0016\u0010Â\u0001\u001a\u00020\r*\u00020(2\u0007\u0010Ã\u0001\u001a\u00020\rH\u0002J\u0015\u0010V\u001a\u00020\r*\u00020(2\u0007\u0010Ã\u0001\u001a\u00020\rH\u0002J\u0013\u0010Ä\u0001\u001a\b\u0012\u0004\u0012\u00020\r0z*\u00020(H\u0002J\u001b\u0010Å\u0001\u001a\u00020D*\b0Æ\u0001j\u0003`Ç\u00012\u0006\u0010G\u001a\u00020\rH\u0002J\u0016\u0010È\u0001\u001a\u00020\r*\u00020(2\u0007\u0010Ã\u0001\u001a\u00020\rH\u0002J\u0014\u0010.\u001a\u00020\r*\u00020(2\u0006\u0010G\u001a\u00020\rH\u0002J\u0016\u0010É\u0001\u001a\u00020\r*\u00020(2\u0007\u0010Ã\u0001\u001a\u00020\rH\u0002J\u001e\u0010Ê\u0001\u001a\u00020D*\u00020(2\u0007\u0010Ã\u0001\u001a\u00020\r2\u0006\u0010V\u001a\u00020\rH\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u001e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000fR\u001e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000fR\u0014\u0010\u001d\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000fR\u000e\u0010\u001f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010*\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b*\u0010\u0014R\u0011\u0010+\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b+\u0010\u0014R\u000e\u0010,\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010.\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u000fR\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u000fR\u0018\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000105X\u0082\u000e¢\u0006\u0004\n\u0002\u00106R\u000e\u00107\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010:\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b;\u0010\u000fR.\u0010<\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020>\u0018\u00010=j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020>\u0018\u0001`?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010B¨\u0006Ì\u0001"}, m13886d2 = {"Landroidx/compose/runtime/SlotWriter;", "", "table", "Landroidx/compose/runtime/SlotTable;", "(Landroidx/compose/runtime/SlotTable;)V", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "calledByMap", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableIntSet;", ImageConst.ImageUpscaleConst.SHARED_MEM_CAPACITY, "", "getCapacity", "()I", "<set-?>", "", "closed", "getClosed", "()Z", "collectingCalledInformation", "getCollectingCalledInformation", "collectingSourceInformation", "getCollectingSourceInformation", "currentGroup", "getCurrentGroup", "currentGroupEnd", "getCurrentGroupEnd", "currentGroupSlotIndex", "getCurrentGroupSlotIndex", "currentSlot", "currentSlotEnd", "deferredSlotWrites", "Landroidx/collection/MutableObjectList;", "endStack", "Landroidx/compose/runtime/IntStack;", "groupGapLen", "groupGapStart", "groups", "", "insertCount", "isGroupEnd", "isNode", "nodeCount", "nodeCountStack", "parent", "getParent", "pendingRecalculateMarks", "Landroidx/compose/runtime/PrioritySet;", "size", "getSize$runtime_release", "slots", "", "[Ljava/lang/Object;", "slotsGapLen", "slotsGapOwner", "slotsGapStart", "slotsSize", "getSlotsSize", "sourceInformationMap", "Ljava/util/HashMap;", "Landroidx/compose/runtime/GroupSourceInformation;", "Lkotlin/collections/HashMap;", "startStack", "getTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "advanceBy", "", "amount", "anchor", "index", "anchorIndex", "appendSlot", "value", "bashCurrentGroup", "beginInsert", "childContainsAnyMarks", "group", "clearSlotGap", "close", "normalClose", "containsAnyGroupMarks", "containsGroupMark", "dataAnchorToDataIndex", "gapLen", "dataIndex", "dataIndexToDataAddress", "dataIndexToDataAnchor", "gapStart", "endGroup", "endInsert", "ensureStarted", "fixParentAnchorsFor", "firstChild", "forAllData", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "data", "forEachData", "forEachTailSlot", "groupIndex", "count", "groupAux", "groupIndexToAddress", "groupKey", "groupObjectKey", "groupSize", "groupSlots", "", "groupSourceInformationFor", "sourceInformation", "", "indexInCurrentGroup", "indexInGroup", "indexInParent", "insertAux", "insertGroups", "insertSlots", "keys", "", "markGroup", "moveAnchors", "originalLocation", "newLocation", "moveFrom", "removeSourceGroup", "moveGroup", TypedValues.Cycle.S_WAVE_OFFSET, "moveGroupGapTo", "moveIntoGroupFrom", "moveSlotGapTo", "moveTo", "writer", "node", "parentAnchorToIndex", "parentIndexToAnchor", "rawUpdate", "recalculateMarks", "recordGroupSourceInformation", "recordGrouplessCallSourceInformationEnd", "recordGrouplessCallSourceInformationStart", "key", "removeAnchors", "removeGroup", "removeGroups", "start", "len", "removeSlots", "reset", "restoreCurrentGroupEnd", "saveCurrentGroupEnd", "seek", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "skip", "skipGroup", "skipToGroupEnd", "slot", "slotIndexOfGroupSlotIndex", "slotsEndAllIndex", "slotsEndAllIndex$runtime_release", "slotsEndIndex", "slotsEndIndex$runtime_release", "slotsStartIndex", "slotsStartIndex$runtime_release", "sourceInformationOf", "startData", "aux", "objectKey", "startGroup", "dataKey", "startNode", "toDebugString", "toString", "trimTailSlots", "tryAnchor", "tryAnchor$runtime_release", Constants.ARG_UPDATE, "updateAnchors", "previousGapStart", "newGapStart", "updateAux", "updateContainsMark", "updateContainsMarkNow", "updateNode", "updateNodeOfGroup", "updateParentNode", "updateToTableMaps", "verifyDataAnchors", "verifyDataAnchors$runtime_release", "verifyParentAnchors", "verifyParentAnchors$runtime_release", "auxIndex", "address", "dataIndexes", "groupAsString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nodeIndex", "slotIndex", "updateDataIndex", "Companion", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSlotTable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlotTable.kt\nandroidx/compose/runtime/SlotWriter\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 IntObjectMap.kt\nandroidx/collection/MutableIntObjectMap\n+ 5 Preconditions.kt\nandroidx/compose/runtime/PreconditionsKt\n+ 6 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 7 ObjectList.kt\nandroidx/collection/ObjectList\n+ 8 SlotTable.kt\nandroidx/compose/runtime/SlotTable\n+ 9 SlotTable.kt\nandroidx/compose/runtime/SlotTableKt\n+ 10 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n*L\n1#1,4179:1\n4553#2,7:4180\n4553#2,7:4190\n4553#2,7:4197\n4553#2,7:4204\n4553#2,7:4211\n4553#2,7:4232\n4553#2,7:4239\n4553#2,7:4246\n4553#2,7:4260\n4553#2,7:4274\n4553#2,7:4281\n4553#2,7:4294\n4553#2,7:4301\n4553#2,7:4308\n4553#2,7:4315\n4553#2,7:4322\n4553#2,7:4329\n4553#2,7:4336\n4553#2,7:4343\n4553#2,7:4374\n4553#2,7:4381\n4553#2,7:4388\n1#3:4187\n1#3:4189\n1#3:4355\n1#3:4364\n729#4:4188\n50#5,7:4218\n50#5,7:4253\n50#5,7:4267\n50#5,7:4401\n50#5,7:4408\n50#5,7:4415\n50#5,7:4422\n50#5,7:4429\n50#5,7:4436\n361#6,7:4225\n305#7,6:4288\n175#8,5:4350\n181#8,3:4356\n175#8,5:4359\n181#8,3:4365\n4046#9,6:4368\n33#10,6:4395\n82#10,3:4443\n33#10,4:4446\n85#10,2:4450\n38#10:4452\n87#10:4453\n231#10,3:4454\n64#10,4:4457\n234#10,2:4461\n69#10:4463\n236#10:4464\n*S KotlinDebug\n*F\n+ 1 SlotTable.kt\nandroidx/compose/runtime/SlotWriter\n*L\n1639#1:4180,7\n1675#1:4190,7\n1711#1:4197,7\n1724#1:4204,7\n1727#1:4211,7\n1816#1:4232,7\n1837#1:4239,7\n1923#1:4246,7\n1928#1:4260,7\n1968#1:4274,7\n1979#1:4281,7\n2143#1:4294,7\n2207#1:4301,7\n2212#1:4308,7\n2244#1:4315,7\n2316#1:4322,7\n2317#1:4329,7\n2330#1:4336,7\n2425#1:4343,7\n2990#1:4374,7\n3002#1:4381,7\n3212#1:4388,7\n1658#1:4189\n2734#1:4355\n2775#1:4364\n1658#1:4188\n1737#1:4218,7\n1924#1:4253,7\n1966#1:4267,7\n3404#1:4401,7\n3408#1:4408,7\n3412#1:4415,7\n3428#1:4422,7\n3436#1:4429,7\n3440#1:4436,7\n1779#1:4225,7\n2129#1:4288,6\n2734#1:4350,5\n2734#1:4356,3\n2775#1:4359,5\n2775#1:4365,3\n2795#1:4368,6\n3313#1:4395,6\n3484#1:4443,3\n3484#1:4446,4\n3484#1:4450,2\n3484#1:4452\n3484#1:4453\n3487#1:4454,3\n3487#1:4457,4\n3487#1:4461,2\n3487#1:4463\n3487#1:4464\n*E\n"})
public final class SlotWriter {

    @NotNull
    private ArrayList<Anchor> anchors;

    @Nullable
    private MutableIntObjectMap<MutableIntSet> calledByMap;
    private boolean closed;
    private int currentGroup;
    private int currentGroupEnd;
    private int currentSlot;
    private int currentSlotEnd;

    @Nullable
    private MutableIntObjectMap<MutableObjectList<Object>> deferredSlotWrites;
    private int groupGapLen;
    private int groupGapStart;

    @NotNull
    private int[] groups;
    private int insertCount;
    private int nodeCount;

    @Nullable
    private PrioritySet pendingRecalculateMarks;

    @NotNull
    private Object[] slots;
    private int slotsGapLen;
    private int slotsGapOwner;
    private int slotsGapStart;

    @Nullable
    private HashMap<Anchor, GroupSourceInformation> sourceInformationMap;

    @NotNull
    private final SlotTable table;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private final IntStack startStack = new IntStack();

    @NotNull
    private final IntStack endStack = new IntStack();

    @NotNull
    private final IntStack nodeCountStack = new IntStack();
    private int parent = -1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0002¨\u0006\u000f"}, m13886d2 = {"Landroidx/compose/runtime/SlotWriter$Companion;", "", "()V", "moveGroup", "", "Landroidx/compose/runtime/Anchor;", "fromWriter", "Landroidx/compose/runtime/SlotWriter;", "fromIndex", "", "toWriter", "updateFromCursor", "", "updateToCursor", "removeSourceGroup", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSlotTable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlotTable.kt\nandroidx/compose/runtime/SlotWriter$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n+ 4 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,4179:1\n1#2:4180\n33#3,6:4181\n4553#4,7:4187\n*S KotlinDebug\n*F\n+ 1 SlotTable.kt\nandroidx/compose/runtime/SlotWriter$Companion\n*L\n2555#1:4181,6\n2611#1:4187,7\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<Anchor> moveGroup(SlotWriter fromWriter, int fromIndex, SlotWriter toWriter, boolean updateFromCursor, boolean updateToCursor, boolean removeSourceGroup) {
            boolean zRemoveGroups;
            List<Anchor> listEmptyList;
            int i;
            int iGroupSize = fromWriter.groupSize(fromIndex);
            int i2 = fromIndex + iGroupSize;
            int iDataIndex = fromWriter.dataIndex(fromIndex);
            int iDataIndex2 = fromWriter.dataIndex(i2);
            int i4 = iDataIndex2 - iDataIndex;
            boolean zContainsAnyGroupMarks = fromWriter.containsAnyGroupMarks(fromIndex);
            toWriter.insertGroups(iGroupSize);
            toWriter.insertSlots(i4, toWriter.getCurrentGroup());
            if (fromWriter.groupGapStart < i2) {
                fromWriter.moveGroupGapTo(i2);
            }
            if (fromWriter.slotsGapStart < iDataIndex2) {
                fromWriter.moveSlotGapTo(iDataIndex2, i2);
            }
            int[] iArr = toWriter.groups;
            int currentGroup = toWriter.getCurrentGroup();
            ArraysKt___ArraysJvmKt.copyInto(fromWriter.groups, iArr, currentGroup * 5, fromIndex * 5, i2 * 5);
            Object[] objArr = toWriter.slots;
            int i5 = toWriter.currentSlot;
            ArraysKt.copyInto(fromWriter.slots, objArr, i5, iDataIndex, iDataIndex2);
            int parent = toWriter.getParent();
            SlotTableKt.updateParentAnchor(iArr, currentGroup, parent);
            int i6 = currentGroup - fromIndex;
            int i7 = currentGroup + iGroupSize;
            int iDataIndex3 = i5 - toWriter.dataIndex(iArr, currentGroup);
            int i8 = toWriter.slotsGapOwner;
            int i9 = toWriter.slotsGapLen;
            int length = objArr.length;
            int i10 = i8;
            int i11 = currentGroup;
            while (true) {
                zRemoveGroups = false;
                if (i11 >= i7) {
                    break;
                }
                if (i11 != currentGroup) {
                    i = iDataIndex3;
                    SlotTableKt.updateParentAnchor(iArr, i11, SlotTableKt.parentAnchor(iArr, i11) + i6);
                } else {
                    i = iDataIndex3;
                }
                int i12 = i7;
                SlotTableKt.updateDataAnchor(iArr, i11, toWriter.dataIndexToDataAnchor(toWriter.dataIndex(iArr, i11) + i, i10 >= i11 ? toWriter.slotsGapStart : 0, i9, length));
                if (i11 == i10) {
                    i10++;
                }
                i11++;
                i7 = i12;
                iDataIndex3 = i;
            }
            int i13 = i7;
            toWriter.slotsGapOwner = i10;
            int iLocationOf = SlotTableKt.locationOf(fromWriter.anchors, fromIndex, fromWriter.getSize$runtime_release());
            int iLocationOf2 = SlotTableKt.locationOf(fromWriter.anchors, i2, fromWriter.getSize$runtime_release());
            if (iLocationOf < iLocationOf2) {
                ArrayList arrayList = fromWriter.anchors;
                ArrayList arrayList2 = new ArrayList(iLocationOf2 - iLocationOf);
                for (int i14 = iLocationOf; i14 < iLocationOf2; i14++) {
                    Anchor anchor = (Anchor) arrayList.get(i14);
                    anchor.setLocation$runtime_release(anchor.getLocation() + i6);
                    arrayList2.add(anchor);
                }
                toWriter.anchors.addAll(SlotTableKt.locationOf(toWriter.anchors, toWriter.getCurrentGroup(), toWriter.getSize$runtime_release()), arrayList2);
                arrayList.subList(iLocationOf, iLocationOf2).clear();
                listEmptyList = arrayList2;
            } else {
                listEmptyList = CollectionsKt.emptyList();
            }
            if (!listEmptyList.isEmpty()) {
                HashMap map = fromWriter.sourceInformationMap;
                HashMap map2 = toWriter.sourceInformationMap;
                if (map != null && map2 != null) {
                    int size = listEmptyList.size();
                    for (int i15 = 0; i15 < size; i15++) {
                        Anchor anchor2 = listEmptyList.get(i15);
                        GroupSourceInformation groupSourceInformation = (GroupSourceInformation) map.get(anchor2);
                        if (groupSourceInformation != null) {
                            map.remove(anchor2);
                            map2.put(anchor2, groupSourceInformation);
                        }
                    }
                }
            }
            int parent2 = toWriter.getParent();
            GroupSourceInformation groupSourceInformationSourceInformationOf = toWriter.sourceInformationOf(parent);
            if (groupSourceInformationSourceInformationOf != null) {
                int iGroupSize2 = parent2 + 1;
                int currentGroup2 = toWriter.getCurrentGroup();
                int i16 = -1;
                while (iGroupSize2 < currentGroup2) {
                    i16 = iGroupSize2;
                    iGroupSize2 = SlotTableKt.groupSize(toWriter.groups, iGroupSize2) + iGroupSize2;
                }
                groupSourceInformationSourceInformationOf.addGroupAfter(toWriter, i16, currentGroup2);
            }
            int iParent = fromWriter.parent(fromIndex);
            if (removeSourceGroup) {
                if (updateFromCursor) {
                    boolean z = iParent >= 0;
                    if (z) {
                        fromWriter.startGroup();
                        fromWriter.advanceBy(iParent - fromWriter.getCurrentGroup());
                        fromWriter.startGroup();
                    }
                    fromWriter.advanceBy(fromIndex - fromWriter.getCurrentGroup());
                    boolean zRemoveGroup = fromWriter.removeGroup();
                    if (z) {
                        fromWriter.skipToGroupEnd();
                        fromWriter.endGroup();
                        fromWriter.skipToGroupEnd();
                        fromWriter.endGroup();
                    }
                    zRemoveGroups = zRemoveGroup;
                } else {
                    zRemoveGroups = fromWriter.removeGroups(fromIndex, iGroupSize);
                    fromWriter.removeSlots(iDataIndex, i4, fromIndex - 1);
                }
            }
            if (zRemoveGroups) {
                ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
            }
            toWriter.nodeCount += SlotTableKt.isNode(iArr, currentGroup) ? 1 : SlotTableKt.nodeCount(iArr, currentGroup);
            if (updateToCursor) {
                toWriter.currentGroup = i13;
                toWriter.currentSlot = i5 + i4;
            }
            if (zContainsAnyGroupMarks) {
                toWriter.updateContainsMark(parent);
            }
            return listEmptyList;
        }

        public static /* synthetic */ List moveGroup$default(Companion companion, SlotWriter slotWriter, int i, SlotWriter slotWriter2, boolean z, boolean z2, boolean z3, int i2, Object obj) {
            if ((i2 & 32) != 0) {
                z3 = true;
            }
            return companion.moveGroup(slotWriter, i, slotWriter2, z, z2, z3);
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.SlotWriter$groupSlots$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001f\n\u0000\n\u0002\u0010(\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, m13886d2 = {"androidx/compose/runtime/SlotWriter$groupSlots$1", "", "", "current", "", "getCurrent", "()I", "setCurrent", "(I)V", "hasNext", "", "next", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class C19631 implements Iterator<Object>, KMappedMarker {
        final /* synthetic */ int $end;
        private int current;
        final /* synthetic */ SlotWriter this$0;

        public C19631(int i, int i2, SlotWriter slotWriter) {
            this.$end = i2;
            this.this$0 = slotWriter;
            this.current = i;
        }

        public final int getCurrent() {
            return this.current;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.current < this.$end;
        }

        @Override // java.util.Iterator
        @Nullable
        public Object next() {
            if (!hasNext()) {
                return null;
            }
            Object[] objArr = this.this$0.slots;
            SlotWriter slotWriter = this.this$0;
            int i = this.current;
            this.current = i + 1;
            return objArr[slotWriter.dataIndexToDataAddress(i)];
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setCurrent(int i) {
            this.current = i;
        }
    }

    public SlotWriter(@NotNull SlotTable slotTable) {
        this.table = slotTable;
        this.groups = slotTable.getGroups();
        this.slots = slotTable.getSlots();
        this.anchors = slotTable.getAnchors$runtime_release();
        this.sourceInformationMap = slotTable.getSourceInformationMap$runtime_release();
        this.calledByMap = slotTable.getCalledByMap$runtime_release();
        this.groupGapStart = slotTable.getGroupsSize();
        this.groupGapLen = (this.groups.length / 5) - slotTable.getGroupsSize();
        this.slotsGapStart = slotTable.getSlotsSize();
        this.slotsGapLen = this.slots.length - slotTable.getSlotsSize();
        this.slotsGapOwner = slotTable.getGroupsSize();
        this.currentGroupEnd = slotTable.getGroupsSize();
    }

    public static /* synthetic */ Anchor anchor$default(SlotWriter slotWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = slotWriter.currentGroup;
        }
        return slotWriter.anchor(i);
    }

    private final int auxIndex(int[] iArr, int i) {
        return SlotTableKt.countOneBits(SlotTableKt.groupInfo(iArr, i) >> 29) + dataIndex(iArr, i);
    }

    private final boolean childContainsAnyMarks(int group) {
        int iGroupSize = group + 1;
        int iGroupSize2 = groupSize(group) + group;
        while (iGroupSize < iGroupSize2) {
            if (SlotTableKt.containsAnyMark(this.groups, groupIndexToAddress(iGroupSize))) {
                return true;
            }
            iGroupSize += groupSize(iGroupSize);
        }
        return false;
    }

    private final void clearSlotGap() {
        int i = this.slotsGapStart;
        ArraysKt___ArraysJvmKt.fill(this.slots, (Object) null, i, this.slotsGapLen + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean containsAnyGroupMarks(int group) {
        return group >= 0 && SlotTableKt.containsAnyMark(this.groups, groupIndexToAddress(group));
    }

    private final boolean containsGroupMark(int group) {
        return group >= 0 && SlotTableKt.containsMark(this.groups, groupIndexToAddress(group));
    }

    private final int dataAnchorToDataIndex(int anchor, int gapLen, int capacity) {
        return anchor < 0 ? (capacity - gapLen) + anchor + 1 : anchor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndex(int index) {
        return dataIndex(this.groups, groupIndexToAddress(index));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndexToDataAddress(int dataIndex) {
        return dataIndex < this.slotsGapStart ? dataIndex : dataIndex + this.slotsGapLen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndexToDataAnchor(int index, int gapStart, int gapLen, int capacity) {
        return index > gapStart ? -(((capacity - gapLen) - index) + 1) : index;
    }

    private final List<Integer> dataIndexes(int[] iArr) {
        List listDataAnchors$default = SlotTableKt.dataAnchors$default(this.groups, 0, 1, null);
        List listPlus = CollectionsKt.plus((Collection) CollectionsKt.slice(listDataAnchors$default, RangesKt.until(0, this.groupGapStart)), (Iterable) CollectionsKt.slice(listDataAnchors$default, RangesKt.until(this.groupGapStart + this.groupGapLen, iArr.length / 5)));
        ArrayList arrayList = new ArrayList(listPlus.size());
        int size = listPlus.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(Integer.valueOf(dataAnchorToDataIndex(((Number) listPlus.get(i)).intValue(), this.slotsGapLen, this.slots.length)));
        }
        return arrayList;
    }

    private final void fixParentAnchorsFor(int parent, int endGroup, int firstChild) {
        int iParentIndexToAnchor = parentIndexToAnchor(parent, this.groupGapStart);
        while (firstChild < endGroup) {
            SlotTableKt.updateParentAnchor(this.groups, groupIndexToAddress(firstChild), iParentIndexToAnchor);
            int iGroupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress(firstChild)) + firstChild;
            fixParentAnchorsFor(firstChild, iGroupSize, firstChild + 1);
            firstChild = iGroupSize;
        }
    }

    private final int getCapacity() {
        return this.groups.length / 5;
    }

    private final int getCurrentGroupSlotIndex() {
        MutableObjectList<Object> mutableObjectList;
        int iSlotsStartIndex$runtime_release = this.currentSlot - slotsStartIndex$runtime_release(this.parent);
        MutableIntObjectMap<MutableObjectList<Object>> mutableIntObjectMap = this.deferredSlotWrites;
        return iSlotsStartIndex$runtime_release + ((mutableIntObjectMap == null || (mutableObjectList = mutableIntObjectMap.get(this.parent)) == null) ? 0 : mutableObjectList.getSize());
    }

    private final void groupAsString(StringBuilder sb, int i) {
        int iGroupIndexToAddress = groupIndexToAddress(i);
        sb.append("Group(");
        if (i < 10) {
            sb.append(' ');
        }
        if (i < 100) {
            sb.append(' ');
        }
        if (i < 1000) {
            sb.append(' ');
        }
        sb.append(i);
        if (iGroupIndexToAddress != i) {
            AbstractC1974b.m1330w(iGroupIndexToAddress, "(", ")", sb);
        }
        sb.append('#');
        sb.append(SlotTableKt.groupSize(this.groups, iGroupIndexToAddress));
        sb.append('^');
        sb.append(parentAnchorToIndex(SlotTableKt.parentAnchor(this.groups, iGroupIndexToAddress)));
        sb.append(": key=");
        sb.append(SlotTableKt.key(this.groups, iGroupIndexToAddress));
        sb.append(", nodes=");
        sb.append(SlotTableKt.nodeCount(this.groups, iGroupIndexToAddress));
        sb.append(", dataAnchor=");
        sb.append(SlotTableKt.dataAnchor(this.groups, iGroupIndexToAddress));
        sb.append(", parentAnchor=");
        sb.append(SlotTableKt.parentAnchor(this.groups, iGroupIndexToAddress));
        if (SlotTableKt.isNode(this.groups, iGroupIndexToAddress)) {
            sb.append(", node=" + SlotTableKt.summarize(String.valueOf(this.slots[dataIndexToDataAddress(nodeIndex(this.groups, iGroupIndexToAddress))]), 10));
        }
        int iSlotIndex = slotIndex(this.groups, iGroupIndexToAddress);
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(i + 1));
        if (iDataIndex > iSlotIndex) {
            sb.append(", [");
            for (int i2 = iSlotIndex; i2 < iDataIndex; i2++) {
                if (i2 != iSlotIndex) {
                    sb.append(SQLKeyword.COMMA);
                }
                sb.append(String.valueOf(SlotTableKt.summarize(String.valueOf(this.slots[dataIndexToDataAddress(i2)]), 10)));
            }
            sb.append(PropertyUtils.INDEXED_DELIM2);
        }
        sb.append(")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int groupIndexToAddress(int index) {
        return index < this.groupGapStart ? index : index + this.groupGapLen;
    }

    private final GroupSourceInformation groupSourceInformationFor(int parent, String sourceInformation) {
        HashMap<Anchor, GroupSourceInformation> map = this.sourceInformationMap;
        if (map == null) {
            return null;
        }
        Anchor anchor = anchor(parent);
        GroupSourceInformation groupSourceInformation = map.get(anchor);
        if (groupSourceInformation == null) {
            groupSourceInformation = new GroupSourceInformation(0, sourceInformation, 0);
            if (sourceInformation == null) {
                int iGroupSize = parent + 1;
                int i = this.currentGroup;
                while (iGroupSize < i) {
                    groupSourceInformation.reportGroup(this, iGroupSize);
                    iGroupSize += SlotTableKt.groupSize(this.groups, iGroupSize);
                }
            }
            map.put(anchor, groupSourceInformation);
        }
        return groupSourceInformation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertGroups(int size) {
        if (size > 0) {
            int i = this.currentGroup;
            moveGroupGapTo(i);
            int i2 = this.groupGapStart;
            int i4 = this.groupGapLen;
            int[] iArr = this.groups;
            int length = iArr.length / 5;
            int i5 = length - i4;
            if (i4 < size) {
                int iMax = Math.max(Math.max(length * 2, i5 + size), 32);
                int[] iArr2 = new int[iMax * 5];
                int i6 = iMax - i5;
                ArraysKt___ArraysJvmKt.copyInto(iArr, iArr2, 0, 0, i2 * 5);
                ArraysKt___ArraysJvmKt.copyInto(iArr, iArr2, (i2 + i6) * 5, (i4 + i2) * 5, length * 5);
                this.groups = iArr2;
                i4 = i6;
            }
            int i7 = this.currentGroupEnd;
            if (i7 >= i2) {
                this.currentGroupEnd = i7 + size;
            }
            int i8 = i2 + size;
            this.groupGapStart = i8;
            this.groupGapLen = i4 - size;
            int iDataIndexToDataAnchor = dataIndexToDataAnchor(i5 > 0 ? dataIndex(i + size) : 0, this.slotsGapOwner >= i2 ? this.slotsGapStart : 0, this.slotsGapLen, this.slots.length);
            for (int i9 = i2; i9 < i8; i9++) {
                SlotTableKt.updateDataAnchor(this.groups, i9, iDataIndexToDataAnchor);
            }
            int i10 = this.slotsGapOwner;
            if (i10 >= i2) {
                this.slotsGapOwner = i10 + size;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertSlots(int size, int group) {
        if (size > 0) {
            moveSlotGapTo(this.currentSlot, group);
            int i = this.slotsGapStart;
            int i2 = this.slotsGapLen;
            if (i2 < size) {
                Object[] objArr = this.slots;
                int length = objArr.length;
                int i4 = length - i2;
                int iMax = Math.max(Math.max(length * 2, i4 + size), 32);
                Object[] objArr2 = new Object[iMax];
                for (int i5 = 0; i5 < iMax; i5++) {
                    objArr2[i5] = null;
                }
                int i6 = iMax - i4;
                ArraysKt.copyInto(objArr, objArr2, 0, 0, i);
                ArraysKt.copyInto(objArr, objArr2, i + i6, i2 + i, length);
                this.slots = objArr2;
                i2 = i6;
            }
            int i7 = this.currentSlotEnd;
            if (i7 >= i) {
                this.currentSlotEnd = i7 + size;
            }
            this.slotsGapStart = i + size;
            this.slotsGapLen = i2 - size;
        }
    }

    private final List<Integer> keys() {
        List listKeys$default = SlotTableKt.keys$default(this.groups, 0, 1, null);
        ArrayList arrayList = new ArrayList(listKeys$default.size());
        int size = listKeys$default.size();
        for (int i = 0; i < size; i++) {
            Object obj = listKeys$default.get(i);
            ((Number) obj).intValue();
            int i2 = this.groupGapStart;
            if (i < i2 || i >= i2 + this.groupGapLen) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void markGroup$default(SlotWriter slotWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = slotWriter.parent;
        }
        slotWriter.markGroup(i);
    }

    private final void moveAnchors(int originalLocation, int newLocation, int size) {
        Anchor anchor;
        int iAnchorIndex;
        int i = size + originalLocation;
        int size$runtime_release = getSize$runtime_release();
        int iLocationOf = SlotTableKt.locationOf(this.anchors, originalLocation, size$runtime_release);
        ArrayList arrayList = new ArrayList();
        if (iLocationOf >= 0) {
            while (iLocationOf < this.anchors.size() && (iAnchorIndex = anchorIndex((anchor = this.anchors.get(iLocationOf)))) >= originalLocation && iAnchorIndex < i) {
                arrayList.add(anchor);
                this.anchors.remove(iLocationOf);
            }
        }
        int i2 = newLocation - originalLocation;
        int size2 = arrayList.size();
        for (int i4 = 0; i4 < size2; i4++) {
            Anchor anchor2 = (Anchor) arrayList.get(i4);
            int iAnchorIndex2 = anchorIndex(anchor2) + i2;
            if (iAnchorIndex2 >= this.groupGapStart) {
                anchor2.setLocation$runtime_release(-(size$runtime_release - iAnchorIndex2));
            } else {
                anchor2.setLocation$runtime_release(iAnchorIndex2);
            }
            this.anchors.add(SlotTableKt.locationOf(this.anchors, iAnchorIndex2, size$runtime_release), anchor2);
        }
    }

    public static /* synthetic */ List moveFrom$default(SlotWriter slotWriter, SlotTable slotTable, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        return slotWriter.moveFrom(slotTable, i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveGroupGapTo(int index) {
        int i = this.groupGapLen;
        int i2 = this.groupGapStart;
        if (i2 != index) {
            if (!this.anchors.isEmpty()) {
                updateAnchors(i2, index);
            }
            if (i > 0) {
                int[] iArr = this.groups;
                int i4 = index * 5;
                int i5 = i * 5;
                int i6 = i2 * 5;
                if (index < i2) {
                    ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, i5 + i4, i4, i6);
                } else {
                    ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, i6, i6 + i5, i4 + i5);
                }
            }
            if (index < i2) {
                i2 = index + i;
            }
            int capacity = getCapacity();
            ComposerKt.runtimeCheck(i2 < capacity);
            while (i2 < capacity) {
                int iParentAnchor = SlotTableKt.parentAnchor(this.groups, i2);
                int iParentIndexToAnchor = parentIndexToAnchor(parentAnchorToIndex(iParentAnchor), index);
                if (iParentIndexToAnchor != iParentAnchor) {
                    SlotTableKt.updateParentAnchor(this.groups, i2, iParentIndexToAnchor);
                }
                i2++;
                if (i2 == index) {
                    i2 += i;
                }
            }
        }
        this.groupGapStart = index;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveSlotGapTo(int index, int group) {
        int i = this.slotsGapLen;
        int i2 = this.slotsGapStart;
        int i4 = this.slotsGapOwner;
        if (i2 != index) {
            Object[] objArr = this.slots;
            if (index < i2) {
                ArraysKt.copyInto(objArr, objArr, index + i, index, i2);
            } else {
                ArraysKt.copyInto(objArr, objArr, i2, i2 + i, index + i);
            }
        }
        int iMin = Math.min(group + 1, getSize$runtime_release());
        if (i4 != iMin) {
            int length = this.slots.length - i;
            if (iMin < i4) {
                int iGroupIndexToAddress = groupIndexToAddress(iMin);
                int iGroupIndexToAddress2 = groupIndexToAddress(i4);
                int i5 = this.groupGapStart;
                while (iGroupIndexToAddress < iGroupIndexToAddress2) {
                    int iDataAnchor = SlotTableKt.dataAnchor(this.groups, iGroupIndexToAddress);
                    if (!(iDataAnchor >= 0)) {
                        ComposerKt.composeImmediateRuntimeError("Unexpected anchor value, expected a positive anchor");
                    }
                    SlotTableKt.updateDataAnchor(this.groups, iGroupIndexToAddress, -((length - iDataAnchor) + 1));
                    iGroupIndexToAddress++;
                    if (iGroupIndexToAddress == i5) {
                        iGroupIndexToAddress += this.groupGapLen;
                    }
                }
            } else {
                int iGroupIndexToAddress3 = groupIndexToAddress(i4);
                int iGroupIndexToAddress4 = groupIndexToAddress(iMin);
                while (iGroupIndexToAddress3 < iGroupIndexToAddress4) {
                    int iDataAnchor2 = SlotTableKt.dataAnchor(this.groups, iGroupIndexToAddress3);
                    if (!(iDataAnchor2 < 0)) {
                        ComposerKt.composeImmediateRuntimeError("Unexpected anchor value, expected a negative anchor");
                    }
                    SlotTableKt.updateDataAnchor(this.groups, iGroupIndexToAddress3, iDataAnchor2 + length + 1);
                    iGroupIndexToAddress3++;
                    if (iGroupIndexToAddress3 == this.groupGapStart) {
                        iGroupIndexToAddress3 += this.groupGapLen;
                    }
                }
            }
            this.slotsGapOwner = iMin;
        }
        this.slotsGapStart = index;
    }

    private final int nodeIndex(int[] iArr, int i) {
        return dataIndex(iArr, i);
    }

    private final int parentAnchorToIndex(int index) {
        return index > -2 ? index : (getSize$runtime_release() + index) - (-2);
    }

    private final int parentIndexToAnchor(int index, int gapStart) {
        return index < gapStart ? index : -((getSize$runtime_release() - index) + 2);
    }

    private final Object rawUpdate(Object value) {
        Object objSkip = skip();
        set(value);
        return objSkip;
    }

    private final void recalculateMarks() {
        PrioritySet prioritySet = this.pendingRecalculateMarks;
        if (prioritySet != null) {
            while (prioritySet.isNotEmpty()) {
                updateContainsMarkNow(prioritySet.takeMax(), prioritySet);
            }
        }
    }

    private final boolean removeAnchors(int gapStart, int size, HashMap<Anchor, GroupSourceInformation> sourceInformationMap) {
        int i = size + gapStart;
        int iLocationOf = SlotTableKt.locationOf(this.anchors, i, getCapacity() - this.groupGapLen);
        if (iLocationOf >= this.anchors.size()) {
            iLocationOf--;
        }
        int i2 = iLocationOf + 1;
        int i4 = 0;
        while (iLocationOf >= 0) {
            Anchor anchor = this.anchors.get(iLocationOf);
            int iAnchorIndex = anchorIndex(anchor);
            if (iAnchorIndex < gapStart) {
                break;
            }
            if (iAnchorIndex < i) {
                anchor.setLocation$runtime_release(Integer.MIN_VALUE);
                if (sourceInformationMap != null) {
                    sourceInformationMap.remove(anchor);
                }
                if (i4 == 0) {
                    i4 = iLocationOf + 1;
                }
                i2 = iLocationOf;
            }
            iLocationOf--;
        }
        boolean z = i2 < i4;
        if (z) {
            this.anchors.subList(i2, i4).clear();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean removeGroups(int start, int len) {
        if (len > 0) {
            ArrayList<Anchor> arrayList = this.anchors;
            moveGroupGapTo(start);
            zRemoveAnchors = arrayList.isEmpty() ? false : removeAnchors(start, len, this.sourceInformationMap);
            this.groupGapStart = start;
            this.groupGapLen += len;
            int i = this.slotsGapOwner;
            if (i > start) {
                this.slotsGapOwner = Math.max(start, i - len);
            }
            int i2 = this.currentGroupEnd;
            if (i2 >= this.groupGapStart) {
                this.currentGroupEnd = i2 - len;
            }
            int i4 = this.parent;
            if (containsGroupMark(i4)) {
                updateContainsMark(i4);
            }
        }
        return zRemoveAnchors;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeSlots(int start, int len, int group) {
        if (len > 0) {
            int i = this.slotsGapLen;
            int i2 = start + len;
            moveSlotGapTo(i2, group);
            this.slotsGapStart = start;
            this.slotsGapLen = i + len;
            ArraysKt___ArraysJvmKt.fill(this.slots, (Object) null, start, i2);
            int i4 = this.currentSlotEnd;
            if (i4 >= start) {
                this.currentSlotEnd = i4 - len;
            }
        }
    }

    private final int restoreCurrentGroupEnd() {
        int capacity = (getCapacity() - this.groupGapLen) - this.endStack.pop();
        this.currentGroupEnd = capacity;
        return capacity;
    }

    private final void saveCurrentGroupEnd() {
        this.endStack.push((getCapacity() - this.groupGapLen) - this.currentGroupEnd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int slotIndex(int[] iArr, int i) {
        return i >= getCapacity() ? this.slots.length - this.slotsGapLen : dataAnchorToDataIndex(SlotTableKt.slotAnchor(iArr, i), this.slotsGapLen, this.slots.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GroupSourceInformation sourceInformationOf(int group) {
        Anchor anchorTryAnchor$runtime_release;
        HashMap<Anchor, GroupSourceInformation> map = this.sourceInformationMap;
        if (map == null || (anchorTryAnchor$runtime_release = tryAnchor$runtime_release(group)) == null) {
            return null;
        }
        return map.get(anchorTryAnchor$runtime_release);
    }

    private final void updateAnchors(int previousGapStart, int newGapStart) {
        Anchor anchor;
        int location$runtime_release;
        Anchor anchor2;
        int location$runtime_release2;
        int i;
        int capacity = getCapacity() - this.groupGapLen;
        if (previousGapStart >= newGapStart) {
            for (int iLocationOf = SlotTableKt.locationOf(this.anchors, newGapStart, capacity); iLocationOf < this.anchors.size() && (location$runtime_release = (anchor = this.anchors.get(iLocationOf)).getLocation()) >= 0; iLocationOf++) {
                anchor.setLocation$runtime_release(-(capacity - location$runtime_release));
            }
            return;
        }
        for (int iLocationOf2 = SlotTableKt.locationOf(this.anchors, previousGapStart, capacity); iLocationOf2 < this.anchors.size() && (location$runtime_release2 = (anchor2 = this.anchors.get(iLocationOf2)).getLocation()) < 0 && (i = location$runtime_release2 + capacity) < newGapStart; iLocationOf2++) {
            anchor2.setLocation$runtime_release(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void updateContainsMark(int group) {
        if (group >= 0) {
            PrioritySet prioritySet = this.pendingRecalculateMarks;
            if (prioritySet == null) {
                prioritySet = new PrioritySet(null, 1, 0 == true ? 1 : 0);
                this.pendingRecalculateMarks = prioritySet;
            }
            prioritySet.add(group);
        }
    }

    private final void updateContainsMarkNow(int group, PrioritySet set) {
        int iGroupIndexToAddress = groupIndexToAddress(group);
        boolean zChildContainsAnyMarks = childContainsAnyMarks(group);
        if (SlotTableKt.containsMark(this.groups, iGroupIndexToAddress) != zChildContainsAnyMarks) {
            SlotTableKt.updateContainsMark(this.groups, iGroupIndexToAddress, zChildContainsAnyMarks);
            int iParent = parent(group);
            if (iParent >= 0) {
                set.add(iParent);
            }
        }
    }

    private final void updateDataIndex(int[] iArr, int i, int i2) {
        SlotTableKt.updateDataAnchor(iArr, i, dataIndexToDataAnchor(i2, this.slotsGapStart, this.slotsGapLen, this.slots.length));
    }

    private final void updateNodeOfGroup(int index, Object value) {
        int iGroupIndexToAddress = groupIndexToAddress(index);
        int[] iArr = this.groups;
        if (!(iGroupIndexToAddress < iArr.length && SlotTableKt.isNode(iArr, iGroupIndexToAddress))) {
            ComposerKt.composeImmediateRuntimeError("Updating the node of a group at " + index + " that was not created with as a node group");
        }
        this.slots[dataIndexToDataAddress(nodeIndex(this.groups, iGroupIndexToAddress))] = value;
    }

    public final void advanceBy(int amount) {
        boolean z = false;
        if (!(amount >= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot seek backwards");
        }
        if (!(this.insertCount <= 0)) {
            PreconditionsKt.throwIllegalStateException("Cannot call seek() while inserting");
        }
        if (amount == 0) {
            return;
        }
        int i = this.currentGroup + amount;
        if (i >= this.parent && i <= this.currentGroupEnd) {
            z = true;
        }
        if (!z) {
            ComposerKt.composeImmediateRuntimeError("Cannot seek outside the current group (" + this.parent + '-' + this.currentGroupEnd + PropertyUtils.MAPPED_DELIM2);
        }
        this.currentGroup = i;
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(i));
        this.currentSlot = iDataIndex;
        this.currentSlotEnd = iDataIndex;
    }

    @NotNull
    public final Anchor anchor(int index) {
        ArrayList<Anchor> arrayList = this.anchors;
        int iSearch = SlotTableKt.search(arrayList, index, getSize$runtime_release());
        if (iSearch >= 0) {
            return arrayList.get(iSearch);
        }
        if (index > this.groupGapStart) {
            index = -(getSize$runtime_release() - index);
        }
        Anchor anchor = new Anchor(index);
        arrayList.add(-(iSearch + 1), anchor);
        return anchor;
    }

    public final int anchorIndex(@NotNull Anchor anchor) {
        int location$runtime_release = anchor.getLocation();
        return location$runtime_release < 0 ? getSize$runtime_release() + location$runtime_release : location$runtime_release;
    }

    public final void appendSlot(@NotNull Anchor anchor, @Nullable Object value) {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Can only append a slot if not current inserting");
        }
        int i = this.currentSlot;
        int i2 = this.currentSlotEnd;
        int iAnchorIndex = anchorIndex(anchor);
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(iAnchorIndex + 1));
        this.currentSlot = iDataIndex;
        this.currentSlotEnd = iDataIndex;
        insertSlots(1, iAnchorIndex);
        if (i >= iDataIndex) {
            i++;
            i2++;
        }
        this.slots[iDataIndex] = value;
        this.currentSlot = i;
        this.currentSlotEnd = i2;
    }

    public final void bashCurrentGroup() {
        SlotTableKt.updateGroupKey(this.groups, this.currentGroup, -3);
    }

    public final void beginInsert() {
        int i = this.insertCount;
        this.insertCount = i + 1;
        if (i == 0) {
            saveCurrentGroupEnd();
        }
    }

    public final void close(boolean normalClose) {
        this.closed = true;
        if (normalClose && this.startStack.isEmpty()) {
            moveGroupGapTo(getSize$runtime_release());
            moveSlotGapTo(this.slots.length - this.slotsGapLen, this.groupGapStart);
            clearSlotGap();
            recalculateMarks();
        }
        this.table.close$runtime_release(this, this.groups, this.groupGapStart, this.slots, this.slotsGapStart, this.anchors, this.sourceInformationMap, this.calledByMap);
    }

    public final int endGroup() {
        MutableObjectList<Object> mutableObjectList;
        boolean z = this.insertCount > 0;
        int i = this.currentGroup;
        int i2 = this.currentGroupEnd;
        int i4 = this.parent;
        int iGroupIndexToAddress = groupIndexToAddress(i4);
        int i5 = this.nodeCount;
        int i6 = i - i4;
        boolean zIsNode = SlotTableKt.isNode(this.groups, iGroupIndexToAddress);
        if (z) {
            MutableIntObjectMap<MutableObjectList<Object>> mutableIntObjectMap = this.deferredSlotWrites;
            if (mutableIntObjectMap != null && (mutableObjectList = mutableIntObjectMap.get(i4)) != null) {
                Object[] objArr = mutableObjectList.content;
                int i7 = mutableObjectList._size;
                for (int i8 = 0; i8 < i7; i8++) {
                    rawUpdate(objArr[i8]);
                }
                mutableIntObjectMap.remove(i4);
            }
            SlotTableKt.updateGroupSize(this.groups, iGroupIndexToAddress, i6);
            SlotTableKt.updateNodeCount(this.groups, iGroupIndexToAddress, i5);
            this.nodeCount = this.nodeCountStack.pop() + (zIsNode ? 1 : i5);
            int iParent = parent(this.groups, i4);
            this.parent = iParent;
            int size$runtime_release = iParent < 0 ? getSize$runtime_release() : groupIndexToAddress(iParent + 1);
            int iDataIndex = size$runtime_release >= 0 ? dataIndex(this.groups, size$runtime_release) : 0;
            this.currentSlot = iDataIndex;
            this.currentSlotEnd = iDataIndex;
            return i5;
        }
        if (!(i == i2)) {
            ComposerKt.composeImmediateRuntimeError("Expected to be at the end of a group");
        }
        int iGroupSize = SlotTableKt.groupSize(this.groups, iGroupIndexToAddress);
        int iNodeCount = SlotTableKt.nodeCount(this.groups, iGroupIndexToAddress);
        SlotTableKt.updateGroupSize(this.groups, iGroupIndexToAddress, i6);
        SlotTableKt.updateNodeCount(this.groups, iGroupIndexToAddress, i5);
        int iPop = this.startStack.pop();
        restoreCurrentGroupEnd();
        this.parent = iPop;
        int iParent2 = parent(this.groups, i4);
        int iPop2 = this.nodeCountStack.pop();
        this.nodeCount = iPop2;
        if (iParent2 == iPop) {
            this.nodeCount = iPop2 + (zIsNode ? 0 : i5 - iNodeCount);
            return i5;
        }
        int i9 = i6 - iGroupSize;
        int i10 = zIsNode ? 0 : i5 - iNodeCount;
        if (i9 != 0 || i10 != 0) {
            while (iParent2 != 0 && iParent2 != iPop && (i10 != 0 || i9 != 0)) {
                int iGroupIndexToAddress2 = groupIndexToAddress(iParent2);
                if (i9 != 0) {
                    SlotTableKt.updateGroupSize(this.groups, iGroupIndexToAddress2, SlotTableKt.groupSize(this.groups, iGroupIndexToAddress2) + i9);
                }
                if (i10 != 0) {
                    int[] iArr = this.groups;
                    SlotTableKt.updateNodeCount(iArr, iGroupIndexToAddress2, SlotTableKt.nodeCount(iArr, iGroupIndexToAddress2) + i10);
                }
                if (SlotTableKt.isNode(this.groups, iGroupIndexToAddress2)) {
                    i10 = 0;
                }
                iParent2 = parent(this.groups, iParent2);
            }
        }
        this.nodeCount += i10;
        return i5;
    }

    public final void endInsert() {
        if (!(this.insertCount > 0)) {
            PreconditionsKt.throwIllegalStateException("Unbalanced begin/end insert");
        }
        int i = this.insertCount - 1;
        this.insertCount = i;
        if (i == 0) {
            if (!(this.nodeCountStack.getTos() == this.startStack.getTos())) {
                ComposerKt.composeImmediateRuntimeError("startGroup/endGroup mismatch while inserting");
            }
            restoreCurrentGroupEnd();
        }
    }

    public final void ensureStarted(int index) {
        boolean z = false;
        if (!(this.insertCount <= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot call ensureStarted() while inserting");
        }
        int i = this.parent;
        if (i != index) {
            if (index >= i && index < this.currentGroupEnd) {
                z = true;
            }
            if (!z) {
                ComposerKt.composeImmediateRuntimeError("Started group at " + index + " must be a subgroup of the group at " + i);
            }
            int i2 = this.currentGroup;
            int i4 = this.currentSlot;
            int i5 = this.currentSlotEnd;
            this.currentGroup = index;
            startGroup();
            this.currentGroup = i2;
            this.currentSlot = i4;
            this.currentSlotEnd = i5;
        }
    }

    public final void forAllData(int group, @NotNull Function2<? super Integer, Object, Unit> block) {
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(groupSize(getCurrentGroup()) + getCurrentGroup()));
        for (int iDataIndex2 = dataIndex(this.groups, groupIndexToAddress(group)); iDataIndex2 < iDataIndex; iDataIndex2++) {
            block.invoke(Integer.valueOf(iDataIndex2), this.slots[dataIndexToDataAddress(iDataIndex2)]);
        }
    }

    public final void forEachData(int group, @NotNull Function2<? super Integer, Object, Unit> block) {
        int iSlotIndex = slotIndex(this.groups, groupIndexToAddress(group));
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(group + 1));
        for (int i = iSlotIndex; i < iDataIndex; i++) {
            block.invoke(Integer.valueOf(i - iSlotIndex), this.slots[dataIndexToDataAddress(i)]);
        }
    }

    public final void forEachTailSlot(int groupIndex, int count, @NotNull Function2<? super Integer, Object, Unit> block) {
        int iSlotsStartIndex$runtime_release = slotsStartIndex$runtime_release(groupIndex);
        int iSlotsEndIndex$runtime_release = slotsEndIndex$runtime_release(groupIndex);
        for (int iMax = Math.max(iSlotsStartIndex$runtime_release, iSlotsEndIndex$runtime_release - count); iMax < iSlotsEndIndex$runtime_release; iMax++) {
            block.invoke(Integer.valueOf(iMax), this.slots[dataIndexToDataAddress(iMax)]);
        }
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final boolean getCollectingCalledInformation() {
        return this.calledByMap != null;
    }

    public final boolean getCollectingSourceInformation() {
        return this.sourceInformationMap != null;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    public final int getCurrentGroupEnd() {
        return this.currentGroupEnd;
    }

    public final int getParent() {
        return this.parent;
    }

    public final int getSize$runtime_release() {
        return getCapacity() - this.groupGapLen;
    }

    public final int getSlotsSize() {
        return this.slots.length - this.slotsGapLen;
    }

    @NotNull
    /* JADX INFO: renamed from: getTable$runtime_release, reason: from getter */
    public final SlotTable getTable() {
        return this.table;
    }

    @Nullable
    public final Object groupAux(int index) {
        int iGroupIndexToAddress = groupIndexToAddress(index);
        return SlotTableKt.hasAux(this.groups, iGroupIndexToAddress) ? this.slots[auxIndex(this.groups, iGroupIndexToAddress)] : Composer.INSTANCE.getEmpty();
    }

    public final int groupKey(int index) {
        return SlotTableKt.key(this.groups, groupIndexToAddress(index));
    }

    @Nullable
    public final Object groupObjectKey(int index) {
        int iGroupIndexToAddress = groupIndexToAddress(index);
        if (SlotTableKt.hasObjectKey(this.groups, iGroupIndexToAddress)) {
            return this.slots[SlotTableKt.objectKeyIndex(this.groups, iGroupIndexToAddress)];
        }
        return null;
    }

    public final int groupSize(int index) {
        return SlotTableKt.groupSize(this.groups, groupIndexToAddress(index));
    }

    @NotNull
    public final Iterator<Object> groupSlots() {
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(this.currentGroup));
        int[] iArr = this.groups;
        int i = this.currentGroup;
        return new C19631(iDataIndex, dataIndex(iArr, groupIndexToAddress(groupSize(i) + i)), this);
    }

    public final boolean indexInCurrentGroup(int index) {
        return indexInGroup(index, this.currentGroup);
    }

    public final boolean indexInGroup(int index, int group) {
        int iIndexOf;
        int capacity;
        if (group == this.parent) {
            capacity = this.currentGroupEnd;
        } else if (group <= this.startStack.peekOr(0) && (iIndexOf = this.startStack.indexOf(group)) >= 0) {
            capacity = (getCapacity() - this.groupGapLen) - this.endStack.peek(iIndexOf);
        } else {
            int iGroupSize = groupSize(group);
            capacity = iGroupSize + group;
        }
        return index > group && index < capacity;
    }

    public final boolean indexInParent(int index) {
        int i = this.parent;
        if (index <= i || index >= this.currentGroupEnd) {
            return i == 0 && index == 0;
        }
        return true;
    }

    public final void insertAux(@Nullable Object value) {
        if (!(this.insertCount >= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot insert auxiliary data when not inserting");
        }
        int i = this.parent;
        int iGroupIndexToAddress = groupIndexToAddress(i);
        if (SlotTableKt.hasAux(this.groups, iGroupIndexToAddress)) {
            ComposerKt.composeImmediateRuntimeError("Group already has auxiliary data");
        }
        insertSlots(1, i);
        int iAuxIndex = auxIndex(this.groups, iGroupIndexToAddress);
        int iDataIndexToDataAddress = dataIndexToDataAddress(iAuxIndex);
        int i2 = this.currentSlot;
        if (i2 > iAuxIndex) {
            int i4 = i2 - iAuxIndex;
            if (!(i4 < 3)) {
                PreconditionsKt.throwIllegalStateException("Moving more than two slot not supported");
            }
            if (i4 > 1) {
                Object[] objArr = this.slots;
                objArr[iDataIndexToDataAddress + 2] = objArr[iDataIndexToDataAddress + 1];
            }
            Object[] objArr2 = this.slots;
            objArr2[iDataIndexToDataAddress + 1] = objArr2[iDataIndexToDataAddress];
        }
        SlotTableKt.addAux(this.groups, iGroupIndexToAddress);
        this.slots[iDataIndexToDataAddress] = value;
        this.currentSlot++;
    }

    public final boolean isGroupEnd() {
        return this.currentGroup == this.currentGroupEnd;
    }

    public final boolean isNode() {
        int i = this.currentGroup;
        return i < this.currentGroupEnd && SlotTableKt.isNode(this.groups, groupIndexToAddress(i));
    }

    public final void markGroup(int group) {
        int iGroupIndexToAddress = groupIndexToAddress(group);
        if (SlotTableKt.hasMark(this.groups, iGroupIndexToAddress)) {
            return;
        }
        SlotTableKt.updateMark(this.groups, iGroupIndexToAddress, true);
        if (SlotTableKt.containsMark(this.groups, iGroupIndexToAddress)) {
            return;
        }
        updateContainsMark(parent(group));
    }

    @NotNull
    public final List<Anchor> moveFrom(@NotNull SlotTable table, int index, boolean removeSourceGroup) {
        ComposerKt.runtimeCheck(this.insertCount > 0);
        if (index != 0 || this.currentGroup != 0 || this.table.getGroupsSize() != 0 || SlotTableKt.groupSize(table.getGroups(), index) != table.getGroupsSize()) {
            SlotWriter slotWriterOpenWriter = table.openWriter();
            try {
                List<Anchor> listMoveGroup = INSTANCE.moveGroup(slotWriterOpenWriter, index, this, true, true, removeSourceGroup);
                slotWriterOpenWriter.close(true);
                return listMoveGroup;
            } catch (Throwable th) {
                slotWriterOpenWriter.close(false);
                throw th;
            }
        }
        int[] iArr = this.groups;
        Object[] objArr = this.slots;
        ArrayList<Anchor> arrayList = this.anchors;
        HashMap<Anchor, GroupSourceInformation> map = this.sourceInformationMap;
        MutableIntObjectMap<MutableIntSet> mutableIntObjectMap = this.calledByMap;
        int[] groups = table.getGroups();
        int groupsSize = table.getGroupsSize();
        Object[] slots = table.getSlots();
        int slotsSize = table.getSlotsSize();
        HashMap<Anchor, GroupSourceInformation> sourceInformationMap$runtime_release = table.getSourceInformationMap$runtime_release();
        MutableIntObjectMap<MutableIntSet> calledByMap$runtime_release = table.getCalledByMap$runtime_release();
        this.groups = groups;
        this.slots = slots;
        this.anchors = table.getAnchors$runtime_release();
        this.groupGapStart = groupsSize;
        this.groupGapLen = (groups.length / 5) - groupsSize;
        this.slotsGapStart = slotsSize;
        this.slotsGapLen = slots.length - slotsSize;
        this.slotsGapOwner = groupsSize;
        this.sourceInformationMap = sourceInformationMap$runtime_release;
        this.calledByMap = calledByMap$runtime_release;
        table.setTo$runtime_release(iArr, 0, objArr, 0, arrayList, map, mutableIntObjectMap);
        return this.anchors;
    }

    public final void moveGroup(int offset) {
        if (this.insertCount != 0) {
            ComposerKt.composeImmediateRuntimeError("Cannot move a group while inserting");
        }
        if (offset < 0) {
            ComposerKt.composeImmediateRuntimeError("Parameter offset is out of bounds");
        }
        if (offset == 0) {
            return;
        }
        int i = this.currentGroup;
        int i2 = this.parent;
        int i4 = this.currentGroupEnd;
        int iGroupSize = i;
        for (int i5 = offset; i5 > 0; i5--) {
            iGroupSize += SlotTableKt.groupSize(this.groups, groupIndexToAddress(iGroupSize));
            if (iGroupSize > i4) {
                ComposerKt.composeImmediateRuntimeError("Parameter offset is out of bounds");
            }
        }
        int iGroupSize2 = SlotTableKt.groupSize(this.groups, groupIndexToAddress(iGroupSize));
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(this.currentGroup));
        int iDataIndex2 = dataIndex(this.groups, groupIndexToAddress(iGroupSize));
        int i6 = iGroupSize + iGroupSize2;
        int iDataIndex3 = dataIndex(this.groups, groupIndexToAddress(i6));
        int i7 = iDataIndex3 - iDataIndex2;
        insertSlots(i7, Math.max(this.currentGroup - 1, 0));
        insertGroups(iGroupSize2);
        int[] iArr = this.groups;
        int iGroupIndexToAddress = groupIndexToAddress(i6) * 5;
        ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, groupIndexToAddress(i) * 5, iGroupIndexToAddress, (iGroupSize2 * 5) + iGroupIndexToAddress);
        if (i7 > 0) {
            Object[] objArr = this.slots;
            ArraysKt.copyInto(objArr, objArr, iDataIndex, dataIndexToDataAddress(iDataIndex2 + i7), dataIndexToDataAddress(iDataIndex3 + i7));
        }
        int i8 = iDataIndex2 + i7;
        int i9 = i8 - iDataIndex;
        int i10 = this.slotsGapStart;
        int i11 = this.slotsGapLen;
        int length = this.slots.length;
        int i12 = this.slotsGapOwner;
        int i13 = i + iGroupSize2;
        int i14 = i;
        while (i14 < i13) {
            int iGroupIndexToAddress2 = groupIndexToAddress(i14);
            int i15 = i9;
            int iDataIndex4 = dataIndex(iArr, iGroupIndexToAddress2) - i15;
            int i16 = i10;
            if (i12 < iGroupIndexToAddress2) {
                i10 = 0;
            }
            updateDataIndex(iArr, iGroupIndexToAddress2, dataIndexToDataAnchor(iDataIndex4, i10, i11, length));
            i14++;
            i10 = i16;
            i9 = i15;
        }
        moveAnchors(i6, i, iGroupSize2);
        if (removeGroups(i6, iGroupSize2)) {
            ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
        }
        fixParentAnchorsFor(i2, this.currentGroupEnd, i);
        if (i7 > 0) {
            removeSlots(i8, i7, i6 - 1);
        }
    }

    @NotNull
    public final List<Anchor> moveIntoGroupFrom(int offset, @NotNull SlotTable table, int index) {
        ComposerKt.runtimeCheck(this.insertCount <= 0 && groupSize(this.currentGroup + offset) == 1);
        int i = this.currentGroup;
        int i2 = this.currentSlot;
        int i4 = this.currentSlotEnd;
        advanceBy(offset);
        startGroup();
        beginInsert();
        SlotWriter slotWriterOpenWriter = table.openWriter();
        try {
            List<Anchor> listMoveGroup$default = Companion.moveGroup$default(INSTANCE, slotWriterOpenWriter, index, this, false, true, false, 32, null);
            slotWriterOpenWriter.close(true);
            endInsert();
            endGroup();
            this.currentGroup = i;
            this.currentSlot = i2;
            this.currentSlotEnd = i4;
            return listMoveGroup$default;
        } catch (Throwable th) {
            slotWriterOpenWriter.close(false);
            throw th;
        }
    }

    @NotNull
    public final List<Anchor> moveTo(@NotNull Anchor anchor, int offset, @NotNull SlotWriter writer) {
        ComposerKt.runtimeCheck(writer.insertCount > 0);
        ComposerKt.runtimeCheck(this.insertCount == 0);
        ComposerKt.runtimeCheck(anchor.getValid());
        int iAnchorIndex = anchorIndex(anchor) + offset;
        int i = this.currentGroup;
        ComposerKt.runtimeCheck(i <= iAnchorIndex && iAnchorIndex < this.currentGroupEnd);
        int iParent = parent(iAnchorIndex);
        int iGroupSize = groupSize(iAnchorIndex);
        int iNodeCount = isNode(iAnchorIndex) ? 1 : nodeCount(iAnchorIndex);
        List<Anchor> listMoveGroup$default = Companion.moveGroup$default(INSTANCE, this, iAnchorIndex, writer, false, false, false, 32, null);
        updateContainsMark(iParent);
        boolean z = iNodeCount > 0;
        while (iParent >= i) {
            int iGroupIndexToAddress = groupIndexToAddress(iParent);
            int[] iArr = this.groups;
            SlotTableKt.updateGroupSize(iArr, iGroupIndexToAddress, SlotTableKt.groupSize(iArr, iGroupIndexToAddress) - iGroupSize);
            if (z) {
                if (SlotTableKt.isNode(this.groups, iGroupIndexToAddress)) {
                    z = false;
                } else {
                    int[] iArr2 = this.groups;
                    SlotTableKt.updateNodeCount(iArr2, iGroupIndexToAddress, SlotTableKt.nodeCount(iArr2, iGroupIndexToAddress) - iNodeCount);
                }
            }
            iParent = parent(iParent);
        }
        if (z) {
            ComposerKt.runtimeCheck(this.nodeCount >= iNodeCount);
            this.nodeCount -= iNodeCount;
        }
        return listMoveGroup$default;
    }

    @Nullable
    public final Object node(int index) {
        int iGroupIndexToAddress = groupIndexToAddress(index);
        if (SlotTableKt.isNode(this.groups, iGroupIndexToAddress)) {
            return this.slots[dataIndexToDataAddress(nodeIndex(this.groups, iGroupIndexToAddress))];
        }
        return null;
    }

    public final int nodeCount(int index) {
        return SlotTableKt.nodeCount(this.groups, groupIndexToAddress(index));
    }

    public final int parent(int index) {
        return parent(this.groups, index);
    }

    public final void recordGroupSourceInformation(@NotNull String sourceInformation) {
        if (this.insertCount > 0) {
            groupSourceInformationFor(this.parent, sourceInformation);
        }
    }

    public final void recordGrouplessCallSourceInformationEnd() {
        GroupSourceInformation groupSourceInformationGroupSourceInformationFor;
        if (this.insertCount <= 0 || (groupSourceInformationGroupSourceInformationFor = groupSourceInformationFor(this.parent, null)) == null) {
            return;
        }
        groupSourceInformationGroupSourceInformationFor.endGrouplessCall(getCurrentGroupSlotIndex());
    }

    public final void recordGrouplessCallSourceInformationStart(int key, @NotNull String value) {
        if (this.insertCount > 0) {
            MutableIntObjectMap<MutableIntSet> mutableIntObjectMap = this.calledByMap;
            if (mutableIntObjectMap != null) {
                SlotTableKt.add(mutableIntObjectMap, key, groupKey(this.parent));
            }
            GroupSourceInformation groupSourceInformationGroupSourceInformationFor = groupSourceInformationFor(this.parent, null);
            if (groupSourceInformationGroupSourceInformationFor != null) {
                groupSourceInformationGroupSourceInformationFor.startGrouplessCall(key, value, getCurrentGroupSlotIndex());
            }
        }
    }

    public final boolean removeGroup() {
        Anchor anchorTryAnchor$runtime_release;
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot remove group while inserting");
        }
        int i = this.currentGroup;
        int i2 = this.currentSlot;
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(i));
        int iSkipGroup = skipGroup();
        GroupSourceInformation groupSourceInformationSourceInformationOf = sourceInformationOf(this.parent);
        if (groupSourceInformationSourceInformationOf != null && (anchorTryAnchor$runtime_release = tryAnchor$runtime_release(i)) != null) {
            groupSourceInformationSourceInformationOf.removeAnchor(anchorTryAnchor$runtime_release);
        }
        PrioritySet prioritySet = this.pendingRecalculateMarks;
        if (prioritySet != null) {
            while (prioritySet.isNotEmpty() && prioritySet.peek() >= i) {
                prioritySet.takeMax();
            }
        }
        boolean zRemoveGroups = removeGroups(i, this.currentGroup - i);
        removeSlots(iDataIndex, this.currentSlot - iDataIndex, i - 1);
        this.currentGroup = i;
        this.currentSlot = i2;
        this.nodeCount -= iSkipGroup;
        return zRemoveGroups;
    }

    public final void reset() {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot reset when inserting");
        }
        recalculateMarks();
        this.currentGroup = 0;
        this.currentGroupEnd = getCapacity() - this.groupGapLen;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
        this.nodeCount = 0;
    }

    public final void seek(@NotNull Anchor anchor) {
        advanceBy(anchor.toIndexFor(this) - this.currentGroup);
    }

    public final void set(@Nullable Object value) {
        if (!(this.currentSlot <= this.currentSlotEnd)) {
            ComposerKt.composeImmediateRuntimeError("Writing to an invalid slot");
        }
        this.slots[dataIndexToDataAddress(this.currentSlot - 1)] = value;
    }

    @Nullable
    public final Object skip() {
        if (this.insertCount > 0) {
            insertSlots(1, this.parent);
        }
        Object[] objArr = this.slots;
        int i = this.currentSlot;
        this.currentSlot = i + 1;
        return objArr[dataIndexToDataAddress(i)];
    }

    public final int skipGroup() {
        int iGroupIndexToAddress = groupIndexToAddress(this.currentGroup);
        int iGroupSize = SlotTableKt.groupSize(this.groups, iGroupIndexToAddress) + this.currentGroup;
        this.currentGroup = iGroupSize;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(iGroupSize));
        if (SlotTableKt.isNode(this.groups, iGroupIndexToAddress)) {
            return 1;
        }
        return SlotTableKt.nodeCount(this.groups, iGroupIndexToAddress);
    }

    public final void skipToGroupEnd() {
        int i = this.currentGroupEnd;
        this.currentGroup = i;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(i));
    }

    @Nullable
    public final Object slot(@NotNull Anchor anchor, int index) {
        return slot(anchorIndex(anchor), index);
    }

    public final int slotIndexOfGroupSlotIndex(int group, int index) {
        int iSlotIndex = slotIndex(this.groups, groupIndexToAddress(group));
        int i = iSlotIndex + index;
        if (!(i >= iSlotIndex && i < dataIndex(this.groups, groupIndexToAddress(group + 1)))) {
            ComposerKt.composeImmediateRuntimeError("Write to an invalid slot index " + index + " for group " + group);
        }
        return i;
    }

    public final int slotsEndAllIndex$runtime_release(int groupIndex) {
        return dataIndex(this.groups, groupIndexToAddress(groupSize(groupIndex) + groupIndex));
    }

    public final int slotsEndIndex$runtime_release(int groupIndex) {
        return dataIndex(this.groups, groupIndexToAddress(groupIndex + 1));
    }

    public final int slotsStartIndex$runtime_release(int groupIndex) {
        return slotIndex(this.groups, groupIndexToAddress(groupIndex));
    }

    public final void startData(int key, @Nullable Object objectKey, @Nullable Object aux) {
        startGroup(key, objectKey, false, aux);
    }

    public final void startGroup() {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Key must be supplied when inserting");
        }
        Composer.Companion companion = Composer.INSTANCE;
        startGroup(0, companion.getEmpty(), false, companion.getEmpty());
    }

    public final void startNode(int key, @Nullable Object objectKey) {
        startGroup(key, objectKey, true, Composer.INSTANCE.getEmpty());
    }

    @NotNull
    public final String toDebugString() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString());
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        sb.append("  parent:    " + this.parent);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        sb.append("  current:   " + this.currentGroup);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        sb.append("  group gap: " + this.groupGapStart + '-' + (this.groupGapStart + this.groupGapLen) + PropertyUtils.MAPPED_DELIM + this.groupGapLen + PropertyUtils.MAPPED_DELIM2);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        sb.append("  slots gap: " + this.slotsGapStart + '-' + (this.slotsGapStart + this.slotsGapLen) + PropertyUtils.MAPPED_DELIM + this.slotsGapLen + PropertyUtils.MAPPED_DELIM2);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        StringBuilder sb2 = new StringBuilder("  gap owner: ");
        sb2.append(this.slotsGapOwner);
        sb.append(sb2.toString());
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        int size$runtime_release = getSize$runtime_release();
        for (int i = 0; i < size$runtime_release; i++) {
            groupAsString(sb, i);
            sb.append('\n');
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @NotNull
    public String toString() {
        return "SlotWriter(current = " + this.currentGroup + " end=" + this.currentGroupEnd + " size = " + getSize$runtime_release() + " gap=" + this.groupGapStart + '-' + (this.groupGapStart + this.groupGapLen) + PropertyUtils.MAPPED_DELIM2;
    }

    public final void trimTailSlots(int count) {
        ComposerKt.runtimeCheck(count > 0);
        int i = this.parent;
        int iSlotIndex = slotIndex(this.groups, groupIndexToAddress(i));
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(i + 1)) - count;
        ComposerKt.runtimeCheck(iDataIndex >= iSlotIndex);
        removeSlots(iDataIndex, count, i);
        int i2 = this.currentSlot;
        if (i2 >= iSlotIndex) {
            this.currentSlot = i2 - count;
        }
    }

    @Nullable
    public final Anchor tryAnchor$runtime_release(int group) {
        if (group < 0 || group >= getSize$runtime_release()) {
            return null;
        }
        return SlotTableKt.find(this.anchors, group, getSize$runtime_release());
    }

    @Nullable
    public final Object update(@Nullable Object value) {
        if (this.insertCount <= 0 || this.currentSlot == this.slotsGapStart) {
            return rawUpdate(value);
        }
        MutableIntObjectMap<MutableObjectList<Object>> mutableIntObjectMap = this.deferredSlotWrites;
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i = 1;
        int i2 = 0;
        if (mutableIntObjectMap == null) {
            mutableIntObjectMap = new MutableIntObjectMap<>(i2, i, defaultConstructorMarker);
        }
        this.deferredSlotWrites = mutableIntObjectMap;
        int i4 = this.parent;
        MutableObjectList<Object> mutableObjectList = mutableIntObjectMap.get(i4);
        if (mutableObjectList == null) {
            mutableObjectList = new MutableObjectList<>(i2, i, defaultConstructorMarker);
            mutableIntObjectMap.set(i4, mutableObjectList);
        }
        mutableObjectList.add(value);
        return Composer.INSTANCE.getEmpty();
    }

    public final void updateAux(@Nullable Object value) {
        int iGroupIndexToAddress = groupIndexToAddress(this.currentGroup);
        if (!SlotTableKt.hasAux(this.groups, iGroupIndexToAddress)) {
            ComposerKt.composeImmediateRuntimeError("Updating the data of a group that was not created with a data slot");
        }
        this.slots[dataIndexToDataAddress(auxIndex(this.groups, iGroupIndexToAddress))] = value;
    }

    public final void updateNode(@Nullable Object value) {
        updateNodeOfGroup(this.currentGroup, value);
    }

    public final void updateParentNode(@Nullable Object value) {
        updateNodeOfGroup(this.parent, value);
    }

    public final void updateToTableMaps() {
        this.sourceInformationMap = this.table.getSourceInformationMap$runtime_release();
        this.calledByMap = this.table.getCalledByMap$runtime_release();
    }

    public final void verifyDataAnchors$runtime_release() {
        int i = this.slotsGapOwner;
        int length = this.slots.length - this.slotsGapLen;
        int size$runtime_release = getSize$runtime_release();
        int i2 = 0;
        int i4 = 0;
        boolean z = false;
        while (i2 < size$runtime_release) {
            int iGroupIndexToAddress = groupIndexToAddress(i2);
            int iDataAnchor = SlotTableKt.dataAnchor(this.groups, iGroupIndexToAddress);
            int iDataIndex = dataIndex(this.groups, iGroupIndexToAddress);
            if (!(iDataIndex >= i4)) {
                StringBuilder sbM1173s = AbstractC0622a.m1173s(i2, i4, "Data index out of order at ", ", previous = ", ", current = ");
                sbM1173s.append(iDataIndex);
                PreconditionsKt.throwIllegalStateException(sbM1173s.toString());
            }
            if (!(iDataIndex <= length)) {
                PreconditionsKt.throwIllegalStateException("Data index, " + iDataIndex + ", out of bound at " + i2);
            }
            if (iDataAnchor < 0 && !z) {
                if (!(i == i2)) {
                    PreconditionsKt.throwIllegalStateException("Expected the slot gap owner to be " + i + " found gap at " + i2);
                }
                z = true;
            }
            i2++;
            i4 = iDataIndex;
        }
    }

    public final void verifyParentAnchors$runtime_release() {
        int i = this.groupGapStart;
        int i2 = this.groupGapLen;
        int capacity = getCapacity();
        int i4 = 0;
        while (true) {
            if (i4 >= i) {
                break;
            }
            if (!(SlotTableKt.parentAnchor(this.groups, i4) > -2)) {
                PreconditionsKt.throwIllegalStateException("Expected a start relative anchor at " + i4);
            }
            i4++;
        }
        for (int i5 = i2 + i; i5 < capacity; i5++) {
            int iParentAnchor = SlotTableKt.parentAnchor(this.groups, i5);
            if (parentAnchorToIndex(iParentAnchor) < i) {
                if (!(iParentAnchor > -2)) {
                    PreconditionsKt.throwIllegalStateException("Expected a start relative anchor at " + i5);
                }
            } else if (!(iParentAnchor <= -2)) {
                PreconditionsKt.throwIllegalStateException("Expected an end relative anchor at " + i5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndex(int[] iArr, int i) {
        return i >= getCapacity() ? this.slots.length - this.slotsGapLen : dataAnchorToDataIndex(SlotTableKt.dataAnchor(iArr, i), this.slotsGapLen, this.slots.length);
    }

    public final boolean isNode(int index) {
        return SlotTableKt.isNode(this.groups, groupIndexToAddress(index));
    }

    public final int parent(@NotNull Anchor anchor) {
        if (anchor.getValid()) {
            return parent(this.groups, anchorIndex(anchor));
        }
        return -1;
    }

    @Nullable
    public final Object slot(int groupIndex, int index) {
        int iSlotIndex = slotIndex(this.groups, groupIndexToAddress(groupIndex));
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(groupIndex + 1));
        int i = index + iSlotIndex;
        if (iSlotIndex > i || i >= iDataIndex) {
            return Composer.INSTANCE.getEmpty();
        }
        return this.slots[dataIndexToDataAddress(i)];
    }

    public final void startData(int key, @Nullable Object aux) {
        startGroup(key, Composer.INSTANCE.getEmpty(), false, aux);
    }

    public final void startNode(int key, @Nullable Object objectKey, @Nullable Object node) {
        startGroup(key, objectKey, true, node);
    }

    public final void updateNode(@NotNull Anchor anchor, @Nullable Object value) {
        updateNodeOfGroup(anchor.toIndexFor(this), value);
    }

    private final int parent(int[] iArr, int i) {
        return parentAnchorToIndex(SlotTableKt.parentAnchor(iArr, groupIndexToAddress(i)));
    }

    @Nullable
    public final Object node(@NotNull Anchor anchor) {
        return node(anchor.toIndexFor(this));
    }

    public final void startGroup(int key) {
        Composer.Companion companion = Composer.INSTANCE;
        startGroup(key, companion.getEmpty(), false, companion.getEmpty());
    }

    @Nullable
    public final Object set(int index, @Nullable Object value) {
        return set(this.currentGroup, index, value);
    }

    public final void startGroup(int key, @Nullable Object dataKey) {
        startGroup(key, dataKey, false, Composer.INSTANCE.getEmpty());
    }

    @Nullable
    public final Object set(int group, int index, @Nullable Object value) {
        int iDataIndexToDataAddress = dataIndexToDataAddress(slotIndexOfGroupSlotIndex(group, index));
        Object[] objArr = this.slots;
        Object obj = objArr[iDataIndexToDataAddress];
        objArr[iDataIndexToDataAddress] = value;
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v2 */
    private final void startGroup(int key, Object objectKey, boolean isNode, Object aux) {
        int iGroupSize;
        GroupSourceInformation groupSourceInformationSourceInformationOf;
        int i = this.parent;
        Object[] objArr = this.insertCount > 0;
        this.nodeCountStack.push(this.nodeCount);
        if (objArr != false) {
            int i2 = this.currentGroup;
            int iDataIndex = dataIndex(this.groups, groupIndexToAddress(i2));
            insertGroups(1);
            this.currentSlot = iDataIndex;
            this.currentSlotEnd = iDataIndex;
            int iGroupIndexToAddress = groupIndexToAddress(i2);
            Composer.Companion companion = Composer.INSTANCE;
            ?? r12 = objectKey != companion.getEmpty() ? 1 : 0;
            ?? r13 = (isNode || aux == companion.getEmpty()) ? 0 : 1;
            int iDataIndexToDataAnchor = dataIndexToDataAnchor(iDataIndex, this.slotsGapStart, this.slotsGapLen, this.slots.length);
            if (iDataIndexToDataAnchor >= 0 && this.slotsGapOwner < i2) {
                iDataIndexToDataAnchor = -(((this.slots.length - this.slotsGapLen) - iDataIndexToDataAnchor) + 1);
            }
            SlotTableKt.initGroup(this.groups, iGroupIndexToAddress, key, isNode, r12, r13, this.parent, iDataIndexToDataAnchor);
            int i4 = (isNode ? 1 : 0) + r12 + r13;
            if (i4 > 0) {
                insertSlots(i4, i2);
                Object[] objArr2 = this.slots;
                int i5 = this.currentSlot;
                if (isNode) {
                    objArr2[i5] = aux;
                    i5++;
                }
                if (r12 != 0) {
                    objArr2[i5] = objectKey;
                    i5++;
                }
                if (r13 != 0) {
                    objArr2[i5] = aux;
                    i5++;
                }
                this.currentSlot = i5;
            }
            this.nodeCount = 0;
            iGroupSize = i2 + 1;
            this.parent = i2;
            this.currentGroup = iGroupSize;
            if (i >= 0 && (groupSourceInformationSourceInformationOf = sourceInformationOf(i)) != null) {
                groupSourceInformationSourceInformationOf.reportGroup(this, i2);
            }
        } else {
            this.startStack.push(i);
            saveCurrentGroupEnd();
            int i6 = this.currentGroup;
            int iGroupIndexToAddress2 = groupIndexToAddress(i6);
            if (!Intrinsics.areEqual(aux, Composer.INSTANCE.getEmpty())) {
                if (isNode) {
                    updateNode(aux);
                } else {
                    updateAux(aux);
                }
            }
            this.currentSlot = slotIndex(this.groups, iGroupIndexToAddress2);
            this.currentSlotEnd = dataIndex(this.groups, groupIndexToAddress(this.currentGroup + 1));
            this.nodeCount = SlotTableKt.nodeCount(this.groups, iGroupIndexToAddress2);
            this.parent = i6;
            this.currentGroup = i6 + 1;
            iGroupSize = i6 + SlotTableKt.groupSize(this.groups, iGroupIndexToAddress2);
        }
        this.currentGroupEnd = iGroupSize;
    }

    public final void ensureStarted(@NotNull Anchor anchor) {
        ensureStarted(anchor.toIndexFor(this));
    }
}
