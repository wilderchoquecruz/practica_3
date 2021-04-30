package tcp_1Java;

import java.io.*;
import static java.lang.Integer.parseInt;
import java.net.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

	public static String op1(int n) throws IOException {

		// A. Serie de Primos (2,3,5,7, ....)
		String cad = " ";
		int c = 1;
		int p = 2;
		int d = 2;
		while (c <= n) {
			if (p % d == 0) {
				if (p == d) {

					// System.out.println(p + ", ");
					cad = cad + String.valueOf(p) + ",";
					c++;
				}
				d = 2;
				p++;
			} else {
				d++;
			}
		}
		return cad;
	}

	public static String op2(int n) {
		// B. Serie de Fibonacci (0,1,1,2,3,5, ....)
		String cad = " ";
		int a = 0, b = 1, c;

		for (int i = 0; i < n; i++) {
			// System.out.print(a + ",");
			cad = cad + String.valueOf(a) + ",";
			c = a + b;
			a = b;
			b = c;
		}
		return cad;

	}

	public static String op3(int n) {
		// C. Serie Fibonacci Primos (2,3,5, ....)
		int a = 2, b = 3, c;
		String cad = " ";

		for (int i = 0; i < n; i++) {
			// System.out.print(a + ",");
			cad = cad + String.valueOf(a) + ",";
			c = a + b;
			a = b;
			b = c;
		}
		return cad;

	}

	public static void main(String args[]) throws IOException {
		DataInputStream in; //
		DataOutputStream out;
		int[] Vector = new int[50];
		// puerto de nuestro servidor
		int PUERTO = 9876;

		try {
			// Creamos el socket del servidor
			ServerSocket servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor iniciado");
			int i = 0;
			while (true) {
				// Espero a que un cliente se conecte
				Socket cliente = servidor.accept();
				System.out.println("Cliente conectado");
				in = new DataInputStream(cliente.getInputStream());// recibimos msj
				out = new DataOutputStream(cliente.getOutputStream());// enviamos msj

				// Leo el mensaje que me envia
				String mensaje = in.readUTF();
				if (mensaje.equals("D")) {
					out.writeUTF("desconectado !!!!! : " + mensaje);
					// Cierro el socket
					cliente.close();
					System.out.println("Cliente desconectado");

				}

				String mensaje2 = in.readUTF();
				// System.out.println(mensaje);
				if (mensaje.equals("A")) {

					out.writeUTF("OPCION : " + mensaje);
					int N = Integer.parseInt(mensaje2);
					mensaje2 = op1(N);
					out.writeUTF("n= : " + N + " Serie de Primos: " + mensaje2);

				}

				if (mensaje.equals("B")) {

					out.writeUTF("OPCION : " + mensaje);
					int N = Integer.parseInt(mensaje2);
					mensaje2 = op2(N);
					out.writeUTF("n= : " + N + " Serie de Fibonacci : " + mensaje2);

				}

				if (mensaje.equals("C")) {

					out.writeUTF("OPCION : " + mensaje);
					int N = Integer.parseInt(mensaje2);
					mensaje2 = op3(N);
					out.writeUTF("n= : " + N + " Serie Fibonacci Primos : " + mensaje2);

				}

				// Le envio un mensaje
				// out.writeUTF("MENSAJE RECIBIDO ");

				// Cierro el socket
				cliente.close();
				System.out.println("Cliente desconectado");
			}
		} catch (IOException ex) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}