package androidx.compose.runtime;

import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.GroupKind;
import androidx.compose.runtime.changelist.ChangeList;
import androidx.compose.runtime.changelist.ComposerChangeListWriter;
import androidx.compose.runtime.changelist.FixupList;
import androidx.compose.runtime.collection.IntMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.ListUtilsKt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.messaging.Constants;
import com.samsung.android.support.senl.p148nt.app.sync.cloudsettings.callee.NotesSyncRpcProvider;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000ñ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b**\u0001A\b\u0000\u0018\u00002\u00020\u0001:\u0004Ø\u0002Ù\u0002BG\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\n\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0002J\n\u0010\u008f\u0001\u001a\u00030\u008e\u0001H\u0002JM\u0010\u0090\u0001\u001a\u00030\u008e\u0001\"\u0005\b\u0000\u0010\u0091\u0001\"\u0005\b\u0001\u0010\u0092\u00012\b\u0010\u0093\u0001\u001a\u0003H\u0091\u00012#\u0010\u0094\u0001\u001a\u001e\u0012\u0005\u0012\u0003H\u0092\u0001\u0012\u0005\u0012\u0003H\u0091\u0001\u0012\u0005\u0012\u00030\u008e\u00010\u0095\u0001¢\u0006\u0003\b\u0096\u0001H\u0016¢\u0006\u0003\u0010\u0097\u0001J\t\u0010\u0098\u0001\u001a\u00020\u0005H\u0016J2\u0010\u0099\u0001\u001a\u0003H\u0092\u0001\"\u0005\b\u0000\u0010\u0092\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u00182\u000f\u0010\u0094\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0092\u00010\u009b\u0001H\u0087\b¢\u0006\u0003\u0010\u009c\u0001J\u0014\u0010\u009d\u0001\u001a\u00020\u00182\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010~H\u0017J\u0012\u0010\u009d\u0001\u001a\u00020\u00182\u0007\u0010\u0093\u0001\u001a\u00020\u0018H\u0017J\u0013\u0010\u009d\u0001\u001a\u00020\u00182\b\u0010\u0093\u0001\u001a\u00030\u009e\u0001H\u0017J\u0013\u0010\u009d\u0001\u001a\u00020\u00182\b\u0010\u0093\u0001\u001a\u00030\u009f\u0001H\u0017J\u0013\u0010\u009d\u0001\u001a\u00020\u00182\b\u0010\u0093\u0001\u001a\u00030 \u0001H\u0017J\u0013\u0010\u009d\u0001\u001a\u00020\u00182\b\u0010\u0093\u0001\u001a\u00030¡\u0001H\u0017J\u0012\u0010\u009d\u0001\u001a\u00020\u00182\u0007\u0010\u0093\u0001\u001a\u00020\u001cH\u0017J\u0013\u0010\u009d\u0001\u001a\u00020\u00182\b\u0010\u0093\u0001\u001a\u00030¢\u0001H\u0017J\u0013\u0010\u009d\u0001\u001a\u00020\u00182\b\u0010\u0093\u0001\u001a\u00030£\u0001H\u0017J\u0014\u0010¤\u0001\u001a\u00020\u00182\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010~H\u0017J\u0010\u0010¥\u0001\u001a\u00030\u008e\u0001H\u0000¢\u0006\u0003\b¦\u0001J\n\u0010§\u0001\u001a\u00030\u008e\u0001H\u0002J\n\u0010¨\u0001\u001a\u00030\u008e\u0001H\u0002J\n\u0010©\u0001\u001a\u00030\u008e\u0001H\u0016J@\u0010ª\u0001\u001a\u00030\u008e\u00012\u0014\u0010«\u0001\u001a\u000f\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020~0¬\u00012\u0015\u0010\u00ad\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u008e\u00010\u009b\u0001¢\u0006\u0003\b®\u0001H\u0000¢\u0006\u0006\b¯\u0001\u0010°\u0001J,\u0010±\u0001\u001a\u00020\u001c2\u0007\u0010²\u0001\u001a\u00020\u001c2\u0006\u0010r\u001a\u00020\u001c2\u0007\u0010³\u0001\u001a\u00020\u001c2\u0007\u0010´\u0001\u001a\u00020\u001cH\u0002J(\u0010µ\u0001\u001a\u0003H\u0092\u0001\"\u0005\b\u0000\u0010\u0092\u00012\u000f\u0010¶\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0092\u00010·\u0001H\u0017¢\u0006\u0003\u0010¸\u0001J\n\u0010¹\u0001\u001a\u00030\u008e\u0001H\u0002J\"\u0010º\u0001\u001a\u00030\u008e\u0001\"\u0005\b\u0000\u0010\u0092\u00012\u000f\u0010»\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0092\u00010\u009b\u0001H\u0016J\t\u0010¼\u0001\u001a\u00020hH\u0002J\u0012\u0010¼\u0001\u001a\u00020h2\u0007\u0010²\u0001\u001a\u00020\u001cH\u0002J\u0010\u0010½\u0001\u001a\u00030\u008e\u0001H\u0000¢\u0006\u0003\b¾\u0001J\u0013\u0010¿\u0001\u001a\u00030\u008e\u00012\u0007\u0010\u009d\u0001\u001a\u00020\u0018H\u0017J\n\u0010À\u0001\u001a\u00030\u008e\u0001H\u0016J\n\u0010Á\u0001\u001a\u00030\u008e\u0001H\u0016J\u0010\u0010Â\u0001\u001a\u00030\u008e\u0001H\u0000¢\u0006\u0003\bÃ\u0001J?\u0010Ä\u0001\u001a\u00030\u008e\u00012\u0014\u0010«\u0001\u001a\u000f\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020~0¬\u00012\u0017\u0010\u00ad\u0001\u001a\u0012\u0012\u0005\u0012\u00030\u008e\u0001\u0018\u00010\u009b\u0001¢\u0006\u0003\b®\u0001H\u0002¢\u0006\u0003\u0010°\u0001J\u001c\u0010Å\u0001\u001a\u00030\u008e\u00012\u0007\u0010²\u0001\u001a\u00020\u001c2\u0007\u0010Æ\u0001\u001a\u00020\u001cH\u0002J\n\u0010Ç\u0001\u001a\u00030\u008e\u0001H\u0016J\u0013\u0010È\u0001\u001a\u00030\u008e\u00012\u0007\u0010É\u0001\u001a\u00020\u0018H\u0002J\n\u0010Ê\u0001\u001a\u00030\u008e\u0001H\u0017J\n\u0010Ë\u0001\u001a\u00030\u008e\u0001H\u0002J\n\u0010Ì\u0001\u001a\u00030\u008e\u0001H\u0017J\n\u0010Í\u0001\u001a\u00030\u008e\u0001H\u0016J\n\u0010Î\u0001\u001a\u00030\u008e\u0001H\u0017J\n\u0010Ï\u0001\u001a\u00030\u008e\u0001H\u0017J\n\u0010Ð\u0001\u001a\u00030\u008e\u0001H\u0017J\n\u0010Ñ\u0001\u001a\u00030\u008e\u0001H\u0017J\f\u0010Ò\u0001\u001a\u0005\u0018\u00010Ó\u0001H\u0017J\n\u0010Ô\u0001\u001a\u00030\u008e\u0001H\u0016J\b\u0010Õ\u0001\u001a\u00030\u008e\u0001J\n\u0010Ö\u0001\u001a\u00030\u008e\u0001H\u0002J\u0013\u0010×\u0001\u001a\u00030\u008e\u00012\u0007\u0010Ø\u0001\u001a\u00020\u001cH\u0016J\n\u0010Ù\u0001\u001a\u00030\u008e\u0001H\u0002J\u001e\u0010Ú\u0001\u001a\u00030\u008e\u00012\u0007\u0010É\u0001\u001a\u00020\u00182\t\u0010Û\u0001\u001a\u0004\u0018\u00010kH\u0002J\u001b\u0010Ü\u0001\u001a\u00030\u008e\u00012\u0007\u0010Ý\u0001\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020\u0018H\u0002J\n\u0010Þ\u0001\u001a\u00030\u008e\u0001H\u0002J\n\u0010ß\u0001\u001a\u00030\u008e\u0001H\u0002J\u000e\u0010E\u001a\u00020\u0018H\u0000¢\u0006\u0003\bà\u0001J#\u0010á\u0001\u001a\u00030\u008e\u00012\f\u0010\u0093\u0001\u001a\u0007\u0012\u0002\b\u00030â\u00012\t\u0010ã\u0001\u001a\u0004\u0018\u00010~H\u0017J+\u0010ä\u0001\u001a\u00030\u008e\u00012\u001f\u0010å\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030è\u0001\u0012\u0007\u0012\u0005\u0018\u00010è\u00010ç\u00010æ\u0001H\u0002J+\u0010é\u0001\u001a\u00030\u008e\u00012\u001f\u0010å\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030è\u0001\u0012\u0007\u0012\u0005\u0018\u00010è\u00010ç\u00010æ\u0001H\u0017J\u0012\u0010ê\u0001\u001a\u00020\u001c2\u0007\u0010ë\u0001\u001a\u00020\u001cH\u0002J9\u0010ì\u0001\u001a\u00030\u008e\u00012\u0010\u0010\u00ad\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010~0â\u00012\u0007\u0010í\u0001\u001a\u00020h2\t\u0010ã\u0001\u001a\u0004\u0018\u00010~2\u0007\u0010î\u0001\u001a\u00020\u0018H\u0002J\u001f\u0010ï\u0001\u001a\u00020~2\t\u0010ð\u0001\u001a\u0004\u0018\u00010~2\t\u0010ñ\u0001\u001a\u0004\u0018\u00010~H\u0017J\u000b\u0010ò\u0001\u001a\u0004\u0018\u00010~H\u0001J\u000b\u0010ó\u0001\u001a\u0004\u0018\u00010~H\u0001J-\u0010ô\u0001\u001a\u00020\u001c2\u0007\u0010õ\u0001\u001a\u00020\u001c2\u0007\u0010²\u0001\u001a\u00020\u001c2\u0007\u0010³\u0001\u001a\u00020\u001c2\u0007\u0010ö\u0001\u001a\u00020\u001cH\u0002J\u000f\u0010÷\u0001\u001a\u00020\u001cH\u0001¢\u0006\u0003\bø\u0001J!\u0010ù\u0001\u001a\u00030\u008e\u00012\u000f\u0010\u0094\u0001\u001a\n\u0012\u0005\u0012\u00030\u008e\u00010\u009b\u0001H\u0000¢\u0006\u0003\bú\u0001J\u0012\u0010û\u0001\u001a\u00020\u001c2\u0007\u0010²\u0001\u001a\u00020\u001cH\u0002J%\u0010ü\u0001\u001a\u00020\u00182\u0014\u0010«\u0001\u001a\u000f\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020~0¬\u0001H\u0000¢\u0006\u0003\bý\u0001Jo\u0010þ\u0001\u001a\u0003Hÿ\u0001\"\u0005\b\u0000\u0010ÿ\u00012\u000b\b\u0002\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u000f2\u000b\b\u0002\u0010\u0081\u0002\u001a\u0004\u0018\u00010\u000f2\u000b\b\u0002\u0010ë\u0001\u001a\u0004\u0018\u00010\u001c2\u001e\b\u0002\u0010Z\u001a\u0018\u0012\u0013\u0012\u0011\u0012\u0004\u0012\u000205\u0012\u0006\u0012\u0004\u0018\u00010~0ç\u00010æ\u00012\u000f\u0010\u0094\u0001\u001a\n\u0012\u0005\u0012\u0003Hÿ\u00010\u009b\u0001H\u0002¢\u0006\u0003\u0010\u0082\u0002J\n\u0010\u0083\u0002\u001a\u00030\u008e\u0001H\u0002J\n\u0010\u0084\u0002\u001a\u00030\u008e\u0001H\u0002J\u0013\u0010\u0085\u0002\u001a\u00030\u008e\u00012\u0007\u0010\u0086\u0002\u001a\u00020MH\u0002J\u0013\u0010\u0087\u0002\u001a\u00030\u008e\u00012\u0007\u0010\u0088\u0002\u001a\u00020hH\u0002J\u001b\u0010\u0089\u0002\u001a\u00030\u008e\u00012\u000f\u0010\u008a\u0002\u001a\n\u0012\u0005\u0012\u00030\u008e\u00010\u009b\u0001H\u0016J%\u0010\u008b\u0002\u001a\u00030\u008e\u00012\u0007\u0010\u008c\u0002\u001a\u00020\u001c2\u0007\u0010\u008d\u0002\u001a\u00020\u001c2\u0007\u0010\u008e\u0002\u001a\u00020\u001cH\u0002J\u0013\u0010\u008f\u0002\u001a\u00030\u008e\u00012\u0007\u0010\u0090\u0002\u001a\u00020zH\u0016J\u000b\u0010\u0091\u0002\u001a\u0004\u0018\u00010MH\u0002J\u000b\u0010\u0092\u0002\u001a\u0004\u0018\u00010~H\u0016J\n\u0010\u0093\u0002\u001a\u00030\u008e\u0001H\u0002J\u0013\u0010\u0094\u0002\u001a\u00030\u008e\u00012\u0007\u0010\u0095\u0002\u001a\u00020\u001cH\u0002J\n\u0010\u0096\u0002\u001a\u00030\u008e\u0001H\u0017J\n\u0010\u0097\u0002\u001a\u00030\u008e\u0001H\u0002J\n\u0010\u0098\u0002\u001a\u00030\u008e\u0001H\u0002J\n\u0010\u0099\u0002\u001a\u00030\u008e\u0001H\u0017J\u0014\u0010\u009a\u0002\u001a\u00030\u008e\u00012\b\u0010\u009a\u0002\u001a\u00030\u009b\u0002H\u0017J\n\u0010\u009c\u0002\u001a\u00030\u008e\u0001H\u0017J\u001d\u0010\u009d\u0002\u001a\u00030\u008e\u00012\u0007\u0010¶\u0001\u001a\u00020\u001c2\b\u0010\u009a\u0002\u001a\u00030\u009b\u0002H\u0017J\u000f\u0010\u009e\u0002\u001a\u00020\u001cH\u0000¢\u0006\u0003\b\u009f\u0002J?\u0010 \u0002\u001a\u00030\u008e\u00012\u0007\u0010¶\u0001\u001a\u00020\u001c2\t\u0010¡\u0002\u001a\u0004\u0018\u00010~2\b\u0010¢\u0002\u001a\u00030£\u00022\t\u0010¤\u0002\u001a\u0004\u0018\u00010~H\u0002ø\u0001\u0000¢\u0006\u0006\b¥\u0002\u0010¦\u0002J\n\u0010§\u0002\u001a\u00030\u008e\u0001H\u0017J\u0013\u0010¨\u0002\u001a\u00030\u008e\u00012\u0007\u0010¶\u0001\u001a\u00020\u001cH\u0002J\u001e\u0010¨\u0002\u001a\u00030\u008e\u00012\u0007\u0010¶\u0001\u001a\u00020\u001c2\t\u0010©\u0002\u001a\u0004\u0018\u00010~H\u0002J\u001e\u0010ª\u0002\u001a\u00030\u008e\u00012\u0007\u0010¶\u0001\u001a\u00020\u001c2\t\u0010©\u0002\u001a\u0004\u0018\u00010~H\u0017J\n\u0010«\u0002\u001a\u00030\u008e\u0001H\u0016J\u0018\u0010¬\u0002\u001a\u00030\u008e\u00012\f\u0010\u0093\u0001\u001a\u0007\u0012\u0002\b\u00030\u00ad\u0002H\u0017J'\u0010®\u0002\u001a\u00030\u008e\u00012\u0015\u0010¯\u0002\u001a\u0010\u0012\u000b\b\u0001\u0012\u0007\u0012\u0002\b\u00030\u00ad\u00020°\u0002H\u0017¢\u0006\u0003\u0010±\u0002J\u001e\u0010²\u0002\u001a\u00030\u008e\u00012\u0007\u0010É\u0001\u001a\u00020\u00182\t\u0010¤\u0002\u001a\u0004\u0018\u00010~H\u0002J\u0013\u0010³\u0002\u001a\u00030\u008e\u00012\u0007\u0010¶\u0001\u001a\u00020\u001cH\u0017J\u0013\u0010´\u0002\u001a\u00030\u008e\u00012\u0007\u0010¶\u0001\u001a\u00020\u001cH\u0017J\u0012\u0010µ\u0002\u001a\u00020\u00012\u0007\u0010¶\u0001\u001a\u00020\u001cH\u0017J\u001e\u0010¶\u0002\u001a\u00030\u008e\u00012\u0007\u0010¶\u0001\u001a\u00020\u001c2\t\u0010©\u0002\u001a\u0004\u0018\u00010~H\u0016J\n\u0010·\u0002\u001a\u00030\u008e\u0001H\u0016J\b\u0010¸\u0002\u001a\u00030\u008e\u0001J\n\u0010¹\u0002\u001a\u00030\u008e\u0001H\u0002J#\u0010º\u0002\u001a\u00020\u00182\u0007\u0010\u0090\u0002\u001a\u0002052\t\u0010»\u0002\u001a\u0004\u0018\u00010~H\u0000¢\u0006\u0003\b¼\u0002J\u0015\u0010½\u0002\u001a\u00030\u008e\u00012\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010~H\u0001J2\u0010¾\u0002\u001a\u00030\u008e\u00012\u0007\u0010¿\u0002\u001a\u00020\u001c2\u0006\u0010r\u001a\u00020\u001c2\t\u0010©\u0002\u001a\u0004\u0018\u00010~2\t\u0010¤\u0002\u001a\u0004\u0018\u00010~H\u0082\bJ\u001c\u0010À\u0002\u001a\u00030\u008e\u00012\u0007\u0010Á\u0002\u001a\u00020\u001c2\u0006\u0010r\u001a\u00020\u001cH\u0082\bJ2\u0010Â\u0002\u001a\u00030\u008e\u00012\u0007\u0010¿\u0002\u001a\u00020\u001c2\u0006\u0010r\u001a\u00020\u001c2\t\u0010©\u0002\u001a\u0004\u0018\u00010~2\t\u0010¤\u0002\u001a\u0004\u0018\u00010~H\u0082\bJ\u001c\u0010Ã\u0002\u001a\u00030\u008e\u00012\u0007\u0010¿\u0002\u001a\u00020\u001c2\u0006\u0010r\u001a\u00020\u001cH\u0082\bJ\u001c\u0010Ä\u0002\u001a\u00030\u008e\u00012\u0007\u0010²\u0001\u001a\u00020\u001c2\u0007\u0010Å\u0002\u001a\u00020\u001cH\u0002J\u001c\u0010Æ\u0002\u001a\u00030\u008e\u00012\u0007\u0010²\u0001\u001a\u00020\u001c2\u0007\u0010Ç\u0002\u001a\u00020\u001cH\u0002J\u001b\u0010È\u0002\u001a\u00020h2\u0007\u0010É\u0002\u001a\u00020h2\u0007\u0010Ê\u0002\u001a\u00020hH\u0002J\u0015\u0010Ë\u0002\u001a\u00030\u008e\u00012\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010~H\u0016J\u0015\u0010Ì\u0002\u001a\u00030\u008e\u00012\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010~H\u0002J\u0015\u0010Í\u0002\u001a\u00030\u008e\u00012\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010~H\u0001J\u0012\u0010Î\u0002\u001a\u00020\u001c2\u0007\u0010²\u0001\u001a\u00020\u001cH\u0002J\n\u0010Ï\u0002\u001a\u00030\u008e\u0001H\u0016J\n\u0010Ð\u0002\u001a\u00030\u008e\u0001H\u0002J\n\u0010Ñ\u0002\u001a\u00030\u008e\u0001H\u0002J\u0010\u0010Ò\u0002\u001a\u00030\u008e\u0001H\u0000¢\u0006\u0003\bÓ\u0002J1\u0010Ô\u0002\u001a\u0003Hÿ\u0001\"\u0005\b\u0000\u0010ÿ\u00012\u0006\u0010s\u001a\u00020t2\u000f\u0010\u0094\u0001\u001a\n\u0012\u0005\u0012\u0003Hÿ\u00010\u009b\u0001H\u0082\b¢\u0006\u0003\u0010Õ\u0002J\u0016\u0010Ö\u0002\u001a\u00020\u001c*\u00020t2\u0007\u0010²\u0001\u001a\u00020\u001cH\u0002J\u0018\u0010×\u0002\u001a\u0004\u0018\u00010~*\u00020t2\u0007\u0010ë\u0001\u001a\u00020\u001cH\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010*\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001c8\u0016@RX\u0097\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010,\u001a\u0004\b-\u0010\u001eR\u0014\u0010.\u001a\u00020/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u001eR\u0016\u00104\u001a\u0004\u0018\u0001058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u001a\u00108\u001a\u00020\u00188VX\u0097\u0004¢\u0006\f\u0012\u0004\b9\u0010,\u001a\u0004\b:\u0010\u001aR\u001c\u0010;\u001a\u0004\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0010\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0004\n\u0002\u0010BR\u000e\u0010C\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010H\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\bI\u0010\u001aR\u0014\u0010J\u001a\u00020\u00188@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u001aR\u000e\u0010L\u001a\u00020MX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020OX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010P\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR&\u0010U\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00188\u0016@RX\u0097\u000e¢\u0006\u000e\n\u0000\u0012\u0004\bV\u0010,\u001a\u0004\bW\u0010\u001aR\u0014\u0010X\u001a\b\u0012\u0004\u0012\u0002050YX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010Z\u001a\b\u0012\u0004\u0012\u00020\\0[X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010]\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0018@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b^\u0010\u001aR\u001e\u0010_\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0018@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b`\u0010\u001aR\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u00010bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020hX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u0004\u0018\u00010kX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010l\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010k0YX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010m\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010n\u001a\n\u0012\u0004\u0012\u00020h\u0018\u00010oX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010s\u001a\u00020tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u0016\u0010y\u001a\u0004\u0018\u00010z8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b{\u0010|R\u0017\u0010}\u001a\u0004\u0018\u00010~8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u007f\u0010\u0080\u0001R\u000f\u0010\u0081\u0001\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0082\u0001\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0083\u0001\u001a\u00020\u00188VX\u0097\u0004¢\u0006\u000e\u0012\u0005\b\u0084\u0001\u0010,\u001a\u0005\b\u0085\u0001\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0087\u0001\u001a\u00030\u0088\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u008a\u0001\u001a\u0004\u0018\u00010~*\u00020t8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Ú\u0002"}, m13886d2 = {"Landroidx/compose/runtime/ComposerImpl;", "Landroidx/compose/runtime/Composer;", "applier", "Landroidx/compose/runtime/Applier;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "changes", "Landroidx/compose/runtime/changelist/ChangeList;", "lateChanges", "composition", "Landroidx/compose/runtime/ControlledComposition;", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/SlotTable;Ljava/util/Set;Landroidx/compose/runtime/changelist/ChangeList;Landroidx/compose/runtime/changelist/ChangeList;Landroidx/compose/runtime/ControlledComposition;)V", "getApplier", "()Landroidx/compose/runtime/Applier;", "applyCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "areChildrenComposing", "", "getAreChildrenComposing$runtime_release", "()Z", "changeCount", "", "getChangeCount$runtime_release", "()I", "changeListWriter", "Landroidx/compose/runtime/changelist/ComposerChangeListWriter;", "childrenComposing", "getComposition", "()Landroidx/compose/runtime/ControlledComposition;", "compositionData", "Landroidx/compose/runtime/tooling/CompositionData;", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "compositionToken", "<set-?>", "compoundKeyHash", "getCompoundKeyHash$annotations", "()V", "getCompoundKeyHash", "currentCompositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "getCurrentCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "currentMarker", "getCurrentMarker", "currentRecomposeScope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getCurrentRecomposeScope$runtime_release", "()Landroidx/compose/runtime/RecomposeScopeImpl;", "defaultsInvalid", "getDefaultsInvalid$annotations", "getDefaultsInvalid", "deferredChanges", "getDeferredChanges$runtime_release", "()Landroidx/compose/runtime/changelist/ChangeList;", "setDeferredChanges$runtime_release", "(Landroidx/compose/runtime/changelist/ChangeList;)V", "derivedStateObserver", "androidx/compose/runtime/ComposerImpl$derivedStateObserver$1", "Landroidx/compose/runtime/ComposerImpl$derivedStateObserver$1;", "entersStack", "Landroidx/compose/runtime/IntStack;", "forceRecomposeScopes", "forciblyRecompose", "groupNodeCount", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges$runtime_release", "insertAnchor", "Landroidx/compose/runtime/Anchor;", "insertFixups", "Landroidx/compose/runtime/changelist/FixupList;", "insertTable", "getInsertTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "setInsertTable$runtime_release", "(Landroidx/compose/runtime/SlotTable;)V", "inserting", "getInserting$annotations", "getInserting", "invalidateStack", "Landroidx/compose/runtime/Stack;", "invalidations", "", "Landroidx/compose/runtime/Invalidation;", "isComposing", "isComposing$runtime_release", "isDisposed", "isDisposed$runtime_release", "nodeCountOverrides", "", "nodeCountVirtualOverrides", "Landroidx/collection/MutableIntIntMap;", "nodeExpected", "nodeIndex", "parentProvider", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "parentStateStack", "pending", "Landroidx/compose/runtime/Pending;", "pendingStack", "providerCache", "providerUpdates", "Landroidx/compose/runtime/collection/IntMap;", "providersInvalid", "providersInvalidStack", "rGroupIndex", "reader", "Landroidx/compose/runtime/SlotReader;", "getReader$runtime_release", "()Landroidx/compose/runtime/SlotReader;", "setReader$runtime_release", "(Landroidx/compose/runtime/SlotReader;)V", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "recomposeScopeIdentity", "", "getRecomposeScopeIdentity", "()Ljava/lang/Object;", "reusing", "reusingGroup", "skipping", "getSkipping$annotations", "getSkipping", "sourceMarkersEnabled", "writer", "Landroidx/compose/runtime/SlotWriter;", "writerHasAProvider", "node", "getNode", "(Landroidx/compose/runtime/SlotReader;)Ljava/lang/Object;", "abortRoot", "", "addRecomposeScope", "apply", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "T", "value", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "buildContext", "cache", "invalid", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "changed", "", "", "", "", "", "", "changedInstance", "changesApplied", "changesApplied$runtime_release", "cleanUpCompose", "clearUpdatedNodeCounts", "collectParameterInformation", "composeContent", "invalidationsRequested", "Landroidx/compose/runtime/collection/ScopeMap;", "content", "Landroidx/compose/runtime/Composable;", "composeContent$runtime_release", "(Landroidx/compose/runtime/collection/ScopeMap;Lkotlin/jvm/functions/Function2;)V", "compoundKeyOf", "group", "recomposeGroup", "recomposeKey", "consume", "key", "Landroidx/compose/runtime/CompositionLocal;", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "createFreshInsertTable", "createNode", "factory", "currentCompositionLocalScope", "deactivate", "deactivate$runtime_release", "deactivateToEndGroup", "disableReusing", "disableSourceInformation", "dispose", "dispose$runtime_release", "doCompose", "doRecordDownsFor", "nearestCommonRoot", "enableReusing", "end", "isNode", "endDefaults", "endGroup", "endMovableGroup", "endNode", "endProvider", "endProviders", "endReplaceGroup", "endReplaceableGroup", "endRestartGroup", "Landroidx/compose/runtime/ScopeUpdateScope;", "endReusableGroup", "endReuseFromRoot", "endRoot", "endToMarker", "marker", "ensureWriter", "enterGroup", "newPending", "exitGroup", "expectedNodeCount", "finalizeCompose", "forceFreshInsertTable", "forceRecomposeScopes$runtime_release", "insertMovableContent", "Landroidx/compose/runtime/MovableContent;", "parameter", "insertMovableContentGuarded", "references", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "insertMovableContentReferences", "insertedGroupVirtualIndex", "index", "invokeMovableContentLambda", "locals", NotesSyncRpcProvider.FORCE_SYNC, "joinKey", "left", "right", "nextSlot", "nextSlotForCache", "nodeIndexOf", "groupLocation", "recomposeIndex", "parentKey", "parentKey$runtime_release", "prepareCompose", "prepareCompose$runtime_release", "rGroupIndexOf", "recompose", "recompose$runtime_release", "recomposeMovableContent", "R", Constants.MessagePayloadKeys.FROM, "to", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ControlledComposition;Ljava/lang/Integer;Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "recomposeToGroupEnd", "recordDelete", "recordInsert", "anchor", "recordProviderUpdate", "providers", "recordSideEffect", "effect", "recordUpsAndDowns", "oldGroup", "newGroup", "commonRoot", "recordUsed", "scope", "rememberObserverAnchor", "rememberedValue", "reportAllMovableContent", "reportFreeMovableContent", "groupBeingRemoved", "skipCurrentGroup", "skipGroup", "skipReaderToGroupEnd", "skipToGroupEnd", "sourceInformation", "", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "stacksSize", "stacksSize$runtime_release", "start", "objectKey", "kind", "Landroidx/compose/runtime/GroupKind;", "data", "start-BaiHCIY", "(ILjava/lang/Object;ILjava/lang/Object;)V", "startDefaults", "startGroup", "dataKey", "startMovableGroup", "startNode", "startProvider", "Landroidx/compose/runtime/ProvidedValue;", "startProviders", "values", "", "([Landroidx/compose/runtime/ProvidedValue;)V", "startReaderGroup", "startReplaceGroup", "startReplaceableGroup", "startRestartGroup", "startReusableGroup", "startReusableNode", "startReuseFromRoot", "startRoot", "tryImminentInvalidation", "instance", "tryImminentInvalidation$runtime_release", "updateCachedValue", "updateCompoundKeyWhenWeEnterGroup", "groupKey", "updateCompoundKeyWhenWeEnterGroupKeyHash", "keyHash", "updateCompoundKeyWhenWeExitGroup", "updateCompoundKeyWhenWeExitGroupKeyHash", "updateNodeCount", "count", "updateNodeCountOverrides", "newCount", "updateProviderMapGroup", "parentScope", "currentProviders", "updateRememberedValue", "updateSlot", "updateValue", "updatedNodeCount", "useNode", "validateNodeExpected", "validateNodeNotExpected", "verifyConsistent", "verifyConsistent$runtime_release", "withReader", "(Landroidx/compose/runtime/SlotReader;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "groupCompoundKeyPart", "nodeAt", "CompositionContextHolder", "CompositionContextImpl", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nComposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Composer.kt\nandroidx/compose/runtime/ComposerImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 SlotTable.kt\nandroidx/compose/runtime/SlotTable\n+ 4 BitwiseOperators.kt\nandroidx/compose/runtime/BitwiseOperatorsKt\n+ 5 Trace.kt\nandroidx/compose/runtime/TraceKt\n+ 6 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 7 Preconditions.kt\nandroidx/compose/runtime/PreconditionsKt\n+ 8 CompositionLocalMap.kt\nandroidx/compose/runtime/CompositionLocalMapKt\n+ 9 Composer.kt\nandroidx/compose/runtime/GroupKind\n+ 10 ComposerChangeListWriter.kt\nandroidx/compose/runtime/changelist/ComposerChangeListWriter\n+ 11 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n+ 12 ScatterMap.kt\nandroidx/collection/ScatterMap\n+ 13 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 14 DerivedState.kt\nandroidx/compose/runtime/SnapshotStateKt__DerivedStateKt\n+ 15 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 16 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,4584:1\n3960#1,3:4594\n3973#1:4597\n3974#1:4599\n3964#1,11:4600\n3960#1,3:4638\n3973#1:4641\n3974#1:4643\n3964#1,11:4644\n3983#1,3:4657\n3996#1:4660\n3997#1:4662\n3987#1,11:4663\n3983#1,3:4674\n3996#1:4677\n3997#1:4679\n3987#1,11:4680\n3960#1,3:4692\n3973#1:4695\n3974#1:4697\n3964#1,11:4698\n3983#1,3:4709\n3996#1:4712\n3997#1:4714\n3987#1,11:4715\n3446#1,8:4760\n3455#1,3:4783\n3973#1:4902\n3974#1:4904\n3973#1:4905\n3974#1:4907\n3973#1:4908\n3974#1:4910\n3973#1:4911\n3974#1:4913\n3996#1:4915\n3997#1:4917\n3996#1:4918\n3997#1:4920\n3996#1:4921\n3997#1:4923\n3996#1:4924\n3997#1:4926\n1#2:4585\n159#3,8:4586\n159#3,8:4748\n159#3,4:4756\n164#3,3:4786\n159#3,4:4880\n164#3,3:4892\n26#4:4598\n26#4:4642\n22#4:4661\n22#4:4678\n26#4:4691\n26#4:4696\n22#4:4713\n26#4:4903\n26#4:4906\n26#4:4909\n26#4:4912\n26#4:4914\n22#4:4916\n22#4:4919\n22#4:4922\n22#4:4925\n22#4:4927\n46#5,5:4611\n46#5,3:4827\n50#5:4865\n4553#6,7:4616\n4553#6,7:4623\n4553#6,7:4726\n4553#6,7:4733\n4553#6,7:4799\n4553#6,7:4806\n4553#6,7:4813\n4553#6,7:4820\n4553#6,7:4866\n4553#6,7:4873\n4553#6,7:4895\n33#7,7:4630\n82#8:4637\n4470#9:4655\n4471#9:4656\n182#10,4:4740\n182#10,4:4768\n192#10,8:4772\n187#10,3:4780\n187#10,3:4790\n182#10,8:4884\n33#11,4:4744\n38#11:4789\n33#11,6:4793\n82#11,3:4928\n33#11,4:4931\n85#11,2:4935\n38#11:4937\n87#11:4938\n393#12,4:4830\n365#12,6:4834\n375#12,3:4841\n378#12,2:4845\n398#12,2:4847\n381#12,6:4849\n400#12:4855\n1956#13:4840\n1820#13:4844\n392#14,6:4856\n398#14,2:4863\n48#15:4862\n1855#16,2:4939\n*S KotlinDebug\n*F\n+ 1 Composer.kt\nandroidx/compose/runtime/ComposerImpl\n*L\n1495#1:4594,3\n1495#1:4597\n1495#1:4599\n1495#1:4600,11\n2457#1:4638,3\n2457#1:4641\n2457#1:4643\n2457#1:4644,11\n2604#1:4657,3\n2604#1:4660\n2604#1:4662\n2604#1:4663,11\n2612#1:4674,3\n2612#1:4677\n2612#1:4679\n2612#1:4680,11\n3114#1:4692,3\n3114#1:4695\n3114#1:4697\n3114#1:4698,11\n3118#1:4709,3\n3118#1:4712\n3118#1:4714\n3118#1:4715,11\n3409#1:4760,8\n3409#1:4783,3\n3962#1:4902\n3962#1:4904\n3964#1:4905\n3964#1:4907\n3966#1:4908\n3966#1:4910\n3968#1:4911\n3968#1:4913\n3985#1:4915\n3985#1:4917\n3987#1:4918\n3987#1:4920\n3989#1:4921\n3989#1:4923\n3991#1:4924\n3991#1:4926\n1430#1:4586,8\n3350#1:4748,8\n3408#1:4756,4\n3408#1:4786,3\n3773#1:4880,4\n3773#1:4892,3\n1495#1:4598\n2457#1:4642\n2604#1:4661\n2612#1:4678\n3058#1:4691\n3114#1:4696\n3118#1:4713\n3962#1:4903\n3964#1:4906\n3966#1:4909\n3968#1:4912\n3973#1:4914\n3985#1:4916\n3987#1:4919\n3989#1:4922\n3991#1:4925\n3996#1:4927\n1755#1:4611,5\n3563#1:4827,3\n3563#1:4865\n1828#1:4616,7\n1841#1:4623,7\n3132#1:4726,7\n3145#1:4733,7\n3521#1:4799,7\n3526#1:4806,7\n3542#1:4813,7\n3562#1:4820,7\n3628#1:4866,7\n3635#1:4873,7\n3785#1:4895,7\n1888#1:4630,7\n2258#1:4637\n2463#1:4655\n2487#1:4656\n3327#1:4740,4\n3414#1:4768,4\n3415#1:4772,8\n3414#1:4780,3\n3327#1:4790,3\n3775#1:4884,8\n3329#1:4744,4\n3329#1:4789\n3473#1:4793,6\n3684#1:4928,3\n3684#1:4931,4\n3684#1:4935,2\n3684#1:4937\n3684#1:4938\n3566#1:4830,4\n3566#1:4834,6\n3566#1:4841,3\n3566#1:4845,2\n3566#1:4847,2\n3566#1:4849,6\n3566#1:4855\n3566#1:4840\n3566#1:4844\n3592#1:4856,6\n3592#1:4863,2\n3592#1:4862\n3716#1:4939,2\n*E\n"})
public final class ComposerImpl implements Composer {
    public static final int $stable = 8;

    @NotNull
    private final Set<RememberObserver> abandonSet;

    @NotNull
    private final Applier<?> applier;

    @NotNull
    private final ComposerChangeListWriter changeListWriter;

    @NotNull
    private ChangeList changes;
    private int childrenComposing;

    @NotNull
    private final ControlledComposition composition;
    private int compositionToken;
    private int compoundKeyHash;

    @Nullable
    private ChangeList deferredChanges;

    @NotNull
    private final ComposerImpl$derivedStateObserver$1 derivedStateObserver;
    private boolean forceRecomposeScopes;
    private boolean forciblyRecompose;
    private int groupNodeCount;

    @NotNull
    private Anchor insertAnchor;

    @NotNull
    private FixupList insertFixups;

    @NotNull
    private SlotTable insertTable;
    private boolean inserting;

    @NotNull
    private final Stack<RecomposeScopeImpl> invalidateStack;
    private boolean isComposing;
    private boolean isDisposed;

    @NotNull
    private ChangeList lateChanges;

    @Nullable
    private int[] nodeCountOverrides;

    @Nullable
    private MutableIntIntMap nodeCountVirtualOverrides;
    private boolean nodeExpected;
    private int nodeIndex;

    @NotNull
    private final CompositionContext parentContext;

    @Nullable
    private Pending pending;

    @Nullable
    private PersistentCompositionLocalMap providerCache;

    @Nullable
    private IntMap<PersistentCompositionLocalMap> providerUpdates;
    private boolean providersInvalid;
    private int rGroupIndex;

    @NotNull
    private SlotReader reader;
    private boolean reusing;

    @NotNull
    private final SlotTable slotTable;
    private boolean sourceMarkersEnabled;

    @NotNull
    private SlotWriter writer;
    private boolean writerHasAProvider;

    @NotNull
    private final Stack<Pending> pendingStack = new Stack<>();

    @NotNull
    private final IntStack parentStateStack = new IntStack();

    @NotNull
    private final List<Invalidation> invalidations = new ArrayList();

    @NotNull
    private final IntStack entersStack = new IntStack();

    @NotNull
    private PersistentCompositionLocalMap parentProvider = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf();

    @NotNull
    private final IntStack providersInvalidStack = new IntStack();
    private int reusingGroup = -1;

    /* JADX WARN: Type inference failed for: r1v11, types: [androidx.compose.runtime.ComposerImpl$derivedStateObserver$1] */
    public ComposerImpl(@NotNull Applier<?> applier, @NotNull CompositionContext compositionContext, @NotNull SlotTable slotTable, @NotNull Set<RememberObserver> set, @NotNull ChangeList changeList, @NotNull ChangeList changeList2, @NotNull ControlledComposition controlledComposition) {
        this.applier = applier;
        this.parentContext = compositionContext;
        this.slotTable = slotTable;
        this.abandonSet = set;
        this.changes = changeList;
        this.lateChanges = changeList2;
        this.composition = controlledComposition;
        this.sourceMarkersEnabled = compositionContext.getCollectingSourceInformation() || compositionContext.getCollectingCallByInformation$runtime_release();
        this.derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.ComposerImpl$derivedStateObserver$1
            @Override // androidx.compose.runtime.DerivedStateObserver
            public void done(@NotNull DerivedState<?> derivedState) {
                ComposerImpl composerImpl = this.this$0;
                composerImpl.childrenComposing--;
            }

            @Override // androidx.compose.runtime.DerivedStateObserver
            public void start(@NotNull DerivedState<?> derivedState) {
                this.this$0.childrenComposing++;
            }
        };
        this.invalidateStack = new Stack<>();
        SlotReader slotReaderOpenReader = slotTable.openReader();
        slotReaderOpenReader.close();
        this.reader = slotReaderOpenReader;
        SlotTable slotTable2 = new SlotTable();
        if (compositionContext.getCollectingSourceInformation()) {
            slotTable2.collectSourceInformation();
        }
        if (compositionContext.getCollectingCallByInformation$runtime_release()) {
            slotTable2.collectCalledByInformation();
        }
        this.insertTable = slotTable2;
        SlotWriter slotWriterOpenWriter = slotTable2.openWriter();
        slotWriterOpenWriter.close(true);
        this.writer = slotWriterOpenWriter;
        this.changeListWriter = new ComposerChangeListWriter(this, this.changes);
        SlotReader slotReaderOpenReader2 = this.insertTable.openReader();
        try {
            Anchor anchor = slotReaderOpenReader2.anchor(0);
            slotReaderOpenReader2.close();
            this.insertAnchor = anchor;
            this.insertFixups = new FixupList();
        } catch (Throwable th) {
            slotReaderOpenReader2.close();
            throw th;
        }
    }

    private final void abortRoot() {
        cleanUpCompose();
        this.pendingStack.clear();
        this.parentStateStack.clear();
        this.entersStack.clear();
        this.providersInvalidStack.clear();
        this.providerUpdates = null;
        this.insertFixups.clear();
        this.compoundKeyHash = 0;
        this.childrenComposing = 0;
        this.nodeExpected = false;
        this.inserting = false;
        this.reusing = false;
        this.isComposing = false;
        this.forciblyRecompose = false;
        this.reusingGroup = -1;
        if (!this.reader.getClosed()) {
            this.reader.close();
        }
        if (this.writer.getClosed()) {
            return;
        }
        forceFreshInsertTable();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void addRecomposeScope() {
        RecomposeScopeImpl recomposeScopeImpl;
        boolean z;
        if (getInserting()) {
            ControlledComposition composition = getComposition();
            Intrinsics.checkNotNull(composition, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            RecomposeScopeImpl recomposeScopeImpl2 = new RecomposeScopeImpl((CompositionImpl) composition);
            this.invalidateStack.push(recomposeScopeImpl2);
            updateValue(recomposeScopeImpl2);
            recomposeScopeImpl2.start(this.compositionToken);
            return;
        }
        Invalidation invalidationRemoveLocation = ComposerKt.removeLocation(this.invalidations, this.reader.getParent());
        Object next = this.reader.next();
        if (Intrinsics.areEqual(next, Composer.INSTANCE.getEmpty())) {
            ControlledComposition composition2 = getComposition();
            Intrinsics.checkNotNull(composition2, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            recomposeScopeImpl = new RecomposeScopeImpl((CompositionImpl) composition2);
            updateValue(recomposeScopeImpl);
        } else {
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
            recomposeScopeImpl = (RecomposeScopeImpl) next;
        }
        if (invalidationRemoveLocation == null) {
            boolean forcedRecompose = recomposeScopeImpl.getForcedRecompose();
            if (forcedRecompose) {
                recomposeScopeImpl.setForcedRecompose(false);
            }
            z = forcedRecompose;
        }
        recomposeScopeImpl.setRequiresRecompose(z);
        this.invalidateStack.push(recomposeScopeImpl);
        recomposeScopeImpl.start(this.compositionToken);
    }

    private final void cleanUpCompose() {
        this.pending = null;
        this.nodeIndex = 0;
        this.groupNodeCount = 0;
        this.compoundKeyHash = 0;
        this.nodeExpected = false;
        this.changeListWriter.resetTransientState();
        this.invalidateStack.clear();
        clearUpdatedNodeCounts();
    }

    private final void clearUpdatedNodeCounts() {
        this.nodeCountOverrides = null;
        this.nodeCountVirtualOverrides = null;
    }

    private final int compoundKeyOf(int group, int rGroupIndex, int recomposeGroup, int recomposeKey) {
        if (group == recomposeGroup) {
            return recomposeKey;
        }
        int iGroupCompoundKeyPart = groupCompoundKeyPart(this.reader, group);
        if (iGroupCompoundKeyPart == 126665345) {
            return iGroupCompoundKeyPart;
        }
        int iParent = this.reader.parent(group);
        if (iParent != recomposeGroup) {
            recomposeKey = compoundKeyOf(iParent, rGroupIndexOf(iParent), recomposeGroup, recomposeKey);
        }
        if (this.reader.hasObjectKey(group)) {
            rGroupIndex = 0;
        }
        return Integer.rotateLeft(Integer.rotateLeft(recomposeKey, 3) ^ iGroupCompoundKeyPart, 3) ^ rGroupIndex;
    }

    private final void createFreshInsertTable() {
        ComposerKt.runtimeCheck(this.writer.getClosed());
        forceFreshInsertTable();
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope() {
        PersistentCompositionLocalMap persistentCompositionLocalMap = this.providerCache;
        return persistentCompositionLocalMap != null ? persistentCompositionLocalMap : currentCompositionLocalScope(this.reader.getParent());
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void doCompose(ScopeMap<RecomposeScopeImpl, Object> invalidationsRequested, Function2<? super Composer, ? super Integer, Unit> content) {
        long[] jArr;
        long[] jArr2;
        int i;
        if (this.isComposing) {
            ComposerKt.composeImmediateRuntimeError("Reentrant composition is not supported");
        }
        Object objBeginSection = Trace.INSTANCE.beginSection("Compose:recompose");
        try {
            this.compositionToken = SnapshotKt.currentSnapshot().getId();
            this.providerUpdates = null;
            MutableScatterMap<Object, Object> map = invalidationsRequested.getMap();
            Object[] objArr = map.keys;
            Object[] objArr2 = map.values;
            long[] jArr3 = map.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i2 = 0;
                while (true) {
                    long j = jArr3[i2];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i4 = 8;
                        int i5 = 8 - ((~(i2 - length)) >>> 31);
                        int i6 = 0;
                        while (i6 < i5) {
                            if ((j & 255) < 128) {
                                int i7 = (i2 << 3) + i6;
                                Object obj = objArr[i7];
                                Object obj2 = objArr2[i7];
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
                                Anchor anchor = ((RecomposeScopeImpl) obj).getAnchor();
                                if (anchor != null) {
                                    int location = anchor.getLocation();
                                    i = i4;
                                    List<Invalidation> list = this.invalidations;
                                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
                                    jArr2 = jArr3;
                                    if (obj2 == ScopeInvalidated.INSTANCE) {
                                        obj2 = null;
                                    }
                                    list.add(new Invalidation(recomposeScopeImpl, location, obj2));
                                } else {
                                    jArr2 = jArr3;
                                    i = i4;
                                }
                            }
                            j >>= i;
                            i6++;
                            i4 = i;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        if (i5 != i4) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                    }
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                    jArr3 = jArr;
                }
            }
            CollectionsKt.sortWith(this.invalidations, ComposerKt.InvalidationLocationAscending);
            this.nodeIndex = 0;
            this.isComposing = true;
            try {
                startRoot();
                Object objNextSlot = nextSlot();
                if (objNextSlot != content && content != null) {
                    updateValue(content);
                }
                ComposerImpl$derivedStateObserver$1 composerImpl$derivedStateObserver$1 = this.derivedStateObserver;
                MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
                try {
                    mutableVectorDerivedStateObservers.add(composerImpl$derivedStateObserver$1);
                    if (content != null) {
                        startGroup(200, ComposerKt.getInvocation());
                        ActualJvm_jvmKt.invokeComposable(this, content);
                        endGroup();
                    } else if ((!this.forciblyRecompose && !this.providersInvalid) || objNextSlot == null || Intrinsics.areEqual(objNextSlot, Composer.INSTANCE.getEmpty())) {
                        skipCurrentGroup();
                    } else {
                        startGroup(200, ComposerKt.getInvocation());
                        ActualJvm_jvmKt.invokeComposable(this, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(objNextSlot, 2));
                        endGroup();
                    }
                    mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                    endRoot();
                    this.isComposing = false;
                    this.invalidations.clear();
                    createFreshInsertTable();
                    Unit unit = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(objBeginSection);
                } finally {
                    mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                }
            } catch (Throwable th) {
                this.isComposing = false;
                this.invalidations.clear();
                abortRoot();
                createFreshInsertTable();
                throw th;
            }
        } catch (Throwable th2) {
            Trace.INSTANCE.endSection(objBeginSection);
            throw th2;
        }
    }

    private final void doRecordDownsFor(int group, int nearestCommonRoot) {
        if (group <= 0 || group == nearestCommonRoot) {
            return;
        }
        doRecordDownsFor(this.reader.parent(group), nearestCommonRoot);
        if (this.reader.isNode(group)) {
            this.changeListWriter.moveDown(nodeAt(this.reader, group));
        }
    }

    private final void end(boolean isNode) {
        int iHashCode;
        List<KeyInfo> list;
        List<KeyInfo> list2;
        int iHashCode2;
        int iPeek2 = this.parentStateStack.peek2() - 1;
        if (getInserting()) {
            int parent = this.writer.getParent();
            int iGroupKey = this.writer.groupKey(parent);
            Object objGroupObjectKey = this.writer.groupObjectKey(parent);
            Object objGroupAux = this.writer.groupAux(parent);
            if (objGroupObjectKey != null) {
                iHashCode2 = Integer.hashCode(objGroupObjectKey instanceof Enum ? ((Enum) objGroupObjectKey).ordinal() : objGroupObjectKey.hashCode()) ^ Integer.rotateRight(getCompoundKeyHash(), 3);
            } else if (objGroupAux == null || iGroupKey != 207 || Intrinsics.areEqual(objGroupAux, Composer.INSTANCE.getEmpty())) {
                iHashCode2 = Integer.rotateRight(iPeek2 ^ getCompoundKeyHash(), 3) ^ Integer.hashCode(iGroupKey);
            } else {
                this.compoundKeyHash = Integer.rotateRight(Integer.rotateRight(iPeek2 ^ getCompoundKeyHash(), 3) ^ Integer.hashCode(objGroupAux.hashCode()), 3);
            }
            this.compoundKeyHash = Integer.rotateRight(iHashCode2, 3);
        } else {
            int parent2 = this.reader.getParent();
            int iGroupKey2 = this.reader.groupKey(parent2);
            Object objGroupObjectKey2 = this.reader.groupObjectKey(parent2);
            Object objGroupAux2 = this.reader.groupAux(parent2);
            if (objGroupObjectKey2 != null) {
                iHashCode = Integer.hashCode(objGroupObjectKey2 instanceof Enum ? ((Enum) objGroupObjectKey2).ordinal() : objGroupObjectKey2.hashCode()) ^ Integer.rotateRight(getCompoundKeyHash(), 3);
            } else if (objGroupAux2 == null || iGroupKey2 != 207 || Intrinsics.areEqual(objGroupAux2, Composer.INSTANCE.getEmpty())) {
                iHashCode = Integer.rotateRight(iPeek2 ^ getCompoundKeyHash(), 3) ^ Integer.hashCode(iGroupKey2);
            } else {
                this.compoundKeyHash = Integer.rotateRight(Integer.rotateRight(iPeek2 ^ getCompoundKeyHash(), 3) ^ Integer.hashCode(objGroupAux2.hashCode()), 3);
            }
            this.compoundKeyHash = Integer.rotateRight(iHashCode, 3);
        }
        int i = this.groupNodeCount;
        Pending pending = this.pending;
        if (pending != null && pending.getKeyInfos().size() > 0) {
            List<KeyInfo> keyInfos = pending.getKeyInfos();
            List<KeyInfo> used = pending.getUsed();
            Set setFastToSet = ListUtilsKt.fastToSet(used);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int size = used.size();
            int size2 = keyInfos.size();
            int i2 = 0;
            int i4 = 0;
            int iUpdatedNodeCountOf = 0;
            while (i2 < size2) {
                KeyInfo keyInfo = keyInfos.get(i2);
                if (setFastToSet.contains(keyInfo)) {
                    list = keyInfos;
                    if (!linkedHashSet.contains(keyInfo)) {
                        if (i4 < size) {
                            KeyInfo keyInfo2 = used.get(i4);
                            if (keyInfo2 != keyInfo) {
                                int iNodePositionOf = pending.nodePositionOf(keyInfo2);
                                linkedHashSet.add(keyInfo2);
                                if (iNodePositionOf != iUpdatedNodeCountOf) {
                                    int iUpdatedNodeCountOf2 = pending.updatedNodeCountOf(keyInfo2);
                                    list2 = used;
                                    this.changeListWriter.moveNode(pending.getStartIndex() + iNodePositionOf, iUpdatedNodeCountOf + pending.getStartIndex(), iUpdatedNodeCountOf2);
                                    pending.registerMoveNode(iNodePositionOf, iUpdatedNodeCountOf, iUpdatedNodeCountOf2);
                                } else {
                                    list2 = used;
                                }
                            } else {
                                list2 = used;
                                i2++;
                            }
                            i4++;
                            iUpdatedNodeCountOf += pending.updatedNodeCountOf(keyInfo2);
                            keyInfos = list;
                            used = list2;
                        }
                    }
                    keyInfos = list;
                } else {
                    this.changeListWriter.removeNode(pending.nodePositionOf(keyInfo) + pending.getStartIndex(), keyInfo.getNodes());
                    pending.updateNodeCount(keyInfo.getLocation(), 0);
                    this.changeListWriter.moveReaderRelativeTo(keyInfo.getLocation());
                    this.reader.reposition(keyInfo.getLocation());
                    recordDelete();
                    this.reader.skipGroup();
                    list = keyInfos;
                    ComposerKt.removeRange(this.invalidations, keyInfo.getLocation(), this.reader.groupSize(keyInfo.getLocation()) + keyInfo.getLocation());
                }
                i2++;
                keyInfos = list;
            }
            this.changeListWriter.endNodeMovement();
            if (keyInfos.size() > 0) {
                this.changeListWriter.moveReaderRelativeTo(this.reader.getGroupEnd());
                this.reader.skipToGroupEnd();
            }
        }
        int i5 = this.nodeIndex;
        while (!this.reader.isGroupEnd()) {
            int currentGroup = this.reader.getCurrentGroup();
            recordDelete();
            this.changeListWriter.removeNode(i5, this.reader.skipGroup());
            ComposerKt.removeRange(this.invalidations, currentGroup, this.reader.getCurrentGroup());
        }
        boolean inserting = getInserting();
        if (inserting) {
            if (isNode) {
                this.insertFixups.endNodeInsert();
                i = 1;
            }
            this.reader.endEmpty();
            int parent3 = this.writer.getParent();
            this.writer.endGroup();
            if (!this.reader.getInEmpty()) {
                int iInsertedGroupVirtualIndex = insertedGroupVirtualIndex(parent3);
                this.writer.endInsert();
                this.writer.close(true);
                recordInsert(this.insertAnchor);
                this.inserting = false;
                if (!this.slotTable.isEmpty()) {
                    updateNodeCount(iInsertedGroupVirtualIndex, 0);
                    updateNodeCountOverrides(iInsertedGroupVirtualIndex, i);
                }
            }
        } else {
            if (isNode) {
                this.changeListWriter.moveUp();
            }
            int remainingSlots = this.reader.getRemainingSlots();
            if (remainingSlots > 0) {
                this.changeListWriter.trimValues(remainingSlots);
            }
            this.changeListWriter.endCurrentGroup();
            int parent4 = this.reader.getParent();
            if (i != updatedNodeCount(parent4)) {
                updateNodeCountOverrides(parent4, i);
            }
            if (isNode) {
                i = 1;
            }
            this.reader.endGroup();
            this.changeListWriter.endNodeMovement();
        }
        exitGroup(i, inserting);
    }

    private final void endGroup() {
        end(false);
    }

    private final void endRoot() {
        endGroup();
        this.parentContext.doneComposing$runtime_release();
        endGroup();
        this.changeListWriter.endRoot();
        finalizeCompose();
        this.reader.close();
        this.forciblyRecompose = false;
        this.providersInvalid = ComposerKt.asBool(this.providersInvalidStack.pop());
    }

    private final void ensureWriter() {
        if (this.writer.getClosed()) {
            SlotWriter slotWriterOpenWriter = this.insertTable.openWriter();
            this.writer = slotWriterOpenWriter;
            slotWriterOpenWriter.skipToGroupEnd();
            this.writerHasAProvider = false;
            this.providerCache = null;
        }
    }

    private final void enterGroup(boolean isNode, Pending newPending) {
        this.pendingStack.push(this.pending);
        this.pending = newPending;
        this.parentStateStack.push(this.groupNodeCount);
        this.parentStateStack.push(this.rGroupIndex);
        this.parentStateStack.push(this.nodeIndex);
        if (isNode) {
            this.nodeIndex = 0;
        }
        this.groupNodeCount = 0;
        this.rGroupIndex = 0;
    }

    private final void exitGroup(int expectedNodeCount, boolean inserting) {
        Pending pendingPop = this.pendingStack.pop();
        if (pendingPop != null && !inserting) {
            pendingPop.setGroupIndex(pendingPop.getGroupIndex() + 1);
        }
        this.pending = pendingPop;
        this.nodeIndex = this.parentStateStack.pop() + expectedNodeCount;
        this.rGroupIndex = this.parentStateStack.pop();
        this.groupNodeCount = this.parentStateStack.pop() + expectedNodeCount;
    }

    private final void finalizeCompose() {
        this.changeListWriter.finalizeComposition();
        if (!this.pendingStack.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Start/end imbalance");
        }
        cleanUpCompose();
    }

    private final void forceFreshInsertTable() {
        SlotTable slotTable = new SlotTable();
        if (this.sourceMarkersEnabled) {
            slotTable.collectSourceInformation();
        }
        if (this.parentContext.getCollectingCallByInformation$runtime_release()) {
            slotTable.collectCalledByInformation();
        }
        this.insertTable = slotTable;
        SlotWriter slotWriterOpenWriter = slotTable.openWriter();
        slotWriterOpenWriter.close(true);
        this.writer = slotWriterOpenWriter;
    }

    private final Object getNode(SlotReader slotReader) {
        return slotReader.node(slotReader.getParent());
    }

    private final int groupCompoundKeyPart(SlotReader slotReader, int i) {
        Object objGroupAux;
        if (!slotReader.hasObjectKey(i)) {
            int iGroupKey = slotReader.groupKey(i);
            return (iGroupKey != 207 || (objGroupAux = slotReader.groupAux(i)) == null || Intrinsics.areEqual(objGroupAux, Composer.INSTANCE.getEmpty())) ? iGroupKey : objGroupAux.hashCode();
        }
        Object objGroupObjectKey = slotReader.groupObjectKey(i);
        if (objGroupObjectKey != null) {
            return objGroupObjectKey instanceof Enum ? ((Enum) objGroupObjectKey).ordinal() : objGroupObjectKey instanceof MovableContent ? MovableContentKt.movableContentKey : objGroupObjectKey.hashCode();
        }
        return 0;
    }

    private final void insertMovableContentGuarded(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) throws Throwable {
        ComposerChangeListWriter composerChangeListWriter;
        ChangeList changeList;
        ComposerChangeListWriter composerChangeListWriter2;
        ChangeList changeList2;
        SlotTable slotTable;
        Anchor anchor;
        SlotReader slotReader;
        IntMap intMap;
        ChangeList changeList3;
        ComposerChangeListWriter composerChangeListWriter3;
        ChangeList changeList4;
        ComposerChangeListWriter composerChangeListWriter4;
        ChangeList changeList5;
        int i;
        int i2;
        SlotTable slotTable2;
        ComposerChangeListWriter composerChangeListWriter5 = this.changeListWriter;
        ChangeList changeList6 = this.lateChanges;
        ChangeList changeList7 = composerChangeListWriter5.getChangeList();
        try {
            composerChangeListWriter5.setChangeList(changeList6);
            this.changeListWriter.resetSlots();
            int size = references.size();
            int i4 = 0;
            int i5 = 0;
            while (i5 < size) {
                try {
                    Pair<MovableContentStateReference, MovableContentStateReference> pair = references.get(i5);
                    final MovableContentStateReference movableContentStateReferenceComponent1 = pair.component1();
                    MovableContentStateReference movableContentStateReferenceComponent2 = pair.component2();
                    Anchor anchor2 = movableContentStateReferenceComponent1.getAnchor();
                    int iAnchorIndex = movableContentStateReferenceComponent1.getSlotTable().anchorIndex(anchor2);
                    IntRef intRef = new IntRef(i4, 1, null);
                    this.changeListWriter.determineMovableContentNodeIndex(intRef, anchor2);
                    if (movableContentStateReferenceComponent2 == null) {
                        if (Intrinsics.areEqual(movableContentStateReferenceComponent1.getSlotTable(), this.insertTable)) {
                            createFreshInsertTable();
                        }
                        final SlotReader slotReaderOpenReader = movableContentStateReferenceComponent1.getSlotTable().openReader();
                        try {
                            slotReaderOpenReader.reposition(iAnchorIndex);
                            this.changeListWriter.moveReaderToAbsolute(iAnchorIndex);
                            final ChangeList changeList8 = new ChangeList();
                            recomposeMovableContent$default(this, null, null, null, null, new Function0<Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    ComposerChangeListWriter composerChangeListWriter6 = this.this$0.changeListWriter;
                                    ChangeList changeList9 = changeList8;
                                    ComposerImpl composerImpl = this.this$0;
                                    SlotReader slotReader2 = slotReaderOpenReader;
                                    MovableContentStateReference movableContentStateReference = movableContentStateReferenceComponent1;
                                    ChangeList changeList10 = composerChangeListWriter6.getChangeList();
                                    try {
                                        composerChangeListWriter6.setChangeList(changeList9);
                                        SlotReader reader = composerImpl.getReader();
                                        int[] iArr = composerImpl.nodeCountOverrides;
                                        IntMap intMap2 = composerImpl.providerUpdates;
                                        composerImpl.nodeCountOverrides = null;
                                        composerImpl.providerUpdates = null;
                                        try {
                                            composerImpl.setReader$runtime_release(slotReader2);
                                            ComposerChangeListWriter composerChangeListWriter7 = composerImpl.changeListWriter;
                                            boolean implicitRootStart = composerChangeListWriter7.getImplicitRootStart();
                                            try {
                                                composerChangeListWriter7.setImplicitRootStart(false);
                                                composerImpl.invokeMovableContentLambda(movableContentStateReference.getContent$runtime_release(), movableContentStateReference.getLocals(), movableContentStateReference.getParameter(), true);
                                                composerChangeListWriter7.setImplicitRootStart(implicitRootStart);
                                                Unit unit = Unit.INSTANCE;
                                            } catch (Throwable th) {
                                                composerChangeListWriter7.setImplicitRootStart(implicitRootStart);
                                                throw th;
                                            }
                                        } finally {
                                            composerImpl.setReader$runtime_release(reader);
                                            composerImpl.nodeCountOverrides = iArr;
                                            composerImpl.providerUpdates = intMap2;
                                        }
                                    } finally {
                                        composerChangeListWriter6.setChangeList(changeList10);
                                    }
                                }
                            }, 15, null);
                            this.changeListWriter.includeOperationsIn(changeList8, intRef);
                            Unit unit = Unit.INSTANCE;
                            slotReaderOpenReader.close();
                            i2 = size;
                            composerChangeListWriter2 = composerChangeListWriter5;
                            changeList2 = changeList7;
                            i = i5;
                        } finally {
                        }
                    } else {
                        MovableContentState movableContentStateMovableContentStateResolve$runtime_release = this.parentContext.movableContentStateResolve$runtime_release(movableContentStateReferenceComponent2);
                        if (movableContentStateMovableContentStateResolve$runtime_release == null || (slotTable = movableContentStateMovableContentStateResolve$runtime_release.getSlotTable()) == null) {
                            slotTable = movableContentStateReferenceComponent2.getSlotTable();
                        }
                        if (movableContentStateMovableContentStateResolve$runtime_release == null || (slotTable2 = movableContentStateMovableContentStateResolve$runtime_release.getSlotTable()) == null || (anchor = slotTable2.anchor(0)) == null) {
                            anchor = movableContentStateReferenceComponent2.getAnchor();
                        }
                        List<? extends Object> listCollectNodesFrom = ComposerKt.collectNodesFrom(slotTable, anchor);
                        if (!listCollectNodesFrom.isEmpty()) {
                            this.changeListWriter.copyNodesToNewAnchorLocation(listCollectNodesFrom, intRef);
                            if (Intrinsics.areEqual(movableContentStateReferenceComponent1.getSlotTable(), this.slotTable)) {
                                int iAnchorIndex2 = this.slotTable.anchorIndex(anchor2);
                                updateNodeCount(iAnchorIndex2, updatedNodeCount(iAnchorIndex2) + listCollectNodesFrom.size());
                            }
                        }
                        this.changeListWriter.copySlotTableToAnchorLocation(movableContentStateMovableContentStateResolve$runtime_release, this.parentContext, movableContentStateReferenceComponent2, movableContentStateReferenceComponent1);
                        SlotReader slotReaderOpenReader2 = slotTable.openReader();
                        try {
                            SlotReader reader = getReader();
                            int[] iArr = this.nodeCountOverrides;
                            IntMap intMap2 = this.providerUpdates;
                            this.nodeCountOverrides = null;
                            this.providerUpdates = null;
                            try {
                                setReader$runtime_release(slotReaderOpenReader2);
                                int iAnchorIndex3 = slotTable.anchorIndex(anchor);
                                slotReaderOpenReader2.reposition(iAnchorIndex3);
                                this.changeListWriter.moveReaderToAbsolute(iAnchorIndex3);
                                changeList3 = new ChangeList();
                                composerChangeListWriter3 = this.changeListWriter;
                                changeList4 = composerChangeListWriter3.getChangeList();
                                try {
                                    composerChangeListWriter3.setChangeList(changeList3);
                                    slotReader = slotReaderOpenReader2;
                                } catch (Throwable th) {
                                    th = th;
                                    intMap = intMap2;
                                    slotReader = slotReaderOpenReader2;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                intMap = intMap2;
                                slotReader = slotReaderOpenReader2;
                            }
                            try {
                                ComposerChangeListWriter composerChangeListWriter6 = this.changeListWriter;
                                i = i5;
                                boolean implicitRootStart = composerChangeListWriter6.getImplicitRootStart();
                                i2 = size;
                                try {
                                    composerChangeListWriter6.setImplicitRootStart(false);
                                    try {
                                        intMap = intMap2;
                                        composerChangeListWriter2 = composerChangeListWriter5;
                                        changeList2 = changeList7;
                                        changeList5 = changeList4;
                                        composerChangeListWriter4 = composerChangeListWriter3;
                                        try {
                                            recomposeMovableContent(movableContentStateReferenceComponent2.getComposition(), movableContentStateReferenceComponent1.getComposition(), Integer.valueOf(slotReader.getCurrentGroup()), movableContentStateReferenceComponent2.getInvalidations$runtime_release(), new Function0<Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$2$1$1$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public /* bridge */ /* synthetic */ Unit invoke() {
                                                    invoke2();
                                                    return Unit.INSTANCE;
                                                }

                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2() {
                                                    this.this$0.invokeMovableContentLambda(movableContentStateReferenceComponent1.getContent$runtime_release(), movableContentStateReferenceComponent1.getLocals(), movableContentStateReferenceComponent1.getParameter(), true);
                                                }
                                            });
                                            try {
                                                composerChangeListWriter6.setImplicitRootStart(implicitRootStart);
                                                try {
                                                    composerChangeListWriter4.setChangeList(changeList5);
                                                    this.changeListWriter.includeOperationsIn(changeList3, intRef);
                                                    Unit unit2 = Unit.INSTANCE;
                                                    try {
                                                        setReader$runtime_release(reader);
                                                        this.nodeCountOverrides = iArr;
                                                        this.providerUpdates = intMap;
                                                        try {
                                                            slotReader.close();
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            composerChangeListWriter = composerChangeListWriter2;
                                                            changeList = changeList2;
                                                            composerChangeListWriter.setChangeList(changeList);
                                                            throw th;
                                                        }
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                        slotReader.close();
                                                        throw th;
                                                    }
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    setReader$runtime_release(reader);
                                                    this.nodeCountOverrides = iArr;
                                                    this.providerUpdates = intMap;
                                                    throw th;
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                                composerChangeListWriter4.setChangeList(changeList5);
                                                throw th;
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                            composerChangeListWriter6.setImplicitRootStart(implicitRootStart);
                                            throw th;
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                        intMap = intMap2;
                                        changeList5 = changeList4;
                                        composerChangeListWriter4 = composerChangeListWriter3;
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                    intMap = intMap2;
                                    composerChangeListWriter4 = composerChangeListWriter3;
                                    changeList5 = changeList4;
                                }
                            } catch (Throwable th10) {
                                th = th10;
                                intMap = intMap2;
                                composerChangeListWriter4 = composerChangeListWriter3;
                                changeList5 = changeList4;
                                composerChangeListWriter4.setChangeList(changeList5);
                                throw th;
                            }
                        } catch (Throwable th11) {
                            th = th11;
                            slotReader = slotReaderOpenReader2;
                        }
                    }
                    this.changeListWriter.skipToEndOfCurrentGroup();
                    i5 = i + 1;
                    size = i2;
                    composerChangeListWriter5 = composerChangeListWriter2;
                    changeList7 = changeList2;
                    i4 = 0;
                } catch (Throwable th12) {
                    th = th12;
                    composerChangeListWriter2 = composerChangeListWriter5;
                    changeList2 = changeList7;
                }
            }
            ComposerChangeListWriter composerChangeListWriter7 = composerChangeListWriter5;
            ChangeList changeList9 = changeList7;
            this.changeListWriter.endMovableContentPlacement();
            this.changeListWriter.moveReaderToAbsolute(0);
            composerChangeListWriter7.setChangeList(changeList9);
        } catch (Throwable th13) {
            th = th13;
            composerChangeListWriter = composerChangeListWriter5;
            changeList = changeList7;
        }
    }

    private final int insertedGroupVirtualIndex(int index) {
        return (-2) - index;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invokeMovableContentLambda(final MovableContent<Object> content, PersistentCompositionLocalMap locals, final Object parameter, boolean force) {
        startMovableGroup(MovableContentKt.movableContentKey, content);
        updateSlot(parameter);
        int compoundKeyHash = getCompoundKeyHash();
        try {
            this.compoundKeyHash = MovableContentKt.movableContentKey;
            boolean z = false;
            if (getInserting()) {
                SlotWriter.markGroup$default(this.writer, 0, 1, null);
            }
            if (!getInserting() && !Intrinsics.areEqual(this.reader.getGroupAux(), locals)) {
                z = true;
            }
            if (z) {
                recordProviderUpdate(locals);
            }
            m17985startBaiHCIY(202, ComposerKt.getCompositionLocalMap(), GroupKind.INSTANCE.m17995getGroupULZAiWs(), locals);
            this.providerCache = null;
            if (!getInserting() || force) {
                boolean z2 = this.providersInvalid;
                this.providersInvalid = z;
                ActualJvm_jvmKt.invokeComposable(this, ComposableLambdaKt.composableLambdaInstance(316014703, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.ComposerImpl.invokeMovableContentLambda.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @Composable
                    public final void invoke(@Nullable Composer composer, int i) {
                        if ((i & 3) == 2 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(316014703, i, -1, "androidx.compose.runtime.ComposerImpl.invokeMovableContentLambda.<anonymous> (Composer.kt:3293)");
                        }
                        content.getContent().invoke(parameter, composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
                this.providersInvalid = z2;
            } else {
                this.writerHasAProvider = true;
                SlotWriter slotWriter = this.writer;
                this.parentContext.insertMovableContent$runtime_release(new MovableContentStateReference(content, parameter, getComposition(), this.insertTable, slotWriter.anchor(slotWriter.parent(slotWriter.getParent())), CollectionsKt.emptyList(), currentCompositionLocalScope()));
            }
            endGroup();
            this.providerCache = null;
            this.compoundKeyHash = compoundKeyHash;
            endMovableGroup();
        } catch (Throwable th) {
            endGroup();
            this.providerCache = null;
            this.compoundKeyHash = compoundKeyHash;
            endMovableGroup();
            throw th;
        }
    }

    private final Object nodeAt(SlotReader slotReader, int i) {
        return slotReader.node(i);
    }

    private final int nodeIndexOf(int groupLocation, int group, int recomposeGroup, int recomposeIndex) {
        int iParent = this.reader.parent(group);
        while (iParent != recomposeGroup && !this.reader.isNode(iParent)) {
            iParent = this.reader.parent(iParent);
        }
        if (this.reader.isNode(iParent)) {
            recomposeIndex = 0;
        }
        if (iParent == group) {
            return recomposeIndex;
        }
        int iUpdatedNodeCount = (updatedNodeCount(iParent) - this.reader.nodeCount(group)) + recomposeIndex;
        loop1: while (recomposeIndex < iUpdatedNodeCount && iParent != groupLocation) {
            iParent++;
            while (iParent < groupLocation) {
                int iGroupSize = this.reader.groupSize(iParent) + iParent;
                if (groupLocation >= iGroupSize) {
                    recomposeIndex += this.reader.isNode(iParent) ? 1 : updatedNodeCount(iParent);
                    iParent = iGroupSize;
                }
            }
            break loop1;
        }
        return recomposeIndex;
    }

    private final int rGroupIndexOf(int group) {
        int iParent = this.reader.parent(group) + 1;
        int i = 0;
        while (iParent < group) {
            if (!this.reader.hasObjectKey(iParent)) {
                i++;
            }
            iParent += this.reader.groupSize(iParent);
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003f A[Catch: all -> 0x0026, TRY_LEAVE, TryCatch #0 {all -> 0x0026, blocks: (B:3:0x0005, B:5:0x0010, B:7:0x0022, B:11:0x002c, B:10:0x0028, B:14:0x0033, B:16:0x0039, B:18:0x003f), top: B:23:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final <R> R recomposeMovableContent(ControlledComposition from, ControlledComposition to, Integer index, List<? extends Pair<RecomposeScopeImpl, ? extends Object>> invalidations, Function0<? extends R> block) {
        R rInvoke;
        boolean z = this.isComposing;
        int i = this.nodeIndex;
        try {
            this.isComposing = true;
            this.nodeIndex = 0;
            int size = invalidations.size();
            for (int i2 = 0; i2 < size; i2++) {
                Pair<RecomposeScopeImpl, ? extends Object> pair = invalidations.get(i2);
                RecomposeScopeImpl recomposeScopeImplComponent1 = pair.component1();
                Object objComponent2 = pair.component2();
                if (objComponent2 != null) {
                    tryImminentInvalidation$runtime_release(recomposeScopeImplComponent1, objComponent2);
                } else {
                    tryImminentInvalidation$runtime_release(recomposeScopeImplComponent1, null);
                }
            }
            if (from == null) {
                rInvoke = block.invoke();
            } else {
                rInvoke = (R) from.delegateInvalidations(to, index != null ? index.intValue() : -1, block);
                if (rInvoke == null) {
                }
            }
            this.isComposing = z;
            this.nodeIndex = i;
            return rInvoke;
        } catch (Throwable th) {
            this.isComposing = z;
            this.nodeIndex = i;
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object recomposeMovableContent$default(ComposerImpl composerImpl, ControlledComposition controlledComposition, ControlledComposition controlledComposition2, Integer num, List list, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            controlledComposition = null;
        }
        if ((i & 2) != 0) {
            controlledComposition2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            list = CollectionsKt.emptyList();
        }
        return composerImpl.recomposeMovableContent(controlledComposition, controlledComposition2, num, list, function0);
    }

    private final void recomposeToGroupEnd() {
        boolean z = this.isComposing;
        this.isComposing = true;
        int parent = this.reader.getParent();
        int iGroupSize = this.reader.groupSize(parent) + parent;
        int i = this.nodeIndex;
        int compoundKeyHash = getCompoundKeyHash();
        int i2 = this.groupNodeCount;
        int i4 = this.rGroupIndex;
        Invalidation invalidationFirstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), iGroupSize);
        boolean z2 = false;
        int i5 = parent;
        while (invalidationFirstInRange != null) {
            int location = invalidationFirstInRange.getLocation();
            ComposerKt.removeLocation(this.invalidations, location);
            if (invalidationFirstInRange.isInvalid()) {
                this.reader.reposition(location);
                int currentGroup = this.reader.getCurrentGroup();
                recordUpsAndDowns(i5, currentGroup, parent);
                this.nodeIndex = nodeIndexOf(location, currentGroup, parent, i);
                this.rGroupIndex = rGroupIndexOf(currentGroup);
                int iParent = this.reader.parent(currentGroup);
                this.compoundKeyHash = compoundKeyOf(iParent, rGroupIndexOf(iParent), parent, compoundKeyHash);
                this.providerCache = null;
                invalidationFirstInRange.getScope().compose(this);
                this.providerCache = null;
                this.reader.restoreParent(parent);
                i5 = currentGroup;
                z2 = true;
            } else {
                this.invalidateStack.push(invalidationFirstInRange.getScope());
                invalidationFirstInRange.getScope().rereadTrackedInstances();
                this.invalidateStack.pop();
            }
            invalidationFirstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), iGroupSize);
        }
        if (z2) {
            recordUpsAndDowns(i5, parent, parent);
            this.reader.skipToGroupEnd();
            int iUpdatedNodeCount = updatedNodeCount(parent);
            this.nodeIndex = i + iUpdatedNodeCount;
            this.groupNodeCount = i2 + iUpdatedNodeCount;
            this.rGroupIndex = i4;
        } else {
            skipReaderToGroupEnd();
        }
        this.compoundKeyHash = compoundKeyHash;
        this.isComposing = z;
    }

    private final void recordDelete() {
        reportFreeMovableContent(this.reader.getCurrentGroup());
        this.changeListWriter.removeCurrentGroup();
    }

    private final void recordInsert(Anchor anchor) {
        if (this.insertFixups.isEmpty()) {
            this.changeListWriter.insertSlots(anchor, this.insertTable);
        } else {
            this.changeListWriter.insertSlots(anchor, this.insertTable, this.insertFixups);
            this.insertFixups = new FixupList();
        }
    }

    private final void recordProviderUpdate(PersistentCompositionLocalMap providers) {
        IntMap<PersistentCompositionLocalMap> intMap = this.providerUpdates;
        if (intMap == null) {
            intMap = new IntMap<>(0, 1, null);
            this.providerUpdates = intMap;
        }
        intMap.set(this.reader.getCurrentGroup(), providers);
    }

    private final void recordUpsAndDowns(int oldGroup, int newGroup, int commonRoot) {
        SlotReader slotReader = this.reader;
        int iNearestCommonRootOf = ComposerKt.nearestCommonRootOf(slotReader, oldGroup, newGroup, commonRoot);
        while (oldGroup > 0 && oldGroup != iNearestCommonRootOf) {
            if (slotReader.isNode(oldGroup)) {
                this.changeListWriter.moveUp();
            }
            oldGroup = slotReader.parent(oldGroup);
        }
        doRecordDownsFor(newGroup, iNearestCommonRootOf);
    }

    private final Anchor rememberObserverAnchor() {
        int i;
        int i2;
        if (getInserting()) {
            if (!ComposerKt.isAfterFirstChild(this.writer)) {
                return null;
            }
            int currentGroup = this.writer.getCurrentGroup() - 1;
            int iParent = this.writer.parent(currentGroup);
            while (true) {
                int i4 = iParent;
                i2 = currentGroup;
                currentGroup = i4;
                if (currentGroup == this.writer.getParent() || currentGroup < 0) {
                    break;
                }
                iParent = this.writer.parent(currentGroup);
            }
            return this.writer.anchor(i2);
        }
        if (!ComposerKt.isAfterFirstChild(this.reader)) {
            return null;
        }
        int currentGroup2 = this.reader.getCurrentGroup() - 1;
        int iParent2 = this.reader.parent(currentGroup2);
        while (true) {
            int i5 = iParent2;
            i = currentGroup2;
            currentGroup2 = i5;
            if (currentGroup2 == this.reader.getParent() || currentGroup2 < 0) {
                break;
            }
            iParent2 = this.reader.parent(currentGroup2);
        }
        return this.reader.anchor(i);
    }

    private final void reportAllMovableContent() {
        if (this.slotTable.containsMark()) {
            ChangeList changeList = new ChangeList();
            this.deferredChanges = changeList;
            SlotReader slotReaderOpenReader = this.slotTable.openReader();
            try {
                this.reader = slotReaderOpenReader;
                ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
                ChangeList changeList2 = composerChangeListWriter.getChangeList();
                try {
                    composerChangeListWriter.setChangeList(changeList);
                    reportFreeMovableContent(0);
                    this.changeListWriter.releaseMovableContent();
                    composerChangeListWriter.setChangeList(changeList2);
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    composerChangeListWriter.setChangeList(changeList2);
                    throw th;
                }
            } finally {
                slotReaderOpenReader.close();
            }
        }
    }

    private final void reportFreeMovableContent(int groupBeingRemoved) {
        reportFreeMovableContent$reportGroup(this, groupBeingRemoved, false, 0);
        this.changeListWriter.endNodeMovement();
    }

    private static final int reportFreeMovableContent$reportGroup(ComposerImpl composerImpl, int i, boolean z, int i2) {
        SlotReader slotReader = composerImpl.reader;
        if (!slotReader.hasMark(i)) {
            if (!slotReader.containsMark(i)) {
                if (slotReader.isNode(i)) {
                    return 1;
                }
                return slotReader.nodeCount(i);
            }
            int iGroupSize = slotReader.groupSize(i) + i;
            int iReportFreeMovableContent$reportGroup = 0;
            for (int iGroupSize2 = i + 1; iGroupSize2 < iGroupSize; iGroupSize2 += slotReader.groupSize(iGroupSize2)) {
                boolean zIsNode = slotReader.isNode(iGroupSize2);
                if (zIsNode) {
                    composerImpl.changeListWriter.endNodeMovement();
                    composerImpl.changeListWriter.moveDown(slotReader.node(iGroupSize2));
                }
                iReportFreeMovableContent$reportGroup += reportFreeMovableContent$reportGroup(composerImpl, iGroupSize2, zIsNode || z, zIsNode ? 0 : i2 + iReportFreeMovableContent$reportGroup);
                if (zIsNode) {
                    composerImpl.changeListWriter.endNodeMovement();
                    composerImpl.changeListWriter.moveUp();
                }
            }
            if (slotReader.isNode(i)) {
                return 1;
            }
            return iReportFreeMovableContent$reportGroup;
        }
        int iGroupKey = slotReader.groupKey(i);
        Object objGroupObjectKey = slotReader.groupObjectKey(i);
        if (iGroupKey != 126665345 || !(objGroupObjectKey instanceof MovableContent)) {
            if (iGroupKey != 206 || !Intrinsics.areEqual(objGroupObjectKey, ComposerKt.getReference())) {
                if (slotReader.isNode(i)) {
                    return 1;
                }
                return slotReader.nodeCount(i);
            }
            Object objGroupGet = slotReader.groupGet(i, 0);
            CompositionContextHolder compositionContextHolder = objGroupGet instanceof CompositionContextHolder ? (CompositionContextHolder) objGroupGet : null;
            if (compositionContextHolder != null) {
                for (ComposerImpl composerImpl2 : compositionContextHolder.getRef().getComposers()) {
                    composerImpl2.reportAllMovableContent();
                    composerImpl.parentContext.reportRemovedComposition$runtime_release(composerImpl2.getComposition());
                }
            }
            return slotReader.nodeCount(i);
        }
        MovableContent movableContent = (MovableContent) objGroupObjectKey;
        Object objGroupGet2 = slotReader.groupGet(i, 0);
        Anchor anchor = slotReader.anchor(i);
        List listFilterToRange = ComposerKt.filterToRange(composerImpl.invalidations, i, slotReader.groupSize(i) + i);
        ArrayList arrayList = new ArrayList(listFilterToRange.size());
        int size = listFilterToRange.size();
        for (int i4 = 0; i4 < size; i4++) {
            Invalidation invalidation = (Invalidation) listFilterToRange.get(i4);
            arrayList.add(TuplesKt.m13893to(invalidation.getScope(), invalidation.getInstances()));
        }
        MovableContentStateReference movableContentStateReference = new MovableContentStateReference(movableContent, objGroupGet2, composerImpl.getComposition(), composerImpl.slotTable, anchor, arrayList, composerImpl.currentCompositionLocalScope(i));
        composerImpl.parentContext.deletedMovableContent$runtime_release(movableContentStateReference);
        composerImpl.changeListWriter.recordSlotEditing();
        composerImpl.changeListWriter.releaseMovableGroupAtCurrent(composerImpl.getComposition(), composerImpl.parentContext, movableContentStateReference);
        if (!z) {
            return slotReader.nodeCount(i);
        }
        composerImpl.changeListWriter.endNodeMovementAndDeleteNode(i2, i);
        return 0;
    }

    private final void skipGroup() {
        this.groupNodeCount = this.reader.skipGroup() + this.groupNodeCount;
    }

    private final void skipReaderToGroupEnd() {
        this.groupNodeCount = this.reader.getParentNodes();
        this.reader.skipToGroupEnd();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d5  */
    /* JADX INFO: renamed from: start-BaiHCIY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m17985startBaiHCIY(int key, Object objectKey, int kind, Object data) {
        int iRotateLeft;
        validateNodeNotExpected();
        int i = this.rGroupIndex;
        if (objectKey != null) {
            iRotateLeft = Integer.rotateLeft((objectKey instanceof Enum ? ((Enum) objectKey).ordinal() : objectKey.hashCode()) ^ Integer.rotateLeft(getCompoundKeyHash(), 3), 3);
        } else {
            if (data != null && key == 207 && !Intrinsics.areEqual(data, Composer.INSTANCE.getEmpty())) {
                this.compoundKeyHash = i ^ Integer.rotateLeft(data.hashCode() ^ Integer.rotateLeft(getCompoundKeyHash(), 3), 3);
                if (objectKey == null) {
                    this.rGroupIndex++;
                }
                GroupKind.Companion companion = GroupKind.INSTANCE;
                boolean z = kind == companion.m17995getGroupULZAiWs();
                Pending pending = null;
                if (!getInserting()) {
                    this.reader.beginEmpty();
                    int currentGroup = this.writer.getCurrentGroup();
                    if (z) {
                        this.writer.startNode(key, Composer.INSTANCE.getEmpty());
                    } else if (data != null) {
                        SlotWriter slotWriter = this.writer;
                        if (objectKey == null) {
                            objectKey = Composer.INSTANCE.getEmpty();
                        }
                        slotWriter.startData(key, objectKey, data);
                    } else {
                        SlotWriter slotWriter2 = this.writer;
                        if (objectKey == null) {
                            objectKey = Composer.INSTANCE.getEmpty();
                        }
                        slotWriter2.startGroup(key, objectKey);
                    }
                    Pending pending2 = this.pending;
                    if (pending2 != null) {
                        KeyInfo keyInfo = new KeyInfo(key, -1, insertedGroupVirtualIndex(currentGroup), -1, 0);
                        pending2.registerInsert(keyInfo, this.nodeIndex - pending2.getStartIndex());
                        pending2.recordUsed(keyInfo);
                    }
                    enterGroup(z, null);
                    return;
                }
                boolean z2 = kind == companion.m17996getNodeULZAiWs() && this.reusing;
                if (this.pending == null) {
                    int groupKey = this.reader.getGroupKey();
                    if (!z2 && groupKey == key && Intrinsics.areEqual(objectKey, this.reader.getGroupObjectKey())) {
                        startReaderGroup(z, data);
                    } else {
                        this.pending = new Pending(this.reader.extractKeys(), this.nodeIndex);
                    }
                }
                Pending pending3 = this.pending;
                if (pending3 != null) {
                    KeyInfo next = pending3.getNext(key, objectKey);
                    if (z2 || next == null) {
                        this.reader.beginEmpty();
                        this.inserting = true;
                        this.providerCache = null;
                        ensureWriter();
                        this.writer.beginInsert();
                        int currentGroup2 = this.writer.getCurrentGroup();
                        if (z) {
                            this.writer.startNode(key, Composer.INSTANCE.getEmpty());
                        } else if (data != null) {
                            SlotWriter slotWriter3 = this.writer;
                            if (objectKey == null) {
                                objectKey = Composer.INSTANCE.getEmpty();
                            }
                            slotWriter3.startData(key, objectKey, data);
                        } else {
                            SlotWriter slotWriter4 = this.writer;
                            if (objectKey == null) {
                                objectKey = Composer.INSTANCE.getEmpty();
                            }
                            slotWriter4.startGroup(key, objectKey);
                        }
                        this.insertAnchor = this.writer.anchor(currentGroup2);
                        KeyInfo keyInfo2 = new KeyInfo(key, -1, insertedGroupVirtualIndex(currentGroup2), -1, 0);
                        pending3.registerInsert(keyInfo2, this.nodeIndex - pending3.getStartIndex());
                        pending3.recordUsed(keyInfo2);
                        pending = new Pending(new ArrayList(), z ? 0 : this.nodeIndex);
                    } else {
                        pending3.recordUsed(next);
                        int location = next.getLocation();
                        this.nodeIndex = pending3.nodePositionOf(next) + pending3.getStartIndex();
                        int iSlotPositionOf = pending3.slotPositionOf(next);
                        int groupIndex = iSlotPositionOf - pending3.getGroupIndex();
                        pending3.registerMoveSlot(iSlotPositionOf, pending3.getGroupIndex());
                        this.changeListWriter.moveReaderRelativeTo(location);
                        this.reader.reposition(location);
                        if (groupIndex > 0) {
                            this.changeListWriter.moveCurrentGroup(groupIndex);
                        }
                        startReaderGroup(z, data);
                    }
                }
                enterGroup(z, pending);
                return;
            }
            iRotateLeft = i ^ Integer.rotateLeft(Integer.rotateLeft(getCompoundKeyHash(), 3) ^ key, 3);
        }
        this.compoundKeyHash = iRotateLeft;
        if (objectKey == null) {
        }
        GroupKind.Companion companion2 = GroupKind.INSTANCE;
        if (kind == companion2.m17995getGroupULZAiWs()) {
        }
        Pending pending4 = null;
        if (!getInserting()) {
        }
    }

    private final void startGroup(int key) {
        m17985startBaiHCIY(key, null, GroupKind.INSTANCE.m17995getGroupULZAiWs(), null);
    }

    private final void startReaderGroup(boolean isNode, Object data) {
        if (isNode) {
            this.reader.startNode();
            return;
        }
        if (data != null && this.reader.getGroupAux() != data) {
            this.changeListWriter.updateAuxData(data);
        }
        this.reader.startGroup();
    }

    private final void startRoot() {
        this.rGroupIndex = 0;
        this.reader = this.slotTable.openReader();
        startGroup(100);
        this.parentContext.startComposing$runtime_release();
        this.parentProvider = this.parentContext.getCompositionLocalScope$runtime_release();
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = changed(this.parentProvider);
        this.providerCache = null;
        if (!this.forceRecomposeScopes) {
            this.forceRecomposeScopes = this.parentContext.getCollectingParameterInformation();
        }
        if (!this.sourceMarkersEnabled) {
            this.sourceMarkersEnabled = this.parentContext.getCollectingSourceInformation();
        }
        Set<CompositionData> set = (Set) CompositionLocalMapKt.read(this.parentProvider, InspectionTablesKt.getLocalInspectionTables());
        if (set != null) {
            set.add(this.slotTable);
            this.parentContext.recordInspectionTable$runtime_release(set);
        }
        startGroup(this.parentContext.getCompoundHashKey());
    }

    private final void updateCompoundKeyWhenWeEnterGroup(int groupKey, int rGroupIndex, Object dataKey, Object data) {
        if (dataKey != null) {
            if (dataKey instanceof Enum) {
                this.compoundKeyHash = Integer.rotateLeft(((Enum) dataKey).ordinal() ^ Integer.rotateLeft(getCompoundKeyHash(), 3), 3);
                return;
            } else {
                this.compoundKeyHash = Integer.rotateLeft(dataKey.hashCode() ^ Integer.rotateLeft(getCompoundKeyHash(), 3), 3);
                return;
            }
        }
        if (data == null || groupKey != 207 || Intrinsics.areEqual(data, Composer.INSTANCE.getEmpty())) {
            this.compoundKeyHash = Integer.rotateLeft(groupKey ^ Integer.rotateLeft(getCompoundKeyHash(), 3), 3) ^ rGroupIndex;
        } else {
            this.compoundKeyHash = Integer.rotateLeft(data.hashCode() ^ Integer.rotateLeft(getCompoundKeyHash(), 3), 3) ^ rGroupIndex;
        }
    }

    private final void updateCompoundKeyWhenWeEnterGroupKeyHash(int keyHash, int rGroupIndex) {
        this.compoundKeyHash = Integer.rotateLeft(keyHash ^ Integer.rotateLeft(getCompoundKeyHash(), 3), 3) ^ rGroupIndex;
    }

    private final void updateCompoundKeyWhenWeExitGroup(int groupKey, int rGroupIndex, Object dataKey, Object data) {
        if (dataKey != null) {
            if (dataKey instanceof Enum) {
                int iOrdinal = ((Enum) dataKey).ordinal();
                this.compoundKeyHash = Integer.rotateRight(Integer.hashCode(iOrdinal) ^ Integer.rotateRight(getCompoundKeyHash(), 3), 3);
                return;
            } else {
                int iHashCode = dataKey.hashCode();
                this.compoundKeyHash = Integer.rotateRight(Integer.hashCode(iHashCode) ^ Integer.rotateRight(getCompoundKeyHash(), 3), 3);
                return;
            }
        }
        if (data == null || groupKey != 207 || Intrinsics.areEqual(data, Composer.INSTANCE.getEmpty())) {
            this.compoundKeyHash = Integer.rotateRight(Integer.hashCode(groupKey) ^ Integer.rotateRight(rGroupIndex ^ getCompoundKeyHash(), 3), 3);
        } else {
            int iHashCode2 = data.hashCode();
            this.compoundKeyHash = Integer.rotateRight(Integer.hashCode(iHashCode2) ^ Integer.rotateRight(rGroupIndex ^ getCompoundKeyHash(), 3), 3);
        }
    }

    private final void updateCompoundKeyWhenWeExitGroupKeyHash(int groupKey, int rGroupIndex) {
        this.compoundKeyHash = Integer.rotateRight(Integer.hashCode(groupKey) ^ Integer.rotateRight(rGroupIndex ^ getCompoundKeyHash(), 3), 3);
    }

    private final void updateNodeCount(int group, int count) {
        if (updatedNodeCount(group) != count) {
            if (group < 0) {
                MutableIntIntMap mutableIntIntMap = this.nodeCountVirtualOverrides;
                if (mutableIntIntMap == null) {
                    mutableIntIntMap = new MutableIntIntMap(0, 1, null);
                    this.nodeCountVirtualOverrides = mutableIntIntMap;
                }
                mutableIntIntMap.set(group, count);
                return;
            }
            int[] iArr = this.nodeCountOverrides;
            if (iArr == null) {
                iArr = new int[this.reader.getGroupsSize()];
                ArraysKt___ArraysJvmKt.fill$default(iArr, -1, 0, 0, 6, (Object) null);
                this.nodeCountOverrides = iArr;
            }
            iArr[group] = count;
        }
    }

    private final void updateNodeCountOverrides(int group, int newCount) {
        int iUpdatedNodeCount = updatedNodeCount(group);
        if (iUpdatedNodeCount != newCount) {
            int i = newCount - iUpdatedNodeCount;
            int size = this.pendingStack.getSize() - 1;
            while (group != -1) {
                int iUpdatedNodeCount2 = updatedNodeCount(group) + i;
                updateNodeCount(group, iUpdatedNodeCount2);
                int i2 = size;
                while (true) {
                    if (-1 < i2) {
                        Pending pendingPeek = this.pendingStack.peek(i2);
                        if (pendingPeek != null && pendingPeek.updateNodeCount(group, iUpdatedNodeCount2)) {
                            size = i2 - 1;
                            break;
                        }
                        i2--;
                    } else {
                        break;
                    }
                }
                if (group < 0) {
                    group = this.reader.getParent();
                } else if (this.reader.isNode(group)) {
                    return;
                } else {
                    group = this.reader.parent(group);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.compose.runtime.PersistentCompositionLocalMap, java.lang.Object] */
    private final PersistentCompositionLocalMap updateProviderMapGroup(PersistentCompositionLocalMap parentScope, PersistentCompositionLocalMap currentProviders) {
        PersistentMap.Builder<CompositionLocal<Object>, ValueHolder<Object>> builderBuilder2 = parentScope.builder2();
        builderBuilder2.putAll(currentProviders);
        ?? Build2 = builderBuilder2.build2();
        startGroup(204, ComposerKt.getProviderMaps());
        updateSlot(Build2);
        updateSlot(currentProviders);
        endGroup();
        return Build2;
    }

    private final void updateSlot(Object value) {
        nextSlot();
        updateValue(value);
    }

    private final int updatedNodeCount(int group) {
        int i;
        if (group >= 0) {
            int[] iArr = this.nodeCountOverrides;
            return (iArr == null || (i = iArr[group]) < 0) ? this.reader.nodeCount(group) : i;
        }
        MutableIntIntMap mutableIntIntMap = this.nodeCountVirtualOverrides;
        if (mutableIntIntMap == null || !mutableIntIntMap.contains(group)) {
            return 0;
        }
        return mutableIntIntMap.get(group);
    }

    private final void validateNodeExpected() {
        if (!this.nodeExpected) {
            ComposerKt.composeImmediateRuntimeError("A call to createNode(), emitNode() or useNode() expected was not expected");
        }
        this.nodeExpected = false;
    }

    private final void validateNodeNotExpected() {
        if (this.nodeExpected) {
            ComposerKt.composeImmediateRuntimeError("A call to createNode(), emitNode() or useNode() expected");
        }
    }

    private final <R> R withReader(SlotReader reader, Function0<? extends R> block) {
        SlotReader reader2 = getReader();
        int[] iArr = this.nodeCountOverrides;
        IntMap intMap = this.providerUpdates;
        this.nodeCountOverrides = null;
        this.providerUpdates = null;
        try {
            setReader$runtime_release(reader);
            return block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            setReader$runtime_release(reader2);
            this.nodeCountOverrides = iArr;
            this.providerUpdates = intMap;
            InlineMarker.finallyEnd(1);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public <V, T> void apply(V value, @NotNull Function2<? super T, ? super V, Unit> block) {
        if (getInserting()) {
            this.insertFixups.updateNode(value, block);
        } else {
            this.changeListWriter.updateNode(value, block);
        }
    }

    @Override // androidx.compose.runtime.Composer
    @NotNull
    public CompositionContext buildContext() {
        startGroup(206, ComposerKt.getReference());
        if (getInserting()) {
            SlotWriter.markGroup$default(this.writer, 0, 1, null);
        }
        Object objNextSlot = nextSlot();
        CompositionContextHolder compositionContextHolder = objNextSlot instanceof CompositionContextHolder ? (CompositionContextHolder) objNextSlot : null;
        if (compositionContextHolder == null) {
            int compoundKeyHash = getCompoundKeyHash();
            boolean z = this.forceRecomposeScopes;
            boolean z2 = this.sourceMarkersEnabled;
            ControlledComposition composition = getComposition();
            CompositionImpl compositionImpl = composition instanceof CompositionImpl ? (CompositionImpl) composition : null;
            compositionContextHolder = new CompositionContextHolder(new CompositionContextImpl(compoundKeyHash, z, z2, compositionImpl != null ? compositionImpl.getObserverHolder() : null));
            updateValue(compositionContextHolder);
        }
        compositionContextHolder.getRef().updateCompositionLocalScope(currentCompositionLocalScope());
        endGroup();
        return compositionContextHolder.getRef();
    }

    @ComposeCompilerApi
    public final <T> T cache(boolean invalid, @NotNull Function0<? extends T> block) {
        T t = (T) nextSlotForCache();
        if (t != Composer.INSTANCE.getEmpty() && !invalid) {
            return t;
        }
        T tInvoke = block.invoke();
        updateCachedValue(tInvoke);
        return tInvoke;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(@Nullable Object value) {
        if (Intrinsics.areEqual(nextSlot(), value)) {
            return false;
        }
        updateValue(value);
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changedInstance(@Nullable Object value) {
        if (nextSlot() == value) {
            return false;
        }
        updateValue(value);
        return true;
    }

    public final void changesApplied$runtime_release() {
        this.providerUpdates = null;
    }

    @Override // androidx.compose.runtime.Composer
    public void collectParameterInformation() {
        this.forceRecomposeScopes = true;
        this.sourceMarkersEnabled = true;
        this.slotTable.collectSourceInformation();
        this.insertTable.collectSourceInformation();
        this.writer.updateToTableMaps();
    }

    public final void composeContent$runtime_release(@NotNull ScopeMap<RecomposeScopeImpl, Object> invalidationsRequested, @NotNull Function2<? super Composer, ? super Integer, Unit> content) {
        if (!this.changes.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
        }
        doCompose(invalidationsRequested, content);
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public <T> T consume(@NotNull CompositionLocal<T> key) {
        return (T) CompositionLocalMapKt.read(currentCompositionLocalScope(), key);
    }

    @Override // androidx.compose.runtime.Composer
    public <T> void createNode(@NotNull Function0<? extends T> factory) {
        validateNodeExpected();
        if (!getInserting()) {
            ComposerKt.composeImmediateRuntimeError("createNode() can only be called when inserting");
        }
        int iPeek = this.parentStateStack.peek();
        SlotWriter slotWriter = this.writer;
        Anchor anchor = slotWriter.anchor(slotWriter.getParent());
        this.groupNodeCount++;
        this.insertFixups.createAndInsertNode(factory, iPeek, anchor);
    }

    public final void deactivate$runtime_release() {
        this.invalidateStack.clear();
        this.invalidations.clear();
        this.changes.clear();
        this.providerUpdates = null;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void deactivateToEndGroup(boolean changed) {
        if (!(this.groupNodeCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("No nodes can be emitted before calling dactivateToEndGroup");
        }
        if (getInserting()) {
            return;
        }
        if (!changed) {
            skipReaderToGroupEnd();
            return;
        }
        int currentGroup = this.reader.getCurrentGroup();
        int currentEnd = this.reader.getCurrentEnd();
        this.changeListWriter.deactivateCurrentGroup();
        ComposerKt.removeRange(this.invalidations, currentGroup, currentEnd);
        this.reader.skipToGroupEnd();
    }

    @Override // androidx.compose.runtime.Composer
    public void disableReusing() {
        this.reusing = false;
    }

    @Override // androidx.compose.runtime.Composer
    public void disableSourceInformation() {
        this.sourceMarkersEnabled = false;
    }

    public final void dispose$runtime_release() {
        Trace trace = Trace.INSTANCE;
        Object objBeginSection = trace.beginSection("Compose:Composer.dispose");
        try {
            this.parentContext.unregisterComposer$runtime_release(this);
            deactivate$runtime_release();
            getApplier().clear();
            this.isDisposed = true;
            Unit unit = Unit.INSTANCE;
            trace.endSection(objBeginSection);
        } catch (Throwable th) {
            Trace.INSTANCE.endSection(objBeginSection);
            throw th;
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void enableReusing() {
        this.reusing = this.reusingGroup >= 0;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endDefaults() {
        endGroup();
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release == null || !currentRecomposeScope$runtime_release.getUsed()) {
            return;
        }
        currentRecomposeScope$runtime_release.setDefaultsInScope(true);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endMovableGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    public void endNode() {
        end(true);
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void endProvider() {
        endGroup();
        endGroup();
        this.providersInvalid = ComposerKt.asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void endProviders() {
        endGroup();
        endGroup();
        this.providersInvalid = ComposerKt.asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endReplaceGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endReplaceableGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    @Nullable
    public ScopeUpdateScope endRestartGroup() {
        Anchor anchor;
        Function1<Composition, Unit> function1End;
        RecomposeScopeImpl recomposeScopeImpl = null;
        RecomposeScopeImpl recomposeScopeImplPop = this.invalidateStack.isNotEmpty() ? this.invalidateStack.pop() : null;
        if (recomposeScopeImplPop != null) {
            recomposeScopeImplPop.setRequiresRecompose(false);
        }
        if (recomposeScopeImplPop != null && (function1End = recomposeScopeImplPop.end(this.compositionToken)) != null) {
            this.changeListWriter.endCompositionScope(function1End, getComposition());
        }
        if (recomposeScopeImplPop != null && !recomposeScopeImplPop.getSkipped$runtime_release() && (recomposeScopeImplPop.getUsed() || this.forceRecomposeScopes)) {
            if (recomposeScopeImplPop.getAnchor() == null) {
                if (getInserting()) {
                    SlotWriter slotWriter = this.writer;
                    anchor = slotWriter.anchor(slotWriter.getParent());
                } else {
                    SlotReader slotReader = this.reader;
                    anchor = slotReader.anchor(slotReader.getParent());
                }
                recomposeScopeImplPop.setAnchor(anchor);
            }
            recomposeScopeImplPop.setDefaultsInvalid(false);
            recomposeScopeImpl = recomposeScopeImplPop;
        }
        end(false);
        return recomposeScopeImpl;
    }

    @Override // androidx.compose.runtime.Composer
    public void endReusableGroup() {
        if (this.reusing && this.reader.getParent() == this.reusingGroup) {
            this.reusingGroup = -1;
            this.reusing = false;
        }
        end(false);
    }

    public final void endReuseFromRoot() {
        if (!(!this.isComposing && this.reusingGroup == 100)) {
            PreconditionsKt.throwIllegalArgumentException("Cannot disable reuse from root if it was caused by other groups");
        }
        this.reusingGroup = -1;
        this.reusing = false;
    }

    @Override // androidx.compose.runtime.Composer
    public void endToMarker(int marker) {
        if (marker < 0) {
            int i = -marker;
            SlotWriter slotWriter = this.writer;
            while (true) {
                int parent = slotWriter.getParent();
                if (parent <= i) {
                    return;
                } else {
                    end(slotWriter.isNode(parent));
                }
            }
        } else {
            if (getInserting()) {
                SlotWriter slotWriter2 = this.writer;
                while (getInserting()) {
                    end(slotWriter2.isNode(slotWriter2.getParent()));
                }
            }
            SlotReader slotReader = this.reader;
            while (true) {
                int parent2 = slotReader.getParent();
                if (parent2 <= marker) {
                    return;
                } else {
                    end(slotReader.isNode(parent2));
                }
            }
        }
    }

    public final boolean forceRecomposeScopes$runtime_release() {
        if (this.forceRecomposeScopes) {
            return false;
        }
        this.forceRecomposeScopes = true;
        this.forciblyRecompose = true;
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @NotNull
    public Applier<?> getApplier() {
        return this.applier;
    }

    @Override // androidx.compose.runtime.Composer
    @TestOnly
    @NotNull
    public CoroutineContext getApplyCoroutineContext() {
        return this.parentContext.getEffectCoroutineContext();
    }

    public final boolean getAreChildrenComposing$runtime_release() {
        return this.childrenComposing > 0;
    }

    public final int getChangeCount$runtime_release() {
        return this.changes.getSize();
    }

    @Override // androidx.compose.runtime.Composer
    @NotNull
    public ControlledComposition getComposition() {
        return this.composition;
    }

    @Override // androidx.compose.runtime.Composer
    @NotNull
    public CompositionData getCompositionData() {
        return this.slotTable;
    }

    @Override // androidx.compose.runtime.Composer
    public int getCompoundKeyHash() {
        return this.compoundKeyHash;
    }

    @Override // androidx.compose.runtime.Composer
    @NotNull
    public CompositionLocalMap getCurrentCompositionLocalMap() {
        return currentCompositionLocalScope();
    }

    @Override // androidx.compose.runtime.Composer
    public int getCurrentMarker() {
        return getInserting() ? -this.writer.getParent() : this.reader.getParent();
    }

    @Nullable
    public final RecomposeScopeImpl getCurrentRecomposeScope$runtime_release() {
        Stack<RecomposeScopeImpl> stack = this.invalidateStack;
        if (this.childrenComposing == 0 && stack.isNotEmpty()) {
            return stack.peek();
        }
        return null;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getDefaultsInvalid() {
        RecomposeScopeImpl currentRecomposeScope$runtime_release;
        return !getSkipping() || this.providersInvalid || ((currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release()) != null && currentRecomposeScope$runtime_release.getDefaultsInvalid());
    }

    @Nullable
    /* JADX INFO: renamed from: getDeferredChanges$runtime_release, reason: from getter */
    public final ChangeList getDeferredChanges() {
        return this.deferredChanges;
    }

    public final boolean getHasInvalidations() {
        return !this.invalidations.isEmpty();
    }

    public final boolean getHasPendingChanges$runtime_release() {
        return this.changes.isNotEmpty();
    }

    @NotNull
    /* JADX INFO: renamed from: getInsertTable$runtime_release, reason: from getter */
    public final SlotTable getInsertTable() {
        return this.insertTable;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getInserting() {
        return this.inserting;
    }

    @NotNull
    /* JADX INFO: renamed from: getReader$runtime_release, reason: from getter */
    public final SlotReader getReader() {
        return this.reader;
    }

    @Override // androidx.compose.runtime.Composer
    @Nullable
    public RecomposeScope getRecomposeScope() {
        return getCurrentRecomposeScope$runtime_release();
    }

    @Override // androidx.compose.runtime.Composer
    @Nullable
    public Object getRecomposeScopeIdentity() {
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release != null) {
            return currentRecomposeScope$runtime_release.getAnchor();
        }
        return null;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getSkipping() {
        RecomposeScopeImpl currentRecomposeScope$runtime_release;
        return (getInserting() || this.reusing || this.providersInvalid || (currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release()) == null || currentRecomposeScope$runtime_release.getRequiresRecompose() || this.forciblyRecompose) ? false : true;
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void insertMovableContent(@NotNull MovableContent<?> value, @Nullable Object parameter) {
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.MovableContent<kotlin.Any?>");
        invokeMovableContentLambda(value, currentCompositionLocalScope(), parameter, false);
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void insertMovableContentReferences(@NotNull List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        try {
            insertMovableContentGuarded(references);
            cleanUpCompose();
        } catch (Throwable th) {
            abortRoot();
            throw th;
        }
    }

    /* JADX INFO: renamed from: isComposing$runtime_release, reason: from getter */
    public final boolean getIsComposing() {
        return this.isComposing;
    }

    /* JADX INFO: renamed from: isDisposed$runtime_release, reason: from getter */
    public final boolean getIsDisposed() {
        return this.isDisposed;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    @NotNull
    public Object joinKey(@Nullable Object left, @Nullable Object right) {
        Object key = ComposerKt.getKey(this.reader.getGroupObjectKey(), left, right);
        return key == null ? new JoinedKey(left, right) : key;
    }

    @PublishedApi
    @Nullable
    public final Object nextSlot() {
        if (getInserting()) {
            validateNodeNotExpected();
            return Composer.INSTANCE.getEmpty();
        }
        Object next = this.reader.next();
        return (!this.reusing || (next instanceof ReusableRememberObserver)) ? next : Composer.INSTANCE.getEmpty();
    }

    @PublishedApi
    @Nullable
    public final Object nextSlotForCache() {
        if (getInserting()) {
            validateNodeNotExpected();
            return Composer.INSTANCE.getEmpty();
        }
        Object next = this.reader.next();
        return (!this.reusing || (next instanceof ReusableRememberObserver)) ? next instanceof RememberObserverHolder ? ((RememberObserverHolder) next).getWrapped() : next : Composer.INSTANCE.getEmpty();
    }

    @TestOnly
    public final int parentKey$runtime_release() {
        if (getInserting()) {
            SlotWriter slotWriter = this.writer;
            return slotWriter.groupKey(slotWriter.getParent());
        }
        SlotReader slotReader = this.reader;
        return slotReader.groupKey(slotReader.getParent());
    }

    public final void prepareCompose$runtime_release(@NotNull Function0<Unit> block) {
        if (this.isComposing) {
            ComposerKt.composeImmediateRuntimeError("Preparing a composition while composing is not supported");
        }
        this.isComposing = true;
        try {
            block.invoke();
        } finally {
            this.isComposing = false;
        }
    }

    public final boolean recompose$runtime_release(@NotNull ScopeMap<RecomposeScopeImpl, Object> invalidationsRequested) {
        if (!this.changes.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
        }
        if (invalidationsRequested.getSize() <= 0 && this.invalidations.isEmpty() && !this.forciblyRecompose) {
            return false;
        }
        doCompose(invalidationsRequested, null);
        return this.changes.isNotEmpty();
    }

    @Override // androidx.compose.runtime.Composer
    public void recordSideEffect(@NotNull Function0<Unit> effect) {
        this.changeListWriter.sideEffect(effect);
    }

    @Override // androidx.compose.runtime.Composer
    public void recordUsed(@NotNull RecomposeScope scope) {
        RecomposeScopeImpl recomposeScopeImpl = scope instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) scope : null;
        if (recomposeScopeImpl == null) {
            return;
        }
        recomposeScopeImpl.setUsed(true);
    }

    @Override // androidx.compose.runtime.Composer
    @Nullable
    public Object rememberedValue() {
        return nextSlotForCache();
    }

    public final void setDeferredChanges$runtime_release(@Nullable ChangeList changeList) {
        this.deferredChanges = changeList;
    }

    public final void setInsertTable$runtime_release(@NotNull SlotTable slotTable) {
        this.insertTable = slotTable;
    }

    public final void setReader$runtime_release(@NotNull SlotReader slotReader) {
        this.reader = slotReader;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c3  */
    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void skipCurrentGroup() {
        int iRotateLeft;
        if (this.invalidations.isEmpty()) {
            skipGroup();
            return;
        }
        SlotReader slotReader = this.reader;
        int groupKey = slotReader.getGroupKey();
        Object groupObjectKey = slotReader.getGroupObjectKey();
        Object groupAux = slotReader.getGroupAux();
        int i = this.rGroupIndex;
        if (groupObjectKey != null) {
            iRotateLeft = Integer.rotateLeft((groupObjectKey instanceof Enum ? ((Enum) groupObjectKey).ordinal() : groupObjectKey.hashCode()) ^ Integer.rotateLeft(getCompoundKeyHash(), 3), 3);
        } else {
            if (groupAux != null && groupKey == 207 && !Intrinsics.areEqual(groupAux, Composer.INSTANCE.getEmpty())) {
                this.compoundKeyHash = Integer.rotateLeft(groupAux.hashCode() ^ Integer.rotateLeft(getCompoundKeyHash(), 3), 3) ^ i;
                startReaderGroup(slotReader.isNode(), null);
                recomposeToGroupEnd();
                slotReader.endGroup();
                if (groupObjectKey == null) {
                    if (groupObjectKey instanceof Enum) {
                        this.compoundKeyHash = Integer.rotateRight(Integer.hashCode(((Enum) groupObjectKey).ordinal()) ^ Integer.rotateRight(getCompoundKeyHash(), 3), 3);
                        return;
                    } else {
                        this.compoundKeyHash = Integer.rotateRight(Integer.hashCode(groupObjectKey.hashCode()) ^ Integer.rotateRight(getCompoundKeyHash(), 3), 3);
                        return;
                    }
                }
                if (groupAux == null || groupKey != 207 || Intrinsics.areEqual(groupAux, Composer.INSTANCE.getEmpty())) {
                    this.compoundKeyHash = Integer.rotateRight(Integer.rotateRight(getCompoundKeyHash() ^ i, 3) ^ Integer.hashCode(groupKey), 3);
                    return;
                } else {
                    this.compoundKeyHash = Integer.rotateRight(Integer.hashCode(groupAux.hashCode()) ^ Integer.rotateRight(getCompoundKeyHash() ^ i, 3), 3);
                    return;
                }
            }
            iRotateLeft = Integer.rotateLeft(Integer.rotateLeft(getCompoundKeyHash(), 3) ^ groupKey, 3) ^ i;
        }
        this.compoundKeyHash = iRotateLeft;
        startReaderGroup(slotReader.isNode(), null);
        recomposeToGroupEnd();
        slotReader.endGroup();
        if (groupObjectKey == null) {
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void skipToGroupEnd() {
        if (!(this.groupNodeCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("No nodes can be emitted before calling skipAndEndGroup");
        }
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release != null) {
            currentRecomposeScope$runtime_release.scopeSkipped();
        }
        if (this.invalidations.isEmpty()) {
            skipReaderToGroupEnd();
        } else {
            recomposeToGroupEnd();
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformation(@NotNull String sourceInformation) {
        if (getInserting() && this.sourceMarkersEnabled) {
            this.writer.recordGroupSourceInformation(sourceInformation);
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformationMarkerEnd() {
        if (getInserting() && this.sourceMarkersEnabled) {
            this.writer.recordGrouplessCallSourceInformationEnd();
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformationMarkerStart(int key, @NotNull String sourceInformation) {
        if (getInserting() && this.sourceMarkersEnabled) {
            this.writer.recordGrouplessCallSourceInformationStart(key, sourceInformation);
        }
    }

    public final int stacksSize$runtime_release() {
        return this.parentStateStack.getTos() + this.pendingStack.getSize() + this.providersInvalidStack.getTos() + this.invalidateStack.getSize() + this.entersStack.getTos();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startDefaults() {
        m17985startBaiHCIY(-127, null, GroupKind.INSTANCE.m17995getGroupULZAiWs(), null);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startMovableGroup(int key, @Nullable Object dataKey) {
        m17985startBaiHCIY(key, dataKey, GroupKind.INSTANCE.m17995getGroupULZAiWs(), null);
    }

    @Override // androidx.compose.runtime.Composer
    public void startNode() {
        m17985startBaiHCIY(125, null, GroupKind.INSTANCE.m17996getNodeULZAiWs(), null);
        this.nodeExpected = true;
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void startProvider(@NotNull ProvidedValue<?> value) {
        ValueHolder<?> valueHolder;
        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = currentCompositionLocalScope();
        startGroup(201, ComposerKt.getProvider());
        Object objRememberedValue = rememberedValue();
        if (Intrinsics.areEqual(objRememberedValue, Composer.INSTANCE.getEmpty())) {
            valueHolder = null;
        } else {
            Intrinsics.checkNotNull(objRememberedValue, "null cannot be cast to non-null type androidx.compose.runtime.ValueHolder<kotlin.Any?>");
            valueHolder = (ValueHolder) objRememberedValue;
        }
        CompositionLocal<?> compositionLocal = value.getCompositionLocal();
        Intrinsics.checkNotNull(compositionLocal, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.ProvidedValue<kotlin.Any?>");
        ValueHolder<?> valueHolderUpdatedStateOf$runtime_release = compositionLocal.updatedStateOf$runtime_release(value, valueHolder);
        boolean zAreEqual = Intrinsics.areEqual(valueHolderUpdatedStateOf$runtime_release, valueHolder);
        if (!zAreEqual) {
            updateRememberedValue(valueHolderUpdatedStateOf$runtime_release);
        }
        boolean z = true;
        boolean z2 = false;
        if (getInserting()) {
            if (value.getCanOverride() || !CompositionLocalMapKt.contains(persistentCompositionLocalMapCurrentCompositionLocalScope, compositionLocal)) {
                persistentCompositionLocalMapCurrentCompositionLocalScope = persistentCompositionLocalMapCurrentCompositionLocalScope.putValue(compositionLocal, valueHolderUpdatedStateOf$runtime_release);
            }
            this.writerHasAProvider = true;
        } else {
            SlotReader slotReader = this.reader;
            Object objGroupAux = slotReader.groupAux(slotReader.getCurrentGroup());
            Intrinsics.checkNotNull(objGroupAux, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap = (PersistentCompositionLocalMap) objGroupAux;
            persistentCompositionLocalMapCurrentCompositionLocalScope = (!(getSkipping() && zAreEqual) && (value.getCanOverride() || !CompositionLocalMapKt.contains(persistentCompositionLocalMapCurrentCompositionLocalScope, compositionLocal))) ? persistentCompositionLocalMapCurrentCompositionLocalScope.putValue(compositionLocal, valueHolderUpdatedStateOf$runtime_release) : persistentCompositionLocalMap;
            if (!this.reusing && persistentCompositionLocalMap == persistentCompositionLocalMapCurrentCompositionLocalScope) {
                z = false;
            }
            z2 = z;
        }
        if (z2 && !getInserting()) {
            recordProviderUpdate(persistentCompositionLocalMapCurrentCompositionLocalScope);
        }
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = z2;
        this.providerCache = persistentCompositionLocalMapCurrentCompositionLocalScope;
        m17985startBaiHCIY(202, ComposerKt.getCompositionLocalMap(), GroupKind.INSTANCE.m17995getGroupULZAiWs(), persistentCompositionLocalMapCurrentCompositionLocalScope);
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void startProviders(@NotNull ProvidedValue<?>[] values) {
        PersistentCompositionLocalMap persistentCompositionLocalMapUpdateProviderMapGroup;
        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = currentCompositionLocalScope();
        startGroup(201, ComposerKt.getProvider());
        boolean z = true;
        boolean z2 = false;
        if (getInserting()) {
            persistentCompositionLocalMapUpdateProviderMapGroup = updateProviderMapGroup(persistentCompositionLocalMapCurrentCompositionLocalScope, CompositionLocalMapKt.updateCompositionMap$default(values, persistentCompositionLocalMapCurrentCompositionLocalScope, null, 4, null));
            this.writerHasAProvider = true;
        } else {
            Object objGroupGet = this.reader.groupGet(0);
            Intrinsics.checkNotNull(objGroupGet, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap = (PersistentCompositionLocalMap) objGroupGet;
            Object objGroupGet2 = this.reader.groupGet(1);
            Intrinsics.checkNotNull(objGroupGet2, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) objGroupGet2;
            PersistentCompositionLocalMap persistentCompositionLocalMapUpdateCompositionMap = CompositionLocalMapKt.updateCompositionMap(values, persistentCompositionLocalMapCurrentCompositionLocalScope, persistentCompositionLocalMap2);
            if (getSkipping() && !this.reusing && Intrinsics.areEqual(persistentCompositionLocalMap2, persistentCompositionLocalMapUpdateCompositionMap)) {
                skipGroup();
                persistentCompositionLocalMapUpdateProviderMapGroup = persistentCompositionLocalMap;
            } else {
                persistentCompositionLocalMapUpdateProviderMapGroup = updateProviderMapGroup(persistentCompositionLocalMapCurrentCompositionLocalScope, persistentCompositionLocalMapUpdateCompositionMap);
                if (!this.reusing && Intrinsics.areEqual(persistentCompositionLocalMapUpdateProviderMapGroup, persistentCompositionLocalMap)) {
                    z = false;
                }
                z2 = z;
            }
        }
        if (z2 && !getInserting()) {
            recordProviderUpdate(persistentCompositionLocalMapUpdateProviderMapGroup);
        }
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = z2;
        this.providerCache = persistentCompositionLocalMapUpdateProviderMapGroup;
        m17985startBaiHCIY(202, ComposerKt.getCompositionLocalMap(), GroupKind.INSTANCE.m17995getGroupULZAiWs(), persistentCompositionLocalMapUpdateProviderMapGroup);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startReplaceGroup(int key) {
        if (this.pending != null) {
            m17985startBaiHCIY(key, null, GroupKind.INSTANCE.m17995getGroupULZAiWs(), null);
            return;
        }
        validateNodeNotExpected();
        this.compoundKeyHash = this.rGroupIndex ^ Integer.rotateLeft(Integer.rotateLeft(getCompoundKeyHash(), 3) ^ key, 3);
        this.rGroupIndex++;
        SlotReader slotReader = this.reader;
        if (getInserting()) {
            slotReader.beginEmpty();
            this.writer.startGroup(key, Composer.INSTANCE.getEmpty());
            enterGroup(false, null);
            return;
        }
        if (slotReader.getGroupKey() == key && !slotReader.getHasObjectKey()) {
            slotReader.startGroup();
            enterGroup(false, null);
            return;
        }
        if (!slotReader.isGroupEnd()) {
            int i = this.nodeIndex;
            int currentGroup = slotReader.getCurrentGroup();
            recordDelete();
            this.changeListWriter.removeNode(i, slotReader.skipGroup());
            ComposerKt.removeRange(this.invalidations, currentGroup, slotReader.getCurrentGroup());
        }
        slotReader.beginEmpty();
        this.inserting = true;
        this.providerCache = null;
        ensureWriter();
        SlotWriter slotWriter = this.writer;
        slotWriter.beginInsert();
        int currentGroup2 = slotWriter.getCurrentGroup();
        slotWriter.startGroup(key, Composer.INSTANCE.getEmpty());
        this.insertAnchor = slotWriter.anchor(currentGroup2);
        enterGroup(false, null);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startReplaceableGroup(int key) {
        m17985startBaiHCIY(key, null, GroupKind.INSTANCE.m17995getGroupULZAiWs(), null);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    @NotNull
    public Composer startRestartGroup(int key) {
        startReplaceGroup(key);
        addRecomposeScope();
        return this;
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableGroup(int key, @Nullable Object dataKey) {
        if (!getInserting() && this.reader.getGroupKey() == key && !Intrinsics.areEqual(this.reader.getGroupAux(), dataKey) && this.reusingGroup < 0) {
            this.reusingGroup = this.reader.getCurrentGroup();
            this.reusing = true;
        }
        m17985startBaiHCIY(key, null, GroupKind.INSTANCE.m17995getGroupULZAiWs(), dataKey);
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableNode() {
        m17985startBaiHCIY(125, null, GroupKind.INSTANCE.m17997getReusableNodeULZAiWs(), null);
        this.nodeExpected = true;
    }

    public final void startReuseFromRoot() {
        this.reusingGroup = 100;
        this.reusing = true;
    }

    public final boolean tryImminentInvalidation$runtime_release(@NotNull RecomposeScopeImpl scope, @Nullable Object instance) {
        Anchor anchor = scope.getAnchor();
        if (anchor == null) {
            return false;
        }
        int indexFor = anchor.toIndexFor(this.reader.getTable());
        if (!this.isComposing || indexFor < this.reader.getCurrentGroup()) {
            return false;
        }
        ComposerKt.insertIfMissing(this.invalidations, indexFor, scope, instance);
        return true;
    }

    @PublishedApi
    public final void updateCachedValue(@Nullable Object value) {
        if (value instanceof RememberObserver) {
            if (getInserting()) {
                this.changeListWriter.remember((RememberObserver) value);
            }
            this.abandonSet.add(value);
            value = new RememberObserverHolder((RememberObserver) value, rememberObserverAnchor());
        }
        updateValue(value);
    }

    @Override // androidx.compose.runtime.Composer
    public void updateRememberedValue(@Nullable Object value) {
        updateCachedValue(value);
    }

    @PublishedApi
    public final void updateValue(@Nullable Object value) {
        if (getInserting()) {
            this.writer.update(value);
            return;
        }
        if (!this.reader.getHadNext()) {
            ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
            SlotReader slotReader = this.reader;
            composerChangeListWriter.appendValue(slotReader.anchor(slotReader.getParent()), value);
            return;
        }
        int groupSlotIndex = this.reader.getGroupSlotIndex() - 1;
        if (!this.changeListWriter.getPastParent()) {
            this.changeListWriter.updateValue(value, groupSlotIndex);
            return;
        }
        ComposerChangeListWriter composerChangeListWriter2 = this.changeListWriter;
        SlotReader slotReader2 = this.reader;
        composerChangeListWriter2.updateAnchoredValue(value, slotReader2.anchor(slotReader2.getParent()), groupSlotIndex);
    }

    @Override // androidx.compose.runtime.Composer
    public void useNode() {
        validateNodeExpected();
        if (getInserting()) {
            ComposerKt.composeImmediateRuntimeError("useNode() called while inserting");
        }
        Object node = getNode(this.reader);
        this.changeListWriter.moveDown(node);
        if (this.reusing && (node instanceof ComposeNodeLifecycleCallback)) {
            this.changeListWriter.useNode(node);
        }
    }

    public final void verifyConsistent$runtime_release() {
        this.insertTable.verifyWellFormed();
    }

    private final void startGroup(int key, Object dataKey) {
        m17985startBaiHCIY(key, dataKey, GroupKind.INSTANCE.m17995getGroupULZAiWs(), null);
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope(int group) {
        PersistentCompositionLocalMap persistentCompositionLocalMap;
        if (getInserting() && this.writerHasAProvider) {
            int parent = this.writer.getParent();
            while (parent > 0) {
                if (this.writer.groupKey(parent) == 202 && Intrinsics.areEqual(this.writer.groupObjectKey(parent), ComposerKt.getCompositionLocalMap())) {
                    Object objGroupAux = this.writer.groupAux(parent);
                    Intrinsics.checkNotNull(objGroupAux, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                    PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) objGroupAux;
                    this.providerCache = persistentCompositionLocalMap2;
                    return persistentCompositionLocalMap2;
                }
                parent = this.writer.parent(parent);
            }
        }
        if (this.reader.getGroupsSize() > 0) {
            while (group > 0) {
                if (this.reader.groupKey(group) == 202 && Intrinsics.areEqual(this.reader.groupObjectKey(group), ComposerKt.getCompositionLocalMap())) {
                    IntMap<PersistentCompositionLocalMap> intMap = this.providerUpdates;
                    if (intMap == null || (persistentCompositionLocalMap = intMap.get(group)) == null) {
                        Object objGroupAux2 = this.reader.groupAux(group);
                        Intrinsics.checkNotNull(objGroupAux2, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                        persistentCompositionLocalMap = (PersistentCompositionLocalMap) objGroupAux2;
                    }
                    this.providerCache = persistentCompositionLocalMap;
                    return persistentCompositionLocalMap;
                }
                group = this.reader.parent(group);
            }
        }
        PersistentCompositionLocalMap persistentCompositionLocalMap3 = this.parentProvider;
        this.providerCache = persistentCompositionLocalMap3;
        return persistentCompositionLocalMap3;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(char value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Character) && value == ((Character) objNextSlot).charValue()) {
            return false;
        }
        updateValue(Character.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(byte value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Byte) && value == ((Number) objNextSlot).byteValue()) {
            return false;
        }
        updateValue(Byte.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(short value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Short) && value == ((Number) objNextSlot).shortValue()) {
            return false;
        }
        updateValue(Short.valueOf(value));
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, m13886d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextHolder;", "Landroidx/compose/runtime/ReusableRememberObserver;", "ref", "Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/ComposerImpl;", "(Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;)V", "getRef", "()Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "onAbandoned", "", "onForgotten", "onRemembered", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class CompositionContextHolder implements ReusableRememberObserver {

        @NotNull
        private final CompositionContextImpl ref;

        public CompositionContextHolder(@NotNull CompositionContextImpl compositionContextImpl) {
            this.ref = compositionContextImpl;
        }

        @NotNull
        public final CompositionContextImpl getRef() {
            return this.ref;
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onAbandoned() {
            this.ref.dispose();
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onForgotten() {
            this.ref.dispose();
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onRemembered() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ*\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0011\u00102\u001a\r\u0012\u0004\u0012\u00020/03¢\u0006\u0002\b4H\u0010¢\u0006\u0004\b5\u00106J\u0015\u00107\u001a\u00020/2\u0006\u00108\u001a\u000209H\u0010¢\u0006\u0002\b:J\u0006\u0010;\u001a\u00020/J\r\u0010<\u001a\u00020/H\u0010¢\u0006\u0002\b=J\r\u0010\u0017\u001a\u00020\u0015H\u0010¢\u0006\u0002\b>J\u0015\u0010?\u001a\u00020/2\u0006\u00108\u001a\u000209H\u0010¢\u0006\u0002\b@J\u0015\u0010A\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0010¢\u0006\u0002\bBJ\u0015\u0010C\u001a\u00020/2\u0006\u0010D\u001a\u00020EH\u0010¢\u0006\u0002\bFJ\u001d\u0010G\u001a\u00020/2\u0006\u00108\u001a\u0002092\u0006\u0010H\u001a\u00020IH\u0010¢\u0006\u0002\bJJ\u0017\u0010K\u001a\u0004\u0018\u00010I2\u0006\u00108\u001a\u000209H\u0010¢\u0006\u0002\bLJ\u001b\u0010M\u001a\u00020/2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020$0\u0010H\u0010¢\u0006\u0002\bOJ\u0015\u0010P\u001a\u00020/2\u0006\u0010Q\u001a\u00020RH\u0010¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0010¢\u0006\u0002\bUJ\u0015\u0010V\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0010¢\u0006\u0002\bWJ\r\u0010X\u001a\u00020/H\u0010¢\u0006\u0002\bYJ\u0015\u0010Z\u001a\u00020/2\u0006\u0010Q\u001a\u00020RH\u0010¢\u0006\u0002\b[J\u0015\u0010\\\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0010¢\u0006\u0002\b]J\u000e\u0010^\u001a\u00020/2\u0006\u0010D\u001a\u00020\u0015R\u0014\u0010\n\u001a\u00020\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0005X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0002\u001a\u00020\u0003X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R(\u0010#\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0010\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010'R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020 8PX\u0090\u0004¢\u0006\f\u0012\u0004\b+\u0010,\u001a\u0004\b-\u0010\"¨\u0006_"}, m13886d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/CompositionContext;", "compoundHashKey", "", "collectingParameterInformation", "", "collectingSourceInformation", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "(Landroidx/compose/runtime/ComposerImpl;IZZLandroidx/compose/runtime/CompositionObserverHolder;)V", "collectingCallByInformation", "getCollectingCallByInformation$runtime_release", "()Z", "getCollectingParameterInformation$runtime_release", "getCollectingSourceInformation$runtime_release", "composers", "", "Landroidx/compose/runtime/ComposerImpl;", "getComposers", "()Ljava/util/Set;", "<set-?>", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "compositionLocalScope", "getCompositionLocalScope", "()Landroidx/compose/runtime/PersistentCompositionLocalMap;", "setCompositionLocalScope", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)V", "compositionLocalScope$delegate", "Landroidx/compose/runtime/MutableState;", "getCompoundHashKey$runtime_release", "()I", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "inspectionTables", "Landroidx/compose/runtime/tooling/CompositionData;", "getInspectionTables", "setInspectionTables", "(Ljava/util/Set;)V", "getObserverHolder$runtime_release", "()Landroidx/compose/runtime/CompositionObserverHolder;", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release$annotations", "()V", "getRecomposeCoroutineContext$runtime_release", "composeInitial", "", "composition", "Landroidx/compose/runtime/ControlledComposition;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "deletedMovableContent", "reference", "Landroidx/compose/runtime/MovableContentStateReference;", "deletedMovableContent$runtime_release", "dispose", "doneComposing", "doneComposing$runtime_release", "getCompositionLocalScope$runtime_release", "insertMovableContent", "insertMovableContent$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "movableContentStateReleased", "data", "Landroidx/compose/runtime/MovableContentState;", "movableContentStateReleased$runtime_release", "movableContentStateResolve", "movableContentStateResolve$runtime_release", "recordInspectionTable", "table", "recordInspectionTable$runtime_release", "registerComposer", "composer", "Landroidx/compose/runtime/Composer;", "registerComposer$runtime_release", "registerComposition", "registerComposition$runtime_release", "reportRemovedComposition", "reportRemovedComposition$runtime_release", "startComposing", "startComposing$runtime_release", "unregisterComposer", "unregisterComposer$runtime_release", "unregisterComposition", "unregisterComposition$runtime_release", "updateCompositionLocalScope", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nComposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Composer.kt\nandroidx/compose/runtime/ComposerImpl$CompositionContextImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n*L\n1#1,4584:1\n1855#2,2:4585\n81#3:4587\n107#3,2:4588\n*S KotlinDebug\n*F\n+ 1 Composer.kt\nandroidx/compose/runtime/ComposerImpl$CompositionContextImpl\n*L\n3851#1:4585,2\n3901#1:4587\n3901#1:4588,2\n*E\n"})
    public final class CompositionContextImpl extends CompositionContext {
        private final boolean collectingParameterInformation;
        private final boolean collectingSourceInformation;

        @NotNull
        private final Set<ComposerImpl> composers = new LinkedHashSet();

        /* JADX INFO: renamed from: compositionLocalScope$delegate, reason: from kotlin metadata */
        @NotNull
        private final MutableState compositionLocalScope = SnapshotStateKt.mutableStateOf(PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf(), SnapshotStateKt.referentialEqualityPolicy());
        private final int compoundHashKey;

        @Nullable
        private Set<Set<CompositionData>> inspectionTables;

        @Nullable
        private final CompositionObserverHolder observerHolder;

        public CompositionContextImpl(int i, boolean z, boolean z2, @Nullable CompositionObserverHolder compositionObserverHolder) {
            this.compoundHashKey = i;
            this.collectingParameterInformation = z;
            this.collectingSourceInformation = z2;
            this.observerHolder = compositionObserverHolder;
        }

        private final PersistentCompositionLocalMap getCompositionLocalScope() {
            return (PersistentCompositionLocalMap) this.compositionLocalScope.getValue();
        }

        private final void setCompositionLocalScope(PersistentCompositionLocalMap persistentCompositionLocalMap) {
            this.compositionLocalScope.setValue(persistentCompositionLocalMap);
        }

        @Override // androidx.compose.runtime.CompositionContext
        @ComposableInferredTarget(scheme = "[0[0]]")
        public void composeInitial$runtime_release(@NotNull ControlledComposition composition, @NotNull Function2<? super Composer, ? super Integer, Unit> content) {
            ComposerImpl.this.parentContext.composeInitial$runtime_release(composition, content);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void deletedMovableContent$runtime_release(@NotNull MovableContentStateReference reference) {
            ComposerImpl.this.parentContext.deletedMovableContent$runtime_release(reference);
        }

        public final void dispose() {
            if (this.composers.isEmpty()) {
                return;
            }
            Set<Set<CompositionData>> set = this.inspectionTables;
            if (set != null) {
                for (ComposerImpl composerImpl : this.composers) {
                    Iterator<Set<CompositionData>> it = set.iterator();
                    while (it.hasNext()) {
                        it.next().remove(composerImpl.slotTable);
                    }
                }
            }
            this.composers.clear();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void doneComposing$runtime_release() {
            ComposerImpl composerImpl = ComposerImpl.this;
            composerImpl.childrenComposing--;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public boolean getCollectingCallByInformation$runtime_release() {
            return ComposerImpl.this.parentContext.getCollectingCallByInformation$runtime_release();
        }

        @Override // androidx.compose.runtime.CompositionContext
        /* JADX INFO: renamed from: getCollectingParameterInformation$runtime_release, reason: from getter */
        public boolean getCollectingParameterInformation() {
            return this.collectingParameterInformation;
        }

        @Override // androidx.compose.runtime.CompositionContext
        /* JADX INFO: renamed from: getCollectingSourceInformation$runtime_release, reason: from getter */
        public boolean getCollectingSourceInformation() {
            return this.collectingSourceInformation;
        }

        @NotNull
        public final Set<ComposerImpl> getComposers() {
            return this.composers;
        }

        @Override // androidx.compose.runtime.CompositionContext
        @NotNull
        public PersistentCompositionLocalMap getCompositionLocalScope$runtime_release() {
            return getCompositionLocalScope();
        }

        @Override // androidx.compose.runtime.CompositionContext
        /* JADX INFO: renamed from: getCompoundHashKey$runtime_release, reason: from getter */
        public int getCompoundHashKey() {
            return this.compoundHashKey;
        }

        @Override // androidx.compose.runtime.CompositionContext
        @NotNull
        public CoroutineContext getEffectCoroutineContext() {
            return ComposerImpl.this.parentContext.getEffectCoroutineContext();
        }

        @Nullable
        public final Set<Set<CompositionData>> getInspectionTables() {
            return this.inspectionTables;
        }

        @Override // androidx.compose.runtime.CompositionContext
        @Nullable
        /* JADX INFO: renamed from: getObserverHolder$runtime_release, reason: from getter */
        public CompositionObserverHolder getObserverHolder() {
            return this.observerHolder;
        }

        @Override // androidx.compose.runtime.CompositionContext
        @NotNull
        public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
            return CompositionKt.getRecomposeCoroutineContext(ComposerImpl.this.getComposition());
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void insertMovableContent$runtime_release(@NotNull MovableContentStateReference reference) {
            ComposerImpl.this.parentContext.insertMovableContent$runtime_release(reference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void invalidate$runtime_release(@NotNull ControlledComposition composition) {
            ComposerImpl.this.parentContext.invalidate$runtime_release(ComposerImpl.this.getComposition());
            ComposerImpl.this.parentContext.invalidate$runtime_release(composition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void invalidateScope$runtime_release(@NotNull RecomposeScopeImpl scope) {
            ComposerImpl.this.parentContext.invalidateScope$runtime_release(scope);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void movableContentStateReleased$runtime_release(@NotNull MovableContentStateReference reference, @NotNull MovableContentState data) {
            ComposerImpl.this.parentContext.movableContentStateReleased$runtime_release(reference, data);
        }

        @Override // androidx.compose.runtime.CompositionContext
        @Nullable
        public MovableContentState movableContentStateResolve$runtime_release(@NotNull MovableContentStateReference reference) {
            return ComposerImpl.this.parentContext.movableContentStateResolve$runtime_release(reference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void recordInspectionTable$runtime_release(@NotNull Set<CompositionData> table) {
            Set hashSet = this.inspectionTables;
            if (hashSet == null) {
                hashSet = new HashSet();
                this.inspectionTables = hashSet;
            }
            hashSet.add(table);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void registerComposer$runtime_release(@NotNull Composer composer) {
            Intrinsics.checkNotNull(composer, "null cannot be cast to non-null type androidx.compose.runtime.ComposerImpl");
            super.registerComposer$runtime_release((ComposerImpl) composer);
            this.composers.add(composer);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void registerComposition$runtime_release(@NotNull ControlledComposition composition) {
            ComposerImpl.this.parentContext.registerComposition$runtime_release(composition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void reportRemovedComposition$runtime_release(@NotNull ControlledComposition composition) {
            ComposerImpl.this.parentContext.reportRemovedComposition$runtime_release(composition);
        }

        public final void setInspectionTables(@Nullable Set<Set<CompositionData>> set) {
            this.inspectionTables = set;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void startComposing$runtime_release() {
            ComposerImpl.this.childrenComposing++;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposer$runtime_release(@NotNull Composer composer) {
            Set<Set<CompositionData>> set = this.inspectionTables;
            if (set != null) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    Set set2 = (Set) it.next();
                    Intrinsics.checkNotNull(composer, "null cannot be cast to non-null type androidx.compose.runtime.ComposerImpl");
                    set2.remove(((ComposerImpl) composer).slotTable);
                }
            }
            TypeIntrinsics.asMutableCollection(this.composers).remove(composer);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposition$runtime_release(@NotNull ControlledComposition composition) {
            ComposerImpl.this.parentContext.unregisterComposition$runtime_release(composition);
        }

        public final void updateCompositionLocalScope(@NotNull PersistentCompositionLocalMap scope) {
            setCompositionLocalScope(scope);
        }

        public static /* synthetic */ void getRecomposeCoroutineContext$runtime_release$annotations() {
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(boolean value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Boolean) && value == ((Boolean) objNextSlot).booleanValue()) {
            return false;
        }
        updateValue(Boolean.valueOf(value));
        return true;
    }

    @InternalComposeApi
    public static /* synthetic */ void getCompoundKeyHash$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getDefaultsInvalid$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getInserting$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getSkipping$annotations() {
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(float value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Float) && value == ((Number) objNextSlot).floatValue()) {
            return false;
        }
        updateValue(Float.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(long value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Long) && value == ((Number) objNextSlot).longValue()) {
            return false;
        }
        updateValue(Long.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(double value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Double) && value == ((Number) objNextSlot).doubleValue()) {
            return false;
        }
        updateValue(Double.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(int value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Integer) && value == ((Number) objNextSlot).intValue()) {
            return false;
        }
        updateValue(Integer.valueOf(value));
        return true;
    }
}
