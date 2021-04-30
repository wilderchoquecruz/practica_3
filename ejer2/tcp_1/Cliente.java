package tcp_1;

import java.io.*;
import java.net.*;
import java.util.*;

public class Cliente {
	public static void main(String args[]) {
		// Scanner read = new Scanner(System.in);
		String host = "localhost";
		try {
			Socket cliente = new Socket(host, 9876);
			DataInputStream in = null;//
			DataOutputStream out = null;
			in = new DataInputStream(cliente.getInputStream());
			out = new DataOutputStream(cliente.getOutputStream());
			System.out.println("1)TAYO 2)HEREDIA 3)Albaracion 4)MOSTRAR");
			// Envio un mensaje al cliente
			Scanner read = new Scanner(System.in);
			String msj = read.next();
			out.writeUTF(msj);

			// Recibo el mensaje del servidor
			String mensaje = in.readUTF();
			// mostramos el mesaje
			System.out.println(mensaje);
			// cerramosel cliente
			cliente.close();
		} catch (Exception e) {
			System.err.println("Error: " + e);
		}
	}
}