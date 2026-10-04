package androidx.compose.p109ui.text;

import androidx.compose.p109ui.graphics.Brush;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shadow;
import androidx.compose.p109ui.graphics.drawscope.DrawStyle;
import androidx.compose.p109ui.text.font.FontFamily;
import androidx.compose.p109ui.text.font.FontStyle;
import androidx.compose.p109ui.text.font.FontSynthesis;
import androidx.compose.p109ui.text.font.FontWeight;
import androidx.compose.p109ui.text.intl.LocaleList;
import androidx.compose.p109ui.text.style.BaselineShift;
import androidx.compose.p109ui.text.style.Hyphens;
import androidx.compose.p109ui.text.style.LineBreak;
import androidx.compose.p109ui.text.style.LineHeightStyle;
import androidx.compose.p109ui.text.style.TextAlign;
import androidx.compose.p109ui.text.style.TextDecoration;
import androidx.compose.p109ui.text.style.TextDirection;
import androidx.compose.p109ui.text.style.TextForegroundStyle;
import androidx.compose.p109ui.text.style.TextGeometricTransform;
import androidx.compose.p109ui.text.style.TextIndent;
import androidx.compose.p109ui.text.style.TextMotion;
import androidx.compose.p109ui.unit.TextUnit;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementKey;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\bU\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u0000 £\u00012\u00020\u0001:\u0002£\u0001B\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006BÕ\u0001\b\u0017\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'¢\u0006\u0002\u0010(Bí\u0001\b\u0017\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,¢\u0006\u0002\u0010-B\u0085\u0002\b\u0017\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101¢\u0006\u0002\u00102B\u009d\u0002\b\u0017\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000104\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106¢\u0006\u0002\u00107B\u0095\u0002\b\u0016\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u0010!\u001a\u00020\"\u0012\b\b\u0002\u0010#\u001a\u00020$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020/\u0012\b\b\u0002\u00100\u001a\u000201\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106¢\u0006\u0002\u00108B\u009f\u0002\b\u0016\u0012\b\u00109\u001a\u0004\u0018\u00010:\u0012\b\b\u0002\u0010;\u001a\u00020<\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u0010!\u001a\u00020\"\u0012\b\b\u0002\u0010#\u001a\u00020$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020/\u0012\b\b\u0002\u00100\u001a\u000201\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106¢\u0006\u0002\u0010=B§\u0002\b\u0017\u0012\b\u00109\u001a\u0004\u0018\u00010:\u0012\b\b\u0002\u0010;\u001a\u00020<\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000104\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106¢\u0006\u0002\u0010>B#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*¢\u0006\u0002\u0010?J«\u0002\u0010\u0082\u0001\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010:2\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u0002012\n\b\u0002\u00105\u001a\u0004\u0018\u000106ø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001Jµ\u0002\u0010\u0082\u0001\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010:2\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00105\u001a\u0004\u0018\u000106H\u0007ø\u0001\u0000¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J¡\u0002\u0010\u0082\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u0002012\n\b\u0002\u00105\u001a\u0004\u0018\u000106ø\u0001\u0000¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J«\u0002\u0010\u0082\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00105\u001a\u0004\u0018\u000106H\u0007ø\u0001\u0000¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001Jã\u0001\u0010\u0082\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0007ø\u0001\u0000¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001Jû\u0001\u0010\u0082\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,H\u0007ø\u0001\u0000¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u0093\u0002\u0010\u0082\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u000101H\u0007ø\u0001\u0000¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u0016\u0010\u0091\u0001\u001a\u00030\u0092\u00012\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0011\u0010\u0094\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020\u0000J\u0011\u0010\u0095\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020\u0000J\n\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0016J\u0010\u0010\u0098\u0001\u001a\u00030\u0097\u0001H\u0000¢\u0006\u0003\b\u0099\u0001J£\u0002\u0010\u009a\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u0002012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u00105\u001a\u0004\u0018\u000106H\u0007ø\u0001\u0000¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J«\u0002\u0010\u009a\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u00105\u001a\u0004\u0018\u000106H\u0007ø\u0001\u0000¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u0012\u0010\u009a\u0001\u001a\u00020\u00002\u0007\u0010\u0093\u0001\u001a\u00020\u0005H\u0007J\u0012\u0010\u009a\u0001\u001a\u00020\u00002\u0007\u0010\u0093\u0001\u001a\u00020\u0003H\u0007J\u0016\u0010\u009a\u0001\u001a\u00020\u00002\u000b\b\u0002\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0000H\u0007J\u0013\u0010\u009f\u0001\u001a\u00020\u00002\u0007\u0010\u0093\u0001\u001a\u00020\u0005H\u0087\u0002J\u0013\u0010\u009f\u0001\u001a\u00020\u00002\u0007\u0010\u0093\u0001\u001a\u00020\u0003H\u0087\u0002J\u0013\u0010\u009f\u0001\u001a\u00020\u00002\u0007\u0010\u0093\u0001\u001a\u00020\u0000H\u0087\u0002J\t\u0010 \u0001\u001a\u00020\u0005H\u0007J\t\u0010¡\u0001\u001a\u00020\u0003H\u0007J\t\u0010¢\u0001\u001a\u00020\u0014H\u0016R\u0011\u0010;\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0017\u0010\u001c\u001a\u00020\b8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00178Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0013\u00109\u001a\u0004\u0018\u00010:8F¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0017\u0010\u0007\u001a\u00020\b8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bH\u0010CR\"\u0010I\u001a\u0004\u0018\u0001018GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\"\u0010N\u001a\u0004\u0018\u00010/8GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\bO\u0010K\u001a\u0004\bP\u0010QR\"\u0010R\u001a\u0004\u0018\u00010\"8GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\bS\u0010K\u001a\u0004\bT\u0010UR\"\u0010V\u001a\u0004\u0018\u00010$8GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\bW\u0010K\u001a\u0004\bX\u0010YR\u0013\u00103\u001a\u0004\u0018\u0001048F¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\\\u0010]R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\b^\u0010_R\u0017\u0010\t\u001a\u00020\n8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b`\u0010CR\u0019\u0010\r\u001a\u0004\u0018\u00010\u000e8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00108Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bc\u0010dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\be\u0010fR\u0017\u00100\u001a\u0002018Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bg\u0010hR\u0017\u0010\u0015\u001a\u00020\n8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bi\u0010CR\u0017\u0010.\u001a\u00020/8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bj\u0010hR\u0017\u0010%\u001a\u00020\n8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bk\u0010CR\u0013\u0010+\u001a\u0004\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8F¢\u0006\u0006\u001a\u0004\bn\u0010oR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010qR\u0013\u0010)\u001a\u0004\u0018\u00010*¢\u0006\b\n\u0000\u001a\u0004\br\u0010sR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\bt\u0010uR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010wR\u0017\u0010!\u001a\u00020\"8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bx\u0010hR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\by\u0010zR\u0017\u0010#\u001a\u00020$8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b{\u0010hR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\b|\u0010}R\u0013\u0010&\u001a\u0004\u0018\u00010'8F¢\u0006\u0006\u001a\u0004\b~\u0010\u007fR\u0015\u00105\u001a\u0004\u0018\u0001068F¢\u0006\b\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¤\u0001"}, m13886d2 = {"Landroidx/compose/ui/text/TextStyle;", "", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "paragraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/ParagraphStyle;)V", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", VElementKey.SHADOW, "Landroidx/compose/ui/graphics/Shadow;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "platformStyle", "Landroidx/compose/ui/text/PlatformTextStyle;", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/ParagraphStyle;Landroidx/compose/ui/text/PlatformTextStyle;)V", "getAlpha", "()F", "getBackground-0d7_KjU", "()J", "getBaselineShift-5SSeXJ0", "()Landroidx/compose/ui/text/style/BaselineShift;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getColor-0d7_KjU", "deprecated_boxing_hyphens", "getHyphens-EaSxIns$annotations", "()V", "getHyphens-EaSxIns", "()Landroidx/compose/ui/text/style/Hyphens;", "deprecated_boxing_lineBreak", "getLineBreak-LgCVezo$annotations", "getLineBreak-LgCVezo", "()Landroidx/compose/ui/text/style/LineBreak;", "deprecated_boxing_textAlign", "getTextAlign-buA522U$annotations", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "deprecated_boxing_textDirection", "getTextDirection-mmuk1to$annotations", "getTextDirection-mmuk1to", "()Landroidx/compose/ui/text/style/TextDirection;", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontFeatureSettings", "()Ljava/lang/String;", "getFontSize-XSAIIZE", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "getFontSynthesis-ZQGJjVo", "()Landroidx/compose/ui/text/font/FontSynthesis;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getHyphens-vmbZdU8", "()I", "getLetterSpacing-XSAIIZE", "getLineBreak-rAG3T2k", "getLineHeight-XSAIIZE", "getLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "getLocaleList", "()Landroidx/compose/ui/text/intl/LocaleList;", "getParagraphStyle$ui_text_release", "()Landroidx/compose/ui/text/ParagraphStyle;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformTextStyle;", "getShadow", "()Landroidx/compose/ui/graphics/Shadow;", "getSpanStyle$ui_text_release", "()Landroidx/compose/ui/text/SpanStyle;", "getTextAlign-e0LSkKk", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "getTextDirection-s_7X-co", "getTextGeometricTransform", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "getTextIndent", "()Landroidx/compose/ui/text/style/TextIndent;", "getTextMotion", "()Landroidx/compose/ui/text/style/TextMotion;", "copy", "copy-Ns73l9s", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-aIRg9q4", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-p1EtxEg", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-v2rsoow", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-HL5avdY", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;)Landroidx/compose/ui/text/TextStyle;", "copy-NOaFTUo", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;)Landroidx/compose/ui/text/TextStyle;", "copy-CXVQc50", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;)Landroidx/compose/ui/text/TextStyle;", "equals", "", "other", "hasSameDrawAffectingAttributes", "hasSameLayoutAffectingAttributes", "hashCode", "", "hashCodeLayoutAffectingAttributes", "hashCodeLayoutAffectingAttributes$ui_text_release", "merge", "merge-dA7vx0o", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "merge-Z1GrekI", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "plus", "toParagraphStyle", "toSpanStyle", "toString", "Companion", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TextStyle {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final TextStyle Default = new TextStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777215, (DefaultConstructorMarker) null);

    @NotNull
    private final ParagraphStyle paragraphStyle;

    @Nullable
    private final PlatformTextStyle platformStyle;

    @NotNull
    private final SpanStyle spanStyle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Landroidx/compose/ui/text/TextStyle$Companion;", "", "()V", AuthenticationConstants.Broker.ACCOUNT_DEFAULT_NAME, "Landroidx/compose/ui/text/TextStyle;", "getDefault$annotations", "getDefault", "()Landroidx/compose/ui/text/TextStyle;", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TextStyle getDefault() {
            return TextStyle.Default;
        }

        private Companion() {
        }

        @Stable
        public static /* synthetic */ void getDefault$annotations() {
        }
    }

    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j6, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i4, int i5, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j5, textDecoration, shadow, drawStyle, i, i2, j6, textIndent, platformTextStyle, lineHeightStyle, i4, i5, textMotion);
    }

    /* JADX INFO: renamed from: copy-CXVQc50$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m20464copyCXVQc50$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j6, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, int i, Object obj) {
        Hyphens hyphensM20760boximpl;
        LineBreak lineBreak2;
        long jM20406getColor0d7_KjU = (i & 1) != 0 ? textStyle.spanStyle.m20406getColor0d7_KjU() : j;
        long jM20407getFontSizeXSAIIZE = (i & 2) != 0 ? textStyle.spanStyle.getFontSize() : j2;
        FontWeight fontWeight2 = (i & 4) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight;
        FontStyle fontStyleM20408getFontStyle4Lr2A7w = (i & 8) != 0 ? textStyle.spanStyle.getFontStyle() : fontStyle;
        FontSynthesis fontSynthesisM20409getFontSynthesisZQGJjVo = (i & 16) != 0 ? textStyle.spanStyle.getFontSynthesis() : fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str;
        long jM20410getLetterSpacingXSAIIZE = (i & 128) != 0 ? textStyle.spanStyle.getLetterSpacing() : j3;
        BaselineShift baselineShiftM20405getBaselineShift5SSeXJ0 = (i & 256) != 0 ? textStyle.spanStyle.getBaselineShift() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : localeList;
        long j7 = jM20406getColor0d7_KjU;
        long jM20404getBackground0d7_KjU = (i & 2048) != 0 ? textStyle.spanStyle.getBackground() : j5;
        TextDecoration textDecoration2 = (i & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow2 = (i & 8192) != 0 ? textStyle.spanStyle.getShadow() : shadow;
        TextDecoration textDecoration3 = textDecoration2;
        TextAlign textAlignM20850boximpl = (i & 16384) != 0 ? TextAlign.m20850boximpl(textStyle.paragraphStyle.getTextAlign()) : textAlign;
        TextDirection textDirectionM20864boximpl = (i & 32768) != 0 ? TextDirection.m20864boximpl(textStyle.paragraphStyle.getTextDirection()) : textDirection;
        long jM20360getLineHeightXSAIIZE = (i & 65536) != 0 ? textStyle.paragraphStyle.getLineHeight() : j6;
        TextIndent textIndent2 = (i & 131072) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent;
        PlatformTextStyle platformTextStyle2 = (i & 262144) != 0 ? textStyle.platformStyle : platformTextStyle;
        LineHeightStyle lineHeightStyle2 = (i & 524288) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : lineHeightStyle;
        LineBreak lineBreakM20770boximpl = (i & 1048576) != 0 ? LineBreak.m20770boximpl(textStyle.paragraphStyle.getLineBreak()) : lineBreak;
        if ((i & 2097152) != 0) {
            lineBreak2 = lineBreakM20770boximpl;
            hyphensM20760boximpl = Hyphens.m20760boximpl(textStyle.paragraphStyle.getHyphens());
        } else {
            hyphensM20760boximpl = hyphens;
            lineBreak2 = lineBreakM20770boximpl;
        }
        return textStyle.m20477copyCXVQc50(j7, jM20407getFontSizeXSAIIZE, fontWeight2, fontStyleM20408getFontStyle4Lr2A7w, fontSynthesisM20409getFontSynthesisZQGJjVo, fontFamily2, fontFeatureSettings, jM20410getLetterSpacingXSAIIZE, baselineShiftM20405getBaselineShift5SSeXJ0, textGeometricTransform2, localeList2, jM20404getBackground0d7_KjU, textDecoration3, shadow2, textAlignM20850boximpl, textDirectionM20864boximpl, jM20360getLineHeightXSAIIZE, textIndent2, platformTextStyle2, lineHeightStyle2, lineBreak2, hyphensM20760boximpl);
    }

    /* JADX INFO: renamed from: copy-HL5avdY$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m20465copyHL5avdY$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j6, TextIndent textIndent, int i, Object obj) {
        long jM20406getColor0d7_KjU = (i & 1) != 0 ? textStyle.spanStyle.m20406getColor0d7_KjU() : j;
        return textStyle.m20478copyHL5avdY(jM20406getColor0d7_KjU, (i & 2) != 0 ? textStyle.spanStyle.getFontSize() : j2, (i & 4) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight, (i & 8) != 0 ? textStyle.spanStyle.getFontStyle() : fontStyle, (i & 16) != 0 ? textStyle.spanStyle.getFontSynthesis() : fontSynthesis, (i & 32) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily, (i & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str, (i & 128) != 0 ? textStyle.spanStyle.getLetterSpacing() : j3, (i & 256) != 0 ? textStyle.spanStyle.getBaselineShift() : baselineShift, (i & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform, (i & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : localeList, (i & 2048) != 0 ? textStyle.spanStyle.getBackground() : j5, (i & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : textDecoration, (i & 8192) != 0 ? textStyle.spanStyle.getShadow() : shadow, (i & 16384) != 0 ? TextAlign.m20850boximpl(textStyle.paragraphStyle.getTextAlign()) : textAlign, (i & 32768) != 0 ? TextDirection.m20864boximpl(textStyle.paragraphStyle.getTextDirection()) : textDirection, (i & 65536) != 0 ? textStyle.paragraphStyle.getLineHeight() : j6, (i & 131072) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent);
    }

    /* JADX INFO: renamed from: copy-NOaFTUo$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m20466copyNOaFTUo$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j6, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i, Object obj) {
        LineHeightStyle lineHeightStyle2;
        PlatformTextStyle platformTextStyle2;
        long jM20406getColor0d7_KjU = (i & 1) != 0 ? textStyle.spanStyle.m20406getColor0d7_KjU() : j;
        long jM20407getFontSizeXSAIIZE = (i & 2) != 0 ? textStyle.spanStyle.getFontSize() : j2;
        FontWeight fontWeight2 = (i & 4) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight;
        FontStyle fontStyleM20408getFontStyle4Lr2A7w = (i & 8) != 0 ? textStyle.spanStyle.getFontStyle() : fontStyle;
        FontSynthesis fontSynthesisM20409getFontSynthesisZQGJjVo = (i & 16) != 0 ? textStyle.spanStyle.getFontSynthesis() : fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str;
        long jM20410getLetterSpacingXSAIIZE = (i & 128) != 0 ? textStyle.spanStyle.getLetterSpacing() : j3;
        BaselineShift baselineShiftM20405getBaselineShift5SSeXJ0 = (i & 256) != 0 ? textStyle.spanStyle.getBaselineShift() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : localeList;
        long j7 = jM20406getColor0d7_KjU;
        long jM20404getBackground0d7_KjU = (i & 2048) != 0 ? textStyle.spanStyle.getBackground() : j5;
        TextDecoration textDecoration2 = (i & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow2 = (i & 8192) != 0 ? textStyle.spanStyle.getShadow() : shadow;
        TextDecoration textDecoration3 = textDecoration2;
        TextAlign textAlignM20850boximpl = (i & 16384) != 0 ? TextAlign.m20850boximpl(textStyle.paragraphStyle.getTextAlign()) : textAlign;
        TextDirection textDirectionM20864boximpl = (i & 32768) != 0 ? TextDirection.m20864boximpl(textStyle.paragraphStyle.getTextDirection()) : textDirection;
        long jM20360getLineHeightXSAIIZE = (i & 65536) != 0 ? textStyle.paragraphStyle.getLineHeight() : j6;
        TextIndent textIndent2 = (i & 131072) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent;
        PlatformTextStyle platformTextStyle3 = (i & 262144) != 0 ? textStyle.platformStyle : platformTextStyle;
        if ((i & 524288) != 0) {
            platformTextStyle2 = platformTextStyle3;
            lineHeightStyle2 = textStyle.paragraphStyle.getLineHeightStyle();
        } else {
            lineHeightStyle2 = lineHeightStyle;
            platformTextStyle2 = platformTextStyle3;
        }
        return textStyle.m20479copyNOaFTUo(j7, jM20407getFontSizeXSAIIZE, fontWeight2, fontStyleM20408getFontStyle4Lr2A7w, fontSynthesisM20409getFontSynthesisZQGJjVo, fontFamily2, fontFeatureSettings, jM20410getLetterSpacingXSAIIZE, baselineShiftM20405getBaselineShift5SSeXJ0, textGeometricTransform2, localeList2, jM20404getBackground0d7_KjU, textDecoration3, shadow2, textAlignM20850boximpl, textDirectionM20864boximpl, jM20360getLineHeightXSAIIZE, textIndent2, platformTextStyle2, lineHeightStyle2);
    }

    /* JADX INFO: renamed from: copy-Ns73l9s$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m20467copyNs73l9s$default(TextStyle textStyle, Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i4, int i5, TextMotion textMotion, int i6, Object obj) {
        TextMotion textMotion2;
        int i7;
        TextDecoration textDecoration2;
        DrawStyle drawStyle2;
        int i8;
        int i9;
        TextIndent textIndent2;
        PlatformTextStyle platformTextStyle2;
        LineHeightStyle lineHeightStyle2;
        Shadow shadow2;
        long j6;
        FontWeight fontWeight2;
        FontStyle fontStyle2;
        FontSynthesis fontSynthesis2;
        String str2;
        long j7;
        BaselineShift baselineShift2;
        TextGeometricTransform textGeometricTransform2;
        LocaleList localeList2;
        long j8;
        long j9;
        Brush brush2;
        float f4;
        int i10;
        TextStyle textStyle2;
        FontFamily fontFamily2;
        float alpha = (i6 & 2) != 0 ? textStyle.spanStyle.getAlpha() : f;
        long jM20407getFontSizeXSAIIZE = (i6 & 4) != 0 ? textStyle.spanStyle.getFontSize() : j;
        FontWeight fontWeight3 = (i6 & 8) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight;
        FontStyle fontStyleM20408getFontStyle4Lr2A7w = (i6 & 16) != 0 ? textStyle.spanStyle.getFontStyle() : fontStyle;
        FontSynthesis fontSynthesisM20409getFontSynthesisZQGJjVo = (i6 & 32) != 0 ? textStyle.spanStyle.getFontSynthesis() : fontSynthesis;
        FontFamily fontFamily3 = (i6 & 64) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i6 & 128) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str;
        long jM20410getLetterSpacingXSAIIZE = (i6 & 256) != 0 ? textStyle.spanStyle.getLetterSpacing() : j2;
        BaselineShift baselineShiftM20405getBaselineShift5SSeXJ0 = (i6 & 512) != 0 ? textStyle.spanStyle.getBaselineShift() : baselineShift;
        TextGeometricTransform textGeometricTransform3 = (i6 & 1024) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList3 = (i6 & 2048) != 0 ? textStyle.spanStyle.getLocaleList() : localeList;
        long jM20404getBackground0d7_KjU = (i6 & 4096) != 0 ? textStyle.spanStyle.getBackground() : j3;
        float f5 = alpha;
        TextDecoration textDecoration3 = (i6 & 8192) != 0 ? textStyle.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow3 = (i6 & 16384) != 0 ? textStyle.spanStyle.getShadow() : shadow;
        DrawStyle drawStyle3 = (i6 & 32768) != 0 ? textStyle.spanStyle.getDrawStyle() : drawStyle;
        int iM20362getTextAligne0LSkKk = (i6 & 65536) != 0 ? textStyle.paragraphStyle.getTextAlign() : i;
        int iM20364getTextDirections_7Xco = (i6 & 131072) != 0 ? textStyle.paragraphStyle.getTextDirection() : i2;
        long jM20360getLineHeightXSAIIZE = (i6 & 262144) != 0 ? textStyle.paragraphStyle.getLineHeight() : j5;
        TextIndent textIndent3 = (i6 & 524288) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent;
        PlatformTextStyle platformTextStyle3 = (i6 & 1048576) != 0 ? textStyle.platformStyle : platformTextStyle;
        LineHeightStyle lineHeightStyle3 = (i6 & 2097152) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : lineHeightStyle;
        int iM20359getLineBreakrAG3T2k = (i6 & 4194304) != 0 ? textStyle.paragraphStyle.getLineBreak() : i4;
        int iM20357getHyphensvmbZdU8 = (i6 & 8388608) != 0 ? textStyle.paragraphStyle.getHyphens() : i5;
        if ((i6 & 16777216) != 0) {
            i7 = iM20357getHyphensvmbZdU8;
            textMotion2 = textStyle.paragraphStyle.getTextMotion();
            textDecoration2 = textDecoration3;
            drawStyle2 = drawStyle3;
            i8 = iM20362getTextAligne0LSkKk;
            i9 = iM20364getTextDirections_7Xco;
            textIndent2 = textIndent3;
            platformTextStyle2 = platformTextStyle3;
            lineHeightStyle2 = lineHeightStyle3;
            i10 = iM20359getLineBreakrAG3T2k;
            shadow2 = shadow3;
            j6 = jM20407getFontSizeXSAIIZE;
            fontWeight2 = fontWeight3;
            fontStyle2 = fontStyleM20408getFontStyle4Lr2A7w;
            fontSynthesis2 = fontSynthesisM20409getFontSynthesisZQGJjVo;
            fontFamily2 = fontFamily3;
            str2 = fontFeatureSettings;
            j7 = jM20410getLetterSpacingXSAIIZE;
            baselineShift2 = baselineShiftM20405getBaselineShift5SSeXJ0;
            textGeometricTransform2 = textGeometricTransform3;
            localeList2 = localeList3;
            j8 = jM20404getBackground0d7_KjU;
            j9 = jM20360getLineHeightXSAIIZE;
            brush2 = brush;
            f4 = f5;
            textStyle2 = textStyle;
        } else {
            textMotion2 = textMotion;
            i7 = iM20357getHyphensvmbZdU8;
            textDecoration2 = textDecoration3;
            drawStyle2 = drawStyle3;
            i8 = iM20362getTextAligne0LSkKk;
            i9 = iM20364getTextDirections_7Xco;
            textIndent2 = textIndent3;
            platformTextStyle2 = platformTextStyle3;
            lineHeightStyle2 = lineHeightStyle3;
            shadow2 = shadow3;
            j6 = jM20407getFontSizeXSAIIZE;
            fontWeight2 = fontWeight3;
            fontStyle2 = fontStyleM20408getFontStyle4Lr2A7w;
            fontSynthesis2 = fontSynthesisM20409getFontSynthesisZQGJjVo;
            str2 = fontFeatureSettings;
            j7 = jM20410getLetterSpacingXSAIIZE;
            baselineShift2 = baselineShiftM20405getBaselineShift5SSeXJ0;
            textGeometricTransform2 = textGeometricTransform3;
            localeList2 = localeList3;
            j8 = jM20404getBackground0d7_KjU;
            j9 = jM20360getLineHeightXSAIIZE;
            brush2 = brush;
            f4 = f5;
            i10 = iM20359getLineBreakrAG3T2k;
            textStyle2 = textStyle;
            fontFamily2 = fontFamily3;
        }
        return textStyle2.m20480copyNs73l9s(brush2, f4, j6, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str2, j7, baselineShift2, textGeometricTransform2, localeList2, j8, textDecoration2, shadow2, drawStyle2, i8, i9, j9, textIndent2, platformTextStyle2, lineHeightStyle2, i10, i7, textMotion2);
    }

    /* JADX INFO: renamed from: copy-aIRg9q4$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m20468copyaIRg9q4$default(TextStyle textStyle, Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, int i, Object obj) {
        TextMotion textMotion2;
        Hyphens hyphens2;
        TextDecoration textDecoration2;
        DrawStyle drawStyle2;
        TextAlign textAlign2;
        TextDirection textDirection2;
        TextIndent textIndent2;
        PlatformTextStyle platformTextStyle2;
        LineHeightStyle lineHeightStyle2;
        Shadow shadow2;
        long j6;
        FontWeight fontWeight2;
        FontStyle fontStyle2;
        FontSynthesis fontSynthesis2;
        String str2;
        long j7;
        BaselineShift baselineShift2;
        TextGeometricTransform textGeometricTransform2;
        LocaleList localeList2;
        long j8;
        long j9;
        Brush brush2;
        float f4;
        LineBreak lineBreak2;
        TextStyle textStyle2;
        FontFamily fontFamily2;
        float alpha = (i & 2) != 0 ? textStyle.spanStyle.getAlpha() : f;
        long jM20407getFontSizeXSAIIZE = (i & 4) != 0 ? textStyle.spanStyle.getFontSize() : j;
        FontWeight fontWeight3 = (i & 8) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight;
        FontStyle fontStyleM20408getFontStyle4Lr2A7w = (i & 16) != 0 ? textStyle.spanStyle.getFontStyle() : fontStyle;
        FontSynthesis fontSynthesisM20409getFontSynthesisZQGJjVo = (i & 32) != 0 ? textStyle.spanStyle.getFontSynthesis() : fontSynthesis;
        FontFamily fontFamily3 = (i & 64) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i & 128) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str;
        long jM20410getLetterSpacingXSAIIZE = (i & 256) != 0 ? textStyle.spanStyle.getLetterSpacing() : j2;
        BaselineShift baselineShiftM20405getBaselineShift5SSeXJ0 = (i & 512) != 0 ? textStyle.spanStyle.getBaselineShift() : baselineShift;
        TextGeometricTransform textGeometricTransform3 = (i & 1024) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList3 = (i & 2048) != 0 ? textStyle.spanStyle.getLocaleList() : localeList;
        long jM20404getBackground0d7_KjU = (i & 4096) != 0 ? textStyle.spanStyle.getBackground() : j3;
        float f5 = alpha;
        TextDecoration textDecoration3 = (i & 8192) != 0 ? textStyle.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow3 = (i & 16384) != 0 ? textStyle.spanStyle.getShadow() : shadow;
        DrawStyle drawStyle3 = (i & 32768) != 0 ? textStyle.spanStyle.getDrawStyle() : drawStyle;
        TextAlign textAlignM20850boximpl = (i & 65536) != 0 ? TextAlign.m20850boximpl(textStyle.paragraphStyle.getTextAlign()) : textAlign;
        TextDirection textDirectionM20864boximpl = (i & 131072) != 0 ? TextDirection.m20864boximpl(textStyle.paragraphStyle.getTextDirection()) : textDirection;
        long jM20360getLineHeightXSAIIZE = (i & 262144) != 0 ? textStyle.paragraphStyle.getLineHeight() : j5;
        TextIndent textIndent3 = (i & 524288) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent;
        PlatformTextStyle platformTextStyle3 = (i & 1048576) != 0 ? textStyle.platformStyle : platformTextStyle;
        LineHeightStyle lineHeightStyle3 = (i & 2097152) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : lineHeightStyle;
        LineBreak lineBreakM20770boximpl = (i & 4194304) != 0 ? LineBreak.m20770boximpl(textStyle.paragraphStyle.getLineBreak()) : lineBreak;
        Hyphens hyphensM20760boximpl = (i & 8388608) != 0 ? Hyphens.m20760boximpl(textStyle.paragraphStyle.getHyphens()) : hyphens;
        if ((i & 16777216) != 0) {
            hyphens2 = hyphensM20760boximpl;
            textMotion2 = textStyle.paragraphStyle.getTextMotion();
            textDecoration2 = textDecoration3;
            drawStyle2 = drawStyle3;
            textAlign2 = textAlignM20850boximpl;
            textDirection2 = textDirectionM20864boximpl;
            textIndent2 = textIndent3;
            platformTextStyle2 = platformTextStyle3;
            lineHeightStyle2 = lineHeightStyle3;
            lineBreak2 = lineBreakM20770boximpl;
            shadow2 = shadow3;
            j6 = jM20407getFontSizeXSAIIZE;
            fontWeight2 = fontWeight3;
            fontStyle2 = fontStyleM20408getFontStyle4Lr2A7w;
            fontSynthesis2 = fontSynthesisM20409getFontSynthesisZQGJjVo;
            fontFamily2 = fontFamily3;
            str2 = fontFeatureSettings;
            j7 = jM20410getLetterSpacingXSAIIZE;
            baselineShift2 = baselineShiftM20405getBaselineShift5SSeXJ0;
            textGeometricTransform2 = textGeometricTransform3;
            localeList2 = localeList3;
            j8 = jM20404getBackground0d7_KjU;
            j9 = jM20360getLineHeightXSAIIZE;
            brush2 = brush;
            f4 = f5;
            textStyle2 = textStyle;
        } else {
            textMotion2 = textMotion;
            hyphens2 = hyphensM20760boximpl;
            textDecoration2 = textDecoration3;
            drawStyle2 = drawStyle3;
            textAlign2 = textAlignM20850boximpl;
            textDirection2 = textDirectionM20864boximpl;
            textIndent2 = textIndent3;
            platformTextStyle2 = platformTextStyle3;
            lineHeightStyle2 = lineHeightStyle3;
            shadow2 = shadow3;
            j6 = jM20407getFontSizeXSAIIZE;
            fontWeight2 = fontWeight3;
            fontStyle2 = fontStyleM20408getFontStyle4Lr2A7w;
            fontSynthesis2 = fontSynthesisM20409getFontSynthesisZQGJjVo;
            str2 = fontFeatureSettings;
            j7 = jM20410getLetterSpacingXSAIIZE;
            baselineShift2 = baselineShiftM20405getBaselineShift5SSeXJ0;
            textGeometricTransform2 = textGeometricTransform3;
            localeList2 = localeList3;
            j8 = jM20404getBackground0d7_KjU;
            j9 = jM20360getLineHeightXSAIIZE;
            brush2 = brush;
            f4 = f5;
            lineBreak2 = lineBreakM20770boximpl;
            textStyle2 = textStyle;
            fontFamily2 = fontFamily3;
        }
        return textStyle2.m20481copyaIRg9q4(brush2, f4, j6, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str2, j7, baselineShift2, textGeometricTransform2, localeList2, j8, textDecoration2, shadow2, drawStyle2, textAlign2, textDirection2, j9, textIndent2, platformTextStyle2, lineHeightStyle2, lineBreak2, hyphens2, textMotion2);
    }

    /* JADX INFO: renamed from: copy-p1EtxEg$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m20469copyp1EtxEg$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j6, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i4, int i5, TextMotion textMotion, int i6, Object obj) {
        TextMotion textMotion2;
        int i7;
        long jM20406getColor0d7_KjU = (i6 & 1) != 0 ? textStyle.spanStyle.m20406getColor0d7_KjU() : j;
        long jM20407getFontSizeXSAIIZE = (i6 & 2) != 0 ? textStyle.spanStyle.getFontSize() : j2;
        FontWeight fontWeight2 = (i6 & 4) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight;
        FontStyle fontStyleM20408getFontStyle4Lr2A7w = (i6 & 8) != 0 ? textStyle.spanStyle.getFontStyle() : fontStyle;
        FontSynthesis fontSynthesisM20409getFontSynthesisZQGJjVo = (i6 & 16) != 0 ? textStyle.spanStyle.getFontSynthesis() : fontSynthesis;
        FontFamily fontFamily2 = (i6 & 32) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i6 & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str;
        long jM20410getLetterSpacingXSAIIZE = (i6 & 128) != 0 ? textStyle.spanStyle.getLetterSpacing() : j3;
        BaselineShift baselineShiftM20405getBaselineShift5SSeXJ0 = (i6 & 256) != 0 ? textStyle.spanStyle.getBaselineShift() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i6 & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i6 & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : localeList;
        long j7 = jM20406getColor0d7_KjU;
        long jM20404getBackground0d7_KjU = (i6 & 2048) != 0 ? textStyle.spanStyle.getBackground() : j5;
        TextDecoration textDecoration2 = (i6 & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow2 = (i6 & 8192) != 0 ? textStyle.spanStyle.getShadow() : shadow;
        TextDecoration textDecoration3 = textDecoration2;
        DrawStyle drawStyle2 = (i6 & 16384) != 0 ? textStyle.spanStyle.getDrawStyle() : drawStyle;
        int iM20362getTextAligne0LSkKk = (i6 & 32768) != 0 ? textStyle.paragraphStyle.getTextAlign() : i;
        int iM20364getTextDirections_7Xco = (i6 & 65536) != 0 ? textStyle.paragraphStyle.getTextDirection() : i2;
        long jM20360getLineHeightXSAIIZE = (i6 & 131072) != 0 ? textStyle.paragraphStyle.getLineHeight() : j6;
        TextIndent textIndent2 = (i6 & 262144) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent;
        PlatformTextStyle platformTextStyle2 = (i6 & 524288) != 0 ? textStyle.platformStyle : platformTextStyle;
        LineHeightStyle lineHeightStyle2 = (i6 & 1048576) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : lineHeightStyle;
        int iM20359getLineBreakrAG3T2k = (i6 & 2097152) != 0 ? textStyle.paragraphStyle.getLineBreak() : i4;
        int iM20357getHyphensvmbZdU8 = (i6 & 4194304) != 0 ? textStyle.paragraphStyle.getHyphens() : i5;
        if ((i6 & 8388608) != 0) {
            i7 = iM20357getHyphensvmbZdU8;
            textMotion2 = textStyle.paragraphStyle.getTextMotion();
        } else {
            textMotion2 = textMotion;
            i7 = iM20357getHyphensvmbZdU8;
        }
        return textStyle.m20482copyp1EtxEg(j7, jM20407getFontSizeXSAIIZE, fontWeight2, fontStyleM20408getFontStyle4Lr2A7w, fontSynthesisM20409getFontSynthesisZQGJjVo, fontFamily2, fontFeatureSettings, jM20410getLetterSpacingXSAIIZE, baselineShiftM20405getBaselineShift5SSeXJ0, textGeometricTransform2, localeList2, jM20404getBackground0d7_KjU, textDecoration3, shadow2, drawStyle2, iM20362getTextAligne0LSkKk, iM20364getTextDirections_7Xco, jM20360getLineHeightXSAIIZE, textIndent2, platformTextStyle2, lineHeightStyle2, iM20359getLineBreakrAG3T2k, i7, textMotion2);
    }

    /* JADX INFO: renamed from: copy-v2rsoow$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m20470copyv2rsoow$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j6, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, int i, Object obj) {
        TextMotion textMotion2;
        Hyphens hyphens2;
        long jM20406getColor0d7_KjU = (i & 1) != 0 ? textStyle.spanStyle.m20406getColor0d7_KjU() : j;
        long jM20407getFontSizeXSAIIZE = (i & 2) != 0 ? textStyle.spanStyle.getFontSize() : j2;
        FontWeight fontWeight2 = (i & 4) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight;
        FontStyle fontStyleM20408getFontStyle4Lr2A7w = (i & 8) != 0 ? textStyle.spanStyle.getFontStyle() : fontStyle;
        FontSynthesis fontSynthesisM20409getFontSynthesisZQGJjVo = (i & 16) != 0 ? textStyle.spanStyle.getFontSynthesis() : fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str;
        long jM20410getLetterSpacingXSAIIZE = (i & 128) != 0 ? textStyle.spanStyle.getLetterSpacing() : j3;
        BaselineShift baselineShiftM20405getBaselineShift5SSeXJ0 = (i & 256) != 0 ? textStyle.spanStyle.getBaselineShift() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : localeList;
        long j7 = jM20406getColor0d7_KjU;
        long jM20404getBackground0d7_KjU = (i & 2048) != 0 ? textStyle.spanStyle.getBackground() : j5;
        TextDecoration textDecoration2 = (i & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow2 = (i & 8192) != 0 ? textStyle.spanStyle.getShadow() : shadow;
        TextDecoration textDecoration3 = textDecoration2;
        DrawStyle drawStyle2 = (i & 16384) != 0 ? textStyle.spanStyle.getDrawStyle() : drawStyle;
        TextAlign textAlignM20850boximpl = (i & 32768) != 0 ? TextAlign.m20850boximpl(textStyle.paragraphStyle.getTextAlign()) : textAlign;
        TextDirection textDirectionM20864boximpl = (i & 65536) != 0 ? TextDirection.m20864boximpl(textStyle.paragraphStyle.getTextDirection()) : textDirection;
        long jM20360getLineHeightXSAIIZE = (i & 131072) != 0 ? textStyle.paragraphStyle.getLineHeight() : j6;
        TextIndent textIndent2 = (i & 262144) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent;
        PlatformTextStyle platformTextStyle2 = (i & 524288) != 0 ? textStyle.platformStyle : platformTextStyle;
        LineHeightStyle lineHeightStyle2 = (i & 1048576) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : lineHeightStyle;
        LineBreak lineBreakM20770boximpl = (i & 2097152) != 0 ? LineBreak.m20770boximpl(textStyle.paragraphStyle.getLineBreak()) : lineBreak;
        Hyphens hyphensM20760boximpl = (i & 4194304) != 0 ? Hyphens.m20760boximpl(textStyle.paragraphStyle.getHyphens()) : hyphens;
        if ((i & 8388608) != 0) {
            hyphens2 = hyphensM20760boximpl;
            textMotion2 = textStyle.paragraphStyle.getTextMotion();
        } else {
            textMotion2 = textMotion;
            hyphens2 = hyphensM20760boximpl;
        }
        return textStyle.m20483copyv2rsoow(j7, jM20407getFontSizeXSAIIZE, fontWeight2, fontStyleM20408getFontStyle4Lr2A7w, fontSynthesisM20409getFontSynthesisZQGJjVo, fontFamily2, fontFeatureSettings, jM20410getLetterSpacingXSAIIZE, baselineShiftM20405getBaselineShift5SSeXJ0, textGeometricTransform2, localeList2, jM20404getBackground0d7_KjU, textDecoration3, shadow2, drawStyle2, textAlignM20850boximpl, textDirectionM20864boximpl, jM20360getLineHeightXSAIIZE, textIndent2, platformTextStyle2, lineHeightStyle2, lineBreakM20770boximpl, hyphens2, textMotion2);
    }

    public static /* synthetic */ TextStyle merge$default(TextStyle textStyle, TextStyle textStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            textStyle2 = null;
        }
        return textStyle.merge(textStyle2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle copy constructors that do not take new stable parameters like LineBreak, Hyphens, and TextMotion are deprecated. Please use the new stable copy constructor.")
    /* JADX INFO: renamed from: copy-CXVQc50, reason: not valid java name */
    public final /* synthetic */ TextStyle m20477copyCXVQc50(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, PlatformTextStyle platformStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens) {
        return new TextStyle(new SpanStyle(Color.m18526equalsimpl0(color, this.spanStyle.m20406getColor0d7_KjU()) ? this.spanStyle.getTextForegroundStyle() : TextForegroundStyle.INSTANCE.m20878from8_81llA(color), fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, platformStyle != null ? platformStyle.getSpanStyle() : null, getDrawStyle(), (DefaultConstructorMarker) null), new ParagraphStyle(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m20863getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m20876getUnspecifieds_7Xco(), lineHeight, textIndent, platformStyle != null ? platformStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak != null ? lineBreak.getMask() : LineBreak.INSTANCE.m20790getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.getValue() : Hyphens.INSTANCE.m20769getUnspecifiedvmbZdU8(), getTextMotion(), (DefaultConstructorMarker) null), platformStyle);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.")
    /* JADX INFO: renamed from: copy-HL5avdY, reason: not valid java name */
    public final /* synthetic */ TextStyle m20478copyHL5avdY(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent) {
        return new TextStyle(new SpanStyle(Color.m18526equalsimpl0(color, this.spanStyle.m20406getColor0d7_KjU()) ? this.spanStyle.getTextForegroundStyle() : TextForegroundStyle.INSTANCE.m20878from8_81llA(color), fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, this.spanStyle.getPlatformStyle(), this.spanStyle.getDrawStyle(), (DefaultConstructorMarker) null), new ParagraphStyle(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m20863getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m20876getUnspecifieds_7Xco(), lineHeight, textIndent, this.paragraphStyle.getPlatformStyle(), getLineHeightStyle(), m20494getLineBreakrAG3T2k(), m20491getHyphensvmbZdU8(), getTextMotion(), (DefaultConstructorMarker) null), this.platformStyle);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.")
    /* JADX INFO: renamed from: copy-NOaFTUo, reason: not valid java name */
    public final /* synthetic */ TextStyle m20479copyNOaFTUo(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, PlatformTextStyle platformStyle, LineHeightStyle lineHeightStyle) {
        return new TextStyle(new SpanStyle(Color.m18526equalsimpl0(color, this.spanStyle.m20406getColor0d7_KjU()) ? this.spanStyle.getTextForegroundStyle() : TextForegroundStyle.INSTANCE.m20878from8_81llA(color), fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, platformStyle != null ? platformStyle.getSpanStyle() : null, this.spanStyle.getDrawStyle(), (DefaultConstructorMarker) null), new ParagraphStyle(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m20863getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m20876getUnspecifieds_7Xco(), lineHeight, textIndent, platformStyle != null ? platformStyle.getParagraphStyle() : null, lineHeightStyle, m20494getLineBreakrAG3T2k(), m20491getHyphensvmbZdU8(), getTextMotion(), (DefaultConstructorMarker) null), platformStyle);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-Ns73l9s, reason: not valid java name */
    public final TextStyle m20480copyNs73l9s(@Nullable Brush brush, float alpha, long fontSize, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable FontSynthesis fontSynthesis, @Nullable FontFamily fontFamily, @Nullable String fontFeatureSettings, long letterSpacing, @Nullable BaselineShift baselineShift, @Nullable TextGeometricTransform textGeometricTransform, @Nullable LocaleList localeList, long background, @Nullable TextDecoration textDecoration, @Nullable Shadow shadow, @Nullable DrawStyle drawStyle, int textAlign, int textDirection, long lineHeight, @Nullable TextIndent textIndent, @Nullable PlatformTextStyle platformStyle, @Nullable LineHeightStyle lineHeightStyle, int lineBreak, int hyphens, @Nullable TextMotion textMotion) {
        return new TextStyle(new SpanStyle(brush, alpha, fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, platformStyle != null ? platformStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(textAlign, textDirection, lineHeight, textIndent, platformStyle != null ? platformStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak, hyphens, textMotion, (DefaultConstructorMarker) null), platformStyle);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "copy constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    /* JADX INFO: renamed from: copy-aIRg9q4, reason: not valid java name */
    public final /* synthetic */ TextStyle m20481copyaIRg9q4(Brush brush, float alpha, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, PlatformTextStyle platformStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        return new TextStyle(new SpanStyle(brush, alpha, fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, platformStyle != null ? platformStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m20863getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m20876getUnspecifieds_7Xco(), lineHeight, textIndent, platformStyle != null ? platformStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak != null ? lineBreak.getMask() : LineBreak.INSTANCE.m20790getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.getValue() : Hyphens.INSTANCE.m20769getUnspecifiedvmbZdU8(), textMotion, (DefaultConstructorMarker) null), platformStyle);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-p1EtxEg, reason: not valid java name */
    public final TextStyle m20482copyp1EtxEg(long color, long fontSize, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable FontSynthesis fontSynthesis, @Nullable FontFamily fontFamily, @Nullable String fontFeatureSettings, long letterSpacing, @Nullable BaselineShift baselineShift, @Nullable TextGeometricTransform textGeometricTransform, @Nullable LocaleList localeList, long background, @Nullable TextDecoration textDecoration, @Nullable Shadow shadow, @Nullable DrawStyle drawStyle, int textAlign, int textDirection, long lineHeight, @Nullable TextIndent textIndent, @Nullable PlatformTextStyle platformStyle, @Nullable LineHeightStyle lineHeightStyle, int lineBreak, int hyphens, @Nullable TextMotion textMotion) {
        return new TextStyle(new SpanStyle(Color.m18526equalsimpl0(color, this.spanStyle.m20406getColor0d7_KjU()) ? this.spanStyle.getTextForegroundStyle() : TextForegroundStyle.INSTANCE.m20878from8_81llA(color), fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, platformStyle != null ? platformStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(textAlign, textDirection, lineHeight, textIndent, platformStyle != null ? platformStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak, hyphens, textMotion, (DefaultConstructorMarker) null), platformStyle);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "copy constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    /* JADX INFO: renamed from: copy-v2rsoow, reason: not valid java name */
    public final /* synthetic */ TextStyle m20483copyv2rsoow(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, PlatformTextStyle platformStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        return new TextStyle(new SpanStyle(Color.m18526equalsimpl0(color, this.spanStyle.m20406getColor0d7_KjU()) ? this.spanStyle.getTextForegroundStyle() : TextForegroundStyle.INSTANCE.m20878from8_81llA(color), fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, platformStyle != null ? platformStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m20863getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m20876getUnspecifieds_7Xco(), lineHeight, textIndent, platformStyle != null ? platformStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak != null ? lineBreak.getMask() : LineBreak.INSTANCE.m20790getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.getValue() : Hyphens.INSTANCE.m20769getUnspecifiedvmbZdU8(), textMotion, (DefaultConstructorMarker) null), platformStyle);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextStyle)) {
            return false;
        }
        TextStyle textStyle = (TextStyle) other;
        return Intrinsics.areEqual(this.spanStyle, textStyle.spanStyle) && Intrinsics.areEqual(this.paragraphStyle, textStyle.paragraphStyle) && Intrinsics.areEqual(this.platformStyle, textStyle.platformStyle);
    }

    public final float getAlpha() {
        return this.spanStyle.getAlpha();
    }

    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m20484getBackground0d7_KjU() {
        return this.spanStyle.getBackground();
    }

    @Nullable
    /* JADX INFO: renamed from: getBaselineShift-5SSeXJ0, reason: not valid java name */
    public final BaselineShift m20485getBaselineShift5SSeXJ0() {
        return this.spanStyle.getBaselineShift();
    }

    @Nullable
    public final Brush getBrush() {
        return this.spanStyle.getBrush();
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m20486getColor0d7_KjU() {
        return this.spanStyle.m20406getColor0d7_KjU();
    }

    @Nullable
    public final DrawStyle getDrawStyle() {
        return this.spanStyle.getDrawStyle();
    }

    @Nullable
    public final FontFamily getFontFamily() {
        return this.spanStyle.getFontFamily();
    }

    @Nullable
    public final String getFontFeatureSettings() {
        return this.spanStyle.getFontFeatureSettings();
    }

    /* JADX INFO: renamed from: getFontSize-XSAIIZE, reason: not valid java name */
    public final long m20487getFontSizeXSAIIZE() {
        return this.spanStyle.getFontSize();
    }

    @Nullable
    /* JADX INFO: renamed from: getFontStyle-4Lr2A7w, reason: not valid java name */
    public final FontStyle m20488getFontStyle4Lr2A7w() {
        return this.spanStyle.getFontStyle();
    }

    @Nullable
    /* JADX INFO: renamed from: getFontSynthesis-ZQGJjVo, reason: not valid java name */
    public final FontSynthesis m20489getFontSynthesisZQGJjVo() {
        return this.spanStyle.getFontSynthesis();
    }

    @Nullable
    public final FontWeight getFontWeight() {
        return this.spanStyle.getFontWeight();
    }

    @JvmName(name = "getHyphens-EaSxIns")
    @Nullable
    /* JADX INFO: renamed from: getHyphens-EaSxIns, reason: not valid java name */
    public final Hyphens m20490getHyphensEaSxIns() {
        return Hyphens.m20760boximpl(m20491getHyphensvmbZdU8());
    }

    /* JADX INFO: renamed from: getHyphens-vmbZdU8, reason: not valid java name */
    public final int m20491getHyphensvmbZdU8() {
        return this.paragraphStyle.getHyphens();
    }

    /* JADX INFO: renamed from: getLetterSpacing-XSAIIZE, reason: not valid java name */
    public final long m20492getLetterSpacingXSAIIZE() {
        return this.spanStyle.getLetterSpacing();
    }

    @JvmName(name = "getLineBreak-LgCVezo")
    @Nullable
    /* JADX INFO: renamed from: getLineBreak-LgCVezo, reason: not valid java name */
    public final LineBreak m20493getLineBreakLgCVezo() {
        return LineBreak.m20770boximpl(m20494getLineBreakrAG3T2k());
    }

    /* JADX INFO: renamed from: getLineBreak-rAG3T2k, reason: not valid java name */
    public final int m20494getLineBreakrAG3T2k() {
        return this.paragraphStyle.getLineBreak();
    }

    /* JADX INFO: renamed from: getLineHeight-XSAIIZE, reason: not valid java name */
    public final long m20495getLineHeightXSAIIZE() {
        return this.paragraphStyle.getLineHeight();
    }

    @Nullable
    public final LineHeightStyle getLineHeightStyle() {
        return this.paragraphStyle.getLineHeightStyle();
    }

    @Nullable
    public final LocaleList getLocaleList() {
        return this.spanStyle.getLocaleList();
    }

    @NotNull
    /* JADX INFO: renamed from: getParagraphStyle$ui_text_release, reason: from getter */
    public final ParagraphStyle getParagraphStyle() {
        return this.paragraphStyle;
    }

    @Nullable
    public final PlatformTextStyle getPlatformStyle() {
        return this.platformStyle;
    }

    @Nullable
    public final Shadow getShadow() {
        return this.spanStyle.getShadow();
    }

    @NotNull
    /* JADX INFO: renamed from: getSpanStyle$ui_text_release, reason: from getter */
    public final SpanStyle getSpanStyle() {
        return this.spanStyle;
    }

    @JvmName(name = "getTextAlign-buA522U")
    @Nullable
    /* JADX INFO: renamed from: getTextAlign-buA522U, reason: not valid java name */
    public final TextAlign m20496getTextAlignbuA522U() {
        return TextAlign.m20850boximpl(m20497getTextAligne0LSkKk());
    }

    /* JADX INFO: renamed from: getTextAlign-e0LSkKk, reason: not valid java name */
    public final int m20497getTextAligne0LSkKk() {
        return this.paragraphStyle.getTextAlign();
    }

    @Nullable
    public final TextDecoration getTextDecoration() {
        return this.spanStyle.getTextDecoration();
    }

    @JvmName(name = "getTextDirection-mmuk1to")
    @Nullable
    /* JADX INFO: renamed from: getTextDirection-mmuk1to, reason: not valid java name */
    public final TextDirection m20498getTextDirectionmmuk1to() {
        return TextDirection.m20864boximpl(m20499getTextDirections_7Xco());
    }

    /* JADX INFO: renamed from: getTextDirection-s_7X-co, reason: not valid java name */
    public final int m20499getTextDirections_7Xco() {
        return this.paragraphStyle.getTextDirection();
    }

    @Nullable
    public final TextGeometricTransform getTextGeometricTransform() {
        return this.spanStyle.getTextGeometricTransform();
    }

    @Nullable
    public final TextIndent getTextIndent() {
        return this.paragraphStyle.getTextIndent();
    }

    @Nullable
    public final TextMotion getTextMotion() {
        return this.paragraphStyle.getTextMotion();
    }

    public final boolean hasSameDrawAffectingAttributes(@NotNull TextStyle other) {
        return this == other || this.spanStyle.hasSameNonLayoutAttributes$ui_text_release(other.spanStyle);
    }

    public final boolean hasSameLayoutAffectingAttributes(@NotNull TextStyle other) {
        if (this != other) {
            return Intrinsics.areEqual(this.paragraphStyle, other.paragraphStyle) && this.spanStyle.hasSameLayoutAffectingAttributes$ui_text_release(other.spanStyle);
        }
        return true;
    }

    public int hashCode() {
        int iHashCode = (this.paragraphStyle.hashCode() + (this.spanStyle.hashCode() * 31)) * 31;
        PlatformTextStyle platformTextStyle = this.platformStyle;
        return iHashCode + (platformTextStyle != null ? platformTextStyle.hashCode() : 0);
    }

    public final int hashCodeLayoutAffectingAttributes$ui_text_release() {
        int iHashCode = (this.paragraphStyle.hashCode() + (this.spanStyle.hashCodeLayoutAffectingAttributes$ui_text_release() * 31)) * 31;
        PlatformTextStyle platformTextStyle = this.platformStyle;
        return iHashCode + (platformTextStyle != null ? platformTextStyle.hashCode() : 0);
    }

    @Stable
    @NotNull
    public final TextStyle merge(@Nullable TextStyle other) {
        return (other == null || Intrinsics.areEqual(other, Default)) ? this : new TextStyle(toSpanStyle().merge(other.toSpanStyle()), toParagraphStyle().merge(other.toParagraphStyle()));
    }

    @Stable
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "merge that takes nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    /* JADX INFO: renamed from: merge-Z1GrekI, reason: not valid java name */
    public final /* synthetic */ TextStyle m20500mergeZ1GrekI(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, PlatformTextStyle platformStyle, TextMotion textMotion) {
        SpanStyle spanStyleM20411fastMergedSHsh3o = SpanStyleKt.m20411fastMergedSHsh3o(this.spanStyle, color, null, Float.NaN, fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, platformStyle != null ? platformStyle.getSpanStyle() : null, drawStyle);
        ParagraphStyle paragraphStyleM20365fastMergej5T8yCg = ParagraphStyleKt.m20365fastMergej5T8yCg(this.paragraphStyle, textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m20863getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m20876getUnspecifieds_7Xco(), lineHeight, textIndent, platformStyle != null ? platformStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak != null ? lineBreak.getMask() : LineBreak.INSTANCE.m20790getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.getValue() : Hyphens.INSTANCE.m20769getUnspecifiedvmbZdU8(), textMotion);
        return (this.spanStyle == spanStyleM20411fastMergedSHsh3o && this.paragraphStyle == paragraphStyleM20365fastMergej5T8yCg) ? this : new TextStyle(spanStyleM20411fastMergedSHsh3o, paragraphStyleM20365fastMergej5T8yCg);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: merge-dA7vx0o, reason: not valid java name */
    public final TextStyle m20501mergedA7vx0o(long color, long fontSize, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable FontSynthesis fontSynthesis, @Nullable FontFamily fontFamily, @Nullable String fontFeatureSettings, long letterSpacing, @Nullable BaselineShift baselineShift, @Nullable TextGeometricTransform textGeometricTransform, @Nullable LocaleList localeList, long background, @Nullable TextDecoration textDecoration, @Nullable Shadow shadow, @Nullable DrawStyle drawStyle, int textAlign, int textDirection, long lineHeight, @Nullable TextIndent textIndent, @Nullable LineHeightStyle lineHeightStyle, int lineBreak, int hyphens, @Nullable PlatformTextStyle platformStyle, @Nullable TextMotion textMotion) {
        SpanStyle spanStyleM20411fastMergedSHsh3o = SpanStyleKt.m20411fastMergedSHsh3o(this.spanStyle, color, null, Float.NaN, fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, platformStyle != null ? platformStyle.getSpanStyle() : null, drawStyle);
        ParagraphStyle paragraphStyleM20365fastMergej5T8yCg = ParagraphStyleKt.m20365fastMergej5T8yCg(this.paragraphStyle, textAlign, textDirection, lineHeight, textIndent, platformStyle != null ? platformStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak, hyphens, textMotion);
        return (this.spanStyle == spanStyleM20411fastMergedSHsh3o && this.paragraphStyle == paragraphStyleM20365fastMergej5T8yCg) ? this : new TextStyle(spanStyleM20411fastMergedSHsh3o, paragraphStyleM20365fastMergej5T8yCg);
    }

    @Stable
    @NotNull
    public final TextStyle plus(@NotNull TextStyle other) {
        return merge(other);
    }

    @Stable
    @NotNull
    public final ParagraphStyle toParagraphStyle() {
        return this.paragraphStyle;
    }

    @Stable
    @NotNull
    public final SpanStyle toSpanStyle() {
        return this.spanStyle;
    }

    @NotNull
    public String toString() {
        return "TextStyle(color=" + ((Object) Color.m18533toStringimpl(m20486getColor0d7_KjU())) + ", brush=" + getBrush() + ", alpha=" + getAlpha() + ", fontSize=" + ((Object) TextUnit.m21168toStringimpl(m20487getFontSizeXSAIIZE())) + ", fontWeight=" + getFontWeight() + ", fontStyle=" + m20488getFontStyle4Lr2A7w() + ", fontSynthesis=" + m20489getFontSynthesisZQGJjVo() + ", fontFamily=" + getFontFamily() + ", fontFeatureSettings=" + getFontFeatureSettings() + ", letterSpacing=" + ((Object) TextUnit.m21168toStringimpl(m20492getLetterSpacingXSAIIZE())) + ", baselineShift=" + m20485getBaselineShift5SSeXJ0() + ", textGeometricTransform=" + getTextGeometricTransform() + ", localeList=" + getLocaleList() + ", background=" + ((Object) Color.m18533toStringimpl(m20484getBackground0d7_KjU())) + ", textDecoration=" + getTextDecoration() + ", shadow=" + getShadow() + ", drawStyle=" + getDrawStyle() + ", textAlign=" + ((Object) TextAlign.m20855toStringimpl(m20497getTextAligne0LSkKk())) + ", textDirection=" + ((Object) TextDirection.m20869toStringimpl(m20499getTextDirections_7Xco())) + ", lineHeight=" + ((Object) TextUnit.m21168toStringimpl(m20495getLineHeightXSAIIZE())) + ", textIndent=" + getTextIndent() + ", platformStyle=" + this.platformStyle + ", lineHeightStyle=" + getLineHeightStyle() + ", lineBreak=" + ((Object) LineBreak.m20781toStringimpl(m20494getLineBreakrAG3T2k())) + ", hyphens=" + ((Object) Hyphens.m20765toStringimpl(m20491getHyphensvmbZdU8())) + ", textMotion=" + getTextMotion() + PropertyUtils.MAPPED_DELIM2;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j6, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j5, textDecoration, shadow, drawStyle, textAlign, textDirection, j6, textIndent, platformTextStyle, lineHeightStyle, lineBreak, hyphens, textMotion);
    }

    @Stable
    @NotNull
    public final TextStyle plus(@NotNull ParagraphStyle other) {
        return merge(other);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that do not take new stable parameters like TextMotion are deprecated. Please use the new stable constructor.")
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j6, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j5, textDecoration, shadow, textAlign, textDirection, j6, textIndent, platformTextStyle, lineHeightStyle, lineBreak, hyphens);
    }

    @Stable
    @NotNull
    public final TextStyle plus(@NotNull SpanStyle other) {
        return merge(other);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructor.")
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j6, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j5, textDecoration, shadow, textAlign, textDirection, j6, textIndent, platformTextStyle, lineHeightStyle);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructor.")
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j6, TextIndent textIndent, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j5, textDecoration, shadow, textAlign, textDirection, j6, textIndent);
    }

    public /* synthetic */ TextStyle(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i4, int i5, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(brush, f, j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, drawStyle, i, i2, j5, textIndent, platformTextStyle, lineHeightStyle, i4, i5, textMotion);
    }

    @Stable
    @NotNull
    public final TextStyle merge(@NotNull SpanStyle other) {
        return new TextStyle(toSpanStyle().merge(other), toParagraphStyle());
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    public /* synthetic */ TextStyle(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(brush, f, j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, drawStyle, textAlign, textDirection, j5, textIndent, platformTextStyle, lineHeightStyle, lineBreak, hyphens, textMotion);
    }

    public TextStyle(@NotNull SpanStyle spanStyle, @NotNull ParagraphStyle paragraphStyle, @Nullable PlatformTextStyle platformTextStyle) {
        this.spanStyle = spanStyle;
        this.paragraphStyle = paragraphStyle;
        this.platformStyle = platformTextStyle;
    }

    @Stable
    @NotNull
    public final TextStyle merge(@NotNull ParagraphStyle other) {
        return new TextStyle(toSpanStyle(), toParagraphStyle().merge(other));
    }

    public /* synthetic */ TextStyle(SpanStyle spanStyle, ParagraphStyle paragraphStyle, PlatformTextStyle platformTextStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(spanStyle, paragraphStyle, (i & 4) != 0 ? null : platformTextStyle);
    }

    public TextStyle(@NotNull SpanStyle spanStyle, @NotNull ParagraphStyle paragraphStyle) {
        this(spanStyle, paragraphStyle, TextStyleKt.createPlatformTextStyleInternal(spanStyle.getPlatformStyle(), paragraphStyle.getPlatformStyle()));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j6, TextIndent textIndent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long jM18561getUnspecified0d7_KjU = (i & 1) != 0 ? Color.INSTANCE.m18561getUnspecified0d7_KjU() : j;
        long jM21172getUnspecifiedXSAIIZE = (i & 2) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j2;
        FontWeight fontWeight2 = (i & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i & 8) != 0 ? null : fontStyle;
        FontSynthesis fontSynthesis2 = (i & 16) != 0 ? null : fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? null : fontFamily;
        String str2 = (i & 64) != 0 ? null : str;
        long jM21172getUnspecifiedXSAIIZE2 = (i & 128) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j3;
        BaselineShift baselineShift2 = (i & 256) != 0 ? null : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & 512) != 0 ? null : textGeometricTransform;
        LocaleList localeList2 = (i & 1024) != 0 ? null : localeList;
        long jM18561getUnspecified0d7_KjU2 = (i & 2048) != 0 ? Color.INSTANCE.m18561getUnspecified0d7_KjU() : j5;
        TextDecoration textDecoration2 = (i & 4096) != 0 ? null : textDecoration;
        long j7 = jM18561getUnspecified0d7_KjU;
        Shadow shadow2 = (i & 8192) != 0 ? null : shadow;
        TextAlign textAlign2 = (i & 16384) != 0 ? null : textAlign;
        TextDirection textDirection2 = (i & 32768) != 0 ? null : textDirection;
        long jM21172getUnspecifiedXSAIIZE3 = (i & 65536) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j6;
        long j8 = jM21172getUnspecifiedXSAIIZE;
        FontWeight fontWeight3 = fontWeight2;
        TextDecoration textDecoration3 = textDecoration2;
        FontStyle fontStyle3 = fontStyle2;
        FontSynthesis fontSynthesis3 = fontSynthesis2;
        FontFamily fontFamily3 = fontFamily2;
        String str3 = str2;
        long j9 = jM21172getUnspecifiedXSAIIZE2;
        BaselineShift baselineShift3 = baselineShift2;
        TextGeometricTransform textGeometricTransform3 = textGeometricTransform2;
        LocaleList localeList3 = localeList2;
        long j10 = jM18561getUnspecified0d7_KjU2;
        this(j7, j8, fontWeight3, fontStyle3, fontSynthesis3, fontFamily3, str3, j9, baselineShift3, textGeometricTransform3, localeList3, j10, textDecoration3, shadow2, textAlign2, textDirection2, jM21172getUnspecifiedXSAIIZE3, (i & 131072) != 0 ? null : textIndent, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* JADX INFO: renamed from: getHyphens-EaSxIns$annotations, reason: not valid java name */
    public static /* synthetic */ void m20471getHyphensEaSxIns$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* JADX INFO: renamed from: getLineBreak-LgCVezo$annotations, reason: not valid java name */
    public static /* synthetic */ void m20472getLineBreakLgCVezo$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* JADX INFO: renamed from: getTextAlign-buA522U$annotations, reason: not valid java name */
    public static /* synthetic */ void m20473getTextAlignbuA522U$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* JADX INFO: renamed from: getTextDirection-mmuk1to$annotations, reason: not valid java name */
    public static /* synthetic */ void m20474getTextDirectionmmuk1to$annotations() {
    }

    private TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j6, TextIndent textIndent) {
        SpanStyle spanStyle = new SpanStyle(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j5, textDecoration, shadow, (PlatformSpanStyle) null, (DrawStyle) null, (DefaultConstructorMarker) null);
        this(spanStyle, new ParagraphStyle(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m20863getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m20876getUnspecifieds_7Xco(), j6, textIndent, (PlatformParagraphStyle) null, (LineHeightStyle) null, LineBreak.INSTANCE.m20790getUnspecifiedrAG3T2k(), Hyphens.INSTANCE.m20769getUnspecifiedvmbZdU8(), (TextMotion) null, (DefaultConstructorMarker) null), null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j6, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long jM18561getUnspecified0d7_KjU = (i & 1) != 0 ? Color.INSTANCE.m18561getUnspecified0d7_KjU() : j;
        long jM21172getUnspecifiedXSAIIZE = (i & 2) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j2;
        FontWeight fontWeight2 = (i & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i & 8) != 0 ? null : fontStyle;
        FontSynthesis fontSynthesis2 = (i & 16) != 0 ? null : fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? null : fontFamily;
        String str2 = (i & 64) != 0 ? null : str;
        long jM21172getUnspecifiedXSAIIZE2 = (i & 128) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j3;
        BaselineShift baselineShift2 = (i & 256) != 0 ? null : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & 512) != 0 ? null : textGeometricTransform;
        LocaleList localeList2 = (i & 1024) != 0 ? null : localeList;
        long jM18561getUnspecified0d7_KjU2 = (i & 2048) != 0 ? Color.INSTANCE.m18561getUnspecified0d7_KjU() : j5;
        TextDecoration textDecoration2 = (i & 4096) != 0 ? null : textDecoration;
        long j7 = jM18561getUnspecified0d7_KjU;
        Shadow shadow2 = (i & 8192) != 0 ? null : shadow;
        TextAlign textAlign2 = (i & 16384) != 0 ? null : textAlign;
        TextDirection textDirection2 = (i & 32768) != 0 ? null : textDirection;
        long jM21172getUnspecifiedXSAIIZE3 = (i & 65536) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j6;
        TextIndent textIndent2 = (i & 131072) != 0 ? null : textIndent;
        PlatformTextStyle platformTextStyle2 = (i & 262144) != 0 ? null : platformTextStyle;
        long j8 = jM21172getUnspecifiedXSAIIZE;
        FontWeight fontWeight3 = fontWeight2;
        TextDecoration textDecoration3 = textDecoration2;
        FontStyle fontStyle3 = fontStyle2;
        FontSynthesis fontSynthesis3 = fontSynthesis2;
        FontFamily fontFamily3 = fontFamily2;
        String str3 = str2;
        long j9 = jM21172getUnspecifiedXSAIIZE2;
        BaselineShift baselineShift3 = baselineShift2;
        TextGeometricTransform textGeometricTransform3 = textGeometricTransform2;
        LocaleList localeList3 = localeList2;
        long j10 = jM18561getUnspecified0d7_KjU2;
        this(j7, j8, fontWeight3, fontStyle3, fontSynthesis3, fontFamily3, str3, j9, baselineShift3, textGeometricTransform3, localeList3, j10, textDecoration3, shadow2, textAlign2, textDirection2, jM21172getUnspecifiedXSAIIZE3, textIndent2, platformTextStyle2, (i & 524288) != 0 ? null : lineHeightStyle, null);
    }

    private TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j6, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle) {
        this(new SpanStyle(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j5, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, (DrawStyle) null, (DefaultConstructorMarker) null), new ParagraphStyle(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m20863getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m20876getUnspecifieds_7Xco(), j6, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, LineBreak.INSTANCE.m20790getUnspecifiedrAG3T2k(), Hyphens.INSTANCE.m20769getUnspecifiedvmbZdU8(), (TextMotion) null, (DefaultConstructorMarker) null), platformTextStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j6, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long jM18561getUnspecified0d7_KjU = (i & 1) != 0 ? Color.INSTANCE.m18561getUnspecified0d7_KjU() : j;
        long jM21172getUnspecifiedXSAIIZE = (i & 2) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j2;
        FontWeight fontWeight2 = (i & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i & 8) != 0 ? null : fontStyle;
        FontSynthesis fontSynthesis2 = (i & 16) != 0 ? null : fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? null : fontFamily;
        String str2 = (i & 64) != 0 ? null : str;
        long jM21172getUnspecifiedXSAIIZE2 = (i & 128) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j3;
        BaselineShift baselineShift2 = (i & 256) != 0 ? null : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & 512) != 0 ? null : textGeometricTransform;
        LocaleList localeList2 = (i & 1024) != 0 ? null : localeList;
        long jM18561getUnspecified0d7_KjU2 = (i & 2048) != 0 ? Color.INSTANCE.m18561getUnspecified0d7_KjU() : j5;
        TextDecoration textDecoration2 = (i & 4096) != 0 ? null : textDecoration;
        long j7 = jM18561getUnspecified0d7_KjU;
        Shadow shadow2 = (i & 8192) != 0 ? null : shadow;
        TextAlign textAlign2 = (i & 16384) != 0 ? null : textAlign;
        TextDirection textDirection2 = (i & 32768) != 0 ? null : textDirection;
        long jM21172getUnspecifiedXSAIIZE3 = (i & 65536) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j6;
        TextIndent textIndent2 = (i & 131072) != 0 ? null : textIndent;
        PlatformTextStyle platformTextStyle2 = (i & 262144) != 0 ? null : platformTextStyle;
        LineHeightStyle lineHeightStyle2 = (i & 524288) != 0 ? null : lineHeightStyle;
        LineBreak lineBreak2 = (i & 1048576) != 0 ? null : lineBreak;
        long j8 = jM21172getUnspecifiedXSAIIZE;
        FontWeight fontWeight3 = fontWeight2;
        TextDecoration textDecoration3 = textDecoration2;
        FontStyle fontStyle3 = fontStyle2;
        FontSynthesis fontSynthesis3 = fontSynthesis2;
        FontFamily fontFamily3 = fontFamily2;
        String str3 = str2;
        long j9 = jM21172getUnspecifiedXSAIIZE2;
        BaselineShift baselineShift3 = baselineShift2;
        TextGeometricTransform textGeometricTransform3 = textGeometricTransform2;
        LocaleList localeList3 = localeList2;
        long j10 = jM18561getUnspecified0d7_KjU2;
        this(j7, j8, fontWeight3, fontStyle3, fontSynthesis3, fontFamily3, str3, j9, baselineShift3, textGeometricTransform3, localeList3, j10, textDecoration3, shadow2, textAlign2, textDirection2, jM21172getUnspecifiedXSAIIZE3, textIndent2, platformTextStyle2, lineHeightStyle2, lineBreak2, (i & 2097152) != 0 ? null : hyphens, null);
    }

    private TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j6, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens) {
        SpanStyle spanStyle = new SpanStyle(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j5, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, (DrawStyle) null, 32768, (DefaultConstructorMarker) null);
        int value = textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m20863getUnspecifiede0LSkKk();
        int value2 = textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m20876getUnspecifieds_7Xco();
        PlatformParagraphStyle paragraphStyle = platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null;
        this(spanStyle, new ParagraphStyle(value, value2, j6, textIndent, paragraphStyle, lineHeightStyle, lineBreak != null ? lineBreak.getMask() : LineBreak.INSTANCE.m20790getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.getValue() : Hyphens.INSTANCE.m20769getUnspecifiedvmbZdU8(), (TextMotion) null, 256, (DefaultConstructorMarker) null), platformTextStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j6, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long jM18561getUnspecified0d7_KjU = (i & 1) != 0 ? Color.INSTANCE.m18561getUnspecified0d7_KjU() : j;
        long jM21172getUnspecifiedXSAIIZE = (i & 2) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j2;
        FontWeight fontWeight2 = (i & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i & 8) != 0 ? null : fontStyle;
        FontSynthesis fontSynthesis2 = (i & 16) != 0 ? null : fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? null : fontFamily;
        String str2 = (i & 64) != 0 ? null : str;
        long jM21172getUnspecifiedXSAIIZE2 = (i & 128) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j3;
        BaselineShift baselineShift2 = (i & 256) != 0 ? null : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & 512) != 0 ? null : textGeometricTransform;
        LocaleList localeList2 = (i & 1024) != 0 ? null : localeList;
        long jM18561getUnspecified0d7_KjU2 = (i & 2048) != 0 ? Color.INSTANCE.m18561getUnspecified0d7_KjU() : j5;
        TextDecoration textDecoration2 = (i & 4096) != 0 ? null : textDecoration;
        long j7 = jM18561getUnspecified0d7_KjU;
        Shadow shadow2 = (i & 8192) != 0 ? null : shadow;
        DrawStyle drawStyle2 = (i & 16384) != 0 ? null : drawStyle;
        TextAlign textAlign2 = (i & 32768) != 0 ? null : textAlign;
        TextDirection textDirection2 = (i & 65536) != 0 ? null : textDirection;
        long jM21172getUnspecifiedXSAIIZE3 = (i & 131072) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j6;
        TextIndent textIndent2 = (i & 262144) != 0 ? null : textIndent;
        PlatformTextStyle platformTextStyle2 = (i & 524288) != 0 ? null : platformTextStyle;
        LineHeightStyle lineHeightStyle2 = (i & 1048576) != 0 ? null : lineHeightStyle;
        LineBreak lineBreak2 = (i & 2097152) != 0 ? null : lineBreak;
        Hyphens hyphens2 = (i & 4194304) != 0 ? null : hyphens;
        long j8 = jM21172getUnspecifiedXSAIIZE;
        FontWeight fontWeight3 = fontWeight2;
        TextDecoration textDecoration3 = textDecoration2;
        FontStyle fontStyle3 = fontStyle2;
        FontSynthesis fontSynthesis3 = fontSynthesis2;
        FontFamily fontFamily3 = fontFamily2;
        String str3 = str2;
        long j9 = jM21172getUnspecifiedXSAIIZE2;
        BaselineShift baselineShift3 = baselineShift2;
        TextGeometricTransform textGeometricTransform3 = textGeometricTransform2;
        LocaleList localeList3 = localeList2;
        long j10 = jM18561getUnspecified0d7_KjU2;
        this(j7, j8, fontWeight3, fontStyle3, fontSynthesis3, fontFamily3, str3, j9, baselineShift3, textGeometricTransform3, localeList3, j10, textDecoration3, shadow2, drawStyle2, textAlign2, textDirection2, jM21172getUnspecifiedXSAIIZE3, textIndent2, platformTextStyle2, lineHeightStyle2, lineBreak2, hyphens2, (i & 8388608) != 0 ? null : textMotion, (DefaultConstructorMarker) null);
    }

    private TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j6, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        this(new SpanStyle(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j5, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m20863getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m20876getUnspecifieds_7Xco(), j6, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak != null ? lineBreak.getMask() : LineBreak.INSTANCE.m20790getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.getValue() : Hyphens.INSTANCE.m20769getUnspecifiedvmbZdU8(), textMotion, (DefaultConstructorMarker) null), platformTextStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j6, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i4, int i5, TextMotion textMotion, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        long jM18561getUnspecified0d7_KjU = (i6 & 1) != 0 ? Color.INSTANCE.m18561getUnspecified0d7_KjU() : j;
        long jM21172getUnspecifiedXSAIIZE = (i6 & 2) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j2;
        FontWeight fontWeight2 = (i6 & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i6 & 8) != 0 ? null : fontStyle;
        FontSynthesis fontSynthesis2 = (i6 & 16) != 0 ? null : fontSynthesis;
        FontFamily fontFamily2 = (i6 & 32) != 0 ? null : fontFamily;
        String str2 = (i6 & 64) != 0 ? null : str;
        long jM21172getUnspecifiedXSAIIZE2 = (i6 & 128) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j3;
        BaselineShift baselineShift2 = (i6 & 256) != 0 ? null : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i6 & 512) != 0 ? null : textGeometricTransform;
        LocaleList localeList2 = (i6 & 1024) != 0 ? null : localeList;
        long jM18561getUnspecified0d7_KjU2 = (i6 & 2048) != 0 ? Color.INSTANCE.m18561getUnspecified0d7_KjU() : j5;
        TextDecoration textDecoration2 = (i6 & 4096) != 0 ? null : textDecoration;
        long j7 = jM18561getUnspecified0d7_KjU;
        Shadow shadow2 = (i6 & 8192) != 0 ? null : shadow;
        DrawStyle drawStyle2 = (i6 & 16384) != 0 ? null : drawStyle;
        int iM20863getUnspecifiede0LSkKk = (i6 & 32768) != 0 ? TextAlign.INSTANCE.m20863getUnspecifiede0LSkKk() : i;
        int iM20876getUnspecifieds_7Xco = (i6 & 65536) != 0 ? TextDirection.INSTANCE.m20876getUnspecifieds_7Xco() : i2;
        long jM21172getUnspecifiedXSAIIZE3 = (i6 & 131072) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j6;
        TextIndent textIndent2 = (i6 & 262144) != 0 ? null : textIndent;
        PlatformTextStyle platformTextStyle2 = (i6 & 524288) != 0 ? null : platformTextStyle;
        LineHeightStyle lineHeightStyle2 = (i6 & 1048576) != 0 ? null : lineHeightStyle;
        int iM20790getUnspecifiedrAG3T2k = (i6 & 2097152) != 0 ? LineBreak.INSTANCE.m20790getUnspecifiedrAG3T2k() : i4;
        int iM20769getUnspecifiedvmbZdU8 = (i6 & 4194304) != 0 ? Hyphens.INSTANCE.m20769getUnspecifiedvmbZdU8() : i5;
        long j8 = jM21172getUnspecifiedXSAIIZE;
        FontWeight fontWeight3 = fontWeight2;
        TextDecoration textDecoration3 = textDecoration2;
        FontStyle fontStyle3 = fontStyle2;
        FontSynthesis fontSynthesis3 = fontSynthesis2;
        FontFamily fontFamily3 = fontFamily2;
        String str3 = str2;
        long j9 = jM21172getUnspecifiedXSAIIZE2;
        BaselineShift baselineShift3 = baselineShift2;
        TextGeometricTransform textGeometricTransform3 = textGeometricTransform2;
        LocaleList localeList3 = localeList2;
        long j10 = jM18561getUnspecified0d7_KjU2;
        this(j7, j8, fontWeight3, fontStyle3, fontSynthesis3, fontFamily3, str3, j9, baselineShift3, textGeometricTransform3, localeList3, j10, textDecoration3, shadow2, drawStyle2, iM20863getUnspecifiede0LSkKk, iM20876getUnspecifieds_7Xco, jM21172getUnspecifiedXSAIIZE3, textIndent2, platformTextStyle2, lineHeightStyle2, iM20790getUnspecifiedrAG3T2k, iM20769getUnspecifiedvmbZdU8, (i6 & 8388608) != 0 ? null : textMotion, (DefaultConstructorMarker) null);
    }

    private TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j6, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i4, int i5, TextMotion textMotion) {
        this(new SpanStyle(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j5, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(i, i2, j6, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, i4, i5, textMotion, (DefaultConstructorMarker) null), platformTextStyle);
    }

    public /* synthetic */ TextStyle(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i4, int i5, TextMotion textMotion, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(brush, (i6 & 2) != 0 ? Float.NaN : f, (i6 & 4) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j, (i6 & 8) != 0 ? null : fontWeight, (i6 & 16) != 0 ? null : fontStyle, (i6 & 32) != 0 ? null : fontSynthesis, (i6 & 64) != 0 ? null : fontFamily, (i6 & 128) != 0 ? null : str, (i6 & 256) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j2, (i6 & 512) != 0 ? null : baselineShift, (i6 & 1024) != 0 ? null : textGeometricTransform, (i6 & 2048) != 0 ? null : localeList, (i6 & 4096) != 0 ? Color.INSTANCE.m18561getUnspecified0d7_KjU() : j3, (i6 & 8192) != 0 ? null : textDecoration, (i6 & 16384) != 0 ? null : shadow, (32768 & i6) != 0 ? null : drawStyle, (65536 & i6) != 0 ? TextAlign.INSTANCE.m20863getUnspecifiede0LSkKk() : i, (131072 & i6) != 0 ? TextDirection.INSTANCE.m20876getUnspecifieds_7Xco() : i2, (262144 & i6) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j5, (524288 & i6) != 0 ? null : textIndent, (1048576 & i6) != 0 ? null : platformTextStyle, (2097152 & i6) != 0 ? null : lineHeightStyle, (4194304 & i6) != 0 ? LineBreak.INSTANCE.m20790getUnspecifiedrAG3T2k() : i4, (8388608 & i6) != 0 ? Hyphens.INSTANCE.m20769getUnspecifiedvmbZdU8() : i5, (i6 & 16777216) != 0 ? null : textMotion, (DefaultConstructorMarker) null);
    }

    private TextStyle(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i4, int i5, TextMotion textMotion) {
        this(new SpanStyle(brush, f, j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(i, i2, j5, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, i4, i5, textMotion, (DefaultConstructorMarker) null), platformTextStyle);
    }

    public /* synthetic */ TextStyle(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(brush, (i & 2) != 0 ? Float.NaN : f, (i & 4) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j, (i & 8) != 0 ? null : fontWeight, (i & 16) != 0 ? null : fontStyle, (i & 32) != 0 ? null : fontSynthesis, (i & 64) != 0 ? null : fontFamily, (i & 128) != 0 ? null : str, (i & 256) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j2, (i & 512) != 0 ? null : baselineShift, (i & 1024) != 0 ? null : textGeometricTransform, (i & 2048) != 0 ? null : localeList, (i & 4096) != 0 ? Color.INSTANCE.m18561getUnspecified0d7_KjU() : j3, (i & 8192) != 0 ? null : textDecoration, (i & 16384) != 0 ? null : shadow, (32768 & i) != 0 ? null : drawStyle, (65536 & i) != 0 ? null : textAlign, (131072 & i) != 0 ? null : textDirection, (262144 & i) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j5, (524288 & i) != 0 ? null : textIndent, (1048576 & i) != 0 ? null : platformTextStyle, (2097152 & i) != 0 ? null : lineHeightStyle, (4194304 & i) != 0 ? null : lineBreak, (8388608 & i) != 0 ? null : hyphens, (i & 16777216) != 0 ? null : textMotion, (DefaultConstructorMarker) null);
    }

    private TextStyle(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        this(new SpanStyle(brush, f, j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m20863getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m20876getUnspecifieds_7Xco(), j5, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak != null ? lineBreak.getMask() : LineBreak.INSTANCE.m20790getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.getValue() : Hyphens.INSTANCE.m20769getUnspecifiedvmbZdU8(), textMotion, (DefaultConstructorMarker) null), platformTextStyle);
    }
}
