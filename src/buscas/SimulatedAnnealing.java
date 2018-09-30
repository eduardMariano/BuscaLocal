package buscas;

import java.util.Random;
import java.util.ArrayList;

import problema.ModeloRainha;
import util.RainhaUtil;

public class SimulatedAnnealing {
	

	public static ModeloRainha SA(ModeloRainha m){
		Random r = new Random();
		double temperaturaInicial = 100;
		double temperaturaAtual = temperaturaInicial;
		double fatorResfriamento = 0.99;
		double delta;
		int maxIteracoes = 1000;
		int maxSucessos = 50;
		int maxPerturbacoes = 100;
		int iteracoesInternas, iteracoesExternas = 1; 
		int sucessos = 1; 
		ModeloRainha inicial = new ModeloRainha(m.getTab(),m.getTabH());
		ModeloRainha atual = new ModeloRainha();
		ArrayList<ModeloRainha> solucao = new ArrayList<ModeloRainha>();
		ModeloRainha resposta = new ModeloRainha();
		while(sucessos != 0 && iteracoesExternas <= maxIteracoes){
			iteracoesInternas = 1;
			sucessos = 0;
			while(sucessos <= maxSucessos && iteracoesInternas <= maxIteracoes){
				atual = new ModeloRainha(m.getTab().size());
				delta = RainhaUtil.vizinho(atual).getTabH()  - atual.getTabH();					//calculo da variação de custos
				if(delta <= 0 || Math.exp((-delta)/temperaturaInicial) > r.nextDouble()){
					solucao.add(atual);
					sucessos+=1;					
				}
				iteracoesInternas +=1;
			}
			temperaturaAtual *= fatorResfriamento;
			iteracoesExternas+=1;
		}
		resposta.setTab(solucao.get(0).getTab());
		resposta.setTabH(solucao.get(0).getTabH());
		for(int i = 1; i < solucao.size(); i++){
			if(solucao.get(i).getTabH()<=resposta.getTabH()){
			resposta.setTab(solucao.get(i).getTab());
			resposta.setTabH(solucao.get(i).getTabH());
			}
		}
		return resposta;
	}

}
