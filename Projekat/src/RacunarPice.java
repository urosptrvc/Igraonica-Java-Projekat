
public class RacunarPice implements zaUplatu{
	private int rednibr;
	private int vreme;
	private String pice;
	
	public int getRednibr() {
		return rednibr;
	}
	public void setRednibr(int rednibr) {
		this.rednibr = rednibr;
	}
	public String getPice() {
		return pice;
	}
	public void setPice(String pice) {
		this.pice = pice;
	}
	public int getVreme() {
		return vreme;
	}
	public void setVreme(int vreme) {
		this.vreme = vreme;
	}
	
	
	public RacunarPice(int rednibr, int vreme, String pice) {
		super();
		this.rednibr = rednibr;
		this.vreme = vreme;
		this.pice = pice;
	}
	@Override
	public int uplata(int vreme, String pice) {
		int sum=0;
		int p=0;
		if(pice=="Ultra")
			p=120;
		if(pice=="RedBull")
			p=200;
		if(pice=="CocaCola")
			p=100;
		sum=vreme*120+p;
		return sum;
	}
	
	
	
}
