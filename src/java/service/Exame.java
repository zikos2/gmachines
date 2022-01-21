package service;

import java.util.ArrayList;
import java.util.Iterator;

public class Exame {

	public static void main(String[] args) {
		Double sum = 0.0;
		ArrayList<Integer> liste = new ArrayList<>();
		Thread tache = new Thread(new ThreadRempli(liste));
		tache.start();
		
		try {
			tache.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Iterator<Integer> it = liste.iterator();
		
		while(it.hasNext()) {
			sum = sum+it.next();
		}
		System.out.println("La somme est "+sum);
	}
	static class ThreadRempli implements Runnable{
		private ArrayList<Integer> list2 = new ArrayList<>();
		public ThreadRempli(ArrayList<Integer> l) {
			list2 = l;
		}
		public void run() {
			for(int i = 0; i < 200; ++i) {
				list2.add(i);
			}
		}
		
	}

}
