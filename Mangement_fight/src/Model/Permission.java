package Model;

public class Permission {
	    private String roleID;
	    private String roleName;
	    private String permissionCode;

	    // Constructor

	    public Permission() {
			super();
			// TODO Auto-generated constructor stub
		}


		// Getters and setters
	    public String getRoleID() {
	        return roleID;
	    }

	    public void setRoleID(String roleID) {
	        this.roleID = roleID;
	    }

	    public String getRoleName() {
	        return roleName;
	    }

	    public void setRoleName(String roleName) {
	        this.roleName = roleName;
	    }

	    public String getPermissionCode() {
	        return permissionCode;
	    }

	    public void setPermissionCode(String permissionCode) {
	        this.permissionCode = permissionCode;
	    }
}
