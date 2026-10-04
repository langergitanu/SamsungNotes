package com.samsung.android.sdk.pen.setting.colorpalette;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPageIndicator;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0000\u0018\u0000 42\u00020\u0001:\u000245B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0014J,\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u0012\u0010 \u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\u000eH\u0016J \u0010'\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0002J\u0018\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0018H\u0002J\u0010\u00100\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0002J\u0010\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0002J\u0010\u00103\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0018\u00010\fR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\"\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00066"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPageClipIndicator;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPageIndicator;", "context", "Landroid/content/Context;", "defaultIndicatorResources", "", "<init>", "(Landroid/content/Context;I)V", "mCurrent", "mActualCount", "mDefaultPadding", "mUpdateIndicatorInfo", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPageClipIndicator$SpenIndicatorInfo;", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPageIndicator$ActionListener;", "mSelfActionListener", "close", "", "setInfo", "size", "space", "count", "updateAllIndicatorDescription", "updateIndicator", "", "position", "background", "Landroid/graphics/drawable/Drawable;", "hoverDescription", "", "indicator", "Landroid/widget/ImageView;", "setActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "active", "getActive", "()I", "setActive", "(I)V", "updateIndicatorItemDescription", "current", ImportHandler.KEY_TOTAL, "needViewSliding", "nextStart", "nextEnd", "startIdx", "endIdx", "userDefineIndicator", TextConst.KEY_START_INDEX, TextConst.KEY_END_INDEX, "start", "init", "Companion", "SpenIndicatorInfo", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPageClipIndicator extends SpenPageIndicator {
    private static final int SHOW_INDICATOR_COUNT = 3;

    @NotNull
    private static final String TAG = "SpenMiniPageIndicator";

    @Nullable
    private SpenPageIndicator.ActionListener mActionListener;
    private int mActualCount;
    private int mCurrent;
    private int mDefaultPadding;

    @NotNull
    private final SpenPageIndicator.ActionListener mSelfActionListener;

    @Nullable
    private SpenIndicatorInfo mUpdateIndicatorInfo;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0002\u001a\u00020\u0003J\"\u0010 \u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPageClipIndicator$SpenIndicatorInfo;", "", "position", "", "size", "padding", "backgroundDrawable", "Landroid/graphics/drawable/Drawable;", "hoverCharSequence", "", "<init>", "(Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPageClipIndicator;IIILandroid/graphics/drawable/Drawable;Ljava/lang/CharSequence;)V", "getPosition", "()I", "setPosition", "(I)V", "getSize", "setSize", "getPadding", "setPadding", "getBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "getHoverCharSequence", "()Ljava/lang/CharSequence;", "setHoverCharSequence", "(Ljava/lang/CharSequence;)V", "close", "", "isSamePosition", "", Constants.ARG_UPDATE, "background", "hover", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class SpenIndicatorInfo {

        @Nullable
        private Drawable backgroundDrawable;

        @Nullable
        private CharSequence hoverCharSequence;
        private int padding;
        private int position;
        private int size;

        public SpenIndicatorInfo(int i, int i2, int i4, @Nullable Drawable drawable, @Nullable CharSequence charSequence) {
            this.position = i;
            this.size = i2;
            this.padding = i4;
            this.backgroundDrawable = drawable;
            this.hoverCharSequence = charSequence;
        }

        public final void close() {
            this.position = -1;
            this.backgroundDrawable = null;
            this.size = 0;
            this.padding = 0;
            this.hoverCharSequence = null;
        }

        @Nullable
        public final Drawable getBackgroundDrawable() {
            return this.backgroundDrawable;
        }

        @Nullable
        public final CharSequence getHoverCharSequence() {
            return this.hoverCharSequence;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final int getPosition() {
            return this.position;
        }

        public final int getSize() {
            return this.size;
        }

        public final boolean isSamePosition(int position) {
            return this.position == position;
        }

        public final void setBackgroundDrawable(@Nullable Drawable drawable) {
            this.backgroundDrawable = drawable;
        }

        public final void setHoverCharSequence(@Nullable CharSequence charSequence) {
            this.hoverCharSequence = charSequence;
        }

        public final void setPadding(int i) {
            this.padding = i;
        }

        public final void setPosition(int i) {
            this.position = i;
        }

        public final void setSize(int i) {
            this.size = i;
        }

        public final void update(int size, @Nullable Drawable background, @Nullable CharSequence hover) {
            this.size = size;
            this.backgroundDrawable = background;
            this.hoverCharSequence = hover;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPageClipIndicator(@NotNull Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSelfActionListener = new SpenPageIndicator.ActionListener() { // from class: com.samsung.android.sdk.pen.setting.colorpalette.SpenPageClipIndicator$mSelfActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPageIndicator.ActionListener
            public void onIndicatorClicked(int position) {
                SpenPageIndicator.ActionListener actionListener = this.this$0.mActionListener;
                if (actionListener != null) {
                    SpenPageClipIndicator spenPageClipIndicator = this.this$0;
                    actionListener.onIndicatorClicked(spenPageClipIndicator.startIndex(spenPageClipIndicator.mCurrent) + position);
                }
            }
        };
        init(context);
    }

    private final int endIndex(int start) {
        int i = start + 3;
        int i2 = this.mActualCount;
        return i >= i2 ? i2 - 1 : start + 2;
    }

    private final void init(Context context) {
        this.mUpdateIndicatorInfo = null;
        this.mDefaultPadding = context.getResources().getDimensionPixelSize(C7932R.dimen.mini_pen_setting_color_palette_page_clip_indicator_padding);
    }

    private final boolean needViewSliding(int nextStart, int nextEnd) {
        if (this.mActualCount <= 3) {
            return false;
        }
        int iStartIndex = startIndex(this.mCurrent);
        return (iStartIndex == nextStart && endIndex(iStartIndex) == nextEnd) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int startIndex(int current) {
        int i = current - 1;
        int i2 = this.mActualCount;
        if (i2 <= 3 || i < 0) {
            return 0;
        }
        return current + 1 >= i2 ? i2 - 3 : i;
    }

    private final void updateIndicatorItemDescription(int position, int current, int total) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4765z(new Object[]{Integer.valueOf(position), Integer.valueOf(current), Integer.valueOf(total)}, 3, "updateIndicatorItemDescription() position=%d, %d/%d", "format(format, *args)", TAG);
        ImageView indicatorView = getIndicatorView(position);
        if (indicatorView == null) {
            return;
        }
        setIndicatorDescription(indicatorView, current, total);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPageIndicator
    public void close() {
        super.close();
        SpenIndicatorInfo spenIndicatorInfo = this.mUpdateIndicatorInfo;
        if (spenIndicatorInfo != null) {
            spenIndicatorInfo.close();
        }
        this.mUpdateIndicatorInfo = null;
        this.mCurrent = 0;
        this.mActualCount = 0;
        this.mActionListener = null;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPageIndicator
    /* JADX INFO: renamed from: getActive, reason: from getter */
    public int getMCurrent() {
        return this.mCurrent;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPageIndicator
    public void setActionListener(@Nullable SpenPageIndicator.ActionListener listener) {
        this.mActionListener = listener;
        super.setActionListener(this.mSelfActionListener);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPageIndicator
    public void setActive(int i) {
        AbstractC6670b.m4744e(i, this.mActualCount, "SpenMiniPageIndicator::setActive() - position=", " actualCount=", TAG);
        if (i < 0 || i >= this.mActualCount) {
            AbstractC2322a.m1631u(i, "invalid position=", TAG);
            return;
        }
        int iStartIndex = startIndex(i);
        int iEndIndex = endIndex(iStartIndex);
        int mCurrent = super.getMCurrent();
        boolean zNeedViewSliding = needViewSliding(iStartIndex, iEndIndex);
        if (zNeedViewSliding) {
            updateIndicator(iStartIndex, iEndIndex);
        }
        int i2 = i - iStartIndex;
        setActive(i2, false);
        this.mCurrent = i;
        if (getIsSupportAction()) {
            if (zNeedViewSliding) {
                updateAllIndicatorDescription();
            } else {
                updateIndicatorItemDescription(mCurrent, iStartIndex + mCurrent + 1, this.mActualCount);
                updateIndicatorItemDescription(i2, this.mCurrent + 1, this.mActualCount);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPageIndicator
    public void setInfo(int size, int space, int count) {
        AbstractC2322a.m1631u(count, "SpenMiniPageIndicator::setInfo() count=", TAG);
        int iMin = (int) Math.min(count, 3.0d);
        this.mActualCount = count;
        this.mCurrent = 0;
        super.setInfo(size, space, iMin);
        for (int i = 0; i < iMin; i++) {
            ImageView indicatorView = getIndicatorView(i);
            if (indicatorView != null) {
                int i2 = this.mDefaultPadding;
                indicatorView.setPaddingRelative(i2, i2, i2, i2);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPageIndicator
    public void updateAllIndicatorDescription() {
        int iMin = (int) Math.min(this.mActualCount, 3.0d);
        int iStartIndex = startIndex(this.mCurrent);
        for (int i = 0; i < iMin; i++) {
            updateIndicatorItemDescription(i, iStartIndex + 1 + i, this.mActualCount);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPageIndicator
    public boolean updateIndicator(int position, int size, @Nullable Drawable background, @Nullable CharSequence hoverDescription) {
        int i;
        Log.i(TAG, "SpenMiniPageIndicator::updateIndicator()");
        SpenIndicatorInfo spenIndicatorInfo = this.mUpdateIndicatorInfo;
        if (spenIndicatorInfo == null) {
            i = position;
            this.mUpdateIndicatorInfo = new SpenIndicatorInfo(i, size, (getDefaultSize() - size) / 2, background, hoverDescription);
        } else {
            i = position;
            if (spenIndicatorInfo == null || spenIndicatorInfo.getPosition() != i) {
                Log.i(TAG, "Currently, Only one resource change is considered. (Additional confirmation is required for the case.)");
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                SpenIndicatorInfo spenIndicatorInfo2 = this.mUpdateIndicatorInfo;
                Integer numValueOf = spenIndicatorInfo2 != null ? Integer.valueOf(spenIndicatorInfo2.getPosition()) : null;
                SpenIndicatorInfo spenIndicatorInfo3 = this.mUpdateIndicatorInfo;
                Integer numValueOf2 = spenIndicatorInfo3 != null ? Integer.valueOf(spenIndicatorInfo3.getSize()) : null;
                SpenIndicatorInfo spenIndicatorInfo4 = this.mUpdateIndicatorInfo;
                AbstractC6670b.m4765z(new Object[]{numValueOf, numValueOf2, spenIndicatorInfo4 != null ? spenIndicatorInfo4.getHoverCharSequence() : null, Integer.valueOf(i), Integer.valueOf(size), hoverDescription}, 6, "[%d, %d, %s] -> [%d, %d, %s]", "format(format, *args)", TAG);
                return false;
            }
            SpenIndicatorInfo spenIndicatorInfo5 = this.mUpdateIndicatorInfo;
            if (spenIndicatorInfo5 != null) {
                spenIndicatorInfo5.update(size, background, hoverDescription);
            }
        }
        return updateIndicator(i, true);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPageIndicator
    public void updateIndicator(@NotNull ImageView indicator, @Nullable Drawable background, @Nullable CharSequence hoverDescription) {
        Intrinsics.checkNotNullParameter(indicator, "indicator");
        indicator.setImageDrawable(background);
        indicator.setBackground(null);
        setHoverDescription(indicator, hoverDescription);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateIndicator(int startIdx, int endIdx) {
        boolean z;
        int i = endIdx - startIdx;
        if (i < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            SpenIndicatorInfo spenIndicatorInfo = this.mUpdateIndicatorInfo;
            if (spenIndicatorInfo == null || spenIndicatorInfo == null) {
                z = false;
            } else {
                z = true;
                if (!spenIndicatorInfo.isSamePosition(startIdx + i2)) {
                }
            }
            updateIndicator(i2, z);
            if (i2 == i) {
                return;
            } else {
                i2++;
            }
        }
    }

    private final boolean updateIndicator(int position, boolean userDefineIndicator) {
        int padding;
        boolean zUpdateIndicator;
        SpenIndicatorInfo spenIndicatorInfo;
        if (!userDefineIndicator || (spenIndicatorInfo = this.mUpdateIndicatorInfo) == null) {
            padding = this.mDefaultPadding;
            zUpdateIndicator = super.updateIndicator(position, getDefaultSize(), getContext().getDrawable(getDefaultResId()), null);
        } else if (spenIndicatorInfo != null) {
            padding = spenIndicatorInfo.getPadding();
            zUpdateIndicator = super.updateIndicator(position, spenIndicatorInfo.getSize(), spenIndicatorInfo.getBackgroundDrawable(), spenIndicatorInfo.getHoverCharSequence());
        } else {
            zUpdateIndicator = false;
            padding = 0;
        }
        if (!zUpdateIndicator) {
            Log.i(TAG, "not update clipIndicator.");
            return false;
        }
        ImageView indicatorView = getIndicatorView(position);
        if (indicatorView == null) {
            return true;
        }
        indicatorView.setPaddingRelative(padding, padding, padding, padding);
        return true;
    }
}
