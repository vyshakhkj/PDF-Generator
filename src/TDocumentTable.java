public class TDocumentTable extends TDocumentElement {
    public String caption;
    public int width;
    public int border;
    public int cellSpacing;
    public int cellPadding;
    public boolean percentageWidth;
    public String bgColor;
    public int rowCount;

    public TDocumentTable() {
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getBorder() {
        return border;
    }

    public void setBorder(int border) {
        this.border = border;
    }

    public int getCellSpacing() {
        return cellSpacing;
    }

    public void setCellSpacing(int cellSpacing) {
        this.cellSpacing = cellSpacing;
    }

    public int getCellPadding() {
        return cellPadding;
    }

    public void setCellPadding(int cellPadding) {
        this.cellPadding = cellPadding;
    }

    public boolean isPercentageWidth() {
        return percentageWidth;
    }

    public void setPercentageWidth(boolean percentageWidth) {
        this.percentageWidth = percentageWidth;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public int getRowCount() {
        return this.documentElements.size();
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    @Override
    public void accept(IDocumentVisitor documentVisitor) {
        documentVisitor.visit(this);
    }
}
