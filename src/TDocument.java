import java.io.IOException;
import java.util.Objects;

import com.itextpdf.text.DocumentException;

public class TDocument extends TDocumentElement{

    public String title;
    public String backgroundColor;
    public String textColor;
    public String linkColor;
    public String vLink;
    public String aLink;
    public int columnCount;

    public TDocument(int columnCount) {
        this.columnCount = columnCount;
        this.title = "Default Title";
    }

    public TDocument(String value) {
        if(Objects.nonNull(value)) {
            this.title = value;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getLinkColor() {
        return linkColor;
    }

    public void setLinkColor(String linkColor) {
        this.linkColor = linkColor;
    }

    public String getvLink() {
        return vLink;
    }

    public void setvLink(String vLink) {
        this.vLink = vLink;
    }

    public String getaLink() {
        return aLink;
    }

    public void setaLink(String aLink) {
        this.aLink = aLink;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    @Override
    public void accept(IDocumentVisitor documentVisitor) throws DocumentException, IOException {
        documentVisitor.visit(this);
    }
}
