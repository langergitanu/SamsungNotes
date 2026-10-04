package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Alignment;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Bold;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.FontBgColor;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.FontColor;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.FontSize;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Indent;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Italic;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Strikethrough;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Task;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.TextFormat;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Underline;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.span.BodyTextAlign;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.span.BodyTextFontSize;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.span.TableCellAlign;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.span.TableCellFontSize;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.span.TextBoxAlign;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.span.TextBoxFontSize;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SpanStates extends com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates {
    private IContract contract;
    protected TableCellAlign tableCellAlign;
    protected TableCellFontSize tableCellFontSize;
    protected TextBoxAlign textBoxAlign;
    protected TextBoxFontSize textBoxFontSize;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private BodyTextAlign bodyTextAlign;
        private BodyTextFontSize bodyTextFontSize;
        private Bold bold;
        private IContract contract;
        private FontBgColor fontBgColor;
        private FontColor fontColor;
        private Indent indent;
        private Italic italic;
        private Strikethrough strikethrough;
        private TableCellAlign tableCellAlign;
        private TableCellFontSize tableCellFontSize;
        private Task task;
        private TextBoxAlign textBoxAlign;
        private TextBoxFontSize textBoxFontSize;
        private TextFormat textFormat;
        private Underline underline;

        public Builder(IContract iContract) {
            this.contract = iContract;
        }

        public Builder align() {
            return bodyTextAlign().textBoxAlign().tableCellAlign();
        }

        public Builder bodyTextAlign() {
            this.bodyTextAlign = new BodyTextAlign();
            return this;
        }

        public Builder bodyTextFontSize(int i) {
            this.bodyTextFontSize = new BodyTextFontSize(i);
            return this;
        }

        public Builder bold() {
            this.bold = new Bold();
            return this;
        }

        public SpanStates build() {
            return new SpanStates(this, 0);
        }

        public Builder fontBgColor() {
            this.fontBgColor = new FontBgColor();
            return this;
        }

        public Builder fontColor(int i) {
            this.fontColor = new FontColor(i);
            return this;
        }

        public Builder fontSize(int i) {
            return bodyTextFontSize(i).textBoxFontSize(i).tableCellFontSize(i);
        }

        public Builder indent() {
            this.indent = new Indent(16);
            return this;
        }

        public Builder italic() {
            this.italic = new Italic();
            return this;
        }

        public Builder strikethrough() {
            this.strikethrough = new Strikethrough();
            return this;
        }

        public Builder tableCellAlign() {
            this.tableCellAlign = new TableCellAlign();
            return this;
        }

        public Builder tableCellFontSize(int i) {
            this.tableCellFontSize = new TableCellFontSize(i);
            return this;
        }

        public Builder task() {
            this.task = new Task();
            return this;
        }

        public Builder textBoxAlign() {
            this.textBoxAlign = new TextBoxAlign();
            return this;
        }

        public Builder textBoxFontSize(int i) {
            this.textBoxFontSize = new TextBoxFontSize(i);
            return this;
        }

        public Builder textFormat() {
            this.textFormat = new TextFormat();
            return this;
        }

        public Builder underline() {
            this.underline = new Underline();
            return this;
        }

        public Builder align(int i) {
            return bodyTextAlign(i).textBoxAlign(i).tableCellAlign(i);
        }

        public Builder bodyTextAlign(int i) {
            this.bodyTextAlign = new BodyTextAlign(i);
            return this;
        }

        public Builder bodyTextFontSize(int i, int i2) {
            this.bodyTextFontSize = new BodyTextFontSize(i, i2);
            return this;
        }

        public Builder bold(boolean z) {
            this.bold = new Bold(z);
            return this;
        }

        public Builder fontBgColor(int i) {
            this.fontBgColor = new FontBgColor(i);
            return this;
        }

        public Builder fontSize(int i, int i2) {
            return bodyTextFontSize(i, i2).textBoxFontSize(i, i2).tableCellFontSize(i, i2);
        }

        public Builder indent(int i) {
            this.indent = new Indent(16, i);
            return this;
        }

        public Builder italic(boolean z) {
            this.italic = new Italic(z);
            return this;
        }

        public Builder strikethrough(boolean z) {
            this.strikethrough = new Strikethrough(z);
            return this;
        }

        public Builder tableCellAlign(int i) {
            this.tableCellAlign = new TableCellAlign(i);
            return this;
        }

        public Builder tableCellFontSize(int i, int i2) {
            this.tableCellFontSize = new TableCellFontSize(i, i2);
            return this;
        }

        public Builder task(int i) {
            this.task = new Task(i);
            return this;
        }

        public Builder textBoxAlign(int i) {
            this.textBoxAlign = new TextBoxAlign(i);
            return this;
        }

        public Builder textBoxFontSize(int i, int i2) {
            this.textBoxFontSize = new TextBoxFontSize(i, i2);
            return this;
        }

        public Builder underline(boolean z) {
            this.underline = new Underline(z);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IContract {
        boolean isSelectedBodyText();

        boolean isSelectedTable();
    }

    public /* synthetic */ SpanStates(Builder builder, int i) {
        this(builder);
    }

    public void clear() {
        Indent indent = this.indent;
        if (indent != null) {
            indent.setEnable(true);
        }
        Task task = this.task;
        if (task != null) {
            task.setEnable(true);
        }
        this.bodyTextFontSize.setEnable(false);
        this.textBoxFontSize.setEnable(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates
    @NonNull
    public Alignment getAlign() {
        return this.contract.isSelectedBodyText() ? this.bodyTextAlign : this.contract.isSelectedTable() ? this.tableCellAlign : this.textBoxAlign;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates
    @NonNull
    public FontSize getFontSize() {
        return this.contract.isSelectedBodyText() ? this.bodyTextFontSize : this.contract.isSelectedTable() ? this.tableCellFontSize : this.textBoxFontSize;
    }

    private SpanStates(Builder builder) {
        this.contract = builder.contract;
        this.bodyTextFontSize = builder.bodyTextFontSize;
        this.bodyTextAlign = builder.bodyTextAlign;
        this.textFormat = builder.textFormat;
        this.fontColor = builder.fontColor;
        this.fontBgColor = builder.fontBgColor;
        this.indent = builder.indent;
        this.task = builder.task;
        this.bold = builder.bold;
        this.italic = builder.italic;
        this.underline = builder.underline;
        this.strikethrough = builder.strikethrough;
        this.textBoxFontSize = builder.textBoxFontSize;
        this.textBoxAlign = builder.textBoxAlign;
        this.tableCellFontSize = builder.tableCellFontSize;
        this.tableCellAlign = builder.tableCellAlign;
        Indent indent = this.indent;
        if (indent != null) {
            indent.setEnable(true);
        }
        Task task = this.task;
        if (task != null) {
            task.setEnable(true);
        }
    }
}
