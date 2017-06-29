<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Carro" %>
     <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resposta Consultar Marca</title>
</head>
<body>
<h1>Dados do modelo da Marca</h1>

<%
//Aqui Começa Codigo Java

//Recuperar atributos do request
Carro c = (Carro) request.getAttribute("carro");

//Exibindo dados do carro - forma 1
out.println("Modelo: " + c.getModelo() + "<br>");
out.println("Ano de Fabricacao: " + c.getAnofab() + "<br>");
out.println("Marca: " + c.getMarca() + "<br>" + "<br>");
%>

Ano de fabricação: <%= c.getAnofab() %><br>
Marca: <%= c.getMarca() %>
</body>
</html>