import java.util.*;
import javax.swing.table.AbstractTableModel;

public class JTableIgraonica extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<RacunarPice> lista;
	
	public JTableIgraonica(ArrayList<RacunarPice> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Object getValueAt(int r, int c) {
		RacunarPice a = lista.get(r);
		int bonus=0;
		switch(c) {
		case 0:
			return a.getRednibr();
		case 1:
		{
			if(a.getVreme()==3)
			{
				bonus = a.getVreme()+1;
				return bonus;
			}
			if(a.getVreme()==4)
			{
				bonus = a.getVreme()+2;
				return bonus;
			}
			return a.getVreme();
		}
		case 2:
			return a.getPice();
		case 3:
			return a.uplata(a.getVreme(), a.getPice());
		}
		return null;
	}

	@Override
	public String getColumnName(int c) {
		switch(c) {
		case 0:
			return "Redni Br:";
		case 1:
			return "Vreme:";
		case 2:
			return "Pice:";
		case 3:
			return "Ukupno:";
		}
		return null;
	}
	
	

}
