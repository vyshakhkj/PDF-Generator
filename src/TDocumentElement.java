import static java.util.Objects.nonNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.DocumentException;

public abstract class TDocumentElement {

    public enum ALIGNMENT { LEFT, CENTER, RIGHT, TOP, MIDDLE, BOTTOM, HEADING, DATA };
    public enum HEADING { H1, H2, H3, H5, H6 };
    public enum LIST_TYPE {UL, OL, MENU, DIR };

    public List<TDocumentElement> documentElements;
    public String backgroundColor;
    public ALIGNMENT align;

    public abstract void accept(IDocumentVisitor documentVisitor) throws DocumentException, IOException;

    public TDocumentElement() {
        documentElements = new ArrayList<TDocumentElement>(5);
        this.align = ALIGNMENT.LEFT;
        this.backgroundColor = "0xFF000000L";
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public ALIGNMENT getAlign() {
        return align;
    }

    public void setAlign(ALIGNMENT align) {
        this.align = align;
    }

    public void addObject(TDocumentElement value) {
        if(nonNull(value)) {
            documentElements.add(value);
        }
    }

    public boolean removeObjects(TDocumentElement value) {
        if(nonNull(value)) {
            documentElements.remove(value);
            return true;
        }
        return false;
    }

    public List<TDocumentElement> getDocumentElements() {
        return documentElements;
    }

    public void setDocumentElements(List<TDocumentElement> documentElements) {
        this.documentElements = documentElements;
    }
}
