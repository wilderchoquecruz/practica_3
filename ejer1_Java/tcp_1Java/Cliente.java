package tcp_1Java;

import java.io.*;
import java.net.*;
import java.util.*;

public class Cliente {
	public static void main(String args[]) {
		// Scanner read = new Scanner(System.in);
		boolean sw = true;
		while (sw) {
			String host = "localhost";
			try {
				Socket cliente = new Socket(host, 9876);
				DataInputStream in = null;//
				DataOutputStream out = null;
				in = new DataInputStream(cliente.getInputStream());
				out = new DataOutputStream(cliente.getOutputStream());
				System.out.println("++++++++++++++ MENU++++++++++");
				System.out.println("INTRODUZCA LA OPCION Y n=, ejemplo A  7");
				System.out.println(
						" A. Serie de Primos (2,3,5,7, ....)\r\n" + " B. Serie de Fibonacci (0,1,1,2,3,5, ....)\r\n"
								+ " C. Serie Fibonacci Primos (2,3,5, ....)\r\n" + " D. Salir\r\n");
				// Envio un mensaje al cliente
				Scanner read = new Scanner(System.in);
				String msj = read.next();

				if (msj.equals("D")) {
					out.writeUTF(msj);
					String mensaje = in.readUTF();
					System.out.println(mensaje);
					cliente.close();
					sw=false;
				}

				out.writeUTF(msj);
				String msj2 = read.next();
				out.writeUTF(msj2);

				// Recibo el mensaje del servidor
				String mensaje = in.readUTF();
				String mensaje2 = in.readUTF();
				// mostramos el mesaje
				System.out.println(mensaje);
				System.out.println(mensaje2);
				// cerramosel cliente
				cliente.close();

			} catch (Exception e) {
				System.err.println("Error: " + e);
			}

		}

	}
}