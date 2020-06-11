<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <body>

<form:form method = "POST" action = "/webui/topics/addTopic" modelAttribute = "addTopic">
         <table>
            <tr>
               <td><form:label path = "topicName">Topic Name</form:label></td>
               <td><form:input path = "topicName" /></td>
               <tr>
                              <td><form:label path = "categoryBean.categoryId">Category</form:label></td>
                              <td>
                                 <form:select path = "categoryBean.categoryId">
                                    <form:option value = "NONE" label = "Select"/>
                                    <form:options items = "${categories}" />
                                 </form:select>
                              </td>
            </tr>
            <tr>
                           <td></td>
                           <td><input type="submit" value="Submit" /></td>
                        </tr>
             </table>
</form:form>
   </body>
</html>