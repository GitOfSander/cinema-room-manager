public class Setting {
    private int rows = 8;

    private int columns = 8;

    public int getRows() {
        return rows;
    }

    public void setColumns(int columns) {
        if (columns == -1) return;
        this.columns = columns;
    }

    public int getColumns() {
        return columns;
    }

    public void setRows(int rows) {
        if (rows == -1) return;
        this.rows = rows;
    }
}
