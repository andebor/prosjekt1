$("#email_input").keyup(function(e) {
    var email_input = $(this).val();
    $.post('check_email.php', {'email_input':email_input}, function(data) {
        $("#user-result").html(data);
        if(data == '<p class="bg-success">Det finnes reservasjoner på denne eposten.</p>') {
            $("#submit").attr("disabled", false);
        }else{
            $("#submit").attr("disabled", true);
        }
    });
});