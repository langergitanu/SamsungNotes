package androidx.compose.p109ui.node;

import android.view.View;
import androidx.compose.p109ui.ExperimentalComposeUiApi;
import androidx.compose.p109ui.InternalComposeUiApi;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.CacheDrawModifierNode;
import androidx.compose.p109ui.graphics.Canvas;
import androidx.compose.p109ui.graphics.layer.GraphicsLayer;
import androidx.compose.p109ui.internal.InlineClassHelperKt;
import androidx.compose.p109ui.layout.IntrinsicMeasurable;
import androidx.compose.p109ui.layout.IntrinsicMeasureScope;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.layout.LayoutInfo;
import androidx.compose.p109ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.ModifierInfo;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.layout.Remeasurement;
import androidx.compose.p109ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.p109ui.node.Owner;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.JvmActuals_jvmKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.semantics.SemanticsConfiguration;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.p109ui.viewinterop.AndroidViewHolder;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import com.google.firebase.messaging.Constants;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.ServerResultMeetingParser;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderConstants;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p005A3.C0016a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000Î\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\bH\b\u0000\u0018\u0000 ñ\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\bñ\u0002ò\u0002ó\u0002ô\u0002B\u0019\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010ç\u0001\u001a\u00030·\u00012\u0007\u0010¨\u0001\u001a\u00020\u0019H\u0002J\u001a\u0010è\u0001\u001a\u00030·\u00012\b\u0010Á\u0001\u001a\u00030¶\u0001H\u0000¢\u0006\u0003\bé\u0001J\u0010\u0010ê\u0001\u001a\u00030·\u0001H\u0000¢\u0006\u0003\bë\u0001J\n\u0010ì\u0001\u001a\u00030·\u0001H\u0002J\u0014\u0010í\u0001\u001a\u00030î\u00012\b\b\u0002\u0010K\u001a\u00020\u000bH\u0002J\u0010\u0010ï\u0001\u001a\u00030·\u0001H\u0000¢\u0006\u0003\bð\u0001J\u0010\u0010ñ\u0001\u001a\u00030·\u0001H\u0000¢\u0006\u0003\bò\u0001J&\u0010ó\u0001\u001a\u00030·\u00012\b\u0010ô\u0001\u001a\u00030õ\u00012\n\u0010ö\u0001\u001a\u0005\u0018\u00010÷\u0001H\u0000¢\u0006\u0003\bø\u0001J\"\u0010ù\u0001\u001a\u00030·\u00012\u0015\u0010ú\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u00030·\u00010µ\u0001H\u0086\bJ(\u0010û\u0001\u001a\u00030·\u00012\u001b\u0010ú\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u00030·\u00010ü\u0001H\u0086\bJ)\u0010ý\u0001\u001a\u00030·\u00012\u0016\u0010ú\u0001\u001a\u0011\u0012\u0005\u0012\u00030þ\u0001\u0012\u0005\u0012\u00030·\u00010µ\u0001H\u0080\b¢\u0006\u0003\bÿ\u0001J(\u0010\u0080\u0002\u001a\u00030·\u00012\u0015\u0010ú\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0005\u0012\u00030·\u00010µ\u0001H\u0080\b¢\u0006\u0003\b\u0081\u0002J\n\u0010\u0082\u0002\u001a\u00030·\u0001H\u0016J\u0013\u0010\u0083\u0002\u001a\f\u0018\u00010\u0084\u0002j\u0005\u0018\u0001`\u0085\u0002H\u0017J\u0010\u0010\u0086\u0002\u001a\t\u0012\u0005\u0012\u00030\u0087\u00020(H\u0016J\t\u0010\u0088\u0002\u001a\u00020eH\u0002J@\u0010\u0089\u0002\u001a\u00030·\u00012\b\u0010\u008a\u0002\u001a\u00030\u008b\u00022\b\u0010\u008c\u0002\u001a\u00030\u008d\u00022\t\b\u0002\u0010\u008e\u0002\u001a\u00020\t2\t\b\u0002\u0010\u008f\u0002\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0006\b\u0090\u0002\u0010\u0091\u0002J@\u0010\u0092\u0002\u001a\u00030·\u00012\b\u0010\u008a\u0002\u001a\u00030\u008b\u00022\b\u0010\u0093\u0002\u001a\u00030\u008d\u00022\t\b\u0002\u0010\u008e\u0002\u001a\u00020\t2\t\b\u0002\u0010\u008f\u0002\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0006\b\u0094\u0002\u0010\u0091\u0002J!\u0010T\u001a\u00030·\u00012\u000f\u0010ú\u0001\u001a\n\u0012\u0005\u0012\u00030·\u00010\u0095\u0002H\u0080\b¢\u0006\u0003\b\u0096\u0002J\"\u0010\u0097\u0002\u001a\u00030·\u00012\u0007\u0010\u0098\u0002\u001a\u00020\u000b2\u0007\u0010\u0099\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0003\b\u009a\u0002J\n\u0010\u009b\u0002\u001a\u00030·\u0001H\u0002J\u0010\u0010\u009c\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\b\u009d\u0002J\u0010\u0010\u009e\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\b\u009f\u0002J\u0010\u0010 \u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\b¡\u0002J\u0010\u0010¢\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\b£\u0002J\u0010\u0010¤\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\b¥\u0002J\u0010\u0010¦\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\b§\u0002J\u0013\u0010¨\u0002\u001a\u00030·\u00012\t\b\u0002\u0010©\u0002\u001a\u00020\tJ\n\u0010ª\u0002\u001a\u00030·\u0001H\u0002J \u0010«\u0002\u001a\u00020\t2\f\b\u0002\u0010¬\u0002\u001a\u0005\u0018\u00010\u00ad\u0002H\u0000ø\u0001\u0000¢\u0006\u0003\b®\u0002J\u0010\u0010¯\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\b°\u0002J\u0010\u0010±\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\b²\u0002J\u0010\u0010³\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\b´\u0002J\u0010\u0010µ\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\b¶\u0002J\u0010\u0010·\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\b¸\u0002J\u0010\u0010¹\u0002\u001a\u00020\u000b2\u0007\u0010Ý\u0001\u001a\u00020\u000bJ\u000f\u0010º\u0002\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000bJ\u0010\u0010»\u0002\u001a\u00020\u000b2\u0007\u0010Ý\u0001\u001a\u00020\u000bJ\u000f\u0010¼\u0002\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000bJ\u0010\u0010½\u0002\u001a\u00020\u000b2\u0007\u0010Ý\u0001\u001a\u00020\u000bJ\u000f\u0010¾\u0002\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000bJ\u0010\u0010¿\u0002\u001a\u00020\u000b2\u0007\u0010Ý\u0001\u001a\u00020\u000bJ\u000f\u0010À\u0002\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000bJ+\u0010Á\u0002\u001a\u00030·\u00012\u0007\u0010Â\u0002\u001a\u00020\u000b2\u0007\u0010Ã\u0002\u001a\u00020\u000b2\u0007\u0010Ä\u0002\u001a\u00020\u000bH\u0000¢\u0006\u0003\bÅ\u0002J\u0013\u0010Æ\u0002\u001a\u00030·\u00012\u0007\u0010Ç\u0002\u001a\u00020\u0000H\u0002J\n\u0010È\u0002\u001a\u00030·\u0001H\u0016J\n\u0010É\u0002\u001a\u00030·\u0001H\u0002J\n\u0010Ê\u0002\u001a\u00030·\u0001H\u0016J\n\u0010Ë\u0002\u001a\u00030·\u0001H\u0016J\n\u0010Ì\u0002\u001a\u00030·\u0001H\u0016J\u0010\u0010Í\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\bÎ\u0002J\"\u0010Ï\u0002\u001a\u00030·\u00012\u0007\u0010Ð\u0002\u001a\u00020\u000b2\u0007\u0010Ñ\u0002\u001a\u00020\u000bH\u0000¢\u0006\u0003\bÒ\u0002J\n\u0010Ó\u0002\u001a\u00030·\u0001H\u0002J \u0010Ô\u0002\u001a\u00020\t2\f\b\u0002\u0010¬\u0002\u001a\u0005\u0018\u00010\u00ad\u0002H\u0000ø\u0001\u0000¢\u0006\u0003\bÕ\u0002J\u0010\u0010Ö\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\b×\u0002J\"\u0010Ø\u0002\u001a\u00030·\u00012\u0007\u0010\u0098\u0002\u001a\u00020\u000b2\u0007\u0010Ä\u0002\u001a\u00020\u000bH\u0000¢\u0006\u0003\bÙ\u0002J\u0010\u0010Ú\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\bÛ\u0002J\u001b\u0010Ü\u0002\u001a\u00030·\u00012\t\b\u0002\u0010Ý\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bÞ\u0002J1\u0010ß\u0002\u001a\u00030·\u00012\t\b\u0002\u0010Ý\u0002\u001a\u00020\t2\t\b\u0002\u0010à\u0002\u001a\u00020\t2\t\b\u0002\u0010á\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bâ\u0002J\u001b\u0010ã\u0002\u001a\u00030·\u00012\t\b\u0002\u0010Ý\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bä\u0002J1\u0010å\u0002\u001a\u00030·\u00012\t\b\u0002\u0010Ý\u0002\u001a\u00020\t2\t\b\u0002\u0010à\u0002\u001a\u00020\t2\t\b\u0002\u0010á\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bæ\u0002J\u0019\u0010ç\u0002\u001a\u00030·\u00012\u0007\u0010è\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0003\bé\u0002J\n\u0010ê\u0002\u001a\u00030·\u0001H\u0002J\u0010\u0010ë\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\bì\u0002J\t\u0010í\u0002\u001a\u00020\tH\u0002J\n\u0010î\u0002\u001a\u00030î\u0001H\u0016J\u0010\u0010ï\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\bð\u0002R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00000\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00000\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR$\u0010!\u001a\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u001e\"\u0004\b%\u0010&R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020)0(8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u0010+R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00000(8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b/\u0010+R\u0016\u00100\u001a\u0004\u0018\u00010\u00128@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R,\u00104\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b8W@WX\u0097\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b5\u0010#\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010<\u001a\u00020;2\u0006\u0010:\u001a\u00020;@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020B8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR$\u0010F\u001a\u00020E2\u0006\u0010:\u001a\u00020E@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u00107\"\u0004\bM\u00109R\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00000(8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bO\u0010+R\u0014\u0010P\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010\u001eR\u0014\u0010R\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u00107R\u000e\u0010T\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010U\u001a\u00020\u00178@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0016\u0010X\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bY\u0010WR\u001a\u0010Z\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u001e\"\u0004\b\\\u0010&R\"\u0010]\u001a\n\u0018\u00010^j\u0004\u0018\u0001`_X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0010\u0010d\u001a\u0004\u0018\u00010eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010f\u001a\u00020gX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u0014\u0010l\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bl\u0010\u001eR\u001e\u0010m\u001a\u00020\t2\u0006\u00103\u001a\u00020\t@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\bm\u0010\u001eR\u0014\u0010n\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bn\u0010\u001eR\u0011\u0010o\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bo\u0010\u001eR\u0013\u0010p\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\bp\u0010qR\u0014\u0010r\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\br\u0010\u001eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010s\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\u001e\"\u0004\bu\u0010&R\u0014\u0010v\u001a\u00020wX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010yR$\u0010{\u001a\u00020z2\u0006\u0010:\u001a\u00020z@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR\u0016\u0010\u0080\u0001\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010\u001eR\u0018\u0010\u0082\u0001\u001a\u00030\u0083\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0016\u0010\u0086\u0001\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010\u001eR\u0016\u0010\u0088\u0001\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0089\u0001\u0010\u001eR\u001e\u0010\u008a\u0001\u001a\t\u0018\u00010\u008b\u0001R\u00020w8@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R.\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00002\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0000@BX\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0018\u0010\u0094\u0001\u001a\u00030\u0095\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001c\u0010\u0098\u0001\u001a\u00070\u0099\u0001R\u00020w8@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0016\u0010\u009c\u0001\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u009d\u0001\u0010\u001eR+\u0010\u009f\u0001\u001a\u00030\u009e\u00012\u0007\u0010:\u001a\u00030\u009e\u0001@VX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R\u0016\u0010¤\u0001\u001a\u00020g8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b¥\u0001\u0010iR\u0016\u0010¦\u0001\u001a\u00020g8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b§\u0001\u0010iR)\u0010¨\u0001\u001a\u00020\u00192\u0006\u0010:\u001a\u00020\u00198V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0006\b«\u0001\u0010¬\u0001R\u001d\u0010\u00ad\u0001\u001a\u00020\tX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0001\u0010\u001e\"\u0005\b¯\u0001\u0010&R\u0018\u0010°\u0001\u001a\u00030±\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b²\u0001\u0010³\u0001R0\u0010´\u0001\u001a\u0013\u0012\u0005\u0012\u00030¶\u0001\u0012\u0005\u0012\u00030·\u0001\u0018\u00010µ\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¸\u0001\u0010¹\u0001\"\u0006\bº\u0001\u0010»\u0001R0\u0010¼\u0001\u001a\u0013\u0012\u0005\u0012\u00030¶\u0001\u0012\u0005\u0012\u00030·\u0001\u0018\u00010µ\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b½\u0001\u0010¹\u0001\"\u0006\b¾\u0001\u0010»\u0001R\u0016\u0010¿\u0001\u001a\u00020\u00178@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bÀ\u0001\u0010WR'\u0010Á\u0001\u001a\u0005\u0018\u00010¶\u00012\t\u00103\u001a\u0005\u0018\u00010¶\u0001@BX\u0080\u000e¢\u0006\n\n\u0000\u001a\u0006\bÂ\u0001\u0010Ã\u0001R\u0019\u0010Ä\u0001\u001a\u0004\u0018\u00010\u00008@X\u0080\u0004¢\u0006\b\u001a\u0006\bÅ\u0001\u0010\u0091\u0001R\u0019\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\bÇ\u0001\u0010È\u0001R\u0011\u0010É\u0001\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Ê\u0001\u001a\u00020\u000b8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bË\u0001\u00107R\u000f\u0010Ì\u0001\u001a\u00020gX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÍ\u0001\u00107\"\u0005\bÎ\u0001\u00109R\"\u0010Ï\u0001\u001a\u0005\u0018\u00010Ð\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÑ\u0001\u0010Ò\u0001\"\u0006\bÓ\u0001\u0010Ô\u0001R\u000f\u0010Õ\u0001\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010×\u0001\u001a\u00030Ö\u00012\u0007\u0010:\u001a\u00030Ö\u0001@VX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bØ\u0001\u0010Ù\u0001\"\u0006\bÚ\u0001\u0010Û\u0001R\u000f\u0010Ü\u0001\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Ý\u0001\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÞ\u0001\u00107R\u0018\u0010ß\u0001\u001a\u00030à\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bá\u0001\u0010â\u0001R#\u0010ã\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e8@X\u0081\u0004¢\u0006\u000e\u0012\u0005\bä\u0001\u0010#\u001a\u0005\bå\u0001\u0010\u0010R\u000f\u0010æ\u0001\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006õ\u0002"}, m13886d2 = {"Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "Landroidx/compose/ui/layout/Remeasurement;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/layout/LayoutInfo;", "Landroidx/compose/ui/node/ComposeUiNode;", "Landroidx/compose/ui/node/InteroperableComposeUiNode;", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "isVirtual", "", "semanticsId", "", "(ZI)V", "_children", "Landroidx/compose/runtime/collection/MutableVector;", "get_children$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "_collapsedSemantics", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "_foldedChildren", "Landroidx/compose/ui/node/MutableVectorWithMutationTracking;", "_foldedParent", "_innerLayerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "_modifier", "Landroidx/compose/ui/Modifier;", "_unfoldedChildren", "_zSortedChildren", "alignmentLinesRequired", "getAlignmentLinesRequired$ui_release", "()Z", "applyingModifierOnAttach", "getApplyingModifierOnAttach$ui_release", "canMultiMeasure", "getCanMultiMeasure$ui_release$annotations", "()V", "getCanMultiMeasure$ui_release", "setCanMultiMeasure$ui_release", "(Z)V", "childLookaheadMeasurables", "", "Landroidx/compose/ui/layout/Measurable;", "getChildLookaheadMeasurables$ui_release", "()Ljava/util/List;", "childMeasurables", "getChildMeasurables$ui_release", "children", "getChildren$ui_release", "collapsedSemantics", "getCollapsedSemantics$ui_release", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "<set-?>", "compositeKeyHash", "getCompositeKeyHash$annotations", "getCompositeKeyHash", "()I", "setCompositeKeyHash", "(I)V", "value", "Landroidx/compose/runtime/CompositionLocalMap;", "compositionLocalMap", "getCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "setCompositionLocalMap", "(Landroidx/compose/runtime/CompositionLocalMap;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", DBSchema.CategoryTreeClosure.DEPTH, "getDepth$ui_release", "setDepth$ui_release", "foldedChildren", "getFoldedChildren$ui_release", "hasFixedInnerContentConstraints", "getHasFixedInnerContentConstraints$ui_release", "height", "getHeight", "ignoreRemeasureRequests", "innerCoordinator", "getInnerCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "innerLayerCoordinator", "getInnerLayerCoordinator", "innerLayerCoordinatorIsDirty", "getInnerLayerCoordinatorIsDirty$ui_release", "setInnerLayerCoordinatorIsDirty$ui_release", "interopViewFactoryHolder", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroidx/compose/ui/viewinterop/InteropViewFactoryHolder;", "getInteropViewFactoryHolder$ui_release", "()Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "setInteropViewFactoryHolder$ui_release", "(Landroidx/compose/ui/viewinterop/AndroidViewHolder;)V", "intrinsicsPolicy", "Landroidx/compose/ui/node/IntrinsicsPolicy;", "intrinsicsUsageByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getIntrinsicsUsageByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setIntrinsicsUsageByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "isAttached", "isDeactivated", "isPlaced", "isPlacedByParent", "isPlacedInLookahead", "()Ljava/lang/Boolean;", "isValidOwnerScope", "isVirtualLookaheadRoot", "isVirtualLookaheadRoot$ui_release", "setVirtualLookaheadRoot$ui_release", "layoutDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "getLayoutDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutPending", "getLayoutPending$ui_release", "layoutState", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "getLayoutState$ui_release", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "lookaheadLayoutPending", "getLookaheadLayoutPending$ui_release", "lookaheadMeasurePending", "getLookaheadMeasurePending$ui_release", "lookaheadPassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "getLookaheadPassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "newRoot", "lookaheadRoot", "getLookaheadRoot$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "setLookaheadRoot", "(Landroidx/compose/ui/node/LayoutNode;)V", "mDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getMDrawScope$ui_release", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "measurePassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "getMeasurePassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "measurePending", "getMeasurePending$ui_release", "Landroidx/compose/ui/layout/MeasurePolicy;", "measurePolicy", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "setMeasurePolicy", "(Landroidx/compose/ui/layout/MeasurePolicy;)V", "measuredByParent", "getMeasuredByParent$ui_release", "measuredByParentInLookahead", "getMeasuredByParentInLookahead$ui_release", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "needsOnPositionedDispatch", "getNeedsOnPositionedDispatch$ui_release", "setNeedsOnPositionedDispatch$ui_release", "nodes", "Landroidx/compose/ui/node/NodeChain;", "getNodes$ui_release", "()Landroidx/compose/ui/node/NodeChain;", "onAttach", "Lkotlin/Function1;", "Landroidx/compose/ui/node/Owner;", "", "getOnAttach$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnAttach$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "onDetach", "getOnDetach$ui_release", "setOnDetach$ui_release", "outerCoordinator", "getOuterCoordinator$ui_release", "owner", "getOwner$ui_release", "()Landroidx/compose/ui/node/Owner;", "parent", "getParent$ui_release", "parentInfo", "getParentInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "pendingModifier", "placeOrder", "getPlaceOrder$ui_release", "previousIntrinsicsUsageByParent", "getSemanticsId", "setSemanticsId", "subcompositionsState", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "getSubcompositionsState$ui_release", "()Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "setSubcompositionsState$ui_release", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "unfoldedVirtualChildrenListDirty", "Landroidx/compose/ui/platform/ViewConfiguration;", "viewConfiguration", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "setViewConfiguration", "(Landroidx/compose/ui/platform/ViewConfiguration;)V", "virtualChildrenCount", "width", "getWidth", "zIndex", "", "getZIndex", "()F", "zSortedChildren", "getZSortedChildren$annotations", "getZSortedChildren", "zSortedChildrenInvalidated", "applyModifier", "attach", "attach$ui_release", "clearSubtreeIntrinsicsUsage", "clearSubtreeIntrinsicsUsage$ui_release", "clearSubtreePlacementIntrinsicsUsage", "debugTreeToString", "", "detach", "detach$ui_release", "dispatchOnPositionedCallbacks", "dispatchOnPositionedCallbacks$ui_release", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "draw$ui_release", "forEachChild", "block", "forEachChildIndexed", "Lkotlin/Function2;", "forEachCoordinator", "Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "forEachCoordinator$ui_release", "forEachCoordinatorIncludingInner", "forEachCoordinatorIncludingInner$ui_release", "forceRemeasure", "getInteropView", "Landroid/view/View;", "Landroidx/compose/ui/viewinterop/InteropView;", "getModifierInfo", "Landroidx/compose/ui/layout/ModifierInfo;", "getOrCreateIntrinsicsPolicy", "hitTest", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "isInLayer", "hitTest-M_7yMNQ$ui_release", "(JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestSemantics", "hitSemanticsEntities", "hitTestSemantics-M_7yMNQ$ui_release", "Lkotlin/Function0;", "ignoreRemeasureRequests$ui_release", "insertAt", "index", "instance", "insertAt$ui_release", "invalidateFocusOnAttach", "invalidateLayer", "invalidateLayer$ui_release", "invalidateLayers", "invalidateLayers$ui_release", "invalidateMeasurements", "invalidateMeasurements$ui_release", "invalidateOnPositioned", "invalidateOnPositioned$ui_release", "invalidateParentData", "invalidateParentData$ui_release", "invalidateSemantics", "invalidateSemantics$ui_release", "invalidateSubtree", "isRootOfInvalidation", "invalidateUnfoldedVirtualChildren", "lookaheadRemeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "lookaheadRemeasure-_Sx5XlM$ui_release", "lookaheadReplace", "lookaheadReplace$ui_release", "markLayoutPending", "markLayoutPending$ui_release", "markLookaheadLayoutPending", "markLookaheadLayoutPending$ui_release", "markLookaheadMeasurePending", "markLookaheadMeasurePending$ui_release", "markMeasurePending", "markMeasurePending$ui_release", "maxIntrinsicHeight", "maxIntrinsicWidth", "maxLookaheadIntrinsicHeight", "maxLookaheadIntrinsicWidth", "minIntrinsicHeight", "minIntrinsicWidth", "minLookaheadIntrinsicHeight", "minLookaheadIntrinsicWidth", SecureFolderConstants.TEMP_FOLDER_NAME, Constants.MessagePayloadKeys.FROM, "to", "count", "move$ui_release", "onChildRemoved", "child", "onDeactivate", "onDensityOrLayoutDirectionChanged", "onLayoutComplete", "onRelease", "onReuse", "onZSortedChildrenInvalidated", "onZSortedChildrenInvalidated$ui_release", ServerResultMeetingParser.PLACE, "x", "y", "place$ui_release", "recreateUnfoldedChildrenIfDirty", "remeasure", "remeasure-_Sx5XlM$ui_release", "removeAll", "removeAll$ui_release", "removeAt", "removeAt$ui_release", Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_REPLACE, "replace$ui_release", "requestLookaheadRelayout", "forceRequest", "requestLookaheadRelayout$ui_release", "requestLookaheadRemeasure", "scheduleMeasureAndLayout", "invalidateIntrinsics", "requestLookaheadRemeasure$ui_release", "requestRelayout", "requestRelayout$ui_release", "requestRemeasure", "requestRemeasure$ui_release", "rescheduleRemeasureOrRelayout", LangPackConfigConstants.LANGUAGE_CODE_IT, "rescheduleRemeasureOrRelayout$ui_release", "resetModifierState", "resetSubtreeIntrinsicsUsage", "resetSubtreeIntrinsicsUsage$ui_release", "shouldInvalidateParentLayer", "toString", "updateChildrenIfDirty", "updateChildrenIfDirty$ui_release", "Companion", "LayoutState", "NoIntrinsicsMeasurePolicy", "UsageByParent", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLayoutNode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayoutNode.kt\nandroidx/compose/ui/node/LayoutNode\n+ 2 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 3 MutableVectorWithMutationTracking.kt\nandroidx/compose/ui/node/MutableVectorWithMutationTracking\n+ 4 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 5 InlineClassHelper.kt\nandroidx/compose/ui/internal/InlineClassHelperKt\n+ 6 NodeKind.kt\nandroidx/compose/ui/node/Nodes\n+ 7 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 8 NodeChain.kt\nandroidx/compose/ui/node/NodeChain\n+ 9 Modifier.kt\nandroidx/compose/ui/Modifier$Node\n+ 10 DelegatableNode.kt\nandroidx/compose/ui/node/DelegatableNodeKt\n+ 11 DelegatingNode.kt\nandroidx/compose/ui/node/DelegatingNode\n+ 12 NodeKind.kt\nandroidx/compose/ui/node/NodeKind\n+ 13 NodeKind.kt\nandroidx/compose/ui/node/NodeKindKt\n+ 14 NodeCoordinator.kt\nandroidx/compose/ui/node/NodeCoordinator\n*L\n1#1,1555:1\n1324#1,7:1562\n1324#1,7:1670\n1149#1,2:1687\n1151#1,2:1701\n202#1:1704\n1312#1,7:2069\n202#1:2244\n202#1:2256\n202#1:2268\n1324#1,7:2287\n1208#2:1556\n1187#2,2:1557\n1208#2:1559\n1187#2,2:1560\n1208#2:1569\n1187#2,2:1570\n1208#2:1759\n1187#2,2:1760\n1208#2:1833\n1187#2,2:1834\n1208#2:1907\n1187#2,2:1908\n1208#2:2030\n1187#2,2:2031\n1208#2:2112\n1187#2,2:2113\n1208#2:2197\n1187#2,2:2198\n48#3:1572\n48#3:1628\n48#3:1658\n48#3:1689\n460#4,7:1573\n146#4:1580\n467#4,4:1581\n460#4,11:1585\n476#4,11:1596\n460#4,11:1629\n460#4,11:1659\n460#4,11:1690\n146#4:1703\n460#4,11:1705\n460#4,11:2151\n460#4,11:2245\n460#4,11:2257\n460#4,11:2269\n42#5,7:1607\n42#5,7:1614\n96#5,7:1621\n42#5,7:1641\n42#5,7:1648\n66#5,9:1677\n66#5,9:1946\n96#5,7:1955\n96#5,7:1962\n42#5,7:1970\n96#5,7:2280\n82#6:1640\n82#6:1656\n94#6:1657\n82#6:1686\n84#6:1719\n80#6:1724\n84#6:1798\n107#6:1872\n94#6:1969\n96#6,3:1977\n100#6:1981\n96#6:1986\n98#6,3:1988\n92#6:1994\n92#6:2014\n78#6:2076\n78#6:2096\n90#6:2162\n80#6:2231\n78#6:2232\n78#6:2236\n78#6:2238\n80#6:2239\n1#7:1655\n720#8,3:1716\n723#8,3:1721\n697#8,8:1725\n720#8,3:1733\n705#8,2:1736\n698#8:1738\n699#8,11:1782\n723#8,3:1793\n710#8:1796\n700#8:1797\n697#8,8:1799\n720#8,3:1807\n705#8,2:1810\n698#8:1812\n699#8,11:1856\n723#8,3:1867\n710#8:1870\n700#8:1871\n697#8,8:1873\n720#8,3:1881\n705#8,2:1884\n698#8:1886\n699#8,11:1930\n723#8,3:1941\n710#8:1944\n700#8:1945\n720#8,3:1983\n723#8,3:1991\n697#8,8:1995\n720#8,3:2003\n705#8,2:2006\n698#8:2008\n699#8,11:2053\n723#8,3:2064\n710#8:2067\n700#8:2068\n697#8,8:2077\n720#8,3:2085\n705#8,2:2088\n698#8:2090\n699#8,11:2135\n723#8,3:2146\n710#8:2149\n700#8:2150\n720#8,3:2233\n723#8,3:2241\n249#9:1720\n249#9:1745\n249#9:1819\n249#9:1893\n249#9:1987\n249#9:2016\n249#9:2098\n249#9:2183\n249#9:2237\n249#9:2240\n432#10,6:1739\n442#10,2:1746\n444#10,8:1751\n452#10,9:1762\n461#10,8:1774\n432#10,6:1813\n442#10,2:1820\n444#10,8:1825\n452#10,9:1836\n461#10,8:1848\n432#10,6:1887\n442#10,2:1894\n444#10,8:1899\n452#10,9:1910\n461#10,8:1922\n432#10,5:2009\n437#10:2015\n442#10,2:2017\n444#10,8:2022\n452#10,9:2033\n461#10,8:2045\n432#10,5:2091\n437#10:2097\n442#10,2:2099\n444#10,8:2104\n452#10,9:2115\n461#10,8:2127\n432#10,6:2177\n442#10,2:2184\n444#10,8:2189\n452#10,9:2200\n461#10,8:2212\n245#11,3:1748\n248#11,3:1771\n245#11,3:1822\n248#11,3:1845\n245#11,3:1896\n248#11,3:1919\n245#11,3:2019\n248#11,3:2042\n245#11,3:2101\n248#11,3:2124\n245#11,3:2186\n248#11,3:2209\n53#12:1980\n58#13:1982\n115#14:2163\n104#14,13:2164\n117#14:2220\n109#14,10:2221\n*S KotlinDebug\n*F\n+ 1 LayoutNode.kt\nandroidx/compose/ui/node/LayoutNode\n*L\n119#1:1562,7\n510#1:1670,7\n543#1:1687,2\n543#1:1701,2\n612#1:1704\n1192#1:2069,7\n1360#1:2244\n1382#1:2256\n1394#1:2268\n1440#1:2287,7\n133#1:1556\n133#1:1557,2\n558#1:1559\n558#1:1560,2\n145#1:1569\n145#1:1570,2\n727#1:1759\n727#1:1760,2\n740#1:1833\n740#1:1834,2\n752#1:1907\n752#1:1908,2\n1176#1:2030\n1176#1:2031,2\n1274#1:2112\n1274#1:2113,2\n1303#1:2197\n1303#1:2198,2\n149#1:1572\n375#1:1628\n500#1:1658\n544#1:1689\n149#1:1573,7\n151#1:1580\n149#1:1581,4\n202#1:1585,11\n204#1:1596,11\n375#1:1629,11\n500#1:1659,11\n544#1:1690,11\n574#1:1703\n612#1:1705,11\n1278#1:2151,11\n1360#1:2245,11\n1382#1:2257,11\n1394#1:2269,11\n289#1:1607,7\n294#1:1614,7\n335#1:1621,7\n454#1:1641,7\n457#1:1648,7\n526#1:1677,9\n884#1:1946,9\n914#1:1955,7\n917#1:1962,7\n1102#1:1970,7\n1409#1:2280,7\n428#1:1640\n479#1:1656\n492#1:1657\n539#1:1686\n706#1:1719\n727#1:1724\n740#1:1798\n752#1:1872\n931#1:1969\n1139#1:1977,3\n1139#1:1981\n1141#1:1986\n1141#1:1988,3\n1176#1:1994\n1177#1:2014\n1274#1:2076\n1275#1:2096\n1303#1:2162\n1333#1:2231\n1333#1:2232\n1335#1:2236\n1336#1:2238\n1340#1:2239\n705#1:1716,3\n705#1:1721,3\n727#1:1725,8\n727#1:1733,3\n727#1:1736,2\n727#1:1738\n727#1:1782,11\n727#1:1793,3\n727#1:1796\n727#1:1797\n740#1:1799,8\n740#1:1807,3\n740#1:1810,2\n740#1:1812\n740#1:1856,11\n740#1:1867,3\n740#1:1870\n740#1:1871\n752#1:1873,8\n752#1:1881,3\n752#1:1884,2\n752#1:1886\n752#1:1930,11\n752#1:1941,3\n752#1:1944\n752#1:1945\n1140#1:1983,3\n1140#1:1991,3\n1176#1:1995,8\n1176#1:2003,3\n1176#1:2006,2\n1176#1:2008\n1176#1:2053,11\n1176#1:2064,3\n1176#1:2067\n1176#1:2068\n1274#1:2077,8\n1274#1:2085,3\n1274#1:2088,2\n1274#1:2090\n1274#1:2135,11\n1274#1:2146,3\n1274#1:2149\n1274#1:2150\n1334#1:2233,3\n1334#1:2241,3\n706#1:1720\n727#1:1745\n740#1:1819\n752#1:1893\n1141#1:1987\n1176#1:2016\n1274#1:2098\n1303#1:2183\n1335#1:2237\n1340#1:2240\n727#1:1739,6\n727#1:1746,2\n727#1:1751,8\n727#1:1762,9\n727#1:1774,8\n740#1:1813,6\n740#1:1820,2\n740#1:1825,8\n740#1:1836,9\n740#1:1848,8\n752#1:1887,6\n752#1:1894,2\n752#1:1899,8\n752#1:1910,9\n752#1:1922,8\n1176#1:2009,5\n1176#1:2015\n1176#1:2017,2\n1176#1:2022,8\n1176#1:2033,9\n1176#1:2045,8\n1274#1:2091,5\n1274#1:2097\n1274#1:2099,2\n1274#1:2104,8\n1274#1:2115,9\n1274#1:2127,8\n1303#1:2177,6\n1303#1:2184,2\n1303#1:2189,8\n1303#1:2200,9\n1303#1:2212,8\n727#1:1748,3\n727#1:1771,3\n740#1:1822,3\n740#1:1845,3\n752#1:1896,3\n752#1:1919,3\n1176#1:2019,3\n1176#1:2042,3\n1274#1:2101,3\n1274#1:2124,3\n1303#1:2186,3\n1303#1:2209,3\n1139#1:1980\n1139#1:1982\n1303#1:2163\n1303#1:2164,13\n1303#1:2220\n1303#1:2221,10\n*E\n"})
public final class LayoutNode implements ComposeNodeLifecycleCallback, Remeasurement, OwnerScope, LayoutInfo, ComposeUiNode, InteroperableComposeUiNode, Owner.OnLayoutCompletedListener {
    public static final int NotPlacedPlaceOrder = Integer.MAX_VALUE;

