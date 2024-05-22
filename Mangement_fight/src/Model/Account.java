package Model;

import java.sql.Date;

public class Account {
	private String accountID;
    private String name;
    private String password;
    private String phone;
    private String email;
    private Date created;
    private String roleID;
    private String permissionCode;
    private String roleName;

 // Constructor
    public Account(String accountID, String name, String password, String phone, String email, Date created, String roleID, String permissionCode, String roleName) {
        this.accountID = accountID;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.created = created;
        this.roleID = roleID;
        this.permissionCode = permissionCode;
        this.roleName = roleName;
    }

    public Account() {

    }

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreated() {
		this.created = new Date(0);
		return created;
	}

	public void setCreated() {
		this.created = new Date(0);
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public void setCreated1() {
		this.created = new Date(0);
	}
	public void setCreated(Date created) {
		this.created = created;
	}
}
