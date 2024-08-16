package CustomUI.Table;


public interface TableActionEvent {

    public void onEdit(int row);

    public void onDelete(int row);
    
    public void onBookTicket(int row);
    
    public void onCancelTicket(int row);
}