    @Nullable
    private SemanticsConfiguration _collapsedSemantics;

    @NotNull
    private final MutableVectorWithMutationTracking<LayoutNode> _foldedChildren;

    @Nullable
    private LayoutNode _foldedParent;

    @Nullable
    private NodeCoordinator _innerLayerCoordinator;

    @NotNull
    private Modifier _modifier;

    @Nullable
    private MutableVector<LayoutNode> _unfoldedChildren;

    @NotNull
    private final MutableVector<LayoutNode> _zSortedChildren;
    private boolean canMultiMeasure;
    private int compositeKeyHash;

    @NotNull
    private CompositionLocalMap compositionLocalMap;

    @NotNull
    private Density density;
    private int depth;
    private boolean ignoreRemeasureRequests;
    private boolean innerLayerCoordinatorIsDirty;

    @Nullable
    private AndroidViewHolder interopViewFactoryHolder;

    @Nullable
    private IntrinsicsPolicy intrinsicsPolicy;

    @NotNull
    private UsageByParent intrinsicsUsageByParent;
    private boolean isDeactivated;
    private final boolean isVirtual;
    private boolean isVirtualLookaheadRoot;

    @NotNull
    private final LayoutNodeLayoutDelegate layoutDelegate;

    @NotNull
    private LayoutDirection layoutDirection;

