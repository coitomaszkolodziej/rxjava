package pakiet;

public class Permission {
	private int permissionId;
	
	public Permission (int id){
		this.permissionId = id;
		
	}
	public int getPermissionId(){
		return this.permissionId;
	}
	public void setPermissionId(int id){
		this.permissionId = id;
	}
}