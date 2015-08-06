package pakiet.Interface;

public class GetArtistsID {
	private int ArtistId;
	
	public GetArtistsID (int id){
		this.ArtistId = id;
		
	}
	public int getId(){
		return this.ArtistId;
	}
	public void setId(int id){
		this.ArtistId = id;
	}
}