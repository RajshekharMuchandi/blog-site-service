<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <body>

<form:form method = "POST" action = "/webui/categories/addCategory" modelAttribute = "addCategory">
         <table>
            <tr>
               <td><form:label path = "categoryName">Category Name</form:label></td>
               <td><form:input path = "categoryName" /></td>
            </tr>
            <tr>
                           <td></td>
                           <td><input type="submit" value="Submit" /></td>
                        </tr>
             </table>
</form:form>
   </body>
</html>