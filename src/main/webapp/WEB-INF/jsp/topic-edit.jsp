<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <body>

<form:form method = "POST" action = "/webui/topics/edit" modelAttribute = "editTopic">
         <table>
            <tr>
               <td><form:label path = "topicName">Topic Name</form:label></td>
               <td><form:input path = "topicName" value = "${topicBean.topicName}"/></td>
               <td><form:hidden path = "categoryBean.categoryId" value = "${topicBean.categoryBean.categoryId}" /></td>
               <tr>
                             <td></td>
                             <td><form:hidden path = "topicId" value = "${topicBean.topicId}" /></td>
                           </tr>
            </tr>
            <tr>
                           <td></td>
                           <td><input type="submit" value="EDIT" /></td>
                        </tr>
             </table>
</form:form>
   </body>
</html>