package androidx.glance.appwidget;

import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b;\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;¨\u0006<"}, m13886d2 = {"Landroidx/glance/appwidget/LayoutType;", "", "(Ljava/lang/String;I)V", "Row", "Column", "Box", Bixby2Constants.SLOT_VALUE_SHARE_AS_TEXT, "List", "CheckBox", "CheckBoxBackport", "Button", "Frame", "LinearProgressIndicator", "CircularProgressIndicator", "VerticalGridOneColumn", "VerticalGridTwoColumns", "VerticalGridThreeColumns", "VerticalGridFourColumns", "VerticalGridFiveColumns", "VerticalGridAutoFit", "Swtch", "SwtchBackport", "ImageCrop", "ImageFit", "ImageFillBounds", "ImageCropDecorative", "ImageFitDecorative", "ImageFillBoundsDecorative", "RadioButton", "RadioButtonBackport", "RadioRow", "RadioColumn", "ArcProgressIndicatorLarge", "ArcProgressIndicatorMedium", "ArcProgressIndicatorSmall", "CircularProgressIndicatorLarge", "CircularProgressIndicatorMedium", "CircularProgressIndicatorSmall", "ImageButtonCrop", "ImageButtonFit", "ImageButtonFillBounds", "ImageButtonCropDecorative", "ImageButtonFitDecorative", "ImageButtonFillBoundsDecorative", "LinearProgressIndicatorDeterminate", "StackedProgressIndicator", "TextFirstStrong", "TextAutoSize", "TextDisplay", "TextTitle", "TextBody", "TextDescription", "TextLabel", "FrameWeight1", "FrameWeight2", "FrameWeight3", "FrameWeight4", "FrameWeight5", "FrameWeight45", "FrameWeight55", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class LayoutType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LayoutType[] $VALUES;
    public static final LayoutType Row = new LayoutType("Row", 0);
    public static final LayoutType Column = new LayoutType("Column", 1);
    public static final LayoutType Box = new LayoutType("Box", 2);
    public static final LayoutType Text = new LayoutType(Bixby2Constants.SLOT_VALUE_SHARE_AS_TEXT, 3);
    public static final LayoutType List = new LayoutType("List", 4);
    public static final LayoutType CheckBox = new LayoutType("CheckBox", 5);
    public static final LayoutType CheckBoxBackport = new LayoutType("CheckBoxBackport", 6);
    public static final LayoutType Button = new LayoutType("Button", 7);
    public static final LayoutType Frame = new LayoutType("Frame", 8);
    public static final LayoutType LinearProgressIndicator = new LayoutType("LinearProgressIndicator", 9);
    public static final LayoutType CircularProgressIndicator = new LayoutType("CircularProgressIndicator", 10);
    public static final LayoutType VerticalGridOneColumn = new LayoutType("VerticalGridOneColumn", 11);
    public static final LayoutType VerticalGridTwoColumns = new LayoutType("VerticalGridTwoColumns", 12);
    public static final LayoutType VerticalGridThreeColumns = new LayoutType("VerticalGridThreeColumns", 13);
    public static final LayoutType VerticalGridFourColumns = new LayoutType("VerticalGridFourColumns", 14);
    public static final LayoutType VerticalGridFiveColumns = new LayoutType("VerticalGridFiveColumns", 15);
    public static final LayoutType VerticalGridAutoFit = new LayoutType("VerticalGridAutoFit", 16);
    public static final LayoutType Swtch = new LayoutType("Swtch", 17);
    public static final LayoutType SwtchBackport = new LayoutType("SwtchBackport", 18);
    public static final LayoutType ImageCrop = new LayoutType("ImageCrop", 19);
    public static final LayoutType ImageFit = new LayoutType("ImageFit", 20);
    public static final LayoutType ImageFillBounds = new LayoutType("ImageFillBounds", 21);
    public static final LayoutType ImageCropDecorative = new LayoutType("ImageCropDecorative", 22);
    public static final LayoutType ImageFitDecorative = new LayoutType("ImageFitDecorative", 23);
    public static final LayoutType ImageFillBoundsDecorative = new LayoutType("ImageFillBoundsDecorative", 24);
    public static final LayoutType RadioButton = new LayoutType("RadioButton", 25);
    public static final LayoutType RadioButtonBackport = new LayoutType("RadioButtonBackport", 26);
    public static final LayoutType RadioRow = new LayoutType("RadioRow", 27);
    public static final LayoutType RadioColumn = new LayoutType("RadioColumn", 28);
    public static final LayoutType ArcProgressIndicatorLarge = new LayoutType("ArcProgressIndicatorLarge", 29);
    public static final LayoutType ArcProgressIndicatorMedium = new LayoutType("ArcProgressIndicatorMedium", 30);
    public static final LayoutType ArcProgressIndicatorSmall = new LayoutType("ArcProgressIndicatorSmall", 31);
    public static final LayoutType CircularProgressIndicatorLarge = new LayoutType("CircularProgressIndicatorLarge", 32);
    public static final LayoutType CircularProgressIndicatorMedium = new LayoutType("CircularProgressIndicatorMedium", 33);
    public static final LayoutType CircularProgressIndicatorSmall = new LayoutType("CircularProgressIndicatorSmall", 34);
    public static final LayoutType ImageButtonCrop = new LayoutType("ImageButtonCrop", 35);
    public static final LayoutType ImageButtonFit = new LayoutType("ImageButtonFit", 36);
    public static final LayoutType ImageButtonFillBounds = new LayoutType("ImageButtonFillBounds", 37);
    public static final LayoutType ImageButtonCropDecorative = new LayoutType("ImageButtonCropDecorative", 38);
    public static final LayoutType ImageButtonFitDecorative = new LayoutType("ImageButtonFitDecorative", 39);
    public static final LayoutType ImageButtonFillBoundsDecorative = new LayoutType("ImageButtonFillBoundsDecorative", 40);
    public static final LayoutType LinearProgressIndicatorDeterminate = new LayoutType("LinearProgressIndicatorDeterminate", 41);
    public static final LayoutType StackedProgressIndicator = new LayoutType("StackedProgressIndicator", 42);
    public static final LayoutType TextFirstStrong = new LayoutType("TextFirstStrong", 43);
    public static final LayoutType TextAutoSize = new LayoutType("TextAutoSize", 44);
    public static final LayoutType TextDisplay = new LayoutType("TextDisplay", 45);
    public static final LayoutType TextTitle = new LayoutType("TextTitle", 46);
    public static final LayoutType TextBody = new LayoutType("TextBody", 47);
    public static final LayoutType TextDescription = new LayoutType("TextDescription", 48);
    public static final LayoutType TextLabel = new LayoutType("TextLabel", 49);
    public static final LayoutType FrameWeight1 = new LayoutType("FrameWeight1", 50);
    public static final LayoutType FrameWeight2 = new LayoutType("FrameWeight2", 51);
    public static final LayoutType FrameWeight3 = new LayoutType("FrameWeight3", 52);
    public static final LayoutType FrameWeight4 = new LayoutType("FrameWeight4", 53);
    public static final LayoutType FrameWeight5 = new LayoutType("FrameWeight5", 54);
    public static final LayoutType FrameWeight45 = new LayoutType("FrameWeight45", 55);
    public static final LayoutType FrameWeight55 = new LayoutType("FrameWeight55", 56);

    private static final /* synthetic */ LayoutType[] $values() {
        return new LayoutType[]{Row, Column, Box, Text, List, CheckBox, CheckBoxBackport, Button, Frame, LinearProgressIndicator, CircularProgressIndicator, VerticalGridOneColumn, VerticalGridTwoColumns, VerticalGridThreeColumns, VerticalGridFourColumns, VerticalGridFiveColumns, VerticalGridAutoFit, Swtch, SwtchBackport, ImageCrop, ImageFit, ImageFillBounds, ImageCropDecorative, ImageFitDecorative, ImageFillBoundsDecorative, RadioButton, RadioButtonBackport, RadioRow, RadioColumn, ArcProgressIndicatorLarge, ArcProgressIndicatorMedium, ArcProgressIndicatorSmall, CircularProgressIndicatorLarge, CircularProgressIndicatorMedium, CircularProgressIndicatorSmall, ImageButtonCrop, ImageButtonFit, ImageButtonFillBounds, ImageButtonCropDecorative, ImageButtonFitDecorative, ImageButtonFillBoundsDecorative, LinearProgressIndicatorDeterminate, StackedProgressIndicator, TextFirstStrong, TextAutoSize, TextDisplay, TextTitle, TextBody, TextDescription, TextLabel, FrameWeight1, FrameWeight2, FrameWeight3, FrameWeight4, FrameWeight5, FrameWeight45, FrameWeight55};
    }

    static {
        LayoutType[] layoutTypeArr$values = $values();
        $VALUES = layoutTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(layoutTypeArr$values);
    }

    private LayoutType(String str, int i) {
    }

    @NotNull
    public static EnumEntries<LayoutType> getEntries() {
        return $ENTRIES;
    }

    public static LayoutType valueOf(String str) {
        return (LayoutType) Enum.valueOf(LayoutType.class, str);
    }

    public static LayoutType[] values() {
        return (LayoutType[]) $VALUES.clone();
    }
}
