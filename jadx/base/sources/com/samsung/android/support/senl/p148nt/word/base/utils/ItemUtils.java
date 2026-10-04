package com.samsung.android.support.senl.p148nt.word.base.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.document.SpenObjectLink;
import com.samsung.android.spr.drawable.Spr;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FontUtils;
import com.samsung.android.support.senl.p148nt.word.C11566R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JD\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\rH\u0007J$\u0010!\u001a\u0004\u0018\u00010\u00172\b\u0010\"\u001a\u0004\u0018\u00010\u00172\u0006\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010%J&\u0010&\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\r2\u0006\u0010 \u001a\u00020\rJ\u0018\u0010*\u001a\u00020+2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\rH\u0002J@\u0010,\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\r2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0003J,\u00103\u001a\u0002042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u00010\u001b2\u0006\u00106\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u00067"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/base/utils/ItemUtils;", "", "<init>", "()V", "HEIGHT_VOICE", "", "WIDTH_IMAGE", "WIDTH_LAYOUT", "SIZE_TITLE", "SIZE_TIME", "MARGIN_LEFT_VOICE", "MARGIN_BOTTOM_VOICE", "MARGIN_LEFT_RIGHT_PLAYICON_VOICE", "", "MARGIN_TOP_BOTTOM_PLAYICON_VOICE", "MARGIN_TITLE_RIGHT_MARGIN", "HEIGHT_WEB", "SIZE_BODY", "MARGIN_LEFT_WEB", "PADDING_LEFT_BOTTOM_TEXT_WEB", "PADDING_TOP_RIGHT_TEXT_WEB", "RADIUS_ROUNDED_CORNER_WEB", "drawVoice", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "title", "", "time", "textSize", "titleColor", "borderColor", "widthNote", "processBitmap", "source", "degrees", "cropRect", "Landroid/graphics/Rect;", "drawLink", "spenObjectlink", "Lcom/samsung/android/sdk/pen/document/SpenObjectLink;", "contentTextSize", "createTextLayout", "Landroid/widget/LinearLayout;", "createBitmap", "heightWeb", "textLayout", "mThumbnail", "Landroid/widget/ImageView;", "rx", "ry", "getTextView", "Landroid/widget/TextView;", "text", "color", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ItemUtils {
    private static final float HEIGHT_VOICE = 0.185f;
    private static final float HEIGHT_WEB = 0.245f;

    @NotNull
    public static final ItemUtils INSTANCE = new ItemUtils();
    private static final float MARGIN_BOTTOM_VOICE = 0.45f;
    private static final int MARGIN_LEFT_RIGHT_PLAYICON_VOICE = 6;
    private static final float MARGIN_LEFT_VOICE = 1.875f;
    private static final float MARGIN_LEFT_WEB = 1.25f;
    private static final int MARGIN_TITLE_RIGHT_MARGIN = 20;
    private static final int MARGIN_TOP_BOTTOM_PLAYICON_VOICE = 4;
    private static final int PADDING_LEFT_BOTTOM_TEXT_WEB = 10;
    private static final int PADDING_TOP_RIGHT_TEXT_WEB = 5;
    private static final int RADIUS_ROUNDED_CORNER_WEB = 50;
    private static final float SIZE_BODY = 1.25f;
    private static final float SIZE_TIME = 1.25f;
    private static final float SIZE_TITLE = 1.65f;
    private static final float WIDTH_IMAGE = 2.25f;
    private static final float WIDTH_LAYOUT = 3.75f;

    private ItemUtils() {
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final Bitmap createBitmap(Context context, int widthNote, int heightWeb, LinearLayout textLayout, ImageView mThumbnail, float rx, float ry) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(widthNote, heightWeb));
        linearLayout.setForeground(context.getDrawable(C11566R.drawable.background_web));
        if (LocaleUtils.isRTLMode()) {
            linearLayout.addView(textLayout);
            linearLayout.addView(mThumbnail);
        } else {
            linearLayout.addView(mThumbnail);
            linearLayout.addView(textLayout);
        }
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(widthNote, 1073741824), View.MeasureSpec.makeMeasureSpec(heightWeb, 1073741824));
        linearLayout.layout(0, 0, widthNote, heightWeb);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(widthNote, heightWeb, Bitmap.Config.ARGB_8888);
        Canvas canvasM4740a = AbstractC6670b.m4740a(bitmapCreateBitmap, "createBitmap(...)", bitmapCreateBitmap);
        Path path = new Path();
        path.addRoundRect(new RectF(0.0f, 0.0f, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight()), 50.0f, 50.0f, Path.Direction.CW);
        canvasM4740a.clipPath(path);
        linearLayout.draw(canvasM4740a);
        return bitmapCreateBitmap;
    }

    private final LinearLayout createTextLayout(Context context, int contentTextSize) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i = (int) (contentTextSize * 1.25f);
        layoutParams.setMargins(i, 0, i, 0);
        layoutParams.gravity = 16;
        layoutParams.weight = 1.0f;
        if (LocaleUtils.isRTLMode()) {
            layoutParams.gravity = 16;
            layoutParams.setMargins(contentTextSize, 0, 0, 0);
        }
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    private final TextView getTextView(Context context, float textSize, String text, int color) {
        TextView textView = new TextView(context);
        FontUtils.setFont(textView, "Roboto_Regular");
        textView.setPadding(10, 5, 5, 10);
        textView.setTextSize(0, textSize);
        textView.setTextColor(color);
        textView.setText(text);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(1);
        return textView;
    }

    @NotNull
    public final Bitmap drawLink(@NotNull Context context, @NotNull SpenObjectLink spenObjectlink, int contentTextSize, int widthNote) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(spenObjectlink, "spenObjectlink");
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(spenObjectlink.getThumbnailPath());
        int i = (int) (widthNote * HEIGHT_WEB);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageBitmap(bitmapDecodeFile);
        LinearLayout linearLayoutCreateTextLayout = createTextLayout(context, contentTextSize);
        float f = contentTextSize;
        TextView textView = getTextView(context, 1.65f * f, spenObjectlink.getTitle(), context.getColor(C11566R.color.web_title));
        textView.setTypeface(null, 1);
        linearLayoutCreateTextLayout.addView(textView);
        float f4 = f * 1.25f;
        linearLayoutCreateTextLayout.addView(getTextView(context, f4, spenObjectlink.getBody(), context.getColor(C11566R.color.web_body)));
        linearLayoutCreateTextLayout.addView(getTextView(context, f4, spenObjectlink.getOption(), context.getColor(C11566R.color.web_url)));
        return createBitmap(context, widthNote, i, linearLayoutCreateTextLayout, imageView, 50.0f, 50.0f);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    @NotNull
    public final Bitmap drawVoice(@NotNull Context context, @Nullable String title, @Nullable String time, int textSize, int titleColor, int borderColor, int widthNote) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i = (int) (widthNote * HEIGHT_VOICE);
        float f = textSize;
        int i2 = (int) (2.25f * f);
        int i4 = (int) (WIDTH_LAYOUT * f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        layoutParams.gravity = 16;
        if (LocaleUtils.isRTLMode()) {
            layoutParams.setMargins((int) (f * MARGIN_LEFT_VOICE), 0, 0, 0);
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageDrawable(Spr.getDrawable(context.getResources(), C11566R.drawable.memo_voice_btn_ic_play, null));
        imageView.setColorFilter(-16777216);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(6, 4, 6, 4);
        TextView textView = new TextView(context);
        FontUtils.setFont(textView, "Roboto_Regular");
        textView.setTextSize(0, (int) (1.65f * f));
        textView.setTextColor(titleColor);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(1);
        textView.setText(title);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        if (LocaleUtils.isRTLMode()) {
            layoutParams2.gravity = 5;
            textView.setPadding(0, 0, 20, 0);
        }
        layoutParams2.setMargins(0, 0, 0, (int) (0.45f * f));
        textView.setLayoutParams(layoutParams2);
        TextView textView2 = new TextView(context);
        FontUtils.setFont(textView2, "Roboto_Regular");
        textView2.setTextSize(0, (int) (1.25f * f));
        textView2.setTextColor(borderColor);
        textView2.setText(time);
        if (LocaleUtils.isRTLMode()) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 5;
            textView2.setLayoutParams(layoutParams3);
            textView2.setPadding(0, 0, 20, 0);
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        int i5 = (int) (f * MARGIN_LEFT_VOICE);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams((widthNote - i4) - i5, -2);
        if (LocaleUtils.isRTLMode()) {
            layoutParams4.gravity = 21;
            layoutParams4.setMargins(0, 0, i5, 0);
        } else {
            layoutParams4.gravity = 16;
            layoutParams4.setMargins(i5, 0, 0, 0);
        }
        linearLayout.setLayoutParams(layoutParams4);
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setGravity(16);
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(widthNote, i));
        linearLayout2.setBackground(context.getDrawable(C11566R.drawable.background_voice));
        linearLayout2.setForeground(context.getDrawable(C11566R.drawable.background_voice));
        linearLayout2.setBackgroundTintList(ColorStateList.valueOf(context.getColor(C11566R.color.voice_floating_bg)));
        if (LocaleUtils.isRTLMode()) {
            linearLayout2.addView(imageView);
            linearLayout2.addView(linearLayout);
        } else {
            linearLayout2.addView(linearLayout);
            linearLayout2.addView(imageView);
        }
        linearLayout2.measure(View.MeasureSpec.makeMeasureSpec(widthNote, 1073741824), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
        linearLayout2.layout(0, 0, widthNote, i);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(widthNote, i, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        linearLayout2.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    @Nullable
    public final Bitmap processBitmap(@Nullable Bitmap source, float degrees, @Nullable Rect cropRect) {
        if (source == null) {
            return null;
        }
        if (cropRect != null) {
            int i = cropRect.left;
            int i2 = cropRect.top;
            source = Bitmap.createBitmap(source, i, i2, cropRect.right - i, cropRect.bottom - i2);
            Intrinsics.checkNotNull(source);
        }
        if (degrees == 0.0f) {
            return source;
        }
        int iSqrt = (int) Math.sqrt((source.getHeight() * source.getHeight()) + (source.getWidth() * source.getWidth()));
        Bitmap.Config config = source.getConfig();
        Intrinsics.checkNotNull(config);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iSqrt, iSqrt, config);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Matrix matrix = new Matrix();
        matrix.setRotate(degrees, source.getWidth() / 2.0f, source.getHeight() / 2.0f);
        matrix.postTranslate((canvas.getWidth() / 2) - (source.getWidth() / 2), (canvas.getHeight() / 2) - (source.getHeight() / 2));
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(source, matrix, paint);
        return bitmapCreateBitmap;
    }
}
