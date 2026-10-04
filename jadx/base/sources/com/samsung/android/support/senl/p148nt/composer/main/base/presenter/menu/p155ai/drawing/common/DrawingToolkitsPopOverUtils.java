package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.DrawingAssistTypePopupWindow;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0005J&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0005J\u001e\u0010!\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u0005J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J:\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020\u00052\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020\u0005H\u0002J\u0018\u0010.\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010/2\u0006\u0010(\u001a\u00020)H\u0002J0\u00100\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)2\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0002J\u0010\u00103\u001a\u0002042\u0006\u0010(\u001a\u00020)H\u0003J\u0010\u00105\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)H\u0003J\u0010\u00106\u001a\u0002072\u0006\u0010(\u001a\u00020)H\u0003J\u0010\u00108\u001a\u0002072\u0006\u00109\u001a\u00020:H\u0003J\u0018\u0010;\u001a\u00020%2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001c\u001a\u00020\nH\u0002J \u0010<\u001a\u00020%2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\nH\u0002J\u0018\u0010=\u001a\u00020%2\u0006\u0010(\u001a\u00020)2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010>\u001a\u0002042\u0006\u0010(\u001a\u00020)H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006?"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/drawing/common/DrawingToolkitsPopOverUtils;", "", "<init>", "()V", "POSITION_AUTO", "", "POSITION_START", "POSITION_CENTER", "POSITION_END", "WINDOWING_MODE_KEY", "", "WINDOWING_MODE_SPLIT_SCREEN", "WINDOWING_MODE_FREEFORM", "THRESHOLD_FOR_LARGE_SCREEN", "POSITION_LANDSCAPE", "POSITION_PORTRAIT", "WIDTH_FOLD", "HEIGHT_FOLD", "END_MARGIN_FOLD", "TOP_MARGIN_FOLD", "WIDTH_TABLET", "HEIGHT_TABLET", "END_MARGIN_TABLET", "TOP_MARGIN_TABLET", "showDrawingToolkitsPopOver", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "text", "requestCode", "uri", "Landroid/net/Uri;", "mimeType", "showDrawingToolkitsStudio", Constant.DRAWING_TOOLKIT_KEY_STUDIO_TYPE, "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/DrawingAssistTypePopupWindow$StudioType;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "getPopOverDetails", "Landroid/os/Bundle;", "context", "Landroid/content/Context;", "positionVertical", "positionHorizontal", "centerX", "centerY", "getSizeArray", "", "getPosition", "vertical", "horizontal", "canSupportPopOver", "", "getSmallestScreenWidthDp", "getContentSize", "Landroid/graphics/Point;", "getContentSizeByWindowMetrics", "windowManager", "Landroid/view/WindowManager;", "getTextBaseIntent", "getUriBaseIntent", "getStudioTypeBaseIntent", "isMultiWindowMode", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDrawingToolkitsPopOverUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DrawingToolkitsPopOverUtils.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/drawing/common/DrawingToolkitsPopOverUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,281:1\n774#2:282\n865#2,2:283\n1193#2,2:285\n1267#2,4:287\n*S KotlinDebug\n*F\n+ 1 DrawingToolkitsPopOverUtils.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/drawing/common/DrawingToolkitsPopOverUtils\n*L\n270#1:282\n270#1:283,2\n273#1:285,2\n273#1:287,4\n*E\n"})
public final class DrawingToolkitsPopOverUtils {
    private static final int END_MARGIN_FOLD = 2;
    private static final int END_MARGIN_TABLET = 6;
    private static final int HEIGHT_FOLD = 1;
    private static final int HEIGHT_TABLET = 5;

    @NotNull
    public static final DrawingToolkitsPopOverUtils INSTANCE = new DrawingToolkitsPopOverUtils();
    private static final int POSITION_AUTO = 0;
    private static final int POSITION_CENTER = 2;
    private static final int POSITION_END = 3;
    private static final int POSITION_LANDSCAPE = 0;
    private static final int POSITION_PORTRAIT = 1;
    private static final int POSITION_START = 1;
    private static final int THRESHOLD_FOR_LARGE_SCREEN = 600;
    private static final int TOP_MARGIN_FOLD = 3;
    private static final int TOP_MARGIN_TABLET = 7;
    private static final int WIDTH_FOLD = 0;
    private static final int WIDTH_TABLET = 4;

    @NotNull
    private static final String WINDOWING_MODE_FREEFORM = "freeform";

    @NotNull
    private static final String WINDOWING_MODE_KEY = "mWindowingMode";

    @NotNull
    private static final String WINDOWING_MODE_SPLIT_SCREEN = "multi-window";

    private DrawingToolkitsPopOverUtils() {
    }

    @RequiresApi(30)
    private final boolean canSupportPopOver(Context context) {
        return getSmallestScreenWidthDp(context) >= 600 && !isMultiWindowMode(context);
    }

    @RequiresApi(30)
    private final Point getContentSize(Context context) {
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        return getContentSizeByWindowMetrics((WindowManager) systemService);
    }

