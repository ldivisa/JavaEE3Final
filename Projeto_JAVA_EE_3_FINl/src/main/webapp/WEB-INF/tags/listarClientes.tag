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
            
            <c:forEach items="${Clientes.listaClientes}" var="cliente">
                <tr>
                <td>
                 ${cliente.codigo}   
                </td>
                <td>
                 ${cliente.nome}   
                </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
