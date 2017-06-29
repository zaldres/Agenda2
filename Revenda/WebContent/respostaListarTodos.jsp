<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Carro" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="dao.ListarTodosDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resposta Consultar Todos</title>
</head>
<body>
<h1>Dados do Modelo</h1>
<%
ArrayList<Carro> listarTodos = (ArrayList<Carro>)request.getAttribute("carro");

for (Carro c : listarTodos) {
	out.println("Modelo: " + c.getModelo() + "<br>");
	out.println("Ano de Fabricacao: " + c.getAnofab() + "<br>");
	out.println("Marca: " + c.getMarca() + "<br>" + "<br>");
		
}
%>

</body>
</html>