    @Nullable
    private LayoutNode lookaheadRoot;

    @NotNull
    private MeasurePolicy measurePolicy;
    private boolean needsOnPositionedDispatch;

    @NotNull
    private final NodeChain nodes;

    @Nullable
    private Function1<? super Owner, Unit> onAttach;

    @Nullable
    private Function1<? super Owner, Unit> onDetach;

    @Nullable
    private Owner owner;

    @Nullable
    private Modifier pendingModifier;

    @NotNull
    private UsageByParent previousIntrinsicsUsageByParent;
    private int semanticsId;

    @Nullable
    private LayoutNodeSubcompositionsState subcompositionsState;
    private boolean unfoldedVirtualChildrenListDirty;

    @NotNull
    private ViewConfiguration viewConfiguration;
    private int virtualChildrenCount;
    private boolean zSortedChildrenInvalidated;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private static final NoIntrinsicsMeasurePolicy ErrorMeasurePolicy = new NoIntrinsicsMeasurePolicy() { // from class: androidx.compose.ui.node.LayoutNode$Companion$ErrorMeasurePolicy$1
        @Override // androidx.compose.p109ui.layout.MeasurePolicy
        /* JADX INFO: renamed from: measure-3p2s80s */
        public /* bridge */ /* synthetic */ MeasureResult mo15214measure3p2s80s(MeasureScope measureScope, List list, long j) {
            return (MeasureResult) m20012measure3p2s80s(measureScope, (List<? extends Measurable>) list, j);
        }

        @NotNull
        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
        public Void m20012measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
            throw new IllegalStateException("Undefined measure and it is required");
        }
    };

    @NotNull
    private static final Function0<LayoutNode> Constructor = new Function0<LayoutNode>() { // from class: androidx.compose.ui.node.LayoutNode$Companion$Constructor$1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final LayoutNode invoke() {
            return new LayoutNode(false, 0 == true ? 1 : 0, 3, null);
        }
    };

    @NotNull
    private static final ViewConfiguration DummyViewConfiguration = new ViewConfiguration() { // from class: androidx.compose.ui.node.LayoutNode$Companion$DummyViewConfiguration$1
        @Override // androidx.compose.p109ui.platform.ViewConfiguration
        public long getDoubleTapMinTimeMillis() {
            return 40L;
        }

        @Override // androidx.compose.p109ui.platform.ViewConfiguration
        public long getDoubleTapTimeoutMillis() {
            return 300L;
        }

        @Override // androidx.compose.p109ui.platform.ViewConfiguration
        public long getLongPressTimeoutMillis() {
            return 400L;
        }

        @Override // androidx.compose.p109ui.platform.ViewConfiguration
        /* JADX INFO: renamed from: getMinimumTouchTargetSize-MYxV2XQ, reason: not valid java name */
        public long mo20011getMinimumTouchTargetSizeMYxV2XQ() {
            return DpSize.INSTANCE.m21076getZeroMYxV2XQ();
        }

        @Override // androidx.compose.p109ui.platform.ViewConfiguration
        public float getTouchSlop() {
            return 16.0f;
        }
    };

    @NotNull
    private static final Comparator<LayoutNode> ZComparator = new C0016a(5);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0080T¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0002R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m13886d2 = {"Landroidx/compose/ui/node/LayoutNode$Companion;", "", "()V", "Constructor", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "getConstructor$ui_release", "()Lkotlin/jvm/functions/Function0;", "DummyViewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getDummyViewConfiguration$ui_release", "()Landroidx/compose/ui/platform/ViewConfiguration;", "ErrorMeasurePolicy", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "NotPlacedPlaceOrder", "", "getNotPlacedPlaceOrder$ui_release$annotations", "ZComparator", "Ljava/util/Comparator;", "getZComparator$ui_release", "()Ljava/util/Comparator;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Function0<LayoutNode> getConstructor$ui_release() {
            return LayoutNode.Constructor;
        }

        @NotNull
        public final ViewConfiguration getDummyViewConfiguration$ui_release() {
            return LayoutNode.DummyViewConfiguration;
        }

        @NotNull
        public final Comparator<LayoutNode> getZComparator$ui_release() {
            return LayoutNode.ZComparator;
        }

        private Companion() {
        }

        public static /* synthetic */ void getNotPlacedPlaceOrder$ui_release$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Landroidx/compose/ui/node/LayoutNode$LayoutState;", "", "(Ljava/lang/String;I)V", "Measuring", "LookaheadMeasuring", "LayingOut", "LookaheadLayingOut", "Idle", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public enum LayoutState {
        Measuring,
        LookaheadMeasuring,
        LayingOut,
        LookaheadLayingOut,
        Idle
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\"\u0010\u000f\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\u0010\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "error", "", "(Ljava/lang/String;)V", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "", "maxIntrinsicWidth", "height", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static abstract class NoIntrinsicsMeasurePolicy implements MeasurePolicy {
        public static final int $stable = 0;

        @NotNull
        private final String error;

        public NoIntrinsicsMeasurePolicy(@NotNull String str) {
            this.error = str;
        }

        @Override // androidx.compose.p109ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return ((Number) m20013maxIntrinsicHeight(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i)).intValue();
        }

        @Override // androidx.compose.p109ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return ((Number) m20014maxIntrinsicWidth(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i)).intValue();
        }

        @Override // androidx.compose.p109ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return ((Number) m20015minIntrinsicHeight(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i)).intValue();
        }

        @Override // androidx.compose.p109ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return ((Number) m20016minIntrinsicWidth(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i)).intValue();
        }

        @NotNull
        /* JADX INFO: renamed from: maxIntrinsicHeight, reason: collision with other method in class */
        public Void m20013maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
            throw new IllegalStateException(this.error.toString());
        }

        @NotNull
        /* JADX INFO: renamed from: maxIntrinsicWidth, reason: collision with other method in class */
        public Void m20014maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
            throw new IllegalStateException(this.error.toString());
        }

        @NotNull
        /* JADX INFO: renamed from: minIntrinsicHeight, reason: collision with other method in class */
        public Void m20015minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
            throw new IllegalStateException(this.error.toString());
        }

        @NotNull
        /* JADX INFO: renamed from: minIntrinsicWidth, reason: collision with other method in class */
        public Void m20016minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
            throw new IllegalStateException(this.error.toString());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "", "(Ljava/lang/String;I)V", "InMeasureBlock", "InLayoutBlock", "NotUsed", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public enum UsageByParent {
        InMeasureBlock,
        InLayoutBlock,
        NotUsed
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutState.values().length];
            try {
                iArr[LayoutState.Idle.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LayoutNode() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ZComparator$lambda$41(LayoutNode layoutNode, LayoutNode layoutNode2) {
        return layoutNode.getZIndex() == layoutNode2.getZIndex() ? Intrinsics.compare(layoutNode.getPlaceOrder$ui_release(), layoutNode2.getPlaceOrder$ui_release()) : Float.compare(layoutNode.getZIndex(), layoutNode2.getZIndex());
    }

    private final void applyModifier(Modifier modifier) {
        this._modifier = modifier;
        this.nodes.updateFrom$ui_release(modifier);
        this.layoutDelegate.updateParentData();
        if (this.lookaheadRoot == null && this.nodes.m20051hasH91voCI$ui_release(NodeKind.m20090constructorimpl(512))) {
            setLookaheadRoot(this);
        }
    }

    private final void clearSubtreePlacementIntrinsicsUsage() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode = content[i];
                if (layoutNode.intrinsicsUsageByParent == UsageByParent.InLayoutBlock) {
                    layoutNode.clearSubtreePlacementIntrinsicsUsage();
                }
                i++;
            } while (i < size);
        }
    }

    private final String debugTreeToString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append(com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant.WHITE_SPACE_FOR_LINK_ICON);
        }
        sb.append("|-");
        sb.append(toString());
        sb.append('\n');
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i2 = 0;
            do {
                sb.append(content[i2].debugTreeToString(depth + 1));
                i2++;
            } while (i2 < size);
        }
        String string = sb.toString();
        if (depth != 0) {
            return string;
        }
        String strSubstring = string.substring(0, string.length() - 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String debugTreeToString$default(LayoutNode layoutNode, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return layoutNode.debugTreeToString(i);
    }

    private final NodeCoordinator getInnerLayerCoordinator() {
        if (this.innerLayerCoordinatorIsDirty) {
            NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
            NodeCoordinator wrappedBy = getOuterCoordinator$ui_release().getWrappedBy();
            this._innerLayerCoordinator = null;
            while (true) {
                if (Intrinsics.areEqual(innerCoordinator$ui_release, wrappedBy)) {
                    break;
                }
                if ((innerCoordinator$ui_release != null ? innerCoordinator$ui_release.getLayer() : null) != null) {
                    this._innerLayerCoordinator = innerCoordinator$ui_release;
                    break;
                }
                innerCoordinator$ui_release = innerCoordinator$ui_release != null ? innerCoordinator$ui_release.getWrappedBy() : null;
            }
        }
        NodeCoordinator nodeCoordinator = this._innerLayerCoordinator;
        if (nodeCoordinator == null || nodeCoordinator.getLayer() != null) {
            return nodeCoordinator;
        }
        throw AbstractC1974b.m1327t("layer was not set");
    }

    private final IntrinsicsPolicy getOrCreateIntrinsicsPolicy() {
        IntrinsicsPolicy intrinsicsPolicy = this.intrinsicsPolicy;
        if (intrinsicsPolicy != null) {
            return intrinsicsPolicy;
        }
        IntrinsicsPolicy intrinsicsPolicy2 = new IntrinsicsPolicy(this, getMeasurePolicy());
        this.intrinsicsPolicy = intrinsicsPolicy2;
        return intrinsicsPolicy2;
    }

    private final float getZIndex() {
        return getMeasurePassDelegate$ui_release().getZIndex$ui_release();
    }

    /* JADX INFO: renamed from: hitTest-M_7yMNQ$ui_release$default, reason: not valid java name */
    public static /* synthetic */ void m20003hitTestM_7yMNQ$ui_release$default(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            z2 = true;
        }
        layoutNode.m20007hitTestM_7yMNQ$ui_release(j, hitTestResult, z3, z2);
    }

    /* JADX INFO: renamed from: hitTestSemantics-M_7yMNQ$ui_release$default, reason: not valid java name */
    public static /* synthetic */ void m20004hitTestSemanticsM_7yMNQ$ui_release$default(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        layoutNode.m20008hitTestSemanticsM_7yMNQ$ui_release(j, hitTestResult, z, z2);
    }

    private final void invalidateFocusOnAttach() {
        if (this.nodes.has$ui_release(NodeKind.m20090constructorimpl(1024) | NodeKind.m20090constructorimpl(2048) | NodeKind.m20090constructorimpl(4096))) {
            for (Modifier.Node head = this.nodes.getHead(); head != null; head = head.getChild()) {
                if (((NodeKind.m20090constructorimpl(1024) & head.getKindSet()) != 0) | ((NodeKind.m20090constructorimpl(2048) & head.getKindSet()) != 0) | ((NodeKind.m20090constructorimpl(4096) & head.getKindSet()) != 0)) {
                    NodeKindKt.autoInvalidateInsertedNode(head);
                }
            }
        }
    }

    public static /* synthetic */ void invalidateSubtree$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        layoutNode.invalidateSubtree(z);
    }

    private final void invalidateUnfoldedVirtualChildren() {
        LayoutNode layoutNode;
        if (this.virtualChildrenCount > 0) {
            this.unfoldedVirtualChildrenListDirty = true;
        }
        if (!this.isVirtual || (layoutNode = this._foldedParent) == null) {
            return;
        }
        layoutNode.invalidateUnfoldedVirtualChildren();
    }

    /* JADX INFO: renamed from: lookaheadRemeasure-_Sx5XlM$ui_release$default, reason: not valid java name */
    public static /* synthetic */ boolean m20005lookaheadRemeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode, Constraints constraints, int i, Object obj) {
        if ((i & 1) != 0) {
            constraints = layoutNode.layoutDelegate.m20024getLastLookaheadConstraintsDWUhwKw();
        }
        return layoutNode.m20009lookaheadRemeasure_Sx5XlM$ui_release(constraints);
    }

    private final void onChildRemoved(LayoutNode child) {
        if (child.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            this.layoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(r0.getChildrenAccessingCoordinatesDuringPlacement() - 1);
        }
        if (this.owner != null) {
            child.detach$ui_release();
        }
        child._foldedParent = null;
        child.getOuterCoordinator$ui_release().setWrappedBy$ui_release(null);
        if (child.isVirtual) {
            this.virtualChildrenCount--;
            MutableVector<LayoutNode> vector = child._foldedChildren.getVector();
            int size = vector.getSize();
            if (size > 0) {
                LayoutNode[] content = vector.getContent();
                int i = 0;
                do {
                    content[i].getOuterCoordinator$ui_release().setWrappedBy$ui_release(null);
                    i++;
                } while (i < size);
            }
        }
        invalidateUnfoldedVirtualChildren();
        onZSortedChildrenInvalidated$ui_release();
    }

    private final void onDensityOrLayoutDirectionChanged() {
        invalidateMeasurements$ui_release();
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
        invalidateLayers$ui_release();
    }

    private final void recreateUnfoldedChildrenIfDirty() {
        if (this.unfoldedVirtualChildrenListDirty) {
            int i = 0;
            this.unfoldedVirtualChildrenListDirty = false;
            MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
            if (mutableVector == null) {
                mutableVector = new MutableVector<>(new LayoutNode[16], 0);
                this._unfoldedChildren = mutableVector;
            }
            mutableVector.clear();
            MutableVector<LayoutNode> vector = this._foldedChildren.getVector();
            int size = vector.getSize();
            if (size > 0) {
                LayoutNode[] content = vector.getContent();
                do {
                    LayoutNode layoutNode = content[i];
                    if (layoutNode.isVirtual) {
                        mutableVector.addAll(mutableVector.getSize(), layoutNode.get_children$ui_release());
                    } else {
                        mutableVector.add(layoutNode);
                    }
                    i++;
                } while (i < size);
            }
            this.layoutDelegate.markChildrenDirty();
        }
    }

    /* JADX INFO: renamed from: remeasure-_Sx5XlM$ui_release$default, reason: not valid java name */
    public static /* synthetic */ boolean m20006remeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode, Constraints constraints, int i, Object obj) {
        if ((i & 1) != 0) {
            constraints = layoutNode.layoutDelegate.m20023getLastConstraintsDWUhwKw();
        }
        return layoutNode.m20010remeasure_Sx5XlM$ui_release(constraints);
    }

    public static /* synthetic */ void requestLookaheadRelayout$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestLookaheadRelayout$ui_release(z);
    }

    public static /* synthetic */ void requestLookaheadRemeasure$ui_release$default(LayoutNode layoutNode, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            z3 = true;
        }
        layoutNode.requestLookaheadRemeasure$ui_release(z, z2, z3);
    }

    public static /* synthetic */ void requestRelayout$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestRelayout$ui_release(z);
    }

    public static /* synthetic */ void requestRemeasure$ui_release$default(LayoutNode layoutNode, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            z3 = true;
        }
        layoutNode.requestRemeasure$ui_release(z, z2, z3);
    }

    private final void resetModifierState() {
        this.nodes.resetState$ui_release();
    }

    private final void setLookaheadRoot(LayoutNode layoutNode) {
        if (Intrinsics.areEqual(layoutNode, this.lookaheadRoot)) {
            return;
        }
        this.lookaheadRoot = layoutNode;
        if (layoutNode != null) {
            this.layoutDelegate.ensureLookaheadDelegateCreated$ui_release();
            NodeCoordinator wrapped = getInnerCoordinator$ui_release().getWrapped();
            for (NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(outerCoordinator$ui_release, wrapped) && outerCoordinator$ui_release != null; outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped()) {
                outerCoordinator$ui_release.ensureLookaheadDelegateCreated();
            }
        }
        invalidateMeasurements$ui_release();
    }

    private final boolean shouldInvalidateParentLayer() {
        if (this.nodes.m20051hasH91voCI$ui_release(NodeKind.m20090constructorimpl(4)) && !this.nodes.m20051hasH91voCI$ui_release(NodeKind.m20090constructorimpl(2))) {
            return true;
        }
        for (Modifier.Node head = this.nodes.getHead(); head != null; head = head.getChild()) {
            if ((NodeKind.m20090constructorimpl(2) & head.getKindSet()) != 0 && DelegatableNodeKt.m19977requireCoordinator64DMado(head, NodeKind.m20090constructorimpl(2)).getLayer() != null) {
                return false;
            }
            if ((NodeKind.m20090constructorimpl(4) & head.getKindSet()) != 0) {
                return true;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void attach$ui_release(@NotNull Owner owner) {
        boolean z;
        LayoutNode layoutNode;
        int i = 0;
        if (!(this.owner == null)) {
            InlineClassHelperKt.throwIllegalStateException("Cannot attach " + this + " as it already is attached.  Tree: " + debugTreeToString$default(this, 0, 1, null));
        }
        LayoutNode layoutNode2 = this._foldedParent;
        if (layoutNode2 == null) {
            z = true;
        } else if (!Intrinsics.areEqual(layoutNode2 != null ? layoutNode2.owner : null, owner)) {
            z = false;
        }
        if (!z) {
            StringBuilder sb = new StringBuilder("Attaching to a different owner(");
            sb.append(owner);
            sb.append(") than the parent's owner(");
            LayoutNode parent$ui_release = getParent$ui_release();
            sb.append(parent$ui_release != null ? parent$ui_release.owner : null);
            sb.append("). This tree: ");
            sb.append(debugTreeToString$default(this, 0, 1, null));
            sb.append(" Parent tree: ");
            LayoutNode layoutNode3 = this._foldedParent;
            sb.append(layoutNode3 != null ? debugTreeToString$default(layoutNode3, 0, 1, null) : null);
            InlineClassHelperKt.throwIllegalStateException(sb.toString());
        }
        LayoutNode parent$ui_release2 = getParent$ui_release();
        if (parent$ui_release2 == null) {
            getMeasurePassDelegate$ui_release().setPlaced$ui_release(true);
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
            if (lookaheadPassDelegate$ui_release != null) {
                lookaheadPassDelegate$ui_release.setPlaced(true);
            }
        }
        getOuterCoordinator$ui_release().setWrappedBy$ui_release(parent$ui_release2 != null ? parent$ui_release2.getInnerCoordinator$ui_release() : null);
        this.owner = owner;
        this.depth = (parent$ui_release2 != null ? parent$ui_release2.depth : -1) + 1;
        Modifier modifier = this.pendingModifier;
        if (modifier != null) {
            applyModifier(modifier);
        }
        this.pendingModifier = null;
        if (this.nodes.m20051hasH91voCI$ui_release(NodeKind.m20090constructorimpl(8))) {
            invalidateSemantics$ui_release();
        }
        owner.onAttach(this);
        if (this.isVirtualLookaheadRoot) {
            setLookaheadRoot(this);
        } else {
            LayoutNode layoutNode4 = this._foldedParent;
            if (layoutNode4 == null || (layoutNode = layoutNode4.lookaheadRoot) == null) {
                layoutNode = this.lookaheadRoot;
            }
            setLookaheadRoot(layoutNode);
            if (this.lookaheadRoot == null && this.nodes.m20051hasH91voCI$ui_release(NodeKind.m20090constructorimpl(512))) {
                setLookaheadRoot(this);
            }
        }
        if (!getIsDeactivated()) {
            this.nodes.markAsAttached();
        }
        MutableVector<LayoutNode> vector = this._foldedChildren.getVector();
        int size = vector.getSize();
        if (size > 0) {
            LayoutNode[] content = vector.getContent();
            do {
                content[i].attach$ui_release(owner);
                i++;
            } while (i < size);
        }
        if (!getIsDeactivated()) {
            this.nodes.runAttachLifecycle();
        }
        invalidateMeasurements$ui_release();
        if (parent$ui_release2 != null) {
            parent$ui_release2.invalidateMeasurements$ui_release();
        }
        NodeCoordinator wrapped = getInnerCoordinator$ui_release().getWrapped();
        for (NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(outerCoordinator$ui_release, wrapped) && outerCoordinator$ui_release != null; outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped()) {
            outerCoordinator$ui_release.onLayoutNodeAttach();
        }
        Function1<? super Owner, Unit> function1 = this.onAttach;
        if (function1 != null) {
            function1.invoke(owner);
        }
        this.layoutDelegate.updateParentData();
        if (getIsDeactivated()) {
            return;
        }
        invalidateFocusOnAttach();
    }

    public final void clearSubtreeIntrinsicsUsage$ui_release() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode = content[i];
                if (layoutNode.intrinsicsUsageByParent != UsageByParent.NotUsed) {
                    layoutNode.clearSubtreeIntrinsicsUsage$ui_release();
                }
                i++;
            } while (i < size);
        }
    }

    public final void detach$ui_release() {
        Owner owner = this.owner;
        if (owner == null) {
            StringBuilder sb = new StringBuilder("Cannot detach node that is already detached!  Tree: ");
            LayoutNode parent$ui_release = getParent$ui_release();
            sb.append(parent$ui_release != null ? debugTreeToString$default(parent$ui_release, 0, 1, null) : null);
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(sb.toString());
            throw new KotlinNothingValueException();
        }
        LayoutNode parent$ui_release2 = getParent$ui_release();
        if (parent$ui_release2 != null) {
            parent$ui_release2.invalidateLayer$ui_release();
            parent$ui_release2.invalidateMeasurements$ui_release();
            LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate$ui_release = getMeasurePassDelegate$ui_release();
            UsageByParent usageByParent = UsageByParent.NotUsed;
            measurePassDelegate$ui_release.setMeasuredByParent$ui_release(usageByParent);
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
            if (lookaheadPassDelegate$ui_release != null) {
                lookaheadPassDelegate$ui_release.setMeasuredByParent$ui_release(usageByParent);
            }
        }
        this.layoutDelegate.resetAlignmentLines();
        Function1<? super Owner, Unit> function1 = this.onDetach;
        if (function1 != null) {
            function1.invoke(owner);
        }
        if (this.nodes.m20051hasH91voCI$ui_release(NodeKind.m20090constructorimpl(8))) {
            invalidateSemantics$ui_release();
        }
        this.nodes.runDetachLifecycle$ui_release();
        this.ignoreRemeasureRequests = true;
        MutableVector<LayoutNode> vector = this._foldedChildren.getVector();
        int size = vector.getSize();
        if (size > 0) {
            LayoutNode[] content = vector.getContent();
            int i = 0;
            do {
                content[i].detach$ui_release();
                i++;
            } while (i < size);
        }
        this.ignoreRemeasureRequests = false;
        this.nodes.markAsDetached$ui_release();
        owner.onDetach(this);
        this.owner = null;
        setLookaheadRoot(null);
        this.depth = 0;
        getMeasurePassDelegate$ui_release().onNodeDetached();
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release2 = getLookaheadPassDelegate$ui_release();
        if (lookaheadPassDelegate$ui_release2 != null) {
            lookaheadPassDelegate$ui_release2.onNodeDetached();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6 */
    public final void dispatchOnPositionedCallbacks$ui_release() {
        if (getLayoutState$ui_release() != LayoutState.Idle || getLayoutPending$ui_release() || getMeasurePending$ui_release() || getIsDeactivated() || !isPlaced()) {
            return;
        }
        NodeChain nodeChain = this.nodes;
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(256);
        if ((nodeChain.getAggregateChildKindSet() & iM20090constructorimpl) != 0) {
            for (Modifier.Node head = nodeChain.getHead(); head != null; head = head.getChild()) {
                if ((head.getKindSet() & iM20090constructorimpl) != 0) {
                    Modifier.Node nodePop = head;
                    MutableVector mutableVector = null;
                    while (nodePop != 0) {
                        if (nodePop instanceof GlobalPositionAwareModifierNode) {
                            GlobalPositionAwareModifierNode globalPositionAwareModifierNode = (GlobalPositionAwareModifierNode) nodePop;
                            globalPositionAwareModifierNode.onGloballyPositioned(DelegatableNodeKt.m19977requireCoordinator64DMado(globalPositionAwareModifierNode, NodeKind.m20090constructorimpl(256)));
                        } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                            Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate();
                            int i = 0;
                            nodePop = nodePop;
                            while (delegate$ui_release != null) {
                                if ((delegate$ui_release.getKindSet() & iM20090constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        nodePop = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (nodePop != 0) {
                                            mutableVector.add(nodePop);
                                            nodePop = 0;
                                        }
                                        mutableVector.add(delegate$ui_release);
                                    }
                                }
                                delegate$ui_release = delegate$ui_release.getChild();
                                nodePop = nodePop;
                            }
                            if (i == 1) {
                            }
                        }
                        nodePop = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head.getAggregateChildKindSet() & iM20090constructorimpl) == 0) {
                    return;
                }
            }
        }
    }

    public final void draw$ui_release(@NotNull Canvas canvas, @Nullable GraphicsLayer graphicsLayer) {
        getOuterCoordinator$ui_release().draw(canvas, graphicsLayer);
    }

    public final void forEachChild(@NotNull Function1<? super LayoutNode, Unit> block) {
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                block.invoke(content[i]);
                i++;
            } while (i < size);
        }
    }

    public final void forEachChildIndexed(@NotNull Function2<? super Integer, ? super LayoutNode, Unit> block) {
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                block.invoke(Integer.valueOf(i), content[i]);
                i++;
            } while (i < size);
        }
    }

    public final void forEachCoordinator$ui_release(@NotNull Function1<? super LayoutModifierNodeCoordinator, Unit> block) {
        NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release();
        NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
        while (outerCoordinator$ui_release != innerCoordinator$ui_release) {
            Intrinsics.checkNotNull(outerCoordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) outerCoordinator$ui_release;
            block.invoke(layoutModifierNodeCoordinator);
            outerCoordinator$ui_release = layoutModifierNodeCoordinator.getWrapped();
        }
    }

    public final void forEachCoordinatorIncludingInner$ui_release(@NotNull Function1<? super NodeCoordinator, Unit> block) {
        NodeCoordinator wrapped = getInnerCoordinator$ui_release().getWrapped();
        for (NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(outerCoordinator$ui_release, wrapped) && outerCoordinator$ui_release != null; outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped()) {
            block.invoke(outerCoordinator$ui_release);
        }
    }

    @Override // androidx.compose.p109ui.layout.Remeasurement
    public void forceRemeasure() {
        LayoutNode layoutNode;
        if (this.lookaheadRoot != null) {
            layoutNode = this;
            requestLookaheadRemeasure$ui_release$default(layoutNode, false, false, false, 5, null);
        } else {
            requestRemeasure$ui_release$default(this, false, false, false, 5, null);
            layoutNode = this;
        }
        Constraints constraintsM20023getLastConstraintsDWUhwKw = layoutNode.layoutDelegate.m20023getLastConstraintsDWUhwKw();
        if (constraintsM20023getLastConstraintsDWUhwKw != null) {
            Owner owner = layoutNode.owner;
            if (owner != null) {
                owner.mo20146measureAndLayout0kLqBqw(this, constraintsM20023getLastConstraintsDWUhwKw.getValue());
                return;
            }
            return;
        }
        Owner owner2 = layoutNode.owner;
        if (owner2 != null) {
            Owner.measureAndLayout$default(owner2, false, 1, null);
        }
    }

    public final boolean getAlignmentLinesRequired$ui_release() {
        AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release;
        AlignmentLines alignmentLines;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
        return layoutNodeLayoutDelegate.getAlignmentLinesOwner$ui_release().getAlignmentLines().getRequired$ui_release() || !((lookaheadAlignmentLinesOwner$ui_release = layoutNodeLayoutDelegate.getLookaheadAlignmentLinesOwner$ui_release()) == null || (alignmentLines = lookaheadAlignmentLinesOwner$ui_release.getAlignmentLines()) == null || !alignmentLines.getRequired$ui_release());
    }

    public final boolean getApplyingModifierOnAttach$ui_release() {
        return this.pendingModifier != null;
    }

    /* JADX INFO: renamed from: getCanMultiMeasure$ui_release, reason: from getter */
    public final boolean getCanMultiMeasure() {
        return this.canMultiMeasure;
    }

    @NotNull
    public final List<Measurable> getChildLookaheadMeasurables$ui_release() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
        return lookaheadPassDelegate$ui_release.getChildDelegates$ui_release();
    }

    @NotNull
    public final List<Measurable> getChildMeasurables$ui_release() {
        return getMeasurePassDelegate$ui_release().getChildDelegates$ui_release();
    }

    @NotNull
    public final List<LayoutNode> getChildren$ui_release() {
        return get_children$ui_release().asMutableList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, androidx.compose.ui.semantics.SemanticsConfiguration] */
    @Nullable
    public final SemanticsConfiguration getCollapsedSemantics$ui_release() {
        if (!isAttached() || getIsDeactivated()) {
            return null;
        }
        if (!this.nodes.m20051hasH91voCI$ui_release(NodeKind.m20090constructorimpl(8)) || this._collapsedSemantics != null) {
            return this._collapsedSemantics;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new SemanticsConfiguration();
        LayoutNodeKt.requireOwner(this).getSnapshotObserver().observeSemanticsReads$ui_release(this, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNode$collapsedSemantics$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v6 */
            /* JADX WARN: Type inference failed for: r6v7, types: [T, androidx.compose.ui.semantics.SemanticsConfiguration] */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                NodeChain nodes = this.this$0.getNodes();
                int iM20090constructorimpl = NodeKind.m20090constructorimpl(8);
                Ref.ObjectRef<SemanticsConfiguration> objectRef2 = objectRef;
                if ((nodes.getAggregateChildKindSet() & iM20090constructorimpl) != 0) {
                    for (Modifier.Node tail = nodes.getTail(); tail != null; tail = tail.getParent()) {
                        if ((tail.getKindSet() & iM20090constructorimpl) != 0) {
                            Modifier.Node nodePop = tail;
                            MutableVector mutableVector = null;
                            while (nodePop != 0) {
                                if (nodePop instanceof SemanticsModifierNode) {
                                    SemanticsModifierNode semanticsModifierNode = (SemanticsModifierNode) nodePop;
                                    if (semanticsModifierNode.getIsClearingSemantics()) {
                                        ?? semanticsConfiguration = new SemanticsConfiguration();
                                        objectRef2.element = semanticsConfiguration;
                                        semanticsConfiguration.setClearingSemantics(true);
                                    }
                                    if (semanticsModifierNode.getShouldMergeDescendantSemantics()) {
                                        objectRef2.element.setMergingSemanticsOfDescendants(true);
                                    }
                                    semanticsModifierNode.applySemantics(objectRef2.element);
                                } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                    Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                                    int i = 0;
                                    nodePop = nodePop;
                                    while (delegate != null) {
                                        if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                nodePop = delegate;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != 0) {
                                                    mutableVector.add(nodePop);
                                                    nodePop = 0;
                                                }
                                                mutableVector.add(delegate);
                                            }
                                        }
                                        delegate = delegate.getChild();
                                        nodePop = nodePop;
                                    }
                                    if (i == 1) {
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                    }
                }
            }
        });
        T t = objectRef.element;
        this._collapsedSemantics = (SemanticsConfiguration) t;
        return (SemanticsConfiguration) t;
    }

    @Override // androidx.compose.p109ui.node.ComposeUiNode
    @ExperimentalComposeUiApi
    public int getCompositeKeyHash() {
        return this.compositeKeyHash;
    }

    @Override // androidx.compose.p109ui.node.ComposeUiNode
    @NotNull
    public CompositionLocalMap getCompositionLocalMap() {
        return this.compositionLocalMap;
    }

    @Override // androidx.compose.p109ui.layout.LayoutInfo
    @NotNull
    public LayoutCoordinates getCoordinates() {
        return getInnerCoordinator$ui_release();
    }

    @Override // androidx.compose.p109ui.layout.LayoutInfo, androidx.compose.p109ui.node.ComposeUiNode
    @NotNull
    public Density getDensity() {
        return this.density;
    }

    /* JADX INFO: renamed from: getDepth$ui_release, reason: from getter */
    public final int getDepth() {
        return this.depth;
    }

    @NotNull
    public final List<LayoutNode> getFoldedChildren$ui_release() {
        return this._foldedChildren.asList();
    }

    public final boolean getHasFixedInnerContentConstraints$ui_release() {
        long jM20074getLastMeasurementConstraintsmsEJaDk$ui_release = getInnerCoordinator$ui_release().m20074getLastMeasurementConstraintsmsEJaDk$ui_release();
        return Constraints.m20919getHasFixedWidthimpl(jM20074getLastMeasurementConstraintsmsEJaDk$ui_release) && Constraints.m20918getHasFixedHeightimpl(jM20074getLastMeasurementConstraintsmsEJaDk$ui_release);
    }

    @Override // androidx.compose.p109ui.layout.LayoutInfo
    public int getHeight() {
        return this.layoutDelegate.getHeight$ui_release();
    }

    @NotNull
    public final NodeCoordinator getInnerCoordinator$ui_release() {
        return this.nodes.getInnerCoordinator();
    }

    /* JADX INFO: renamed from: getInnerLayerCoordinatorIsDirty$ui_release, reason: from getter */
    public final boolean getInnerLayerCoordinatorIsDirty() {
        return this.innerLayerCoordinatorIsDirty;
    }

    @Override // androidx.compose.p109ui.node.InteroperableComposeUiNode
    @InternalComposeUiApi
    @Nullable
    public View getInteropView() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            return androidViewHolder.getView();
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: getInteropViewFactoryHolder$ui_release, reason: from getter */
    public final AndroidViewHolder getInteropViewFactoryHolder() {
        return this.interopViewFactoryHolder;
    }

    @NotNull
    /* JADX INFO: renamed from: getIntrinsicsUsageByParent$ui_release, reason: from getter */
    public final UsageByParent getIntrinsicsUsageByParent() {
        return this.intrinsicsUsageByParent;
    }

    @NotNull
    /* JADX INFO: renamed from: getLayoutDelegate$ui_release, reason: from getter */
    public final LayoutNodeLayoutDelegate getLayoutDelegate() {
        return this.layoutDelegate;
    }

    @Override // androidx.compose.p109ui.layout.LayoutInfo, androidx.compose.p109ui.node.ComposeUiNode
    @NotNull
    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final boolean getLayoutPending$ui_release() {
        return this.layoutDelegate.getLayoutPending$ui_release();
    }

    @NotNull
    public final LayoutState getLayoutState$ui_release() {
        return this.layoutDelegate.getLayoutState$ui_release();
    }

    public final boolean getLookaheadLayoutPending$ui_release() {
        return this.layoutDelegate.getLookaheadLayoutPending$ui_release();
    }

    public final boolean getLookaheadMeasurePending$ui_release() {
        return this.layoutDelegate.getLookaheadMeasurePending$ui_release();
    }

    @Nullable
    public final LayoutNodeLayoutDelegate.LookaheadPassDelegate getLookaheadPassDelegate$ui_release() {
        return this.layoutDelegate.getLookaheadPassDelegate$ui_release();
    }

    @Nullable
    /* JADX INFO: renamed from: getLookaheadRoot$ui_release, reason: from getter */
    public final LayoutNode getLookaheadRoot() {
        return this.lookaheadRoot;
    }

    @NotNull
    public final LayoutNodeDrawScope getMDrawScope$ui_release() {
        return LayoutNodeKt.requireOwner(this).getSharedDrawScope();
    }

    @NotNull
    public final LayoutNodeLayoutDelegate.MeasurePassDelegate getMeasurePassDelegate$ui_release() {
        return this.layoutDelegate.getMeasurePassDelegate$ui_release();
    }

    public final boolean getMeasurePending$ui_release() {
        return this.layoutDelegate.getMeasurePending$ui_release();
    }

    @Override // androidx.compose.p109ui.node.ComposeUiNode
    @NotNull
    public MeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    @NotNull
    public final UsageByParent getMeasuredByParent$ui_release() {
        return getMeasurePassDelegate$ui_release().getMeasuredByParent$ui_release();
    }

    @NotNull
    public final UsageByParent getMeasuredByParentInLookahead$ui_release() {
        UsageByParent measuredByParent$ui_release;
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        return (lookaheadPassDelegate$ui_release == null || (measuredByParent$ui_release = lookaheadPassDelegate$ui_release.getMeasuredByParent$ui_release()) == null) ? UsageByParent.NotUsed : measuredByParent$ui_release;
    }

    @Override // androidx.compose.p109ui.node.ComposeUiNode
    @NotNull
    /* JADX INFO: renamed from: getModifier, reason: from getter */
    public Modifier get_modifier() {
        return this._modifier;
    }

    @Override // androidx.compose.p109ui.layout.LayoutInfo
    @NotNull
    public List<ModifierInfo> getModifierInfo() {
        return this.nodes.getModifierInfo();
    }

    /* JADX INFO: renamed from: getNeedsOnPositionedDispatch$ui_release, reason: from getter */
    public final boolean getNeedsOnPositionedDispatch() {
        return this.needsOnPositionedDispatch;
    }

    @NotNull
    /* JADX INFO: renamed from: getNodes$ui_release, reason: from getter */
    public final NodeChain getNodes() {
        return this.nodes;
    }

    @Nullable
    public final Function1<Owner, Unit> getOnAttach$ui_release() {
        return this.onAttach;
    }

    @Nullable
    public final Function1<Owner, Unit> getOnDetach$ui_release() {
        return this.onDetach;
    }

    @NotNull
    public final NodeCoordinator getOuterCoordinator$ui_release() {
        return this.nodes.getOuterCoordinator();
    }

    @Nullable
    /* JADX INFO: renamed from: getOwner$ui_release, reason: from getter */
    public final Owner getOwner() {
        return this.owner;
    }

    @Nullable
    public final LayoutNode getParent$ui_release() {
        LayoutNode layoutNode = this._foldedParent;
        while (layoutNode != null && layoutNode.isVirtual) {
            layoutNode = layoutNode._foldedParent;
        }
        return layoutNode;
    }

    @Override // androidx.compose.p109ui.layout.LayoutInfo
    @Nullable
    public LayoutInfo getParentInfo() {
        return getParent$ui_release();
    }

    public final int getPlaceOrder$ui_release() {
        return getMeasurePassDelegate$ui_release().getPlaceOrder$ui_release();
    }

    @Override // androidx.compose.p109ui.layout.LayoutInfo
    public int getSemanticsId() {
        return this.semanticsId;
    }

    @Nullable
    /* JADX INFO: renamed from: getSubcompositionsState$ui_release, reason: from getter */
    public final LayoutNodeSubcompositionsState getSubcompositionsState() {
        return this.subcompositionsState;
    }

    @Override // androidx.compose.p109ui.layout.LayoutInfo, androidx.compose.p109ui.node.ComposeUiNode
    @NotNull
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    @Override // androidx.compose.p109ui.layout.LayoutInfo
    public int getWidth() {
        return this.layoutDelegate.getWidth$ui_release();
    }

    @NotNull
    public final MutableVector<LayoutNode> getZSortedChildren() {
        if (this.zSortedChildrenInvalidated) {
            this._zSortedChildren.clear();
            MutableVector<LayoutNode> mutableVector = this._zSortedChildren;
            mutableVector.addAll(mutableVector.getSize(), get_children$ui_release());
            this._zSortedChildren.sortWith(ZComparator);
            this.zSortedChildrenInvalidated = false;
        }
        return this._zSortedChildren;
    }

    @NotNull
    public final MutableVector<LayoutNode> get_children$ui_release() {
        updateChildrenIfDirty$ui_release();
        if (this.virtualChildrenCount == 0) {
            return this._foldedChildren.getVector();
        }
        MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
        Intrinsics.checkNotNull(mutableVector);
        return mutableVector;
    }

    /* JADX INFO: renamed from: hitTest-M_7yMNQ$ui_release, reason: not valid java name */
    public final void m20007hitTestM_7yMNQ$ui_release(long pointerPosition, @NotNull HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        getOuterCoordinator$ui_release().m20077hitTestYqVAtuI(NodeCoordinator.INSTANCE.getPointerInputSource(), NodeCoordinator.m20061fromParentPosition8S9VItk$default(getOuterCoordinator$ui_release(), pointerPosition, false, 2, null), hitTestResult, isTouchEvent, isInLayer);
    }

    /* JADX INFO: renamed from: hitTestSemantics-M_7yMNQ$ui_release, reason: not valid java name */
    public final void m20008hitTestSemanticsM_7yMNQ$ui_release(long pointerPosition, @NotNull HitTestResult hitSemanticsEntities, boolean isTouchEvent, boolean isInLayer) {
        getOuterCoordinator$ui_release().m20077hitTestYqVAtuI(NodeCoordinator.INSTANCE.getSemanticsSource(), NodeCoordinator.m20061fromParentPosition8S9VItk$default(getOuterCoordinator$ui_release(), pointerPosition, false, 2, null), hitSemanticsEntities, true, isInLayer);
    }

    public final void ignoreRemeasureRequests$ui_release(@NotNull Function0<Unit> block) {
        this.ignoreRemeasureRequests = true;
        block.invoke();
        this.ignoreRemeasureRequests = false;
    }

    public final void insertAt$ui_release(int index, @NotNull LayoutNode instance) {
        if (!(instance._foldedParent == null)) {
            StringBuilder sb = new StringBuilder("Cannot insert ");
            sb.append(instance);
            sb.append(" because it already has a parent. This tree: ");
            sb.append(debugTreeToString$default(this, 0, 1, null));
            sb.append(" Other tree: ");
            LayoutNode layoutNode = instance._foldedParent;
            sb.append(layoutNode != null ? debugTreeToString$default(layoutNode, 0, 1, null) : null);
            InlineClassHelperKt.throwIllegalStateException(sb.toString());
        }
        if (!(instance.owner == null)) {
            InlineClassHelperKt.throwIllegalStateException("Cannot insert " + instance + " because it already has an owner. This tree: " + debugTreeToString$default(this, 0, 1, null) + " Other tree: " + debugTreeToString$default(instance, 0, 1, null));
        }
        instance._foldedParent = this;
        this._foldedChildren.add(index, instance);
        onZSortedChildrenInvalidated$ui_release();
        if (instance.isVirtual) {
            this.virtualChildrenCount++;
        }
        invalidateUnfoldedVirtualChildren();
        Owner owner = this.owner;
        if (owner != null) {
            instance.attach$ui_release(owner);
        }
        if (instance.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
            layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() + 1);
        }
    }

    public final void invalidateLayer$ui_release() {
        NodeCoordinator innerLayerCoordinator = getInnerLayerCoordinator();
        if (innerLayerCoordinator != null) {
            innerLayerCoordinator.invalidateLayer();
            return;
        }
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
    }

    public final void invalidateLayers$ui_release() {
        NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release();
        NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
        while (outerCoordinator$ui_release != innerCoordinator$ui_release) {
            Intrinsics.checkNotNull(outerCoordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) outerCoordinator$ui_release;
            OwnedLayer layer = layoutModifierNodeCoordinator.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
            outerCoordinator$ui_release = layoutModifierNodeCoordinator.getWrapped();
        }
        OwnedLayer layer2 = getInnerCoordinator$ui_release().getLayer();
        if (layer2 != null) {
            layer2.invalidate();
        }
    }

    public final void invalidateMeasurements$ui_release() {
        if (this.lookaheadRoot != null) {
            requestLookaheadRemeasure$ui_release$default(this, false, false, false, 7, null);
        } else {
            requestRemeasure$ui_release$default(this, false, false, false, 7, null);
        }
    }

    public final void invalidateOnPositioned$ui_release() {
        if (getLayoutPending$ui_release() || getMeasurePending$ui_release() || this.needsOnPositionedDispatch) {
            return;
        }
        LayoutNodeKt.requireOwner(this).requestOnPositionedCallback(this);
    }

    public final void invalidateParentData$ui_release() {
        this.layoutDelegate.invalidateParentData();
    }

    public final void invalidateSemantics$ui_release() {
        this._collapsedSemantics = null;
        LayoutNodeKt.requireOwner(this).onSemanticsChange();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v8 */
    public final void invalidateSubtree(boolean isRootOfInvalidation) {
        LayoutNode parent$ui_release;
        if (isRootOfInvalidation && (parent$ui_release = getParent$ui_release()) != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
        invalidateSemantics$ui_release();
        requestRemeasure$ui_release$default(this, false, false, false, 7, null);
        NodeChain nodeChain = this.nodes;
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(2);
        if ((nodeChain.getAggregateChildKindSet() & iM20090constructorimpl) != 0) {
            for (Modifier.Node head = nodeChain.getHead(); head != null; head = head.getChild()) {
                if ((head.getKindSet() & iM20090constructorimpl) != 0) {
                    Modifier.Node nodePop = head;
                    MutableVector mutableVector = null;
                    while (nodePop != 0) {
                        if (nodePop instanceof LayoutModifierNode) {
                            OwnedLayer layer = DelegatableNodeKt.m19977requireCoordinator64DMado((LayoutModifierNode) nodePop, NodeKind.m20090constructorimpl(2)).getLayer();
                            if (layer != null) {
                                layer.invalidate();
                            }
                        } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                            Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate();
                            int i = 0;
                            nodePop = nodePop;
                            while (delegate$ui_release != null) {
                                if ((delegate$ui_release.getKindSet() & iM20090constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        nodePop = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (nodePop != 0) {
                                            mutableVector.add(nodePop);
                                            nodePop = 0;
                                        }
                                        mutableVector.add(delegate$ui_release);
                                    }
                                }
                                delegate$ui_release = delegate$ui_release.getChild();
                                nodePop = nodePop;
                            }
                            if (i == 1) {
                            }
                        }
                        nodePop = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head.getAggregateChildKindSet() & iM20090constructorimpl) == 0) {
                    break;
                }
            }
        }
        MutableVector<LayoutNode> mutableVector2 = get_children$ui_release();
        int size = mutableVector2.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector2.getContent();
            int i2 = 0;
            do {
                content[i2].invalidateSubtree(false);
                i2++;
            } while (i2 < size);
        }
    }

    @Override // androidx.compose.p109ui.layout.LayoutInfo
    public boolean isAttached() {
        return this.owner != null;
    }

    @Override // androidx.compose.p109ui.layout.LayoutInfo
    /* JADX INFO: renamed from: isDeactivated, reason: from getter */
    public boolean getIsDeactivated() {
        return this.isDeactivated;
    }

    @Override // androidx.compose.p109ui.layout.LayoutInfo
    public boolean isPlaced() {
        return getMeasurePassDelegate$ui_release().isPlaced();
    }

    public final boolean isPlacedByParent() {
        return getMeasurePassDelegate$ui_release().isPlacedByParent();
    }

    @Nullable
    public final Boolean isPlacedInLookahead() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        if (lookaheadPassDelegate$ui_release != null) {
            return Boolean.valueOf(lookaheadPassDelegate$ui_release.isPlaced());
        }
        return null;
    }

    @Override // androidx.compose.p109ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return isAttached();
    }

    /* JADX INFO: renamed from: isVirtualLookaheadRoot$ui_release, reason: from getter */
    public final boolean getIsVirtualLookaheadRoot() {
        return this.isVirtualLookaheadRoot;
    }

    /* JADX INFO: renamed from: lookaheadRemeasure-_Sx5XlM$ui_release, reason: not valid java name */
    public final boolean m20009lookaheadRemeasure_Sx5XlM$ui_release(@Nullable Constraints constraints) {
        if (constraints == null || this.lookaheadRoot == null) {
            return false;
        }
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
        return lookaheadPassDelegate$ui_release.m20028remeasureBRTryo0(constraints.getValue());
    }

    public final void lookaheadReplace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
        lookaheadPassDelegate$ui_release.replace();
    }

    public final void markLayoutPending$ui_release() {
        this.layoutDelegate.markLayoutPending$ui_release();
    }

    public final void markLookaheadLayoutPending$ui_release() {
        this.layoutDelegate.markLookaheadLayoutPending$ui_release();
    }

    public final void markLookaheadMeasurePending$ui_release() {
        this.layoutDelegate.markLookaheadMeasurePending$ui_release();
    }

    public final void markMeasurePending$ui_release() {
        this.layoutDelegate.markMeasurePending$ui_release();
    }

    public final int maxIntrinsicHeight(int width) {
        return getOrCreateIntrinsicsPolicy().maxIntrinsicHeight(width);
    }

    public final int maxIntrinsicWidth(int height) {
        return getOrCreateIntrinsicsPolicy().maxIntrinsicWidth(height);
    }

    public final int maxLookaheadIntrinsicHeight(int width) {
        return getOrCreateIntrinsicsPolicy().maxLookaheadIntrinsicHeight(width);
    }

    public final int maxLookaheadIntrinsicWidth(int height) {
        return getOrCreateIntrinsicsPolicy().maxLookaheadIntrinsicWidth(height);
    }

    public final int minIntrinsicHeight(int width) {
        return getOrCreateIntrinsicsPolicy().minIntrinsicHeight(width);
    }

    public final int minIntrinsicWidth(int height) {
        return getOrCreateIntrinsicsPolicy().minIntrinsicWidth(height);
    }

    public final int minLookaheadIntrinsicHeight(int width) {
        return getOrCreateIntrinsicsPolicy().minLookaheadIntrinsicHeight(width);
    }

    public final int minLookaheadIntrinsicWidth(int height) {
        return getOrCreateIntrinsicsPolicy().minLookaheadIntrinsicWidth(height);
    }

    public final void move$ui_release(int from, int to, int count) {
        if (from == to) {
            return;
        }
        for (int i = 0; i < count; i++) {
            this._foldedChildren.add(from > to ? to + i : (to + count) - 2, this._foldedChildren.removeAt(from > to ? from + i : from));
        }
        onZSortedChildrenInvalidated$ui_release();
        invalidateUnfoldedVirtualChildren();
        invalidateMeasurements$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onDeactivate() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onDeactivate();
        }
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.subcompositionsState;
        if (layoutNodeSubcompositionsState != null) {
            layoutNodeSubcompositionsState.onDeactivate();
        }
        this.isDeactivated = true;
        resetModifierState();
        if (isAttached()) {
            invalidateSemantics$ui_release();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // androidx.compose.ui.node.Owner.OnLayoutCompletedListener
    public void onLayoutComplete() {
        NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(128);
        boolean zM20099getIncludeSelfInTraversalH91voCI = NodeKindKt.m20099getIncludeSelfInTraversalH91voCI(iM20090constructorimpl);
        Modifier.Node tail = innerCoordinator$ui_release.getTail();
        if (!zM20099getIncludeSelfInTraversalH91voCI && (tail = tail.getParent()) == null) {
            return;
        }
        for (Modifier.Node nodeHeadNode = innerCoordinator$ui_release.headNode(zM20099getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & iM20090constructorimpl) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
            if ((nodeHeadNode.getKindSet() & iM20090constructorimpl) != 0) {
                Modifier.Node nodePop = nodeHeadNode;
                MutableVector mutableVector = null;
                while (nodePop != 0) {
                    if (nodePop instanceof LayoutAwareModifierNode) {
                        ((LayoutAwareModifierNode) nodePop).onPlaced(getInnerCoordinator$ui_release());
                    } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                        Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate();
                        int i = 0;
                        nodePop = nodePop;
                        while (delegate$ui_release != null) {
                            if ((delegate$ui_release.getKindSet() & iM20090constructorimpl) != 0) {
                                i++;
                                if (i == 1) {
                                    nodePop = delegate$ui_release;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (nodePop != 0) {
                                        mutableVector.add(nodePop);
                                        nodePop = 0;
                                    }
                                    mutableVector.add(delegate$ui_release);
                                }
                            }
                            delegate$ui_release = delegate$ui_release.getChild();
                            nodePop = nodePop;
                        }
                        if (i == 1) {
                        }
                    }
                    nodePop = DelegatableNodeKt.pop(mutableVector);
                }
            }
            if (nodeHeadNode == tail) {
                return;
            }
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onRelease() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onRelease();
        }
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.subcompositionsState;
        if (layoutNodeSubcompositionsState != null) {
            layoutNodeSubcompositionsState.onRelease();
        }
        NodeCoordinator wrapped = getInnerCoordinator$ui_release().getWrapped();
        for (NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(outerCoordinator$ui_release, wrapped) && outerCoordinator$ui_release != null; outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped()) {
            outerCoordinator$ui_release.onRelease();
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onReuse() {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalArgumentException("onReuse is only expected on attached node");
        }
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onReuse();
        }
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.subcompositionsState;
        if (layoutNodeSubcompositionsState != null) {
            layoutNodeSubcompositionsState.onReuse();
        }
        if (getIsDeactivated()) {
            this.isDeactivated = false;
            invalidateSemantics$ui_release();
        } else {
            resetModifierState();
        }
        setSemanticsId(SemanticsModifierKt.generateSemanticsId());
        this.nodes.markAsAttached();
        this.nodes.runAttachLifecycle();
        rescheduleRemeasureOrRelayout$ui_release(this);
    }

    public final void onZSortedChildrenInvalidated$ui_release() {
        if (!this.isVirtual) {
            this.zSortedChildrenInvalidated = true;
            return;
        }
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.onZSortedChildrenInvalidated$ui_release();
        }
    }

    public final void place$ui_release(int x, int y2) {
        Placeable.PlacementScope placementScope;
        NodeCoordinator innerCoordinator$ui_release;
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release == null || (innerCoordinator$ui_release = parent$ui_release.getInnerCoordinator$ui_release()) == null || (placementScope = innerCoordinator$ui_release.getPlacementScope()) == null) {
            placementScope = LayoutNodeKt.requireOwner(this).getPlacementScope();
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, getMeasurePassDelegate$ui_release(), x, y2, 0.0f, 4, null);
    }

    /* JADX INFO: renamed from: remeasure-_Sx5XlM$ui_release, reason: not valid java name */
    public final boolean m20010remeasure_Sx5XlM$ui_release(@Nullable Constraints constraints) {
        if (constraints == null) {
            return false;
        }
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreeIntrinsicsUsage$ui_release();
        }
        return getMeasurePassDelegate$ui_release().m20032remeasureBRTryo0(constraints.getValue());
    }

    public final void removeAll$ui_release() {
        int size = this._foldedChildren.getSize();
        while (true) {
            size--;
            if (-1 >= size) {
                this._foldedChildren.clear();
                return;
            }
            onChildRemoved(this._foldedChildren.get(size));
        }
    }

    public final void removeAt$ui_release(int index, int count) {
        if (!(count >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("count (" + count + ") must be greater than 0");
        }
        int i = (count + index) - 1;
        if (index > i) {
            return;
        }
        while (true) {
            onChildRemoved(this._foldedChildren.get(i));
            this._foldedChildren.removeAt(i);
            if (i == index) {
                return;
            } else {
                i--;
            }
        }
    }

    public final void replace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        getMeasurePassDelegate$ui_release().replace();
    }

    public final void requestLookaheadRelayout$ui_release(boolean forceRequest) {
        Owner owner;
        if (this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        owner.onRequestRelayout(this, true, forceRequest);
    }

    public final void requestLookaheadRemeasure$ui_release(boolean forceRequest, boolean scheduleMeasureAndLayout, boolean invalidateIntrinsics) {
        if (!(this.lookaheadRoot != null)) {
            InlineClassHelperKt.throwIllegalStateException("Lookahead measure cannot be requested on a node that is not a part of theLookaheadScope");
        }
        Owner owner = this.owner;
        if (owner == null || this.ignoreRemeasureRequests || this.isVirtual) {
            return;
        }
        owner.onRequestMeasure(this, true, forceRequest, scheduleMeasureAndLayout);
        if (invalidateIntrinsics) {
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
            lookaheadPassDelegate$ui_release.invalidateIntrinsicsParent(forceRequest);
        }
    }

    public final void requestRelayout$ui_release(boolean forceRequest) {
        Owner owner;
        if (this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        Owner.onRequestRelayout$default(owner, this, false, forceRequest, 2, null);
    }

    public final void requestRemeasure$ui_release(boolean forceRequest, boolean scheduleMeasureAndLayout, boolean invalidateIntrinsics) {
        Owner owner;
        if (this.ignoreRemeasureRequests || this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        Owner.onRequestMeasure$default(owner, this, false, forceRequest, scheduleMeasureAndLayout, 2, null);
        if (invalidateIntrinsics) {
            getMeasurePassDelegate$ui_release().invalidateIntrinsicsParent(forceRequest);
        }
    }

    public final void rescheduleRemeasureOrRelayout$ui_release(@NotNull LayoutNode it) {
        if (WhenMappings.$EnumSwitchMapping$0[it.getLayoutState$ui_release().ordinal()] != 1) {
            throw new IllegalStateException("Unexpected state " + it.getLayoutState$ui_release());
        }
        if (it.getLookaheadMeasurePending$ui_release()) {
            requestLookaheadRemeasure$ui_release$default(it, true, false, false, 6, null);
            return;
        }
        if (it.getLookaheadLayoutPending$ui_release()) {
            it.requestLookaheadRelayout$ui_release(true);
        }
        if (it.getMeasurePending$ui_release()) {
            requestRemeasure$ui_release$default(it, true, false, false, 6, null);
        } else if (it.getLayoutPending$ui_release()) {
            it.requestRelayout$ui_release(true);
        }
    }

    public final void resetSubtreeIntrinsicsUsage$ui_release() {
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode = content[i];
                UsageByParent usageByParent = layoutNode.previousIntrinsicsUsageByParent;
                layoutNode.intrinsicsUsageByParent = usageByParent;
                if (usageByParent != UsageByParent.NotUsed) {
                    layoutNode.resetSubtreeIntrinsicsUsage$ui_release();
                }
                i++;
            } while (i < size);
        }
    }

    public final void setCanMultiMeasure$ui_release(boolean z) {
        this.canMultiMeasure = z;
    }

    @Override // androidx.compose.p109ui.node.ComposeUiNode
    @ExperimentalComposeUiApi
    public void setCompositeKeyHash(int i) {
        this.compositeKeyHash = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7 */
    @Override // androidx.compose.p109ui.node.ComposeUiNode
    public void setCompositionLocalMap(@NotNull CompositionLocalMap compositionLocalMap) {
        this.compositionLocalMap = compositionLocalMap;
        setDensity((Density) compositionLocalMap.get(CompositionLocalsKt.getLocalDensity()));
        setLayoutDirection((LayoutDirection) compositionLocalMap.get(CompositionLocalsKt.getLocalLayoutDirection()));
        setViewConfiguration((ViewConfiguration) compositionLocalMap.get(CompositionLocalsKt.getLocalViewConfiguration()));
        NodeChain nodeChain = this.nodes;
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(32768);
        if ((nodeChain.getAggregateChildKindSet() & iM20090constructorimpl) != 0) {
            for (Modifier.Node head = nodeChain.getHead(); head != null; head = head.getChild()) {
                if ((head.getKindSet() & iM20090constructorimpl) != 0) {
                    Modifier.Node nodePop = head;
                    MutableVector mutableVector = null;
                    while (nodePop != 0) {
                        if (nodePop instanceof CompositionLocalConsumerModifierNode) {
                            Modifier.Node node = ((CompositionLocalConsumerModifierNode) nodePop).getNode();
                            if (node.getIsAttached()) {
                                NodeKindKt.autoInvalidateUpdatedNode(node);
                            } else {
                                node.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
                            }
                        } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                            Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate();
                            int i = 0;
                            nodePop = nodePop;
                            while (delegate$ui_release != null) {
                                if ((delegate$ui_release.getKindSet() & iM20090constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        nodePop = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (nodePop != 0) {
                                            mutableVector.add(nodePop);
                                            nodePop = 0;
                                        }
                                        mutableVector.add(delegate$ui_release);
                                    }
                                }
                                delegate$ui_release = delegate$ui_release.getChild();
                                nodePop = nodePop;
                            }
                            if (i == 1) {
                            }
                        }
                        nodePop = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head.getAggregateChildKindSet() & iM20090constructorimpl) == 0) {
                    return;
                }
            }
        }
    }

    @Override // androidx.compose.p109ui.node.ComposeUiNode
    public void setDensity(@NotNull Density density) {
        if (Intrinsics.areEqual(this.density, density)) {
            return;
        }
        this.density = density;
        onDensityOrLayoutDirectionChanged();
        for (Modifier.Node head = this.nodes.getHead(); head != null; head = head.getChild()) {
            if ((NodeKind.m20090constructorimpl(16) & head.getKindSet()) != 0) {
                ((PointerInputModifierNode) head).onDensityChange();
            } else if (head instanceof CacheDrawModifierNode) {
                ((CacheDrawModifierNode) head).invalidateDrawCache();
            }
        }
    }

    public final void setDepth$ui_release(int i) {
        this.depth = i;
    }

    public final void setInnerLayerCoordinatorIsDirty$ui_release(boolean z) {
        this.innerLayerCoordinatorIsDirty = z;
    }

    public final void setInteropViewFactoryHolder$ui_release(@Nullable AndroidViewHolder androidViewHolder) {
        this.interopViewFactoryHolder = androidViewHolder;
    }

    public final void setIntrinsicsUsageByParent$ui_release(@NotNull UsageByParent usageByParent) {
        this.intrinsicsUsageByParent = usageByParent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7 */
    @Override // androidx.compose.p109ui.node.ComposeUiNode
    public void setLayoutDirection(@NotNull LayoutDirection layoutDirection) {
        if (this.layoutDirection != layoutDirection) {
            this.layoutDirection = layoutDirection;
            onDensityOrLayoutDirectionChanged();
            NodeChain nodeChain = this.nodes;
            int iM20090constructorimpl = NodeKind.m20090constructorimpl(4);
            if ((nodeChain.getAggregateChildKindSet() & iM20090constructorimpl) != 0) {
                for (Modifier.Node head = nodeChain.getHead(); head != null; head = head.getChild()) {
                    if ((head.getKindSet() & iM20090constructorimpl) != 0) {
                        Modifier.Node nodePop = head;
                        MutableVector mutableVector = null;
                        while (nodePop != 0) {
                            if (nodePop instanceof DrawModifierNode) {
                                DrawModifierNode drawModifierNode = (DrawModifierNode) nodePop;
                                if (drawModifierNode instanceof CacheDrawModifierNode) {
                                    ((CacheDrawModifierNode) drawModifierNode).invalidateDrawCache();
                                }
                            } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate();
                                int i = 0;
                                nodePop = nodePop;
                                while (delegate$ui_release != null) {
                                    if ((delegate$ui_release.getKindSet() & iM20090constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            nodePop = delegate$ui_release;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != 0) {
                                                mutableVector.add(nodePop);
                                                nodePop = 0;
                                            }
                                            mutableVector.add(delegate$ui_release);
                                        }
                                    }
                                    delegate$ui_release = delegate$ui_release.getChild();
                                    nodePop = nodePop;
                                }
                                if (i == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    if ((head.getAggregateChildKindSet() & iM20090constructorimpl) == 0) {
                        return;
                    }
                }
            }
        }
    }

    @Override // androidx.compose.p109ui.node.ComposeUiNode
    public void setMeasurePolicy(@NotNull MeasurePolicy measurePolicy) {
        if (Intrinsics.areEqual(this.measurePolicy, measurePolicy)) {
            return;
        }
        this.measurePolicy = measurePolicy;
        IntrinsicsPolicy intrinsicsPolicy = this.intrinsicsPolicy;
        if (intrinsicsPolicy != null) {
            intrinsicsPolicy.updateFrom(getMeasurePolicy());
        }
        invalidateMeasurements$ui_release();
    }

    @Override // androidx.compose.p109ui.node.ComposeUiNode
    public void setModifier(@NotNull Modifier modifier) {
        if (!(!this.isVirtual || get_modifier() == Modifier.INSTANCE)) {
            InlineClassHelperKt.throwIllegalArgumentException("Modifiers are not supported on virtual LayoutNodes");
        }
        if (getIsDeactivated()) {
            InlineClassHelperKt.throwIllegalArgumentException("modifier is updated when deactivated");
        }
        if (isAttached()) {
            applyModifier(modifier);
        } else {
            this.pendingModifier = modifier;
        }
    }

    public final void setNeedsOnPositionedDispatch$ui_release(boolean z) {
        this.needsOnPositionedDispatch = z;
    }

    public final void setOnAttach$ui_release(@Nullable Function1<? super Owner, Unit> function1) {
        this.onAttach = function1;
    }

    public final void setOnDetach$ui_release(@Nullable Function1<? super Owner, Unit> function1) {
        this.onDetach = function1;
    }

    public void setSemanticsId(int i) {
        this.semanticsId = i;
    }

    public final void setSubcompositionsState$ui_release(@Nullable LayoutNodeSubcompositionsState layoutNodeSubcompositionsState) {
        this.subcompositionsState = layoutNodeSubcompositionsState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6 */
    @Override // androidx.compose.p109ui.node.ComposeUiNode
    public void setViewConfiguration(@NotNull ViewConfiguration viewConfiguration) {
        if (Intrinsics.areEqual(this.viewConfiguration, viewConfiguration)) {
            return;
        }
        this.viewConfiguration = viewConfiguration;
        NodeChain nodeChain = this.nodes;
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(16);
        if ((nodeChain.getAggregateChildKindSet() & iM20090constructorimpl) != 0) {
            for (Modifier.Node head = nodeChain.getHead(); head != null; head = head.getChild()) {
                if ((head.getKindSet() & iM20090constructorimpl) != 0) {
                    Modifier.Node nodePop = head;
                    MutableVector mutableVector = null;
                    while (nodePop != 0) {
                        if (nodePop instanceof PointerInputModifierNode) {
                            ((PointerInputModifierNode) nodePop).onViewConfigurationChange();
                        } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                            Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate();
                            int i = 0;
                            nodePop = nodePop;
                            while (delegate$ui_release != null) {
                                if ((delegate$ui_release.getKindSet() & iM20090constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        nodePop = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (nodePop != 0) {
                                            mutableVector.add(nodePop);
                                            nodePop = 0;
                                        }
                                        mutableVector.add(delegate$ui_release);
                                    }
                                }
                                delegate$ui_release = delegate$ui_release.getChild();
                                nodePop = nodePop;
                            }
                            if (i == 1) {
                            }
                        }
                        nodePop = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head.getAggregateChildKindSet() & iM20090constructorimpl) == 0) {
                    return;
                }
            }
        }
    }

    public final void setVirtualLookaheadRoot$ui_release(boolean z) {
        this.isVirtualLookaheadRoot = z;
    }

    @NotNull
    public String toString() {
        return JvmActuals_jvmKt.simpleIdentityToString(this, null) + " children: " + getChildren$ui_release().size() + " measurePolicy: " + getMeasurePolicy();
    }

    public final void updateChildrenIfDirty$ui_release() {
        if (this.virtualChildrenCount > 0) {
            recreateUnfoldedChildrenIfDirty();
        }
    }

    public LayoutNode(boolean z, int i) {
        this.isVirtual = z;
        this.semanticsId = i;
        this._foldedChildren = new MutableVectorWithMutationTracking<>(new MutableVector(new LayoutNode[16], 0), new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNode$_foldedChildren$1
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
                this.this$0.getLayoutDelegate().markChildrenDirty();
            }
        });
        this._zSortedChildren = new MutableVector<>(new LayoutNode[16], 0);
        this.zSortedChildrenInvalidated = true;
        this.measurePolicy = ErrorMeasurePolicy;
        this.density = LayoutNodeKt.DefaultDensity;
        this.layoutDirection = LayoutDirection.Ltr;
        this.viewConfiguration = DummyViewConfiguration;
        this.compositionLocalMap = CompositionLocalMap.INSTANCE.getEmpty();
        UsageByParent usageByParent = UsageByParent.NotUsed;
        this.intrinsicsUsageByParent = usageByParent;
        this.previousIntrinsicsUsageByParent = usageByParent;
        this.nodes = new NodeChain(this);
        this.layoutDelegate = new LayoutNodeLayoutDelegate(this);
        this.innerLayerCoordinatorIsDirty = true;
        this._modifier = Modifier.INSTANCE;
    }

    @Deprecated(message = "Temporary API to support ConstraintLayout prototyping.")
    public static /* synthetic */ void getCanMultiMeasure$ui_release$annotations() {
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getCompositeKeyHash$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getZSortedChildren$annotations() {
    }

    public /* synthetic */ LayoutNode(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? SemanticsModifierKt.generateSemanticsId() : i);
    }
}
