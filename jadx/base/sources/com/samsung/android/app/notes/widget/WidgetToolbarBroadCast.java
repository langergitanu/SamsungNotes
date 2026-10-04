package com.samsung.android.app.notes.widget;

import android.content.Context;
import android.content.Intent;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bJV\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0013J$\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/WidgetToolbarBroadCast;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "sendUpdateWidgetToolbarBroadcast", "", "context", "Landroid/content/Context;", "widgetId", "", "transparency", "backgroundColor", "darkMode", "sendUpdateWidgetCreatorBroadcast", "listItems", "", "matchSetting", "", "backgroundShape", "backgroundOnOff", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetToolbarBroadCast {
    public static final int $stable = 0;

    @NotNull
    public static final WidgetToolbarBroadCast INSTANCE = new WidgetToolbarBroadCast();

    @NotNull
    private static final String TAG = "WidgetToolbarBroadCast";

    private WidgetToolbarBroadCast() {
    }

    public final void sendUpdateWidgetCreatorBroadcast(@NotNull Context context, int widgetId, int transparency, int backgroundColor, int darkMode, @Nullable List<Integer> listItems, boolean matchSetting, int backgroundShape, boolean backgroundOnOff) {
        Intrinsics.checkNotNullParameter(context, "context");
        String packageName = context.getPackageName();
        StringBuilder sb = new StringBuilder();
        sb.append(packageName);
        sb.append(" : sendUpdateWidgetToolbarBroadcast - widgetId | ");
        sb.append(widgetId);
        sb.append(" backgroundColor : ");
        sb.append(backgroundColor);
        AbstractC0622a.m1180z(sb, darkMode, backgroundShape, " darkMode : ", " shape : ");
        sb.append(" matchSetting : ");
        sb.append(matchSetting);
        sb.append(" backgroundOnOff : ");
        sb.append(backgroundOnOff);
        Logger.m8697d(TAG, sb.toString());
        Intent intent = new Intent(BaseWidgetConstant.ACTION_UPDATE_TOOLBAR);
        intent.setPackage(context.getPackageName());
        if (transparency != -1) {
            intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, transparency);
        }
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, widgetId);
        if (backgroundColor != -1) {
            intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR, backgroundColor);
        }
        if (darkMode != -1) {
            intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE, darkMode);
        }
        List<Integer> list = listItems;
        if (list != null && !list.isEmpty()) {
            intent.putIntegerArrayListExtra(BaseWidgetConstant.KEY_SELECTED_ITEMS, new ArrayList<>(list));
        }
        intent.putExtra(BaseWidgetConstant.KEY_WIDGET_MATCH_SETTING, matchSetting);
        intent.putExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE, backgroundShape);
        intent.putExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF, backgroundOnOff);
        context.sendBroadcast(intent);
    }

    public final void sendUpdateWidgetToolbarBroadcast(@NotNull Context context, int widgetId, int transparency, int backgroundColor, int darkMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Logger.m8697d(TAG, context.getPackageName() + " : sendUpdateWidgetToolbarBroadcast - widgetId | " + widgetId + " backgroundColor : " + backgroundColor + " darkMode : " + darkMode);
        Intent intent = new Intent(BaseWidgetConstant.ACTION_UPDATE_TOOLBAR);
        intent.setPackage(context.getPackageName());
        if (transparency != -1) {
            intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, transparency);
        }
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, widgetId);
        if (backgroundColor != -1) {
            intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR, backgroundColor);
        }
        if (darkMode != -1) {
            intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE, darkMode);
        }
        context.sendBroadcast(intent);
    }

    public final void sendUpdateWidgetCreatorBroadcast(@NotNull Context context, int widgetId, @NotNull List<Integer> listItems) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listItems, "listItems");
        List<Integer> list = listItems;
        Logger.m8697d(TAG, context.getPackageName() + " : sendUpdateWidgetToolbarBroadcast - widgetId | " + widgetId + ", listItems : " + new ArrayList(list));
        Intent intent = new Intent(BaseWidgetConstant.ACTION_UPDATE_TOOLBAR);
        intent.setPackage(context.getPackageName());
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, widgetId);
        intent.putIntegerArrayListExtra(BaseWidgetConstant.KEY_SELECTED_ITEMS, new ArrayList<>(list));
        context.sendBroadcast(intent);
    }
}
