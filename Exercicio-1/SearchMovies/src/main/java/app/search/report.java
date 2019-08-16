package app.search;

import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class report {
	
	private FileWriter file;
	private PrintWriter writeFile;
	
	public void reportCreate() {
		
		try {
			file = new FileWriter(System.getProperty("user.dir").toString() + "\\target\\reports\\report.html");
			writeFile = new PrintWriter(file);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível criar o relatório", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void reportHead() {	
		
		try {
			
			writeFile.printf("<!DOCTYPE html>");
			writeFile.printf("<html lang=\"pt-br\">");
			writeFile.printf("<head>");
			writeFile.printf("    <meta charset=\"UTF-8\">");
			writeFile.printf("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
			writeFile.printf("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");
			writeFile.printf("    <!-- Bootstrap CSS -->");
			writeFile.printf("    <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">");
			writeFile.printf("    <title>Report - AtomicSolutions</title>");
			writeFile.printf("</head>");
			writeFile.printf("<body>");
			writeFile.printf("    <div class=\"container\">");
			writeFile.printf("        <h1>Resultado da Busca</h1>");
			writeFile.printf("        <br>");
			writeFile.printf("        <table class=\"table\">");
			writeFile.printf("            <thead class=\"thead-dark\">");
			writeFile.printf("                <tr>");
			writeFile.printf("                    <th scope=\"col\">Filme</th>");
			writeFile.printf("                    <th scope=\"col\">Data Lançamento</th>");
			writeFile.printf("                    <th scope=\"col\">Diretor</th>");
			writeFile.printf("                    <th scope=\"col\">Data Nascimento</th>");
			writeFile.printf("                    <th scope=\"col\">Nº Resultados Aproximado</th>");
			writeFile.printf("                </tr>");
			writeFile.printf("            </thead>");
			writeFile.printf("            <tbody>");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível editar o relatório", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	public void reportTable(String movie, String releaseDate, String director, String dateBirth, String numResults, Boolean status) {
		
		try {
			
			if(status) { //Passed
				writeFile.printf("                <tr class=\"table-success\">");
			}
			else //Failed
			{
				writeFile.printf("                <tr class=\"table-danger\">");
			}
			
			writeFile.printf("                    <td>" + movie + "</td>");
			writeFile.printf("                    <td>" + releaseDate + "</td>");
			writeFile.printf("                    <td>" + director + "</td>");
			writeFile.printf("                    <td>" + dateBirth + "</td>");
			writeFile.printf("                    <td>" + numResults.substring(16, numResults.indexOf("re")) + "</td>");
			writeFile.printf("                </tr>");	
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível criar o relatório", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	public void reportFooter() {
		
		try {
			
			writeFile.printf("        </table>");
			writeFile.printf("    </div>");
			writeFile.printf("</body>");
			writeFile.printf("</html>");
			
			writeFile.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível criar o relatório", "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			writeFile.close();
		}

	}

}
