package androidx.compose.p109ui.semantics;

import androidx.compose.p109ui.autofill.ContentDataType;
import androidx.compose.p109ui.autofill.ContentType;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.state.ToggleableState;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.text.TextRange;
import androidx.compose.p109ui.text.input.ImeAction;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.smp.SmpConstants;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000ô\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u009d\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009f\u00010\u009e\u0001\"\u0005\b\u0000\u0010\u009f\u00012\u0007\u0010 \u0001\u001a\u00020\u0019H\u0000\u001aD\u0010\u009d\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009f\u00010\u009e\u0001\"\u0005\b\u0000\u0010\u009f\u00012\u0007\u0010 \u0001\u001a\u00020\u00192!\u0010¡\u0001\u001a\u001c\u0012\u0007\u0012\u0005\u0018\u0001H\u009f\u0001\u0012\u0005\u0012\u0003H\u009f\u0001\u0012\u0007\u0012\u0005\u0018\u0001H\u009f\u00010¢\u0001H\u0000\u001a4\u0010£\u0001\u001a\u0011\u0012\f\u0012\n\u0012\u0005\u0012\u0003H\u009f\u00010¤\u00010\u009e\u0001\"\u0010\b\u0000\u0010\u009f\u0001*\t\u0012\u0004\u0012\u0002050¥\u00012\u0007\u0010 \u0001\u001a\u00020\u0019H\u0082\b\u001a\u0017\u0010¦\u0001\u001a\u0003H\u009f\u0001\"\u0005\b\u0000\u0010\u009f\u0001H\u0002¢\u0006\u0003\u0010§\u0001\u001a+\u0010¨\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a+\u0010\u00ad\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a+\u0010®\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a+\u0010¯\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a\f\u0010°\u0001\u001a\u00030©\u0001*\u00020\u0003\u001a\f\u0010±\u0001\u001a\u00030©\u0001*\u00020\u0003\u001a+\u0010²\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a\u0015\u0010³\u0001\u001a\u00030©\u0001*\u00020\u00032\u0007\u0010´\u0001\u001a\u00020\u0019\u001a+\u0010µ\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a,\u0010¶\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0011\u0010«\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0092\u00010¬\u0001\u001a9\u0010·\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u001e\u0010«\u0001\u001a\u0019\u0012\f\u0012\n\u0012\u0005\u0012\u00030º\u00010¹\u0001\u0012\u0004\u0012\u000205\u0018\u00010¸\u0001\u001a\f\u0010»\u0001\u001a\u00030©\u0001*\u00020\u0003\u001a#\u0010¼\u0001\u001a\u00030©\u0001*\u00020\u00032\u0015\u0010½\u0001\u001a\u0010\u0012\u0005\u0012\u00030¾\u0001\u0012\u0004\u0012\u00020\\0¸\u0001\u001a1\u0010¿\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0016\u0010«\u0001\u001a\u0011\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u000205\u0018\u00010¸\u0001\u001a\f\u0010À\u0001\u001a\u00030©\u0001*\u00020\u0003\u001a3\u0010Á\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0016\u0010«\u0001\u001a\u0011\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u000205\u0018\u00010¸\u0001H\u0000\u001a+\u0010Â\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a@\u0010Ã\u0001\u001a\u00030©\u0001*\u00020\u00032\u0007\u0010Ä\u0001\u001a\u00020C2\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001ø\u0001\u0000¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001\u001a+\u0010Ç\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a+\u0010È\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a+\u0010É\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a+\u0010Ê\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a+\u0010Ë\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a\f\u0010Ì\u0001\u001a\u00030©\u0001*\u00020\u0003\u001a+\u0010Í\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a-\u0010Î\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001H\u0007\u001a\f\u0010Ï\u0001\u001a\u00030©\u0001*\u00020\u0003\u001a+\u0010Ð\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a]\u0010Ñ\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192B\u0010«\u0001\u001a=\u0012\u0017\u0012\u00150\u0092\u0001¢\u0006\u000f\bÒ\u0001\u0012\n\b \u0001\u0012\u0005\b\b(Ó\u0001\u0012\u0017\u0012\u00150\u0092\u0001¢\u0006\u000f\bÒ\u0001\u0012\n\b \u0001\u0012\u0005\b\b(Ô\u0001\u0012\u0004\u0012\u000205\u0018\u00010¢\u0001\u001aN\u0010Õ\u0001\u001a\u00030©\u0001*\u00020\u00032:\u0010«\u0001\u001a5\b\u0001\u0012\u0017\u0012\u00150Ö\u0001¢\u0006\u000f\bÒ\u0001\u0012\n\b \u0001\u0012\u0005\b\b(×\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030Ö\u00010Ø\u0001\u0012\u0007\u0012\u0005\u0018\u00010¾\u00010¢\u0001¢\u0006\u0003\u0010Ù\u0001\u001a/\u0010Ú\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0014\u0010«\u0001\u001a\u000f\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u0002050¸\u0001\u001a\f\u0010Û\u0001\u001a\u00030©\u0001*\u00020\u0003\u001a2\u0010Ü\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0017\u0010«\u0001\u001a\u0012\u0012\u0005\u0012\u00030\u0092\u0001\u0012\u0004\u0012\u000205\u0018\u00010¸\u0001\u001as\u0010Ý\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192X\u0010«\u0001\u001aS\u0012\u0016\u0012\u00140\\¢\u0006\u000f\bÒ\u0001\u0012\n\b \u0001\u0012\u0005\b\b(ß\u0001\u0012\u0016\u0012\u00140\\¢\u0006\u000f\bÒ\u0001\u0012\n\b \u0001\u0012\u0005\b\b(à\u0001\u0012\u0016\u0012\u001405¢\u0006\u000f\bÒ\u0001\u0012\n\b \u0001\u0012\u0005\b\b(á\u0001\u0012\u0004\u0012\u000205\u0018\u00010Þ\u0001\u001a0\u0010\u007f\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0016\u0010«\u0001\u001a\u0011\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u000205\u0018\u00010¸\u0001\u001a1\u0010\u008a\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0016\u0010«\u0001\u001a\u0011\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u000205\u0018\u00010¸\u0001\u001a1\u0010â\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0016\u0010«\u0001\u001a\u0011\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000205\u0018\u00010¸\u0001\"/\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t*\u0004\b\u0004\u0010\u0005\"/\u0010\u000b\u001a\u00020\n*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010*\u0004\b\f\u0010\u0005\"/\u0010\u0012\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00118@@@X\u0080\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017*\u0004\b\u0013\u0010\u0005\"(\u0010\u001a\u001a\u00020\u0019*\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\"/\u0010 \u001a\u00020\u001f*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u001f8@@@X\u0080\u008e\u0002¢\u0006\u0012\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%*\u0004\b!\u0010\u0005\";\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&*\u00020\u00032\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020'0&8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-*\u0004\b)\u0010\u0005\"/\u0010/\u001a\u00020.*\u00020\u00032\u0006\u0010\u0000\u001a\u00020.8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b1\u00102\"\u0004\b3\u00104*\u0004\b0\u0010\u0005\"/\u00106\u001a\u000205*\u00020\u00032\u0006\u0010\u0000\u001a\u0002058F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b8\u00109\"\u0004\b:\u0010;*\u0004\b7\u0010\u0005\"/\u0010=\u001a\u00020<*\u00020\u00032\u0006\u0010\u0000\u001a\u00020<8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B*\u0004\b>\u0010\u0005\"5\u0010D\u001a\u00020C*\u00020\u00032\u0006\u0010\u0000\u001a\u00020C8G@GX\u0087\u008e\u0002¢\u0006\u0018\u0012\u0004\bE\u0010F\u001a\u0004\bH\u0010\u0015\"\u0004\bI\u0010\u0017*\u0004\bG\u0010\u0005\"5\u0010J\u001a\u000205*\u00020\u00032\u0006\u0010\u0000\u001a\u0002058F@FX\u0087\u008e\u0002¢\u0006\u0018\u0012\u0004\bK\u0010F\u001a\u0004\bJ\u00109\"\u0004\bM\u0010;*\u0004\bL\u0010\u0005\"/\u0010N\u001a\u000205*\u00020\u00032\u0006\u0010\u0000\u001a\u0002058F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bN\u00109\"\u0004\bP\u0010;*\u0004\bO\u0010\u0005\"/\u0010Q\u001a\u000205*\u00020\u00032\u0006\u0010\u0000\u001a\u0002058F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bQ\u00109\"\u0004\bS\u0010;*\u0004\bR\u0010\u0005\"/\u0010T\u001a\u000205*\u00020\u00032\u0006\u0010\u0000\u001a\u0002058F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bT\u00109\"\u0004\bV\u0010;*\u0004\bU\u0010\u0005\"/\u0010X\u001a\u00020W*\u00020\u00032\u0006\u0010\u0000\u001a\u00020W8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bZ\u0010\u0015\"\u0004\b[\u0010\u0017*\u0004\bY\u0010\u0005\"/\u0010]\u001a\u00020\\*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\\8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b_\u0010\u0015\"\u0004\b`\u0010\u0017*\u0004\b^\u0010\u0005\"/\u0010a\u001a\u00020\u0019*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00198F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bc\u0010\u001c\"\u0004\bd\u0010\u001e*\u0004\bb\u0010\u0005\"/\u0010f\u001a\u00020e*\u00020\u00032\u0006\u0010\u0000\u001a\u00020e8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bh\u0010i\"\u0004\bj\u0010k*\u0004\bg\u0010\u0005\"/\u0010m\u001a\u00020l*\u00020\u00032\u0006\u0010\u0000\u001a\u00020l8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bo\u0010\u0015\"\u0004\bp\u0010\u0017*\u0004\bn\u0010\u0005\"/\u0010q\u001a\u000205*\u00020\u00032\u0006\u0010\u0000\u001a\u0002058F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bs\u00109\"\u0004\bt\u0010;*\u0004\br\u0010\u0005\"/\u0010u\u001a\u00020\u0019*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00198F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bw\u0010\u001c\"\u0004\bx\u0010\u001e*\u0004\bv\u0010\u0005\"/\u0010y\u001a\u00020\u0019*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00198F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b{\u0010\u001c\"\u0004\b|\u0010\u001e*\u0004\bz\u0010\u0005\"(\u0010}\u001a\u00020.*\u00020\u00032\u0006\u0010\u0018\u001a\u00020.8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b~\u00102\"\u0004\b\u007f\u00104\"7\u0010\u0081\u0001\u001a\u00030\u0080\u0001*\u00020\u00032\u0007\u0010\u0000\u001a\u00030\u0080\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001*\u0005\b\u0082\u0001\u0010\u0005\"3\u0010\u0087\u0001\u001a\u00020.*\u00020\u00032\u0006\u0010\u0000\u001a\u00020.8F@FX\u0086\u008e\u0002¢\u0006\u0015\u001a\u0005\b\u0089\u0001\u00102\"\u0005\b\u008a\u0001\u00104*\u0005\b\u0088\u0001\u0010\u0005\"7\u0010\u008c\u0001\u001a\u00030\u008b\u0001*\u00020\u00032\u0007\u0010\u0000\u001a\u00030\u008b\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001*\u0005\b\u008d\u0001\u0010\u0005\"7\u0010\u0093\u0001\u001a\u00030\u0092\u0001*\u00020\u00032\u0007\u0010\u0000\u001a\u00030\u0092\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001*\u0005\b\u0094\u0001\u0010\u0005\"3\u0010\u0099\u0001\u001a\u00020<*\u00020\u00032\u0006\u0010\u0000\u001a\u00020<8F@FX\u0086\u008e\u0002¢\u0006\u0015\u001a\u0005\b\u009b\u0001\u0010@\"\u0005\b\u009c\u0001\u0010B*\u0005\b\u009a\u0001\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006ã\u0001"}, m13886d2 = {"<set-?>", "Landroidx/compose/ui/semantics/CollectionInfo;", "collectionInfo", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "getCollectionInfo$delegate", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/Object;", "getCollectionInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", "setCollectionInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/CollectionInfo;)V", "Landroidx/compose/ui/semantics/CollectionItemInfo;", "collectionItemInfo", "getCollectionItemInfo$delegate", "getCollectionItemInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionItemInfo;", "setCollectionItemInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/CollectionItemInfo;)V", "Landroidx/compose/ui/autofill/ContentDataType;", "contentDataType", "getContentDataType$delegate", "getContentDataType", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", "setContentDataType-NTL_tik", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;I)V", "value", "", "contentDescription", "getContentDescription", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", "setContentDescription", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/lang/String;)V", "Landroidx/compose/ui/autofill/ContentType;", "contentType", "getContentType$delegate", "getContentType", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentType;", "setContentType", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/autofill/ContentType;)V", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "customActions", "getCustomActions$delegate", "getCustomActions", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/util/List;", "setCustomActions", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/util/List;)V", "Landroidx/compose/ui/text/AnnotatedString;", "editableText", "getEditableText$delegate", "getEditableText", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", "setEditableText", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/text/AnnotatedString;)V", "", "focused", "getFocused$delegate", "getFocused", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", "setFocused", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Z)V", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "horizontalScrollAxisRange", "getHorizontalScrollAxisRange$delegate", "getHorizontalScrollAxisRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", "setHorizontalScrollAxisRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/ScrollAxisRange;)V", "Landroidx/compose/ui/text/input/ImeAction;", "imeAction", "getImeAction$annotations", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "getImeAction$delegate", "getImeAction", "setImeAction-4L7nppU", "isContainer", "isContainer$annotations", "isContainer$delegate", "setContainer", "isEditable", "isEditable$delegate", "setEditable", "isShowingTextSubstitution", "isShowingTextSubstitution$delegate", "setShowingTextSubstitution", "isTraversalGroup", "isTraversalGroup$delegate", "setTraversalGroup", "Landroidx/compose/ui/semantics/LiveRegionMode;", "liveRegion", "getLiveRegion$delegate", "getLiveRegion", "setLiveRegion-hR3wRGc", "", "maxTextLength", "getMaxTextLength$delegate", "getMaxTextLength", "setMaxTextLength", "paneTitle", "getPaneTitle$delegate", "getPaneTitle", "setPaneTitle", "Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "progressBarRangeInfo", "getProgressBarRangeInfo$delegate", "getProgressBarRangeInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "setProgressBarRangeInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/ProgressBarRangeInfo;)V", "Landroidx/compose/ui/semantics/Role;", "role", "getRole$delegate", "getRole", "setRole-kuIjeqM", "selected", "getSelected$delegate", "getSelected", "setSelected", "stateDescription", "getStateDescription$delegate", "getStateDescription", "setStateDescription", "testTag", "getTestTag$delegate", "getTestTag", "setTestTag", "text", "getText", "setText", "Landroidx/compose/ui/text/TextRange;", "textSelectionRange", "getTextSelectionRange$delegate", "getTextSelectionRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", "setTextSelectionRange-FDrldGo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;J)V", "textSubstitution", "getTextSubstitution$delegate", "getTextSubstitution", "setTextSubstitution", "Landroidx/compose/ui/state/ToggleableState;", "toggleableState", "getToggleableState$delegate", "getToggleableState", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/state/ToggleableState;", "setToggleableState", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/state/ToggleableState;)V", "", "traversalIndex", "getTraversalIndex$delegate", "getTraversalIndex", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)F", "setTraversalIndex", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;F)V", "verticalScrollAxisRange", "getVerticalScrollAxisRange$delegate", "getVerticalScrollAxisRange", "setVerticalScrollAxisRange", "AccessibilityKey", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "T", "name", "mergePolicy", "Lkotlin/Function2;", "ActionPropertyKey", "Landroidx/compose/ui/semantics/AccessibilityAction;", "Lkotlin/Function;", "throwSemanticsGetNotSupported", "()Ljava/lang/Object;", "clearTextSubstitution", "", "label", "action", "Lkotlin/Function0;", "collapse", "copyText", "cutText", "dialog", "disabled", "dismiss", "error", "description", "expand", "getScrollViewportLength", "getTextLayoutResult", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/TextLayoutResult;", "heading", "indexForKey", "mapping", "", "insertTextAtCursor", "invisibleToUser", "onAutofillText", "onClick", "onImeAction", "imeActionType", "onImeAction-9UiTYpY", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;ILjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "onLongClick", "pageDown", "pageLeft", "pageRight", "pageUp", "password", "pasteText", "performImeAction", SmpConstants.MARKETING_TYPE_POPUP, "requestFocus", "scrollBy", "Lkotlin/ParameterName;", "x", "y", "scrollByOffset", "Landroidx/compose/ui/geometry/Offset;", TypedValues.Cycle.S_WAVE_OFFSET, "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Lkotlin/jvm/functions/Function2;)V", "scrollToIndex", "selectableGroup", "setProgress", "setSelection", "Lkotlin/Function3;", TextConst.KEY_START_INDEX, TextConst.KEY_END_INDEX, "relativeToOriginalText", "showTextSubstitution", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SemanticsPropertiesKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "stateDescription", "getStateDescription(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "progressBarRangeInfo", "getProgressBarRangeInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "paneTitle", "getPaneTitle(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "liveRegion", "getLiveRegion(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "focused", "getFocused(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "isContainer", "isContainer(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "isTraversalGroup", "isTraversalGroup(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "contentType", "getContentType(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentType;", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "contentDataType", "getContentDataType(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "traversalIndex", "getTraversalIndex(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)F", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "horizontalScrollAxisRange", "getHorizontalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "verticalScrollAxisRange", "getVerticalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "role", "getRole(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "testTag", "getTestTag(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "textSubstitution", "getTextSubstitution(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "isShowingTextSubstitution", "isShowingTextSubstitution(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "editableText", "getEditableText(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "textSelectionRange", "getTextSelectionRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "imeAction", "getImeAction(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "selected", "getSelected(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "collectionInfo", "getCollectionInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "collectionItemInfo", "getCollectionItemInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionItemInfo;", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "toggleableState", "getToggleableState(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/state/ToggleableState;", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "isEditable", "isEditable(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "maxTextLength", "getMaxTextLength(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1), AbstractC1974b.m1328u(SemanticsPropertiesKt.class, "customActions", "getCustomActions(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/util/List;", 1)};

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.ui.semantics.SemanticsPropertiesKt$ActionPropertyKey$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\n¢\u0006\u0002\b\u0007"}, m13886d2 = {"<anonymous>", "Landroidx/compose/ui/semantics/AccessibilityAction;", "T", "Lkotlin/Function;", "", "parentValue", "childValue", "invoke"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSemanticsProperties.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SemanticsProperties.kt\nandroidx/compose/ui/semantics/SemanticsPropertiesKt$ActionPropertyKey$1\n*L\n1#1,1614:1\n*E\n"})
    public static final class C22251<T> extends Lambda implements Function2<AccessibilityAction<T>, AccessibilityAction<T>, AccessibilityAction<T>> {
        public static final C22251 INSTANCE = new C22251();

        public C22251() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final AccessibilityAction<T> invoke(@Nullable AccessibilityAction<T> accessibilityAction, @NotNull AccessibilityAction<T> accessibilityAction2) {
            String label;
            Function action;
            if (accessibilityAction == null || (label = accessibilityAction.getLabel()) == null) {
                label = accessibilityAction2.getLabel();
            }
            if (accessibilityAction == null || (action = accessibilityAction.getAction()) == null) {
                action = accessibilityAction2.getAction();
            }
            return new AccessibilityAction<>(label, action);
        }
    }

    static {
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        semanticsProperties.getStateDescription();
        semanticsProperties.getProgressBarRangeInfo();
        semanticsProperties.getPaneTitle();
        semanticsProperties.getLiveRegion();
        semanticsProperties.getFocused();
        semanticsProperties.getIsTraversalGroup();
        semanticsProperties.getIsTraversalGroup();
        semanticsProperties.getContentType$ui_release();
        semanticsProperties.getContentDataType$ui_release();
        semanticsProperties.getTraversalIndex();
        semanticsProperties.getHorizontalScrollAxisRange();
        semanticsProperties.getVerticalScrollAxisRange();
        semanticsProperties.getRole();
        semanticsProperties.getTestTag();
        semanticsProperties.getTextSubstitution();
        semanticsProperties.getIsShowingTextSubstitution();
        semanticsProperties.getEditableText();
        semanticsProperties.getTextSelectionRange();
        semanticsProperties.getImeAction();
        semanticsProperties.getSelected();
        semanticsProperties.getCollectionInfo();
        semanticsProperties.getCollectionItemInfo();
        semanticsProperties.getToggleableState();
        semanticsProperties.getIsEditable();
        semanticsProperties.getMaxTextLength();
        SemanticsActions.INSTANCE.getCustomActions();
    }

    @NotNull
    public static final <T> SemanticsPropertyKey<T> AccessibilityKey(@NotNull String str) {
        return new SemanticsPropertyKey<>(str, true);
    }

    private static final <T extends Function<? extends Boolean>> SemanticsPropertyKey<AccessibilityAction<T>> ActionPropertyKey(String str) {
        return AccessibilityKey(str, C22251.INSTANCE);
    }

    public static final void clearTextSubstitution(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getClearTextSubstitution(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void clearTextSubstitution$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        clearTextSubstitution(semanticsPropertyReceiver, str, function0);
    }

    public static final void collapse(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getCollapse(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void collapse$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        collapse(semanticsPropertyReceiver, str, function0);
    }

    public static final void copyText(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getCopyText(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void copyText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        copyText(semanticsPropertyReceiver, str, function0);
    }

    public static final void cutText(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getCutText(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void cutText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        cutText(semanticsPropertyReceiver, str, function0);
    }

    public static final void dialog(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getIsDialog(), Unit.INSTANCE);
    }

    public static final void disabled(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getDisabled(), Unit.INSTANCE);
    }

    public static final void dismiss(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getDismiss(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void dismiss$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        dismiss(semanticsPropertyReceiver, str, function0);
    }

    public static final void error(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull String str) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getError(), str);
    }

    public static final void expand(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getExpand(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void expand$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        expand(semanticsPropertyReceiver, str, function0);
    }

    @NotNull
    public static final CollectionInfo getCollectionInfo(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getCollectionInfo().getValue(semanticsPropertyReceiver, $$delegatedProperties[20]);
    }

    @NotNull
    public static final CollectionItemInfo getCollectionItemInfo(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getCollectionItemInfo().getValue(semanticsPropertyReceiver, $$delegatedProperties[21]);
    }

    public static final int getContentDataType(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getContentDataType$ui_release().getValue(semanticsPropertyReceiver, $$delegatedProperties[8]).m18148unboximpl();
    }

    @NotNull
    public static final String getContentDescription(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return (String) throwSemanticsGetNotSupported();
    }

    @NotNull
    public static final ContentType getContentType(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getContentType$ui_release().getValue(semanticsPropertyReceiver, $$delegatedProperties[7]);
    }

    @NotNull
    public static final List<CustomAccessibilityAction> getCustomActions(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsActions.INSTANCE.getCustomActions().getValue(semanticsPropertyReceiver, $$delegatedProperties[25]);
    }

    @NotNull
    public static final AnnotatedString getEditableText(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getEditableText().getValue(semanticsPropertyReceiver, $$delegatedProperties[16]);
    }

    public static final boolean getFocused(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getFocused().getValue(semanticsPropertyReceiver, $$delegatedProperties[4]).booleanValue();
    }

    @NotNull
    public static final ScrollAxisRange getHorizontalScrollAxisRange(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange().getValue(semanticsPropertyReceiver, $$delegatedProperties[10]);
    }

    @Deprecated(message = "Pass the ImeAction to onImeAction instead.")
    public static final int getImeAction(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getImeAction().getValue(semanticsPropertyReceiver, $$delegatedProperties[18]).getValue();
    }

    public static final int getLiveRegion(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getLiveRegion().getValue(semanticsPropertyReceiver, $$delegatedProperties[3]).getValue();
    }

    public static final int getMaxTextLength(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getMaxTextLength().getValue(semanticsPropertyReceiver, $$delegatedProperties[24]).intValue();
    }

    @NotNull
    public static final String getPaneTitle(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getPaneTitle().getValue(semanticsPropertyReceiver, $$delegatedProperties[2]);
    }

    @NotNull
    public static final ProgressBarRangeInfo getProgressBarRangeInfo(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getProgressBarRangeInfo().getValue(semanticsPropertyReceiver, $$delegatedProperties[1]);
    }

    public static final int getRole(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getRole().getValue(semanticsPropertyReceiver, $$delegatedProperties[12]).getValue();
    }

    public static final void getScrollViewportLength(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @NotNull final Function0<Float> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getGetScrollViewportLength(), new AccessibilityAction(str, new Function1<List<Float>, Boolean>() { // from class: androidx.compose.ui.semantics.SemanticsPropertiesKt.getScrollViewportLength.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull List<Float> list) {
                boolean z;
                Float fInvoke = function0.invoke();
                if (fInvoke == null) {
                    z = false;
                } else {
                    list.add(fInvoke);
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        }));
    }

    public static /* synthetic */ void getScrollViewportLength$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        getScrollViewportLength(semanticsPropertyReceiver, str, function0);
    }

    public static final boolean getSelected(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getSelected().getValue(semanticsPropertyReceiver, $$delegatedProperties[19]).booleanValue();
    }

    @NotNull
    public static final String getStateDescription(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getStateDescription().getValue(semanticsPropertyReceiver, $$delegatedProperties[0]);
    }

    @NotNull
    public static final String getTestTag(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getTestTag().getValue(semanticsPropertyReceiver, $$delegatedProperties[13]);
    }

    @NotNull
    public static final AnnotatedString getText(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return (AnnotatedString) throwSemanticsGetNotSupported();
    }

    public static final void getTextLayoutResult(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function1<? super List<TextLayoutResult>, Boolean> function1) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getGetTextLayoutResult(), new AccessibilityAction(str, function1));
    }

    public static /* synthetic */ void getTextLayoutResult$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        getTextLayoutResult(semanticsPropertyReceiver, str, function1);
    }

    public static final long getTextSelectionRange(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getTextSelectionRange().getValue(semanticsPropertyReceiver, $$delegatedProperties[17]).getPackedValue();
    }

    @NotNull
    public static final AnnotatedString getTextSubstitution(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getTextSubstitution().getValue(semanticsPropertyReceiver, $$delegatedProperties[14]);
    }

    @NotNull
    public static final ToggleableState getToggleableState(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getToggleableState().getValue(semanticsPropertyReceiver, $$delegatedProperties[22]);
    }

    public static final float getTraversalIndex(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getTraversalIndex().getValue(semanticsPropertyReceiver, $$delegatedProperties[9]).floatValue();
    }

    @NotNull
    public static final ScrollAxisRange getVerticalScrollAxisRange(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getVerticalScrollAxisRange().getValue(semanticsPropertyReceiver, $$delegatedProperties[11]);
    }

    public static final void heading(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getHeading(), Unit.INSTANCE);
    }

    public static final void indexForKey(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull Function1<Object, Integer> function1) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getIndexForKey(), function1);
    }

    public static final void insertTextAtCursor(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function1<? super AnnotatedString, Boolean> function1) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getInsertTextAtCursor(), new AccessibilityAction(str, function1));
    }

    public static /* synthetic */ void insertTextAtCursor$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        insertTextAtCursor(semanticsPropertyReceiver, str, function1);
    }

    public static final void invisibleToUser(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getInvisibleToUser(), Unit.INSTANCE);
    }

    public static final boolean isContainer(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getIsTraversalGroup().getValue(semanticsPropertyReceiver, $$delegatedProperties[5]).booleanValue();
    }

    public static final boolean isEditable(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getIsEditable().getValue(semanticsPropertyReceiver, $$delegatedProperties[23]).booleanValue();
    }

    public static final boolean isShowingTextSubstitution(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getIsShowingTextSubstitution().getValue(semanticsPropertyReceiver, $$delegatedProperties[15]).booleanValue();
    }

    public static final boolean isTraversalGroup(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getIsTraversalGroup().getValue(semanticsPropertyReceiver, $$delegatedProperties[6]).booleanValue();
    }

    public static final void onAutofillText(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function1<? super AnnotatedString, Boolean> function1) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getOnAutofillText$ui_release(), new AccessibilityAction(str, function1));
    }

    public static /* synthetic */ void onAutofillText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        onAutofillText(semanticsPropertyReceiver, str, function1);
    }

    public static final void onClick(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getOnClick(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void onClick$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        onClick(semanticsPropertyReceiver, str, function0);
    }

    /* JADX INFO: renamed from: onImeAction-9UiTYpY, reason: not valid java name */
    public static final void m20280onImeAction9UiTYpY(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, int i, @Nullable String str, @Nullable Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getImeAction(), ImeAction.m20617boximpl(i));
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getOnImeAction(), new AccessibilityAction(str, function0));
    }

    /* JADX INFO: renamed from: onImeAction-9UiTYpY$default, reason: not valid java name */
    public static /* synthetic */ void m20281onImeAction9UiTYpY$default(SemanticsPropertyReceiver semanticsPropertyReceiver, int i, String str, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        m20280onImeAction9UiTYpY(semanticsPropertyReceiver, i, str, function0);
    }

    public static final void onLongClick(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getOnLongClick(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void onLongClick$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        onLongClick(semanticsPropertyReceiver, str, function0);
    }

    public static final void pageDown(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getPageDown(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void pageDown$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        pageDown(semanticsPropertyReceiver, str, function0);
    }

    public static final void pageLeft(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getPageLeft(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void pageLeft$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        pageLeft(semanticsPropertyReceiver, str, function0);
    }

    public static final void pageRight(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getPageRight(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void pageRight$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        pageRight(semanticsPropertyReceiver, str, function0);
    }

    public static final void pageUp(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getPageUp(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void pageUp$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        pageUp(semanticsPropertyReceiver, str, function0);
    }

    public static final void password(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getPassword(), Unit.INSTANCE);
    }

    public static final void pasteText(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getPasteText(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void pasteText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        pasteText(semanticsPropertyReceiver, str, function0);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `SemanticsPropertyReceiver.onImeAction` instead.", replaceWith = @ReplaceWith(expression = "onImeAction(imeActionType = ImeAction.Default, label = label, action = action)", imports = {"androidx.compose.ui.semantics.onImeAction", "androidx.compose.ui.text.input.ImeAction"}))
    public static final void performImeAction(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getOnImeAction(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void performImeAction$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        performImeAction(semanticsPropertyReceiver, str, function0);
    }

    public static final void popup(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getIsPopup(), Unit.INSTANCE);
    }

    public static final void requestFocus(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getRequestFocus(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void requestFocus$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        requestFocus(semanticsPropertyReceiver, str, function0);
    }

    public static final void scrollBy(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function2<? super Float, ? super Float, Boolean> function2) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getScrollBy(), new AccessibilityAction(str, function2));
    }

    public static /* synthetic */ void scrollBy$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        scrollBy(semanticsPropertyReceiver, str, function2);
    }

    public static final void scrollByOffset(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull Function2<? super Offset, ? super Continuation<? super Offset>, ? extends Object> function2) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getScrollByOffset(), function2);
    }

    public static final void scrollToIndex(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @NotNull Function1<? super Integer, Boolean> function1) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getScrollToIndex(), new AccessibilityAction(str, function1));
    }

    public static /* synthetic */ void scrollToIndex$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        scrollToIndex(semanticsPropertyReceiver, str, function1);
    }

    public static final void selectableGroup(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getSelectableGroup(), Unit.INSTANCE);
    }

    public static final void setCollectionInfo(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull CollectionInfo collectionInfo) {
        SemanticsProperties.INSTANCE.getCollectionInfo().setValue(semanticsPropertyReceiver, $$delegatedProperties[20], collectionInfo);
    }

    public static final void setCollectionItemInfo(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull CollectionItemInfo collectionItemInfo) {
        SemanticsProperties.INSTANCE.getCollectionItemInfo().setValue(semanticsPropertyReceiver, $$delegatedProperties[21], collectionItemInfo);
    }

    public static final void setContainer(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z) {
        SemanticsProperties.INSTANCE.getIsTraversalGroup().setValue(semanticsPropertyReceiver, $$delegatedProperties[5], Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: setContentDataType-NTL_tik, reason: not valid java name */
    public static final void m20282setContentDataTypeNTL_tik(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, int i) {
        SemanticsProperties.INSTANCE.getContentDataType$ui_release().setValue(semanticsPropertyReceiver, $$delegatedProperties[8], ContentDataType.m18142boximpl(i));
    }

    public static final void setContentDescription(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull String str) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getContentDescription(), CollectionsKt.listOf(str));
    }

    public static final void setContentType(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull ContentType contentType) {
        SemanticsProperties.INSTANCE.getContentType$ui_release().setValue(semanticsPropertyReceiver, $$delegatedProperties[7], contentType);
    }

    public static final void setCustomActions(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull List<CustomAccessibilityAction> list) {
        SemanticsActions.INSTANCE.getCustomActions().setValue(semanticsPropertyReceiver, $$delegatedProperties[25], list);
    }

    public static final void setEditable(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z) {
        SemanticsProperties.INSTANCE.getIsEditable().setValue(semanticsPropertyReceiver, $$delegatedProperties[23], Boolean.valueOf(z));
    }

    public static final void setEditableText(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull AnnotatedString annotatedString) {
        SemanticsProperties.INSTANCE.getEditableText().setValue(semanticsPropertyReceiver, $$delegatedProperties[16], annotatedString);
    }

    public static final void setFocused(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z) {
        SemanticsProperties.INSTANCE.getFocused().setValue(semanticsPropertyReceiver, $$delegatedProperties[4], Boolean.valueOf(z));
    }

    public static final void setHorizontalScrollAxisRange(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull ScrollAxisRange scrollAxisRange) {
        SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange().setValue(semanticsPropertyReceiver, $$delegatedProperties[10], scrollAxisRange);
    }

    @Deprecated(message = "Pass the ImeAction to onImeAction instead.")
    /* JADX INFO: renamed from: setImeAction-4L7nppU, reason: not valid java name */
    public static final void m20283setImeAction4L7nppU(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, int i) {
        SemanticsProperties.INSTANCE.getImeAction().setValue(semanticsPropertyReceiver, $$delegatedProperties[18], ImeAction.m20617boximpl(i));
    }

    /* JADX INFO: renamed from: setLiveRegion-hR3wRGc, reason: not valid java name */
    public static final void m20284setLiveRegionhR3wRGc(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, int i) {
        SemanticsProperties.INSTANCE.getLiveRegion().setValue(semanticsPropertyReceiver, $$delegatedProperties[3], LiveRegionMode.m20250boximpl(i));
    }

    public static final void setMaxTextLength(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, int i) {
        SemanticsProperties.INSTANCE.getMaxTextLength().setValue(semanticsPropertyReceiver, $$delegatedProperties[24], Integer.valueOf(i));
    }

    public static final void setPaneTitle(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull String str) {
        SemanticsProperties.INSTANCE.getPaneTitle().setValue(semanticsPropertyReceiver, $$delegatedProperties[2], str);
    }

    public static final void setProgress(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function1<? super Float, Boolean> function1) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getSetProgress(), new AccessibilityAction(str, function1));
    }

    public static /* synthetic */ void setProgress$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        setProgress(semanticsPropertyReceiver, str, function1);
    }

    public static final void setProgressBarRangeInfo(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull ProgressBarRangeInfo progressBarRangeInfo) {
        SemanticsProperties.INSTANCE.getProgressBarRangeInfo().setValue(semanticsPropertyReceiver, $$delegatedProperties[1], progressBarRangeInfo);
    }

    /* JADX INFO: renamed from: setRole-kuIjeqM, reason: not valid java name */
    public static final void m20285setRolekuIjeqM(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, int i) {
        SemanticsProperties.INSTANCE.getRole().setValue(semanticsPropertyReceiver, $$delegatedProperties[12], Role.m20259boximpl(i));
    }

    public static final void setSelected(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z) {
        SemanticsProperties.INSTANCE.getSelected().setValue(semanticsPropertyReceiver, $$delegatedProperties[19], Boolean.valueOf(z));
    }

    public static final void setSelection(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function3<? super Integer, ? super Integer, ? super Boolean, Boolean> function3) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getSetSelection(), new AccessibilityAction(str, function3));
    }

    public static /* synthetic */ void setSelection$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        setSelection(semanticsPropertyReceiver, str, function3);
    }

    public static final void setShowingTextSubstitution(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z) {
        SemanticsProperties.INSTANCE.getIsShowingTextSubstitution().setValue(semanticsPropertyReceiver, $$delegatedProperties[15], Boolean.valueOf(z));
    }

    public static final void setStateDescription(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull String str) {
        SemanticsProperties.INSTANCE.getStateDescription().setValue(semanticsPropertyReceiver, $$delegatedProperties[0], str);
    }

    public static final void setTestTag(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull String str) {
        SemanticsProperties.INSTANCE.getTestTag().setValue(semanticsPropertyReceiver, $$delegatedProperties[13], str);
    }

    public static final void setText(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull AnnotatedString annotatedString) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getText(), CollectionsKt.listOf(annotatedString));
    }

    public static /* synthetic */ void setText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        setText(semanticsPropertyReceiver, str, function1);
    }

    /* JADX INFO: renamed from: setTextSelectionRange-FDrldGo, reason: not valid java name */
    public static final void m20286setTextSelectionRangeFDrldGo(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, long j) {
        SemanticsProperties.INSTANCE.getTextSelectionRange().setValue(semanticsPropertyReceiver, $$delegatedProperties[17], TextRange.m20444boximpl(j));
    }

    public static final void setTextSubstitution(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull AnnotatedString annotatedString) {
        SemanticsProperties.INSTANCE.getTextSubstitution().setValue(semanticsPropertyReceiver, $$delegatedProperties[14], annotatedString);
    }

    public static /* synthetic */ void setTextSubstitution$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        setTextSubstitution(semanticsPropertyReceiver, str, function1);
    }

    public static final void setToggleableState(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull ToggleableState toggleableState) {
        SemanticsProperties.INSTANCE.getToggleableState().setValue(semanticsPropertyReceiver, $$delegatedProperties[22], toggleableState);
    }

    public static final void setTraversalGroup(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z) {
        SemanticsProperties.INSTANCE.getIsTraversalGroup().setValue(semanticsPropertyReceiver, $$delegatedProperties[6], Boolean.valueOf(z));
    }

    public static final void setTraversalIndex(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, float f) {
        SemanticsProperties.INSTANCE.getTraversalIndex().setValue(semanticsPropertyReceiver, $$delegatedProperties[9], Float.valueOf(f));
    }

    public static final void setVerticalScrollAxisRange(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull ScrollAxisRange scrollAxisRange) {
        SemanticsProperties.INSTANCE.getVerticalScrollAxisRange().setValue(semanticsPropertyReceiver, $$delegatedProperties[11], scrollAxisRange);
    }

    public static final void showTextSubstitution(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function1<? super Boolean, Boolean> function1) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getShowTextSubstitution(), new AccessibilityAction(str, function1));
    }

    public static /* synthetic */ void showTextSubstitution$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        showTextSubstitution(semanticsPropertyReceiver, str, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T throwSemanticsGetNotSupported() {
        throw new UnsupportedOperationException("You cannot retrieve a semantics property directly - use one of the SemanticsConfiguration.getOr* methods instead");
    }

    @NotNull
    public static final <T> SemanticsPropertyKey<T> AccessibilityKey(@NotNull String str, @NotNull Function2<? super T, ? super T, ? extends T> function2) {
        return new SemanticsPropertyKey<>(str, true, function2);
    }

    public static final void setText(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function1<? super AnnotatedString, Boolean> function1) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getSetText(), new AccessibilityAction(str, function1));
    }

    public static final void setTextSubstitution(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable Function1<? super AnnotatedString, Boolean> function1) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getSetTextSubstitution(), new AccessibilityAction(str, function1));
    }

    @Deprecated(message = "Pass the ImeAction to onImeAction instead.")
    public static /* synthetic */ void getImeAction$annotations(SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }

    @Deprecated(message = "Use `isTraversalGroup` instead.", replaceWith = @ReplaceWith(expression = "isTraversalGroup", imports = {}))
    public static /* synthetic */ void isContainer$annotations(SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }
}
