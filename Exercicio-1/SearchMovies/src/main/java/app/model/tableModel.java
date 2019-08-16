package app.model;

import java.util.ArrayList;

public class tableModel {
	
	private ArrayList<table> data;
	
	public tableModel() {
		data = new ArrayList<table>();
	}
	
	public void addTableRow(table row) {
		data.add(row);
	}
	
	public table getTableRow(int position) {
		return data.get(position);
	}
	
	public int numTableRows() {
		return data.size();
	}
	
	public String test() {
		return "Teste OK";
	}
}
