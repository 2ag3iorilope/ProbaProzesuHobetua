//aurreko bertsioarekin diferentziak detektatu eta probatu

package ProbaProzesuHobetua;

import java.io.*;

public class Procesos {

	public static void main(String[] args) {
		boolean error = false;
		int retorno;
		ProcessBuilder pb;
		Process process;

		if (args.length == 0) {
			System.err.println("Exekutatzeko programa bat behar da");

		} else {
			System.out.println("Aita-prozesuan nago");
			System.out.println("Prozesu-ume bat abiaraziko dut.");
			pb = new ProcessBuilder(args);
			try {

				process = pb.start(); //prozesu berri bat hasten du (ume prozesua)

				retorno = process.waitFor(); //aita prozesua zain dago azpiprozesua (ume-prozesua) amaitu arte

				//retorno aldagaian azpiprozesuaren irteera-balioa jasotzen da

				System.out.println(args [0] +" ume-prozesuaren exekuzioak itzuli egiten du "+ retorno);
			} catch (IOException ex) {
				System.err.println("S/I salbuespena!!");
				error = true;
			} catch (InterruptedException ex) {
				System.err.println("Ume-prozesuak oker amaitu zuen");
				error = true;
			}
			if (error == false) {
				System.out.println("Aita-prozesua amaitu da");
				System.out.println("Ume-prozesuak behar bezala amaitu duelako");
			}
		}
	}
}

//Berriro ere java Procesos.java notepad.exe erabili dugu eta programak ondo funtzionatzen duea konrpobatzen dugu