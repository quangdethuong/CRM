$(document).ready(function() {
    $(".btn-delete-job").click(function () {
        var id = $(this).attr("jobid");

        // Lưu trữ tham chiếu của nút Xóa
        var deleteButton = $(this);

        // Hiển thị overlay và popup
        $("#overlay").fadeIn();
        $("#deleteConfirmation").fadeIn();

        // Xử lý nút Xác nhận trong popup
        $(".btn-confirm-delete").click(function() {
            $.ajax({
                method: "GET",
                url: "http://localhost:8080/demoservlet/job/delete?id=" + id,
                //data: { name: "John", location: "Boston" }
            })
                .done(function (result) {
                    // Loại bỏ hàng chứa nút Xóa
                    deleteButton.closest("tr").remove();
                    console.log("Kết quả", result);
                });

            // Đóng overlay và popup
            $("#overlay").fadeOut();
            $("#deleteConfirmation").fadeOut();
        });

        // Xử lý nút Hủy trong popup
        $(".btn-cancel-delete").click(function() {
            // Đóng overlay và popup
            $("#overlay").fadeOut();
            $("#deleteConfirmation").fadeOut();
        });
    });
});
