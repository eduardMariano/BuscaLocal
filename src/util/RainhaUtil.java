package util;

import java.util.ArrayList;
import java.util.Random;

import problema.ModeloRainha;

public class RainhaUtil {
	
	public static ArrayList<Integer> setBoard(int n){
		ArrayList<Integer> tabuleiro = new ArrayList<Integer>();
		Random r = new Random();
		for(int i = 0; i<n;i++){
			tabuleiro.add(r.nextInt(n));
		}
		return tabuleiro;		
	}
	
	public static Integer getCost(ArrayList<Integer> tab){
		Integer custo = 0;															//custo da heuristica
		for(int i =0; i <tab.size(); i++){											//fixa em uma coluna
			for(int j = i+1; j<tab.size();j++){										//laço de comparação
				if(tab.get(i)==tab.get(j)){											//linhas
					custo+=1;
				}
				int aux = j - i;
				if(tab.get(i)==tab.get(j) - aux || tab.get(i)==tab.get(j) + aux){									
					custo+=1;
				}
			}
		}
		return custo;
	}
	
	public static ModeloRainha vizinho(ModeloRainha modelo){						//retorna um modelo com apenas uma coluna mudada
		Random r = new Random();
		
		ModeloRainha copia = new ModeloRainha(modelo.getTab(), modelo.getTabH());
		
		int col = r.nextInt(modelo.getTab().size()-1);
		int ant = modelo.getTab().get(col);
		if(ant == 0){
			copia.getTab().set(col, 7);
		}
		else{
			copia.getTab().set(col, ant-1);
		}
		copia.setTabH(getCost(copia.getTab()));
	
		return copia;
	}
}
