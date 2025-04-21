<%-- 
    Document   : INDEX
    Created on : 20 de abr. de 2025, 01:08:38
    Author     : Luiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean  id="Clientes" class="org.hopto.depositodivisa.dao.clientesDao" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de clientes - JSP Page</title>
    </head>
    <body>
        <h1>Lista de clientes!</h1>
        <table border="1">
            <tr>
                <td>
                 Codigo
                </td>
                        
                <td>
                   Nome 
                </td>
            </tr>
            <c:set var="contador" value="1"/>
            <c:forEach items="${Clientes.listaClientes}" var="cliente">
               <c:choose>
                    <c:when test="${contador%2==0}">
                        <tr style="background-color: red">
                    </c:when>
                            
                    <c:otherwise>
                        <tr style="background-color: green">
                    </c:otherwise>
                </c:choose>
                
                <td>    
                 ${cliente.codigo}   
                </td>
                <td>
                 ${cliente.nome}   
                </td>
                </tr>
                <c:set var="contador" value="${contador+1}"/>
               
            </c:forEach>
        </table>
    </body>
</html>
