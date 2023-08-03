$(document).ready(function (){
    $('.btn-delete-role').click(function (){
        const This = $(this) // save button to reuse "this" button
        const id = This.attr("roleId")
        $.ajax({
            method: "GET",
            url: "http://localhost:8080/demoservlet/role/delete?id=" + id,
            // data: { name: "John", location: "Boston" }
        })
            .done(function( msg ) {
                This.closest("tr").remove();
                console.log("Result", msg)
            });
    });
});