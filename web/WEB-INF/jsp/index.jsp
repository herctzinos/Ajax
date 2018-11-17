<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script>
//            $(document).ready(function () {
//                $("#ajaxtext").keyup(function () {
//                    var text = $(this).val();
//                    $.ajax({}
//                        url: 'findname.htm?userinput=' + text,
//                        contentType: 'application/json',
//                        success: function (result) {
//                            $("ajaxoutput").empty();
//                            var jsonobj = $.parseJSON(result);
//                            $.each(jsonobj, function (i, item) {
//
//                                $tr = $('<tr>').append(
//                                        $('<td>').text(item.title)
//                                        );
//                                $("ajaxoutput").append($tr);
//                            });
//                        }
//                    });
//                });
//            });

$(document).ready(function () { // Οταν φορτώσει η σελίδα τρέξε....
                $("#ajaxtext").keyup(function () { // Βάλε handler στο input type
                    var text = $(this).val(); // Το κείμενο το χρήστη
                    // alert(text);
                    $.ajax({
                        url: 'findname.htm?userinput=' + text,
                        contentType: 'aplication/json',
                        success: function (result) {
                            $("#ajaxoutput").empty();
                            var jsonobj = $.parseJSON(result);

                            $.each(jsonobj, function (i, item) {
                                $tr = $('<tr>').append(
                                        $('<td>').text(item.title),
                                        );
                                $("#ajaxoutput").append($tr);
                            });
                        }
                     });
                });
            });
        </script>
    </head>

    <body>
        <p>Hello! This is the default welcome page for a Spring Web MVC project.</p>
        <form action="test/findname.htm" method="GET">
            First name:<br>
            <input type="text" name="name" value="">
            <br>
            <input type="submit" value="Submit">
        </form> 
        <input type="text" name="userinput" id="ajaxtext">


        <table>
            <c:forEach items="${list}" var="current">
                <tr>
                    <td>${current.title}<td>
                </tr>
            </c:forEach>

        </table>

        <div id="ajaxoutput"></div>
    </body>
</html>
