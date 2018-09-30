package problema;

import java.util.ArrayList;

import util.RainhaUtil;

public class ModeloRainha {
	private ArrayList<Integer> tab; 										//Tabuleiro
	private int tabH;														//Valor da heur�stica do tabuleiro
	
	public ModeloRainha(int qtdRainhas){
		tab = RainhaUtil.setBoard(qtdRainhas);
		tabH = RainhaUtil.getCost(tab);
	}
	
	public ModeloRainha(ArrayList<Integer> tab, int tabH){
		this.tab = tab;
		this.tabH = tabH;
	}
	
	public ModeloRainha(){
		
	}
	
	public ArrayList<Integer> getTab() {
		return tab;
	}

	public void setTab(ArrayList<Integer> tab) {
		this.tab = tab;
	}

	public int getTabH() {
		return tabH;
	}

	public void setTabH(int tabH) {
		this.tabH = tabH;
	}
	
	public String toString(){
		return "Tabuleiro: " + this.tab + "Custo: " + this.tabH + "\n";
	}
	
}
	

