package com.samsung.android.sdk.pen.engine.writingview;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.ScaleGestureDetector;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.carousel.RunnableC4617a;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.control.SpenControlObjectManager;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.engine.ListenerManager;
import com.samsung.android.sdk.pen.engine.SpenColorPickerListener;
import com.samsung.android.sdk.pen.engine.SpenConvertStrokeToShapeListener;
import com.samsung.android.sdk.pen.engine.SpenPenChangeListener;
import com.samsung.android.sdk.pen.engine.SpenRecentColorListener;
import com.samsung.android.sdk.pen.engine.SpenRemoverChangeListener;
import com.samsung.android.sdk.pen.engine.SpenRemoverListener;
import com.samsung.android.sdk.pen.engine.SpenReplayListener;
import com.samsung.android.sdk.pen.engine.SpenSelectionChangeListener;
import com.samsung.android.sdk.pen.engine.SpenToastActionListener;
import com.samsung.android.sdk.pen.engine.SpenTouchListener;
import com.samsung.android.sdk.pen.engine.deltaZoom.SpenZoomListener;
import com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface;
import com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopTexture;
import com.samsung.android.sdk.pen.engine.resource.SpenResources;
import com.samsung.android.sdk.pen.engine.writingview.document.SpenWritingDocument;
import com.samsung.android.sdk.pen.recoguifeature.SPenRecognitionWorker;
import com.samsung.android.sdk.pen.text.SpenSoftInputListener;
import com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.p148nt.app.sync.cloudsettings.callee.NotesSyncRpcProvider;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000Þ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 ø\u00012\u00020\u0001:\u0004÷\u0001ø\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0004\u0010\rB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000eB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\u0010B3\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u0011J \u0010\"\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0006\u0010$\u001a\u00020#J\u0010\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\t2\u0006\u0010&\u001a\u00020'H\u0016J0\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0014J\b\u0010/\u001a\u00020#H\u0014J\b\u00100\u001a\u00020#H\u0014J\u0010\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020\u0007H\u0014J\u0010\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u0007H\u0016J\u0010\u00105\u001a\u00020#2\u0006\u00106\u001a\u000207H\u0014J\u0018\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\u00072\u0006\u0010&\u001a\u00020:H\u0016J\u0018\u0010;\u001a\u00020\t2\u0006\u00109\u001a\u00020\u00072\u0006\u0010&\u001a\u00020:H\u0016J\u0018\u0010<\u001a\u00020\t2\u0006\u00109\u001a\u00020\u00072\u0006\u0010&\u001a\u00020:H\u0016J\u0018\u0010=\u001a\u00020\t2\u0006\u00109\u001a\u00020\u00072\u0006\u0010&\u001a\u00020:H\u0016J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010B\u001a\u00020\t2\b\u0010C\u001a\u0004\u0018\u00010DJ\u000e\u0010E\u001a\u00020#2\u0006\u0010F\u001a\u00020\u0007J*\u0010G\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0007J*\u0010N\u001a\u0004\u0018\u00010O2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0007J*\u0010P\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0007J,\u0010Q\u001a\u0004\u0018\u00010H2\b\u0010R\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u0007J,\u0010S\u001a\u0004\u0018\u00010H2\b\u0010R\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u0007J4\u0010T\u001a\u0004\u0018\u00010H2\b\u0010R\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\tJ\"\u0010V\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u0007J\u000e\u0010W\u001a\u00020#2\u0006\u0010X\u001a\u00020\tJ&\u0010Y\u001a\u00020#2\u0006\u0010+\u001a\u00020Z2\u0006\u0010,\u001a\u00020Z2\u0006\u0010-\u001a\u00020Z2\u0006\u0010.\u001a\u00020ZJ&\u0010[\u001a\u00020#2\u0006\u0010+\u001a\u00020Z2\u0006\u0010,\u001a\u00020Z2\u0006\u0010-\u001a\u00020Z2\u0006\u0010.\u001a\u00020ZJ\u000e\u0010\\\u001a\u00020#2\u0006\u0010]\u001a\u00020ZJ\u001e\u0010e\u001a\u00020#2\u0006\u0010]\u001a\u00020Z2\u0006\u0010f\u001a\u00020Z2\u0006\u0010g\u001a\u00020ZJ\u000e\u0010k\u001a\u00020\t2\u0006\u0010]\u001a\u00020ZJ\u000e\u0010n\u001a\u00020\t2\u0006\u0010]\u001a\u00020ZJ\u0012\u0010\u0082\u0001\u001a\u00020#2\u0007\u0010\u0083\u0001\u001a\u00020\u0007H\u0016J-\u0010\u0084\u0001\u001a\u00020#2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010H2\u0007\u0010\u0086\u0001\u001a\u00020\u00072\u0007\u0010\u0087\u0001\u001a\u00020\u00072\u0007\u0010\u0088\u0001\u001a\u00020\u0007J\u0010\u0010\u0089\u0001\u001a\u00020#2\u0007\u0010\u0083\u0001\u001a\u00020\u0007J-\u0010\u008a\u0001\u001a\u00020#2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010H2\u0007\u0010\u0086\u0001\u001a\u00020\u00072\u0007\u0010\u0087\u0001\u001a\u00020\u00072\u0007\u0010\u0088\u0001\u001a\u00020\u0007J6\u0010\u008a\u0001\u001a\u00020#2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010H2\u0007\u0010\u0086\u0001\u001a\u00020\u00072\u0007\u0010\u0087\u0001\u001a\u00020\u00072\u0007\u0010\u0088\u0001\u001a\u00020\u00072\u0007\u0010\u008b\u0001\u001a\u00020\tJ$\u0010\u008c\u0001\u001a\u00020#2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010H2\u0007\u0010\u0086\u0001\u001a\u00020\u00072\u0007\u0010\u008d\u0001\u001a\u00020\u0007J\u000f\u0010\u008e\u0001\u001a\u00020#2\u0006\u0010^\u001a\u00020\tJ!\u0010\u0091\u0001\u001a\u00020#2\u0006\u0010^\u001a\u00020\t2\u0007\u0010\u0092\u0001\u001a\u00020\u00072\u0007\u0010\u0093\u0001\u001a\u00020\u0007J\u0013\u0010\u0094\u0001\u001a\u00020#2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001J\u0013\u0010\u0097\u0001\u001a\u00020#2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0098\u0001J\u0013\u0010\u0099\u0001\u001a\u00020#2\n\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u0001J\u0013\u0010\u009c\u0001\u001a\u00020#2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u009d\u0001J\u0013\u0010\u009e\u0001\u001a\u00020#2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u009f\u0001J\u0013\u0010 \u0001\u001a\u00020#2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010¡\u0001J\u0013\u0010¢\u0001\u001a\u00020#2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010£\u0001J\u0013\u0010¤\u0001\u001a\u00020#2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010¡\u0001J\u0013\u0010¥\u0001\u001a\u00020#2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010¦\u0001J\u0013\u0010§\u0001\u001a\u00020#2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010¨\u0001J\u0013\u0010©\u0001\u001a\u00020#2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010ª\u0001J.\u0010«\u0001\u001a\u00020#2\u001b\u0010¬\u0001\u001a\u0016\u0012\u0005\u0012\u00030®\u00010\u00ad\u0001j\n\u0012\u0005\u0012\u00030®\u0001`¯\u00012\b\u0010°\u0001\u001a\u00030±\u0001J\u0019\u0010²\u0001\u001a\u00020#2\u0007\u0010³\u0001\u001a\u00020\u00072\u0007\u0010´\u0001\u001a\u00020\u0007J\u0010\u0010µ\u0001\u001a\u00020\u00072\u0007\u0010³\u0001\u001a\u00020\u0007J\u0012\u0010¶\u0001\u001a\u00020#2\u0007\u0010·\u0001\u001a\u00020\tH\u0016J\u001e\u0010¸\u0001\u001a\u00020\t2\u0007\u0010¹\u0001\u001a\u00020\t2\f\u0010º\u0001\u001a\u00030»\u0001\"\u00020\tJ\u0010\u0010¼\u0001\u001a\u00020\t2\u0007\u0010¹\u0001\u001a\u00020\tJ\u0011\u0010½\u0001\u001a\u00020\t2\b\u0010¾\u0001\u001a\u00030¿\u0001J\u001d\u0010À\u0001\u001a\u00020#2\u0006\u0010^\u001a\u00020\t2\f\u0010º\u0001\u001a\u00030»\u0001\"\u00020\tJ\u0010\u0010Î\u0001\u001a\u00020#2\u0007\u0010Ï\u0001\u001a\u00020\u0007J\u0010\u0010Ð\u0001\u001a\u00020#2\u0007\u0010Ñ\u0001\u001a\u00020\tJ\u0010\u0010Õ\u0001\u001a\u00020#2\u0007\u0010¹\u0001\u001a\u00020\tJ\u0010\u0010Ö\u0001\u001a\u00020#2\u0007\u0010¹\u0001\u001a\u00020\tJ\u0010\u0010×\u0001\u001a\u00020#2\u0007\u0010¹\u0001\u001a\u00020\tJ\u0010\u0010Ø\u0001\u001a\u00020#2\u0007\u0010¹\u0001\u001a\u00020\tJ\u0010\u0010Ù\u0001\u001a\u00020#2\u0007\u0010¹\u0001\u001a\u00020\tJ\u0013\u0010Ú\u0001\u001a\u00020#2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010Û\u0001J\u0007\u0010Ü\u0001\u001a\u00020\tJ\u0007\u0010Ý\u0001\u001a\u00020\tJ\u0007\u0010Þ\u0001\u001a\u00020\tJ\u0007\u0010ß\u0001\u001a\u00020\tJ\u0010\u0010à\u0001\u001a\u00020\t2\u0007\u0010á\u0001\u001a\u00020\u0007J\u000f\u0010ß\u0001\u001a\u00020\t2\u0006\u0010q\u001a\u00020\u0007J#\u0010â\u0001\u001a\u00020#2\b\u0010ã\u0001\u001a\u00030ä\u00012\u0007\u0010å\u0001\u001a\u00020Z2\u0007\u0010æ\u0001\u001a\u00020\u0007J\u0013\u0010ë\u0001\u001a\u00020#2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010ì\u0001J\u0013\u0010í\u0001\u001a\u00020#2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010î\u0001J\u0013\u0010ï\u0001\u001a\u00020#2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010ð\u0001J\u0013\u0010ñ\u0001\u001a\u00020\t2\n\u0010ò\u0001\u001a\u0005\u0018\u00010®\u0001J\u0007\u0010ó\u0001\u001a\u00020#J\u0010\u0010ô\u0001\u001a\u00020#2\u0007\u0010õ\u0001\u001a\u00020\u0007J\u001d\u0010ö\u0001\u001a\u00020#2\u0006\u0010^\u001a\u00020\t2\f\u0010º\u0001\u001a\u00030»\u0001\"\u00020\tR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0018\u00010!R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010_\u001a\u00020\t2\u0006\u0010^\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010c\u001a\u00020\t2\u0006\u0010^\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bc\u0010`\"\u0004\bd\u0010bR\u0011\u0010h\u001a\u00020Z8F¢\u0006\u0006\u001a\u0004\bi\u0010jR\u0011\u0010l\u001a\u00020Z8F¢\u0006\u0006\u001a\u0004\bm\u0010jR\u0011\u0010o\u001a\u00020Z8F¢\u0006\u0006\u001a\u0004\bp\u0010jR(\u0010s\u001a\u0004\u0018\u00010r2\b\u0010q\u001a\u0004\u0018\u00010r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR(\u0010x\u001a\u0004\u0018\u00010r2\b\u0010x\u001a\u0004\u0018\u00010r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\by\u0010u\"\u0004\bz\u0010wR*\u0010}\u001a\u0004\u0018\u00010|2\b\u0010{\u001a\u0004\u0018\u00010|8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R'\u0010\u008f\u0001\u001a\u00020\t2\u0006\u0010^\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008f\u0001\u0010`\"\u0005\b\u0090\u0001\u0010bR0\u0010Ã\u0001\u001a\u0005\u0018\u00010Â\u00012\n\u0010Á\u0001\u001a\u0005\u0018\u00010Â\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÄ\u0001\u0010Å\u0001\"\u0006\bÆ\u0001\u0010Ç\u0001R0\u0010É\u0001\u001a\u0005\u0018\u00010È\u00012\n\u0010Á\u0001\u001a\u0005\u0018\u00010È\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÊ\u0001\u0010Ë\u0001\"\u0006\bÌ\u0001\u0010Í\u0001R\u0019\u0010Ò\u0001\u001a\u0004\u0018\u00010\u00168BX\u0082\u0004¢\u0006\b\u001a\u0006\bÓ\u0001\u0010Ô\u0001R\u0017\u0010ç\u0001\u001a\u0005\u0018\u00010è\u00018F¢\u0006\b\u001a\u0006\bé\u0001\u0010ê\u0001¨\u0006ù\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/writingview/SpenWritingView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "drawingType", "", "isAsyncDrawing", "", "(Landroid/content/Context;IZ)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;IIZ)V", "mWritingViewImpl", "Lcom/samsung/android/sdk/pen/engine/writingview/SpenWritingViewImpl;", "mContext", "mActivity", "Landroid/app/Activity;", "mOrientationListener", "Landroid/view/OrientationEventListener;", "mDrawLoop", "Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopInterface;", "mListenerManager", "Lcom/samsung/android/sdk/pen/engine/ListenerManager;", "mTextureView", "Landroid/view/TextureView;", "mIsHWUIDrawLoop", "mActivityComponent", "Lcom/samsung/android/sdk/pen/engine/writingview/SpenWritingView$ActivityComponent;", "construct", "", "close", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onHoverEvent", "onLayout", "changed", "left", "top", "right", "bottom", "onAttachedToWindow", "onDetachedFromWindow", "onWindowVisibilityChanged", "visibility", "onScreenStateChanged", "screenState", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onKeyDown", "keyCode", "Landroid/view/KeyEvent;", "onKeyUp", "onKeyPreIme", "onKeyShortcut", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "setDocument", ExternalDataConstants.DOCUMENT_TABLE_NAME, "Lcom/samsung/android/sdk/pen/engine/writingview/document/SpenWritingDocument;", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "captureView", "Landroid/graphics/Bitmap;", "src", "Landroid/graphics/Rect;", "dstWidth", "dstHeight", "option", "captureViewWithRawData", "", "captureContent", "captureContentWithStrokeMask", "backgroundBitmap", "captureOriginalContentWithStrokeMask", "captureObject", "isHighlighter", "captureMosaicMask", "setDarkMode", "isDarkMode", "setMargin", "", "setContentRect", "setContentScale", WiggleAnimationConfig.KEY_SCALE, "enable", "isZoomable", "()Z", "setZoomable", "(Z)V", "isScrollable", "setScrollable", "setZoomScale", "pivotX", "pivotY", "zoomScale", "getZoomScale", "()F", "setMaxZoomScale", "maxZoomScale", "getMaxZoomScale", "setMinZoomScale", "minZoomScale", "getMinZoomScale", "position", "Landroid/graphics/PointF;", "pan", "getPan", "()Landroid/graphics/PointF;", "setPan", "(Landroid/graphics/PointF;)V", "delta", "getDelta", "setDelta", "pMatrix", "Landroid/graphics/Matrix;", "contentMatrix", "getContentMatrix", "()Landroid/graphics/Matrix;", "setContentMatrix", "(Landroid/graphics/Matrix;)V", "setBackgroundColor", "color", "setBackgroundBitmap", "bitmap", "gravity", "tileModeX", "tileModeY", "setContentBackgroundColor", "setContentBackgroundBitmap", "includeAsMosaicBackground", "setContentTransparentBackgroundImage", "tileMode", "setHapticSoundEnabled", "isToolTipEnabled", "setToolTipEnabled", "setStretchContentSize", "width", "height", "setPenChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/engine/SpenPenChangeListener;", "setRemoverChangeListener", "Lcom/samsung/android/sdk/pen/engine/SpenRemoverChangeListener;", "setRemoverListener", "removerListener", "Lcom/samsung/android/sdk/pen/engine/SpenRemoverListener;", "setColorPickerListener", "Lcom/samsung/android/sdk/pen/engine/SpenColorPickerListener;", "setRecentColorListener", "Lcom/samsung/android/sdk/pen/engine/SpenRecentColorListener;", "setPreTouchListener", "Lcom/samsung/android/sdk/pen/engine/SpenTouchListener;", "setToastActionListener", "Lcom/samsung/android/sdk/pen/engine/SpenToastActionListener;", "setTouchListener", "setSelectionChangeListener", "Lcom/samsung/android/sdk/pen/engine/SpenSelectionChangeListener;", "setZoomListener", "Lcom/samsung/android/sdk/pen/engine/deltaZoom/SpenZoomListener;", "setScaleGestureListener", "Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;", "appendDoodleObject", "strokes", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectStroke;", "Lkotlin/collections/ArrayList;", "objectShape", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "setToolTypeAction", "toolType", "action", "getToolTypeAction", "onWindowFocusChanged", "hasWindowFocus", "setFrontBufferRenderingEnabled", "enabled", NotesSyncRpcProvider.FORCE_SYNC, "", "setInputMethodServiceInkWindowMode", "setFrontBufferRenderingCaptureWindow", "window", "Landroid/view/Window;", "setPredictionEnabled", "info", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "penSettingInfo", "getPenSettingInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "setPenSettingInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;)V", "Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "removerSettingInfo", "getRemoverSettingInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "setRemoverSettingInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;)V", "setSelectionType", "type", "setIntersectSelection", "intersect", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "getActivity", "()Landroid/app/Activity;", "setEdgeEffectEnabled", "setHoverScrollEnabled", "setLongPressEnabled", "setHoldLongPressEnabled", "setStrokeToShapeEnabled", "setReplayListener", "Lcom/samsung/android/sdk/pen/engine/SpenReplayListener;", "startReplay", "stopReplay", "resumeReplay", "pauseReplay", "setReplaySpeed", "speed", "setHoverScrollOption", "responseTime", "", "velocity", "margin", "controlObjectManager", "Lcom/samsung/android/sdk/pen/control/SpenControlObjectManager;", "getControlObjectManager", "()Lcom/samsung/android/sdk/pen/control/SpenControlObjectManager;", "setContextMenuListener", "Lcom/samsung/android/sdk/pen/view/contextmenu/SpenContextMenuListener;", "setSoftInputListener", "Lcom/samsung/android/sdk/pen/text/SpenSoftInputListener;", "setConvertStrokeToShapeListener", "Lcom/samsung/android/sdk/pen/engine/SpenConvertStrokeToShapeListener;", "convertStrokeToShape", "stroke", "onResume", "onTrimMemory", "level", "setUnbufferedDispatchEnabled", "ActivityComponent", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenWritingView extends FrameLayout {
    public static final int BITMAP_GRAVITY_BOTTOM = 9;
    public static final int BITMAP_GRAVITY_CENTER = 6;
    public static final int BITMAP_GRAVITY_FIT = 0;
    public static final int BITMAP_GRAVITY_LEFT = 5;
    public static final int BITMAP_GRAVITY_LEFT_BOTTOM = 8;
    public static final int BITMAP_GRAVITY_LEFT_TOP = 2;
    public static final int BITMAP_GRAVITY_RIGHT = 7;
    public static final int BITMAP_GRAVITY_RIGHT_BOTTOM = 10;
    public static final int BITMAP_GRAVITY_RIGHT_TOP = 4;
    public static final int BITMAP_GRAVITY_STRETCH = 1;
    public static final int BITMAP_GRAVITY_TOP = 3;
    public static final int BITMAP_TILEMODE_CLAMP = 1;
    public static final int BITMAP_TILEMODE_DISABLE = 0;
    public static final int BITMAP_TILEMODE_MIRROR = 3;
    public static final int BITMAP_TILEMODE_REPEAT = 2;
    public static final int CAPTURE_ALL = 285212689;
    public static final int CAPTURE_BACKGROUND = 16777216;
    public static final int CAPTURE_CONTENT_BACKGROUND = 268435456;
    public static final int CAPTURE_FOREGROUND_ALL = 17;
    private static final int CAPTURE_OBJECT = 16;
    private static final int CAPTURE_STROKE = 1;
    public static final int DRAWING_TYPE_NOCACHE_VECTOR = 2;
    public static final int DRAWING_TYPE_RASTER = 0;
    public static final int DRAWING_TYPE_VECTOR = 1;
    public static final int DRAW_LOOP_TYPE_HWUI = 0;
    public static final int DRAW_LOOP_TYPE_TEXTURE_VIEW = 1;

    @NotNull
    private static final String TAG = "SpenWritingView";
    private static final int mDrawLoopType = 1;

    @Nullable
    private Activity mActivity;

    @Nullable
    private ActivityComponent mActivityComponent;

    @Nullable
    private Context mContext;

    @Nullable
    private SpenDrawLoopInterface mDrawLoop;
    private boolean mIsHWUIDrawLoop;

    @Nullable
    private ListenerManager mListenerManager;

    @Nullable
    private OrientationEventListener mOrientationListener;

    @Nullable
    private TextureView mTextureView;

    @Nullable
    private SpenWritingViewImpl mWritingViewImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/writingview/SpenWritingView$ActivityComponent;", "Landroid/content/ComponentCallbacks2;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "(Lcom/samsung/android/sdk/pen/engine/writingview/SpenWritingView;)V", "onActivityCreated", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "bundle", "Landroid/os/Bundle;", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "onActivitySaveInstanceState", "onActivityDestroyed", "onTrimMemory", "level", "", "onConfigurationChanged", "configuration", "Landroid/content/res/Configuration;", "onLowMemory", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class ActivityComponent implements ComponentCallbacks2, Application.ActivityLifecycleCallbacks {
        public ActivityComponent() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (activity == SpenWritingView.this.mActivity) {
                Log.i(SpenWritingView.TAG, "onActivityStarted");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (activity == SpenWritingView.this.mActivity) {
                Log.i(SpenWritingView.TAG, "onActivityPaused");
                SpenWritingViewImpl spenWritingViewImpl = SpenWritingView.this.mWritingViewImpl;
                if (spenWritingViewImpl != null) {
                    spenWritingViewImpl.onPause();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (activity == SpenWritingView.this.mActivity) {
                Log.i(SpenWritingView.TAG, "onActivityResumed, Restore GL resources");
                SpenDrawLoopInterface spenDrawLoopInterface = SpenWritingView.this.mDrawLoop;
                if (spenDrawLoopInterface != null) {
                    spenDrawLoopInterface.onResume();
                }
                SpenWritingViewImpl spenWritingViewImpl = SpenWritingView.this.mWritingViewImpl;
                if (spenWritingViewImpl != null) {
                    spenWritingViewImpl.onResume();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (activity == SpenWritingView.this.mActivity) {
                Log.i(SpenWritingView.TAG, "onActivityStopped");
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(@NotNull Configuration configuration) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int level) {
            int i = Build.VERSION.SDK_INT;
            if ((i > 34 || level != 80) && (i <= 34 || level != 40)) {
                return;
            }
            Log.d(SpenWritingView.TAG, "onTrimMemory, Force to clear gl resourced");
            SpenResources.INSTANCE.forceClearResources();
            SpenWritingViewImpl spenWritingViewImpl = SpenWritingView.this.mWritingViewImpl;
            if (spenWritingViewImpl != null) {
                spenWritingViewImpl.onTrimMemory();
            }
            SpenDrawLoopInterface spenDrawLoopInterface = SpenWritingView.this.mDrawLoop;
            if (spenDrawLoopInterface != null) {
                spenDrawLoopInterface.onPause();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenWritingView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mActivityComponent = new ActivityComponent();
        construct(context, 0, false);
    }

    private final void construct(Context context, int drawingType, boolean isAsyncDrawing) {
        try {
            SPenRecognitionWorker.initializeSelf(context);
        } catch (UnsatisfiedLinkError unused) {
            Log.i(TAG, "Recoguifeature initialized failure | not supported!");
        }
        this.mContext = context;
        this.mIsHWUIDrawLoop = false;
        this.mDrawLoop = new SpenDrawLoopTexture(false);
        setLayerType(2, null);
        TextureView textureView = new TextureView(context);
        this.mTextureView = textureView;
        addView(textureView);
        textureView.setOpaque(false);
        textureView.setSurfaceTextureListener((SpenDrawLoopTexture) this.mDrawLoop);
        if (textureView.isAvailable() && textureView.getSurfaceTexture() != null) {
            SpenDrawLoopInterface spenDrawLoopInterface = this.mDrawLoop;
            Intrinsics.checkNotNull(spenDrawLoopInterface, "null cannot be cast to non-null type com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopTexture");
            SurfaceTexture surfaceTexture = textureView.getSurfaceTexture();
            Intrinsics.checkNotNull(surfaceTexture);
            ((SpenDrawLoopTexture) spenDrawLoopInterface).onSurfaceTextureAvailable(surfaceTexture, getWidth(), getHeight());
        }
        this.mListenerManager = new ListenerManager(context);
        SpenWritingViewImpl spenWritingViewImpl = new SpenWritingViewImpl(context, this, this.mDrawLoop, drawingType, isAsyncDrawing);
        this.mWritingViewImpl = spenWritingViewImpl;
        spenWritingViewImpl.setListenerManager(this.mListenerManager);
        Activity activity = getActivity();
        this.mActivity = activity;
        if (activity != null) {
            activity.registerComponentCallbacks(this.mActivityComponent);
            activity.getApplication().registerActivityLifecycleCallbacks(this.mActivityComponent);
        }
        SpenResources.INSTANCE.registerResourceView(this);
        this.mOrientationListener = new OrientationEventListener(context, this) { // from class: com.samsung.android.sdk.pen.engine.writingview.SpenWritingView.construct.3
            final /* synthetic */ Context $context;
            final /* synthetic */ SpenWritingView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(context);
                this.$context = context;
                this.this$0 = this;
            }

            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int orientation) {
                SpenWritingView spenWritingView = this.this$0;
                Context context2 = this.$context;
                synchronized (this) {
                    SpenWritingViewImpl spenWritingViewImpl2 = spenWritingView.mWritingViewImpl;
                    if (spenWritingViewImpl2 != null) {
                        Log.i(SpenWritingView.TAG, "onOrientationChanged, orientation = " + orientation);
                        Object systemService = context2.getSystemService("window");
                        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                        spenWritingViewImpl2.setScreenOrientation(((WindowManager) systemService).getDefaultDisplay().getRotation());
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        };
        setWillNotDraw(false);
    }

    private final Activity getActivity() {
        for (Context baseContext = this.mContext; baseContext instanceof ContextWrapper; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof Activity) {
                Log.d(TAG, "getActivity - Activity found");
                return (Activity) baseContext;
            }
        }
        Log.d(TAG, "getActivity - Activity NOT found");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDocument$lambda$6(SpenWritingView spenWritingView) {
        if (spenWritingView.mIsHWUIDrawLoop || spenWritingView.mDrawLoop == null) {
            return;
        }
        Rect rect = new Rect();
        spenWritingView.getDrawingRect(rect);
        if (rect.isEmpty()) {
            return;
        }
        int i = rect.right - rect.left;
        int i2 = rect.bottom - rect.top;
        Log.i(TAG, "setCaptureCurrentViewBmp" + rect);
        Bitmap bitmapCaptureView = spenWritingView.captureView(rect, i, i2, 285212689);
        SpenDrawLoopInterface spenDrawLoopInterface = spenWritingView.mDrawLoop;
        Intrinsics.checkNotNull(spenDrawLoopInterface, "null cannot be cast to non-null type com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopTexture");
        ((SpenDrawLoopTexture) spenDrawLoopInterface).setCaptureCurrentViewBmp(bitmapCaptureView);
    }

    public final void appendDoodleObject(@NotNull ArrayList<SpenObjectStroke> strokes, @NotNull SpenObjectShape objectShape) {
        Intrinsics.checkNotNullParameter(strokes, "strokes");
        Intrinsics.checkNotNullParameter(objectShape, "objectShape");
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.appendDoodleObject(strokes, objectShape);
        }
    }

    @Nullable
    public final Bitmap captureContent(@Nullable Rect src, int dstWidth, int dstHeight, int option) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.captureContent(src, dstWidth, dstHeight, option);
        }
        return null;
    }

    @Nullable
    public final Bitmap captureContentWithStrokeMask(@Nullable Bitmap backgroundBitmap, @Nullable Rect src, int dstWidth, int dstHeight) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.captureContentWithStrokeMask(backgroundBitmap, src, dstWidth, dstHeight);
        }
        return null;
    }

    @Nullable
    public final Bitmap captureMosaicMask(@Nullable Rect src, int dstWidth, int dstHeight) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.captureMosaicMask(src, dstWidth, dstHeight);
        }
        return null;
    }

    @Nullable
    public final Bitmap captureObject(@Nullable Bitmap backgroundBitmap, @Nullable Rect src, int dstWidth, int dstHeight, boolean isHighlighter) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.captureObject(backgroundBitmap, src, dstWidth, dstHeight, isHighlighter);
        }
        return null;
    }

    @Nullable
    public final Bitmap captureOriginalContentWithStrokeMask(@Nullable Bitmap backgroundBitmap, @Nullable Rect src, int dstWidth, int dstHeight) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.captureOriginalContentWithStrokeMask(backgroundBitmap, src, dstWidth, dstHeight);
        }
        return null;
    }

    @Nullable
    public final Bitmap captureView(@Nullable Rect src, int dstWidth, int dstHeight, int option) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.captureView(src, dstWidth, dstHeight, option);
        }
        return null;
    }

    @Nullable
    public final byte[] captureViewWithRawData(@Nullable Rect src, int dstWidth, int dstHeight, int option) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.captureViewWithRawData(src, dstWidth, dstHeight, option);
        }
        return null;
    }

    public final void close() {
        Log.d(TAG, "SpenWritingView.close()");
        if (!this.mIsHWUIDrawLoop) {
            TextureView textureView = this.mTextureView;
            if (textureView != null) {
                textureView.setSurfaceTextureListener(null);
            }
            removeView(this.mTextureView);
            this.mTextureView = null;
        }
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.unregisterComponentCallbacks(this.mActivityComponent);
            activity.getApplication().unregisterActivityLifecycleCallbacks(this.mActivityComponent);
            this.mActivity = null;
        }
        SpenResources.INSTANCE.unregisterResourceView(this);
        ListenerManager listenerManager = this.mListenerManager;
        if (listenerManager != null) {
            listenerManager.close();
        }
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.close();
        }
        OrientationEventListener orientationEventListener = this.mOrientationListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        SpenDrawLoopInterface spenDrawLoopInterface = this.mDrawLoop;
        if (spenDrawLoopInterface != null) {
            spenDrawLoopInterface.close();
            if (!isAttachedToWindow()) {
                this.mDrawLoop = null;
            }
        }
        this.mContext = null;
        this.mActivityComponent = null;
    }

    public final boolean convertStrokeToShape(@Nullable SpenObjectStroke stroke) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        return spenWritingViewImpl != null && spenWritingViewImpl.convertStrokeToShape(stroke);
    }

    @Nullable
    public final Matrix getContentMatrix() {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.getContentMatrix();
        }
        return null;
    }

    @Nullable
    public final SpenControlObjectManager getControlObjectManager() {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.getControlObjectManager();
        }
        return null;
    }

    @Nullable
    public final PointF getDelta() {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.getDelta();
        }
        return null;
    }

    public final float getMaxZoomScale() {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.getMaxZoomScale();
        }
        return 0.0f;
    }

    public final float getMinZoomScale() {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.getMinZoomScale();
        }
        return 0.0f;
    }

    @Nullable
    public final PointF getPan() {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.getPan();
        }
        return null;
    }

    @Nullable
    public final SpenSettingPenInfo getPenSettingInfo() {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.getPenSettingInfo();
        }
        return null;
    }

    @Nullable
    public final SpenSettingRemoverInfo getRemoverSettingInfo() {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.getRemoverSettingInfo();
        }
        return null;
    }

    public final int getToolTypeAction(int toolType) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.getToolTypeAction(toolType);
        }
        return 0;
    }

    public final float getZoomScale() {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.getZoomScale();
        }
        return 0.0f;
    }

    public final boolean isScrollable() {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.isScrollable();
        }
        return false;
    }

    public final boolean isToolTipEnabled() {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.isToolTipEnabled();
        }
        return false;
    }

    public final boolean isZoomable() {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.isZoomable();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            ViewParent parent = getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            spenWritingViewImpl.onAttachedToWindow((ViewGroup) parent);
        }
    }

    @Override // android.view.View
    @NotNull
    public InputConnection onCreateInputConnection(@NotNull EditorInfo outAttrs) {
        InputConnection inputConnectionOnCreateInputConnection;
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        if (!isEnabled()) {
            InputConnection inputConnectionOnCreateInputConnection2 = super.onCreateInputConnection(outAttrs);
            Intrinsics.checkNotNullExpressionValue(inputConnectionOnCreateInputConnection2, "onCreateInputConnection(...)");
            return inputConnectionOnCreateInputConnection2;
        }
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null && (inputConnectionOnCreateInputConnection = spenWritingViewImpl.onCreateInputConnection(outAttrs)) != null) {
            return inputConnectionOnCreateInputConnection;
        }
        InputConnection inputConnectionOnCreateInputConnection3 = super.onCreateInputConnection(outAttrs);
        Intrinsics.checkNotNullExpressionValue(inputConnectionOnCreateInputConnection3, "onCreateInputConnection(...)");
        return inputConnectionOnCreateInputConnection3;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            ViewParent parent = getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            spenWritingViewImpl.onDetachedFromWindow((ViewGroup) parent);
        }
        super.onDetachedFromWindow();
        SpenWritingViewImpl spenWritingViewImpl2 = this.mWritingViewImpl;
        if (spenWritingViewImpl2 == null || spenWritingViewImpl2.isNativeViewValid()) {
            return;
        }
        SpenDrawLoopInterface spenDrawLoopInterface = this.mDrawLoop;
        if (spenDrawLoopInterface != null) {
            spenDrawLoopInterface.onViewDetachedFromWindow();
        }
        this.mDrawLoop = null;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        SpenDrawLoopInterface spenDrawLoopInterface = this.mDrawLoop;
        if (spenDrawLoopInterface != null) {
            spenDrawLoopInterface.onDraw(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onHoverEvent(event);
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.onHoverEvent(event);
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        return (spenWritingViewImpl != null && spenWritingViewImpl.onKeyDown(keyCode, event)) || super.onKeyDown(keyCode, event);
    }

    @Override // android.view.View
    public boolean onKeyPreIme(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.onKeyPreIme(keyCode, event);
        }
        return false;
    }

    @Override // android.view.View
    public boolean onKeyShortcut(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.onKeyShortcut(keyCode, event);
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        return (spenWritingViewImpl != null && spenWritingViewImpl.onKeyUp(keyCode, event)) || super.onKeyUp(keyCode, event);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.onLayout(changed, left, top, right, bottom);
        }
    }

    public final void onResume() {
        Log.i(TAG, "onResumed, Restore GL resources");
        SpenDrawLoopInterface spenDrawLoopInterface = this.mDrawLoop;
        if (spenDrawLoopInterface != null) {
            spenDrawLoopInterface.onResume();
        }
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.onResume();
        }
    }

    @Override // android.view.View
    public void onScreenStateChanged(int screenState) {
        super.onScreenStateChanged(screenState);
        OrientationEventListener orientationEventListener = this.mOrientationListener;
        if (orientationEventListener == null || getWindowVisibility() != 0) {
            return;
        }
        if (screenState == 0) {
            orientationEventListener.disable();
        } else {
            orientationEventListener.enable();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.onTouchEvent(event);
        }
        return false;
    }

    public final void onTrimMemory(int level) {
        int i = Build.VERSION.SDK_INT;
        if ((i > 34 || level != 80) && (i <= 34 || level != 40)) {
            return;
        }
        Log.d(TAG, "onTrimMemory, Force to clear gl resourced");
        SpenResources.INSTANCE.forceClearResources();
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.onTrimMemory();
        }
        SpenDrawLoopInterface spenDrawLoopInterface = this.mDrawLoop;
        if (spenDrawLoopInterface != null) {
            spenDrawLoopInterface.onPause();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.onWindowFocusChanged(hasWindowFocus);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        OrientationEventListener orientationEventListener = this.mOrientationListener;
        if (orientationEventListener != null) {
            if (visibility == 0) {
                orientationEventListener.enable();
            } else {
                orientationEventListener.disable();
            }
        }
    }

    public final boolean pauseReplay() {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.pauseReplay();
        }
        return false;
    }

    public final boolean resumeReplay() {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.resumeReplay();
        }
        return false;
    }

    public final void setBackgroundBitmap(@Nullable Bitmap bitmap, int gravity, int tileModeX, int tileModeY) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setBackgroundBitmap(bitmap, gravity, tileModeX, tileModeY);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setBackgroundColor(color);
        }
    }

    public final void setColorPickerListener(@Nullable SpenColorPickerListener listener) {
        ListenerManager listenerManager = this.mListenerManager;
        if (listenerManager != null) {
            listenerManager.setColorPickerListener(listener);
        }
    }

    public final void setColorTheme(int theme) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setColorTheme(theme);
        }
    }

    public final void setContentBackgroundBitmap(@Nullable Bitmap bitmap, int gravity, int tileModeX, int tileModeY) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setContentBackgroundBitmap(bitmap, gravity, tileModeX, tileModeY);
        }
    }

    public final void setContentBackgroundColor(int color) {
        AbstractC0541b.m755A(color, "setContentBackgroundColor = ", TAG);
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setContentBackgroundColor(color);
        }
    }

    public final void setContentMatrix(@Nullable Matrix matrix) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setContentMatrix(matrix);
        }
    }

    public final void setContentRect(float left, float top, float right, float bottom) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setContentRect(left, top, right, bottom);
        }
    }

    public final void setContentScale(float scale) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setContentScale(scale);
        }
    }

    public final void setContentTransparentBackgroundImage(@Nullable Bitmap bitmap, int gravity, int tileMode) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setContentTransparentBackgroundImage(bitmap, gravity, tileMode);
        }
    }

    public final void setContextMenuListener(@Nullable SpenContextMenuListener listener) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setContextMenuListener(listener);
        }
    }

    public final void setConvertStrokeToShapeListener(@Nullable SpenConvertStrokeToShapeListener listener) {
        ListenerManager listenerManager = this.mListenerManager;
        if (listenerManager != null) {
            listenerManager.setConvertStrokeToShapeListener(listener);
        }
    }

    public final void setDarkMode(boolean isDarkMode) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setDarkMode(isDarkMode);
        }
    }

    public final void setDelta(@Nullable PointF pointF) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setDelta(pointF);
        }
    }

    public final boolean setDocument(@Nullable SpenWritingDocument document) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        boolean document2 = spenWritingViewImpl != null ? spenWritingViewImpl.setDocument(document) : false;
        if (!this.mIsHWUIDrawLoop) {
            View view = new View(this.mContext);
            int iIndexOfChild = indexOfChild(this.mTextureView);
            if (iIndexOfChild != -1) {
                addView(view, iIndexOfChild);
            } else {
                addView(view);
            }
            SpenDrawLoopInterface spenDrawLoopInterface = this.mDrawLoop;
            Intrinsics.checkNotNull(spenDrawLoopInterface, "null cannot be cast to non-null type com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopTexture");
            ((SpenDrawLoopTexture) spenDrawLoopInterface).setOwnedTwinView(view);
            post(new RunnableC4617a(this, 14));
        }
        return document2;
    }

    public final void setEdgeEffectEnabled(boolean enabled) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setEdgeEffectEnabled(enabled);
        }
    }

    public final boolean setFrontBufferRenderingCaptureWindow(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.setFrontBufferRenderingCaptureWindow(window);
        }
        return false;
    }

    public final boolean setFrontBufferRenderingEnabled(boolean enabled, @NotNull boolean... force) {
        Intrinsics.checkNotNullParameter(force, "force");
        boolean z = !(force.length == 0) ? force[0] : false;
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.setFrontBufferRenderingEnabled(enabled, z);
        }
        return false;
    }

    public final void setHapticSoundEnabled(boolean enable) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setHapticSoundEnabled(enable);
        }
    }

    public final void setHoldLongPressEnabled(boolean enabled) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setHoldLongPressEnabled(enabled);
        }
    }

    public final void setHoverScrollEnabled(boolean enabled) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setHoverScrollEnabled(enabled);
        }
    }

    public final void setHoverScrollOption(long responseTime, float velocity, int margin) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setHoverScrollOption(responseTime, velocity, margin);
        }
    }

    public final boolean setInputMethodServiceInkWindowMode(boolean enabled) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.setInputMethodServiceInkWindowMode(enabled);
        }
        return false;
    }

    public final void setIntersectSelection(boolean intersect) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setIntersectSelection(intersect);
        }
    }

    public final void setLongPressEnabled(boolean enabled) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setLongPressEnabled(enabled);
        }
    }

    public final void setMargin(float left, float top, float right, float bottom) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setMargin(left, top, right, bottom);
        }
    }

    public final boolean setMaxZoomScale(float scale) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.setMaxZoomScale(scale);
        }
        return false;
    }

    public final boolean setMinZoomScale(float scale) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.setMinZoomScale(scale);
        }
        return false;
    }

    public final void setPan(@Nullable PointF pointF) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setPan(pointF);
        }
    }

    public final void setPenChangeListener(@Nullable SpenPenChangeListener listener) {
        ListenerManager listenerManager = this.mListenerManager;
        if (listenerManager != null) {
            listenerManager.setPenChangeListener(listener);
        }
    }

    public final void setPenSettingInfo(@Nullable SpenSettingPenInfo spenSettingPenInfo) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setPenSettingInfo(spenSettingPenInfo);
        }
    }

    public final void setPreTouchListener(@Nullable SpenTouchListener listener) {
        ListenerManager listenerManager = this.mListenerManager;
        if (listenerManager != null) {
            listenerManager.setPreTouchListener(listener);
        }
    }

    public final void setPredictionEnabled(boolean enable, @NotNull boolean... force) {
        Intrinsics.checkNotNullParameter(force, "force");
        boolean z = !(force.length == 0) ? force[0] : false;
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setPredictionEnabled(enable, z);
        }
    }

    public final void setRecentColorListener(@Nullable SpenRecentColorListener listener) {
        ListenerManager listenerManager = this.mListenerManager;
        if (listenerManager != null) {
            listenerManager.setRecentColorListener(listener);
        }
    }

    public final void setRemoverChangeListener(@Nullable SpenRemoverChangeListener listener) {
        ListenerManager listenerManager = this.mListenerManager;
        if (listenerManager != null) {
            listenerManager.setRemoverChangeListener(listener);
        }
    }

    public final void setRemoverListener(@Nullable SpenRemoverListener removerListener) {
        ListenerManager listenerManager = this.mListenerManager;
        if (listenerManager != null) {
            listenerManager.setRemoverListener(removerListener);
        }
    }

    public final void setRemoverSettingInfo(@Nullable SpenSettingRemoverInfo spenSettingRemoverInfo) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setRemoverSettingInfo(spenSettingRemoverInfo);
        }
    }

    public final void setReplayListener(@Nullable SpenReplayListener listener) {
        ListenerManager listenerManager = this.mListenerManager;
        if (listenerManager != null) {
            listenerManager.setReplayListener(listener);
        }
    }

    public final boolean setReplaySpeed(int speed) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.setReplaySpeed(speed);
        }
        return false;
    }

    public final void setScaleGestureListener(@Nullable ScaleGestureDetector.SimpleOnScaleGestureListener listener) {
    }

    public final void setScrollable(boolean z) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setScrollable(z);
        }
    }

    public final void setSelectionChangeListener(@Nullable SpenSelectionChangeListener listener) {
        ListenerManager listenerManager = this.mListenerManager;
        if (listenerManager != null) {
            listenerManager.setSelectionChangeListener(listener);
        }
    }

    public final void setSelectionType(int type) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setSelectionType(type);
        }
    }

    public final void setSoftInputListener(@Nullable SpenSoftInputListener listener) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setSoftInputListener(listener);
        }
    }

    public final void setStretchContentSize(boolean enable, int width, int height) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setStretchContentSize(enable, width, height);
        }
    }

    public final void setStrokeToShapeEnabled(boolean enabled) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setStrokeToShapeEnabled(enabled);
        }
    }

    public final void setToastActionListener(@Nullable SpenToastActionListener listener) {
        ListenerManager listenerManager = this.mListenerManager;
        if (listenerManager != null) {
            listenerManager.setToastActionListenerner(listener);
        }
    }

    public final void setToolTipEnabled(boolean z) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setToolTipEnabled(z);
        }
    }

    public final void setToolTypeAction(int toolType, int action) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setToolTypeAction(toolType, action);
        }
    }

    public final void setTouchListener(@Nullable SpenTouchListener listener) {
        ListenerManager listenerManager = this.mListenerManager;
        if (listenerManager != null) {
            listenerManager.setTouchListener(listener);
        }
    }

    public final void setUnbufferedDispatchEnabled(boolean enable, @NotNull boolean... force) {
        Intrinsics.checkNotNullParameter(force, "force");
        boolean z = !(force.length == 0) ? force[0] : false;
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setUnbufferedDispatchEnabled(enable, z);
        }
    }

    public final void setZoomListener(@Nullable SpenZoomListener listener) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setZoomListener(listener);
        }
    }

    public final void setZoomScale(float scale, float pivotX, float pivotY) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setZoomScale(scale, pivotX, pivotY);
        }
    }

    public final void setZoomable(boolean z) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setZoomable(z);
        }
    }

    public final boolean startReplay() {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.startReplay();
        }
        return false;
    }

    public final boolean stopReplay() {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.stopReplay();
        }
        return false;
    }

    public final boolean pauseReplay(int position) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            return spenWritingViewImpl.setReplayPosition(position);
        }
        return false;
    }

    public final void setContentBackgroundBitmap(@Nullable Bitmap bitmap, int gravity, int tileModeX, int tileModeY, boolean includeAsMosaicBackground) {
        SpenWritingViewImpl spenWritingViewImpl = this.mWritingViewImpl;
        if (spenWritingViewImpl != null) {
            spenWritingViewImpl.setContentBackgroundBitmap(bitmap, gravity, tileModeX, tileModeY, includeAsMosaicBackground);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenWritingView(@NotNull Context context, int i, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mActivityComponent = new ActivityComponent();
        construct(context, i, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenWritingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mActivityComponent = new ActivityComponent();
        construct(context, 0, false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenWritingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mActivityComponent = new ActivityComponent();
        construct(context, i, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenWritingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mActivityComponent = new ActivityComponent();
        construct(context, 0, false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenWritingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2, boolean z) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mActivityComponent = new ActivityComponent();
        construct(context, i2, z);
    }
}
