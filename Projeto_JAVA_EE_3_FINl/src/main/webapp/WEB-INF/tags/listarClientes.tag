<%@tag body-content="empty" %>
<jsp:useBean  id="Clientes" class="org.hopto.depositodivisa.dao.clientesDao" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

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
   