package main;

import buscas.SimulatedAnnealing;
import problema.ModeloRainha;

public class Main {

	public static void main(String[] args) {
		long initialTime = System.currentTimeMillis();
		ModeloRainha r = new ModeloRainha(8);
		System.out.println("Inicial: " + r);
		System.out.println("SA: "+ SimulatedAnnealing.SA(r));

		long endTime = System.currentTimeMillis();
		System.out.println("Tempo total em milessegundos: " + (endTime - initialTime));
	}

}
