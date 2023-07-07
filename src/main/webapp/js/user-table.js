$(document).ready(function (){
    $('.btn-delete-user').click(function (){
        const This = $(this) // save button to reuse "this" button
        const id = This.attr("userId")
        $.ajax({
            method: "GET",
            url: "http://localhost:8080/demoservlet/user/delete?id=" + id,
            // data: { name: "John", location: "Boston" }
        })
            .done(function( msg ) {
                This.closest("tr").remove();
                console.log("Result", msg)
            });
    });
});

