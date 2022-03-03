package controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController() {
		super();
	}

	private String os() {
		String os = System.getProperty("os.name");
		System.out.println(os);
		return os;
	}
	
	public void ip(String process) {
		String sistema = os();
		
		if (sistema.contains("Windows")) {
			process = "ipconfig";

		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) {
				if(linha.contains("Adaptador")) {
					if(!linha.contains("Ethernet Ethernet")) {
						if(!linha.contains("*")) {
							System.out.println(linha);
						}
					}
				}
				if(linha.contains("IPv4")) {
					System.out.println(linha);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch (IOException e) {
			String msgErro = e.getMessage();
			System.err.println(msgErro);
		}
		}
		else {
			process = "ifconfig";
			
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while(linha != null) {
					if(linha.contains("mtu")) {
						System.out.println(linha);
					}
					if(linha.contains("inet ")) {
						System.out.println(linha);
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch (IOException e) {
				String msgErro = e.getMessage();
				System.err.println(msgErro);
			}
		}
		
	}
	
	public void ping(String process) {
		String sistema = os();
		
		if (sistema.contains("Windows")) {
			process = "ping -4 -n 10 www.google.com.br";
		
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) {
				String[] vetLinha = linha.split(",");
				int tamanho = vetLinha.length;
				String media = vetLinha[tamanho - 1];
				if(media.contains("dia =")) {
					System.out.println(media);
				}
				linha = buffer.readLine();
				}
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch (IOException e) {
			String msgErro = e.getMessage();
			System.err.println(msgErro);
		}
	}
	else {
		process = "ping -4 -c 10 www.google.com.br";
		
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) {
				if(linha.contains("avg")) {
					System.out.println(linha);
				}
				linha = buffer.readLine();
				}
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch (IOException e) {
			String msgErro = e.getMessage();
			System.err.println(msgErro);
		}
	}
  }

}