    @RequiresApi(30)
    private final Point getContentSizeByWindowMetrics(WindowManager windowManager) {
        Insets insetsIgnoringVisibility = windowManager.getCurrentWindowMetrics().getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.navigationBars() | WindowInsets.Type.displayCutout());
        Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility, "getInsetsIgnoringVisibility(...)");
        int i = insetsIgnoringVisibility.right + insetsIgnoringVisibility.left;
        int i2 = insetsIgnoringVisibility.bottom + insetsIgnoringVisibility.top;
        Rect bounds = windowManager.getCurrentWindowMetrics().getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        int iWidth = bounds.width() - i;
        int rotation = windowManager.getDefaultDisplay().getRotation();
        if (rotation == 0 || rotation == 2) {
            iWidth += i;
        }
        return new Point(iWidth, bounds.height() - i2);
    }

    private final Bundle getPopOverDetails(Context context, int positionVertical, int positionHorizontal, int centerX, int centerY) {
        List<String> sizeArray = getSizeArray(context);
        List<String> list = sizeArray;
        if (list == null || list.isEmpty()) {
            return null;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        Point[] pointArr = new Point[2];
        boolean zIsFoldableModel = DeviceUtils.isFoldableModel();
        int i = Integer.parseInt(zIsFoldableModel ? sizeArray.get(0) : sizeArray.get(4));
        int i2 = Integer.parseInt(zIsFoldableModel ? sizeArray.get(1) : sizeArray.get(5));
        int i4 = Integer.parseInt(zIsFoldableModel ? sizeArray.get(2) : sizeArray.get(6));
        int i5 = Integer.parseInt(sizeArray.get(zIsFoldableModel ? 3 : 7));
        iArr[1] = i;
        iArr[0] = i;
        iArr2[1] = i2;
        iArr2[0] = i2;
        Point point = new Point(i4, i5);
        pointArr[1] = point;
        pointArr[0] = point;
        int position = getPosition(context, positionVertical, positionHorizontal, centerX, centerY);
        int[] iArr3 = {position, position};
        ActivityOptions activityOptionsMakeBasic = ActivityOptions.makeBasic();
        activityOptionsMakeBasic.semSetPopOverOptions(iArr, iArr2, pointArr, iArr3);
        return activityOptionsMakeBasic.toBundle();
    }

    public static /* synthetic */ Bundle getPopOverDetails$default(DrawingToolkitsPopOverUtils drawingToolkitsPopOverUtils, Context context, int i, int i2, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i = 0;
        }
        if ((i6 & 4) != 0) {
            i2 = 0;
        }
        if ((i6 & 8) != 0) {
            i4 = 0;
        }
        if ((i6 & 16) != 0) {
            i5 = 0;
        }
        return drawingToolkitsPopOverUtils.getPopOverDetails(context, i, i2, i4, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int getPosition(Context context, int vertical, int horizontal, int centerX, int centerY) {
        int i;
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        int i4 = context.getResources().getDisplayMetrics().heightPixels;
        if (vertical == 1) {
            i = 1;
        } else {
            i = 4;
            if (vertical != 2) {
                if (vertical != 3) {
                    if (vertical != 0 || centerY <= 0 || centerY >= i4 / 3) {
                        if (vertical != 0 || centerY <= 0 || centerY >= (i4 * 2) / 3) {
                            i = 2;
                        }
                    }
                }
            }
        }
        int i5 = 16;
        if (horizontal != 1) {
            if (horizontal != 2) {
                if (horizontal != 3) {
                    if (horizontal != 0 || centerX <= 0 || centerX >= i2 / 3) {
                        i5 = (horizontal != 0 || centerX <= 0 || centerX >= (i2 * 2) / 3) ? 32 : 64;
                    }
                }
            }
        }
        return i5 | i;
    }

    private final List<String> getSizeArray(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        String string;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(Features.PACKAGE_NAME_SKETCH_BOOK, 128);
            if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (bundle = applicationInfo.metaData) == null || (string = bundle.getString("popoverToolkitSize")) == null) {
                return null;
            }
            return StringsKt__StringsKt.split$default(string, new String[]{","}, false, 0, 6, (Object) null);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @RequiresApi(30)
    private final int getSmallestScreenWidthDp(Context context) {
        Point contentSize = getContentSize(context);
        return (int) (Math.min(contentSize.x, contentSize.y) / context.getResources().getDisplayMetrics().density);
    }

    private final Intent getStudioTypeBaseIntent(Context context, DrawingAssistTypePopupWindow.StudioType studioType) {
        Intent intent = new Intent(Constant.DRAWING_TOOLKIT_START_DESIGN_STUDIO);
        intent.setPackage(Features.PACKAGE_NAME_SKETCH_BOOK);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra(Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE, Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_DONE);
        intent.putExtra(Constant.DRAWING_TOOLKIT_KEY_NEED_WATERMARK, "true");
        intent.putExtra(Constant.DRAWING_TOOLKIT_KEY_PACKAGE_INFO, context.getPackageName());
        intent.putExtra(Constant.DRAWING_TOOLKIT_KEY_STUDIO_TYPE, studioType.getStr());
        return intent;
    }

    private final Intent getTextBaseIntent(Context context, String text) {
        Intent intent = new Intent(Constant.DRAWING_TOOLKIT_ACTION_GET_CONTENT);
        intent.setPackage(Features.PACKAGE_NAME_SKETCH_BOOK);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("type", "text");
        intent.putExtra(Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE, Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_DONE);
        intent.putExtra(Constant.DRAWING_TOOLKIT_KEY_REQUEST_TYPE_TEXT_DESCRIPTION_TEXT, text);
        intent.putExtra(Constant.DRAWING_TOOLKIT_KEY_PACKAGE_INFO, context.getPackageName());
        return intent;
    }

    private final Intent getUriBaseIntent(Context context, Uri uri, String mimeType) {
        context.grantUriPermission(Features.PACKAGE_NAME_SKETCH_BOOK, uri, 1);
        if (Intrinsics.areEqual(mimeType, com.samsung.android.support.senl.p148nt.base.common.constants.Constants.MIME_IMAGE)) {
            Intent intent = new Intent(Constant.DRAWING_TOOLKIT_ACTION_GET_CONTENT);
            intent.setPackage(Features.PACKAGE_NAME_SKETCH_BOOK);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra(Constant.DRAWING_TOOLKIT_KEY_IMAGE_TYPE, uri);
            intent.putExtra("type", "image");
            intent.putExtra(Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE, Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_REPLACE);
            intent.putExtra(Constant.DRAWING_TOOLKIT_KEY_PACKAGE_INFO, context.getPackageName());
            intent.addFlags(1);
            intent.addFlags(2);
            return intent;
        }
        Intent intent2 = new Intent(Constant.DRAWING_TOOLKIT_ACTION_SEND);
        intent2.setPackage(Features.PACKAGE_NAME_SKETCH_BOOK);
        intent2.addCategory("android.intent.category.DEFAULT");
        intent2.setType(mimeType);
        intent2.putExtra("type", Constant.DRAWING_TOOLKIT_KEY_REQUEST_TYPE_SKETCH);
        intent2.putExtra(Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE, Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_REPLACE);
        intent2.putExtra("android.intent.extra.STREAM", uri);
        intent2.putExtra(Constant.DRAWING_TOOLKIT_KEY_PACKAGE_INFO, context.getPackageName());
        intent2.addFlags(1);
        return intent2;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.util.LinkedHashMap, java.util.Map] */
    private final boolean isMultiWindowMode(Context context) {
        String string = context.getResources().getConfiguration().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        List listSplit$default = StringsKt__StringsKt.split$default(string, new String[]{" "}, false, 0, 6, (Object) null);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = MapsKt.emptyMap();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listSplit$default) {
            if (StringsKt.m14162r((String) obj, WINDOWING_MODE_KEY)) {
                arrayList.add(obj);
            }
        }
        ?? linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.m13952k(arrayList)), 16));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            List listSplit$default2 = StringsKt__StringsKt.split$default((String) it.next(), new String[]{MarketingConstants.REFERRER_DELIMITER_U003D}, false, 0, 6, (Object) null);
            Pair pairM13893to = TuplesKt.m13893to((String) listSplit$default2.get(0), (String) listSplit$default2.get(1));
            linkedHashMap.put(pairM13893to.getFirst(), pairM13893to.getSecond());
        }
        objectRef.element = linkedHashMap;
        return Intrinsics.areEqual(linkedHashMap.get(WINDOWING_MODE_KEY), WINDOWING_MODE_SPLIT_SCREEN) || Intrinsics.areEqual(((Map) objectRef.element).get(WINDOWING_MODE_KEY), WINDOWING_MODE_FREEFORM);
    }

    public final void showDrawingToolkitsPopOver(@NotNull Activity activity, @NotNull String text, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(text, "text");
        showDrawingToolkitsPopOver(activity, getTextBaseIntent(activity, text), requestCode);
    }

    public final void showDrawingToolkitsStudio(@NotNull Activity activity, @NotNull DrawingAssistTypePopupWindow.StudioType studioType, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(studioType, "studioType");
        showDrawingToolkitsPopOver(activity, getStudioTypeBaseIntent(activity, studioType), requestCode);
    }

    public final void showDrawingToolkitsPopOver(@NotNull Activity activity, @NotNull Uri uri, @NotNull String mimeType, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        showDrawingToolkitsPopOver(activity, getUriBaseIntent(activity, uri, mimeType), requestCode);
    }

    private final void showDrawingToolkitsPopOver(Activity activity, Intent intent, int requestCode) {
        if (Build.VERSION.SDK_INT >= 30 ? canSupportPopOver(activity) : false) {
            activity.startActivityForResult(intent, requestCode, getPopOverDetails(activity, 2, 2, 0, 0));
        } else {
            activity.startActivityForResult(intent, requestCode);
        }
    }
}
